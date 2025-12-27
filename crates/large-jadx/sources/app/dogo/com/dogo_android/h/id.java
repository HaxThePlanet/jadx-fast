package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentGoodExampleNotAvailableBinding.java */
/* loaded from: classes.dex */
public abstract class id extends ViewDataBinding {

    public final MaterialToolbar O;
    protected id(Object object, View view, int i, FrameLayout frameLayout, TextView textView, ImageView imageView, TextView textView2, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = materialToolbar;
    }

    public static id T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return id.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static id U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (id)ViewDataBinding.z(layoutInflater, 2131558671, viewGroup, z, object);
    }
}
