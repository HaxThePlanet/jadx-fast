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
import com.google.android.material.internal.i;
import com.google.android.material.internal.i.b;
import com.google.android.material.internal.l;
import d.h.l.u;
import f.c.a.e.a0.c;
import f.c.a.e.a0.d;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.d0.g;
import f.c.a.e.f;
import f.c.a.e.i;
import f.c.a.e.j;
import f.c.a.e.k;
import f.c.a.e.l;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* loaded from: classes2.dex */
public class a extends Drawable implements i.b {

    private static final int I;
    private static final int J;
    private float A;
    private float B;
    private int C;
    private float D;
    private float E;
    private float F;
    private WeakReference<View> G;
    private WeakReference<FrameLayout> H;
    private final WeakReference<Context> a;
    private final g b;
    private final i c;
    private final Rect v;
    private float w;
    private float x;
    private float y;
    private final f.c.a.e.n.a.b z;

    class a implements Runnable {

        final View a;
        final FrameLayout b;
        final f.c.a.e.n.a c;
        a(f.c.a.e.n.a a, View view2, FrameLayout frameLayout3) {
            this.c = a;
            this.a = view2;
            this.b = frameLayout3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.c.L(this.a, this.b);
        }
    }

    public static final class b implements Parcelable {

        public static final Parcelable.Creator<f.c.a.e.n.a.b> CREATOR;
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
        static {
            a.b.a aVar = new a.b.a();
            a.b.CREATOR = aVar;
        }

        public b(Context context) {
            super();
            int i = 255;
            int i2 = -1;
            d dVar = new d(context, k.e);
            this.b = dVar.i().getDefaultColor();
            this.x = context.getString(j.q);
            this.y = i.a;
            this.z = j.s;
            this.B = true;
        }

        protected b(Parcel parcel) {
            int obj2;
            super();
            int i = 255;
            int i2 = -1;
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
            obj2 = parcel.readInt() != 0 ? 1 : 0;
            this.B = obj2;
        }

        static int A(f.c.a.e.n.a.b a$b) {
            return b.E;
        }

        static int B(f.c.a.e.n.a.b a$b, int i2) {
            b.E = i2;
            return i2;
        }

        static int C(f.c.a.e.n.a.b a$b) {
            return b.F;
        }

        static int D(f.c.a.e.n.a.b a$b, int i2) {
            b.F = i2;
            return i2;
        }

        static boolean a(f.c.a.e.n.a.b a$b) {
            return b.B;
        }

        static boolean b(f.c.a.e.n.a.b a$b, boolean z2) {
            b.B = z2;
            return z2;
        }

        static int c(f.c.a.e.n.a.b a$b) {
            return b.w;
        }

        static int d(f.c.a.e.n.a.b a$b) {
            return b.G;
        }

        static int e(f.c.a.e.n.a.b a$b, int i2) {
            b.G = i2;
            return i2;
        }

        static int f(f.c.a.e.n.a.b a$b, int i2) {
            b.w = i2;
            return i2;
        }

        static int g(f.c.a.e.n.a.b a$b) {
            return b.H;
        }

        static int h(f.c.a.e.n.a.b a$b, int i2) {
            b.H = i2;
            return i2;
        }

        static int i(f.c.a.e.n.a.b a$b) {
            return b.c;
        }

        static int j(f.c.a.e.n.a.b a$b, int i2) {
            b.c = i2;
            return i2;
        }

        static java.lang.CharSequence k(f.c.a.e.n.a.b a$b) {
            return b.x;
        }

        static int l(f.c.a.e.n.a.b a$b) {
            return b.y;
        }

        static int m(f.c.a.e.n.a.b a$b) {
            return b.z;
        }

        static int n(f.c.a.e.n.a.b a$b) {
            return b.v;
        }

        static int o(f.c.a.e.n.a.b a$b, int i2) {
            b.v = i2;
            return i2;
        }

        static int p(f.c.a.e.n.a.b a$b) {
            return b.a;
        }

        static int q(f.c.a.e.n.a.b a$b, int i2) {
            b.a = i2;
            return i2;
        }

        static int r(f.c.a.e.n.a.b a$b) {
            return b.b;
        }

        static int s(f.c.a.e.n.a.b a$b, int i2) {
            b.b = i2;
            return i2;
        }

        static int t(f.c.a.e.n.a.b a$b) {
            return b.A;
        }

        static int u(f.c.a.e.n.a.b a$b, int i2) {
            b.A = i2;
            return i2;
        }

        static int v(f.c.a.e.n.a.b a$b) {
            return b.C;
        }

