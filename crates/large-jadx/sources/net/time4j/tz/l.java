package net.time4j.tz;

import android.util.TimeUtils;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.time4j.f1.a;
import net.time4j.f1.d;
import net.time4j.f1.f;
import net.time4j.f1.g;

/* loaded from: classes3.dex */
public abstract class l implements Serializable {

    private static volatile boolean A;
    private static int B;
    private static final Map<String, net.time4j.tz.k> C;
    private static final Map<String, net.time4j.tz.k> D;
    private static final net.time4j.tz.r E;
    private static final net.time4j.tz.r F;
    private static final ConcurrentMap<String, net.time4j.tz.l.c> G;
    private static final ReferenceQueue<net.time4j.tz.l> H;
    private static final LinkedList<net.time4j.tz.l> I;
    private static final ConcurrentMap<String, net.time4j.tz.r> J;
    static final net.time4j.tz.s K;
    private static final net.time4j.tz.l L;
    private static final String a;
    private static final Comparator<net.time4j.tz.k> b;
    public static final net.time4j.tz.o c;
    public static final net.time4j.tz.o v;
    private static final boolean w;
    private static final boolean x = true;
    private static volatile net.time4j.tz.l.e y;
    private static volatile net.time4j.tz.l z;

    static class a implements Comparator<net.time4j.tz.k> {
        @Override // java.util.Comparator
        public int a(net.time4j.tz.k k, net.time4j.tz.k k2) {
            return k.a().compareTo(k2.a());
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((k)object, (k)object2);
        }
    }

    public static class b {
        public static void a() {
            boolean z;
            Object poll;
            Class<net.time4j.tz.l> obj = l.class;
            synchronized (obj) {
                while (l.l().poll() != null) {
                }
                try {
                    l.m().clear();
                    l.e eVar = new l.e();
                    l.n(eVar);
                    l.o().clear();
                    if (l.p()) {
                    }
                    l.q(l.f());
                    throw poll;
                }
            }
        }
    }

    private static class c extends SoftReference<net.time4j.tz.l> {

        private final String a;
        c(net.time4j.tz.l l, ReferenceQueue<net.time4j.tz.l> referenceQueue2) {
            super(l, referenceQueue2);
            this.a = l.z().a();
        }

        static String a(net.time4j.tz.l.c l$c) {
            return c.a;
        }
    }

    private static class e {

        private final List<net.time4j.tz.k> a;
        private final List<net.time4j.tz.k> b;
        e() {
            Object iterator2;
            net.time4j.tz.r next;
            Iterator iterator;
            net.time4j.tz.r contains;
            boolean contains2;
            super();
            int i = 1024;
            ArrayList arrayList = new ArrayList(i);
            ArrayList arrayList2 = new ArrayList(i);
            arrayList.add(p.C);
            Iterator iterator3 = l.g().entrySet().iterator();
            while (iterator3.hasNext()) {
                iterator2 = (Map.Entry)iterator3.next().getValue();
                if ((r)iterator2 == l.h() && l.i() != l.h()) {
                } else {
                }
                iterator = (r)iterator2.b().iterator();
                while (iterator.hasNext()) {
                    contains = l.j((String)iterator.next());
                    if (!arrayList.contains(contains)) {
                    }
                    arrayList.add(contains);
                }
                arrayList2.addAll(arrayList);
                iterator2 = iterator2.e().keySet().iterator();
                while (iterator2.hasNext()) {
                    iterator = l.j((String)iterator2.next());
                    if (!arrayList2.contains(iterator)) {
                    }
                    arrayList2.add(iterator);
                }
                iterator = l.j((String)iterator2.next());
                if (!arrayList2.contains(iterator)) {
                }
                arrayList2.add(iterator);
                contains = l.j((String)iterator.next());
                if (!arrayList.contains(contains)) {
                }
                arrayList.add(contains);
                if (l.i() != l.h()) {
                } else {
                }
            }
            Collections.sort(arrayList, l.k());
            Collections.sort(arrayList2, l.k());
            this.a = Collections.unmodifiableList(arrayList);
            this.b = Collections.unmodifiableList(arrayList2);
        }

