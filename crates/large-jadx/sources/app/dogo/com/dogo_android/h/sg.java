package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.subscription.SubscriptionViewModel;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.Callbacks;
import app.dogo.com.dogo_android.subscription.benefits.UserTestimonialsCallback;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class sg extends ViewDataBinding {

    public final ConstraintLayout O;
    public final app.dogo.com.dogo_android.h.ym P;
    public final ImageView Q;
    public final app.dogo.com.dogo_android.h.ii R;
    public final TextView S;
    public final TextView T;
    public final ImageView U;
    public final ViewPager2 V;
    public final FrameLayout W;
    public final MaterialButton X;
    public final TextView Y;
    public final TextView Z;
    public final RecyclerView a0;
    public final RecyclerView b0;
    public final ScrollView c0;
    public final FrameLayout d0;
    public final app.dogo.com.dogo_android.h.kk e0;
    protected SubscriptionViewModel f0;
    protected SubscriptionBenefitsOfferAdapter.Callbacks g0;
    protected UserTestimonialsCallback h0;
    protected sg(Object object, View view2, int i3, ConstraintLayout constraintLayout4, app.dogo.com.dogo_android.h.ym ym5, ImageView imageView6, app.dogo.com.dogo_android.h.ii ii7, TextView textView8, TextView textView9, ImageView imageView10, ImageView imageView11, Guideline guideline12, ViewPager2 viewPager213, FrameLayout frameLayout14, MaterialButton materialButton15, TextView textView16, TextView textView17, RecyclerView recyclerView18, RecyclerView recyclerView19, Barrier barrier20, Barrier barrier21, TextView textView22, ScrollView scrollView23, Guideline guideline24, FrameLayout frameLayout25, app.dogo.com.dogo_android.h.kk kk26, Barrier barrier27) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = constraintLayout4;
        obj.P = ym5;
        obj.Q = imageView6;
        obj.R = ii7;
        obj.S = textView8;
        obj.T = textView9;
        obj.U = imageView11;
        obj.V = viewPager213;
        obj.W = frameLayout14;
        obj.X = materialButton15;
        obj.Y = textView16;
        obj.Z = textView17;
        obj.a0 = recyclerView18;
        obj.b0 = recyclerView19;
        obj.c0 = scrollView23;
        obj.d0 = frameLayout25;
        obj.e0 = kk26;
    }

    public static app.dogo.com.dogo_android.h.sg T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return sg.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.sg U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (sg)ViewDataBinding.z(layoutInflater, 2131558716, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(SubscriptionBenefitsOfferAdapter.Callbacks subscriptionBenefitsOfferAdapter$Callbacks);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(UserTestimonialsCallback userTestimonialsCallback);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(SubscriptionViewModel subscriptionViewModel);
}
