package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.o;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class oj extends ViewDataBinding {

    public final ImageView O;
    public final MaterialButton P;
    protected o Q;
    protected oj(Object object, View view2, int i3, ImageView imageView4, TextView textView5, TextView textView6, ImageView imageView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, MaterialButton materialButton12, TextView textView13) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = materialButton12;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o o);
}
