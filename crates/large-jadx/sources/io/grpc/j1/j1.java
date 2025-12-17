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

/* loaded from: classes3.dex */
final class j1 {

    private final io.grpc.j1.j1.b a;
    private final Map<String, io.grpc.j1.j1.b> b;
    private final Map<String, io.grpc.j1.j1.b> c;
    private final io.grpc.j1.z1.d0 d;
    private final Object e;
    private final Map<String, ?> f = null;

    static class a {
    }

    static final class b {

        static final d.a<io.grpc.j1.j1.b> g;
        final Long a;
        final Boolean b;
        final Integer c;
        final Integer d;
        final io.grpc.j1.a2 e;
        final io.grpc.j1.t0 f;
        static {
            j1.b.g = d.a.b("io.grpc.internal.ManagedChannelServiceConfig.MethodInfo");
        }

        b(Map<String, ?> map, boolean z2, int i3, int i4) {
            int i2;
            int i;
            Map map2;
            int str;
            int intValue;
            String str2;
            Map obj6;
            int obj8;
            super();
            this.a = e2.w(map);
            this.b = e2.x(map);
            Integer num2 = e2.l(map);
            this.c = num2;
            str = 0;
            if (num2 != null) {
                intValue = num2.intValue() >= 0 ? i : str;
                n.k(intValue, "maxInboundMessageSize %s exceeds bounds", num2);
            }
            Integer num3 = e2.k(map);
            this.d = num3;
            if (num3 != null) {
                if (num3.intValue() >= 0) {
                } else {
                    i = str;
                }
                n.k(i, "maxOutboundMessageSize %s exceeds bounds", num3);
            }
            i2 = 0;
            if (z2) {
                map2 = e2.r(map);
            } else {
                map2 = i2;
            }
            if (map2 == null) {
                obj8 = i2;
            } else {
                obj8 = j1.b.b(map2, i3);
            }
            this.e = obj8;
            if (z2) {
                obj6 = e2.d(map);
            } else {
                obj6 = i2;
            }
            if (obj6 == null) {
            } else {
                i2 = j1.b.a(obj6, i4);
            }
            this.f = i2;
        }

        private static io.grpc.j1.t0 a(Map<String, ?> map, int i2) {
            int i;
            int i3;
            Integer num = e2.h(map);
            n.p(num, "maxAttempts cannot be empty");
            int intValue = (Integer)num.intValue();
            final int i4 = 0;
            i3 = intValue >= 2 ? i : i4;
            final String str4 = "maxAttempts must be greater than 1: %s";
            n.h(i3, str4, intValue);
            Long num2 = e2.c(map);
            n.p(num2, "hedgingDelay cannot be empty");
            long longValue = (Long)num2.longValue();
            if (Long.compare(longValue, i6) >= 0) {
            } else {
                i = i4;
            }
            n.j(i, "hedgingDelay must not be negative: %s", longValue);
            t0 t0Var = new t0(Math.min(intValue, i2), longValue, str4, e2.p(map));
            return t0Var;
        }

        private static io.grpc.j1.a2 b(Map<String, ?> map, int i2) {
            int i4;
            int i3;
            int i5;
            int i;
            int i6;
            int empty;
            Double valueOf;
            long longValue;
            Integer num = e2.i(map);
            n.p(num, "maxAttempts cannot be empty");
            int intValue = (Integer)num.intValue();
            i = 1;
            int i7 = 0;
            i6 = intValue >= 2 ? i : i7;
            n.h(i6, "maxAttempts must be greater than 1: %s", intValue);
            Long num2 = e2.e(map);
            n.p(num2, "initialBackoff cannot be empty");
            final long longValue2 = (Long)num2.longValue();
            int i11 = 0;
            i4 = Long.compare(longValue2, i11) > 0 ? i : i7;
            n.j(i4, "initialBackoffNanos must be greater than 0: %s", longValue2);
            Long num3 = e2.j(map);
            n.p(num3, "maxBackoff cannot be empty");
            long longValue3 = (Long)num3.longValue();
            i3 = Long.compare(longValue3, i11) > 0 ? i : i7;
            n.j(i3, "maxBackoff must be greater than 0: %s", longValue3);
            Double num4 = e2.a(map);
            n.p(num4, "backoffMultiplier cannot be empty");
            double doubleValue = (Double)num4.doubleValue();
            i5 = Double.compare(doubleValue, i12) > 0 ? i : i7;
            n.k(i5, "backoffMultiplier must be greater than 0: %s", Double.valueOf(doubleValue));
            Long num5 = e2.q(map);
            if (num5 != null) {
                if (Long.compare(longValue, i11) >= 0) {
                    empty = i;
                } else {
                    empty = i7;
                }
            } else {
            }
            n.k(empty, "perAttemptRecvTimeout cannot be negative: %s", num5);
            Set set2 = e2.s(map);
            if (num5 == null) {
                if (!set2.isEmpty()) {
                } else {
                    i = i7;
                }
            }
            n.e(i, "retryableStatusCodes cannot be empty without perAttemptRecvTimeout");
            super(Math.min(intValue, i2), longValue2, obj6, longValue3, obj8, doubleValue, obj10, num5, set2);
            return a2Var;
        }

