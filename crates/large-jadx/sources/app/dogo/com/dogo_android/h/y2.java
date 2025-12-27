package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;

/* compiled from: CellLessonTrickBubbleBinding.java */
/* loaded from: classes.dex */
public abstract class y2 extends ViewDataBinding {

    public final ImageView O;
    public final TextView P;
    protected TrickItem Q;
    protected y2(Object object, View view, int i, ImageView imageView, ImageView imageView2, TextView textView) {
        super(object, view, i);
        this.O = imageView;
        this.P = textView;
    }

    public static y2 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return y2.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static y2 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (y2)ViewDataBinding.z(layoutInflater, 2131558497, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(TrickItem trickItem);
}
