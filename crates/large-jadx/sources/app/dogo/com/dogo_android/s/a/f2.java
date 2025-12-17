package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.DogParentUIState;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.k2;
import app.dogo.externalmodel.model.responses.CreateDogInviteResponse;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import i.b.a0;
import i.b.b;
import i.b.g0;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000c\u001a\u00020\rJ\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DogParentInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "dynamicLinkService", "Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/service/DynamicLinkService;)V", "createInviteLink", "Lio/reactivex/Single;", "", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getDogParentUiState", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState;", "dogId", "removeDogParent", "Lio/reactivex/Completable;", "parentId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f2 {

    private final p1 a;
    private final app.dogo.com.dogo_android.s.a.n3 b;
    private final k2 c;
    public f2(p1 p1, app.dogo.com.dogo_android.s.a.n3 n32, k2 k23) {
        n.f(p1, "userRepository");
        n.f(n32, "subscribeInteractor");
        n.f(k23, "dynamicLinkService");
        super();
        this.a = p1;
        this.b = n32;
        this.c = k23;
    }

    private static final g0 b(app.dogo.com.dogo_android.s.a.f2 f2, DogProfile dogProfile2, CreateDogInviteResponse createDogInviteResponse3) {
        n.f(f2, "this$0");
        n.f(dogProfile2, "$dogProfile");
        n.f(createDogInviteResponse3, "inviteResponse");
        return f2.c.a(dogProfile2.getName(), dogProfile2.getAvatar(), createDogInviteResponse3.getInviteId());
    }

    private static final String c(ShortDynamicLink shortDynamicLink) {
        n.f(shortDynamicLink, "it");
        return String.valueOf(shortDynamicLink.getShortLink());
    }

    private static final g0 e(app.dogo.com.dogo_android.s.a.f2 f2, List list2) {
        n.f(f2, "this$0");
        n.f(list2, "ownerInformation");
        h hVar = new h(list2);
        return f2.b.q().map(hVar);
    }

    private static final DogParentUIState f(List list, Boolean boolean2) {
        n.f(list, "$ownerInformation");
        n.f(boolean2, "it");
        DogParentUIState dogParentUIState = new DogParentUIState(list, boolean2.booleanValue());
        return dogParentUIState;
    }

    public static g0 g(app.dogo.com.dogo_android.s.a.f2 f2, List list2) {
        return f2.e(f2, list2);
    }

    public static String h(ShortDynamicLink shortDynamicLink) {
        return f2.c(shortDynamicLink);
    }

    public static g0 i(app.dogo.com.dogo_android.s.a.f2 f2, DogProfile dogProfile2, CreateDogInviteResponse createDogInviteResponse3) {
        return f2.b(f2, dogProfile2, createDogInviteResponse3);
    }

    public static DogParentUIState j(List list, Boolean boolean2) {
        return f2.f(list, boolean2);
    }

    public final a0<String> a(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        g gVar = new g(this, dogProfile);
        a0 obj3 = this.a.n(dogProfile.getId()).flatMap(gVar).map(f.a);
        n.e(obj3, "userRepository.createDogInviteId(dogProfile.id).flatMap { inviteResponse ->\n            dynamicLinkService.generateDogInvitationUrl(\n                dogProfile.name,\n                dogProfile.avatar,\n                inviteResponse.inviteId\n            )\n        }.map {\n            it.shortLink.toString()\n        }");
        return obj3;
    }

    public final a0<DogParentUIState> d(String string) {
        n.f(string, "dogId");
        e eVar = new e(this);
        a0 obj2 = this.a.B(string).flatMap(eVar);
        n.e(obj2, "userRepository.getOwnersInformation(dogId).flatMap { ownerInformation ->\n            subscribeInteractor.revenueCatSubscribed().map {\n                DogParentUIState(\n                    parents = ownerInformation,\n                    isPremium = it\n                )\n            }\n        }");
        return obj2;
    }

    public final b k(String string, String string2) {
        n.f(string, "dogId");
        n.f(string2, "parentId");
        return this.a.p(string, string2);
    }
}
