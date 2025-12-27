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

/* compiled from: IterableFirebaseMessagingService.java */
/* loaded from: classes2.dex */
public class IterableFirebaseMessagingService extends FirebaseMessagingService {
    public static String a() {
        String str3;
        Object obj;
        try {
            obj = m.a(FirebaseMessaging.getInstance().getToken());
        } catch (Exception unused) {
            str3 = "Failed to fetch firebase token";
            j0.c(str, str3);
        } catch (java.lang.InterruptedException interrupted1) {
            interrupted1 = interrupted1.getLocalizedMessage();
            j0.c(str, interrupted1);
        } catch (java.util.concurrent.ExecutionException execution2) {
            execution2 = execution2.getLocalizedMessage();
            j0.c(str, execution2);
        }
        return obj;
    }

    public static boolean b(Context context, RemoteMessage remoteMessage) {
        Map data = remoteMessage.getData();
        final int i = 0;
        return false;
    }

    public static void c() {
        String str = IterableFirebaseMessagingService.a();
        StringBuilder stringBuilder = new StringBuilder();
        final String str4 = "New Firebase Token generated: ";
        str2 = str4 + str;
        j0.a("itblFCMMessagingService", str2);
        j.s().H();
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        IterableFirebaseMessagingService.b(this, remoteMessage);
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        IterableFirebaseMessagingService.c();
    }
}
