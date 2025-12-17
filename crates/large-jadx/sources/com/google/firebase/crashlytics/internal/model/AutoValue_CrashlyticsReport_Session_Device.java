package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_CrashlyticsReport_Session_Device extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device {

    private final int arch;
    private final int cores;
    private final long diskSpace;
    private final String manufacturer;
    private final String model;
    private final String modelClass;
    private final long ram;
    private final boolean simulator;
    private final int state;

    static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder {

        private Integer arch;
        private Integer cores;
        private Long diskSpace;
        private String manufacturer;
        private String model;
        private String modelClass;
        private Long ram;
        private Boolean simulator;
        private Integer state;
        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device build() {
            Object stringBuilder3;
            Object stringBuilder8;
            Object stringBuilder7;
            Object stringBuilder;
            Object stringBuilder9;
            Object stringBuilder4;
            Object stringBuilder5;
            Object stringBuilder6;
            Object stringBuilder2;
            String string;
            if (this.arch == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append("");
                stringBuilder3.append(" arch");
                string = stringBuilder3.toString();
            }
            if (this.model == null) {
                stringBuilder8 = new StringBuilder();
                stringBuilder8.append(string);
                stringBuilder8.append(" model");
                string = stringBuilder8.toString();
            }
            if (this.cores == null) {
                stringBuilder7 = new StringBuilder();
                stringBuilder7.append(string);
                stringBuilder7.append(" cores");
                string = stringBuilder7.toString();
            }
            if (this.ram == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" ram");
                string = stringBuilder.toString();
            }
            if (this.diskSpace == null) {
                stringBuilder9 = new StringBuilder();
                stringBuilder9.append(string);
                stringBuilder9.append(" diskSpace");
                string = stringBuilder9.toString();
            }
            if (this.simulator == null) {
                stringBuilder4 = new StringBuilder();
                stringBuilder4.append(string);
                stringBuilder4.append(" simulator");
                string = stringBuilder4.toString();
            }
            if (this.state == null) {
                stringBuilder5 = new StringBuilder();
                stringBuilder5.append(string);
                stringBuilder5.append(" state");
                string = stringBuilder5.toString();
            }
            if (this.manufacturer == null) {
                stringBuilder6 = new StringBuilder();
                stringBuilder6.append(string);
                stringBuilder6.append(" manufacturer");
                string = stringBuilder6.toString();
            }
            if (this.modelClass == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(" modelClass");
                string = stringBuilder2.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.arch.intValue(), this.model, this.cores.intValue(), this.ram.longValue(), obj7, this.diskSpace.longValue(), obj9, this.simulator.booleanValue(), this.state.intValue(), this.manufacturer, this.modelClass, 0);
                return autoValue_CrashlyticsReport_Session_Device;
            }
            StringBuilder stringBuilder10 = new StringBuilder();
            stringBuilder10.append("Missing required properties:");
            stringBuilder10.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder10.toString());
            throw illegalStateException;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setArch(int i) {
            this.arch = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setCores(int i) {
            this.cores = Integer.valueOf(i);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setDiskSpace(long l) {
            this.diskSpace = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setManufacturer(String string) {
            Objects.requireNonNull(string, "Null manufacturer");
            this.manufacturer = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setModel(String string) {
            Objects.requireNonNull(string, "Null model");
            this.model = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setModelClass(String string) {
            Objects.requireNonNull(string, "Null modelClass");
            this.modelClass = string;
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setRam(long l) {
            this.ram = Long.valueOf(l);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setSimulator(boolean z) {
            this.simulator = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device$Builder
        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Device.Builder setState(int i) {
            this.state = Integer.valueOf(i);
            return this;
        }
    }
    private AutoValue_CrashlyticsReport_Session_Device(int i, String string2, int i3, long l4, long l5, boolean z6, int i7, String string8, String string9) {
        super();
        this.arch = i;
        this.model = string2;
        this.cores = i3;
        this.ram = l4;
        this.diskSpace = z6;
        this.simulator = string8;
        this.state = string9;
        this.manufacturer = obj10;
        this.modelClass = obj11;
    }

    AutoValue_CrashlyticsReport_Session_Device(int i, String string2, int i3, long l4, long l5, boolean z6, int i7, String string8, String string9, com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device.1 autoValue_CrashlyticsReport_Session_Device$110) {
        super(i, string2, i3, l4, l5, z6, i7, string8, string9, 110, obj11);
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public boolean equals(Object object) {
        int i;
        String modelClass;
        String diskSpace2;
        long diskSpace;
        boolean obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof CrashlyticsReport.Session.Device) {
            if (this.arch == (CrashlyticsReport.Session.Device)object.getArch() && this.model.equals(object.getModel()) && this.cores == object.getCores() && Long.compare(diskSpace2, diskSpace) == 0 && Long.compare(diskSpace2, diskSpace) == 0 && this.simulator == object.isSimulator() && this.state == object.getState() && this.manufacturer.equals(object.getManufacturer()) && this.modelClass.equals(object.getModelClass())) {
                if (this.model.equals(object.getModel())) {
                    if (this.cores == object.getCores()) {
                        if (Long.compare(diskSpace2, diskSpace) == 0) {
                            if (Long.compare(diskSpace2, diskSpace) == 0) {
                                if (this.simulator == object.isSimulator()) {
                                    if (this.state == object.getState()) {
                                        if (this.manufacturer.equals(object.getManufacturer())) {
                                            if (this.modelClass.equals(object.getModelClass())) {
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
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public int getArch() {
        return this.arch;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public int getCores() {
        return this.cores;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public long getDiskSpace() {
        return this.diskSpace;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public String getModel() {
        return this.model;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public String getModelClass() {
        return this.modelClass;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public long getRam() {
        return this.ram;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public int getState() {
        return this.state;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public int hashCode() {
        int i;
        int i19 = 1000003;
        long ram = this.ram;
        int i27 = 32;
        long diskSpace = this.diskSpace;
        i = this.simulator ? 1231 : 1237;
        return i17 ^= i20;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public boolean isSimulator() {
        return this.simulator;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Device
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Device{arch=");
        stringBuilder.append(this.arch);
        stringBuilder.append(", model=");
        stringBuilder.append(this.model);
        stringBuilder.append(", cores=");
        stringBuilder.append(this.cores);
        stringBuilder.append(", ram=");
        stringBuilder.append(this.ram);
        stringBuilder.append(", diskSpace=");
        stringBuilder.append(this.diskSpace);
        stringBuilder.append(", simulator=");
        stringBuilder.append(this.simulator);
        stringBuilder.append(", state=");
        stringBuilder.append(this.state);
        stringBuilder.append(", manufacturer=");
        stringBuilder.append(this.manufacturer);
        stringBuilder.append(", modelClass=");
        stringBuilder.append(this.modelClass);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
