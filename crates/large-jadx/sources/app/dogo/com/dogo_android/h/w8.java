package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.u.n.p.m.b.a;
import app.dogo.com.dogo_android.u.n.p.m.e;

/* compiled from: DialogDogLogSelectBinding.java */
/* loaded from: classes.dex */
public abstract class w8 extends ViewDataBinding {

    public final RecyclerView O;
    protected e P;
    protected b.a Q;
    protected w8(Object object, View view, int i, RecyclerView recyclerView) {
        super(object, view, i);
        this.O = recyclerView;
    }

    public static w8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return w8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static w8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (w8)ViewDataBinding.z(layoutInflater, 2131558599, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(b.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e eVar);
}
