package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.util.customview.shimmer.ShimmerFrameLayout;

/* loaded from: classes.dex */
public abstract class ui extends ViewDataBinding {

    public final TextView O;
    public final ConstraintLayout P;
    public final ShimmerFrameLayout Q;
    public final app.dogo.com.dogo_android.h.ak R;
    protected CouponTimer S;
    protected o T;
    protected ui(Object object, View view2, int i3, TextView textView4, ConstraintLayout constraintLayout5, ShimmerFrameLayout shimmerFrameLayout6, app.dogo.com.dogo_android.h.ak ak7) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = constraintLayout5;
        this.Q = shimmerFrameLayout6;
        this.R = ak7;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o o);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(CouponTimer couponTimer);
}
