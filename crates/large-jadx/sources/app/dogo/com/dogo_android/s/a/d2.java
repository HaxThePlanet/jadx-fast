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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000cJ\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u000b\u001a\u00020\u000cJ\u0008\u0010\u0011\u001a\u00020\nH\u0002J\u0014\u0010\u0012\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DogInviteAcceptanceInteractor;", "", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "(Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/android/network/DogoApiClient;)V", "acceptDogInvite", "Lio/reactivex/Completable;", "inviteId", "", "dogId", "getDogInvite", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "loginUserIfNeeded", "parseDogInviteError", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d2 {

    private final h2 a;
    private final p1 b;
    private final DogoApiClient c;
    public d2(h2 h2, p1 p12, DogoApiClient dogoApiClient3) {
        n.f(h2, "authService");
        n.f(p12, "userRepository");
        n.f(dogoApiClient3, "apiClient");
        super();
        this.a = h2;
        this.b = p12;
        this.c = dogoApiClient3;
    }

    private static final f b(app.dogo.com.dogo_android.s.a.d2 d2, String string2, AcceptDogInviteResponse acceptDogInviteResponse3) {
        n.f(d2, "this$0");
        n.f(string2, "$dogId");
        n.f(acceptDogInviteResponse3, "it");
        return d2.b.v0(acceptDogInviteResponse3.getUser(), string2);
    }

    private static final f c(app.dogo.com.dogo_android.s.a.d2 d2, Throwable throwable2) {
        n.f(d2, "this$0");
        n.f(throwable2, "it");
        return b.m(d2.l(throwable2));
    }

    private static final DogOwnerInvitation e(GetDogInviteResponse getDogInviteResponse) {
        n.f(getDogInviteResponse, "it");
        return DogOwnerInvitationKt.toDogOwnerInvite(getDogInviteResponse);
    }

    private static final g0 f(app.dogo.com.dogo_android.s.a.d2 d2, Throwable throwable2) {
        n.f(d2, "this$0");
        n.f(throwable2, "it");
        return a0.error(d2.l(throwable2));
    }

    public static f g(app.dogo.com.dogo_android.s.a.d2 d2, String string2, AcceptDogInviteResponse acceptDogInviteResponse3) {
        return d2.b(d2, string2, acceptDogInviteResponse3);
    }

    public static g0 h(app.dogo.com.dogo_android.s.a.d2 d2, Throwable throwable2) {
        return d2.f(d2, throwable2);
    }

    public static f i(app.dogo.com.dogo_android.s.a.d2 d2, Throwable throwable2) {
        return d2.c(d2, throwable2);
    }

    public static DogOwnerInvitation j(GetDogInviteResponse getDogInviteResponse) {
        return d2.e(getDogInviteResponse);
    }

    private final b k() {
        int i;
        b ignoreElement;
        String str;
        int i2 = 0;
        i = this.a.v().length() == 0 ? 1 : i2;
        if (i != 0) {
            n.e(this.a.c(i2).ignoreElement(), "{\n            authService.anonymousSignInSingle(false).ignoreElement()\n        }");
        } else {
            n.e(b.f(), "{\n            Completable.complete()\n        }");
        }
        return ignoreElement;
    }

    private final Exception l(Throwable throwable) {
        Object exception;
        int type;
        int code;
        int i;
        Object obj4;
        if (throwable instanceof HttpException != null) {
            exception = throwable;
            if ((HttpException)exception.code() == 422) {
                ApiError apiError = ApiErrorKt.toApiError(exception);
                if (apiError == null) {
                    type = 0;
                } else {
                    type = apiError.getType();
                }
                if (n.b(type, "INVITATION_EXPIRED")) {
                    exception = 1;
                } else {
                    exception = n.b(type, "INVITATION_ALREADY_USED");
                }
                if (exception != null) {
                    obj4 = new DogParentInvitationException.InvitationHasExpired();
                } else {
                }
            } else {
            }
        } else {
            exception = new Exception((Exception)(Exception)throwable);
            obj4 = exception;
        }
        return obj4;
    }

    public final b a(String string, String string2) {
        n.f(string, "inviteId");
        n.f(string2, "dogId");
        a aVar = new a(this, string2);
        c obj3 = new c(this);
        b obj2 = this.c.acceptDogInvite(string).flatMapCompletable(aVar).t(obj3);
        n.e(obj2, "apiClient.acceptDogInvite(inviteId)\n            .flatMapCompletable {\n                userRepository.updateLocalUserData(it.user, dogId)\n            }.onErrorResumeNext {\n                Completable.error(parseDogInviteError(it))\n            }");
        return obj2;
    }

    public final a0<DogOwnerInvitation> d(String string) {
        n.f(string, "inviteId");
        b bVar2 = new b(this);
        a0 obj3 = k().d(this.c.getDogInvite(string)).map(d.a).onErrorResumeNext(bVar2);
        n.e(obj3, "loginUserIfNeeded()\n            .andThen(apiClient.getDogInvite(inviteId))\n            .map { it.toDogOwnerInvite() }\n            .onErrorResumeNext {\n                Single.error(parseDogInviteError(it))\n            }");
        return obj3;
    }
}
