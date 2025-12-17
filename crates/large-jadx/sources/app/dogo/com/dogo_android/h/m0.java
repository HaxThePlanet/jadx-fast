package app.dogo.com.dogo_android.h;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.d.b.z.n;

/* loaded from: classes.dex */
public abstract class m0 extends ViewDataBinding {

    protected n O;
    protected m0(Object object, View view2, int i3) {
        super(object, view2, i3);
    }

    public static app.dogo.com.dogo_android.h.m0 T(View view) {
        return m0.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.m0 U(View view, Object object2) {
        return (m0)ViewDataBinding.k(object2, view, 2131558464);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n n);
}
