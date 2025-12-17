package com.google.firebase.encoders;

/* loaded from: classes2.dex */
public interface ValueEncoder<T>  extends com.google.firebase.encoders.Encoder<T, com.google.firebase.encoders.ValueEncoderContext> {
    public abstract void encode(TValue tvalue, TContext tcontext2);
}
