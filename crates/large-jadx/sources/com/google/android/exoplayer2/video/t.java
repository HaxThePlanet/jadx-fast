package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.util.AttributeSet;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.r;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: classes2.dex */
public final class t extends GLSurfaceView implements com.google.android.exoplayer2.video.v {

    private final com.google.android.exoplayer2.video.t.a a;

    private static final class a implements GLSurfaceView.Renderer {

        private static final float[] C;
        private static final float[] D;
        private static final float[] E;
        private static final String[] F;
        private static final FloatBuffer G;
        private int A;
        private com.google.android.exoplayer2.video.u B;
        private final GLSurfaceView a;
        private final int[] b;
        private final int[] c;
        private final int[] v;
        private final int[] w;
        private final AtomicReference<com.google.android.exoplayer2.video.u> x;
        private final FloatBuffer[] y;
        private int z;
        static {
            int i2 = 9;
            float[] fArr3 = new float[i2];
            fArr3 = new int[]{1066728948, 1066728948, 1066728948, 0, -1094142919, 1073813127, 1070352826, -1085267771, 0};
            t.a.C = fArr3;
            float[] fArr4 = new float[i2];
            fArr4 = new int[]{1066728948, 1066728948, 1066728948, 0, -1101390676, 1074211586, 1072005382, -1089965392, 0};
            t.a.D = fArr4;
            float[] fArr = new float[i2];
            fArr = new int[]{1066762502, 1066762502, 1066762502, 0, -1103068398, 1074362581, 1071082635, -1087968903, 0};
            t.a.E = fArr;
            t.a.F = /* result */;
            float[] fArr2 = new float[8];
            fArr2 = new int[]{-1082130432, 1065353216, -1082130432, -1082130432, 1065353216, 1065353216, 1065353216, -1082130432};
            t.a.G = r.f(fArr2);
        }

        public a(GLSurfaceView gLSurfaceView) {
            int i;
            int[] iArr;
            int[] iArr2;
            int i2;
            super();
            this.a = gLSurfaceView;
            final int obj5 = 3;
            this.b = new int[obj5];
            this.c = new int[obj5];
            this.v = new int[obj5];
            this.w = new int[obj5];
            AtomicReference atomicReference = new AtomicReference();
            this.x = atomicReference;
            this.y = new FloatBuffer[obj5];
            i = 0;
            while (i < obj5) {
                i2 = -1;
                this.w[i] = i2;
                this.v[i] = i2;
                i++;
            }
        }

        private void b() {
            int[] iArr;
            int i2;
            int i3;
            int i;
            final int i11 = 3;
            GLES20.glGenTextures(i11, this.b, 0);
            while (i2 < i11) {
                GLES20.glUniform1i(GLES20.glGetUniformLocation(this.z, t.a.F[i2]), i2);
                GLES20.glActiveTexture(i5 += i2);
                i3 = 3553;
                GLES20.glBindTexture(i3, this.b[i2]);
                int i12 = 1175979008;
                GLES20.glTexParameterf(i3, 10241, i12);
                GLES20.glTexParameterf(i3, 10240, i12);
                i = 1191259904;
                GLES20.glTexParameterf(i3, 10242, i);
                GLES20.glTexParameterf(i3, 10243, i);
                i2++;
            }
            r.b();
        }

        @Override // android.opengl.GLSurfaceView$Renderer
        public void a(com.google.android.exoplayer2.video.u u) {
            Object obj2 = this.x.getAndSet(u);
            if ((u)obj2 != null) {
                (u)obj2.s();
            }
            this.a.requestRender();
        }

