package app.dogo.com.dogo_android.d.a;

import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.util.n0.u;

/* loaded from: classes.dex */
public final class i implements u {

    public final app.dogo.com.dogo_android.d.a.m a;
    public final ChallengeModel b;
    public i(app.dogo.com.dogo_android.d.a.m m, ChallengeModel challengeModel2) {
        super();
        this.a = m;
        this.b = challengeModel2;
    }

    @Override // app.dogo.com.dogo_android.util.n0.u
    public final boolean a(Object object, int i2) {
        return m.P(this.a, this.b, (List)object, i2);
    }
}
