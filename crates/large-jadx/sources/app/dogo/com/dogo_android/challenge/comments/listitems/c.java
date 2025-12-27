package app.dogo.com.dogo_android.d.b.z;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements e {

    public final /* synthetic */ String a;
    public final /* synthetic */ j b;
    public /* synthetic */ c(String str, j jVar) {
        super();
        this.a = str;
        this.b = jVar;
    }

    public final void onComplete(j jVar) {
        ChallengeCommentCaptionObservable.i(this.a, this.b, jVar);
    }
}
