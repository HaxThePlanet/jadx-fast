package f.c.a.e.d0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.b;
import d.h.k.c;
import f.c.a.e.b;
import f.c.a.e.c0.a;
import f.c.a.e.r.a;
import f.c.a.e.u.a;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class g extends Drawable implements b, f.c.a.e.d0.n {

    private static final String P;
    private static final Paint Q;
    private final RectF A;
    private final RectF B;
    private final Region C;
    private final Region D;
    private f.c.a.e.d0.k E;
    private final Paint F;
    private final Paint G;
    private final a H;
    private final f.c.a.e.d0.l.b I;
    private final f.c.a.e.d0.l J;
    private PorterDuffColorFilter K;
    private PorterDuffColorFilter L;
    private int M;
    private final RectF N;
    private boolean O;
    private f.c.a.e.d0.g.c a;
    private final f.c.a.e.d0.m.g[] b;
    private final f.c.a.e.d0.m.g[] c;
    private final BitSet v;
    private boolean w;
    private final Matrix x;
    private final Path y;
    private final Path z;

    static final class c extends Drawable.ConstantState {

        public f.c.a.e.d0.k a;
        public a b;
        public ColorFilter c;
        public ColorStateList d;
        public ColorStateList e;
        public ColorStateList f;
        public ColorStateList g;
        public PorterDuff.Mode h;
        public Rect i = null;
        public float j;
        public float k;
        public float l;
        public int m;
        public float n;
        public float o;
        public float p;
        public int q;
        public int r;
        public int s;
        public int t;
        public boolean u;
        public Paint.Style v;
        public c(f.c.a.e.d0.g.c g$c) {
            Rect rect;
            Object obj3;
            super();
            int i = 0;
            this.d = i;
            this.e = i;
            this.f = i;
            this.g = i;
            this.h = PorterDuff.Mode.SRC_IN;
            int i2 = 1065353216;
            this.j = i2;
            this.k = i2;
            this.m = 255;
            int i4 = 0;
            this.n = i4;
            this.o = i4;
            this.p = i4;
            int i5 = 0;
            this.q = i5;
            this.r = i5;
            this.s = i5;
            this.t = i5;
            this.u = i5;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = c.a;
            this.b = c.b;
            this.l = c.l;
            this.c = c.c;
            this.d = c.d;
            this.e = c.e;
            this.h = c.h;
            this.g = c.g;
            this.m = c.m;
            this.j = c.j;
            this.s = c.s;
            this.q = c.q;
            this.u = c.u;
            this.k = c.k;
            this.n = c.n;
            this.o = c.o;
            this.p = c.p;
            this.r = c.r;
            this.t = c.t;
            this.f = c.f;
            this.v = c.v;
            if (c.i != null) {
                rect = new Rect(c.i);
                this.i = rect;
            }
        }

        public c(f.c.a.e.d0.k k, a a2) {
            super();
            int i = 0;
            this.d = i;
            this.e = i;
            this.f = i;
            this.g = i;
            this.h = PorterDuff.Mode.SRC_IN;
            int i2 = 1065353216;
            this.j = i2;
            this.k = i2;
            this.m = 255;
            int i4 = 0;
            this.n = i4;
            this.o = i4;
            this.p = i4;
            int i5 = 0;
            this.q = i5;
            this.r = i5;
            this.s = i5;
            this.t = i5;
            this.u = i5;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = k;
            this.b = a2;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, 0);
            g.e(gVar, true);
            return gVar;
        }
    }

    class a implements f.c.a.e.d0.l.b {

        final f.c.a.e.d0.g a;
        a(f.c.a.e.d0.g g) {
            this.a = g;
            super();
        }

        @Override // f.c.a.e.d0.l$b
        public void a(f.c.a.e.d0.m m, Matrix matrix2, int i3) {
            g.b(this.a).set(i3, m.e());
            g.c(this.a)[i3] = m.f(matrix2);
        }

        @Override // f.c.a.e.d0.l$b
        public void b(f.c.a.e.d0.m m, Matrix matrix2, int i3) {
            g.b(this.a).set(i3 + 4, m.e());
            g.d(this.a)[i3] = m.f(matrix2);
        }
    }

    class b implements f.c.a.e.d0.k.c {

        final float a;
        b(f.c.a.e.d0.g g, float f2) {
            this.a = f2;
            super();
        }

        @Override // f.c.a.e.d0.k$c
        public f.c.a.e.d0.c a(f.c.a.e.d0.c c) {
            boolean bVar;
            float f;
            Object obj3;
            if (c instanceof i) {
            } else {
                bVar = new b(this.a, c);
                obj3 = bVar;
            }
            return obj3;
        }
    }
    static {
        g.P = g.class.getSimpleName();
        Paint paint = new Paint(1);
        g.Q = paint;
        paint.setColor(-1);
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        paint.setXfermode(porterDuffXfermode);
    }

    public g() {
        k kVar = new k();
        super(kVar);
    }

    public g(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(k.e(context, attributeSet2, i3, i4).m());
    }

    private g(f.c.a.e.d0.g.c g$c) {
        f.c.a.e.d0.l lVar;
        super();
        int i = 4;
        this.b = new m.g[i];
        this.c = new m.g[i];
        BitSet bitSet = new BitSet(8);
        this.v = bitSet;
        Matrix matrix = new Matrix();
        this.x = matrix;
        Path path = new Path();
        this.y = path;
        Path path2 = new Path();
        this.z = path2;
        RectF rectF = new RectF();
        this.A = rectF;
        RectF rectF2 = new RectF();
        this.B = rectF2;
        Region region = new Region();
        this.C = region;
        Region region2 = new Region();
        this.D = region2;
        int i3 = 1;
        Paint paint = new Paint(i3);
        this.F = paint;
        Paint paint2 = new Paint(i3);
        this.G = paint2;
        a aVar = new a();
        this.H = aVar;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lVar = l.k();
        } else {
            lVar = new l();
        }
        this.J = lVar;
        RectF rectF3 = new RectF();
        this.N = rectF3;
        this.O = i3;
        this.a = c;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        l0();
        k0(getState());
        g.a obj6 = new g.a(this);
        this.I = obj6;
    }

    g(f.c.a.e.d0.g.c g$c, f.c.a.e.d0.g.a g$a2) {
        super(c);
    }

    public g(f.c.a.e.d0.k k) {
        g.c cVar = new g.c(k, 0);
        super(cVar);
    }

    private float F() {
        if (N()) {
            return strokeWidth /= i3;
        }
        return 0;
    }

    private boolean L() {
        f.c.a.e.d0.g.c cVar;
        int i;
        cVar = this.a;
        final int i2 = cVar.q;
        if (i2 != 1 && cVar.r > 0) {
            if (cVar.r > 0) {
                if (i2 != 2) {
                    if (V()) {
                    } else {
                        i = 0;
                    }
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private boolean M() {
        int i;
        Paint.Style fILL_AND_STROKE;
        Paint.Style style = cVar.v;
        if (style != Paint.Style.FILL_AND_STROKE) {
            if (style == Paint.Style.FILL) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private boolean N() {
        int i;
        Paint.Style cmp;
        Paint.Style fILL_AND_STROKE;
        cmp = cVar.v;
        if (cmp != Paint.Style.FILL_AND_STROKE) {
            if (cmp == Paint.Style.STROKE && Float.compare(strokeWidth, fILL_AND_STROKE) > 0) {
                i = Float.compare(strokeWidth, fILL_AND_STROKE) > 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private void P() {
        super.invalidateSelf();
    }

    private void S(Canvas canvas) {
        if (!L()) {
        }
        canvas.save();
        U(canvas);
        if (!this.O) {
            n(canvas);
            canvas.restore();
        }
        int i2 = (int)i;
        int i4 = (int)i3;
        if (i2 < 0) {
        } else {
            if (i4 < 0) {
            } else {
                Bitmap bitmap = Bitmap.createBitmap(i6 += i2, i11 += i4, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmap);
                float f = (float)i17;
                float f3 = (float)i19;
                canvas2.translate(-f, -f3);
                n(canvas2);
                canvas.drawBitmap(bitmap, f, f3, 0);
                bitmap.recycle();
                canvas.restore();
            }
        }
        IllegalStateException obj7 = new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
        throw obj7;
    }

    private static int T(int i, int i2) {
        return obj1 >>>= 8;
    }

    private void U(Canvas canvas) {
        int clipBounds;
        int rEPLACE;
        int i;
        int i2 = B();
        int i3 = C();
        if (Build.VERSION.SDK_INT < 21 && this.O) {
            if (this.O) {
                clipBounds = canvas.getClipBounds();
                int i4 = cVar.r;
                clipBounds.inset(-i4, -i4);
                clipBounds.offset(i2, i3);
                canvas.clipRect(clipBounds, Region.Op.REPLACE);
            }
        }
        canvas.translate((float)i2, (float)i3);
    }

    static BitSet b(f.c.a.e.d0.g g) {
        return g.v;
    }

    static f.c.a.e.d0.m.g[] c(f.c.a.e.d0.g g) {
        return g.b;
    }

    static f.c.a.e.d0.m.g[] d(f.c.a.e.d0.g g) {
        return g.c;
    }

    static boolean e(f.c.a.e.d0.g g, boolean z2) {
        g.w = z2;
        return z2;
    }

    private PorterDuffColorFilter f(Paint paint, boolean z2) {
        int obj2;
        int obj3;
        obj2 = paint.getColor();
        obj3 = l(obj2);
        this.M = obj3;
        if (z2 != 0 && obj3 != obj2) {
            obj2 = paint.getColor();
            obj3 = l(obj2);
            this.M = obj3;
            if (obj3 != obj2) {
                obj2 = new PorterDuffColorFilter(obj3, PorterDuff.Mode.SRC_IN);
                return obj2;
            }
        }
        return null;
    }

    private void g(RectF rectF, Path path2) {
        int cmp;
        int i3;
        int i2;
        int i;
        Object obj5;
        h(rectF, path2);
        if (Float.compare(f, i3) != 0) {
            this.x.reset();
            i3 = cVar2.j;
            i = 1073741824;
            this.x.setScale(i3, i3, width /= i, obj5 /= i);
            path2.transform(this.x);
        }
        path2.computeBounds(this.N, true);
    }

    private void i() {
        g.b bVar = new g.b(this, -f);
        f.c.a.e.d0.k kVar = E().y(bVar);
        this.E = kVar;
        this.J.d(kVar, cVar.k, v(), this.z);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode porterDuff$Mode2, boolean z3) {
        int obj3;
        if (z3) {
            obj3 = l(colorStateList.getColorForState(getState(), 0));
        }
        this.M = obj3;
        PorterDuffColorFilter obj5 = new PorterDuffColorFilter(obj3, mode2);
        return obj5;
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode porterDuff$Mode2, Paint paint3, boolean z4) {
        PorterDuffColorFilter obj1;
        if (colorStateList != null) {
            if (mode2 == null) {
                obj1 = f(paint3, z4);
            } else {
                obj1 = j(colorStateList, mode2, z4);
            }
        } else {
        }
        return obj1;
    }

    private boolean k0(int[] iArr) {
        ColorStateList color2;
        int i;
        int i2;
        int colorForState;
        ColorStateList color;
        ColorStateList list;
        int[] obj5;
        color2 = this.F.getColor();
        colorForState = cVar2.d.getColorForState(iArr, color2);
        if (cVar.d != null && color2 != colorForState) {
            color2 = this.F.getColor();
            colorForState = cVar2.d.getColorForState(iArr, color2);
            if (color2 != colorForState) {
                this.F.setColor(colorForState);
                i = i2;
            } else {
                i = 0;
            }
        } else {
        }
        color = this.G.getColor();
        obj5 = cVar4.e.getColorForState(iArr, color);
        if (cVar3.e != null && color != obj5) {
            color = this.G.getColor();
            obj5 = cVar4.e.getColorForState(iArr, color);
            if (color != obj5) {
                this.G.setColor(obj5);
            } else {
                i2 = i;
            }
        } else {
        }
        return i2;
    }

    private boolean l0() {
        boolean z;
        f.c.a.e.d0.g.c colorForState;
        boolean z2;
        Paint state;
        int i;
        f.c.a.e.d0.g.c cVar = this.a;
        this.K = k(cVar.g, cVar.h, this.F, true);
        f.c.a.e.d0.g.c cVar2 = this.a;
        final int i2 = 0;
        this.L = k(cVar2.f, cVar2.h, this.G, i2);
        colorForState = this.a;
        if (colorForState.u) {
            this.H.d(colorForState.g.getColorForState(getState(), i2));
        }
        if (c.a(this.K, this.K)) {
            if (!c.a(this.L, this.L)) {
            } else {
                i = i2;
            }
        }
        return i;
    }

    public static f.c.a.e.d0.g m(Context context, float f2) {
        g gVar = new g();
        gVar.O(context);
        gVar.Z(ColorStateList.valueOf(a.c(context, b.q, g.class.getSimpleName())));
        gVar.Y(f2);
        return gVar;
    }

    private void m0() {
        float f = K();
        cVar.r = (int)ceil;
        cVar2.s = (int)ceil2;
        l0();
        P();
    }

    private void n(Canvas canvas) {
        int cardinality;
        int i2;
        int i4;
        boolean z;
        String str;
        int i;
        a aVar;
        int i3;
        if (this.v.cardinality() > 0) {
            Log.w(g.P, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (cVar.s != 0) {
            canvas.drawPath(this.y, this.H.c());
        }
        i4 = 0;
        while (i4 < 4) {
            this.b[i4].b(this.H, cVar2.r, canvas);
            this.c[i4].b(this.H, cVar3.r, canvas);
            i4++;
        }
        if (this.O) {
            int i5 = B();
            int i6 = C();
            canvas.translate((float)i7, (float)i8);
            canvas.drawPath(this.y, g.Q);
            canvas.translate((float)i5, (float)i6);
        }
    }

    private void o(Canvas canvas) {
        this.q(canvas, this.F, this.y, cVar.a, u());
    }

    private void q(Canvas canvas, Paint paint2, Path path3, f.c.a.e.d0.k k4, RectF rectF5) {
        int obj4;
        float obj5;
        if (k4.u(rectF5)) {
            obj4 *= obj5;
            canvas.drawRoundRect(rectF5, obj4, obj4, paint2);
        } else {
            canvas.drawPath(path3, paint2);
        }
    }

    private RectF v() {
        this.B.set(u());
        float f = F();
        this.B.inset(f, f);
        return this.B;
    }

    @Override // android.graphics.drawable.Drawable
    public int A() {
        return this.M;
    }

    @Override // android.graphics.drawable.Drawable
    public int B() {
        f.c.a.e.d0.g.c cVar = this.a;
        return (int)i4;
    }

    @Override // android.graphics.drawable.Drawable
    public int C() {
        f.c.a.e.d0.g.c cVar = this.a;
        return (int)i4;
    }

    @Override // android.graphics.drawable.Drawable
    public int D() {
        return cVar.r;
    }

    @Override // android.graphics.drawable.Drawable
    public f.c.a.e.d0.k E() {
        return cVar.a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorStateList G() {
        return cVar.g;
    }

    @Override // android.graphics.drawable.Drawable
    public float H() {
        return cVar.a.r().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public float I() {
        return cVar.a.t().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public float J() {
        return cVar.p;
    }

    @Override // android.graphics.drawable.Drawable
    public float K() {
        return f += f2;
    }

    @Override // android.graphics.drawable.Drawable
    public void O(Context context) {
        a aVar = new a(context);
        cVar.b = aVar;
        m0();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean Q() {
        a aVar;
        int i;
        aVar = cVar.b;
        if (aVar != null && aVar.d()) {
            i = aVar.d() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean R() {
        return cVar.a.u(u());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean V() {
        int i;
        int convex;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 21) {
            if (!R() && !this.y.isConvex() && sDK_INT < 29) {
                if (!this.y.isConvex()) {
                    if (sDK_INT < 29) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void W(float f) {
        setShapeAppearanceModel(cVar.a.w(f));
    }

    @Override // android.graphics.drawable.Drawable
    public void X(f.c.a.e.d0.c c) {
        setShapeAppearanceModel(cVar.a.x(c));
    }

    @Override // android.graphics.drawable.Drawable
    public void Y(float f) {
        final f.c.a.e.d0.g.c cVar = this.a;
        if (Float.compare(f2, f) != 0) {
            cVar.o = f;
            m0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void Z(ColorStateList colorStateList) {
        ColorStateList obj3;
        final f.c.a.e.d0.g.c cVar = this.a;
        if (cVar.d != colorStateList) {
            cVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void a0(float f) {
        float obj3;
        final f.c.a.e.d0.g.c cVar = this.a;
        if (Float.compare(f2, f) != 0) {
            cVar.k = f;
            this.w = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void b0(int i, int i2, int i3, int i4) {
        Rect rect;
        f.c.a.e.d0.g.c cVar = this.a;
        if (cVar.i == null) {
            rect = new Rect();
            cVar.i = rect;
        }
        cVar2.i.set(i, i2, i3, i4);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void c0(float f) {
        final f.c.a.e.d0.g.c cVar = this.a;
        if (Float.compare(f2, f) != 0) {
            cVar.n = f;
            m0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void d0(boolean z) {
        this.O = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        int i;
        this.F.setColorFilter(this.K);
        int alpha = this.F.getAlpha();
        this.F.setAlpha(g.T(alpha, cVar.m));
        this.G.setColorFilter(this.L);
        this.G.setStrokeWidth(cVar2.l);
        int alpha2 = this.G.getAlpha();
        this.G.setAlpha(g.T(alpha2, cVar3.m));
        if (this.w) {
            i();
            g(u(), this.y);
            this.w = false;
        }
        S(canvas);
        if (M()) {
            o(canvas);
        }
        if (N()) {
            r(canvas);
        }
        this.F.setAlpha(alpha);
        this.G.setAlpha(alpha2);
    }

    @Override // android.graphics.drawable.Drawable
    public void e0(int i) {
        this.H.d(i);
        obj2.u = false;
        P();
    }

    @Override // android.graphics.drawable.Drawable
    public void f0(int i) {
        final f.c.a.e.d0.g.c cVar = this.a;
        if (cVar.t != i) {
            cVar.t = i;
            P();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void g0(float f, int i2) {
        j0(f);
        i0(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Path sDK_INT;
        Path path;
        if (cVar.q == 2) {
        }
        if (R()) {
            outline.setRoundRect(getBounds(), f *= f2);
        }
        g(u(), this.y);
        if (!this.y.isConvex()) {
            if (Build.VERSION.SDK_INT >= 29) {
                outline.setConvexPath(this.y);
            }
        } else {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = cVar.i;
        if (rect2 != null) {
            rect.set(rect2);
            return 1;
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.C.set(getBounds());
        g(u(), this.y);
        this.D.setPath(this.y, this.C);
        this.C.op(this.D, Region.Op.DIFFERENCE);
        return this.C;
    }

    @Override // android.graphics.drawable.Drawable
    protected final void h(RectF rectF, Path path2) {
        f.c.a.e.d0.g.c cVar = this.a;
        this.J.e(cVar.a, cVar.k, rectF, this.I, path2);
    }

    @Override // android.graphics.drawable.Drawable
    public void h0(float f, ColorStateList colorStateList2) {
        j0(f);
        i0(colorStateList2);
    }

    @Override // android.graphics.drawable.Drawable
    public void i0(ColorStateList colorStateList) {
        ColorStateList obj3;
        final f.c.a.e.d0.g.c cVar = this.a;
        if (cVar.e != colorStateList) {
            cVar.e = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.w = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        boolean stateful;
        int i;
        if (!super.isStateful()) {
            stateful = cVar.g;
            if (stateful != null) {
                if (!stateful.isStateful()) {
                    stateful = cVar2.f;
                    if (stateful != null) {
                        if (!stateful.isStateful()) {
                            stateful = cVar3.e;
                            if (stateful != null) {
                                if (!stateful.isStateful()) {
                                    stateful = cVar4.d;
                                    if (stateful != null && stateful.isStateful()) {
                                        if (stateful.isStateful()) {
                                            i = 1;
                                        } else {
                                            i = 0;
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void j0(float f) {
        cVar.l = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected int l(int i) {
        int obj3;
        a aVar = cVar.b;
        if (aVar != null) {
            obj3 = aVar.c(i, f += f2);
        }
        return obj3;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        g.c cVar = new g.c(this.a);
        this.a = cVar;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.w = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int obj2;
        if (!k0(iArr)) {
            if (l0()) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        if (obj2 != null) {
            invalidateSelf();
        }
        return obj2;
    }

    @Override // android.graphics.drawable.Drawable
    protected void p(Canvas canvas, Paint paint2, Path path3, RectF rectF4) {
        this.q(canvas, paint2, path3, cVar.a, rectF4);
    }

    @Override // android.graphics.drawable.Drawable
    protected void r(Canvas canvas) {
        this.q(canvas, this.G, this.z, this.E, v());
    }

    @Override // android.graphics.drawable.Drawable
    public float s() {
        return cVar.a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        final f.c.a.e.d0.g.c cVar = this.a;
        if (cVar.m != i) {
            cVar.m = i;
            P();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        cVar.c = colorFilter;
        P();
    }

    @Override // android.graphics.drawable.Drawable
    public void setShapeAppearanceModel(f.c.a.e.d0.k k) {
        cVar.a = k;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        cVar.g = colorStateList;
        l0();
        P();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode porterDuff$Mode) {
        final f.c.a.e.d0.g.c cVar = this.a;
        if (cVar.h != mode) {
            cVar.h = mode;
            l0();
            P();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public float t() {
        return cVar.a.l().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    protected RectF u() {
        this.A.set(getBounds());
        return this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public float w() {
        return cVar.o;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorStateList x() {
        return cVar.d;
    }

    @Override // android.graphics.drawable.Drawable
    public float y() {
        return cVar.k;
    }

    @Override // android.graphics.drawable.Drawable
    public float z() {
        return cVar.n;
    }
}
