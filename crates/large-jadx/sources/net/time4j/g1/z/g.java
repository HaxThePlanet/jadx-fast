package net.time4j.g1.z;

import java.util.Objects;
import net.time4j.engine.p;

/* loaded from: classes3.dex */
public final class g {

    private final p<?> a;
    private final int b;
    private final int c;
    public g(p<?> p, int i2, int i3) {
        super();
        Objects.requireNonNull(p, "Missing chronological element.");
        String str2 = ")";
        final String str3 = " (";
        if (i2 < 0) {
        } else {
            if (i3 <= i2) {
            } else {
                this.a = p;
                this.b = i2;
                this.c = i3;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("End index ");
            stringBuilder2.append(i3);
            stringBuilder2.append(" must be greater than start index ");
            stringBuilder2.append(i2);
            stringBuilder2.append(str3);
            stringBuilder2.append(p.name());
            stringBuilder2.append(str2);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative start index: ");
        stringBuilder.append(i2);
        stringBuilder.append(str3);
        stringBuilder.append(p.name());
        stringBuilder.append(str2);
        IllegalArgumentException obj8 = new IllegalArgumentException(stringBuilder.toString());
        throw obj8;
    }

    public p<?> a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public boolean equals(Object object) {
        int i;
        boolean equals;
        p pVar;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof g) {
            if (this.a.equals(object.a) && this.b == object.b && this.c == object.c) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return i += i5;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(80);
        stringBuilder.append(g.class.getName());
        stringBuilder.append("[element=");
        stringBuilder.append(this.a.name());
        stringBuilder.append(",start-index=");
        stringBuilder.append(this.b);
        stringBuilder.append(",end-index=");
        stringBuilder.append(this.c);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
