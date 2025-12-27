package app.dogo.com.dogo_android.view;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    public final /* synthetic */ GenericWebViewActivity a;
    public /* synthetic */ a(GenericWebViewActivity genericWebViewActivity) {
        super();
        this.a = genericWebViewActivity;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        GenericWebViewActivity.k(this.a, view);
    }
}
