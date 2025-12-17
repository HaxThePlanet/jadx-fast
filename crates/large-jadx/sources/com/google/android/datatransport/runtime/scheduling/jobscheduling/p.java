package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import f.c.a.b.d;
import f.c.a.b.i.b0.a;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes.dex */
final class p extends com.google.android.datatransport.runtime.scheduling.jobscheduling.s {

    private final a a;
    private final Map<d, com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b> b;
    p(a a, Map<d, com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b> map2) {
        super();
        Objects.requireNonNull(a, "Null clock");
        this.a = a;
        Objects.requireNonNull(map2, "Null values");
        this.b = map2;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s
    a e() {
        return this.a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj5;
        if (object == this) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof s) {
            if (this.a.equals((s)object.e()) && this.b.equals(object.h())) {
                if (this.b.equals(object.h())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    Map<d, com.google.android.datatransport.runtime.scheduling.jobscheduling.s.b> h() {
        return this.b;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s
    public int hashCode() {
        int i5 = 1000003;
        return i3 ^= i6;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.s
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SchedulerConfig{clock=");
        stringBuilder.append(this.a);
        stringBuilder.append(", values=");
        stringBuilder.append(this.b);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
