package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes.dex */
public abstract class en extends ViewDataBinding {

    public final FrameLayout O;
    public final ConstraintLayout P;
    public final TextView Q;
    protected String R;
    protected en(Object object, View view2, int i3, FrameLayout frameLayout4, AppCompatImageView appCompatImageView5, ConstraintLayout constraintLayout6, TextView textView7) {
        super(object, view2, i3);
        this.O = frameLayout4;
        this.P = constraintLayout6;
        this.Q = textView7;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(String string);
}
