package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class za extends com.google.android.gms.internal.measurement.xa<com.google.android.gms.internal.measurement.ya, com.google.android.gms.internal.measurement.ya> {
    @Override // com.google.android.gms.internal.measurement.xa
    final int a(Object object) {
        return (ya)object.a();
    }

    @Override // com.google.android.gms.internal.measurement.xa
    final int b(Object object) {
        return (ya)object.b();
    }

    @Override // com.google.android.gms.internal.measurement.xa
    final Object c(Object object) {
        return object.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.xa
    final Object d(Object object, Object object2) {
        if ((ya)object2.equals(ya.c())) {
            return object;
        }
        return ya.d((ya)object, object2);
    }

    @Override // com.google.android.gms.internal.measurement.xa
    final Object e() {
        return ya.e();
    }

    @Override // com.google.android.gms.internal.measurement.xa
    final void f(Object object, int i2, long l3) {
        (ya)object.h(i2 <<= 3, Long.valueOf(l3));
    }

    @Override // com.google.android.gms.internal.measurement.xa
    final void g(Object object) {
        object.zzc.f();
    }

    @Override // com.google.android.gms.internal.measurement.xa
    final void h(Object object, Object object2) {
        object.zzc = (ya)object2;
    }

    @Override // com.google.android.gms.internal.measurement.xa
    final void i(Object object, com.google.android.gms.internal.measurement.f8 f82) {
        (ya)object.i(f82);
    }
}
