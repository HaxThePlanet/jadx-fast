package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;

/* compiled from: CellProgramExamPremiumLockedBinding.java */
/* loaded from: classes.dex */
public abstract class k4 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    public final ImageView Q;
    protected ProgramExam R;
    protected k4(Object object, View view, int i, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, ImageView imageView3, ImageView imageView4) {
        super(object, view, i);
        this.O = imageView;
        this.P = textView;
        this.Q = imageView3;
    }

    public static k4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return k4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static k4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (k4)ViewDataBinding.z(layoutInflater, 2131558516, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
