package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;

/* compiled from: CellProgramOverviewExamRejectedGridItemBinding.java */
/* loaded from: classes.dex */
public abstract class w5 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    protected ProgramExam Q;
    protected w5(Object object, View view, int i, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, TextView textView) {
        super(object, view, i);
        this.O = imageView2;
        this.P = textView;
    }

    public static w5 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return w5.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static w5 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (w5)ViewDataBinding.z(layoutInflater, 2131558535, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
