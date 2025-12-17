package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Log extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log {

    private final String content;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder {

        private String content;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log build() {
            Object stringBuilder;
            String string;
            if (this.content == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" content");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                AutoValue_CrashlyticsReport_Session_Event_Log autoValue_CrashlyticsReport_Session_Event_Log = new AutoValue_CrashlyticsReport_Session_Event_Log(this.content, 0);
                return autoValue_CrashlyticsReport_Session_Event_Log;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Missing required properties:");
            stringBuilder2.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder2.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log.Builder setContent(String string) {
            Objects.requireNonNull(string, "Null content");
            this.content = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Event_Log(String string) {
        super();
        this.content = string;
    }

    AutoValue_CrashlyticsReport_Session_Event_Log(String string, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log.1 autoValue_CrashlyticsReport_Session_Event_Log$12) {
        super(string);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log
    public boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        if (object instanceof CrashlyticsReport.Session.Event.Log) {
            return this.content.equals((CrashlyticsReport.Session.Event.Log)object.getContent());
        }
        return 0;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log
    public String getContent() {
        return this.content;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log
    public int hashCode() {
        return i ^= i3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Log
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Log{content=");
        stringBuilder.append(this.content);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
