package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;

/* compiled from: CellProgramExamReadyCardBinding.java */
/* loaded from: classes.dex */
public abstract class m4 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    public final ImageView Q;
    protected ProgramExam R;
    protected m4(Object object, View view, int i, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, ImageView imageView3) {
        super(object, view, i);
        this.O = imageView;
        this.P = textView;
        this.Q = imageView2;
    }

    public static m4 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m4.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static m4 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (m4)ViewDataBinding.z(layoutInflater, 2131558517, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramExam programExam);
}
