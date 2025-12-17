package app.dogo.com.dogo_android.q.p;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;

/* loaded from: classes.dex */
public final class h implements DialogInterface.OnClickListener {

    public final app.dogo.com.dogo_android.q.p.w a;
    public final ProfilePreview b;
    public h(app.dogo.com.dogo_android.q.p.w w, ProfilePreview profilePreview2) {
        super();
        this.a = w;
        this.b = profilePreview2;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        w.K1(this.a, this.b, dialogInterface, i2);
    }
}
