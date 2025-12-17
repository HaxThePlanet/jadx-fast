package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.Program;

/* loaded from: classes.dex */
public abstract class gm extends ViewDataBinding {

    public final ImageView O;
    public final CardView P;
    public final TextView Q;
    protected Program R;
    protected gm(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, CardView cardView6, TextView textView7) {
        super(object, view2, i3);
        this.O = imageView5;
        this.P = cardView6;
        this.Q = textView7;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Program program);
}
