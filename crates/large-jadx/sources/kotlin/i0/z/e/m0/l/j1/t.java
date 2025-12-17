package kotlin.i0.z.e.m0.l.j1;

import kotlin.i0.z.e.m0.l.b0;

/* loaded from: classes3.dex */
public class t {
    static {
    }

    private static void a(int i) {
        String str3;
        int i3;
        String str2;
        String str;
        Object obj9;
        final int i4 = 10;
        final int i5 = 7;
        if (i != i5 && i != i4) {
            str3 = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        } else {
        }
        final int i6 = 2;
        if (i != i5 && i != i4) {
            i3 = i != i4 ? 3 : i6;
        } else {
        }
        Object[] arr = new Object[i3];
        str2 = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckingProcedure";
        int i7 = 0;
        switch (i) {
            case 1:
                arr[i7] = "supertype";
                break;
            case 2:
                arr[i7] = "subtype";
                break;
            case 3:
                arr[i7] = "typeCheckingProcedureCallbacks";
                break;
            case 4:
                arr[i7] = "parameter";
                break;
            case 5:
                arr[i7] = "argument";
                break;
            case 6:
                arr[i7] = str2;
                break;
            case 7:
                arr[i7] = "type1";
                break;
            case 8:
                arr[i7] = "type2";
                break;
            case 9:
                arr[i7] = "typeParameter";
                break;
            case 10:
                arr[i7] = "typeArgument";
                break;
            case 11:
                arr[i7] = "subtypeArgumentProjection";
                break;
            default:
                arr[i7] = "supertypeArgumentProjection";
        }
        String str4 = "getInType";
        String str5 = "getOutType";
        final int i8 = 1;
        if (i != i5) {
            if (i != i4) {
                arr[i8] = str2;
            } else {
                arr[i8] = str4;
            }
        } else {
            arr[i8] = str5;
        }
        switch (i) {
            case 5:
                arr[i6] = str5;
                break;
            case 7:
                arr[i6] = str4;
                break;
            case 8:
                arr[i6] = "equalTypes";
                break;
            case 9:
                arr[i6] = "getEffectiveProjectionKind";
                break;
            case 10:
                arr[i6] = "isSubtypeOf";
                break;
            case 11:
                arr[i6] = "checkSubtypeForTheSameConstructor";
                break;
            case 12:
                arr[i6] = "capture";
                break;
            default:
                arr[i6] = "findCorrespondingSupertype";
        }
        String format = String.format(str3, arr);
        if (i != i5 && i != i4) {
            if (i != i4) {
                obj9 = new IllegalArgumentException(format);
            } else {
                obj9 = new IllegalStateException(format);
            }
        } else {
        }
        throw obj9;
    }

    public static b0 b(b0 b0, b0 b02) {
        int i = 0;
        if (b0 == null) {
        } else {
            if (b02 == null) {
            } else {
                s sVar = new s();
                return t.c(b0, b02, sVar);
            }
            t.a(1);
            throw i;
        }
        t.a(0);
        throw i;
    }

    public static b0 c(b0 b0, b0 b02, kotlin.i0.z.e.m0.l.j1.u u3) {
        final int i = 0;
        if (b0 == null) {
        } else {
            if (b02 == null) {
            } else {
                if (u3 == null) {
                } else {
                    return w.d(b0, b02, u3);
                }
                t.a(4);
                throw i;
            }
            t.a(3);
            throw i;
        }
        t.a(2);
        throw i;
    }
}
