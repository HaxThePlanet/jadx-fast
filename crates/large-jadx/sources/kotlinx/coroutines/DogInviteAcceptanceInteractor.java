package app.dogo.com.dogo_android.s.a;

import app.dogo.android.network.DogoApiClient;
import app.dogo.com.dogo_android.profile.invitation.DogParentInvitationException.InvitationHasExpired;
import app.dogo.com.dogo_android.repository.domain.ApiError;
import app.dogo.com.dogo_android.repository.domain.ApiErrorKt;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitationKt;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.externalmodel.model.responses.AcceptDogInviteResponse;
import app.dogo.externalmodel.model.responses.GetDogInviteResponse;
import i.b.a0;
import i.b.b;
import i.b.f;
import i.b.g0;
import kotlin.Metadata;
import kotlin.d0.d.n;
import retrofit2.HttpException;

/* compiled from: DogInviteAcceptanceInteractor.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cJ\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000b\u001a\u00020\u000cJ\u0008\u0010\u0011\u001a\u00020\nH\u0002J\u0014\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DogInviteAcceptanceInteractor;", "", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "(Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/android/network/DogoApiClient;)V", "acceptDogInvite", "Lio/reactivex/Completable;", "inviteId", "", "dogId", "getDogInvite", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "loginUserIfNeeded", "parseDogInviteError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d2, reason: from kotlin metadata */
public final class DogInviteAcceptanceInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final h2 apiClient;
    /* renamed from: b, reason: from kotlin metadata */
    private final p1 authService;
    /* renamed from: c, reason: from kotlin metadata */
    private final DogoApiClient userRepository;
    public d2(h2 h2Var, p1 p1Var, DogoApiClient dogoApiClient) {
        n.f(h2Var, "authService");
        n.f(p1Var, "userRepository");
        n.f(dogoApiClient, "apiClient");
        super();
        this.apiClient = h2Var;
        this.authService = p1Var;
        this.userRepository = dogoApiClient;
    }

    private static final f b(d2 d2Var, String str, AcceptDogInviteResponse acceptDogInviteResponse) {
        n.f(d2Var, "this$0");
        n.f(str, "$dogId");
        n.f(acceptDogInviteResponse, "it");
        return d2Var.authService.v0(acceptDogInviteResponse.getUser(), str);
    }

    /* renamed from: c, reason: from kotlin metadata */
    private static final f acceptDogInvite(d2 inviteId, Throwable dogId) {
        n.f(inviteId, "this$0");
        n.f(dogId, "it");
        return b.m(inviteId.l(dogId));
    }

    /* renamed from: e, reason: from kotlin metadata */
    private static final DogOwnerInvitation getDogInvite(GetDogInviteResponse inviteId) {
        n.f(inviteId, "it");
        return DogOwnerInvitationKt.toDogOwnerInvite(inviteId);
    }

    private static final g0 f(d2 d2Var, Throwable th) {
        n.f(d2Var, "this$0");
        n.f(th, "it");
        return a0.error(d2Var.l(th));
    }

    /* renamed from: k, reason: from kotlin metadata */
    private final b loginUserIfNeeded() {
        int i = 1;
        b ignoreElement;
        boolean z = false;
        int r0 = this.apiClient.v().length() == 0 ? 1 : z;
        if (this.apiClient != 0) {
            str = "{\n            authService.anonymousSignInSingle(false).ignoreElement()\n        }";
            n.e(this.apiClient.c(z).ignoreElement(), str);
        } else {
            str = "{\n            Completable.complete()\n        }";
            n.e(b.f(), str);
        }
        return ignoreElement;
    }

    private final Exception l(Throwable th) {
        String type = null;
        boolean z = true;
        String str;
        DogParentInvitationException.InvitationHasExpired dogParentInvitationException_InvitationHasExpired;
        if (!(th instanceof HttpException)) {
        } else {
            th2 = th;
            int i = 422;
            if (th2.code() == 422) {
                ApiError apiError = ApiErrorKt.toApiError(th2);
                if (apiError == null) {
                    int i2 = 0;
                } else {
                    type = apiError.getType();
                }
                if (n.b(type, "INVITATION_EXPIRED")) {
                    int i3 = 1;
                } else {
                    str = "INVITATION_ALREADY_USED";
                    z = n.b(type, str);
                }
                th = z ? new DogParentInvitationException_InvitationHasExpired() : (Exception)th;
            } else {
            }
        }
        return (z ? new DogParentInvitationException_InvitationHasExpired() : (Exception)th);
    }

    public final b a(String str, String str2) {
        n.f(str, "inviteId");
        n.f(str2, "dogId");
        b bVar = this.userRepository.acceptDogInvite(str).flatMapCompletable(new kotlinx.coroutines.a(this, str2)).t(new kotlinx.coroutines.c(this));
        n.e(bVar, "apiClient.acceptDogInvite(inviteId)\n            .flatMapCompletable {\n                userRepository.updateLocalUserData(it.user, dogId)\n            }.onErrorResumeNext {\n                Completable.error(parseDogInviteError(it))\n            }");
        return bVar;
    }

    public final a0<DogOwnerInvitation> d(String str) {
        n.f(str, "inviteId");
        a0 onErrorResumeNext = loginUserIfNeeded().d(this.userRepository.getDogInvite(str)).map(kotlinx.coroutines.d.a).onErrorResumeNext(new kotlinx.coroutines.b(this));
        n.e(onErrorResumeNext, "loginUserIfNeeded()\n            .andThen(apiClient.getDogInvite(inviteId))\n            .map { it.toDogOwnerInvite() }\n            .onErrorResumeNext {\n                Single.error(parseDogInviteError(it))\n            }");
        return onErrorResumeNext;
    }

    public static /* synthetic */ f g(d2 d2Var, String str, AcceptDogInviteResponse acceptDogInviteResponse) {
        return DogInviteAcceptanceInteractor.b(d2Var, str, acceptDogInviteResponse);
    }

    public static /* synthetic */ g0 h(d2 d2Var, Throwable th) {
        return DogInviteAcceptanceInteractor.f(d2Var, th);
    }

    public static /* synthetic */ f i(d2 d2Var, Throwable th) {
        return DogInviteAcceptanceInteractor.acceptDogInvite(d2Var, th);
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static /* synthetic */ DogOwnerInvitation parseDogInviteError(GetDogInviteResponse exception) {
        return DogInviteAcceptanceInteractor.getDogInvite(exception);
    }
}
