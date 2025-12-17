package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;

/* loaded from: classes2.dex */
public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    private static final int[] z;
    private final Handler a;
    private final int[] b;
    private final com.google.android.exoplayer2.util.EGLSurfaceTexture.b c;
    private EGLDisplay v;
    private EGLContext w;
    private EGLSurface x;
    private SurfaceTexture y;

    public static final class GlException extends RuntimeException {
        private GlException(String string) {
            super(string);
        }

        GlException(String string, com.google.android.exoplayer2.util.EGLSurfaceTexture.a eGLSurfaceTexture$a2) {
            super(string);
        }
    }

    static class a {
    }

    public interface b {
        public abstract void a();
    }
    static {
        int[] iArr = new int[17];
        iArr = new int[]{
            12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8,
            12325, 0, 12327, 12344, 12339, 4, 12344
        };
        EGLSurfaceTexture.z = iArr;
    }

    public EGLSurfaceTexture(Handler handler) {
        super(handler, 0);
    }

    public EGLSurfaceTexture(Handler handler, com.google.android.exoplayer2.util.EGLSurfaceTexture.b eGLSurfaceTexture$b2) {
        super();
        this.a = handler;
        this.c = b2;
        this.b = new int[1];
    }

    private static EGLConfig a(EGLDisplay eGLDisplay) {
        int[] iArr;
        int i = 1;
        final EGLConfig[] arr2 = new EGLConfig[i];
        final int[] iArr3 = new int[i];
        boolean obj11 = EGL14.eglChooseConfig(eGLDisplay, EGLSurfaceTexture.z, 0, arr2, 0, 1, iArr3, 0);
        int i3 = 0;
        if (obj11 == null) {
        } else {
            if (iArr3[i3] <= 0) {
            } else {
                if (arr2[i3] == null) {
                } else {
                    return arr2[i3];
                }
            }
        }
        Object[] arr = new Object[3];
        arr[i3] = Boolean.valueOf(obj11);
        arr[i] = Integer.valueOf(iArr3[i3]);
        arr[2] = arr2[i3];
        EGLSurfaceTexture.GlException glException = new EGLSurfaceTexture.GlException(p0.z("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", arr), 0);
        throw glException;
    }

    private static EGLContext b(EGLDisplay eGLDisplay, EGLConfig eGLConfig2, int i3) {
        int[] obj4;
        if (i3 == 0) {
            obj4 = new int[]{12440, 2, 12344};
        } else {
            obj4 = new int[]{12440, 2, 12992, 1, 12344};
        }
        EGLContext obj2 = EGL14.eglCreateContext(eGLDisplay, eGLConfig2, EGL14.EGL_NO_CONTEXT, obj4, 0);
        if (obj2 == null) {
        } else {
            return obj2;
        }
        obj2 = new EGLSurfaceTexture.GlException("eglCreateContext failed", 0);
        throw obj2;
    }

    private static EGLSurface c(EGLDisplay eGLDisplay, EGLConfig eGLConfig2, EGLContext eGLContext3, int i4) {
        int i;
        EGLSurface obj3;
        int[] obj5;
        final int i2 = 0;
        if (i4 == 1) {
            obj3 = EGL14.EGL_NO_SURFACE;
            if (!EGL14.eglMakeCurrent(eGLDisplay, obj3, obj3, eGLContext3)) {
            } else {
                return obj3;
            }
            EGLSurfaceTexture.GlException obj2 = new EGLSurfaceTexture.GlException("eglMakeCurrent failed", i2);
            throw obj2;
        } else {
            if (i4 == 2) {
                obj5 = new int[]{12375, 1, 12374, 1, 12992, 1, 12344};
            } else {
                obj5 = new int[]{12375, 1, 12374, 1, 12344};
            }
            if (EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig2, obj5, 0) == null) {
            } else {
            }
        }
        obj2 = new EGLSurfaceTexture.GlException("eglCreatePbufferSurface failed", i2);
        throw obj2;
    }

    private void d() {
        final com.google.android.exoplayer2.util.EGLSurfaceTexture.b bVar = this.c;
        if (bVar != null) {
            bVar.a();
        }
    }

    private static void e(int[] iArr) {
        GLES20.glGenTextures(1, iArr, 0);
        r.b();
    }

    private static EGLDisplay f() {
        int i = 0;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(i);
        final int i2 = 0;
        if (eglGetDisplay == null) {
        } else {
            int[] iArr = new int[2];
            if (!EGL14.eglInitialize(eglGetDisplay, iArr, i, iArr, 1)) {
            } else {
                return eglGetDisplay;
            }
            EGLSurfaceTexture.GlException glException = new EGLSurfaceTexture.GlException("eglInitialize failed", i2);
            throw glException;
        }
        EGLSurfaceTexture.GlException glException2 = new EGLSurfaceTexture.GlException("eglGetDisplay failed", i2);
        throw glException2;
    }

    @Override // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public SurfaceTexture g() {
        final SurfaceTexture surfaceTexture = this.y;
        g.e(surfaceTexture);
        return (SurfaceTexture)surfaceTexture;
    }

    @Override // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public void h(int i) {
        EGLDisplay eGLDisplay = EGLSurfaceTexture.f();
        this.v = eGLDisplay;
        EGLConfig eGLConfig = EGLSurfaceTexture.a(eGLDisplay);
        EGLContext context = EGLSurfaceTexture.b(this.v, eGLConfig, i);
        this.w = context;
        this.x = EGLSurfaceTexture.c(this.v, eGLConfig, context, i);
        EGLSurfaceTexture.e(this.b);
        SurfaceTexture obj4 = new SurfaceTexture(this.b[0]);
        this.y = obj4;
        obj4.setOnFrameAvailableListener(this);
    }

    @Override // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public void i() {
        EGLDisplay equals2;
        Throwable th;
        SurfaceTexture surfaceTexture;
        EGLDisplay equals3;
        EGLSurface equals;
        int eGL_NO_DISPLAY2;
        EGLDisplay eGL_NO_DISPLAY;
        EGLDisplay eGL_NO_CONTEXT;
        EGLContext eGL_NO_CONTEXT2;
        this.a.removeCallbacks(this);
        final int i2 = 0;
        surfaceTexture = this.y;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            GLES20.glDeleteTextures(1, this.b, 0);
        }
        equals3 = this.v;
        if (equals3 != null && !equals3.equals(EGL14.EGL_NO_DISPLAY)) {
            if (!equals3.equals(EGL14.EGL_NO_DISPLAY)) {
                eGL_NO_DISPLAY = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(this.v, eGL_NO_DISPLAY, eGL_NO_DISPLAY, EGL14.EGL_NO_CONTEXT);
            }
        }
        equals = this.x;
        if (equals != null && !equals.equals(EGL14.EGL_NO_SURFACE)) {
            if (!equals.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.v, this.x);
            }
        }
        try {
            EGLContext context = this.w;
            if (context != null) {
            }
            EGL14.eglDestroyContext(this.v, context);
            if (p0.a >= 19) {
            }
            EGL14.eglReleaseThread();
            equals2 = this.v;
            if (equals2 != null && !equals2.equals(EGL14.EGL_NO_DISPLAY)) {
            }
            if (!equals2.equals(EGL14.EGL_NO_DISPLAY)) {
            }
            EGL14.eglTerminate(this.v);
            this.v = i2;
            this.w = i2;
            this.x = i2;
            this.y = i2;
            eGL_NO_DISPLAY = this.v;
            eGL_NO_CONTEXT = EGL14.EGL_NO_DISPLAY;
            eGL_NO_DISPLAY = eGL_NO_DISPLAY.equals(eGL_NO_CONTEXT);
            if (eGL_NO_DISPLAY != null && eGL_NO_DISPLAY == null) {
            }
            eGL_NO_CONTEXT = EGL14.EGL_NO_DISPLAY;
            eGL_NO_DISPLAY = eGL_NO_DISPLAY.equals(eGL_NO_CONTEXT);
            if (eGL_NO_DISPLAY == null) {
            }
            eGL_NO_DISPLAY = this.v;
            eGL_NO_CONTEXT = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGL_NO_DISPLAY, eGL_NO_CONTEXT, eGL_NO_CONTEXT, EGL14.EGL_NO_CONTEXT);
            eGL_NO_DISPLAY = this.x;
            eGL_NO_CONTEXT = EGL14.EGL_NO_SURFACE;
            eGL_NO_DISPLAY = eGL_NO_DISPLAY.equals(eGL_NO_CONTEXT);
            if (eGL_NO_DISPLAY != null && eGL_NO_DISPLAY == null) {
            }
            eGL_NO_CONTEXT = EGL14.EGL_NO_SURFACE;
            eGL_NO_DISPLAY = eGL_NO_DISPLAY.equals(eGL_NO_CONTEXT);
            if (eGL_NO_DISPLAY == null) {
            }
            eGL_NO_DISPLAY = this.v;
            eGL_NO_CONTEXT = this.x;
            EGL14.eglDestroySurface(eGL_NO_DISPLAY, eGL_NO_CONTEXT);
        }
        eGL_NO_DISPLAY = this.w;
        if (eGL_NO_DISPLAY != null) {
            eGL_NO_CONTEXT = this.v;
            EGL14.eglDestroyContext(eGL_NO_CONTEXT, eGL_NO_DISPLAY);
        }
        eGL_NO_DISPLAY = p0.a;
        if (eGL_NO_DISPLAY >= eGLDisplay) {
            EGL14.eglReleaseThread();
        }
        EGLDisplay eGLDisplay = this.v;
        if (eGLDisplay == null) {
        } else {
            eGL_NO_DISPLAY = EGL14.EGL_NO_DISPLAY;
            eGLDisplay = eGLDisplay.equals(eGL_NO_DISPLAY);
            if (eGLDisplay != null) {
            } else {
                eGLDisplay = this.v;
                EGL14.eglTerminate(eGLDisplay);
            }
        }
        this.v = obj1;
        this.w = obj1;
        this.x = obj1;
        this.y = obj1;
        throw th;
    }

    @Override // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.a.post(this);
    }

    @Override // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public void run() {
        d();
        final SurfaceTexture surfaceTexture = this.y;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }
}
