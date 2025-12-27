package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.d.a.n.e;

/* compiled from: CellChallengeFanItemBinding.java */
/* loaded from: classes.dex */
public abstract class u0 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final ImageView Q;
    public final ImageView R;
    public final ImageView S;
    public final TextView T;
    protected e U;
    protected u0(Object object, View view, int i, ImageView imageView, ImageView imageView2, View view2, ImageView imageView3, ImageView imageView4, ImageView imageView5, TextView textView) {
        super(object, view, i);
        this.O = imageView;
        this.P = imageView2;
        this.Q = imageView3;
        this.R = imageView4;
        this.S = imageView5;
        this.T = textView;
    }

    public static u0 T(View view) {
        return u0.U(view, f.e());
    }

    @Deprecated
    public static u0 U(View view, Object object) {
        return (u0)ViewDataBinding.k(object, view, 2131558468);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e eVar);
}
