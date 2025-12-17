package com.bumptech.glide.q;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    private final List<ImageHeaderParser> a;
    public b() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    public void a(ImageHeaderParser imageHeaderParser) {
        this.a.add(imageHeaderParser);
        return;
        synchronized (this) {
            this.a.add(imageHeaderParser);
        }
    }

    public List<ImageHeaderParser> b() {
        return this.a;
        synchronized (this) {
            return this.a;
        }
    }
}
