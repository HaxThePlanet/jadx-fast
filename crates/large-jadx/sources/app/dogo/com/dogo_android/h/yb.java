package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class yb extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.gi O;
    public final FrameLayout P;
    public final Button Q;
    protected yb(Object object, View view2, int i3, app.dogo.com.dogo_android.h.gi gi4, FrameLayout frameLayout5, ImageView imageView6, Button button7, TextView textView8) {
        super(object, view2, i3);
        this.O = gi4;
        this.P = frameLayout5;
        this.Q = button7;
    }

    public static app.dogo.com.dogo_android.h.yb T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return yb.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.yb U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (yb)ViewDataBinding.z(layoutInflater, 2131558653, viewGroup2, z3, object4);
    }
}
