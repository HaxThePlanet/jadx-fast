package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* loaded from: classes.dex */
public abstract class gj extends ViewDataBinding {

    public final Button O;
    public final CardView P;
    public final Button Q;
    protected ProgramDescriptionItem R;
    protected o S;
    protected gj(Object object, View view2, int i3, ImageView imageView4, Button button5, ImageView imageView6, CardView cardView7, ImageView imageView8, TextView textView9, TextView textView10, Button button11) {
        super(object, view2, i3);
        this.O = button5;
        this.P = cardView7;
        this.Q = button11;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o o);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(ProgramDescriptionItem programDescriptionItem);
}
