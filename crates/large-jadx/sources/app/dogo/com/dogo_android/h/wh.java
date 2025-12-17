package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.u.h;

/* loaded from: classes.dex */
public abstract class wh extends ViewDataBinding {

    public final ProgressBar O;
    public final TextView P;
    public final ProgressBar Q;
    public final TextView R;
    protected h S;
    protected wh(Object object, View view2, int i3, Guideline guideline4, ProgressBar progressBar5, TextView textView6, ImageView imageView7, ImageView imageView8, ProgressBar progressBar9, TextView textView10) {
        super(object, view2, i3);
        this.O = progressBar5;
        this.P = textView6;
        this.Q = progressBar9;
        this.R = textView10;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(h h);
}
