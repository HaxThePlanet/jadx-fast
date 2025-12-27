package com.vimeo.networking.model;

/* compiled from: CategoryList.java */
/* loaded from: classes2.dex */
public class CategoryList extends BaseResponseList<Category> {

    private static final long serialVersionUID = 6478758702787753766L;
    @Override // com.vimeo.networking.model.BaseResponseList
    public Class<Category> getModelClass() {
        return Category.class;
    }
}
