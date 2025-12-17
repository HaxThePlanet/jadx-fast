package com.google.android.exoplayer2.video.b0;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l0;
import com.google.android.exoplayer2.util.r;
import com.google.android.exoplayer2.video.w;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class k implements w, com.google.android.exoplayer2.video.b0.d {

    private int A;
    private SurfaceTexture B;
    private volatile int C = 0;
    private int D = -1;
    private byte[] E;
    private final AtomicBoolean a;
    private final AtomicBoolean b;
    private final com.google.android.exoplayer2.video.b0.j c;
    private final com.google.android.exoplayer2.video.b0.f v;
    private final l0<Long> w;
    private final l0<com.google.android.exoplayer2.video.b0.h> x;
    private final float[] y;
    private final float[] z;
    public k() {
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        this.a = atomicBoolean;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(1);
        this.b = atomicBoolean2;
        j jVar = new j();
        this.c = jVar;
        f fVar = new f();
        this.v = fVar;
        l0 l0Var = new l0();
        this.w = l0Var;
        l0 l0Var2 = new l0();
        this.x = l0Var2;
        int i = 16;
        this.y = new float[i];
        this.z = new float[i];
        int i2 = 0;
        int i3 = -1;
    }

    private void f(SurfaceTexture surfaceTexture) {
        this.a.set(true);
    }

    private void i(byte[] bArr, int i2, long l3) {
        int obj3;
        int obj4;
        this.E = bArr;
        if (i2 == -1) {
            obj4 = this.C;
        }
        this.D = obj4;
        if (this.D == obj4 && Arrays.equals(this.E, this.E)) {
            if (Arrays.equals(bArr2, this.E)) {
            }
        }
        obj3 = 0;
        obj4 = this.E;
        if (obj4 != null) {
            obj3 = i.a(obj4, this.D);
        }
        if (obj3 != null && j.c(obj3)) {
            if (j.c(obj3)) {
            } else {
                obj3 = h.b(this.D);
            }
        } else {
        }
        this.x.a(l3, obj6);
    }

    @Override // com.google.android.exoplayer2.video.w
    public void a(float[] fArr, boolean z2) {
        boolean compareAndSet;
        boolean compareAndSet2;
        int i2;
        int i;
        com.google.android.exoplayer2.video.b0.f fVar;
        float[] fArr2;
        long longValue;
        GLES20.glClear(16384);
        r.b();
        i2 = 1;
        i = 0;
        SurfaceTexture surfaceTexture = this.B;
        g.e(surfaceTexture);
        (SurfaceTexture)surfaceTexture.updateTexImage();
        r.b();
        if (this.a.compareAndSet(i2, i) && this.b.compareAndSet(i2, i)) {
            surfaceTexture = this.B;
            g.e(surfaceTexture);
            (SurfaceTexture)surfaceTexture.updateTexImage();
            r.b();
            if (this.b.compareAndSet(i2, i)) {
                Matrix.setIdentityM(this.y, i);
            }
            long timestamp = this.B.getTimestamp();
            Object obj = this.w.g(timestamp);
            if ((Long)obj != null) {
                this.v.c(this.y, (Long)obj.longValue());
            }
            compareAndSet = this.x.j(timestamp);
            if ((h)compareAndSet != null) {
                this.c.d((h)compareAndSet);
            }
        }
        Matrix.multiplyMM(this.z, 0, fArr, 0, this.y, 0);
        this.c.a(this.A, this.z, z2);
    }

    @Override // com.google.android.exoplayer2.video.w
    public void b(long l, float[] f2Arr2) {
        this.v.e(l, f2Arr2);
    }

    @Override // com.google.android.exoplayer2.video.w
    public SurfaceTexture c() {
        int i = 1056964608;
        GLES20.glClearColor(i, i, i, 1065353216);
        r.b();
        this.c.b();
        r.b();
        this.A = r.g();
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.A);
        this.B = surfaceTexture;
        a aVar = new a(this);
        surfaceTexture.setOnFrameAvailableListener(aVar);
        return this.B;
    }

    @Override // com.google.android.exoplayer2.video.w
    public void d() {
        this.w.c();
        this.v.d();
        this.b.set(true);
    }

    @Override // com.google.android.exoplayer2.video.w
    public void e(long l, long l2, i1 i13, MediaFormat mediaFormat4) {
        this.w.a(i13, mediaFormat4);
        i(obj5.N, obj5.O, i13);
    }

    @Override // com.google.android.exoplayer2.video.w
    public void g(SurfaceTexture surfaceTexture) {
        f(surfaceTexture);
    }

    @Override // com.google.android.exoplayer2.video.w
    public void h(int i) {
        this.C = i;
    }
}
