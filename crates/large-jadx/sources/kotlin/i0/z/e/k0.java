package kotlin.i0.z.e;

import java.lang.ref.WeakReference;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
final class k0 {

    private final WeakReference<java.lang.ClassLoader> a;
    private final int b;
    public k0(java.lang.ClassLoader classLoader) {
        n.f(classLoader, "classLoader");
        super();
        WeakReference weakReference = new WeakReference(classLoader);
        this.a = weakReference;
        this.b = System.identityHashCode(classLoader);
    }

    public final void a(java.lang.ClassLoader classLoader) {
    }

    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof k0 && (ClassLoader)this.a.get() == (ClassLoader)object.a.get()) {
            obj2 = (ClassLoader)this.a.get() == (ClassLoader)object.a.get() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public int hashCode() {
        return this.b;
    }

    public String toString() {
        Object string;
        string = this.a.get();
        if (string != null && (ClassLoader)string.toString() != null) {
            if (string.toString() != null) {
            } else {
                string = "<null>";
            }
        } else {
        }
        return string;
    }
}
