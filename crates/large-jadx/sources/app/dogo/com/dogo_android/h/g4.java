package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;

/* compiled from: CellProgramExamLockedCardBinding.java */
/* loaded from: classes.dex */
public abstract class g4 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    protected ProgramExam Q;
    protected g4(Object object, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = imageView;
        this.P = textView;
    }

    public static g4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return g4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static g4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (g4)ViewDataBinding.z(layoutInflater, 2131558514, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
