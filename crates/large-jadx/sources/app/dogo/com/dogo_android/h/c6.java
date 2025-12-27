package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: CellProgramQuestionItemBinding.java */
/* loaded from: classes.dex */
public abstract class c6 extends ViewDataBinding {

    public final TextView O;
    protected c6(Object object, View view, int i, TextView textView, ImageView imageView, TextView textView2) {
        super(object, view, i);
        this.O = textView;
    }

    public static c6 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return c6.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static c6 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (c6)ViewDataBinding.z(layoutInflater, 2131558538, viewGroup, z, object);
    }
}
