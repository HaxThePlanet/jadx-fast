package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.k0.e;

/* loaded from: classes.dex */
public final class j implements View.OnClickListener {

    public final DogProfile a;
    public final e b;
    public j(DogProfile dogProfile, e e2) {
        super();
        this.a = dogProfile;
        this.b = e2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        o.n(this.a, this.b, view);
    }
}
