package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;

/* compiled from: CellProgramOverviewExamReadyGridItemBinding.java */
/* loaded from: classes.dex */
public abstract class u5 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    protected ProgramExam Q;
    protected u5(Object object, View view, int i, ImageView imageView, TextView textView) {
        super(object, view, i);
        this.O = imageView;
        this.P = textView;
    }

    public static u5 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return u5.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static u5 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (u5)ViewDataBinding.z(layoutInflater, 2131558534, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
