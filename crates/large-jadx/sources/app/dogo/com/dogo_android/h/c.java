package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.dogcreation.g;

/* loaded from: classes.dex */
public abstract class c extends ViewDataBinding {

    public final FrameLayout O;
    protected c(Object object, View view2, int i3, FrameLayout frameLayout4) {
        super(object, view2, i3);
        this.O = frameLayout4;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(g g);
}
