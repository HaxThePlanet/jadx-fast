package app.dogo.com.dogo_android.d.b;

import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class a implements e {

    public final app.dogo.com.dogo_android.d.b.v a;
    public final ChallengeEntryModel b;
    public a(app.dogo.com.dogo_android.d.b.v v, ChallengeEntryModel challengeEntryModel2) {
        super();
        this.a = v;
        this.b = challengeEntryModel2;
    }

    @Override // com.google.android.gms.tasks.e
    public final void onComplete(j j) {
        v.j2(this.a, this.b, j);
    }
}
