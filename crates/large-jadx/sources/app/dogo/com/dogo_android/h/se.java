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
    protected se(Object object, View view2, int i3, AppCompatImageView appCompatImageView4, AppCompatImageView appCompatImageView5, Guideline guideline6, AppCompatImageView appCompatImageView7, Guideline guideline8, Button button9, ViewPager2 viewPager210, TabLayout tabLayout11, MaterialToolbar materialToolbar12, TextView textView13, FrameLayout frameLayout14) {
        super(object, view2, i3);
        this.O = appCompatImageView4;
        this.P = appCompatImageView5;
        this.Q = button9;
        this.R = viewPager210;
        this.S = tabLayout11;
        this.T = materialToolbar12;
        this.U = textView13;
        this.V = frameLayout14;
    }

    public static app.dogo.com.dogo_android.h.se T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return se.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.se U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (se)ViewDataBinding.z(layoutInflater, 2131558690, viewGroup2, z3, object4);
    }
}
