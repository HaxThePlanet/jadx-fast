package app.dogo.com.dogo_android.util;

import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import com.google.android.gms.tasks.f;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements f {

    public final /* synthetic */ ChallengeEntryVoter a;
    public final /* synthetic */ w b;
    public /* synthetic */ d(ChallengeEntryVoter challengeEntryVoter, w wVar) {
        super();
        this.a = challengeEntryVoter;
        this.b = wVar;
    }

    public final void onFailure(Exception exc) {
        QueueableEntryDataFetcher.o(this.a, this.b, exc);
    }
}
