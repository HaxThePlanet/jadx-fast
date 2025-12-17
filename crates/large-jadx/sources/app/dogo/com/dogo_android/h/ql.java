package app.dogo.com.dogo_android.h;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes.dex */
public abstract class ql extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ConstraintLayout P;
    protected Integer Q;
    protected Integer R;
    protected ql(Object object, View view2, int i3, ConstraintLayout constraintLayout4, AppCompatImageView appCompatImageView5, ConstraintLayout constraintLayout6) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = constraintLayout6;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Integer integer);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(Integer integer);
}
