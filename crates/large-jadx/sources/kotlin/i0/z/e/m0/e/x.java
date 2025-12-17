package kotlin.i0.z.e.m0.e;

import kotlin.reflect.jvm.internal.impl.protobuf.i.a;
import kotlin.reflect.jvm.internal.impl.protobuf.i.b;

/* loaded from: classes3.dex */
public enum x implements i.a {

    INTERNAL(false, false),
    PRIVATE(true, true),
    PROTECTED(2, 2),
    PUBLIC(3, 3),
    PRIVATE_TO_THIS(4, 4),
    LOCAL(5, 5);

    private final int value;

    static class a implements i.b<kotlin.i0.z.e.m0.e.x> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i$b
        public kotlin.i0.z.e.m0.e.x a(int i) {
            return x.valueOf(i);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i$b
        public i.a findValueByNumber(int i) {
            return a(i);
        }
    }
    public static kotlin.i0.z.e.m0.e.x valueOf(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return x.LOCAL;
                        }
                        return x.PRIVATE_TO_THIS;
                    }
                    return x.PUBLIC;
                }
                return x.PROTECTED;
            }
            return x.PRIVATE;
        }
        return x.INTERNAL;
    }

    @Override // java.lang.Enum
    public final int getNumber() {
        return this.value;
    }
}
