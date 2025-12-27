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

/* compiled from: FragmentGoodExampleVideoBinding.java */
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
    protected kd(Object object, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, ViewPager2 viewPager2, Guideline guideline, View view2, ProgressBar progressBar, View view3, TabLayout tabLayout, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = imageView;
        this.P = imageView2;
        this.Q = textView;
        this.R = viewPager2;
        this.S = view2;
        this.T = progressBar;
        this.U = view3;
        this.V = tabLayout;
        this.W = materialToolbar;
    }

    public static kd T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return kd.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static kd U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (kd)ViewDataBinding.z(layoutInflater, 2131558672, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(b bVar);
}
