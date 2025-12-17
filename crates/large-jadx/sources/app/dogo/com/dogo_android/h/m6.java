package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep;

/* loaded from: classes.dex */
public abstract class m6 extends ViewDataBinding {

    public final TextView O;
    public final ImageView P;
    protected TrickItem.TrickStep Q;
    protected m6(Object object, View view2, int i3, TextView textView4, ImageView imageView5) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = imageView5;
    }
}
