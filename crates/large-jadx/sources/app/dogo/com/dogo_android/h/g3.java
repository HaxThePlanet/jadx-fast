package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* compiled from: CellLibraryTrickItemBinding.java */
/* loaded from: classes.dex */
public abstract class g3 extends ViewDataBinding {

    public final ImageView O;
    public final ImageView P;
    public final TextView Q;
    protected TrickItem R;
    protected g3(Object object, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(object, view, i);
        this.O = imageView;
        this.P = imageView2;
        this.Q = textView;
    }

    public static g3 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return g3.V(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static g3 V(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (g3)ViewDataBinding.z(layoutInflater, 2131558501, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public TrickItem T() {
        return this.R;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(TrickItem trickItem);
}
