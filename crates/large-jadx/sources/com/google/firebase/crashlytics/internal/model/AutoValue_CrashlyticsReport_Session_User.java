package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_User extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User {

    private final String identifier;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder {

        private String identifier;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User build() {
            Object stringBuilder;
            String string;
            if (this.identifier == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" identifier");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                AutoValue_CrashlyticsReport_Session_User autoValue_CrashlyticsReport_Session_User = new AutoValue_CrashlyticsReport_Session_User(this.identifier, 0);
                return autoValue_CrashlyticsReport_Session_User;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Missing required properties:");
            stringBuilder2.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder setIdentifier(String string) {
            Objects.requireNonNull(string, "Null identifier");
            this.identifier = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_User(String string) {
        super();
        this.identifier = string;
    }

    AutoValue_CrashlyticsReport_Session_User(String string, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_User.1 autoValue_CrashlyticsReport_Session_User$12) {
        super(string);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User
    public boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        if (object instanceof CrashlyticsReport.Session.User) {
            return this.identifier.equals((CrashlyticsReport.Session.User)object.getIdentifier());
        }
        return 0;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User
    public String getIdentifier() {
        return this.identifier;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User
    public int hashCode() {
        return i ^= i3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$User
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User{identifier=");
        stringBuilder.append(this.identifier);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
