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
    protected ej(Object object, View view2, int i3, Button button4, ConstraintLayout constraintLayout5, View view6, View view7, View view8, View view9, View view10, ImageView imageView11, MaterialCardView materialCardView12, TextView textView13, CheckBox checkBox14, CheckBox checkBox15, CheckBox checkBox16, CheckBox checkBox17, CheckBox checkBox18) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = button4;
        obj.P = view6;
        obj.Q = view7;
        obj.R = view8;
        obj.S = view9;
        obj.T = view10;
        obj.U = materialCardView12;
        obj.V = checkBox14;
        obj.W = checkBox15;
        obj.X = checkBox16;
        obj.Y = checkBox17;
        obj.Z = checkBox18;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(a0 a0);

    public abstract void U(List<Boolean> list);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(PottyProgramProgress pottyProgramProgress);
}
