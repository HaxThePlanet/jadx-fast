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

/* compiled from: FragmentSubscriptionChoosePlanBinding.java */
/* loaded from: classes.dex */
public abstract class ug extends ViewDataBinding {

    public final ConstraintLayout O;
    public final TextView P;
    public final MaterialButton Q;
    public final RecyclerView R;
    public final ConstraintLayout S;
    public final MaterialButton T;
    public final kk U;
    public final TextView V;
    public final MaterialToolbar W;
    protected SubscriptionViewModel X;
    protected SubscriptionBenefitsOfferAdapter.Callbacks Y;
    protected ug(Object object, View view, int i, ConstraintLayout constraintLayout, TextView textView, Guideline guideline, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, MaterialButton materialButton, TextView textView7, RecyclerView recyclerView, TextView textView8, ConstraintLayout constraintLayout2, MaterialButton materialButton2, Guideline guideline2, kk kkVar, Barrier barrier, TextView textView9, MaterialToolbar materialToolbar) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = constraintLayout;
        object2.P = textView;
        object2.Q = materialButton;
        object2.R = recyclerView;
        object2.S = constraintLayout2;
        object2.T = materialButton2;
        object2.U = kkVar;
        object2.V = textView9;
        object2.W = materialToolbar;
    }

    public static ug T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ug.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ug U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ug)ViewDataBinding.z(layoutInflater, 2131558717, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(SubscriptionBenefitsOfferAdapter.Callbacks callbacks);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(SubscriptionViewModel subscriptionViewModel);
}
