package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.k0.e;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class j implements View.OnClickListener {

    public final /* synthetic */ DogProfile a;
    public final /* synthetic */ e b;
    public /* synthetic */ j(DogProfile dogProfile, e eVar) {
        super();
        this.a = dogProfile;
        this.b = eVar;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        DogProfileBindingAdapters.L(this.a, this.b, view);
    }
}
