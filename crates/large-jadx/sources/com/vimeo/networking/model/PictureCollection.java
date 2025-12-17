package com.vimeo.networking.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class PictureCollection implements Serializable {

    private static final long serialVersionUID = -4495146309328278574L;
    public boolean active;
    public boolean isDefault;
    public ArrayList<com.vimeo.networking.model.Picture> sizes;
    public String uri;
    @Override // java.io.Serializable
    public com.vimeo.networking.model.Picture pictureForWidth(int i) {
        Object obj;
        ArrayList sizes;
        Object next;
        int width;
        int i2;
        sizes = this.sizes;
        if (sizes != null && !sizes.isEmpty()) {
            if (!sizes.isEmpty()) {
                ArrayList sizes2 = this.sizes;
                obj = sizes2.get(size--);
                Iterator iterator = this.sizes.iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    width = next.width;
                    if (width >= i && width -= i < width2 -= i) {
                    }
                    if (width -= i < width2 -= i) {
                    }
                    obj = next;
                }
                return obj;
            }
        }
        return null;
    }
}
