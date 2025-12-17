package kotlin.i0.z.e.m0.f;

import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.d0.c.l;
import kotlin.y.i;

/* loaded from: classes3.dex */
public final class c {

    private static final kotlin.i0.z.e.m0.f.e e;
    private static final Pattern f;
    private static final l<String, kotlin.i0.z.e.m0.f.e> g;
    private final String a;
    private transient kotlin.i0.z.e.m0.f.b b;
    private transient kotlin.i0.z.e.m0.f.c c;
    private transient kotlin.i0.z.e.m0.f.e d;

    static class a implements l<String, kotlin.i0.z.e.m0.f.e> {
        @Override // kotlin.d0.c.l
        public kotlin.i0.z.e.m0.f.e a(String string) {
            return e.i(string);
        }

        @Override // kotlin.d0.c.l
        public Object invoke(Object object) {
            return a((String)object);
        }
    }
    static {
        c.e = e.n("<root>");
        c.f = Pattern.compile("\\.");
        c.a aVar = new c.a();
        c.g = aVar;
    }

    public c(String string) {
        if (string == null) {
        } else {
            super();
            this.a = string;
        }
        c.a(2);
        throw 0;
    }

    c(String string, kotlin.i0.z.e.m0.f.b b2) {
        final int i = 0;
        if (string == null) {
        } else {
            if (b2 == null) {
            } else {
                super();
                this.a = string;
                this.b = b2;
            }
            c.a(1);
            throw i;
        }
        c.a(0);
        throw i;
    }

    private c(String string, kotlin.i0.z.e.m0.f.c c2, kotlin.i0.z.e.m0.f.e e3) {
        if (string == null) {
        } else {
            super();
            this.a = string;
            this.c = c2;
            this.d = e3;
        }
        c.a(3);
        throw 0;
    }

    private static void a(int i) {
        String str3;
        int i2;
        String str2;
        String str;
        Object obj8;
        str3 = /* condition */ ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        i2 = /* condition */ ? i4 : 3;
        Object[] arr = new Object[i2];
        str2 = "shortName";
        final String str4 = "kotlin/reflect/jvm/internal/impl/name/FqNameUnsafe";
        final int i5 = 0;
        final int i6 = 1;
        if (i != i6) {
            switch (i) {
                case 4:
                    arr[i5] = str4;
                    break;
                case 5:
                    arr[i5] = "name";
                    break;
                case 6:
                    arr[i5] = "segment";
                    break;
                case 7:
                    arr[i5] = str2;
                    break;
                default:
                    arr[i5] = "fqName";
            }
        } else {
            arr[i5] = "safe";
        }
        switch (i) {
            case 4:
                arr[i6] = "asString";
                break;
            case 5:
                arr[i6] = "toSafe";
                break;
            case 6:
                arr[i6] = "parent";
                break;
            case 7:
                arr[i6] = str4;
                break;
            case 8:
                arr[i6] = str2;
                break;
            case 9:
                arr[i6] = "shortNameOrSpecial";
                break;
            case 10:
                arr[i6] = "pathSegments";
                break;
            default:
                arr[i6] = "toString";
        }
        switch (i) {
            case 5:
                arr[i4] = "child";
                break;
            case 6:
                arr[i4] = "startsWith";
                break;
            case 7:
                arr[i4] = "topLevel";
                break;
            default:
                arr[i4] = "<init>";
        }
        if (/* condition */) {
            obj8 = new IllegalStateException(format);
        } else {
            obj8 = new IllegalArgumentException(format);
        }
        throw obj8;
    }

