package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* loaded from: classes.dex */
public abstract class im extends ViewDataBinding {

    protected String O;
    protected im(Object object, View view2, int i3, AppCompatImageView appCompatImageView4) {
        super(object, view2, i3);
    }

    public static app.dogo.com.dogo_android.h.im T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return im.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.im U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (im)ViewDataBinding.z(layoutInflater, 2131558799, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String string);
}
