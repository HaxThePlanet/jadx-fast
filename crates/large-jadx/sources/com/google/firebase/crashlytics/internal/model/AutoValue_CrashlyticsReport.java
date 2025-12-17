package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport {

    private final String buildVersion;
    private final String displayVersion;
    private final String gmpAppId;
    private final String installationUuid;
    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload ndkPayload;
    private final int platform;
    private final String sdkVersion;
    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session session;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder {

        private String buildVersion;
        private String displayVersion;
        private String gmpAppId;
        private String installationUuid;
        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload ndkPayload;
        private Integer platform;
        private String sdkVersion;
        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session session;
        private Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport crashlyticsReport) {
            super();
            this.sdkVersion = crashlyticsReport.getSdkVersion();
            this.gmpAppId = crashlyticsReport.getGmpAppId();
            this.platform = Integer.valueOf(crashlyticsReport.getPlatform());
            this.installationUuid = crashlyticsReport.getInstallationUuid();
            this.buildVersion = crashlyticsReport.getBuildVersion();
            this.displayVersion = crashlyticsReport.getDisplayVersion();
            this.session = crashlyticsReport.getSession();
            this.ndkPayload = crashlyticsReport.getNdkPayload();
        }

        Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport crashlyticsReport, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport.1 autoValue_CrashlyticsReport$12) {
            super(crashlyticsReport);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport build() {
            Object stringBuilder3;
            Object stringBuilder2;
            Object stringBuilder4;
            Object installationUuid;
            Object stringBuilder;
            Object displayVersion;
            String string;
            if (this.sdkVersion == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("");
                stringBuilder3.append(" sdkVersion");
                string = stringBuilder3.toString();
            }
            if (this.gmpAppId == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" gmpAppId");
                string = stringBuilder2.toString();
            }
            if (this.platform == null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string);
                stringBuilder4.append(" platform");
                string = stringBuilder4.toString();
            }
            if (this.installationUuid == null) {
                installationUuid = new StringBuilder();
                installationUuid.append(string);
                installationUuid.append(" installationUuid");
                string = installationUuid.toString();
            }
            if (this.buildVersion == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" buildVersion");
                string = stringBuilder.toString();
            }
            if (this.displayVersion == null) {
                displayVersion = new StringBuilder();
                displayVersion.append(string);
                displayVersion.append(" displayVersion");
                string = displayVersion.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.sdkVersion, this.gmpAppId, this.platform.intValue(), this.installationUuid, this.buildVersion, this.displayVersion, this.session, this.ndkPayload, 0);
                return autoValue_CrashlyticsReport;
            }
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("Missing required properties:");
            stringBuilder5.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder5.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setBuildVersion(String string) {
            Objects.requireNonNull(string, "Null buildVersion");
            this.buildVersion = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setDisplayVersion(String string) {
            Objects.requireNonNull(string, "Null displayVersion");
            this.displayVersion = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setGmpAppId(String string) {
            Objects.requireNonNull(string, "Null gmpAppId");
            this.gmpAppId = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setInstallationUuid(String string) {
            Objects.requireNonNull(string, "Null installationUuid");
            this.installationUuid = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setNdkPayload(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload crashlyticsReport$FilesPayload) {
            this.ndkPayload = filesPayload;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setPlatform(int i) {
            this.platform = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setSdkVersion(String string) {
            Objects.requireNonNull(string, "Null sdkVersion");
            this.sdkVersion = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setSession(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session crashlyticsReport$Session) {
            this.session = session;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport(String string, String string2, int i3, String string4, String string5, String string6, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session crashlyticsReport$Session7, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload crashlyticsReport$FilesPayload8) {
        super();
        this.sdkVersion = string;
        this.gmpAppId = string2;
        this.platform = i3;
        this.installationUuid = string4;
        this.buildVersion = string5;
        this.displayVersion = string6;
        this.session = session7;
        this.ndkPayload = filesPayload8;
    }

    AutoValue_CrashlyticsReport(String string, String string2, int i3, String string4, String string5, String string6, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session crashlyticsReport$Session7, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload crashlyticsReport$FilesPayload8, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport.1 autoValue_CrashlyticsReport$19) {
        super(string, string2, i3, string4, string5, string6, session7, filesPayload8);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public boolean equals(Object object) {
        int i;
        boolean ndkPayload;
        Object installationUuid;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport) {
            if (this.sdkVersion.equals((CrashlyticsReport)object.getSdkVersion()) && this.gmpAppId.equals(object.getGmpAppId()) && this.platform == object.getPlatform() && this.installationUuid.equals(object.getInstallationUuid()) && this.buildVersion.equals(object.getBuildVersion()) && this.displayVersion.equals(object.getDisplayVersion())) {
                if (this.gmpAppId.equals(object.getGmpAppId())) {
                    if (this.platform == object.getPlatform()) {
                        if (this.installationUuid.equals(object.getInstallationUuid())) {
                            if (this.buildVersion.equals(object.getBuildVersion())) {
                                if (this.displayVersion.equals(object.getDisplayVersion())) {
                                    com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session session = this.session;
                                    if (session == null) {
                                        if (object.getSession() == null) {
                                            ndkPayload = this.ndkPayload;
                                            if (ndkPayload == null) {
                                                if (object.getNdkPayload() == null) {
                                                } else {
                                                    i = i2;
                                                }
                                            } else {
                                                if (ndkPayload.equals(object.getNdkPayload())) {
                                                } else {
                                                }
                                            }
                                        } else {
                                        }
                                    } else {
                                        if (session.equals(object.getSession())) {
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String getBuildVersion() {
        return this.buildVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String getDisplayVersion() {
        return this.displayVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String getGmpAppId() {
        return this.gmpAppId;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String getInstallationUuid() {
        return this.installationUuid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload getNdkPayload() {
        return this.ndkPayload;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public int getPlatform() {
        return this.platform;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String getSdkVersion() {
        return this.sdkVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session getSession() {
        return this.session;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public int hashCode() {
        int i;
        int i2;
        int i19 = 1000003;
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session session = this.session;
        if (session == null) {
            i = i2;
        } else {
            i = session.hashCode();
        }
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload ndkPayload = this.ndkPayload;
        if (ndkPayload == null) {
        } else {
            i2 = ndkPayload.hashCode();
        }
        return i17 ^= i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    protected com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder toBuilder() {
        AutoValue_CrashlyticsReport.Builder builder = new AutoValue_CrashlyticsReport.Builder(this, 0);
        return builder;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CrashlyticsReport{sdkVersion=");
        stringBuilder.append(this.sdkVersion);
        stringBuilder.append(", gmpAppId=");
        stringBuilder.append(this.gmpAppId);
        stringBuilder.append(", platform=");
        stringBuilder.append(this.platform);
        stringBuilder.append(", installationUuid=");
        stringBuilder.append(this.installationUuid);
        stringBuilder.append(", buildVersion=");
        stringBuilder.append(this.buildVersion);
        stringBuilder.append(", displayVersion=");
        stringBuilder.append(this.displayVersion);
        stringBuilder.append(", session=");
        stringBuilder.append(this.session);
        stringBuilder.append(", ndkPayload=");
        stringBuilder.append(this.ndkPayload);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