        static List a(net.time4j.tz.l.e l$e) {
            return e.a;
        }

        static List b(net.time4j.tz.l.e l$e) {
            return e.b;
        }
    }

    private static class d implements net.time4j.tz.r, net.time4j.tz.s {
        d(net.time4j.tz.l.a l$a) {
            super();
        }

        @Override // net.time4j.tz.r
        public String a(String string, net.time4j.tz.d d2, Locale locale3) {
            Objects.requireNonNull(locale3, "Missing locale.");
            final String str2 = "";
            if (string.isEmpty()) {
                return str2;
            }
            TimeZone time = h.R(string);
            if (time.getID().equals(string)) {
                return time.getDisplayName(d2.isDaylightSaving(), obj5 ^= 1, locale3);
            }
            return str2;
        }

        public Set<String> b() {
            HashSet hashSet = new HashSet();
            hashSet.addAll(Arrays.asList(TimeZone.getAvailableIDs()));
            return hashSet;
        }

        @Override // net.time4j.tz.r
        public String c() {
            return "";
        }

        @Override // net.time4j.tz.r
        public net.time4j.tz.s d() {
            return this;
        }

        public Map<String, String> e() {
            return Collections.emptyMap();
        }

        public Set<String> f(Locale locale, boolean z2) {
            return Collections.emptySet();
        }

        @Override // net.time4j.tz.r
        public String g(boolean z, Locale locale2) {
            String obj1;
            obj1 = z ? "GMT" : "GMT±hh:mm";
            return obj1;
        }

        @Override // net.time4j.tz.r
        public String getLocation() {
            return "";
        }

        @Override // net.time4j.tz.r
        public String getName() {
            return "java.util.TimeZone";
        }

        @Override // net.time4j.tz.r
        public String getVersion() {
            return TimeUtils.getTimeZoneDatabaseVersion();
        }

