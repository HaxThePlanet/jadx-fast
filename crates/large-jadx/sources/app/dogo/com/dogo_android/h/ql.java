package app.dogo.com.dogo_android.h;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* compiled from: LayoutOnboardingToolBarBinding.java */
/* loaded from: classes.dex */
public abstract class ql extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ConstraintLayout P;
    protected Integer Q;
    protected Integer R;
    protected ql(Object object, View view, int i, ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout2) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = constraintLayout2;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Integer integer);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(Integer integer);
}
