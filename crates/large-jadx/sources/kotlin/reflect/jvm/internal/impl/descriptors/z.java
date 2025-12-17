package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public enum z {

    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.z a(boolean z, boolean z2, boolean z3) {
            kotlin.reflect.jvm.internal.impl.descriptors.z obj1;
            obj1 = z ? z.SEALED : z2 ? z.ABSTRACT : z3 ? z.OPEN : z.FINAL;
            return obj1;
        }
    }
}
