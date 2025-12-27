package f.c.a.e.c0;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.Shader.TileMode;
import d.h.f.a;

/* compiled from: ShadowRenderer.java */
/* loaded from: classes2.dex */
public class a {

    private static final int[] i;
    private static final float[] j;
    private static final int[] k;
    private static final float[] l;
    private final Paint a;
    private final Paint b;
    private final Paint c;
    private int d;
    private int e;
    private int f;
    private final Path g;
    private Paint h;
    static {
        a.i = new int[3];
        a.j = new float[] { 0, 1056964608, 1065353216 };
        a.k = new int[4];
        a.l = new float[] { 0, 0, 1056964608, 1065353216 };
    }

    public a() {
        this(-16777216);
    }

    public void a(Canvas canvas, Matrix matrix, RectF rectF, int i, float f, float f2) {
        final Object canvas2 = this;
        final Object matrix23 = canvas;
        RectF rectF32 = rectF;
        int i42 = i;
        float f62 = f2;
        float f7 = 0.0f;
        i = 1;
        i = 0;
        int r5 = i;
        int i9 = 3;
        final int i10 = 2;
        if (i != 0) {
            int[] iArr2 = a.k;
            iArr2[i] = i;
            iArr2[i] = canvas2.f;
            iArr2[i10] = canvas2.e;
            iArr2[i9] = canvas2.d;
            f52 = f;
        } else {
            canvas2.g.rewind();
            canvas2.g.moveTo(rectF.centerX(), rectF.centerY());
            canvas2.g.arcTo(rectF32, f, f62);
            canvas2.g.close();
            float f13 = (float)-i42;
            rectF32.inset(f13, f13);
            iArr = a.k;
            iArr[i] = i;
            iArr[i] = canvas2.d;
            iArr[i10] = canvas2.e;
            iArr[i9] = canvas2.f;
        }
        float f12 = 2f;
        final float f14 = rectF.width() / f12;
        if (f14 <= 0.0f) {
            return;
        }
        float f8 = 1f;
        float f4 = f8 - (float)i42 / f14;
        final float[] fArr = a.l;
        fArr[i] = f4;
        fArr[i10] = (f8 - f4) / f12 + f4;
        RadialGradient radialGradient = new RadialGradient(rectF.centerX(), rectF.centerY(), f14, a.k, fArr, Shader.TileMode.CLAMP);
        canvas2.b.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix);
        f = rectF.height() / rectF.width();
        matrix23.scale(f8, f);
        if (i == 0) {
            matrix23.clipPath(canvas2.g, Region.Op.DIFFERENCE);
            matrix23.drawPath(canvas2.g, canvas2.h);
        }
        canvas.drawArc(rectF, f, f2, true, canvas2.b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix, RectF rectF, int i) {
        rectF.bottom += f2;
        rectF.offset(0.0f, (float)-i);
        final int[] iArr = a.i;
        iArr[0] = this.f;
        iArr[1] = this.e;
        iArr[2] = this.d;
        LinearGradient linearGradient = new LinearGradient(left2, rectF.top, left2, rectF.bottom, iArr, a.j, Shader.TileMode.CLAMP);
        this.c.setShader(linearGradient);
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.c);
        canvas.restore();
    }

    public Paint c() {
        return this.a;
    }

    public void d(int i) {
        this.d = a.i(i, 68);
        this.e = a.i(i, 20);
        this.f = a.i(i, 0);
        this.a.setColor(this.d);
    }

    public a(int i) {
        super();
        this.g = new Path();
        this.h = new Paint();
        this.a = new Paint();
        d(i);
        this.h.setColor(0);
        Paint paint5 = new Paint(4);
        this.b = paint5;
        paint5.setStyle(Paint.Style.FILL);
        this.c = new Paint(paint5);
    }
}
