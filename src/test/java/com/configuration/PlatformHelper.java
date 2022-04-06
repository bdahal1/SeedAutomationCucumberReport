package com.configuration;

import com.helper.ConfigurationHelper;
import com.module.AndroidPlatform;
import com.module.IOSPlatform;
import com.module.interfaces.ClientPlatform;

import java.util.HashMap;

public class PlatformHelper {

    private static HashMap<Platform, ClientPlatform> platforms = new HashMap<>();

    public static <T extends ClientPlatform> T getPlatformInstance(Platform type) {
        if (!platforms.containsKey(type)) {
            ClientPlatform platform;
            switch (type) {
            case ANDROID:
                platform = new AndroidPlatform();
                break;
            case IOS:
                platform = new IOSPlatform();
                break;
            default:
                throw new RuntimeException("Invalid platform");
            }

            platforms.put(type, platform);
        }

        return (T) platforms.get(type);
    }

    public static <T extends ClientPlatform> T getCurrentPlatform() {
        return PlatformHelper.getPlatformInstance(ConfigurationHelper.getPlatform());
    }

    public static <T extends ClientPlatform> T setPlatform(Platform type) {
        return PlatformHelper.getPlatformInstance(type);
    }
}
