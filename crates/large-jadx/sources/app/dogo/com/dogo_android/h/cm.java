package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;

/* compiled from: LayoutProgramCertificateInProgressBinding.java */
/* loaded from: classes.dex */
public abstract class cm extends ViewDataBinding {

    public final ImageView O;
    public final ProgressBar P;
    public final TextView Q;
    protected ProgramExamSummary R;
    protected cm(Object object, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, ProgressBar progressBar, TextView textView2) {
        super(object, view, i);
        this.O = imageView2;
        this.P = progressBar;
        this.Q = textView2;
    }

    public static cm T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return cm.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static cm U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (cm)ViewDataBinding.z(layoutInflater, 2131558796, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExamSummary programExamSummary);
}
