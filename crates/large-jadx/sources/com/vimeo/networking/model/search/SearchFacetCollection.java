package com.vimeo.networking.model.search;

import java.io.Serializable;

/* compiled from: SearchFacetCollection.java */
/* loaded from: classes2.dex */
public class SearchFacetCollection implements Serializable {

    private static final long serialVersionUID = 3340976215489066653L;
    public SearchFacet mCategoryFacet;
    public SearchFacet mDurationFacet;
    public SearchFacet mLicenseFacet;
    public SearchFacet mTypeFacet;
    public SearchFacet mUploadedFacet;
    public SearchFacet mUserTypeFacet;
    public SearchFacet getCategoryFacet() {
        return this.mCategoryFacet;
    }

    public SearchFacet getDurationFacet() {
        return this.mDurationFacet;
    }

    public SearchFacet getLicenseFacet() {
        return this.mLicenseFacet;
    }

    public SearchFacet getTypeFacet() {
        return this.mTypeFacet;
    }

    public SearchFacet getUploadedFacet() {
        return this.mUploadedFacet;
    }

    public SearchFacet getUserTypeFacet() {
        return this.mUserTypeFacet;
    }
}
