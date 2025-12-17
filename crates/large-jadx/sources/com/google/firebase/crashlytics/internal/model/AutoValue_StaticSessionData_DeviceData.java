package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_StaticSessionData_DeviceData extends com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData {

    private final int arch;
    private final int availableProcessors;
    private final long diskSpace;
    private final boolean isEmulator;
    private final String manufacturer;
    private final String model;
    private final String modelClass;
    private final int state;
    private final long totalRam;
    AutoValue_StaticSessionData_DeviceData(int i, String string2, int i3, long l4, long l5, boolean z6, int i7, String string8, String string9) {
        super();
        this.arch = i;
        Objects.requireNonNull(string2, "Null model");
        this.model = string2;
        this.availableProcessors = i3;
        this.totalRam = l4;
        this.diskSpace = z6;
        this.isEmulator = string8;
        this.state = string9;
        Objects.requireNonNull(obj10, "Null manufacturer");
        this.manufacturer = obj10;
        Objects.requireNonNull(obj11, "Null modelClass");
        this.modelClass = obj11;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public int arch() {
        return this.arch;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public int availableProcessors() {
        return this.availableProcessors;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public long diskSpace() {
        return this.diskSpace;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public boolean equals(Object object) {
        int i;
        String availableProcessors;
        String availableProcessors2;
        long diskSpace;
        boolean obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof StaticSessionData.DeviceData != null) {
            if (this.arch == (StaticSessionData.DeviceData)object.arch() && this.model.equals(object.model()) && this.availableProcessors == object.availableProcessors() && Long.compare(availableProcessors2, diskSpace) == 0 && Long.compare(availableProcessors2, diskSpace) == 0 && this.isEmulator == object.isEmulator() && this.state == object.state() && this.manufacturer.equals(object.manufacturer()) && this.modelClass.equals(object.modelClass())) {
                if (this.model.equals(object.model())) {
                    if (this.availableProcessors == object.availableProcessors()) {
                        if (Long.compare(availableProcessors2, diskSpace) == 0) {
                            if (Long.compare(availableProcessors2, diskSpace) == 0) {
                                if (this.isEmulator == object.isEmulator()) {
                                    if (this.state == object.state()) {
                                        if (this.manufacturer.equals(object.manufacturer())) {
                                            if (this.modelClass.equals(object.modelClass())) {
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

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public int hashCode() {
        int i;
        int i19 = 1000003;
        long totalRam = this.totalRam;
        int i27 = 32;
        long diskSpace = this.diskSpace;
        i = this.isEmulator ? 1231 : 1237;
        return i17 ^= i20;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public boolean isEmulator() {
        return this.isEmulator;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public String manufacturer() {
        return this.manufacturer;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public String model() {
        return this.model;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public String modelClass() {
        return this.modelClass;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public int state() {
        return this.state;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeviceData{arch=");
        stringBuilder.append(this.arch);
        stringBuilder.append(", model=");
        stringBuilder.append(this.model);
        stringBuilder.append(", availableProcessors=");
        stringBuilder.append(this.availableProcessors);
        stringBuilder.append(", totalRam=");
        stringBuilder.append(this.totalRam);
        stringBuilder.append(", diskSpace=");
        stringBuilder.append(this.diskSpace);
        stringBuilder.append(", isEmulator=");
        stringBuilder.append(this.isEmulator);
        stringBuilder.append(", state=");
        stringBuilder.append(this.state);
        stringBuilder.append(", manufacturer=");
        stringBuilder.append(this.manufacturer);
        stringBuilder.append(", modelClass=");
        stringBuilder.append(this.modelClass);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$DeviceData
    public long totalRam() {
        return this.totalRam;
    }
}
