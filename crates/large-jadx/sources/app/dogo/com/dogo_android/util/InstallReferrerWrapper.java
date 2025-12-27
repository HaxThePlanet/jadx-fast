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

/* compiled from: InstallReferrerWrapper.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u001e\u0010\u000c\u001a\u00020\r2\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\u00020\r2\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/util/InstallReferrerWrapper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "referrerClient", "Lcom/android/installreferrer/api/InstallReferrerClient;", "getStateListener", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "taskSource", "Lcom/google/android/gms/tasks/TaskCompletionSource;", "Landroid/net/Uri;", "onReferrerSetupFinishFailure", "", "responseCode", "", "onReferrerSetupFinishSuccess", "startConnection", "Lcom/google/android/gms/tasks/Task;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r, reason: from kotlin metadata */
public final class InstallReferrerWrapper {

    /* renamed from: a, reason: from kotlin metadata */
    private final InstallReferrerClient referrerClient;

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007", d2 = {"app/dogo/com/dogo_android/util/InstallReferrerWrapper$getStateListener$1", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "onInstallReferrerServiceDisconnected", "", "onInstallReferrerSetupFinished", "responseCode", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements InstallReferrerStateListener {

        final /* synthetic */ r a;
        final /* synthetic */ k<Uri> b;
        a(k<Uri> kVar) {
            this.a = rVar;
            this.b = kVar;
            super();
        }

        public void onInstallReferrerSetupFinished(int responseCode) {
            if (responseCode == 0) {
                this.a.f(this.b);
            } else {
                this.a.e(this.b, responseCode);
            }
            if (this.a.referrerClient.isReady()) {
                this.a.referrerClient.endConnection();
            }
        }

        public void onInstallReferrerServiceDisconnected() {
        }
    }
    public r(Context context) {
        super();
        InstallReferrerClient builder2 = InstallReferrerClient.newBuilder(context).build();
        n.e(builder2, "newBuilder(context).build()");
        this.referrerClient = builder2;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ InstallReferrerClient getStateListener(r taskSource) {
        return taskSource.referrerClient;
    }

    public static final /* synthetic */ void b(r rVar, k kVar, int i) {
        rVar.e(kVar, i);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public static final /* synthetic */ void onReferrerSetupFinishFailure(r taskSource, k responseCode) {
        taskSource.f(responseCode);
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final InstallReferrerStateListener onReferrerSetupFinishSuccess(k<Uri> taskSource) {
        return new InstallReferrerWrapper_getStateListener_1(this, taskSource);
    }

    private final void e(k<Uri> kVar, int i) {
        if (i == -1) {
            str = "encountered SERVICE_DISCONNECTED";
            kVar.b(new Exception(str));
        } else {
            if (i == 1) {
                str = "encountered SERVICE_UNAVAILABLE";
                kVar.b(new Exception(str));
            } else {
                if (i == 2) {
                    str = "encountered FEATURE_NOT_SUPPORTED";
                    kVar.b(new Exception(str));
                } else {
                    if (i == 3) {
                        str = "encountered DEVELOPER_ERROR";
                        kVar.b(new Exception(str));
                    }
                }
            }
        }
    }

    private final void f(k<Uri> kVar) {
        try {
            kVar.e(new Uri.Builder().encodedQuery(this.referrerClient.getInstallReferrer().getInstallReferrer()).build());
        } catch (Exception e) {
            kVar.b(new Exception("failed to parse link", e));
        }
    }

    /* renamed from: g, reason: from kotlin metadata */
    public final j<Uri> startConnection() {
        final k kVar = new k();
        final j jVar = kVar.a();
        n.e(jVar, "taskSource.task");
        try {
            this.referrerClient.startConnection(onReferrerSetupFinishSuccess(kVar));
        } catch (Exception e) {
            obj.b(e);
        }
        return jVar;
    }
}
