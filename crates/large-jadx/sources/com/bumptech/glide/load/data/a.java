package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class a extends com.bumptech.glide.load.data.l<AssetFileDescriptor> {
    public a(ContentResolver contentResolver, Uri uri2) {
        super(contentResolver, uri2);
    }

    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.l
    protected void c(Object object) {
        g((AssetFileDescriptor)object);
    }

    @Override // com.bumptech.glide.load.data.l
    protected Object f(Uri uri, ContentResolver contentResolver2) {
        return h(uri, contentResolver2);
    }

    @Override // com.bumptech.glide.load.data.l
    protected void g(AssetFileDescriptor assetFileDescriptor) {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.l
    protected AssetFileDescriptor h(Uri uri, ContentResolver contentResolver2) {
        AssetFileDescriptor obj4 = contentResolver2.openAssetFileDescriptor(uri, "r");
        if (obj4 == null) {
        } else {
            return obj4;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FileDescriptor is null for: ");
        stringBuilder.append(uri);
        obj4 = new FileNotFoundException(stringBuilder.toString());
        throw obj4;
    }
}
