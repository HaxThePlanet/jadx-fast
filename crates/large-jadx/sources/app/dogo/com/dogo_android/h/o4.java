package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellProgramExamUnavailableHeaderBinding.java */
/* loaded from: classes.dex */
public abstract class o4 extends ViewDataBinding {
    protected o4(Object object, View view, int i, TextView textView, TextView textView2) {
        super(object, view, i);
    }

    public static o4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return o4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static o4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (o4)ViewDataBinding.z(layoutInflater, 2131558518, viewGroup, z, object);
    }
}
