package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.t.h0.i.a;
import app.dogo.com.dogo_android.t.h0.l;

/* loaded from: classes.dex */
public abstract class m9 extends ViewDataBinding {

    public final FrameLayout O;
    public final Button P;
    public final ConstraintLayout Q;
    public final ProgressBar R;
    public final RecyclerView S;
    protected l T;
    protected i.a U;
    protected m9(Object object, View view2, int i3, FrameLayout frameLayout4, Button button5, ConstraintLayout constraintLayout6, ProgressBar progressBar7, RecyclerView recyclerView8, TextView textView9) {
        super(object, view2, i3);
        this.O = frameLayout4;
        this.P = button5;
        this.Q = constraintLayout6;
        this.R = progressBar7;
        this.S = recyclerView8;
    }

    public static app.dogo.com.dogo_android.h.m9 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return m9.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.m9 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (m9)ViewDataBinding.z(layoutInflater, 2131558609, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(i.a i$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l l);
}
