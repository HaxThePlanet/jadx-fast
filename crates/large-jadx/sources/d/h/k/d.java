package d.h.k;

/* compiled from: Pair.java */
/* loaded from: classes.dex */
public class d<F, S> {

    public final F a;
    public final S b;
    public d(F f, S s) {
        super();
        this.a = f;
        this.b = s;
    }

    public static <A, B> d<A, B> a(A a, B b) {
        return new d(a, b);
    }

    public boolean equals(Object object) {
        boolean z2 = false;
        z2 = false;
        if (!(object instanceof d)) {
            return false;
        }
        if (c.a(object.a, this.a)) {
            if (c.a(object.b, this.b)) {
                int i = 1;
            }
        }
        return z2;
    }

    public int hashCode() {
        int i;
        i = 0;
        if (this.a == null) {
        } else {
            i = this.a.hashCode();
        }
        if (this.b != null) {
            i = this.b.hashCode();
        }
        return i ^ i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Pair{";
        String str3 = " ";
        String str4 = "}";
        str = str2 + this.a + str3 + this.b + str4;
        return str;
    }
}