        static int x(f.c.a.e.n.a.b a$b, int i2) {
            b.C = i2;
            return i2;
        }

        static int y(f.c.a.e.n.a.b a$b) {
            return b.D;
        }

        static int z(f.c.a.e.n.a.b a$b, int i2) {
            b.D = i2;
            return i2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
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
    }
    static {
        a.I = k.o;
        a.J = b.d;
    }

    private a(Context context) {
        super();
        WeakReference weakReference = new WeakReference(context);
        this.a = weakReference;
        l.c(context);
        Resources resources = context.getResources();
        Rect rect = new Rect();
        this.v = rect;
        g gVar = new g();
        this.b = gVar;
        this.w = (float)dimensionPixelSize2;
        this.y = (float)dimensionPixelSize3;
        this.x = (float)dimensionPixelSize;
        i iVar = new i(this);
        this.c = iVar;
        iVar.e().setTextAlign(Paint.Align.CENTER);
        a.b bVar = new a.b(context);
        this.z = bVar;
        F(k.e);
    }

    private void E(d d) {
        if (this.c.d() == d) {
        }
        Object obj = this.a.get();
        if ((Context)obj == null) {
        }
        this.c.h(d, (Context)obj);
        M();
    }

    private void F(int i) {
        Object obj = this.a.get();
        if ((Context)obj == null) {
        }
        d dVar = new d((Context)obj, i);
        E(dVar);
    }

    private void J(View view) {
        int i;
        int i2;
        android.view.ViewParent parent = view.getParent();
        if ((ViewGroup)parent != null) {
            i = this.H;
            if ((ViewGroup)parent.getId() != f.E && i != null && i.get() == parent) {
                i = this.H;
                if (i != null) {
                    if (i.get() == parent) {
                    }
                }
            }
        } else {
        }
        a.K(view);
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        frameLayout.setId(f.E);
        int i4 = 0;
        frameLayout.setClipChildren(i4);
        frameLayout.setClipToPadding(i4);
        frameLayout.setLayoutParams(view.getLayoutParams());
        frameLayout.setMinimumWidth(view.getWidth());
        frameLayout.setMinimumHeight(view.getHeight());
        int indexOfChild = parent.indexOfChild(view);
        parent.removeViewAt(indexOfChild);
        final int i5 = -1;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i5, i5);
        view.setLayoutParams(layoutParams2);
        frameLayout.addView(view);
        parent.addView(frameLayout, indexOfChild);
        WeakReference weakReference = new WeakReference(frameLayout);
        this.H = weakReference;
        a.a aVar = new a.a(this, view, frameLayout);
        frameLayout.post(aVar);
    }

    private static void K(View view) {
        final android.view.ViewParent obj1 = view.getParent();
        final int i = 0;
        (ViewGroup)obj1.setClipChildren(i);
        obj1.setClipToPadding(i);
    }

    private void M() {
        Object equals;
        Object obj;
        int parent;
        Rect rect;
        float f2;
        WeakReference weakReference;
        float f;
        equals = this.a.get();
        WeakReference weakReference3 = this.G;
        if (weakReference3 != null) {
            obj = weakReference3.get();
        } else {
            obj = parent;
        }
        if ((Context)equals != null) {
            if (obj == null) {
            } else {
                rect = new Rect();
                rect.set(this.v);
                Rect rect5 = new Rect();
                obj.getDrawingRect(rect5);
                weakReference = this.H;
                if (weakReference != null) {
                    parent = weakReference.get();
                }
                if (parent == 0) {
                    if (b.a && parent == 0) {
                        if (parent == 0) {
                            parent = obj.getParent();
                        }
                        parent.offsetDescendantRectToMyCoords(obj, rect5);
                    }
                } else {
                }
                b((Context)equals, rect5, obj);
                b.f(this.v, this.A, this.B, this.E, this.F);
                this.b.W(this.D);
                if (!rect.equals(this.v)) {
                    this.b.setBounds(this.v);
                }
            }
        }
    }

    private void N() {
        this.C = i3--;
    }

