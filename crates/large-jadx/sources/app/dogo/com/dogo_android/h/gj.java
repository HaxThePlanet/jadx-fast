package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* compiled from: LayoutDashboardProgramCompleteBinding.java */
/* loaded from: classes.dex */
public abstract class gj extends ViewDataBinding {

    public final Button O;
    public final CardView P;
    public final Button Q;
    protected ProgramDescriptionItem R;
    protected o S;
    protected gj(Object object, View view, int i, ImageView imageView, Button button, ImageView imageView2, CardView cardView, ImageView imageView3, TextView textView, TextView textView2, Button button2) {
        super(object, view, i);
        this.O = button;
        this.P = cardView;
        this.Q = button2;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o oVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(ProgramDescriptionItem programDescriptionItem);
}
