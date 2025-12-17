package app.dogo.com.dogo_android.util;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerClient.Builder;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u001e\u0010\u000c\u001a\u00020\r2\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\u00020\r2\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/util/InstallReferrerWrapper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "referrerClient", "Lcom/android/installreferrer/api/InstallReferrerClient;", "getStateListener", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "taskSource", "Lcom/google/android/gms/tasks/TaskCompletionSource;", "Landroid/net/Uri;", "onReferrerSetupFinishFailure", "", "responseCode", "", "onReferrerSetupFinishSuccess", "startConnection", "Lcom/google/android/gms/tasks/Task;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r {

    private final InstallReferrerClient a;

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007", d2 = {"app/dogo/com/dogo_android/util/InstallReferrerWrapper$getStateListener$1", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "onInstallReferrerServiceDisconnected", "", "onInstallReferrerSetupFinished", "responseCode", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements InstallReferrerStateListener {

        final app.dogo.com.dogo_android.util.r a;
        final k<Uri> b;
        a(app.dogo.com.dogo_android.util.r r, k<Uri> k2) {
            this.a = r;
            this.b = k2;
            super();
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerServiceDisconnected() {
        }

        @Override // com.android.installreferrer.api.InstallReferrerStateListener
        public void onInstallReferrerSetupFinished(int i) {
            Object obj;
            k kVar;
            app.dogo.com.dogo_android.util.r obj3;
            if (i == 0) {
                r.c(this.a, this.b);
            } else {
                r.b(this.a, this.b, i);
            }
            if (r.a(this.a).isReady()) {
                r.a(this.a).endConnection();
            }
        }
    }
    public r(Context context) {
        super();
        InstallReferrerClient obj2 = InstallReferrerClient.newBuilder(context).build();
        n.e(obj2, "newBuilder(context).build()");
        this.a = obj2;
    }

    public static final InstallReferrerClient a(app.dogo.com.dogo_android.util.r r) {
        return r.a;
    }

    public static final void b(app.dogo.com.dogo_android.util.r r, k k2, int i3) {
        r.e(k2, i3);
    }

    public static final void c(app.dogo.com.dogo_android.util.r r, k k2) {
        r.f(k2);
    }

    private final InstallReferrerStateListener d(k<Uri> k) {
        r.a aVar = new r.a(this, k);
        return aVar;
    }

    private final void e(k<Uri> k, int i2) {
        String str;
        Exception obj3;
        if (i2 != -1) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                    } else {
                        obj3 = new Exception("encountered DEVELOPER_ERROR");
                        k.b(obj3);
                    }
                } else {
                    obj3 = new Exception("encountered FEATURE_NOT_SUPPORTED");
                    k.b(obj3);
                }
            } else {
                obj3 = new Exception("encountered SERVICE_UNAVAILABLE");
                k.b(obj3);
            }
        } else {
            obj3 = new Exception("encountered SERVICE_DISCONNECTED");
            k.b(obj3);
        }
    }

    private final void f(k<Uri> k) {
        Uri build;
        Uri.Builder builder;
        String str;
        try {
            builder = new Uri.Builder();
            k.e(builder.encodedQuery(this.a.getInstallReferrer().getInstallReferrer()).build());
            Exception exception = new Exception("failed to parse link", th);
            k.b(exception);
        }
    }

    public final j<Uri> g() {
        InstallReferrerClient client;
        k kVar = new k();
        final j jVar = kVar.a();
        n.e(jVar, "taskSource.task");
        this.a.startConnection(d(kVar));
        return jVar;
    }
}
