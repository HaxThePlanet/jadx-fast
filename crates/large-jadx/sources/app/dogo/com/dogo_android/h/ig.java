package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.c.i;

/* compiled from: FragmentRecordVideoBinding.java */
/* loaded from: classes.dex */
public abstract class ig extends ViewDataBinding {
    protected ig(Object object, View view, int i, ImageButton imageButton, View view2, SurfaceView surfaceView) {
        super(object, view, i);
    }

    public static ig T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return ig.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static ig U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (ig)ViewDataBinding.z(layoutInflater, 2131558711, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(i iVar);
}