        @Override // android.opengl.GLSurfaceView$Renderer
        public void onDrawFrame(GL10 gL10) {
            int i13;
            int i4;
            float[] fArr;
            int i2;
            int i6;
            int i;
            int i7;
            int i12;
            int i11;
            int i9;
            int i14;
            int i3;
            int i5;
            int i10;
            int i8;
            java.nio.ByteBuffer byteBuffer;
            final Object obj = this;
            Object andSet = obj.x.getAndSet(0);
            if ((u)andSet == null && obj.B == null) {
                if (obj.B == null) {
                }
            }
            i4 = obj.B;
            if ((u)andSet != null && i4 != null) {
                i4 = obj.B;
                if (i4 != null) {
                    i4.s();
                }
                obj.B = (u)andSet;
            }
            com.google.android.exoplayer2.video.u uVar = obj.B;
            g.e(uVar);
            fArr = t.a.D;
            int i20 = uVar.z;
            final int i22 = 3;
            final int i23 = 1;
            if (i20 != i23) {
                if (i20 != i22) {
                } else {
                    fArr = t.a.E;
                }
            } else {
                fArr = t.a.C;
            }
            final int i24 = 0;
            GLES20.glUniformMatrix3fv(obj.A, i23, i24, fArr, i24);
            int[] iArr = uVar.y;
            g.e(iArr);
            java.nio.ByteBuffer[] objArr = uVar.x;
            g.e(objArr);
            i2 = i24;
            int i27 = 2;
            while (i2 < i22) {
                if (i2 == 0) {
                } else {
                }
                i = i7 / 2;
                GLES20.glActiveTexture(i28 += i2);
                GLES20.glBindTexture(3553, obj.b[i2]);
                GLES20.glPixelStorei(3317, i23);
                GLES20.glTexImage2D(3553, 0, 6409, (int[])iArr[i2], i, 0, 6409, 5121, (ByteBuffer[])objArr[i2]);
                i2++;
                i27 = 2;
                i = uVar.w;
            }
            int[] iArr2 = new int[i22];
            iArr2[i24] = uVar.v;
            i17 /= i27;
            iArr2[i27] = i18;
            iArr2[i23] = i18;
            i13 = i24;
            i2 = 4;
            i7 = 5;
            while (i13 < i22) {
                if (obj.v[i13] == iArr2[i13]) {
                } else {
                }
                if (iArr[i13] != 0) {
                } else {
                }
                i11 = i24;
                g.f(i11);
                f /= f2;
                float[] fArr2 = new float[8];
                int i40 = 0;
                fArr2[i24] = i40;
                fArr2[i23] = i40;
                fArr2[i27] = i40;
                int i41 = 1065353216;
                fArr2[i22] = i41;
                fArr2[i2] = i37;
                fArr2[i7] = i40;
                fArr2[6] = i37;
                fArr2[7] = i41;
                obj.y[i13] = r.f(fArr2);
                GLES20.glVertexAttribPointer(obj.c[i13], 2, 5126, false, 0, obj.y[i13]);
                obj.v[i13] = iArr2[i13];
                obj.w[i13] = iArr[i13];
                i13++;
                i2 = 4;
                i7 = 5;
                i11 = i23;
                if (obj.w[i13] != iArr[i13]) {
                }
            }
            GLES20.glClear(16384);
            GLES20.glDrawArrays(i7, i24, i2);
            r.b();
        }

        @Override // android.opengl.GLSurfaceView$Renderer
        public void onSurfaceChanged(GL10 gL10, int i2, int i3) {
            final int obj1 = 0;
            GLES20.glViewport(obj1, obj1, i2, i3);
        }

        @Override // android.opengl.GLSurfaceView$Renderer
        public void onSurfaceCreated(GL10 gL10, EGLConfig eGLConfig2) {
            int obj7 = r.c("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.z = obj7;
            GLES20.glUseProgram(obj7);
            int glGetAttribLocation = GLES20.glGetAttribLocation(this.z, "in_pos");
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 0, t.a.G);
            int i = 0;
            this.c[i] = GLES20.glGetAttribLocation(this.z, "in_tc_y");
            GLES20.glEnableVertexAttribArray(this.c[i]);
            int i2 = 1;
            this.c[i2] = GLES20.glGetAttribLocation(this.z, "in_tc_u");
            GLES20.glEnableVertexAttribArray(this.c[i2]);
            int i3 = 2;
            this.c[i3] = GLES20.glGetAttribLocation(this.z, "in_tc_v");
            GLES20.glEnableVertexAttribArray(this.c[i3]);
            r.b();
            this.A = GLES20.glGetUniformLocation(this.z, "mColorConversion");
            r.b();
            b();
            r.b();
        }
    }
    public t(Context context) {
        super(context, 0);
    }

    public t(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        t.a obj1 = new t.a(this);
        this.a = obj1;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(obj1);
        setRenderMode(0);
    }

    @Deprecated
    public com.google.android.exoplayer2.video.v getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    @Override // android.opengl.GLSurfaceView
    public void setOutputBuffer(com.google.android.exoplayer2.video.u u) {
        this.a.a(u);
    }
}
