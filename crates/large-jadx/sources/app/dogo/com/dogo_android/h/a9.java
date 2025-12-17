package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.q.q.f.a;
import app.dogo.com.dogo_android.q.q.j;

/* loaded from: classes.dex */
public abstract class a9 extends ViewDataBinding {

    public final View O;
    public final ConstraintLayout P;
    public final RecyclerView Q;
    protected j R;
    protected f.a S;
    protected a9(Object object, View view2, int i3, View view4, ConstraintLayout constraintLayout5, ImageView imageView6, ImageView imageView7, Guideline guideline8, NestedScrollView nestedScrollView9, TextView textView10, ImageView imageView11, RecyclerView recyclerView12) {
        super(object, view2, i3);
        this.O = view4;
        this.P = constraintLayout5;
        this.Q = recyclerView12;
    }

    public static app.dogo.com.dogo_android.h.a9 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return a9.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.a9 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (a9)ViewDataBinding.z(layoutInflater, 2131558601, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(f.a f$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(j j);
}
