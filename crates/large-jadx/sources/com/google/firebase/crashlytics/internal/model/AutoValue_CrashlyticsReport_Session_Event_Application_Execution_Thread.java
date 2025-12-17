package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread {

    private final com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
    private final int importance;
    private final String name;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder {

        private com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
        private Integer importance;
        private String name;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread build() {
            Object stringBuilder;
            Object stringBuilder2;
            Object stringBuilder3;
            String string;
            if (this.name == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" name");
                string = stringBuilder.toString();
            }
            if (this.importance == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" importance");
                string = stringBuilder2.toString();
            }
            if (this.frames == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" frames");
                string = stringBuilder3.toString();
            }
            if (!string.isEmpty()) {
            } else {
                AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread autoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(this.name, this.importance.intValue(), this.frames, 0);
                return autoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Missing required properties:");
            stringBuilder4.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder4.toString());
            throw illegalStateException;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setFrames(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
            Objects.requireNonNull(immutableList, "Null frames");
            this.frames = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setImportance(int i) {
            this.importance = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder setName(String string) {
            Objects.requireNonNull(string, "Null name");
            this.name = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(String string, int i2, com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList3) {
        super();
        this.name = string;
        this.importance = i2;
        this.frames = immutableList3;
    }

    AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread(String string, int i2, com.google.firebase.crashlytics.internal.model.ImmutableList immutableList3, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.1 autoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread$14) {
        super(string, i2, immutableList3);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread
    public boolean equals(Object object) {
        int i;
        boolean importance;
        String importance2;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread) {
            if (this.name.equals((CrashlyticsReport.Session.Event.Application.Execution.Thread)object.getName()) && this.importance == object.getImportance() && this.frames.equals(object.getFrames())) {
                if (this.importance == object.getImportance()) {
                    if (this.frames.equals(object.getFrames())) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames() {
        return this.frames;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread
    public int getImportance() {
        return this.importance;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread
    public String getName() {
        return this.name;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread
    public int hashCode() {
        int i7 = 1000003;
        return i5 ^= i8;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thread{name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", importance=");
        stringBuilder.append(this.importance);
        stringBuilder.append(", frames=");
        stringBuilder.append(this.frames);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
