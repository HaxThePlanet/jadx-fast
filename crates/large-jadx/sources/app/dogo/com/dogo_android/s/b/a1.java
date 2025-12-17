package app.dogo.com.dogo_android.s.b;

import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.service.p2;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00082\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0007J\u0014\u0010\u0012\u001a\u00020\u00132\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0015J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0008R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\n8F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ChallengeLocalRepository;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "challengeMap", "", "", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "challenges", "", "getChallenges", "()Ljava/util/Map;", "locale", "getLocale", "()Ljava/lang/String;", "getChallenge", "id", "setChallenges", "", "result", "", "updateChallengeModel", "challengeModel", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a1 {

    private final Map<String, ChallengeModel> a;
    public a1(p2 p2) {
        n.f(p2, "preferenceService");
        super();
        HashMap obj2 = new HashMap();
        this.a = obj2;
    }

    public final ChallengeModel a(String string) {
        return (ChallengeModel)this.a.get(string);
    }

    public final Map<String, ChallengeModel> b() {
        return this.a;
    }

    public final void c(List<ChallengeModel> list) {
        String next;
        Map map;
        String str;
        n.f(list, "result");
        final Iterator obj4 = list.iterator();
        for (ChallengeModel next : obj4) {
            this.a.put(next.getId(), next);
        }
    }

    public final void d(ChallengeModel challengeModel) {
        n.f(challengeModel, "challengeModel");
        this.a.put(challengeModel.getId(), challengeModel);
    }
}
