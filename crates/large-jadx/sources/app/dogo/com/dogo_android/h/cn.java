package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.util.k0.g;

/* loaded from: classes.dex */
public abstract class cn extends ViewDataBinding {

    public final TextView O;
    public final FrameLayout P;
    public final FrameLayout Q;
    public final AppCompatImageView R;
    public final FrameLayout S;
    public final FrameLayout T;
    public final ConstraintLayout U;
    public final TextView V;
    protected g W;
    protected cn(Object object, View view2, int i3, TextView textView4, FrameLayout frameLayout5, FrameLayout frameLayout6, AppCompatImageView appCompatImageView7, FrameLayout frameLayout8, FrameLayout frameLayout9, ConstraintLayout constraintLayout10, TextView textView11) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = frameLayout5;
        this.Q = frameLayout6;
        this.R = appCompatImageView7;
        this.S = frameLayout8;
        this.T = frameLayout9;
        this.U = constraintLayout10;
        this.V = textView11;
    }

    @Override // androidx.databinding.ViewDataBinding
    public g T() {
        return this.W;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(g g);
}
