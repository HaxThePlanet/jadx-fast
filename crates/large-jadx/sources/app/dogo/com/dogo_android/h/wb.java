package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.r.l;
import app.dogo.com.dogo_android.view.compat.FocusedBorderTextInput;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class wb extends ViewDataBinding {

    public final LinearLayout O;
    public final MaterialButton P;
    public final CheckBox Q;
    public final CheckBox R;
    public final CheckBox S;
    public final CheckBox T;
    public final CheckBox U;
    public final CheckBox V;
    public final CheckBox W;
    public final MaterialToolbar X;
    public final TextView Y;
    protected l Z;
    protected wb(Object object, View view2, int i3, LinearLayout linearLayout4, TextView textView5, AppCompatImageView appCompatImageView6, FocusedBorderTextInput focusedBorderTextInput7, TextView textView8, TextView textView9, FocusedBorderTextInput focusedBorderTextInput10, TextView textView11, NestedScrollView nestedScrollView12, MaterialButton materialButton13, TextView textView14, CheckBox checkBox15, CheckBox checkBox16, CheckBox checkBox17, CheckBox checkBox18, CheckBox checkBox19, CheckBox checkBox20, CheckBox checkBox21, MaterialToolbar materialToolbar22, TextView textView23) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = linearLayout4;
        obj.P = materialButton13;
        obj.Q = checkBox15;
        obj.R = checkBox16;
        obj.S = checkBox17;
        obj.T = checkBox18;
        obj.U = checkBox19;
        obj.V = checkBox20;
        obj.W = checkBox21;
        obj.X = materialToolbar22;
        obj.Y = textView23;
    }

    public static app.dogo.com.dogo_android.h.wb T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return wb.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.wb U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (wb)ViewDataBinding.z(layoutInflater, 2131558652, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(l l);
}
