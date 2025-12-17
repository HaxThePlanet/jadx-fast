package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.d0.d.n;

/* loaded from: classes3.dex */
public final class f {

    private final String a;
    private final int b;
    public f(String string, int i2) {
        n.f(string, "number");
        super();
        this.a = string;
        this.b = i2;
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("NumberWithRadix(number=");
        stringBuilder.append(this.a);
        stringBuilder.append(", radix=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
