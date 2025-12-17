package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.c;
import androidx.core.widget.h;
import d.a.a;
import d.a.l.a.c;
import d.h.l.z;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
class b0 extends ListView {

    private boolean A;
    private boolean B;
    private boolean C;
    private z D;
    private h E;
    androidx.appcompat.widget.b0.b F;
    private final Rect a;
    private int b = 0;
    private int c = 0;
    private int v = 0;
    private int w = 0;
    private int x;
    private Field y;
    private androidx.appcompat.widget.b0.a z;

    private class b implements Runnable {

        final androidx.appcompat.widget.b0 a;
        b(androidx.appcompat.widget.b0 b0) {
            this.a = b0;
            super();
        }

        @Override // java.lang.Runnable
        public void a() {
            final androidx.appcompat.widget.b0 b0Var = this.a;
            b0Var.F = 0;
            b0Var.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void b() {
            this.a.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            final androidx.appcompat.widget.b0 b0Var = this.a;
            b0Var.F = 0;
            b0Var.drawableStateChanged();
        }
    }

    private static class a extends c {

        private boolean b = true;
        a(Drawable drawable) {
            super(drawable);
            final int obj1 = 1;
        }

        @Override // d.a.l.a.c
        void c(boolean z) {
            this.b = z;
        }

        @Override // d.a.l.a.c
        public void draw(Canvas canvas) {
            if (this.b) {
                super.draw(canvas);
            }
        }

        @Override // d.a.l.a.c
        public void setHotspot(float f, float f2) {
            if (this.b) {
                super.setHotspot(f, f2);
            }
        }

        @Override // d.a.l.a.c
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.b) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // d.a.l.a.c
        public boolean setState(int[] iArr) {
            if (this.b) {
                return super.setState(iArr);
            }
            return 0;
        }

        @Override // d.a.l.a.c
        public boolean setVisible(boolean z, boolean z2) {
            if (this.b) {
                return super.setVisible(z, z2);
            }
            return 0;
        }
    }
    b0(Context context, boolean z2) {
        Field obj3;
        super(context, 0, a.A);
        obj3 = new Rect();
        this.a = obj3;
        this.B = z2;
        setCacheColorHint(0);
        obj3 = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
        this.y = obj3;
        obj3.setAccessible(true);
    }

    private void a() {
        z zVar;
        int i = 0;
        this.C = i;
        setPressed(i);
        drawableStateChanged();
        View childAt = getChildAt(i2 -= firstVisiblePosition);
        if (childAt != null) {
            childAt.setPressed(i);
        }
        zVar = this.D;
        if (zVar != null) {
            zVar.b();
            this.D = 0;
        }
    }

    private void b(View view, int i2) {
        performItemClick(view, i2, getItemIdAtPosition(i2));
    }

