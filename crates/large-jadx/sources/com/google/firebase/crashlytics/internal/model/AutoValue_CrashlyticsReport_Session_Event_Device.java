package com.google.firebase.crashlytics.internal.model;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Event_Device extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device {

    private final Double batteryLevel;
    private final int batteryVelocity;
    private final long diskUsed;
    private final int orientation;
    private final boolean proximityOn;
    private final long ramUsed;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder {

        private Double batteryLevel;
        private Integer batteryVelocity;
        private Long diskUsed;
        private Integer orientation;
        private Boolean proximityOn;
        private Long ramUsed;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device build() {
            Object batteryVelocity;
            Object stringBuilder;
            Object stringBuilder2;
            Object stringBuilder4;
            Object stringBuilder3;
            String string;
            if (this.batteryVelocity == null) {
                batteryVelocity = new StringBuilder();
                batteryVelocity.append("");
                batteryVelocity.append(" batteryVelocity");
                string = batteryVelocity.toString();
            }
            if (this.proximityOn == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" proximityOn");
                string = stringBuilder.toString();
            }
            if (this.orientation == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" orientation");
                string = stringBuilder2.toString();
            }
            if (this.ramUsed == null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string);
                stringBuilder4.append(" ramUsed");
                string = stringBuilder4.toString();
            }
            if (this.diskUsed == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" diskUsed");
                string = stringBuilder3.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.batteryLevel, this.batteryVelocity.intValue(), this.proximityOn.booleanValue(), this.orientation.intValue(), this.ramUsed.longValue(), obj8, this.diskUsed.longValue(), obj10, 0);
                return autoValue_CrashlyticsReport_Session_Event_Device;
            }
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder5.append("Missing required properties:");
            stringBuilder5.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder5.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setBatteryLevel(Double double) {
            this.batteryLevel = double;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setBatteryVelocity(int i) {
            this.batteryVelocity = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setDiskUsed(long l) {
            this.diskUsed = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setOrientation(int i) {
            this.orientation = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setProximityOn(boolean z) {
            this.proximityOn = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device.Builder setRamUsed(long l) {
            this.ramUsed = Long.valueOf(l);
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Event_Device(Double double, int i2, boolean z3, int i4, long l5, long l6) {
        super();
        this.batteryLevel = double;
        this.batteryVelocity = i2;
        this.proximityOn = z3;
        this.orientation = i4;
        this.ramUsed = l5;
        this.diskUsed = obj7;
    }

    AutoValue_CrashlyticsReport_Session_Event_Device(Double double, int i2, boolean z3, int i4, long l5, long l6, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device.1 autoValue_CrashlyticsReport_Session_Event_Device$17) {
        super(double, i2, z3, i4, l5, l6, 17, obj8);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device
    public boolean equals(Object object) {
        int i;
        int batteryVelocity;
        long batteryVelocity2;
        long diskUsed;
        int obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.Event.Device) {
            Double batteryLevel = this.batteryLevel;
            if (batteryLevel == null) {
                if ((CrashlyticsReport.Session.Event.Device)object.getBatteryLevel() == null) {
                    if (this.batteryVelocity == object.getBatteryVelocity()) {
                        if (this.proximityOn == object.isProximityOn()) {
                            if (this.orientation == object.getOrientation()) {
                                if (Long.compare(batteryVelocity2, diskUsed) == 0) {
                                    if (Long.compare(batteryVelocity2, diskUsed) == 0) {
                                    } else {
                                        i = i2;
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
                if (batteryLevel.equals(object.getBatteryLevel()) && this.batteryVelocity == object.getBatteryVelocity() && this.proximityOn == object.isProximityOn() && this.orientation == object.getOrientation() && Long.compare(batteryVelocity2, diskUsed) == 0 && Long.compare(batteryVelocity2, diskUsed) == 0) {
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device
    public Double getBatteryLevel() {
        return this.batteryLevel;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device
    public int getBatteryVelocity() {
        return this.batteryVelocity;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device
    public long getDiskUsed() {
        return this.diskUsed;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device
    public int getOrientation() {
        return this.orientation;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device
    public long getRamUsed() {
        return this.ramUsed;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device
    public int hashCode() {
        int i;
        int i2;
        Double batteryLevel = this.batteryLevel;
        if (batteryLevel == null) {
            i = 0;
        } else {
            i = batteryLevel.hashCode();
        }
        int i14 = 1000003;
        i2 = this.proximityOn ? 1231 : 1237;
        long ramUsed = this.ramUsed;
        final int i20 = 32;
        long diskUsed = this.diskUsed;
        return i12 ^= i16;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device
    public boolean isProximityOn() {
        return this.proximityOn;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Device
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Device{batteryLevel=");
        stringBuilder.append(this.batteryLevel);
        stringBuilder.append(", batteryVelocity=");
        stringBuilder.append(this.batteryVelocity);
        stringBuilder.append(", proximityOn=");
        stringBuilder.append(this.proximityOn);
        stringBuilder.append(", orientation=");
        stringBuilder.append(this.orientation);
        stringBuilder.append(", ramUsed=");
        stringBuilder.append(this.ramUsed);
        stringBuilder.append(", diskUsed=");
        stringBuilder.append(this.diskUsed);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
