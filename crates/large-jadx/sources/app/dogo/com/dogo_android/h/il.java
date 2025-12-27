package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.n.g;

/* compiled from: LayoutLibrarySubscribeBinding.java */
/* loaded from: classes.dex */
public abstract class il extends ViewDataBinding {

    public final Button O;
    protected g P;
    protected il(Object object, View view, int i, ImageView imageView, TextView textView, Button button, TextView textView2) {
        super(object, view, i);
        this.O = button;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(g gVar);
}
