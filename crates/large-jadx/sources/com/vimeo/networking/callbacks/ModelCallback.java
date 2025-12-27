package com.vimeo.networking.callbacks;

/* compiled from: ModelCallback.java */
/* loaded from: classes2.dex */
public abstract class ModelCallback<T> extends VimeoCallback<T> {

    private Class objectType;
    public ModelCallback(Class cls) {
        super();
        this.objectType = cls;
    }

    @Override // com.vimeo.networking.callbacks.VimeoCallback
    public Class getObjectType() {
        return this.objectType;
    }
}
