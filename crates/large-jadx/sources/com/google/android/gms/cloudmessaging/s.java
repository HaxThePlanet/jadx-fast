package com.google.android.gms.cloudmessaging;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes2.dex */
final class s {

    private final Messenger a = null;
    private final com.google.android.gms.cloudmessaging.i b = null;
    s(IBinder iBinder) {
        String obj4;
        super();
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        final int i = 0;
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            Messenger messenger = new Messenger(iBinder);
            this.a = messenger;
        }
        if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            i iVar = new i(iBinder);
            this.b = iVar;
        }
        obj4 = String.valueOf(interfaceDescriptor);
        String str = "Invalid interface descriptor: ";
        if (obj4.length() != 0) {
            obj4 = str.concat(obj4);
        } else {
            obj4 = new String(str);
        }
        Log.w("MessengerIpcClient", obj4);
        obj4 = new RemoteException();
        throw obj4;
    }

    final void a(Message message) {
        Messenger messenger = this.a;
        if (messenger != null) {
            messenger.send(message);
        }
        com.google.android.gms.cloudmessaging.i iVar = this.b;
        if (iVar == null) {
        } else {
            iVar.b(message);
        }
        IllegalStateException obj2 = new IllegalStateException("Both messengers are null");
        throw obj2;
    }
}
