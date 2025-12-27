package f.c.a.b;

import java.util.Objects;

/* compiled from: Encoding.java */
/* loaded from: classes.dex */
public final class b {

    private final String a;
    private b(String str) {
        super();
        Objects.requireNonNull(str, "name is null");
        this.a = str;
    }

    public static b b(String str) {
        return new b(str);
    }

    public String a() {
        return this.a;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof b)) {
            return false;
        }
        return this.a.equals(object.a);
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Encoding{name=\"";
        String str4 = "\"}";
        str = str2 + this.a + str4;
        return str;
    }
}
