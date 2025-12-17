package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoObservable;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public abstract class k2 extends ViewDataBinding {

    public final app.dogo.com.dogo_android.h.sk O;
    public final TextView P;
    public final LinearLayout Q;
    public final ConstraintLayout R;
    public final TextView S;
    public final TextView T;
    protected EntryUserPhotoObservable U;
    protected a0 V;
    protected k2(Object object, View view2, int i3, app.dogo.com.dogo_android.h.sk sk4, TextView textView5, LinearLayout linearLayout6, ConstraintLayout constraintLayout7, TextView textView8, TextView textView9) {
        super(object, view2, i3);
        this.O = sk4;
        this.P = textView5;
        this.Q = linearLayout6;
        this.R = constraintLayout7;
        this.S = textView8;
        this.T = textView9;
    }

    public static app.dogo.com.dogo_android.h.k2 T(View view) {
        return k2.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.k2 U(View view, Object object2) {
        return (k2)ViewDataBinding.k(object2, view, 2131558490);
    }

    @Override // androidx.databinding.ViewDataBinding
    public a0 V() {
        return this.V;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(EntryUserPhotoObservable entryUserPhotoObservable);
}
