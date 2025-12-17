package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception {

    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception causedBy;
    private final com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
    private final int overflowCount;
    private final String reason;
    private final String type;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder {

        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception causedBy;
        private com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> frames;
        private Integer overflowCount;
        private String reason;
        private String type;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception build() {
            Object stringBuilder;
            Object stringBuilder2;
            Object overflowCount;
            String string;
            if (this.type == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" type");
                string = stringBuilder.toString();
            }
            if (this.frames == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" frames");
                string = stringBuilder2.toString();
            }
            if (this.overflowCount == null) {
                overflowCount = new StringBuilder();
                overflowCount.append(string);
                overflowCount.append(" overflowCount");
                string = overflowCount.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.type, this.reason, this.frames, this.causedBy, this.overflowCount.intValue(), 0);
                return autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Missing required properties:");
            stringBuilder3.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder3.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setCausedBy(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception crashlyticsReport$Session$Event$Application$Execution$Exception) {
            this.causedBy = exception;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setFrames(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList) {
            Objects.requireNonNull(immutableList, "Null frames");
            this.frames = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setOverflowCount(int i) {
            this.overflowCount = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setReason(String string) {
            this.reason = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder setType(String string) {
            Objects.requireNonNull(string, "Null type");
            this.type = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String string, String string2, com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> immutableList3, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception crashlyticsReport$Session$Event$Application$Execution$Exception4, int i5) {
        super();
        this.type = string;
        this.reason = string2;
        this.frames = immutableList3;
        this.causedBy = exception4;
        this.overflowCount = i5;
    }

    AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception(String string, String string2, com.google.firebase.crashlytics.internal.model.ImmutableList immutableList3, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception crashlyticsReport$Session$Event$Application$Execution$Exception4, int i5, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.1 autoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception$16) {
        super(string, string2, immutableList3, exception4, i5);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception
    public boolean equals(Object object) {
        int i;
        boolean overflowCount;
        String causedBy;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.Event.Application.Execution.Exception != null) {
            if (this.type.equals((CrashlyticsReport.Session.Event.Application.Execution.Exception)object.getType())) {
                String reason = this.reason;
                if (reason == null) {
                    if (object.getReason() == null) {
                        if (this.frames.equals(object.getFrames())) {
                            com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception causedBy2 = this.causedBy;
                            if (causedBy2 == null) {
                                if (object.getCausedBy() == null) {
                                    if (this.overflowCount == object.getOverflowCount()) {
                                    } else {
                                        i = i2;
                                    }
                                } else {
                                }
                            } else {
                                if (causedBy2.equals(object.getCausedBy()) && this.overflowCount == object.getOverflowCount()) {
                                } else {
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                    if (reason.equals(object.getReason()) && this.frames.equals(object.getFrames())) {
                    } else {
                    }
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception getCausedBy() {
        return this.causedBy;
    }

    public com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> getFrames() {
        return this.frames;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception
    public int getOverflowCount() {
        return this.overflowCount;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception
    public String getReason() {
        return this.reason;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception
    public String getType() {
        return this.type;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception
    public int hashCode() {
        int i;
        int i2;
        int i13 = 1000003;
        String reason = this.reason;
        if (reason == null) {
            i = i2;
        } else {
            i = reason.hashCode();
        }
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Exception causedBy = this.causedBy;
        if (causedBy == null) {
        } else {
            i2 = causedBy.hashCode();
        }
        return i11 ^= overflowCount;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Exception
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception{type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", reason=");
        stringBuilder.append(this.reason);
        stringBuilder.append(", frames=");
        stringBuilder.append(this.frames);
        stringBuilder.append(", causedBy=");
        stringBuilder.append(this.causedBy);
        stringBuilder.append(", overflowCount=");
        stringBuilder.append(this.overflowCount);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
