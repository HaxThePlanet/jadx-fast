package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import d.a.j;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {

    private int a;
    private int b;
    private WeakReference<View> c;
    private LayoutInflater v;
    private androidx.appcompat.widget.ViewStubCompat.a w;

    public interface a {
        public abstract void a(androidx.appcompat.widget.ViewStubCompat viewStubCompat, View view2);
    }
    public ViewStubCompat(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        final int i = 0;
        this.a = i;
        TypedArray obj3 = context.obtainStyledAttributes(attributeSet2, j.H3, i3, i);
        final int obj5 = -1;
        this.b = obj3.getResourceId(j.K3, obj5);
        this.a = obj3.getResourceId(j.J3, i);
        setId(obj3.getResourceId(j.I3, obj5));
        obj3.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    public View a() {
        LayoutInflater from;
        android.view.ViewParent parent = getParent();
        if (!parent instanceof ViewGroup) {
        } else {
            if (this.a == 0) {
            } else {
                if (this.v != null) {
                } else {
                    from = LayoutInflater.from(getContext());
                }
                View inflate = from.inflate(this.a, (ViewGroup)parent, false);
                int i3 = this.b;
                if (i3 != -1) {
                    inflate.setId(i3);
                }
                int indexOfChild = parent.indexOfChild(this);
                parent.removeViewInLayout(this);
                android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    parent.addView(inflate, indexOfChild, layoutParams);
                } else {
                    parent.addView(inflate, indexOfChild);
                }
                WeakReference weakReference = new WeakReference(inflate);
                this.c = weakReference;
                androidx.appcompat.widget.ViewStubCompat.a view = this.w;
                if (view != null) {
                    view.a(this, inflate);
                }
                return inflate;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ViewStub must have a valid layoutResource");
            throw illegalArgumentException;
        }
        IllegalStateException illegalStateException = new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        throw illegalStateException;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public int getInflatedId() {
        return this.b;
    }

    @Override // android.view.View
    public LayoutInflater getLayoutInflater() {
        return this.v;
    }

    @Override // android.view.View
    public int getLayoutResource() {
        return this.a;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        final int obj1 = 0;
        setMeasuredDimension(obj1, obj1);
    }

    @Override // android.view.View
    public void setInflatedId(int i) {
        this.b = i;
    }

    @Override // android.view.View
    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.v = layoutInflater;
    }

    @Override // android.view.View
    public void setLayoutResource(int i) {
        this.a = i;
    }

    @Override // android.view.View
    public void setOnInflateListener(androidx.appcompat.widget.ViewStubCompat.a viewStubCompat$a) {
        this.w = a;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Object weakReference;
        weakReference = this.c;
        if (weakReference != null) {
            weakReference = weakReference.get();
            if ((View)weakReference == null) {
            } else {
                (View)weakReference.setVisibility(i);
            }
            IllegalStateException obj2 = new IllegalStateException("setVisibility called on un-referenced view");
            throw obj2;
        }
        super.setVisibility(i);
        if (i != 0) {
            if (i == 4) {
                a();
            }
        } else {
        }
    }
}
