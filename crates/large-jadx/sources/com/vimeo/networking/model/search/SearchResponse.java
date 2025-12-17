package com.vimeo.networking.model.search;

import com.vimeo.networking.model.BaseResponseList;

/* loaded from: classes2.dex */
public class SearchResponse extends BaseResponseList<com.vimeo.networking.model.search.SearchResult> {

    private static final long serialVersionUID = -7915082057592438294L;
    public com.vimeo.networking.model.search.SearchFacetCollection mFacetCollection;
    public int mMatureHiddenCount;
    @Override // com.vimeo.networking.model.BaseResponseList
    public com.vimeo.networking.model.search.SearchFacetCollection getFacetCollection() {
        return this.mFacetCollection;
    }

    @Override // com.vimeo.networking.model.BaseResponseList
    public int getMatureHiddenCount() {
        return this.mMatureHiddenCount;
    }

    public Class<com.vimeo.networking.model.search.SearchResult> getModelClass() {
        return SearchResult.class;
    }
}
