package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.z;
import com.zendesk.service.a;
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
import n.a.a;
import zendesk.support.ProviderStore;
import zendesk.support.Request;
import zendesk.support.RequestProvider;
import zendesk.support.RequestUpdates;
import zendesk.support.Support;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u0010H\u0002J\u000e\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0010H\u0002J\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0010J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u0010H\u0002J\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;", "", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/Utilities;)V", "requestProvider", "Lzendesk/support/RequestProvider;", "getRequestProvider", "()Lzendesk/support/RequestProvider;", "zendeskRequestHistoryCache", "Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "", "Lzendesk/support/Request;", "getRemoteUserRequestHistory", "Lio/reactivex/Single;", "getUnreadMessageCount", "", "getUnreadMessageCountOrZero", "getUserRequestHistory", "hasRequestHistory", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class s3 {

    private final h2 a;
    private final v2 b;
    private final z<List<Request>> c;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010\u0008\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016¨\u0006\n", d2 = {"app/dogo/com/dogo_android/repository/interactor/ZendeskInteractor$getRemoteUserRequestHistory$1$1", "Lcom/zendesk/service/ZendeskCallback;", "", "Lzendesk/support/Request;", "onError", "", "error", "Lcom/zendesk/service/ErrorResponse;", "onSuccess", "requests", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends f<List<? extends Request>> {

        final c0<List<Request>> a;
        a(c0<List<Request>> c0) {
            this.a = c0;
            super();
        }

        @Override // com.zendesk.service.f
        public void onError(a a) {
            int obj4;
            if (a == null) {
                obj4 = 0;
            } else {
                obj4 = a.b();
            }
            Exception exception = new Exception(n.o("Zendesk Updates request failed because ", obj4));
            this.a.onError(exception);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(Object object) {
            onSuccess((List)object);
        }

        public void onSuccess(List<? extends Request> list) {
            List obj2;
            if (list == null) {
                obj2 = p.g();
            }
            this.a.onSuccess(obj2);
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/repository/interactor/ZendeskInteractor$getUnreadMessageCount$1$1", "Lcom/zendesk/service/ZendeskCallback;", "Lzendesk/support/RequestUpdates;", "onError", "", "error", "Lcom/zendesk/service/ErrorResponse;", "onSuccess", "requestUpdates", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends f<RequestUpdates> {

        final c0<Integer> a;
        b(c0<Integer> c0) {
            this.a = c0;
            super();
        }

        @Override // com.zendesk.service.f
        public void onError(a a) {
            int obj4;
            if (a == null) {
                obj4 = 0;
            } else {
                obj4 = a.b();
            }
            Exception exception = new Exception(n.o("Zendesk Updates request failed because ", obj4));
            this.a.onError(exception);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(Object object) {
            onSuccess((RequestUpdates)object);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(RequestUpdates requestUpdates) {
            Object valueOf;
            Object obj2;
            if (requestUpdates != null) {
                if (requestUpdates.hasUpdatedRequests()) {
                    this.a.onSuccess(Integer.valueOf(requestUpdates.getRequestUpdates().size()));
                } else {
                    this.a.onSuccess(0);
                }
            }
        }
    }
    public s3(h2 h2, v2 v22) {
        n.f(h2, "authService");
        n.f(v22, "timeUtils");
        super();
        this.a = h2;
        this.b = v22;
        z obj3 = new z(TimeUnit.MINUTES.toMillis(15), obj1);
        this.c = obj3;
    }

    private final a0<List<Request>> a() {
        t1 t1Var = new t1(this);
        a0 create = a0.create(t1Var);
        n.e(create, "create { emitter ->\n            val localRequestProvider = requestProvider\n            if (localRequestProvider != null) {\n                localRequestProvider.getAllRequests(object : ZendeskCallback<List<Request>>() {\n                    override fun onSuccess(requests: List<Request>?) {\n                        emitter.onSuccess(requests ?: emptyList())\n                    }\n\n                    override fun onError(error: ErrorResponse?) {\n                        emitter.onError(Exception(\"Zendesk Updates request failed because ${error?.reason}\"))\n                    }\n                })\n            } else {\n                emitter.onError(Exception(\"Zendesk Request provider is not available\"))\n            }\n        }");
        return create;
    }

    private static final void b(app.dogo.com.dogo_android.s.a.s3 s3, c0 c02) {
        Object aVar;
        Object obj1;
        n.f(s3, "this$0");
        n.f(c02, "emitter");
        obj1 = s3.c();
        if (obj1 != null) {
            aVar = new s3.a(c02);
            obj1.getAllRequests(aVar);
        } else {
            obj1 = new Exception("Zendesk Request provider is not available");
            c02.onError(obj1);
        }
    }

    private final RequestProvider c() {
        int requestProvider;
        ProviderStore provider = Support.INSTANCE.provider();
        if (provider == null) {
            requestProvider = 0;
        } else {
            requestProvider = provider.requestProvider();
        }
        return requestProvider;
    }

    private final a0<Integer> d() {
        u1 u1Var = new u1(this);
        a0 create = a0.create(u1Var);
        n.e(create, "create { emitter ->\n            val localRequestProvider = requestProvider\n            if (localRequestProvider != null) {\n                localRequestProvider.getUpdatesForDevice(object : ZendeskCallback<RequestUpdates>() {\n                    override fun onSuccess(requestUpdates: RequestUpdates?) {\n                        if (requestUpdates != null) {\n                            if (requestUpdates.hasUpdatedRequests()) {\n                                val updatesCount = requestUpdates.requestUpdates.size\n                                emitter.onSuccess(updatesCount)\n                            } else {\n                                emitter.onSuccess(0)\n                            }\n                        }\n                    }\n\n                    override fun onError(error: ErrorResponse?) {\n                        emitter.onError(Exception(\"Zendesk Updates request failed because ${error?.reason}\"))\n                    }\n                })\n            } else {\n                emitter.onError(Exception(\"Zendesk Request provider is not available\"))\n            }\n        }");
        return create;
    }

    private static final void e(app.dogo.com.dogo_android.s.a.s3 s3, c0 c02) {
        Object bVar;
        Object obj1;
        n.f(s3, "this$0");
        n.f(c02, "emitter");
        obj1 = s3.c();
        if (obj1 != null) {
            bVar = new s3.b(c02);
            obj1.getUpdatesForDevice(bVar);
        } else {
            obj1 = new Exception("Zendesk Request provider is not available");
            c02.onError(obj1);
        }
    }

    private static final Integer g(Throwable throwable) {
        n.f(throwable, "it");
        a.d(throwable);
        return null;
    }

    private final a0<List<Request>> h() {
        a0 just;
        String str;
        Object obj = this.c.a(this.a.v(), this.b.g());
        if ((List)obj != null) {
            n.e(a0.just((List)obj), "{\n            Single.just(cacheValue)\n        }");
        } else {
            w1 w1Var = new w1(this);
            n.e(a().map(w1Var), "{\n            getRemoteUserRequestHistory().map { response ->\n                zendeskRequestHistoryCache.setData(\n                    authService.currentUserId,\n                    timeUtils.currentTimeInMillis,\n                    response\n                )\n                response\n            }\n        }");
        }
        return just;
    }

    private static final List i(app.dogo.com.dogo_android.s.a.s3 s3, List list2) {
        n.f(s3, "this$0");
        n.f(list2, "response");
        s3.c.f(s3.a.v(), s3.b.g(), obj3);
        return list2;
    }

    private static final Boolean k(List list) {
        n.f(list, "it");
        return Boolean.valueOf(obj1 ^= 1);
    }

    private static final Boolean l(Throwable throwable) {
        n.f(throwable, "it");
        a.d(throwable);
        return Boolean.FALSE;
    }

    public static Boolean m(Throwable throwable) {
        return s3.l(throwable);
    }

    public static Boolean n(List list) {
        return s3.k(list);
    }

    public static void o(app.dogo.com.dogo_android.s.a.s3 s3, c0 c02) {
        s3.b(s3, c02);
    }

    public static void p(app.dogo.com.dogo_android.s.a.s3 s3, c0 c02) {
        s3.e(s3, c02);
    }

    public static Integer q(Throwable throwable) {
        return s3.g(throwable);
    }

    public static List r(app.dogo.com.dogo_android.s.a.s3 s3, List list2) {
        s3.i(s3, list2);
        return list2;
    }

    public final a0<Integer> f() {
        a0 onErrorReturn;
        String str;
        String str2;
        if (this.a.D()) {
            n.e(d().onErrorReturn(v1.a), "{\n            getUnreadMessageCount().onErrorReturn {\n                Timber.e(it)\n                0\n            }\n        }");
        } else {
            int i = 0;
            a.f("Skipping zendesk call for anonymous users", new Object[i]);
            n.e(a0.just(Integer.valueOf(i)), "{\n            Timber.i(\"Skipping zendesk call for anonymous users\")\n            Single.just(0)\n        }");
        }
        return onErrorReturn;
    }

    public final a0<Boolean> j() {
        a0 onErrorReturn;
        String str;
        if (this.a.D()) {
            n.e(h().map(s1.a).onErrorReturn(r1.a), "{\n            getUserRequestHistory()\n                .map { it.isNotEmpty() }\n                .onErrorReturn {\n                    Timber.e(it)\n                    false\n                }\n        }");
        } else {
            a.f("Skipping zendesk call for anonymous users", new Object[0]);
            n.e(a0.just(Boolean.FALSE), "{\n            Timber.i(\"Skipping zendesk call for anonymous users\")\n            Single.just(false)\n        }");
        }
        return onErrorReturn;
    }
}
