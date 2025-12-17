package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.i1;

/* loaded from: classes2.dex */
public interface v {

    public static final com.google.android.exoplayer2.drm.v a;

    public interface b {

        public static final com.google.android.exoplayer2.drm.v.b a;
        static {
            v.b.a = m.b;
        }

        public static void b() {
        }

        public abstract void a();
    }

    class a implements com.google.android.exoplayer2.drm.v {
        @Override // com.google.android.exoplayer2.drm.v
        public com.google.android.exoplayer2.drm.DrmSession c(Looper looper, com.google.android.exoplayer2.drm.u.a u$a2, i1 i13) {
            if (i13.G == null) {
                return null;
            }
            UnsupportedDrmException obj4 = new UnsupportedDrmException(1);
            DrmSession.DrmSessionException obj3 = new DrmSession.DrmSessionException(obj4, 6001);
            z obj2 = new z(obj3);
            return obj2;
        }

        public Class<com.google.android.exoplayer2.drm.g0> d(i1 i1) {
            Class<com.google.android.exoplayer2.drm.g0> obj1;
            obj1 = i1.G != null ? g0.class : 0;
            return obj1;
        }
    }
    static {
        v.a aVar = new v.a();
        v.a = aVar;
    }

    public void a() {
    }

    public com.google.android.exoplayer2.drm.v.b b(Looper looper, com.google.android.exoplayer2.drm.u.a u$a2, i1 i13) {
        return v.b.a;
    }

    public abstract com.google.android.exoplayer2.drm.DrmSession c(Looper looper, com.google.android.exoplayer2.drm.u.a u$a2, i1 i13);

    public abstract Class<? extends com.google.android.exoplayer2.drm.a0> d(i1 i1);

    public void f() {
    }
}
