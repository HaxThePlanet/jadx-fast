package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;

/* compiled from: DialogInviteAccaptedBinding.java */
/* loaded from: classes.dex */
public abstract class i9 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    protected String Q;
    protected String R;
    protected String S;
    protected i9(Object object, View view, int i, ImageView imageView, TextView textView, TextView textView2) {
        super(object, view, i);
        this.O = imageView;
        this.P = textView;
    }

    public static i9 T(LayoutInflater layoutInflater) {
        return i9.U(layoutInflater, f.e());
    }

    @Deprecated
    public static i9 U(LayoutInflater layoutInflater, Object object) {
        return (i9)ViewDataBinding.z(layoutInflater, 2131558607, null, false, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(String str);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(String str);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void X(String str);
}
