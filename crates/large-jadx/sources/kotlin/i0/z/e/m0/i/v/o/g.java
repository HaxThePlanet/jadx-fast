package kotlin.i0.z.e.m0.i.v.o;

import kotlin.i0.z.e.m0.l.b0;

/* loaded from: classes3.dex */
public class g extends kotlin.i0.z.e.m0.i.v.o.a {
    public g(b0 b0) {
        final int i = 0;
        if (b0 == null) {
        } else {
            super(b0, i);
        }
        g.b(0);
        throw i;
    }

    private g(b0 b0, kotlin.i0.z.e.m0.i.v.o.d d2) {
        if (b0 == null) {
        } else {
            super(b0, d2);
        }
        g.b(1);
        throw 0;
    }

    private static void b(int i) {
        String str;
        String obj4;
        Object[] arr = new Object[3];
        int i3 = 0;
        final int i5 = 2;
        if (i != i5) {
            arr[i3] = "type";
        } else {
            arr[i3] = "newType";
        }
        arr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i != i5) {
            arr[i5] = "<init>";
        } else {
            arr[i5] = "replaceType";
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
        throw illegalArgumentException;
    }

    @Override // kotlin.i0.z.e.m0.i.v.o.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{Transient} : ");
        stringBuilder.append(getType());
        return stringBuilder.toString();
    }
}
