package com.configuration.run;

import com.configuration.PlatformRunConfig;

public class AndroidRunConfig  extends PlatformRunConfig {

    public AndroidRunConfig(RunConfig config) {
        super(config);
    }

    public String getApp() { return config.getPlatformValue("app"); }

    public String getDevice() {
        return config.getPlatformValue("device");
    }

    public String getPlatformVersion() {
        return config.getPlatformValue("platformVersion");
    }

    public String getAppActivity() {
        return config.getPlatformValue("appActivity");
    }

    public String getAutomationName() { return config.getPlatformValue("automationName"); }

    public String getUrl(){ return config.getPlatformValue("url");}

}
