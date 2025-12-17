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
    protected sj(Object object, View view2, int i3, ProgressBar progressBar4, TextView textView5, CardView cardView6, ImageView imageView7, ProgressBar progressBar8, TextView textView9, Guideline guideline10) {
        super(object, view2, i3);
        this.O = progressBar4;
        this.P = textView5;
        this.Q = cardView6;
        this.R = imageView7;
        this.S = progressBar8;
        this.T = textView9;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o o);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramDescriptionItem programDescriptionItem);
}
