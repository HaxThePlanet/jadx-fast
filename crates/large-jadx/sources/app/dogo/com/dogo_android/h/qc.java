package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.q.p.h0;
import app.dogo.com.dogo_android.q.p.v;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public abstract class qc extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final ImageView Q;
    public final TextView R;
    public final View S;
    public final ViewPager2 T;
    public final TabLayout U;
    public final app.dogo.com.dogo_android.h.in V;
    protected v W;
    protected h0 X;
    protected qc(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView7, View view8, ConstraintLayout constraintLayout9, ImageView imageView10, ProgressBar progressBar11, ScrollView scrollView12, ViewPager2 viewPager213, TabLayout tabLayout14, app.dogo.com.dogo_android.h.in in15) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = imageView5;
        this.Q = imageView6;
        this.R = textView7;
        this.S = view8;
        this.T = viewPager213;
        this.U = tabLayout14;
        this.V = in15;
    }

    public static app.dogo.com.dogo_android.h.qc T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return qc.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.qc U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (qc)ViewDataBinding.z(layoutInflater, 2131558662, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(v v);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(h0 h0);
}
