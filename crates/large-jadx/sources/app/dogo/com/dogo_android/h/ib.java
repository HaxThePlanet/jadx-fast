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

/* compiled from: FragmentDogCreationBreedSearchDialogBinding.java */
/* loaded from: classes.dex */
public abstract class ib extends ViewDataBinding {

    public final FrameLayout O;
    public final RecyclerView P;
    public final EditText Q;
    public final MaterialToolbar R;
    protected m S;
    protected i.b T;
    protected ib(Object object, View view, int i, FrameLayout frameLayout, RecyclerView recyclerView, ImageView imageView, EditText editText, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = frameLayout;
        this.P = recyclerView;
        this.Q = editText;
        this.R = materialToolbar;
    }

    public static ib T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ib.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ib U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ib)ViewDataBinding.z(layoutInflater, 2131558645, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(i.b bVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(m mVar);
}
