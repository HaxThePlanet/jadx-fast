package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.d.c.j.b;

/* loaded from: classes.dex */
public abstract class c1 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final ImageView Q;
    public final ImageView R;
    public final RelativeLayout S;
    public final ImageView T;
    public final ConstraintLayout U;
    public final ImageView V;
    public final TextView W;
    public final FrameLayout X;
    public final TextView Y;
    public final RelativeLayout Z;
    public final ImageView a0;
    protected b b0;
    protected c1(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, ImageView imageView10, ConstraintLayout constraintLayout11, FrameLayout frameLayout12, ImageView imageView13, TextView textView14, FrameLayout frameLayout15, TextView textView16, RelativeLayout relativeLayout17, ImageView imageView18) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = imageView4;
        obj.P = imageView5;
        obj.Q = imageView6;
        obj.R = imageView7;
        obj.S = relativeLayout8;
        obj.T = imageView10;
        obj.U = constraintLayout11;
        obj.V = imageView13;
        obj.W = textView14;
        obj.X = frameLayout15;
        obj.Y = textView16;
        obj.Z = relativeLayout17;
        obj.a0 = imageView18;
    }

    public static app.dogo.com.dogo_android.h.c1 T(View view) {
        return c1.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.c1 U(View view, Object object2) {
        return (c1)ViewDataBinding.k(object2, view, 2131558472);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(b b);
}
