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

/* loaded from: classes.dex */
public abstract class ic extends ViewDataBinding {

    public final Button O;
    public final ConstraintLayout P;
    public final Button Q;
    public final ImageView R;
    public final TextView S;
    protected g T;
    protected ic(Object object, View view2, int i3, Button button4, ConstraintLayout constraintLayout5, Button button6, ImageView imageView7, TextView textView8) {
        super(object, view2, i3);
        this.O = button4;
        this.P = constraintLayout5;
        this.Q = button6;
        this.R = imageView7;
        this.S = textView8;
    }

    public static app.dogo.com.dogo_android.h.ic T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ic.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ic U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ic)ViewDataBinding.z(layoutInflater, 2131558658, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g g);
}
