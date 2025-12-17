package kotlin.i0.z.e.m0.l;

import kotlin.i0.z.e.m0.l.j1.g;

/* loaded from: classes3.dex */
public class x0 extends kotlin.i0.z.e.m0.l.w0 {

    private final kotlin.i0.z.e.m0.l.h1 a;
    private final kotlin.i0.z.e.m0.l.b0 b;
    public x0(kotlin.i0.z.e.m0.l.b0 b0) {
        if (b0 == null) {
        } else {
            super(h1.INVARIANT, b0);
        }
        x0.d(2);
        throw 0;
    }

    public x0(kotlin.i0.z.e.m0.l.h1 h1, kotlin.i0.z.e.m0.l.b0 b02) {
        final int i = 0;
        if (h1 == null) {
        } else {
            if (b02 == null) {
            } else {
                super();
                this.a = h1;
                this.b = b02;
            }
            x0.d(1);
            throw i;
        }
        x0.d(0);
        throw i;
    }

    private static void d(int i) {
        String str;
        String str2;
        int i2;
        String str3;
        String str4;
        Object obj9;
        final int i3 = 5;
        final int i4 = 4;
        if (i != i4 && i != i3) {
            str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        } else {
        }
        str2 = 3;
        final int i6 = 2;
        if (i != i4 && i != i3) {
            i2 = i != i3 ? str2 : i6;
        } else {
        }
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/types/TypeProjectionImpl";
        int i7 = 0;
        switch (i) {
            case 1:
                arr[i7] = "type";
                break;
            case 2:
                arr[i7] = str3;
                break;
            case 3:
                arr[i7] = "kotlinTypeRefiner";
                break;
            default:
                arr[i7] = "projection";
        }
        int i8 = 1;
        if (i != i4) {
            if (i != i3) {
                arr[i8] = str3;
            } else {
                arr[i8] = "getType";
            }
        } else {
            arr[i8] = "getProjectionKind";
        }
        if (i != str2) {
            if (i != i4 && i != i3) {
                if (i != i3) {
                    if (i != 6) {
                        arr[i6] = "<init>";
                    } else {
                        arr[i6] = "refine";
                    }
                }
            }
        } else {
            arr[i6] = "replaceType";
        }
        String format = String.format(str, arr);
        if (i != i4 && i != i3) {
            if (i != i3) {
                obj9 = new IllegalArgumentException(format);
            } else {
                obj9 = new IllegalStateException(format);
            }
        } else {
        }
        throw obj9;
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public kotlin.i0.z.e.m0.l.h1 a() {
        kotlin.i0.z.e.m0.l.h1 h1Var = this.a;
        if (h1Var == null) {
        } else {
            return h1Var;
        }
        x0.d(4);
        throw 0;
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public kotlin.i0.z.e.m0.l.v0 b(g g) {
        if (g == null) {
        } else {
            x0 x0Var = new x0(this.a, g.g(this.b));
            return x0Var;
        }
        x0.d(6);
        throw 0;
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public boolean c() {
        return 0;
    }

    @Override // kotlin.i0.z.e.m0.l.w0
    public kotlin.i0.z.e.m0.l.b0 getType() {
        kotlin.i0.z.e.m0.l.b0 b0Var = this.b;
        if (b0Var == null) {
        } else {
            return b0Var;
        }
        x0.d(5);
        throw 0;
    }
}