        public boolean equals(Object object) {
            boolean z;
            int i;
            Object num;
            Object obj4;
            if (!object instanceof j1.b) {
                return 0;
            }
            if (k.a(this.a, object.a) && k.a(this.b, object.b) && k.a(this.c, object.c) && k.a(this.d, object.d) && k.a(this.e, object.e) && k.a(this.f, object.f)) {
                if (k.a(this.b, object.b)) {
                    if (k.a(this.c, object.c)) {
                        if (k.a(this.d, object.d)) {
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
            return k.b(this.a, this.b, this.c, this.d, this.e, this.f);
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

        final io.grpc.j1.j1 b;
        private c(io.grpc.j1.j1 j1) {
            super();
            this.b = j1;
        }

        c(io.grpc.j1.j1 j1, io.grpc.j1.j1.a j1$a2) {
            super(j1);
        }

        @Override // io.grpc.f0
        public f0.b a(o0.f o0$f) {
            f0.b.a obj2 = f0.b.d();
            obj2.b(this.b);
            return obj2.a();
        }
    }
    j1(io.grpc.j1.j1.b j1$b, Map<String, io.grpc.j1.j1.b> map2, Map<String, io.grpc.j1.j1.b> map3, io.grpc.j1.z1.d0 z1$d04, Object object5, Map<String, ?> map6) {
        super();
        this.a = b;
        HashMap obj1 = new HashMap(map2);
        this.b = Collections.unmodifiableMap(obj1);
        obj1 = new HashMap(map3);
        this.c = Collections.unmodifiableMap(obj1);
        this.d = d04;
        this.e = object5;
        if (map6 != null) {
            obj1 = new HashMap(map6);
            obj1 = Collections.unmodifiableMap(obj1);
        }
        obj1 = 0;
    }

    static io.grpc.j1.j1 a() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        super(0, hashMap, hashMap2, 0, 0, 0);
        return j1Var2;
    }

    static io.grpc.j1.j1 b(Map<String, ?> map, boolean z2, int i3, int i4, Object object5) {
        int iterator;
        io.grpc.j1.z1.d0 d0Var;
        io.grpc.j1.j1.b bVar;
        int i2;
        io.grpc.j1.z1.d0 d0Var2;
        int i5;
        int i;
        boolean empty;
        String str;
        Map map2;
        String str2;
        boolean z;
        boolean z3 = z2;
        iterator = 0;
        if (z3) {
            d0Var2 = d0Var;
        } else {
            d0Var2 = iterator;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        final Map map3 = e2.b(map);
        List list = e2.m(map);
        if (list == null) {
            super(0, hashMap, hashMap2, d0Var2, object5, map3);
            return j1Var;
        }
        Iterator iterator2 = list.iterator();
        i2 = iterator;
        while (iterator2.hasNext()) {
            Object next2 = iterator2.next();
            bVar = new j1.b((Map)next2, z3, i3, i4);
            iterator = e2.o(next2);
            if (iterator != null) {
            }
            map2 = map;
            if (iterator.isEmpty()) {
            } else {
            }
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                Object next3 = iterator.next();
                str = e2.t((Map)next3);
                empty = e2.n(next3);
                str2 = 1;
                if (r.b(str)) {
                } else {
                }
                map2 = map;
                if (r.b(empty)) {
                } else {
                }
                empty = u0.b(str, empty);
                n.k(key2 ^= str2, "Duplicate method name %s", empty);
                hashMap.put(empty, bVar);
                n.k(key ^= str2, "Duplicate service %s", str);
                hashMap2.put(str, bVar);
                n.k(r.b(empty), "missing service name for method %s", empty);
                if (i2 == 0) {
                } else {
                }
                str2 = 0;
                n.k(str2, "Duplicate default method config in service config %s", map);
                i2 = bVar;
            }
            next3 = iterator.next();
            str = e2.t((Map)next3);
            empty = e2.n(next3);
            str2 = 1;
            if (r.b(str)) {
            } else {
            }
            map2 = map;
            if (r.b(empty)) {
            } else {
            }
            empty = u0.b(str, empty);
            n.k(key2 ^= str2, "Duplicate method name %s", empty);
            hashMap.put(empty, bVar);
            n.k(key ^= str2, "Duplicate service %s", str);
            hashMap2.put(str, bVar);
            n.k(r.b(empty), "missing service name for method %s", empty);
            if (i2 == 0) {
            } else {
            }
            str2 = 0;
            n.k(str2, "Duplicate default method config in service config %s", map);
            i2 = bVar;
        }
        super(i2, hashMap, hashMap2, d0Var2, object5, map3);
        return j1Var2;
    }

    f0 c() {
        boolean empty;
        final int i = 0;
        if (this.c.isEmpty() && this.b.isEmpty() && this.a == null) {
            if (this.b.isEmpty()) {
                if (this.a == null) {
                    return i;
                }
            }
        }
        j1.c cVar = new j1.c(this, i);
        return cVar;
    }

    Map<String, ?> d() {
        return this.f;
    }

    Object e() {
        return this.e;
    }

    public boolean equals(Object object) {
        int i;
        boolean z;
        Class<io.grpc.j1.j1> obj;
        Object bVar;
        Class class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (j1.class != object.getClass()) {
            } else {
                if (k.a(this.a, object.a) && k.a(this.b, object.b) && k.a(this.c, object.c) && k.a(this.d, object.d) && k.a(this.e, object.e)) {
                    if (k.a(this.b, object.b)) {
                        if (k.a(this.c, object.c)) {
                            if (k.a(this.d, object.d)) {
                                if (k.a(this.e, object.e)) {
                                } else {
                                    i = i2;
                                }
                            } else {
                            }
                        } else {
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

    io.grpc.j1.j1.b f(u0<?, ?> u0) {
        Object obj;
        Object obj3;
        if ((j1.b)this.b.get(u0.c()) == null) {
            obj = obj3;
        }
        if (obj == null) {
            obj = this.a;
        }
        return obj;
    }

    io.grpc.j1.z1.d0 g() {
        return this.d;
    }

    public int hashCode() {
        Object[] arr = new Object[5];
        return k.b(this.a, this.b, this.c, this.d, this.e);
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
