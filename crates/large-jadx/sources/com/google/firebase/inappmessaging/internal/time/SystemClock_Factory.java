package com.google.firebase.inappmessaging.internal.time;

import com.google.firebase.inappmessaging.dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class SystemClock_Factory implements Factory<com.google.firebase.inappmessaging.internal.time.SystemClock> {

    private static final class InstanceHolder {

        private static final com.google.firebase.inappmessaging.internal.time.SystemClock_Factory INSTANCE;
        static {
            SystemClock_Factory systemClock_Factory = new SystemClock_Factory();
            SystemClock_Factory.InstanceHolder.INSTANCE = systemClock_Factory;
        }

        static com.google.firebase.inappmessaging.internal.time.SystemClock_Factory access$000() {
            return SystemClock_Factory.InstanceHolder.INSTANCE;
        }
    }
    public static com.google.firebase.inappmessaging.internal.time.SystemClock_Factory create() {
        return SystemClock_Factory.InstanceHolder.access$000();
    }

    public static com.google.firebase.inappmessaging.internal.time.SystemClock newInstance() {
        SystemClock systemClock = new SystemClock();
        return systemClock;
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public com.google.firebase.inappmessaging.internal.time.SystemClock get() {
        return SystemClock_Factory.newInstance();
    }

    @Override // com.google.firebase.inappmessaging.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
