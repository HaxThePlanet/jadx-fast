package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.collect.z;
import io.grpc.d1.b;
import java.util.Set;

/* compiled from: RetryPolicy.java */
/* loaded from: classes3.dex */
final class a2 {

    final int a;
    final long b;
    final long c;
    final double d;
    final Long e;
    final Set<d1.b> f;
    a2(int i, long j, long j2, double d, Long long, Set<d1.b> set) {
        super();
        this.a = i;
        this.b = j;
        this.c = j2;
        this.d = d;
        this.e = long;
        this.f = z.s(set);
    }

    public boolean equals(Object object) {
        boolean z = false;
        z = false;
        if (!(object instanceof a2)) {
            return false;
        }
        if (this.a == object.a) {
            if (this.b == object.b) {
                if (this.c == object.c) {
                    if (Double.compare(this.d, object.d) == 0) {
                        if (k.a(this.e, object.e)) {
                            if (k.a(this.f, object.f)) {
                                int i2 = 1;
                            }
                        }
                    }
                }
            }
        }
        return z;
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
