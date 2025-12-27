package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.d.d.r.h;

/* compiled from: CellEntryProfileTitleItemBinding.java */
/* loaded from: classes.dex */
public abstract class g2 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    public final ImageView R;
    public final TextView S;
    public final TextView T;
    public final ImageView U;
    public final TextView V;
    protected h W;
    protected g2(Object object, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, RelativeLayout relativeLayout, TextView textView2, AppCompatImageView appCompatImageView, TextView textView3, ImageView imageView4, TextView textView4) {
        super(object, view, i);
        this.O = imageView;
        this.P = imageView2;
        this.Q = textView;
        this.R = imageView3;
        this.S = textView2;
        this.T = textView3;
        this.U = imageView4;
        this.V = textView4;
    }

    public static g2 T(View view) {
        return g2.U(view, f.e());
    }

    @Deprecated
    public static g2 U(View view, Object object) {
        return (g2)ViewDataBinding.k(object, view, 2131558488);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(h hVar);
}
