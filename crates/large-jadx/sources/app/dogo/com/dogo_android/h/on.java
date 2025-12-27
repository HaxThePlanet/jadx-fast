package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* compiled from: LayoutWorkoutStreaksWithLongestBinding.java */
/* loaded from: classes.dex */
public abstract class on extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    protected Integer Q;
    protected Integer R;
    protected on(Object object, View view, int i, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView2, View view2, TextView textView3, ImageView imageView2, ConstraintLayout constraintLayout2) {
        super(object, view, i);
        this.O = textView;
        this.P = textView3;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Integer integer);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(Integer integer);
}
