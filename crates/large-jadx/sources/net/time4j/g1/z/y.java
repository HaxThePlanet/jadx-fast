package net.time4j.g1.z;

import java.util.Objects;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.n;
import net.time4j.engine.o;
import net.time4j.engine.p;

/* loaded from: classes3.dex */
final class y implements net.time4j.g1.z.h<Void> {

    private final int a;
    private final n<Character> b;
    y(n<Character> n, int i2) {
        super();
        Objects.requireNonNull(n, "Missing condition for unparseable chars.");
        if (i2 < 1) {
        } else {
            this.b = n;
            this.a = i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Must be positive: ");
        stringBuilder.append(i2);
        IllegalArgumentException obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        int i;
        int i2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (object instanceof y) {
            if (this.a == object.a) {
                i2 = this.b;
                obj5 = object.b;
                if (i2 == null) {
                    if (obj5 == null) {
                    } else {
                        i = i3;
                    }
                } else {
                    if (i2.equals(obj5)) {
                    } else {
                    }
                }
            } else {
            }
            return i;
        }
        return i3;
    }

    public p<Void> getElement() {
        return 0;
    }

    @Override // net.time4j.g1.z.h
    public int hashCode() {
        int i2;
        int i;
        n nVar = this.b;
        if (nVar == null) {
            i2 = this.a;
        } else {
            i3 ^= i;
        }
        return i2;
    }

    @Override // net.time4j.g1.z.h
    public boolean isNumerical() {
        return 0;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        int i;
        int test;
        n nVar;
        int obj5;
        int obj9;
        final int obj7 = s2.f();
        final int obj8 = charSequence.length();
        final int i2 = 0;
        if (this.b == null) {
            obj5 = obj8 - obj5;
        } else {
            obj9 = obj7;
            i = i2;
            while (i < this.a) {
                test = i + obj7;
                if (test < obj8) {
                }
                if (this.b.test(Character.valueOf(charSequence.charAt(test)))) {
                }
                obj9++;
                i++;
            }
            obj5 = obj9;
        }
        obj5 = Math.min(Math.max(obj5, i2), obj8);
        if (obj5 > obj7) {
            s2.l(obj5);
        }
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        return 0;
    }

    public net.time4j.g1.z.h<Void> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        return this;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        int i;
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(y.class.getName());
        if (this.b == null) {
            stringBuilder.append("[keepRemainingChars=");
            stringBuilder.append(this.a);
        } else {
            stringBuilder.append("[condition=");
            stringBuilder.append(this.b);
            stringBuilder.append(", maxIterations=");
            stringBuilder.append(this.a);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<Void> withElement(p<Void> p) {
        return this;
    }
}
