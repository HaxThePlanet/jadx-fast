package app.dogo.com.dogo_android.h;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import app.dogo.com.dogo_android.n.k.m;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public abstract class qd extends ViewDataBinding {

    public final WebView O;
    public final TextView P;
    public final MaterialButton Q;
    public final ImageView R;
    public final FrameLayout S;
    public final MaterialToolbar T;
    protected m U;
    protected qd(Object object, View view2, int i3, WebView webView4, TextView textView5, ImageView imageView6, MaterialButton materialButton7, ImageView imageView8, ScrollView scrollView9, FrameLayout frameLayout10, MaterialToolbar materialToolbar11) {
        super(object, view2, i3);
        this.O = webView4;
        this.P = textView5;
        this.Q = materialButton7;
        this.R = imageView8;
        this.S = frameLayout10;
        this.T = materialToolbar11;
    }

    public static app.dogo.com.dogo_android.h.qd T(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3) {
        return qd.U(layoutInflater, viewGroup2, z3, f.e());
    }

    @Deprecated
    public static app.dogo.com.dogo_android.h.qd U(LayoutInflater layoutInflater, ViewGroup viewGroup2, boolean z3, Object object4) {
        return (qd)ViewDataBinding.z(layoutInflater, 2131558676, viewGroup2, z3, object4);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(m m);
}
