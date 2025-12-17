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
import android.util.SparseArray;
import androidx.core.graphics.drawable.a;

/* loaded from: classes.dex */
class b extends Drawable implements Drawable.Callback {

    private Runnable A;
    private long B;
    private long C;
    private d.a.l.a.b.b D;
    private d.a.l.a.b.c a;
    private Rect b;
    private Drawable c;
    private Drawable v;
    private int w = 255;
    private boolean x;
    private int y = -1;
    private boolean z;

    class a implements Runnable {

        final d.a.l.a.b a;
        a(d.a.l.a.b b) {
            this.a = b;
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
        @Override // android.graphics.drawable.Drawable$Callback
        public Drawable.Callback a() {
            this.a = 0;
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable$Callback
        public d.a.l.a.b.b b(Drawable.Callback drawable$Callback) {
            this.a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable$Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable$Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable2, long l3) {
            final Drawable.Callback callback = this.a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable2, l3);
            }
        }

        @Override // android.graphics.drawable.Drawable$Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable2) {
            final Drawable.Callback callback = this.a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable2);
            }
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
        final d.a.l.a.b a;
        Resources b = null;
        int c = 160;
        int d;
        int e;
        SparseArray<Drawable.ConstantState> f;
        Drawable[] g;
        int h = 0;
        boolean i = false;
        boolean j = true;
        Rect k;
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
        c(d.a.l.a.b.c b$c, d.a.l.a.b b2, Resources resources3) {
            int i2;
            int i;
            Drawable[] obj3;
            int obj4;
            Resources obj5;
            super();
            int i3 = 160;
            i = 1;
            this.a = b2;
            obj4 = resources3 != null ? resources3 : obj4;
            obj4 = c != null ? c.b : obj4;
            obj4 = 0;
            obj4 = c != null ? c.c : i2;
            obj4 = b.f(resources3, obj4);
            this.c = obj4;
            if (c != null) {
                this.d = c.d;
                this.e = c.e;
                this.i = c.i;
                this.l = c.l;
                this.x = c.x;
                this.y = c.y;
                this.z = c.z;
                this.A = c.A;
                this.B = c.B;
                this.C = c.C;
                this.D = c.D;
                this.E = c.E;
                this.F = c.F;
                this.G = c.G;
                this.H = c.H;
                this.I = c.I;
                if (c.c == obj4 && c.j) {
                    if (c.j) {
                        obj4 = new Rect(c.k);
                        this.k = obj4;
                    }
                    if (c.m) {
                        this.n = c.n;
                        this.o = c.o;
                        this.p = c.p;
                        this.q = c.q;
                    }
                }
                if (c.r) {
                    this.s = c.s;
                }
                if (c.t) {
                    this.u = c.u;
                }
                obj4 = c.g;
                this.g = new Drawable[obj4.length];
                this.h = c.h;
                obj3 = c.f;
                if (obj3 != null) {
                    this.f = obj3.clone();
                } else {
                    obj3 = new SparseArray(this.h);
                    this.f = obj3;
                }
                while (i2 < this.h) {
                    if (obj4[i2] != null) {
                    }
                    i2++;
                    obj5 = obj4[i2].getConstantState();
                    if (obj5 != null) {
                    } else {
                    }
                    this.g[i2] = obj4[i2];
                    this.f.put(i2, obj5);
                }
            } else {
                this.g = new Drawable[10];
            }
        }

        private void e() {
            SparseArray sparseArray;
            int i;
            int keyAt;
            Drawable drawable;
            Drawable[] objArr;
            Resources resources;
            sparseArray = this.f;
            if (sparseArray != null) {
                i = 0;
                while (i < sparseArray.size()) {
                    this.g[this.f.keyAt(i)] = s((Drawable.ConstantState)this.f.valueAt(i).newDrawable(this.b));
                    i++;
                }
                this.f = 0;
            }
        }

        private Drawable s(Drawable drawable) {
            int sDK_INT;
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.z);
            }
            final Drawable obj3 = drawable.mutate();
            obj3.setCallback(this.a);
            return obj3;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final int a(Drawable drawable) {
            int length;
            final int i = this.h;
            if (i >= objArr.length) {
                o(i, i + 10);
            }
            drawable.mutate();
            int i2 = 0;
            int i3 = 1;
            drawable.setVisible(i2, i3);
            drawable.setCallback(this.a);
            this.g[i] = drawable;
            this.h = i5 += i3;
            this.e = obj5 |= i4;
            p();
            this.k = 0;
            this.j = i2;
            this.m = i2;
            this.v = i2;
            return i;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        final void b(Resources.Theme resources$Theme) {
            int i;
            Drawable[] objArr;
            int i2;
            Drawable applyTheme;
            int changingConfigurations;
            Object obj6;
            if (theme != null) {
                e();
                objArr = this.g;
                i2 = 0;
                while (i2 < this.h) {
                    if (objArr[i2] != null && objArr[i2].canApplyTheme()) {
                    }
                    i2++;
                    if (objArr[i2].canApplyTheme()) {
                    }
                    objArr[i2].applyTheme(theme);
                    this.e = i3 |= changingConfigurations;
                }
                y(theme.getResources());
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean c() {
            int i;
            Drawable.ConstantState constantState;
            synchronized (this) {
                try {
                    return this.w;
                    e();
                    int i2 = 1;
                    this.v = i2;
                    final int i4 = 0;
                    i = i4;
                    while (i < this.h) {
                        i++;
                    }
                    if (objArr[i].getConstantState() == null) {
                    } else {
                    }
                    this.w = i4;
                    return i4;
                    i++;
                }
                this.w = i2;
                return i2;
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean canApplyTheme() {
            int i;
            boolean applyTheme;
            int i2;
            final int i4 = 0;
            i = i4;
            while (i < this.h) {
                Drawable drawable = this.g[i];
                i2 = 1;
                applyTheme = this.f.get(i);
                i++;
            }
            return i4;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        protected void d() {
            int i2;
            int minimumHeight;
            int i;
            int i3;
            this.m = true;
            e();
            int i6 = -1;
            this.o = i6;
            this.n = i6;
            i2 = 0;
            this.q = i2;
            this.p = i2;
            while (i2 < this.h) {
                Drawable drawable = this.g[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                }
                minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                }
                i2++;
                this.q = minimumHeight;
                this.p = minimumWidth;
                this.o = intrinsicHeight;
                this.n = intrinsicWidth;
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        final int f() {
            return objArr.length;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final Drawable g(int i) {
            SparseArray indexOfKey;
            Drawable drawable = this.g[i];
            if (drawable != null) {
                return drawable;
            }
            indexOfKey = this.f;
            final int i2 = 0;
            indexOfKey = indexOfKey.indexOfKey(i);
            Drawable drawable3 = s((Drawable.ConstantState)this.f.valueAt(indexOfKey).newDrawable(this.b));
            this.g[i] = drawable3;
            this.f.removeAt(indexOfKey);
            if (indexOfKey != null && indexOfKey >= 0 && this.f.size() == 0) {
                indexOfKey = indexOfKey.indexOfKey(i);
                if (indexOfKey >= 0) {
                    drawable3 = s((Drawable.ConstantState)this.f.valueAt(indexOfKey).newDrawable(this.b));
                    this.g[i] = drawable3;
                    this.f.removeAt(indexOfKey);
                    if (this.f.size() == 0) {
                        this.f = i2;
                    }
                    return drawable3;
                }
            }
            return i2;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return i |= i3;
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
            int rect;
            boolean z;
            int i;
            boolean padding;
            int bottom;
            if (this.i) {
                return null;
            }
            Rect rect2 = this.k;
            if (rect2 == null) {
                if (this.j) {
                } else {
                    e();
                    Rect rect3 = new Rect();
                    final int i4 = 0;
                    i = i4;
                    while (i < this.h) {
                        if (this.g[i].getPadding(rect3) && rect == null) {
                        }
                        i++;
                        if (rect == null) {
                        }
                        int left = rect3.left;
                        if (left > rect.left) {
                        }
                        int top = rect3.top;
                        if (top > rect.top) {
                        }
                        int right = rect3.right;
                        if (right > rect.right) {
                        }
                        padding = rect3.bottom;
                        if (padding > rect.bottom) {
                        }
                        rect.bottom = padding;
                        rect.right = right;
                        rect.top = top;
                        rect.left = left;
                        rect = new Rect(i4, i4, i4, i4);
                    }
                }
                this.j = true;
                this.k = rect;
                return rect;
            }
            return rect2;
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
            int resolveOpacity;
            int i;
            int opacity;
            if (this.r) {
                return this.s;
            }
            e();
            int i2 = this.h;
            final Drawable[] objArr = this.g;
            if (i2 > 0) {
                resolveOpacity = objArr[0].getOpacity();
            } else {
                resolveOpacity = -2;
            }
            final int i5 = 1;
            i = i5;
            while (i < i2) {
                resolveOpacity = Drawable.resolveOpacity(resolveOpacity, objArr[i].getOpacity());
                i++;
            }
            this.s = resolveOpacity;
            this.r = i5;
            return resolveOpacity;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public void o(int i, int i2) {
            final Drawable[] obj4 = new Drawable[i2];
            final int i3 = 0;
            System.arraycopy(this.g, i3, obj4, i3, i);
            this.g = obj4;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        void p() {
            final int i = 0;
            this.r = i;
            this.t = i;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final boolean q() {
            return this.l;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        abstract void r();

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
            int i4;
            Drawable layoutDirection;
            int i5;
            final Drawable[] objArr = this.g;
            final int i7 = 0;
            i4 = i3;
            while (i3 < this.h) {
                if (objArr[i3] != null) {
                }
                i3++;
                if (Build.VERSION.SDK_INT >= 23) {
                } else {
                }
                layoutDirection = i7;
                if (i3 == i2) {
                }
                i4 = layoutDirection;
                layoutDirection = objArr[i3].setLayoutDirection(i);
            }
            this.z = i;
            return i4;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public final void x(boolean z) {
            this.i = z;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        final void y(Resources resources) {
            int i;
            Resources obj2;
            this.b = resources;
            obj2 = b.f(resources, this.c);
            this.c = obj2;
            if (resources != null && this.c != obj2) {
                this.b = resources;
                obj2 = b.f(resources, this.c);
                this.c = obj2;
                if (this.c != obj2) {
                    obj2 = 0;
                    this.m = obj2;
                    this.j = obj2;
                }
            }
        }
    }
    b() {
        super();
        int i = 255;
        int i2 = -1;
    }

    private void d(Drawable drawable) {
        d.a.l.a.b.b bVar;
        int i2;
        Object obj;
        int sDK_INT;
        Object cVar;
        boolean z;
        int layoutDirection;
        int i;
        Rect bottom;
        int top;
        int right;
        if (this.D == null) {
            bVar = new b.b();
            this.D = bVar;
        }
        d.a.l.a.b.b bVar2 = this.D;
        bVar2.b(drawable.getCallback());
        drawable.setCallback(bVar2);
        if (cVar2.A <= 0 && this.x) {
            if (this.x) {
                drawable.setAlpha(this.w);
            }
        }
        cVar = this.a;
        if (cVar.E) {
            drawable.setColorFilter(cVar.D);
        } else {
            if (cVar.H) {
                a.o(drawable, cVar.F);
            }
            obj = this.a;
            if (obj.I) {
                a.p(drawable, obj.G);
            }
        }
        drawable.setVisible(isVisible(), true);
        drawable.setDither(cVar3.x);
        drawable.setState(getState());
        drawable.setLevel(getLevel());
        drawable.setBounds(getBounds());
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 23) {
            drawable.setLayoutDirection(getLayoutDirection());
        }
        if (sDK_INT >= 19) {
            drawable.setAutoMirrored(cVar4.C);
        }
        bottom = this.b;
        if (sDK_INT >= 21 && bottom != null) {
            if (bottom != null) {
                drawable.setHotspotBounds(bottom.left, bottom.top, bottom.right, bottom.bottom);
            }
        }
        drawable.setCallback(this.D.a());
    }

    private boolean e() {
        boolean autoMirrored;
        int i;
        if (isAutoMirrored() && a.f(this) == 1) {
            if (a.f(this) == 1) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    static int f(Resources resources, int i2) {
        android.util.DisplayMetrics obj0;
        int obj1;
        if (resources == null) {
        } else {
            obj1 = obj0.densityDpi;
        }
        if (obj1 == null) {
            obj1 = 160;
        }
        return obj1;
    }

    @Override // android.graphics.drawable.Drawable
    void a(boolean z) {
        int i4;
        long uptimeMillis;
        int i3;
        int i2;
        long l;
        int i;
        int cmp;
        int cmp2;
        Runnable obj14;
        i4 = 1;
        this.x = i4;
        uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable = this.c;
        i2 = 255;
        final int i9 = 0;
        final int i10 = 0;
        if (drawable != null) {
            l = this.B;
            if (Long.compare(l, i10) != 0) {
                if (Long.compare(l, uptimeMillis) <= 0) {
                    drawable.setAlpha(this.w);
                    this.B = i10;
                    i3 = i9;
                } else {
                    drawable.setAlpha(i16 /= 255);
                    i3 = i4;
                }
            } else {
            }
        } else {
            this.B = i10;
        }
        Drawable drawable2 = this.v;
        if (drawable2 != null) {
            i = this.C;
            if (Long.compare(i, i10) != 0) {
                if (Long.compare(i, uptimeMillis) <= 0) {
                    drawable2.setVisible(i9, i9);
                    this.v = 0;
                    this.C = i10;
                    i4 = i3;
                } else {
                    drawable2.setAlpha(i7 /= 255);
                }
            } else {
            }
        } else {
            this.C = i10;
        }
        if (z != null && i4 != 0) {
            if (i4 != 0) {
                scheduleSelf(this.A, uptimeMillis += i3);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme resources$Theme) {
        this.a.b(theme);
    }

    @Override // android.graphics.drawable.Drawable
    d.a.l.a.b.c b() {
        throw 0;
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
        Drawable drawable = this.c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.v;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    boolean g(int i) {
        int drawable;
        int i2;
        long uptimeMillis;
        long l;
        int obj10;
        i2 = 0;
        if (i == this.y) {
            return i2;
        }
        uptimeMillis = SystemClock.uptimeMillis();
        final int i7 = 0;
        final int i8 = 0;
        if (cVar.B > 0) {
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                drawable2.setVisible(i2, i2);
            }
            drawable = this.c;
            if (drawable != null) {
                this.v = drawable;
                this.C = l2 += uptimeMillis;
            } else {
                this.v = i7;
                this.C = i8;
            }
        } else {
            drawable = this.c;
            if (drawable != null) {
                drawable.setVisible(i2, i2);
            }
        }
        drawable = this.a;
        if (i >= 0 && i < drawable.h) {
            drawable = this.a;
            if (i < drawable.h) {
                drawable = drawable.g(i);
                this.c = drawable;
                this.y = i;
                obj10 = obj10.A;
                if (drawable != null && obj10 > 0) {
                    obj10 = obj10.A;
                    if (obj10 > 0) {
                        this.B = uptimeMillis += l;
                    }
                    d(drawable);
                }
            } else {
                this.c = i7;
                this.y = -1;
            }
        } else {
        }
        int i6 = 1;
        if (Long.compare(l3, i8) == 0) {
            if (Long.compare(i2, i8) != 0) {
                obj10 = this.A;
                if (obj10 == null) {
                    obj10 = new b.a(this);
                    this.A = obj10;
                } else {
                    unscheduleSelf(obj10);
                }
                a(i6);
            }
        } else {
        }
        invalidateSelf();
        return i6;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.w;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return changingConfigurations |= changingConfigurations2;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.a.c()) {
            cVar2.d = getChangingConfigurations();
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
        final Rect rect2 = this.b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int intrinsicHeight;
        if (this.a.q()) {
            return this.a.i();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            intrinsicHeight = drawable.getIntrinsicHeight();
        } else {
            intrinsicHeight = -1;
        }
        return intrinsicHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int intrinsicWidth;
        if (this.a.q()) {
            return this.a.m();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        } else {
            intrinsicWidth = -1;
        }
        return intrinsicWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        int minimumHeight;
        if (this.a.q()) {
            return this.a.j();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            minimumHeight = drawable.getMinimumHeight();
        } else {
            minimumHeight = 0;
        }
        return minimumHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        int minimumWidth;
        if (this.a.q()) {
            return this.a.k();
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            minimumWidth = drawable.getMinimumWidth();
        } else {
            minimumWidth = 0;
        }
        return minimumWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        int i;
        Drawable visible;
        visible = this.c;
        if (visible != null) {
            if (!visible.isVisible()) {
                i = -2;
            } else {
                i = this.a.n();
            }
        } else {
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        final Drawable drawable = this.c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int padding;
        int i;
        boolean left;
        int bottom;
        Rect rect2 = this.a.l();
        if (rect2 != null) {
            rect.set(rect2);
            padding = right |= i != 0 ? 1 : 0;
        } else {
            Drawable drawable = this.c;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (e()) {
            rect.left = rect.right;
            rect.right = rect.left;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable
    void h(d.a.l.a.b.c b$c) {
        Object obj2;
        this.a = c;
        final int i = this.y;
        obj2 = c.g(i);
        this.c = obj2;
        if (i >= 0 && obj2 != null) {
            obj2 = c.g(i);
            this.c = obj2;
            if (obj2 != null) {
                d(obj2);
            }
        }
        this.v = 0;
    }

    @Override // android.graphics.drawable.Drawable
    final void i(Resources resources) {
        this.a.y(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateDrawable(Drawable drawable) {
        Object obj2;
        d.a.l.a.b.c cVar = this.a;
        if (cVar != null) {
            cVar.p();
        }
        if (drawable == this.c && getCallback() != null) {
            if (getCallback() != null) {
                getCallback().invalidateDrawable(this);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return cVar.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        int i;
        int i2;
        Drawable drawable;
        int i3;
        Drawable drawable2 = this.v;
        i2 = 1;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            this.v = 0;
            i = i2;
        } else {
            i = 0;
        }
        drawable = this.c;
        drawable.jumpToCurrentState();
        if (drawable != null && this.x) {
            drawable.jumpToCurrentState();
            if (this.x) {
                this.c.setAlpha(this.w);
            }
        }
        final int i5 = 0;
        if (Long.compare(l, i5) != 0) {
            this.C = i5;
            i = i2;
        }
        if (Long.compare(l2, i5) != 0) {
            this.B = i5;
        } else {
            i2 = i;
        }
        if (i2 != 0) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        boolean mutate;
        if (!this.z && super.mutate() == this) {
            if (super.mutate() == this) {
                d.a.l.a.b.c cVar = b();
                cVar.r();
                h(cVar);
                this.z = true;
            }
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.v;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.a.w(i, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.v;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.v;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleDrawable(Drawable drawable, Runnable runnable2, long l3) {
        Object obj2;
        if (drawable == this.c && getCallback() != null) {
            if (getCallback() != null) {
                getCallback().scheduleDrawable(this, runnable2, l3);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        int z;
        int cmp;
        int i2;
        int obj6;
        if (this.x) {
            this.x = true;
            this.w = i;
            z = this.c;
            if (this.w != i && z != null) {
                this.x = true;
                this.w = i;
                z = this.c;
                if (z != null) {
                    if (Long.compare(l, i2) == 0) {
                        z.setAlpha(i);
                    } else {
                        a(false);
                    }
                }
            }
        } else {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Object cVar;
        cVar = this.a;
        cVar.C = z;
        cVar = this.c;
        if (cVar.C != z && cVar != null) {
            cVar.C = z;
            cVar = this.c;
            if (cVar != null) {
                a.j(cVar, z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Object cVar;
        cVar = this.a;
        cVar.E = true;
        cVar.D = colorFilter;
        cVar = this.c;
        if (cVar.D != colorFilter && cVar != null) {
            cVar.D = colorFilter;
            cVar = this.c;
            if (cVar != null) {
                cVar.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        Object cVar;
        cVar = this.a;
        cVar.x = z;
        cVar = this.c;
        if (cVar.x != z && cVar != null) {
            cVar.x = z;
            cVar = this.c;
            if (cVar != null) {
                cVar.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        final Drawable drawable = this.c;
        if (drawable != null) {
            a.k(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect;
        rect = this.b;
        if (rect == null) {
            rect = new Rect(i, i2, i3, i4);
            this.b = rect;
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.c;
        if (drawable != null) {
            a.l(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Object cVar;
        cVar = this.a;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            a.o(this.c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode porterDuff$Mode) {
        Object cVar;
        cVar = this.a;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            a.p(this.c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.v;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleDrawable(Drawable drawable, Runnable runnable2) {
        Object obj2;
        if (drawable == this.c && getCallback() != null) {
            if (getCallback() != null) {
                getCallback().unscheduleDrawable(this, runnable2);
            }
        }
    }
}
