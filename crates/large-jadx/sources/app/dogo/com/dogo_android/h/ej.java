package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.a0;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import com.google.android.material.card.MaterialCardView;
import java.util.List;

/* compiled from: LayoutDashboardPottyProgramCheckmarksCardBinding.java */
/* loaded from: classes.dex */
public abstract class ej extends ViewDataBinding {

    public final Button O;
    public final View P;
    public final View Q;
    public final View R;
    public final View S;
    public final View T;
    public final MaterialCardView U;
    public final CheckBox V;
    public final CheckBox W;
    public final CheckBox X;
    public final CheckBox Y;
    public final CheckBox Z;
    protected a0 a0;
    protected List<Boolean> b0;
    protected ej(Object object, View view, int i, Button button, ConstraintLayout constraintLayout, View view2, View view3, View view4, View view5, View view6, ImageView imageView, MaterialCardView materialCardView, TextView textView, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = button;
        object2.P = view2;
        object2.Q = view3;
        object2.R = view4;
        object2.S = view5;
        object2.T = view6;
        object2.U = materialCardView;
        object2.V = checkBox;
        object2.W = checkBox2;
        object2.X = checkBox3;
        object2.Y = checkBox4;
        object2.Z = checkBox5;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(List<Boolean> list);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(PottyProgramProgress pottyProgramProgress);
}
