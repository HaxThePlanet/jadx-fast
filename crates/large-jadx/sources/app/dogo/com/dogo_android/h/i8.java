package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.a0.g.f.e0;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: DialogChallengeEntryCreationBinding.java */
/* loaded from: classes.dex */
public abstract class i8 extends ViewDataBinding {

    public final FrameLayout O;
    public final EditText P;
    public final ImageView Q;
    public final cn R;
    public final ImageView S;
    protected e0 T;
    protected a0 U;
    protected i8(Object object, View view, int i, FrameLayout frameLayout, EditText editText, ImageView imageView, cn cnVar, ImageView imageView2) {
        super(object, view, i);
        this.O = frameLayout;
        this.P = editText;
        this.Q = imageView;
        this.R = cnVar;
        this.S = imageView2;
    }

    public static i8 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return i8.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static i8 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (i8)ViewDataBinding.z(layoutInflater, 2131558592, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e0 e0Var);
}
