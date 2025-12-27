package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentClickerHelpBinding.java */
/* loaded from: classes.dex */
public abstract class ma extends ViewDataBinding {

    public final ConstraintLayout O;
    public final MaterialToolbar P;
    protected ma(Object object, View view, int i, ConstraintLayout constraintLayout, TextView textView, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = materialToolbar;
    }

    public static ma T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ma.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ma U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ma)ViewDataBinding.z(layoutInflater, 2131558634, viewGroup, z, object);
    }
}
