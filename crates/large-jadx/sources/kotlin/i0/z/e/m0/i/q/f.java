package kotlin.i0.z.e.m0.i.q;

import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.f.a;

/* loaded from: classes3.dex */
public final class f {

    private final a a;
    private final int b;
    public f(a a, int i2) {
        n.f(a, "classId");
        super();
        this.a = a;
        this.b = i2;
    }

    public final a a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.b;
    }

    public final a d() {
        return this.a;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i3 = 0;
        if (!object instanceof f) {
            return i3;
        }
        if (!n.b(this.a, object.a)) {
            return i3;
        }
        if (this.b != object.b) {
            return i3;
        }
        return i;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        int i;
        int str;
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        str = i;
        while (str < c()) {
            stringBuilder.append("kotlin/Array<");
            str++;
        }
        stringBuilder.append(d());
        while (i < c()) {
            stringBuilder.append(">");
            i++;
        }
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
