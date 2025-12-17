package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.dogcreation.j.i.b;
import app.dogo.com.dogo_android.dogcreation.j.m;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class ib extends ViewDataBinding {

    public final FrameLayout O;
    public final RecyclerView P;
    public final EditText Q;
    public final MaterialToolbar R;
    protected m S;
    protected i.b T;
    protected ib(Object object, View view2, int i3, FrameLayout frameLayout4, RecyclerView recyclerView5, ImageView imageView6, EditText editText7, MaterialToolbar materialToolbar8) {
        super(object, view2, i3);
        this.O = frameLayout4;
        this.P = recyclerView5;
        this.Q = editText7;
        this.R = materialToolbar8;
    }

    public static app.dogo.com.dogo_android.h.ib T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return ib.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.ib U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (ib)ViewDataBinding.z(layoutInflater, 2131558645, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(i.b i$b);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(m m);
}
