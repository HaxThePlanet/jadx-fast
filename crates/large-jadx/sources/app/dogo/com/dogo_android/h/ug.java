package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.subscription.SubscriptionViewModel;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.Callbacks;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class ug extends ViewDataBinding {

    public final ConstraintLayout O;
    public final TextView P;
    public final MaterialButton Q;
    public final RecyclerView R;
    public final ConstraintLayout S;
    public final MaterialButton T;
    public final app.dogo.com.dogo_android.h.kk U;
    public final TextView V;
    public final MaterialToolbar W;
    protected SubscriptionViewModel X;
    protected SubscriptionBenefitsOfferAdapter.Callbacks Y;
    protected ug(Object object, View view2, int i3, ConstraintLayout constraintLayout4, TextView textView5, Guideline guideline6, ImageView imageView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, MaterialButton materialButton13, TextView textView14, RecyclerView recyclerView15, TextView textView16, ConstraintLayout constraintLayout17, MaterialButton materialButton18, Guideline guideline19, app.dogo.com.dogo_android.h.kk kk20, Barrier barrier21, TextView textView22, MaterialToolbar materialToolbar23) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = constraintLayout4;
        obj.P = textView5;
        obj.Q = materialButton13;
        obj.R = recyclerView15;
        obj.S = constraintLayout17;
        obj.T = materialButton18;
        obj.U = kk20;
        obj.V = textView22;
        obj.W = materialToolbar23;
    }

    public static app.dogo.com.dogo_android.h.ug T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ug.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ug U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ug)ViewDataBinding.z(layoutInflater, 2131558717, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(SubscriptionBenefitsOfferAdapter.Callbacks subscriptionBenefitsOfferAdapter$Callbacks);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(SubscriptionViewModel subscriptionViewModel);
}
