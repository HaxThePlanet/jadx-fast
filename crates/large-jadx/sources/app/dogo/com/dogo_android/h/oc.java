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

/* compiled from: FragmentDogPreviewBinding.java */
/* loaded from: classes.dex */
public abstract class oc extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    public final View R;
    public final ViewPager2 S;
    public final TabLayout T;
    public final in U;
    protected v V;
    protected h0 W;
    protected oc(Object object, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, View view2, ImageView imageView3, ProgressBar progressBar, ScrollView scrollView, ViewPager2 viewPager2, TabLayout tabLayout, in inVar) {
        super(object, view, i);
        this.O = imageView;
        this.P = imageView2;
        this.Q = textView;
        this.R = view2;
        this.S = viewPager2;
        this.T = tabLayout;
        this.U = inVar;
    }

    public static oc T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return oc.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static oc U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (oc)ViewDataBinding.z(layoutInflater, 2131558661, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(v vVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(h0 h0Var);
}
