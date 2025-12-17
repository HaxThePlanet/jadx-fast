package com.google.firebase.encoders;

import java.io.Writer;

/* loaded from: classes2.dex */
public interface DataEncoder {
    public abstract String encode(Object object);

    public abstract void encode(Object object, Writer writer2);
}
