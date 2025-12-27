package app.dogo.com.dogo_android.d.b.z;

import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class h implements e {

    public final /* synthetic */ String a;
    public final /* synthetic */ l b;
    public /* synthetic */ h(String str, l lVar) {
        super();
        this.a = str;
        this.b = lVar;
    }

    public final void onComplete(j jVar) {
        ChallengeCommentItemObservable.k(this.a, this.b, jVar);
    }
}
