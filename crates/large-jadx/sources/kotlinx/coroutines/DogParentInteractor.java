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

/* compiled from: DogParentInteractor.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000c\u001a\u00020\rJ\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DogParentInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "dynamicLinkService", "Lapp/dogo/com/dogo_android/service/DynamicLinkService;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/service/DynamicLinkService;)V", "createInviteLink", "Lio/reactivex/Single;", "", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getDogParentUiState", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState;", "dogId", "removeDogParent", "Lio/reactivex/Completable;", "parentId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f2, reason: from kotlin metadata */
public final class DogParentInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final p1 dynamicLinkService;
    /* renamed from: b, reason: from kotlin metadata */
    private final n3 subscribeInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final k2 userRepository;
    public f2(p1 p1Var, n3 n3Var, k2 k2Var) {
        n.f(p1Var, "userRepository");
        n.f(n3Var, "subscribeInteractor");
        n.f(k2Var, "dynamicLinkService");
        super();
        this.dynamicLinkService = p1Var;
        this.subscribeInteractor = n3Var;
        this.userRepository = k2Var;
    }

    private static final g0 b(f2 f2Var, DogProfile dogProfile, CreateDogInviteResponse createDogInviteResponse) {
        n.f(f2Var, "this$0");
        n.f(dogProfile, "$dogProfile");
        n.f(createDogInviteResponse, "inviteResponse");
        return f2Var.userRepository.a(dogProfile.getName(), dogProfile.getAvatar(), createDogInviteResponse.getInviteId());
    }

    /* renamed from: c, reason: from kotlin metadata */
    private static final String createInviteLink(ShortDynamicLink dogProfile) {
        n.f(dogProfile, "it");
        return String.valueOf(dogProfile.getShortLink());
    }

    /* renamed from: e, reason: from kotlin metadata */
    private static final g0 removeDogParent(f2 dogId, List parentId) {
        n.f(dogId, "this$0");
        n.f(parentId, "ownerInformation");
        return dogId.subscribeInteractor.q().map(new kotlinx.coroutines.h(parentId));
    }

    private static final DogParentUIState f(List list, Boolean boolean) {
        n.f(list, "$ownerInformation");
        n.f(boolean, "it");
        return new DogParentUIState(list, boolean.booleanValue());
    }

    public final a0<String> a(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        a0 map = this.dynamicLinkService.n(dogProfile.getId()).flatMap(new kotlinx.coroutines.g(this, dogProfile)).map(kotlinx.coroutines.f.a);
        n.e(map, "userRepository.createDogInviteId(dogProfile.id).flatMap { inviteResponse ->\n            dynamicLinkService.generateDogInvitationUrl(\n                dogProfile.name,\n                dogProfile.avatar,\n                inviteResponse.inviteId\n            )\n        }.map {\n            it.shortLink.toString()\n        }");
        return map;
    }

    public final a0<DogParentUIState> d(String str) {
        n.f(str, "dogId");
        a0 flatMapped = this.dynamicLinkService.B(str).flatMap(new kotlinx.coroutines.e(this));
        n.e(flatMapped, "userRepository.getOwnersInformation(dogId).flatMap { ownerInformation ->\n            subscribeInteractor.revenueCatSubscribed().map {\n                DogParentUIState(\n                    parents = ownerInformation,\n                    isPremium = it\n                )\n            }\n        }");
        return flatMapped;
    }

    public final b k(String str, String str2) {
        n.f(str, "dogId");
        n.f(str2, "parentId");
        return this.dynamicLinkService.p(str, str2);
    }

    public static /* synthetic */ g0 g(f2 f2Var, List list) {
        return DogParentInteractor.removeDogParent(f2Var, list);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static /* synthetic */ String getDogParentUiState(ShortDynamicLink dogId) {
        return DogParentInteractor.createInviteLink(dogId);
    }

    public static /* synthetic */ g0 i(f2 f2Var, DogProfile dogProfile, CreateDogInviteResponse createDogInviteResponse) {
        return DogParentInteractor.b(f2Var, dogProfile, createDogInviteResponse);
    }

    public static /* synthetic */ DogParentUIState j(List list, Boolean boolean) {
        return DogParentInteractor.f(list, boolean);
    }
}
