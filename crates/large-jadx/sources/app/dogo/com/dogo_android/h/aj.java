package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* compiled from: LayoutDashboardPottyProgramCardBinding.java */
/* loaded from: classes.dex */
public abstract class aj extends ViewDataBinding {

    public final CardView O;
    public final ImageView P;
    public final TextView Q;
    protected ProgramDescriptionItem R;
    protected o S;
    protected aj(Object object, View view, int i, CardView cardView, ImageView imageView, TextView textView, Guideline guideline) {
        super(object, view, i);
        this.O = cardView;
        this.P = imageView;
        this.Q = textView;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o oVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(ProgramDescriptionItem programDescriptionItem);
}
