package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.dogcreation.h.g;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentDogCreationPictureBinding.java */
/* loaded from: classes.dex */
public abstract class sb extends ViewDataBinding {

    public final ImageView O;
    public final Button P;
    public final TextView Q;
    public final MaterialToolbar R;
    public final TextView S;
    protected g T;
    protected sb(Object object, View view, int i, ImageView imageView, Button button, TextView textView, MaterialToolbar materialToolbar, TextView textView2) {
        super(object, view, i);
        this.O = imageView;
        this.P = button;
        this.Q = textView;
        this.R = materialToolbar;
        this.S = textView2;
    }

    public static sb T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return sb.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static sb U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (sb)ViewDataBinding.z(layoutInflater, 2131558650, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(g gVar);
}
