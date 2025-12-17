package com.google.firebase.crashlytics.internal.settings.model;

/* loaded from: classes2.dex */
public class AppRequestData {

    public final String appId;
    public final String buildVersion;
    public final String builtSdkVersion;
    public final String displayVersion;
    public final String googleAppId;
    public final String instanceIdentifier;
    public final String minSdkVersion;
    public final String name;
    public final String organizationId;
    public final int source;
    public AppRequestData(String string, String string2, String string3, String string4, String string5, String string6, String string7, int i8, String string9, String string10) {
        super();
        this.organizationId = string;
        this.googleAppId = string2;
        this.appId = string3;
        this.displayVersion = string4;
        this.buildVersion = string5;
        this.instanceIdentifier = string6;
        this.name = string7;
        this.source = i8;
        this.minSdkVersion = string9;
        this.builtSdkVersion = string10;
    }
}
