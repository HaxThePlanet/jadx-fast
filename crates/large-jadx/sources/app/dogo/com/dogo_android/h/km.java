package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary;

/* loaded from: classes.dex */
public abstract class km extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.em O;
    public final app.dogo.com.dogo_android.h.em P;
    public final app.dogo.com.dogo_android.h.em Q;
    public final app.dogo.com.dogo_android.h.em R;
    public final ImageView S;
    public final ImageView T;
    public final ImageView U;
    public final ImageView V;
    public final ConstraintLayout W;
    protected ProgramCompletionSummary X;
    protected km(Object object, View view2, int i3, app.dogo.com.dogo_android.h.em em4, app.dogo.com.dogo_android.h.em em5, app.dogo.com.dogo_android.h.em em6, app.dogo.com.dogo_android.h.em em7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ConstraintLayout constraintLayout12) {
        super(object, view2, i3);
        this.O = em4;
        this.P = em5;
        this.Q = em6;
        this.R = em7;
        this.S = imageView8;
        this.T = imageView9;
        this.U = imageView10;
        this.V = imageView11;
        this.W = constraintLayout12;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(ProgramCompletionSummary programCompletionSummary);
}
