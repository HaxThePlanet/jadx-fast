package com.vimeo.networking.model.search;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class FacetOption implements Serializable {

    private static final long serialVersionUID = 6525562797608669182L;
    public String mName;
    public String mText;
    public int mTotal;
    @Override // java.io.Serializable
    public String getName() {
        return this.mName;
    }

    @Override // java.io.Serializable
    public String getText() {
        return this.mText;
    }

    @Override // java.io.Serializable
    public int getTotal() {
        return this.mTotal;
    }
}
