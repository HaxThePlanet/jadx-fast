package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent;

/* compiled from: CellDogParentBinding.java */
/* loaded from: classes.dex */
public abstract class w1 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final TextView P;
    protected DogParentUIState.DogParent Q;
    protected w1(Object object, View view, int i, ConstraintLayout constraintLayout, TextView textView) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = textView;
    }

    public static w1 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return w1.V(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static w1 V(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (w1)ViewDataBinding.z(layoutInflater, 2131558482, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public DogParentUIState.DogParent T() {
        return this.Q;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(DogParentUIState.DogParent dogParent);
}
