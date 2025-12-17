package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class eh extends ViewDataBinding {

    public final ImageView O;
    public final MaterialButton P;
    protected eh(Object object, View view2, int i3, ImageView imageView4, ImageView imageView5, TextView textView6, MaterialButton materialButton7, TextView textView8, AppCompatImageView appCompatImageView9) {
        super(object, view2, i3);
        this.O = imageView4;
        this.P = materialButton7;
    }

    public static app.dogo.com.dogo_android.h.eh T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return eh.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.eh U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (eh)ViewDataBinding.z(layoutInflater, 2131558722, viewGroup2, z3, object4);
    }
}
