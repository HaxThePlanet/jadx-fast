package com.google.protobuf;

/* loaded from: classes2.dex */
final class q1 {

    private interface b {
        public abstract byte a(int i);

        public abstract int size();
    }

    static class a implements com.google.protobuf.q1.b {

        final com.google.protobuf.j a;
        a(com.google.protobuf.j j) {
            this.a = j;
            super();
        }

        @Override // com.google.protobuf.q1$b
        public byte a(int i) {
            return this.a.g(i);
        }

        @Override // com.google.protobuf.q1$b
        public int size() {
            return this.a.size();
        }
    }
    static String a(com.google.protobuf.j j) {
        q1.a aVar = new q1.a(j);
        return q1.b(aVar);
    }

    static String b(com.google.protobuf.q1.b q1$b) {
        int i2;
        String str;
        int i3;
        int i;
        StringBuilder stringBuilder = new StringBuilder(b.size());
        i2 = 0;
        while (i2 < b.size()) {
            byte b2 = b.a(i2);
            if (b2 != 34) {
            } else {
            }
            stringBuilder.append("\\\"");
            i2++;
            if (b2 != 39) {
            } else {
            }
            stringBuilder.append("\\'");
            i3 = 92;
            if (b2 != i3) {
            } else {
            }
            stringBuilder.append("\\\\");
            if (b2 >= 32 && b2 <= 126) {
            } else {
            }
            stringBuilder.append(i3);
            stringBuilder.append((char)i8);
            stringBuilder.append((char)i11);
            stringBuilder.append((char)i5);
            if (b2 <= 126) {
            } else {
            }
            stringBuilder.append((char)b2);
            stringBuilder.append("\\r");
            stringBuilder.append("\\f");
            stringBuilder.append("\\v");
            stringBuilder.append("\\n");
            stringBuilder.append("\\t");
            stringBuilder.append("\\b");
            stringBuilder.append("\\a");
        }
        return stringBuilder.toString();
    }

    static String c(String string) {
        return q1.a(j.u(string));
    }
}
