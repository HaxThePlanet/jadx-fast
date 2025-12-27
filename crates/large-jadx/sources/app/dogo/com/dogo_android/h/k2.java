package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoObservable;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: CellEntryUserPhotoItemBinding.java */
/* loaded from: classes.dex */
public abstract class k2 extends ViewDataBinding {

    public final sk O;
    public final TextView P;
    public final LinearLayout Q;
    public final ConstraintLayout R;
    public final TextView S;
    public final TextView T;
    protected EntryUserPhotoObservable U;
    protected a0 V;
    protected k2(Object object, View view, int i, sk skVar, TextView textView, LinearLayout linearLayout, ConstraintLayout constraintLayout, TextView textView2, TextView textView3) {
        super(object, view, i);
        this.O = skVar;
        this.P = textView;
        this.Q = linearLayout;
        this.R = constraintLayout;
        this.S = textView2;
        this.T = textView3;
    }

    public static k2 T(View view) {
        return k2.U(view, f.e());
    }

    @Deprecated
    public static k2 U(View view, Object object) {
        return (k2)ViewDataBinding.k(object, view, 2131558490);
    }

    @Override // androidx.databinding.ViewDataBinding
    public a0 V() {
        return this.V;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(EntryUserPhotoObservable entryUserPhotoObservable);
}
