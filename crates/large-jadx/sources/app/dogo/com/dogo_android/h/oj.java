package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.o;
import com.google.android.material.button.MaterialButton;

/* compiled from: LayoutDashboardResubscribeBinding.java */
/* loaded from: classes.dex */
public abstract class oj extends ViewDataBinding {

    public final ImageView O;
    public final MaterialButton P;
    protected o Q;
    protected oj(Object object, View view, int i, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, MaterialButton materialButton, TextView textView7) {
        super(object, view, i);
        this.O = imageView;
        this.P = materialButton;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(o oVar);
}
