package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.v;

/* loaded from: classes.dex */
public abstract class yj extends ViewDataBinding {

    public final Button O;
    public final Button P;
    protected v Q;
    protected yj(Object object, View view2, int i3, Button button4, TextView textView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, Button button9, TextView textView10) {
        super(object, view2, i3);
        this.O = button4;
        this.P = button9;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(v v);
}
