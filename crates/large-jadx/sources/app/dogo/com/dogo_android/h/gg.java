package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.n.m.t.g;

/* loaded from: classes.dex */
public abstract class gg extends ViewDataBinding {

    public final Button O;
    public final Button P;
    public final app.dogo.com.dogo_android.h.om Q;
    protected g R;
    protected gg(Object object, View view2, int i3, Button button4, Button button5, ImageView imageView6, app.dogo.com.dogo_android.h.om om7, TextView textView8) {
        super(object, view2, i3);
        this.O = button4;
        this.P = button5;
        this.Q = om7;
    }

    public static app.dogo.com.dogo_android.h.gg T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return gg.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.gg U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (gg)ViewDataBinding.z(layoutInflater, 2131558710, viewGroup2, z3, object4);
    }
}
