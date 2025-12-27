package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentSpecialProgramDescriptionBinding.java */
/* loaded from: classes.dex */
public abstract class qg extends ViewDataBinding {

    public final ConstraintLayout O;
    public final TextView P;
    public final MaterialToolbar Q;
    protected String R;
    protected qg(Object object, View view, int i, ConstraintLayout constraintLayout, TextView textView, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = constraintLayout;
        this.P = textView;
        this.Q = materialToolbar;
    }

    public static qg T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return qg.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static qg U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (qg)ViewDataBinding.z(layoutInflater, 2131558715, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);
}
