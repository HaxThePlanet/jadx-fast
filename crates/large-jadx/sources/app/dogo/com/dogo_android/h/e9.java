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
import app.dogo.com.dogo_android.p.a.d;

/* compiled from: DialogInstagramInviteBinding.java */
/* loaded from: classes.dex */
public abstract class e9 extends ViewDataBinding {

    public final FrameLayout O;
    public final FrameLayout P;
    public final VideoView Q;
    protected d R;
    protected e9(Object object, View view, int i, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView, ImageView imageView, VideoView videoView) {
        super(object, view, i);
        this.O = frameLayout;
        this.P = frameLayout2;
        this.Q = videoView;
    }

    public static e9 T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return e9.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static e9 U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (e9)ViewDataBinding.z(layoutInflater, 2131558605, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(d dVar);
}
