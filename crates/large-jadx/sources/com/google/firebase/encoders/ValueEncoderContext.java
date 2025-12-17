package com.google.firebase.encoders;

/* loaded from: classes2.dex */
public interface ValueEncoderContext {
    public abstract com.google.firebase.encoders.ValueEncoderContext add(double d);

    public abstract com.google.firebase.encoders.ValueEncoderContext add(float f);

    public abstract com.google.firebase.encoders.ValueEncoderContext add(int i);

    public abstract com.google.firebase.encoders.ValueEncoderContext add(long l);

    public abstract com.google.firebase.encoders.ValueEncoderContext add(String string);

    public abstract com.google.firebase.encoders.ValueEncoderContext add(boolean z);

    public abstract com.google.firebase.encoders.ValueEncoderContext add(byte[] bArr);
}
