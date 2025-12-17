package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public class i extends com.bumptech.glide.load.data.l<ParcelFileDescriptor> {
    public i(ContentResolver contentResolver, Uri uri2) {
        super(contentResolver, uri2);
    }

    public Class<ParcelFileDescriptor> a() {
        return ParcelFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.l
    protected void c(Object object) {
        g((ParcelFileDescriptor)object);
    }

    @Override // com.bumptech.glide.load.data.l
    protected Object f(Uri uri, ContentResolver contentResolver2) {
        return h(uri, contentResolver2);
    }

    @Override // com.bumptech.glide.load.data.l
    protected void g(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.l
    protected ParcelFileDescriptor h(Uri uri, ContentResolver contentResolver2) {
        AssetFileDescriptor obj4 = contentResolver2.openAssetFileDescriptor(uri, "r");
        if (obj4 == null) {
        } else {
            return obj4.getParcelFileDescriptor();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FileDescriptor is null for: ");
        stringBuilder.append(uri);
        obj4 = new FileNotFoundException(stringBuilder.toString());
        throw obj4;
    }
}
