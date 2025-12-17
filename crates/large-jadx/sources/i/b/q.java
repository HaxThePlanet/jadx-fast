package i.b;

import i.b.m0.b.b;
import i.b.m0.j.n;

/* loaded from: classes3.dex */
public final class q<T>  {

    static final i.b.q<Object> b;
    final Object a;
    static {
        q qVar = new q(0);
        q.b = qVar;
    }

    private q(Object object) {
        super();
        this.a = object;
    }

    public static <T> i.b.q<T> a() {
        return q.b;
    }

    public static <T> i.b.q<T> b(Throwable throwable) {
        b.e(throwable, "error is null");
        q qVar = new q(n.error(throwable));
        return qVar;
    }

    public static <T> i.b.q<T> c(T t) {
        b.e(t, "value is null");
        q qVar = new q(t);
        return qVar;
    }

    public Throwable d() {
        Object obj = this.a;
        if (n.isError(obj)) {
            return n.getError(obj);
        }
        return null;
    }

    public T e() {
        Object error;
        error = this.a;
        if (error != null && !n.isError(error)) {
            if (!n.isError(error)) {
                return this.a;
            }
        }
        return 0;
    }

    public boolean equals(Object object) {
        if (object instanceof q) {
            return b.c(this.a, object.a);
        }
        return 0;
    }

    public boolean f() {
        int i;
        i = this.a == null ? 1 : 0;
        return i;
    }

    public boolean g() {
        return n.isError(this.a);
    }

    public boolean h() {
        Object error;
        int i;
        error = this.a;
        if (error != null && !n.isError(error)) {
            i = !n.isError(error) ? 1 : 0;
        } else {
        }
        return i;
    }

    public int hashCode() {
        int i;
        Object obj = this.a;
        if (obj != null) {
            i = obj.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public String toString() {
        Object obj = this.a;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        final String str3 = "]";
        if (n.isError(obj)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("OnErrorNotification[");
            stringBuilder2.append(n.getError(obj));
            stringBuilder2.append(str3);
            return stringBuilder2.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OnNextNotification[");
        stringBuilder.append(this.a);
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }
}
