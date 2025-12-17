package net.time4j.engine;

import net.time4j.tz.k;

/* loaded from: classes3.dex */
public abstract class d0 {

    public static final net.time4j.engine.d0 a;

    static class a {
    }

    private static class b extends net.time4j.engine.d0 {

        private final int b;
        private b(int i) {
            super();
            this.b = i;
        }

        b(int i, net.time4j.engine.d0.a d0$a2) {
            super(i);
        }

        @Override // net.time4j.engine.d0
        public int b(net.time4j.engine.g g, k k2) {
            return this.b;
        }

        @Override // net.time4j.engine.d0
        public boolean equals(Object object) {
            int i;
            if (this == object) {
                return 1;
            }
            final int i3 = 0;
            if (object instanceof d0.b) {
                if (this.b == object.b) {
                } else {
                    i = i3;
                }
                return i;
            }
            return i3;
        }

        @Override // net.time4j.engine.d0
        public int hashCode() {
            return this.b;
        }

        @Override // net.time4j.engine.d0
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("FixedStartOfDay[");
            stringBuilder.append(this.b);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }
    static {
        d0.a = d0.a(0);
        d0.a(-21600);
        d0.a(21600);
    }

    private static net.time4j.engine.d0 a(int i) {
        d0.b bVar = new d0.b(i, 0);
        return bVar;
    }

    public abstract int b(net.time4j.engine.g g, k k2);
}
