package zendesk.belvedere;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import java.util.Locale;

/* loaded from: classes3.dex */
class g {

    static final String[] c;
    private final Context a;
    private final int b;
    static {
        g.c = /* result */;
    }

    g(Context context, int i2) {
        super();
        this.a = context;
        this.b = i2;
    }

    Cursor a(int i) {
        Object eXTERNAL_CONTENT_URI;
        int i2;
        Bundle bundle;
        String[] contentResolver;
        int eXTERNAL_CONTENT_URI2;
        int i3;
        int i5;
        int i4;
        String format;
        Cursor obj10;
        i2 = 0;
        if (this.a == null) {
            return i2;
        }
        eXTERNAL_CONTENT_URI = b();
        eXTERNAL_CONTENT_URI2 = 0;
        i3 = 1;
        if (this.b >= 26) {
            bundle = new Bundle();
            bundle.putInt("android:query-arg-limit", i);
            obj10 = new String[i3];
            obj10[eXTERNAL_CONTENT_URI2] = eXTERNAL_CONTENT_URI;
            bundle.putStringArray("android:query-arg-sort-columns", obj10);
            bundle.putInt("android:query-arg-sort-direction", i3);
            obj10 = this.a.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, g.c, bundle, i2);
        } else {
            bundle = new Object[2];
            bundle[eXTERNAL_CONTENT_URI2] = eXTERNAL_CONTENT_URI;
            bundle[i3] = Integer.valueOf(i);
            obj10 = this.a.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, g.c, 0, 0, String.format(Locale.US, "%s DESC LIMIT %s", bundle));
        }
        return obj10;
    }

    String b() {
        String str;
        str = this.b >= 29 ? "datetaken" : "date_modified";
        return str;
    }
}
