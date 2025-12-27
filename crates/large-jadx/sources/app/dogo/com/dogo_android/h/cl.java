package app.dogo.com.dogo_android.h;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;

/* compiled from: LayoutLibraryShortcutBinding.java */
/* loaded from: classes.dex */
public abstract class cl extends ViewDataBinding {

    public final TextView O;
    public final AppCompatImageView P;
    protected Boolean Q;
    protected String R;
    protected Drawable S;
    protected cl(Object object, View view, int i, TextView textView, ImageView imageView, AppCompatImageView appCompatImageView) {
        super(object, view, i);
        this.O = textView;
        this.P = appCompatImageView;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(Drawable drawable);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(Boolean boolean);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);
}
