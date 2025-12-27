package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData;

/* compiled from: LayoutDashboardSpecialProgramCardBinding.java */
/* loaded from: classes.dex */
public abstract class sj extends ViewDataBinding {

    public final ProgressBar O;
    public final TextView P;
    public final CardView Q;
    public final ImageView R;
    public final ProgressBar S;
    public final TextView T;
    protected ProgramDescriptionItem U;
    protected SpecialProgramOverviewItem.ProgramProgressData V;
    protected o W;
    protected sj(Object object, View view, int i, ProgressBar progressBar, TextView textView, CardView cardView, ImageView imageView, ProgressBar progressBar2, TextView textView2, Guideline guideline) {
        super(object, view, i);
        this.O = progressBar;
        this.P = textView;
        this.Q = cardView;
        this.R = imageView;
        this.S = progressBar2;
        this.T = textView2;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o oVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(SpecialProgramOverviewItem.ProgramProgressData programProgressData);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramDescriptionItem programDescriptionItem);
}
