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

/* compiled from: LayoutTrainingStreakStatsBinding.java */
/* loaded from: classes.dex */
public abstract class gn extends ViewDataBinding {

    public final TextView O;
    public final TextView P;
    public final TextView Q;
    protected ProfilePreview R;
    protected gn(Object object, View view, int i, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView2, View view2, View view3, TextView textView3, ImageView imageView2, ConstraintLayout constraintLayout2, TextView textView4, ImageView imageView3, ConstraintLayout constraintLayout3) {
        super(object, view, i);
        this.O = textView;
        this.P = textView3;
        this.Q = textView4;
    }

    public static gn T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return gn.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static gn U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (gn)ViewDataBinding.z(layoutInflater, 2131558815, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(ProfilePreview profilePreview);
}
