package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.facebook.internal.g0.i.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008&\u0018\u00002\u00020\u0001:\u0001+B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u0012\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u0019J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0004J\u0018\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u001bH$J\u0008\u0010(\u001a\u00020\u0019H\u0002J\u0010\u0010)\u001a\u00020\u00192\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0006\u0010*\u001a\u00020\u0015R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,", d2 = {"Lcom/facebook/internal/PlatformServiceClient;", "Landroid/content/ServiceConnection;", "context", "Landroid/content/Context;", "requestMessage", "", "replyMessage", "protocolVersion", "applicationId", "", "nonce", "(Landroid/content/Context;IIILjava/lang/String;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "handler", "Landroid/os/Handler;", "listener", "Lcom/facebook/internal/PlatformServiceClient$CompletedListener;", "getNonce", "()Ljava/lang/String;", "running", "", "sender", "Landroid/os/Messenger;", "callback", "", "result", "Landroid/os/Bundle;", "cancel", "handleMessage", "message", "Landroid/os/Message;", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "Landroid/os/IBinder;", "onServiceDisconnected", "populateRequestBundle", "data", "sendMessage", "setCompletedListener", "start", "CompletedListener", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public abstract class x implements ServiceConnection {

    private final int A;
    private final String B;
    private final Context a;
    private final Handler b;
    private com.facebook.internal.x.b c;
    private boolean v;
    private Messenger w;
    private final int x;
    private final int y;
    private final String z;

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"com/facebook/internal/PlatformServiceClient$1", "Landroid/os/Handler;", "handleMessage", "", "message", "Landroid/os/Message;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class a extends Handler {

        final com.facebook.internal.x a;
        a(com.facebook.internal.x x) {
            this.a = x;
            super();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (a.d(this)) {
            }
            n.f(message, "message");
            this.a.c(message);
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006", d2 = {"Lcom/facebook/internal/PlatformServiceClient$CompletedListener;", "", "completed", "", "result", "Landroid/os/Bundle;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public interface b {
        public abstract void a(Bundle bundle);
    }
    public x(Context context, int i2, int i3, int i4, String string5, String string6) {
        Object obj2;
        n.f(context, "context");
        n.f(string5, "applicationId");
        super();
        Context applicationContext = context.getApplicationContext();
        obj2 = applicationContext != null ? applicationContext : obj2;
        this.a = obj2;
        this.x = i2;
        this.y = i3;
        this.z = string5;
        this.A = i4;
        this.B = string6;
        obj2 = new x.a(this);
        this.b = obj2;
    }

    private final void a(Bundle bundle) {
        if (!this.v) {
        }
        this.v = false;
        com.facebook.internal.x.b bVar = this.c;
        if (bVar != null) {
            bVar.a(bundle);
        }
    }

    private final void e() {
        String str;
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.z);
        String str3 = this.B;
        if (str3 != null) {
            bundle.putString("com.facebook.platform.extra.NONCE", str3);
        }
        d(bundle);
        Message obtain = Message.obtain(0, this.x);
        obtain.arg1 = this.A;
        n.e(obtain, "request");
        obtain.setData(bundle);
        Messenger messenger = new Messenger(this.b);
        obtain.replyTo = messenger;
        Messenger messenger2 = this.w;
        if (messenger2 != null) {
            messenger2.send(obtain);
        }
    }

    @Override // android.content.ServiceConnection
    public final void b() {
        this.v = false;
    }

    @Override // android.content.ServiceConnection
    protected final void c(Message message) {
        int string;
        Bundle obj3;
        n.f(message, "message");
        if (message.what == this.y) {
            obj3 = message.getData();
            if (obj3.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                a(0);
            } else {
                a(obj3);
            }
            this.a.unbindService(this);
        }
    }

    @Override // android.content.ServiceConnection
    protected abstract void d(Bundle bundle);

    @Override // android.content.ServiceConnection
    public final void f(com.facebook.internal.x.b x$b) {
        this.c = b;
    }

    @Override // android.content.ServiceConnection
    public final boolean g() {
        int i;
        i = 0;
        synchronized (this) {
            try {
                return i;
            }
            return i;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
        n.f(componentName, "name");
        n.f(iBinder2, "service");
        Messenger obj2 = new Messenger(iBinder2);
        this.w = obj2;
        e();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        n.f(componentName, "name");
        final int obj2 = 0;
        this.w = obj2;
        this.a.unbindService(this);
        a(obj2);
    }
}
