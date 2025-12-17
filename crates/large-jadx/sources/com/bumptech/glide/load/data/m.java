package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import java.io.InputStream;

/* loaded from: classes.dex */
public class m extends com.bumptech.glide.load.data.b<InputStream> {
    public m(AssetManager assetManager, String string2) {
        super(assetManager, string2);
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.b
    protected void c(Object object) {
        g((InputStream)object);
    }

    @Override // com.bumptech.glide.load.data.b
    protected Object f(AssetManager assetManager, String string2) {
        return h(assetManager, string2);
    }

    @Override // com.bumptech.glide.load.data.b
    protected void g(InputStream inputStream) {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.data.b
    protected InputStream h(AssetManager assetManager, String string2) {
        return assetManager.open(string2);
    }
}
