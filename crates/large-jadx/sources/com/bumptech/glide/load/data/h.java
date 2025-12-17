package com.bumptech.glide.load.data;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

/* loaded from: classes.dex */
public class h extends com.bumptech.glide.load.data.b<AssetFileDescriptor> {
    public h(AssetManager assetManager, String string2) {
        super(assetManager, string2);
    }

    public Class<AssetFileDescriptor> a() {
        return AssetFileDescriptor.class;
    }

    @Override // com.bumptech.glide.load.data.b
    protected void c(Object object) {
        g((AssetFileDescriptor)object);
    }

    @Override // com.bumptech.glide.load.data.b
    protected Object f(AssetManager assetManager, String string2) {
        return h(assetManager, string2);
    }

    @Override // com.bumptech.glide.load.data.b
    protected void g(AssetFileDescriptor assetFileDescriptor) {
        assetFileDescriptor.close();
    }

    @Override // com.bumptech.glide.load.data.b
    protected AssetFileDescriptor h(AssetManager assetManager, String string2) {
        return assetManager.openFd(string2);
    }
}
