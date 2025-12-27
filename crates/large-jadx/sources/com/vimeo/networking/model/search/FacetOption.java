package com.vimeo.networking.model.search;

import java.io.Serializable;

/* compiled from: FacetOption.java */
/* loaded from: classes2.dex */
public class FacetOption implements Serializable {

    private static final long serialVersionUID = 6525562797608669182L;
    public String mName;
    public String mText;
    public int mTotal;
    public String getName() {
        return this.mName;
    }

    public String getText() {
        return this.mText;
    }

    public int getTotal() {
        return this.mTotal;
    }
}
