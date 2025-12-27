package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.button.MaterialButton;

/* compiled from: TooltipWorkoutClickerBinding.java */
/* loaded from: classes.dex */
public abstract class wn extends ViewDataBinding {

    public final MaterialButton O;
    public final TextView P;
    protected wn(Object object, View view, int i, MaterialButton materialButton, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = materialButton;
        this.P = textView2;
    }

    public static wn T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return wn.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static wn U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (wn)ViewDataBinding.z(layoutInflater, 2131558930, viewGroup, z, object);
    }
}
