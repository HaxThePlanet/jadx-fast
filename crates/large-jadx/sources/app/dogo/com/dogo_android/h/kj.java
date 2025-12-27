package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.w;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;

/* compiled from: LayoutDashboardRecommendedProgramCardBinding.java */
/* loaded from: classes.dex */
public abstract class kj extends ViewDataBinding {

    public final Button O;
    public final CardView P;
    public final ImageView Q;
    public final TextView R;
    public final Button S;
    public final TextView T;
    public final TextView U;
    protected ProgramDescriptionItem V;
    protected w W;
    protected kj(Object object, View view, int i, Button button, ImageView imageView, CardView cardView, CardView cardView2, ImageView imageView2, TextView textView, TextView textView2, Button button2, TextView textView3, TextView textView4, TextView textView5) {
        super(object, view, i);
        this.O = button;
        this.P = cardView;
        this.Q = imageView2;
        this.R = textView;
        this.S = button2;
        this.T = textView3;
        this.U = textView5;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(w wVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(ProgramDescriptionItem programDescriptionItem);
}
