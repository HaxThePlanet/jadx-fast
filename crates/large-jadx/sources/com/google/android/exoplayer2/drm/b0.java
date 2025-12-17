package com.google.android.exoplayer2.drm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public interface b0 {

    public static final class a {

        private final byte[] a;
        private final String b;
        public a(byte[] bArr, String string2, int i3) {
            super();
            this.a = bArr;
            this.b = string2;
        }

        public byte[] a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }
    }

    public interface b {
        public abstract void a(com.google.android.exoplayer2.drm.b0 b0, byte[] b2Arr2, int i3, int i4, byte[] b5Arr5);
    }

    public interface c {
        public abstract com.google.android.exoplayer2.drm.b0 a(UUID uUID);
    }

    public static final class d {

        private final byte[] a;
        private final String b;
        public d(byte[] bArr, String string2) {
            super();
            this.a = bArr;
            this.b = string2;
        }

        public byte[] a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }
    }
    public abstract void a();

    public abstract Class<? extends com.google.android.exoplayer2.drm.a0> b();

    public abstract Map<String, String> c(byte[] bArr);

    public abstract com.google.android.exoplayer2.drm.a0 d(byte[] bArr);

    public abstract com.google.android.exoplayer2.drm.b0.d e();

    public abstract byte[] f();

    public abstract void g(byte[] bArr, byte[] b2Arr2);

    public abstract void h(byte[] bArr);

    public abstract void i(com.google.android.exoplayer2.drm.b0.b b0$b);

    public abstract byte[] j(byte[] bArr, byte[] b2Arr2);

    public abstract void k(byte[] bArr);

    public abstract com.google.android.exoplayer2.drm.b0.a l(byte[] bArr, List<com.google.android.exoplayer2.drm.t.b> list2, int i3, HashMap<String, String> hashMap4);
}
