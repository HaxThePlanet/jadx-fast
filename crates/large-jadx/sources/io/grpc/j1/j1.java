package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.base.r;
import io.grpc.d.a;
import io.grpc.f0;
import io.grpc.f0.b;
import io.grpc.f0.b.a;
import io.grpc.o0.f;
import io.grpc.u0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ManagedChannelServiceConfig.java */
/* loaded from: classes3.dex */
final class j1 {

    private final j1.b a;
    private final Map<String, j1.b> b;
    private final Map<String, j1.b> c;
    private final z1.d0 d;
    private final Object e;
    private final Map<String, ?> f = null;

    static class a {
    }

    static final class b {

        static final d.a<j1.b> g;
        final Long a;
        final Boolean b;
        final Integer c;
        final Integer d;
        final a2 e;
        final t0 f;
        static {
            j1.b.g = d.a.b("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");
        }

        b(Map<String, ?> map, boolean z, int i, int i2) {
            boolean z3 = true;
            Map map2;
            Map map3;
            super();
            this.a = e2.w(map);
            this.b = e2.x(map);
            Integer num = e2.l(map);
            this.c = num;
            i2 = 1;
            int i5 = 0;
            if (num != null) {
                int r3 = num.intValue() >= 0 ? 1 : i5;
                str = "maxInboundMessageSize %s exceeds bounds";
                n.k((num.intValue() >= 0 ? 1 : i5), "maxInboundMessageSize %s exceeds bounds", num);
            }
            Integer num2 = e2.k(map);
            this.d = num2;
            if (num2 != null && num2.intValue() >= 0) {
                n.k(z3, "maxOutboundMessageSize %s exceeds bounds", num2);
            }
            i = 0;
            if (z) {
                map2 = e2.r(map);
            } else {
            }
            if (map2 == null) {
            } else {
                io.grpc.j1.a2 a2Var = j1.b.b(map2, i);
            }
            this.e = i;
            if (z) {
                map3 = e2.d(map);
            } else {
            }
            if (map3 != null) {
                io.grpc.j1.t0 t0Var = j1.b.a(map3, i2);
            }
            this.f = i;
        }

        private static t0 a(Map<String, ?> map, int i) {
            boolean z;
            Integer num = e2.h(map);
            n.p(num, "maxAttempts cannot be empty");
            int value = num.intValue();
            i = 1;
            i = 0;
            int r3 = value >= 2 ? 1 : i;
            final String str4 = "maxAttempts must be greater than 1: %s";
            n.h((value >= 2 ? 1 : i), str4, value);
            Long l = e2.c(map);
            n.p(l, (value >= 2 ? 1 : i));
            r3 = l.longValue();
            if (r3 < 0) {
            }
            n.j(i, "hedgingDelay must not be negative: %s", r3);
            return new t0(Math.min(value, i), (value >= 2 ? 1 : i), str4, e2.p(map));
        }

        private static a2 b(Map<String, ?> map, int i) {
            boolean z;
            boolean z2 = true;
            boolean z3;
            boolean empty;
            String str;
            Integer num2 = e2.i(map);
            n.p(num2, "maxAttempts cannot be empty");
            int value3 = num2.intValue();
            i = 1;
            i = 0;
            int r3 = i;
            n.h(i, "maxAttempts must be greater than 1: %s", value3);
            Long l2 = e2.e(map);
            n.p(l2, i);
            final long value4 = l2.longValue();
            long l5 = 0L;
            int r0 = i;
            n.j(i, "initialBackoffNanos must be greater than 0: %s", value4);
            r0 = e2.j(map);
            n.p(r0, "maxBackoff cannot be empty");
            long value = r0.longValue();
            r0 = i;
            n.j(i, "maxBackoff must be greater than 0: %s", value);
            r0 = e2.a(map);
            n.p(r0, "backoffMultiplier cannot be empty");
            double value5 = r0.doubleValue();
            r0 = i;
            str = "backoffMultiplier must be greater than 0: %s";
            n.k(i, "backoffMultiplier must be greater than 0: %s", Double.valueOf(value5, d2));
            Long l = e2.q(map);
            if (l != null) {
                long value2 = l.longValue();
                if (value2 >= l5) {
                } else {
                }
            }
            n.k(empty, "perAttemptRecvTimeout cannot be negative: %s", l);
            Set set = e2.s(map);
            n.e(z2, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            a2 a2Var = new a2(Math.min(value3, i), value4, l4, value, l6, value5, l7, l, set);
            return a2Var;
        }

        public boolean equals(Object object) {
            boolean z2 = false;
            z2 = false;
            if (!(object instanceof j1.b)) {
                return false;
            }
            if (k.a(this.a, object.a)) {
                if (k.a(this.b, object.b)) {
                    if (k.a(this.c, object.c)) {
                        if (k.a(this.d, object.d)) {
                            if (k.a(this.e, object.e)) {
                                if (k.a(this.f, object.f)) {
                                    int i = 1;
                                }
                            }
                        }
                    }
                }
            }
            return z2;
        }

        public int hashCode() {
            Object[] arr = new Object[6];
            return k.b(new Object[] { this.a, this.b, this.c, this.d, this.e, this.f });
        }

        public String toString() {
            j.b bVar = j.c(this);
            bVar.d("timeoutNanos", this.a);
            bVar.d("waitForReady", this.b);
            bVar.d("maxInboundMessageSize", this.c);
            bVar.d("maxOutboundMessageSize", this.d);
            bVar.d("retryPolicy", this.e);
            bVar.d("hedgingPolicy", this.f);
            return bVar.toString();
        }
    }

