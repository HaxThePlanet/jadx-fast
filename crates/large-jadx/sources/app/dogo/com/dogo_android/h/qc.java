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

/* compiled from: FragmentDogPreviewFullscreenBinding.java */
/* loaded from: classes.dex */
public abstract class qc extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final ImageView Q;
    public final TextView R;
    public final View S;
    public final ViewPager2 T;
    public final TabLayout U;
    public final in V;
    protected v W;
    protected h0 X;
    protected qc(Object object, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, View view2, ConstraintLayout constraintLayout, ImageView imageView4, ProgressBar progressBar, ScrollView scrollView, ViewPager2 viewPager2, TabLayout tabLayout, in inVar) {
        super(object, view, i);
        this.O = imageView;
        this.P = imageView2;
        this.Q = imageView3;
        this.R = textView;
        this.S = view2;
        this.T = viewPager2;
        this.U = tabLayout;
        this.V = inVar;
    }

    public static qc T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return qc.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static qc U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (qc)ViewDataBinding.z(layoutInflater, 2131558662, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(v vVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(h0 h0Var);
}
