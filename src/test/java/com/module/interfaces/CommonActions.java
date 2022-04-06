package com.module.interfaces;


import java.io.File;

public interface CommonActions {

    void launch() throws Exception;

    void logOut();

    File takeScreenshot() throws Exception;

    void navigateToLogin();

    void quitDriver();
}
