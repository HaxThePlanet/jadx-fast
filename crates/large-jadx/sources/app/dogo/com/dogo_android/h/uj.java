package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* compiled from: LayoutDashboardSpecialProgramCompletedBinding.java */
/* loaded from: classes.dex */
public abstract class uj extends ViewDataBinding {

    public final CardView O;
    public final Button P;
    protected ProgramDescriptionItem Q;
    protected o R;
    protected uj(Object object, View view, int i, TextView textView, ImageView imageView, ImageView imageView2, CardView cardView, Button button, ImageView imageView3, TextView textView2) {
        super(object, view, i);
        this.O = cardView;
        this.P = button;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o oVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(ProgramDescriptionItem programDescriptionItem);
}
