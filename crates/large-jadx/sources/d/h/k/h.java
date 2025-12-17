package d.h.k;

/* loaded from: classes.dex */
public class h<T>  extends d.h.k.g<T> {

    private final Object c;
    public h(int i) {
        super(i);
        Object obj1 = new Object();
        this.c = obj1;
    }

    public boolean a(T t) {
        final Object obj = this.c;
        return super.a(t);
        synchronized (obj) {
            obj = this.c;
            return super.a(t);
        }
    }

    public T b() {
        final Object obj = this.c;
        return super.b();
        synchronized (obj) {
            obj = this.c;
            return super.b();
        }
    }
}
