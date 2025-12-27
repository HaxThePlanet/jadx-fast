package app.dogo.com.dogo_android.h;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.d.b.z.n;

/* compiled from: CellChallengeCommentsTitleBinding.java */
/* loaded from: classes.dex */
public abstract class m0 extends ViewDataBinding {

    protected n O;
    protected m0(Object object, View view, int i) {
        super(object, view, i);
    }

    public static m0 T(View view) {
        return m0.U(view, f.e());
    }

    @Deprecated
    public static m0 U(View view, Object object) {
        return (m0)ViewDataBinding.k(object, view, 2131558464);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(n nVar);
}
