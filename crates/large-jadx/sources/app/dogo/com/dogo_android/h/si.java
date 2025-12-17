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

/* loaded from: classes.dex */
public abstract class si extends ViewDataBinding {

    public final Button O;
    public final RecyclerView P;
    public final CardView Q;
    public final app.dogo.com.dogo_android.h.km R;
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
    protected si(Object object, View view2, int i3, Button button4, RecyclerView recyclerView5, ImageView imageView6, CardView cardView7, app.dogo.com.dogo_android.h.km km8, ImageView imageView9, TextView textView10, ImageView imageView11, Button button12, ImageView imageView13, TextView textView14, TextView textView15, ImageView imageView16, TextView textView17) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = button4;
        obj.P = recyclerView5;
        obj.Q = cardView7;
        obj.R = km8;
        obj.S = imageView9;
        obj.T = textView10;
        obj.U = button12;
        obj.V = imageView13;
        obj.W = textView14;
        obj.X = textView15;
        obj.Y = imageView16;
        obj.Z = textView17;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(t t);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(ProgramLessonItem programLessonItem);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProgramCompletionSummary programCompletionSummary);
}
