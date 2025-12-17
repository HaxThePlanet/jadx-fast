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

/* loaded from: classes.dex */
public abstract class q5 extends ViewDataBinding {

    public final View O;
    public final RecyclerView P;
    protected ProgramLesson Q;
    protected q5(Object object, View view2, int i3, View view4, RecyclerView recyclerView5, ImageView imageView6, TextView textView7, TextView textView8) {
        super(object, view2, i3);
        this.O = view4;
        this.P = recyclerView5;
    }

    public static app.dogo.com.dogo_android.h.q5 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return q5.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.q5 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (q5)ViewDataBinding.z(layoutInflater, 2131558532, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramLesson programLesson);
}
