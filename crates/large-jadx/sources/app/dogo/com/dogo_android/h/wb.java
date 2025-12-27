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

/* compiled from: FragmentDogCreationReminderWithTimeBinding.java */
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
    protected wb(Object object, View view, int i, LinearLayout linearLayout, TextView textView, AppCompatImageView appCompatImageView, FocusedBorderTextInput focusedBorderTextInput, TextView textView2, TextView textView3, FocusedBorderTextInput focusedBorderTextInput2, TextView textView4, NestedScrollView nestedScrollView, MaterialButton materialButton, TextView textView5, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, MaterialToolbar materialToolbar, TextView textView6) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = linearLayout;
        object2.P = materialButton;
        object2.Q = checkBox;
        object2.R = checkBox2;
        object2.S = checkBox3;
        object2.T = checkBox4;
        object2.U = checkBox5;
        object2.V = checkBox6;
        object2.W = checkBox7;
        object2.X = materialToolbar;
        object2.Y = textView6;
    }

    public static wb T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return wb.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static wb U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (wb)ViewDataBinding.z(layoutInflater, 2131558652, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(l lVar);
}
