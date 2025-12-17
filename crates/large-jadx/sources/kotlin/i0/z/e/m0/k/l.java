package kotlin.i0.z.e.m0.k;

/* loaded from: classes3.dex */
class l<T>  {

    private final T a;
    private final Thread b;
    l(T t) {
        super();
        this.a = t;
        this.b = Thread.currentThread();
    }

    public T a() {
        if (!b()) {
        } else {
            return this.a;
        }
        IllegalStateException illegalStateException = new IllegalStateException("No value in this thread (hasValue should be checked before)");
        throw illegalStateException;
    }

    public boolean b() {
        int i;
        i = this.b == Thread.currentThread() ? 1 : 0;
        return i;
    }
}
