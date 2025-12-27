package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellProgramListHeaderBinding.java */
/* loaded from: classes.dex */
public abstract class m5 extends ViewDataBinding {

    public final ConstraintLayout O;
    protected m5(Object object, View view, int i, ConstraintLayout constraintLayout, TextView textView) {
        super(object, view, i);
        this.O = constraintLayout;
    }

    public static m5 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m5.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static m5 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (m5)ViewDataBinding.z(layoutInflater, 2131558530, viewGroup, z, object);
    }
}
