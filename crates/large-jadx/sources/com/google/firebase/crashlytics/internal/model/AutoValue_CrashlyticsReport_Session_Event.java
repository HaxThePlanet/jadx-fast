package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Event extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event {

    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application app;
    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device device;
    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log log;
    private final long timestamp;
    private final String type;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder {

        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application app;
        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device device;
        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log log;
        private Long timestamp;
        private String type;
        private Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event crashlyticsReport$Session$Event) {
            super();
            this.timestamp = Long.valueOf(event.getTimestamp());
            this.type = event.getType();
            this.app = event.getApp();
            this.device = event.getDevice();
            this.log = event.getLog();
        }

        Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event crashlyticsReport$Session$Event, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event.1 autoValue_CrashlyticsReport_Session_Event$12) {
            super(event);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event build() {
            Object stringBuilder3;
            Object stringBuilder2;
            Object stringBuilder4;
            Object stringBuilder;
            String string;
            if (this.timestamp == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("");
                stringBuilder3.append(" timestamp");
                string = stringBuilder3.toString();
            }
            if (this.type == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" type");
                string = stringBuilder2.toString();
            }
            if (this.app == null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string);
                stringBuilder4.append(" app");
                string = stringBuilder4.toString();
            }
            if (this.device == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" device");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.timestamp.longValue(), obj4, this.type, this.app, this.device, this.log, 0);
                return autoValue_CrashlyticsReport_Session_Event;
            }
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("Missing required properties:");
            stringBuilder5.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder5.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder setApp(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application crashlyticsReport$Session$Event$Application) {
            Objects.requireNonNull(application, "Null app");
            this.app = application;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder setDevice(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device crashlyticsReport$Session$Event$Device) {
            Objects.requireNonNull(device, "Null device");
            this.device = device;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder setLog(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log crashlyticsReport$Session$Event$Log) {
            this.log = log;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder setTimestamp(long l) {
            this.timestamp = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder setType(String string) {
            Objects.requireNonNull(string, "Null type");
            this.type = string;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Event(long l, String string2, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application crashlyticsReport$Session$Event$Application3, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device crashlyticsReport$Session$Event$Device4, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log crashlyticsReport$Session$Event$Log5) {
        super();
        this.timestamp = l;
        this.type = application3;
        this.app = device4;
        this.device = log5;
        this.log = obj6;
    }

    AutoValue_CrashlyticsReport_Session_Event(long l, String string2, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application crashlyticsReport$Session$Event$Application3, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device crashlyticsReport$Session$Event$Device4, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log crashlyticsReport$Session$Event$Log5, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event.1 autoValue_CrashlyticsReport_Session_Event$16) {
        super(l, string2, application3, device4, log5, 16);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event
    public boolean equals(Object object) {
        int i;
        int equals;
        long timestamp;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.Event) {
            if (Long.compare(timestamp, timestamp2) == 0 && this.type.equals(object.getType()) && this.app.equals(object.getApp()) && this.device.equals(object.getDevice())) {
                if (this.type.equals(object.getType())) {
                    if (this.app.equals(object.getApp())) {
                        if (this.device.equals(object.getDevice())) {
                            equals = this.log;
                            if (equals == null) {
                                if (object.getLog() == null) {
                                } else {
                                    i = i2;
                                }
                            } else {
                                if (equals.equals(object.getLog())) {
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
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application getApp() {
        return this.app;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device getDevice() {
        return this.device;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log getLog() {
        return this.log;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event
    public long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event
    public String getType() {
        return this.type;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event
    public int hashCode() {
        int i;
        long timestamp = this.timestamp;
        int i13 = 1000003;
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log log = this.log;
        if (log == null) {
            i = 0;
        } else {
            i = log.hashCode();
        }
        return i11 ^= i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder toBuilder() {
        AutoValue_CrashlyticsReport_Session_Event.Builder builder = new AutoValue_CrashlyticsReport_Session_Event.Builder(this, 0);
        return builder;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{timestamp=");
        stringBuilder.append(this.timestamp);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", app=");
        stringBuilder.append(this.app);
        stringBuilder.append(", device=");
        stringBuilder.append(this.device);
        stringBuilder.append(", log=");
        stringBuilder.append(this.log);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
