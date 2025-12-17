package com.google.android.gms.internal.measurement;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class w8<MessageType extends com.google.android.gms.internal.measurement.w8<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.measurement.t8<MessageType, BuilderType>>  extends com.google.android.gms.internal.measurement.k7<MessageType, BuilderType> {

    private static final Map<Object, com.google.android.gms.internal.measurement.w8<?, ?>> zza;
    protected com.google.android.gms.internal.measurement.ya zzc;
    protected int zzd = -1;
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        w8.zza = concurrentHashMap;
    }

    public w8() {
        super();
        this.zzc = ya.c();
        int i = -1;
    }

    protected static <E> com.google.android.gms.internal.measurement.c9<E> k() {
        return ha.d();
    }

    protected static <E> com.google.android.gms.internal.measurement.c9<E> l(com.google.android.gms.internal.measurement.c9<E> c9) {
        int i;
        int size = c9.size();
        i = size == 0 ? 10 : size + size;
        return c9.f(i);
    }

    static Object m(Method method, Object object2, Object... object3Arr3) {
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

    protected static Object n(com.google.android.gms.internal.measurement.y9 y9, String string2, Object[] object3Arr3) {
        ia iaVar = new ia(y9, string2, object3Arr3);
        return iaVar;
    }

    protected static <T extends com.google.android.gms.internal.measurement.w8> void o(Class<T> class, T t2) {
        w8.zza.put(class, t2);
    }

    static <T extends com.google.android.gms.internal.measurement.w8> T r(Class<T> class) {
        Object obj;
        int i;
        java.lang.ClassLoader classLoader;
        final Map zza = w8.zza;
        if ((w8)zza.get(class) == null) {
            Class.forName(class.getName(), true, class.getClassLoader());
            obj = zza.get(class);
        }
        if (obj == null) {
            classLoader = 0;
            obj = (w8)hb.j(class).v(6, classLoader, classLoader);
            if ((w8)obj == null) {
            } else {
                zza.put(class, (w8)obj);
            }
            IllegalStateException obj4 = new IllegalStateException();
            throw obj4;
        }
        return obj;
    }

    protected static com.google.android.gms.internal.measurement.a9 s() {
        return x8.g();
    }

    protected static com.google.android.gms.internal.measurement.b9 t() {
        return m9.d();
    }

    protected static com.google.android.gms.internal.measurement.b9 u(com.google.android.gms.internal.measurement.b9 b9) {
        int i;
        int size = b9.size();
        i = size == 0 ? 10 : size + size;
        return b9.K(i);
    }

    @Override // com.google.android.gms.internal.measurement.k7
    public final void a(com.google.android.gms.internal.measurement.e8 e8) {
        ga.a().b(getClass()).i(this, f8.l(e8));
    }

    @Override // com.google.android.gms.internal.measurement.k7
    public final int b() {
        int zzd;
        int class;
        if (this.zzd == -1) {
            this.zzd = ga.a().b(getClass()).d(this);
        }
        return zzd;
    }

    @Override // com.google.android.gms.internal.measurement.k7
    public final com.google.android.gms.internal.measurement.x9 c() {
        final int i2 = 0;
        Object obj = v(5, i2, i2);
        (t8)obj.p(this);
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.k7
    public final com.google.android.gms.internal.measurement.y9 e() {
        final int i2 = 0;
        return (w8)v(6, i2, i2);
    }

    @Override // com.google.android.gms.internal.measurement.k7
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
        return ga.a().b(getClass()).h(this, (w8)object);
    }

    @Override // com.google.android.gms.internal.measurement.k7
    public final com.google.android.gms.internal.measurement.x9 f() {
        final int i2 = 0;
        return (t8)v(5, i2, i2);
    }

    @Override // com.google.android.gms.internal.measurement.k7
    final int g() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.k7
    public final int hashCode() {
        int zzb = this.zzb;
        if (zzb != 0) {
            return zzb;
        }
        int i = ga.a().b(getClass()).b(this);
        this.zzb = i;
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.k7
    final void i(int i) {
        this.zzd = i;
    }

    protected final <MessageType extends com.google.android.gms.internal.measurement.w8<MessageType, BuilderType>, BuilderType extends com.google.android.gms.internal.measurement.t8<MessageType, BuilderType>> BuilderType p() {
        final int i2 = 0;
        return (t8)v(5, i2, i2);
    }

    public final BuilderType q() {
        final int i2 = 0;
        Object obj = v(5, i2, i2);
        (t8)obj.p(this);
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.k7
    public final String toString() {
        return aa.a(this, super.toString());
    }

    @Override // com.google.android.gms.internal.measurement.k7
    protected abstract Object v(int i, Object object2, Object object3);
}
