package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

/* compiled from: FileDescriptorAssetPathFetcher.java */
/* loaded from: classes.dex */
public class h extends b<AssetFileDescriptor> {
    public h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.bumptech.glide.load.data.b
    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.b
    protected void g(AssetFileDescriptor assetFileDescriptor) throws java.io.IOException {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.b
    protected AssetFileDescriptor h(AssetManager assetManager, String str) throws java.io.IOException {
        return assetManager.openFd(str);
    }
}
