package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes.dex */
public abstract class mn extends ViewDataBinding {

    public final TextView O;
    protected Integer P;
    protected mn(Object object, View view2, int i3, TextView textView4, ImageView imageView5, TextView textView6) {
        super(object, view2, i3);
        this.O = textView4;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Integer integer);
}