    static final class c extends f0 {

        final j1 b;
        /* synthetic */ c(j1.a aVar) {
            this(j1Var);
        }

        @Override // io.grpc.f0
        public f0.b a(o0.f fVar) {
            f0.b.a aVar = f0.b.d();
            aVar.b(this.b);
            return aVar.a();
        }

        private c() {
            super();
            this.b = j1Var;
        }
    }
    j1(j1.b bVar, Map<String, j1.b> map, Map<String, j1.b> map2, z1.d0 d0Var, Object object, Map<String, ?> map3) {
        super();
        this.a = bVar;
        this.b = Collections.unmodifiableMap(new HashMap(map));
        this.c = Collections.unmodifiableMap(new HashMap(map2));
        this.d = d0Var;
        this.e = object;
        if (map3 != null) {
        }
    }

    static j1 a() {
        j1 j1Var = new j1(null, new HashMap(), new HashMap(), null, null, null);
        return j1Var;
    }

    static j1 b(Map<String, ?> map, boolean z, int i, int i2, Object object) {
        io.grpc.j1.j1.b bVar;
        io.grpc.j1.z1.d0 d0Var;
        boolean hasNext;
        String str;
        Map map2;
        Object obj;
        String str2;
        boolean z5 = true;
        boolean z22 = z;
        i = 0;
        d0Var = z22 ? d0Var : i;
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        final Map map3 = e2.b(map);
        List list2 = e2.m(map);
        if (list2 == null) {
            j1 j1Var = new j1(null, hashMap, hashMap2, d0Var, object, map3);
            return j1Var;
        }
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            bVar = new j1.b(item, z22, i, i2);
            List list = e2.o(item);
            map2 = map;
        }
        j1 j1Var2 = new j1(bVar, hashMap, hashMap2, d0Var, object, map3);
        return j1Var2;
    }

    f0 c() {
        final io.grpc.j1.j1.a aVar = null;
        if (this.c.isEmpty()) {
            if (this.b.isEmpty() && this.a == null) {
                return aVar;
            }
        }
        return new j1.c(this, aVar);
    }

    Map<String, ?> d() {
        return this.f;
    }

    Object e() {
        return this.e;
    }

    public boolean equals(Object object) {
        boolean z = true;
        boolean z2;
        io.grpc.j1.j1.b bVar;
        boolean z3;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object != null) {
            obj = j1.class;
            if (obj == object.getClass()) {
                if (k.a(this.a, object.a)) {
                    if (k.a(this.b, object.b)) {
                        if (k.a(this.c, object.c)) {
                            if (k.a(this.d, object.d)) {
                                if (!(k.a(this.e, object.e))) {
                                }
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    j1.b f(u0<?, ?> u0Var) {
        Object u0Var2;
        if ((j1.b)this.b.get(u0Var.c()) == null) {
        }
        if (this.b == null) {
        }
        return u0Var2;
    }

    z1.d0 g() {
        return this.d;
    }

    public int hashCode() {
        Object[] arr = new Object[5];
        return k.b(new Object[] { this.a, this.b, this.c, this.d, this.e });
    }

    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("defaultMethodConfig", this.a);
        bVar.d("serviceMethodMap", this.b);
        bVar.d("serviceMap", this.c);
        bVar.d("retryThrottling", this.d);
        bVar.d("loadBalancingConfig", this.e);
        return bVar.toString();
    }
}
