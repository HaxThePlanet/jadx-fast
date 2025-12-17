package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.annotations.ExtraProperty;
import java.lang.annotation.Annotation;

/* loaded from: classes2.dex */
@ExtraProperty
public @interface Protobuf {

    public static enum IntEncoding {

        DEFAULT,
        SIGNED,
        FIXED;
    }
    @Override // java.lang.annotation.Annotation
    public abstract com.google.firebase.encoders.proto.Protobuf.IntEncoding intEncoding() default Protobuf$IntEncoding.DEFAULT;

    @Override // java.lang.annotation.Annotation
    public abstract int tag();
}
