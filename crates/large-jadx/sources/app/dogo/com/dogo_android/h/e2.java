package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.d.d.r.f;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public abstract class e2 extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.sk O;
    public final TextView P;
    public final ImageView Q;
    public final TextView R;
    protected f S;
    protected e2(Object object, View view2, int i3, app.dogo.com.dogo_android.h.sk sk4, TextView textView5, ImageView imageView6, TextView textView7) {
        super(object, view2, i3);
        this.O = sk4;
        this.P = textView5;
        this.Q = imageView6;
        this.R = textView7;
    }

    public static app.dogo.com.dogo_android.h.e2 T(View view) {
        return e2.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.e2 U(View view, Object object2) {
        return (e2)ViewDataBinding.k(object2, view, 2131558487);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(f f);
}
