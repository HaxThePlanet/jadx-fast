package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_StaticSessionData extends com.google.firebase.crashlytics.internal.model.StaticSessionData {

    private final com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData appData;
    private final com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData deviceData;
    private final com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData osData;
    AutoValue_StaticSessionData(com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData staticSessionData$AppData, com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData staticSessionData$OsData2, com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData staticSessionData$DeviceData3) {
        super();
        Objects.requireNonNull(appData, "Null appData");
        this.appData = appData;
        Objects.requireNonNull(osData2, "Null osData");
        this.osData = osData2;
        Objects.requireNonNull(deviceData3, "Null deviceData");
        this.deviceData = deviceData3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData appData() {
        return this.appData;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData deviceData() {
        return this.deviceData;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public boolean equals(Object object) {
        int i;
        boolean deviceData;
        Object appData;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof StaticSessionData != null) {
            if (this.appData.equals((StaticSessionData)object.appData()) && this.osData.equals(object.osData()) && this.deviceData.equals(object.deviceData())) {
                if (this.osData.equals(object.osData())) {
                    if (this.deviceData.equals(object.deviceData())) {
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

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public int hashCode() {
        int i7 = 1000003;
        return i5 ^= i8;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData osData() {
        return this.osData;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StaticSessionData{appData=");
        stringBuilder.append(this.appData);
        stringBuilder.append(", osData=");
        stringBuilder.append(this.osData);
        stringBuilder.append(", deviceData=");
        stringBuilder.append(this.deviceData);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
