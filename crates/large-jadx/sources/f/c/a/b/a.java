package f.c.a.b;

import java.util.Objects;

/* compiled from: AutoValue_Event.java */
/* loaded from: classes.dex */
final class a<T> extends c<T> {

    private final Integer a;
    private final T b;
    private final d c;
    a(Integer integer, T t, d dVar) {
        super();
        this.a = integer;
        Objects.requireNonNull(t, "Null payload");
        this.b = t;
        Objects.requireNonNull(dVar, "Null priority");
        this.c = dVar;
    }

    @Override // f.c.a.b.c
    public Integer a() {
        return this.a;
    }

    @Override // f.c.a.b.c
    public T b() {
        return this.b;
    }

    @Override // f.c.a.b.c
    public d c() {
        return this.c;
    }

    @Override // f.c.a.b.c
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        Object obj;
        boolean equals2;
        z = true;
        if (object == this) {
            return true;
        }
        final int i = 0;
        if (object instanceof c) {
            if (this.a == null) {
                if (object.a() == null) {
                    if (this.b.equals(object.b())) {
                        if (!(this.c.equals(object.c()))) {
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // f.c.a.b.c
    public int hashCode() {
        int i = 0;
        if (this.a == null) {
            i = 0;
        } else {
            i = this.a.hashCode();
        }
        int i7 = 1000003;
        return (i ^ i7) * i7 ^ this.b.hashCode() * i7 ^ this.c.hashCode();
    }

    @Override // f.c.a.b.c
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Event{code=";
        String str3 = ", payload=";
        String str4 = ", priority=";
        String str5 = "}";
        str = str2 + this.a + str3 + this.b + str4 + this.c + str5;
        return str;
    }
}
