package androidx.core.util;

/* loaded from: classes5.dex */
public class Pair<F, S>  {

    public final F first;
    public final S second;
    public Pair(F f, S s2) {
        super();
        this.first = f;
        this.second = s2;
    }

    public static <A, B> androidx.core.util.Pair<A, B> create(A a, B b2) {
        Pair pair = new Pair(a, b2);
        return pair;
    }

    public boolean equals(Object o) {
        int i;
        boolean equals;
        Object second;
        if (!o instanceof Pair) {
            return 0;
        }
        Object obj = o;
        if (ObjectsCompat.equals(obj.first, this.first) && ObjectsCompat.equals(obj.second, this.second)) {
            if (ObjectsCompat.equals(obj.second, this.second)) {
                i = 1;
            }
        }
        return i;
    }

    public int hashCode() {
        int i;
        int i2;
        if (this.first == null) {
            i = i2;
        } else {
            i = this.first.hashCode();
        }
        if (this.second == null) {
        } else {
            i2 = this.second.hashCode();
        }
        return i ^= i2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Pair{").append(this.first).append(" ").append(this.second).append("}").toString();
    }
}
