package zendesk.belvedere;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import androidx.core.content.a;
import d.h.l.u;
import zendesk.belvedere.b0.b;
import zendesk.belvedere.b0.e;
import zendesk.belvedere.b0.f;
import zendesk.support.request.AttachmentHelper;

/* loaded from: classes3.dex */
public class SelectableView extends FrameLayout implements View.OnClickListener {

    private zendesk.belvedere.SelectableView.c a;
    private View b;
    private View c;
    private String v;
    private String w;

    class a implements ValueAnimator.AnimatorUpdateListener {

        final zendesk.belvedere.SelectableView a;
        a(zendesk.belvedere.SelectableView selectableView) {
            this.a = selectableView;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SelectableView.a(this.a, (Float)valueAnimator.getAnimatedValue().floatValue());
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        final zendesk.belvedere.SelectableView a;
        b(zendesk.belvedere.SelectableView selectableView) {
            this.a = selectableView;
            super();
        }

        @Override // android.animation.ValueAnimator$AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SelectableView.b(this.a, (Float)valueAnimator.getAnimatedValue().floatValue());
        }
    }

    interface c {
        public abstract boolean a(boolean z);
    }
    public SelectableView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        f();
    }

    static void a(zendesk.belvedere.SelectableView selectableView, float f2) {
        selectableView.g(f2);
    }

    static void b(zendesk.belvedere.SelectableView selectableView, float f2) {
        selectableView.c(f2);
    }

    private void c(float f) {
        getChild().setAlpha(f);
    }

    private void d(boolean z) {
        int i;
        int i2;
        View obj3;
        if (z) {
            this.c.setVisibility(0);
            this.c.bringToFront();
            u.s0(this.c, f += i2);
        } else {
            this.c.setVisibility(8);
        }
    }

    private ImageView e(int i) {
        int i3 = -2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 17;
        ImageView imageView = new ImageView(getContext());
        imageView.setId(f.c);
        imageView.setImageDrawable(a.f(getContext(), e.d));
        u.o0(imageView, a.f(getContext(), e.c));
        imageView.setLayoutParams(layoutParams);
        imageView.setVisibility(8);
        a0.b(imageView, i);
        return imageView;
    }

    private void f() {
        int i = 1;
        setClickable(i);
        setFocusable(i);
        setOnClickListener(this);
        ImageView view = e(a0.a(getContext(), b.a));
        this.c = view;
        addView(view);
    }

    private void g(float f) {
        getChild().setScaleX(f);
        getChild().setScaleY(f);
    }

    private View getChild() {
        int i;
        int childCount;
        int i3;
        int i2;
        View view = this.b;
        if (view != null) {
            return view;
        }
        if (getChildCount() != 2) {
        } else {
            i = 0;
            while (i < getChildCount()) {
                childCount = getChildAt(i);
                if (childCount.getId() != f.c) {
                    break;
                } else {
                }
                i++;
            }
            return this.b;
        }
        RuntimeException runtimeException = new RuntimeException("More then one child added to SelectableView");
        throw runtimeException;
    }

    private void setContentDesc(boolean z) {
        String obj1;
        if (z) {
            setContentDescription(this.v);
        } else {
            setContentDescription(this.w);
        }
    }

    @Override // android.widget.FrameLayout
    public void h(String string, String string2) {
        this.v = string;
        this.w = string2;
        setContentDesc(isSelected());
    }

    @Override // android.widget.FrameLayout
    public void onClick(View view) {
        int float;
        zendesk.belvedere.SelectableView.c view2;
        int obj4;
        obj4 ^= float;
        view2 = this.a;
        if (view2 != null) {
            float = view2.a(obj4);
        }
        if (float != 0) {
            setSelected(obj4);
            int i2 = 2;
            if (obj4 != null) {
                obj4 = new float[i2];
                obj4 = new int[]{1065353216, 1063675494};
                obj4 = ValueAnimator.ofFloat(obj4);
                float[] fArr2 = new float[i2];
                fArr2 = new int[]{1065353216, 1061997773};
                float = ValueAnimator.ofFloat(fArr2);
            } else {
                obj4 = new float[i2];
                obj4 = new int[]{1063675494, 1065353216};
                obj4 = ValueAnimator.ofFloat(obj4);
                float[] fArr = new float[i2];
                fArr = new int[]{1061997773, 1065353216};
                float = ValueAnimator.ofFloat(fArr);
            }
            SelectableView.a aVar = new SelectableView.a(this);
            obj4.addUpdateListener(aVar);
            SelectableView.b bVar = new SelectableView.b(this);
            float.addUpdateListener(bVar);
            view2 = 75;
            float.setDuration(view2);
            obj4.setDuration(view2);
            obj4.start();
            float.start();
        }
    }

    @Override // android.widget.FrameLayout
    public void setSelected(boolean z) {
        int obj1;
        super.setSelected(z);
        if (z) {
            g(1063675494);
            c(1061997773);
            obj1 = 1;
            d(obj1);
            setContentDesc(obj1);
        } else {
            obj1 = 1065353216;
            g(obj1);
            c(obj1);
            obj1 = 0;
            d(obj1);
            setContentDesc(obj1);
        }
    }

    @Override // android.widget.FrameLayout
    public void setSelectionListener(zendesk.belvedere.SelectableView.c selectableView$c) {
        this.a = c;
    }
}
