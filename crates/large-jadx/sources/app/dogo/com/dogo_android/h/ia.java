package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.d.c.h;

/* compiled from: FragmentChallengeNotificationCenterBinding.java */
/* loaded from: classes.dex */
public abstract class ia extends ViewDataBinding {

    public final TextView O;
    public final RecyclerView P;
    public final cn Q;
    protected h R;
    protected ia(Object object, View view, int i, TextView textView, RecyclerView recyclerView, cn cnVar) {
        super(object, view, i);
        this.O = textView;
        this.P = recyclerView;
        this.Q = cnVar;
    }

    public static ia T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ia.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ia U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ia)ViewDataBinding.z(layoutInflater, 2131558632, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(h hVar);
}
