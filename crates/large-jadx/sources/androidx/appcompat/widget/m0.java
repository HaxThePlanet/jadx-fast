package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.a.c;
import d.a.a;
import d.a.o.a;

/* loaded from: classes.dex */
public class m0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    private int A;
    Runnable a;
    private androidx.appcompat.widget.m0.c b;
    androidx.appcompat.widget.e0 c;
    private Spinner v;
    private boolean w;
    int x;
    int y;
    private int z;

    class a implements Runnable {

        final View a;
        final androidx.appcompat.widget.m0 b;
        a(androidx.appcompat.widget.m0 m0, View view2) {
            this.b = m0;
            this.a = view2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.smoothScrollTo(left -= i3, 0);
            m0Var.a = 0;
        }
    }

    private class b extends BaseAdapter {

        final androidx.appcompat.widget.m0 a;
        b(androidx.appcompat.widget.m0 m0) {
            this.a = m0;
            super();
        }

        @Override // android.widget.BaseAdapter
        public int getCount() {
            return m0Var.c.getChildCount();
        }

        @Override // android.widget.BaseAdapter
        public Object getItem(int i) {
            return (m0.d)m0Var.c.getChildAt(i).b();
        }

        @Override // android.widget.BaseAdapter
        public long getItemId(int i) {
            return (long)i;
        }

        @Override // android.widget.BaseAdapter
        public View getView(int i, View view2, ViewGroup viewGroup3) {
            Object obj1;
            androidx.appcompat.widget.m0.d obj2;
            int obj3;
            if (view2 == null) {
                obj2 = this.a.c((a.c)getItem(i), true);
            } else {
                (m0.d)view2.a((a.c)getItem(i));
            }
            return obj2;
        }
    }

    private class c implements View.OnClickListener {

        final androidx.appcompat.widget.m0 a;
        c(androidx.appcompat.widget.m0 m0) {
            this.a = m0;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            int i2;
            View childAt;
            int i;
            (m0.d)view.b().e();
            final int i3 = 0;
            i2 = i3;
            while (i2 < m0Var.c.getChildCount()) {
                childAt = m0Var2.c.getChildAt(i2);
                if (childAt == view) {
                } else {
                }
                i = i3;
                childAt.setSelected(i);
                i2++;
                i = 1;
            }
        }
    }

    private class d extends LinearLayout {

        private final int[] a;
        private a.c b;
        private TextView c;
        private ImageView v;
        private View w;
        final androidx.appcompat.widget.m0 x;
        public d(androidx.appcompat.widget.m0 m0, Context context2, a.c a$c3, boolean z4) {
            androidx.appcompat.widget.t0 obj5;
            boolean obj6;
            this.x = m0;
            obj5 = a.d;
            final int i = 0;
            super(context2, i, obj5);
            int[] iArr = new int[1];
            final int i4 = 0;
            iArr[i4] = 16842964;
            this.a = iArr;
            this.b = c3;
            obj5 = t0.v(context2, i, iArr, obj5, i4);
            if (obj5.s(i4)) {
                setBackgroundDrawable(obj5.g(i4));
            }
            obj5.w();
            if (z4) {
                setGravity(8388627);
            }
            c();
        }

        @Override // android.widget.LinearLayout
        public void a(a.c a$c) {
            this.b = c;
            c();
        }

        @Override // android.widget.LinearLayout
        public a.c b() {
            return this.b;
        }

        @Override // android.widget.LinearLayout
        public void c() {
            Object cVar;
            ImageView view2;
            int view;
            TextView appCompatTextView;
            TextView i3;
            java.lang.CharSequence i4;
            Object charSequence;
            int i5;
            int i;
            int i2;
            ImageView appCompatImageView;
            ImageView layoutParams;
            LinearLayout.LayoutParams layoutParams2;
            cVar = this.b;
            view = cVar.b();
            i3 = 8;
            i4 = 0;
            if (view != null) {
                android.view.ViewParent parent = view.getParent();
                if (parent != this && parent != null) {
                    if (parent != null) {
                        (ViewGroup)parent.removeView(view);
                    }
                    addView(view);
                }
                this.w = view;
                TextView view3 = this.c;
                if (view3 != null) {
                    view3.setVisibility(i3);
                }
                cVar = this.v;
                if (cVar != null) {
                    cVar.setVisibility(i3);
                    this.v.setImageDrawable(i4);
                }
            } else {
                View view4 = this.w;
                if (view4 != null) {
                    removeView(view4);
                    this.w = i4;
                }
                android.graphics.drawable.Drawable drawable = cVar.c();
                charSequence = cVar.d();
                i5 = 16;
                i = 0;
                i2 = -2;
                if (drawable != null) {
                    if (this.v == null) {
                        appCompatImageView = new AppCompatImageView(getContext());
                        layoutParams2 = new LinearLayout.LayoutParams(i2, i2);
                        layoutParams2.gravity = i5;
                        appCompatImageView.setLayoutParams(layoutParams2);
                        addView(appCompatImageView, i);
                        this.v = appCompatImageView;
                    }
                    this.v.setImageDrawable(drawable);
                    this.v.setVisibility(i);
                } else {
                    view2 = this.v;
                    if (view2 != null) {
                        view2.setVisibility(i3);
                        this.v.setImageDrawable(i4);
                    }
                }
                empty ^= 1;
                if (view != null) {
                    if (this.c == null) {
                        appCompatTextView = new AppCompatTextView(getContext(), i4, a.e);
                        appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                        layoutParams = new LinearLayout.LayoutParams(i2, i2);
                        layoutParams.gravity = i5;
                        appCompatTextView.setLayoutParams(layoutParams);
                        addView(appCompatTextView);
                        this.c = appCompatTextView;
                    }
                    this.c.setText(charSequence);
                    this.c.setVisibility(i);
                } else {
                    charSequence = this.c;
                    if (charSequence != null) {
                        charSequence.setVisibility(i3);
                        this.c.setText(i4);
                    }
                }
                i3 = this.v;
                if (i3 != null) {
                    i3.setContentDescription(cVar.a());
                }
                if (view != null) {
                } else {
                    i4 = cVar.a();
                }
                v0.a(this, i4);
            }
        }

        @Override // android.widget.LinearLayout
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        @Override // android.widget.LinearLayout
        public void onMeasure(int i, int i2) {
            int i3;
            int obj2;
            super.onMeasure(i, i2);
            i3 = m0Var.x;
            if (obj2.x > 0 && getMeasuredWidth() > i3) {
                i3 = m0Var.x;
                if (getMeasuredWidth() > i3) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
                }
            }
        }

        @Override // android.widget.LinearLayout
        public void setSelected(boolean z) {
            int i;
            boolean obj2;
            i = isSelected() != z ? 1 : 0;
            super.setSelected(z);
            if (i != 0 && z) {
                if (z) {
                    sendAccessibilityEvent(4);
                }
            }
        }
    }
    static {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
    }

    private Spinner b() {
        t tVar = new t(getContext(), 0, a.h);
        e0.a aVar = new e0.a(-2, -1);
        tVar.setLayoutParams(aVar);
        tVar.setOnItemSelectedListener(this);
        return tVar;
    }

    private boolean d() {
        Object parent;
        int i;
        parent = this.v;
        if (parent != null && parent.getParent() == this) {
            i = parent.getParent() == this ? 1 : 0;
        } else {
        }
        return i;
    }

    private void e() {
        Spinner spinner;
        Object adapter;
        Runnable runnable;
        Object layoutParams;
        if (d()) {
        }
        if (this.v == null) {
            this.v = b();
        }
        removeView(this.c);
        layoutParams = new ViewGroup.LayoutParams(-2, -1);
        addView(this.v, layoutParams);
        if (this.v.getAdapter() == null) {
            layoutParams = new m0.b(this);
            this.v.setAdapter(layoutParams);
        }
        runnable = this.a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.a = 0;
        }
        this.v.setSelection(this.A);
    }

    private boolean f() {
        final int i = 0;
        if (!d()) {
            return i;
        }
        removeView(this.v);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        addView(this.c, layoutParams);
        setTabSelected(this.v.getSelectedItemPosition());
        return i;
    }

    @Override // android.widget.HorizontalScrollView
    public void a(int i) {
        Runnable runnable = this.a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        m0.a aVar = new m0.a(this, this.c.getChildAt(i));
        this.a = aVar;
        post(aVar);
    }

    @Override // android.widget.HorizontalScrollView
    androidx.appcompat.widget.m0.d c(a.c a$c, boolean z2) {
        int context;
        Object obj3;
        int obj4;
        m0.d dVar = new m0.d(this, getContext(), c, z2);
        if (z2) {
            dVar.setBackgroundDrawable(0);
            obj3 = new AbsListView.LayoutParams(-1, this.z);
            dVar.setLayoutParams(obj3);
        } else {
            dVar.setFocusable(true);
            if (this.b == null) {
                obj3 = new m0.c(this);
                this.b = obj3;
            }
            dVar.setOnClickListener(this.b);
        }
        return dVar;
    }

    @Override // android.widget.HorizontalScrollView
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        final Runnable runnable = this.a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.widget.HorizontalScrollView
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        a obj2 = a.b(getContext());
        setContentHeight(obj2.f());
        this.y = obj2.e();
    }

    @Override // android.widget.HorizontalScrollView
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        final Runnable runnable = this.a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view2, int i3, long l4) {
        (m0.d)view2.b().e();
    }

    @Override // android.widget.HorizontalScrollView
    public void onMeasure(int i, int i2) {
        int measuredWidth;
        int size;
        int i3;
        int i6;
        int childCount;
        int i4;
        int i5;
        int obj7;
        int obj8;
        obj8 = View.MeasureSpec.getMode(i);
        measuredWidth = 1;
        size = 0;
        i3 = 1073741824;
        i6 = obj8 == i3 ? measuredWidth : size;
        setFillViewport(i6);
        childCount = this.c.getChildCount();
        if (childCount > measuredWidth) {
            if (obj8 != i3) {
                if (obj8 == Integer.MIN_VALUE) {
                    obj8 = 2;
                    if (childCount > obj8) {
                        this.x = (int)obj8;
                    } else {
                        this.x = size2 /= obj8;
                    }
                    this.x = Math.min(this.x, this.y);
                } else {
                    this.x = -1;
                }
            } else {
            }
        } else {
        }
        obj8 = View.MeasureSpec.makeMeasureSpec(this.z, i3);
        if (i6 == 0 && this.w) {
            if (this.w) {
            } else {
                measuredWidth = size;
            }
        } else {
        }
        if (measuredWidth != 0) {
            this.c.measure(size, obj8);
            if (this.c.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                e();
            } else {
                f();
            }
        } else {
            f();
        }
        super.onMeasure(i, obj8);
        if (i6 != 0 && getMeasuredWidth() != getMeasuredWidth()) {
            if (getMeasuredWidth() != getMeasuredWidth()) {
                setTabSelected(this.A);
            }
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.widget.HorizontalScrollView
    public void setAllowCollapse(boolean z) {
        this.w = z;
    }

    @Override // android.widget.HorizontalScrollView
    public void setContentHeight(int i) {
        this.z = i;
        requestLayout();
    }

    @Override // android.widget.HorizontalScrollView
    public void setTabSelected(int i) {
        int i3;
        View childAt;
        int i2;
        this.A = i;
        final int i4 = 0;
        i3 = i4;
        while (i3 < this.c.getChildCount()) {
            if (i3 == i) {
            } else {
            }
            i2 = i4;
            this.c.getChildAt(i3).setSelected(i2);
            if (i2 != 0) {
            }
            i3++;
            a(i);
            i2 = 1;
        }
        Spinner spinner = this.v;
        if (spinner != null && i >= 0) {
            if (i >= 0) {
                spinner.setSelection(i);
            }
        }
    }
}
