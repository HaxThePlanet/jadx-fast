package app.dogo.com.dogo_android.h;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoObservable;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public abstract class c2 extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.sk O;
    protected EntryPhotoObservable P;
    protected a0 Q;
    protected c2(Object object, View view2, int i3, app.dogo.com.dogo_android.h.sk sk4) {
        super(object, view2, i3);
        this.O = sk4;
    }

    public static app.dogo.com.dogo_android.h.c2 T(View view) {
        return c2.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.c2 U(View view, Object object2) {
        return (c2)ViewDataBinding.k(object2, view, 2131558486);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(EntryPhotoObservable entryPhotoObservable);
}
