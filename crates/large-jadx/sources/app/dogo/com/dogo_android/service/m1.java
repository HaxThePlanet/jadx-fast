package app.dogo.com.dogo_android.service;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes.dex */
public final class m1 implements c {

    public final app.dogo.com.dogo_android.service.PhotoUploadNotificationService a;
    public final String b;
    public m1(app.dogo.com.dogo_android.service.PhotoUploadNotificationService photoUploadNotificationService, String string2) {
        super();
        this.a = photoUploadNotificationService;
        this.b = string2;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return PhotoUploadNotificationService.l(this.a, this.b, j);
    }
}
