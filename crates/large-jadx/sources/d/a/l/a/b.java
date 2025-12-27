package d.a.l.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import androidx.core.graphics.drawable.a;

/* compiled from: DrawableContainer.java */
/* loaded from: classes.dex */
class b extends Drawable implements Drawable.Callback {

    private Runnable A;
    private long B;
    private long C;
    private b.b D;
    private b.c a;
    private Rect b;
    private Drawable c;
    private Drawable v;
    private int w = 255;
    private boolean x;
    private int y = -1;
    private boolean z;

    class a implements Runnable {

        final /* synthetic */ b a;
        a() {
            this.a = bVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(true);
            this.a.invalidateSelf();
        }
    }

    static class b implements Drawable.Callback {

        private Drawable.Callback a;
        b() {
            super();
        }

        public Drawable.Callback a() {
            this.a = null;
            return this.a;
        }

        public b.b b(Drawable.Callback callback) {
            this.a = callback;
            return this;
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (this.a != null) {
                this.a.scheduleDrawable(drawable, runnable, j);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (this.a != null) {
                this.a.unscheduleDrawable(drawable, runnable);
            }
        }

        public void invalidateDrawable(Drawable drawable) {
        }
    }

    static abstract class c extends Drawable.ConstantState {

        int A = 0;
        int B = 0;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;
        final b a;
        Resources b = null;
        int c = 160;
        int d;
        int e;
        SparseArray<Drawable.ConstantState> f = new SparseArray<>();
        Drawable[] g;
        int h;
        boolean i = false;
        boolean j = true;
        Rect k = new Rect();
        boolean l = false;
        boolean m = true;
        int n;
        int o;
        int p;
        int q;
        boolean r = true;
        int s;
        boolean t = true;
        boolean u;
        boolean v = true;
        boolean w = true;
        boolean x = true;
        boolean y;
        int z;
        c(b.c cVar, b bVar, Resources resources) {
            int i = 0;
            int i2 = 1;
            int i5;
            int i4;
            super();
            i = 0;
            i2 = 1;
            this.a = bVar;
            bVar = cVar != null ? cVar.b : 0;
        }

        private void e() {
            int i = 0;
            int keyAt;
            Drawable drawable;
            Drawable[] objArr;
            Resources resources;
            if (this.f != null) {
                i = 0;
                while (i < this.f.size()) {
                    this.g[this.f.keyAt(i)] = s((Drawable.ConstantState)this.f.valueAt(i).newDrawable(this.b));
                    i = i + 1;
                }
                SparseArray sparseArray = null;
                this.f = sparseArray;
            }
        }

