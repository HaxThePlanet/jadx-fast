package androidx.camera.core.impl;

import java.util.Objects;

/* loaded from: classes.dex */
final class c extends androidx.camera.core.impl.h {

    private final Object a;
    c(Object object) {
        super();
        Objects.requireNonNull(object, "Null value");
        this.a = object;
    }

    @Override // androidx.camera.core.impl.h
    public Object b() {
        return this.a;
    }

    @Override // androidx.camera.core.impl.h
    public boolean equals(Object object) {
        if (object == this) {
            return 1;
        }
        if (object instanceof h) {
            return this.a.equals((h)object.b());
        }
        return 0;
    }

    @Override // androidx.camera.core.impl.h
    public int hashCode() {
        return i ^= i3;
    }

    @Override // androidx.camera.core.impl.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Identifier{value=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
