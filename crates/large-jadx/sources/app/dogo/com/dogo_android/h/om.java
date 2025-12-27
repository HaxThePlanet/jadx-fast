package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.n.m.t.g;
import app.dogo.com.dogo_android.util.customview.TrickRatingBar;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.textview.MaterialTextView;

/* compiled from: LayoutRateBinding.java */
/* loaded from: classes.dex */
public abstract class om extends ViewDataBinding {

    public final LinearLayout O;
    public final MaterialTextView P;
    public final an Q;
    public final TextView R;
    public final MaterialToolbar S;
    public final ImageView T;
    public final TrickRatingBar U;
    public final TextView V;
    protected g W;
    protected om(Object object, View view, int i, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, LinearLayout linearLayout, MaterialTextView materialTextView, ImageView imageView6, ImageView imageView7, TextView textView, an anVar, TextView textView2, MaterialToolbar materialToolbar, ImageView imageView8, TrickRatingBar trickRatingBar, TextView textView3) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = linearLayout;
        object2.P = materialTextView;
        object2.Q = anVar;
        object2.R = textView2;
        object2.S = materialToolbar;
        object2.T = imageView8;
        object2.U = trickRatingBar;
        object2.V = textView3;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(g gVar);
}
