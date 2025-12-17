package androidx.lifecycle;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes.dex */
public class ProcessLifecycleOwnerInitializer extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String string2, String[] string3Arr3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        m.a(getContext());
        a0.i(getContext());
        return 1;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] string2Arr2, String string3, String[] string4Arr4, String string5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues2, String string3, String[] string4Arr4) {
        return 0;
    }
}
