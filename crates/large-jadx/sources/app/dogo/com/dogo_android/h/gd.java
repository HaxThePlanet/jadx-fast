package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.welcome_v2.AnimatedTextView;
import app.dogo.com.dogo_android.y.r.e;

/* loaded from: classes.dex */
public abstract class gd extends ViewDataBinding {

    public final AnimatedTextView O;
    public final ImageView P;
    public final TextView Q;
    public final TextView R;
    public final TextView S;
    public final ConstraintLayout T;
    public final CardView U;
    public final TextView V;
    public final TextView W;
    public final TextView X;
    public final ImageView Y;
    public final ImageView Z;
    public final TextView a0;
    protected TrickItem b0;
    protected gd(Object object, View view2, int i3, ImageView imageView4, AnimatedTextView animatedTextView5, ImageView imageView6, TextView textView7, TextView textView8, TextView textView9, ConstraintLayout constraintLayout10, CardView cardView11, ImageView imageView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, ImageView imageView17, ImageView imageView18, TextView textView19, TextView textView20) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = animatedTextView5;
        obj.P = imageView6;
        obj.Q = textView7;
        obj.R = textView8;
        obj.S = textView9;
        obj.T = constraintLayout10;
        obj.U = cardView11;
        obj.V = textView13;
        obj.W = textView14;
        obj.X = textView15;
        obj.Y = imageView17;
        obj.Z = imageView18;
        obj.a0 = textView20;
    }

    public static app.dogo.com.dogo_android.h.gd T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return gd.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.gd U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (gd)ViewDataBinding.z(layoutInflater, 2131558670, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e e);
}
