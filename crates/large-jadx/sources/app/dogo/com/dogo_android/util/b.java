package app.dogo.com.dogo_android.util;

import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class b implements e {

    public final ChallengeEntryVoter a;
    public final app.dogo.com.dogo_android.util.w b;
    public b(ChallengeEntryVoter challengeEntryVoter, app.dogo.com.dogo_android.util.w w2) {
        super();
        this.a = challengeEntryVoter;
        this.b = w2;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        w.i(this.a, this.b, j);
    }
}
