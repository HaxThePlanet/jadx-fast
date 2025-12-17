package com.google.android.play.core.internal;

/* loaded from: classes2.dex */
public final class o1<T>  implements com.google.android.play.core.internal.r1<T> {

    private com.google.android.play.core.internal.r1<T> a;
    public static <T> void a(com.google.android.play.core.internal.r1<T> r1, com.google.android.play.core.internal.r1<T> r12) {
        if (r1.a != null) {
        } else {
            r1.a = r12;
        }
        IllegalStateException obj1 = new IllegalStateException();
        throw obj1;
    }

    public final T zza() {
        com.google.android.play.core.internal.r1 r1Var = this.a;
        if (r1Var == null) {
        } else {
            return r1Var.zza();
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }
}
