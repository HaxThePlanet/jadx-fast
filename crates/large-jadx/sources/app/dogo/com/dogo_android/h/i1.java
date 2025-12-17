package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* loaded from: classes.dex */
public abstract class i1 extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final ImageView Q;
    protected TrickItem R;
    protected i1(Object object, View view2, int i3, TextView textView4, TextView textView5, ImageView imageView6) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = textView5;
        this.Q = imageView6;
    }
}
