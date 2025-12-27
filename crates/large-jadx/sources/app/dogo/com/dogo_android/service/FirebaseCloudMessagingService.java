package app.dogo.com.dogo_android.service;

import android.app.Service;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.j.e;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.util.h0.p1;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import com.appsflyer.AppsFlyerLib;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.messaging.RemoteMessage.Notification;
import com.iterable.iterableapi.IterableFirebaseMessagingService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import zendesk.support.Support;

/* compiled from: FirebaseCloudMessagingService.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J(\u0010\u0015\u001a\u00020\n2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0002J\u001a\u0010\u0018\u001a\u00020\n2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/service/FirebaseCloudMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "getProgramRepository", "()Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "programRepository$delegate", "Lkotlin/Lazy;", "invalidateProgramCacheIfNeeded", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "isZendeskType", "", "data", "", "", "onMessageReceived", "onNewToken", "newToken", "sendNotification", "notificationData", "Lcom/google/firebase/messaging/RemoteMessage$Notification;", "showZendeskNotification", "uri", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FirebaseCloudMessagingService extends FirebaseMessagingService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final FirebaseCloudMessagingService.a INSTANCE = new FirebaseCloudMessagingService$a(0);
    private final h a;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/service/FirebaseCloudMessagingService$Companion;", "", "()V", "DOGO_FCM_NOTIFICATION_INTENT", "", "FIELD_OPENED_FROM_PUSH", "FIELD_URI", "ZENDESK_PATH", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "", "org/koin/android/ext/android/ComponentCallbackExtKt$inject$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.d0.d.p implements kotlin.d0.c.a<j1> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ ComponentCallbacks $this_inject;
        @Override // kotlin.d0.d.p
        public final j1 invoke() {
            return a.a(this.$this_inject).c(c0.b(ProgramRepository.class), this.$qualifier, this.$parameters);
        }

        public b(ComponentCallbacks componentCallbacks, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_inject = componentCallbacks;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    public FirebaseCloudMessagingService() {
        super();
        final m.a.c.j.a aVar = null;
        this.a = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new FirebaseCloudMessagingService.b(this, aVar, aVar));
    }

    private final j1 a() {
        return (ProgramRepository)this.a.getValue();
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final void invalidateProgramCacheIfNeeded(RemoteMessage remoteMessage) {
        String str;
        final String str2 = "uri";
        if ((String)remoteMessage.getData().get(str2) == null) {
            str = "";
        }
        Uri parse = Uri.parse(str);
        n.e(parse, str2);
        z = p.l0(app.dogo.com.dogo_android.util.extensionfunction.p1.getEmptyProgramSaveInfo(parse)) instanceof LessonExamHistoryScreen;
        if (p.l0(app.dogo.com.dogo_android.util.extensionfunction.p1.getEmptyProgramSaveInfo(parse)) instanceof essonExamHistoryScreen) {
            a().w();
        }
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean isZendeskType(Map<String, String> data) {
        String str;
        if ((String)data.get("uri") == null) {
            str = "";
        }
        return Uri.parse(str).getPathSegments().contains("zendesk");
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final void sendNotification(RemoteMessage.Notification notificationData, Map<String, String> data) {
        Intent intent = new Intent(this, SplashActivity.class);
        String str2 = "extras";
        final Object value = data.get(str2);
        String str3 = "notificationType";
        final Object value2 = data.get(str3);
        String str4 = "uri";
        intent.addFlags(67108864);
        intent.putExtra("source", "fcm_notification");
        intent.putExtra(str3, value2);
        intent.putExtra(str2, value);
        intent.putExtra(str4, (String)data.get(str4));
        app.dogo.com.dogo_android.service.App.a iNSTANCE2 = App.INSTANCE;
        n.d(notificationData);
        StringBuilder stringBuilder = new StringBuilder();
        str = value2 + 95 + value;
        iNSTANCE2.k().g(iNSTANCE2.k().f(intent, notificationData.getTitle(), notificationData.getBody(), "announcement_id").c(), str, NotificationType.Fcm.getId());
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final void showZendeskNotification(RemoteMessage.Notification notificationData, String uri) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uri));
        intent.addFlags(67108864);
        intent.putExtra("opened-from-push-notification", true);
        app.dogo.com.dogo_android.service.App.a iNSTANCE2 = App.INSTANCE;
        n.d(notificationData);
        iNSTANCE2.k().g(iNSTANCE2.k().f(intent, notificationData.getTitle(), notificationData.getBody(), "announcement_id").c(), uri, NotificationType.Fcm.getId());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        String str3 = null;
        String str4;
        n.f(remoteMessage, "remoteMessage");
        IterableFirebaseMessagingService.b(this, remoteMessage);
        invalidateProgramCacheIfNeeded(remoteMessage);
        if (remoteMessage.getNotification() != null) {
            Map data = remoteMessage.getData();
            n.e(data, "remoteMessage.data");
            if (isZendeskType(data)) {
                str2 = "uri";
                Object value2 = data.get(str2);
                str3 = null;
                if (value2 != null) {
                    int i = 2;
                    str4 = "zendesk/requests/";
                    str3 = l.T0(value2, str4, str3, i, str3);
                }
                if (!Support.INSTANCE.refreshRequest(str3, getApplicationContext())) {
                    if ((String)data.get(str2) == null) {
                        str = "";
                    }
                    showZendeskNotification(remoteMessage.getNotification(), str);
                }
            } else {
                sendNotification(remoteMessage.getNotification(), data);
            }
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String newToken) {
        n.f(newToken, "newToken");
        AppsFlyerLib.getInstance().updateServerUninstallToken(getApplicationContext(), newToken);
        IterableFirebaseMessagingService.c();
        app.dogo.com.dogo_android.service.App.a iNSTANCE2 = App.INSTANCE;
        iNSTANCE2.r().setUserProperty(UserProperty.FcmToken, newToken);
        iNSTANCE2.l().K0(newToken);
    }
}
