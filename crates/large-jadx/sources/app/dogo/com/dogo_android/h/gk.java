package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.g.e0;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;

/* loaded from: classes.dex */
public abstract class gk extends ViewDataBinding {

    public final RecyclerView O;
    public final ImageView P;
    public final Button Q;
    public final app.dogo.com.dogo_android.h.kn R;
    protected e0 S;
    protected WorkoutSession T;
    protected gk(Object object, View view2, int i3, TextView textView4, RecyclerView recyclerView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, Button button9, app.dogo.com.dogo_android.h.kn kn10, TextView textView11) {
        super(object, view2, i3);
        this.O = recyclerView5;
        this.P = imageView6;
        this.Q = button9;
        this.R = kn10;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(e0 e0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(WorkoutSession workoutSession);
}
