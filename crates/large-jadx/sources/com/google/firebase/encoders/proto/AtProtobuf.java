package com.google.firebase.encoders.proto;

import java.lang.annotation.Annotation;

/* loaded from: classes2.dex */
public final class AtProtobuf {

    private com.google.firebase.encoders.proto.Protobuf.IntEncoding intEncoding;
    private int tag;

    private static final class ProtobufImpl implements com.google.firebase.encoders.proto.Protobuf {

        private final com.google.firebase.encoders.proto.Protobuf.IntEncoding intEncoding;
        private final int tag;
        ProtobufImpl(int i, com.google.firebase.encoders.proto.Protobuf.IntEncoding protobuf$IntEncoding2) {
            super();
            this.tag = i;
            this.intEncoding = intEncoding2;
        }

        public Class<? extends Annotation> annotationType() {
            return Protobuf.class;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public boolean equals(Object object) {
            int i;
            int intEncoding;
            Object obj5;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (!object instanceof Protobuf) {
                return i2;
            }
            if (this.tag == (Protobuf)object.tag() && this.intEncoding.equals(object.intEncoding())) {
                if (this.intEncoding.equals(object.intEncoding())) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int hashCode() {
            return i += i5;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public com.google.firebase.encoders.proto.Protobuf.IntEncoding intEncoding() {
            return this.intEncoding;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public int tag() {
            return this.tag;
        }

        @Override // com.google.firebase.encoders.proto.Protobuf
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("@com.google.firebase.encoders.proto.Protobuf");
            stringBuilder.append('(');
            stringBuilder.append("tag=");
            stringBuilder.append(this.tag);
            stringBuilder.append("intEncoding=");
            stringBuilder.append(this.intEncoding);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    public AtProtobuf() {
        super();
        this.intEncoding = Protobuf.IntEncoding.DEFAULT;
    }

    public static com.google.firebase.encoders.proto.AtProtobuf builder() {
        AtProtobuf atProtobuf = new AtProtobuf();
        return atProtobuf;
    }

    public com.google.firebase.encoders.proto.Protobuf build() {
        AtProtobuf.ProtobufImpl protobufImpl = new AtProtobuf.ProtobufImpl(this.tag, this.intEncoding);
        return protobufImpl;
    }

    public com.google.firebase.encoders.proto.AtProtobuf intEncoding(com.google.firebase.encoders.proto.Protobuf.IntEncoding protobuf$IntEncoding) {
        this.intEncoding = intEncoding;
        return this;
    }

    public com.google.firebase.encoders.proto.AtProtobuf tag(int i) {
        this.tag = i;
        return this;
    }
}
