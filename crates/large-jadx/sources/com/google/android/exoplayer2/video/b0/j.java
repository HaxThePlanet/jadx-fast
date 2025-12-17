package com.google.android.exoplayer2.video.b0;

import android.opengl.GLES20;
import com.google.android.exoplayer2.util.r;
import java.nio.FloatBuffer;

/* loaded from: classes2.dex */
final class j {

    private static final String[] j;
    private static final String[] k;
    private static final float[] l;
    private static final float[] m;
    private static final float[] n;
    private static final float[] o;
    private static final float[] p;
    private int a;
    private com.google.android.exoplayer2.video.b0.j.a b;
    private com.google.android.exoplayer2.video.b0.j.a c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    private static class a {

        private final int a;
        private final FloatBuffer b;
        private final FloatBuffer c;
        private final int d;
        public a(com.google.android.exoplayer2.video.b0.h.b h$b) {
            int i;
            int obj2;
            super();
            this.a = b.a();
            this.b = r.f(b.c);
            this.c = r.f(b.d);
            obj2 = b.b;
            if (obj2 != 1) {
                if (obj2 != 2) {
                    this.d = 4;
                } else {
                    this.d = 6;
                }
            } else {
                this.d = 5;
            }
        }

        static FloatBuffer a(com.google.android.exoplayer2.video.b0.j.a j$a) {
            return a.b;
        }

        static FloatBuffer b(com.google.android.exoplayer2.video.b0.j.a j$a) {
            return a.c;
        }

        static int c(com.google.android.exoplayer2.video.b0.j.a j$a) {
            return a.d;
        }

        static int d(com.google.android.exoplayer2.video.b0.j.a j$a) {
            return a.a;
        }
    }
    static {
        j.j = /* result */;
        j.k = /* result */;
        int i = 9;
        float[] fArr2 = new float[i];
        fArr2 = new int[]{1065353216, 0, 0, 0, -1082130432, 0, 0, 1065353216, 1065353216};
        j.l = fArr2;
        float[] fArr3 = new float[i];
        fArr3 = new int[]{1065353216, 0, 0, 0, -1090519040, 0, 0, 1056964608, 1065353216};
        j.m = fArr3;
        float[] fArr4 = new float[i];
        fArr4 = new int[]{1065353216, 0, 0, 0, -1090519040, 0, 0, 1065353216, 1065353216};
        j.n = fArr4;
        float[] fArr5 = new float[i];
        fArr5 = new int[]{1056964608, 0, 0, 0, -1082130432, 0, 0, 1065353216, 1065353216};
        j.o = fArr5;
        float[] fArr = new float[i];
        fArr = new int[]{1056964608, 0, 0, 0, -1082130432, 0, 1056964608, 1065353216, 1065353216};
        j.p = fArr;
    }

    public static boolean c(com.google.android.exoplayer2.video.b0.h h) {
        com.google.android.exoplayer2.video.b0.h.a aVar;
        int i;
        com.google.android.exoplayer2.video.b0.h.a obj4;
        aVar = h.a;
        obj4 = h.b;
        i = 0;
        final int i3 = 1;
        if (aVar.b() == i3 && bVar.a == 0 && obj4.b() == i3 && obj4.a == 0) {
            if (bVar.a == 0) {
                if (obj4.b() == i3) {
                    if (obj4.a == 0) {
                        i = i3;
                    }
                }
            }
        }
        return i;
    }

    void a(int i, float[] f2Arr2, boolean z3) {
        com.google.android.exoplayer2.video.b0.j.a aVar;
        float[] fArr;
        int i2;
        final Object obj = this;
        aVar = z3 ? obj.c : obj.b;
        if (aVar == null) {
        }
        GLES20.glUseProgram(obj.d);
        r.b();
        GLES20.glEnableVertexAttribArray(obj.g);
        GLES20.glEnableVertexAttribArray(obj.h);
        r.b();
        int i9 = obj.a;
        int i15 = 1;
        if (i9 == i15) {
            fArr = z3 ? j.n : j.m;
        } else {
            if (i9 == 2) {
                fArr = z3 ? j.p : j.o;
            } else {
                fArr = j.l;
            }
        }
        final int i18 = 0;
        GLES20.glUniformMatrix3fv(obj.f, i15, i18, fArr, i18);
        GLES20.glUniformMatrix4fv(obj.e, i15, i18, f2Arr2, i18);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i);
        GLES20.glUniform1i(obj.i, i18);
        r.b();
        GLES20.glVertexAttribPointer(obj.g, 3, 5126, false, 12, j.a.a(aVar));
        r.b();
        GLES20.glVertexAttribPointer(obj.h, 2, 5126, false, 8, j.a.b(aVar));
        r.b();
        GLES20.glDrawArrays(j.a.c(aVar), i18, j.a.d(aVar));
        r.b();
        GLES20.glDisableVertexAttribArray(obj.g);
        GLES20.glDisableVertexAttribArray(obj.h);
    }

    void b() {
        int i = r.d(j.j, j.k);
        this.d = i;
        this.e = GLES20.glGetUniformLocation(i, "uMvpMatrix");
        this.f = GLES20.glGetUniformLocation(this.d, "uTexMatrix");
        this.g = GLES20.glGetAttribLocation(this.d, "aPosition");
        this.h = GLES20.glGetAttribLocation(this.d, "aTexCoords");
        this.i = GLES20.glGetUniformLocation(this.d, "uTexture");
    }

    public void d(com.google.android.exoplayer2.video.b0.h h) {
        com.google.android.exoplayer2.video.b0.j.a aVar;
        Object obj4;
        if (!j.c(h)) {
        }
        this.a = h.c;
        final int i2 = 0;
        aVar = new j.a(h.a.a(i2));
        this.b = aVar;
        if (h.d) {
        } else {
            aVar = new j.a(h.b.a(i2));
        }
        this.c = aVar;
    }
}
