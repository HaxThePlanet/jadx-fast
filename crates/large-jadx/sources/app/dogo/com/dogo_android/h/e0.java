package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.DogBreed;

/* compiled from: CellBreedListRowBinding.java */
/* loaded from: classes.dex */
public abstract class e0 extends ViewDataBinding {

    public final TextView O;
    protected DogBreed P;
    protected e0(Object object, View view, int i, TextView textView) {
        super(object, view, i);
        this.O = textView;
    }

    public static e0 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return e0.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static e0 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (e0)ViewDataBinding.z(layoutInflater, 2131558459, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(DogBreed dogBreed);
}
