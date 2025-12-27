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

/* compiled from: FragmentLibraryArticleDetailsBinding.java */
/* loaded from: classes.dex */
public abstract class qd extends ViewDataBinding {

    public final WebView O;
    public final TextView P;
    public final MaterialButton Q;
    public final ImageView R;
    public final FrameLayout S;
    public final MaterialToolbar T;
    protected m U;
    protected qd(Object object, View view, int i, WebView webView, TextView textView, ImageView imageView, MaterialButton materialButton, ImageView imageView2, ScrollView scrollView, FrameLayout frameLayout, MaterialToolbar materialToolbar) {
        super(object, view, i);
        this.O = webView;
        this.P = textView;
        this.Q = materialButton;
        this.R = imageView2;
        this.S = frameLayout;
        this.T = materialToolbar;
    }

    public static qd T(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return qd.U(layoutInflater, viewGroup, z, f.e());
    }

    @Deprecated
    public static qd U(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object object) {
        return (qd)ViewDataBinding.z(layoutInflater, 2131558676, viewGroup, z, object);
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void V(m mVar);
}
