package com.google.firebase.storage.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.storage.network.NetworkRequest;

/* loaded from: classes2.dex */
public class StorageReferenceUri {

    private final Uri gsUri;
    private final Uri httpBaseUri;
    private final Uri httpUri;
    public StorageReferenceUri(Uri uri) {
        super(uri, 0);
    }

    public StorageReferenceUri(Uri uri, EmulatedServiceSettings emulatedServiceSettings2) {
        StringBuilder stringBuilder;
        int length;
        String str;
        Uri obj4;
        super();
        this.gsUri = uri;
        if (emulatedServiceSettings2 == null) {
            obj4 = NetworkRequest.PROD_BASE_URL;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("http://");
            stringBuilder.append(emulatedServiceSettings2.getHost());
            stringBuilder.append(":");
            stringBuilder.append(emulatedServiceSettings2.getPort());
            stringBuilder.append("/v0");
            obj4 = Uri.parse(stringBuilder.toString());
        }
        this.httpBaseUri = obj4;
        String obj3 = Slashes.normalizeSlashes(uri.getPath());
        if (obj3.length() > 0 && !"/".equals(obj3)) {
            if (!"/".equals(obj3)) {
                obj4 = obj4.buildUpon().appendPath("b").appendEncodedPath(uri.getAuthority()).appendPath("o").appendPath(obj3);
            }
        }
        this.httpUri = obj4.build();
    }

    public Uri getGsUri() {
        return this.gsUri;
    }

    public Uri getHttpBaseUri() {
        return this.httpBaseUri;
    }

    public Uri getHttpUri() {
        return this.httpUri;
    }
}
