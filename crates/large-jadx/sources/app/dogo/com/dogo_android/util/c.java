package app.dogo.com.dogo_android.util;

import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import com.google.android.gms.tasks.g;

/* loaded from: classes.dex */
public final class c implements g {

    public final app.dogo.com.dogo_android.util.w a;
    public final ChallengeEntryVoter b;
    public c(app.dogo.com.dogo_android.util.w w, ChallengeEntryVoter challengeEntryVoter2) {
        super();
        this.a = w;
        this.b = challengeEntryVoter2;
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        w.j(this.a, this.b, (QuerySnapshot)object);
    }
}