    private void b(Context context, Rect rect2, View view3) {
        float f;
        int i5;
        int i2;
        int i;
        float i4;
        int i3;
        float obj5;
        int obj6;
        float obj7;
        int i6 = p();
        int i10 = a.b.t(this.z);
        final int i13 = 8388691;
        if (i10 != i13 && i10 != 8388693) {
            if (i10 != 8388693) {
                this.B = (float)i;
            } else {
                this.B = (float)i;
            }
        } else {
        }
        if (m() <= 9) {
            i5 = !r() ? this.w : this.x;
            this.D = i5;
            this.F = i5;
            this.E = i5;
        } else {
            float f2 = this.x;
            this.D = f2;
            this.F = f2;
            this.E = i8 += i4;
        }
        i2 = r() ? d.N : d.K;
        obj5 = context.getResources().getDimensionPixelSize(i2);
        int i9 = o();
        int i12 = a.b.t(this.z);
        if (i12 != 8388659 && i12 != i13) {
            if (i12 != i13) {
                if (u.B(view3) == 0) {
                    obj6 -= obj5;
                } else {
                    obj6 += obj5;
                }
                this.A = obj6;
            } else {
                if (u.B(view3) == 0) {
                    obj6 += obj5;
                } else {
                    obj6 -= obj5;
                }
                this.A = obj6;
            }
        } else {
        }
    }

    public static f.c.a.e.n.a c(Context context) {
        return a.d(context, 0, a.J, a.I);
    }

    private static f.c.a.e.n.a d(Context context, AttributeSet attributeSet2, int i3, int i4) {
        a aVar = new a(context);
        aVar.s(context, attributeSet2, i3, i4);
        return aVar;
    }

    static f.c.a.e.n.a e(Context context, f.c.a.e.n.a.b a$b2) {
        a aVar = new a(context);
        aVar.u(b2);
        return aVar;
    }

    private void f(Canvas canvas) {
        Rect rect = new Rect();
        final String str = g();
        this.c.e().getTextBounds(str, 0, str.length(), rect);
        canvas.drawText(str, this.A, f3 += f, this.c.e());
    }

    private String g() {
        if (m() <= this.C) {
            return NumberFormat.getInstance().format((long)i3);
        }
        Object obj = this.a.get();
        if ((Context)obj == null) {
            return "";
        }
        Object[] arr = new Object[2];
        return (Context)obj.getString(j.t, Integer.valueOf(this.C), "+");
    }

    private int o() {
        int i;
        if (r()) {
            i = a.b.A(this.z);
        } else {
            i = a.b.v(this.z);
        }
        return i += i3;
    }

    private int p() {
        int i;
        if (r()) {
            i = a.b.C(this.z);
        } else {
            i = a.b.y(this.z);
        }
        return i += i3;
    }

    private void s(Context context, AttributeSet attributeSet2, int i3, int i4) {
        Context obj8;
        int obj10;
        final int i5 = 0;
        final TypedArray obj9 = l.h(context, attributeSet2, l.n, i3, i4, new int[i5]);
        C(obj9.getInt(l.w, 4));
        obj10 = l.x;
        if (obj9.hasValue(obj10)) {
            D(obj9.getInt(obj10, i5));
        }
        x(a.t(context, obj9, l.o));
        obj10 = l.r;
        if (obj9.hasValue(obj10)) {
            z(a.t(context, obj9, obj10));
        }
        y(obj9.getInt(l.p, 8388661));
        B(obj9.getDimensionPixelOffset(l.u, i5));
        H(obj9.getDimensionPixelOffset(l.y, i5));
        A(obj9.getDimensionPixelOffset(l.v, k()));
        G(obj9.getDimensionPixelOffset(l.z, q()));
        obj8 = l.q;
        if (obj9.hasValue(obj8)) {
            this.w = (float)obj8;
        }
        obj8 = l.s;
        if (obj9.hasValue(obj8)) {
            this.y = (float)obj8;
        }
        obj8 = l.t;
        if (obj9.hasValue(obj8)) {
            this.x = (float)obj8;
        }
        obj9.recycle();
    }

    private static int t(Context context, TypedArray typedArray2, int i3) {
        return c.a(context, typedArray2, i3).getDefaultColor();
    }

    private void u(f.c.a.e.n.a.b a$b) {
        int i;
        C(a.b.c(b));
        if (a.b.n(b) != -1) {
            D(a.b.n(b));
        }
        x(a.b.p(b));
        z(a.b.r(b));
        y(a.b.t(b));
        B(a.b.v(b));
        H(a.b.y(b));
        A(a.b.A(b));
        G(a.b.C(b));
        v(a.b.d(b));
        w(a.b.g(b));
        I(a.b.a(b));
    }

    @Override // android.graphics.drawable.Drawable
    public void A(int i) {
        a.b.B(this.z, i);
        M();
    }

    @Override // android.graphics.drawable.Drawable
    public void B(int i) {
        a.b.x(this.z, i);
        M();
    }

