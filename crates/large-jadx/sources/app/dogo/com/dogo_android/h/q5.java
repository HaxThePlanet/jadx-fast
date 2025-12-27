package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;

/* compiled from: CellProgramOverviewExamItemBinding.java */
/* loaded from: classes.dex */
public abstract class q5 extends ViewDataBinding {

    public final View O;
    public final RecyclerView P;
    protected ProgramLesson Q;
    protected q5(Object object, View view, int i, View view2, RecyclerView recyclerView, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = view2;
        this.P = recyclerView;
    }

    public static q5 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return q5.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static q5 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (q5)ViewDataBinding.z(layoutInflater, 2131558532, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramLesson programLesson);
}
