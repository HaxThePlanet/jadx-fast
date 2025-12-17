package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes2.dex */
public class Group implements Serializable {

    private static final long serialVersionUID = -3604741570351063891L;
    public Date createdTime;
    public String groupDescription;
    public String link;
    public com.vimeo.networking.model.Metadata metadata;
    public String name;
    public com.vimeo.networking.model.PictureCollection pictureCollection;
    public com.vimeo.networking.model.Privacy privacy;
    public String uri;
    public com.vimeo.networking.model.User user;
}
