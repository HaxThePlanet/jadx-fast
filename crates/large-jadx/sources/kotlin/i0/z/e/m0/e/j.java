package kotlin.i0.z.e.m0.e;

import kotlin.reflect.jvm.internal.impl.protobuf.i.a;
import kotlin.reflect.jvm.internal.impl.protobuf.i.b;

/* loaded from: classes3.dex */
public enum j implements i.a {

    DECLARATION(false, false),
    FAKE_OVERRIDE(true, true),
    DELEGATION(2, 2),
    SYNTHESIZED(3, 3);

    private final int value;

    static class a implements i.b<kotlin.i0.z.e.m0.e.j> {
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i$b
        public kotlin.i0.z.e.m0.e.j a(int i) {
            return j.valueOf(i);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i$b
        public i.a findValueByNumber(int i) {
            return a(i);
        }
    }
    public static kotlin.i0.z.e.m0.e.j valueOf(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return j.SYNTHESIZED;
                }
                return j.DELEGATION;
            }
            return j.FAKE_OVERRIDE;
        }
        return j.DECLARATION;
    }

    @Override // java.lang.Enum
    public final int getNumber() {
        return this.value;
    }
}
