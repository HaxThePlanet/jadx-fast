package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;

/* loaded from: classes.dex */
public abstract class gn extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final TextView Q;
    protected ProfilePreview R;
    protected gn(Object object, View view2, int i3, TextView textView4, ImageView imageView5, ConstraintLayout constraintLayout6, TextView textView7, View view8, View view9, TextView textView10, ImageView imageView11, ConstraintLayout constraintLayout12, TextView textView13, ImageView imageView14, ConstraintLayout constraintLayout15) {
        super(object, view2, i3);
        this.O = textView4;
        this.P = textView10;
        this.Q = textView13;
    }

    public static app.dogo.com.dogo_android.h.gn T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return gn.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.gn U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (gn)ViewDataBinding.z(layoutInflater, 2131558815, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProfilePreview profilePreview);
}
