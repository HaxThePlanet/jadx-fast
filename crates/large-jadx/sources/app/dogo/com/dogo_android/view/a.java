package app.dogo.com.dogo_android.view;

import android.view.View;
import android.view.View.OnClickListener;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final app.dogo.com.dogo_android.view.GenericWebViewActivity a;
    public a(app.dogo.com.dogo_android.view.GenericWebViewActivity genericWebViewActivity) {
        super();
        this.a = genericWebViewActivity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GenericWebViewActivity.j(this.a, view);
    }
}
