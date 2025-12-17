package com.google.android.exoplayer2.video.b0;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.video.w;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes2.dex */
public final class l extends GLSurfaceView {

    private Surface A;
    private boolean B;
    private boolean C;
    private boolean D;
    private final CopyOnWriteArrayList<com.google.android.exoplayer2.video.b0.l.b> a;
    private final SensorManager b;
    private final Sensor c;
    private final com.google.android.exoplayer2.video.b0.g v;
    private final Handler w;
    private final com.google.android.exoplayer2.video.b0.m x;
    private final com.google.android.exoplayer2.video.b0.k y;
    private SurfaceTexture z;

    public interface b {
        public abstract void O(Surface surface);

        public abstract void U(Surface surface);
    }

    final class a implements GLSurfaceView.Renderer, com.google.android.exoplayer2.video.b0.m.a, com.google.android.exoplayer2.video.b0.g.a {

        private final float[] A;
        private final float[] B;
        final com.google.android.exoplayer2.video.b0.l C;
        private final com.google.android.exoplayer2.video.b0.k a;
        private final float[] b;
        private final float[] c;
        private final float[] v;
        private final float[] w;
        private final float[] x;
        private float y;
        private float z = 3.1415927f;
        public a(com.google.android.exoplayer2.video.b0.l l, com.google.android.exoplayer2.video.b0.k k2) {
            this.C = l;
            super();
            int obj5 = 16;
            this.b = new float[obj5];
            this.c = new float[obj5];
            float[] fArr3 = new float[obj5];
            this.v = fArr3;
            final float[] fArr4 = new float[obj5];
            this.w = fArr4;
            final float[] fArr5 = new float[obj5];
            this.x = fArr5;
            this.A = new float[obj5];
            this.B = new float[obj5];
            this.a = k2;
            obj5 = 0;
            Matrix.setIdentityM(fArr3, obj5);
            Matrix.setIdentityM(fArr4, obj5);
            Matrix.setIdentityM(fArr5, obj5);
            obj5 = 1078530011;
        }

        private float c(float f) {
            int i;
            i = Float.compare(f, i2) > 0 ? 1 : 0;
            if (i != 0) {
                return (float)i4;
            }
            return 1119092736;
        }

        private void d() {
            Matrix.setRotateM(this.w, 0, -f, (float)d2, (float)d4, 0);
        }

        @Override // android.opengl.GLSurfaceView$Renderer
        public void a(float[] fArr, float f2) {
            final float[] fArr2 = this.v;
            final int i = 0;
            System.arraycopy(fArr, i, fArr2, i, fArr2.length);
            this.z = -f2;
            d();
            return;
            synchronized (this) {
                fArr2 = this.v;
                i = 0;
                System.arraycopy(fArr, i, fArr2, i, fArr2.length);
                this.z = -f2;
                d();
            }
        }

        @Override // android.opengl.GLSurfaceView$Renderer
        public void b(PointF pointF) {
            this.y = pointF.y;
            d();
            Matrix.setRotateM(this.x, 0, -obj8, 0, 1065353216, 0);
            return;
            synchronized (this) {
                this.y = pointF.y;
                d();
                Matrix.setRotateM(this.x, 0, -obj8, 0, 1065353216, 0);
            }
        }

        @Override // android.opengl.GLSurfaceView$Renderer
        public void onDrawFrame(GL10 gL10) {
            Matrix.multiplyMM(this.B, 0, this.v, 0, this.x, 0);
            Matrix.multiplyMM(this.A, 0, this.w, 0, this.B, 0);
            int i2 = 0;
            Matrix.multiplyMM(this.c, i2, this.b, 0, this.A, 0);
            this.a.a(this.c, i2);
            return;
            synchronized (this) {
                Matrix.multiplyMM(this.B, 0, this.v, 0, this.x, 0);
                Matrix.multiplyMM(this.A, 0, this.w, 0, this.B, 0);
                i2 = 0;
                Matrix.multiplyMM(this.c, i2, this.b, 0, this.A, 0);
                this.a.a(this.c, i2);
            }
        }

        @Override // android.opengl.GLSurfaceView$Renderer
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return this.C.performClick();
        }

        @Override // android.opengl.GLSurfaceView$Renderer
        public void onSurfaceChanged(GL10 gL10, int i2, int i3) {
            int obj7 = 0;
            GLES20.glViewport(obj7, obj7, i2, i3);
            final int i4 = obj7 / obj8;
            Matrix.perspectiveM(this.b, 0, c(i4), i4, 1036831949, 1120403456);
        }

