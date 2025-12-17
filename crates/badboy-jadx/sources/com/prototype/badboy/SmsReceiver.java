package com.prototype.badboy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony.Sms.Intents;
import android.telephony.SmsMessage;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0016¨\u0006\n", d2 = {"Lcom/prototype/badboy/SmsReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SmsReceiver extends BroadcastReceiver {

    public static final int $stable;
    static {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean messagesFromIntent;
        String str;
        int i3;
        int length;
        int i;
        SmsMessage smsMessage2;
        SmsMessage smsMessage;
        int i2;
        String string;
        String str2;
        String str3;
        String str4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), "android.provider.Telephony.SMS_RECEIVED")) {
            messagesFromIntent = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            Intrinsics.checkNotNull(messagesFromIntent);
            str = messagesFromIntent;
            i3 = 0;
            i = 0;
            while (i < str.length) {
                smsMessage = smsMessage2;
                i2 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                Log.d("SmsReceiver", stringBuilder.append("From: ").append(smsMessage.getOriginatingAddress()).append(", Body: ").append(smsMessage.getMessageBody()).toString());
                i++;
            }
        }
    }
}
