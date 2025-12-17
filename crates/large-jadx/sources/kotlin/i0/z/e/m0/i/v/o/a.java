package kotlin.i0.z.e.m0.i.v.o;

import kotlin.i0.z.e.m0.l.b0;

/* loaded from: classes3.dex */
public abstract class a implements kotlin.i0.z.e.m0.i.v.o.d {

    protected final b0 a;
    private final kotlin.i0.z.e.m0.i.v.o.d b;
    public a(b0 b0, kotlin.i0.z.e.m0.i.v.o.d d2) {
        Object obj2;
        if (b0 == null) {
        } else {
            super();
            this.a = b0;
            if (d2 != null) {
            } else {
                obj2 = this;
            }
            this.b = obj2;
        }
        a.b(0);
        throw 0;
    }

    private static void b(int i) {
        String str;
        int i2;
        String str3;
        String str2;
        Object obj7;
        final int i3 = 2;
        final int i4 = 1;
        if (i != i4 && i != i3) {
            str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        } else {
        }
        if (i != i4 && i != i3) {
            i2 = i != i3 ? 3 : i3;
        } else {
        }
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        final int i5 = 0;
        if (i != i4 && i != i3) {
            if (i != i3) {
                arr[i5] = "receiverType";
            } else {
                arr[i5] = str3;
            }
        } else {
        }
        if (i != i4) {
            if (i != i3) {
                arr[i4] = str3;
            } else {
                arr[i4] = "getOriginal";
            }
        } else {
            arr[i4] = "getType";
        }
        if (i != i4 && i != i3) {
            if (i != i3) {
                arr[i3] = "<init>";
            }
        }
        String format = String.format(str, arr);
        if (i != i4 && i != i3) {
            if (i != i3) {
                obj7 = new IllegalArgumentException(format);
            } else {
                obj7 = new IllegalStateException(format);
            }
        } else {
        }
        throw obj7;
    }

    @Override // kotlin.i0.z.e.m0.i.v.o.d
    public b0 getType() {
        b0 b0Var = this.a;
        if (b0Var == null) {
        } else {
            return b0Var;
        }
        a.b(1);
        throw 0;
    }
}
