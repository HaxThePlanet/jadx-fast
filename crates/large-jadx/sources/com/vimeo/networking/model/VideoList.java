package com.vimeo.networking.model;

/* compiled from: VideoList.java */
/* loaded from: classes2.dex */
public class VideoList extends BaseResponseList<Video> {

    private static final long serialVersionUID = -5034081563847270372L;
    @Override // com.vimeo.networking.model.BaseResponseList
    public Class<Video> getModelClass() {
        return Video.class;
    }
}
