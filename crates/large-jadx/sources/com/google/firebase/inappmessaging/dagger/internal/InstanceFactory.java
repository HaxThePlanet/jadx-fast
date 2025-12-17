package com.google.firebase.inappmessaging.dagger.internal;

import com.google.firebase.inappmessaging.dagger.Lazy;

/* loaded from: classes2.dex */
public final class InstanceFactory<T>  implements com.google.firebase.inappmessaging.dagger.internal.Factory<T>, Lazy<T> {

    private static final com.google.firebase.inappmessaging.dagger.internal.InstanceFactory<Object> NULL_INSTANCE_FACTORY;
    private final T instance;
    static {
        InstanceFactory instanceFactory = new InstanceFactory(0);
        InstanceFactory.NULL_INSTANCE_FACTORY = instanceFactory;
    }

    private InstanceFactory(T t) {
        super();
        this.instance = t;
    }

    public static <T> com.google.firebase.inappmessaging.dagger.internal.Factory<T> create(T t) {
        InstanceFactory instanceFactory = new InstanceFactory(Preconditions.checkNotNull(t, "instance cannot be null"));
        return instanceFactory;
    }

    public static <T> com.google.firebase.inappmessaging.dagger.internal.Factory<T> createNullable(T t) {
        com.google.firebase.inappmessaging.dagger.internal.InstanceFactory instanceFactory;
        com.google.firebase.inappmessaging.dagger.internal.InstanceFactory obj1;
        if (t == null) {
            obj1 = InstanceFactory.nullInstanceFactory();
        } else {
            instanceFactory = new InstanceFactory(t);
            obj1 = instanceFactory;
        }
        return obj1;
    }

    private static <T> com.google.firebase.inappmessaging.dagger.internal.InstanceFactory<T> nullInstanceFactory() {
        return InstanceFactory.NULL_INSTANCE_FACTORY;
    }

    public T get() {
        return this.instance;
    }
}
