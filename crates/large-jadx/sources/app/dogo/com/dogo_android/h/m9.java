package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.t.h0.i.a;
import app.dogo.com.dogo_android.t.h0.l;

/* compiled from: DialogLanguageSelectBinding.java */
/* loaded from: classes.dex */
public abstract class m9 extends ViewDataBinding {

    public final FrameLayout O;
    public final Button P;
    public final ConstraintLayout Q;
    public final ProgressBar R;
    public final RecyclerView S;
    protected l T;
    protected i.a U;
    protected m9(Object object, View view, int i, FrameLayout frameLayout, Button button, ConstraintLayout constraintLayout, ProgressBar progressBar, RecyclerView recyclerView, TextView textView) {
        super(object, view, i);
        this.O = frameLayout;
        this.P = button;
        this.Q = constraintLayout;
        this.R = progressBar;
        this.S = recyclerView;
    }

    public static m9 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return m9.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static m9 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (m9)ViewDataBinding.z(layoutInflater, 2131558609, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(i.a aVar);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(l lVar);
}
