package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.button.MaterialButton;

/* compiled from: TooltipTrickDetailsClickerBinding.java */
/* loaded from: classes.dex */
public abstract class un extends ViewDataBinding {

    public final MaterialButton O;
    public final TextView P;
    protected un(Object object, View view, int i, MaterialButton materialButton, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = materialButton;
        this.P = textView;
    }

    public static un T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return un.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static un U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (un)ViewDataBinding.z(layoutInflater, 2131558929, viewGroup, z, object);
    }
}
