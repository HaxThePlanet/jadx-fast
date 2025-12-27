package f.c.a.e.n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.google.android.material.internal.i.b;
import d.h.l.u;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.d0.g;
import f.c.a.e.f;
import f.c.a.e.j;
import f.c.a.e.k;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* compiled from: BadgeDrawable.java */
/* loaded from: classes2.dex */
public class a extends Drawable implements i.b {

    private static final int I = 0;
    private static final int J = 0;
    private float A;
    private float B;
    private int C;
    private float D;
    private float E;
    private float F;
    private WeakReference<View> G;
    private WeakReference<FrameLayout> H;
    private final WeakReference<Context> a = new WeakReference<>();
    private final g b = new g();
    private final com.google.android.material.internal.i c = new i();
    private final Rect v = new Rect();
    private float w;
    private float x;
    private float y;
    private final a.b z = new a$b();

    class a implements Runnable {

        final /* synthetic */ View a;
        final /* synthetic */ FrameLayout b;
        final /* synthetic */ a c;
        a(View view, FrameLayout frameLayout) {
            this.c = aVar;
            this.a = view;
            this.b = frameLayout;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.L(this.a, this.b);
        }
    }

    public static final class b implements Parcelable {

        public static final Parcelable.Creator<a.b> CREATOR = new a$b$a<>();
        private int A;
        private boolean B;
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private int H;
        private int a;
        private int b;
        private int c = 255;
        private int v = -1;
        private int w;
        private java.lang.CharSequence x;
        private int y;
        private int z;

        public b(Context context) {
            super();
            this.b = new d(context, k.e).i().getDefaultColor();
            this.x = context.getString(j.q);
            this.y = i.a;
            this.z = j.s;
            this.B = true;
        }

        static /* synthetic */ int A(a.b bVar) {
            return bVar.E;
        }

        static /* synthetic */ int B(a.b bVar, int i) {
            bVar.E = i;
            return i;
        }

        static /* synthetic */ int C(a.b bVar) {
            return bVar.F;
        }

        static /* synthetic */ int D(a.b bVar, int i) {
            bVar.F = i;
            return i;
        }

        static /* synthetic */ boolean a(a.b bVar) {
            return bVar.B;
        }

        static /* synthetic */ boolean b(a.b bVar, boolean z) {
            bVar.B = z;
            return z;
        }

        static /* synthetic */ int c(a.b bVar) {
            return bVar.w;
        }

        static /* synthetic */ int d(a.b bVar) {
            return bVar.G;
        }

        static /* synthetic */ int e(a.b bVar, int i) {
            bVar.G = i;
            return i;
        }

        static /* synthetic */ int f(a.b bVar, int i) {
            bVar.w = i;
            return i;
        }

        static /* synthetic */ int g(a.b bVar) {
            return bVar.H;
        }

        static /* synthetic */ int h(a.b bVar, int i) {
            bVar.H = i;
            return i;
        }

        static /* synthetic */ int i(a.b bVar) {
            return bVar.c;
        }

        static /* synthetic */ int j(a.b bVar, int i) {
            bVar.c = i;
            return i;
        }

        static /* synthetic */ java.lang.CharSequence k(a.b bVar) {
            return bVar.x;
        }

        static /* synthetic */ int l(a.b bVar) {
            return bVar.y;
        }

        static /* synthetic */ int m(a.b bVar) {
            return bVar.z;
        }

        static /* synthetic */ int n(a.b bVar) {
            return bVar.v;
        }

        static /* synthetic */ int o(a.b bVar, int i) {
            bVar.v = i;
            return i;
        }

        static /* synthetic */ int p(a.b bVar) {
            return bVar.a;
        }

        static /* synthetic */ int q(a.b bVar, int i) {
            bVar.a = i;
            return i;
        }

        static /* synthetic */ int r(a.b bVar) {
            return bVar.b;
        }

        static /* synthetic */ int s(a.b bVar, int i) {
            bVar.b = i;
            return i;
        }

        static /* synthetic */ int t(a.b bVar) {
            return bVar.A;
        }

        static /* synthetic */ int u(a.b bVar, int i) {
            bVar.A = i;
            return i;
        }

