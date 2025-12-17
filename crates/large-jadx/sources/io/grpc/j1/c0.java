package io.grpc.j1;

import com.google.common.base.VerifyException;
import com.google.common.base.n;
import com.google.common.base.q;
import com.google.common.base.t;
import com.google.common.base.v;
import io.grpc.a;
import io.grpc.a1;
import io.grpc.d1;
import io.grpc.f1;
import io.grpc.v0;
import io.grpc.v0.b;
import io.grpc.v0.c;
import io.grpc.v0.e;
import io.grpc.v0.g;
import io.grpc.v0.g.a;
import io.grpc.v0.h;
import io.grpc.y;
import java.lang.reflect.Constructor;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public class c0 extends v0 {

    private static final io.grpc.j1.c0.g A;
    private static String B;
    private static final Logger s;
    private static final Set<String> t;
    private static final String u;
    private static final String v;
    private static final String w;
    static boolean x;
    static boolean y;
    protected static boolean z;
    final a1 a;
    private final Random b;
    protected volatile io.grpc.j1.c0.b c;
    private final AtomicReference<io.grpc.j1.c0.f> d;
    private final String e;
    private final String f;
    private final int g;
    private final io.grpc.j1.f2.d<Executor> h;
    private final long i;
    private final f1 j;
    private final q k;
    protected boolean l;
    private boolean m;
    private Executor n;
    private final boolean o = false;
    private final v0.h p;
    private boolean q;
    private v0.e r;

    static class a {
    }

    public interface b {
        public abstract List<InetAddress> resolveAddress(String string);
    }

    protected static final class c {

        private d1 a;
        private List<y> b;
        private v0.c c;
        public a d;
        c(io.grpc.j1.c0.a c0$a) {
            super();
        }

        static List a(io.grpc.j1.c0.c c0$c) {
            return c.b;
        }

        static List b(io.grpc.j1.c0.c c0$c, List list2) {
            c.b = list2;
            return list2;
        }

        static d1 c(io.grpc.j1.c0.c c0$c) {
            return c.a;
        }

        static d1 d(io.grpc.j1.c0.c c0$c, d1 d12) {
            c.a = d12;
            return d12;
        }

        static v0.c e(io.grpc.j1.c0.c c0$c) {
            return c.c;
        }

        static v0.c f(io.grpc.j1.c0.c c0$c, v0.c v0$c2) {
            c.c = c2;
            return c2;
        }
    }

    private final class e implements Runnable {

        private final v0.e a;
        final io.grpc.j1.c0 b;
        e(io.grpc.j1.c0 c0, v0.e v0$e2) {
            this.b = c0;
            super();
            n.p(e2, "savedListener");
            this.a = (v0.e)e2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean loggable;
            Object i;
            f1 f1Var;
            Throwable aVar;
            boolean loggable2;
            List list;
            v0.c cVar2;
            Object singletonList;
            io.grpc.j1.c0.e.a aVar3;
            boolean string;
            int i2;
            String aVar2;
            v0.e eVar;
            v0.g gVar;
            d1 d1Var;
            v0.g.a aVar4;
            Logger string2;
            String str;
            Level fINER = Level.FINER;
            if (c0.g().isLoggable(fINER)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Attempting DNS resolution of ");
                stringBuilder.append(c0.h(this.b));
                c0.g().finer(stringBuilder.toString());
            }
            i = 0;
            i2 = 1;
            int i3 = 0;
            y yVar = c0.i(this.b);
            aVar4 = v0.g.d();
            if (yVar != null) {
                if (c0.g().isLoggable(fINER)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Using proxy address ");
                    stringBuilder2.append(yVar);
                    c0.g().finer(stringBuilder2.toString());
                }
                aVar4.b(Collections.singletonList(yVar));
            } else {
                i = this.b.o(i3);
                if (c0.c.c(i) != null) {
                    this.a.a(c0.c.c(i));
                    if (i != null && c0.c.c(i) == null) {
                        if (c0.c.c(i) == null) {
                        } else {
                            i2 = i3;
                        }
                    } else {
                    }
                    c0.e.a aVar5 = new c0.e.a(this, i2);
                    c0.f(this.b).execute(aVar5);
                }
                if (c0.c.a(i) != null) {
                    aVar4.b(c0.c.a(i));
                }
                if (c0.c.e(i) != null) {
                    aVar4.d(c0.c.e(i));
                }
                singletonList = i.d;
                if (singletonList != null) {
                    aVar4.c(singletonList);
                }
            }
            this.a.c(aVar4.a());
            if (i != 0 && c0.c.c(i) == null) {
                if (c0.c.c(i) == null) {
                } else {
                    i2 = i3;
                }
            } else {
            }
            f1Var = c0.f(this.b);
            aVar3 = new c0.e.a(this, i2);
            f1Var.execute(aVar3);
        }
    }

    public interface f {
        public abstract List<String> a(String string);
    }

    interface g {
        public abstract io.grpc.j1.c0.f a();

        public abstract Throwable b();
    }

    private static enum d implements io.grpc.j1.c0.b {

        INSTANCE;
        public List<InetAddress> resolveAddress(String string) {
            return Collections.unmodifiableList(Arrays.asList(InetAddress.getAllByName(string)));
        }
    }
    static {
        Class<io.grpc.j1.c0> obj = c0.class;
        c0.s = Logger.getLogger(obj.getName());
        HashSet hashSet = new HashSet(Arrays.asList(/* result */));
        c0.t = Collections.unmodifiableSet(hashSet);
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        c0.u = property;
        String str6 = "false";
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", str6);
        c0.v = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", str6);
        c0.w = property3;
        c0.x = Boolean.parseBoolean(property);
        c0.y = Boolean.parseBoolean(property2);
        c0.z = Boolean.parseBoolean(property3);
        c0.A = c0.v(obj.getClassLoader());
    }

    protected c0(String string, String string2, v0.b v0$b3, io.grpc.j1.f2.d<Executor> f2$d4, q q5, boolean z6) {
        int obj4;
        int obj7;
        super();
        obj4 = new Random();
        this.b = obj4;
        this.c = c0.d.INSTANCE;
        obj4 = new AtomicReference();
        this.d = obj4;
        n.p(b3, "args");
        this.h = d4;
        obj4 = new StringBuilder();
        obj4.append("//");
        n.p(string2, "name");
        obj4.append((String)string2);
        obj4 = URI.create(obj4.toString());
        final int i3 = 0;
        obj7 = obj4.getHost() != null ? i : i3;
        n.k(obj7, "Invalid DNS name: %s", string2);
        String obj5 = obj4.getAuthority();
        n.q(obj5, "nameUri (%s) doesn't have an authority", obj4);
        this.e = (String)obj5;
        this.f = obj4.getHost();
        if (obj4.getPort() == -1) {
            this.g = b3.a();
        } else {
            this.g = obj4.getPort();
        }
        obj4 = b3.c();
        n.p(obj4, "proxyDetector");
        this.a = (a1)obj4;
        this.i = c0.s(z6);
        n.p(q5, "stopwatch");
        this.k = (q)q5;
        obj4 = b3.e();
        n.p(obj4, "syncContext");
        this.j = (f1)obj4;
        obj4 = b3.b();
        this.n = obj4;
        if (obj4 == null) {
        }
        int i2 = i3;
        obj4 = b3.d();
        n.p(obj4, "serviceConfigParser");
        this.p = (v0.h)obj4;
    }

    private List<y> A() {
        Logger logger;
        int size;
        Level fINE;
        String inetSocketAddress;
        int i;
        int i2 = 0;
        List resolveAddress = this.c.resolveAddress(this.f);
        ArrayList arrayList = new ArrayList(resolveAddress.size());
        Iterator iterator = resolveAddress.iterator();
        try {
            for (InetAddress size : iterator) {
                inetSocketAddress = new InetSocketAddress(size, this.g);
                fINE = new y(inetSocketAddress);
                arrayList.add(fINE);
            }
            inetSocketAddress = new InetSocketAddress((InetAddress)iterator.next(), this.g);
            fINE = new y(inetSocketAddress);
            arrayList.add(fINE);
            return Collections.unmodifiableList(arrayList);
            t.f(th);
            RuntimeException runtimeException = new RuntimeException(th);
            throw runtimeException;
            if (th == null) {
            } else {
            }
            c0.s.log(Level.FINE, "Address resolution failure", th);
            throw runtimeException;
        } catch (Throwable th) {
        }
    }

    private v0.c B() {
        List emptyList;
        Object obj;
        io.grpc.j1.c0.f fVar;
        Object fINE;
        Object string;
        Object[] arr;
        Object fINE2;
        String str;
        emptyList = Collections.emptyList();
        fVar = u();
        if (fVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("_grpc_config.");
            stringBuilder.append(this.f);
            emptyList = fVar.a(stringBuilder.toString());
        }
        if (!emptyList.isEmpty()) {
            obj = c0.x(emptyList, this.b, c0.r());
            if (obj != null && obj.d() != null) {
                if (obj.d() != null) {
                    return v0.c.b(obj.d());
                }
                return this.p.a((Map)obj.c());
            }
        } else {
            arr = new Object[1];
            c0.s.log(Level.FINE, "No TXT records found for {0}", this.f);
        }
        return null;
    }

    protected static boolean C(boolean z, boolean z2, String string3) {
        int i;
        char charAt;
        int i2;
        int obj5;
        final int i3 = 0;
        if (!z) {
            return i3;
        }
        if ("localhost".equalsIgnoreCase(string3)) {
            return z2;
        }
        if (string3.contains(":")) {
            return i3;
        }
        int obj4 = 1;
        i = obj4;
        obj5 = i3;
        while (obj5 < string3.length()) {
            charAt = string3.charAt(obj5);
            if (charAt != 46) {
            }
            obj5++;
            if (charAt >= 48 && charAt <= 57) {
            } else {
            }
            charAt = i3;
            i &= charAt;
            if (charAt <= 57) {
            } else {
            }
            charAt = obj4;
        }
        return obj4 ^= i;
    }

    static f1 f(io.grpc.j1.c0 c0) {
        return c0.j;
    }

    static Logger g() {
        return c0.s;
    }

    static String h(io.grpc.j1.c0 c0) {
        return c0.f;
    }

    static y i(io.grpc.j1.c0 c0) {
        return c0.n();
    }

    static long j(io.grpc.j1.c0 c0) {
        return c0.i;
    }

    static q k(io.grpc.j1.c0 c0) {
        return c0.k;
    }

    static boolean l(io.grpc.j1.c0 c0, boolean z2) {
        c0.q = z2;
        return z2;
    }

    private boolean m() {
        int i;
        boolean cmp2;
        TimeUnit nANOSECONDS;
        int i2;
        int cmp;
        cmp2 = this.i;
        i2 = 0;
        if (this.l && Long.compare(cmp2, i2) != 0) {
            cmp2 = this.i;
            i2 = 0;
            if (Long.compare(cmp2, i2) != 0) {
                if (Long.compare(cmp2, i2) > 0 && Long.compare(l, i2) > 0) {
                    if (Long.compare(l, i2) > 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private y n() {
        io.grpc.z0 z0Var = this.a.a(InetSocketAddress.createUnresolved(this.f, this.g));
        if (z0Var != null) {
            y yVar = new y(z0Var);
            return yVar;
        }
        return null;
    }

    private static final List<String> p(Map<String, ?> map) {
        return b1.g(map, "clientLanguage");
    }

    private static final List<String> q(Map<String, ?> map) {
        return b1.g(map, "clientHostname");
    }

    private static String r() {
        String hostName;
        if (c0.B == null) {
            c0.B = InetAddress.getLocalHost().getHostName();
        }
        return c0.B;
    }

    private static long s(boolean z) {
        String property;
        int nanos;
        Logger logger;
        Level wARNING;
        int arr;
        int i;
        String obj9;
        final int i2 = 0;
        if (z != null) {
            return i2;
        }
        property = System.getProperty("networkaddress.cache.ttl");
        nanos = 30;
        if (property != null) {
            nanos = Long.parseLong(property);
        }
        if (Long.compare(nanos, i2) > 0) {
            nanos = TimeUnit.SECONDS.toNanos(nanos);
        }
        return nanos;
    }

    private static final Double t(Map<String, ?> map) {
        return b1.h(map, "percentage");
    }

    static io.grpc.j1.c0.g v(java.lang.ClassLoader classLoader) {
        int i2 = 0;
        Object obj4 = Class.forName("io.grpc.j1.z0", true, classLoader).asSubclass(c0.g.class).getConstructor(new Class[i2]).newInstance(new Object[i2]);
        if ((c0.g)obj4.b() != null) {
            try {
                c0.s.log(Level.FINE, "JndiResourceResolverFactory not available, skipping.", obj4.b());
                return null;
                return obj4;
                Logger logger = c0.s;
                Level fINE = Level.FINE;
                String str2 = "Can't construct JndiResourceResolverFactory, skipping.";
                logger.log(fINE, str2, classLoader);
                return obj0;
                logger = c0.s;
                fINE = Level.FINE;
                str2 = "Can't find JndiResourceResolverFactory ctor, skipping.";
                logger.log(fINE, str2, classLoader);
                return obj0;
                logger = c0.s;
                fINE = Level.FINE;
                str2 = "Unable to cast JndiResourceResolverFactory, skipping.";
                logger.log(fINE, str2, classLoader);
                return obj0;
                logger = c0.s;
                fINE = Level.FINE;
                str2 = "Unable to find JndiResourceResolverFactory, skipping.";
                logger.log(fINE, str2, classLoader);
                return obj0;
            } catch (Exception e) {
            }
        }
    }

    static Map<String, ?> w(Map<String, ?> map, Random random2, String string3) {
        List list;
        Double equals;
        Object next;
        boolean contains;
        String str;
        boolean equalsIgnoreCase;
        String str2;
        int i;
        String str3;
        int obj9;
        Iterator iterator = map.entrySet().iterator();
        for (Map.Entry next : iterator) {
            v.a(c0.t.contains(next.getKey()), "Bad key: %s", next);
        }
        list = c0.p(map);
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        if (list != null && !list.isEmpty()) {
            if (!list.isEmpty()) {
                Iterator iterator2 = list.iterator();
                for (String next4 : iterator2) {
                }
                list = i5;
                if (list == null) {
                    return i3;
                }
            }
        }
        equals = c0.t(map);
        if (equals != null) {
            equalsIgnoreCase = equals.intValue();
            str2 = 100;
            if (equalsIgnoreCase >= 0 && equalsIgnoreCase <= str2) {
                i = equalsIgnoreCase <= str2 ? i4 : i5;
            } else {
            }
            v.a(i, "Bad percentage: %s", equals);
            if (random2.nextInt(str2) >= equalsIgnoreCase) {
                return i3;
            }
        }
        obj9 = c0.q(map);
        if (obj9 != null && !obj9.isEmpty()) {
            if (!obj9.isEmpty()) {
                obj9 = obj9.iterator();
                for (String next2 : obj9) {
                }
                obj9 = i5;
                if (obj9 == null) {
                    return i3;
                }
            }
        }
        obj9 = "serviceConfig";
        Map obj10 = b1.j(map, obj9);
        if (obj10 == null) {
        } else {
            return obj10;
        }
        Object[] arr = new Object[2];
        arr[i5] = map;
        arr[i4] = obj9;
        obj10 = new VerifyException(String.format("key '%s' missing in '%s'", arr));
        throw obj10;
    }

    static v0.c x(List<String> list, Random random2, String string3) {
        int i;
        boolean next;
        try {
            Iterator obj3 = c0.y(list).iterator();
            final int i2 = 0;
            i = i2;
            while (obj3.hasNext()) {
                if (c0.w((Map)obj3.next(), random2, string3) != 0) {
                    break;
                } else {
                }
            }
            if (c0.w((Map)obj3.next(), random2, string3) != 0) {
            } else {
            }
        } catch (RuntimeException e) {
        }
        if (i == 0) {
            return i2;
        }
        return v0.c.a(i);
    }

    static List<Map<String, ?>> y(List<String> list) {
        Object str;
        Logger logger;
        Level fINE;
        Object[] arr;
        int i;
        ArrayList arrayList = new ArrayList();
        Iterator obj6 = list.iterator();
        for (String next2 : obj6) {
            str = a1.a(next2.substring(12));
            b1.a((List)str);
            arrayList.addAll(str);
            arr = new Object[1];
            c0.s.log(Level.FINE, "Ignoring non service config {0}", next2);
        }
        return arrayList;
    }

    private void z() {
        boolean z;
        io.grpc.j1.c0.e eVar;
        v0.e eVar2;
        if (!this.q && !this.m) {
            if (!this.m) {
                if (!m()) {
                } else {
                    this.q = true;
                    eVar = new c0.e(this, this.r);
                    this.n.execute(eVar);
                }
            }
        }
    }

    @Override // io.grpc.v0
    public String a() {
        return this.e;
    }

    @Override // io.grpc.v0
    public void b() {
        int i;
        i = this.r != null ? 1 : 0;
        n.v(i, "not started");
        z();
    }

    @Override // io.grpc.v0
    public void c() {
        Object executor;
        boolean z;
        if (this.m) {
        }
        this.m = true;
        executor = this.n;
        if (executor != null && this.o) {
            if (this.o) {
                this.n = (Executor)f2.f(this.h, executor);
            }
        }
    }

    @Override // io.grpc.v0
    public void d(v0.e v0$e) {
        int i;
        boolean z;
        i = this.r == null ? 1 : 0;
        n.v(i, "already started");
        if (this.o) {
            this.n = (Executor)f2.d(this.h);
        }
        n.p(e, "listener");
        this.r = (v0.e)e;
        z();
    }

    @Override // io.grpc.v0
    protected io.grpc.j1.c0.c o(boolean z) {
        List list;
        boolean obj5;
        c0.c cVar = new c0.c(0);
        c0.c.b(cVar, A());
        if (c0.z) {
            c0.c.f(cVar, B());
        }
        return cVar;
    }

    @Override // io.grpc.v0
    protected io.grpc.j1.c0.f u() {
        Object obj;
        boolean z;
        if (!c0.C(c0.x, c0.y, this.f)) {
            return null;
        }
        z = c0.A;
        if ((c0.f)this.d.get() == null && z != null) {
            z = c0.A;
            if (z != null) {
                obj = z.a();
            }
        }
        return obj;
    }
}
