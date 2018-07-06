package com.slamtheham.ultracore.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.slamtheham.ultracore.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.Charset;

public class Updater {

    private Main plugin;

    private String nowVersion;
    private String latestVersion;

    private String downloadURL;

    private Gson gson = new Gson();

    public Updater(Main plugin) {
        this.plugin = plugin;
        this.nowVersion = plugin.getDescription().getVersion();
    }

    public void check() {
        try {
            //Latest version number
            String latestVersionInfo = readFrom("https://api.github.com/repos/SlamTheHam/UltraCore/releases/latest");

            Type type = new TypeToken<JsonObject>() {}.getType();
            JsonObject object = gson.fromJson(latestVersionInfo, type);

            latestVersion = object.get("tag_name").getAsString();
            downloadURL = object.get("html_url").getAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean available() {
        return !nowVersion.equals(latestVersion);
    }

    private String readFrom(String url) throws IOException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }

            return sb.toString();
        }
    }

    public Main getPlugin() {
        return plugin;
    }

    public String getNowVersion() {
        return nowVersion;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public String getDownloadURL() {
        return downloadURL;
    }
}
