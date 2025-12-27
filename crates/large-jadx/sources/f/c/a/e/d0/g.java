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
import d.h.k.c;
import java.util.BitSet;

/* compiled from: MaterialShapeDrawable.java */
/* loaded from: classes2.dex */
public class g extends Drawable implements androidx.core.graphics.drawable.b, n {

    private static final String P;
    private static final Paint Q = new Paint(1);
    private final RectF A;
    private final RectF B;
    private final Region C;
    private final Region D;
    private k E;
    private final Paint F;
    private final Paint G;
    private final f.c.a.e.c0.a H;
    private final l.b I;
    private final l J;
    private PorterDuffColorFilter K;
    private PorterDuffColorFilter L;
    private int M;
    private final RectF N;
    private boolean O;
    private g.c a;
    private final m.g[] b;
    private final m.g[] c;
    private final BitSet v;
    private boolean w;
    private final Matrix x;
    private final Path y;
    private final Path z;

    static final class c extends Drawable.ConstantState {

        public k a;
        public f.c.a.e.u.a b;
        public ColorFilter c;
        public ColorStateList d = null;
        public ColorStateList e = null;
        public ColorStateList f = null;
        public ColorStateList g = null;
        public PorterDuff.Mode h;
        public Rect i;
        public float j = 1f;
        public float k = 1f;
        public float l;
        public int m = 255;
        public float n = 0f;
        public float o = 0f;
        public float p = 0f;
        public int q = 0;
        public int r = 0;
        public int s = 0;
        public int t = 0;
        public boolean u = false;
        public Paint.Style v;
        public c(k kVar, f.c.a.e.u.a aVar) {
            super();
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = kVar;
            this.b = aVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            final f.c.a.e.d0.g gVar = new g(this, null);
            gVar.w = 1;
            return gVar;
        }

