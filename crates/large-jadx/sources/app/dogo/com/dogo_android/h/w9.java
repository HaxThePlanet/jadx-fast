package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.VideoView;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.y.q.e;

/* loaded from: classes.dex */
public abstract class w9 extends ViewDataBinding {

    public final ImageButton O;
    public final ContentLoadingProgressBar P;
    public final VideoView Q;
    protected w9(Object object, View view2, int i3, ImageButton imageButton4, ContentLoadingProgressBar contentLoadingProgressBar5, VideoView videoView6) {
        super(object, view2, i3);
        this.O = imageButton4;
        this.P = contentLoadingProgressBar5;
        this.Q = videoView6;
    }

    public static app.dogo.com.dogo_android.h.w9 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return w9.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.w9 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (w9)ViewDataBinding.z(layoutInflater, 2131558614, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e e);
}
