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

/* compiled from: CellProgramExamPendingCardBinding.java */
/* loaded from: classes.dex */
public abstract class i4 extends ViewDataBinding {

    public final ConstraintLayout O;
    public final ImageView P;
    public final TextView Q;
    public final TextView R;
    public final ImageView S;
    public final ImageView T;
    protected ProgramExam U;
    protected i4(Object object, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = imageView;
        this.Q = textView;
        this.R = textView2;
        this.S = imageView2;
        this.T = imageView3;
    }

    public static i4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return i4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static i4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (i4)ViewDataBinding.z(layoutInflater, 2131558515, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
