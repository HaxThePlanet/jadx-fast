package com.vimeo.networking.model.search;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class SearchFacetCollection implements Serializable {

    private static final long serialVersionUID = 3340976215489066653L;
    public com.vimeo.networking.model.search.SearchFacet mCategoryFacet;
    public com.vimeo.networking.model.search.SearchFacet mDurationFacet;
    public com.vimeo.networking.model.search.SearchFacet mLicenseFacet;
    public com.vimeo.networking.model.search.SearchFacet mTypeFacet;
    public com.vimeo.networking.model.search.SearchFacet mUploadedFacet;
    public com.vimeo.networking.model.search.SearchFacet mUserTypeFacet;
    @Override // java.io.Serializable
    public com.vimeo.networking.model.search.SearchFacet getCategoryFacet() {
        return this.mCategoryFacet;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.search.SearchFacet getDurationFacet() {
        return this.mDurationFacet;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.search.SearchFacet getLicenseFacet() {
        return this.mLicenseFacet;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.search.SearchFacet getTypeFacet() {
        return this.mTypeFacet;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.search.SearchFacet getUploadedFacet() {
        return this.mUploadedFacet;
    }

    @Override // java.io.Serializable
    public com.vimeo.networking.model.search.SearchFacet getUserTypeFacet() {
        return this.mUserTypeFacet;
    }
}
