package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.util.customview.shimmer.ShimmerFrameLayout;

/* compiled from: LayoutDashboardDiscountCounterBinding.java */
/* loaded from: classes.dex */
public abstract class ui extends ViewDataBinding {

    public final TextView O;
    public final ConstraintLayout P;
    public final ShimmerFrameLayout Q;
    public final ak R;
    protected CouponTimer S;
    protected o T;
    protected ui(Object object, View view, int i, TextView textView, ConstraintLayout constraintLayout, ShimmerFrameLayout shimmerFrameLayout, ak akVar) {
        super(object, view, i);
        this.O = textView;
        this.P = constraintLayout;
        this.Q = shimmerFrameLayout;
        this.R = akVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o oVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(CouponTimer couponTimer);
}
