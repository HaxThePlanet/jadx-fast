package com.google.firebase.encoders;

/* loaded from: classes2.dex */
public interface ObjectEncoder<T>  extends com.google.firebase.encoders.Encoder<T, com.google.firebase.encoders.ObjectEncoderContext> {
    public abstract void encode(TValue tvalue, TContext tcontext2);
}
