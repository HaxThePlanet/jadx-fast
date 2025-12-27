package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellProgramLessonHeaderItemBinding.java */
/* loaded from: classes.dex */
public abstract class a5 extends ViewDataBinding {

    public final TextView O;
    protected String P;
    protected a5(Object object, View view, int i, TextView textView) {
        super(object, view, i);
        this.O = textView;
    }

    public static a5 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return a5.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static a5 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (a5)ViewDataBinding.z(layoutInflater, 2131558524, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);
}
