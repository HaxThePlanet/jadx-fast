package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.util.k0.g;

/* compiled from: LayoutTopBarBinding.java */
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
    protected cn(Object object, View view, int i, TextView textView, FrameLayout frameLayout, FrameLayout frameLayout2, AppCompatImageView appCompatImageView, FrameLayout frameLayout3, FrameLayout frameLayout4, ConstraintLayout constraintLayout, TextView textView2) {
        super(object, view, i);
        this.O = textView;
        this.P = frameLayout;
        this.Q = frameLayout2;
        this.R = appCompatImageView;
        this.S = frameLayout3;
        this.T = frameLayout4;
        this.U = constraintLayout;
        this.V = textView2;
    }

    @Override // androidx.databinding.ViewDataBinding
    public g T() {
        return this.W;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(g gVar);
}
