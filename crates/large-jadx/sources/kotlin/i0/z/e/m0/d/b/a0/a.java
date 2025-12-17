package kotlin.i0.z.e.m0.d.b.a0;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.i0.z.e.m0.e.a0.b.c;
import kotlin.i0.z.e.m0.e.a0.b.f;
import kotlin.y.i;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class a {

    private final kotlin.i0.z.e.m0.d.b.a0.a.a a;
    private final f b;
    private final String[] c;
    private final String[] d;
    private final String[] e;
    private final String f;
    private final int g;

    public static enum a {

        UNKNOWN(false),
        CLASS(true),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);

        private final int id;
        public static final Map access$getEntryById$cp() {
            return a.a.entryById;
        }

        public static final kotlin.i0.z.e.m0.d.b.a0.a.a getById(int i) {
            return a.a.Companion.a(i);
        }

        @Override // java.lang.Enum
        public final int getId() {
            return this.id;
        }
    }
    public a(kotlin.i0.z.e.m0.d.b.a0.a.a a$a, f f2, c c3, String[] string4Arr4, String[] string5Arr5, String[] string6Arr6, String string7, int i8, String string9) {
        n.f(a, "kind");
        n.f(f2, "metadataVersion");
        n.f(c3, "bytecodeVersion");
        super();
        this.a = a;
        this.b = f2;
        this.c = string4Arr4;
        this.d = string5Arr5;
        this.e = string6Arr6;
        this.f = string7;
        this.g = i8;
    }

    private final boolean h(int i, int i2) {
        int obj1;
        obj1 = i &= i2 != 0 ? 1 : 0;
        return obj1;
    }

    public final String[] a() {
        return this.c;
    }

    public final String[] b() {
        return this.d;
    }

    public final kotlin.i0.z.e.m0.d.b.a0.a.a c() {
        return this.a;
    }

    public final f d() {
        return this.b;
    }

    public final String e() {
        int str;
        int i;
        str = this.f;
        i = c() == a.a.MULTIFILE_CLASS_PART ? 1 : 0;
        if (i != 0) {
        } else {
            str = 0;
        }
        return str;
    }

    public final List<String> f() {
        int strArr;
        int i;
        int i2;
        strArr = this.c;
        i = c() == a.a.MULTIFILE_CLASS ? 1 : 0;
        if (i != 0) {
        } else {
            strArr = i2;
        }
        if (strArr == 0) {
        } else {
            i2 = i.d(strArr);
        }
        if (i2 != 0) {
        } else {
            i2 = p.g();
        }
        return i2;
    }

    public final String[] g() {
        return this.e;
    }

    public final boolean i() {
        return h(this.g, 2);
    }

    public final boolean j() {
        boolean z;
        int i2;
        int i;
        if (h(this.g, 64) && !h(this.g, 32)) {
            i2 = !h(this.g, 32) ? 1 : 0;
        } else {
        }
        return i2;
    }

    public final boolean k() {
        boolean z;
        int i;
        int i2;
        if (h(this.g, 16) && !h(this.g, 32)) {
            i = !h(this.g, 32) ? 1 : 0;
        } else {
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append(" version=");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
