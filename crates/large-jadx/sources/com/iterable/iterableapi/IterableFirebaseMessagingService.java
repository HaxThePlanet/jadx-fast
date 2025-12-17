package com.iterable.iterableapi;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.gms.tasks.m;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.messaging.RemoteMessage.Notification;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public class IterableFirebaseMessagingService extends FirebaseMessagingService {
    public static String a() {
        String str;
        Object obj;
        final String str2 = "itblFCMMessagingService";
        obj = m.a(FirebaseMessaging.getInstance().getToken());
        return obj;
    }

    public static boolean b(Context context, RemoteMessage remoteMessage2) {
        Map equals;
        Object stringBuilder2;
        boolean stringBuilder;
        int size;
        String str2;
        String str;
        String obj6;
        String obj7;
        equals = remoteMessage2.getData();
        final int i = 0;
        if (equals != null) {
            if (equals.size() == 0) {
            } else {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Message data payload: ");
                stringBuilder3.append(remoteMessage2.getData());
                String str5 = "itblFCMMessagingService";
                j0.a(str5, stringBuilder3.toString());
                if (remoteMessage2.getNotification() != null) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Message Notification Body: ");
                    stringBuilder2.append(remoteMessage2.getNotification().getBody());
                    j0.a(str5, stringBuilder2.toString());
                }
                obj7 = n0.f(equals);
                if (!n0.e(obj7)) {
                    j0.a(str5, "Not an Iterable push message");
                    return i;
                }
                int i2 = 1;
                if (!n0.d(obj7)) {
                    if (!n0.c(obj7)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Iterable push received ");
                        stringBuilder.append(equals);
                        j0.a(str5, stringBuilder.toString());
                        obj7 = new o0();
                        equals = new l0[i2];
                        equals[i] = n0.a(context.getApplicationContext(), obj7);
                        obj7.execute(equals);
                    } else {
                        j0.a(str5, "Iterable OS notification push received");
                    }
                } else {
                    j0.a(str5, "Iterable ghost silent push received");
                    obj6 = obj7.getString("notificationType");
                    if (obj6 != null && j.s().t() != null) {
                        if (j.s().t() != null) {
                            if (obj6.equals("InAppUpdate")) {
                                j.s().q().I();
                            } else {
                                obj6 = obj7.getString("messageId");
                                if (obj6.equals("InAppRemove") && obj6 != null) {
                                    obj6 = obj7.getString("messageId");
                                    if (obj6 != null) {
                                        j.s().q().A(obj6);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return i2;
        }
        return i;
    }

    public static void c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("New Firebase Token generated: ");
        stringBuilder.append(IterableFirebaseMessagingService.a());
        j0.a("itblFCMMessagingService", stringBuilder.toString());
        j.s().H();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        IterableFirebaseMessagingService.b(this, remoteMessage);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String string) {
        IterableFirebaseMessagingService.c();
    }
}