        private Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.z);
            }
            final Drawable mutate = drawable.mutate();
            mutate.setCallback(this.a);
            return mutate;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final int a(Drawable drawable) {
            length = this.g.length;
            if (this.h >= this.g.length) {
                length = i + 10;
                o(this.h, length);
            }
            drawable.mutate();
            boolean z = false;
            boolean z2 = true;
            drawable.setVisible(z, z2);
            drawable.setCallback(this.a);
            this.g[this.h] = drawable;
            this.h += z2;
            this.e = drawable.getChangingConfigurations() | this.e;
            p();
            this.k = null;
            this.j = z;
            this.m = z;
            this.v = z;
            return this.h;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        final void b(Resources.Theme theme) {
            int i2 = 0;
            Drawable drawable;
            int changingConfigurations;
            if (theme != null) {
                e();
                i2 = 0;
                while (i2 < this.h) {
                    i2 = i2 + 1;
                }
                y(theme.getResources());
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public synchronized boolean c() {
            int i;
            e();
            boolean z3 = true;
            this.v = z3;
            final boolean z4 = false;
            i = z4;
            this.w = z4;
            this.w = z3;
            return true;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean canApplyTheme() {
            int i;
            boolean applyTheme;
            i = 0;
            while (i < this.h) {
                Drawable drawable = this.g[i];
                boolean z = true;
                Object obj = this.f.get(i);
                if (obj != null && obj.canApplyTheme()) {
                }
                if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        protected void d() {
            int i = 0;
            this.m = true;
            e();
            int i6 = -1;
            this.o = i6;
            this.n = i6;
            i = 0;
            this.q = i;
            this.p = i;
            while (i < this.h) {
                Drawable drawable = this.g[i];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                int minimumWidth = drawable.getMinimumWidth();
                int minimumHeight = drawable.getMinimumHeight();
                i = i + 1;
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        final int f() {
            return this.g.length;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final Drawable g(int i) {
            Drawable drawable = this.g[i];
            if (this.g != null) {
                return drawable;
            }
            final SparseArray sparseArray2 = null;
            if (this.f != null && indexOfKey >= 0) {
                Drawable drawable3 = s((Drawable.ConstantState)this.f.valueAt(indexOfKey).newDrawable(this.b));
                this.g[i] = drawable3;
                this.f.removeAt(indexOfKey);
                if (this.f.size() == 0) {
                    this.f = sparseArray2;
                }
                return drawable3;
            }
            return sparseArray2;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return this.d | this.e;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final int h() {
            return this.h;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final int i() {
            if (!this.m) {
                d();
            }
            return this.o;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final int j() {
            if (!this.m) {
                d();
            }
            return this.q;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final int k() {
            if (!this.m) {
                d();
            }
            return this.p;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final Rect l() {
            int i = 0;
            int i2;
            boolean padding;
            int bottom2;
            i = 0;
            if (this.i) {
                return null;
            }
            return this.k;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final int m() {
            if (!this.m) {
                d();
            }
            return this.n;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final int n() {
            int resolveOpacity = -2;
            int i;
            if (this.r) {
                return this.s;
            }
            e();
            if (this.h > 0) {
                resolveOpacity = objArr[0].getOpacity();
            } else {
                resolveOpacity = -2;
            }
            final boolean z2 = true;
            i = z2;
            while (i < this.h) {
                resolveOpacity = Drawable.resolveOpacity(resolveOpacity, objArr[i].getOpacity());
                i = i + 1;
            }
            this.s = resolveOpacity;
            this.r = z2;
            return resolveOpacity;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public void o(int i, int i2) {
            final Drawable[] arr = new Drawable[i2];
            final int i3 = 0;
            System.arraycopy(this.g, i3, arr, i3, i);
            this.g = arr;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        void p() {
            final boolean z = false;
            this.r = z;
            this.t = z;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final boolean q() {
            return this.l;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final void t(boolean z) {
            this.l = z;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final void u(int i) {
            this.A = i;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final void v(int i) {
            this.B = i;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        final boolean w(int i, int i2) {
            int i3;
            boolean z;
            Drawable drawable;
            int i4;
            i3 = 0;
            while (i3 < this.h) {
                i3 = i3 + 1;
            }
            this.z = i;
            return z;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final void x(boolean z) {
            this.i = z;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        final void y(Resources resources) {
            if (resources != null) {
                this.b = resources;
                int i2 = b.f(resources, this.c);
                this.c = i2;
                if (this.c != i2) {
                    boolean z = false;
                    this.m = z;
                    this.j = z;
                }
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        abstract void r();
    }
    b() {
        super();
    }

    private void d(Drawable drawable) {
        if (this.D == null) {
            this.D = new b.b();
        }
        this.D.b(drawable.getCallback());
        drawable.setCallback(this.D);
        try {
            if (this.a.A <= 0 && this.x) {
                drawable.setAlpha(this.w);
            }
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    a.o(drawable, cVar.F);
                }
                if (cVar4.I) {
                    a.p(drawable, cVar4.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.a.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            sDK_INT2 = Build.VERSION.SDK_INT;
            int layoutDirection = 23;
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            drawable.setAutoMirrored(this.a.C);
            int top2 = 21;
            if (this.b != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            d.a.l.a.b.b bVar4 = this.D.a();
            drawable.setCallback(this.D);
            throw th;
        }
        drawable.setCallback(this.D.a());
    }

    private boolean e() {
        boolean autoMirrored;
        boolean z = false;
        if (!isAutoMirrored() || a.f(this) != 1) {
            int i3 = 0;
        }
        return z;
    }

    static int f(Resources resources, int i) {
        int densityDpi2;
        if (resources != null) {
        }
        if (densityDpi2 == 0) {
            densityDpi2 = 160;
        }
        return densityDpi2;
    }

    @Override // android.graphics.drawable.Drawable
    void a(boolean z) {
        int i = 1;
        long l2;
        int i2;
        int cmp;
        int cmp2;
        boolean z2 = true;
        this.x = z2;
        long uptimeMillis = SystemClock.uptimeMillis();
        long l = 255L;
        final boolean z3 = false;
        final long l4 = 0L;
        if (this.c == null) {
            this.B = l4;
        } else {
            if (this.B != l4) {
                if (this.B <= uptimeMillis) {
                    this.c.setAlpha(this.w);
                    this.B = l4;
                    i = z3;
                } else {
                    this.c.setAlpha((int)(l2 - uptimeMillis) * 255L / this.a.A - 255 * this.w / 255);
                }
            }
        }
        if (this.v == null) {
            this.C = l4;
        } else {
            if (this.C != l4) {
                if (this.C <= uptimeMillis) {
                    this.v.setVisible(z3, z3);
                    this.v = null;
                    this.C = l4;
                } else {
                    i = (int)(l7 - uptimeMillis) * 255L / this.a.B * this.w / 255;
                    this.v.setAlpha(i);
                }
            }
        }
        if (z && i != 0) {
            uptimeMillis = uptimeMillis + 16L;
            scheduleSelf(this.A, uptimeMillis);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.a.b(theme);
    }

    @Override // android.graphics.drawable.Drawable
    int c() {
        return this.y;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.c != null) {
            this.c.draw(canvas);
        }
        if (this.v != null) {
            this.v.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    boolean g(int i) {
        long l;
        int i2;
        boolean z = false;
        long uptimeMillis;
        long l3;
        d.a.l.a.b.a aVar;
        z = false;
        if (i == this.y) {
            return false;
        }
        uptimeMillis = SystemClock.uptimeMillis();
        final Drawable drawable5 = null;
        final long l6 = 0L;
        if (this.a.B > 0) {
            if (this.v != null) {
                this.v.setVisible(z, z);
            }
            if (this.c != null) {
                this.v = this.c;
                l = (long)this.a.B + uptimeMillis;
                this.C = l;
            } else {
                this.v = drawable5;
                this.C = l6;
            }
        } else {
            if (this.c != null) {
                this.c.setVisible(z, z);
            }
        }
        if (i >= 0) {
            if (i >= cVar3.h) {
                this.c = drawable5;
                int i3 = -1;
                this.y = i3;
            } else {
                Drawable drawable = this.a.g(i);
                this.c = drawable;
                this.y = i;
                if (drawable != null) {
                    if (this.a.A > 0) {
                        l3 = (long)i3;
                        uptimeMillis = uptimeMillis + l3;
                        this.B = uptimeMillis;
                    }
                    d(drawable);
                }
            }
        }
        boolean z2 = true;
        if (this.B == l6) {
            if (this.C != l6 && this.A == null) {
                this.A = new b.a(this);
                a(z2);
            }
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.w;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.a.c()) {
            this.a.d = getChangingConfigurations();
            return this.a;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        if (this.b != null) {
            rect.set(this.b);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int intrinsicHeight = -1;
        if (this.a.q()) {
            return this.a.i();
        }
        if (this.c != null) {
            intrinsicHeight = this.c.getIntrinsicHeight();
        } else {
            intrinsicHeight = -1;
        }
        return intrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int intrinsicWidth = -1;
        if (this.a.q()) {
            return this.a.m();
        }
        if (this.c != null) {
            intrinsicWidth = this.c.getIntrinsicWidth();
        } else {
            intrinsicWidth = -1;
        }
        return intrinsicWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        int minimumHeight = 0;
        if (this.a.q()) {
            return this.a.j();
        }
        if (this.c != null) {
            minimumHeight = this.c.getMinimumHeight();
        } else {
            minimumHeight = 0;
        }
        return minimumHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        int minimumWidth = 0;
        if (this.a.q()) {
            return this.a.k();
        }
        if (this.c != null) {
            minimumWidth = this.c.getMinimumWidth();
        } else {
            minimumWidth = 0;
        }
        return minimumWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int i = -2;
        if (this.c == null || !this.c.isVisible()) {
            i = -2;
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.c != null) {
            this.c.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding = false;
        int right2;
        Rect rect2 = this.a.l();
        if (rect2 != null) {
            rect.set(rect2);
            i = (rect2.left | rect2.top) | rect2.bottom;
            int r0 = rect2.right | i != 0 ? 1 : 0;
        } else {
            if (this.c != null) {
                padding = this.c.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (this.e()) {
            rect.left = rect.right;
            rect.right = rect.left;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable
    void h(b.c cVar) {
        this.a = cVar;
        if (this.y >= 0) {
            Drawable drawable = cVar.g(this.y);
            this.c = drawable;
            if (drawable != null) {
                d(drawable);
            }
        }
        this.v = null;
    }

    @Override // android.graphics.drawable.Drawable
    final void i(Resources resources) {
        this.a.y(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateDrawable(Drawable drawable) {
        if (this.a != null) {
            this.a.p();
        }
        if (drawable == this.c && this.getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        int i = 0;
        i = 1;
        if (this.v != null) {
            this.v.jumpToCurrentState();
            this.v = null;
        } else {
            i = 0;
        }
        if (this.c != null) {
            this.c.jumpToCurrentState();
            if (this.x) {
                this.c.setAlpha(this.w);
            }
        }
        final long l3 = 0L;
        if (this.C != l3) {
            this.C = l3;
        }
        if (this.B != l3) {
            this.B = l3;
        } else {
        }
        if (i != 0) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.z && mutate() == this) {
            d.a.l.a.b.c cVar = b();
            cVar.r();
            h(cVar);
            boolean z = true;
            this.z = z;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.v != null) {
            this.v.setBounds(rect);
        }
        if (this.c != null) {
            this.c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.a.w(i, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.v != null) {
            return this.v.setLevel(i);
        }
        if (this.c != null) {
            return this.c.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.v != null) {
            return this.v.setState(iArr);
        }
        if (this.c != null) {
            return this.c.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable == this.c && this.getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (!this.x || this.w != i) {
            this.x = true;
            this.w = i;
            if (this.c != null) {
                long l = 0L;
                if (this.B == l) {
                    this.c.setAlpha(i);
                } else {
                    boolean z2 = false;
                    a(z2);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (cVar.C != z) {
            this.a.C = z;
            if (this.c != null) {
                a.j(this.c, z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.E = true;
        if (cVar.D != colorFilter) {
            this.a.D = colorFilter;
            if (this.c != null) {
                this.c.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (cVar.x != z) {
            this.a.x = z;
            if (this.c != null) {
                this.c.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        if (this.c != null) {
            a.k(this.c, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.b == null) {
            this.b = new Rect(i, i2, i3, i4);
        } else {
            this.b.set(i, i2, i3, i4);
        }
        if (this.c != null) {
            a.l(this.c, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList list) {
        this.a.H = true;
        if (cVar.F != list) {
            this.a.F = list;
            a.o(this.c, list);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.a.I = true;
        if (cVar.G != mode) {
            this.a.G = mode;
            a.p(this.c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.v != null) {
            this.v.setVisible(z, z2);
        }
        if (this.c != null) {
            this.c.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.c && this.getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    b.c b() {
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }
}
