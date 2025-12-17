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
    protected yd(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, ConstraintLayout constraintLayout5, View view6, Barrier barrier7, Guideline guideline8, Barrier barrier9, ClickerSoundMaterialButton clickerSoundMaterialButton10, View view11, Guideline guideline12, Guideline guideline13, Space space14, Button button15, Chip chip16, FrameLayout frameLayout17, Chip chip18, TextView textView19, ProgressBar progressBar20, LottieAnimationView lottieAnimationView21, TabLayout tabLayout22, ConstraintLayout constraintLayout23, ConstraintLayout constraintLayout24, MaterialToolbar materialToolbar25, ConstraintLayout constraintLayout26, ViewPager2 viewPager227, View view28) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = constraintLayout5;
        obj.P = view6;
        obj.Q = clickerSoundMaterialButton10;
        obj.R = space14;
        obj.S = button15;
        obj.T = chip16;
        obj.U = frameLayout17;
        obj.V = chip18;
        obj.W = textView19;
        obj.X = lottieAnimationView21;
        obj.Y = tabLayout22;
        obj.Z = constraintLayout23;
        obj.a0 = constraintLayout24;
        obj.b0 = materialToolbar25;
        obj.c0 = constraintLayout26;
        obj.d0 = viewPager227;
        obj.e0 = view28;
    }

    public static app.dogo.com.dogo_android.h.yd T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return yd.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.yd U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (yd)ViewDataBinding.z(layoutInflater, 2131558679, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(k k);
}
