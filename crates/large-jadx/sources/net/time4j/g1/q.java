package net.time4j.g1;

import java.util.Objects;
import net.time4j.engine.c;

/* compiled from: PredefinedKey.java */
/* loaded from: classes3.dex */
final class q<A> implements c<A> {

    private final String a;
    private final Class<A> b;
    private q(String str, Class<A> cls) {
        super();
        Objects.requireNonNull(str, "Missing name of attribute key.");
        Objects.requireNonNull(cls, "Missing type of attribute.");
        this.a = str;
        this.b = cls;
    }

    static <A> q<A> b(String str, Class<A> cls) {
        return new q(str, cls);
    }

    public Class<A> a() {
        return this.b;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        boolean equals2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof q) {
            if (this.a.equals(object.a)) {
                if (!(this.b.equals(object.b))) {
                }
            }
            return z;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    public String name() {
        return this.a;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String name = this.b.getName();
        String str2 = "@";
        str = name + str2 + this.a;
        return str;
    }
}
