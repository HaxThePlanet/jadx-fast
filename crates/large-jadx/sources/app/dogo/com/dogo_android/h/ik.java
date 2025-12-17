package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.e0;

/* loaded from: classes.dex */
public abstract class ik extends ViewDataBinding {

    public final ImageView O;
    public final Button P;
    protected e0 Q;
    protected ik(Object object, View view2, int i3, TextView textView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, Button button9, TextView textView10) {
        super(object, view2, i3);
        this.O = imageView6;
        this.P = button9;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(e0 e0);
}
