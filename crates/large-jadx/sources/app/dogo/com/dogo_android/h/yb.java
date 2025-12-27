package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: FragmentDogCreationWelcomeBinding.java */
/* loaded from: classes.dex */
public abstract class yb extends ViewDataBinding {

    public final gi O;
    public final FrameLayout P;
    public final Button Q;
    protected yb(Object object, View view, int i, gi giVar, FrameLayout frameLayout, ImageView imageView, Button button, TextView textView) {
        super(object, view, i);
        this.O = giVar;
        this.P = frameLayout;
        this.Q = button;
    }

    public static yb T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return yb.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static yb U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (yb)ViewDataBinding.z(layoutInflater, 2131558653, viewGroup, z, object);
    }
}
