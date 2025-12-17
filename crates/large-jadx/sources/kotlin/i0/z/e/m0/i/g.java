package kotlin.i0.z.e.m0.i;

import java.util.Comparator;
import kotlin.i0.z.e.m0.f.e;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;

/* loaded from: classes3.dex */
public class g implements Comparator<m> {

    public static final kotlin.i0.z.e.m0.i.g a;
    static {
        g gVar = new g();
        g.a = gVar;
    }

    private static Integer b(m m, m m2) {
        boolean z;
        i -= i3;
        if (i2 != 0) {
            return Integer.valueOf(i2);
        }
        if (d.B(m) && d.B(m2)) {
            if (d.B(m2)) {
                return null;
            }
        }
        int obj2 = m.getName().e(m2.getName());
        if (obj2 != null) {
            return Integer.valueOf(obj2);
        }
        return null;
    }

    private static int c(m m) {
        if (d.B(m)) {
            return 8;
        }
        if (m instanceof l) {
            return 7;
        }
        if (m instanceof o0 && (o0)m.m0() == null) {
            if ((o0)m.m0() == null) {
                return 6;
            }
            return 5;
        }
        if (m instanceof x && (x)m.m0() == null) {
            if ((x)m.m0() == null) {
                return 4;
            }
            return 3;
        }
        if (m instanceof e) {
            return 2;
        }
        if (m instanceof y0) {
            return 1;
        }
        return 0;
    }

    @Override // java.util.Comparator
    public int a(m m, m m2) {
        int obj1;
        obj1 = g.b(m, m2);
        if (obj1 != null) {
            obj1 = obj1.intValue();
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    @Override // java.util.Comparator
    public int compare(Object object, Object object2) {
        return a((m)object, (m)object2);
    }
}
