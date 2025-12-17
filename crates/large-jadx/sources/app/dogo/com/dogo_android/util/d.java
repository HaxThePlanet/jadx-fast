package app.dogo.com.dogo_android.util;

import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import com.google.android.gms.tasks.f;

/* loaded from: classes.dex */
public final class d implements f {

    public final ChallengeEntryVoter a;
    public final app.dogo.com.dogo_android.util.w b;
    public d(ChallengeEntryVoter challengeEntryVoter, app.dogo.com.dogo_android.util.w w2) {
        super();
        this.a = challengeEntryVoter;
        this.b = w2;
    }

    @Override // com.google.android.gms.tasks.f
    public final void onFailure(Exception exception) {
        w.k(this.a, this.b, exception);
    }
}
