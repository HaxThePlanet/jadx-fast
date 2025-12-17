package com.google.firebase.encoders;

/* loaded from: classes2.dex */
public interface ObjectEncoderContext {
    public abstract com.google.firebase.encoders.ObjectEncoderContext add(com.google.firebase.encoders.FieldDescriptor fieldDescriptor, double d2);

    public abstract com.google.firebase.encoders.ObjectEncoderContext add(com.google.firebase.encoders.FieldDescriptor fieldDescriptor, float f2);

    public abstract com.google.firebase.encoders.ObjectEncoderContext add(com.google.firebase.encoders.FieldDescriptor fieldDescriptor, int i2);

    public abstract com.google.firebase.encoders.ObjectEncoderContext add(com.google.firebase.encoders.FieldDescriptor fieldDescriptor, long l2);

    public abstract com.google.firebase.encoders.ObjectEncoderContext add(com.google.firebase.encoders.FieldDescriptor fieldDescriptor, Object object2);

    public abstract com.google.firebase.encoders.ObjectEncoderContext add(com.google.firebase.encoders.FieldDescriptor fieldDescriptor, boolean z2);

    @Deprecated
    public abstract com.google.firebase.encoders.ObjectEncoderContext add(String string, double d2);

    @Deprecated
    public abstract com.google.firebase.encoders.ObjectEncoderContext add(String string, int i2);

    @Deprecated
    public abstract com.google.firebase.encoders.ObjectEncoderContext add(String string, long l2);

    @Deprecated
    public abstract com.google.firebase.encoders.ObjectEncoderContext add(String string, Object object2);

    @Deprecated
    public abstract com.google.firebase.encoders.ObjectEncoderContext add(String string, boolean z2);

    public abstract com.google.firebase.encoders.ObjectEncoderContext inline(Object object);

    public abstract com.google.firebase.encoders.ObjectEncoderContext nested(com.google.firebase.encoders.FieldDescriptor fieldDescriptor);

    public abstract com.google.firebase.encoders.ObjectEncoderContext nested(String string);
}
