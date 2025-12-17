package com.revenuecat.purchases.util;

import android.app.Application;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0003\u000c\r\u000eB\t\u0008\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ+\u0010\u0008\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\u0008\u0008\u0010\t¨\u0006\u000f", d2 = {"Lcom/revenuecat/purchases/util/AdvertisingIdClient;", "", "Landroid/app/Application;", "application", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/util/AdvertisingIdClient$AdInfo;", "Lkotlin/w;", "completion", "getAdvertisingIdInfo", "(Landroid/app/Application;Lkotlin/d0/c/l;)V", "<init>", "()V", "AdInfo", "AdvertisingConnection", "AdvertisingInterface", "purchases_release"}, k = 1, mv = {1, 4, 0})
public final class AdvertisingIdClient {

    public static final com.revenuecat.purchases.util.AdvertisingIdClient INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u000b\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0019\u0008\u0000\u0012\u0006\u0010\u0008\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00022\u0008\u0008\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\u0008\n\u0010\u000bJ\u0010\u0010\u000c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00052\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010\u0013\u001a\u0004\u0008\t\u0010\u0007R\u0019\u0010\u0008\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0008\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0004¨\u0006\u0018", d2 = {"Lcom/revenuecat/purchases/util/AdvertisingIdClient$AdInfo;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "id", "isLimitAdTrackingEnabled", "copy", "(Ljava/lang/String;Z)Lcom/revenuecat/purchases/util/AdvertisingIdClient$AdInfo;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "getId", "<init>", "(Ljava/lang/String;Z)V", "purchases_release"}, k = 1, mv = {1, 4, 0})
    public static final class AdInfo {

        private final String id;
        private final boolean isLimitAdTrackingEnabled;
        public AdInfo(String string, boolean z2) {
            n.f(string, "id");
            super();
            this.id = string;
            this.isLimitAdTrackingEnabled = z2;
        }

        public static com.revenuecat.purchases.util.AdvertisingIdClient.AdInfo copy$default(com.revenuecat.purchases.util.AdvertisingIdClient.AdInfo advertisingIdClient$AdInfo, String string2, boolean z3, int i4, Object object5) {
            String obj1;
            boolean obj2;
            if (i4 & 1 != 0) {
                obj1 = adInfo.id;
            }
            if (i4 &= 2 != 0) {
                obj2 = adInfo.isLimitAdTrackingEnabled;
            }
            return adInfo.copy(obj1, obj2);
        }

        public final String component1() {
            return this.id;
        }

        public final boolean component2() {
            return this.isLimitAdTrackingEnabled;
        }

        public final com.revenuecat.purchases.util.AdvertisingIdClient.AdInfo copy(String string, boolean z2) {
            n.f(string, "id");
            AdvertisingIdClient.AdInfo adInfo = new AdvertisingIdClient.AdInfo(string, z2);
            return adInfo;
        }

        public boolean equals(Object object) {
            boolean isLimitAdTrackingEnabled;
            String str;
            Object obj3;
            if (this != (AdvertisingIdClient.AdInfo)object && object instanceof AdvertisingIdClient.AdInfo && n.b(this.id, object.id) && this.isLimitAdTrackingEnabled == object.isLimitAdTrackingEnabled) {
                if (object instanceof AdvertisingIdClient.AdInfo) {
                    if (n.b(this.id, object.id)) {
                        if (this.isLimitAdTrackingEnabled == object.isLimitAdTrackingEnabled) {
                        }
                    }
                }
                return 0;
            }
            return 1;
        }

        public final String getId() {
            return this.id;
        }

        public int hashCode() {
            int i;
            boolean isLimitAdTrackingEnabled;
            String str = this.id;
            if (str != null) {
                i = str.hashCode();
            } else {
                i = 0;
            }
            if (this.isLimitAdTrackingEnabled) {
                isLimitAdTrackingEnabled = 1;
            }
            return i2 += isLimitAdTrackingEnabled;
        }

