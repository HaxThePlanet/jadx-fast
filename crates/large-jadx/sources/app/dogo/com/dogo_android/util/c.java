package app.dogo.com.dogo_android.util;

import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import com.google.android.gms.tasks.g;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class c implements g {

    public final /* synthetic */ w a;
    public final /* synthetic */ ChallengeEntryVoter b;
    public /* synthetic */ c(w wVar, ChallengeEntryVoter challengeEntryVoter) {
        super();
        this.a = wVar;
        this.b = challengeEntryVoter;
    }

    public final void onSuccess(Object object) {
        QueueableEntryDataFetcher.n(this.a, this.b, object);
    }
}
