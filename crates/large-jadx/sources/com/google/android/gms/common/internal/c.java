package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.b;
import com.google.android.gms.common.d;
import com.google.android.gms.common.f;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public abstract class c<T extends IInterface>  {

    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = null;
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final d[] zze;
    private volatile String zzA;
    private b zzB;
    private boolean zzC;
    private volatile com.google.android.gms.common.internal.l1 zzD;
    com.google.android.gms.common.internal.w1 zza;
    final Handler zzb;
    protected com.google.android.gms.common.internal.c.c zzc;
    protected AtomicInteger zzd;
    private int zzf;
    private long zzg;
    private long zzh;
    private int zzi;
    private long zzj;
    private volatile String zzk;
    private final Context zzl;
    private final Looper zzm;
    private final com.google.android.gms.common.internal.i zzn;
    private final f zzo;
    private final Object zzp;
    private final Object zzq;
    private com.google.android.gms.common.internal.m zzr;
    private T zzs;
    private final ArrayList<com.google.android.gms.common.internal.g1<?>> zzt;
    private com.google.android.gms.common.internal.i1 zzu;
    private int zzv;
    private final com.google.android.gms.common.internal.c.a zzw;
    private final com.google.android.gms.common.internal.c.b zzx;
    private final int zzy;
    private final String zzz;

    public interface a {
        public abstract void j(int i);

        public abstract void n(Bundle bundle);
    }

    public interface b {
        public abstract void m(b b);
    }

    public interface c {
        public abstract void a(b b);
    }

    public interface e {
        public abstract void a();
    }

    protected class d implements com.google.android.gms.common.internal.c.c {

        final com.google.android.gms.common.internal.c a;
        public d(com.google.android.gms.common.internal.c c) {
            this.a = c;
            super();
        }

        @Override // com.google.android.gms.common.internal.c$c
        public final void a(b b) {
            com.google.android.gms.common.internal.c.b bVar;
            if (b.n2()) {
                final com.google.android.gms.common.internal.c obj3 = this.a;
                obj3.getRemoteService(0, obj3.getScopes());
            }
            if (c.zzn(this.a) != null) {
                c.zzn(this.a).m(b);
            }
        }
    }
    static {
        c.zze = new d[0];
        c.GOOGLE_PLUS_REQUIRED_FEATURES = /* result */;
    }

    protected c(Context context, Handler handler2, com.google.android.gms.common.internal.i i3, f f4, int i5, com.google.android.gms.common.internal.c.a c$a6, com.google.android.gms.common.internal.c.b c$b7) {
        super();
        final int i = 0;
        this.zzk = i;
        Object object = new Object();
        this.zzp = object;
        Object object2 = new Object();
        this.zzq = object2;
        ArrayList arrayList = new ArrayList();
        this.zzt = arrayList;
        this.zzv = 1;
        this.zzB = i;
        int i4 = 0;
        this.zzC = i4;
        this.zzD = i;
        AtomicInteger atomicInteger = new AtomicInteger(i4);
        this.zzd = atomicInteger;
        r.k(context, "Context must not be null");
        this.zzl = context;
        r.k(handler2, "Handler must not be null");
        this.zzb = handler2;
        this.zzm = handler2.getLooper();
        r.k(i3, "Supervisor must not be null");
        this.zzn = i3;
        r.k(f4, "API availability must not be null");
        this.zzo = f4;
        this.zzy = i5;
        this.zzw = a6;
        this.zzx = b7;
        this.zzz = i;
    }

    protected c(Context context, Looper looper2, int i3, com.google.android.gms.common.internal.c.a c$a4, com.google.android.gms.common.internal.c.b c$b5, String string6) {
        r.j(a4);
        r.j(b5);
        super(context, looper2, i.b(context), f.f(), i3, a4, b5, string6);
    }

    protected c(Context context, Looper looper2, com.google.android.gms.common.internal.i i3, f f4, int i5, com.google.android.gms.common.internal.c.a c$a6, com.google.android.gms.common.internal.c.b c$b7, String string8) {
        super();
        int i = 0;
        this.zzk = i;
        Object object = new Object();
        this.zzp = object;
        Object object2 = new Object();
        this.zzq = object2;
        ArrayList arrayList = new ArrayList();
        this.zzt = arrayList;
        this.zzv = 1;
        this.zzB = i;
        int i4 = 0;
        this.zzC = i4;
        this.zzD = i;
        AtomicInteger atomicInteger = new AtomicInteger(i4);
        this.zzd = atomicInteger;
        r.k(context, "Context must not be null");
        this.zzl = context;
        r.k(looper2, "Looper must not be null");
        this.zzm = looper2;
        r.k(i3, "Supervisor must not be null");
        this.zzn = i3;
        r.k(f4, "API availability must not be null");
        this.zzo = f4;
        f1 obj3 = new f1(this, looper2);
        this.zzb = obj3;
        this.zzy = i5;
        this.zzw = a6;
        this.zzx = b7;
        this.zzz = string8;
    }

    static void zzc(com.google.android.gms.common.internal.c c, int i2) {
        int obj3;
        obj3 = c.zzp;
        synchronized (obj3) {
            obj3 = c.zzp;
        }
        c.zzC = true;
        obj3 = 5;
        try {
            Handler zzb = c.zzb;
            zzb.sendMessage(zzb.obtainMessage(obj3, c.zzd.get(), 16));
            throw c;
        }
    }

    static Object zzd(com.google.android.gms.common.internal.c c) {
        return c.zzq;
    }

    static com.google.android.gms.common.internal.m zze(com.google.android.gms.common.internal.c c, com.google.android.gms.common.internal.m m2) {
        c.zzr = m2;
        return m2;
    }

    static b zzf(com.google.android.gms.common.internal.c c, b b2) {
        c.zzB = b2;
        return b2;
    }

    static boolean zzg(com.google.android.gms.common.internal.c c) {
        boolean zzC;
        int i;
        Object obj2;
        i = 0;
        if (c.zzC) {
        } else {
            if (TextUtils.isEmpty(c.getServiceDescriptor())) {
            } else {
                if (TextUtils.isEmpty(c.getLocalStartServiceAction())) {
                } else {
                    Class.forName(c.getServiceDescriptor());
                    i = 1;
                }
            }
        }
        return i;
    }

    static boolean zzh(com.google.android.gms.common.internal.c c) {
        return c.zzC;
    }

    static void zzi(com.google.android.gms.common.internal.c c, int i2, IInterface iInterface3) {
        c.zzp(i2, 0);
    }

    static b zzj(com.google.android.gms.common.internal.c c) {
        return c.zzB;
    }

    static com.google.android.gms.common.internal.c.a zzk(com.google.android.gms.common.internal.c c) {
        return c.zzw;
    }

    static boolean zzl(com.google.android.gms.common.internal.c c, int i2, int i3, IInterface iInterface4) {
        int obj2;
        final Object zzp = c.zzp;
        synchronized (zzp) {
            obj2 = 0;
        }
        try {
            return obj2;
            throw c;
        }
    }

    static ArrayList zzm(com.google.android.gms.common.internal.c c) {
        return c.zzt;
    }

    static com.google.android.gms.common.internal.c.b zzn(com.google.android.gms.common.internal.c c) {
        return c.zzx;
    }

    static void zzo(com.google.android.gms.common.internal.c c, com.google.android.gms.common.internal.l1 l12) {
        com.google.android.gms.common.internal.t obj0;
        Object obj1;
        c.zzD = l12;
        if (c.usesClientTelemetry()) {
            obj0 = l12.v;
            if (obj0 == null) {
                obj0 = 0;
            } else {
                obj0 = obj0.o2();
            }
            s.b().c(obj0);
        }
    }

    private final void zzp(int i, T t2) {
        int context;
        String valueOf;
        int i2;
        int str3;
        int i4;
        int stringBuilder;
        com.google.android.gms.common.internal.w1 w1Var;
        Object zzn;
        String startServicePackage;
        String str2;
        String localStartServiceAction;
        Object p1Var;
        int i3;
        int zzu;
        int useDynamicLookup;
        String str;
        boolean z;
        int obj13;
        Object obj14;
        context = 4;
        i2 = 0;
        str3 = 1;
        i4 = i != context ? i2 : str3;
        stringBuilder = t2 == null ? i2 : str3;
        if (i4 == stringBuilder) {
            i2 = str3;
        }
        r.a(i2);
        Object zzp = this.zzp;
        this.zzv = i;
        this.zzs = t2;
        int i9 = 0;
        synchronized (zzp) {
            stringBuilder = 3;
            if (i != 2 && i != stringBuilder) {
                if (i != stringBuilder) {
                    if (i != context) {
                    } else {
                        r.j(t2);
                        onConnectedLocked(t2);
                    }
                } else {
                    com.google.android.gms.common.internal.i1 zzu2 = this.zzu;
                    obj13 = this.zza;
                    if (zzu2 != null && obj13 != null) {
                        obj13 = this.zza;
                        if (obj13 != null) {
                            obj13 = obj13.a();
                            context = this.zza.b();
                            StringBuilder stringBuilder2 = new StringBuilder(i5 += length5);
                            stringBuilder2.append("Calling connect() while still connected, missing disconnect() for ");
                            stringBuilder2.append(obj13);
                            stringBuilder2.append(" on ");
                            stringBuilder2.append(context);
                            Log.e("GmsClient", stringBuilder2.toString());
                            str2 = this.zza.a();
                            r.j(str2);
                            this.zzn.c(str2, this.zza.b(), this.zza.c(), zzu2, zza(), this.zza.d());
                            this.zzd.incrementAndGet();
                        }
                    }
                    obj13 = new i1(this, this.zzd.get());
                    this.zzu = obj13;
                    if (this.zzv == stringBuilder && getLocalStartServiceAction() != null) {
                        if (getLocalStartServiceAction() != null) {
                            super(getContext().getPackageName(), getLocalStartServiceAction(), 1, i.a(), 0);
                        } else {
                            super(getStartServicePackage(), getStartServiceAction(), 0, i.a(), getUseDynamicLookup());
                        }
                    } else {
                    }
                    this.zza = obj14;
                    if (obj14.d() && getMinApkVersion() < 17895000) {
                        try {
                            if (getMinApkVersion() < 17895000) {
                            }
                            obj14 = "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ";
                            valueOf = String.valueOf(this.zza.a());
                            if (valueOf.length() != 0) {
                            } else {
                            }
                            obj14 = obj14.concat(valueOf);
                            valueOf = new String(obj14);
                            obj14 = valueOf;
                            obj13 = new IllegalStateException(obj14);
                            throw obj13;
                            context = this.zza.a();
                            r.j(context);
                            p1Var = new p1(context, this.zza.b(), this.zza.c(), this.zza.d());
                            if (!this.zzn.d(p1Var, obj13, zza())) {
                            }
                            obj14 = this.zza.a();
                            context = this.zza.b();
                            stringBuilder = new StringBuilder(i7 += length4);
                            stringBuilder.append("unable to connect to service: ");
                            stringBuilder.append(obj14);
                            stringBuilder.append(" on ");
                            stringBuilder.append(context);
                            Log.e("GmsClient", stringBuilder.toString());
                            zzb(16, i9, this.zzd.get());
                            zzu = this.zzu;
                            if (zzu != null) {
                            }
                            zzn = this.zza.a();
                            r.j(zzn);
                            this.zzn.c(zzn, this.zza.b(), this.zza.c(), zzu, zza(), this.zza.d());
                            this.zzu = i9;
                            throw i;
                        }
                    }
                }
            } else {
            }
        }
    }

    public void checkAvailabilityAndConnect() {
        int i = this.zzo.h(this.zzl, getMinApkVersion());
        if (i != 0) {
            int i3 = 0;
            zzp(1, i3);
            c.d dVar2 = new c.d(this);
            triggerNotAvailable(dVar2, i, i3);
        }
        c.d dVar = new c.d(this);
        connect(dVar);
    }

    protected final void checkConnected() {
        if (!isConnected()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        throw illegalStateException;
    }

    public void connect(com.google.android.gms.common.internal.c.c c$c) {
        r.k(c, "Connection progress callbacks cannot be null.");
        this.zzc = c;
        zzp(2, 0);
    }

    protected abstract T createServiceInterface(IBinder iBinder);

    public void disconnect() {
        int i;
        Object obj;
        this.zzd.incrementAndGet();
        ArrayList zzt = this.zzt;
        i = 0;
        synchronized (zzt) {
            while (i < this.zzt.size()) {
                (g1)this.zzt.get(i).e();
                i++;
            }
            this.zzt.clear();
            Object zzq = this.zzq;
            int i2 = 0;
            this.zzr = i2;
            zzp(1, i2);
            return;
            synchronized (zzq) {
                this.zzt.clear();
                zzq = this.zzq;
                i2 = 0;
                this.zzr = i2;
                zzp(1, i2);
            }
        }
    }

    public void disconnect(String string) {
        this.zzk = string;
        disconnect();
    }

    public void dump(String string, FileDescriptor fileDescriptor2, PrintWriter printWriter3, String[] string4Arr4) {
        Object hexString;
        Object string2;
        long zzj;
        int stringBuilder;
        int format;
        int i2;
        int str;
        long zzh;
        long stringBuilder2;
        int i;
        StringBuilder stringBuilder3;
        Object obj11;
        String obj12;
        String obj13;
        String obj14;
        obj12 = this.zzp;
        obj14 = this.zzv;
        hexString = this.zzs;
        Object zzq = this.zzq;
        obj12 = this.zzr;
        printWriter3.append(string).append("mConnectState=");
        stringBuilder = 3;
        format = 2;
        i2 = 1;
        synchronized (obj12) {
            obj12 = this.zzp;
            obj14 = this.zzv;
            hexString = this.zzs;
            zzq = this.zzq;
            obj12 = this.zzr;
            printWriter3.append(string).append("mConnectState=");
            stringBuilder = 3;
            format = 2;
            i2 = 1;
        }
        if (obj14 != format) {
            if (obj14 != stringBuilder) {
                try {
                    if (obj14 != 4) {
                    } else {
                    }
                    if (obj14 != 5) {
                    } else {
                    }
                    printWriter3.print("UNKNOWN");
                    printWriter3.print("DISCONNECTING");
                    printWriter3.print("CONNECTED");
                } catch (Throwable th) {
                }
            } else {
                printWriter3.print("LOCAL_CONNECTING");
            }
        } else {
            printWriter3.print("REMOTE_CONNECTING");
        }
        try {
            printWriter3.append(" mService=");
            if (hexString == null) {
            } else {
            }
            printWriter3.append("null");
            printWriter3.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(hexString.asBinder())));
        }
        printWriter3.append(" mServiceBroker=");
        if (obj12 == null) {
            printWriter3.println("null");
        } else {
            printWriter3.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(obj12.asBinder())));
        }
        obj12 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        final int i3 = 0;
        if (Long.compare(zzh, i3) > 0) {
            long zzh2 = this.zzh;
            Date date = new Date(zzh2, obj5);
            String format2 = obj12.format(date);
            stringBuilder3 = new StringBuilder(length3 += 21);
            stringBuilder3.append(zzh2);
            stringBuilder3.append(" ");
            stringBuilder3.append(format2);
            printWriter3.append(string).append("lastConnectedTime=").println(stringBuilder3.toString());
        }
        if (Long.compare(stringBuilder2, i3) > 0) {
            printWriter3.append(string).append("lastSuspendedCause=");
            obj14 = this.zzf;
            if (obj14 != i2) {
                if (obj14 != format) {
                    if (obj14 != stringBuilder) {
                        printWriter3.append(String.valueOf(obj14));
                    } else {
                        printWriter3.append("CAUSE_DEAD_OBJECT_EXCEPTION");
                    }
                } else {
                    printWriter3.append("CAUSE_NETWORK_LOST");
                }
            } else {
                printWriter3.append("CAUSE_SERVICE_DISCONNECTED");
            }
            long zzg = this.zzg;
            Date date3 = new Date(zzg, stringBuilder);
            format = obj12.format(date3);
            stringBuilder2 = new StringBuilder(length2 += 21);
            stringBuilder2.append(zzg);
            stringBuilder2.append(" ");
            stringBuilder2.append(format);
            printWriter3.append(" lastSuspendedTime=").println(stringBuilder2.toString());
        }
        if (Long.compare(zzj, i3) > 0) {
            obj14 = b.a(this.zzi);
            printWriter3.append(string).append("lastFailedStatus=").append(obj14);
            obj13 = this.zzj;
            Date date2 = new Date(obj13, obj14);
            obj12 = obj12.format(date2);
            stringBuilder = new StringBuilder(length += 21);
            stringBuilder.append(obj13);
            stringBuilder.append(" ");
            stringBuilder.append(obj12);
            printWriter3.append(" lastFailedTime=").println(stringBuilder.toString());
        }
    }

    protected boolean enableLocalFallback() {
        return 0;
    }

    public Account getAccount() {
        return null;
    }

    public d[] getApiFeatures() {
        return c.zze;
    }

    public final d[] getAvailableFeatures() {
        com.google.android.gms.common.internal.l1 zzD = this.zzD;
        if (zzD == null) {
            return null;
        }
        return zzD.b;
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.zzl;
    }

    public String getEndpointPackageName() {
        boolean connected;
        if (!isConnected()) {
        } else {
            connected = this.zza;
            if (connected == null) {
            } else {
                return connected.b();
            }
        }
        RuntimeException runtimeException = new RuntimeException("Failed to connect when checking package");
        throw runtimeException;
    }

    public int getGCoreServiceId() {
        return this.zzy;
    }

    protected Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        return bundle;
    }

    public String getLastDisconnectMessage() {
        return this.zzk;
    }

    protected String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzm;
    }

    public int getMinApkVersion() {
        return f.a;
    }

    public void getRemoteService(com.google.android.gms.common.internal.k k, Set<Scope> set2) {
        Bundle getServiceRequestExtraArgs;
        Object h1Var;
        String packageName;
        IBinder obj5;
        Object[] obj6;
        g gVar = new g(this.zzy, this.zzA);
        gVar.v = this.zzl.getPackageName();
        gVar.y = getGetServiceRequestExtraArgs();
        if (set2 != null) {
            gVar.x = (Scope[])set2.toArray(new Scope[set2.size()]);
        }
        if (requiresSignIn()) {
            if (getAccount() == null) {
                obj6 = new Account("<<default account>>", "com.google");
            }
            gVar.z = obj6;
            if (k != null) {
                gVar.w = k.asBinder();
            }
        } else {
            if (requiresAccount()) {
                gVar.z = getAccount();
            }
        }
        gVar.A = c.zze;
        gVar.B = getApiFeatures();
        if (usesClientTelemetry()) {
            gVar.E = true;
        }
        obj5 = this.zzq;
        obj6 = this.zzr;
        synchronized (obj5) {
            h1Var = new h1(this, this.zzd.get());
            obj6.getService(h1Var, gVar);
        }
    }

    protected Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    public final T getService() {
        final Object zzp = this.zzp;
        synchronized (zzp) {
            checkConnected();
            IInterface zzs = this.zzs;
            r.k(zzs, "Client is connected but service is null");
            return zzs;
        }
    }

    public IBinder getServiceBrokerBinder() {
        Object zzq = this.zzq;
        com.google.android.gms.common.internal.m zzr = this.zzr;
        synchronized (zzq) {
            return null;
        }
    }

    protected abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not a sign in API");
        throw unsupportedOperationException;
    }

    protected abstract String getStartServiceAction();

    protected String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public com.google.android.gms.common.internal.e getTelemetryConfiguration() {
        com.google.android.gms.common.internal.l1 zzD = this.zzD;
        if (zzD == null) {
            return null;
        }
        return zzD.v;
    }

    protected boolean getUseDynamicLookup() {
        return 0;
    }

    public boolean hasConnectionInfo() {
        if (this.zzD != null) {
            return 1;
        }
        return 0;
    }

    public boolean isConnected() {
        int i;
        final Object zzp = this.zzp;
        synchronized (zzp) {
            i = 1;
            try {
                return i;
                throw th;
            }
        }
    }

    public boolean isConnecting() {
        int i;
        int i2;
        final Object zzp = this.zzp;
        final int zzv = this.zzv;
        i2 = 1;
        synchronized (zzp) {
            if (zzv == 3) {
            } else {
                try {
                    i2 = 0;
                    return i2;
                    throw th;
                }
            }
        }
    }

    protected void onConnectedLocked(T t) {
        this.zzh = System.currentTimeMillis();
    }

    protected void onConnectionFailed(b b) {
        this.zzi = b.j2();
        this.zzj = System.currentTimeMillis();
    }

    protected void onConnectionSuspended(int i) {
        this.zzf = i;
        this.zzg = System.currentTimeMillis();
    }

    protected void onPostInitHandler(int i, IBinder iBinder2, Bundle bundle3, int i4) {
        final Handler zzb = this.zzb;
        j1 j1Var = new j1(this, i, iBinder2, bundle3);
        zzb.sendMessage(zzb.obtainMessage(1, i4, -1, j1Var));
    }

    public void onUserSignOut(com.google.android.gms.common.internal.c.e c$e) {
        e.a();
    }

    public boolean providesSignIn() {
        return 0;
    }

    public boolean requiresAccount() {
        return 0;
    }

    public boolean requiresGooglePlayServices() {
        return 1;
    }

    public boolean requiresSignIn() {
        return 0;
    }

    public void setAttributionTag(String string) {
        this.zzA = string;
    }

    public void triggerConnectionSuspended(int i) {
        final Handler zzb = this.zzb;
        zzb.sendMessage(zzb.obtainMessage(6, this.zzd.get(), i));
    }

    protected void triggerNotAvailable(com.google.android.gms.common.internal.c.c c$c, int i2, PendingIntent pendingIntent3) {
        r.k(c, "Connection progress callbacks cannot be null.");
        this.zzc = c;
        final Handler obj3 = this.zzb;
        obj3.sendMessage(obj3.obtainMessage(3, this.zzd.get(), i2, pendingIntent3));
    }

    public boolean usesClientTelemetry() {
        return 0;
    }

    protected final String zza() {
        String name;
        if (this.zzz == null) {
            name = this.zzl.getClass().getName();
        }
        return name;
    }

    protected final void zzb(int i, Bundle bundle2, int i3) {
        final Handler obj4 = this.zzb;
        k1 k1Var = new k1(this, i, 0);
        obj4.sendMessage(obj4.obtainMessage(7, i3, -1, k1Var));
    }
}
