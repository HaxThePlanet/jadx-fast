package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes.dex */
public abstract class on extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected Integer Q;
    protected Integer R;
    protected on(Object object, View view2, int i3, TextView textView4, ImageView imageView5, ConstraintLayout constraintLayout6, TextView textView7, View view8, TextView textView9, ImageView imageView10, ConstraintLayout constraintLayout11) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = textView9;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Integer integer);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(Integer integer);
}
