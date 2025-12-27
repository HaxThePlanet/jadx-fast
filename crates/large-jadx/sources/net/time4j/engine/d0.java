package net.time4j.engine;

import net.time4j.tz.k;

/* compiled from: StartOfDay.java */
/* loaded from: classes3.dex */
public abstract class d0 {

    public static final d0 a;

    static class a {
    }

    private static class b extends d0 {

        private final int b;
        /* synthetic */ b(int i, d0.a aVar) {
            this(i);
        }

        @Override // net.time4j.engine.d0
        public int b(g gVar, k kVar) {
            return this.b;
        }

        @Override // net.time4j.engine.d0
        public boolean equals(Object object) {
            boolean z = true;
            z = true;
            if (this == object) {
                return true;
            }
            final int i = 0;
            if (object instanceof d0.b) {
                if (this.b != object.b) {
                }
                return z;
            }
            return false;
        }

        @Override // net.time4j.engine.d0
        public int hashCode() {
            return this.b;
        }

        @Override // net.time4j.engine.d0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "FixedStartOfDay[";
            String str3 = "]";
            str = str2 + this.b + str3;
            return str;
        }

        private b(int i) {
            super();
            this.b = i;
        }
    }
    static {
        d0.a = d0.a(0);
        d0.a(-21600);
        d0.a(21600);
    }

    protected d0() {
        super();
    }

    private static d0 a(int i) {
        return new d0.b(i, null);
    }

    public abstract int b(g gVar, k kVar);
}
