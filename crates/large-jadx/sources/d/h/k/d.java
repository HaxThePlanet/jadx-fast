package d.h.k;

/* loaded from: classes.dex */
public class d<F, S>  {

    public final F a;
    public final S b;
    public d(F f, S s2) {
        super();
        this.a = f;
        this.b = s2;
    }

    public static <A, B> d.h.k.d<A, B> a(A a, B b2) {
        d dVar = new d(a, b2);
        return dVar;
    }

    public boolean equals(Object object) {
        boolean z;
        int i;
        Object obj4;
        if (!object instanceof d) {
            return 0;
        }
        if (c.a(object.a, this.a) && c.a(object.b, this.b)) {
            if (c.a(object.b, this.b)) {
                i = 1;
            }
        }
        return i;
    }

    public int hashCode() {
        int i2;
        int i;
        Object obj = this.a;
        if (obj == null) {
            i2 = i;
        } else {
            i2 = obj.hashCode();
        }
        final Object obj2 = this.b;
        if (obj2 == null) {
        } else {
            i = obj2.hashCode();
        }
        return i2 ^= i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pair{");
        stringBuilder.append(this.a);
        stringBuilder.append(" ");
        stringBuilder.append(this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
