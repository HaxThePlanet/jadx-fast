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

/* compiled from: FragmentSubscriptionBenefitsBinding.java */
/* loaded from: classes.dex */
public abstract class sg extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ym P;
    public final ImageView Q;
    public final ii R;
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
    public final kk e0;
    protected SubscriptionViewModel f0;
    protected SubscriptionBenefitsOfferAdapter.Callbacks g0;
    protected UserTestimonialsCallback h0;
    protected sg(Object object, View view, int i, ConstraintLayout constraintLayout, ym ymVar, ImageView imageView, ii iiVar, TextView textView, TextView textView2, ImageView imageView2, ImageView imageView3, Guideline guideline, ViewPager2 viewPager2, FrameLayout frameLayout, MaterialButton materialButton, TextView textView3, TextView textView4, RecyclerView recyclerView, RecyclerView recyclerView2, Barrier barrier, Barrier barrier2, TextView textView5, ScrollView scrollView, Guideline guideline2, FrameLayout frameLayout2, kk kkVar, Barrier barrier3) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = constraintLayout;
        object2.P = ymVar;
        object2.Q = imageView;
        object2.R = iiVar;
        object2.S = textView;
        object2.T = textView2;
        object2.U = imageView3;
        object2.V = viewPager2;
        object2.W = frameLayout;
        object2.X = materialButton;
        object2.Y = textView3;
        object2.Z = textView4;
        object2.a0 = recyclerView;
        object2.b0 = recyclerView2;
        object2.c0 = scrollView;
        object2.d0 = frameLayout2;
        object2.e0 = kkVar;
    }

    public static sg T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return sg.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static sg U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (sg)ViewDataBinding.z(layoutInflater, 2131558716, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(SubscriptionBenefitsOfferAdapter.Callbacks callbacks);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(UserTestimonialsCallback userTestimonialsCallback);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(SubscriptionViewModel subscriptionViewModel);
}
