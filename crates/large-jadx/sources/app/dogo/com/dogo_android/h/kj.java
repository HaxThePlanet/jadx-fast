package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.w;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* loaded from: classes.dex */
public abstract class kj extends ViewDataBinding {

    public final Button O;
    public final CardView P;
    public final ImageView Q;
    public final TextView R;
    public final Button S;
    public final TextView T;
    public final TextView U;
    protected ProgramDescriptionItem V;
    protected w W;
    protected kj(Object object, View view2, int i3, Button button4, ImageView imageView5, CardView cardView6, CardView cardView7, ImageView imageView8, TextView textView9, TextView textView10, Button button11, TextView textView12, TextView textView13, TextView textView14) {
        super(object, view2, i3);
        this.O = button4;
        this.P = cardView6;
        this.Q = imageView8;
        this.R = textView9;
        this.S = button11;
        this.T = textView12;
        this.U = textView14;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(w w);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(ProgramDescriptionItem programDescriptionItem);
}
