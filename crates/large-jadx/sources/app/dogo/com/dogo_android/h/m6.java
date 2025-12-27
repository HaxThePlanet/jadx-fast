package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep;

/* compiled from: CellProgramTrainingTrickBinding.java */
/* loaded from: classes.dex */
public abstract class m6 extends ViewDataBinding {

    public final TextView O;
    public final ImageView P;
    protected TrickItem.TrickStep Q;
    protected m6(Object object, View view, int i, TextView textView, ImageView imageView) {
        super(object, view, i);
        this.O = textView;
        this.P = imageView;
    }
}
