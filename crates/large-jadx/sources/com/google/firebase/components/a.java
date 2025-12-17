package com.google.firebase.components;

/* loaded from: classes2.dex */
public final class a implements com.google.firebase.components.ComponentFactory {

    public final Object a;
    public a(Object object) {
        super();
        this.a = object;
    }

    @Override // com.google.firebase.components.ComponentFactory
    public final Object create(com.google.firebase.components.ComponentContainer componentContainer) {
        final Object obj = this.a;
        Component.a(obj, componentContainer);
        return obj;
    }
}
