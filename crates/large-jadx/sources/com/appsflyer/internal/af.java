package com.appsflyer.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes.dex */
final class af extends com.appsflyer.internal.av<String> {
    af(Context context) {
        super(context, "com.facebook.katana.provider.AttributionIdProvider", /* result */);
    }

    private String AFKeystoreWrapper() {
        Throwable th3;
        Throwable th;
        ContentResolver contentResolver;
        final String str = "aid";
        StringBuilder stringBuilder = new StringBuilder("content://");
        stringBuilder.append(this.valueOf);
        Cursor query = this.AFInAppEventParameterName.getContentResolver().query(Uri.parse(stringBuilder.toString()), /* result */, 0, 0, 0);
        if (query != null && query.moveToFirst() && query != null) {
            try {
                if (query.moveToFirst()) {
                }
                if (query != null) {
                }
                query.close();
                return query.getString(query.getColumnIndex(str));
                if (query != null) {
                }
                query.close();
                return null;
                th = th2;
                Throwable th2 = th3;
                if (th == null) {
                } else {
                }
                th.close();
                throw th2;
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.appsflyer.internal.av
    public final String AFInAppEventParameterName() {
        Thread thread = new Thread(this.AFInAppEventType);
        thread.start();
        return (String)super.valueOf();
    }

    @Override // com.appsflyer.internal.av
    public final Object AFInAppEventType() {
        return AFKeystoreWrapper();
    }

    @Override // com.appsflyer.internal.av
    public final Object valueOf() {
        Thread thread = new Thread(this.AFInAppEventType);
        thread.start();
        return (String)super.valueOf();
    }
}
