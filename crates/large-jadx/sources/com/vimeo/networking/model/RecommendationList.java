package com.vimeo.networking.model;

/* compiled from: RecommendationList.java */
/* loaded from: classes2.dex */
public class RecommendationList extends BaseResponseList<Recommendation> {

    private static final long serialVersionUID = -1488717279892501485L;
    @Override // com.vimeo.networking.model.BaseResponseList
    public Class<Recommendation> getModelClass() {
        return Recommendation.class;
    }
}
