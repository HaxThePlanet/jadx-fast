package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.u.h;

/* compiled from: LayoutBitingProgramProgressDisplayBinding.java */
/* loaded from: classes.dex */
public abstract class wh extends ViewDataBinding {

    public final ProgressBar O;
    public final TextView P;
    public final ProgressBar Q;
    public final TextView R;
    protected h S;
    protected wh(Object object, View view, int i, Guideline guideline, ProgressBar progressBar, TextView textView, ImageView imageView, ImageView imageView2, ProgressBar progressBar2, TextView textView2) {
        super(object, view, i);
        this.O = progressBar;
        this.P = textView;
        this.Q = progressBar2;
        this.R = textView2;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(h hVar);
}
