package com.facebook.internal;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.facebook.FacebookException;
import com.facebook.o;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0008\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u0015", d2 = {"Lcom/facebook/internal/AttributionIdentifiers;", "", "()V", "androidAdvertiserId", "", "getAndroidAdvertiserId", "()Ljava/lang/String;", "androidAdvertiserIdValue", "<set-?>", "androidInstallerPackage", "getAndroidInstallerPackage", "attributionId", "getAttributionId", "fetchTime", "", "", "isTrackingLimited", "()Z", "Companion", "GoogleAdInfo", "GoogleAdServiceConnection", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class a {

    private static final String f = "com.facebook.internal.a";
    public static com.facebook.internal.a g;
    public static final com.facebook.internal.a.a h;
    private String a;
    private long b;
    private String c;
    private String d;
    private boolean e;

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0000@\u0000X\u0081\u000e¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0010\u0010\u0002¨\u0006\u001d", d2 = {"Lcom/facebook/internal/AttributionIdentifiers$Companion;", "", "()V", "ANDROID_ID_COLUMN_NAME", "", "ATTRIBUTION_ID_COLUMN_NAME", "ATTRIBUTION_ID_CONTENT_PROVIDER", "ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI", "CONNECTION_RESULT_SUCCESS", "", "IDENTIFIER_REFRESH_INTERVAL_MILLIS", "", "LIMIT_TRACKING_COLUMN_NAME", "TAG", "cachedIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "getCachedIdentifiers$facebook_core_release$annotations", "cacheAndReturnIdentifiers", "identifiers", "getAndroidId", "context", "Landroid/content/Context;", "getAndroidIdViaReflection", "getAndroidIdViaService", "getAttributionIdentifiers", "getInstallerPackageName", "isGooglePlayServicesAvailable", "", "isTrackingLimited", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        private final com.facebook.internal.a a(com.facebook.internal.a a) {
            a.f(a, System.currentTimeMillis());
            a.g = a;
            return a;
        }

        private final com.facebook.internal.a b(Context context) {
            com.facebook.internal.a aVar;
            if (c(context) == null && d(context) == null) {
                if (d(context) == null) {
                    aVar = new a();
                }
            }
            return aVar;
        }

        private final com.facebook.internal.a c(Context context) {
            java.lang.reflect.Method method;
            Object str2;
            int str;
            Class[] arr;
            int booleanValue;
            Object obj8;
            final int i = 0;
            if (!g(context)) {
                try {
                    return i;
                    str = 1;
                    arr = new Class[str];
                    booleanValue = 0;
                    arr[booleanValue] = Context.class;
                    method = b0.F("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", arr);
                    str2 = new Object[str];
                    str2[booleanValue] = context;
                    obj8 = b0.N(i, method, str2);
                    method = b0.E(obj8.getClass(), "getId", new Class[booleanValue]);
                    str2 = b0.E(obj8.getClass(), "isLimitAdTrackingEnabled", new Class[booleanValue]);
                    if (method != null && obj8 != null && method != null) {
                    }
                    str2 = new Object[str];
                    str2[booleanValue] = context;
                    obj8 = b0.N(i, method, str2);
                    if (obj8 != null) {
                    }
                    method = b0.E(obj8.getClass(), "getId", new Class[booleanValue]);
                    str2 = b0.E(obj8.getClass(), "isLimitAdTrackingEnabled", new Class[booleanValue]);
                    if (method != null) {
                    }
                    if (str2 == null) {
                    } else {
                    }
                    a aVar = new a();
                    a.c(aVar, (String)b0.N(obj8, method, new Object[booleanValue]));
                    obj8 = b0.N(obj8, str2, new Object[booleanValue]);
                    if ((Boolean)obj8 != null) {
                    }
                    booleanValue = (Boolean)obj8.booleanValue();
                    a.g(aVar, booleanValue);
                    return aVar;
                    return i;
                    b0.c0("android_id", context);
                    return obj0;
                }
            }
        }

        private final com.facebook.internal.a d(Context context) {
            boolean bindService;
            int i;
            a.c cVar = new a.c();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, cVar, 1)) {
                a.b bVar = new a.b(cVar.a());
                a aVar = new a();
                a.c(aVar, bVar.j());
                a.g(aVar, bVar.m());
                context.unbindService(cVar);
                return aVar;
            }
            return null;
        }

        private final String f(Context context) {
            String obj2;
            final PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                obj2 = packageManager.getInstallerPackageName(context.getPackageName());
            } else {
                obj2 = 0;
            }
            return obj2;
        }

        private final boolean g(Context context) {
            int i;
            boolean valueOf;
            Object obj6;
            i = 1;
            Class[] arr = new Class[i];
            final int i3 = 0;
            arr[i3] = Context.class;
            java.lang.reflect.Method method = b0.F("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", arr);
            if (method != null) {
                Object[] arr2 = new Object[i];
                arr2[i3] = context;
                obj6 = b0.N(0, method, arr2);
                if (obj6 instanceof Integer && obj6 ^= i == 0) {
                    if (obj6 ^= i == 0) {
                    } else {
                        i = i3;
                    }
                } else {
                }
                return i;
            }
            return i3;
        }

        public final com.facebook.internal.a e(Context context) {
            int columnIndex;
            String str;
            int columnIndex2;
            StringBuilder stringBuilder;
            String string;
            String str3;
            Object obj;
            Object resolveContentProvider2;
            ContentResolver contentResolver;
            Looper mainLooper;
            Uri uri;
            android.content.pm.ProviderInfo resolveContentProvider;
            int i;
            String str2;
            Throwable th;
            String str4 = "limit_tracking";
            String str6 = "androidid";
            String str7 = "aid";
            n.f(context, "context");
            com.facebook.internal.a aVar = b(context);
            if (n.b(Looper.myLooper(), Looper.getMainLooper())) {
            } else {
                com.facebook.internal.a aVar2 = a.g;
                if (aVar2 != null && Long.compare(i3, i) < 0) {
                    if (Long.compare(i3, i) < 0) {
                        return aVar2;
                    }
                }
                str2 = 0;
                resolveContentProvider2 = context.getPackageManager().resolveContentProvider("com.facebook.katana.provider.AttributionIdProvider", str2);
                resolveContentProvider = context.getPackageManager().resolveContentProvider("com.facebook.wakizashi.provider.AttributionIdProvider", str2);
                String packageName = resolveContentProvider2.packageName;
                n.e(packageName, "contentProviderInfo.packageName");
                if (resolveContentProvider2 != null && j.a(context, packageName)) {
                    packageName = resolveContentProvider2.packageName;
                    n.e(packageName, "contentProviderInfo.packageName");
                    if (j.a(context, packageName)) {
                        resolveContentProvider2 = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
                        uri = resolveContentProvider2;
                    } else {
                    }
                } else {
                }
                String str9 = f(context);
                if (str9 != null) {
                    a.d(aVar, str9);
                }
                if (uri == null) {
                    a(aVar);
                    return aVar;
                }
                try {
                    Cursor obj13 = context.getContentResolver().query(uri, /* result */, 0, 0, 0);
                    if (obj13 != null) {
                    }
                    if (!obj13.moveToFirst()) {
                    } else {
                    }
                    columnIndex2 = obj13.getColumnIndex(str6);
                    columnIndex = obj13.getColumnIndex(str4);
                    a.e(aVar, obj13.getString(obj13.getColumnIndex(str7)));
                    if (columnIndex2 > 0 && columnIndex > 0 && aVar.h() == null) {
                    }
                    if (columnIndex > 0) {
                    }
                    if (aVar.h() == null) {
                    }
                    a.c(aVar, obj13.getString(columnIndex2));
                    a.g(aVar, Boolean.parseBoolean(obj13.getString(columnIndex)));
                    obj13.close();
                    a(aVar);
                    return aVar;
                    obj = context;
                    context = th2;
                    Throwable th2 = context;
                    context = th;
                    a(aVar);
                    if (obj13 != null) {
                    }
                    obj13.close();
                    return aVar;
                    obj13 = new FacebookException("getAttributionIdentifiers cannot be called on the main thread.");
                    throw obj13;
                    th2 = obj;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Caught unexpected exception in getAttributionId(): ");
                    stringBuilder.append(context);
                    context = stringBuilder.toString();
                    b0.d0(a.b(), context);
                    if (th2 != null) {
                    }
                    th2.close();
                    return obj;
                    obj = th2;
                    if (obj == null) {
                    } else {
                    }
                    obj.close();
                    throw context;
                } catch (Exception e) {
                } catch (Throwable th1) {
                }
            }
        }

        public final boolean h(Context context) {
            com.facebook.internal.a obj2;
            n.f(context, "context");
            obj2 = e(context);
            if (obj2 != null && obj2.l()) {
                obj2 = obj2.l() ? 1 : 0;
            } else {
            }
            return obj2;
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000c\u001a\u00020\u0003H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u000b¨\u0006\u000e", d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdInfo;", "Landroid/os/IInterface;", "binder", "Landroid/os/IBinder;", "(Landroid/os/IBinder;)V", "advertiserId", "", "getAdvertiserId", "()Ljava/lang/String;", "isTrackingLimited", "", "()Z", "asBinder", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class b implements IInterface {

        private final IBinder a;
        static {
        }

        public b(IBinder iBinder) {
            n.f(iBinder, "binder");
            super();
            this.a = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.a;
        }

        @Override // android.os.IInterface
        public final String j() {
            final Parcel obtain = Parcel.obtain();
            String str = "Parcel.obtain()";
            n.e(obtain, str);
            final Parcel obtain2 = Parcel.obtain();
            n.e(obtain2, str);
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.a.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            obtain2.recycle();
            obtain.recycle();
            return obtain2.readString();
        }

        @Override // android.os.IInterface
        public final boolean m() {
            int i;
            final Parcel obtain = Parcel.obtain();
            String str = "Parcel.obtain()";
            n.e(obtain, str);
            final Parcel obtain2 = Parcel.obtain();
            n.e(obtain2, str);
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            obtain.writeInt(1);
            final int i3 = 0;
            this.a.transact(2, obtain, obtain2, i3);
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

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0010\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00040\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "binder", "Landroid/os/IBinder;", "getBinder", "()Landroid/os/IBinder;", "consumed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "queue", "Ljava/util/concurrent/BlockingQueue;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "onServiceDisconnected", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class c implements ServiceConnection {

        private final AtomicBoolean a;
        private final BlockingQueue<IBinder> b;
        public c() {
            super();
            AtomicBoolean atomicBoolean = new AtomicBoolean(0);
            this.a = atomicBoolean;
            LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
            this.b = linkedBlockingDeque;
        }

        @Override // android.content.ServiceConnection
        public final IBinder a() {
            int i2 = 1;
            if (compareAndSet ^= i2 == 0) {
            } else {
                Object take = this.b.take();
                n.e(take, "queue.take()");
                return (IBinder)take;
            }
            IllegalStateException illegalStateException = new IllegalStateException("Binder already consumed".toString());
            throw illegalStateException;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
            BlockingQueue obj1;
            if (iBinder2 != null) {
                this.b.put(iBinder2);
            }
            try {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
    static {
        a.a aVar = new a.a(0);
        a.h = aVar;
    }

    public static final long a(com.facebook.internal.a a) {
        return a.b;
    }

    public static final String b() {
        return a.f;
    }

    public static final void c(com.facebook.internal.a a, String string2) {
        a.a = string2;
    }

    public static final void d(com.facebook.internal.a a, String string2) {
        a.d = string2;
    }

    public static final void e(com.facebook.internal.a a, String string2) {
        a.c = string2;
    }

    public static final void f(com.facebook.internal.a a, long l2) {
        a.b = l2;
    }

    public static final void g(com.facebook.internal.a a, boolean z2) {
        a.e = z2;
    }

    public static final com.facebook.internal.a k(Context context) {
        return a.h.e(context);
    }

    public final String h() {
        boolean z;
        int i;
        if (o.y() && o.e()) {
            i = o.e() ? this.a : 0;
        } else {
        }
        return i;
    }

    public final String i() {
        return this.d;
    }

    public final String j() {
        return this.c;
    }

    public final boolean l() {
        return this.e;
    }
}
