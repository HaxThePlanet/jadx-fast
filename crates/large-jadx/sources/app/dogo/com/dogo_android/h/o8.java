package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class o8 extends ViewDataBinding {

    public final RecyclerView O;
    public final app.dogo.com.dogo_android.h.cn P;
    protected o8(Object object, View view2, int i3, RecyclerView recyclerView4, app.dogo.com.dogo_android.h.cn cn5) {
        super(object, view2, i3);
        this.O = recyclerView4;
        this.P = cn5;
    }

    public static app.dogo.com.dogo_android.h.o8 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return o8.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.o8 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (o8)ViewDataBinding.z(layoutInflater, 2131558595, viewGroup2, z3, object4);
    }
}
