package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class mh extends ViewDataBinding {

    public final WebView O;
    public final MaterialToolbar P;
    protected mh(Object object, View view2, int i3, WebView webView4, TextView textView5, MaterialToolbar materialToolbar6) {
        super(object, view2, i3);
        this.O = webView4;
        this.P = materialToolbar6;
    }

    public static app.dogo.com.dogo_android.h.mh T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return mh.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.mh U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (mh)ViewDataBinding.z(layoutInflater, 2131558726, viewGroup2, z3, object4);
    }
}
