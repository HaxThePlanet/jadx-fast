package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import d.d.a;
import d.d.b;
import d.d.d;
import d.d.e;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {

    private static final int[] COLOR_BACKGROUND_ATTR;
    private static final androidx.cardview.widget.e IMPL;
    private final androidx.cardview.widget.d mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    class a implements androidx.cardview.widget.d {

        private Drawable a;
        final androidx.cardview.widget.CardView b;
        a(androidx.cardview.widget.CardView cardView) {
            this.b = cardView;
            super();
        }

        @Override // androidx.cardview.widget.d
        public void a(int i, int i2, int i3, int i4) {
            view.mShadowBounds.set(i, i2, i3, i4);
            androidx.cardview.widget.CardView view2 = this.b;
            Rect mContentPadding = view2.mContentPadding;
            CardView.access$001(view2, i += left, i2 += top, i3 += right, i4 += bottom);
        }

        @Override // androidx.cardview.widget.d
        public void b(int i, int i2) {
            androidx.cardview.widget.CardView view = this.b;
            if (i > view.mUserSetMinWidth) {
                CardView.access$101(view, i);
            }
            final androidx.cardview.widget.CardView obj3 = this.b;
            if (i2 > obj3.mUserSetMinHeight) {
                CardView.access$201(obj3, i2);
            }
        }

        @Override // androidx.cardview.widget.d
        public void c(Drawable drawable) {
            this.a = drawable;
            this.b.setBackgroundDrawable(drawable);
        }

        @Override // androidx.cardview.widget.d
        public boolean d() {
            return this.b.getPreventCornerOverlap();
        }

        @Override // androidx.cardview.widget.d
        public boolean e() {
            return this.b.getUseCompatPadding();
        }

        @Override // androidx.cardview.widget.d
        public Drawable f() {
            return this.a;
        }

        @Override // androidx.cardview.widget.d
        public View g() {
            return this.b;
        }
    }
    static {
        Object bVar;
        int i;
        int[] iArr = new int[1];
        CardView.COLOR_BACKGROUND_ATTR = iArr;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 21) {
            bVar = new b();
            CardView.IMPL = bVar;
        } else {
            if (sDK_INT >= 17) {
                bVar = new a();
                CardView.IMPL = bVar;
            } else {
                bVar = new c();
                CardView.IMPL = bVar;
            }
        }
        CardView.IMPL.j();
    }

    public CardView(Context context) {
        super(context, 0);
    }

    public CardView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.a);
    }

    public CardView(Context context, AttributeSet attributeSet2, int i3) {
        int value;
        float f;
        int obj12;
        super(context, attributeSet2, i3);
        Rect rect = new Rect();
        this.mContentPadding = rect;
        Rect rect2 = new Rect();
        this.mShadowBounds = rect2;
        CardView.a aVar = new CardView.a(this);
        this.mCardViewDelegate = aVar;
        final TypedArray obj11 = context.obtainStyledAttributes(attributeSet2, e.a, i3, d.a);
        obj12 = e.d;
        int i9 = 0;
        if (obj11.hasValue(obj12)) {
            obj12 = obj11.getColorStateList(obj12);
        } else {
            obj12 = getContext().obtainStyledAttributes(CardView.COLOR_BACKGROUND_ATTR);
            obj12.recycle();
            obj12 = new float[3];
            Color.colorToHSV(obj12.getColor(i9, i9), obj12);
            if (Float.compare(obj12, i2) > 0) {
                obj12 = getResources().getColor(b.b);
            } else {
                obj12 = getResources().getColor(b.a);
            }
            obj12 = ColorStateList.valueOf(obj12);
        }
        int i4 = 0;
        final float dimension2 = obj11.getDimension(e.f, i4);
        obj12 = obj11.getDimension(e.g, i4);
        this.mCompatPadding = obj11.getBoolean(e.i, i9);
        this.mPreventCornerOverlap = obj11.getBoolean(e.h, true);
        int dimensionPixelSize = obj11.getDimensionPixelSize(e.j, i9);
        rect.left = obj11.getDimensionPixelSize(e.l, dimensionPixelSize);
        rect.top = obj11.getDimensionPixelSize(e.n, dimensionPixelSize);
        rect.right = obj11.getDimensionPixelSize(e.m, dimensionPixelSize);
        rect.bottom = obj11.getDimensionPixelSize(e.k, dimensionPixelSize);
        f = Float.compare(dimension2, obj12) > 0 ? dimension2 : obj12;
        this.mUserSetMinWidth = obj11.getDimensionPixelSize(e.b, i9);
        this.mUserSetMinHeight = obj11.getDimensionPixelSize(e.c, i9);
        obj11.recycle();
        CardView.IMPL.a(aVar, context, obj12, obj11.getDimension(e.e, i4), dimension2, f);
    }

    static void access$001(androidx.cardview.widget.CardView cardView, int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
    }

    static void access$101(androidx.cardview.widget.CardView cardView, int i2) {
        super.setMinimumWidth(i2);
    }

    static void access$201(androidx.cardview.widget.CardView cardView, int i2) {
        super.setMinimumHeight(i2);
    }

    @Override // android.widget.FrameLayout
    public ColorStateList getCardBackgroundColor() {
        return CardView.IMPL.h(this.mCardViewDelegate);
    }

    @Override // android.widget.FrameLayout
    public float getCardElevation() {
        return CardView.IMPL.c(this.mCardViewDelegate);
    }

    @Override // android.widget.FrameLayout
    public int getContentPaddingBottom() {
        return mContentPadding.bottom;
    }

    @Override // android.widget.FrameLayout
    public int getContentPaddingLeft() {
        return mContentPadding.left;
    }

    @Override // android.widget.FrameLayout
    public int getContentPaddingRight() {
        return mContentPadding.right;
    }

    @Override // android.widget.FrameLayout
    public int getContentPaddingTop() {
        return mContentPadding.top;
    }

    @Override // android.widget.FrameLayout
    public float getMaxCardElevation() {
        return CardView.IMPL.g(this.mCardViewDelegate);
    }

    @Override // android.widget.FrameLayout
    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    @Override // android.widget.FrameLayout
    public float getRadius() {
        return CardView.IMPL.d(this.mCardViewDelegate);
    }

    @Override // android.widget.FrameLayout
    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    @Override // android.widget.FrameLayout
    protected void onMeasure(int i, int i2) {
        androidx.cardview.widget.e iMPL;
        boolean mode;
        int ceil;
        int i3;
        int i4;
        int obj7;
        int obj8;
        iMPL = CardView.IMPL;
        if (!iMPL instanceof b) {
            int mode2 = View.MeasureSpec.getMode(i);
            ceil = 1073741824;
            i3 = Integer.MIN_VALUE;
            if (mode2 != i3 && mode2 != ceil) {
                if (mode2 != ceil) {
                } else {
                    obj7 = View.MeasureSpec.makeMeasureSpec(Math.max((int)ceil2, View.MeasureSpec.getSize(i)), mode2);
                }
            } else {
            }
            mode = View.MeasureSpec.getMode(i2);
            if (mode != i3 && mode != ceil) {
                if (mode != ceil) {
                } else {
                    obj8 = View.MeasureSpec.makeMeasureSpec(Math.max((int)ceil, View.MeasureSpec.getSize(i2)), mode);
                }
            } else {
            }
            super.onMeasure(obj7, obj8);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.FrameLayout
    public void setCardBackgroundColor(int i) {
        CardView.IMPL.n(this.mCardViewDelegate, ColorStateList.valueOf(i));
    }

    @Override // android.widget.FrameLayout
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        CardView.IMPL.n(this.mCardViewDelegate, colorStateList);
    }

    @Override // android.widget.FrameLayout
    public void setCardElevation(float f) {
        CardView.IMPL.f(this.mCardViewDelegate, f);
    }

    @Override // android.widget.FrameLayout
    public void setContentPadding(int i, int i2, int i3, int i4) {
        this.mContentPadding.set(i, i2, i3, i4);
        CardView.IMPL.i(this.mCardViewDelegate);
    }

    @Override // android.widget.FrameLayout
    public void setMaxCardElevation(float f) {
        CardView.IMPL.o(this.mCardViewDelegate, f);
    }

    @Override // android.widget.FrameLayout
    public void setMinimumHeight(int i) {
        this.mUserSetMinHeight = i;
        super.setMinimumHeight(i);
    }

    @Override // android.widget.FrameLayout
    public void setMinimumWidth(int i) {
        this.mUserSetMinWidth = i;
        super.setMinimumWidth(i);
    }

    @Override // android.widget.FrameLayout
    public void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.widget.FrameLayout
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    @Override // android.widget.FrameLayout
    public void setPreventCornerOverlap(boolean z) {
        boolean mPreventCornerOverlap;
        boolean obj2;
        if (z != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z;
            CardView.IMPL.m(this.mCardViewDelegate);
        }
    }

    @Override // android.widget.FrameLayout
    public void setRadius(float f) {
        CardView.IMPL.b(this.mCardViewDelegate, f);
    }

    @Override // android.widget.FrameLayout
    public void setUseCompatPadding(boolean z) {
        boolean mCardViewDelegate;
        boolean obj2;
        if (this.mCompatPadding != z) {
            this.mCompatPadding = z;
            CardView.IMPL.e(this.mCardViewDelegate);
        }
    }
}
