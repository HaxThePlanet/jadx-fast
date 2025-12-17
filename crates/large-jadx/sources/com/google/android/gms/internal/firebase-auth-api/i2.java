package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public abstract class i2<PrimitiveT, KeyT>  {

    private final Class<PrimitiveT> a;
    public i2(Class<PrimitiveT> class) {
        super();
        this.a = class;
    }

    final Class<PrimitiveT> a() {
        return this.a;
    }

    public abstract PrimitiveT b(KeyT keyt);
}
