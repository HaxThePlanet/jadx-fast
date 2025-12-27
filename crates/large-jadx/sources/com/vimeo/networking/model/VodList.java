package com.vimeo.networking.model;

/* compiled from: VodList.java */
/* loaded from: classes2.dex */
public class VodList extends BaseResponseList<VodItem> {

    private static final long serialVersionUID = 2086096986453255372L;
    @Override // com.vimeo.networking.model.BaseResponseList
    public Class<VodItem> getModelClass() {
        return VodItem.class;
    }
}