        public final boolean isLimitAdTrackingEnabled() {
            return this.isLimitAdTrackingEnabled;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AdInfo(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", isLimitAdTrackingEnabled=");
            stringBuilder.append(this.isLimitAdTrackingEnabled);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\t\u0010\nR\u0016\u0010\r\u001a\u00020\u00048@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u001c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017¨\u0006\u001a", d2 = {"Lcom/revenuecat/purchases/util/AdvertisingIdClient$AdvertisingConnection;", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "Lkotlin/w;", "onServiceConnected", "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", "onServiceDisconnected", "(Landroid/content/ComponentName;)V", "getBinder$purchases_release", "()Landroid/os/IBinder;", "binder", "Ljava/util/concurrent/LinkedBlockingQueue;", "queue", "Ljava/util/concurrent/LinkedBlockingQueue;", "", "retrieved", "Z", "getRetrieved$purchases_release", "()Z", "setRetrieved$purchases_release", "(Z)V", "<init>", "()V", "purchases_release"}, k = 1, mv = {1, 4, 0})
    private static final class AdvertisingConnection implements ServiceConnection {

        private final LinkedBlockingQueue<IBinder> queue;
        private boolean retrieved;
        public AdvertisingConnection() {
            super();
            LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(1);
            this.queue = linkedBlockingQueue;
        }

        @Override // android.content.ServiceConnection
        public final IBinder getBinder$purchases_release() {
            if (this.retrieved) {
            } else {
                this.retrieved = true;
                Object take = this.queue.take();
                Objects.requireNonNull(take, "null cannot be cast to non-null type android.os.IBinder");
                return (IBinder)take;
            }
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }

        @Override // android.content.ServiceConnection
        public final boolean getRetrieved$purchases_release() {
            return this.retrieved;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
            n.f(componentName, "name");
            n.f(iBinder2, "service");
            this.queue.put(iBinder2);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            n.f(componentName, "name");
        }

        @Override // android.content.ServiceConnection
        public final void setRetrieved$purchases_release(boolean z) {
            this.retrieved = z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0008\u001a\u00020\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0008\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0008\u0010\tR\u0015\u0010\r\u001a\u0004\u0018\u00010\n8F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0010", d2 = {"Lcom/revenuecat/purchases/util/AdvertisingIdClient$AdvertisingInterface;", "Landroid/os/IInterface;", "Landroid/os/IBinder;", "asBinder", "()Landroid/os/IBinder;", "", "isLimitAdTrackingEnabled", "()Z", "binder", "Landroid/os/IBinder;", "", "getId", "()Ljava/lang/String;", "id", "<init>", "(Landroid/os/IBinder;)V", "purchases_release"}, k = 1, mv = {1, 4, 0})
    private static final class AdvertisingInterface implements IInterface {

        private final IBinder binder;
        public AdvertisingInterface(IBinder iBinder) {
            n.f(iBinder, "binder");
            super();
            this.binder = iBinder;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this.binder;
        }

        @Override // android.os.IInterface
        public final String getId() {
            final Parcel obtain = Parcel.obtain();
            final Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            this.binder.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            obtain2.recycle();
            obtain.recycle();
            return obtain2.readString();
        }

        @Override // android.os.IInterface
        public final boolean isLimitAdTrackingEnabled() {
            int i;
            final Parcel obtain = Parcel.obtain();
            final Parcel obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            obtain.writeInt(1);
            final int i3 = 0;
            this.binder.transact(2, obtain, obtain2, i3);
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
    static {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient();
        AdvertisingIdClient.INSTANCE = advertisingIdClient;
    }

    public final void getAdvertisingIdInfo(Application application, l<? super com.revenuecat.purchases.util.AdvertisingIdClient.AdInfo, w> l2) {
        n.f(application, "application");
        n.f(l2, "completion");
        AdvertisingIdClient.getAdvertisingIdInfo.1 anon = new AdvertisingIdClient.getAdvertisingIdInfo.1(application, l2);
        Thread thread = new Thread(anon);
        thread.start();
    }
}
