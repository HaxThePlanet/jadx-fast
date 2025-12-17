package net.time4j.g1;

import java.util.Objects;
import net.time4j.engine.c;

/* loaded from: classes3.dex */
final class q<A>  implements c<A> {

    private final String a;
    private final Class<A> b;
    private q(String string, Class<A> class2) {
        super();
        Objects.requireNonNull(string, "Missing name of attribute key.");
        Objects.requireNonNull(class2, "Missing type of attribute.");
        this.a = string;
        this.b = class2;
    }

    static <A> net.time4j.g1.q<A> b(String string, Class<A> class2) {
        q qVar = new q(string, class2);
        return qVar;
    }

    public Class<A> a() {
        return this.b;
    }

    @Override // net.time4j.engine.c
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof q) {
            if (this.a.equals(object.a) && this.b.equals(object.b)) {
                if (this.b.equals(object.b)) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // net.time4j.engine.c
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // net.time4j.engine.c
    public String name() {
        return this.a;
    }

    @Override // net.time4j.engine.c
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b.getName());
        stringBuilder.append("@");
        stringBuilder.append(this.a);
        return stringBuilder.toString();
    }
}
