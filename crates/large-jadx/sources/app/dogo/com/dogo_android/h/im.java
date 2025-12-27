package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: LayoutProgramOverviewPointBinding.java */
/* loaded from: classes.dex */
public abstract class im extends ViewDataBinding {

    protected String O;
    protected im(Object object, View view, int i, AppCompatImageView appCompatImageView) {
        super(object, view, i);
    }

    public static im T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return im.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static im U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (im)ViewDataBinding.z(layoutInflater, 2131558799, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);
}
