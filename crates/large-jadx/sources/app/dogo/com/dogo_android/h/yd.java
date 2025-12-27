package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.legacy.widget.Space;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.n.m.u.k;
import app.dogo.com.dogo_android.n.m.u.n;
import app.dogo.com.dogo_android.view.dailytraining.ClickerSoundMaterialButton;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.Chip;
import com.google.android.material.tabs.TabLayout;

/* compiled from: FragmentLibraryTrickDetailsBinding.java */
/* loaded from: classes.dex */
public abstract class yd extends ViewDataBinding {

    public final ConstraintLayout O;
    public final View P;
    public final ClickerSoundMaterialButton Q;
    public final Space R;
    public final Button S;
    public final Chip T;
    public final FrameLayout U;
    public final Chip V;
    public final TextView W;
    public final LottieAnimationView X;
    public final TabLayout Y;
    public final ConstraintLayout Z;
    public final ConstraintLayout a0;
    public final MaterialToolbar b0;
    public final ConstraintLayout c0;
    public final ViewPager2 d0;
    public final View e0;
    protected n f0;
    protected k g0;
    protected yd(Object object, View view, int i, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, View view2, Barrier barrier, Guideline guideline, Barrier barrier2, ClickerSoundMaterialButton clickerSoundMaterialButton, View view3, Guideline guideline2, Guideline guideline3, Space space, Button button, Chip chip, FrameLayout frameLayout, Chip chip2, TextView textView, ProgressBar progressBar, LottieAnimationView lottieAnimationView, TabLayout tabLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, MaterialToolbar materialToolbar, ConstraintLayout constraintLayout4, ViewPager2 viewPager2, View view4) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = constraintLayout;
        object2.P = view2;
        object2.Q = clickerSoundMaterialButton;
        object2.R = space;
        object2.S = button;
        object2.T = chip;
        object2.U = frameLayout;
        object2.V = chip2;
        object2.W = textView;
        object2.X = lottieAnimationView;
        object2.Y = tabLayout;
        object2.Z = constraintLayout2;
        object2.a0 = constraintLayout3;
        object2.b0 = materialToolbar;
        object2.c0 = constraintLayout4;
        object2.d0 = viewPager2;
        object2.e0 = view4;
    }

    public static yd T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return yd.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static yd U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (yd)ViewDataBinding.z(layoutInflater, 2131558679, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(k kVar);
}
