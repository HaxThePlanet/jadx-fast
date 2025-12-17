package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class FiamWindowManager_Factory implements Factory<com.google.firebase.inappmessaging.display.internal.FiamWindowManager> {

    private static final class InstanceHolder {

        private static final com.google.firebase.inappmessaging.display.internal.FiamWindowManager_Factory INSTANCE;
        static {
            FiamWindowManager_Factory fiamWindowManager_Factory = new FiamWindowManager_Factory();
            FiamWindowManager_Factory.InstanceHolder.INSTANCE = fiamWindowManager_Factory;
        }

        static com.google.firebase.inappmessaging.display.internal.FiamWindowManager_Factory access$000() {
            return FiamWindowManager_Factory.InstanceHolder.INSTANCE;
        }
    }
    public static com.google.firebase.inappmessaging.display.internal.FiamWindowManager_Factory create() {
        return FiamWindowManager_Factory.InstanceHolder.access$000();
    }

    public static com.google.firebase.inappmessaging.display.internal.FiamWindowManager newInstance() {
        FiamWindowManager fiamWindowManager = new FiamWindowManager();
        return fiamWindowManager;
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public com.google.firebase.inappmessaging.display.internal.FiamWindowManager get() {
        return FiamWindowManager_Factory.newInstance();
    }

    @Override // com.google.firebase.inappmessaging.display.dagger.internal.Factory
    public Object get() {
        return get();
    }
}
