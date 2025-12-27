package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.login_v2.b0;

/* compiled from: ActivityLoginBinding.java */
/* loaded from: classes.dex */
public abstract class i extends ViewDataBinding {

    public final CoordinatorLayout O;
    public final k P;
    public final FrameLayout Q;
    public final en R;
    protected b0 S;
    protected i(Object object, View view, int i, CoordinatorLayout coordinatorLayout, FrameLayout frameLayout, k kVar, FrameLayout frameLayout2, en enVar) {
        super(object, view, i);
        this.O = coordinatorLayout;
        this.P = kVar;
        this.Q = frameLayout2;
        this.R = enVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(b0 b0Var);
}