        public c(g.c cVar) {
            super();
            this.h = PorterDuff.Mode.SRC_IN;
            this.i = null;
            this.v = Paint.Style.FILL_AND_STROKE;
            this.a = cVar.a;
            this.b = cVar.b;
            this.l = cVar.l;
            this.c = cVar.c;
            this.d = cVar.d;
            this.e = cVar.e;
            this.h = cVar.h;
            this.g = cVar.g;
            this.m = cVar.m;
            this.j = cVar.j;
            this.s = cVar.s;
            this.q = cVar.q;
            this.u = cVar.u;
            this.k = cVar.k;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
            this.r = cVar.r;
            this.t = cVar.t;
            this.f = cVar.f;
            this.v = cVar.v;
            if (cVar.i != null) {
                this.i = new Rect(cVar.i);
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }

    class a implements l.b {

        final /* synthetic */ g a;
        a() {
            this.a = gVar;
            super();
        }

        public void a(m mVar, Matrix matrix, int i) {
            this.a.v.set(i, mVar.e());
            this.a.b[i] = mVar.f(matrix);
        }

        public void b(m mVar, Matrix matrix, int i) {
            this.a.v.set(i + 4, mVar.e());
            this.a.c[i] = mVar.f(matrix);
        }
    }

    class b implements k.c {

        final /* synthetic */ float a;
        b(float f) {
            this.a = f;
            super();
        }

        public c a(c cVar) {
            f.c.a.e.d0.b bVar;
            z = cVar instanceof i;
            if (!(cVar instanceof i)) {
            }
            return bVar;
        }
    }
    static {
        String simpleName = g.class.getSimpleName();
        g.P = simpleName;
        simpleName.setColor(-1);
        simpleName.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* synthetic */ g(g.c cVar, g.a aVar) {
        this(cVar);
    }

    private float F() {
        if (N()) {
            return this.G.getStrokeWidth() / 2f;
        }
        return 0;
    }

    private boolean L() {
        f.c.a.e.d0.g.c cVar;
        boolean z2 = true;
        if (cVar.q == 1 || !(cVar.r <= 0 && cVar.q == 2)) {
            int i5 = 0;
        }
        return z2;
    }

    private boolean M() {
        boolean z = false;
        Paint.Style fILL_AND_STROKE2;
        if (this.a.v == Paint.Style.FILL_AND_STROKE || this.a.v == Paint.Style.FILL) {
            int i2 = 1;
        }
        return z;
    }

    private boolean N() {
        boolean z = false;
        Paint.Style fILL_AND_STROKE2 = null;
        if (this.a.v == Paint.Style.FILL_AND_STROKE || this.a.v == Paint.Style.STROKE) {
            float strokeWidth = this.G.getStrokeWidth();
            float f = 0.0f;
            int r0 = strokeWidth > 0.0f ? 1 : 0;
        }
        return (strokeWidth > 0.0f ? 1 : 0);
    }

    private void P() {
        super.invalidateSelf();
    }

    private void S(Canvas canvas) {
        if (!L()) {
            return;
        }
        canvas.save();
        U(canvas);
        if (!this.O) {
            n(canvas);
            canvas.restore();
            return;
        }
        int i = (int)(this.N.width() - (float)getBounds().width());
        int i2 = (int)(this.N.height() - (float)getBounds().height());
        if (this.O < 0) {
            throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
        } else {
            if (this.N >= 0) {
                Bitmap bitmap = Bitmap.createBitmap((int)this.N.width() + (this.a.r * 2) + i, (int)this.N.height() + (this.a.r * 2) + i2, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmap);
                float f2 = (float)(getBounds().left - this.a.r) - i;
                float f5 = (float)(getBounds().top - this.a.r) - i2;
                canvas2.translate(-f2, -f5);
                n(canvas2);
                canvas.drawBitmap(bitmap, f2, f5, null);
                bitmap.recycle();
                canvas.restore();
                return;
            }
        }
    }

    private void U(Canvas canvas) {
        int i3 = B();
        int i4 = C();
        int i = 21;
        if (Build.VERSION.SDK_INT < 21 && this.O) {
            Rect clipBounds = canvas.getClipBounds();
            i2 = -i5;
            clipBounds.inset(i2, -i5);
            clipBounds.offset(i3, i4);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate((float)i3, (float)i4);
    }

    static /* synthetic */ BitSet b(g gVar) {
        return gVar.v;
    }

    static /* synthetic */ m.g[] c(g gVar) {
        return gVar.b;
    }

    static /* synthetic */ m.g[] d(g gVar) {
        return gVar.c;
    }

    static /* synthetic */ boolean e(g gVar, boolean z) {
        gVar.w = z;
        return z;
    }

    private PorterDuffColorFilter f(Paint paint, boolean z) {
        if (z) {
            int color = paint.getColor();
            int i = l(color);
            this.M = i;
            if (i != color) {
                return new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN);
            }
        }
        return null;
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        float f = 1f;
        if (this.a.j != f) {
            this.x.reset();
            float f3 = 2f;
            f2 = rectF.width() / f3;
            this.x.setScale(this.a.j, this.a.j, f2, rectF.height() / f3);
            path.transform(this.x);
        }
        path.computeBounds(this.N, true);
    }

    private void i() {
        f.c.a.e.d0.k kVar = E().y(new g.b(this, -F()));
        this.E = kVar;
        this.J.d(kVar, this.a.k, v(), this.z);
    }

    private PorterDuffColorFilter j(ColorStateList list, PorterDuff.Mode mode, boolean z) {
        int colorForState;
        if (z) {
            colorForState = l(list.getColorForState(getState(), 0));
        }
        this.M = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter k(ColorStateList list, PorterDuff.Mode mode, Paint paint, boolean z) {
        PorterDuffColorFilter porterDuffColorFilter;
        if (list == null || mode == null) {
            porterDuffColorFilter = f(paint, z);
        }
        return porterDuffColorFilter;
    }

    private boolean k0(int[] iArr) {
        int i = 0;
        boolean z = true;
        int colorForState;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        int colorForState2;
        if (this.a.d != null) {
            int color = this.F.getColor();
            colorForState = this.a.d.getColorForState(iArr, color);
            if (color != colorForState) {
                this.F.setColor(colorForState);
            } else {
                i = 0;
            }
        }
        if (this.a.e != null) {
            int color2 = this.G.getColor();
            colorForState2 = this.a.e.getColorForState(iArr, color2);
            if (color2 != colorForState2) {
                this.G.setColor(colorForState2);
            } else {
            }
        }
        return z;
    }

    private boolean l0() {
        boolean z3 = true;
        z3 = true;
        this.K = k(cVar2.g, cVar2.h, this.F, z3);
        z3 = false;
        this.L = k(cVar3.f, cVar3.h, this.G, z3);
        if (cVar.u) {
            this.H.d(cVar.g.getColorForState(getState(), z3));
        }
        if (c.a(this.K, this.K)) {
            if (c.a(this.L, this.L)) {
            }
        }
        return z3;
    }

    public static g m(Context context, float f) {
        f.c.a.e.d0.g gVar = new g();
        gVar.O(context);
        gVar.Z(ColorStateList.valueOf(a.c(context, b.q, g.class.getSimpleName())));
        gVar.Y(f);
        return gVar;
    }

    private void m0() {
        float f = K();
        this.a.r = (int)(Math.ceil((double)(0.75f * f)));
        this.a.s = (int)(Math.ceil((double)(f * 0.25f)));
        l0();
        P();
    }

    private void n(Canvas canvas) {
        int i2 = 0;
        String str;
        f.c.a.e.c0.a aVar;
        int i4;
        if (this.v.cardinality() > 0) {
            str = "Compatibility shadow requested but can't be drawn for all operations in this shape.";
            Log.w(g.P, str);
        }
        if (this.a.s != 0) {
            canvas.drawPath(this.y, this.H.c());
        }
        i2 = 0;
        int i3 = 4;
        while (g.P < 4) {
            this.b[i2].b(this.H, this.a.r, canvas);
            this.c[i2].b(this.H, this.a.r, canvas);
            i2 = i2 + 1;
            i3 = 4;
        }
        if (this.O) {
            int i5 = B();
            int i6 = C();
            canvas.translate((float)-i5, (float)-i6);
            canvas.drawPath(this.y, g.Q);
            canvas.translate((float)i5, (float)i6);
        }
    }

    private void o(Canvas canvas) {
        this.q(canvas, this.F, this.y, this.a.a, u());
    }

    private void q(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (kVar.u(rectF)) {
            f = kVar.t().a(rectF) * this.a.k;
            canvas.drawRoundRect(rectF, f, f, paint);
        } else {
            canvas.drawPath(path, paint);
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
        return (int)(double)cVar.s * Math.sin(Math.toRadians((double)cVar.t));
    }

    @Override // android.graphics.drawable.Drawable
    public int C() {
        return (int)(double)cVar.s * Math.cos(Math.toRadians((double)cVar.t));
    }

    @Override // android.graphics.drawable.Drawable
    public int D() {
        return this.a.r;
    }

    @Override // android.graphics.drawable.Drawable
    public k E() {
        return this.a.a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorStateList G() {
        return this.a.g;
    }

    @Override // android.graphics.drawable.Drawable
    public float H() {
        return this.a.a.r().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public float I() {
        return this.a.a.t().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public float J() {
        return this.a.p;
    }

    @Override // android.graphics.drawable.Drawable
    public float K() {
        return w() + J();
    }

    @Override // android.graphics.drawable.Drawable
    public void O(Context context) {
        this.a.b = new a(context);
        m0();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean Q() {
        boolean z2 = false;
        int r0 = this.a.b != null && this.a.b.d() ? 1 : 0;
        return (this.a.b != null && this.a.b.d() ? 1 : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean R() {
        return this.a.a.u(u());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean V() {
        boolean z = true;
        int i = 21;
        boolean convex;
        int sDK_INT2 = Build.VERSION.SDK_INT;
        i = 21;
        if (Build.VERSION.SDK_INT < 21 || !this.R()) {
            int i2 = 1;
        } else {
            if (this.y.isConvex() || Build.VERSION.SDK_INT >= 29) {
                int i3 = 0;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void W(float f) {
        setShapeAppearanceModel(this.a.a.w(f));
    }

    @Override // android.graphics.drawable.Drawable
    public void X(c cVar) {
        setShapeAppearanceModel(this.a.a.x(cVar));
    }

    @Override // android.graphics.drawable.Drawable
    public void Y(float f) {
        if (cVar.o != f) {
            this.a.o = f;
            m0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void Z(ColorStateList list) {
        if (cVar.d != list) {
            this.a.d = list;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void a0(float f) {
        if (cVar.k != f) {
            this.a.k = f;
            boolean z = true;
            this.w = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void b0(int i, int i2, int i3, int i4) {
        if (cVar.i == null) {
            this.a.i = new Rect();
        }
        this.a.i.set(i, i2, i3, i4);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void c0(float f) {
        if (cVar.n != f) {
            this.a.n = f;
            m0();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void d0(boolean z) {
        this.O = z;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.F.setColorFilter(this.K);
        int alpha = this.F.getAlpha();
        this.F.setAlpha(g.T(alpha, this.a.m));
        this.G.setColorFilter(this.L);
        this.G.setStrokeWidth(this.a.l);
        int alpha2 = this.G.getAlpha();
        this.G.setAlpha(g.T(alpha2, this.a.m));
        if (this.w) {
            i();
            g(u(), this.y);
            boolean z = false;
            this.w = z;
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
        this.a.u = false;
        P();
    }

    @Override // android.graphics.drawable.Drawable
    public void f0(int i) {
        if (cVar.t != i) {
            this.a.t = i;
            P();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void g0(float f, int i) {
        j0(f);
        i0(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Path path2;
        if (this.a.q == 2) {
            return;
        }
        if (R()) {
            outline.setRoundRect(getBounds(), H() * this.a.k);
            return;
        }
        g(u(), this.y);
        if (!this.y.isConvex()) {
            if (Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.y);
                } catch (java.lang.IllegalArgumentException unused) {
                    return;
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (this.a.i != null) {
            rect.set(this.a.i);
            return true;
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
    protected final void h(RectF rectF, Path path) {
        this.J.e(kVar, f, rectF, this.I, path);
    }

    @Override // android.graphics.drawable.Drawable
    public void h0(float f, ColorStateList list) {
        j0(f);
        i0(list);
    }

    @Override // android.graphics.drawable.Drawable
    public void i0(ColorStateList list) {
        if (cVar.e != list) {
            this.a.e = list;
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
        boolean z = true;
        if (!super.isStateful()) {
            if (this.a.g == null || !this.a.g.isStateful()) {
                if (this.a.f == null || !this.a.f.isStateful()) {
                    if (this.a.e == null || !this.a.e.isStateful()) {
                        if (this.a.d == null || !this.a.d.isStateful()) {
                            int i2 = 0;
                        } else {
                            int i = 1;
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void j0(float f) {
        this.a.l = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected int l(int i) {
        int i2;
        if (this.a.b != null) {
            i2 = this.a.b.c(i, K() + z());
        }
        return i2;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.a = new g.c(this.a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.w = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z3 = false;
        if (k0(iArr) || l0()) {
            int i2 = 1;
        }
        if (z3) {
            invalidateSelf();
        }
        return z3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void p(Canvas canvas, Paint paint, Path path, RectF rectF) {
        this.q(canvas, paint, path, this.a.a, rectF);
    }

    @Override // android.graphics.drawable.Drawable
    protected void r(Canvas canvas) {
        this.q(canvas, this.G, this.z, this.E, v());
    }

    @Override // android.graphics.drawable.Drawable
    public float s() {
        return this.a.a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (cVar.m != i) {
            this.a.m = i;
            P();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.c = colorFilter;
        P();
    }

    @Override // android.graphics.drawable.Drawable
    public void setShapeAppearanceModel(k kVar) {
        this.a.a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList list) {
        this.a.g = list;
        l0();
        P();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (cVar.h != mode) {
            this.a.h = mode;
            l0();
            P();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public float t() {
        return this.a.a.l().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    protected RectF u() {
        this.A.set(getBounds());
        return this.A;
    }

    @Override // android.graphics.drawable.Drawable
    public float w() {
        return this.a.o;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorStateList x() {
        return this.a.d;
    }

    @Override // android.graphics.drawable.Drawable
    public float y() {
        return this.a.k;
    }

    @Override // android.graphics.drawable.Drawable
    public float z() {
        return this.a.n;
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet set, int i, int i2) {
        this(k.e(context, set, i, i2).m());
    }

    public g(k kVar) {
        this(new g.c(kVar, null));
    }

    private g(g.c cVar) {
        f.c.a.e.d0.l lVar;
        super();
        int i = 4;
        this.b = new m.g[i];
        this.c = new m.g[i];
        this.v = new BitSet(8);
        this.x = new Matrix();
        this.y = new Path();
        this.z = new Path();
        this.A = new RectF();
        this.B = new RectF();
        this.C = new Region();
        this.D = new Region();
        int i3 = 1;
        Paint paint = new Paint(i3);
        this.F = paint;
        final Paint paint2 = new Paint(i3);
        this.G = paint2;
        this.H = new a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lVar = l.k();
        } else {
            lVar = new l();
        }
        this.J = lVar;
        this.N = new RectF();
        this.O = true;
        this.a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        l0();
        k0(getState());
        this.I = new g.a(this);
    }

    private static int T(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }
}
