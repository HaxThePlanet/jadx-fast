package com.google.android.exoplayer2.drm;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.n;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MediaDrmCallbackException extends IOException {

    public final long bytesLoaded;
    public final n dataSpec;
    public final Map<String, List<String>> responseHeaders;
    public final Uri uriAfterRedirects;
    public MediaDrmCallbackException(n n, Uri uri2, Map<String, List<String>> map3, long l4, Throwable throwable5) {
        super(obj6);
        this.dataSpec = n;
        this.uriAfterRedirects = uri2;
        this.responseHeaders = map3;
        this.bytesLoaded = l4;
    }
}
