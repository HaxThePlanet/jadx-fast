package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;

/* loaded from: classes2.dex */
public final class k implements Handler.Callback {

    public final com.google.android.gms.cloudmessaging.r a;
    public k(com.google.android.gms.cloudmessaging.r r) {
        super();
        this.a = r;
    }

    @Override // android.os.Handler$Callback
    public final boolean handleMessage(Message message) {
        com.google.android.gms.cloudmessaging.r boolean;
        String str2;
        boolean loggable;
        Object str3;
        int str;
        Object obj5;
        boolean = this.a;
        int arg1 = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            StringBuilder stringBuilder = new StringBuilder(41);
            stringBuilder.append("Received response to request: ");
            stringBuilder.append(arg1);
            Log.d("MessengerIpcClient", stringBuilder.toString());
        }
        str3 = boolean.w.get(arg1);
        synchronized (boolean) {
            obj5 = new StringBuilder(50);
            obj5.append("Received response for unknown request: ");
            obj5.append(arg1);
            Log.w("MessengerIpcClient", obj5.toString());
        }
        return 1;
    }
}
