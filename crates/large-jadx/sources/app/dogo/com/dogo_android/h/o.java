package app.dogo.com.dogo_android.h;

import android.view.View;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.MaterialToolbar;

/* compiled from: ActivityWebviewBinding.java */
/* loaded from: classes.dex */
public abstract class o extends ViewDataBinding {

    public final MaterialToolbar O;
    public final WebView P;
    protected String Q;
    protected String R;
    protected o(Object object, View view, int i, ConstraintLayout constraintLayout, MaterialToolbar materialToolbar, WebView webView) {
        super(object, view, i);
        this.O = materialToolbar;
        this.P = webView;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(String str);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(String str);
}
