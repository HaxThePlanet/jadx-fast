package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class i9 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    protected String Q;
    protected String R;
    protected String S;
    protected i9(Object object, View view2, int i3, ImageView imageView4, TextView textView5, TextView textView6) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = textView5;
    }

    public static app.dogo.com.dogo_android.h.i9 T(LayoutInflater layoutInflater) {
        return i9.U(layoutInflater, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.i9 U(LayoutInflater layoutInflater, Object object2) {
        return (i9)ViewDataBinding.z(layoutInflater, 2131558607, 0, false, object2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String string);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(String string);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(String string);
}
