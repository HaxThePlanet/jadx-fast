package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class y0 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final TextView P;
    protected y0(Object object, View view2, int i3, ConstraintLayout constraintLayout4, CardView cardView5, TextView textView6) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = textView6;
    }

    public static app.dogo.com.dogo_android.h.y0 T(View view) {
        return y0.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.y0 U(View view, Object object2) {
        return (y0)ViewDataBinding.k(object2, view, 2131558470);
    }
}
