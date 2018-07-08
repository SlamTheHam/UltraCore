package com.slamtheham.ultracore.config;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;

public class Config {

    private File configFile;
    private String filename;
    private JavaPlugin plugin;
    private boolean shouldCopy;
    private FileConfiguration fileConfiguration;

    public Config(JavaPlugin plugin, String filename, Boolean shouldCopy){
        this.filename = filename;
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), this.filename);
        this.shouldCopy = shouldCopy;
        if (shouldCopy){
            this.firstRun(plugin);
        }
        this.fileConfiguration = (FileConfiguration) YamlConfiguration.loadConfiguration(this.configFile);
    }

    public FileConfiguration getConfig() {
        return this.fileConfiguration;
    }

    public void save() {
        try {
            this.fileConfiguration.save(this.configFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            this.fileConfiguration.load(this.configFile);
        }
        catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e3) {
            this.configFile = new File(this.plugin.getDataFolder(), this.filename);
            if (this.shouldCopy) {
                this.firstRun(this.plugin);
            }
            this.fileConfiguration = (FileConfiguration)YamlConfiguration.loadConfiguration(this.configFile);
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void firstRun(JavaPlugin plugin) {
        if (!this.configFile.exists()) {
            this.configFile.getParentFile().mkdirs();
            this.copy(plugin.getResource(this.filename), this.configFile);
        }
    }

    private void copy(InputStream in, File file) {
        try {
            OutputStream out = new FileOutputStream(file);
            byte[] buf = new byte[63];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            out.close();
            in.close();
        }
        catch (Exception ex) {}
    }

    public ConfigurationSection getConfigurationSection(String path) {
        return this.getConfig().getConfigurationSection(path);
    }

    public File getConfigFile() {
        return configFile;
    }

    public String getFilename() {
        return filename;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public boolean isShouldCopy() {
        return shouldCopy;
    }

    public FileConfiguration getFileConfiguration() {
        return fileConfiguration;
    }
}
