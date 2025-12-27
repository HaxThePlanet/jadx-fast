package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;

/* compiled from: CellProgramTaskIncompleteItemBinding.java */
/* loaded from: classes.dex */
public abstract class g6 extends ViewDataBinding {

    public final TextView O;
    protected ProgramTasks P;
    protected g6(Object object, View view, int i, ImageView imageView, TextView textView) {
        super(object, view, i);
        this.O = textView;
    }

    public static g6 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return g6.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static g6 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (g6)ViewDataBinding.z(layoutInflater, 2131558540, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramTasks programTasks);
}
