package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoObservable;

/* loaded from: classes.dex */
public abstract class a2 extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.sk O;
    public final ImageView P;
    public final RelativeLayout Q;
    protected EntryOldPhotoObservable R;
    protected a2(Object object, View view2, int i3, app.dogo.com.dogo_android.h.sk sk4, ImageView imageView5, RelativeLayout relativeLayout6) {
        super(object, view2, i3);
        this.O = sk4;
        this.P = imageView5;
        this.Q = relativeLayout6;
    }

    public static app.dogo.com.dogo_android.h.a2 T(View view) {
        return a2.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.a2 U(View view, Object object2) {
        return (a2)ViewDataBinding.k(object2, view, 2131558485);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(EntryOldPhotoObservable entryOldPhotoObservable);
}
