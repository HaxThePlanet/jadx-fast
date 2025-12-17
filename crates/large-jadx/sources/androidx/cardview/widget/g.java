package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import d.d.b;
import d.d.c;

/* loaded from: classes.dex */
class g extends Drawable {

    private static final double q;
    static androidx.cardview.widget.g.a r;
    private final int a;
    private Paint b;
    private Paint c;
    private Paint d;
    private final RectF e;
    private float f = 0.5f;
    private Path g;
    private float h;
    private float i;
    private float j;
    private ColorStateList k;
    private boolean l = true;
    private final int m;
    private final int n;
    private boolean o = true;
    private boolean p = false;

    interface a {
        public abstract void a(Canvas canvas, RectF rectF2, float f3, Paint paint4);
    }
    static {
        g.q = Math.cos(Math.toRadians(4631530004285489152L));
    }

    g(Resources resources, ColorStateList colorStateList2, float f3, float f4, float f5) {
        super();
        int i = 1;
        this.m = resources.getColor(b.d);
        this.n = resources.getColor(b.c);
        this.a = resources.getDimensionPixelSize(c.a);
        int i6 = 5;
        Paint obj3 = new Paint(i6);
        this.b = obj3;
        n(colorStateList2);
        obj3 = new Paint(i6);
        this.c = obj3;
        obj3.setStyle(Paint.Style.FILL);
        obj3 = (float)obj3;
        obj3 = new RectF();
        this.e = obj3;
        obj3 = new Paint(this.c);
        this.d = obj3;
        obj3.setAntiAlias(false);
        s(f4, f5);
    }

    private void a(Rect rect) {
        final float f = this.h;
        i *= f;
        this.e.set(f2 += f, f3 += i2, f4 -= f, obj7 -= i2);
        b();
    }

    private void b() {
        Path path;
        final Object obj2 = this;
        float f2 = obj2.f;
        RectF rectF = new RectF(-f2, -f2, f2, f2);
        RectF rectF2 = new RectF(rectF);
        float f4 = obj2.i;
        rectF2.inset(-f4, -f4);
        path = obj2.g;
        if (path == null) {
            path = new Path();
            obj2.g = path;
        } else {
            path.reset();
        }
        obj2.g.setFillType(Path.FillType.EVEN_ODD);
        int i15 = 0;
        obj2.g.moveTo(-f6, i15);
        obj2.g.rLineTo(-f7, i15);
        final int i22 = 0;
        obj2.g.arcTo(rectF2, 1127481344, 1119092736, i22);
        obj2.g.arcTo(rectF, 1132920832, -1028390912, i22);
        obj2.g.close();
        float f = obj2.f;
        int i14 = 3;
        final int[] iArr2 = new int[i14];
        int i20 = obj2.m;
        iArr2[i22] = i20;
        final int i27 = 1;
        iArr2[i27] = i20;
        final int i28 = 2;
        iArr2[i28] = obj2.n;
        final float[] fArr2 = new float[i14];
        fArr2[i22] = i15;
        fArr2[i27] = f /= i3;
        fArr2[i28] = 1065353216;
        super(0, 0, f8 + f9, iArr2, fArr2, Shader.TileMode.CLAMP);
        obj2.c.setShader(radialGradient);
        float f5 = obj2.f;
        float f10 = obj2.i;
        int[] iArr = new int[i14];
        int i17 = obj2.m;
        iArr[i22] = i17;
        iArr[i27] = i17;
        iArr[i28] = obj2.n;
        float[] fArr = new float[i14];
        fArr = new int[]{0, 1056964608, 1065353216};
        super(0, i16 + f10, 0, i7 - f10, iArr, fArr, Shader.TileMode.CLAMP);
        obj2.d.setShader(linearGradient);
        obj2.d.setAntiAlias(i22);
    }

    static float c(float f, float f2, boolean z3) {
        int i;
        int i2;
        double d;
        float obj6;
        if (z3) {
            obj6 = (float)i;
        }
        return obj6;
    }

    static float d(float f, float f2, boolean z3) {
        int i = 1069547520;
        if (z3) {
            return (float)i2;
        }
        return f *= i;
    }

