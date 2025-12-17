package app.dogo.com.dogo_android.welcome_v2.w0;

import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class d implements e {

    public final app.dogo.com.dogo_android.welcome_v2.w0.i a;
    public final ChallengeEntryModel b;
    public d(app.dogo.com.dogo_android.welcome_v2.w0.i i, ChallengeEntryModel challengeEntryModel2) {
        super();
        this.a = i;
        this.b = challengeEntryModel2;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        i.N1(this.a, this.b, j);
    }
}
