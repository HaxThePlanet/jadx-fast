package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.InputStream;

/* compiled from: StreamAssetPathFetcher.java */
/* loaded from: classes.dex */
public class m extends b<InputStream> {
    public m(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.bumptech.glide.load.data.b
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.b
    protected void g(InputStream inputStream) throws java.io.IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.b
    protected InputStream h(AssetManager assetManager, String str) throws java.io.IOException {
        return assetManager.open(str);
    }
}
