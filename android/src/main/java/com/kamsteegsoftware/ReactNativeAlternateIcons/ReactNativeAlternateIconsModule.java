package com.kamsteegsoftware.ReactNativeAlternateIcons;

import android.content.ComponentName;
import android.content.pm.PackageManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class ReactNativeAlternateIconsModule extends ReactContextBaseJavaModule  {


    public ReactNativeAlternateIconsModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "ReactNativeAlternateIcons";
    }

    @ReactMethod
    public void setIconName(String name) {
        String packageName = getReactApplicationContext().getPackageName();
        PackageManager manager = getReactApplicationContext().getPackageManager();

        manager.setComponentEnabledSetting(
                getCurrentActivity().getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);

        manager.setComponentEnabledSetting(
                new ComponentName(packageName , packageName + "." + name),
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);

    }

    @ReactMethod
    public void reset() {
      
    }

    @ReactMethod
    public void getIconName() {

    }

    @ReactMethod
    public void supportDevice() {

    }
}