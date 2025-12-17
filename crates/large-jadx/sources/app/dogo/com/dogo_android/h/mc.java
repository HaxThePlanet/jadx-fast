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
    protected mc(Object object, View view2, int i3, Guideline guideline4, TextView textView5, TextView textView6, MaterialButton materialButton7, MaterialButton materialButton8, ImageView imageView9, MaterialButton materialButton10, ScrollView scrollView11, RecyclerView recyclerView12, TextView textView13, MaterialButton materialButton14, ConstraintLayout constraintLayout15, TextView textView16, Toolbar toolbar17, Barrier barrier18) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = textView5;
        obj.P = materialButton7;
        obj.Q = materialButton8;
        obj.R = materialButton10;
        obj.S = scrollView11;
        obj.T = recyclerView12;
        obj.U = materialButton14;
        obj.V = constraintLayout15;
        obj.W = textView16;
        obj.X = toolbar17;
    }

    public static app.dogo.com.dogo_android.h.mc T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return mc.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.mc U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (mc)ViewDataBinding.z(layoutInflater, 2131558660, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g g);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(i i);
}
