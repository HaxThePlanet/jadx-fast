package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import java.util.List;

/* loaded from: classes.dex */
public abstract class ki extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.ej O;
    public final app.dogo.com.dogo_android.h.aj P;
    public final app.dogo.com.dogo_android.h.cj Q;
    public final View R;
    public final app.dogo.com.dogo_android.h.qj S;
    public final TextView T;
    protected ProgramDescriptionItem U;
    protected PottyProgramProgress V;
    protected o W;
    protected List<Boolean> X;
    protected ki(Object object, View view2, int i3, app.dogo.com.dogo_android.h.ej ej4, TextView textView5, ImageView imageView6, app.dogo.com.dogo_android.h.aj aj7, app.dogo.com.dogo_android.h.cj cj8, View view9, app.dogo.com.dogo_android.h.qj qj10, TextView textView11) {
        super(object, view2, i3);
        this.O = ej4;
        this.P = aj7;
        this.Q = cj8;
        this.R = view9;
        this.S = qj10;
        this.T = textView11;
    }

    public static app.dogo.com.dogo_android.h.ki T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ki.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ki U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ki)ViewDataBinding.z(layoutInflater, 2131558747, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(o o);

    public abstract void W(List<Boolean> list);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(ProgramDescriptionItem programDescriptionItem);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void Y(PottyProgramProgress pottyProgramProgress);
}
