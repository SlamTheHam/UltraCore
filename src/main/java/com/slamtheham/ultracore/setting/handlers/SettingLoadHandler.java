package com.slamtheham.ultracore.setting.handlers;

import com.slamtheham.ultracore.setting.Setting;
import com.slamtheham.ultracore.setting.SettingsManager;

public interface SettingLoadHandler {

    void run(Setting setting, SettingsManager manager);

}
