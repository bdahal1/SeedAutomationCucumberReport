package com.abstract_steps;

import com.helper.DataHelper;

import java.util.*;

public abstract class AbstractStepDefinitions {

    private HashMap<String, String> data;

    private HashMap<String, String> globalData;

    public AbstractStepDefinitions() {
        globalData = DataHelper.getGlobalData();
    }

    protected String getOrSaveGlobalString(String key) {
        return getOrSaveGlobalString(key, "");
    }

    protected String getOrSaveGlobalString(String key, String newValue) {
        if (!globalData.containsKey(key) && !newValue.equals("")) {
            globalData.put(key, newValue);
            return newValue;
        } else if (globalData.containsKey(key) && !newValue.equals("")) {
            globalData.remove(key);
            globalData.put(key, newValue);
            return newValue;
        } else {
            return globalData.get(key);
        }
    }

}
