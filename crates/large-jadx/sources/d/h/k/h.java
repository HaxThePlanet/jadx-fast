package d.h.k;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class h<T> extends g<T> {

    private final Object c = new Object();
    public h(int i) {
        super(i);
        final Object object = new Object();
    }

    @Override // d.h.k.g
    public boolean a(T t) {
        synchronized (obj2) {
            try {
                return super.a(t);
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    @Override // d.h.k.g
    public T b() {
        synchronized (obj2) {
            try {
                return super.b();
            } catch (Throwable th) {
            }
            throw th;
        }
    }
}
