package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.q.p.v;
import app.dogo.com.dogo_android.repository.domain.DogProfile;

/* loaded from: classes.dex */
public final class b implements View.OnClickListener {

    public final v a;
    public final DogProfile b;
    public b(v v, DogProfile dogProfile2) {
        super();
        this.a = v;
        this.b = dogProfile2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        o.f(this.a, this.b, view);
    }
}
