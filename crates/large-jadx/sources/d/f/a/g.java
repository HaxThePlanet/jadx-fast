package d.f.a;

/* loaded from: classes.dex */
class g<T>  implements d.f.a.f<T> {

    private final Object[] a;
    private int b;
    g(int i) {
        super();
        if (i <= 0) {
        } else {
            this.a = new Object[i];
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("The max pool size must be > 0");
        throw obj2;
    }

    public boolean a(T t) {
        int i = this.b;
        final Object[] objArr = this.a;
        if (i < objArr.length) {
            objArr[i] = t;
            int obj4 = 1;
            this.b = i += obj4;
            return obj4;
        }
        return 0;
    }

    public T b() {
        int i = this.b;
        final int i3 = 0;
        if (i > 0) {
            final int i4 = i + -1;
            final Object[] objArr = this.a;
            objArr[i4] = i3;
            this.b = i--;
            return objArr[i4];
        }
        return i3;
    }

    public void c(T[] tArr, int i2) {
        int i;
        Object obj;
        int i3;
        Object[] objArr;
        int length;
        int obj7;
        if (i2 > tArr.length) {
            obj7 = tArr.length;
        }
        i = 0;
        while (i < obj7) {
            i3 = this.b;
            objArr = this.a;
            if (i3 < objArr.length) {
            }
            i++;
            objArr[i3] = tArr[i];
            this.b = i3++;
        }
    }
}
