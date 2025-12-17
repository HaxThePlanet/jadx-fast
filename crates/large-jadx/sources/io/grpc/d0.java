package io.grpc;

import com.google.common.base.n;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;

/* loaded from: classes2.dex */
public final class d0 {

    private static final Logger d;
    private static final io.grpc.d0 e;
    private final ConcurrentNavigableMap<Long, io.grpc.h0<Object>> a;
    private final ConcurrentMap<Long, io.grpc.h0<Object>> b;
    private final ConcurrentMap<Long, io.grpc.h0<Object>> c;

    static class a {
    }

    public static final class b {
        public b(io.grpc.d0.c d0$c) {
            super();
            n.o(c);
        }
    }

    public static final class c {
        public c(SSLSession sSLSession) {
            java.security.cert.Certificate[] localCertificates;
            java.security.cert.Certificate[] peerCertificates;
            Logger logger;
            Level fINE;
            int arr;
            Object obj6;
            super();
            sSLSession.getCipherSuite();
            localCertificates = sSLSession.getLocalCertificates();
            final int i = 0;
            localCertificates = localCertificates != null ? localCertificates[i] : localCertificates;
            peerCertificates = sSLSession.getPeerCertificates();
            obj6 = peerCertificates != null ? peerCertificates[i] : obj6;
        }
    }
    static {
        d0.d = Logger.getLogger(d0.class.getName());
        d0 d0Var = new d0();
        d0.e = d0Var;
    }

    public d0() {
        super();
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        ConcurrentSkipListMap concurrentSkipListMap2 = new ConcurrentSkipListMap();
        this.a = concurrentSkipListMap2;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.b = concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        this.c = concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
    }

    static Logger a() {
        return d0.d;
    }

    private static <T extends io.grpc.h0<?>> void b(Map<Long, T> map, T t2) {
        final Object obj2 = map.put(Long.valueOf(t2.f().d()), t2);
    }

    public static long f(io.grpc.m0 m0) {
        return m0.f().d();
    }

    public static io.grpc.d0 g() {
        return d0.e;
    }

    private static <T extends io.grpc.h0<?>> void h(Map<Long, T> map, T t2) {
        final Object obj2 = map.remove(Long.valueOf(d0.f(t2)));
    }

    public void c(io.grpc.h0<Object> h0) {
        d0.b(this.c, h0);
    }

    public void d(io.grpc.h0<Object> h0) {
        d0.b(this.a, h0);
    }

    public void e(io.grpc.h0<Object> h0) {
        d0.b(this.b, h0);
    }

    public void i(io.grpc.h0<Object> h0) {
        d0.h(this.c, h0);
    }

    public void j(io.grpc.h0<Object> h0) {
        d0.h(this.a, h0);
    }

    public void k(io.grpc.h0<Object> h0) {
        d0.h(this.b, h0);
    }
}
