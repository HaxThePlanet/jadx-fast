package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.encoders.annotations.Encodable.Ignore;
import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session {

    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application app;
    private final boolean crashed;
    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device device;
    private final Long endedAt;
    private final com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event> events;
    private final String generator;
    private final int generatorType;
    private final String identifier;
    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem os;
    private final long startedAt;
    private final com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User user;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder {

        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application app;
        private Boolean crashed;
        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device device;
        private Long endedAt;
        private com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event> events;
        private String generator;
        private Integer generatorType;
        private String identifier;
        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem os;
        private Long startedAt;
        private com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User user;
        private Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session crashlyticsReport$Session) {
            super();
            this.generator = session.getGenerator();
            this.identifier = session.getIdentifier();
            this.startedAt = Long.valueOf(session.getStartedAt());
            this.endedAt = session.getEndedAt();
            this.crashed = Boolean.valueOf(session.isCrashed());
            this.app = session.getApp();
            this.user = session.getUser();
            this.os = session.getOs();
            this.device = session.getDevice();
            this.events = session.getEvents();
            this.generatorType = Integer.valueOf(session.getGeneratorType());
        }

        Builder(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session crashlyticsReport$Session, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session.1 autoValue_CrashlyticsReport_Session$12) {
            super(session);
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session build() {
            Object stringBuilder;
            Object stringBuilder3;
            Object stringBuilder4;
            Object stringBuilder5;
            Object stringBuilder2;
            Object generatorType;
            String string;
            final Object obj = this;
            if (obj.generator == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(" generator");
                string = stringBuilder.toString();
            }
            if (obj.identifier == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" identifier");
                string = stringBuilder3.toString();
            }
            if (obj.startedAt == null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string);
                stringBuilder4.append(" startedAt");
                string = stringBuilder4.toString();
            }
            if (obj.crashed == null) {
                stringBuilder5 = new StringBuilder();
                stringBuilder5.append(string);
                stringBuilder5.append(" crashed");
                string = stringBuilder5.toString();
            }
            if (obj.app == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" app");
                string = stringBuilder2.toString();
            }
            if (obj.generatorType == null) {
                generatorType = new StringBuilder();
                generatorType.append(string);
                generatorType.append(" generatorType");
                string = generatorType.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(obj.generator, obj.identifier, obj.startedAt.longValue(), obj7, obj.endedAt, obj.crashed.booleanValue(), obj.app, obj.user, obj.os, obj.device, obj.events, obj.generatorType.intValue(), 0);
                return autoValue_CrashlyticsReport_Session;
            }
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append("Missing required properties:");
            stringBuilder6.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder6.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setApp(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application crashlyticsReport$Session$Application) {
            Objects.requireNonNull(application, "Null app");
            this.app = application;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setCrashed(boolean z) {
            this.crashed = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setDevice(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device crashlyticsReport$Session$Device) {
            this.device = device;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setEndedAt(Long long) {
            this.endedAt = long;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setEvents(com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event> immutableList) {
            this.events = immutableList;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setGenerator(String string) {
            Objects.requireNonNull(string, "Null generator");
            this.generator = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setGeneratorType(int i) {
            this.generatorType = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setIdentifier(String string) {
            Objects.requireNonNull(string, "Null identifier");
            this.identifier = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setOs(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem crashlyticsReport$Session$OperatingSystem) {
            this.os = operatingSystem;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setStartedAt(long l) {
            this.startedAt = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder setUser(com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User crashlyticsReport$Session$User) {
            this.user = user;
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session(String string, String string2, long l3, Long long4, boolean z5, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application crashlyticsReport$Session$Application6, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User crashlyticsReport$Session$User7, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem crashlyticsReport$Session$OperatingSystem8, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device crashlyticsReport$Session$Device9, com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event> immutableList10, int i11) {
        super();
        this.generator = string;
        this.identifier = string2;
        this.startedAt = l3;
        this.endedAt = z5;
        this.crashed = application6;
        this.app = user7;
        this.user = operatingSystem8;
        this.os = device9;
        this.device = immutableList10;
        this.events = i11;
        this.generatorType = obj12;
    }

    AutoValue_CrashlyticsReport_Session(String string, String string2, long l3, Long long4, boolean z5, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application crashlyticsReport$Session$Application6, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User crashlyticsReport$Session$User7, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem crashlyticsReport$Session$OperatingSystem8, com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device crashlyticsReport$Session$Device9, com.google.firebase.crashlytics.internal.model.ImmutableList immutableList10, int i11, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session.1 autoValue_CrashlyticsReport_Session$112) {
        super(string, string2, l3, long4, z5, application6, user7, operatingSystem8, device9, immutableList10, i11, 112);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public boolean equals(Object object) {
        int i;
        boolean generatorType;
        Object startedAt2;
        long startedAt;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session) {
            if (this.generator.equals((CrashlyticsReport.Session)object.getGenerator()) && this.identifier.equals(object.getIdentifier()) && Long.compare(startedAt2, startedAt) == 0) {
                if (this.identifier.equals(object.getIdentifier())) {
                    if (Long.compare(startedAt2, startedAt) == 0) {
                        Long endedAt = this.endedAt;
                        if (endedAt == null) {
                            if (object.getEndedAt() == null) {
                                if (this.crashed == object.isCrashed()) {
                                    if (this.app.equals(object.getApp())) {
                                        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User user = this.user;
                                        if (user == null) {
                                            if (object.getUser() == null) {
                                                com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem operatingSystem = this.os;
                                                if (operatingSystem == null) {
                                                    if (object.getOs() == null) {
                                                        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device device = this.device;
                                                        if (device == null) {
                                                            if (object.getDevice() == null) {
                                                                com.google.firebase.crashlytics.internal.model.ImmutableList events = this.events;
                                                                if (events == null) {
                                                                    if (object.getEvents() == null) {
                                                                        if (this.generatorType == object.getGeneratorType()) {
                                                                        } else {
                                                                            i = i2;
                                                                        }
                                                                    } else {
                                                                    }
                                                                } else {
                                                                    if (events.equals(object.getEvents()) && this.generatorType == object.getGeneratorType()) {
                                                                    } else {
                                                                    }
                                                                }
                                                            } else {
                                                            }
                                                        } else {
                                                            if (device.equals(object.getDevice())) {
                                                            } else {
                                                            }
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                    if (operatingSystem.equals(object.getOs())) {
                                                    } else {
                                                    }
                                                }
                                            } else {
                                            }
                                        } else {
                                            if (user.equals(object.getUser())) {
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
                            if (endedAt.equals(object.getEndedAt()) && this.crashed == object.isCrashed() && this.app.equals(object.getApp())) {
                            } else {
                            }
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

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application getApp() {
        return this.app;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device getDevice() {
        return this.device;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public Long getEndedAt() {
        return this.endedAt;
    }

    public com.google.firebase.crashlytics.internal.model.ImmutableList<com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event> getEvents() {
        return this.events;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public String getGenerator() {
        return this.generator;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public int getGeneratorType() {
        return this.generatorType;
    }

    @Encodable$Ignore
    public String getIdentifier() {
        return this.identifier;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem getOs() {
        return this.os;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public long getStartedAt() {
        return this.startedAt;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User getUser() {
        return this.user;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public int hashCode() {
        int i5;
        int i2;
        int i4;
        int i3;
        int i;
        int i6;
        int i29 = 1000003;
        long startedAt = this.startedAt;
        Long endedAt = this.endedAt;
        i6 = 0;
        if (endedAt == null) {
            i5 = i6;
        } else {
            i5 = endedAt.hashCode();
        }
        i2 = this.crashed ? 1231 : 1237;
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User user = this.user;
        if (user == null) {
            i4 = i6;
        } else {
            i4 = user.hashCode();
        }
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem operatingSystem = this.os;
        if (operatingSystem == null) {
            i3 = i6;
        } else {
            i3 = operatingSystem.hashCode();
        }
        com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device device = this.device;
        if (device == null) {
            i = i6;
        } else {
            i = device.hashCode();
        }
        com.google.firebase.crashlytics.internal.model.ImmutableList events = this.events;
        if (events == null) {
        } else {
            i6 = events.hashCode();
        }
        return i27 ^= generatorType;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public boolean isCrashed() {
        return this.crashed;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Builder toBuilder() {
        AutoValue_CrashlyticsReport_Session.Builder builder = new AutoValue_CrashlyticsReport_Session.Builder(this, 0);
        return builder;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Session{generator=");
        stringBuilder.append(this.generator);
        stringBuilder.append(", identifier=");
        stringBuilder.append(this.identifier);
        stringBuilder.append(", startedAt=");
        stringBuilder.append(this.startedAt);
        stringBuilder.append(", endedAt=");
        stringBuilder.append(this.endedAt);
        stringBuilder.append(", crashed=");
        stringBuilder.append(this.crashed);
        stringBuilder.append(", app=");
        stringBuilder.append(this.app);
        stringBuilder.append(", user=");
        stringBuilder.append(this.user);
        stringBuilder.append(", os=");
        stringBuilder.append(this.os);
        stringBuilder.append(", device=");
        stringBuilder.append(this.device);
        stringBuilder.append(", events=");
        stringBuilder.append(this.events);
        stringBuilder.append(", generatorType=");
        stringBuilder.append(this.generatorType);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
