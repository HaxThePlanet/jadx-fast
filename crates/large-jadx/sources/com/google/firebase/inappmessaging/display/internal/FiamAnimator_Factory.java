package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class FiamAnimator_Factory implements Factory<com.google.firebase.inappmessaging.display.internal.FiamAnimator> {

    private static final class InstanceHolder {

        private static final com.google.firebase.inappmessaging.display.internal.FiamAnimator_Factory INSTANCE;
        static {
            FiamAnimator_Factory fiamAnimator_Factory = new FiamAnimator_Factory();
            FiamAnimator_Factory.InstanceHolder.INSTANCE = fiamAnimator_Factory;
        }

        static com.google.firebase.inappmessaging.display.internal.FiamAnimator_Factory access$000() {
            return FiamAnimator_Factory.InstanceHolder.INSTANCE;
        }
    }
    public static com.google.firebase.inappmessaging.display.internal.FiamAnimator_Factory create() {
        return FiamAnimator_Factory.InstanceHolder.access$000();
    }

    public static com.google.firebase.inappmessaging.display.internal.FiamAnimator newInstance() {
        FiamAnimator fiamAnimator = new FiamAnimator();
        return fiamAnimator;
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public com.google.firebase.inappmessaging.display.internal.FiamAnimator get() {
        return FiamAnimator_Factory.newInstance();
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
