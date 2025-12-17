package app.dogo.com.dogo_android.h;

import android.view.View;
import android.webkit.WebView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.MaterialToolbar;

/* loaded from: classes.dex */
public abstract class o extends ViewDataBinding {

    public final MaterialToolbar O;
    public final WebView P;
    protected String Q;
    protected String R;
    protected o(Object object, View view2, int i3, ConstraintLayout constraintLayout4, MaterialToolbar materialToolbar5, WebView webView6) {
        super(object, view2, i3);
        this.O = materialToolbar5;
        this.P = webView6;
    }

    @Override // androidx.databinding.ViewDataBinding
    public abstract void T(String string);

    @Override // androidx.databinding.ViewDataBinding
    public abstract void U(String string);
}
