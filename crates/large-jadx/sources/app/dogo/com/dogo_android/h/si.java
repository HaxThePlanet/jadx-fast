package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.g.t;
import app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;

/* compiled from: LayoutDashboardCurrentLessonCardBinding.java */
/* loaded from: classes.dex */
public abstract class si extends ViewDataBinding {

    public final Button O;
    public final RecyclerView P;
    public final CardView Q;
    public final km R;
    public final ImageView S;
    public final TextView T;
    public final Button U;
    public final ImageView V;
    public final TextView W;
    public final TextView X;
    public final ImageView Y;
    public final TextView Z;
    protected ProgramLessonItem a0;
    protected ProgramCompletionSummary b0;
    protected t c0;
    protected si(Object object, View view, int i, Button button, RecyclerView recyclerView, ImageView imageView, CardView cardView, km kmVar, ImageView imageView2, TextView textView, ImageView imageView3, Button button2, ImageView imageView4, TextView textView2, TextView textView3, ImageView imageView5, TextView textView4) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = button;
        object2.P = recyclerView;
        object2.Q = cardView;
        object2.R = kmVar;
        object2.S = imageView2;
        object2.T = textView;
        object2.U = button2;
        object2.V = imageView4;
        object2.W = textView2;
        object2.X = textView3;
        object2.Y = imageView5;
        object2.Z = textView4;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(t tVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(ProgramLessonItem programLessonItem);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramCompletionSummary programCompletionSummary);
}
