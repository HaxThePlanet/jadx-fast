package kotlin.reflect.jvm.internal.impl.descriptors.i1;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.l.i0;

/* loaded from: classes3.dex */
public interface e {

    public static final class a implements kotlin.reflect.jvm.internal.impl.descriptors.i1.e {

        public static final kotlin.reflect.jvm.internal.impl.descriptors.i1.e.a a;
        static {
            e.a aVar = new e.a();
            e.a.a = aVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.i1.e
        public i0 a(a a, i0 i02) {
            n.f(a, "classId");
            n.f(i02, "computedType");
            return i02;
        }
    }
    public abstract i0 a(a a, i0 i02);
}