    private void d() {
        Object substring;
        kotlin.i0.z.e.m0.f.c cVar;
        String str;
        int i;
        int lastIndexOf = this.a.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            this.d = e.i(this.a.substring(lastIndexOf + 1));
            cVar = new c(this.a.substring(0, lastIndexOf));
            this.c = cVar;
        } else {
            this.d = e.i(this.a);
            this.c = b.c.j();
        }
    }

    public static kotlin.i0.z.e.m0.f.c m(kotlin.i0.z.e.m0.f.e e) {
        if (e == null) {
        } else {
            c cVar = new c(e.c(), b.c.j(), e);
            return cVar;
        }
        c.a(16);
        throw 0;
    }

    public String b() {
        String str = this.a;
        if (str == null) {
        } else {
            return str;
        }
        c.a(4);
        throw 0;
    }

    public kotlin.i0.z.e.m0.f.c c(kotlin.i0.z.e.m0.f.e e) {
        String string;
        String str;
        if (e == null) {
        } else {
            if (e()) {
                string = e.c();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a);
                stringBuilder.append(".");
                stringBuilder.append(e.c());
                string = stringBuilder.toString();
            }
            c cVar = new c(string, this, e);
            return cVar;
        }
        c.a(9);
        throw 0;
    }

    public boolean e() {
        return this.a.isEmpty();
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof c) {
            return i2;
        }
        if (!this.a.equals(object.a)) {
            return i2;
        }
        return i;
    }

    public boolean f() {
        int i2;
        kotlin.i0.z.e.m0.f.b indexOf;
        int i;
        if (this.b == null) {
            if (b().indexOf(60) < 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    public kotlin.i0.z.e.m0.f.c g() {
        kotlin.i0.z.e.m0.f.c cVar = this.c;
        int i3 = 0;
        if (cVar != null) {
            if (cVar == null) {
            } else {
                return cVar;
            }
            c.a(7);
            throw i3;
        }
        if (e()) {
        } else {
            d();
            kotlin.i0.z.e.m0.f.c cVar2 = this.c;
            if (cVar2 == null) {
            } else {
                return cVar2;
            }
            c.a(8);
            throw i3;
        }
        IllegalStateException illegalStateException = new IllegalStateException("root");
        throw illegalStateException;
    }

    public List<kotlin.i0.z.e.m0.f.e> h() {
        List emptyList;
        l lVar;
        if (e()) {
            emptyList = Collections.emptyList();
        } else {
            emptyList = i.L(c.f.split(this.a), c.g);
        }
        if (emptyList == null) {
        } else {
            return emptyList;
        }
        c.a(14);
        throw 0;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public kotlin.i0.z.e.m0.f.e i() {
        kotlin.i0.z.e.m0.f.e eVar = this.d;
        int i3 = 0;
        if (eVar != null) {
            if (eVar == null) {
            } else {
                return eVar;
            }
            c.a(10);
            throw i3;
        }
        if (e()) {
        } else {
            d();
            kotlin.i0.z.e.m0.f.e eVar2 = this.d;
            if (eVar2 == null) {
            } else {
                return eVar2;
            }
            c.a(11);
            throw i3;
        }
        IllegalStateException illegalStateException = new IllegalStateException("root");
        throw illegalStateException;
    }

    public kotlin.i0.z.e.m0.f.e j() {
        final int i3 = 0;
        if (e()) {
            kotlin.i0.z.e.m0.f.e eVar = c.e;
            if (eVar == null) {
            } else {
                return eVar;
            }
            c.a(12);
            throw i3;
        }
        kotlin.i0.z.e.m0.f.e eVar2 = i();
        if (eVar2 == null) {
        } else {
            return eVar2;
        }
        c.a(13);
        throw i3;
    }

    public boolean k(kotlin.i0.z.e.m0.f.e e) {
        int indexOf;
        if (e == null) {
        } else {
            final int i = 0;
            if (e()) {
                return i;
            }
            if (this.a.indexOf(46) == -1) {
                indexOf = this.a.length();
            }
            return this.a.regionMatches(i, e.c(), i, indexOf);
        }
        c.a(15);
        throw 0;
    }

    public kotlin.i0.z.e.m0.f.b l() {
        kotlin.i0.z.e.m0.f.b bVar = this.b;
        final int i3 = 0;
        if (bVar != null) {
            if (bVar == null) {
            } else {
                return bVar;
            }
            c.a(5);
            throw i3;
        }
        b bVar2 = new b(this);
        this.b = bVar2;
        if (bVar2 == null) {
        } else {
            return bVar2;
        }
        c.a(6);
        throw i3;
    }

    public String toString() {
        String str;
        if (e()) {
            str = c.e.c();
        } else {
            str = this.a;
        }
        if (str == null) {
        } else {
            return str;
        }
        c.a(17);
        throw 0;
    }
}
