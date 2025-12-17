package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.q.p.h0;
import app.dogo.com.dogo_android.q.p.v;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public abstract class oc extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    public final View R;
    public final ViewPager2 S;
    public final TabLayout T;
    public final app.dogo.com.dogo_android.h.in U;
    protected v V;
    protected h0 W;
    protected oc(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, TextView textView6, View view7, ImageView imageView8, ProgressBar progressBar9, ScrollView scrollView10, ViewPager2 viewPager211, TabLayout tabLayout12, app.dogo.com.dogo_android.h.in in13) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = imageView5;
        this.Q = textView6;
        this.R = view7;
        this.S = viewPager211;
        this.T = tabLayout12;
        this.U = in13;
    }

    public static app.dogo.com.dogo_android.h.oc T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return oc.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.oc U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (oc)ViewDataBinding.z(layoutInflater, 2131558661, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(v v);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(h0 h0);
}
