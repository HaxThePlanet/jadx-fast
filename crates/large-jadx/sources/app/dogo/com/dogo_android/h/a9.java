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

/* compiled from: DialogDogSelectBinding.java */
/* loaded from: classes.dex */
public abstract class a9 extends ViewDataBinding {

    public final View O;
    public final ConstraintLayout P;
    public final RecyclerView Q;
    protected j R;
    protected f.a S;
    protected a9(Object object, View view, int i, View view2, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, Guideline guideline, NestedScrollView nestedScrollView, TextView textView, ImageView imageView3, RecyclerView recyclerView) {
        super(object, view, i);
        this.O = view2;
        this.P = constraintLayout;
        this.Q = recyclerView;
    }

    public static a9 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return a9.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static a9 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (a9)ViewDataBinding.z(layoutInflater, 2131558601, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(f.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(j jVar);
}