        @Override // net.time4j.tz.r
        public net.time4j.tz.m h(String string) {
            return null;
        }
    }
    static {
        boolean equalsIgnoreCase;
        net.time4j.tz.j i3;
        boolean z;
        net.time4j.tz.p i;
        List list;
        int i2;
        boolean equals;
        net.time4j.tz.p enumConstants;
        boolean next3;
        int next;
        String length;
        String next2;
        String str2;
        String str;
        Class<net.time4j.tz.l> obj = l.class;
        System.getProperty("line.separator");
        l.a = System.getProperty("net.time4j.tz.repository.version");
        l.a aVar = new l.a();
        l.b = aVar;
        net.time4j.tz.g lATER_OFFSET = g.LATER_OFFSET;
        l.c = b.PUSH_FORWARD.and(lATER_OFFSET);
        l.v = b.ABORT.and(lATER_OFFSET);
        equalsIgnoreCase = "Dalvik".equalsIgnoreCase(System.getProperty("java.vm.name"));
        l.w = equalsIgnoreCase;
        i = 0;
        int i6 = 1;
        if (!equalsIgnoreCase && Boolean.getBoolean("net.time4j.allow.system.tz.override")) {
            if (!Boolean.getBoolean("net.time4j.allow.system.tz.override")) {
                int i4 = i;
            }
        }
        int i5 = i6;
        i3 = 0;
        l.y = i3;
        l.z = i3;
        l.A = i6;
        l.B = 11;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        l.G = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        l.J = concurrentHashMap2;
        ReferenceQueue referenceQueue = new ReferenceQueue();
        l.H = referenceQueue;
        LinkedList linkedList = new LinkedList();
        l.I = linkedList;
        list = l.L(l.class.getClassLoader(), /* result */);
        HashMap hashMap2 = new HashMap();
        enumConstants = p.C;
        String str12 = "Z";
        hashMap2.put(str12, enumConstants);
        hashMap2.put("UT", enumConstants);
        String str15 = "UTC";
        hashMap2.put(str15, enumConstants);
        hashMap2.put("GMT", enumConstants);
        hashMap2.put("UTC0", enumConstants);
        hashMap2.put("GMT0", enumConstants);
        Iterator iterator = list.iterator();
        for (Class next4 : iterator) {
            enumConstants = next4.getEnumConstants();
            next2 = i;
            while (next2 < enumConstants.length) {
                str2 = (k[])enumConstants[next2];
                hashMap2.put(str2.a(), str2);
                next2++;
            }
            str2 = enumConstants[next2];
            hashMap2.put(str2.a(), str2);
            next2++;
        }
        l.C = Collections.unmodifiableMap(hashMap2);
        HashMap hashMap = new HashMap();
        l.s(hashMap);
        l.D = Collections.unmodifiableMap(hashMap);
        Iterator iterator2 = d.c().g(r.class).iterator();
        i2 = i3;
        String str19 = "TZDB";
        while (iterator2.hasNext()) {
            next3 = iterator2.next();
            next2 = (r)next3.getName();
            if (next2.equals(str19) != null) {
            } else {
            }
            if (next2.isEmpty() == null && next2.equals("DEFAULT") == null) {
            }
            str19 = "TZDB";
            if (next2.equals("DEFAULT") == null) {
            }
            l.J.put(next2, next3);
            i2 = l.r(next3, i2);
        }
        Iterator iterator3 = d.c().g(s.class).iterator();
        next = i3;
        for (s next : iterator3) {
        }
        l.d dVar3 = new l.d(i3);
        l.E = dVar3;
        if (next == 0) {
            next = dVar3.d();
        }
        l.K = next;
        ConcurrentMap map = l.J;
        map.put("java.util.TimeZone", dVar3);
        if (i2 == 0) {
            l.F = dVar3;
        } else {
            map.put(str19, i2);
            l.F = i2;
        }
        String property3 = System.getProperty("user.timezone");
        if (!str12.equals(property3)) {
            if (str15.equals(property3)) {
                i3 = p.C.p();
            } else {
                if (property3 != null) {
                    i3 = l.F(l.P(property3), property3, i);
                }
            }
        } else {
        }
        if (i3 == null) {
            l.L = l.v();
        } else {
            l.L = i3;
        }
        if (l.x) {
            l.z = l.L;
        }
        l.e eVar = new l.e();
        l.y = eVar;
    }