        static /* synthetic */ int v(a.b bVar) {
            return bVar.C;
        }

        static /* synthetic */ int x(a.b bVar, int i) {
            bVar.C = i;
            return i;
        }

        static /* synthetic */ int y(a.b bVar) {
            return bVar.D;
        }

        static /* synthetic */ int z(a.b bVar, int i) {
            bVar.D = i;
            return i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeInt(this.c);
            parcel.writeInt(this.v);
            parcel.writeInt(this.w);
            parcel.writeString(this.x.toString());
            parcel.writeInt(this.y);
            parcel.writeInt(this.A);
            parcel.writeInt(this.C);
            parcel.writeInt(this.D);
            parcel.writeInt(this.E);
            parcel.writeInt(this.F);
            parcel.writeInt(this.G);
            parcel.writeInt(this.H);
            parcel.writeInt(this.B);
        }

        protected b(Parcel parcel) {
            int i = 1;
            super();
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.c = parcel.readInt();
            this.v = parcel.readInt();
            this.w = parcel.readInt();
            this.x = parcel.readString();
            this.y = parcel.readInt();
            this.A = parcel.readInt();
            this.C = parcel.readInt();
            this.D = parcel.readInt();
            this.E = parcel.readInt();
            this.F = parcel.readInt();
            this.G = parcel.readInt();
            this.H = parcel.readInt();
            parcel = parcel.readInt() != 0 ? 1 : 0;
            this.B = (parcel.readInt() != 0 ? 1 : 0);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }
    }
    static {
        a.I = k.o;
        a.J = b.d;
    }

    private a(Context context) throws android.content.res.Resources.NotFoundException {
        super();
        WeakReference weakReference = new WeakReference(context);
        l.c(context);
        Resources resources = context.getResources();
        Rect rect = new Rect();
        g gVar = new g();
        this.w = (float)resources.getDimensionPixelSize(d.M);
        this.y = (float)resources.getDimensionPixelSize(d.L);
        this.x = (float)resources.getDimensionPixelSize(d.O);
        new i(this).e().setTextAlign(Paint.Align.CENTER);
        f.c.a.e.n.a.b bVar = new a.b(context);
        F(k.e);
    }

    private void E(f.c.a.e.a0.d dVar) {
        if (this.c.d() == dVar) {
            return;
        }
        Object obj = this.a.get();
        if (obj == null) {
            return;
        }
        this.c.h(dVar, obj);
        M();
    }

    private void F(int i) {
        Object obj = this.a.get();
        if (obj == null) {
            return;
        }
        E(new d(obj, i));
    }

    private void J(View view) {
        int i2;
        android.view.ViewParent parent = view.getParent();
        if (parent != null) {
            return;
        }
        a.K(view);
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        frameLayout.setId(f.E);
        boolean z = false;
        frameLayout.setClipChildren(z);
        frameLayout.setClipToPadding(z);
        frameLayout.setLayoutParams(view.getLayoutParams());
        frameLayout.setMinimumWidth(view.getWidth());
        frameLayout.setMinimumHeight(view.getHeight());
        int indexOfChild = parent.indexOfChild(view);
        parent.removeViewAt(indexOfChild);
        final int i4 = -1;
        view.setLayoutParams(new FrameLayout.LayoutParams(i4, i4));
        frameLayout.addView(view);
        parent.addView(frameLayout, indexOfChild);
        this.H = new WeakReference(frameLayout);
        frameLayout.post(new a.a(this, view, frameLayout));
    }

    private static void K(View view) {
        final android.view.ViewParent parent = view.getParent();
        final boolean z = false;
        parent.setClipChildren(z);
        parent.setClipToPadding(z);
    }

    private void M() {
        View view;
        int i = 0;
        WeakReference weakReference;
        Object obj = this.a.get();
        i = 0;
        Object obj2 = this.G != null ? (View)obj2 : i;
    }

    private void N() {
        this.C = (int)(Math.pow(10d, (double)l() - 1d)) - 1;
    }

