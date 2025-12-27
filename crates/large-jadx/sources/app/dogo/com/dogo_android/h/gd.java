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

/* compiled from: FragmentFirstExamUnlcokedBinding.java */
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
    protected gd(Object object, View view, int i, ImageView imageView, AnimatedTextView animatedTextView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, CardView cardView, ImageView imageView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ImageView imageView4, ImageView imageView5, TextView textView8, TextView textView9) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = animatedTextView;
        object2.P = imageView2;
        object2.Q = textView;
        object2.R = textView2;
        object2.S = textView3;
        object2.T = constraintLayout;
        object2.U = cardView;
        object2.V = textView4;
        object2.W = textView5;
        object2.X = textView6;
        object2.Y = imageView4;
        object2.Z = imageView5;
        object2.a0 = textView9;
    }

    public static gd T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return gd.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static gd U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (gd)ViewDataBinding.z(layoutInflater, 2131558670, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e eVar);
}
