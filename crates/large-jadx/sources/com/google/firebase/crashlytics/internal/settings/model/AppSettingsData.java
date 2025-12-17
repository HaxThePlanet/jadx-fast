package com.google.firebase.crashlytics.internal.settings.model;

/* loaded from: classes2.dex */
public class AppSettingsData {

    public static final String STATUS_ACTIVATED = "activated";
    public static final String STATUS_CONFIGURED = "configured";
    public static final String STATUS_NEW = "new";
    public final String bundleId;
    public final int nativeReportUploadVariant;
    public final String ndkReportsUrl;
    public final String organizationId;
    public final int reportUploadVariant;
    public final String reportsUrl;
    public final String status;
    public final boolean updateRequired;
    public final String url;
    public AppSettingsData(String string, String string2, String string3, String string4, String string5, String string6, boolean z7, int i8, int i9) {
        super();
        this.status = string;
        this.url = string2;
        this.reportsUrl = string3;
        this.ndkReportsUrl = string4;
        this.bundleId = string5;
        this.organizationId = string6;
        this.updateRequired = z7;
        this.reportUploadVariant = i8;
        this.nativeReportUploadVariant = i9;
    }

    public AppSettingsData(String string, String string2, String string3, String string4, boolean z5) {
        super(string, string2, string3, string4, 0, 0, z5, 0, 0);
    }
}
