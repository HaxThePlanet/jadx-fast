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

/* compiled from: FragmentUnlockHelplineBinding.java */
/* loaded from: classes.dex */
public abstract class eh extends ViewDataBinding {

    public final ImageView O;
    public final MaterialButton P;
    protected eh(Object object, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, MaterialButton materialButton, TextView textView2, AppCompatImageView appCompatImageView) {
        super(object, view, i);
        this.O = imageView;
        this.P = materialButton;
    }

    public static eh T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return eh.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static eh U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (eh)ViewDataBinding.z(layoutInflater, 2131558722, viewGroup, z, object);
    }
}
