package d.f.a;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
class g<T> implements f<T> {

    private final Object[] a;
    private int b;
    g(int i) {
        super();
        if (i <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        } else {
            this.a = new Object[i];
            return;
        }
    }

    public boolean a(T t) {
        if (this.b < objArr.length) {
            this.a[this.b] = t;
            int i3 = 1;
            this.b += i3;
            return true;
        }
        return false;
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

    public void c(T[] tArr, int i) {
        int i3;
        int length2;
        if (i > tArr.length) {
            length2 = tArr.length;
        }
        i = 0;
        for (Object obj : tArr) {
            length = objArr.length;
        }
    }
}
