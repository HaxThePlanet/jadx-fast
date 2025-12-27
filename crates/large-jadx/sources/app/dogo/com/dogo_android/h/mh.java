package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: FragmentWorkoutInfoBinding.java */
/* loaded from: classes.dex */
public abstract class mh extends ViewDataBinding {

    public final WebView O;
    public final MaterialToolbar P;
    protected mh(Object object, View view, int i, WebView webView, TextView textView, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = webView;
        this.P = materialToolbar;
    }

    public static mh T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return mh.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static mh U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (mh)ViewDataBinding.z(layoutInflater, 2131558726, viewGroup, z, object);
    }
}
