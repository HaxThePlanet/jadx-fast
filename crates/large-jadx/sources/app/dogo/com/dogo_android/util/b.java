package app.dogo.com.dogo_android.util;

import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class b implements e {

    public final /* synthetic */ ChallengeEntryVoter a;
    public final /* synthetic */ w b;
    public /* synthetic */ b(ChallengeEntryVoter challengeEntryVoter, w wVar) {
        super();
        this.a = challengeEntryVoter;
        this.b = wVar;
    }

    public final void onComplete(j jVar) {
        QueueableEntryDataFetcher.h(this.a, this.b, jVar);
    }
}
