package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;

/* compiled from: LayoutProgramCertificateCompletedBinding.java */
/* loaded from: classes.dex */
public abstract class am extends ViewDataBinding {

    public final ImageView O;
    protected ProgramExamSummary P;
    protected am(Object object, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, Guideline guideline, Button button, TextView textView2) {
        super(object, view, i);
        this.O = imageView;
    }

    public static am T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return am.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static am U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (am)ViewDataBinding.z(layoutInflater, 2131558795, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExamSummary programExamSummary);
}
