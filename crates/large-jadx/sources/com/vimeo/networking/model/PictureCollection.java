package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: PictureCollection.java */
/* loaded from: classes2.dex */
public class PictureCollection implements Serializable {

    private static final long serialVersionUID = -4495146309328278574L;
    public boolean active;
    public boolean isDefault;
    public ArrayList<Picture> sizes;
    public String uri;
    public Picture pictureForWidth(int i) {
        Object item;
        int i2;
        if (this.sizes != null && !this.sizes.isEmpty()) {
            item = this.sizes.get(this.sizes.size() - 1);
            Iterator it = this.sizes.iterator();
            while (it.hasNext()) {
                item = it.next();
            }
            return item;
        }
        return null;
    }
}
