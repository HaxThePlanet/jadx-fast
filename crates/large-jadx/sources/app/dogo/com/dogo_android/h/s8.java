package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class s8 extends ViewDataBinding {

    public final Button O;
    public final RelativeLayout P;
    public final RelativeLayout Q;
    protected s8(Object object, View view2, int i3, Button button4, ImageView imageView5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, TextView textView8) {
        super(object, view2, i3);
        this.O = button4;
        this.P = relativeLayout6;
        this.Q = relativeLayout7;
    }

    public static app.dogo.com.dogo_android.h.s8 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return s8.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.s8 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (s8)ViewDataBinding.z(layoutInflater, 2131558597, viewGroup2, z3, object4);
    }
}
