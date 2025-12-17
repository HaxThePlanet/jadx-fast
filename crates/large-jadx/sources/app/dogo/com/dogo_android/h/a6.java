package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class a6 extends ViewDataBinding {

    public final TextView O;
    public final CardView P;
    protected a6(Object object, View view2, int i3, TextView textView4, CardView cardView5) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = cardView5;
    }

    public static app.dogo.com.dogo_android.h.a6 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return a6.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.a6 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (a6)ViewDataBinding.z(layoutInflater, 2131558537, viewGroup2, z3, object4);
    }
}
