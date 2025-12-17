package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.m.b;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public abstract class kd extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    public final ViewPager2 R;
    public final View S;
    public final ProgressBar T;
    public final View U;
    public final TabLayout V;
    public final MaterialToolbar W;
    protected b X;
    protected kd(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, TextView textView6, ViewPager2 viewPager27, Guideline guideline8, View view9, ProgressBar progressBar10, View view11, TabLayout tabLayout12, MaterialToolbar materialToolbar13) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = imageView5;
        this.Q = textView6;
        this.R = viewPager27;
        this.S = view9;
        this.T = progressBar10;
        this.U = view11;
        this.V = tabLayout12;
        this.W = materialToolbar13;
    }

    public static app.dogo.com.dogo_android.h.kd T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return kd.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.kd U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (kd)ViewDataBinding.z(layoutInflater, 2131558672, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(b b);
}
