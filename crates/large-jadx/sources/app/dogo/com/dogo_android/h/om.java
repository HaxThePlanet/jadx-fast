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

/* loaded from: classes.dex */
public abstract class om extends ViewDataBinding {

    public final LinearLayout O;
    public final MaterialTextView P;
    public final app.dogo.com.dogo_android.h.an Q;
    public final TextView R;
    public final MaterialToolbar S;
    public final ImageView T;
    public final TrickRatingBar U;
    public final TextView V;
    protected g W;
    protected om(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, LinearLayout linearLayout9, MaterialTextView materialTextView10, ImageView imageView11, ImageView imageView12, TextView textView13, app.dogo.com.dogo_android.h.an an14, TextView textView15, MaterialToolbar materialToolbar16, ImageView imageView17, TrickRatingBar trickRatingBar18, TextView textView19) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = linearLayout9;
        obj.P = materialTextView10;
        obj.Q = an14;
        obj.R = textView15;
        obj.S = materialToolbar16;
        obj.T = imageView17;
        obj.U = trickRatingBar18;
        obj.V = textView19;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(g g);
}
