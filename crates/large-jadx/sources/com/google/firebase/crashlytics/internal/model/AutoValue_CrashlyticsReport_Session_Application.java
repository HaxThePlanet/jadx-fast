package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Application extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application {

    private final String developmentPlatform;
    private final String developmentPlatformVersion;
    private final String displayVersion;
    private final String identifier;
    private final String installationUuid;
    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization organization;
    private final String version;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder {

        private String developmentPlatform;
        private String developmentPlatformVersion;
        private String displayVersion;
        private String identifier;
        private String installationUuid;
        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization organization;
        private String version;
        private Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application crashlyticsReport$Session$Application) {
            super();
            this.identifier = application.getIdentifier();
            this.version = application.getVersion();
            this.displayVersion = application.getDisplayVersion();
            this.organization = application.getOrganization();
            this.installationUuid = application.getInstallationUuid();
            this.developmentPlatform = application.getDevelopmentPlatform();
            this.developmentPlatformVersion = application.getDevelopmentPlatformVersion();
        }

        Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application crashlyticsReport$Session$Application, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application.1 autoValue_CrashlyticsReport_Session_Application$12) {
            super(application);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application build() {
            Object stringBuilder2;
            Object stringBuilder;
            String string;
            if (this.identifier == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(" identifier");
                string = stringBuilder2.toString();
            }
            if (this.version == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" version");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.identifier, this.version, this.displayVersion, this.organization, this.installationUuid, this.developmentPlatform, this.developmentPlatformVersion, 0);
                return autoValue_CrashlyticsReport_Session_Application;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Missing required properties:");
            stringBuilder3.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder3.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setDevelopmentPlatform(String string) {
            this.developmentPlatform = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setDevelopmentPlatformVersion(String string) {
            this.developmentPlatformVersion = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setDisplayVersion(String string) {
            this.displayVersion = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setIdentifier(String string) {
            Objects.requireNonNull(string, "Null identifier");
            this.identifier = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setInstallationUuid(String string) {
            this.installationUuid = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setOrganization(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization crashlyticsReport$Session$Application$Organization) {
            this.organization = organization;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setVersion(String string) {
            Objects.requireNonNull(string, "Null version");
            this.version = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Application(String string, String string2, String string3, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization crashlyticsReport$Session$Application$Organization4, String string5, String string6, String string7) {
        super();
        this.identifier = string;
        this.version = string2;
        this.displayVersion = string3;
        this.organization = organization4;
        this.installationUuid = string5;
        this.developmentPlatform = string6;
        this.developmentPlatformVersion = string7;
    }

    AutoValue_CrashlyticsReport_Session_Application(String string, String string2, String string3, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization crashlyticsReport$Session$Application$Organization4, String string5, String string6, String string7, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application.1 autoValue_CrashlyticsReport_Session_Application$18) {
        super(string, string2, string3, organization4, string5, string6, string7);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application
    public boolean equals(Object object) {
        int i;
        String developmentPlatformVersion;
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization developmentPlatform;
        String obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.Application) {
            if (this.identifier.equals((CrashlyticsReport.Session.Application)object.getIdentifier()) && this.version.equals(object.getVersion())) {
                if (this.version.equals(object.getVersion())) {
                    String displayVersion = this.displayVersion;
                    if (displayVersion == null) {
                        if (object.getDisplayVersion() == null) {
                            com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization organization = this.organization;
                            if (organization == null) {
                                if (object.getOrganization() == null) {
                                    String installationUuid = this.installationUuid;
                                    if (installationUuid == null) {
                                        if (object.getInstallationUuid() == null) {
                                            String developmentPlatform2 = this.developmentPlatform;
                                            if (developmentPlatform2 == null) {
                                                if (object.getDevelopmentPlatform() == null) {
                                                    developmentPlatformVersion = this.developmentPlatformVersion;
                                                    if (developmentPlatformVersion == null) {
                                                        if (object.getDevelopmentPlatformVersion() == null) {
                                                        } else {
                                                            i = i2;
                                                        }
                                                    } else {
                                                        if (developmentPlatformVersion.equals(object.getDevelopmentPlatformVersion())) {
                                                        } else {
                                                        }
                                                    }
                                                } else {
                                                }
                                            } else {
                                                if (developmentPlatform2.equals(object.getDevelopmentPlatform())) {
                                                } else {
                                                }
                                            }
                                        } else {
                                        }
                                    } else {
                                        if (installationUuid.equals(object.getInstallationUuid())) {
                                        } else {
                                        }
                                    }
                                } else {
                                }
                            } else {
                                if (organization.equals(object.getOrganization())) {
                                } else {
                                }
                            }
                        } else {
                        }
                    } else {
                        if (displayVersion.equals(object.getDisplayVersion())) {
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application
    public String getDevelopmentPlatform() {
        return this.developmentPlatform;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application
    public String getDevelopmentPlatformVersion() {
        return this.developmentPlatformVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application
    public String getDisplayVersion() {
        return this.displayVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application
    public String getIdentifier() {
        return this.identifier;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application
    public String getInstallationUuid() {
        return this.installationUuid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization getOrganization() {
        return this.organization;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application
    public String getVersion() {
        return this.version;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application
    public int hashCode() {
        int i3;
        int i;
        int i5;
        int i2;
        int i4;
        int i20 = 1000003;
        String displayVersion = this.displayVersion;
        i4 = 0;
        if (displayVersion == null) {
            i3 = i4;
        } else {
            i3 = displayVersion.hashCode();
        }
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization organization = this.organization;
        if (organization == null) {
            i = i4;
        } else {
            i = organization.hashCode();
        }
        String installationUuid = this.installationUuid;
        if (installationUuid == null) {
            i5 = i4;
        } else {
            i5 = installationUuid.hashCode();
        }
        String developmentPlatform = this.developmentPlatform;
        if (developmentPlatform == null) {
            i2 = i4;
        } else {
            i2 = developmentPlatform.hashCode();
        }
        String developmentPlatformVersion = this.developmentPlatformVersion;
        if (developmentPlatformVersion == null) {
        } else {
            i4 = developmentPlatformVersion.hashCode();
        }
        return i18 ^= i4;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application
    protected com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder toBuilder() {
        AutoValue_CrashlyticsReport_Session_Application.Builder builder = new AutoValue_CrashlyticsReport_Session_Application.Builder(this, 0);
        return builder;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Application{identifier=");
        stringBuilder.append(this.identifier);
        stringBuilder.append(", version=");
        stringBuilder.append(this.version);
        stringBuilder.append(", displayVersion=");
        stringBuilder.append(this.displayVersion);
        stringBuilder.append(", organization=");
        stringBuilder.append(this.organization);
        stringBuilder.append(", installationUuid=");
        stringBuilder.append(this.installationUuid);
        stringBuilder.append(", developmentPlatform=");
        stringBuilder.append(this.developmentPlatform);
        stringBuilder.append(", developmentPlatformVersion=");
        stringBuilder.append(this.developmentPlatformVersion);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
