package kotlin.i0.z.e;

import java.lang.ref.WeakReference;
import kotlin.d0.d.n;
import kotlin.i0.z.e.n0.b;

/* loaded from: classes3.dex */
public final class g {

    private static b<String, Object> a;
    static {
        final b bVar = b.b();
        n.e(bVar, "HashPMap.empty<String, Any>()");
        g.a = bVar;
    }

    public static final <T> kotlin.i0.z.e.h<T> a(Class<T> class) {
        Object obj;
        boolean z2;
        int i2;
        int i;
        Object obj2;
        boolean z;
        Class cls;
        n.f(class, "jClass");
        String name = class.getName();
        obj = g.a.c(name);
        if (obj instanceof WeakReference != null) {
            obj = (WeakReference)obj.get();
            if ((h)obj != null) {
                i2 = (h)obj.d();
            }
            if (n.b(i2, class)) {
                return obj;
            }
        } else {
            if (obj != null) {
                Object obj3 = obj;
                final int i4 = 0;
                i = i4;
                while (i < obj3.length) {
                    obj2 = (WeakReference[])obj3[i].get();
                    if ((h)obj2 != null) {
                    } else {
                    }
                    cls = i2;
                    i++;
                    cls = (h)obj2.d();
                }
                int length = obj4.length;
                WeakReference[] arr = new WeakReference[length + 1];
                System.arraycopy(obj, i4, arr, i4, length);
                h hVar2 = new h(class);
                WeakReference obj9 = new WeakReference(hVar2);
                arr[length] = obj9;
                obj9 = g.a.f(name, arr);
                n.e(obj9, "K_CLASS_CACHE.plus(name, newArray)");
                g.a = obj9;
                return hVar2;
            }
        }
        h hVar = new h(class);
        WeakReference weakReference = new WeakReference(hVar);
        obj9 = g.a.f(name, weakReference);
        n.e(obj9, "K_CLASS_CACHE.plus(name, WeakReference(newKClass))");
        g.a = obj9;
        return hVar;
    }
}
