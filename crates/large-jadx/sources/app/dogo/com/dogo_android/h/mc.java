package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.u.n.p.l.g;
import app.dogo.com.dogo_android.u.n.p.l.i;
import com.google.android.material.button.MaterialButton;

/* compiled from: FragmentDogLogEditBinding.java */
/* loaded from: classes.dex */
public abstract class mc extends ViewDataBinding {

    public final TextView O;
    public final MaterialButton P;
    public final MaterialButton Q;
    public final MaterialButton R;
    public final ScrollView S;
    public final RecyclerView T;
    public final MaterialButton U;
    public final ConstraintLayout V;
    public final TextView W;
    public final Toolbar X;
    protected i Y;
    protected g Z;
    protected mc(Object object, View view, int i, Guideline guideline, TextView textView, TextView textView2, MaterialButton materialButton, MaterialButton materialButton2, ImageView imageView, MaterialButton materialButton3, ScrollView scrollView, RecyclerView recyclerView, TextView textView3, MaterialButton materialButton4, ConstraintLayout constraintLayout, TextView textView4, Toolbar toolbar, Barrier barrier) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = textView;
        object2.P = materialButton;
        object2.Q = materialButton2;
        object2.R = materialButton3;
        object2.S = scrollView;
        object2.T = recyclerView;
        object2.U = materialButton4;
        object2.V = constraintLayout;
        object2.W = textView4;
        object2.X = toolbar;
    }

    public static mc T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return mc.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static mc U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (mc)ViewDataBinding.z(layoutInflater, 2131558660, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g gVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(i iVar);
}
