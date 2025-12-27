package com.vimeo.networking.model;

/* compiled from: CommentList.java */
/* loaded from: classes2.dex */
public class CommentList extends BaseResponseList<Comment> {

    private static final long serialVersionUID = -5092384010058406105L;
    @Override // com.vimeo.networking.model.BaseResponseList
    public Class<Comment> getModelClass() {
        return Comment.class;
    }
}
