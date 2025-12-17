package androidx.lifecycle;

/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements androidx.lifecycle.n {

    private final Object a;
    private final androidx.lifecycle.c.a b;
    ReflectiveGenericLifecycleObserver(Object object) {
        super();
        this.a = object;
        this.b = c.c.c(object.getClass());
    }

    @Override // androidx.lifecycle.n
    public void c(androidx.lifecycle.q q, androidx.lifecycle.j.b j$b2) {
        this.b.a(q, b2, this.a);
    }
}
