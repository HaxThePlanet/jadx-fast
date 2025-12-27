package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.profile.invitation.g;

/* compiled from: FragmentDogInviteBinding.java */
/* loaded from: classes.dex */
public abstract class ic extends ViewDataBinding {

    public final Button O;
    public final ConstraintLayout P;
    public final Button Q;
    public final ImageView R;
    public final TextView S;
    protected g T;
    protected ic(Object object, View view, int i, Button button, ConstraintLayout constraintLayout, Button button2, ImageView imageView, TextView textView) {
        super(object, view, i);
        this.O = button;
        this.P = constraintLayout;
        this.Q = button2;
        this.R = imageView;
        this.S = textView;
    }

    public static ic T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ic.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ic U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ic)ViewDataBinding.z(layoutInflater, 2131558658, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g gVar);
}
