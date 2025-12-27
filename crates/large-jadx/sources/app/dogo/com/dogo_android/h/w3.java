package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.PottyRemindersItem;

/* compiled from: CellPottyOverviewReminderBinding.java */
/* loaded from: classes.dex */
public abstract class w3 extends ViewDataBinding {

    public final TextView O;
    public final SwitchCompat P;
    public final TextView Q;
    protected PottyRemindersItem R;
    protected w3(Object object, View view, int i, TextView textView, SwitchCompat switchCompat, TextView textView2) {
        super(object, view, i);
        this.O = textView;
        this.P = switchCompat;
        this.Q = textView2;
    }

    public static w3 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return w3.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static w3 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (w3)ViewDataBinding.z(layoutInflater, 2131558509, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(PottyRemindersItem pottyRemindersItem);
}
