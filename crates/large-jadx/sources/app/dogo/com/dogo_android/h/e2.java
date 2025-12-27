package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: CellEntryProfileItemBinding.java */
/* loaded from: classes.dex */
public abstract class e2 extends ViewDataBinding {

    public final sk O;
    public final TextView P;
    public final ImageView Q;
    public final TextView R;
    protected app.dogo.com.dogo_android.d.d.r.f S;
    protected e2(Object object, View view, int i, sk skVar, TextView textView, ImageView imageView, TextView textView2) {
        super(object, view, i);
        this.O = skVar;
        this.P = textView;
        this.Q = imageView;
        this.R = textView2;
    }

    public static e2 T(View view) {
        return e2.U(view, f.e());
    }

    @Deprecated
    public static e2 U(View view, Object object) {
        return (e2)ViewDataBinding.k(object, view, 2131558487);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(app.dogo.com.dogo_android.d.d.r.f fVar);
}
