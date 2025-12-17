package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_StaticSessionData_AppData extends com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData {

    private final String appIdentifier;
    private final int deliveryMechanism;
    private final String installUuid;
    private final String unityVersion;
    private final String versionCode;
    private final String versionName;
    AutoValue_StaticSessionData_AppData(String string, String string2, String string3, String string4, int i5, String string6) {
        super();
        Objects.requireNonNull(string, "Null appIdentifier");
        this.appIdentifier = string;
        Objects.requireNonNull(string2, "Null versionCode");
        this.versionCode = string2;
        Objects.requireNonNull(string3, "Null versionName");
        this.versionName = string3;
        Objects.requireNonNull(string4, "Null installUuid");
        this.installUuid = string4;
        this.deliveryMechanism = i5;
        this.unityVersion = string6;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$AppData
    public String appIdentifier() {
        return this.appIdentifier;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$AppData
    public int deliveryMechanism() {
        return this.deliveryMechanism;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$AppData
    public boolean equals(Object object) {
        int i;
        String deliveryMechanism;
        int deliveryMechanism2;
        boolean obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof StaticSessionData.AppData != null) {
            if (this.appIdentifier.equals((StaticSessionData.AppData)object.appIdentifier()) && this.versionCode.equals(object.versionCode()) && this.versionName.equals(object.versionName()) && this.installUuid.equals(object.installUuid()) && this.deliveryMechanism == object.deliveryMechanism()) {
                if (this.versionCode.equals(object.versionCode())) {
                    if (this.versionName.equals(object.versionName())) {
                        if (this.installUuid.equals(object.installUuid())) {
                            if (this.deliveryMechanism == object.deliveryMechanism()) {
                                deliveryMechanism = this.unityVersion;
                                if (deliveryMechanism == null) {
                                    if (object.unityVersion() == null) {
                                    } else {
                                        i = i2;
                                    }
                                } else {
                                    if (deliveryMechanism.equals(object.unityVersion())) {
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
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$AppData
    public int hashCode() {
        int i;
        int i14 = 1000003;
        String unityVersion = this.unityVersion;
        if (unityVersion == null) {
            i = 0;
        } else {
            i = unityVersion.hashCode();
        }
        return i12 ^= i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$AppData
    public String installUuid() {
        return this.installUuid;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$AppData
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AppData{appIdentifier=");
        stringBuilder.append(this.appIdentifier);
        stringBuilder.append(", versionCode=");
        stringBuilder.append(this.versionCode);
        stringBuilder.append(", versionName=");
        stringBuilder.append(this.versionName);
        stringBuilder.append(", installUuid=");
        stringBuilder.append(this.installUuid);
        stringBuilder.append(", deliveryMechanism=");
        stringBuilder.append(this.deliveryMechanism);
        stringBuilder.append(", unityVersion=");
        stringBuilder.append(this.unityVersion);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$AppData
    public String unityVersion() {
        return this.unityVersion;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$AppData
    public String versionCode() {
        return this.versionCode;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$AppData
    public String versionName() {
        return this.versionName;
    }
}
