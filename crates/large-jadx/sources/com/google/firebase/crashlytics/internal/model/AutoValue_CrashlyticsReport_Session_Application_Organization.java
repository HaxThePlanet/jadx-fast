package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Application_Organization extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization {

    private final String clsId;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization.Builder {

        private String clsId;
        private Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization crashlyticsReport$Session$Application$Organization) {
            super();
            this.clsId = organization.getClsId();
        }

        Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization crashlyticsReport$Session$Application$Organization, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application_Organization.1 autoValue_CrashlyticsReport_Session_Application_Organization$12) {
            super(organization);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization build() {
            Object stringBuilder;
            String string;
            if (this.clsId == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" clsId");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                AutoValue_CrashlyticsReport_Session_Application_Organization autoValue_CrashlyticsReport_Session_Application_Organization = new AutoValue_CrashlyticsReport_Session_Application_Organization(this.clsId, 0);
                return autoValue_CrashlyticsReport_Session_Application_Organization;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Missing required properties:");
            stringBuilder2.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization.Builder setClsId(String string) {
            Objects.requireNonNull(string, "Null clsId");
            this.clsId = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Application_Organization(String string) {
        super();
        this.clsId = string;
    }

    AutoValue_CrashlyticsReport_Session_Application_Organization(String string, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application_Organization.1 autoValue_CrashlyticsReport_Session_Application_Organization$12) {
        super(string);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization
    public boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        if (object instanceof CrashlyticsReport.Session.Application.Organization) {
            return this.clsId.equals((CrashlyticsReport.Session.Application.Organization)object.getClsId());
        }
        return 0;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization
    public String getClsId() {
        return this.clsId;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization
    public int hashCode() {
        return i ^= i3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization
    protected com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization.Builder toBuilder() {
        AutoValue_CrashlyticsReport_Session_Application_Organization.Builder builder = new AutoValue_CrashlyticsReport_Session_Application_Organization.Builder(this, 0);
        return builder;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Application$Organization
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Organization{clsId=");
        stringBuilder.append(this.clsId);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
