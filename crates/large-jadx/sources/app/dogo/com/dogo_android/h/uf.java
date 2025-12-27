package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.y.z.g;

/* compiled from: FragmentProgramOverviewBinding.java */
/* loaded from: classes.dex */
public abstract class uf extends ViewDataBinding {

    public final TextView O;
    public final Button P;
    public final AppCompatImageView Q;
    public final ImageView R;
    public final FrameLayout S;
    public final TextView T;
    public final LinearLayout U;
    public final AppCompatImageView V;
    public final TextView W;
    public final AppCompatImageView X;
    public final View Y;
    public final RecyclerView Z;
    public final ConstraintLayout a0;
    public final NestedScrollView b0;
    public final TextView c0;
    public final AppCompatImageView d0;
    public final TextView e0;
    public final TextView f0;
    public final LinearLayout g0;
    protected g h0;
    protected String i0;
    protected uf(Object object, View view, int i, TextView textView, AppCompatImageView appCompatImageView, Button button, View view2, AppCompatImageView appCompatImageView2, ImageView imageView, FrameLayout frameLayout, TextView textView2, View view3, View view4, LinearLayout linearLayout, TextView textView3, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, TextView textView4, AppCompatImageView appCompatImageView5, AppCompatImageView appCompatImageView6, View view5, AppCompatImageView appCompatImageView7, TextView textView5, RecyclerView recyclerView, ConstraintLayout constraintLayout, NestedScrollView nestedScrollView, AppCompatImageView appCompatImageView8, TextView textView6, AppCompatImageView appCompatImageView9, TextView textView7, AppCompatImageView appCompatImageView10, TextView textView8, View view6, TextView textView9, TextView textView10, LinearLayout linearLayout2, TextView textView11) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = textView;
        object2.P = button;
        object2.Q = appCompatImageView2;
        object2.R = imageView;
        object2.S = frameLayout;
        object2.T = textView2;
        object2.U = linearLayout;
        object2.V = appCompatImageView3;
        object2.W = textView4;
        object2.X = appCompatImageView6;
        object2.Y = view5;
        object2.Z = recyclerView;
        object2.a0 = constraintLayout;
        object2.b0 = nestedScrollView;
        object2.c0 = textView6;
        object2.d0 = appCompatImageView9;
        object2.e0 = textView7;
        object2.f0 = textView10;
        object2.g0 = linearLayout2;
    }

    public static uf T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return uf.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static uf U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (uf)ViewDataBinding.z(layoutInflater, 2131558704, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(g gVar);
}
