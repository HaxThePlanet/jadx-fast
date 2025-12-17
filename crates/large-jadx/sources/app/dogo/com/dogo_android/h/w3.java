package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;

/* loaded from: classes.dex */
public abstract class w3 extends ViewDataBinding {

    public final TextView O;
    public final SwitchCompat P;
    public final TextView Q;
    protected PottyRemindersItem R;
    protected w3(Object object, View view2, int i3, TextView textView4, SwitchCompat switchCompat5, TextView textView6) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = switchCompat5;
        this.Q = textView6;
    }

    public static app.dogo.com.dogo_android.h.w3 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return w3.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.w3 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (w3)ViewDataBinding.z(layoutInflater, 2131558509, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(PottyRemindersItem pottyRemindersItem);
}
