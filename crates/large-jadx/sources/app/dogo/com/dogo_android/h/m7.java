package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations;
import app.dogo.com.dogo_android.u.l.a;

/* compiled from: CellSpecialProgramExerciseWithVariationsBinding.java */
/* loaded from: classes.dex */
public abstract class m7 extends ViewDataBinding {

    public final qm O;
    public final RecyclerView P;
    public final View Q;
    public final TextView R;
    public final TextView S;
    protected TrickItemWithVariations T;
    protected l.a U;
    protected m7(Object object, View view, int i, qm qmVar, RecyclerView recyclerView, ImageView imageView, View view2, ImageView imageView2, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = qmVar;
        this.P = recyclerView;
        this.Q = view2;
        this.R = textView;
        this.S = textView2;
    }

    public static m7 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m7.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static m7 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (m7)ViewDataBinding.z(layoutInflater, 2131558556, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(l.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(TrickItemWithVariations trickItemWithVariations);
}
