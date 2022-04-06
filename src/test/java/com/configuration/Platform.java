package com.configuration;

public enum Platform {

    ANDROID("android"),
    IOS("ios"),
    UNKNOWN("unknown");
    String name;

    Platform(String name) {
        this.name = name;
    }

    public static Platform getPlatform(String name) {
        for (Platform platform : Platform.values()) {
            if (platform.name.equals(name)) {
                return platform;
            }
        }
        return Platform.UNKNOWN;
    }

}
