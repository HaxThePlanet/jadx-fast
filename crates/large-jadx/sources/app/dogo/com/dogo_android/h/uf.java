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
    protected uf(Object object, View view2, int i3, TextView textView4, AppCompatImageView appCompatImageView5, Button button6, View view7, AppCompatImageView appCompatImageView8, ImageView imageView9, FrameLayout frameLayout10, TextView textView11, View view12, View view13, LinearLayout linearLayout14, TextView textView15, AppCompatImageView appCompatImageView16, AppCompatImageView appCompatImageView17, TextView textView18, AppCompatImageView appCompatImageView19, AppCompatImageView appCompatImageView20, View view21, AppCompatImageView appCompatImageView22, TextView textView23, RecyclerView recyclerView24, ConstraintLayout constraintLayout25, NestedScrollView nestedScrollView26, AppCompatImageView appCompatImageView27, TextView textView28, AppCompatImageView appCompatImageView29, TextView textView30, AppCompatImageView appCompatImageView31, TextView textView32, View view33, TextView textView34, TextView textView35, LinearLayout linearLayout36, TextView textView37) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = textView4;
        obj.P = button6;
        obj.Q = appCompatImageView8;
        obj.R = imageView9;
        obj.S = frameLayout10;
        obj.T = textView11;
        obj.U = linearLayout14;
        obj.V = appCompatImageView16;
        obj.W = textView18;
        obj.X = appCompatImageView20;
        obj.Y = view21;
        obj.Z = recyclerView24;
        obj.a0 = constraintLayout25;
        obj.b0 = nestedScrollView26;
        obj.c0 = textView28;
        obj.d0 = appCompatImageView29;
        obj.e0 = textView30;
        obj.f0 = textView35;
        obj.g0 = linearLayout36;
    }

    public static app.dogo.com.dogo_android.h.uf T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return uf.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.uf U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (uf)ViewDataBinding.z(layoutInflater, 2131558704, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String string);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(g g);
}
