package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.a0.g.e;
import app.dogo.com.dogo_android.view.dailytraining.l;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* compiled from: ActivityMainBinding.java */
/* loaded from: classes.dex */
public abstract class m extends ViewDataBinding {

    public final ConstraintLayout O;
    public final FrameLayout P;
    protected e Q;
    protected l R;
    protected m(Object object, View view, int i, ConstraintLayout constraintLayout, FrameLayout frameLayout, FrameLayout frameLayout2, BottomNavigationView bottomNavigationView, FrameLayout frameLayout3, CoordinatorLayout coordinatorLayout) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = frameLayout3;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(l lVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(e eVar);
}
