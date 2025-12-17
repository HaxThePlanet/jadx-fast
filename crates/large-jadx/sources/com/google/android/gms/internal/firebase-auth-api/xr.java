package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class xr<MessageType extends com.google.android.gms.internal.firebase-auth-api.xr<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.firebase-auth-api.ur<MessageType, BuilderType>>  extends com.google.android.gms.internal.firebase-auth-api.jq<MessageType, BuilderType> {

    private static final Map<Object, com.google.android.gms.internal.firebase-auth-api.xr<?, ?>> zzb;
    protected com.google.android.gms.internal.firebase-auth-api.a1 zzc;
    protected int zzd = -1;
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        xr.zzb = concurrentHashMap;
    }

    public xr() {
        super();
        this.zzc = a1.c();
        int i = -1;
    }

    protected static <E> com.google.android.gms.internal.firebase-auth-api.d<E> d(com.google.android.gms.internal.firebase-auth-api.d<E> d) {
        int i;
        int size = d.size();
        i = size == 0 ? 10 : size + size;
        return d.f(i);
    }

    static Object e(Method method, Object object2, Object... object3Arr3) {
        try {
            return method.invoke(object2, object3Arr3);
            method = method.getCause();
            object2 = method instanceof RuntimeException;
            object2 = method instanceof Error;
            if (object2 != null) {
            }
            throw (Error)method;
        }
        throw (RuntimeException)method;
    }

    protected static Object f(com.google.android.gms.internal.firebase-auth-api.y y, String string2, Object[] object3Arr3) {
        j0 j0Var = new j0(y, string2, object3Arr3);
        return j0Var;
    }

    protected static <T extends com.google.android.gms.internal.firebase-auth-api.xr> void h(Class<T> class, T t2) {
        xr.zzb.put(class, t2);
    }

    private static <T extends com.google.android.gms.internal.firebase-auth-api.xr<T, ?>> T m(T t) {
        boolean z;
        if (t != null) {
            if (!t.j()) {
            } else {
            }
            zzaby zzaby = new zzaby(t);
            zzaae zzaae = new zzaae(zzaby.getMessage());
            zzaae.h(t);
            throw zzaae;
        }
        return t;
    }

    static <T extends com.google.android.gms.internal.firebase-auth-api.xr> T u(Class<T> class) {
        Object obj;
        int i;
        java.lang.ClassLoader classLoader;
        final Map zzb = xr.zzb;
        if ((xr)zzb.get(class) == null) {
            Class.forName(class.getName(), true, class.getClassLoader());
            obj = zzb.get(class);
        }
        if (obj == null) {
            classLoader = 0;
            obj = (xr)j1.j(class).q(6, classLoader, classLoader);
            if ((xr)obj == null) {
            } else {
                zzb.put(class, (xr)obj);
            }
            IllegalStateException obj4 = new IllegalStateException();
            throw obj4;
        }
        return obj;
    }

    protected static <T extends com.google.android.gms.internal.firebase-auth-api.xr<T, ?>> T v(T t, com.google.android.gms.internal.firebase-auth-api.wq wq2, com.google.android.gms.internal.firebase-auth-api.lr lr3) {
        try {
            final com.google.android.gms.internal.firebase-auth-api.zq obj3 = wq2.m();
            int i2 = 0;
            final Object obj2 = t.q(4, i2, i2);
            com.google.android.gms.internal.firebase-auth-api.l0 l0Var = h0.a().b((xr)obj2.getClass());
            l0Var.h(obj2, ar.N(obj3), lr3);
            l0Var.c(obj2);
            obj3.g(0);
            xr.m(obj2);
            return obj2;
            wq2.h(t);
            throw wq2;
            wq2 = t.getCause();
            wq2 = wq2 instanceof zzaae;
            if (wq2 != null) {
            }
            t = t.getCause();
            throw (zzaae)t;
            throw t;
            lr3 = wq2.getCause();
            lr3 = lr3 instanceof zzaae;
            if (lr3 != null) {
            }
            t = wq2.getCause();
            throw (zzaae)t;
            lr3 = new zzaae(wq2);
            lr3.h(t);
            throw lr3;
            wq2.h(t);
            throw wq2;
            throw t;
        } catch (com.google.android.gms.internal.firebase-auth-api.zzaae e) {
        } catch (java.io.IOException ioException1) {
        } catch (RuntimeException e2) {
        }
    }

    protected static <T extends com.google.android.gms.internal.firebase-auth-api.xr<T, ?>> T w(T t, byte[] b2Arr2, com.google.android.gms.internal.firebase-auth-api.lr lr3) {
        final com.google.android.gms.internal.firebase-auth-api.xr obj2 = xr.x(t, b2Arr2, 0, b2Arr2.length, lr3);
        xr.m(obj2);
        return obj2;
    }

    static <T extends com.google.android.gms.internal.firebase-auth-api.xr<T, ?>> T x(T t, byte[] b2Arr2, int i3, int i4, com.google.android.gms.internal.firebase-auth-api.lr lr5) {
        int i = 0;
        final Object obj6 = t.q(4, i, i);
        com.google.android.gms.internal.firebase-auth-api.l0 obj8 = h0.a().b((xr)obj6.getClass());
        mq mqVar = new mq(lr5);
        obj8.i(obj6, b2Arr2, 0, i4, mqVar);
        obj8.c(obj6);
        if (obj6.zza != 0) {
        } else {
            return obj6;
        }
        RuntimeException obj7 = new RuntimeException();
        throw obj7;
    }

    protected static <E> com.google.android.gms.internal.firebase-auth-api.d<E> y() {
        return i0.d();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    final int a() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    final void b(int i) {
        this.zzd = i;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    public final boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        int i = 0;
        if (object == null) {
            return i;
        }
        if (getClass() != object.getClass()) {
            return i;
        }
        return h0.a().b(getClass()).j(this, (xr)object);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    public final int hashCode() {
        int zza = this.zza;
        if (zza != 0) {
            return zza;
        }
        int i = h0.a().b(getClass()).b(this);
        this.zza = i;
        return i;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    public final boolean j() {
        Object obj;
        int i;
        i = 1;
        final int i2 = 0;
        byte byteValue = (Byte)q(i, i2, i2).byteValue();
        if (byteValue == i) {
            return i;
        } else {
            if (byteValue == 0) {
                i = 0;
            }
        }
        boolean z = h0.a().b(getClass()).g(this);
        obj = i != z ? i2 : this;
        q(2, obj, i2);
        return z;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    public final com.google.android.gms.internal.firebase-auth-api.x l() {
        final int i2 = 0;
        return (ur)q(5, i2, i2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    public final com.google.android.gms.internal.firebase-auth-api.x n() {
        final int i2 = 0;
        Object obj = q(5, i2, i2);
        (ur)obj.d(this);
        return obj;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    public final int o() {
        int zzd;
        int class;
        if (this.zzd == -1) {
            this.zzd = h0.a().b(getClass()).d(this);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    public final com.google.android.gms.internal.firebase-auth-api.y p() {
        final int i2 = 0;
        return (xr)q(6, i2, i2);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    protected abstract Object q(int i, Object object2, Object object3);

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    public final void r(com.google.android.gms.internal.firebase-auth-api.gr gr) {
        h0.a().b(getClass()).f(this, hr.l(gr));
    }

    protected final <MessageType extends com.google.android.gms.internal.firebase-auth-api.xr<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.firebase-auth-api.ur<MessageType, BuilderType>> BuilderType s() {
        final int i2 = 0;
        return (ur)q(5, i2, i2);
    }

    public final BuilderType t() {
        final int i2 = 0;
        Object obj = q(5, i2, i2);
        (ur)obj.d(this);
        return obj;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.jq
    public final String toString() {
        return b0.a(this, super.toString());
    }
}
