package app.dogo.com.dogo_android.h;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndObservable;

/* compiled from: CellChallengeFeedEndCardBinding.java */
/* loaded from: classes.dex */
public abstract class w0 extends ViewDataBinding {

    public final Button O;
    public final TextView P;
    protected ChallengeFeedEndObservable Q;
    protected w0(Object object, View view, int i, Button button, TextView textView) {
        super(object, view, i);
        this.O = button;
        this.P = textView;
    }

    public static w0 T(View view) {
        return w0.U(view, f.e());
    }

    @Deprecated
    public static w0 U(View view, Object object) {
        return (w0)ViewDataBinding.k(object, view, 2131558469);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ChallengeFeedEndObservable challengeFeedEndObservable);
}
