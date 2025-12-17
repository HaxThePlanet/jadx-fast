package com.google.android.exoplayer2.l2;

import com.google.android.exoplayer2.util.g;

/* loaded from: classes2.dex */
public interface q {

    public static final class a {

        public final com.google.android.exoplayer2.l2.r a;
        public final com.google.android.exoplayer2.l2.r b;
        public a(com.google.android.exoplayer2.l2.r r) {
            super(r, r);
        }

        public a(com.google.android.exoplayer2.l2.r r, com.google.android.exoplayer2.l2.r r2) {
            super();
            g.e(r);
            this.a = (r)r;
            g.e(r2);
            this.b = (r)r2;
        }

        public boolean equals(Object object) {
            int i;
            com.google.android.exoplayer2.l2.r equals;
            Class<com.google.android.exoplayer2.l2.q.a> obj;
            Class class;
            boolean obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (q.a.class != object.getClass()) {
                } else {
                    if (this.a.equals(object.a) && this.b.equals(object.b)) {
                        if (this.b.equals(object.b)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            return i2 += i4;
        }

        public String toString() {
            String string;
            Object str;
            StringBuilder stringBuilder;
            String valueOf = String.valueOf(this.a);
            if (this.a.equals(this.b)) {
                string = "";
            } else {
                String valueOf2 = String.valueOf(this.b);
                stringBuilder = new StringBuilder(length2 += 2);
                stringBuilder.append(", ");
                stringBuilder.append(valueOf2);
                string = stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder(i += length3);
            stringBuilder2.append("[");
            stringBuilder2.append(valueOf);
            stringBuilder2.append(string);
            stringBuilder2.append("]");
            return stringBuilder2.toString();
        }
    }

    public static class b implements com.google.android.exoplayer2.l2.q {

        private final long a;
        public b(long l) {
            super(l, obj4, 0, obj1);
        }

        public b(long l, long l2) {
            com.google.android.exoplayer2.l2.r obj4;
            super();
            this.a = l;
            final int i = 0;
            if (Long.compare(obj5, i) == 0) {
                obj4 = r.c;
            } else {
                obj4 = new r(i, obj1, obj5, obj6);
            }
            q.a obj3 = new q.a(obj4);
        }

        @Override // com.google.android.exoplayer2.l2.q
        public boolean b() {
            return 0;
        }

        @Override // com.google.android.exoplayer2.l2.q
        public long getDurationUs() {
            return this.a;
        }
    }
    public abstract boolean b();

    public abstract long getDurationUs();
}
