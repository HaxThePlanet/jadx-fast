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

/* loaded from: classes.dex */
public abstract class oe extends ViewDataBinding {

    public final Button O;
    public final MaterialToolbar P;
    protected e Q;
    protected oe(Object object, View view2, int i3, Button button4, ImageView imageView5, TextView textView6, TextView textView7, ImageView imageView8, TextView textView9, TextView textView10, ImageView imageView11, TextView textView12, TextView textView13, ImageView imageView14, ImageView imageView15, TextView textView16, MaterialToolbar materialToolbar17) {
        final Object obj = this;
        super(object, view2, i3);
        obj.O = button4;
        obj.P = materialToolbar17;
    }

    public static app.dogo.com.dogo_android.h.oe T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return oe.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.oe U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (oe)ViewDataBinding.z(layoutInflater, 2131558688, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(e e);
}
