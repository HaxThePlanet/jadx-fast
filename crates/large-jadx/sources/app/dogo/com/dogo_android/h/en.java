package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* compiled from: LayoutTopBarV2Binding.java */
/* loaded from: classes.dex */
public abstract class en extends ViewDataBinding {

    public final FrameLayout O;
    public final ConstraintLayout P;
    public final TextView Q;
    protected String R;
    protected en(Object object, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, TextView textView) {
        super(object, view, i);
        this.O = frameLayout;
        this.P = constraintLayout;
        this.Q = textView;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(String str);
}
