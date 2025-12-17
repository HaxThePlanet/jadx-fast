package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
@Deprecated
public final class ad {

    private final boolean AFInAppEventParameterName;
    public final long AFInAppEventType;
    public final String values;

    static final class a {

        private final boolean AFInAppEventType;
        final String valueOf;
        a(String string, boolean z2) {
            super();
            this.valueOf = string;
            this.AFInAppEventType = z2;
        }

        final boolean AFKeystoreWrapper() {
            return this.AFInAppEventType;
        }
    }

    static final class b implements ServiceConnection {

        final LinkedBlockingQueue<IBinder> AFInAppEventType;
        boolean valueOf;
        private b() {
            super();
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1);
            this.AFInAppEventType = linkedBlockingQueue;
            this.valueOf = false;
        }

        b(byte b) {
            super();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
            try {
                this.AFInAppEventType.put(iBinder2);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    static final class c implements IInterface {

        private final IBinder AFInAppEventType;
        c(IBinder iBinder) {
            super();
            this.AFInAppEventType = iBinder;
        }

        @Override // android.os.IInterface
        public final String AFKeystoreWrapper() {
            final Parcel obtain = Parcel.obtain();
            final Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.AFInAppEventType.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            obtain2.recycle();
            obtain.recycle();
            return obtain2.readString();
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.AFInAppEventType;
        }

        @Override // android.os.IInterface
        final boolean valueOf() {
            int i;
            final Parcel obtain = Parcel.obtain();
            final Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            obtain.writeInt(1);
            final int i3 = 0;
            this.AFInAppEventType.transact(2, obtain, obtain2, i3);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
            } else {
                i = i3;
            }
            obtain2.recycle();
            obtain.recycle();
            return i;
        }
    }
    public ad(String string, long l2, boolean z3) {
        super();
        this.values = string;
        this.AFInAppEventType = l2;
        this.AFInAppEventParameterName = obj4;
    }

    static com.appsflyer.internal.ad.a AFInAppEventParameterName(Context context) {
        Throwable th;
        if (Looper.myLooper() == Looper.getMainLooper()) {
        } else {
            int i = 0;
            context.getPackageManager().getPackageInfo("com.android.vending", i);
            ad.b bVar = new ad.b(i);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            int i2 = 1;
            if (context.bindService(intent, bVar, i2)) {
                if (bVar.valueOf) {
                } else {
                    bVar.valueOf = i2;
                    Object poll = bVar.AFInAppEventType.poll(10, obj4);
                    if ((IBinder)poll == null) {
                    } else {
                        ad.c cVar = new ad.c((IBinder)poll);
                        ad.a aVar = new ad.a(cVar.AFKeystoreWrapper(), cVar.valueOf());
                        if (context != null) {
                            context.unbindService(bVar);
                        }
                        return aVar;
                    }
                    TimeoutException timeoutException = new TimeoutException("Timed out waiting for the service connection");
                    throw timeoutException;
                }
                IllegalStateException illegalStateException = new IllegalStateException("Cannot call get on this connection more than once");
                throw illegalStateException;
            }
            if (context == null) {
            } else {
                context.unbindService(bVar);
            }
            IOException obj6 = new IOException("Google Play connection failed");
            throw obj6;
        }
        obj6 = new IllegalStateException("Cannot be called from the main thread");
        throw obj6;
    }

    public final boolean values() {
        return this.AFInAppEventParameterName;
    }
}
