package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import app.dogo.com.dogo_android.a0.g.e;
import app.dogo.com.dogo_android.view.dailytraining.l;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/* loaded from: classes.dex */
public abstract class m extends ViewDataBinding {

    public final ConstraintLayout O;
    public final FrameLayout P;
    protected e Q;
    protected l R;
    protected m(Object object, View view2, int i3, ConstraintLayout constraintLayout4, FrameLayout frameLayout5, FrameLayout frameLayout6, BottomNavigationView bottomNavigationView7, FrameLayout frameLayout8, CoordinatorLayout coordinatorLayout9) {
        super(object, view2, i3);
        this.O = constraintLayout4;
        this.P = frameLayout8;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(l l);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(e e);
}
