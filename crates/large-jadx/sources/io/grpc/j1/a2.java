package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.collect.z;
import io.grpc.d1.b;
import java.util.Set;

/* loaded from: classes3.dex */
final class a2 {

    final int a;
    final long b;
    final long c;
    final double d;
    final Long e;
    final Set<d1.b> f;
    a2(int i, long l2, long l3, double d4, Long long5, Set<d1.b> set6) {
        super();
        this.a = i;
        this.b = l2;
        this.c = d4;
        this.d = set6;
        this.e = obj8;
        this.f = z.s(obj9);
    }

    public boolean equals(Object object) {
        int compare;
        int i;
        int i2;
        long l;
        Object obj7;
        if (!object instanceof a2) {
            return 0;
        }
        if (this.a == object.a && Long.compare(i2, l) == 0 && Long.compare(i2, l) == 0 && Double.compare(this.d, obj3) == 0 && k.a(this.e, object.e) && k.a(this.f, object.f)) {
            if (Long.compare(i2, l) == 0) {
                if (Long.compare(i2, l) == 0) {
                    if (Double.compare(this.d, obj3) == 0) {
                        if (k.a(this.e, object.e)) {
                            if (k.a(this.f, object.f)) {
                                i = 1;
                            }
                        }
                    }
                }
            }
        }
        return i;
    }

    public int hashCode() {
        Object[] arr = new Object[6];
        int i4 = 0;
        arr[i4] = Integer.valueOf(this.a);
        int i5 = 1;
        arr[i5] = Long.valueOf(this.b);
        int i6 = 2;
        arr[i6] = Long.valueOf(this.c);
        arr[3] = Double.valueOf(this.d);
        arr[4] = this.e;
        arr[5] = this.f;
        return k.b(arr);
    }

    public String toString() {
        j.b bVar = j.c(this);
        String str = "maxAttempts";
        bVar.b(str, this.a);
        bVar.c("initialBackoffNanos", this.b);
        bVar.c("maxBackoffNanos", this.c);
        bVar.a("backoffMultiplier", this.d);
        bVar.d("perAttemptRecvTimeoutNanos", this.e);
        bVar.d("retryableStatusCodes", this.f);
        return bVar.toString();
    }
}
