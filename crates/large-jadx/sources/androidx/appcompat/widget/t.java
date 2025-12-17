package androidx.appcompat.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.c;
import androidx.appcompat.app.c.a;
import androidx.appcompat.app.h;
import androidx.appcompat.view.menu.p;
import d.a.a;
import d.a.g;
import d.a.j;
import d.a.k.a.a;
import d.a.o.d;
import d.h.l.t;
import d.h.l.u;

/* loaded from: classes.dex */
public class t extends Spinner implements t {

    private static final int[] A;
    private final androidx.appcompat.widget.e a;
    private final Context b;
    private androidx.appcompat.widget.d0 c;
    private SpinnerAdapter v;
    private final boolean w;
    private androidx.appcompat.widget.t.g x;
    int y;
    final Rect z;

    class b implements ViewTreeObserver.OnGlobalLayoutListener {

        final androidx.appcompat.widget.t a;
        b(androidx.appcompat.widget.t t) {
            this.a = t;
            super();
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            boolean z;
            int sDK_INT;
            int i;
            if (!this.a.getInternalPopup().b()) {
                this.a.b();
            }
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver != null) {
                if (Build.VERSION.SDK_INT >= 16) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                } else {
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
            }
        }
    }

    private static class d implements ListAdapter, SpinnerAdapter {

        private SpinnerAdapter a;
        private ListAdapter b;
        public d(SpinnerAdapter spinnerAdapter, Resources.Theme resources$Theme2) {
            boolean dropDownViewTheme;
            int sDK_INT;
            int i;
            super();
            this.a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter != null) {
                this.b = (ListAdapter)spinnerAdapter;
            }
            if (theme2 != null) {
                if (Build.VERSION.SDK_INT >= 23 && spinnerAdapter instanceof ThemedSpinnerAdapter != null) {
                    if (spinnerAdapter instanceof ThemedSpinnerAdapter != null) {
                        if ((ThemedSpinnerAdapter)spinnerAdapter.getDropDownViewTheme() != theme2) {
                            spinnerAdapter.setDropDownViewTheme(theme2);
                        }
                    } else {
                        if (spinnerAdapter instanceof p0 && (p0)spinnerAdapter.getDropDownViewTheme() == null) {
                            if ((p0)spinnerAdapter.getDropDownViewTheme() == null) {
                                spinnerAdapter.setDropDownViewTheme(theme2);
                            }
                        }
                    }
                } else {
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter list = this.b;
            if (list != null) {
                return list.areAllItemsEnabled();
            }
            return 1;
        }

        @Override // android.widget.ListAdapter
        public int getCount() {
            int count;
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                count = 0;
            } else {
                count = spinnerAdapter.getCount();
            }
            return count;
        }

        @Override // android.widget.ListAdapter
        public View getDropDownView(int i, View view2, ViewGroup viewGroup3) {
            int obj2;
            final SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                obj2 = 0;
            } else {
                obj2 = spinnerAdapter.getDropDownView(i, view2, viewGroup3);
            }
            return obj2;
        }

        @Override // android.widget.ListAdapter
        public Object getItem(int i) {
            int obj2;
            final SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                obj2 = 0;
            } else {
                obj2 = spinnerAdapter.getItem(i);
            }
            return obj2;
        }

        @Override // android.widget.ListAdapter
        public long getItemId(int i) {
            int itemId;
            SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter == null) {
                itemId = -1;
            } else {
                itemId = spinnerAdapter.getItemId(i);
            }
            return itemId;
        }

        @Override // android.widget.ListAdapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.ListAdapter
        public View getView(int i, View view2, ViewGroup viewGroup3) {
            return getDropDownView(i, view2, viewGroup3);
        }

        @Override // android.widget.ListAdapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.ListAdapter
        public boolean hasStableIds() {
            SpinnerAdapter stableIds;
            int i;
            stableIds = this.a;
            if (stableIds != null && stableIds.hasStableIds()) {
                i = stableIds.hasStableIds() ? 1 : 0;
            } else {
            }
            return i;
        }

        @Override // android.widget.ListAdapter
        public boolean isEmpty() {
            int i;
            i = getCount() == 0 ? 1 : 0;
            return i;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            final ListAdapter list = this.b;
            if (list != null) {
                return list.isEnabled(i);
            }
            return 1;
        }

        @Override // android.widget.ListAdapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            final SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            final SpinnerAdapter spinnerAdapter = this.a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    static class f extends View.BaseSavedState {

        public static final Parcelable.Creator<androidx.appcompat.widget.t.f> CREATOR;
        boolean a;
        static {
            t.f.a aVar = new t.f.a();
            t.f.CREATOR = aVar;
        }

        f(Parcel parcel) {
            int obj1;
            super(parcel);
            obj1 = parcel.readByte() != 0 ? 1 : 0;
            this.a = obj1;
        }

        f(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View$BaseSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte((byte)obj2);
        }
    }

    interface g {
        public abstract boolean b();

        public abstract void c(Drawable drawable);

        public abstract int d();

        public abstract void dismiss();

        public abstract void f(int i);

        public abstract java.lang.CharSequence g();

        public abstract Drawable i();

        public abstract void j(java.lang.CharSequence charSequence);

        public abstract void l(int i);

        public abstract void m(int i);

        public abstract void n(int i, int i2);

        public abstract int o();

        public abstract void p(ListAdapter listAdapter);
    }

    class a extends androidx.appcompat.widget.d0 {

        final androidx.appcompat.widget.t.e B;
        final androidx.appcompat.widget.t C;
        a(androidx.appcompat.widget.t t, View view2, androidx.appcompat.widget.t.e t$e3) {
            this.C = t;
            this.B = e3;
            super(view2);
        }

        @Override // androidx.appcompat.widget.d0
        public p b() {
            return this.B;
        }

        @Override // androidx.appcompat.widget.d0
        public boolean c() {
            boolean z;
            if (!this.C.getInternalPopup().b()) {
                this.C.b();
            }
            return 1;
        }
    }

    class c implements androidx.appcompat.widget.t.g, DialogInterface.OnClickListener {

        c a;
        private ListAdapter b;
        private java.lang.CharSequence c;
        final androidx.appcompat.widget.t v;
        c(androidx.appcompat.widget.t t) {
            this.v = t;
            super();
        }

        @Override // androidx.appcompat.widget.t$g
        public boolean b() {
            boolean showing;
            c cVar = this.a;
            if (cVar != null) {
                showing = cVar.isShowing();
            } else {
                showing = 0;
            }
            return showing;
        }

        @Override // androidx.appcompat.widget.t$g
        public void c(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.t$g
        public int d() {
            return 0;
        }

        @Override // androidx.appcompat.widget.t$g
        public void dismiss() {
            c cVar;
            cVar = this.a;
            if (cVar != null) {
                cVar.dismiss();
                this.a = 0;
            }
        }

        @Override // androidx.appcompat.widget.t$g
        public void f(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.t$g
        public java.lang.CharSequence g() {
            return this.c;
        }

        @Override // androidx.appcompat.widget.t$g
        public Drawable i() {
            return null;
        }

        @Override // androidx.appcompat.widget.t$g
        public void j(java.lang.CharSequence charSequence) {
            this.c = charSequence;
        }

        @Override // androidx.appcompat.widget.t$g
        public void l(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.t$g
        public void m(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.t$g
        public void n(int i, int i2) {
            if (this.b == null) {
            }
            c.a aVar = new c.a(this.v.getPopupContext());
            java.lang.CharSequence charSequence = this.c;
            if (charSequence != null) {
                aVar.setTitle(charSequence);
            }
            aVar.l(this.b, this.v.getSelectedItemPosition(), this);
            c create = aVar.create();
            this.a = create;
            ListView list2 = create.a();
            if (Build.VERSION.SDK_INT >= 17) {
                list2.setTextDirection(i);
                list2.setTextAlignment(i2);
            }
            this.a.show();
        }

        @Override // androidx.appcompat.widget.t$g
        public int o() {
            return 0;
        }

        @Override // androidx.appcompat.widget.t$g
        public void onClick(DialogInterface dialogInterface, int i2) {
            int i;
            long itemId;
            Object obj4;
            this.v.setSelection(i2);
            if (this.v.getOnItemClickListener() != null) {
                this.v.performItemClick(0, i2, this.b.getItemId(i2));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.t$g
        public void p(ListAdapter listAdapter) {
            this.b = listAdapter;
        }
    }

    class e extends androidx.appcompat.widget.f0 implements androidx.appcompat.widget.t.g {

        private java.lang.CharSequence a0;
        ListAdapter b0;
        private final Rect c0;
        private int d0;
        final androidx.appcompat.widget.t e0;
        public e(androidx.appcompat.widget.t t, Context context2, AttributeSet attributeSet3, int i4) {
            this.e0 = t;
            super(context2, attributeSet3, i4);
            Rect obj2 = new Rect();
            this.c0 = obj2;
            D(t);
            J(true);
            O(0);
            obj2 = new t.e.a(this, t);
            L(obj2);
        }

        static void R(androidx.appcompat.widget.t.e t$e) {
            super.a();
        }

        @Override // androidx.appcompat.widget.f0
        void S() {
            int right;
            int i2;
            int i3;
            int i6;
            int paddingRight;
            int width;
            int i5;
            int i;
            int i4;
            int right2;
            int left;
            Drawable drawable = i();
            i3 = 0;
            if (drawable != null) {
                drawable.getPadding(tVar6.z);
                if (z0.b(this.e0)) {
                    right = rect2.right;
                } else {
                    right = -left2;
                }
                i3 = right;
            } else {
                right = tVar5.z;
                right.right = i3;
                right.left = i3;
            }
            int paddingLeft = this.e0.getPaddingLeft();
            paddingRight = this.e0.getPaddingRight();
            width = this.e0.getWidth();
            androidx.appcompat.widget.t tVar9 = this.e0;
            i4 = tVar9.y;
            if (i4 == -2) {
                Rect rect4 = tVar12.z;
                i11 -= right2;
                if (tVar9.a((SpinnerAdapter)this.b0, i()) > i12) {
                    i5 = i12;
                }
                F(Math.max(i5, i13 -= paddingRight));
            } else {
                if (i4 == -1) {
                    F(i10 -= paddingRight);
                } else {
                    F(i4);
                }
            }
            if (z0.b(this.e0)) {
                i3 += width;
            } else {
                i3 += i2;
            }
            f(i6);
        }

        @Override // androidx.appcompat.widget.f0
        public int T() {
            return this.d0;
        }

        @Override // androidx.appcompat.widget.f0
        boolean U(View view) {
            boolean z;
            View obj2;
            if (u.Q(view) && view.getGlobalVisibleRect(this.c0)) {
                obj2 = view.getGlobalVisibleRect(this.c0) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // androidx.appcompat.widget.f0
        public java.lang.CharSequence g() {
            return this.a0;
        }

        @Override // androidx.appcompat.widget.f0
        public void j(java.lang.CharSequence charSequence) {
            this.a0 = charSequence;
        }

        @Override // androidx.appcompat.widget.f0
        public void m(int i) {
            this.d0 = i;
        }

        @Override // androidx.appcompat.widget.f0
        public void n(int i, int i2) {
            Object obj5;
            int obj6;
            S();
            I(2);
            super.a();
            ListView list = k();
            list.setChoiceMode(1);
            if (Build.VERSION.SDK_INT >= 17) {
                list.setTextDirection(i);
                list.setTextAlignment(i2);
            }
            P(this.e0.getSelectedItemPosition());
            if (b()) {
            }
            obj5 = this.e0.getViewTreeObserver();
            if (obj5 != null) {
                obj6 = new t.e.b(this);
                obj5.addOnGlobalLayoutListener(obj6);
                obj5 = new t.e.c(this, obj6);
                K(obj5);
            }
        }

        @Override // androidx.appcompat.widget.f0
        public void p(ListAdapter listAdapter) {
            super.p(listAdapter);
            this.b0 = listAdapter;
        }
    }
    static {
        int[] iArr = new int[1];
        t.A = iArr;
    }

    public t(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.L);
    }

    public t(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3, -1);
    }

    public t(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4, 0);
    }

    public t(Context context, AttributeSet attributeSet2, int i3, int i4, Resources.Theme resources$Theme5) {
        androidx.appcompat.widget.t.a arrayAdapter;
        Resources.Theme theme;
        Object eVar;
        Throwable value;
        String str2;
        String str;
        Context obj7;
        int obj10;
        Resources.Theme obj11;
        super(context, attributeSet2, i3);
        Rect rect = new Rect();
        this.z = rect;
        o0.a(this, getContext());
        arrayAdapter = 0;
        androidx.appcompat.widget.t0 t0Var = t0.v(context, attributeSet2, j.o2, i3, arrayAdapter);
        eVar = new e(this);
        this.a = eVar;
        if (theme5 != null) {
            eVar = new d(context, theme5);
            this.b = eVar;
        } else {
            obj11 = t0Var.n(j.t2, arrayAdapter);
            if (obj11 != null) {
                eVar = new d(context, obj11);
                this.b = eVar;
            } else {
                this.b = context;
            }
        }
        obj11 = context.obtainStyledAttributes(attributeSet2, t.A, i3, arrayAdapter);
        if (i4 == -1 && obj11.hasValue(arrayAdapter)) {
            obj11 = context.obtainStyledAttributes(attributeSet2, t.A, i3, arrayAdapter);
            if (obj11.hasValue(arrayAdapter)) {
                obj10 = obj11.getInt(arrayAdapter, arrayAdapter);
            }
            if (obj11 != null) {
                obj11.recycle();
            }
        }
        obj11 = 1;
        if (obj10 != null) {
            if (obj10 != obj11) {
            } else {
                obj10 = new t.e(this, this.b, attributeSet2, i3);
                androidx.appcompat.widget.t0 t0Var2 = t0.v(this.b, attributeSet2, j.o2, i3, arrayAdapter);
                this.y = t0Var2.m(j.s2, -2);
                obj10.c(t0Var2.g(j.q2));
                obj10.j(t0Var.o(j.r2));
                t0Var2.w();
                this.x = obj10;
                arrayAdapter = new t.a(this, this, obj10);
                this.c = arrayAdapter;
            }
        } else {
            obj10 = new t.c(this);
            this.x = obj10;
            obj10.j(t0Var.o(j.r2));
        }
        obj10 = t0Var.q(j.p2);
        if (obj10 != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, obj10);
            arrayAdapter.setDropDownViewResource(g.t);
            setAdapter(arrayAdapter);
        }
        t0Var.w();
        this.w = obj11;
        obj7 = this.v;
        if (obj7 != null) {
            setAdapter(obj7);
            this.v = 0;
        }
        this.a.e(attributeSet2, i3);
    }

    @Override // android.widget.Spinner
    int a(SpinnerAdapter spinnerAdapter, Drawable drawable2) {
        int i;
        int i3;
        int i2;
        int view;
        int measuredWidth;
        ViewGroup.LayoutParams layoutParams;
        int i4;
        int obj11;
        int obj12;
        i = 0;
        if (spinnerAdapter == null) {
            return i;
        }
        int i5 = Math.max(i, getSelectedItemPosition());
        int i8 = Math.min(spinnerAdapter.getCount(), i5 + 15);
        int i12 = 0;
        i2 = i7;
        view = i12;
        i3 = i;
        while (i2 < i8) {
            int itemViewType = spinnerAdapter.getItemViewType(i2);
            if (itemViewType != i) {
            }
            view = spinnerAdapter.getView(i2, view, this);
            if (view.getLayoutParams() == null) {
            }
            view.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), i), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), i));
            i3 = Math.max(i3, view.getMeasuredWidth());
            i2++;
            i4 = -2;
            layoutParams = new ViewGroup.LayoutParams(i4, i4);
            view.setLayoutParams(layoutParams);
            view = i12;
            i = itemViewType;
        }
        if (drawable2 != null) {
            drawable2.getPadding(this.z);
            obj11 = this.z;
            i3 += obj12;
        }
        return i3;
    }

    @Override // android.widget.Spinner
    void b() {
        androidx.appcompat.widget.t.g gVar;
        int textDirection;
        int textAlignment;
        if (Build.VERSION.SDK_INT >= 17) {
            this.x.n(getTextDirection(), getTextAlignment());
        } else {
            textDirection = -1;
            this.x.n(textDirection, textDirection);
        }
    }

    @Override // android.widget.Spinner
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        androidx.appcompat.widget.t.g gVar = this.x;
        if (gVar != null) {
            return gVar.d();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        androidx.appcompat.widget.t.g gVar = this.x;
        if (gVar != null) {
            return gVar.o();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.x != null) {
            return this.y;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    final androidx.appcompat.widget.t.g getInternalPopup() {
        return this.x;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        androidx.appcompat.widget.t.g gVar = this.x;
        if (gVar != null) {
            return gVar.i();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.b;
    }

    @Override // android.widget.Spinner
    public java.lang.CharSequence getPrompt() {
        java.lang.CharSequence prompt;
        androidx.appcompat.widget.t.g gVar = this.x;
        if (gVar != null) {
            prompt = gVar.g();
        } else {
            prompt = super.getPrompt();
        }
        return prompt;
    }

    @Override // android.widget.Spinner
    public ColorStateList getSupportBackgroundTintList() {
        ColorStateList list;
        androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            list = eVar.c();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // android.widget.Spinner
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            mode = eVar.d();
        } else {
            mode = 0;
        }
        return mode;
    }

    @Override // android.widget.Spinner
    protected void onDetachedFromWindow() {
        androidx.appcompat.widget.t.g gVar;
        super.onDetachedFromWindow();
        gVar = this.x;
        if (gVar != null && gVar.b()) {
            if (gVar.b()) {
                this.x.dismiss();
            }
        }
    }

    @Override // android.widget.Spinner
    protected void onMeasure(int i, int i2) {
        int i3;
        Drawable background;
        int obj3;
        androidx.appcompat.widget.t.g obj4;
        super.onMeasure(i, i2);
        if (this.x != null && View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
                setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
            }
        }
    }

    @Override // android.widget.Spinner
    public void onRestoreInstanceState(Parcelable parcelable) {
        Object superState;
        boolean obj2;
        super.onRestoreInstanceState((t.f)parcelable.getSuperState());
        obj2 = getViewTreeObserver();
        if (parcelable.a && obj2 != null) {
            obj2 = getViewTreeObserver();
            if (obj2 != null) {
                superState = new t.b(this);
                obj2.addOnGlobalLayoutListener(superState);
            }
        }
    }

    @Override // android.widget.Spinner
    public Parcelable onSaveInstanceState() {
        androidx.appcompat.widget.t.g gVar;
        int i;
        t.f fVar = new t.f(super.onSaveInstanceState());
        gVar = this.x;
        if (gVar != null && gVar.b()) {
            i = gVar.b() ? 1 : 0;
        } else {
        }
        fVar.a = i;
        return fVar;
    }

    @Override // android.widget.Spinner
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.appcompat.widget.d0 onTouch;
        onTouch = this.c;
        if (onTouch != null && onTouch.onTouch(this, motionEvent)) {
            if (onTouch.onTouch(this, motionEvent)) {
                return 1;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.Spinner
    public boolean performClick() {
        androidx.appcompat.widget.t.g gVar = this.x;
        if (gVar != null && !gVar.b()) {
            if (!gVar.b()) {
                b();
            }
            return 1;
        }
        return super.performClick();
    }

    @Override // android.widget.Spinner
    public void setAdapter(Adapter adapter) {
        setAdapter((SpinnerAdapter)adapter);
    }

    @Override // android.widget.Spinner
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        Context context;
        Object theme;
        androidx.appcompat.widget.t.g gVar;
        androidx.appcompat.widget.t.d dVar;
        if (!this.w) {
            this.v = spinnerAdapter;
        }
        super.setAdapter(spinnerAdapter);
        if (this.x != null && this.b == null) {
            if (this.b == null) {
                context = getContext();
            }
            dVar = new t.d(spinnerAdapter, context.getTheme());
            this.x.p(dVar);
        }
    }

    @Override // android.widget.Spinner
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.g(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        androidx.appcompat.widget.t.g sDK_INT;
        int i2;
        androidx.appcompat.widget.t.g gVar = this.x;
        if (gVar != null) {
            gVar.m(i);
            this.x.f(i);
        } else {
            if (Build.VERSION.SDK_INT >= 16) {
                super.setDropDownHorizontalOffset(i);
            }
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        androidx.appcompat.widget.t.g sDK_INT;
        int i2;
        sDK_INT = this.x;
        if (sDK_INT != null) {
            sDK_INT.l(i);
        } else {
            if (Build.VERSION.SDK_INT >= 16) {
                super.setDropDownVerticalOffset(i);
            }
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        androidx.appcompat.widget.t.g sDK_INT;
        int i2;
        if (this.x != null) {
            this.y = i;
        } else {
            if (Build.VERSION.SDK_INT >= 16) {
                super.setDropDownWidth(i);
            }
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        androidx.appcompat.widget.t.g sDK_INT;
        int i;
        sDK_INT = this.x;
        if (sDK_INT != null) {
            sDK_INT.c(drawable);
        } else {
            if (Build.VERSION.SDK_INT >= 16) {
                super.setPopupBackgroundDrawable(drawable);
            }
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(a.d(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(java.lang.CharSequence charSequence) {
        final androidx.appcompat.widget.t.g gVar = this.x;
        if (gVar != null) {
            gVar.j(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // android.widget.Spinner
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }
}
