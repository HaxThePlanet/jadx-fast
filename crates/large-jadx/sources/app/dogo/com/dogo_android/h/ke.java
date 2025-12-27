package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* compiled from: FragmentMetricsIntroDailyTimeBinding.java */
/* loaded from: classes.dex */
public abstract class ke extends ViewDataBinding {

    public final MaterialButton O;
    public final MaterialToolbar P;
    protected ke(Object object, View view, int i, TextView textView, AppCompatImageView appCompatImageView, MaterialButton materialButton, TextView textView2, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = materialButton;
        this.P = materialToolbar;
    }

    public static ke T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ke.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ke U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ke)ViewDataBinding.z(layoutInflater, 2131558686, viewGroup, z, object);
    }
}
