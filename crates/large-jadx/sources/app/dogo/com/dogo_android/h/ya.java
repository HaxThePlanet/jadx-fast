package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.welcome_v2.c0.a;
import app.dogo.com.dogo_android.welcome_v2.v0;
import com.yuyakaido.android.cardstackview.CardStackView;

/* loaded from: classes.dex */
public abstract class ya extends ViewDataBinding {

    public final View O;
    public final CardStackView P;
    public final ConstraintLayout Q;
    public final View R;
    public final app.dogo.com.dogo_android.h.ql S;
    protected v0 T;
    protected c0.a U;
    protected ya(Object object, View view2, int i3, View view4, CardStackView cardStackView5, ConstraintLayout constraintLayout6, View view7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, app.dogo.com.dogo_android.h.ql ql12) {
        super(object, view2, i3);
        this.O = view4;
        this.P = cardStackView5;
        this.Q = constraintLayout6;
        this.R = view7;
        this.S = ql12;
    }

    public static app.dogo.com.dogo_android.h.ya T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ya.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ya U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ya)ViewDataBinding.z(layoutInflater, 2131558640, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0.a c0$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(v0 v0);
}