    private void b(Context context, Rect rect, View view) throws android.content.res.Resources.NotFoundException {
        int i;
        float f2;
        int i3 = 8388693;
        float f4;
        float f5;
        float f6;
        int i4 = p();
        int i7 = this.z.A;
        final int i11 = 8388691;
        if (i7 == i11 || i7 == 8388693) {
            i2 = rect.bottom - i4;
            f = (float)i2;
            this.B = f;
        } else {
            i2 = rect.top + i4;
            f = (float)i2;
            this.B = f;
        }
        if (m() <= 9) {
            float r0 = !r() ? this.w : this.x;
            this.D = r0;
            this.F = r0;
            this.E = r0;
        } else {
            this.D = this.x;
            this.F = this.x;
            f2 = (this.c.f(g()) / 2f) + this.y;
            this.E = f2;
        }
        r0 = r() ? d.N : d.K;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize((r() ? d.N : d.K));
        int i6 = o();
        int i10 = this.z.A;
        if (i10 == 8388659 || i10 == i11) {
            if (u.B(view) == 0) {
                f4 = (float)i6;
                f5 = (float)rect.left - this.E + (float)dimensionPixelSize + f4;
            } else {
                f4 = (float)i6;
                f5 = (float)rect.right + this.E - (float)dimensionPixelSize - f4;
            }
            this.A = f5;
        } else {
            if (u.B(view) == 0) {
                f4 = (float)i6;
                f5 = (float)rect.right + this.E - (float)dimensionPixelSize - f4;
            } else {
                f4 = (float)i6;
                f5 = (float)rect.left - this.E + (float)dimensionPixelSize + f4;
            }
            this.A = f5;
        }
    }

    public static a c(Context context) {
        return a.d(context, null, a.J, a.I);
    }

    private static a d(Context context, AttributeSet set, int i, int i2) {
        return new a(context);
    }

    static a e(Context context, a.b bVar) {
        return new a(context);
    }

