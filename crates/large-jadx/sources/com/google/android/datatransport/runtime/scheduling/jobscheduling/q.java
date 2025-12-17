package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
final class q extends com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b {

    private final long a;
    private final long b;
    private final Set<com.google.android.datatransport.runtime.scheduling.jobscheduling.s.c> c;

    static class a {
    }

    static final class b extends com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b.a {

        private Long a;
        private Long b;
        private Set<com.google.android.datatransport.runtime.scheduling.jobscheduling.s.c> c;
        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s$b$a
        public com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b a() {
            Object stringBuilder2;
            Object stringBuilder3;
            Object stringBuilder;
            String string;
            if (this.a == null) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append("");
                stringBuilder2.append(" delta");
                string = stringBuilder2.toString();
            }
            if (this.b == null) {
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(string);
                stringBuilder3.append(" maxAllowedDelay");
                string = stringBuilder3.toString();
            }
            if (this.c == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" flags");
                string = stringBuilder.toString();
            }
            if (!string.isEmpty()) {
            } else {
                super(this.a.longValue(), obj4, this.b.longValue(), obj6, this.c, 0);
                return qVar;
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Missing required properties:");
            stringBuilder4.append(string);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder4.toString());
            throw illegalStateException;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s$b$a
        public com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b.a b(long l) {
            this.a = Long.valueOf(l);
            return this;
        }

        public com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b.a c(Set<com.google.android.datatransport.runtime.scheduling.jobscheduling.s.c> set) {
            Objects.requireNonNull(set, "Null flags");
            this.c = set;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s$b$a
        public com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b.a d(long l) {
            this.b = Long.valueOf(l);
            return this;
        }
    }
    private q(long l, long l2, Set<com.google.android.datatransport.runtime.scheduling.jobscheduling.s.c> set3) {
        super();
        this.a = l;
        this.b = set3;
        this.c = obj5;
    }

    q(long l, long l2, Set set3, com.google.android.datatransport.runtime.scheduling.jobscheduling.q.a q$a4) {
        super(l, l2, set3, a4, obj5);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s$b
    long b() {
        return this.a;
    }

    Set<com.google.android.datatransport.runtime.scheduling.jobscheduling.s.c> c() {
        return this.c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s$b
    long d() {
        return this.b;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s$b
    public boolean equals(Object object) {
        int i;
        int cmp;
        long l2;
        long l;
        Object obj8;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof s.b) {
            if (Long.compare(l2, l) == 0 && Long.compare(l2, l) == 0 && this.c.equals(object.c())) {
                if (Long.compare(l2, l) == 0) {
                    if (this.c.equals(object.c())) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s$b
    public int hashCode() {
        long l = this.a;
        int i10 = 32;
        int i8 = 1000003;
        long l2 = this.b;
        return i6 ^= i9;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s$b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConfigValue{delta=");
        stringBuilder.append(this.a);
        stringBuilder.append(", maxAllowedDelay=");
        stringBuilder.append(this.b);
        stringBuilder.append(", flags=");
        stringBuilder.append(this.c);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
