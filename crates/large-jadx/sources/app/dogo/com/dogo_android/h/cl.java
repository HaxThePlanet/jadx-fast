package app.dogo.com.dogo_android.h;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;

/* loaded from: classes.dex */
public abstract class cl extends ViewDataBinding {

    public final TextView O;
    public final AppCompatImageView P;
    protected Boolean Q;
    protected String R;
    protected Drawable S;
    protected cl(Object object, View view2, int i3, TextView textView4, ImageView imageView5, AppCompatImageView appCompatImageView6) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = appCompatImageView6;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Drawable drawable);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String string);
}
