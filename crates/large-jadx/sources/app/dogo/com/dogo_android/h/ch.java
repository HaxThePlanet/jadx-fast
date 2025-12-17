package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.r.l;
import app.dogo.com.dogo_android.view.compat.FocusedBorderTextInput;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class ch extends ViewDataBinding {

    public final LinearLayout O;
    public final TextView P;
    public final TextView Q;
    public final MaterialButton R;
    public final TextView S;
    public final TextView T;
    public final CheckBox U;
    public final CheckBox V;
    public final CheckBox W;
    public final CheckBox X;
    public final CheckBox Y;
    public final CheckBox Z;
    public final CheckBox a0;
    public final MaterialToolbar b0;
    protected l c0;
    protected Boolean d0;
    protected ch(Object object, View view2, int i3, LinearLayout linearLayout4, ConstraintLayout constraintLayout5, TextView textView6, TextView textView7, TextView textView8, FocusedBorderTextInput focusedBorderTextInput9, TextView textView10, TextView textView11, Guideline guideline12, FocusedBorderTextInput focusedBorderTextInput13, TextView textView14, NestedScrollView nestedScrollView15, Guideline guideline16, MaterialButton materialButton17, TextView textView18, TextView textView19, TextView textView20, CheckBox checkBox21, CheckBox checkBox22, CheckBox checkBox23, CheckBox checkBox24, CheckBox checkBox25, CheckBox checkBox26, CheckBox checkBox27, MaterialToolbar materialToolbar28, TextView textView29, TextView textView30) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = linearLayout4;
        obj.P = textView7;
        obj.Q = textView8;
        obj.R = materialButton17;
        obj.S = textView18;
        obj.T = textView19;
        obj.U = checkBox21;
        obj.V = checkBox22;
        obj.W = checkBox23;
        obj.X = checkBox24;
        obj.Y = checkBox25;
        obj.Z = checkBox26;
        obj.a0 = checkBox27;
        obj.b0 = materialToolbar28;
    }

    public static app.dogo.com.dogo_android.h.ch T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ch.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ch U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ch)ViewDataBinding.z(layoutInflater, 2131558721, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l l);
}
