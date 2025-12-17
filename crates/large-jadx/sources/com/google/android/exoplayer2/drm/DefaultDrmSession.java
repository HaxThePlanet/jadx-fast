package com.google.android.exoplayer2.drm;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.source.s;
import com.google.android.exoplayer2.source.v;
import com.google.android.exoplayer2.upstream.w;
import com.google.android.exoplayer2.upstream.w.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.n;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes2.dex */
class DefaultDrmSession implements com.google.android.exoplayer2.drm.DrmSession {

    public final List<com.google.android.exoplayer2.drm.t.b> a = null;
    private final com.google.android.exoplayer2.drm.b0 b;
    private final com.google.android.exoplayer2.drm.DefaultDrmSession.a c;
    private final com.google.android.exoplayer2.drm.DefaultDrmSession.b d;
    private final int e;
    private final boolean f;
    private final boolean g;
    private final HashMap<String, String> h;
    private final n<com.google.android.exoplayer2.drm.u.a> i;
    private final w j;
    final com.google.android.exoplayer2.drm.f0 k;
    final UUID l;
    final com.google.android.exoplayer2.drm.DefaultDrmSession.e m;
    private int n = 2;
    private int o;
    private HandlerThread p;
    private com.google.android.exoplayer2.drm.DefaultDrmSession.c q;
    private com.google.android.exoplayer2.drm.a0 r;
    private com.google.android.exoplayer2.drm.DrmSession.DrmSessionException s;
    private byte[] t;
    private byte[] u;
    private com.google.android.exoplayer2.drm.b0.a v;
    private com.google.android.exoplayer2.drm.b0.d w;

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(Throwable throwable) {
            super(throwable);
        }
    }

    public interface a {
        public abstract void a(Exception exception, boolean z2);

        public abstract void b(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession);

        public abstract void c();
    }

    public interface b {
        public abstract void a(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, int i2);

        public abstract void b(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, int i2);
    }

    private class c extends Handler {

        private boolean a;
        final com.google.android.exoplayer2.drm.DefaultDrmSession b;
        public c(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, Looper looper2) {
            this.b = defaultDrmSession;
            super(looper2);
        }

        private boolean a(Message message, com.google.android.exoplayer2.drm.MediaDrmCallbackException mediaDrmCallbackException2) {
            Object cause;
            com.google.android.exoplayer2.drm.DefaultDrmSession.UnexpectedDrmSessionException unexpectedDrmSessionException;
            final Object obj2 = this;
            Object obj3 = mediaDrmCallbackException2;
            Object obj4 = obj.obj;
            final int i5 = 0;
            if (!obj4.b) {
                return i5;
            }
            i3 += i6;
            obj4.e = i4;
            int i8 = 3;
            if (i4 > DefaultDrmSession.j(obj2.b).d(i8)) {
                return i5;
            }
            super(obj4.a, obj11, obj3.dataSpec, obj3.uriAfterRedirects, obj3.responseHeaders, SystemClock.elapsedRealtime(), obj16, elapsedRealtime2 -= l2, obj18, obj3.bytesLoaded, obj20);
            v vVar = new v(i8);
            if (cause3 instanceof IOException != null) {
                cause = mediaDrmCallbackException2.getCause();
            } else {
                unexpectedDrmSessionException = new DefaultDrmSession.UnexpectedDrmSessionException(mediaDrmCallbackException2.getCause());
                cause = unexpectedDrmSessionException;
            }
            int i2 = obj4.e;
            w.c cVar = new w.c(sVar, vVar, cause, i2);
            long l = DefaultDrmSession.j(obj2.b).a(cVar);
            if (Long.compare(l, l3) == 0) {
                return i5;
            }
            synchronized (this) {
                obj2.sendMessageDelayed(Message.obtain(message), l);
                return 1;
            }
        }

        @Override // android.os.Handler
        void b(int i, Object object2, boolean z3) {
            super(s.a(), obj2, z3, SystemClock.elapsedRealtime(), obj5, object2);
            obtainMessage(i, dVar2).sendToTarget();
        }

        @Override // android.os.Handler
        public void c() {
            removeCallbacksAndMessages(0);
            this.a = true;
            return;
            synchronized (this) {
                removeCallbacksAndMessages(0);
                this.a = true;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object create;
            byte[] bArr;
            com.google.android.exoplayer2.drm.f0 f0Var;
            boolean z;
            Object obj;
            Object obj6;
            create = message.obj;
            int what = message.what;
            if (what != 0) {
                if (what != 1) {
                } else {
                    com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession = this.b;
                    bArr = defaultDrmSession.k.a(defaultDrmSession.l, (b0.a)create.d);
                    DefaultDrmSession.j(this.b).c(create.a);
                    synchronized (this) {
                        defaultDrmSession4.m.obtainMessage(message.what, Pair.create(create.d, bArr)).sendToTarget();
                    }
                }
                RuntimeException runtimeException = new RuntimeException();
                throw runtimeException;
            }
            try {
                com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession2 = this.b;
                bArr = defaultDrmSession2.k.b(defaultDrmSession2.l, (b0.d)create.d);
                String str = "DefaultDrmSession";
                v.i(str, "Key/provisioning request produced an unexpected exception. Not retrying.", th);
                str = a(message, th);
                if (str != null) {
                }
                DefaultDrmSession.j(this.b).c(create.a);
                if (!this.a) {
                }
                defaultDrmSession4.m.obtainMessage(message.what, Pair.create(create.d, bArr)).sendToTarget();
                throw message;
            } catch (Throwable th) {
            }
        }
    }

    private static final class d {

        public final long a;
        public final boolean b;
        public final long c;
        public final Object d;
        public int e;
        public d(long l, boolean z2, long l3, Object object4) {
            super();
            this.a = l;
            this.b = l3;
            this.c = object4;
            this.d = obj6;
        }
    }

    private class e extends Handler {

        final com.google.android.exoplayer2.drm.DefaultDrmSession a;
        public e(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, Looper looper2) {
            this.a = defaultDrmSession;
            super(looper2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i;
            com.google.android.exoplayer2.drm.DefaultDrmSession obj4;
            Object obj = message.obj;
            final Object first = obj.first;
            Object second = obj.second;
            obj4 = message.what;
            if (obj4 != null) {
                if (obj4 != 1) {
                } else {
                    DefaultDrmSession.i(this.a, first, second);
                }
            } else {
                DefaultDrmSession.h(this.a, first, second);
            }
        }
    }
    public DefaultDrmSession(UUID uUID, com.google.android.exoplayer2.drm.b0 b02, com.google.android.exoplayer2.drm.DefaultDrmSession.a defaultDrmSession$a3, com.google.android.exoplayer2.drm.DefaultDrmSession.b defaultDrmSession$b4, List<com.google.android.exoplayer2.drm.t.b> list5, int i6, boolean z7, boolean z8, byte[] b9Arr9, HashMap<String, String> hashMap10, com.google.android.exoplayer2.drm.f0 f011, Looper looper12, w w13) {
        int i;
        List obj2;
        super();
        if (i6 != 1) {
            if (i6 == 3) {
                g.e(b9Arr9);
            }
        } else {
        }
        this.l = uUID;
        this.c = a3;
        this.d = b4;
        this.b = b02;
        this.e = i6;
        this.f = z7;
        this.g = z8;
        if (b9Arr9 != null) {
            this.u = b9Arr9;
            obj2 = 0;
        } else {
            g.e(list5);
            this.a = Collections.unmodifiableList((List)list5);
        }
        this.h = hashMap10;
        this.k = f011;
        obj2 = new n();
        this.i = obj2;
        this.j = w13;
        obj2 = 2;
        obj2 = new DefaultDrmSession.e(this, looper12);
        this.m = obj2;
    }

    private void A(byte[] bArr, int i2, boolean z3) {
        com.google.android.exoplayer2.drm.DefaultDrmSession.c obj5;
        this.v = this.b.l(bArr, this.a, i2, this.h);
        obj5 = this.q;
        p0.i(obj5);
        final com.google.android.exoplayer2.drm.b0.a obj6 = this.v;
        g.e(obj6);
        (DefaultDrmSession.c)obj5.b(1, obj6, z3);
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean C() {
        this.b.g(this.t, this.u);
        return 1;
    }

    static void h(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, Object object2, Object object3) {
        defaultDrmSession.y(object2, object3);
    }

    static void i(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession, Object object2, Object object3) {
        defaultDrmSession.s(object2, object3);
    }

    static w j(com.google.android.exoplayer2.drm.DefaultDrmSession defaultDrmSession) {
        return defaultDrmSession.j;
    }

    private void k(m<com.google.android.exoplayer2.drm.u.a> m) {
        Object next;
        Iterator iterator = this.i.H().iterator();
        for (u.a next : iterator) {
            m.accept(next);
        }
    }

    @RequiresNonNull("sessionId")
    private void l(boolean z) {
        byte[] bArr;
        int string;
        int str;
        long l;
        int i;
        boolean obj9;
        if (this.g) {
        }
        bArr = this.t;
        p0.i(bArr);
        string = this.e;
        str = 1;
        final int i3 = 2;
        if (string != null && string != str) {
            if (string != str) {
                if (string != i3) {
                    bArr = 3;
                    if (string != bArr) {
                    } else {
                        g.e(this.u);
                        g.e(this.t);
                        A(this.u, bArr, z);
                    }
                } else {
                    if (this.u != null) {
                        if (C()) {
                            A((byte[])bArr, i3, z);
                        }
                    } else {
                    }
                }
            } else {
                if (this.u == null) {
                    A(bArr, str, z);
                } else {
                    str = 4;
                    if (this.n != str) {
                        if (C()) {
                            l = m();
                            if (this.e == 0 && Long.compare(l, i) <= 0) {
                                if (Long.compare(l, i) <= 0) {
                                    StringBuilder stringBuilder = new StringBuilder(88);
                                    stringBuilder.append("Offline license has expired or will expire soon. Remaining seconds: ");
                                    stringBuilder.append(l);
                                    v.b("DefaultDrmSession", stringBuilder.toString());
                                    A(bArr, i3, z);
                                } else {
                                    if (Long.compare(l, bArr) <= 0) {
                                        obj9 = new KeysExpiredException();
                                        r(obj9, i3);
                                    } else {
                                        this.n = str;
                                        k(q.a);
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            }
        } else {
        }
    }

    private long m() {
        if (!w0.d.equals(this.l)) {
            return Long.MAX_VALUE;
        }
        Pair pair = h0.b(this);
        g.e(pair);
        return Math.min((Long)pair.first.longValue(), obj2);
    }

    @EnsuresNonNullIf(expression = "sessionId", result = true)
    private boolean o() {
        int i2;
        int i;
        int i3 = this.n;
        if (i3 != 3) {
            if (i3 == 4) {
                i2 = 1;
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    static void p(Exception exception, com.google.android.exoplayer2.drm.u.a u$a2) {
        a2.f(exception);
    }

    static void q(int i, com.google.android.exoplayer2.drm.u.a u$a2) {
        a2.e(i);
    }

    private void r(Exception exception, int i2) {
        int obj2;
        DrmSession.DrmSessionException drmSessionException = new DrmSession.DrmSessionException(exception, x.a(exception, i2));
        this.s = drmSessionException;
        v.d("DefaultDrmSession", "DRM session error", exception);
        b obj3 = new b(exception);
        k(obj3);
        if (this.n != 4) {
            this.n = 1;
        }
    }

    private void s(Object object, Object object2) {
        com.google.android.exoplayer2.drm.b0.a aVar;
        com.google.android.exoplayer2.drm.b0.a obj2;
        int obj3;
        if (object == this.v) {
            if (!o()) {
            } else {
                this.v = 0;
                if (object2 instanceof Exception != null) {
                    t((Exception)object2, false);
                }
                if (this.e == 3) {
                    aVar = this.u;
                    p0.i(aVar);
                    this.b.j((byte[])aVar, (byte[])object2);
                    k(a.a);
                } else {
                    obj2 = this.b.j(this.t, object2);
                    obj3 = this.e;
                    if (obj3 != 2) {
                        if (obj3 == null && this.u != null && obj2 != null && obj2.length != 0) {
                            if (this.u != null) {
                                if (obj2 != null) {
                                    if (obj2.length != 0) {
                                        this.u = obj2;
                                    }
                                }
                            }
                        }
                    } else {
                    }
                    this.n = 4;
                    k(p.a);
                }
            }
        }
    }

    private void t(Exception exception, boolean z2) {
        Object obj2;
        int obj3;
        if (exception instanceof NotProvisionedException != null) {
            this.c.b(this);
        } else {
            obj3 = z2 != 0 ? 1 : 2;
            r(exception, obj3);
        }
    }

    private void u() {
        int i2;
        int i;
        if (this.e == 0 && this.n == 4) {
            if (this.n == 4) {
                p0.i(this.t);
                l(false);
            }
        }
    }

    private void y(Object object, Object object2) {
        com.google.android.exoplayer2.drm.b0.d dVar;
        int obj2;
        Object obj3;
        if (object == this.w) {
            if (this.n != 2 && !o()) {
                if (!o()) {
                } else {
                    this.w = 0;
                    if (object2 instanceof Exception != null) {
                        this.c.a((Exception)object2, false);
                    }
                }
            } else {
            }
            this.b.k((byte[])object2);
            this.c.c();
        }
    }

    @EnsuresNonNullIf(expression = "sessionId", result = true)
    private boolean z() {
        final int i2 = 1;
        if (o()) {
            return i2;
        }
        byte[] bArr = this.b.f();
        this.t = bArr;
        this.r = this.b.d(bArr);
        int i = 3;
        this.n = i;
        c cVar = new c(i);
        k(cVar);
        g.e(this.t);
        return i2;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void B() {
        this.w = this.b.e();
        com.google.android.exoplayer2.drm.DefaultDrmSession.c cVar = this.q;
        p0.i(cVar);
        final com.google.android.exoplayer2.drm.b0.d dVar2 = this.w;
        g.e(dVar2);
        (DefaultDrmSession.c)cVar.b(0, dVar2, true);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(com.google.android.exoplayer2.drm.u.a u$a) {
        int i2;
        Looper looper;
        int i;
        boolean obj4;
        final int i7 = 1;
        i2 = this.o >= 0 ? i7 : i;
        g.f(i2);
        if (a != null) {
            this.i.b(a);
        }
        i4 += i7;
        this.o = looper;
        if (looper == i7) {
            if (this.n == 2) {
                i = i7;
            }
            g.f(i);
            obj4 = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.p = obj4;
            obj4.start();
            obj4 = new DefaultDrmSession.c(this, this.p.getLooper());
            this.q = obj4;
            if (z()) {
                l(i7);
            }
        } else {
            if (a != null && o() && this.i.d(a) == i7) {
                if (o()) {
                    if (this.i.d(a) == i7) {
                        a.e(this.n);
                    }
                }
            }
        }
        this.d.a(this, this.o);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void b(com.google.android.exoplayer2.drm.u.a u$a) {
        int i3;
        int i;
        int i2;
        int i4;
        i2 = 1;
        i4 = 0;
        i3 = this.o > 0 ? i2 : i4;
        g.f(i3);
        i6 -= i2;
        this.o = i;
        this.n = i4;
        com.google.android.exoplayer2.drm.DefaultDrmSession.e eVar = this.m;
        p0.i(eVar);
        i2 = 0;
        (DefaultDrmSession.e)eVar.removeCallbacksAndMessages(i2);
        com.google.android.exoplayer2.drm.DefaultDrmSession.c cVar = this.q;
        p0.i(cVar);
        (DefaultDrmSession.c)cVar.c();
        this.q = i2;
        HandlerThread handler = this.p;
        p0.i(handler);
        (HandlerThread)handler.quit();
        this.p = i2;
        this.r = i2;
        this.s = i2;
        this.v = i2;
        this.w = i2;
        i = this.t;
        if (i == 0 && i != null) {
            this.n = i4;
            eVar = this.m;
            p0.i(eVar);
            i2 = 0;
            (DefaultDrmSession.e)eVar.removeCallbacksAndMessages(i2);
            cVar = this.q;
            p0.i(cVar);
            (DefaultDrmSession.c)cVar.c();
            this.q = i2;
            handler = this.p;
            p0.i(handler);
            (HandlerThread)handler.quit();
            this.p = i2;
            this.r = i2;
            this.s = i2;
            this.v = i2;
            this.w = i2;
            i = this.t;
            if (i != null) {
                this.b.h(i);
                this.t = i2;
            }
        }
        this.i.g(a);
        if (a != null && this.i.d(a) == 0) {
            this.i.g(a);
            if (this.i.d(a) == 0) {
                a.g();
            }
        }
        this.d.b(this, this.o);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID d() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean e() {
        return this.f;
    }

    public Map<String, String> f() {
        int i;
        com.google.android.exoplayer2.drm.b0 b0Var;
        byte[] bArr = this.t;
        if (bArr == null) {
            i = 0;
        } else {
            i = this.b.c(bArr);
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final com.google.android.exoplayer2.drm.a0 g() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final com.google.android.exoplayer2.drm.DrmSession.DrmSessionException getError() {
        com.google.android.exoplayer2.drm.DrmSession.DrmSessionException exc;
        exc = this.n == 1 ? this.s : 0;
        return exc;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.n;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean n(byte[] bArr) {
        return Arrays.equals(this.t, bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void v(int i) {
        if (i != 2) {
        } else {
            u();
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void w() {
        boolean z;
        if (z()) {
            l(true);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void x(Exception exception, boolean z2) {
        int obj2;
        obj2 = z2 ? 1 : 3;
        r(exception, obj2);
    }
}
