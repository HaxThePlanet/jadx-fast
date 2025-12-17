package kotlin.i0.z.e.m0.j.b;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: classes3.dex */
public interface p {

    public static final kotlin.i0.z.e.m0.j.b.p a;

    static class a implements kotlin.i0.z.e.m0.j.b.p {
        private static void c(int i) {
            String str;
            String obj4;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i5 = 1;
            if (i != i5) {
                arr[i3] = "descriptor";
            } else {
                arr[i3] = "unresolvedSuperClasses";
            }
            arr[i5] = "kotlin/reflect/jvm/internal/impl/serialization/deserialization/ErrorReporter$1";
            int i4 = 2;
            if (i != i4) {
                arr[i4] = "reportIncompleteHierarchy";
            } else {
                arr[i4] = "reportCannotInferVisibility";
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.i0.z.e.m0.j.b.p
        public void a(b b) {
            if (b == null) {
            } else {
            }
            p.a.c(2);
            throw 0;
        }

        public void b(e e, List<String> list2) {
            final int i = 0;
            if (e == null) {
            } else {
                if (list2 == null) {
                } else {
                }
                p.a.c(1);
                throw i;
            }
            p.a.c(0);
            throw i;
        }
    }
    static {
        p.a aVar = new p.a();
        p.a = aVar;
    }

    public abstract void a(b b);

    public abstract void b(e e, List<String> list2);
}
