package zendesk.belvedere;

import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.provider.MediaStore.Files;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
class m {

    private final Context a;
    private final zendesk.belvedere.g b;
    m(Context context) {
        super();
        this.a = context.getApplicationContext();
        g gVar = new g(context, Build.VERSION.SDK_INT);
        this.b = gVar;
    }

    boolean a(String string) {
        return a0.c(string, this.a);
    }

    List<zendesk.belvedere.s> b(int i) {
        int moveToNext;
        String mimeTypeFromExtension;
        boolean lastIndexOf;
        long l;
        int i3;
        int i2;
        android.net.Uri uri;
        android.net.Uri contentUri;
        String string;
        String str;
        long long3;
        long long;
        long long2;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = obj.b.a(i);
        if (cursor != null) {
        }
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }
}
