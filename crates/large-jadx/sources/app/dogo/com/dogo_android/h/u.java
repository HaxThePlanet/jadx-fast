package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.PermissionDescription;
import java.util.List;

/* compiled from: AlertDialogPermissionMissingBinding.java */
/* loaded from: classes.dex */
public abstract class u extends ViewDataBinding {

    public final RecyclerView O;
    protected List<PermissionDescription> P;
    protected u(Object object, View view, int i, RecyclerView recyclerView, TextView textView) {
        super(object, view, i);
        this.O = recyclerView;
    }

    public static u T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return u.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static u U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (u)ViewDataBinding.z(layoutInflater, 2131558438, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(List<PermissionDescription> list);
}