    public static Set<net.time4j.tz.k> C(Locale locale, boolean z2, String string3) {
        boolean obj2;
        net.time4j.tz.s obj3;
        obj3 = l.D(string3);
        if (obj3 == null) {
            return Collections.emptySet();
        }
        if (obj3.d() == null) {
            obj3 = l.K;
        }
        HashSet hashSet = new HashSet();
        Iterator obj1 = obj3.f(locale, z2).iterator();
        for (String obj2 : obj1) {
            hashSet.add(l.P(obj2));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static net.time4j.tz.r D(String string) {
        ConcurrentMap equals;
        Object obj1;
        if (string.isEmpty()) {
        } else {
            if (string.equals("DEFAULT")) {
                obj1 = l.F;
            } else {
                obj1 = l.J.get(string);
            }
            return obj1;
        }
        obj1 = new IllegalArgumentException("Missing zone model provider.");
        throw obj1;
    }

    private static net.time4j.tz.l F(net.time4j.tz.k k, String string2, boolean z3) {
        String substring;
        Object hVar;
        Object obj;
        Object substring2;
        int cVar;
        int i3;
        int i2;
        Object rVar;
        int i4;
        char charAt;
        boolean equals;
        int i;
        Object obj9;
        Object obj10;
        net.time4j.tz.l.c obj11;
        ConcurrentMap map = l.G;
        obj = map.get(string2);
        final int i5 = 0;
        if ((l.c)obj != null) {
            if ((l)(l.c)obj.get() == null) {
                map.remove(l.c.a(obj));
            }
        } else {
            cVar = i5;
        }
        if (cVar != 0) {
            return cVar;
        }
        substring = "";
        i3 = 0;
        i2 = i3;
        i4 = 1;
        while (i2 < string2.length()) {
            i2++;
            i4 = 1;
        }
        substring2 = string2;
        if (substring2.isEmpty()) {
            if (z3 != null) {
            } else {
                return i5;
            }
            obj9 = new IllegalArgumentException("Timezone key is empty.");
            throw obj9;
        }
        rVar = l.F;
        if (!substring.isEmpty()) {
            if (substring.equals("DEFAULT")) {
                i3 = i4;
            }
        } else {
        }
        if (i3 == 0 && (r)l.J.get(substring) == null && z3 != null) {
            if ((r)l.J.get(substring) == null) {
                if (z3 != null) {
                    obj9 = substring.equals("TZDB") ? "TZDB provider not available: " : "Timezone model provider not registered: ";
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(obj9);
                    stringBuilder.append(string2);
                    obj11 = new IllegalArgumentException(stringBuilder.toString());
                    throw obj11;
                }
                return i5;
            }
        }
        if (k == null) {
            if (i3 != 0) {
                obj9 = l.P(substring2);
                if (obj9 instanceof p) {
                    return (p)obj9.p();
                }
            } else {
                obj9 = new e(string2);
            }
        }
        if (rVar == l.E) {
            hVar = new h(obj9, substring2);
            if (hVar.T() && !substring2.equals("GMT") && !substring2.startsWith("UT")) {
                if (!substring2.equals("GMT")) {
                    if (!substring2.startsWith("UT")) {
                        if (substring2.equals("Z")) {
                            cVar = hVar;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
            hVar = rVar.h(substring2);
            if (hVar == null) {
                cVar = l.H(rVar, obj9, substring2);
            } else {
                cVar = new c(obj9, hVar);
            }
        }
        if (cVar == 0 && z3 == null) {
            if (z3 == null) {
                return i5;
            }
            if (!TimeZone.getDefault().getID().equals(string2)) {
            } else {
                obj11 = new e(string2);
                obj9 = new h(obj11);
                return obj9;
            }
            obj11 = new StringBuilder();
            obj11.append("Unknown timezone: ");
            obj11.append(string2);
            obj9 = new IllegalArgumentException(obj11.toString());
            throw obj9;
        }
        if (l.A) {
            obj11 = new l.c(cVar, l.H);
            obj9 = l.G.putIfAbsent(string2, obj11);
            if ((l.c)obj9 == null) {
                obj10 = l.class;
                l.I.addFirst(cVar);
                synchronized (obj10) {
                    obj9 = l.I;
                    while (obj9.size() >= l.B) {
                        obj9.removeLast();
                        obj9 = l.I;
                    }
                }
            } else {
                obj9 = (l.c)obj9.get();
                if ((l)obj9 != null) {
                    cVar = obj9;
                }
            }
        }
        return cVar;
    }

    private static net.time4j.tz.l G(net.time4j.tz.k k, boolean z2) {
        if (k instanceof p) {
            return (p)k.p();
        }
        return l.F(k, k.a(), z2);
    }

    private static net.time4j.tz.l H(net.time4j.tz.r r, net.time4j.tz.k k2, String string3) {
        int i;
        Object str;
        int i2 = 0;
        str = string3;
        i = i2;
        while (i == 0) {
            str = r.e().get(str);
            if ((String)str != null) {
            }
            i = r.h((String)str);
        }
        String str2 = r.c();
        if (i == 0 && str2.isEmpty()) {
            str2 = r.c();
            if (str2.isEmpty()) {
                return i2;
            }
            if (str2.equals(r.getName())) {
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append("~");
                stringBuilder.append(string3);
                a obj4 = new a(k2, l.M(stringBuilder.toString()));
                return obj4;
            }
            StringBuilder obj6 = new StringBuilder();
            obj6.append("Circular zone model provider fallback: ");
            obj6.append(r.getName());
            IllegalArgumentException obj5 = new IllegalArgumentException(obj6.toString());
            throw obj5;
        }
        obj4 = new c(k2, i);
        return obj4;
    }

    private static List<Class<? extends net.time4j.tz.k>> L(java.lang.ClassLoader classLoader, String... string2Arr2) {
        int i;
        Class forName;
        boolean assignableFrom;
        String str;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < string2Arr2.length) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("net.time4j.tz.olson.");
            stringBuilder.append(string2Arr2[i]);
            forName = Class.forName(stringBuilder.toString(), true, classLoader);
            if (k.class.isAssignableFrom(forName)) {
            }
            i++;
            arrayList.add(forName);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static net.time4j.tz.l M(String string) {
        return l.F(0, string, true);
    }

    public static net.time4j.tz.l N(net.time4j.tz.k k) {
        return l.G(k, true);
    }

    public static net.time4j.tz.l O() {
        boolean z;
        if (l.x && l.z != null) {
            if (l.z != null) {
                return l.z;
            }
        }
        return l.L;
    }

    private static net.time4j.tz.k P(String string) {
        boolean stringBuilder;
        Object eVar;
        int i;
        Object obj2;
        if ((k)l.C.get(string) == null && string.startsWith("GMT")) {
            if (string.startsWith("GMT")) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("UTC");
                stringBuilder.append(string.substring(3));
                obj2 = stringBuilder.toString();
            }
            if (p.x(obj2, false) == null) {
                eVar = new e(obj2);
            }
        }
        return eVar;
    }

    static net.time4j.tz.l f() {
        return l.v();
    }

    static ConcurrentMap g() {
        return l.J;
    }

    static net.time4j.tz.r h() {
        return l.E;
    }

    static net.time4j.tz.r i() {
        return l.F;
    }

    static net.time4j.tz.k j(String string) {
        return l.P(string);
    }

    static Comparator k() {
        return l.b;
    }

    static ReferenceQueue l() {
        return l.H;
    }

    static LinkedList m() {
        return l.I;
    }

    static net.time4j.tz.l.e n(net.time4j.tz.l.e l$e) {
        l.y = e;
        return e;
    }

    static ConcurrentMap o() {
        return l.G;
    }

    static boolean p() {
        return l.x;
    }

    static net.time4j.tz.l q(net.time4j.tz.l l) {
        l.z = l;
        return l;
    }

    private static net.time4j.tz.r r(net.time4j.tz.r r, net.time4j.tz.r r2) {
        String compareTo;
        boolean compareTo2;
        boolean equals;
        Object obj3;
        compareTo = r.getVersion();
        if (!compareTo.isEmpty()) {
            compareTo2 = l.a;
            if (compareTo.equals(compareTo2)) {
            } else {
                if (compareTo2 == null) {
                    if (r2 != null) {
                        if (compareTo.compareTo(r2.getVersion()) > 0) {
                        } else {
                            if (compareTo.compareTo(r2.getVersion()) == 0 && !r.getLocation().contains("{java.home}")) {
                                if (!r.getLocation().contains("{java.home}")) {
                                } else {
                                    obj3 = r2;
                                }
                            } else {
                            }
                        }
                    }
                } else {
                }
            }
        } else {
        }
        return obj3;
    }

    private static void s(Map<String, net.time4j.tz.k> map) {
        net.time4j.tz.p pVar = p.C;
        map.put("Etc/GMT", pVar);
        map.put("Etc/Greenwich", pVar);
        map.put("Etc/Universal", pVar);
        map.put("Etc/Zulu", pVar);
        map.put("Etc/GMT+0", pVar);
        map.put("Etc/GMT-0", pVar);
        map.put("Etc/GMT0", pVar);
        map.put("Etc/UTC", pVar);
        map.put("Etc/UCT", pVar);
        map.put("Etc/GMT-14", p.u(50400));
        map.put("Etc/GMT-13", p.u(46800));
        map.put("Etc/GMT-12", p.u(43200));
        map.put("Etc/GMT-11", p.u(39600));
        map.put("Etc/GMT-10", p.u(36000));
        map.put("Etc/GMT-9", p.u(32400));
        map.put("Etc/GMT-8", p.u(28800));
        map.put("Etc/GMT-7", p.u(25200));
        map.put("Etc/GMT-6", p.u(21600));
        map.put("Etc/GMT-5", p.u(18000));
        map.put("Etc/GMT-4", p.u(14400));
        map.put("Etc/GMT-3", p.u(10800));
        map.put("Etc/GMT-2", p.u(7200));
        map.put("Etc/GMT-1", p.u(3600));
        map.put("Etc/GMT+1", p.u(-3600));
        map.put("Etc/GMT+2", p.u(-7200));
        map.put("Etc/GMT+3", p.u(-10800));
        map.put("Etc/GMT+4", p.u(-14400));
        map.put("Etc/GMT+5", p.u(-18000));
        map.put("Etc/GMT+6", p.u(-21600));
        map.put("Etc/GMT+7", p.u(-25200));
        map.put("Etc/GMT+8", p.u(-28800));
        map.put("Etc/GMT+9", p.u(-32400));
        map.put("Etc/GMT+10", p.u(-36000));
        map.put("Etc/GMT+11", p.u(-39600));
        map.put("Etc/GMT+12", p.u(-43200));
    }

    public static List<net.time4j.tz.k> t() {
        return l.e.a(l.y);
    }

    public static List<net.time4j.tz.k> u(String string) {
        net.time4j.tz.k kVar;
        if (string.equals("INCLUDE_ALIAS")) {
            return l.e.b(l.y);
        }
        net.time4j.tz.r obj2 = l.D(string);
        if (obj2 == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        obj2 = obj2.b().iterator();
        for (String next2 : obj2) {
            arrayList.add(l.P(next2));
        }
        Collections.sort(arrayList, l.b);
        return Collections.unmodifiableList(arrayList);
    }

    private static net.time4j.tz.l v() {
        net.time4j.tz.l hVar;
        int eVar;
        String iD = TimeZone.getDefault().getID();
        if (l.F(0, iD, false) == null) {
            eVar = new e(iD);
            hVar = new h(eVar);
        }
        return hVar;
    }

    public static String x(net.time4j.tz.k k, net.time4j.tz.d d2, Locale locale3) {
        String substring;
        Object rVar;
        net.time4j.tz.s sVar;
        String substring2;
        String str;
        boolean equals;
        boolean empty;
        String obj4;
        net.time4j.tz.d obj5;
        obj4 = k.a();
        int indexOf = obj4.indexOf(126);
        rVar = l.F;
        if (indexOf >= 0) {
            substring2 = obj4.substring(0, indexOf);
            if (!substring2.equals("DEFAULT") && (r)l.J.get(substring2) == null) {
                if ((r)l.J.get(substring2) == null) {
                    return obj4;
                }
            }
            substring = obj4.substring(indexOf++);
        } else {
            substring = obj4;
        }
        if (rVar.d() == null) {
            sVar = l.K;
        }
        empty = l.K;
        if (sVar.a(substring, d2, locale3).isEmpty() && sVar != empty) {
            empty = l.K;
            if (sVar != empty) {
                str = empty.a(substring, d2, locale3);
            }
            if (str.isEmpty()) {
            } else {
                obj4 = str;
            }
            str = obj4;
        }
        return str;
    }

    @Override // java.io.Serializable
    public abstract net.time4j.tz.p A(a a, g g2);

    @Override // java.io.Serializable
    public abstract net.time4j.tz.p B(f f);

    @Override // java.io.Serializable
    public abstract net.time4j.tz.o E();

    @Override // java.io.Serializable
    public abstract boolean I(f f);

    @Override // java.io.Serializable
    public abstract boolean J();

    @Override // java.io.Serializable
    public abstract boolean K(a a, g g2);

    @Override // java.io.Serializable
    public abstract net.time4j.tz.l Q(net.time4j.tz.o o);

    @Override // java.io.Serializable
    public String w(net.time4j.tz.d d, Locale locale2) {
        return l.x(z(), d, locale2);
    }

    @Override // java.io.Serializable
    public abstract net.time4j.tz.m y();

    @Override // java.io.Serializable
    public abstract net.time4j.tz.k z();
}
