package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.z;
import com.zendesk.service.f;
import i.b.a0;
import i.b.c0;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;
import zendesk.support.ProviderStore;
import zendesk.support.Request;
import zendesk.support.RequestProvider;
import zendesk.support.RequestUpdates;
import zendesk.support.Support;

/* compiled from: ZendeskInteractor.kt */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u0010H\u0002J\u000e\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0010H\u0002J\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0010J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u0010H\u0002J\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;", "", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;)V", "requestProvider", "Lzendesk/support/RequestProvider;", "getRequestProvider", "()Lzendesk/support/RequestProvider;", "zendeskRequestHistoryCache", "Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "", "Lzendesk/support/Request;", "getRemoteUserRequestHistory", "Lio/reactivex/Single;", "getUnreadMessageCount", "", "getUnreadMessageCountOrZero", "getUserRequestHistory", "hasRequestHistory", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: s3, reason: from kotlin metadata */
public final class ZendeskInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final h2 authService;
    private final v2 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final z<List<Request>> timeUtils = new z<>();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u0008\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n", d2 = {"app/dogo/com/dogo_android/repository/interactor/ZendeskInteractor$getRemoteUserRequestHistory$1$1", "Lcom/zendesk/service/ZendeskCallback;", "", "Lzendesk/support/Request;", "onError", "", "error", "Lcom/zendesk/service/ErrorResponse;", "onSuccess", "requests", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends f<List<? extends Request>> {

        final /* synthetic */ c0<List<Request>> a;
        a(c0<List<Request>> c0Var) {
            this.a = c0Var;
            super();
        }

        @Override // com.zendesk.service.f
        public void onError(com.zendesk.service.a error) {
            String str = null;
            if (error == null) {
                int i = 0;
            } else {
                str = error.b();
            }
            Exception exception = new Exception(n.o("Zendesk Updates request failed because ", str));
            this.a.onError(exception);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(List<? extends Request> list) {
            List list2;
            if (list == null) {
                list2 = p.g();
            }
            this.a.onSuccess(list2);
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/repository/interactor/ZendeskInteractor$getUnreadMessageCount$1$1", "Lcom/zendesk/service/ZendeskCallback;", "Lzendesk/support/RequestUpdates;", "onError", "", "error", "Lcom/zendesk/service/ErrorResponse;", "onSuccess", "requestUpdates", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends f<RequestUpdates> {

        final /* synthetic */ c0<Integer> a;
        b(c0<Integer> c0Var) {
            this.a = c0Var;
            super();
        }

        @Override // com.zendesk.service.f
        public void onError(com.zendesk.service.a error) {
            String str = null;
            if (error == null) {
                int i = 0;
            } else {
                str = error.b();
            }
            Exception exception = new Exception(n.o("Zendesk Updates request failed because ", str));
            this.a.onError(exception);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(RequestUpdates requestUpdates) {
            if (requestUpdates != null && requestUpdates.hasUpdatedRequests()) {
                this.a.onSuccess(Integer.valueOf(requestUpdates.getRequestUpdates().size()));
            }
        }
    }
    public s3(h2 h2Var, v2 v2Var) {
        n.f(h2Var, "authService");
        n.f(v2Var, "timeUtils");
        super();
        this.authService = h2Var;
        this.b = v2Var;
        final z simpleSessionCache = new SimpleSessionCache(TimeUnit.MINUTES.toMillis(15L), obj);
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final a0<List<Request>> getRemoteUserRequestHistory() {
        a0 a0Var = a0.create(new kotlinx.coroutines.t1(this));
        n.e(a0Var, "create { emitter ->\n            val localRequestProvider = requestProvider\n            if (localRequestProvider != null) {\n                localRequestProvider.getAllRequests(object : ZendeskCallback<List<Request>>() {\n                    override fun onSuccess(requests: List<Request>?) {\n                        emitter.onSuccess(requests ?: emptyList())\n                    }\n\n                    override fun onError(error: ErrorResponse?) {\n                        emitter.onError(Exception(\"Zendesk Updates request failed because ${error?.reason}\"))\n                    }\n                })\n            } else {\n                emitter.onError(Exception(\"Zendesk Request provider is not available\"))\n            }\n        }");
        return a0Var;
    }

    private static final void b(s3 s3Var, c0 c0Var) {
        n.f(s3Var, "this$0");
        n.f(c0Var, "emitter");
        RequestProvider requestProvider = s3Var.c();
        if (requestProvider != null) {
            requestProvider.getAllRequests(new ZendeskInteractor_getRemoteUserRequestHistory_1_1(c0Var));
        } else {
            c0Var.onError(new Exception("Zendesk Request provider is not available"));
        }
    }

    private final RequestProvider c() {
        int i = 0;
        ProviderStore provider = Support.INSTANCE.provider();
        if (provider == null) {
            i = 0;
        } else {
            RequestProvider requestProvider = provider.requestProvider();
        }
        return i;
    }

    private final a0<Integer> d() {
        a0 a0Var = a0.create(new kotlinx.coroutines.u1(this));
        n.e(a0Var, "create { emitter ->\n            val localRequestProvider = requestProvider\n            if (localRequestProvider != null) {\n                localRequestProvider.getUpdatesForDevice(object : ZendeskCallback<RequestUpdates>() {\n                    override fun onSuccess(requestUpdates: RequestUpdates?) {\n                        if (requestUpdates != null) {\n                            if (requestUpdates.hasUpdatedRequests()) {\n                                val updatesCount = requestUpdates.requestUpdates.size\n                                emitter.onSuccess(updatesCount)\n                            } else {\n                                emitter.onSuccess(0)\n                            }\n                        }\n                    }\n\n                    override fun onError(error: ErrorResponse?) {\n                        emitter.onError(Exception(\"Zendesk Updates request failed because ${error?.reason}\"))\n                    }\n                })\n            } else {\n                emitter.onError(Exception(\"Zendesk Request provider is not available\"))\n            }\n        }");
        return a0Var;
    }

    private static final void e(s3 s3Var, c0 c0Var) {
        n.f(s3Var, "this$0");
        n.f(c0Var, "emitter");
        RequestProvider requestProvider = s3Var.c();
        if (requestProvider != null) {
            requestProvider.getUpdatesForDevice(new ZendeskInteractor_getUnreadMessageCount_1_1(c0Var));
        } else {
            c0Var.onError(new Exception("Zendesk Request provider is not available"));
        }
    }

    private static final Integer g(Throwable th) {
        n.f(th, "it");
        a.d(th);
        return null;
    }

    private final a0<List<Request>> h() {
        a0 just;
        Object data = this.timeUtils.getData(this.authService.v(), this.b.g());
        if (data != null) {
            str = "{\n            Single.just(cacheValue)\n        }";
            n.e(a0.just(data), str);
        } else {
            str = "{\n            getRemoteUserRequestHistory().map { response ->\n                zendeskRequestHistoryCache.setData(\n                    authService.currentUserId,\n                    timeUtils.currentTimeInMillis,\n                    response\n                )\n                response\n            }\n        }";
            n.e(getRemoteUserRequestHistory().map(new kotlinx.coroutines.w1(this)), str);
        }
        return just;
    }

    private static final List i(s3 s3Var, List list) {
        n.f(s3Var, "this$0");
        n.f(list, "response");
        s3Var.timeUtils.setData(s3Var.authService.v(), s3Var.b.g(), list);
        return list;
    }

    private static final Boolean k(List list) {
        n.f(list, "it");
        return Boolean.valueOf(!list.isEmpty());
    }

    private static final Boolean l(Throwable th) {
        n.f(th, "it");
        a.d(th);
        return Boolean.FALSE;
    }

    public final a0<Integer> f() {
        a0 onErrorReturn;
        if (this.authService.D()) {
            str = "{\n            getUnreadMessageCount().onErrorReturn {\n                Timber.e(it)\n                0\n            }\n        }";
            n.e(d().onErrorReturn(kotlinx.coroutines.v1.a), str);
        } else {
            int i = 0;
            str2 = "Skipping zendesk call for anonymous users";
            a.f(str2, new Object[i]);
            str = "{\n            Timber.i(\"Skipping zendesk call for anonymous users\")\n            Single.just(0)\n        }";
            n.e(a0.just(Integer.valueOf(i)), str);
        }
        return onErrorReturn;
    }

    public final a0<Boolean> j() {
        a0 onErrorReturn;
        if (this.authService.D()) {
            str = "{\n            getUserRequestHistory()\n                .map { it.isNotEmpty() }\n                .onErrorReturn {\n                    Timber.e(it)\n                    false\n                }\n        }";
            n.e(h().map(kotlinx.coroutines.s1.a).onErrorReturn(kotlinx.coroutines.r1.a), str);
        } else {
            a.f("Skipping zendesk call for anonymous users", new Object[0]);
            str = "{\n            Timber.i(\"Skipping zendesk call for anonymous users\")\n            Single.just(false)\n        }";
            n.e(a0.just(Boolean.FALSE), str);
        }
        return onErrorReturn;
    }

    public static /* synthetic */ Boolean m(Throwable th) {
        return ZendeskInteractor.l(th);
    }

    public static /* synthetic */ Boolean n(List list) {
        return ZendeskInteractor.k(list);
    }

    public static /* synthetic */ void o(s3 s3Var, c0 c0Var) {
        ZendeskInteractor.b(s3Var, c0Var);
    }

    public static /* synthetic */ void p(s3 s3Var, c0 c0Var) {
        ZendeskInteractor.e(s3Var, c0Var);
    }

    public static /* synthetic */ Integer q(Throwable th) {
        return ZendeskInteractor.g(th);
    }

    public static /* synthetic */ List r(s3 s3Var, List list) {
        ZendeskInteractor.i(s3Var, list);
        return list;
    }
}
