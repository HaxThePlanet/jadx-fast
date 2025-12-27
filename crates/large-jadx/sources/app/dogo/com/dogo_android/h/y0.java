package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellChallengeFilterListRowBinding.java */
/* loaded from: classes.dex */
public abstract class y0 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final TextView P;
    protected y0(Object object, View view, int i, ConstraintLayout constraintLayout, CardView cardView, TextView textView) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = textView;
    }

    public static y0 T(View view) {
        return y0.U(view, f.e());
    }

    @Deprecated
    public static y0 U(View view, Object object) {
        return (y0)ViewDataBinding.k(object, view, 2131558470);
    }
}
