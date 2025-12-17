package androidx.lifecycle;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements androidx.lifecycle.n {

    private final androidx.lifecycle.g a;
    private final androidx.lifecycle.n b;

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            FullLifecycleObserverAdapter.a.a = iArr;
            iArr[j.b.ON_CREATE.ordinal()] = 1;
            FullLifecycleObserverAdapter.a.a[j.b.ON_START.ordinal()] = 2;
            FullLifecycleObserverAdapter.a.a[j.b.ON_RESUME.ordinal()] = 3;
            FullLifecycleObserverAdapter.a.a[j.b.ON_PAUSE.ordinal()] = 4;
            FullLifecycleObserverAdapter.a.a[j.b.ON_STOP.ordinal()] = 5;
            FullLifecycleObserverAdapter.a.a[j.b.ON_DESTROY.ordinal()] = 6;
            FullLifecycleObserverAdapter.a.a[j.b.ON_ANY.ordinal()] = 7;
        }
    }
    FullLifecycleObserverAdapter(androidx.lifecycle.g g, androidx.lifecycle.n n2) {
        super();
        this.a = g;
        this.b = n2;
    }

    @Override // androidx.lifecycle.n
    public void c(androidx.lifecycle.q q, androidx.lifecycle.j.b j$b2) {
        androidx.lifecycle.g i;
        switch (i) {
            case 1:
                this.a.b(q);
                break;
            case 2:
                this.a.onStart(q);
                break;
            case 3:
                this.a.a(q);
                break;
            case 4:
                this.a.d(q);
                break;
            case 5:
                this.a.onStop(q);
                break;
            case 6:
                this.a.onDestroy(q);
                break;
            case 7:
                IllegalArgumentException obj3 = new IllegalArgumentException("ON_ANY must not been send by anybody");
                throw obj3;
            default:
        }
        androidx.lifecycle.n nVar = this.b;
        if (nVar != null) {
            nVar.c(q, b2);
        }
    }
}
