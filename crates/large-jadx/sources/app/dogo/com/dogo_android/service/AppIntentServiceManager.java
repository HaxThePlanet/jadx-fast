package app.dogo.com.dogo_android.service;

import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: AppIntentServiceManager.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/service/AppIntentServiceManager;", "", "context", "Landroid/content/Context;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "(Landroid/content/Context;Lapp/dogo/com/dogo_android/service/StorageService;)V", "startEntryUploadService", "", "entryId", "", "remotePath", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g2, reason: from kotlin metadata */
public final class AppIntentServiceManager {

    /* renamed from: a, reason: from kotlin metadata */
    private final Context context;
    /* renamed from: b, reason: from kotlin metadata */
    private final t2 storageService;
    public g2(Context context, t2 t2Var) {
        n.f(context, "context");
        n.f(t2Var, "storageService");
        super();
        this.context = context;
        this.storageService = t2Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final boolean startEntryUploadService(String entryId, String remotePath) {
        n.f(entryId, "entryId");
        android.net.Uri uri = this.storageService.h("challenge_pending", n.o(entryId, ".jpg"));
        if (uri == null) {
            return false;
        }
        Intent intent = new Intent(this.context, PhotoUploadNotificationService.class);
        intent.putExtra("extra_file_uri", uri);
        intent.putExtra("extra_remote_path", remotePath);
        intent.putExtra("extra_request_id", entryId);
        intent.putExtra("extra_request_type", PhotoUploadNotificationService_RequestTypes.CHALLENGE);
        intent.setAction("action_upload");
        this.context.startService(intent);
        return true;
    }
}
