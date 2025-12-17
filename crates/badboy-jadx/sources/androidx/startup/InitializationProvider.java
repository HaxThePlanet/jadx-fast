package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes5.dex */
public class InitializationProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String selection, String[] selectionArgs) {
        IllegalStateException illegalStateException = new IllegalStateException("Not allowed.");
        throw illegalStateException;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        IllegalStateException illegalStateException = new IllegalStateException("Not allowed.");
        throw illegalStateException;
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues values) {
        IllegalStateException illegalStateException = new IllegalStateException("Not allowed.");
        throw illegalStateException;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Object instance;
        final Context context = getContext();
        if (context == null) {
        } else {
            if (context.getApplicationContext() != null) {
                AppInitializer.getInstance(context).discoverAndInitialize();
            } else {
                StartupLogger.w("Deferring initialization because `applicationContext` is null.");
            }
            return 1;
        }
        StartupException startupException = new StartupException("Context cannot be null");
        throw startupException;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        IllegalStateException illegalStateException = new IllegalStateException("Not allowed.");
        throw illegalStateException;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        IllegalStateException illegalStateException = new IllegalStateException("Not allowed.");
        throw illegalStateException;
    }
}
