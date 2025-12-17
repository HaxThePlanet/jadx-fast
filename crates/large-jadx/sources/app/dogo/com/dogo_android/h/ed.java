package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.t.g0.i;
import app.dogo.com.dogo_android.t.g0.j.a;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class ed extends ViewDataBinding {

    public final FrameLayout O;
    public final RecyclerView P;
    public final EditText Q;
    public final MaterialToolbar R;
    protected i S;
    protected j.a T;
    protected ed(Object object, View view2, int i3, FrameLayout frameLayout4, AppCompatImageView appCompatImageView5, RecyclerView recyclerView6, EditText editText7, MaterialToolbar materialToolbar8) {
        super(object, view2, i3);
        this.O = frameLayout4;
        this.P = recyclerView6;
        this.Q = editText7;
        this.R = materialToolbar8;
    }

    public static app.dogo.com.dogo_android.h.ed T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ed.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ed U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ed)ViewDataBinding.z(layoutInflater, 2131558669, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(j.a j$a);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(i i);
}