    private void f(Canvas canvas) {
        Rect rect = new Rect();
        final String str = g();
        this.c.e().getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, this.A, this.B + (float)(rect.height() / 2), this.c.e());
    }

    private String g() {
        if (m() <= this.C) {
            return NumberFormat.getInstance().format((long)m());
        }
        Object obj = this.a.get();
        if (obj == null) {
            return "";
        }
        Object[] arr = new Object[2];
        return obj.getString(j.t, new Object[] { Integer.valueOf(this.C), "+" });
    }

    private int o() {
        int i;
        if (r()) {
            i = this.z.E;
        } else {
            i = this.z.C;
        }
        return i + this.z.G;
    }

    private int p() {
        int i;
        if (r()) {
            i = this.z.F;
        } else {
            i = this.z.D;
        }
        return i + this.z.H;
    }

    private void s(Context context, AttributeSet set, int i, int i2) {
        final int i7 = 0;
        final TypedArray typedArray = l.h(context, set, l.n, i, i2, new int[i7]);
        C(typedArray.getInt(l.w, 4));
        _int = l.x;
        if (typedArray.hasValue(_int)) {
            D(typedArray.getInt(l.x, i7));
        }
        x(a.t(context, typedArray, l.o));
        int i16 = l.r;
        if (typedArray.hasValue(i16)) {
            z(a.t(context, typedArray, l.r));
        }
        y(typedArray.getInt(l.p, 8388661));
        B(typedArray.getDimensionPixelOffset(l.u, i7));
        H(typedArray.getDimensionPixelOffset(l.y, i7));
        A(typedArray.getDimensionPixelOffset(l.v, k()));
        G(typedArray.getDimensionPixelOffset(l.z, q()));
        i2 = l.q;
        if (typedArray.hasValue(i2)) {
            this.w = (float)(typedArray.getDimensionPixelSize(l.q, (int)this.w));
        }
        i5 = l.s;
        if (typedArray.hasValue(i5)) {
            this.y = (float)(typedArray.getDimensionPixelSize(l.s, (int)this.y));
        }
        i6 = l.t;
        if (typedArray.hasValue(i6)) {
            this.x = (float)(typedArray.getDimensionPixelSize(l.t, (int)this.x));
        }
        typedArray.recycle();
    }

    private static int t(Context context, TypedArray typedArray, int i) {
        return c.a(context, typedArray, i).getDefaultColor();
    }

    private void u(a.b bVar) {
        C(bVar.w);
        if (bVar.v != -1) {
            D(bVar.v);
        }
        x(bVar.a);
        z(bVar.b);
        y(bVar.A);
        B(bVar.C);
        H(bVar.D);
        A(bVar.E);
        G(bVar.F);
        v(bVar.G);
        w(bVar.H);
        I(bVar.B);
    }

    @Override // android.graphics.drawable.Drawable
    public void A(int i) {
        this.z.E = i;
        M();
    }

    @Override // android.graphics.drawable.Drawable
    public void B(int i) {
        this.z.C = i;
        M();
    }

    @Override // android.graphics.drawable.Drawable
    public void C(int i) {
        if (this.z.w != i) {
            this.z.w = i;
            N();
            this.c.i(true);
            M();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void D(int i) {
        int max = Math.max(0, i);
        if (this.z.v != max) {
            this.z.v = max;
            this.c.i(true);
            M();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void G(int i) {
        this.z.F = i;
        M();
    }

    @Override // android.graphics.drawable.Drawable
    public void H(int i) {
        this.z.D = i;
        M();
    }

    @Override // android.graphics.drawable.Drawable
    public void I(boolean z) {
        setVisible(z, false);
        this.z.B = z;
        if (b.a && this.i() != null && !z) {
            (ViewGroup)i().getParent().invalidate();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void L(View view, FrameLayout frameLayout) {
        this.G = new WeakReference(view);
        boolean z = b.a;
        if (!b.a || frameLayout != null) {
            this.H = new WeakReference(frameLayout);
        } else {
            J(view);
        }
        if (!b.a) {
            a.K(view);
        }
        M();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.z.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.v.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.v.width();
    }

    @Override // android.graphics.drawable.Drawable
    public java.lang.CharSequence h() throws android.content.res.Resources.NotFoundException {
        int i2 = 0;
        if (!isVisible()) {
            return null;
        }
        if (r()) {
            if (this.z.y > 0) {
                Object obj = this.a.get();
                if (obj == null) {
                    return i2;
                }
                final int i8 = 0;
                int i9 = 1;
                if (m() <= this.C) {
                    Object[] arr2 = new Object[i9];
                    return obj.getResources().getQuantityString(this.z.y, m(), new Object[] { Integer.valueOf(m()) });
                }
                Object[] arr = new Object[i9];
                return obj.getString(this.z.z, new Object[] { Integer.valueOf(this.C) });
            }
            return i2;
        }
        return this.z.x;
    }

    @Override // android.graphics.drawable.Drawable
    public FrameLayout i() {
        Object obj = null;
        obj = this.H != null ? (FrameLayout)obj : 0;
        return obj;
    }

    @Override // android.graphics.drawable.Drawable
    public int j() {
        return this.z.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int k() {
        return this.z.C;
    }

    @Override // android.graphics.drawable.Drawable
    public int l() {
        return this.z.w;
    }

    @Override // android.graphics.drawable.Drawable
    public int m() {
        if (!r()) {
            return 0;
        }
        return this.z.v;
    }

    @Override // android.graphics.drawable.Drawable
    public a.b n() {
        return this.z;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int q() {
        return this.z.D;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean r() {
        boolean z = true;
        int r0 = this.z.v != -1 ? 1 : 0;
        return (this.z.v != -1 ? 1 : 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.z.c = i;
        this.c.e().setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    void v(int i) {
        this.z.G = i;
        M();
    }

    @Override // android.graphics.drawable.Drawable
    void w(int i) {
        this.z.H = i;
        M();
    }

    @Override // android.graphics.drawable.Drawable
    public void x(int i) {
        this.z.a = i;
        final ColorStateList str = ColorStateList.valueOf(i);
        if (this.b.x() != str) {
            this.b.Z(str);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void y(int i) {
        FrameLayout frameLayout = null;
        if (this.z.A != i) {
            this.z.A = i;
            if (this.G != null && this.G.get() != null) {
                Object obj = this.H != null ? (FrameLayout)obj : 0;
                L((View)this.G.get(), frameLayout);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void z(int i) {
        this.z.b = i;
        if (this.c.e().getColor() != i) {
            this.c.e().setColor(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
