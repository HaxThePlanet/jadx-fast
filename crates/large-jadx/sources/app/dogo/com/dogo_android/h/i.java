package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.login_v2.b0;

/* loaded from: classes.dex */
public abstract class i extends ViewDataBinding {

    public final CoordinatorLayout O;
    public final app.dogo.com.dogo_android.h.k P;
    public final FrameLayout Q;
    public final app.dogo.com.dogo_android.h.en R;
    protected b0 S;
    protected i(Object object, View view2, int i3, CoordinatorLayout coordinatorLayout4, FrameLayout frameLayout5, app.dogo.com.dogo_android.h.k k6, FrameLayout frameLayout7, app.dogo.com.dogo_android.h.en en8) {
        super(object, view2, i3);
        this.O = coordinatorLayout4;
        this.P = k6;
        this.Q = frameLayout7;
        this.R = en8;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(b0 b0);
}
