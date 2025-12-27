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

/* compiled from: FragmentFaqListBinding.java */
/* loaded from: classes.dex */
public abstract class ed extends ViewDataBinding {

    public final FrameLayout O;
    public final RecyclerView P;
    public final EditText Q;
    public final MaterialToolbar R;
    protected i S;
    protected j.a T;
    protected ed(Object object, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, RecyclerView recyclerView, EditText editText, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = frameLayout;
        this.P = recyclerView;
        this.Q = editText;
        this.R = materialToolbar;
    }

    public static ed T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ed.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ed U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ed)ViewDataBinding.z(layoutInflater, 2131558669, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(j.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(i iVar);
}
