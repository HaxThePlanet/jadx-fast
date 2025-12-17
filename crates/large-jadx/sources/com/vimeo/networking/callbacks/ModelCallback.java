package com.vimeo.networking.callbacks;

/* loaded from: classes2.dex */
public abstract class ModelCallback<T>  extends com.vimeo.networking.callbacks.VimeoCallback<T> {

    private Class objectType;
    public ModelCallback(Class class) {
        super();
        this.objectType = class;
    }

    @Override // com.vimeo.networking.callbacks.VimeoCallback
    public Class getObjectType() {
        return this.objectType;
    }
}
