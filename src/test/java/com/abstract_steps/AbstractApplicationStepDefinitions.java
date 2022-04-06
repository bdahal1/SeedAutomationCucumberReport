package com.abstract_steps;


import com.configuration.PlatformHelper;
import com.module.interfaces.mobile.Mobile_Platform;

public class AbstractApplicationStepDefinitions extends AbstractStepDefinitions {

    protected Mobile_Platform platform;


    public AbstractApplicationStepDefinitions() {
        platform = PlatformHelper.getCurrentPlatform();
    }
}
