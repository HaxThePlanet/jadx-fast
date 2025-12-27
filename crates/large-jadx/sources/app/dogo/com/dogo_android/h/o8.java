package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: DialogChallengeProfileBinding.java */
/* loaded from: classes.dex */
public abstract class o8 extends ViewDataBinding {

    public final RecyclerView O;
    public final cn P;
    protected o8(Object object, View view, int i, RecyclerView recyclerView, cn cnVar) {
        super(object, view, i);
        this.O = recyclerView;
        this.P = cnVar;
    }

    public static o8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return o8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static o8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (o8)ViewDataBinding.z(layoutInflater, 2131558595, viewGroup, z, object);
    }
}
