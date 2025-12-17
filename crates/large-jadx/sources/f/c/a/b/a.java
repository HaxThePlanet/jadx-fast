package f.c.a.b;

import java.util.Objects;

/* loaded from: classes.dex */
final class a<T>  extends f.c.a.b.c<T> {

    private final Integer a;
    private final T b;
    private final f.c.a.b.d c;
    a(Integer integer, T t2, f.c.a.b.d d3) {
        super();
        this.a = integer;
        Objects.requireNonNull(t2, "Null payload");
        this.b = t2;
        Objects.requireNonNull(d3, "Null priority");
        this.c = d3;
    }

    @Override // f.c.a.b.c
    public Integer a() {
        return this.a;
    }

    public T b() {
        return this.b;
    }

    @Override // f.c.a.b.c
    public f.c.a.b.d c() {
        return this.c;
    }

    @Override // f.c.a.b.c
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Integer num;
        boolean obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof c) {
            Integer num2 = this.a;
            if (num2 == null) {
                if ((c)object.a() == null) {
                    if (this.b.equals(object.b())) {
                        if (this.c.equals(object.c())) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            } else {
                if (num2.equals(object.a()) && this.b.equals(object.b()) && this.c.equals(object.c())) {
                } else {
                }
            }
            return i;
        }
        return i2;
    }

    @Override // f.c.a.b.c
    public int hashCode() {
        int i;
        Integer num = this.a;
        if (num == null) {
            i = 0;
        } else {
            i = num.hashCode();
        }
        int i7 = 1000003;
        return i5 ^= i8;
    }

    @Override // f.c.a.b.c
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{code=");
        stringBuilder.append(this.a);
        stringBuilder.append(", payload=");
        stringBuilder.append(this.b);
        stringBuilder.append(", priority=");
        stringBuilder.append(this.c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
