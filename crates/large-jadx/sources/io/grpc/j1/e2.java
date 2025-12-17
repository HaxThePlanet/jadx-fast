package io.grpc.j1;

import com.google.common.base.VerifyException;
import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.k;
import com.google.common.base.n;
import com.google.common.base.v;
import io.grpc.d1;
import io.grpc.d1.b;
import io.grpc.p0;
import io.grpc.q0;
import io.grpc.v0.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class e2 {

    public static final class a {

        private final String a;
        private final Map<String, ?> b;
        public a(String string, Map<String, ?> map2) {
            super();
            n.p(string, "policyName");
            this.a = (String)string;
            n.p(map2, "rawConfigValue");
            this.b = (Map)map2;
        }

        public String a() {
            return this.a;
        }

        public Map<String, ?> b() {
            return this.b;
        }

        public boolean equals(Object object) {
            boolean equals;
            int i;
            String str;
            Object obj4;
            i = 0;
            if (object instanceof e2.a && this.a.equals(object.a) && this.b.equals(object.b)) {
                if (this.a.equals(object.a)) {
                    if (this.b.equals(object.b)) {
                        i = 1;
                    }
                }
            }
            return i;
        }

        public int hashCode() {
            Object[] arr = new Object[2];
            return k.b(this.a, this.b);
        }

        public String toString() {
            j.b bVar = j.c(this);
            bVar.d("policyName", this.a);
            bVar.d("rawConfigValue", this.b);
            return bVar.toString();
        }
    }

    public static final class b {

        final p0 a;
        final Object b;
        public b(p0 p0, Object object2) {
            super();
            n.p(p0, "provider");
            this.a = (p0)p0;
            this.b = object2;
        }

        public boolean equals(Object object) {
            int i;
            Object z;
            Class<io.grpc.j1.e2.b> obj;
            Class class;
            boolean obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (e2.b.class != object.getClass()) {
                } else {
                    if (k.a(this.a, object.a) && k.a(this.b, object.b)) {
                        if (k.a(this.b, object.b)) {
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
            Object[] arr = new Object[2];
            return k.b(this.a, this.b);
        }

        public String toString() {
            j.b bVar = j.c(this);
            bVar.d("provider", this.a);
            bVar.d("config", this.b);
            return bVar.toString();
        }
    }
    public static List<io.grpc.j1.e2.a> A(List<Map<String, ?>> list) {
        io.grpc.j1.e2.a aVar;
        if (list == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        Iterator obj2 = list.iterator();
        for (Map next2 : obj2) {
            arrayList.add(e2.z(next2));
        }
        return Collections.unmodifiableList(arrayList);
    }

    static Double a(Map<String, ?> map) {
        return b1.h(map, "backoffMultiplier");
    }

    public static Map<String, ?> b(Map<String, ?> map) {
        if (map == null) {
            return 0;
        }
        return b1.j(map, "healthCheckConfig");
    }

    static Long c(Map<String, ?> map) {
        return b1.l(map, "hedgingDelay");
    }

    static Map<String, ?> d(Map<String, ?> map) {
        return b1.j(map, "hedgingPolicy");
    }

    static Long e(Map<String, ?> map) {
        return b1.l(map, "initialBackoff");
    }

    private static Set<d1.b> f(Map<String, ?> map, String string2) {
        List obj0 = b1.e(map, string2);
        if (obj0 == null) {
            return 0;
        }
        return e2.u(obj0);
    }

    public static List<Map<String, ?>> g(Map<String, ?> map) {
        Object str;
        boolean emptyMap;
        Object obj3;
        ArrayList arrayList = new ArrayList();
        str = "loadBalancingConfig";
        if (map.containsKey(str)) {
            arrayList.addAll(b1.f(map, str));
        }
        obj3 = b1.k(map, "loadBalancingPolicy");
        if (arrayList.isEmpty() && obj3 != null) {
            obj3 = b1.k(map, "loadBalancingPolicy");
            if (obj3 != null) {
                arrayList.add(Collections.singletonMap(obj3.toLowerCase(Locale.ROOT), Collections.emptyMap()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    static Integer h(Map<String, ?> map) {
        return b1.i(map, "maxAttempts");
    }

    static Integer i(Map<String, ?> map) {
        return b1.i(map, "maxAttempts");
    }

    static Long j(Map<String, ?> map) {
        return b1.l(map, "maxBackoff");
    }

    static Integer k(Map<String, ?> map) {
        return b1.i(map, "maxRequestMessageBytes");
    }

    static Integer l(Map<String, ?> map) {
        return b1.i(map, "maxResponseMessageBytes");
    }

    static List<Map<String, ?>> m(Map<String, ?> map) {
        return b1.f(map, "methodConfig");
    }

    static String n(Map<String, ?> map) {
        return b1.k(map, "method");
    }

    static List<Map<String, ?>> o(Map<String, ?> map) {
        return b1.f(map, "name");
    }

    static Set<d1.b> p(Map<String, ?> map) {
        final String str = "nonFatalStatusCodes";
        Set obj3 = e2.f(map, str);
        if (obj3 == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(d1.b.class));
        }
        v.a(contains ^= 1, "%s must not contain OK", str);
        return obj3;
    }

    static Long q(Map<String, ?> map) {
        return b1.l(map, "perAttemptRecvTimeout");
    }

    static Map<String, ?> r(Map<String, ?> map) {
        return b1.j(map, "retryPolicy");
    }

    static Set<d1.b> s(Map<String, ?> map) {
        int i;
        final String str = "retryableStatusCodes";
        final Set obj4 = e2.f(map, str);
        int i2 = 1;
        i = obj4 != null ? i2 : 0;
        v.a(i, "%s is required in retry policy", str);
        v.a(i2 ^= contains, "%s must not contain OK", str);
        return obj4;
    }

    static String t(Map<String, ?> map) {
        return b1.k(map, "service");
    }

    private static Set<d1.b> u(List<?> list) {
        Object string;
        Object stringBuilder;
        Object valueOf;
        int value;
        int i;
        int i2;
        int i3;
        String str;
        EnumSet noneOf = EnumSet.noneOf(d1.b.class);
        Iterator obj8 = list.iterator();
        for (Object string : obj8) {
            valueOf = d1.b.valueOf((String)string);
            noneOf.add(valueOf);
            Object obj2 = string;
            int intValue2 = (Double)obj2.intValue();
            i3 = 0;
            if (Double.compare(d, doubleValue) == 0) {
            } else {
            }
            i = i3;
            v.a(i, "Status code %s is not integral", string);
            if (d1.i(intValue2).n().value() == obj2.intValue()) {
            } else {
            }
            i2 = i3;
            v.a(i2, "Status code %s is not valid", string);
            i = i2;
        }
        return Collections.unmodifiableSet(noneOf);
    }

    static io.grpc.j1.z1.d0 v(Map<String, ?> map) {
        int i2;
        int i;
        int i3 = 0;
        if (map == null) {
            return i3;
        }
        Map obj6 = b1.j(map, "retryThrottling");
        if (obj6 == null) {
            return i3;
        }
        float floatValue = b1.h(obj6, "maxTokens").floatValue();
        obj6 = b1.h(obj6, "tokenRatio").floatValue();
        int i4 = 0;
        final int i5 = 0;
        i2 = Float.compare(floatValue, i4) > 0 ? i : i5;
        n.v(i2, "maxToken should be greater than zero");
        if (Float.compare(obj6, i4) > 0) {
        } else {
            i = i5;
        }
        n.v(i, "tokenRatio should be greater than zero");
        z1.d0 d0Var = new z1.d0(floatValue, obj6);
        return d0Var;
    }

    static Long w(Map<String, ?> map) {
        return b1.l(map, "timeout");
    }

    static Boolean x(Map<String, ?> map) {
        return b1.d(map, "waitForReady");
    }

    public static v0.c y(List<io.grpc.j1.e2.a> list, q0 q02) {
        Object next;
        String str;
        p0 p0Var;
        boolean obj4;
        Level obj5;
        ArrayList arrayList = new ArrayList();
        obj4 = list.iterator();
        for (e2.a next : obj4) {
            str = next.a();
            p0Var = q02.d(str);
            arrayList.add(str);
        }
        obj5 = new StringBuilder();
        obj5.append("None of ");
        obj5.append(arrayList);
        obj5.append(" specified by Service Config are available.");
        return v0.c.b(d1.h.r(obj5.toString()));
    }

    public static io.grpc.j1.e2.a z(Map<String, ?> map) {
        if (map.size() != 1) {
        } else {
            Object key = (Map.Entry)map.entrySet().iterator().next().getKey();
            e2.a aVar = new e2.a(key, b1.j(map, (String)key));
            return aVar;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("There are ");
        stringBuilder.append(map.size());
        stringBuilder.append(" fields in a LoadBalancingConfig object. Exactly one is expected. Config=");
        stringBuilder.append(map);
        RuntimeException runtimeException = new RuntimeException(stringBuilder.toString());
        throw runtimeException;
    }
}
