package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.collect.z;
import io.grpc.d1.b;
import java.util.Set;

/* compiled from: HedgingPolicy.java */
/* loaded from: classes3.dex */
final class t0 {

    final int a;
    final long b;
    final Set<d1.b> c;
    t0(int i, long j, Set<d1.b> set) {
        super();
        this.a = i;
        this.b = j;
        this.c = z.s(set);
    }

    public boolean equals(Object object) {
        boolean z = true;
        int cmp;
        long l;
        boolean z2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object != null) {
            obj = t0.class;
            if (obj == object.getClass()) {
                if (this.a == object.a) {
                    if (this.b == object.b) {
                        if (!(k.a(this.c, object.c))) {
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int hashCode() {
        Object[] arr = new Object[3];
        int i4 = 0;
        arr[i4] = Integer.valueOf(this.a);
        arr[1] = Long.valueOf(this.b);
        arr[2] = this.c;
        return k.b(arr);
    }

    public String toString() {
        j.b bVar = j.c(this);
        String str = "maxAttempts";
        bVar.b(str, this.a);
        bVar.c("hedgingDelayNanos", this.b);
        bVar.d("nonFatalStatusCodes", this.c);
        return bVar.toString();
    }
}
