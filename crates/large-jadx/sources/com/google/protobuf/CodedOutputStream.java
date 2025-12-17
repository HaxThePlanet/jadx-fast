package com.google.protobuf;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class CodedOutputStream extends com.google.protobuf.i {

    private static final Logger c;
    private static final boolean d;
    com.google.protobuf.m a;
    private boolean b;

    public static class OutOfSpaceException extends IOException {

        private static final long serialVersionUID = -6947486886997889499L;
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        OutOfSpaceException(String string, Throwable throwable2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CodedOutputStream was writing to a flat byte array and ran out of space.: ");
            stringBuilder.append(string);
            super(stringBuilder.toString(), throwable2);
        }

        OutOfSpaceException(Throwable throwable) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable);
        }
    }

    static class a {
    }

    private static abstract class b extends com.google.protobuf.CodedOutputStream {

        final byte[] e;
        final int f;
        int g;
        int h;
        b(int i) {
            super(0);
            if (i < 0) {
            } else {
                byte[] obj2 = new byte[Math.max(i, 20)];
                this.e = obj2;
                this.f = obj2.length;
            }
            obj2 = new IllegalArgumentException("bufferSize must be >= 0");
            throw obj2;
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void d1(byte b) {
            final int i = this.g;
            this.g = i + 1;
            this.e[i] = b;
            this.h = obj4++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void e1(int i) {
            final byte[] bArr = this.e;
            int i2 = this.g;
            int i5 = i2 + 1;
            this.g = i5;
            bArr[i2] = (byte)i7;
            int i3 = i5 + 1;
            this.g = i3;
            bArr[i5] = (byte)i9;
            int i6 = i3 + 1;
            this.g = i6;
            bArr[i3] = (byte)i11;
            this.g = i6 + 1;
            bArr[i6] = (byte)obj5;
            this.h = obj5 += 4;
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void f1(long l) {
            final byte[] bArr = this.e;
            int i = this.g;
            int i7 = i + 1;
            this.g = i7;
            int i11 = 255;
            bArr[i] = (byte)i27;
            int i2 = i7 + 1;
            this.g = i2;
            int i28 = 8;
            bArr[i7] = (byte)i31;
            int i8 = i2 + 1;
            this.g = i8;
            bArr[i2] = (byte)i35;
            int i3 = i8 + 1;
            this.g = i3;
            bArr[i8] = (byte)i13;
            int i9 = i3 + 1;
            this.g = i9;
            bArr[i3] = (byte)i17;
            int i4 = i9 + 1;
            this.g = i4;
            bArr[i9] = (byte)i21;
            int i10 = i4 + 1;
            this.g = i10;
            bArr[i4] = (byte)i25;
            this.g = i10 + 1;
            bArr[i10] = (byte)obj9;
            this.h = obj9 += i28;
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void g1(int i) {
            long l;
            if (i >= 0) {
                i1(i);
            } else {
                j1((long)i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void h1(int i, int i2) {
            i1(y1.c(i, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void i1(int i) {
            boolean z;
            int i2;
            byte b2;
            long l;
            int i3;
            byte b;
            int obj7;
            if (CodedOutputStream.c()) {
                while (obj7 & -128 == 0) {
                    int i17 = this.g;
                    i3 = i17 + 1;
                    this.g = i3;
                    w1.O(this.e, (long)i17, i3);
                    obj7 >>>= 7;
                }
                int i16 = this.g;
                int i18 = i16 + 1;
                this.g = i18;
                w1.O(this.e, (long)i16, i18);
                this.h = i7 += obj7;
            }
            while (obj7 & -128 == 0) {
                i2 = this.g;
                this.g = i2 + 1;
                this.e[i2] = (byte)i12;
                this.h = i5++;
                obj7 >>>= 7;
            }
            int i9 = this.g;
            this.g = i9 + 1;
            this.e[i9] = (byte)obj7;
            this.h = obj7++;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int j0() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
            throw unsupportedOperationException;
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void j1(long l) {
            boolean z;
            int i3;
            int i;
            byte b;
            long l2;
            int i2;
            byte b2;
            int obj12;
            int i5 = 7;
            int i8 = 0;
            final int i11 = -128;
            if (CodedOutputStream.c()) {
                while (Long.compare(i17, i8) == 0) {
                    int i18 = this.g;
                    i2 = i18 + 1;
                    this.g = i2;
                    w1.O(this.e, (long)i18, i2);
                    obj12 >>>= i5;
                }
                int i7 = this.g;
                int i10 = i7 + 1;
                this.g = i10;
                w1.O(this.e, (long)i7, i10);
                this.h = obj13 += obj12;
            }
            while (Long.compare(i12, i8) == 0) {
                i = this.g;
                this.g = i + 1;
                this.e[i] = (byte)i16;
                this.h = i4++;
                obj12 >>>= i5;
            }
            int i6 = this.g;
            this.g = i6 + 1;
            this.e[i6] = (byte)obj12;
            this.h = obj12++;
        }
    }

    private static class c extends com.google.protobuf.CodedOutputStream {

        private final byte[] e;
        private final int f;
        private int g;
        c(byte[] bArr, int i2, int i3) {
            super(0);
            Objects.requireNonNull(bArr, "buffer");
            int i8 = i2 + i3;
            if (i4 |= i6 < 0) {
            } else {
                this.e = bArr;
                this.g = i2;
                this.f = i8;
            }
            Object[] arr = new Object[3];
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
            throw illegalArgumentException;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void F0(int i, int i2) {
            Y0(i, 0);
            G0(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void G0(int i) {
            long l;
            if (i >= 0) {
                a1(i);
            } else {
                c1((long)i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void J0(int i, com.google.protobuf.t0 t02, com.google.protobuf.l1 l13) {
            Y0(i, 2);
            a1((a)t02.getSerializedSize(l13));
            l13.b(t02, this.a);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void K0(com.google.protobuf.t0 t0) {
            a1(t0.getSerializedSize());
            t0.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void L0(int i, com.google.protobuf.t0 t02) {
            final int i2 = 1;
            final int i3 = 3;
            Y0(i2, i3);
            Z0(2, i);
            f1(i3, t02);
            Y0(i2, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void M0(int i, com.google.protobuf.j j2) {
            final int i2 = 1;
            final int i3 = 3;
            Y0(i2, i3);
            Z0(2, i);
            p0(i3, j2);
            Y0(i2, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void W0(int i, String string2) {
            Y0(i, 2);
            X0(string2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void X0(String string) {
            int i3;
            int i;
            int i2;
            int i4;
            final int i5 = this.g;
            i = CodedOutputStream.Y(string.length());
            if (i == CodedOutputStream.Y(length *= 3)) {
                int i8 = i5 + i;
                this.g = i8;
                i3 = x1.i(string, this.e, i8, j0());
                this.g = i5;
                a1(i10 -= i);
                this.g = i3;
            } else {
                try {
                    a1(x1.j(string));
                    this.g = x1.i(string, this.e, this.g, j0());
                    CodedOutputStream.OutOfSpaceException outOfSpaceException = new CodedOutputStream.OutOfSpaceException(string);
                    throw outOfSpaceException;
                    this.g = outOfSpaceException;
                    e0(string, th);
                }
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void Y0(int i, int i2) {
            a1(y1.c(i, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void Z0(int i, int i2) {
            Y0(i, 0);
            a1(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void a(ByteBuffer byteBuffer) {
            d1(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void a1(int i) {
            boolean z;
            int format;
            int str;
            int obj5;
            if (CodedOutputStream.c() && !d.c() && j0() >= 5 && i & -128 == 0) {
                if (!d.c()) {
                    if (j0() >= 5) {
                        if (i & -128 == 0) {
                            int i7 = this.g;
                            int i17 = i7 + 1;
                            this.g = i17;
                            w1.O(this.e, (long)i7, i17);
                        }
                        int i8 = this.g;
                        int i18 = i8 + 1;
                        this.g = i18;
                        w1.O(this.e, (long)i8, i18);
                        i >>>= 7;
                        if (obj5 & -128 == 0) {
                            int i9 = this.g;
                            int i19 = i9 + 1;
                            this.g = i19;
                            w1.O(this.e, (long)i9, i19);
                        }
                        int i10 = this.g;
                        int i20 = i10 + 1;
                        this.g = i20;
                        w1.O(this.e, (long)i10, i20);
                        obj5 >>>= 7;
                        if (obj5 & -128 == 0) {
                            int i15 = this.g;
                            int i25 = i15 + 1;
                            this.g = i25;
                            w1.O(this.e, (long)i15, i25);
                        }
                        int i11 = this.g;
                        int i21 = i11 + 1;
                        this.g = i21;
                        w1.O(this.e, (long)i11, i21);
                        obj5 >>>= 7;
                        if (obj5 & -128 == 0) {
                            int i14 = this.g;
                            int i24 = i14 + 1;
                            this.g = i24;
                            w1.O(this.e, (long)i14, i24);
                        }
                        int i12 = this.g;
                        int i22 = i12 + 1;
                        this.g = i22;
                        w1.O(this.e, (long)i12, i22);
                        int i13 = this.g;
                        int i23 = i13 + 1;
                        this.g = i23;
                        w1.O(this.e, (long)i13, i23);
                    }
                }
            }
            while (obj5 & -128 == 0) {
                format = this.g;
                this.g = format + 1;
                this.e[format] = (byte)i28;
                obj5 >>>= 7;
            }
            int i16 = this.g;
            this.g = i16 + 1;
            this.e[i16] = (byte)obj5;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void b(byte[] bArr, int i2, int i3) {
            e1(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void b1(int i, long l2) {
            Y0(i, 0);
            c1(l2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void c1(long l) {
            boolean z;
            int i;
            byte b;
            byte b2;
            int obj10;
            int i2 = 7;
            int i5 = 0;
            final int i8 = -128;
            if (CodedOutputStream.c() && j0() >= 10) {
                if (j0() >= 10) {
                }
            }
            while (Long.compare(i9, i5) == 0) {
                i = this.g;
                this.g = i + 1;
                this.e[i] = (byte)i15;
                obj10 >>>= i2;
            }
            int i3 = this.g;
            this.g = i3 + 1;
            this.e[i3] = (byte)obj10;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public void d0() {
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void d1(ByteBuffer byteBuffer) {
            final int remaining = byteBuffer.remaining();
            byteBuffer.get(this.e, this.g, remaining);
            this.g = obj6 += remaining;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void e1(byte[] bArr, int i2, int i3) {
            try {
                System.arraycopy(bArr, i2, this.e, this.g, i3);
                this.g = obj4 += i3;
                int arr = 3;
                arr = new Object[arr];
                int i = 0;
                int valueOf = this.g;
                valueOf = Integer.valueOf(valueOf);
                arr[i] = valueOf;
                i = 1;
                valueOf = this.f;
                valueOf = Integer.valueOf(valueOf);
                arr[i] = valueOf;
                i = 2;
                i3 = Integer.valueOf(i3);
                arr[i] = i3;
                i3 = "Pos: %d, limit: %d, len: %d";
                i3 = String.format(i3, arr);
                i2 = new CodedOutputStream.OutOfSpaceException(i3, bArr);
                throw i2;
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void f1(int i, com.google.protobuf.t0 t02) {
            Y0(i, 2);
            K0(t02);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int j0() {
            return i -= i3;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void k0(byte b) {
            try {
                final int i = this.g;
                this.g = i + 1;
                this.e[i] = b;
                int format = 3;
                format = new Object[format];
                int str = 0;
                int valueOf = this.g;
                valueOf = Integer.valueOf(valueOf);
                format[str] = valueOf;
                str = this.f;
                str = Integer.valueOf(str);
                valueOf = 1;
                format[valueOf] = str;
                str = 2;
                valueOf = Integer.valueOf(valueOf);
                format[str] = valueOf;
                str = "Pos: %d, limit: %d, len: %d";
                format = String.format(str, format);
                CodedOutputStream.OutOfSpaceException outOfSpaceException = new CodedOutputStream.OutOfSpaceException(format, b);
                throw outOfSpaceException;
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void l0(int i, boolean z2) {
            Y0(i, 0);
            k0((byte)z2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void o0(byte[] bArr, int i2, int i3) {
            a1(i3);
            e1(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void p0(int i, com.google.protobuf.j j2) {
            Y0(i, 2);
            q0(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void q0(com.google.protobuf.j j) {
            a1(j.size());
            j.Y(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void v0(int i, int i2) {
            Y0(i, 5);
            w0(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void w0(int i) {
            try {
                final byte[] bArr = this.e;
                int i2 = this.g;
                int i5 = i2 + 1;
                this.g = i5;
                bArr[i2] = (byte)i7;
                int i3 = i5 + 1;
                this.g = i3;
                bArr[i5] = (byte)i9;
                int i6 = i3 + 1;
                this.g = i6;
                bArr[i3] = (byte)i11;
                this.g = i6 + 1;
                bArr[i6] = (byte)obj5;
                int format = 3;
                format = new Object[format];
                int str = 0;
                int valueOf = this.g;
                valueOf = Integer.valueOf(valueOf);
                format[str] = valueOf;
                str = this.f;
                str = Integer.valueOf(str);
                valueOf = 1;
                format[valueOf] = str;
                str = 2;
                valueOf = Integer.valueOf(valueOf);
                format[str] = valueOf;
                str = "Pos: %d, limit: %d, len: %d";
                format = String.format(str, format);
                CodedOutputStream.OutOfSpaceException outOfSpaceException = new CodedOutputStream.OutOfSpaceException(format, i);
                throw outOfSpaceException;
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void x0(int i, long l2) {
            Y0(i, 1);
            y0(l2);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void y0(long l) {
            try {
                final byte[] bArr = this.e;
                int i = this.g;
                int i7 = i + 1;
                this.g = i7;
                bArr[i] = (byte)i12;
                int i2 = i7 + 1;
                this.g = i2;
                bArr[i7] = (byte)i16;
                int i8 = i2 + 1;
                this.g = i8;
                bArr[i2] = (byte)i20;
                int i3 = i8 + 1;
                this.g = i3;
                bArr[i8] = (byte)i24;
                int i9 = i3 + 1;
                this.g = i9;
                bArr[i3] = (byte)i28;
                int i4 = i9 + 1;
                this.g = i4;
                bArr[i9] = (byte)i32;
                int i10 = i4 + 1;
                this.g = i10;
                bArr[i4] = (byte)i36;
                this.g = i10 + 1;
                bArr[i10] = (byte)obj6;
                int format = 3;
                format = new Object[format];
                int str = 0;
                int valueOf = this.g;
                valueOf = Integer.valueOf(valueOf);
                format[str] = valueOf;
                str = this.f;
                str = Integer.valueOf(str);
                valueOf = 1;
                format[valueOf] = str;
                str = 2;
                valueOf = Integer.valueOf(valueOf);
                format[str] = valueOf;
                str = "Pos: %d, limit: %d, len: %d";
                format = String.format(str, format);
                obj7 = new CodedOutputStream.OutOfSpaceException(format, l);
                throw obj7;
            }
        }
    }

    private static final class d extends com.google.protobuf.CodedOutputStream.b {

        private final OutputStream i;
        d(OutputStream outputStream, int i2) {
            super(i2);
            Objects.requireNonNull(outputStream, "out");
            this.i = outputStream;
        }

        private void k1() {
            final int i2 = 0;
            this.i.write(this.e, i2, this.g);
            this.g = i2;
        }

        private void l1(int i) {
            if (i2 -= i4 < i) {
                k1();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void F0(int i, int i2) {
            l1(20);
            h1(i, 0);
            g1(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void G0(int i) {
            long l;
            if (i >= 0) {
                a1(i);
            } else {
                c1((long)i);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        void J0(int i, com.google.protobuf.t0 t02, com.google.protobuf.l1 l13) {
            Y0(i, 2);
            p1(t02, l13);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void K0(com.google.protobuf.t0 t0) {
            a1(t0.getSerializedSize());
            t0.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void L0(int i, com.google.protobuf.t0 t02) {
            final int i2 = 1;
            final int i3 = 3;
            Y0(i2, i3);
            Z0(2, i);
            o1(i3, t02);
            Y0(i2, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void M0(int i, com.google.protobuf.j j2) {
            final int i2 = 1;
            final int i3 = 3;
            Y0(i2, i3);
            Z0(2, i);
            p0(i3, j2);
            Y0(i2, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void W0(int i, String string2) {
            Y0(i, 2);
            X0(string2);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void X0(String string) {
            int i3;
            int i;
            int i2;
            int i4;
            int i5;
            try {
                length *= 3;
                int i10 = CodedOutputStream.Y(i6);
                int i12 = i10 + i6;
                int i16 = this.f;
                if (i12 > i16) {
                }
                byte[] bArr2 = new byte[i6];
                int i14 = 0;
                int i9 = x1.i(string, bArr2, i14, i6);
                a1(i9);
                b(bArr2, i14, i9);
                if (i12 > i16 -= i7) {
                }
                k1();
                i3 = CodedOutputStream.Y(string.length());
                int i13 = this.g;
                if (i3 == i10) {
                } else {
                }
                int i11 = i13 + i3;
                this.g = i11;
                i2 = x1.i(string, this.e, i11, i19 -= i11);
                this.g = i13;
                i1(i18 -= i3);
                this.g = i2;
                i4 = x1.j(string);
                i1(i4);
                this.g = x1.i(string, this.e, this.g, i4);
                this.h = i8 += i4;
                CodedOutputStream.OutOfSpaceException exc = new CodedOutputStream.OutOfSpaceException(th);
                throw exc;
                exc = this.h;
                int i15 = this.g;
                i15 -= obj2;
                exc -= i15;
                this.h = exc;
                this.g = obj2;
                throw th;
                e0(string, th);
            } catch (com.google.protobuf.x1.d e) {
            } catch (java.lang.ArrayIndexOutOfBoundsException arrayIndexOutOfBounds1) {
            }
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void Y0(int i, int i2) {
            a1(y1.c(i, i2));
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void Z0(int i, int i2) {
            l1(20);
            h1(i, 0);
            i1(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void a(ByteBuffer byteBuffer) {
            m1(byteBuffer);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void a1(int i) {
            l1(5);
            i1(i);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void b(byte[] bArr, int i2, int i3) {
            n1(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void b1(int i, long l2) {
            l1(20);
            h1(i, 0);
            j1(l2);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void c1(long l) {
            l1(10);
            j1(l);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void d0() {
            if (this.g > 0) {
                k1();
            }
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void k0(byte b) {
            if (this.g == this.f) {
                k1();
            }
            d1(b);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void l0(int i, boolean z2) {
            l1(11);
            h1(i, 0);
            d1((byte)z2);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void m1(ByteBuffer byteBuffer) {
            int remaining;
            byte[] bArr;
            int i2;
            int i3;
            int i4;
            int i5;
            int i;
            int obj6;
            remaining = byteBuffer.remaining();
            int i6 = this.f;
            i3 = this.g;
            if (i6 - i3 >= remaining) {
                byteBuffer.get(this.e, i3, remaining);
                this.g = obj6 += remaining;
                this.h = obj6 += remaining;
            } else {
                i6 -= i3;
                byteBuffer.get(this.e, i3, i2);
                remaining -= i2;
                this.g = this.f;
                this.h = i9 += i2;
                k1();
                int i7 = this.f;
                i3 = 0;
                while (remaining > i7) {
                    byteBuffer.get(this.e, i3, i7);
                    this.i.write(this.e, i3, this.f);
                    i2 = this.f;
                    remaining -= i2;
                    this.h = i10 += i2;
                    i7 = this.f;
                    i3 = 0;
                }
                byteBuffer.get(this.e, i3, remaining);
                this.g = remaining;
                this.h = obj6 += remaining;
            }
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void n1(byte[] bArr, int i2, int i3) {
            byte[] bArr2;
            int i;
            int i4;
            int obj4;
            int obj5;
            int obj6;
            int i5 = this.f;
            i = this.g;
            if (i5 - i >= i3) {
                System.arraycopy(bArr, i2, this.e, i, i3);
                this.g = obj4 += i3;
                this.h = obj4 += i3;
            } else {
                i5 -= i;
                System.arraycopy(bArr, i2, this.e, i, i6);
                i2 += i6;
                i3 -= i6;
                this.g = this.f;
                this.h = i9 += i6;
                k1();
                if (obj6 <= this.f) {
                    System.arraycopy(bArr, obj5, this.e, 0, obj6);
                    this.g = obj6;
                } else {
                    this.i.write(bArr, obj5, obj6);
                }
                this.h = obj4 += obj6;
            }
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void o0(byte[] bArr, int i2, int i3) {
            a1(i3);
            n1(bArr, i2, i3);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void o1(int i, com.google.protobuf.t0 t02) {
            Y0(i, 2);
            K0(t02);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void p0(int i, com.google.protobuf.j j2) {
            Y0(i, 2);
            q0(j2);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        void p1(com.google.protobuf.t0 t0, com.google.protobuf.l1 l12) {
            a1((a)t0.getSerializedSize(l12));
            l12.b(t0, this.a);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void q0(com.google.protobuf.j j) {
            a1(j.size());
            j.Y(this);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void v0(int i, int i2) {
            l1(14);
            h1(i, 5);
            e1(i2);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void w0(int i) {
            l1(4);
            e1(i);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void x0(int i, long l2) {
            l1(18);
            h1(i, 1);
            f1(l2);
        }

        @Override // com.google.protobuf.CodedOutputStream$b
        public void y0(long l) {
            l1(8);
            f1(l);
        }
    }
    static {
        CodedOutputStream.c = Logger.getLogger(CodedOutputStream.class.getName());
        CodedOutputStream.d = w1.I();
    }

    CodedOutputStream(com.google.protobuf.CodedOutputStream.a codedOutputStream$a) {
        super();
    }

    public static int A(int i, com.google.protobuf.g0 g02) {
        final int i7 = 2;
        return i5 += obj2;
    }

    public static int B(int i, com.google.protobuf.g0 g02) {
        return obj0 += obj1;
    }

    public static int C(com.google.protobuf.g0 g0) {
        return CodedOutputStream.D(g0.b());
    }

    static int D(int i) {
        return i2 += i;
    }

    public static int E(int i, com.google.protobuf.t0 t02) {
        final int i7 = 2;
        return i5 += obj2;
    }

    public static int F(int i, com.google.protobuf.t0 t02) {
        return obj0 += obj1;
    }

    static int G(int i, com.google.protobuf.t0 t02, com.google.protobuf.l1 l13) {
        return obj0 += obj1;
    }

    public static int H(com.google.protobuf.t0 t0) {
        return CodedOutputStream.D(t0.getSerializedSize());
    }

    static int I(com.google.protobuf.t0 t0, com.google.protobuf.l1 l12) {
        return CodedOutputStream.D((a)t0.getSerializedSize(l12));
    }

    static int J(int i) {
        final int i2 = 4096;
        if (i > i2) {
            return i2;
        }
        return i;
    }

    public static int K(int i, com.google.protobuf.j j2) {
        final int i7 = 2;
        return i5 += obj2;
    }

    @Deprecated
    public static int L(int i) {
        return CodedOutputStream.Y(i);
    }

    public static int M(int i, int i2) {
        return obj0 += obj1;
    }

    public static int N(int i) {
        return 4;
    }

    public static int O(int i, long l2) {
        return obj0 += obj1;
    }

    public static int P(long l) {
        return 8;
    }

    public static int Q(int i, int i2) {
        return obj0 += obj1;
    }

    public static int R(int i) {
        return CodedOutputStream.Y(CodedOutputStream.b0(i));
    }

    public static int S(int i, long l2) {
        return obj0 += obj1;
    }

    public static int T(long l) {
        return CodedOutputStream.a0(CodedOutputStream.c0(l));
    }

    public static int U(int i, String string2) {
        return obj0 += obj1;
    }

    public static int V(String string) {
        java.nio.charset.Charset charset;
        int obj1;
        try {
            obj1 = x1.j(string);
            string = string.getBytes(c0.a);
            string = string.length;
            return CodedOutputStream.D(obj1);
        }
    }

    public static int W(int i) {
        return CodedOutputStream.Y(y1.c(i, 0));
    }

    public static int X(int i, int i2) {
        return obj0 += obj1;
    }

    public static int Y(int i) {
        if (i & -128 == 0) {
            return 1;
        }
        if (i & -16384 == 0) {
            return 2;
        }
        if (i4 &= i == 0) {
            return 3;
        }
        if (i &= i6 == 0) {
            return 4;
        }
        return 5;
    }

    public static int Z(int i, long l2) {
        return obj0 += obj1;
    }

    public static int a0(long l) {
        int i;
        int i2;
        int cmp;
        int obj6;
        final int i6 = 0;
        if (Long.compare(i4, i6) == 0) {
            return 1;
        }
        if (Long.compare(l, i6) < 0) {
            return 10;
        }
        if (Long.compare(i5, i6) != 0) {
            i = 6;
            l >>>= i2;
        } else {
            i = 2;
        }
        if (Long.compare(i8, i6) != 0) {
            i += 2;
            obj6 >>>= cmp;
        }
        if (Long.compare(obj6, i6) != 0) {
            i++;
        }
        return i;
    }

    public static int b0(int i) {
        return obj1 ^= i2;
    }

    static boolean c() {
        return CodedOutputStream.d;
    }

    public static long c0(long l) {
        return obj3 ^= i2;
    }

    public static int e(int i, boolean z2) {
        return obj0 += obj1;
    }

    public static int f(boolean z) {
        return 1;
    }

    public static int g(byte[] bArr) {
        return CodedOutputStream.D(bArr.length);
    }

    public static com.google.protobuf.CodedOutputStream g0(OutputStream outputStream, int i2) {
        CodedOutputStream.d dVar = new CodedOutputStream.d(outputStream, i2);
        return dVar;
    }

    public static int h(int i, com.google.protobuf.j j2) {
        return obj0 += obj1;
    }

    public static com.google.protobuf.CodedOutputStream h0(byte[] bArr) {
        return CodedOutputStream.i0(bArr, 0, bArr.length);
    }

    public static int i(com.google.protobuf.j j) {
        return CodedOutputStream.D(j.size());
    }

    public static com.google.protobuf.CodedOutputStream i0(byte[] bArr, int i2, int i3) {
        CodedOutputStream.c cVar = new CodedOutputStream.c(bArr, i2, i3);
        return cVar;
    }

    public static int j(int i, double d2) {
        return obj0 += obj1;
    }

    public static int k(double d) {
        return 8;
    }

    public static int l(int i, int i2) {
        return obj0 += obj1;
    }

    public static int m(int i) {
        return CodedOutputStream.x(i);
    }

    public static int n(int i, int i2) {
        return obj0 += obj1;
    }

    public static int o(int i) {
        return 4;
    }

    public static int p(int i, long l2) {
        return obj0 += obj1;
    }

    public static int q(long l) {
        return 8;
    }

    public static int r(int i, float f2) {
        return obj0 += obj1;
    }

    public static int s(float f) {
        return 4;
    }

    @Deprecated
    static int t(int i, com.google.protobuf.t0 t02, com.google.protobuf.l1 l13) {
        return obj0 += obj1;
    }

    @Deprecated
    public static int u(com.google.protobuf.t0 t0) {
        return t0.getSerializedSize();
    }

    @Deprecated
    static int v(com.google.protobuf.t0 t0, com.google.protobuf.l1 l12) {
        return (a)t0.getSerializedSize(l12);
    }

    public static int w(int i, int i2) {
        return obj0 += obj1;
    }

    public static int x(int i) {
        if (i >= 0) {
            return CodedOutputStream.Y(i);
        }
        return 10;
    }

    public static int y(int i, long l2) {
        return obj0 += obj1;
    }

    public static int z(long l) {
        return CodedOutputStream.a0(l);
    }

    @Override // com.google.protobuf.i
    public final void A0(float f) {
        w0(Float.floatToRawIntBits(f));
    }

    @Deprecated
    public final void B0(int i, com.google.protobuf.t0 t02) {
        Y0(i, 3);
        D0(t02);
        Y0(i, 4);
    }

    @Deprecated
    final void C0(int i, com.google.protobuf.t0 t02, com.google.protobuf.l1 l13) {
        Y0(i, 3);
        E0(t02, l13);
        Y0(i, 4);
    }

    @Deprecated
    public final void D0(com.google.protobuf.t0 t0) {
        t0.writeTo(this);
    }

    @Deprecated
    final void E0(com.google.protobuf.t0 t0, com.google.protobuf.l1 l12) {
        l12.b(t0, this.a);
    }

    @Override // com.google.protobuf.i
    public abstract void F0(int i, int i2);

    @Override // com.google.protobuf.i
    public abstract void G0(int i);

    @Override // com.google.protobuf.i
    public final void H0(int i, long l2) {
        b1(i, l2);
    }

    @Override // com.google.protobuf.i
    public final void I0(long l) {
        c1(l);
    }

    @Override // com.google.protobuf.i
    abstract void J0(int i, com.google.protobuf.t0 t02, com.google.protobuf.l1 l13);

    @Override // com.google.protobuf.i
    public abstract void K0(com.google.protobuf.t0 t0);

    @Override // com.google.protobuf.i
    public abstract void L0(int i, com.google.protobuf.t0 t02);

    @Override // com.google.protobuf.i
    public abstract void M0(int i, com.google.protobuf.j j2);

    @Deprecated
    public final void N0(int i) {
        a1(i);
    }

    @Override // com.google.protobuf.i
    public final void O0(int i, int i2) {
        v0(i, i2);
    }

    @Override // com.google.protobuf.i
    public final void P0(int i) {
        w0(i);
    }

    @Override // com.google.protobuf.i
    public final void Q0(int i, long l2) {
        x0(i, l2);
    }

    @Override // com.google.protobuf.i
    public final void R0(long l) {
        y0(l);
    }

    @Override // com.google.protobuf.i
    public final void S0(int i, int i2) {
        Z0(i, CodedOutputStream.b0(i2));
    }

    @Override // com.google.protobuf.i
    public final void T0(int i) {
        a1(CodedOutputStream.b0(i));
    }

    @Override // com.google.protobuf.i
    public final void U0(int i, long l2) {
        b1(i, CodedOutputStream.c0(l2));
    }

    @Override // com.google.protobuf.i
    public final void V0(long l) {
        c1(CodedOutputStream.c0(l));
    }

    @Override // com.google.protobuf.i
    public abstract void W0(int i, String string2);

    @Override // com.google.protobuf.i
    public abstract void X0(String string);

    @Override // com.google.protobuf.i
    public abstract void Y0(int i, int i2);

    @Override // com.google.protobuf.i
    public abstract void Z0(int i, int i2);

    @Override // com.google.protobuf.i
    public abstract void a1(int i);

    @Override // com.google.protobuf.i
    public abstract void b1(int i, long l2);

    @Override // com.google.protobuf.i
    public abstract void c1(long l);

    @Override // com.google.protobuf.i
    public final void d() {
        if (j0() != 0) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("Did not write as much data as expected.");
        throw illegalStateException;
    }

    @Override // com.google.protobuf.i
    public abstract void d0();

    @Override // com.google.protobuf.i
    final void e0(String string, com.google.protobuf.x1.d x1$d2) {
        CodedOutputStream.c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", d2);
        final byte[] obj4 = string.getBytes(c0.a);
        a1(obj4.length);
        b(obj4, 0, obj4.length);
    }

    @Override // com.google.protobuf.i
    boolean f0() {
        return this.b;
    }

    @Override // com.google.protobuf.i
    public abstract int j0();

    @Override // com.google.protobuf.i
    public abstract void k0(byte b);

    @Override // com.google.protobuf.i
    public abstract void l0(int i, boolean z2);

    @Override // com.google.protobuf.i
    public final void m0(boolean z) {
        k0((byte)z);
    }

    @Override // com.google.protobuf.i
    public final void n0(byte[] bArr) {
        o0(bArr, 0, bArr.length);
    }

    @Override // com.google.protobuf.i
    abstract void o0(byte[] bArr, int i2, int i3);

    @Override // com.google.protobuf.i
    public abstract void p0(int i, com.google.protobuf.j j2);

    @Override // com.google.protobuf.i
    public abstract void q0(com.google.protobuf.j j);

    @Override // com.google.protobuf.i
    public final void r0(int i, double d2) {
        x0(i, Double.doubleToRawLongBits(d2));
    }

    @Override // com.google.protobuf.i
    public final void s0(double d) {
        y0(Double.doubleToRawLongBits(d));
    }

    @Override // com.google.protobuf.i
    public final void t0(int i, int i2) {
        F0(i, i2);
    }

    @Override // com.google.protobuf.i
    public final void u0(int i) {
        G0(i);
    }

    @Override // com.google.protobuf.i
    public abstract void v0(int i, int i2);

    @Override // com.google.protobuf.i
    public abstract void w0(int i);

    @Override // com.google.protobuf.i
    public abstract void x0(int i, long l2);

    @Override // com.google.protobuf.i
    public abstract void y0(long l);

    @Override // com.google.protobuf.i
    public final void z0(int i, float f2) {
        v0(i, Float.floatToRawIntBits(f2));
    }
}
