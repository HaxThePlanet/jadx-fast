package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent;

/* loaded from: classes.dex */
public abstract class w1 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final TextView P;
    protected DogParentUIState.DogParent Q;
    protected w1(Object object, View view2, int i3, ConstraintLayout constraintLayout4, TextView textView5) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = textView5;
    }

    public static app.dogo.com.dogo_android.h.w1 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return w1.V(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.w1 V(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (w1)ViewDataBinding.z(layoutInflater, 2131558482, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public DogParentUIState.DogParent T() {
        return this.Q;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(DogParentUIState.DogParent dogParentUIState$DogParent);
}
