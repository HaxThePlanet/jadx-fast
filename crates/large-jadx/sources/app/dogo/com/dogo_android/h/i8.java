package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.a0.g.f.e0;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public abstract class i8 extends ViewDataBinding {

    public final FrameLayout O;
    public final EditText P;
    public final ImageView Q;
    public final app.dogo.com.dogo_android.h.cn R;
    public final ImageView S;
    protected e0 T;
    protected a0 U;
    protected i8(Object object, View view2, int i3, FrameLayout frameLayout4, EditText editText5, ImageView imageView6, app.dogo.com.dogo_android.h.cn cn7, ImageView imageView8) {
        super(object, view2, i3);
        this.O = frameLayout4;
        this.P = editText5;
        this.Q = imageView6;
        this.R = cn7;
        this.S = imageView8;
    }

    public static app.dogo.com.dogo_android.h.i8 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return i8.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.i8 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (i8)ViewDataBinding.z(layoutInflater, 2131558592, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e0 e0);
}
