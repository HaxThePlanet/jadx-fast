package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.PermissionDescription;
import java.util.List;

/* compiled from: AlertDialogPermissionExplanationBinding.java */
/* loaded from: classes.dex */
public abstract class s extends ViewDataBinding {

    public final RecyclerView O;
    protected List<PermissionDescription> P;
    protected s(Object object, View view, int i, RecyclerView recyclerView) {
        super(object, view, i);
        this.O = recyclerView;
    }

    public static s T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return s.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static s U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (s)ViewDataBinding.z(layoutInflater, 2131558437, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(List<PermissionDescription> list);
}
