package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.util.l0.b;
import app.dogo.com.dogo_android.welcome_v2.k0;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

/* compiled from: FragmentOnboardingPagerBinding.java */
/* loaded from: classes.dex */
public abstract class se extends ViewDataBinding {

    public final AppCompatImageView O;
    public final AppCompatImageView P;
    public final Button Q;
    public final ViewPager2 R;
    public final TabLayout S;
    public final MaterialToolbar T;
    public final TextView U;
    public final FrameLayout V;
    protected b W;
    protected k0 X;
    protected se(Object object, View view, int i, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, Guideline guideline, AppCompatImageView appCompatImageView3, Guideline guideline2, Button button, ViewPager2 viewPager2, TabLayout tabLayout, MaterialToolbar materialToolbar, TextView textView, FrameLayout frameLayout) {
        super(object, view, i);
        this.O = appCompatImageView;
        this.P = appCompatImageView2;
        this.Q = button;
        this.R = viewPager2;
        this.S = tabLayout;
        this.T = materialToolbar;
        this.U = textView;
        this.V = frameLayout;
    }

    public static se T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return se.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static se U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (se)ViewDataBinding.z(layoutInflater, 2131558690, viewGroup, z, object);
    }
}
