package kotlin.i0.z.e.m0.e;

import kotlin.reflect.jvm.internal.impl.protobuf.i.a;
import kotlin.reflect.jvm.internal.impl.protobuf.i.b;

/* loaded from: classes3.dex */
public enum k implements i.a {

    FINAL(false, false),
    OPEN(true, true),
    ABSTRACT(2, 2),
    SEALED(3, 3);

    private final int value;

    static class a implements i.b<kotlin.i0.z.e.m0.e.k> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i$b
        public kotlin.i0.z.e.m0.e.k a(int i) {
            return k.valueOf(i);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i$b
        public i.a findValueByNumber(int i) {
            return a(i);
        }
    }
    public static kotlin.i0.z.e.m0.e.k valueOf(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return k.SEALED;
                }
                return k.ABSTRACT;
            }
            return k.OPEN;
        }
        return k.FINAL;
    }

    @Override // java.lang.Enum
    public final int getNumber() {
        return this.value;
    }
}
