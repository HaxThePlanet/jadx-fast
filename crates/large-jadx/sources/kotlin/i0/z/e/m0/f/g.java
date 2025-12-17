package kotlin.i0.z.e.m0.f;

/* loaded from: classes3.dex */
public class g {

    public static final kotlin.i0.z.e.m0.f.e a;
    public static final kotlin.i0.z.e.m0.f.e b;
    public static final kotlin.i0.z.e.m0.f.e c;
    static {
        g.a = e.n("<no name provided>");
        e.n("<root package>");
        g.b = e.j("Companion");
        g.c = e.j("no_name_in_PSI_3d19d79d_1ba9_4cd0_b7f5_b46aa3cd5d40");
        e.n("<anonymous>");
    }

    private static void a(int i) {
        String str3;
        int i2;
        String str;
        String str2;
        Object obj7;
        final int i3 = 1;
        str3 = i != i3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        final int i4 = 2;
        i2 = i != i3 ? i4 : 3;
        Object[] arr = new Object[i2];
        str = "kotlin/reflect/jvm/internal/impl/name/SpecialNames";
        final int i5 = 0;
        if (i != i3) {
            arr[i5] = str;
        } else {
            arr[i5] = "name";
        }
        if (i != i3) {
            arr[i3] = "safeIdentifier";
        } else {
            arr[i3] = str;
        }
        if (i != i3) {
        } else {
            arr[i4] = "isSafeIdentifier";
        }
        String format = String.format(str3, arr);
        if (i != i3) {
            obj7 = new IllegalStateException(format);
        } else {
            obj7 = new IllegalArgumentException(format);
        }
        throw obj7;
    }

    public static boolean b(kotlin.i0.z.e.m0.f.e e) {
        int i;
        boolean obj2;
        if (!e) {
        } else {
            if (!e.c().isEmpty() && !e.k()) {
                if (!e.k()) {
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }
        g.a(1);
        throw 0;
    }

    public static kotlin.i0.z.e.m0.f.e c(kotlin.i0.z.e.m0.f.e e) {
        boolean z;
        kotlin.i0.z.e.m0.f.e obj1;
        if (e != null && !e.k()) {
            if (!e.k()) {
            } else {
                obj1 = g.c;
            }
        } else {
        }
        if (obj1 == null) {
        } else {
            return obj1;
        }
        g.a(0);
        throw 0;
    }
}
