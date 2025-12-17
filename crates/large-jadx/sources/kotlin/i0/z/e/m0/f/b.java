package kotlin.i0.z.e.m0.f;

import java.util.List;

/* loaded from: classes3.dex */
public final class b {

    public static final kotlin.i0.z.e.m0.f.b c;
    private final kotlin.i0.z.e.m0.f.c a;
    private transient kotlin.i0.z.e.m0.f.b b;
    static {
        b bVar = new b("");
        b.c = bVar;
    }

    public b(String string) {
        if (string == null) {
        } else {
            super();
            c cVar = new c(string, this);
            this.a = cVar;
        }
        b.a(1);
        throw 0;
    }

    public b(kotlin.i0.z.e.m0.f.c c) {
        if (c == null) {
        } else {
            super();
            this.a = c;
        }
        b.a(2);
        throw 0;
    }

    private b(kotlin.i0.z.e.m0.f.c c, kotlin.i0.z.e.m0.f.b b2) {
        if (c == null) {
        } else {
            super();
            this.a = c;
            this.b = b2;
        }
        b.a(3);
        throw 0;
    }

    private static void a(int i) {
        String str;
        int i2;
        String str3;
        String str2;
        Object obj7;
        str = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i2 = /* condition */ ? i3 : 3;
        Object[] arr = new Object[i2];
        str3 = "shortName";
        final String str5 = "kotlin/reflect/jvm/internal/impl/name/FqName";
        int i4 = 0;
        switch (i) {
            case 1:
                arr[i4] = "fqName";
                break;
            case 2:
                arr[i4] = str5;
                break;
            case 3:
                arr[i4] = "name";
                break;
            case 4:
                arr[i4] = "segment";
                break;
            case 5:
                arr[i4] = str3;
                break;
            default:
                arr[i4] = "names";
        }
        int i5 = 1;
        switch (i) {
            case 4:
                arr[i5] = "asString";
                break;
            case 5:
                arr[i5] = "toUnsafe";
                break;
            case 6:
                arr[i5] = "parent";
                break;
            case 7:
                arr[i5] = str5;
                break;
            case 8:
                arr[i5] = str3;
                break;
            case 9:
                arr[i5] = "shortNameOrSpecial";
                break;
            default:
                arr[i5] = "pathSegments";
        }
        switch (i) {
            case 1:
                arr[i3] = "<init>";
                break;
            case 3:
                arr[i3] = "child";
                break;
            case 4:
                arr[i3] = "startsWith";
                break;
            case 5:
                arr[i3] = "topLevel";
                break;
            default:
                arr[i3] = "fromSegments";
        }
        if (/* condition */) {
            obj7 = new IllegalStateException(format);
        } else {
            obj7 = new IllegalArgumentException(format);
        }
        throw obj7;
    }

    public static kotlin.i0.z.e.m0.f.b k(kotlin.i0.z.e.m0.f.e e) {
        if (e == null) {
        } else {
            b bVar = new b(c.m(e));
            return bVar;
        }
        b.a(13);
        throw 0;
    }

    public String b() {
        String str = this.a.b();
        if (str == null) {
        } else {
            return str;
        }
        b.a(4);
        throw 0;
    }

    public kotlin.i0.z.e.m0.f.b c(kotlin.i0.z.e.m0.f.e e) {
        if (e == null) {
        } else {
            b bVar = new b(this.a.c(e), this);
            return bVar;
        }
        b.a(8);
        throw 0;
    }

    public boolean d() {
        return this.a.e();
    }

    public kotlin.i0.z.e.m0.f.b e() {
        kotlin.i0.z.e.m0.f.b bVar = this.b;
        int i3 = 0;
        if (bVar != null) {
            if (bVar == null) {
            } else {
                return bVar;
            }
            b.a(6);
            throw i3;
        }
        if (d()) {
        } else {
            b bVar2 = new b(this.a.g());
            this.b = bVar2;
            if (bVar2 == null) {
            } else {
                return bVar2;
            }
            b.a(7);
            throw i3;
        }
        IllegalStateException illegalStateException = new IllegalStateException("root");
        throw illegalStateException;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof b) {
            return i2;
        }
        if (!this.a.equals(object.a)) {
            return i2;
        }
        return i;
    }

    public List<kotlin.i0.z.e.m0.f.e> f() {
        List list = this.a.h();
        if (list == null) {
        } else {
            return list;
        }
        b.a(11);
        throw 0;
    }

    public kotlin.i0.z.e.m0.f.e g() {
        kotlin.i0.z.e.m0.f.e eVar = this.a.i();
        if (eVar == null) {
        } else {
            return eVar;
        }
        b.a(9);
        throw 0;
    }

    public kotlin.i0.z.e.m0.f.e h() {
        kotlin.i0.z.e.m0.f.e eVar = this.a.j();
        if (eVar == null) {
        } else {
            return eVar;
        }
        b.a(10);
        throw 0;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean i(kotlin.i0.z.e.m0.f.e e) {
        if (e == null) {
        } else {
            return this.a.k(e);
        }
        b.a(12);
        throw 0;
    }

    public kotlin.i0.z.e.m0.f.c j() {
        kotlin.i0.z.e.m0.f.c cVar = this.a;
        if (cVar == null) {
        } else {
            return cVar;
        }
        b.a(5);
        throw 0;
    }

    public String toString() {
        return this.a.toString();
    }
}
