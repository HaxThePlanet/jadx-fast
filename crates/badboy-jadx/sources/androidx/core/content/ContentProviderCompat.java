package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;

/* loaded from: classes5.dex */
public final class ContentProviderCompat {
    public static Context requireContext(ContentProvider provider) {
        final Context context = provider.getContext();
        if (context == null) {
        } else {
            return context;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot find context from the provider.");
        throw illegalStateException;
    }
}
