package d.s.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.List;

/* loaded from: classes.dex */
public final class f {
    public static List<Uri> a(Cursor cursor) {
        return cursor.getNotificationUris();
    }

    public static void b(Cursor cursor, ContentResolver contentResolver2, List<Uri> list3) {
        cursor.setNotificationUris(contentResolver2, list3);
    }
}
