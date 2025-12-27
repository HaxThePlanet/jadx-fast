package com.vimeo.networking.model.search;

import com.vimeo.networking.model.BaseResponseList;

/* compiled from: SearchResponse.java */
/* loaded from: classes2.dex */
public class SearchResponse extends BaseResponseList<SearchResult> {

    private static final long serialVersionUID = -7915082057592438294L;
    public SearchFacetCollection mFacetCollection;
    public int mMatureHiddenCount;
    @Override // com.vimeo.networking.model.BaseResponseList
    public SearchFacetCollection getFacetCollection() {
        return this.mFacetCollection;
    }

    @Override // com.vimeo.networking.model.BaseResponseList
    public int getMatureHiddenCount() {
        return this.mMatureHiddenCount;
    }

    @Override // com.vimeo.networking.model.BaseResponseList
    public Class<SearchResult> getModelClass() {
        return SearchResult.class;
    }
}
