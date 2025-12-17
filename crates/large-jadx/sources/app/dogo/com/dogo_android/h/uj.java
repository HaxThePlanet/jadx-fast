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
public abstract class uj extends ViewDataBinding {

    public final CardView O;
    public final Button P;
    protected ProgramDescriptionItem Q;
    protected o R;
    protected uj(Object object, View view2, int i3, TextView textView4, ImageView imageView5, ImageView imageView6, CardView cardView7, Button button8, ImageView imageView9, TextView textView10) {
        super(object, view2, i3);
        this.O = cardView7;
        this.P = button8;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o o);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(ProgramDescriptionItem programDescriptionItem);
}
