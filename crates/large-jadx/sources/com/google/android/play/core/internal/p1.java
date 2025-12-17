package com.google.android.play.core.internal;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class p1<T>  implements com.google.android.play.core.internal.r1, com.google.android.play.core.internal.n1 {

    private static final Object c;
    private volatile com.google.android.play.core.internal.r1<T> a;
    private volatile Object b;
    static {
        Object object = new Object();
        p1.c = object;
    }

    private p1(com.google.android.play.core.internal.r1<T> r1) {
        super();
        this.b = p1.c;
        this.a = r1;
    }

    public static <P extends com.google.android.play.core.internal.r1<T>, T> com.google.android.play.core.internal.n1<T> a(P p) {
        if (p instanceof n1) {
            return (n1)p;
        }
        Objects.requireNonNull(p);
        p1 p1Var = new p1(p);
        return p1Var;
    }

    public static <P extends com.google.android.play.core.internal.r1<T>, T> com.google.android.play.core.internal.r1<T> b(P p) {
        Objects.requireNonNull(p);
        if (p instanceof p1) {
            return p;
        }
        p1 p1Var = new p1(p);
        return p1Var;
    }

    public final T zza() {
        Object obj;
        Object obj2;
        Object obj3;
        obj2 = p1.c;
        obj = this.a.zza();
        obj3 = this.b;
        if (this.b == obj2 && this.b == obj2 && obj3 != obj2) {
            synchronized (this) {
                obj = this.a.zza();
                obj3 = this.b;
                if (obj3 != obj2) {
                    if (obj3 != obj) {
                    } else {
                    }
                    String valueOf2 = String.valueOf(obj3);
                    String valueOf = String.valueOf(obj);
                    StringBuilder stringBuilder = new StringBuilder(i += length2);
                    stringBuilder.append("Scoped provider was invoked recursively returning different results: ");
                    stringBuilder.append(valueOf2);
                    stringBuilder.append(" & ");
                    stringBuilder.append(valueOf);
                    stringBuilder.append(". This is likely due to a circular dependency.");
                    IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                    throw illegalStateException;
                }
                this.b = obj;
                this.a = 0;
                try {
                    throw th;
                    return obj;
                }
            }
        }
    }
}
