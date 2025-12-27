package d.h.k;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class g<T> implements f<T> {

    private final Object[] a;
    private int b;
    public g(int i) {
        super();
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        } else {
            this.a = new Object[i];
            return;
        }
    }

    private boolean c(T t) {
        int i;
        i = 0;
        while (i < this.b) {
            if (this.a[i] == t) {
                return true;
            }
        }
        return false;
    }

    public boolean a(T t) {
        if (c(t)) {
            throw new IllegalStateException("Already in the pool!");
        } else {
            if (this.b < objArr.length) {
                this.a[this.b] = t;
                int i4 = 1;
                this.b += i4;
                return true;
            }
            return false;
        }
    }

    public T b() {
        final Object obj = null;
        if (this.b > 0) {
            final int i3 = i - 1;
            this.a[i3] = obj;
            this.b--;
            return objArr[i3];
        }
        return obj;
    }
}