    @Override // android.graphics.drawable.Drawable
    public void C(int i) {
        int i2;
        int obj2;
        if (a.b.c(this.z) != i) {
            a.b.f(this.z, i);
            N();
            this.c.i(true);
            M();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void D(int i) {
        int i2;
        int obj2;
        obj2 = Math.max(0, i);
        if (a.b.n(this.z) != obj2) {
            a.b.o(this.z, obj2);
            this.c.i(true);
            M();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void G(int i) {
        a.b.D(this.z, i);
        M();
    }

    @Override // android.graphics.drawable.Drawable
    public void H(int i) {
        a.b.z(this.z, i);
        M();
    }

    @Override // android.graphics.drawable.Drawable
    public void I(boolean z) {
        boolean z2;
        boolean obj2;
        setVisible(z, false);
        a.b.b(this.z, z);
        if (b.a && i() != null && !z) {
            if (i() != null) {
                if (!z) {
                    (ViewGroup)i().getParent().invalidate();
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void L(View view, FrameLayout frameLayout2) {
        WeakReference weakReference;
        WeakReference weakReference2 = new WeakReference(view);
        this.G = weakReference2;
        boolean z = b.a;
        if (z && frameLayout2 == null) {
            if (frameLayout2 == null) {
                J(view);
            } else {
                weakReference = new WeakReference(frameLayout2);
                this.H = weakReference;
            }
        } else {
        }
        if (!z) {
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
        boolean visible;
        if (!getBounds().isEmpty() && getAlpha() != 0) {
            if (getAlpha() != 0) {
                if (!isVisible()) {
                } else {
                    this.b.draw(canvas);
                    if (r()) {
                        f(canvas);
                    }
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return a.b.i(this.z);
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
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public java.lang.CharSequence h() {
        int i2 = 0;
        if (!isVisible()) {
            return i2;
        }
        Object obj = this.a.get();
        if (r() && a.b.l(this.z) > 0 && (Context)obj == null) {
            if (a.b.l(this.z) > 0) {
                obj = this.a.get();
                if ((Context)(Context)obj == null) {
                    return i2;
                }
                final int i8 = 0;
                int i9 = 1;
                if (m() <= this.C) {
                    Object[] arr2 = new Object[i9];
                    arr2[i8] = Integer.valueOf(m());
                    return (Context)(Context)obj.getResources().getQuantityString(a.b.l(this.z), m(), arr2);
                }
                Object[] arr = new Object[i9];
                arr[i8] = Integer.valueOf(this.C);
                return obj.getString(a.b.m(this.z), arr);
            }
            return i2;
        }
        return a.b.k(this.z);
    }

    @Override // android.graphics.drawable.Drawable
    public FrameLayout i() {
        Object obj;
        WeakReference weakReference = this.H;
        if (weakReference != null) {
            obj = weakReference.get();
        } else {
            obj = 0;
        }
        return obj;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int j() {
        return a.b.v(this.z);
    }

    @Override // android.graphics.drawable.Drawable
    public int k() {
        return a.b.v(this.z);
    }

    @Override // android.graphics.drawable.Drawable
    public int l() {
        return a.b.c(this.z);
    }

    @Override // android.graphics.drawable.Drawable
    public int m() {
        if (!r()) {
            return 0;
        }
        return a.b.n(this.z);
    }

    @Override // android.graphics.drawable.Drawable
    public f.c.a.e.n.a.b n() {
        return this.z;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int q() {
        return a.b.y(this.z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean r() {
        int i;
        i = a.b.n(this.z) != -1 ? 1 : 0;
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        a.b.j(this.z, i);
        this.c.e().setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    @Override // android.graphics.drawable.Drawable
    void v(int i) {
        a.b.e(this.z, i);
        M();
    }

    @Override // android.graphics.drawable.Drawable
    void w(int i) {
        a.b.h(this.z, i);
        M();
    }

    @Override // android.graphics.drawable.Drawable
    public void x(int i) {
        Object list;
        a.b.q(this.z, i);
        final ColorStateList obj2 = ColorStateList.valueOf(i);
        if (this.b.x() != obj2) {
            this.b.Z(obj2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void y(int i) {
        int i2;
        int obj2;
        a.b.u(this.z, i);
        obj2 = this.G;
        if (a.b.t(this.z) != i && obj2 != null && obj2.get() != null) {
            a.b.u(this.z, i);
            obj2 = this.G;
            if (obj2 != null) {
                if (obj2.get() != null) {
                    WeakReference weakReference = this.H;
                    if (weakReference != null) {
                        i2 = weakReference.get();
                    } else {
                        i2 = 0;
                    }
                    L((View)this.G.get(), i2);
                }
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void z(int i) {
        int color;
        a.b.s(this.z, i);
        if (this.c.e().getColor() != i) {
            this.c.e().setColor(i);
            invalidateSelf();
        }
    }
}
