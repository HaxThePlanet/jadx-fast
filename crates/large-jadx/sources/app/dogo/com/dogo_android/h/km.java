package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary;

/* compiled from: LayoutProgramProgressBarBinding.java */
/* loaded from: classes.dex */
public abstract class km extends ViewDataBinding {

    public final em O;
    public final em P;
    public final em Q;
    public final em R;
    public final ImageView S;
    public final ImageView T;
    public final ImageView U;
    public final ImageView V;
    public final ConstraintLayout W;
    protected ProgramCompletionSummary X;
    protected km(Object object, View view, int i, em emVar, em emVar2, em emVar3, em emVar4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ConstraintLayout constraintLayout) {
        super(object, view, i);
        this.O = emVar;
        this.P = emVar2;
        this.Q = emVar3;
        this.R = emVar4;
        this.S = imageView;
        this.T = imageView2;
        this.U = imageView3;
        this.V = imageView4;
        this.W = constraintLayout;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(ProgramCompletionSummary programCompletionSummary);
}
