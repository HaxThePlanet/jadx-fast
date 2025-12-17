package com.google.firebase.encoders.config;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;

/* loaded from: classes2.dex */
public interface EncoderConfig<T extends com.google.firebase.encoders.config.EncoderConfig<T>>  {
    public abstract <U> T registerEncoder(Class<U> class, ObjectEncoder<? super U> objectEncoder2);

    public abstract <U> T registerEncoder(Class<U> class, ValueEncoder<? super U> valueEncoder2);
}
