package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.button.MaterialButton;

/* compiled from: TooltipCalendarBinding.java */
/* loaded from: classes.dex */
public abstract class sn extends ViewDataBinding {

    public final MaterialButton O;
    protected sn(Object object, View view, int i, MaterialButton materialButton, TextView textView) {
        super(object, view, i);
        this.O = materialButton;
    }

    public static sn T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return sn.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static sn U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (sn)ViewDataBinding.z(layoutInflater, 2131558928, viewGroup, z, object);
    }
}
