package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback.Stub;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService.Stub;

/* loaded from: classes5.dex */
class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {

    private final Context mContext;
    private boolean mHasBoundService = false;
    ResolvableFuture<Integer> mResultFuture;
    IUnusedAppRestrictionsBackportService mUnusedAppRestrictionsService = null;
    UnusedAppRestrictionsBackportServiceConnection(Context context) {
        super();
        int i = 0;
        int i2 = 0;
        this.mContext = context;
    }

    private IUnusedAppRestrictionsBackportCallback getBackportCallback() {
        UnusedAppRestrictionsBackportServiceConnection.1 anon = new UnusedAppRestrictionsBackportServiceConnection.1(this);
        return anon;
    }

    public void connectAndFetchResult(ResolvableFuture<Integer> resolvableFuture) {
        if (this.mHasBoundService != null) {
        } else {
            int i = 1;
            this.mHasBoundService = i;
            this.mResultFuture = resolvableFuture;
            Intent intent = new Intent("android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService");
            this.mContext.bindService(intent.setPackage(PackageManagerCompat.getPermissionRevocationVerifierApp(this.mContext.getPackageManager())), this, i);
        }
        IllegalStateException illegalStateException = new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
        throw illegalStateException;
    }

    @Override // android.content.ServiceConnection
    public void disconnectFromService() {
        if (this.mHasBoundService == null) {
        } else {
            this.mHasBoundService = false;
            this.mContext.unbindService(this);
        }
        IllegalStateException illegalStateException = new IllegalStateException("bindService must be called before unbind");
        throw illegalStateException;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        IUnusedAppRestrictionsBackportService mUnusedAppRestrictionsService;
        IUnusedAppRestrictionsBackportCallback backportCallback;
        int valueOf;
        this.mUnusedAppRestrictionsService = IUnusedAppRestrictionsBackportService.Stub.asInterface(service);
        this.mUnusedAppRestrictionsService.isPermissionRevocationEnabledForApp(getBackportCallback());
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        this.mUnusedAppRestrictionsService = 0;
    }
}
