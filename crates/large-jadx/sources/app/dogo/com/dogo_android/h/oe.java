package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.o.e;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentNewsletterBenefitsBinding.java */
/* loaded from: classes.dex */
public abstract class oe extends ViewDataBinding {

    public final Button O;
    public final MaterialToolbar P;
    protected e Q;
    protected oe(Object object, View view, int i, Button button, ImageView imageView, TextView textView, TextView textView2, ImageView imageView2, TextView textView3, TextView textView4, ImageView imageView3, TextView textView5, TextView textView6, ImageView imageView4, ImageView imageView5, TextView textView7, MaterialToolbar materialToolbar) {
        final Object object2 = this;
        super(object, view, i);
        object2.O = button;
        object2.P = materialToolbar;
    }

    public static oe T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return oe.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static oe U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (oe)ViewDataBinding.z(layoutInflater, 2131558688, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e eVar);
}
