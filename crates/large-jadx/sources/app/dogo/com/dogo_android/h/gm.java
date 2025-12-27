package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.Program;

/* compiled from: LayoutProgramOverviewCertificateBinding.java */
/* loaded from: classes.dex */
public abstract class gm extends ViewDataBinding {

    public final ImageView O;
    public final CardView P;
    public final TextView Q;
    protected Program R;
    protected gm(Object object, View view, int i, ImageView imageView, ImageView imageView2, CardView cardView, TextView textView) {
        super(object, view, i);
        this.O = imageView2;
        this.P = cardView;
        this.Q = textView;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Program program);
}
