package com.google.firebase.crashlytics.internal.model;

import java.util.Objects;

/* loaded from: classes2.dex */
final class AutoValue_StaticSessionData_OsData extends com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData {

    private final boolean isRooted;
    private final String osCodeName;
    private final String osRelease;
    AutoValue_StaticSessionData_OsData(String string, String string2, boolean z3) {
        super();
        Objects.requireNonNull(string, "Null osRelease");
        this.osRelease = string;
        Objects.requireNonNull(string2, "Null osCodeName");
        this.osCodeName = string2;
        this.isRooted = z3;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$OsData
    public boolean equals(Object object) {
        int i;
        boolean isRooted;
        String osCodeName;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof StaticSessionData.OsData != null) {
            if (this.osRelease.equals((StaticSessionData.OsData)object.osRelease()) && this.osCodeName.equals(object.osCodeName()) && this.isRooted == object.isRooted()) {
                if (this.osCodeName.equals(object.osCodeName())) {
                    if (this.isRooted == object.isRooted()) {
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

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$OsData
    public int hashCode() {
        int i;
        int i8 = 1000003;
        i = this.isRooted ? 1231 : 1237;
        return i6 ^= i;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$OsData
    public boolean isRooted() {
        return this.isRooted;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$OsData
    public String osCodeName() {
        return this.osCodeName;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$OsData
    public String osRelease() {
        return this.osRelease;
    }

    @Override // com.google.firebase.crashlytics.internal.model.StaticSessionData$OsData
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OsData{osRelease=");
        stringBuilder.append(this.osRelease);
        stringBuilder.append(", osCodeName=");
        stringBuilder.append(this.osCodeName);
        stringBuilder.append(", isRooted=");
        stringBuilder.append(this.isRooted);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
