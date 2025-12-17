package com.google.firebase.crashlytics.internal.model;

/* loaded from: classes2.dex */
public abstract class StaticSessionData {

    public static abstract class AppData {
        public static com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData create(String string, String string2, String string3, String string4, int i5, String string6) {
            super(string, string2, string3, string4, i5, string6);
            return autoValue_StaticSessionData_AppData2;
        }

        public abstract String appIdentifier();

        public abstract int deliveryMechanism();

        public abstract String installUuid();

        public abstract String unityVersion();

        public abstract String versionCode();

        public abstract String versionName();
    }

    public static abstract class DeviceData {
        public static com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData create(int i, String string2, int i3, long l4, long l5, boolean z6, int i7, String string8, String string9) {
            super(i, string2, i3, l4, obj5, z6, obj7, string8, string9, obj22, obj23);
            return autoValue_StaticSessionData_DeviceData2;
        }

        public abstract int arch();

        public abstract int availableProcessors();

        public abstract long diskSpace();

        public abstract boolean isEmulator();

        public abstract String manufacturer();

        public abstract String model();

        public abstract String modelClass();

        public abstract int state();

        public abstract long totalRam();
    }

    public static abstract class OsData {
        public static com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData create(String string, String string2, boolean z3) {
            AutoValue_StaticSessionData_OsData autoValue_StaticSessionData_OsData = new AutoValue_StaticSessionData_OsData(string, string2, z3);
            return autoValue_StaticSessionData_OsData;
        }

        public abstract boolean isRooted();

        public abstract String osCodeName();

        public abstract String osRelease();
    }
    public static com.google.firebase.crashlytics.internal.model.StaticSessionData create(com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData staticSessionData$AppData, com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData staticSessionData$OsData2, com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData staticSessionData$DeviceData3) {
        AutoValue_StaticSessionData autoValue_StaticSessionData = new AutoValue_StaticSessionData(appData, osData2, deviceData3);
        return autoValue_StaticSessionData;
    }

    public abstract com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData appData();

    public abstract com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData deviceData();

    public abstract com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData osData();
}
