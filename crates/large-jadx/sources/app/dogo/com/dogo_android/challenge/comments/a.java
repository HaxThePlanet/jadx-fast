package app.dogo.com.dogo_android.d.b;

import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class a implements e {

    public final /* synthetic */ v a;
    public final /* synthetic */ ChallengeEntryModel b;
    public /* synthetic */ a(v vVar, ChallengeEntryModel challengeEntryModel) {
        super();
        this.a = vVar;
        this.b = challengeEntryModel;
    }

    public final void onComplete(j jVar) {
        ChallengeCommentsDialog.v2(this.a, this.b, jVar);
    }
}
