package io.grpc;

import com.google.common.base.n;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: InternalChannelz.java */
/* loaded from: classes2.dex */
public final class d0 {

    private static final Logger d;
    private static final d0 e = new d0();
    private final ConcurrentNavigableMap<Long, h0<Object>> a = new ConcurrentSkipListMap<>();
    private final ConcurrentMap<Long, h0<Object>> b = new ConcurrentHashMap<>();
    private final ConcurrentMap<Long, h0<Object>> c = new ConcurrentHashMap<>();

    static class a {
    }

    public static final class b {
        public b(d0.c cVar) {
            super();
            n.o(cVar);
        }
    }

    public static final class c {
        public c(SSLSession sSLSession) {
            super();
            sSLSession.getCipherSuite();
            java.security.cert.Certificate[] localCertificates = sSLSession.getLocalCertificates();
            final int i2 = 0;
            java.security.cert.Certificate certificate2 = localCertificates != null ? localCertificates[i2] : certificate2;
            try {
                java.security.cert.Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                java.security.cert.Certificate certificate = peerCertificates[i2];
            } catch (javax.net.ssl.SSLPeerUnverifiedException sSLPeerUnverified) {
                int arr = 1;
                arr = new Object[arr];
                sSLSession = sSLSession.getPeerHost();
                arr[i] = sSLSession;
                sSLSession = "Peer cert not available for peerHost=%s";
                sSLSession = String.format(sSLSession, arr);
                d0.d.log(Level.FINE, sSLSession, sSLPeerUnverified);
            }
        }
    }
    static {
        d0.d = Logger.getLogger(d0.class.getName());
    }

    public d0() {
        super();
        ConcurrentSkipListMap concurrentSkipListMap = new ConcurrentSkipListMap();
        ConcurrentSkipListMap concurrentSkipListMap2 = new ConcurrentSkipListMap();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap3 = new ConcurrentHashMap();
    }

    static /* synthetic */ Logger a() {
        return d0.d;
    }

    private static <T extends h0<?>> void b(Map<Long, T> map, T t) {
    }

    public static long f(m0 m0Var) {
        return m0Var.f().d();
    }

    public static d0 g() {
        return d0.e;
    }

    private static <T extends h0<?>> void h(Map<Long, T> map, T t) {
    }

    public void c(h0<Object> h0Var) {
        d0.b(this.c, h0Var);
    }

    public void d(h0<Object> h0Var) {
        d0.b(this.a, h0Var);
    }

    public void e(h0<Object> h0Var) {
        d0.b(this.b, h0Var);
    }

    public void i(h0<Object> h0Var) {
        d0.h(this.c, h0Var);
    }

    public void j(h0<Object> h0Var) {
        d0.h(this.a, h0Var);
    }

    public void k(h0<Object> h0Var) {
        d0.h(this.b, h0Var);
    }
}
