package com.vimeo.networking.model;

/* compiled from: UserList.java */
/* loaded from: classes2.dex */
public class UserList extends BaseResponseList<User> {

    private static final long serialVersionUID = -4188665245239932555L;
    @Override // com.vimeo.networking.model.BaseResponseList
    public Class<User> getModelClass() {
        return User.class;
    }
}