    private void e(Canvas canvas) {
        Path path4;
        int i3;
        Path path3;
        Path path2;
        Path path;
        Paint paint3;
        Paint paint5;
        Paint paint2;
        Paint paint4;
        int i2;
        int i4;
        int i;
        int i6;
        Paint paint;
        int i5;
        float f = this.f;
        i10 -= f2;
        int i15 = 1073741824;
        i7 += i13;
        final int i27 = i8 * i15;
        int i16 = 0;
        int i23 = 1;
        i4 = 0;
        i3 = Float.compare(i14, i16) > 0 ? i23 : i4;
        i5 = Float.compare(i, i16) > 0 ? i23 : i4;
        RectF rectF4 = this.e;
        canvas.translate(left += i8, top += i8);
        canvas.drawPath(this.g, this.c);
        if (i3 != 0) {
            canvas.drawRect(0, i11, width3 - i27, -f6, this.d);
        }
        canvas.restoreToCount(canvas.save());
        RectF rectF6 = this.e;
        canvas.translate(right -= i8, bottom -= i8);
        canvas.rotate(1127481344);
        canvas.drawPath(this.g, this.c);
        if (i3 != 0) {
            canvas.drawRect(0, i11, width2 - i27, i3 + f7, this.d);
        }
        canvas.restoreToCount(canvas.save());
        RectF rectF7 = this.e;
        canvas.translate(left2 += i8, bottom2 -= i8);
        canvas.rotate(1132920832);
        canvas.drawPath(this.g, this.c);
        if (i5 != 0) {
            canvas.drawRect(0, i11, height2 - i27, -f8, this.d);
        }
        canvas.restoreToCount(canvas.save());
        RectF rectF9 = this.e;
        canvas.translate(right2 -= i8, top2 += i8);
        canvas.rotate(1119092736);
        canvas.drawPath(this.g, this.c);
        if (i5 != 0) {
            canvas.drawRect(0, i11, height - i27, -path4, this.d);
        }
        canvas.restoreToCount(canvas.save());
    }

    private void n(ColorStateList colorStateList) {
        ColorStateList obj4;
        if (colorStateList == null) {
            obj4 = ColorStateList.valueOf(0);
        }
        this.k = obj4;
        this.b.setColor(obj4.getColorForState(getState(), this.k.getDefaultColor()));
    }

    private void s(float f, float f2) {
        int cmp;
        float obj4;
        int i = 0;
        final String str3 = ". Must be >= 0";
        if (Float.compare(f, i) < 0) {
        } else {
            if (Float.compare(f2, i) < 0) {
            } else {
                float obj5 = (float)obj5;
                int i2 = 1;
                if (Float.compare(obj4, obj5) > 0 && !this.p) {
                    if (!this.p) {
                        this.p = i2;
                    }
                    obj4 = obj5;
                }
                if (Float.compare(f3, obj4) == 0 && Float.compare(f4, obj5) == 0) {
                    if (Float.compare(f4, obj5) == 0) {
                    }
                }
                this.j = obj4;
                this.h = obj5;
                this.i = (float)obj4;
                this.l = i2;
                invalidateSelf();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Invalid max shadow size ");
            stringBuilder2.append(f2);
            stringBuilder2.append(str3);
            obj4 = new IllegalArgumentException(stringBuilder2.toString());
            throw obj4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid shadow size ");
        stringBuilder.append(f);
        stringBuilder.append(str3);
        obj5 = new IllegalArgumentException(stringBuilder.toString());
        throw obj5;
    }

    private int t(float f) {
        int obj3;
        obj3 = (int)obj3;
        final int i3 = 1;
        if (obj3 % 2 == i3) {
            obj3 -= i3;
        }
        return obj3;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        if (this.l) {
            a(getBounds());
            this.l = false;
        }
        int i4 = 1073741824;
        int i5 = 0;
        canvas.translate(i5, f /= i4);
        e(canvas);
        canvas.translate(i5, i2 /= i4);
        g.r.a(canvas, this.e, this.f, this.b);
    }

    @Override // android.graphics.drawable.Drawable
    ColorStateList f() {
        return this.k;
    }

    @Override // android.graphics.drawable.Drawable
    float g() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        float f3 = this.f;
        int i = (int)ceil;
        float f6 = this.f;
        int i2 = (int)ceil2;
        rect.set(i2, i, i2, i);
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    void h(Rect rect) {
        getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    float i() {
        return this.h;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        boolean stateful;
        int i;
        stateful = this.k;
        if (stateful != null) {
            if (!stateful.isStateful()) {
                i = super.isStateful() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    float j() {
        float f = this.h;
        int i9 = 1069547520;
        final int i13 = 1073741824;
        return i += i7;
    }

    @Override // android.graphics.drawable.Drawable
    float k() {
        float f = this.h;
        int i8 = 1073741824;
        return i += i6;
    }

    @Override // android.graphics.drawable.Drawable
    float l() {
        return this.j;
    }

    @Override // android.graphics.drawable.Drawable
    void m(boolean z) {
        this.o = z;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    void o(ColorStateList colorStateList) {
        n(colorStateList);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.l = true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        ColorStateList list = this.k;
        int obj3 = list.getColorForState(iArr, list.getDefaultColor());
        if (this.b.getColor() == obj3) {
            return 0;
        }
        this.b.setColor(obj3);
        obj3 = 1;
        this.l = obj3;
        invalidateSelf();
        return obj3;
    }

    @Override // android.graphics.drawable.Drawable
    void p(float f) {
        if (Float.compare(f, i) < 0) {
        } else {
            float obj4 = (float)obj4;
            if (Float.compare(f2, obj4) == 0) {
            }
            this.f = obj4;
            this.l = true;
            invalidateSelf();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid radius ");
        stringBuilder.append(f);
        stringBuilder.append(". Must be >= 0");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // android.graphics.drawable.Drawable
    void q(float f) {
        s(this.j, f);
    }

    @Override // android.graphics.drawable.Drawable
    void r(float f) {
        s(f, this.h);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.b.setAlpha(i);
        this.c.setAlpha(i);
        this.d.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
    }
}
