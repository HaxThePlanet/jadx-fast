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

/* loaded from: classes.dex */
public abstract class u8 extends ViewDataBinding {

    public final Button O;
    public final ConstraintLayout P;
    public final RecyclerView Q;
    protected n R;
    protected k.a S;
    protected u8(Object object, View view2, int i3, Button button4, ConstraintLayout constraintLayout5, RecyclerView recyclerView6, TextView textView7) {
        super(object, view2, i3);
        this.O = button4;
        this.P = constraintLayout5;
        this.Q = recyclerView6;
    }

    public static app.dogo.com.dogo_android.h.u8 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return u8.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.u8 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (u8)ViewDataBinding.z(layoutInflater, 2131558598, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(k.a k$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(n n);
}
