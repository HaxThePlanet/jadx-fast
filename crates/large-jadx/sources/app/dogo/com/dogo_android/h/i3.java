package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep;

/* compiled from: CellLibraryTrickStep2Binding.java */
/* loaded from: classes.dex */
public abstract class i3 extends ViewDataBinding {

    public final TextView O;
    public final ImageView P;
    protected TrickItem.TrickStep Q;
    protected i3(Object object, View view, int i, TextView textView, Guideline guideline, ImageView imageView) {
        super(object, view, i);
        this.O = textView;
        this.P = imageView;
    }

    public static i3 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return i3.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static i3 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (i3)ViewDataBinding.z(layoutInflater, 2131558502, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem.TrickStep trickStep);
}
