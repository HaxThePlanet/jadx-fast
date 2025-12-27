package com.vimeo.networking.model.search;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: SearchFacet.java */
/* loaded from: classes2.dex */
public class SearchFacet implements Serializable {

    private static final long serialVersionUID = -6507918911819851151L;
    public String mName;
    public ArrayList<FacetOption> mOptions;
    public String getName() {
        return this.mName;
    }

    public ArrayList<FacetOption> getOptions() {
        return this.mOptions;
    }
}
