package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.installreferrer.commons.InstallReferrerCommons;
import f.c.a.c.a.a;
import f.c.a.c.a.a.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* compiled from: InstallReferrerClientImpl.java */
/* loaded from: classes.dex */
class InstallReferrerClientImpl extends InstallReferrerClient {

    private int a = 0;
    private final Context b;
    private a c;
    private ServiceConnection d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClientState {

        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED = 0;
    }

    static class a {
    }

    private final class b implements ServiceConnection {

        private final InstallReferrerStateListener a;
        final /* synthetic */ InstallReferrerClientImpl b;
        private b(InstallReferrerStateListener list) {
            this.b = installReferrerClientImpl;
            super();
            if (list == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            } else {
                this.a = list;
                return;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service connected.");
            this.b.c = a.a.j(iBinder);
            this.b.a = 2;
            this.a.onInstallReferrerSetupFinished(0);
        }

        public void onServiceDisconnected(ComponentName componentName) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Install Referrer service disconnected.");
            this.b.c = 0;
            this.b.a = 0;
            this.a.onInstallReferrerServiceDisconnected();
        }

        /* synthetic */ b(InstallReferrerStateListener list, InstallReferrerClientImpl.a aVar) {
            this(installReferrerClientImpl, list);
        }
    }
    public InstallReferrerClientImpl(Context context) {
        super();
        this.b = context.getApplicationContext();
    }

    private boolean c() {
        try {
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            return false;
        }
        if (this.b.getPackageManager().getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
            return true;
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void endConnection() {
        this.a = 3;
        final ServiceConnection serviceConnection3 = null;
        if (this.d != null) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Unbinding from service.");
            this.b.unbindService(this.d);
            this.d = serviceConnection3;
        }
        this.c = serviceConnection3;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public ReferrerDetails getInstallReferrer() throws Bundle {
        if (!isReady()) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.b.getPackageName());
            try {
            } catch (android.os.RemoteException remote) {
                String str = "InstallReferrerClient";
                InstallReferrerCommons.logWarn(str, "RemoteException getting install referrer information");
                str = null;
                this.a = str;
                throw remote;
            }
            return new ReferrerDetails(this.c.j0(bundle));
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void startConnection(InstallReferrerStateListener list) {
        final int i3 = 0;
        final String str10 = "InstallReferrerClient";
        if (isReady()) {
            InstallReferrerCommons.logVerbose(str10, "Service connection is valid. No need to re-initialize.");
            list.onInstallReferrerSetupFinished(i3);
            return;
        }
        int i4 = 3;
        final int i5 = 1;
        if (this.a == i5) {
            InstallReferrerCommons.logWarn(str10, "Client is already in the process of connecting to the service.");
            list.onInstallReferrerSetupFinished(i4);
            return;
        }
        if (this.a == i4) {
            InstallReferrerCommons.logWarn(str10, "Client was already closed and can't be reused. Please create another instance.");
            list.onInstallReferrerSetupFinished(i4);
            return;
        }
        InstallReferrerCommons.logVerbose(str10, "Starting install referrer service setup.");
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        String str12 = "com.android.vending";
        intent.setComponent(new ComponentName(str12, "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        List intentServices = this.b.getPackageManager().queryIntentServices(intent, i3);
        int i7 = 2;
        if (intentServices != null && !intentServices.isEmpty()) {
            if (serviceInfo2 != null) {
                if ("com.android.vending".equals(serviceInfo2.packageName) && serviceInfo2.name != null && this.c()) {
                    com.android.installreferrer.api.InstallReferrerClientImpl.b bVar = new InstallReferrerClientImpl.b(this, list, null);
                    this.d = bVar;
                    try {
                    } catch (java.lang.SecurityException unused) {
                        String str = "No permission to connect to service.";
                        InstallReferrerCommons.logWarn(str9, str);
                        this.a = i2;
                        str = 4;
                        list.onInstallReferrerSetupFinished(str);
                        return;
                    }
                    if (this.b.bindService(new Intent(intent), bVar, i5)) {
                        InstallReferrerCommons.logVerbose(str10, "Service was bonded successfully.");
                        return;
                    }
                    InstallReferrerCommons.logWarn(str10, "Connection to service is blocked.");
                    this.a = i3;
                    list.onInstallReferrerSetupFinished(i5);
                    return;
                }
                InstallReferrerCommons.logWarn(str10, "Play Store missing or incompatible. Version 8.3.73 or later required.");
                this.a = i3;
                list.onInstallReferrerSetupFinished(i7);
                return;
            }
        }
        this.a = i3;
        InstallReferrerCommons.logVerbose(str10, "Install Referrer service unavailable on device.");
        list.onInstallReferrerSetupFinished(i7);
    }

    static /* synthetic */ a a(InstallReferrerClientImpl installReferrerClientImpl, a aVar) {
        installReferrerClientImpl.c = aVar;
        return aVar;
    }

    static /* synthetic */ int b(InstallReferrerClientImpl installReferrerClientImpl, int i) {
        installReferrerClientImpl.a = i;
        return i;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public boolean isReady() {
        if (this.a == 2 && this.c != null && this.d != null) {
            return true;
        }
        return false;
    }
}
