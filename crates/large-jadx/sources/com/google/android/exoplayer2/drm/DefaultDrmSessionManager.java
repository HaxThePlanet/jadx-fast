package com.google.android.exoplayer2.drm;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.upstream.w;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.t;
import com.google.common.collect.v;
import com.google.common.collect.y0;
import com.google.common.collect.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes2.dex */
public class DefaultDrmSessionManager implements com.google.android.exoplayer2.drm.v {

    private final UUID b;
    private final com.google.android.exoplayer2.drm.b0.c c;
    private final com.google.android.exoplayer2.drm.f0 d;
    private final HashMap<String, String> e;
    private final boolean f;
    private final int[] g;
    private final boolean h;
    private final com.google.android.exoplayer2.drm.DefaultDrmSessionManager.f i;
    private final w j;
    private final com.google.android.exoplayer2.drm.DefaultDrmSessionManager.g k;
    private final long l;
    private final List<com.google.android.exoplayer2.drm.DefaultDrmSession> m;
    private final Set<com.google.android.exoplayer2.drm.DefaultDrmSessionManager.e> n;
    private final Set<com.google.android.exoplayer2.drm.DefaultDrmSession> o;
    private int p;
    private com.google.android.exoplayer2.drm.b0 q;
    private com.google.android.exoplayer2.drm.DefaultDrmSession r;
    private com.google.android.exoplayer2.drm.DefaultDrmSession s;
    private Looper t;
    private Handler u;
    private int v;
    private byte[] w;
    volatile com.google.android.exoplayer2.drm.DefaultDrmSessionManager.d x;

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uUID) {
            String obj3 = String.valueOf(uUID);
            StringBuilder stringBuilder = new StringBuilder(length += 29);
            stringBuilder.append("Media does not support uuid: ");
            stringBuilder.append(obj3);
            super(stringBuilder.toString());
        }

        MissingSchemeDataException(UUID uUID, com.google.android.exoplayer2.drm.DefaultDrmSessionManager.a defaultDrmSessionManager$a2) {
            super(uUID);
        }
    }

    static class a {
    }

    public static final class b {

        private final HashMap<String, String> a;
        private UUID b;
        private com.google.android.exoplayer2.drm.b0.c c;
        private boolean d;
        private int[] e;
        private boolean f;
        private w g;
        private long h = 300000;
        public b() {
            super();
            HashMap hashMap = new HashMap();
            this.a = hashMap;
            this.b = w0.d;
            this.c = d0.d;
            t tVar = new t();
            this.g = tVar;
            this.e = new int[0];
            int i2 = 300000;
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager a(com.google.android.exoplayer2.drm.f0 f0) {
            super(this.b, this.c, f0, this.a, this.d, this.e, this.f, this.g, this.h, obj10, 0);
            return defaultDrmSessionManager2;
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager.b b(boolean z) {
            this.d = z;
            return this;
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager.b c(boolean z) {
            this.f = z;
            return this;
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager.b d(int... iArr) {
            int i3;
            int i4;
            int i;
            int i2;
            final int i5 = 0;
            i3 = i5;
            while (i3 < iArr.length) {
                i4 = iArr[i3];
                if (i4 != 2) {
                }
                g.a(i2);
                i3++;
                if (i4 == 1) {
                } else {
                }
                i2 = i5;
            }
            this.e = (int[])iArr.clone();
            return this;
        }

        public com.google.android.exoplayer2.drm.DefaultDrmSessionManager.b e(UUID uUID, com.google.android.exoplayer2.drm.b0.c b0$c2) {
            g.e(uUID);
            this.b = (UUID)uUID;
            g.e(c2);
            this.c = (b0.c)c2;
            return this;
        }
    }

    private class d extends Handler {

        final com.google.android.exoplayer2.drm.DefaultDrmSessionManager a;
        public d(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager, Looper looper2) {
            this.a = defaultDrmSessionManager;
            super(looper2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object next;
            boolean z;
            Object obj5;
            final Object obj = message.obj;
            if ((byte[])obj == null) {
            }
            Iterator iterator = DefaultDrmSessionManager.m(this.a).iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((DefaultDrmSession)next.n((byte[])obj)) {
                    break;
                } else {
                }
            }
        }
    }

    private class c implements com.google.android.exoplayer2.drm.b0.b {

        final com.google.android.exoplayer2.drm.DefaultDrmSessionManager a;
        private c(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
            this.a = defaultDrmSessionManager;
            super();
        }

        c(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager, com.google.android.exoplayer2.drm.DefaultDrmSessionManager.a defaultDrmSessionManager$a2) {
            super(defaultDrmSessionManager);
        }

        @Override // com.google.android.exoplayer2.drm.b0$b
        public void a(com.google.android.exoplayer2.drm.b0 b0, byte[] b2Arr2, int i3, int i4, byte[] b5Arr5) {
            com.google.android.exoplayer2.drm.DefaultDrmSessionManager.d obj1 = obj1.x;
            g.e(obj1);
            (DefaultDrmSessionManager.d)obj1.obtainMessage(i3, b2Arr2).sendToTarget();
        }
    }

    private class e implements com.google.android.exoplayer2.drm.v.b {

        private final com.google.android.exoplayer2.drm.u.a b;
        private com.google.android.exoplayer2.drm.DrmSession c;
        private boolean d;
        final com.google.android.exoplayer2.drm.DefaultDrmSessionManager e;
        public e(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager, com.google.android.exoplayer2.drm.u.a u$a2) {
            this.e = defaultDrmSessionManager;
            super();
            this.b = a2;
        }

        private void d(i1 i1) {
            int i;
            Looper looper;
            com.google.android.exoplayer2.drm.u.a aVar;
            int i2;
            Object obj5;
            if (DefaultDrmSessionManager.q(this.e) != 0) {
                if (this.d) {
                } else {
                    i = this.e;
                    looper = DefaultDrmSessionManager.k(i);
                    g.e(looper);
                    this.c = DefaultDrmSessionManager.l(i, (Looper)looper, this.b, i1, false);
                    DefaultDrmSessionManager.j(this.e).add(this);
                }
            }
        }

        private void f() {
            com.google.android.exoplayer2.drm.u.a aVar;
            if (this.d) {
            }
            com.google.android.exoplayer2.drm.DrmSession drmSession = this.c;
            if (drmSession != null) {
                drmSession.b(this.b);
            }
            DefaultDrmSessionManager.j(this.e).remove(this);
            this.d = true;
        }

        @Override // com.google.android.exoplayer2.drm.v$b
        public void a() {
            Handler handler = DefaultDrmSessionManager.p(this.e);
            g.e(handler);
            d dVar = new d(this);
            p0.v0((Handler)handler, dVar);
        }

        @Override // com.google.android.exoplayer2.drm.v$b
        public void c(i1 i1) {
            Handler handler = DefaultDrmSessionManager.p(this.e);
            g.e(handler);
            e eVar = new e(this, i1);
            (Handler)handler.post(eVar);
        }

        @Override // com.google.android.exoplayer2.drm.v$b
        public void e(i1 i1) {
            d(i1);
        }

        @Override // com.google.android.exoplayer2.drm.v$b
        public void g() {
            f();
        }
    }

    private class f implements com.google.android.exoplayer2.drm.DefaultDrmSession.a {

        private final Set<com.google.android.exoplayer2.drm.DefaultDrmSession> a;
        private com.google.android.exoplayer2.drm.DefaultDrmSession b;
        public f(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
            super();
            HashSet obj1 = new HashSet();
            this.a = obj1;
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession$a
        public void a(Exception exception, boolean z2) {
            Set next;
            this.b = 0;
            this.a.clear();
            com.google.common.collect.b1 b1Var = v.u(this.a).m();
            for (DefaultDrmSession next : b1Var) {
                next.x(exception, z2);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession$a
        public void b(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession) {
            this.a.add(defaultDrmSession);
            if (this.b != null) {
            }
            this.b = defaultDrmSession;
            defaultDrmSession.B();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession$a
        public void c() {
            Set next;
            this.b = 0;
            this.a.clear();
            com.google.common.collect.b1 b1Var = v.u(this.a).m();
            for (DefaultDrmSession next : b1Var) {
                next.w();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession$a
        public void d(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession) {
            Object obj2;
            this.a.remove(defaultDrmSession);
            this.b = 0;
            if (this.b == defaultDrmSession && !this.a.isEmpty()) {
                this.b = 0;
                if (!this.a.isEmpty()) {
                    obj2 = this.a.iterator().next();
                    this.b = (DefaultDrmSession)obj2;
                    obj2.B();
                }
            }
        }
    }

    private class g implements com.google.android.exoplayer2.drm.DefaultDrmSession.b {

        final com.google.android.exoplayer2.drm.DefaultDrmSessionManager a;
        private g(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
            this.a = defaultDrmSessionManager;
            super();
        }

        g(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager, com.google.android.exoplayer2.drm.DefaultDrmSessionManager.a defaultDrmSessionManager$a2) {
            super(defaultDrmSessionManager);
        }

        static void c(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession) {
            defaultDrmSession.b(0);
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession$b
        public void a(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, int i2) {
            int obj6;
            if (Long.compare(l, l2) != 0) {
                DefaultDrmSessionManager.o(this.a).remove(defaultDrmSession);
                obj6 = DefaultDrmSessionManager.p(this.a);
                g.e(obj6);
                (Handler)obj6.removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession$b
        public void b(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, int i2) {
            com.google.android.exoplayer2.drm.f fVar;
            int i;
            int cmp;
            long l;
            Handler obj7;
            fVar = -9223372036854775807L;
            cmp = Long.compare(l2, fVar);
            if (i2 == 1 && DefaultDrmSessionManager.q(this.a) > 0 && cmp != 0) {
                if (DefaultDrmSessionManager.q(this.a) > 0) {
                    cmp = Long.compare(l2, fVar);
                    if (cmp != 0) {
                        DefaultDrmSessionManager.o(this.a).add(defaultDrmSession);
                        obj7 = DefaultDrmSessionManager.p(this.a);
                        g.e(obj7);
                        fVar = new f(defaultDrmSession);
                        (Handler)obj7.postAtTime(fVar, defaultDrmSession, uptimeMillis += l);
                    } else {
                        DefaultDrmSessionManager.m(this.a).remove(defaultDrmSession);
                        int i3 = 0;
                        if (i2 == 0 && DefaultDrmSessionManager.r(this.a) == defaultDrmSession) {
                            DefaultDrmSessionManager.m(this.a).remove(defaultDrmSession);
                            i3 = 0;
                            if (DefaultDrmSessionManager.r(this.a) == defaultDrmSession) {
                                DefaultDrmSessionManager.s(this.a, i3);
                            }
                            if (DefaultDrmSessionManager.e(this.a) == defaultDrmSession) {
                                DefaultDrmSessionManager.g(this.a, i3);
                            }
                            DefaultDrmSessionManager.h(this.a).d(defaultDrmSession);
                            if (Long.compare(cmp, fVar) != 0) {
                                obj7 = DefaultDrmSessionManager.p(this.a);
                                g.e(obj7);
                                (Handler)obj7.removeCallbacksAndMessages(defaultDrmSession);
                                DefaultDrmSessionManager.o(this.a).remove(defaultDrmSession);
                            }
                        }
                    }
                } else {
                }
            } else {
            }
            DefaultDrmSessionManager.i(this.a);
        }
    }
    private DefaultDrmSessionManager(UUID uUID, com.google.android.exoplayer2.drm.b0.c b0$c2, com.google.android.exoplayer2.drm.f0 f03, HashMap<String, String> hashMap4, boolean z5, int[] i6Arr6, boolean z7, w w8, long l9) {
        super();
        g.e(uUID);
        g.b(equals ^= 1, "Use C.CLEARKEY_UUID instead");
        this.b = uUID;
        this.c = c2;
        this.d = f03;
        this.e = hashMap4;
        this.f = z5;
        this.g = i6Arr6;
        this.h = z7;
        this.j = w8;
        DefaultDrmSessionManager.f obj3 = new DefaultDrmSessionManager.f(this);
        this.i = obj3;
        obj3 = new DefaultDrmSessionManager.g(this, 0);
        this.k = obj3;
        this.v = 0;
        obj3 = new ArrayList();
        this.m = obj3;
        this.n = y0.f();
        this.o = y0.f();
        this.l = l9;
    }

    DefaultDrmSessionManager(UUID uUID, com.google.android.exoplayer2.drm.b0.c b0$c2, com.google.android.exoplayer2.drm.f0 f03, HashMap hashMap4, boolean z5, int[] i6Arr6, boolean z7, w w8, long l9, com.google.android.exoplayer2.drm.DefaultDrmSessionManager.a defaultDrmSessionManager$a10) {
        super(uUID, c2, f03, hashMap4, z5, i6Arr6, z7, w8, l9, a10);
    }

    private com.google.android.exoplayer2.drm.DrmSession A(int i, boolean z2) {
        Object b0Var;
        boolean equals;
        int i2;
        com.google.android.exoplayer2.drm.DefaultDrmSession obj5;
        boolean obj6;
        b0Var = this.q;
        g.e(b0Var);
        int i3 = 1;
        if (c0.class.equals((b0)b0Var.b()) && c0.d) {
            i2 = c0.d ? i3 : 0;
        } else {
        }
        final int i4 = 0;
        if (i2 == 0 && p0.l0(this.g, i) != -1) {
            if (p0.l0(this.g, i) != -1) {
                if (g0.class.equals(b0Var.b())) {
                } else {
                    obj5 = this.r;
                    if (obj5 == null) {
                        obj5 = x(v.z(), i3, i4, z2);
                        this.m.add(obj5);
                        this.r = obj5;
                    } else {
                        obj5.a(i4);
                    }
                }
                return this.r;
            }
        }
        return i4;
    }

    private void B(Looper looper) {
        com.google.android.exoplayer2.drm.DefaultDrmSessionManager.d dVar;
        if (this.x == null) {
            dVar = new DefaultDrmSessionManager.d(this, looper);
            this.x = dVar;
        }
    }

    private void C() {
        com.google.android.exoplayer2.drm.b0 empty;
        if (this.q != null && this.p == 0 && this.m.isEmpty() && this.n.isEmpty()) {
            if (this.p == 0) {
                if (this.m.isEmpty()) {
                    if (this.n.isEmpty()) {
                        com.google.android.exoplayer2.drm.b0 b0Var = this.q;
                        g.e(b0Var);
                        (b0)b0Var.a();
                        this.q = 0;
                    }
                }
            }
        }
    }

    private void D() {
        Object next;
        int i;
        com.google.common.collect.b1 b1Var = z.s(this.o).m();
        for (DrmSession next : b1Var) {
            next.b(0);
        }
    }

    private void E() {
        Object next;
        com.google.common.collect.b1 b1Var = z.s(this.n).m();
        for (DefaultDrmSessionManager.e next : b1Var) {
            next.a();
        }
    }

    private void G(com.google.android.exoplayer2.drm.DrmSession drmSession, com.google.android.exoplayer2.drm.u.a u$a2) {
        int obj6;
        drmSession.b(a2);
        if (Long.compare(l, l2) != 0) {
            drmSession.b(0);
        }
    }

    static com.google.android.exoplayer2.drm.DefaultDrmSession e(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.s;
    }

    static com.google.android.exoplayer2.drm.DefaultDrmSession g(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager, com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession2) {
        defaultDrmSessionManager.s = defaultDrmSession2;
        return defaultDrmSession2;
    }

    static com.google.android.exoplayer2.drm.DefaultDrmSessionManager.f h(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.i;
    }

    static void i(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
        defaultDrmSessionManager.C();
    }

    static Set j(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.n;
    }

    static Looper k(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.t;
    }

    static com.google.android.exoplayer2.drm.DrmSession l(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager, Looper looper2, com.google.android.exoplayer2.drm.u.a u$a3, i1 i14, boolean z5) {
        return defaultDrmSessionManager.t(looper2, a3, i14, z5);
    }

    static List m(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.m;
    }

    static long n(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.l;
    }

    static Set o(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.o;
    }

    static Handler p(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.u;
    }

    static int q(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.p;
    }

    static com.google.android.exoplayer2.drm.DefaultDrmSession r(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager) {
        return defaultDrmSessionManager.r;
    }

    static com.google.android.exoplayer2.drm.DefaultDrmSession s(com.google.android.exoplayer2.drm.DefaultDrmSessionManager defaultDrmSessionManager, com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession2) {
        defaultDrmSessionManager.r = defaultDrmSession2;
        return defaultDrmSession2;
    }

    private com.google.android.exoplayer2.drm.DrmSession t(Looper looper, com.google.android.exoplayer2.drm.u.a u$a2, i1 i13, boolean z4) {
        com.google.android.exoplayer2.drm.DefaultDrmSession i;
        boolean next;
        boolean z;
        List obj5;
        boolean obj7;
        B(looper);
        obj5 = i13.G;
        if (obj5 == null) {
            return A(z.k(i13.D), z4);
        }
        final int i2 = 0;
        i = 0;
        if (this.w == null) {
            g.e(obj5);
            obj5 = new DefaultDrmSessionManager.MissingSchemeDataException(this.b, i);
            v.d("DefaultDrmSessionMgr", "DRM error", obj5);
            if (DefaultDrmSessionManager.y((t)obj5, this.b, i2).isEmpty() && a2 != null) {
                obj5 = new DefaultDrmSessionManager.MissingSchemeDataException(this.b, i);
                v.d("DefaultDrmSessionMgr", "DRM error", obj5);
                if (a2 != null) {
                    a2.f(obj5);
                }
                obj7 = new DrmSession.DrmSessionException(obj5, 6003);
                z obj6 = new z(obj7);
                return obj6;
            }
        } else {
            obj5 = i;
        }
        if (!this.f) {
            i = this.s;
        } else {
            obj7 = this.m.iterator();
            while (obj7.hasNext()) {
                next = obj7.next();
                if (p0.b(next.a, obj5)) {
                    break;
                } else {
                }
            }
        }
        if (i == null) {
            i = x(obj5, i2, a2, z4);
            if (!this.f) {
                this.s = i;
            }
            this.m.add(i);
        } else {
            i.a(a2);
        }
        return i;
    }

    private static boolean u(com.google.android.exoplayer2.drm.DrmSession drmSession) {
        int state;
        int i;
        int i2;
        boolean obj3;
        if (drmSession.getState() == 1) {
            if (p0.a >= 19) {
                obj3 = drmSession.getError();
                g.e(obj3);
                if (obj3 instanceof ResourceBusyException != null) {
                } else {
                    i = 0;
                }
            }
        } else {
        }
        return i;
    }

    private boolean v(com.google.android.exoplayer2.drm.t t) {
        int i;
        boolean string;
        boolean equals;
        int i2;
        UUID str;
        StringBuilder stringBuilder;
        String obj6;
        i2 = 1;
        if (this.w != null) {
            return i2;
        }
        final int i4 = 0;
        if (DefaultDrmSessionManager.y(t, this.b, i2).isEmpty() && t.v == i2 && t.e(i4).c(w0.b)) {
            if (t.v == i2) {
                if (t.e(i4).c(w0.b)) {
                    String valueOf = String.valueOf(this.b);
                    stringBuilder = new StringBuilder(length += 72);
                    stringBuilder.append("DrmInitData only contains common PSSH SchemeData. Assuming support for: ");
                    stringBuilder.append(valueOf);
                    v.h("DefaultDrmSessionMgr", stringBuilder.toString());
                }
            }
            return i4;
        }
        obj6 = t.c;
        if (obj6 != null) {
            if ("cenc".equals(obj6)) {
            } else {
                if ("cbcs".equals(obj6)) {
                    if (p0.a >= 25) {
                    } else {
                        i2 = i4;
                    }
                    return i2;
                }
                if (!"cbc1".equals(obj6) && "cens".equals(obj6)) {
                    if ("cens".equals(obj6)) {
                    }
                    return i2;
                }
            }
            return i4;
        }
        return i2;
    }

    private com.google.android.exoplayer2.drm.DefaultDrmSession w(List<com.google.android.exoplayer2.drm.t.b> list, boolean z2, com.google.android.exoplayer2.drm.u.a u$a3) {
        int cmp;
        final Object obj = this;
        g.e(obj.q);
        Looper looper = obj.t;
        g.e(looper);
        super(obj.b, obj.q, obj.i, obj.k, list, obj.v, z | z2, z2, obj.w, obj.e, obj.d, (Looper)looper, obj.j);
        defaultDrmSession.a(a3);
        if (Long.compare(l, l2) != 0) {
            defaultDrmSession.a(0);
        }
        return defaultDrmSession;
    }

    private com.google.android.exoplayer2.drm.DefaultDrmSession x(List<com.google.android.exoplayer2.drm.t.b> list, boolean z2, com.google.android.exoplayer2.drm.u.a u$a3, boolean z4) {
        com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession;
        boolean empty;
        boolean obj6;
        defaultDrmSession = w(list, z2, a3);
        if (DefaultDrmSessionManager.u(defaultDrmSession) && !this.o.isEmpty()) {
            if (!this.o.isEmpty()) {
                D();
                G(defaultDrmSession, a3);
                defaultDrmSession = w(list, z2, a3);
            }
        }
        E();
        if (DefaultDrmSessionManager.u(defaultDrmSession) && z4 && !this.n.isEmpty() && !this.o.isEmpty()) {
            if (z4) {
                if (!this.n.isEmpty()) {
                    E();
                    if (!this.o.isEmpty()) {
                        D();
                    }
                    G(defaultDrmSession, a3);
                    defaultDrmSession = w(list, z2, a3);
                }
            }
        }
        return defaultDrmSession;
    }

    private static List<com.google.android.exoplayer2.drm.t.b> y(com.google.android.exoplayer2.drm.t t, UUID uUID2, boolean z3) {
        int i;
        com.google.android.exoplayer2.drm.t.b bVar;
        int i2;
        boolean equals;
        ArrayList arrayList = new ArrayList(t.v);
        int i4 = 0;
        i = i4;
        while (i < t.v) {
            bVar = t.e(i);
            if (!bVar.c(uUID2)) {
            } else {
            }
            i2 = 1;
            if (i2 != 0) {
            }
            i++;
            if (bVar.w == null) {
            } else {
            }
            arrayList.add(bVar);
            if (z3) {
            }
            if (w0.c.equals(uUID2) && bVar.c(w0.b)) {
            } else {
            }
            i2 = i4;
            if (bVar.c(w0.b)) {
            } else {
            }
        }
        return arrayList;
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    private void z(Looper looper) {
        Object handler;
        Object obj2;
        handler = this.t;
        synchronized (this) {
            try {
                this.t = looper;
                handler = new Handler(looper);
                this.u = handler;
                if (handler == looper) {
                } else {
                }
                obj2 = 1;
                obj2 = 0;
                g.f(obj2);
                g.e(this.u);
                throw looper;
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.v
    public void F(int i, byte[] b2Arr2) {
        int i2;
        g.f(this.m.isEmpty());
        if (i != 1) {
            if (i == 3) {
                g.e(b2Arr2);
            }
        } else {
        }
        this.v = i;
        this.w = b2Arr2;
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void a() {
        int arrayList;
        int i;
        long size;
        int i2;
        i3--;
        this.p = i4;
        if (i4 != 0) {
        }
        if (Long.compare(l, size) != 0) {
            arrayList = new ArrayList(this.m);
            i = 0;
            while (i < arrayList.size()) {
                (DefaultDrmSession)arrayList.get(i).b(0);
                i++;
            }
        }
        E();
        C();
    }

    @Override // com.google.android.exoplayer2.drm.v
    public com.google.android.exoplayer2.drm.v.b b(Looper looper, com.google.android.exoplayer2.drm.u.a u$a2, i1 i13) {
        int i;
        i = this.p > 0 ? 1 : 0;
        g.f(i);
        z(looper);
        DefaultDrmSessionManager.e obj2 = new DefaultDrmSessionManager.e(this, a2);
        obj2.c(i13);
        return obj2;
    }

    @Override // com.google.android.exoplayer2.drm.v
    public com.google.android.exoplayer2.drm.DrmSession c(Looper looper, com.google.android.exoplayer2.drm.u.a u$a2, i1 i13) {
        int i;
        final int i3 = 1;
        i = this.p > 0 ? i3 : 0;
        g.f(i);
        z(looper);
        return t(looper, a2, i13, i3);
    }

    public Class<? extends com.google.android.exoplayer2.drm.a0> d(i1 i1) {
        Class<com.google.android.exoplayer2.drm.g0> cls;
        com.google.android.exoplayer2.drm.b0 b0Var = this.q;
        g.e(b0Var);
        cls = (b0)b0Var.b();
        com.google.android.exoplayer2.drm.t tVar = i1.G;
        if (tVar == null) {
            if (p0.l0(this.g, z.k(i1.D)) != -1) {
            } else {
                cls = 0;
            }
            return cls;
        }
        if (v(tVar)) {
        } else {
            cls = g0.class;
        }
        return cls;
    }

    @Override // com.google.android.exoplayer2.drm.v
    public final void f() {
        com.google.android.exoplayer2.drm.b0 cmp;
        com.google.android.exoplayer2.drm.DefaultDrmSessionManager.c cVar;
        long l;
        int i = this.p;
        this.p = i + 1;
        if (i != 0) {
        }
        int i3 = 0;
        if (this.q == null) {
            cmp = this.c.a(this.b);
            this.q = cmp;
            cVar = new DefaultDrmSessionManager.c(this, i3);
            cmp.i(cVar);
        } else {
            if (Long.compare(cVar, l) != 0) {
                cmp = 0;
                while (cmp < this.m.size()) {
                    (DefaultDrmSession)this.m.get(cmp).a(i3);
                    cmp++;
                }
            }
        }
    }
}
