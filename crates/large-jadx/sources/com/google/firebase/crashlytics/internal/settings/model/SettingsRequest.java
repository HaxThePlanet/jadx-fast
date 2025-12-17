package com.google.firebase.crashlytics.internal.settings.model;

import com.google.firebase.crashlytics.internal.common.InstallIdProvider;

/* loaded from: classes2.dex */
public class SettingsRequest {

    public final String buildVersion;
    public final String deviceModel;
    public final String displayVersion;
    public final String googleAppId;
    public final InstallIdProvider installIdProvider;
    public final String instanceId;
    public final String osBuildVersion;
    public final String osDisplayVersion;
    public final int source;
    public SettingsRequest(String string, String string2, String string3, String string4, InstallIdProvider installIdProvider5, String string6, String string7, String string8, int i9) {
        super();
        this.googleAppId = string;
        this.deviceModel = string2;
        this.osBuildVersion = string3;
        this.osDisplayVersion = string4;
        this.installIdProvider = installIdProvider5;
        this.instanceId = string6;
        this.displayVersion = string7;
        this.buildVersion = string8;
        this.source = i9;
    }
}
