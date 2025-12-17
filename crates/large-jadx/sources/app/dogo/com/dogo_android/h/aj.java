package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* loaded from: classes.dex */
public abstract class aj extends ViewDataBinding {

    public final CardView O;
    public final ImageView P;
    public final TextView Q;
    protected ProgramDescriptionItem R;
    protected o S;
    protected aj(Object object, View view2, int i3, CardView cardView4, ImageView imageView5, TextView textView6, Guideline guideline7) {
        super(object, view2, i3);
        this.O = cardView4;
        this.P = imageView5;
        this.Q = textView6;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o o);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(ProgramDescriptionItem programDescriptionItem);
}
