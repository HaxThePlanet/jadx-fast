package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public abstract class j2<KeyProtoT extends com.google.android.gms.internal.firebase-auth-api.y>  {

    private final Class<KeyProtoT> a;
    private final Map<Class<?>, com.google.android.gms.internal.firebase-auth-api.i2<?, KeyProtoT>> b;
    private final Class<?> c;
    @SafeVarargs
    protected j2(Class<KeyProtoT> class, com.google.android.gms.internal.firebase-auth-api.i2<?, KeyProtoT>... i22Arr2) {
        int i;
        Object obj;
        Class cls;
        String obj6;
        super();
        this.a = class;
        HashMap obj5 = new HashMap();
        int i2 = 0;
        i = i2;
        while (i <= 0) {
            obj = i22Arr2[i];
            obj5.put(obj.a(), obj);
            i++;
        }
        this.c = i22Arr2[i2].a();
        this.b = Collections.unmodifiableMap(obj5);
    }

    public com.google.android.gms.internal.firebase-auth-api.h2<?, KeyProtoT> a() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Creating keys is not supported.");
        throw unsupportedOperationException;
    }

    public abstract com.google.android.gms.internal.firebase-auth-api.z9 b();

    public abstract KeyProtoT c(com.google.android.gms.internal.firebase-auth-api.wq wq);

    final Class<?> d() {
        return this.c;
    }

    public final Class<KeyProtoT> e() {
        return this.a;
    }

    public final <P> P f(KeyProtoT keyprotot, Class<P> class2) {
        Object obj = this.b.get(class2);
        if ((i2)obj == null) {
        } else {
            return (i2)obj.b(keyprotot);
        }
        String obj4 = class2.getCanonicalName();
        StringBuilder stringBuilder = new StringBuilder(length += 41);
        stringBuilder.append("Requested primitive class ");
        stringBuilder.append(obj4);
        stringBuilder.append(" not supported.");
        IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    public abstract String g();

    public final Set<Class<?>> h() {
        return this.b.keySet();
    }

    public abstract void i(KeyProtoT keyprotot);
}
