package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellDogLogDividerBinding.java */
/* loaded from: classes.dex */
public abstract class o1 extends ViewDataBinding {
    protected o1(Object object, View view, int i, TextView textView, ImageView imageView, ImageView imageView2) {
        super(object, view, i);
    }

    public static o1 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return o1.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static o1 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (o1)ViewDataBinding.z(layoutInflater, 2131558478, viewGroup, z, object);
    }
}
