package i.b;

import i.b.m0.b.b;
import i.b.m0.j.n;

/* compiled from: Notification.java */
/* loaded from: classes3.dex */
public final class q<T> {

    static final q<Object> b = new q<>(0);
    final Object a;

    private q(Object object) {
        super();
        this.a = object;
    }

    public static <T> q<T> a() {
        return q.b;
    }

    public static <T> q<T> b(Throwable th) {
        b.e(th, "error is null");
        return new q(n.error(th));
    }

    public static <T> q<T> c(T t) {
        b.e(t, "value is null");
        return new q(t);
    }

    public Throwable d() {
        if (n.isError(this.a)) {
            return n.getError(this.a);
        }
        return null;
    }

    public T e() {
        if (this.a != null && !n.isError(this.a)) {
            return this.a;
        }
        return null;
    }

    public boolean equals(Object object) {
        if (object instanceof q) {
            return b.c(this.a, object.a);
        }
        return false;
    }

    public boolean f() {
        boolean z = true;
        int r0 = this.a == null ? 1 : 0;
        return (this.a == null ? 1 : 0);
    }

    public boolean g() {
        return n.isError(this.a);
    }

    public boolean h() {
        boolean z = false;
        int r0 = this.a != null && !n.isError(this.a) ? 1 : 0;
        return (this.a != null && !n.isError(this.a) ? 1 : 0);
    }

    public int hashCode() {
        int i = 0;
        if (this.a != null) {
            i = this.a.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public String toString() {
        if (this.a == null) {
            return "OnCompleteNotification";
        }
        final String str5 = "]";
        if (n.isError(this.a)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            final String str6 = "OnErrorNotification[";
            Throwable error = n.getError(this.a);
            str2 = str6 + error + str5;
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str4 = "OnNextNotification[";
        str3 = str4 + this.a + str5;
        return str3;
    }
}
