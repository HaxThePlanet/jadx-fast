package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.u.h;

/* compiled from: LayoutBitingProgramProgressBinding.java */
/* loaded from: classes.dex */
public abstract class uh extends ViewDataBinding {

    protected h O;
    protected uh(Object object, View view, int i, TextView textView) {
        super(object, view, i);
    }

    public static uh T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return uh.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static uh U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (uh)ViewDataBinding.z(layoutInflater, 2131558739, viewGroup, z, object);
    }
}
