package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndObservable;

/* loaded from: classes.dex */
public abstract class w0 extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    protected ChallengeFeedEndObservable Q;
    protected w0(Object object, View view2, int i3, Button button4, TextView textView5) {
        super(object, view2, i3);
        this.O = button4;
        this.P = textView5;
    }

    public static app.dogo.com.dogo_android.h.w0 T(View view) {
        return w0.U(view, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.w0 U(View view, Object object2) {
        return (w0)ViewDataBinding.k(object2, view, 2131558469);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ChallengeFeedEndObservable challengeFeedEndObservable);
}
