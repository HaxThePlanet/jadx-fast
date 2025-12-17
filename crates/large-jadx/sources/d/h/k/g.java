package d.h.k;

/* loaded from: classes.dex */
public class g<T>  implements d.h.k.f<T> {

    private final Object[] a;
    private int b;
    public g(int i) {
        super();
        if (i <= 0) {
        } else {
            this.a = new Object[i];
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("The max pool size must be > 0");
        throw obj2;
    }

    private boolean c(T t) {
        int i;
        Object obj;
        final int i2 = 0;
        i = i2;
        while (i < this.b) {
            i++;
        }
        return i2;
    }

    public boolean a(T t) {
        if (c(t)) {
        } else {
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
        obj4 = new IllegalStateException("Already in the pool!");
        throw obj4;
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
}
