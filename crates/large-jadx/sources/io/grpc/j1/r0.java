package io.grpc.j1;

import com.google.common.base.n;
import com.google.common.base.p;
import com.google.common.base.q;
import com.google.common.base.s;
import com.google.common.util.concurrent.g;
import io.grpc.a;
import io.grpc.a1;
import io.grpc.d;
import io.grpc.d.a;
import io.grpc.d1;
import io.grpc.d1.b;
import io.grpc.e1;
import io.grpc.i0;
import io.grpc.j0;
import io.grpc.j0.a;
import io.grpc.l;
import io.grpc.l.a;
import io.grpc.l.c;
import io.grpc.l.c.a;
import io.grpc.m0;
import io.grpc.o0.e;
import io.grpc.o0.h;
import io.grpc.t0;
import io.grpc.t0.d;
import io.grpc.t0.f;
import io.grpc.u0;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: GrpcUtil.java */
/* loaded from: classes3.dex */
public final class r0 {

    private static final Logger a;
    public static final t0.f<Long> b;
    public static final t0.f<String> c;
    public static final t0.f<byte[]> d;
    public static final t0.f<String> e;
    public static final t0.f<byte[]> f;
    public static final t0.f<String> g;
    public static final t0.f<String> h;
    public static final t0.f<String> i;
    public static final long j = 0L;
    public static final a1 k = new u1();
    public static final d.a<Boolean> l;
    private static final l m = new r0$b();
    public static final f2.d<Executor> n = new r0$c<>();
    public static final f2.d<ScheduledExecutorService> o = new r0$d<>();
    public static final s<q> p = new r0$e<>();

    public enum i {

        CANCEL,
        COMPRESSION_ERROR,
        CONNECT_ERROR,
        ENHANCE_YOUR_CALM,
        FLOW_CONTROL_ERROR,
        FRAME_SIZE_ERROR,
        HTTP_1_1_REQUIRED,
        INADEQUATE_SECURITY,
        INTERNAL_ERROR,
        NO_ERROR,
        PROTOCOL_ERROR,
        REFUSED_STREAM,
        SETTINGS_TIMEOUT,
        STREAM_CLOSED;

        private final int code;
        private final d1 status;
        private static r0.i[] buildHttp2CodeMap() {
            int i = 0;
            final io.grpc.j1.r0.i[] values = r0.i.values();
            io.grpc.j1.r0.i[] arr = new r0.i[(int)(values[values.length - 1].code()) + 1];
            i = 0;
            for (io.grpc.j1.r0.i iVar : values) {
                i2 = (int)iVar.code();
                arr[i2] = iVar;
            }
            return arr;
        }

        public static r0.i forCode(long j) {
            final io.grpc.j1.r0.i[] codeMap2 = r0.i.codeMap;
            long l = (long)codeMap2.length;
            if (j < r0.i.codeMap.length) {
                return r0.i.codeMap[(int)j];
            }
            return null;
        }

        public static d1 statusForCode(long j) {
            io.grpc.j1.r0.i forCode = r0.i.forCode(j);
            if (forCode == null) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "Unrecognized HTTP/2 error code: ";
                str2 = str + j;
                return d1.i(r0.i.INTERNAL_ERROR.status().n().value()).r(str2);
            }
            return forCode.status();
        }

        @Override // java.lang.Enum
        public long code() {
            return (long)this.code;
        }

