package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.collect.z;
import io.grpc.d1.b;
import java.util.Set;

/* loaded from: classes3.dex */
final class t0 {

    final int a;
    final long b;
    final Set<d1.b> c;
    t0(int i, long l2, Set<d1.b> set3) {
        super();
        this.a = i;
        this.b = l2;
        this.c = z.s(obj4);
    }

    public boolean equals(Object object) {
        int i;
        Set cmp;
        Class<io.grpc.j1.t0> obj;
        Class class;
        long l;
        boolean obj7;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (t0.class != object.getClass()) {
            } else {
                if (this.a == object.a && Long.compare(l2, l) == 0 && k.a(this.c, object.c)) {
                    if (Long.compare(l2, l) == 0) {
                        if (k.a(this.c, object.c)) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
            }
            return i;
        }
        return i2;
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
