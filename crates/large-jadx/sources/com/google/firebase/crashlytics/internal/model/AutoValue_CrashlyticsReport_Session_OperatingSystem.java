package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem {

    private final String buildVersion;
    private final boolean jailbroken;
    private final int platform;
    private final String version;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder {

        private String buildVersion;
        private Boolean jailbroken;
        private Integer platform;
        private String version;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem build() {
            Object stringBuilder4;
            Object stringBuilder2;
            Object stringBuilder;
            Object stringBuilder3;
            String string;
            if (this.platform == null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append("");
                stringBuilder4.append(" platform");
                string = stringBuilder4.toString();
            }
            if (this.version == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" version");
                string = stringBuilder2.toString();
            }
            if (this.buildVersion == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" buildVersion");
                string = stringBuilder.toString();
            }
            if (this.jailbroken == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" jailbroken");
                string = stringBuilder3.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.platform.intValue(), this.version, this.buildVersion, this.jailbroken.booleanValue(), 0);
                return autoValue_CrashlyticsReport_Session_OperatingSystem;
            }
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("Missing required properties:");
            stringBuilder5.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder5.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder setBuildVersion(String string) {
            Objects.requireNonNull(string, "Null buildVersion");
            this.buildVersion = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder setJailbroken(boolean z) {
            this.jailbroken = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder setPlatform(int i) {
            this.platform = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder setVersion(String string) {
            Objects.requireNonNull(string, "Null version");
            this.version = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_OperatingSystem(int i, String string2, String string3, boolean z4) {
        super();
        this.platform = i;
        this.version = string2;
        this.buildVersion = string3;
        this.jailbroken = z4;
    }

    AutoValue_CrashlyticsReport_Session_OperatingSystem(int i, String string2, String string3, boolean z4, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem.1 autoValue_CrashlyticsReport_Session_OperatingSystem$15) {
        super(i, string2, string3, z4);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem
    public boolean equals(Object object) {
        int i;
        int jailbroken;
        int buildVersion;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.OperatingSystem) {
            if (this.platform == (CrashlyticsReport.Session.OperatingSystem)object.getPlatform() && this.version.equals(object.getVersion()) && this.buildVersion.equals(object.getBuildVersion()) && this.jailbroken == object.isJailbroken()) {
                if (this.version.equals(object.getVersion())) {
                    if (this.buildVersion.equals(object.getBuildVersion())) {
                        if (this.jailbroken == object.isJailbroken()) {
                        } else {
                            i = i2;
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

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem
    public String getBuildVersion() {
        return this.buildVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem
    public int getPlatform() {
        return this.platform;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem
    public String getVersion() {
        return this.version;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem
    public int hashCode() {
        int i;
        int i9 = 1000003;
        i = this.jailbroken ? 1231 : 1237;
        return i7 ^= i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem
    public boolean isJailbroken() {
        return this.jailbroken;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$OperatingSystem
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OperatingSystem{platform=");
        stringBuilder.append(this.platform);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append(", buildVersion=");
        stringBuilder.append(this.buildVersion);
        stringBuilder.append(", jailbroken=");
        stringBuilder.append(this.jailbroken);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
