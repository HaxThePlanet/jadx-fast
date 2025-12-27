package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.e0;

/* compiled from: LayoutDashboardWorkoutLockedCardBinding.java */
/* loaded from: classes.dex */
public abstract class ik extends ViewDataBinding {

    public final ImageView O;
    public final Button P;
    protected e0 Q;
    protected ik(Object object, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, Button button, TextView textView2) {
        super(object, view, i);
        this.O = imageView2;
        this.P = button;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(e0 e0Var);
}
