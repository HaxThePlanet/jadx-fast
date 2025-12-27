package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.Date;

/* compiled from: Group.java */
/* loaded from: classes2.dex */
public class Group implements Serializable {

    private static final long serialVersionUID = -3604741570351063891L;
    public Date createdTime;
    public String groupDescription;
    public String link;
    public Metadata metadata;
    public String name;
    public PictureCollection pictureCollection;
    public Privacy privacy;
    public String uri;
    public User user;
}
