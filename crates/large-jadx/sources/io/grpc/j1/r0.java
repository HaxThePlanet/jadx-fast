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
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.URI;
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
    public static final long j;
    public static final a1 k;
    public static final d.a<Boolean> l;
    private static final l m;
    public static final io.grpc.j1.f2.d<Executor> n;
    public static final io.grpc.j1.f2.d<ScheduledExecutorService> o;
    public static final s<q> p;

    public static enum i {

        NO_ERROR(false, field_1),
        PROTOCOL_ERROR(true, field_4),
        INTERNAL_ERROR(2, field_4),
        FLOW_CONTROL_ERROR(3, field_4),
        SETTINGS_TIMEOUT(4, field_4),
        STREAM_CLOSED(5, field_4),
        FRAME_SIZE_ERROR(5, field_4),
        REFUSED_STREAM(4, field_1),
        CANCEL(3, 5),
        COMPRESSION_ERROR(3, field_4),
        CONNECT_ERROR(2, field_4),
        ENHANCE_YOUR_CALM(true, 2),
        INADEQUATE_SECURITY(false, true),
        HTTP_1_1_REQUIRED(2, 3);

        private final int code;
        private final d1 status;
        private static io.grpc.j1.r0.i[] buildHttp2CodeMap() {
            int i;
            io.grpc.j1.r0.i iVar;
            int i2;
            final io.grpc.j1.r0.i[] values = r0.i.values();
            io.grpc.j1.r0.i[] arr = new r0.i[i4++];
            i = 0;
            while (i < values.length) {
                iVar = values[i];
                arr[(int)code2] = iVar;
                i++;
            }
            return arr;
        }

        public static io.grpc.j1.r0.i forCode(long l) {
            int cmp;
            final io.grpc.j1.r0.i[] codeMap = r0.i.codeMap;
            if (Long.compare(l, l2) < 0 && Long.compare(l, i) < 0) {
                if (Long.compare(l, i) < 0) {
                }
                return codeMap[(int)l];
            }
            return null;
        }

        public static d1 statusForCode(long l) {
            io.grpc.j1.r0.i forCode = r0.i.forCode(l);
            if (forCode == null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unrecognized HTTP/2 error code: ");
                stringBuilder.append(l);
                return d1.i(r0.i.INTERNAL_ERROR.status().n().value()).r(stringBuilder.toString());
            }
            return forCode.status();
        }

        @Override // java.lang.Enum
        public long code() {
            return (long)code;
        }

        @Override // java.lang.Enum
        public d1 status() {
            return this.status;
        }
    }

    class a implements a1 {
    }

    class c implements io.grpc.j1.f2.d<Executor> {
        @Override // io.grpc.j1.f2$d
        public Object a() {
            return d();
        }

        @Override // io.grpc.j1.f2$d
        public void b(Object object) {
            c((Executor)object);
        }

        @Override // io.grpc.j1.f2$d
        public void c(Executor executor) {
            (ExecutorService)executor.shutdown();
        }

        @Override // io.grpc.j1.f2$d
        public Executor d() {
            return Executors.newCachedThreadPool(r0.i("grpc-default-executor-%d", true));
        }

        @Override // io.grpc.j1.f2$d
        public String toString() {
            return "grpc-default-executor";
        }
    }

    class d implements io.grpc.j1.f2.d<ScheduledExecutorService> {
        @Override // io.grpc.j1.f2$d
        public Object a() {
            return d();
        }

        @Override // io.grpc.j1.f2$d
        public void b(Object object) {
            c((ScheduledExecutorService)object);
        }

        @Override // io.grpc.j1.f2$d
        public void c(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        @Override // io.grpc.j1.f2$d
        public ScheduledExecutorService d() {
            int i = 1;
            ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(i, r0.i("grpc-timer-%d", i));
            final Class[] arr2 = new Class[i];
            final int i2 = 0;
            arr2[i2] = Boolean.TYPE;
            Object[] arr = new Object[i];
            arr[i2] = Boolean.TRUE;
            scheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", arr2).invoke(scheduledThreadPool, arr);
            return Executors.unconfigurableScheduledExecutorService(scheduledThreadPool);
        }
    }

    class e implements s<q> {
        @Override // com.google.common.base.s
        public q a() {
            return q.c();
        }

        @Override // com.google.common.base.s
        public Object get() {
            return a();
        }
    }

    static class j implements t0.d<Long> {
        @Override // io.grpc.t0$d
        public String a(Object object) {
            return d((Long)object);
        }

        @Override // io.grpc.t0$d
        public Object b(String string) {
            return c(string);
        }

        @Override // io.grpc.t0$d
        public Long c(String string) {
            int i;
            int i2;
            final int i11 = 0;
            int i12 = 1;
            i = string.length() > 0 ? i12 : i11;
            n.e(i, "empty timeout");
            i2 = string.length() <= 9 ? i12 : i11;
            n.e(i2, "bad timeout format");
            long long = Long.parseLong(string.substring(i11, length3 -= i12));
            char obj6 = string.charAt(length4 -= i12);
            if (obj6 != 72 && obj6 != 77 && obj6 != 83 && obj6 != 117 && obj6 != 109) {
                if (obj6 != 77) {
                    if (obj6 != 83) {
                        if (obj6 != 117) {
                            if (obj6 != 109) {
                                if (obj6 != 110) {
                                } else {
                                    return Long.valueOf(long);
                                }
                                Object[] arr = new Object[i12];
                                arr[i11] = Character.valueOf(obj6);
                                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Invalid timeout unit: %s", arr));
                                throw illegalArgumentException;
                            }
                            return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(long));
                        }
                        return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(long));
                    }
                    return Long.valueOf(TimeUnit.SECONDS.toNanos(long));
                }
                return Long.valueOf(TimeUnit.MINUTES.toNanos(long));
            }
            return Long.valueOf(TimeUnit.HOURS.toNanos(long));
        }

        @Override // io.grpc.t0$d
        public String d(Long long) {
            TimeUnit nANOSECONDS = TimeUnit.NANOSECONDS;
            if (Long.compare(longValue, i) < 0) {
            } else {
                if (Long.compare(longValue2, i2) < 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(long);
                    stringBuilder.append("n");
                    return stringBuilder.toString();
                }
                long l = 100000000000L;
                if (Long.compare(longValue3, l) < 0) {
                    StringBuilder stringBuilder6 = new StringBuilder();
                    stringBuilder6.append(nANOSECONDS.toMicros(long.longValue()));
                    stringBuilder6.append("u");
                    return stringBuilder6.toString();
                }
                long l2 = 100000000000000L;
                if (Long.compare(longValue4, l2) < 0) {
                    StringBuilder stringBuilder5 = new StringBuilder();
                    stringBuilder5.append(nANOSECONDS.toMillis(long.longValue()));
                    stringBuilder5.append("m");
                    return stringBuilder5.toString();
                }
                long l3 = 100000000000000000L;
                if (Long.compare(longValue5, l3) < 0) {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(nANOSECONDS.toSeconds(long.longValue()));
                    stringBuilder4.append("S");
                    return stringBuilder4.toString();
                }
                long l4 = 6000000000000000000L;
                if (Long.compare(longValue6, l4) < 0) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(nANOSECONDS.toMinutes(long.longValue()));
                    stringBuilder3.append("M");
                    return stringBuilder3.toString();
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(nANOSECONDS.toHours(long.longValue()));
                stringBuilder2.append("H");
                return stringBuilder2.toString();
            }
            IllegalArgumentException obj6 = new IllegalArgumentException("Timeout too small");
            throw obj6;
        }
    }

    class b extends l {
    }

    private static final class h implements j0.a<byte[]> {
        h(io.grpc.j1.r0.a r0$a) {
            super();
        }

        @Override // io.grpc.j0$a
        public byte[] a(Object object) {
            d((byte[])object);
            return object;
        }

        @Override // io.grpc.j0$a
        public Object b(byte[] bArr) {
            c(bArr);
            return bArr;
        }

        @Override // io.grpc.j0$a
        public byte[] c(byte[] bArr) {
            return bArr;
        }

        @Override // io.grpc.j0$a
        public byte[] d(byte[] bArr) {
            return bArr;
        }
    }

    class f implements io.grpc.j1.s {

        final l.a a;
        final io.grpc.j1.s b;
        f(l.a l$a, io.grpc.j1.s s2) {
            this.a = a;
            this.b = s2;
            super();
        }

        public io.grpc.j1.q b(u0<?, ?> u0, t0 t02, d d3, l[] l4Arr4) {
            int i;
            l.c.a aVar = l.c.a();
            aVar.b(d3);
            final int i4 = 1;
            i = l4Arr4[length -= i4] == r0.a() ? i4 : 0;
            n.v(i, "lb tracer already assigned");
            l4Arr4[length2 -= i4] = r0.n(this.a, aVar.a(), t02);
            return this.b.b(u0, t02, d3, l4Arr4);
        }

        @Override // io.grpc.j1.s
        public i0 f() {
            return this.b.f();
        }
    }

    class g extends io.grpc.j1.j0 {

        final l a;
        volatile l b;
        final l.a c;
        final l.c d;
        final t0 e;
        g(l.a l$a, l.c l$c2, t0 t03) {
            this.c = a;
            this.d = c2;
            this.e = t03;
            super();
            r0.g.a obj1 = new r0.g.a(this);
            this.a = obj1;
            this.b = obj1;
        }

        @Override // io.grpc.j1.j0
        public void i(d1 d1) {
            o(this.d, this.e);
            n().i(d1);
        }

        @Override // io.grpc.j1.j0
        public void m(a a, t0 t02) {
            l.c.a aVar = this.d.b();
            aVar.e(a);
            o(aVar.a(), t02);
            n().m(a, t02);
        }

        @Override // io.grpc.j1.j0
        protected l n() {
            return this.b;
        }

        @Override // io.grpc.j1.j0
        void o(l.c l$c, t0 t02) {
            Object lVar;
            Object obj3;
            if (this.b != this.a) {
            }
            synchronized (this) {
                this.b = this.c.a(c, t02);
            }
        }
    }
    static {
        r0.a = Logger.getLogger(r0.class.getName());
        Charset.forName("US-ASCII");
        r0.j jVar = new r0.j();
        r0.b = t0.f.e("grpc-timeout", jVar);
        t0.d dVar = t0.c;
        r0.c = t0.f.e("grpc-encoding", dVar);
        int i3 = 0;
        r0.h hVar = new r0.h(i3);
        r0.d = j0.b("grpc-accept-encoding", hVar);
        r0.e = t0.f.e("content-encoding", dVar);
        r0.h hVar2 = new r0.h(i3);
        String str9 = "accept-encoding";
        r0.f = j0.b(str9, hVar2);
        r0.g = t0.f.e("content-type", dVar);
        r0.h = t0.f.e("te", dVar);
        r0.i = t0.f.e("user-agent", dVar);
        p.a(',').c();
        TimeUnit sECONDS = TimeUnit.SECONDS;
        int i2 = 20;
        r0.j = sECONDS.toNanos(i2);
        TimeUnit.HOURS.toNanos(2);
        sECONDS.toNanos(i2);
        u1 u1Var = new u1();
        r0.k = u1Var;
        r0.l = d.a.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        r0.b bVar = new r0.b();
        r0.m = bVar;
        r0.c cVar = new r0.c();
        r0.n = cVar;
        r0.d dVar2 = new r0.d();
        r0.o = dVar2;
        r0.e eVar = new r0.e();
        r0.p = eVar;
    }

    static l a() {
        return r0.m;
    }

    public static URI b(String string) {
        n.p(string, "authority");
        super(0, string, 0, 0, 0);
        return uri;
    }

    public static String c(String string) {
        int i;
        int i2;
        URI uri = r0.b(string);
        final int i3 = 0;
        i = uri.getHost() != null ? i2 : i3;
        n.k(i, "No host in authority '%s'", string);
        if (uri.getUserInfo() == null) {
        } else {
            i2 = i3;
        }
        n.k(i2, "Userinfo must not be present on authority: '%s'", string);
        return string;
    }

    static void d(io.grpc.j1.k2.a k2$a) {
        final java.io.InputStream next = a.next();
        while (next != null) {
            r0.e(next);
            next = a.next();
        }
    }

    public static void e(Closeable closeable) {
        Logger logger;
        Level wARNING;
        String str;
        Throwable obj3;
        if (closeable == null) {
        }
        closeable.close();
    }

    public static l[] f(d d, t0 t02, int i3, boolean z4) {
        int obj6;
        boolean obj7;
        final List list = d.i();
        size++;
        final l[] arr = new l[i];
        final l.c.a aVar = l.c.a();
        aVar.b(d);
        aVar.d(i3);
        aVar.c(z4);
        obj6 = 0;
        while (obj6 < list.size()) {
            arr[obj6] = r0.n((l.a)list.get(obj6), aVar.a(), t02);
            obj6++;
        }
        arr[i--] = r0.m;
        return arr;
    }

    public static String g(String string, String string2) {
        String obj2;
        StringBuilder stringBuilder = new StringBuilder();
        if (string2 != null) {
            stringBuilder.append(string2);
            stringBuilder.append(' ');
        }
        stringBuilder.append("grpc-java-");
        stringBuilder.append(string);
        stringBuilder.append('/');
        stringBuilder.append("1.41.0");
        return stringBuilder.toString();
    }

    public static String h(InetSocketAddress inetSocketAddress) {
        try {
            final int i = 0;
            return (String)InetSocketAddress.class.getMethod("getHostString", new Class[i]).invoke(inetSocketAddress, new Object[i]);
            inetSocketAddress = inetSocketAddress.getHostName();
            return inetSocketAddress;
        }
    }

    public static ThreadFactory i(String string, boolean z2) {
        g gVar = new g();
        gVar.e(z2);
        gVar.f(string);
        return gVar.b();
    }

    static io.grpc.j1.s j(o0.e o0$e, boolean z2) {
        int i;
        boolean z;
        o0.h hVar = e.c();
        final int i2 = 0;
        if (hVar != null) {
            i = (n2)hVar.d().a();
        } else {
            i = i2;
        }
        l.a obj2 = e.b();
        if (i != 0 && obj2 == null) {
            obj2 = e.b();
            if (obj2 == null) {
                return i;
            }
            r0.f obj3 = new r0.f(obj2, i);
            return obj3;
        }
        if (!e.a().p() && e.d()) {
            if (e.d()) {
                obj3 = new g0(e.a(), r.a.DROPPED);
                return obj3;
            }
            if (!z2) {
                obj3 = new g0(e.a(), r.a.PROCESSED);
                return obj3;
            }
        }
        return i2;
    }

    private static d1.b k(int i) {
        int i3;
        int i2;
        if (i >= 100 && i < 200) {
            if (i < 200) {
                return d1.b.INTERNAL;
            }
        }
        if (i != 400 && i != 401 && i != 403 && i != 404 && i != 429 && i != 431 && /* condition */) {
            if (i != 401) {
                if (i != 403) {
                    if (i != 404) {
                        if (i != 429) {
                            if (i != 431) {
                                if (/* condition */) {
                                }
                                return d1.b.UNKNOWN;
                            }
                        }
                        return d1.b.UNAVAILABLE;
                    }
                    return d1.b.UNIMPLEMENTED;
                }
                return d1.b.PERMISSION_DENIED;
            }
            return d1.b.UNAUTHENTICATED;
        }
        return d1.b.INTERNAL;
    }

    public static d1 l(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP status code ");
        stringBuilder.append(i);
        return r0.k(i).toStatus().r(stringBuilder.toString());
    }

    public static boolean m(String string) {
        int i2;
        int i;
        i2 = 0;
        if (string == null) {
            return i2;
        }
        final int i3 = 16;
        if (i3 > string.length()) {
            return i2;
        }
        String obj4 = string.toLowerCase();
        if (!obj4.startsWith("application/grpc")) {
            return i2;
        }
        final int i4 = 1;
        if (obj4.length() == i3) {
            return i4;
        }
        obj4 = obj4.charAt(i3);
        if (obj4 != 43) {
            if (obj4 == 59) {
                i2 = i4;
            }
        } else {
        }
        return i2;
    }

    static l n(l.a l$a, l.c l$c2, t0 t03) {
        boolean gVar;
        l obj1;
        if (a instanceof l.b) {
            obj1 = a.a(c2, t03);
        } else {
            gVar = new r0.g(a, c2, t03);
            obj1 = gVar;
        }
        return obj1;
    }

    public static boolean o(d d) {
        return obj2 ^= 1;
    }
}
