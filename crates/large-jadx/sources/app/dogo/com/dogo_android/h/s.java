package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.repository.domain.PermissionDescription;
import java.util.List;

/* loaded from: classes.dex */
public abstract class s extends ViewDataBinding {

    public final RecyclerView O;
    protected List<PermissionDescription> P;
    protected s(Object object, View view2, int i3, RecyclerView recyclerView4) {
        super(object, view2, i3);
        this.O = recyclerView4;
    }

    public static app.dogo.com.dogo_android.h.s T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return s.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.s U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (s)ViewDataBinding.z(layoutInflater, 2131558437, viewGroup2, z3, object4);
    }

    public abstract void V(List<PermissionDescription> list);
}
