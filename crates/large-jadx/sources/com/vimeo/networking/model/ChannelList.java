package com.vimeo.networking.model;

/* compiled from: ChannelList.java */
/* loaded from: classes2.dex */
public class ChannelList extends BaseResponseList<Channel> {

    private static final long serialVersionUID = -6382319292336453350L;
    @Override // com.vimeo.networking.model.BaseResponseList
    public Class<Channel> getModelClass() {
        return Channel.class;
    }
}
