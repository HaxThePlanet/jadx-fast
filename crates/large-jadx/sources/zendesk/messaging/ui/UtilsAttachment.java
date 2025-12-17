package zendesk.messaging.ui;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;

/* loaded from: classes3.dex */
class UtilsAttachment {
    static String formatFileSize(Context context, long l2) {
        int sDK_INT;
        int obj3;
        if (Build.VERSION.SDK_INT >= 26) {
            int i = 1000;
            sDK_INT = 1024;
            obj3 /= sDK_INT;
        }
        return Formatter.formatFileSize(context, obj3);
    }
}
