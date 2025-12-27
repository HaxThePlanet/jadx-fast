package net.time4j.g1.z;

import java.util.Objects;
import net.time4j.engine.p;

/* compiled from: ElementPosition.java */
/* loaded from: classes3.dex */
public final class g {

    private final p<?> a;
    private final int b;
    private final int c;
    public g(p<?> pVar, int i, int i2) {
        super();
        Objects.requireNonNull(pVar, "Missing chronological element.");
        String str2 = ")";
        final String str3 = " (";
        if (i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = "Negative start index: ";
            String name2 = pVar.name();
            pVar = str4 + i + str3 + name2 + str2;
            throw new IllegalArgumentException(pVar);
        } else {
            if (i2 <= i) {
                StringBuilder stringBuilder2 = new StringBuilder();
                final String str5 = "End index ";
                String str6 = " must be greater than start index ";
                String name = pVar.name();
                pVar = str5 + i2 + str6 + i + str3 + name + str2;
                throw new IllegalArgumentException(pVar);
            } else {
                this.a = pVar;
                this.b = i;
                this.c = i2;
                return;
            }
        }
    }

    public p<?> a() {
        return this.a;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        p pVar;
        int i2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof g) {
            if (this.a.equals(object.a)) {
                if (this.b == object.b) {
                    if (this.c != object.c) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() + (this.b | (this.c << 16)) * 37;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(80);
        String name = g.class.getName();
        String str2 = "[element=";
        String name2 = this.a.name();
        String str3 = ",start-index=";
        String str4 = ",end-index=";
        str = 80 + name + str2 + name2 + str3 + this.b + str4 + this.c + 93;
        return str;
    }
}
