package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class RenewableTimer_Factory implements Factory<com.google.firebase.inappmessaging.display.internal.RenewableTimer> {

    private static final class InstanceHolder {

        private static final com.google.firebase.inappmessaging.display.internal.RenewableTimer_Factory INSTANCE;
        static {
            RenewableTimer_Factory renewableTimer_Factory = new RenewableTimer_Factory();
            RenewableTimer_Factory.InstanceHolder.INSTANCE = renewableTimer_Factory;
        }

        static com.google.firebase.inappmessaging.display.internal.RenewableTimer_Factory access$000() {
            return RenewableTimer_Factory.InstanceHolder.INSTANCE;
        }
    }
    public static com.google.firebase.inappmessaging.display.internal.RenewableTimer_Factory create() {
        return RenewableTimer_Factory.InstanceHolder.access$000();
    }

    public static com.google.firebase.inappmessaging.display.internal.RenewableTimer newInstance() {
        RenewableTimer renewableTimer = new RenewableTimer();
        return renewableTimer;
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public com.google.firebase.inappmessaging.display.internal.RenewableTimer get() {
        return RenewableTimer_Factory.newInstance();
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
