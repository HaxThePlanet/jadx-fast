package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.n.g;

/* loaded from: classes.dex */
public abstract class il extends ViewDataBinding {

    public final Button O;
    protected g P;
    protected il(Object object, View view2, int i3, ImageView imageView4, TextView textView5, Button button6, TextView textView7) {
        super(object, view2, i3);
        this.O = button6;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(g g);
}
