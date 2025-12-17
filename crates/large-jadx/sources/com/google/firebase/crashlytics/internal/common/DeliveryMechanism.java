package com.google.firebase.crashlytics.internal.common;

/* loaded from: classes2.dex */
public enum DeliveryMechanism {

    DEVELOPER(true),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);

    private final int id;
    public static com.google.firebase.crashlytics.internal.common.DeliveryMechanism determineFrom(String string) {
        com.google.firebase.crashlytics.internal.common.DeliveryMechanism obj0;
        obj0 = string != null ? DeliveryMechanism.APP_STORE : DeliveryMechanism.DEVELOPER;
        return obj0;
    }

    @Override // java.lang.Enum
    public int getId() {
        return this.id;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.id);
    }
}
