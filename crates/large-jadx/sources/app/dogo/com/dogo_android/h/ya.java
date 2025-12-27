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

/* compiled from: FragmentDashboardSurveyBinding.java */
/* loaded from: classes.dex */
public abstract class ya extends ViewDataBinding {

    public final View O;
    public final CardStackView P;
    public final ConstraintLayout Q;
    public final View R;
    public final ql S;
    protected v0 T;
    protected c0.a U;
    protected ya(Object object, View view, int i, View view2, CardStackView cardStackView, ConstraintLayout constraintLayout, View view3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ql qlVar) {
        super(object, view, i);
        this.O = view2;
        this.P = cardStackView;
        this.Q = constraintLayout;
        this.R = view3;
        this.S = qlVar;
    }

    public static ya T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ya.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ya U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ya)ViewDataBinding.z(layoutInflater, 2131558640, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(c0.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(v0 v0Var);
}
