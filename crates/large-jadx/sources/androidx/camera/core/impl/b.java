package androidx.camera.core.impl;

import java.util.Objects;

/* loaded from: classes.dex */
final class b<T>  extends androidx.camera.core.impl.g.a<T> {

    private final String a;
    private final Class<T> b;
    private final Object c;
    b(String string, Class<T> class2, Object object3) {
        super();
        Objects.requireNonNull(string, "Null id");
        this.a = string;
        Objects.requireNonNull(class2, "Null valueClass");
        this.b = class2;
        this.c = object3;
    }

    @Override // androidx.camera.core.impl.g$a
    public String c() {
        return this.a;
    }

    @Override // androidx.camera.core.impl.g$a
    public Object d() {
        return this.c;
    }

    public Class<T> e() {
        return this.b;
    }

    @Override // androidx.camera.core.impl.g$a
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object str;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof g.a) {
            if (this.a.equals((g.a)object.c()) && this.b.equals(object.e())) {
                if (this.b.equals(object.e())) {
                    equals = this.c;
                    if (equals == null) {
                        if (object.d() == null) {
                        } else {
                            i = i2;
                        }
                    } else {
                        if (equals.equals(object.d())) {
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // androidx.camera.core.impl.g$a
    public int hashCode() {
        int i;
        int i8 = 1000003;
        Object obj = this.c;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        return i6 ^= i;
    }

    @Override // androidx.camera.core.impl.g$a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Option{id=");
        stringBuilder.append(this.a);
        stringBuilder.append(", valueClass=");
        stringBuilder.append(this.b);
        stringBuilder.append(", token=");
        stringBuilder.append(this.c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
