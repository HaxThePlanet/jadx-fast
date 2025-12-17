package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.r;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class a implements ServiceConnection {

    boolean a = false;
    private final BlockingQueue<IBinder> b;
    public a() {
        super();
        int i = 0;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.b = linkedBlockingQueue;
    }

    public IBinder a(long l, TimeUnit timeUnit2) {
        r.i("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.a) {
        } else {
            this.a = true;
            Object obj2 = this.b.poll(l, timeUnit2);
            if ((IBinder)obj2 == null) {
            } else {
                return (IBinder)obj2;
            }
            obj2 = new TimeoutException("Timed out waiting for the service connection");
            throw obj2;
        }
        obj2 = new IllegalStateException("Cannot call get on this connection more than once");
        throw obj2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        this.b.add(iBinder2);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
