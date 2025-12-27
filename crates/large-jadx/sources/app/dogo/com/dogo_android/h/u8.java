package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.e.k.a;
import app.dogo.com.dogo_android.e.n;

/* compiled from: DialogClickerSelectBinding.java */
/* loaded from: classes.dex */
public abstract class u8 extends ViewDataBinding {

    public final Button O;
    public final ConstraintLayout P;
    public final RecyclerView Q;
    protected n R;
    protected k.a S;
    protected u8(Object object, View view, int i, Button button, ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView) {
        super(object, view, i);
        this.O = button;
        this.P = constraintLayout;
        this.Q = recyclerView;
    }

    public static u8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return u8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static u8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (u8)ViewDataBinding.z(layoutInflater, 2131558598, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(k.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(n nVar);
}
