package com.google.firebase.database.tubesock;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
class MessageBuilderFactory {

    interface Builder {
        public abstract boolean appendBytes(byte[] bArr);

        public abstract com.google.firebase.database.tubesock.WebSocketMessage toMessage();
    }

    static class BinaryBuilder implements com.google.firebase.database.tubesock.MessageBuilderFactory.Builder {

        private int pendingByteCount = 0;
        private List<byte[]> pendingBytes;
        BinaryBuilder() {
            super();
            int i = 0;
            ArrayList arrayList = new ArrayList();
            this.pendingBytes = arrayList;
        }

        @Override // com.google.firebase.database.tubesock.MessageBuilderFactory$Builder
        public boolean appendBytes(byte[] bArr) {
            this.pendingBytes.add(bArr);
            this.pendingByteCount = pendingByteCount += obj2;
            return 1;
        }

        @Override // com.google.firebase.database.tubesock.MessageBuilderFactory$Builder
        public com.google.firebase.database.tubesock.WebSocketMessage toMessage() {
            int i2;
            int i;
            int length2;
            int length;
            byte[] bArr = new byte[this.pendingByteCount];
            int i3 = 0;
            i = i2;
            while (i2 < this.pendingBytes.size()) {
                Object obj = this.pendingBytes.get(i2);
                System.arraycopy((byte[])obj, i3, bArr, i, obj.length);
                i += length2;
                i2++;
            }
            WebSocketMessage webSocketMessage = new WebSocketMessage(bArr);
            return webSocketMessage;
        }
    }

    static class TextBuilder implements com.google.firebase.database.tubesock.MessageBuilderFactory.Builder {

        private static java.lang.ThreadLocal<CharsetDecoder> localDecoder;
        private static java.lang.ThreadLocal<CharsetEncoder> localEncoder;
        private StringBuilder builder;
        private ByteBuffer carryOver;
        static {
            MessageBuilderFactory.TextBuilder.1 anon = new MessageBuilderFactory.TextBuilder.1();
            MessageBuilderFactory.TextBuilder.localDecoder = anon;
            MessageBuilderFactory.TextBuilder.2 anon2 = new MessageBuilderFactory.TextBuilder.2();
            MessageBuilderFactory.TextBuilder.localEncoder = anon2;
        }

        TextBuilder() {
            super();
            StringBuilder stringBuilder = new StringBuilder();
            this.builder = stringBuilder;
        }

        private String decodeString(byte[] bArr) {
            try {
                return (CharsetDecoder)MessageBuilderFactory.TextBuilder.localDecoder.get().decode(ByteBuffer.wrap(bArr)).toString();
                bArr = null;
                return bArr;
            }
        }

        private String decodeStringStreaming(byte[] bArr) {
            int i;
            CharBuffer allocate;
            boolean overflow;
            boolean underflow;
            ByteBuffer obj6 = getBuffer(bArr);
            allocate = CharBuffer.allocate((int)i3);
            try {
                CoderResult decode = (CharsetDecoder)MessageBuilderFactory.TextBuilder.localDecoder.get().decode(obj6, allocate, false);
                while (decode.isError()) {
                    if (decode.isOverflow()) {
                    }
                    decode = (CharsetDecoder)MessageBuilderFactory.TextBuilder.localDecoder.get().decode(obj6, allocate, false);
                    overflow = CharBuffer.allocate(i4++);
                    allocate.flip();
                    overflow.put(allocate);
                    allocate = overflow;
                }
                return null;
                if (decode.isUnderflow()) {
                } else {
                }
                if (obj6.remaining() > 0) {
                }
                this.carryOver = obj6;
                (CharsetEncoder)MessageBuilderFactory.TextBuilder.localEncoder.get().encode(CharBuffer.wrap(allocate));
                allocate.flip();
                return allocate.toString();
                if (decode.isOverflow()) {
                }
                overflow = CharBuffer.allocate(i4++);
                allocate.flip();
                overflow.put(allocate);
                allocate = overflow;
                return obj0;
            }
        }

        private ByteBuffer getBuffer(byte[] bArr) {
            ByteBuffer carryOver = this.carryOver;
            if (carryOver != null) {
                ByteBuffer allocate = ByteBuffer.allocate(length += remaining);
                allocate.put(this.carryOver);
                this.carryOver = 0;
                allocate.put(bArr);
                allocate.flip();
                return allocate;
            }
            return ByteBuffer.wrap(bArr);
        }

        @Override // com.google.firebase.database.tubesock.MessageBuilderFactory$Builder
        public boolean appendBytes(byte[] bArr) {
            String obj2 = decodeString(bArr);
            if (obj2 != null) {
                this.builder.append(obj2);
                return 1;
            }
            return 0;
        }

        @Override // com.google.firebase.database.tubesock.MessageBuilderFactory$Builder
        public com.google.firebase.database.tubesock.WebSocketMessage toMessage() {
            if (this.carryOver != null) {
                return null;
            }
            WebSocketMessage webSocketMessage = new WebSocketMessage(this.builder.toString());
            return webSocketMessage;
        }
    }
    static com.google.firebase.database.tubesock.MessageBuilderFactory.Builder builder(byte b) {
        if (b == 2) {
            MessageBuilderFactory.BinaryBuilder obj1 = new MessageBuilderFactory.BinaryBuilder();
            return obj1;
        }
        obj1 = new MessageBuilderFactory.TextBuilder();
        return obj1;
    }
}