        @Override // java.lang.Enum
        public d1 status() {
            return this.status;
        }
    }

    class a implements a1 {
    }

    class c implements f2.d<Executor> {
        c() {
            super();
        }

        public void c(Executor executor) {
            executor.shutdown();
        }

        public Executor d() {
            return Executors.newCachedThreadPool(r0.i("grpc-default-executor-%d", true));
        }

        @Override // java.lang.Object
        public String toString() {
            return "grpc-default-executor";
        }
    }

    class d implements f2.d<ScheduledExecutorService> {
        d() {
            super();
        }

        public void c(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        public ScheduledExecutorService d() throws java.lang.IllegalAccessException, InvocationTargetException {
            boolean z = true;
            ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(z, r0.i("grpc-timer-%d", z));
            try {
                final Class[] arr2 = new Class[z];
                final int i = 0;
                arr2[i] = Boolean.TYPE;
                Object[] arr = new Object[z];
                arr[i] = Boolean.TRUE;
                scheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", arr2).invoke(scheduledThreadPool, arr);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch (RuntimeException e1) {
                throw e1;
            } catch (java.lang.NoSuchMethodException unused) {
                return Executors.unconfigurableScheduledExecutorService(scheduledThreadPool);
            }
        }
    }

    class e implements s<q> {
        e() {
            super();
        }

        public q a() {
            return q.c();
        }
    }

    static class j implements t0.d<Long> {
        j() {
            super();
        }

        public Long c(String str) {
            boolean z;
            boolean z2;
            final int i2 = 0;
            int i = 1;
            int r0 = str.length() > 0 ? i : i2;
            n.e((str.length() > 0 ? i : i2), "empty timeout");
            r0 = str.length() <= 9 ? i : i2;
            n.e((str.length() <= 9 ? i : i2), "bad timeout format");
            long parsed = Long.parseLong((str.length() <= 9 ? i : i2));
            char charAt = str.charAt((str.length() <= 9 ? i : i2));
            if (charAt != 72 && charAt != 77) {
                if (charAt != 83 && charAt != 117) {
                    if (charAt != 109 && charAt == 110) {
                        return Long.valueOf(parsed);
                    }
                    return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(parsed));
                }
                return Long.valueOf(TimeUnit.SECONDS.toNanos(parsed));
            }
            return Long.valueOf(TimeUnit.HOURS.toNanos(parsed));
        }

        public String d(Long long) {
            TimeUnit nANOSECONDS2 = TimeUnit.NANOSECONDS;
            long value = long.longValue();
            if (value < 0) {
                throw new IllegalArgumentException("Timeout too small");
            } else {
                long value2 = long.longValue();
                if (value2 < 100000000) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str12 = "n";
                    str13 = long + str12;
                    return str13;
                }
                long value3 = long.longValue();
                long l = 100000000000L;
                if (value3 < l) {
                    StringBuilder stringBuilder6 = new StringBuilder();
                    long micros = TimeUnit.NANOSECONDS.toMicros(long.longValue());
                    String str10 = "u";
                    str11 = micros + str10;
                    return str11;
                }
                long value4 = long.longValue();
                long l2 = 100000000000000L;
                if (value4 < l2) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    long millis = TimeUnit.NANOSECONDS.toMillis(long.longValue());
                    String str8 = "m";
                    str9 = millis + str8;
                    return str9;
                }
                long value5 = long.longValue();
                long l3 = 100000000000000000L;
                if (value5 < l3) {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    long seconds = TimeUnit.NANOSECONDS.toSeconds(long.longValue());
                    String str6 = "S";
                    str7 = seconds + str6;
                    return str7;
                }
                long value6 = long.longValue();
                long l4 = 6000000000000000000L;
                if (value6 < l4) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    long minutes = TimeUnit.NANOSECONDS.toMinutes(long.longValue());
                    String str4 = "M";
                    str5 = minutes + str4;
                    return str5;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                long hours = TimeUnit.NANOSECONDS.toHours(long.longValue());
                String str2 = "H";
                str3 = hours + str2;
                return str3;
            }
        }
    }

    class b extends l {
        b() {
            super();
        }
    }

    private static final class h implements j0.a<byte[]> {
        private h() {
            super();
        }

        /* synthetic */ h(r0.a aVar) {
            this();
        }

        public byte[] c(byte[] bArr) {
            return bArr;
        }

        public byte[] d(byte[] bArr) {
            return bArr;
        }
    }

    class f implements s {

        final /* synthetic */ l.a a;
        final /* synthetic */ s b;
        f(l.a aVar, s sVar) {
            this.a = aVar;
            this.b = sVar;
            super();
        }

        public q b(u0<?, ?> u0Var, t0 t0Var, d dVar, l[] lVarArr) {
            boolean z = false;
            l.c.a aVar = l.c.a();
            aVar.b(dVar);
            final int i = 1;
            int r1 = lVarArr[lVarArr.length - i] == r0.m ? i : 0;
            n.v((lVarArr[lVarArr.length - i] == r0.m ? i : 0), "lb tracer already assigned");
            lVarArr[(lVarArr[lVarArr.length - i] == r0.m ? i : 0)] = r0.n(this.a, aVar.a(), t0Var);
            return this.b.b(u0Var, t0Var, dVar, lVarArr);
        }

        public i0 f() {
            return this.b.f();
        }
    }

    class g extends j0 {

        final l a = new r0$g$a();
        volatile l b = new r0$g$a();
        final /* synthetic */ l.a c;
        final /* synthetic */ l.c d;
        final /* synthetic */ t0 e;
        g(l.a aVar, l.c cVar, t0 t0Var) {
            this.c = aVar;
            this.d = cVar;
            this.e = t0Var;
            super();
            final io.grpc.j1.r0.g.a aVar2 = new r0.g.a(this);
        }

        @Override // io.grpc.j1.j0
        public void i(d1 d1Var) {
            o(this.d, this.e);
            n().i(d1Var);
        }

        @Override // io.grpc.j1.j0
        public void m(a aVar, t0 t0Var) {
            l.c.a aVar2 = this.d.b();
            aVar2.e(aVar);
            o(aVar2.a(), t0Var);
            n().m(aVar, t0Var);
        }

        @Override // io.grpc.j1.j0
        protected l n() {
            return this.b;
        }

        @Override // io.grpc.j1.j0
        void o(l.c cVar, t0 t0Var) {
            if (this.b != this.a) {
                return;
            }
            synchronized (this) {
                try {
                    if (this.b == this.a) {
                        this.b = this.c.a(cVar, t0Var);
                    }
                    return;
                } catch (Throwable th) {
                }
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            }
        }
    }
    static {
        r0.a = Logger.getLogger(r0.class.getName());
        Charset.forName("US-ASCII");
        r0.b = t0.f.e("grpc-timeout", new r0.j());
        t0.d dVar = t0.c;
        r0.c = t0.f.e("grpc-encoding", dVar);
        io.grpc.j1.r0.a aVar2 = null;
        r0.d = j0.b("grpc-accept-encoding", new r0.h(aVar2));
        r0.e = t0.f.e("content-encoding", dVar);
        String str9 = "accept-encoding";
        r0.f = j0.b(str9, new r0.h(aVar2));
        r0.g = t0.f.e("content-type", dVar);
        r0.h = t0.f.e("te", dVar);
        r0.i = t0.f.e("user-agent", dVar);
        p.a(',').c();
        TimeUnit sECONDS2 = TimeUnit.SECONDS;
        long l = 20L;
        r0.j = sECONDS2.toNanos(l);
        TimeUnit.HOURS.toNanos(2L);
        sECONDS2.toNanos(l);
        r0.l = d.a.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
    }

    private r0() {
        super();
    }

    static /* synthetic */ l a() {
        return r0.m;
    }

    public static URI b(String str) {
        n.p(str, "authority");
        try {
            URI uri = new URI(null, str, null, null, null);
        } catch (java.net.URISyntaxException uRISyntax) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Invalid authority: ";
            str = str3 + str;
            throw new IllegalArgumentException(str, uRISyntax);
        }
        return uri;
    }

    public static String c(String str) {
        boolean z;
        boolean z2 = true;
        URI uri = r0.b(str);
        final int i2 = 0;
        int r1 = uri.getHost() != null ? 1 : i2;
        n.k((uri.getHost() != null ? 1 : i2), "No host in authority '%s'", str);
        if (uri.getUserInfo() != null) {
        }
        n.k(z2, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    static void d(k2.a aVar) {
        final java.io.InputStream next = aVar.next();
        while (next != null) {
            r0.e(next);
            next = aVar.next();
        }
    }

    public static void e(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (java.io.IOException ioException) {
            r0.a.log(Level.WARNING, "exception caught in closeQuietly", ioException);
        }
    }

    public static l[] f(d dVar, t0 t0Var, int i, boolean z) {
        final List list = dVar.i();
        int i2 = list.size() + 1;
        final l[] arr = new l[i2];
        final l.c.a aVar = l.c.a();
        aVar.b(dVar);
        aVar.d(i);
        aVar.c(z);
        i = 0;
        while (i < list.size()) {
            arr[i] = r0.n((l.a)list.get(i), aVar.a(), t0Var);
            i = i + 1;
        }
        arr[i2 - 1] = r0.m;
        return arr;
    }

    public static String g(String str, String str2) {
        final StringBuilder stringBuilder = new StringBuilder();
        if (str2 != null) {
            stringBuilder.append(str2);
            char c = ' ';
            stringBuilder.append(c);
        }
        stringBuilder.append("grpc-java-");
        stringBuilder.append(str);
        stringBuilder.append('/');
        stringBuilder.append("1.41.0");
        return stringBuilder.toString();
    }

    public static String h(InetSocketAddress inetSocketAddress) {
        try {
            final int i = 0;
        } catch (java.lang.NoSuchMethodException | java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            inetSocketAddress = inetSocketAddress.getHostName();
            return inetSocketAddress;
        }
        return (String)InetSocketAddress.class.getMethod("getHostString", new Class[i]).invoke(inetSocketAddress, new Object[i]);
    }

    public static ThreadFactory i(String str, boolean z) {
        final g gVar = new g();
        gVar.e(z);
        gVar.f(str);
        return gVar.b();
    }

    static s j(o0.e eVar, boolean z) {
        io.grpc.j1.s sVar;
        o0.h hVar = eVar.c();
        final int i = 0;
        if (hVar != null) {
            sVar = (n2)hVar.d().a();
        } else {
        }
        if (sVar != null) {
            l.a aVar = eVar.b();
            if (aVar == null) {
                return sVar;
            }
            return new r0.f(aVar, sVar);
        }
        if (!eVar.a().p() && eVar.d()) {
            return new g0(eVar.a(), r.a.DROPPED);
        }
        return null;
    }

    private static d1.b k(int i) {
        int i2 = 100;
        if (i >= 100 && i < 200) {
            return d1.b.INTERNAL;
        }
        int i3 = 400;
        if (!(d1.b.INTERNAL == 400 || d1.b.INTERNAL != 401 || d1.b.INTERNAL != 403)) {
            if (d1.b.INTERNAL != 404 && d1.b.INTERNAL != 429) {
                i3 = 431;
                if (d1.b.INTERNAL != 431) {
                    if (/* condition */) {
                        return d1.b.UNAVAILABLE;
                    }
                    return d1.b.UNKNOWN;
                }
            }
            return d1.b.UNIMPLEMENTED;
        }
        return d1.b.INTERNAL;
    }

    public static d1 l(int i) {
        final StringBuilder stringBuilder = new StringBuilder();
        final String str = "HTTP status code ";
        str2 = str + i;
        return r0.k(i).toStatus().r(str2);
    }

    public static boolean m(String str) {
        boolean z = false;
        char c = 43;
        z = false;
        if (str == null) {
            return false;
        }
        final int i2 = 16;
        if (i2 > str.length()) {
            return false;
        }
        String str3 = str.toLowerCase();
        if (!str3.startsWith("application/grpc")) {
            return false;
        }
        final int i = 1;
        if (str3.length() == i2) {
            return true;
        }
        char charAt = str3.charAt(i2);
        c = '+';
        int r0 = i;
        return i;
    }

    static l n(l.a aVar, l.c cVar, t0 t0Var) {
        l lVar;
        z = aVar instanceof l.b;
        if (aVar instanceof l.b) {
            lVar = aVar.a(cVar, t0Var);
        } else {
        }
        return lVar;
    }

    public static boolean o(d dVar) {
        return !Boolean.TRUE.equals(dVar.h(r0.l));
    }
}
