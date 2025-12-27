package com.vimeo.networking.model;

/* compiled from: FeedList.java */
/* loaded from: classes2.dex */
public class FeedList extends BaseResponseList<FeedItem> {

    private static final long serialVersionUID = 5489148474407186588L;
    @Override // com.vimeo.networking.model.BaseResponseList
    public Class<FeedItem> getModelClass() {
        return FeedItem.class;
    }
}
