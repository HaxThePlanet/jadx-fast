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

/* compiled from: CellExamHistoryPendingBinding.java */
/* loaded from: classes.dex */
public abstract class o2 extends ViewDataBinding {

    public final TextView O;
    public final ConstraintLayout P;
    public final ImageView Q;
    public final TextView R;
    public final TextView S;
    public final ImageView T;
    protected ProgramExam U;
    protected o2(Object object, View view, int i, TextView textView, ConstraintLayout constraintLayout, ImageView imageView, TextView textView2, TextView textView3, ImageView imageView2) {
        super(object, view, i);
        this.O = textView;
        this.P = constraintLayout;
        this.Q = imageView;
        this.R = textView2;
        this.S = textView3;
        this.T = imageView2;
    }

    public static o2 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return o2.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static o2 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (o2)ViewDataBinding.z(layoutInflater, 2131558492, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
