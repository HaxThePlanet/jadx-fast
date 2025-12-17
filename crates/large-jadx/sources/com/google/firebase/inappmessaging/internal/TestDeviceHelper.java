package com.google.firebase.inappmessaging.internal;

import f.c.f.a.a.a.c;
import f.c.f.a.a.a.e.e;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class TestDeviceHelper {

    static final String FRESH_INSTALL_PREFERENCES = "fresh_install";
    static final int MAX_FETCH_COUNT = 5;
    static final String TEST_DEVICE_PREFERENCES = "test_device";
    private int fetchCount = 0;
    private boolean isFreshInstall;
    private boolean isTestDevice;
    private final com.google.firebase.inappmessaging.internal.SharedPreferencesUtils sharedPreferencesUtils;
    public TestDeviceHelper(com.google.firebase.inappmessaging.internal.SharedPreferencesUtils sharedPreferencesUtils) {
        super();
        final int i = 0;
        this.sharedPreferencesUtils = sharedPreferencesUtils;
        this.isFreshInstall = readFreshInstallStatusFromPreferences();
        this.isTestDevice = readTestDeviceStatusFromPreferences();
    }

    private boolean readFreshInstallStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference("fresh_install", true);
    }

    private boolean readTestDeviceStatusFromPreferences() {
        return this.sharedPreferencesUtils.getAndSetBooleanPreference("test_device", false);
    }

    private void setFreshInstallStatus(boolean z) {
        this.isFreshInstall = z;
        this.sharedPreferencesUtils.setBooleanPreference("fresh_install", z);
    }

    private void setTestDeviceStatus(boolean z) {
        this.isTestDevice = z;
        this.sharedPreferencesUtils.setBooleanPreference("test_device", z);
    }

    private void updateFreshInstallStatus() {
        boolean isFreshInstall;
        int i;
        fetchCount++;
        this.fetchCount = isFreshInstall;
        if (this.isFreshInstall && isFreshInstall >= 5) {
            fetchCount++;
            this.fetchCount = isFreshInstall;
            if (isFreshInstall >= 5) {
                setFreshInstallStatus(false);
            }
        }
    }

    public boolean isAppInstallFresh() {
        return this.isFreshInstall;
    }

    public boolean isDeviceInTestMode() {
        return this.isTestDevice;
    }

    public void processCampaignFetch(e e) {
        boolean isTestDevice;
        Object obj2;
        if (!this.isTestDevice) {
            updateFreshInstallStatus();
            obj2 = e.f().iterator();
            while (obj2.hasNext()) {
                if ((c)obj2.next().e()) {
                    break;
                } else {
                }
            }
        }
    }
}
