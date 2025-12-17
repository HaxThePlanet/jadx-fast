package kotlin.i0.z.e;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.d0.d.n;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.k;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.a.k.a;
import kotlin.reflect.jvm.internal.impl.descriptors.l1.b.b;

/* loaded from: classes3.dex */
public final class b0 {

    private static final ConcurrentMap<kotlin.i0.z.e.k0, WeakReference<k>> a;
    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        b0.a = concurrentHashMap;
    }

    public static final k a(Class<?> class) {
        k.a aVar;
        Object obj2;
        Object ifAbsent;
        Object obj;
        n.f(class, "$this$getOrCreateModule");
        java.lang.ClassLoader obj5 = b.g(class);
        k0 k0Var = new k0(obj5);
        ConcurrentMap map = b0.a;
        obj2 = map.get(k0Var);
        ifAbsent = (WeakReference)obj2.get();
        if (obj2 != null && (k)ifAbsent != null) {
            ifAbsent = obj2.get();
            if ((k)(k)ifAbsent != null) {
                n.e((k)(k)ifAbsent, "it");
                return ifAbsent;
            }
            map.remove(k0Var, obj2);
        }
        obj5 = k.c.a(obj5);
        aVar = null;
        obj2 = b0.a;
        WeakReference weakReference = new WeakReference(obj5);
        ifAbsent = obj2.putIfAbsent(k0Var, weakReference);
        while ((WeakReference)ifAbsent != null) {
            obj = (WeakReference)ifAbsent.get();
            obj2.remove(k0Var, ifAbsent);
            aVar = null;
            obj2 = b0.a;
            weakReference = new WeakReference(obj5);
            ifAbsent = obj2.putIfAbsent(k0Var, weakReference);
        }
        k0Var.a(aVar);
        return obj5;
    }
}
