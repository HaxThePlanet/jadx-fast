package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.q.p.v;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;

/* loaded from: classes.dex */
public abstract class qk extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.yl O;
    public final app.dogo.com.dogo_android.h.yl P;
    public final Button Q;
    public final Button R;
    public final app.dogo.com.dogo_android.h.yl S;
    public final LinearLayout T;
    public final app.dogo.com.dogo_android.h.yl U;
    protected v V;
    protected ProfilePreview W;
    protected qk(Object object, View view2, int i3, app.dogo.com.dogo_android.h.yl yl4, app.dogo.com.dogo_android.h.yl yl5, Button button6, Button button7, app.dogo.com.dogo_android.h.yl yl8, LinearLayout linearLayout9, app.dogo.com.dogo_android.h.yl yl10) {
        super(object, view2, i3);
        this.O = yl4;
        this.P = yl5;
        this.Q = button6;
        this.R = button7;
        this.S = yl8;
        this.T = linearLayout9;
        this.U = yl10;
    }

    public static app.dogo.com.dogo_android.h.qk T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return qk.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.qk U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (qk)ViewDataBinding.z(layoutInflater, 2131558776, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(v v);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(ProfilePreview profilePreview);
}
