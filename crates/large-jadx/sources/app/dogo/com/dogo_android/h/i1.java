package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* compiled from: CellDailyTrickBinding.java */
/* loaded from: classes.dex */
public abstract class i1 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final ImageView Q;
    protected TrickItem R;
    protected i1(Object object, View view, int i, TextView textView, TextView textView2, ImageView imageView) {
        super(object, view, i);
        this.O = textView;
        this.P = textView2;
        this.Q = imageView;
    }
}
