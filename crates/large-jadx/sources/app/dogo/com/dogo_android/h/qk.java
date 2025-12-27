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

/* compiled from: LayoutDogProfileDetailsBinding.java */
/* loaded from: classes.dex */
public abstract class qk extends ViewDataBinding {

    public final yl O;
    public final yl P;
    public final Button Q;
    public final Button R;
    public final yl S;
    public final LinearLayout T;
    public final yl U;
    protected v V;
    protected ProfilePreview W;
    protected qk(Object object, View view, int i, yl ylVar, yl ylVar2, Button button, Button button2, yl ylVar3, LinearLayout linearLayout, yl ylVar4) {
        super(object, view, i);
        this.O = ylVar;
        this.P = ylVar2;
        this.Q = button;
        this.R = button2;
        this.S = ylVar3;
        this.T = linearLayout;
        this.U = ylVar4;
    }

    public static qk T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return qk.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static qk U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (qk)ViewDataBinding.z(layoutInflater, 2131558776, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(v vVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(ProfilePreview profilePreview);
}
