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

/* compiled from: ServiceConfigUtil.java */
/* loaded from: classes3.dex */
public final class e2 {

    public static final class a {

        private final String a;
        private final Map<String, ?> b;
        public a(String str, Map<String, ?> map) {
            super();
            n.p(str, "policyName");
            this.a = str;
            n.p(map, "rawConfigValue");
            this.b = map;
        }

        public String a() {
            return this.a;
        }

        public Map<String, ?> b() {
            return this.b;
        }

        public boolean equals(Object object) {
            boolean z = false;
            equals = object instanceof e2.a;
            int i = 0;
            if (object instanceof e2.a) {
                if (this.a.equals(object.a)) {
                    if (this.b.equals(object.b)) {
                        int i2 = 1;
                    }
                }
            }
            return z;
        }

        public int hashCode() {
            Object[] arr = new Object[2];
            return k.b(new Object[] { this.a, this.b });
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
        public b(p0 p0Var, Object object) {
            super();
            n.p(p0Var, "provider");
            this.a = p0Var;
            this.b = object;
        }

        public boolean equals(Object object) {
            boolean z = true;
            boolean z2;
            boolean z3;
            z = true;
            if (this == object) {
                return true;
            }
            final int i = 0;
            if (object != null) {
                obj = e2.b.class;
                if (obj == object.getClass()) {
                    if (k.a(this.a, object.a)) {
                        if (!(k.a(this.b, object.b))) {
                        }
                    }
                }
                return z;
            }
            return false;
        }

        public int hashCode() {
            Object[] arr = new Object[2];
            return k.b(new Object[] { this.a, this.b });
        }

        public String toString() {
            j.b bVar = j.c(this);
            bVar.d("provider", this.a);
            bVar.d("config", this.b);
            return bVar.toString();
        }
    }
    private e2() {
        super();
    }

    public static List<e2.a> A(List<Map<String, ?>> list) {
        if (list == null) {
            return null;
        }
        final ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(e2.z((Map)it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    static Double a(Map<String, ?> map) {
        return b1.h(map, "backoffMultiplier");
    }

    public static Map<String, ?> b(Map<String, ?> map) {
        if (map == null) {
            return null;
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

    private static Set<d1.b> f(Map<String, ?> map, String str) {
        List list = b1.e(map, str);
        if (list == null) {
            return null;
        }
        return e2.u(list);
    }

    public static List<Map<String, ?>> g(Map<String, ?> map) {
        final ArrayList arrayList = new ArrayList();
        str = "loadBalancingConfig";
        if (map.containsKey(str)) {
            arrayList.addAll(b1.f(map, str));
        }
        if (arrayList.isEmpty()) {
            String str2 = b1.k(map, "loadBalancingPolicy");
            if (str2 != null) {
                arrayList.add(Collections.singletonMap(str2.toLowerCase(Locale.ROOT), Collections.emptyMap()));
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
        Set set = e2.f(map, str);
        if (set == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(d1.b.class));
        }
        v.a(!set.contains(d1.b.OK), "%s must not contain OK", str);
        return set;
    }

    static Long q(Map<String, ?> map) {
        return b1.l(map, "perAttemptRecvTimeout");
    }

    static Map<String, ?> r(Map<String, ?> map) {
        return b1.j(map, "retryPolicy");
    }

    static Set<d1.b> s(Map<String, ?> map) {
        boolean z = false;
        final String str = "retryableStatusCodes";
        final Set set = e2.f(map, str);
        int i = 1;
        int r2 = set != null ? i : 0;
        v.a((set != null ? i : 0), "%s is required in retry policy", str);
        v.a(i ^ (set != null ? i : 0), (set != null ? i : 0), str);
        return set;
    }

    static String t(Map<String, ?> map) {
        return b1.k(map, "service");
    }

    private static Set<d1.b> u(List<?> list) throws VerifyException {
        String str;
        d1.b str2;
        int value;
        boolean z4;
        boolean z;
        int i2;
        String str3;
        EnumSet noneOf = EnumSet.noneOf(d1.b.class);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return Collections.unmodifiableSet(noneOf);
    }

    static z1.d0 v(Map<String, ?> map) {
        boolean z;
        boolean z2 = true;
        int i3 = 0;
        if (map == null) {
            return null;
        }
        Map map2 = b1.j(map, "retryThrottling");
        if (map2 == null) {
            return i3;
        }
        float value = b1.h(map2, "maxTokens").floatValue();
        float value2 = b1.h(map2, "tokenRatio").floatValue();
        float f = 0.0f;
        final int i = 0;
        int r2 = value > 0.0f ? 1 : i;
        n.v((value > 0.0f ? 1 : i), "maxToken should be greater than zero");
        if (value2 <= 0.0f) {
        }
        n.v(z2, "tokenRatio should be greater than zero");
        return new z1.d0(value, value2);
    }

    static Long w(Map<String, ?> map) {
        return b1.l(map, "timeout");
    }

    static Boolean x(Map<String, ?> map) {
        return b1.d(map, "waitForReady");
    }

    public static v0.c y(List<e2.a> list, q0 q0Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            String str = item.a();
            p0 p0Var = q0Var.d(str);
            if (p0Var != null) {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "None of ";
        String str2 = " specified by Service Config are available.";
        str4 = str3 + arrayList + str2;
        return v0.c.b(d1.h.r(str4));
    }

    public static e2.a z(Map<String, ?> map) {
        if (map.size() != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "There are ";
            int size2 = map.size();
            String str2 = " fields in a LoadBalancingConfig object. Exactly one is expected. Config=";
            map = str + size2 + str2 + map;
            throw new RuntimeException(map);
        } else {
            Object key = (Map.Entry)map.entrySet().iterator().next().getKey();
            return new e2.a(key, b1.j(map, key));
        }
    }
}
