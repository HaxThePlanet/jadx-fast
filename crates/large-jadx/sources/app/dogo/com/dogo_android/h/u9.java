package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.p.b.d;

/* loaded from: classes.dex */
public abstract class u9 extends ViewDataBinding {

    public final FrameLayout O;
    public final FrameLayout P;
    public final VideoView Q;
    protected d R;
    protected u9(Object object, View view2, int i3, FrameLayout frameLayout4, FrameLayout frameLayout5, TextView textView6, ImageView imageView7, VideoView videoView8) {
        super(object, view2, i3);
        this.O = frameLayout4;
        this.P = frameLayout5;
        this.Q = videoView8;
    }

    public static app.dogo.com.dogo_android.h.u9 T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return u9.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.u9 U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (u9)ViewDataBinding.z(layoutInflater, 2131558613, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d d);
}
