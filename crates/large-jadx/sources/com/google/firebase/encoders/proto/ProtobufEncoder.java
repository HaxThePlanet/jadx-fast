package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ProtobufEncoder {

    private final ObjectEncoder<Object> fallbackEncoder;
    private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    private final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    public static final class Builder implements EncoderConfig<com.google.firebase.encoders.proto.ProtobufEncoder.Builder> {

        private static final ObjectEncoder<Object> DEFAULT_FALLBACK_ENCODER;
        private ObjectEncoder<Object> fallbackEncoder;
        private final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
        private final Map<Class<?>, ValueEncoder<?>> valueEncoders;
        static {
            ProtobufEncoder.Builder.DEFAULT_FALLBACK_ENCODER = b.a;
        }

        public Builder() {
            super();
            HashMap hashMap = new HashMap();
            this.objectEncoders = hashMap;
            HashMap hashMap2 = new HashMap();
            this.valueEncoders = hashMap2;
            this.fallbackEncoder = ProtobufEncoder.Builder.DEFAULT_FALLBACK_ENCODER;
        }

        static void a(Object object, ObjectEncoderContext objectEncoderContext2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Couldn't find encoder for type ");
            stringBuilder.append(object.getClass().getCanonicalName());
            EncodingException obj3 = new EncodingException(stringBuilder.toString());
            throw obj3;
        }

        @Override // com.google.firebase.encoders.config.EncoderConfig
        public com.google.firebase.encoders.proto.ProtobufEncoder build() {
            HashMap hashMap = new HashMap(this.objectEncoders);
            HashMap hashMap2 = new HashMap(this.valueEncoders);
            ProtobufEncoder protobufEncoder = new ProtobufEncoder(hashMap, hashMap2, this.fallbackEncoder);
            return protobufEncoder;
        }

        @Override // com.google.firebase.encoders.config.EncoderConfig
        public com.google.firebase.encoders.proto.ProtobufEncoder.Builder configureWith(Configurator configurator) {
            configurator.configure(this);
            return this;
        }

        @Override // com.google.firebase.encoders.config.EncoderConfig
        public EncoderConfig registerEncoder(Class class, ObjectEncoder objectEncoder2) {
            return registerEncoder(class, objectEncoder2);
        }

        @Override // com.google.firebase.encoders.config.EncoderConfig
        public EncoderConfig registerEncoder(Class class, ValueEncoder valueEncoder2) {
            return registerEncoder(class, valueEncoder2);
        }

        public <U> com.google.firebase.encoders.proto.ProtobufEncoder.Builder registerEncoder(Class<U> class, ObjectEncoder<? super U> objectEncoder2) {
            this.objectEncoders.put(class, objectEncoder2);
            this.valueEncoders.remove(class);
            return this;
        }

        public <U> com.google.firebase.encoders.proto.ProtobufEncoder.Builder registerEncoder(Class<U> class, ValueEncoder<? super U> valueEncoder2) {
            this.valueEncoders.put(class, valueEncoder2);
            this.objectEncoders.remove(class);
            return this;
        }

        public com.google.firebase.encoders.proto.ProtobufEncoder.Builder registerFallbackEncoder(ObjectEncoder<Object> objectEncoder) {
            this.fallbackEncoder = objectEncoder;
            return this;
        }
    }
    ProtobufEncoder(Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder3) {
        super();
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder3;
    }

    public static com.google.firebase.encoders.proto.ProtobufEncoder.Builder builder() {
        ProtobufEncoder.Builder builder = new ProtobufEncoder.Builder();
        return builder;
    }

    public void encode(Object object, OutputStream outputStream2) {
        ProtobufDataEncoderContext protobufDataEncoderContext = new ProtobufDataEncoderContext(outputStream2, this.objectEncoders, this.valueEncoders, this.fallbackEncoder);
        protobufDataEncoderContext.encode(object);
    }

    public byte[] encode(Object object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        encode(object, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
