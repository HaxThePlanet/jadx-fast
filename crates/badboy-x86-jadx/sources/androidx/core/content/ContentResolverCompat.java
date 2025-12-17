package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.core.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;

/* loaded from: classes5.dex */
public final class ContentResolverCompat {
    public static Cursor query(ContentResolver resolver, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
        try {
            return resolver.query(uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
            boolean operationCanceledException = th instanceof OperationCanceledException;
            if (operationCanceledException != null) {
            }
            operationCanceledException = new OperationCanceledException();
            throw operationCanceledException;
            throw th;
        }
    }

    @Deprecated
    public static Cursor query(ContentResolver resolver, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
        Object cancellationSignalObject;
        Object obj;
        if (cancellationSignal != null) {
            obj = cancellationSignalObject;
        } else {
            obj = cancellationSignalObject;
        }
        return ContentResolverCompat.query(resolver, uri, projection, selection, selectionArgs, sortOrder, obj);
    }
}
