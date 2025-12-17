package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService.Stub;

/* loaded from: classes5.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    public static final String ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION = "android.support.unusedapprestrictions.action.CustomUnusedAppRestrictionsBackportService";
    private IUnusedAppRestrictionsBackportService.Stub mBinder;
    public UnusedAppRestrictionsBackportService() {
        super();
        UnusedAppRestrictionsBackportService.1 anon = new UnusedAppRestrictionsBackportService.1(this);
        this.mBinder = anon;
    }

    @Override // android.app.Service
    protected abstract void isPermissionRevocationEnabled(androidx.core.content.UnusedAppRestrictionsBackportCallback unusedAppRestrictionsBackportCallback);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
