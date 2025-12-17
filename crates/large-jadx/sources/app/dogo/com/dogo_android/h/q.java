package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.welcome_v2.p0;

/* loaded from: classes.dex */
public abstract class q extends ViewDataBinding {

    public final FrameLayout O;
    protected p0 P;
    protected q(Object object, View view2, int i3, FrameLayout frameLayout4, ImageView imageView5, ImageView imageView6, FrameLayout frameLayout7, ImageView imageView8, ImageView imageView9) {
        super(object, view2, i3);
        this.O = frameLayout7;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(p0 p0);
}
