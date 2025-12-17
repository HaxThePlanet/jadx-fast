package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import com.android.installreferrer.commons.InstallReferrerCommons;
import f.c.a.c.a.a;
import f.c.a.c.a.a.a;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* loaded from: classes.dex */
class InstallReferrerClientImpl extends com.android.installreferrer.api.InstallReferrerClient {

    private int a = 0;
    private final Context b;
    private a c;
    private ServiceConnection d;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClientState {

        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED;
    }

    static class a {
    }

    private final class b implements ServiceConnection {

        private final com.android.installreferrer.api.InstallReferrerStateListener a;
        final com.android.installreferrer.api.InstallReferrerClientImpl b;
        private b(com.android.installreferrer.api.InstallReferrerClientImpl installReferrerClientImpl, com.android.installreferrer.api.InstallReferrerStateListener installReferrerStateListener2) {
            this.b = installReferrerClientImpl;
            super();
            if (installReferrerStateListener2 == null) {
            } else {
                this.a = installReferrerStateListener2;
            }
            RuntimeException obj1 = new RuntimeException("Please specify a listener to know when setup is done.");
            throw obj1;
        }

        b(com.android.installreferrer.api.InstallReferrerClientImpl installReferrerClientImpl, com.android.installreferrer.api.InstallReferrerStateListener installReferrerStateListener2, com.android.installreferrer.api.InstallReferrerClientImpl.a installReferrerClientImpl$a3) {
            super(installReferrerClientImpl, installReferrerStateListener2);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder2) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service connected.");
            InstallReferrerClientImpl.a(this.b, a.a.j(iBinder2));
            InstallReferrerClientImpl.b(this.b, 2);
            this.a.onInstallReferrerSetupFinished(0);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Install Referrer service disconnected.");
            InstallReferrerClientImpl.a(this.b, 0);
            InstallReferrerClientImpl.b(this.b, 0);
            this.a.onInstallReferrerServiceDisconnected();
        }
    }
    public InstallReferrerClientImpl(Context context) {
        super();
        final int i = 0;
        this.b = context.getApplicationContext();
    }

    static a a(com.android.installreferrer.api.InstallReferrerClientImpl installReferrerClientImpl, a a2) {
        installReferrerClientImpl.c = a2;
        return a2;
    }

    static int b(com.android.installreferrer.api.InstallReferrerClientImpl installReferrerClientImpl, int i2) {
        installReferrerClientImpl.a = i2;
        return i2;
    }

    private boolean c() {
        if (packageInfo.versionCode >= 80837300) {
            return 1;
        }
        return 0;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void endConnection() {
        Object service2;
        ServiceConnection service;
        this.a = 3;
        final int i2 = 0;
        if (this.d != null) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Unbinding from service.");
            this.b.unbindService(this.d);
            this.d = i2;
        }
        this.c = i2;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public com.android.installreferrer.api.ReferrerDetails getInstallReferrer() {
        if (!isReady()) {
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("package_name", this.b.getPackageName());
            ReferrerDetails referrerDetails = new ReferrerDetails(this.c.j0(bundle));
            return referrerDetails;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Service not connected. Please start a connection before using the service.");
        throw illegalStateException;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public boolean isReady() {
        int i;
        if (this.a == 2 && this.c != null && this.d != null) {
            if (this.c != null) {
                if (this.d != null) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void startConnection(com.android.installreferrer.api.InstallReferrerStateListener installReferrerStateListener) {
        Object intentServices;
        String name;
        boolean empty;
        final int i2 = 0;
        final String str9 = "InstallReferrerClient";
        if (isReady()) {
            InstallReferrerCommons.logVerbose(str9, "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.onInstallReferrerSetupFinished(i2);
        }
        int i = this.a;
        int i3 = 3;
        final int i4 = 1;
        if (i == i4) {
            InstallReferrerCommons.logWarn(str9, "Client is already in the process of connecting to the service.");
            installReferrerStateListener.onInstallReferrerSetupFinished(i3);
        }
        if (i == i3) {
            InstallReferrerCommons.logWarn(str9, "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.onInstallReferrerSetupFinished(i3);
        }
        InstallReferrerCommons.logVerbose(str9, "Starting install referrer service setup.");
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        String str11 = "com.android.vending";
        ComponentName componentName = new ComponentName(str11, "com.google.android.finsky.externalreferrer.GetInstallReferrerService");
        intent.setComponent(componentName);
        intentServices = this.b.getPackageManager().queryIntentServices(intent, i2);
        int i6 = 2;
        intentServices = obj.serviceInfo;
        Intent intent2 = new Intent(intent);
        InstallReferrerClientImpl.b bVar = new InstallReferrerClientImpl.b(this, installReferrerStateListener, 0);
        this.d = bVar;
        if (intentServices != null && !intentServices.isEmpty() && intentServices != null && str11.equals(intentServices.packageName) && intentServices.name != null && c() && this.b.bindService(intent2, bVar, i4)) {
            if (!intentServices.isEmpty()) {
                intentServices = obj.serviceInfo;
                if (intentServices != null) {
                    if (str11.equals(intentServices.packageName)) {
                        if (intentServices.name != null) {
                            if (c()) {
                                intent2 = new Intent(intent);
                                bVar = new InstallReferrerClientImpl.b(this, installReferrerStateListener, 0);
                                this.d = bVar;
                                if (this.b.bindService(intent2, bVar, i4)) {
                                    InstallReferrerCommons.logVerbose(str9, "Service was bonded successfully.");
                                }
                                InstallReferrerCommons.logWarn(str9, "Connection to service is blocked.");
                                this.a = i2;
                                installReferrerStateListener.onInstallReferrerSetupFinished(i4);
                            }
                        }
                    }
                    InstallReferrerCommons.logWarn(str9, "Play Store missing or incompatible. Version 8.3.73 or later required.");
                    this.a = i2;
                    installReferrerStateListener.onInstallReferrerSetupFinished(i6);
                }
            }
        }
        this.a = i2;
        InstallReferrerCommons.logVerbose(str9, "Install Referrer service unavailable on device.");
        installReferrerStateListener.onInstallReferrerSetupFinished(i6);
    }
}
