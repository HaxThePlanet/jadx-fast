package app.dogo.com.dogo_android.h;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoObservable;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: CellEntryPhotoItemBinding.java */
/* loaded from: classes.dex */
public abstract class c2 extends ViewDataBinding {

    public final sk O;
    protected EntryPhotoObservable P;
    protected a0 Q;
    protected c2(Object object, View view, int i, sk skVar) {
        super(object, view, i);
        this.O = skVar;
    }

    public static c2 T(View view) {
        return c2.U(view, f.e());
    }

    @Deprecated
    public static c2 U(View view, Object object) {
        return (c2)ViewDataBinding.k(object, view, 2131558486);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(EntryPhotoObservable entryPhotoObservable);
}
