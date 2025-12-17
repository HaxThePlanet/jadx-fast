package zendesk.core;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

/* loaded from: classes3.dex */
public abstract class SdkStartUpProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String string2, String[] string3Arr3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        return "";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        onStartUp(getContext());
        return 1;
    }

    @Override // android.content.ContentProvider
    protected abstract void onStartUp(Context context);

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] string2Arr2, String string3, String[] string4Arr4, String string5) {
        final int obj2 = 0;
        MatrixCursor obj1 = new MatrixCursor(new String[obj2], obj2);
        return obj1;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues2, String string3, String[] string4Arr4) {
        return 0;
    }
}
