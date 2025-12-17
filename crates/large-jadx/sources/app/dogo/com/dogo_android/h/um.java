package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.a0.g.f.d0;

/* loaded from: classes.dex */
public abstract class um extends ViewDataBinding {

    public final ImageView O;
    protected d0 P;
    protected um(Object object, View view2, int i3, ImageView imageView4) {
        super(object, view2, i3);
        this.O = imageView4;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(d0 d0);
}
