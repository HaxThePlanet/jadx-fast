package app.dogo.com.dogo_android.welcome_v2.w0;

import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import com.google.android.gms.tasks.e;
import com.google.android.gms.tasks.j;

/* compiled from: lambda */
/* loaded from: classes.dex */
public final class d implements e {

    public final /* synthetic */ i a;
    public final /* synthetic */ ChallengeEntryModel b;
    public /* synthetic */ d(i iVar, ChallengeEntryModel challengeEntryModel) {
        super();
        this.a = iVar;
        this.b = challengeEntryModel;
    }

    public final void onComplete(j jVar) {
        OnboardingChallengeEntryFragment.W1(this.a, this.b, jVar);
    }
}
