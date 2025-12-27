package app.dogo.com.dogo_android.d.b.z;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class g implements e {

    public final /* synthetic */ String a;
    public final /* synthetic */ l b;
    public /* synthetic */ g(String str, l lVar) {
        super();
        this.a = str;
        this.b = lVar;
    }

    public final void onComplete(j jVar) {
        ChallengeCommentItemObservable.j(this.a, this.b, jVar);
    }
}