        @Override // android.opengl.GLSurfaceView$Renderer
        public void onSurfaceCreated(GL10 gL10, EGLConfig eGLConfig2) {
            l.a(this.C, this.a.c());
            return;
            synchronized (this) {
                l.a(this.C, this.a.c());
            }
        }
    }
    public l(Context context) {
        super(context, 0);
    }

    public l(Context context, AttributeSet attributeSet2) {
        Sensor defaultSensor;
        super(context, attributeSet2);
        CopyOnWriteArrayList obj7 = new CopyOnWriteArrayList();
        this.a = obj7;
        obj7 = new Handler(Looper.getMainLooper());
        this.w = obj7;
        obj7 = context.getSystemService("sensor");
        g.e(obj7);
        this.b = (SensorManager)obj7;
        if (p0.a >= 18) {
            defaultSensor = obj7.getDefaultSensor(15);
        } else {
            defaultSensor = 0;
        }
        if (defaultSensor == null) {
            defaultSensor = obj7.getDefaultSensor(11);
        }
        this.c = defaultSensor;
        obj7 = new k();
        this.y = obj7;
        l.a aVar = new l.a(this, obj7);
        obj7 = new m(context, aVar, 1103626240);
        this.x = obj7;
        Object obj6 = context.getSystemService("window");
        g.e((WindowManager)obj6);
        final int i6 = 2;
        final com.google.android.exoplayer2.video.b0.g.a[] arr = new g.a[i6];
        arr[0] = obj7;
        int i8 = 1;
        arr[i8] = aVar;
        g gVar = new g((WindowManager)obj6.getDefaultDisplay(), arr);
        this.v = gVar;
        this.B = i8;
        setEGLContextClientVersion(i6);
        setRenderer(aVar);
        setOnTouchListener(obj7);
    }

    static void a(com.google.android.exoplayer2.video.b0.l l, SurfaceTexture surfaceTexture2) {
        l.g(surfaceTexture2);
    }

    private void c() {
        Iterator iterator;
        Object next;
        Surface surface = this.A;
        if (surface != null) {
            iterator = this.a.iterator();
            for (l.b next : iterator) {
                next.O(surface);
            }
        }
        l.h(this.z, surface);
        int i = 0;
        this.z = i;
        this.A = i;
    }

    private void e(SurfaceTexture surfaceTexture) {
        Object next;
        Surface surface2 = new Surface(surfaceTexture);
        this.z = surfaceTexture;
        this.A = surface2;
        Iterator obj5 = this.a.iterator();
        for (l.b next : obj5) {
            next.U(surface2);
        }
        l.h(this.z, this.A);
    }

    private void g(SurfaceTexture surfaceTexture) {
        b bVar = new b(this, surfaceTexture);
        this.w.post(bVar);
    }

    private static void h(SurfaceTexture surfaceTexture, Surface surface2) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface2 != null) {
            surface2.release();
        }
    }

    private void j() {
        boolean z2;
        int i;
        int i2;
        Object sensor;
        boolean z;
        com.google.android.exoplayer2.video.b0.g gVar;
        i2 = 0;
        if (this.B && this.C) {
            i = this.C ? 1 : i2;
        } else {
        }
        sensor = this.c;
        if (sensor != null) {
            if (i == this.D) {
            } else {
                if (i != 0) {
                    this.b.registerListener(this.v, sensor, i2);
                } else {
                    this.b.unregisterListener(this.v);
                }
                this.D = i;
            }
        }
    }

    @Override // android.opengl.GLSurfaceView
    public void b(com.google.android.exoplayer2.video.b0.l.b l$b) {
        this.a.add(b);
    }

    @Override // android.opengl.GLSurfaceView
    public void d() {
        c();
    }

    @Override // android.opengl.GLSurfaceView
    public void f(SurfaceTexture surfaceTexture) {
        e(surfaceTexture);
    }

    @Override // android.opengl.GLSurfaceView
    public com.google.android.exoplayer2.video.b0.d getCameraMotionListener() {
        return this.y;
    }

    @Override // android.opengl.GLSurfaceView
    public w getVideoFrameMetadataListener() {
        return this.y;
    }

    @Override // android.opengl.GLSurfaceView
    public Surface getVideoSurface() {
        return this.A;
    }

    @Override // android.opengl.GLSurfaceView
    public void i(com.google.android.exoplayer2.video.b0.l.b l$b) {
        this.a.remove(b);
    }

    @Override // android.opengl.GLSurfaceView
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c cVar = new c(this);
        this.w.post(cVar);
    }

    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.C = false;
        j();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.C = true;
        j();
    }

    @Override // android.opengl.GLSurfaceView
    public void setDefaultStereoMode(int i) {
        this.y.h(i);
    }

    @Override // android.opengl.GLSurfaceView
    public void setUseSensorRotation(boolean z) {
        this.B = z;
        j();
    }
}
