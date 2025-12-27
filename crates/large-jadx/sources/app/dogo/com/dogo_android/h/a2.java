package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoObservable;

/* compiled from: CellEntryOldPhotoItemBinding.java */
/* loaded from: classes.dex */
public abstract class a2 extends ViewDataBinding {

    public final sk O;
    public final ImageView P;
    public final RelativeLayout Q;
    protected EntryOldPhotoObservable R;
    protected a2(Object object, View view, int i, sk skVar, ImageView imageView, RelativeLayout relativeLayout) {
        super(object, view, i);
        this.O = skVar;
        this.P = imageView;
        this.Q = relativeLayout;
    }

    public static a2 T(View view) {
        return a2.U(view, f.e());
    }

    @Deprecated
    public static a2 U(View view, Object object) {
        return (a2)ViewDataBinding.k(object, view, 2131558485);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(EntryOldPhotoObservable entryOldPhotoObservable);
}
