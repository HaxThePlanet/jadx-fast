package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.g.e0;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;

/* compiled from: LayoutDashboardWorkoutCardBinding.java */
/* loaded from: classes.dex */
public abstract class gk extends ViewDataBinding {

    public final RecyclerView O;
    public final ImageView P;
    public final Button Q;
    public final kn R;
    protected e0 S;
    protected WorkoutSession T;
    protected gk(Object object, View view, int i, TextView textView, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, ImageView imageView3, Button button, kn knVar, TextView textView2) {
        super(object, view, i);
        this.O = recyclerView;
        this.P = imageView;
        this.Q = button;
        this.R = knVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(e0 e0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(WorkoutSession workoutSession);
}
