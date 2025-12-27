package app.dogo.com.dogo_android.util.h0;

import android.view.View;
import android.view.View.OnClickListener;
import com.skydoves.balloon.Balloon;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c1 implements View.OnClickListener {

    public final /* synthetic */ h1 a;
    public final /* synthetic */ Balloon b;
    public /* synthetic */ c1(h1 h1Var, Balloon balloon) {
        super();
        this.a = h1Var;
        this.b = balloon;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        app.dogo.com.dogo_android.util.extensionfunction.n1.g(this.a, this.b, view);
    }
}
