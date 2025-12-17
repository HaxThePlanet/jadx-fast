package com.vimeo.networking.model.search;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class SearchFacet implements Serializable {

    private static final long serialVersionUID = -6507918911819851151L;
    public String mName;
    public ArrayList<com.vimeo.networking.model.search.FacetOption> mOptions;
    @Override // java.io.Serializable
    public String getName() {
        return this.mName;
    }

    public ArrayList<com.vimeo.networking.model.search.FacetOption> getOptions() {
        return this.mOptions;
    }
}
