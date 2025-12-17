package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class BaseResponseList<T>  implements Serializable {

    private static final long serialVersionUID = -1641146617506148394L;
    public ArrayList<T> data;
    public int page;
    public com.vimeo.networking.model.Paging paging;
    public int perPage;
    public int total;
    public abstract Class<T> getModelClass();
}
