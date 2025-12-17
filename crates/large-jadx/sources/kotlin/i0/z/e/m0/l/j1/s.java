package kotlin.i0.z.e.m0.l.j1;

import kotlin.i0.z.e.m0.l.t0;

/* loaded from: classes3.dex */
class s implements kotlin.i0.z.e.m0.l.j1.u {
    private static void b(int i) {
        String str;
        String obj3;
        Object[] arr = new Object[3];
        int i3 = 0;
        switch (i) {
            case 1:
                arr[i3] = "b";
                break;
            case 2:
                arr[i3] = "typeCheckingProcedure";
                break;
            case 3:
                arr[i3] = "a";
                break;
            case 4:
                arr[i3] = "subtype";
                break;
            case 5:
                arr[i3] = "supertype";
                break;
            case 6:
                arr[i3] = "type";
                break;
            default:
                arr[i3] = "typeProjection";
        }
        arr[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        int i5 = 2;
        switch (i) {
            case 3:
                arr[i5] = "assertEqualTypeConstructors";
                break;
            case 4:
                arr[i5] = "assertSubtype";
                break;
            case 5:
                arr[i5] = "capture";
                break;
            case 6:
                arr[i5] = "noCorrespondingSupertype";
                break;
            default:
                arr[i5] = "assertEqualTypes";
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
        throw illegalArgumentException;
    }

    @Override // kotlin.i0.z.e.m0.l.j1.u
    public boolean a(t0 t0, t0 t02) {
        final int i = 0;
        if (t0 == null) {
        } else {
            if (t02 == null) {
            } else {
                return t0.equals(t02);
            }
            s.b(4);
            throw i;
        }
        s.b(3);
        throw i;
    }
}
