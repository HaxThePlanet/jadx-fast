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

/* compiled from: DialogVideoPlaybackBinding.java */
/* loaded from: classes.dex */
public abstract class w9 extends ViewDataBinding {

    public final ImageButton O;
    public final ContentLoadingProgressBar P;
    public final VideoView Q;
    protected w9(Object object, View view, int i, ImageButton imageButton, ContentLoadingProgressBar contentLoadingProgressBar, VideoView videoView) {
        super(object, view, i);
        this.O = imageButton;
        this.P = contentLoadingProgressBar;
        this.Q = videoView;
    }

    public static w9 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return w9.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static w9 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (w9)ViewDataBinding.z(layoutInflater, 2131558614, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(a0 a0Var);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void W(e eVar);
}
