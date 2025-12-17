package app.dogo.com.dogo_android.service;

import android.app.Service;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.j.e;
import app.dogo.com.dogo_android.k.m;
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
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import kotlin.m;
import kotlin.y.p;
import m.a.a.b.a.a;
import m.a.c.j.a;
import m.a.c.l.a;
import zendesk.support.Support;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0002J\u001e\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J(\u0010\u0015\u001a\u00020\n2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0010H\u0002J\u001a\u0010\u0018\u001a\u00020\n2\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0011H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/service/FirebaseCloudMessagingService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "getProgramRepository", "()Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "programRepository$delegate", "Lkotlin/Lazy;", "invalidateProgramCacheIfNeeded", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "isZendeskType", "", "data", "", "", "onMessageReceived", "onNewToken", "newToken", "sendNotification", "notificationData", "Lcom/google/firebase/messaging/RemoteMessage$Notification;", "showZendeskNotification", "uri", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FirebaseCloudMessagingService extends FirebaseMessagingService {

    public static final app.dogo.com.dogo_android.service.FirebaseCloudMessagingService.a Companion;
    private final h a;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/service/FirebaseCloudMessagingService$Companion;", "", "()V", "DOGO_FCM_NOTIFICATION_INTENT", "", "FIELD_OPENED_FROM_PUSH", "FIELD_URI", "ZENDESK_PATH", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "", "org/koin/android/ext/android/ComponentCallbackExtKt$inject$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class b extends p implements a<j1> {

        final a $parameters;
        final a $qualifier;
        final ComponentCallbacks $this_inject;
        public b(ComponentCallbacks componentCallbacks, a a2, a a3) {
            this.$this_inject = componentCallbacks;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final j1 invoke() {
            return a.a(this.$this_inject).c(c0.b(j1.class), this.$qualifier, this.$parameters);
        }
    }
    static {
        FirebaseCloudMessagingService.a aVar = new FirebaseCloudMessagingService.a(0);
        FirebaseCloudMessagingService.Companion = aVar;
    }

    public FirebaseCloudMessagingService() {
        super();
        final int i = 0;
        FirebaseCloudMessagingService.b bVar = new FirebaseCloudMessagingService.b(this, i, i);
        this.a = j.a(m.SYNCHRONIZED, bVar);
    }

    private final j1 a() {
        return (j1)this.a.getValue();
    }

    private final void b(RemoteMessage remoteMessage) {
        Object obj2;
        final String str = "uri";
        if ((String)remoteMessage.getData().get(str) == null) {
            obj2 = "";
        }
        obj2 = Uri.parse(obj2);
        n.e(obj2, str);
        if (obj2 instanceof s) {
            a().w();
        }
    }

    private final boolean c(Map<String, String> map) {
        Object obj2;
        if ((String)map.get("uri") == null) {
            obj2 = "";
        }
        return Uri.parse(obj2).getPathSegments().contains("zendesk");
    }

    private final void d(RemoteMessage.Notification remoteMessage$Notification, Map<String, String> map2) {
        Intent intent = new Intent(this, SplashActivity.class);
        String str = "extras";
        final Object obj2 = map2.get(str);
        String str2 = "notificationType";
        final Object obj3 = map2.get(str2);
        String str3 = "uri";
        intent.addFlags(67108864);
        intent.putExtra("source", "fcm_notification");
        intent.putExtra(str2, (String)obj3);
        intent.putExtra(str, (String)obj2);
        intent.putExtra(str3, (String)map2.get(str3));
        app.dogo.com.dogo_android.service.App.a obj10 = App.Companion;
        n.d(notification);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(obj3);
        stringBuilder.append('_');
        stringBuilder.append(obj2);
        obj10.k().g(obj10.k().f(intent, notification.getTitle(), notification.getBody(), "announcement_id").c(), stringBuilder.toString(), m.Fcm.getId());
    }

    private final void e(RemoteMessage.Notification remoteMessage$Notification, String string2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(string2));
        intent.addFlags(67108864);
        intent.putExtra("opened-from-push-notification", true);
        app.dogo.com.dogo_android.service.App.a companion = App.Companion;
        n.d(notification);
        companion.k().g(companion.k().f(intent, notification.getTitle(), notification.getBody(), "announcement_id").c(), string2, m.Fcm.getId());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Object notification;
        String str;
        boolean refreshRequest;
        int i;
        android.content.Context applicationContext;
        String str2;
        Object obj7;
        n.f(remoteMessage, "remoteMessage");
        IterableFirebaseMessagingService.b(this, remoteMessage);
        b(remoteMessage);
        if (remoteMessage.getNotification() != null) {
            notification = remoteMessage.getData();
            n.e(notification, "remoteMessage.data");
            if (c(notification)) {
                str = "uri";
                Object obj = notification.get(str);
                i = 0;
                if ((String)obj == null) {
                } else {
                    i = l.T0((String)obj, "zendesk/requests/", i, 2, i);
                }
                if (!Support.INSTANCE.refreshRequest(i, getApplicationContext()) && (String)notification.get(str) == null) {
                    if ((String)notification.get(str) == null) {
                        notification = "";
                    }
                    e(remoteMessage.getNotification(), notification);
                }
            } else {
                d(remoteMessage.getNotification(), notification);
            }
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String string) {
        n.f(string, "newToken");
        AppsFlyerLib.getInstance().updateServerUninstallToken(getApplicationContext(), string);
        IterableFirebaseMessagingService.c();
        app.dogo.com.dogo_android.service.App.a companion = App.Companion;
        companion.r().q(q3.FcmToken, string);
        companion.l().K0(string);
    }
}
