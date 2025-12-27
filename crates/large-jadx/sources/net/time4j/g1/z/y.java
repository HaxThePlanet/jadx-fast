package net.time4j.g1.z;

import java.util.Objects;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.n;
import net.time4j.engine.o;
import net.time4j.engine.p;

/* compiled from: SkipProcessor.java */
/* loaded from: classes3.dex */
final class y implements h<Void> {

    private final int a;
    private final n<Character> b;
    y(n<Character> nVar, int i) {
        super();
        Objects.requireNonNull(nVar, "Missing condition for unparseable chars.");
        if (i < 1) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Must be positive: ";
            i = str2 + i;
            throw new IllegalArgumentException(i);
        } else {
            this.b = nVar;
            this.a = i;
            return;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        int i2;
        boolean equals;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof y) {
            if (this.a == object.a) {
                if (this.b == null) {
                    if (object.b != null) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        if (this.b == null) {
        } else {
            i2 = ~this.a;
            i = this.b.hashCode() ^ i2;
        }
        return i;
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        int i;
        int i2;
        n nVar;
        int z52;
        z52 = sVar.f();
        final int length = charSequence.length();
        i = 0;
        if (this.b == null) {
            z52 = length - this.a;
        } else {
            while (i < this.a) {
                i2 = i + z52;
            }
        }
        int min = Math.min(Math.max(z52, i), length);
        if (min > z52) {
            sVar.l(min);
        }
    }

    @Override // java.lang.Object
    public String toString() {
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

    public p<Void> getElement() {
        return null;
    }

    public boolean isNumerical() {
        return false;
    }

    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) {
        return 0;
    }

    public h<Void> quickPath(c<?> cVar, d dVar, int i) {
        return this;
    }

    public h<Void> withElement(p<Void> pVar) {
        return this;
    }
}
