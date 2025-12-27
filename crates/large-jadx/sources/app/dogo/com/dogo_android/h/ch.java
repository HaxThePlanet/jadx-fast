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

/* compiled from: FragmentTrainingReminderWithTimeBinding.java */
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
    protected ch(Object object, View view, int i, LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, FocusedBorderTextInput focusedBorderTextInput, TextView textView4, TextView textView5, Guideline guideline, FocusedBorderTextInput focusedBorderTextInput2, TextView textView6, NestedScrollView nestedScrollView, Guideline guideline2, MaterialButton materialButton, TextView textView7, TextView textView8, TextView textView9, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, MaterialToolbar materialToolbar, TextView textView10, TextView textView11) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = linearLayout;
        object2.P = textView2;
        object2.Q = textView3;
        object2.R = materialButton;
        object2.S = textView7;
        object2.T = textView8;
        object2.U = checkBox;
        object2.V = checkBox2;
        object2.W = checkBox3;
        object2.X = checkBox4;
        object2.Y = checkBox5;
        object2.Z = checkBox6;
        object2.a0 = checkBox7;
        object2.b0 = materialToolbar;
    }

    public static ch T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ch.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ch U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ch)ViewDataBinding.z(layoutInflater, 2131558721, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l lVar);
}
