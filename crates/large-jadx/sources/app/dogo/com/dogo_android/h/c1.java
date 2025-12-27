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

/* compiled from: CellChallengeNotificationItemBinding.java */
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
    protected c1(Object object, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView5, ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView6, TextView textView, FrameLayout frameLayout2, TextView textView2, RelativeLayout relativeLayout3, ImageView imageView7) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = imageView;
        object2.P = imageView2;
        object2.Q = imageView3;
        object2.R = imageView4;
        object2.S = relativeLayout;
        object2.T = imageView5;
        object2.U = constraintLayout;
        object2.V = imageView6;
        object2.W = textView;
        object2.X = frameLayout2;
        object2.Y = textView2;
        object2.Z = relativeLayout3;
        object2.a0 = imageView7;
    }

    public static c1 T(View view) {
        return c1.U(view, f.e());
    }

    @Deprecated
    public static c1 U(View view, Object object) {
        return (c1)ViewDataBinding.k(object, view, 2131558472);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(b bVar);
}
