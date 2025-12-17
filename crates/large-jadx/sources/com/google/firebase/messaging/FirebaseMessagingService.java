package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class FirebaseMessagingService extends com.google.firebase.messaging.EnhancedIntentService {

    public static final String ACTION_DIRECT_BOOT_REMOTE_INTENT = "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT";
    private static final Queue<String> recentlyReceivedMessageIds;
    static {
        ArrayDeque arrayDeque = new ArrayDeque(10);
        FirebaseMessagingService.recentlyReceivedMessageIds = arrayDeque;
    }

    private boolean alreadyReceivedMessage(String string) {
        boolean loggable;
        boolean contains;
        Object obj5;
        int i2 = 0;
        if (TextUtils.isEmpty(string)) {
            return i2;
        }
        Queue recentlyReceivedMessageIds = FirebaseMessagingService.recentlyReceivedMessageIds;
        String str = "FirebaseMessaging";
        if (recentlyReceivedMessageIds.contains(string) && Log.isLoggable(str, 3)) {
            str = "FirebaseMessaging";
            if (Log.isLoggable(str, 3)) {
                obj5 = String.valueOf(string);
                loggable = "Received duplicate message: ";
                if (obj5.length() != 0) {
                    obj5 = loggable.concat(obj5);
                } else {
                    obj5 = new String(loggable);
                }
                Log.d(str, obj5);
            }
            return 1;
        }
        if (recentlyReceivedMessageIds.size() >= 10) {
            recentlyReceivedMessageIds.remove();
        }
        recentlyReceivedMessageIds.add(string);
        return i2;
    }

    private void dispatchMessage(Intent intent) {
        Bundle extras;
        boolean uploadScionMetrics;
        ExecutorService networkIOExecutor;
        com.google.firebase.messaging.DisplayNotification displayNotification;
        if (intent.getExtras() == null) {
            extras = new Bundle();
        }
        extras.remove("androidx.content.wakelockid");
        NotificationParams notificationParams = new NotificationParams(extras);
        networkIOExecutor = FcmExecutors.newNetworkIOExecutor();
        displayNotification = new DisplayNotification(this, notificationParams, networkIOExecutor);
        if (NotificationParams.isNotification(extras) && displayNotification.handleNotification()) {
            notificationParams = new NotificationParams(extras);
            networkIOExecutor = FcmExecutors.newNetworkIOExecutor();
            displayNotification = new DisplayNotification(this, notificationParams, networkIOExecutor);
            if (displayNotification.handleNotification()) {
                networkIOExecutor.shutdown();
            }
            networkIOExecutor.shutdown();
            if (MessagingAnalytics.shouldUploadScionMetrics(intent)) {
                MessagingAnalytics.logNotificationForeground(intent);
            }
        }
        RemoteMessage obj5 = new RemoteMessage(extras);
        onMessageReceived(obj5);
    }

    private String getMessageId(Intent intent) {
        String stringExtra = intent.getStringExtra("google.message_id");
        if (stringExtra == null) {
            return intent.getStringExtra("message_id");
        }
        return stringExtra;
    }

    private void handleMessageIntent(Intent intent) {
        if (!alreadyReceivedMessage(intent.getStringExtra("google.message_id"))) {
            passMessageIntentToSdk(intent);
        }
    }

    private void passMessageIntentToSdk(Intent intent) {
        String stringExtra;
        String equals;
        int i;
        String obj7;
        equals = "gcm";
        if (intent.getStringExtra("message_type") == null) {
            stringExtra = equals;
        }
        final int i4 = 3;
        final int i5 = 2;
        final int i7 = 1;
        switch (stringExtra) {
            case "deleted_messages":
                i = i7;
                i = -1;
                break;
            case "gcm":
                i = 0;
                i = -1;
                break;
            case "send_error":
                i = i4;
                i = -1;
                break;
            case "send_event":
                i = i5;
                i = -1;
                break;
            default:
                i = -1;
        }
        if (i != 0 && i != i7 && i != i5 && i != i4) {
            if (i != i7) {
                if (i != i5) {
                    if (i != i4) {
                        obj7 = "Received message with unknown type: ";
                        if (stringExtra.length() != 0) {
                            obj7 = obj7.concat(stringExtra);
                        } else {
                            stringExtra = new String(obj7);
                            obj7 = stringExtra;
                        }
                        Log.w("FirebaseMessaging", obj7);
                    }
                    SendException sendException = new SendException(intent.getStringExtra("error"));
                    onSendError(getMessageId(intent), sendException);
                }
                onMessageSent(intent.getStringExtra("google.message_id"));
            }
            onDeletedMessages();
        }
        MessagingAnalytics.logNotificationReceived(intent);
        dispatchMessage(intent);
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    protected Intent getStartCommandIntent(Intent intent) {
        return ServiceStarter.getInstance().getMessagingEvent();
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void handleIntent(Intent intent) {
        boolean equals;
        String obj3;
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(action)) {
            if ("com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(action)) {
            } else {
                if ("com.google.firebase.messaging.NEW_TOKEN".equals(action)) {
                    onNewToken(intent.getStringExtra("token"));
                }
                obj3 = String.valueOf(intent.getAction());
                String str = "Unknown intent action: ";
                if (obj3.length() != 0) {
                    obj3 = str.concat(obj3);
                } else {
                    obj3 = new String(str);
                }
            }
            Log.d("FirebaseMessaging", obj3);
        }
        handleMessageIntent(intent);
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void onDeletedMessages() {
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void onMessageReceived(com.google.firebase.messaging.RemoteMessage remoteMessage) {
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void onMessageSent(String string) {
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void onNewToken(String string) {
    }

    @Override // com.google.firebase.messaging.EnhancedIntentService
    public void onSendError(String string, Exception exception2) {
    }
}
