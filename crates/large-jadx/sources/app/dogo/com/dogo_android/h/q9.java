package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.subscription.redeemcoupon.RedeemCodeViewModel;

/* compiled from: DialogRedeemCodePromptBinding.java */
/* loaded from: classes.dex */
public abstract class q9 extends ViewDataBinding {

    public final Button O;
    public final AppCompatEditText P;
    public final Button Q;
    protected RedeemCodeViewModel R;
    protected q9(Object object, View view, int i, Button button, AppCompatEditText appCompatEditText, Button button2, TextView textView) {
        super(object, view, i);
        this.O = button;
        this.P = appCompatEditText;
        this.Q = button2;
    }

    public static q9 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return q9.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static q9 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (q9)ViewDataBinding.z(layoutInflater, 2131558611, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(RedeemCodeViewModel redeemCodeViewModel);
}
