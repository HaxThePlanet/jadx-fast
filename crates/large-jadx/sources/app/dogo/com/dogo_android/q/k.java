package app.dogo.com.dogo_android.q;

import android.view.View;
import android.view.View.OnClickListener;
import app.dogo.com.dogo_android.q.p.v;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;

/* loaded from: classes.dex */
public final class k implements View.OnClickListener {

    public final v a;
    public final ProfilePreview b;
    public k(v v, ProfilePreview profilePreview2) {
        super();
        this.a = v;
        this.b = profilePreview2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        o.o(this.a, this.b, view);
    }
}
