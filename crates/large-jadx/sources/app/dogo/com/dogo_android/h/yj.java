package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.g.v;

/* compiled from: LayoutDashboardSurveyCardBinding.java */
/* loaded from: classes.dex */
public abstract class yj extends ViewDataBinding {

    public final Button O;
    public final Button P;
    protected v Q;
    protected yj(Object object, View view, int i, Button button, TextView textView, ImageView imageView, ImageView imageView2, ImageView imageView3, Button button2, TextView textView2) {
        super(object, view, i);
        this.O = button;
        this.P = button2;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(v vVar);
}
