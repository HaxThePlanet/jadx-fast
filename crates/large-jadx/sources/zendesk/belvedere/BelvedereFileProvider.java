package zendesk.belvedere;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MatrixCursor.RowBuilder;
import android.net.Uri;
import android.util.Log;
import androidx.core.content.FileProvider;
import java.util.Arrays;

/* loaded from: classes3.dex */
public class BelvedereFileProvider extends FileProvider {
    private String[] h(String[] stringArr) {
        int i;
        boolean equals;
        Object obj;
        i = 0;
        String str = "_data";
        while (i < stringArr.length) {
            i++;
            str = "_data";
        }
        Object[] copyOf = Arrays.copyOf(stringArr, length2++);
        (String[])copyOf[stringArr.length] = str;
        return copyOf;
    }

    @Override // androidx.core.content.FileProvider
    public Cursor query(Uri uri, String[] string2Arr2, String string3, String[] string4Arr4, String string5) {
        int length;
        int obj4;
        int obj6;
        Cursor obj2 = super.query(uri, string2Arr2, string3, string4Arr4, string5);
        if (obj2 == null) {
            Log.w("Belvedere", "Not able to apply workaround, super.query(...) returned null");
            return null;
        }
        String[] obj3 = obj2.getColumnNames();
        MatrixCursor obj5 = new MatrixCursor(h(obj3), obj2.getCount());
        obj2.moveToPosition(-1);
        while (obj2.moveToNext()) {
            obj6 = 0;
            while (obj6 < obj3.length) {
                obj5.newRow().add(obj2.getString(obj6));
                obj6++;
            }
            obj4.add(obj2.getString(obj6));
            obj6++;
        }
        obj2.close();
        return obj5;
    }
}
