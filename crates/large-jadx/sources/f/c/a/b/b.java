package f.c.a.b;

import java.util.Objects;

/* loaded from: classes.dex */
public final class b {

    private final String a;
    private b(String string) {
        super();
        Objects.requireNonNull(string, "name is null");
        this.a = string;
    }

    public static f.c.a.b.b b(String string) {
        b bVar = new b(string);
        return bVar;
    }

    public String a() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof b) {
            return 0;
        }
        return this.a.equals(object.a);
    }

    public int hashCode() {
        return i ^= i3;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Encoding{name=\"");
        stringBuilder.append(this.a);
        stringBuilder.append("\"}");
        return stringBuilder.toString();
    }
}
