package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
abstract class gb {

    final Unsafe a;
    gb(Unsafe unsafe) {
        super();
        this.a = unsafe;
    }

    public abstract double a(Object object, long l2);

    public abstract float b(Object object, long l2);

    public abstract void c(Object object, long l2, boolean z3);

    public abstract void d(Object object, long l2, byte b3);

    public abstract void e(Object object, long l2, double d3);

    public abstract void f(Object object, long l2, float f3);

    public abstract boolean g(Object object, long l2);

    public final int h(Class<?> class) {
        return this.a.arrayBaseOffset(class);
    }

    public final int i(Class<?> class) {
        return this.a.arrayIndexScale(class);
    }

    public final int j(Object object, long l2) {
        return this.a.getInt(object, l2);
    }

    public final long k(Object object, long l2) {
        return this.a.getLong(object, l2);
    }

    public final long l(Field field) {
        return this.a.objectFieldOffset(field);
    }

    public final Object m(Object object, long l2) {
        return this.a.getObject(object, l2);
    }

    public final void n(Object object, long l2, int i3) {
        this.a.putInt(object, l2, i3);
    }

    public final void o(Object object, long l2, long l3) {
        this.a.putLong(object, l2, obj3);
    }

    public final void p(Object object, long l2, Object object3) {
        this.a.putObject(object, l2, object3);
    }
}
