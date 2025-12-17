package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public final class j<L>  {

    private volatile L a;

    public static final class a {

        private final L a;
        private final String b;
        public boolean equals(Object object) {
            Object obj;
            Object obj5;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof j.a) {
                return i2;
            }
            if (this.a == object.a && this.b.equals(object.b)) {
                if (this.b.equals(object.b)) {
                    return i;
                }
            }
            return i2;
        }

        public int hashCode() {
            return i += i3;
        }
    }

    public interface b {
        public abstract void a(L l);

        public abstract void b();
    }
    j(Looper looper, L l2, String string3) {
        super();
        p0 p0Var = new p0(this, looper);
        r.k(l2, "Listener must not be null");
        this.a = l2;
        r.f(string3);
    }

    void a(com.google.android.gms.common.api.internal.j.b<? super L> j$b) {
        final Object obj = this.a;
        if (obj == null) {
            b.b();
        }
        b.a(obj);
    }
}
