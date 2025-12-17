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
        int i = 3;
        a.i = new int[i];
        float[] fArr = new float[i];
        fArr = new int[]{0, 1056964608, 1065353216};
        a.j = fArr;
        int i2 = 4;
        a.k = new int[i2];
        float[] fArr2 = new float[i2];
        fArr2 = new int[]{0, 0, 1056964608, 1065353216};
        a.l = fArr2;
    }

    public a() {
        super(-16777216);
    }

    public a(int i) {
        super();
        Path path = new Path();
        this.g = path;
        Paint paint = new Paint();
        this.h = paint;
        Paint paint2 = new Paint();
        this.a = paint2;
        d(i);
        this.h.setColor(0);
        Paint obj2 = new Paint(4);
        this.b = obj2;
        obj2.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(obj2);
        this.c = paint3;
    }

    public void a(Canvas canvas, Matrix matrix2, RectF rectF3, int i4, float f5, float f6) {
        int i;
        int i2;
        int i3;
        float f;
        int[] iArr;
        final Object obj = this;
        final Object obj3 = canvas;
        RectF rectF = rectF3;
        int i5 = i4;
        int i10 = f6;
        int i8 = 0;
        int i12 = 1;
        int i13 = 0;
        i2 = Float.compare(i10, i8) < 0 ? i12 : i13;
        final Path path = obj.g;
        int i21 = 3;
        final int i23 = 2;
        if (i2 != 0) {
            int[] iArr2 = a.k;
            iArr2[i13] = i13;
            iArr2[i12] = obj.f;
            iArr2[i23] = obj.e;
            iArr2[i21] = obj.d;
            f = f5;
        } else {
            path.rewind();
            path.moveTo(rectF3.centerX(), rectF3.centerY());
            path.arcTo(rectF, f5, i10);
            path.close();
            float f7 = (float)i24;
            rectF.inset(f7, f7);
            iArr = a.k;
            iArr[i13] = i13;
            iArr[i12] = obj.d;
            iArr[i23] = obj.e;
            iArr[i21] = obj.f;
        }
        int i22 = 1073741824;
        final int i25 = width2 / i22;
        if (Float.compare(i25, i8) <= 0) {
        }
        int i9 = 1065353216;
        int i7 = i9 - i6;
        final float[] fArr = a.l;
        fArr[i12] = i7;
        fArr[i23] = i15 += i7;
        super(rectF3.centerX(), rectF3.centerY(), i25, a.k, fArr, Shader.TileMode.CLAMP);
        obj.b.setShader(radialGradient);
        canvas.save();
        canvas.concat(matrix2);
        obj3.scale(i9, height /= width);
        if (i2 == 0) {
            obj3.clipPath(path, Region.Op.DIFFERENCE);
            obj3.drawPath(path, obj.h);
        }
        canvas.drawArc(rectF3, f5, f6, true, obj.b);
        canvas.restore();
    }

    public void b(Canvas canvas, Matrix matrix2, RectF rectF3, int i4) {
        rectF3.bottom = bottom += f;
        rectF3.offset(0, (float)obj13);
        final int[] iArr = a.i;
        iArr[0] = this.f;
        iArr[1] = this.e;
        iArr[2] = this.d;
        final float left = rectF3.left;
        super(left, rectF3.top, left, rectF3.bottom, iArr, a.j, Shader.TileMode.CLAMP);
        this.c.setShader(linearGradient);
        canvas.save();
        canvas.concat(matrix2);
        canvas.drawRect(rectF3, this.c);
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
}
