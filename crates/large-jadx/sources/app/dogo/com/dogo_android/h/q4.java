package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellProgramLearningBinding.java */
/* loaded from: classes.dex */
public abstract class q4 extends ViewDataBinding {

    public final TextView O;
    protected String P;
    protected q4(Object object, View view, int i, ImageView imageView, TextView textView) {
        super(object, view, i);
        this.O = textView;
    }

    public static q4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return q4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static q4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (q4)ViewDataBinding.z(layoutInflater, 2131558519, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);
}
