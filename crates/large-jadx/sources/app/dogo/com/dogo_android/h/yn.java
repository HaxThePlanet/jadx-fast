package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.button.MaterialButton;

/* compiled from: TooltipWorkoutTrickBinding.java */
/* loaded from: classes.dex */
public abstract class yn extends ViewDataBinding {

    public final MaterialButton O;
    public final TextView P;
    protected yn(Object object, View view, int i, MaterialButton materialButton, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = materialButton;
        this.P = textView2;
    }

    public static yn T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return yn.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static yn U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (yn)ViewDataBinding.z(layoutInflater, 2131558931, viewGroup, z, object);
    }
}
