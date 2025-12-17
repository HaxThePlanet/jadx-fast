package kotlin.i0.z.e.m0.c.b;

import java.io.Serializable;
import kotlin.d0.d.g;

/* loaded from: classes3.dex */
public final class e implements Serializable {

    public static final kotlin.i0.z.e.m0.c.b.e.a a;
    private static final kotlin.i0.z.e.m0.c.b.e b;
    private final int column;
    private final int line;

    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.z.e.m0.c.b.e a() {
            return e.a();
        }
    }
    static {
        e.a aVar = new e.a(0);
        e.a = aVar;
        int i2 = -1;
        e eVar = new e(i2, i2);
        e.b = eVar;
    }

    public e(int i, int i2) {
        super();
        this.line = i;
        this.column = i2;
    }

    public static final kotlin.i0.z.e.m0.c.b.e a() {
        return e.b;
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof e) {
            return i2;
        }
        if (this.line != object.line) {
            return i2;
        }
        if (this.column != object.column) {
            return i2;
        }
        return i;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        return i += column;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Position(line=");
        stringBuilder.append(this.line);
        stringBuilder.append(", column=");
        stringBuilder.append(this.column);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
