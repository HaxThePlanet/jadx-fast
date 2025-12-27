package app.dogo.com.dogo_android.q.p;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements DialogInterface.OnClickListener {

    public final /* synthetic */ w a;
    public final /* synthetic */ ProfilePreview b;
    public /* synthetic */ h(w wVar, ProfilePreview profilePreview) {
        super();
        this.a = wVar;
        this.b = profilePreview;
    }

    @Override // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        DogPreviewFragment.F1(this.a, this.b, dialogInterface, i);
    }
}