    private void c(Canvas canvas) {
        boolean selector;
        Rect rect;
        selector = getSelector();
        if (!this.a.isEmpty() && selector != null) {
            selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.a);
                selector.draw(canvas);
            }
        }
    }

    private void f(int i, View view2) {
        boolean valueOf;
        int i2;
        int obj6;
        boolean obj7;
        Rect rect = this.a;
        rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
        rect.left = left2 -= i7;
        rect.top = top -= i8;
        rect.right = right += i9;
        rect.bottom = bottom += i10;
        valueOf = this.y.getBoolean(this);
        if (view2.isEnabled() != valueOf) {
            i2 = !valueOf ? 1 : 0;
            this.y.set(this, Boolean.valueOf(i2));
            if (i != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i, View view2) {
        int i3;
        int i2;
        int visibility;
        int obj5;
        View obj6;
        final Drawable selector = getSelector();
        final int i4 = 0;
        if (selector != null && i != -1) {
            visibility = i != -1 ? i3 : i4;
        } else {
        }
        if (visibility != 0) {
            selector.setVisible(i4, i4);
        }
        f(i, view2);
        if (visibility != 0) {
            obj5 = this.a;
            if (getVisibility() == 0) {
            } else {
                i3 = i4;
            }
            selector.setVisible(i3, i4);
            a.k(selector, obj5.exactCenterX(), obj5.exactCenterY());
        }
    }

    private void h(int i, View view2, float f3, float f4) {
        int i2;
        g(i, view2);
        final Drawable obj3 = getSelector();
        if (obj3 != null && i != -1) {
            if (i != -1) {
                a.k(obj3, f3, f4);
            }
        }
    }

    private void i(View view, int i2, float f3, float f4) {
        int childAt;
        int firstVisiblePosition;
        final int i = 1;
        this.C = i;
        int sDK_INT = Build.VERSION.SDK_INT;
        final int i3 = 21;
        if (sDK_INT >= i3) {
            drawableHotspotChanged(f3, f4);
        }
        if (!isPressed()) {
            setPressed(i);
        }
        layoutChildren();
        childAt = this.x;
        final int i7 = 0;
        childAt = getChildAt(childAt -= firstVisiblePosition);
        if (childAt != -1 && childAt != null && childAt != view && childAt.isPressed()) {
            childAt = getChildAt(childAt -= firstVisiblePosition);
            if (childAt != null) {
                if (childAt != view) {
                    if (childAt.isPressed()) {
                        childAt.setPressed(i7);
                    }
                }
            }
        }
        this.x = i2;
        if (sDK_INT >= i3) {
            view.drawableHotspotChanged(f3 - f, f4 - f2);
        }
        if (!view.isPressed()) {
            view.setPressed(i);
        }
        h(i2, view, f3, f4);
        setSelectorEnabled(i7);
        refreshDrawableState();
    }

    private boolean j() {
        return this.C;
    }

    private void k() {
        boolean drawableState;
        final Drawable selector = getSelector();
        if (selector != null && j() && isPressed()) {
            if (j()) {
                if (isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        }
    }

    private void setSelectorEnabled(boolean z) {
        final androidx.appcompat.widget.b0.a aVar = this.z;
        if (aVar != null) {
            aVar.c(z);
        }
    }

    @Override // android.widget.ListView
    public int d(int i, int i2, int i3, int i4, int i5) {
        int dividerHeight;
        int i7;
        int i8;
        int view;
        int i6;
        int measuredHeight;
        android.view.ViewGroup.LayoutParams defaultLayoutParams;
        int measureSpec;
        int i9;
        int obj12;
        int obj14;
        obj12 = getListPaddingTop();
        int obj13 = getListPaddingBottom();
        final ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return obj12 += obj13;
        }
        obj12 += obj13;
        obj13 = 0;
        if (getDividerHeight() > 0 && getDivider() != null) {
            if (getDivider() != null) {
            } else {
                dividerHeight = obj13;
            }
        } else {
        }
        final int i10 = 0;
        i6 = i8;
        view = i10;
        while (i7 < adapter.getCount()) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
            }
            view = adapter.getView(i7, view, this);
            if (view.getLayoutParams() == null) {
            }
            int height = defaultLayoutParams.height;
            if (height > 0) {
            } else {
            }
            measureSpec = View.MeasureSpec.makeMeasureSpec(obj13, obj13);
            view.measure(i, measureSpec);
            view.forceLayout();
            if (i7 > 0) {
            }
            obj12 += measuredHeight;
            if (i5 >= 0 && i7 >= i5) {
            }
            i7++;
            if (i7 >= i5) {
            }
            i6 = obj12;
            obj12 += dividerHeight;
            measureSpec = View.MeasureSpec.makeMeasureSpec(height, 1073741824);
            view.setLayoutParams(generateDefaultLayoutParams());
            view = i10;
            i8 = itemViewType;
        }
        return obj12;
    }

    @Override // android.widget.ListView
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.ListView
    protected void drawableStateChanged() {
        if (this.F != null) {
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        k();
    }

    @Override // android.widget.ListView
    public boolean e(MotionEvent motionEvent, int i2) {
        int childAt;
        float f;
        int pointToPosition;
        int i;
        Object obj8;
        int obj9;
        final int actionMasked = motionEvent.getActionMasked();
        final int i3 = 0;
        final int i4 = 1;
        if (actionMasked != i4 && actionMasked != 2) {
            if (actionMasked != 2) {
                childAt = actionMasked != 3 ? i4 : obj9;
            } else {
            }
        } else {
        }
        if (childAt != 0) {
            if (obj9 != null) {
                a();
            }
        } else {
        }
        if (childAt != 0) {
            if (this.E == null) {
                obj9 = new h(this);
                this.E = obj9;
            }
            this.E.m(i4);
            this.E.onTouch(this, motionEvent);
        } else {
            obj8 = this.E;
            if (obj8 != null) {
                obj8.m(i3);
            }
        }
        return childAt;
    }

    @Override // android.widget.ListView
    public boolean hasFocus() {
        int i;
        boolean focus;
        if (!this.B) {
            if (super.hasFocus()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.widget.ListView
    public boolean hasWindowFocus() {
        int i;
        boolean windowFocus;
        if (!this.B) {
            if (super.hasWindowFocus()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.widget.ListView
    public boolean isFocused() {
        int i;
        boolean focused;
        if (!this.B) {
            if (super.isFocused()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // android.widget.ListView
    public boolean isInTouchMode() {
        boolean inTouchMode;
        int i;
        if (this.B) {
            if (!this.A) {
                i = super.isInTouchMode() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // android.widget.ListView
    protected void onDetachedFromWindow() {
        this.F = 0;
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ListView
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int selectedItemPosition;
        int bVar;
        int enabled;
        MotionEvent obj5;
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        selectedItemPosition = motionEvent.getActionMasked();
        if (selectedItemPosition == 10 && this.F == null) {
            if (this.F == null) {
                bVar = new b0.b(this);
                this.F = bVar;
                bVar.b();
            }
        }
        final int i3 = -1;
        if (selectedItemPosition != 9) {
            if (selectedItemPosition == 7) {
                obj5 = pointToPosition((int)f, (int)obj5);
                selectedItemPosition = getChildAt(obj5 - firstVisiblePosition);
                if (obj5 != i3 && obj5 != getSelectedItemPosition() && selectedItemPosition.isEnabled()) {
                    if (obj5 != getSelectedItemPosition()) {
                        selectedItemPosition = getChildAt(obj5 - firstVisiblePosition);
                        if (selectedItemPosition.isEnabled()) {
                            setSelectionFromTop(obj5, top -= enabled);
                        }
                        k();
                    }
                }
            } else {
                setSelection(i3);
            }
        } else {
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.widget.ListView
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int pointToPosition;
        int i;
        if (motionEvent.getAction() != 0) {
        } else {
            this.x = pointToPosition((int)f, (int)f2);
        }
        androidx.appcompat.widget.b0.b bVar = this.F;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ListView
    void setListSelectionHidden(boolean z) {
        this.A = z;
    }

    @Override // android.widget.ListView
    public void setSelector(Drawable drawable) {
        androidx.appcompat.widget.b0.a aVar;
        if (drawable != null) {
            aVar = new b0.a(drawable);
        } else {
            aVar = 0;
        }
        this.z = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.b = rect.left;
        this.c = rect.top;
        this.v = rect.right;
        this.w = rect.bottom;
    }
}
