package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.a;
import com.google.android.gms.common.f;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.n.a;
import f.c.a.d.b.a.d;
import f.c.a.d.b.a.e;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class AdvertisingIdClient {

    private final Context mContext;
    private a zze;
    private d zzf;
    private boolean zzg;
    private final Object zzh;
    private com.google.android.gms.ads.identifier.AdvertisingIdClient.zza zzi;
    private final boolean zzj;
    private final long zzk;

    public static final class Info {

        private final String zzq;
        private final boolean zzr;
        public Info(String string, boolean z2) {
            super();
            this.zzq = string;
            this.zzr = z2;
        }

        public final String getId() {
            return this.zzq;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.zzr;
        }

        public final String toString() {
            String zzq = this.zzq;
            StringBuilder stringBuilder = new StringBuilder(length += 7);
            stringBuilder.append("{");
            stringBuilder.append(zzq);
            stringBuilder.append("}");
            stringBuilder.append(this.zzr);
            return stringBuilder.toString();
        }
    }

    static class zza extends Thread {

        private WeakReference<com.google.android.gms.ads.identifier.AdvertisingIdClient> zzm;
        private long zzn;
        CountDownLatch zzo;
        boolean zzp = false;
        public zza(com.google.android.gms.ads.identifier.AdvertisingIdClient advertisingIdClient, long l2) {
            super();
            WeakReference weakReference = new WeakReference(advertisingIdClient);
            this.zzm = weakReference;
            this.zzn = l2;
            CountDownLatch obj2 = new CountDownLatch(1);
            this.zzo = obj2;
            obj2 = 0;
            start();
        }

        private final void disconnect() {
            Object obj;
            obj = this.zzm.get();
            if ((AdvertisingIdClient)obj != null) {
                (AdvertisingIdClient)obj.finish();
                this.zzp = true;
            }
        }

        @Override // java.lang.Thread
        public final void run() {
            try {
                if (!this.zzo.await(this.zzn, obj2)) {
                }
                disconnect();
                disconnect();
            }
        }
    }
    public AdvertisingIdClient(Context context) {
        super(context, 30000, obj3, 0, 0);
    }

    private AdvertisingIdClient(Context context, long l2, boolean z3, boolean z4) {
        Object obj2;
        Context obj5;
        super();
        Object object = new Object();
        this.zzh = object;
        r.j(context);
        if (z4 != null) {
            obj5 = context.getApplicationContext();
            if (obj5 == null) {
            } else {
                obj2 = obj5;
            }
        }
        this.mContext = obj2;
        this.zzg = false;
        this.zzk = l2;
        this.zzj = obj6;
    }

    public static com.google.android.gms.ads.identifier.AdvertisingIdClient.Info getAdvertisingIdInfo(Context context) {
        zzb zzb = new zzb(context);
        final int i = 0;
        boolean boolean = zzb.getBoolean("gads:ad_id_app_context:enabled", i);
        final boolean boolean2 = zzb.getBoolean("gads:ad_id_use_persistent_service:enabled", i);
        super(context, -1, z3, boolean, boolean2);
        advertisingIdClient.zza(i);
        final com.google.android.gms.ads.identifier.AdvertisingIdClient.Info obj13 = advertisingIdClient.getInfo();
        advertisingIdClient.zza(obj13, boolean, zzb.getFloat("gads:ad_id_app_context:ping_ratio", 0), elapsedRealtime2 - elapsedRealtime, boolean2, zzb.getString("gads:ad_id_use_shared_preference:experiment_id", ""));
        advertisingIdClient.finish();
        return obj13;
    }

    public static boolean getIsAdIdFakeForDebugLogging(Context context) {
        zzb zzb = new zzb(context);
        final int i = 0;
        super(context, -1, obj6, zzb.getBoolean("gads:ad_id_app_context:enabled", i), zzb.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", i));
        advertisingIdClient.zza(i);
        advertisingIdClient.finish();
        return advertisingIdClient.zzb();
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    private static a zza(Context context, boolean z2) {
        int i;
        String obj4;
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int i2 = f.f().h(context, 12451000);
            if (i2 != 0) {
            }
            if (i2 != 2) {
            } else {
            }
            IOException obj3 = new IOException("Google Play services not available");
            throw obj3;
            if (z2 != null) {
            } else {
            }
            obj4 = "com.google.android.gms.ads.identifier.service.PERSISTENT_START";
            obj4 = "com.google.android.gms.ads.identifier.service.START";
            a aVar = new a();
            Intent intent = new Intent(obj4);
            intent.setPackage("com.google.android.gms");
            if (!a.b().a(context, intent, aVar, 1)) {
            } else {
            }
            return aVar;
            obj3 = new IOException("Connection failure");
            throw obj3;
        } catch (Throwable th) {
        }
    }

    private static d zza(Context context, a a2) {
        return e.j(a2.a(10000, obj1));
    }

    private final void zza() {
        com.google.android.gms.ads.identifier.AdvertisingIdClient.zza zzi;
        int cmp;
        long zzk;
        final Object zzh = this.zzh;
        zzi = this.zzi;
        synchronized (zzh) {
            zzi.zzo.countDown();
            this.zzi.join();
            final int i = 0;
            if (Long.compare(zzk2, i) > 0) {
                try {
                    cmp = new AdvertisingIdClient.zza(this, this.zzk, i);
                    this.zzi = cmp;
                    throw th;
                } catch (java.lang.InterruptedException interrupted) {
                } catch (Throwable th1) {
                }
            }
        }
    }

    private final void zza(boolean z) {
        r.i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            finish();
            a aVar = AdvertisingIdClient.zza(this.mContext, this.zzj);
            this.zze = aVar;
            this.zzf = AdvertisingIdClient.zza(this.mContext, aVar);
            this.zzg = true;
            if (z != null) {
                zza();
            }
        }
    }

    private final boolean zza(com.google.android.gms.ads.identifier.AdvertisingIdClient.Info advertisingIdClient$Info, boolean z2, float f3, long l4, String string5, Throwable throwable6) {
        String str;
        String obj5;
        String obj6;
        if (Double.compare(random, d) > 0) {
            return 0;
        }
        HashMap obj7 = new HashMap();
        final String str2 = "0";
        obj6 = z2 ? str : str2;
        obj7.put("app_context", obj6);
        if (info != null) {
            if (info.isLimitAdTrackingEnabled()) {
            } else {
                str = str2;
            }
            obj7.put("limit_ad_tracking", str);
        }
        if (info != null && info.getId() != null) {
            if (info.getId() != null) {
                obj7.put("ad_id_size", Integer.toString(info.getId().length()));
            }
        }
        if (obj11 != null) {
            obj7.put("error", obj11.getClass().getName());
        }
        if (throwable6 != null && !throwable6.isEmpty()) {
            if (!throwable6.isEmpty()) {
                obj7.put("experiment_id", throwable6);
            }
        }
        obj7.put("tag", "AdvertisingIdClient");
        obj7.put("time_spent", Long.toString(l4));
        obj5 = new zza(this, obj7);
        obj5.start();
        return 1;
    }

    private final boolean zzb() {
        boolean zzg;
        IOException str;
        r.i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            Object zzh = this.zzh;
            str = this.zzi;
            synchronized (zzh) {
                if (!str.zzp) {
                } else {
                    zza(false);
                    if (!this.zzg) {
                    } else {
                    }
                    IOException iOException = new IOException("AdvertisingIdClient cannot reconnect.");
                    throw iOException;
                }
                IOException iOException2 = new IOException("AdvertisingIdClient is not connected.");
                throw iOException2;
            }
        }
    }

    protected void finalize() {
        finish();
        super.finalize();
    }

    public final void finish() {
        Object mContext;
        boolean zzg;
        Object mContext2;
        Object str;
        r.i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zze == null) {
            } else {
                if (this.zzg) {
                    a.b().c(this.mContext, this.zze);
                }
            }
            try {
                this.zzg = false;
                int i2 = 0;
                this.zzf = i2;
                this.zze = i2;
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    public com.google.android.gms.ads.identifier.AdvertisingIdClient.Info getInfo() {
        boolean zzg;
        IOException str;
        r.i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            Object zzh = this.zzh;
            str = this.zzi;
            synchronized (zzh) {
                if (!str.zzp) {
                } else {
                    zza(false);
                    if (!this.zzg) {
                    } else {
                    }
                    IOException iOException = new IOException("AdvertisingIdClient cannot reconnect.");
                    throw iOException;
                }
                IOException iOException2 = new IOException("AdvertisingIdClient is not connected.");
                throw iOException2;
            }
        }
    }

    public void start() {
        zza(true);
    }
}
