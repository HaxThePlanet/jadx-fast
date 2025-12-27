package com.squareup.moshi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: JsonValueWriter.java */
/* loaded from: classes2.dex */
final class n extends o {

    Object[] B;
    private String C;
    n() {
        super();
        this.B = new Object[32];
        w(6);
    }

    private n T(Object object) {
        boolean z;
        int i2;
        int i3 = 3;
        int i = q();
        int i5 = 1;
        if (this.a == i5 && i == 6) {
            i3 = i2 - 1;
            int i4 = 7;
            this.b[i3] = i4;
            i2 = i2 - i5;
            this.B[i2] = object;
            return this;
        }
        i3 = 3;
        if (i == 3 && this.C != null) {
            if (object != null || this.y) {
                i2 = i2 - i5;
                Object obj3 = (Map)this.B[i2].put(this.C, object);
                if (obj3 == null) {
                    String str = null;
                    this.C = str;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str7 = "Map key '";
            String str9 = "' has multiple values at path ";
            String path = getPath();
            String str10 = ": ";
            String str5 = " and ";
            object = str7 + this.C + str9 + path + str10 + obj3 + str5 + object;
            throw new IllegalArgumentException(object);
        }
        if (i == i5) {
            i2 = i2 - i5;
            (List)this.B[i2].add(object);
        }
        if (i == 9) {
            throw new IllegalStateException("Sink from valueSink() was not closed");
        }
        throw new IllegalStateException("Nesting problem.");
    }

    @Override // com.squareup.moshi.o
    public o H(double d) {
        if (!this.x) {
            if (Double.isNaN(d)) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "Numeric values must be finite, but was ";
                d = str + d;
                throw new IllegalArgumentException(d);
            }
        }
        if (this.z) {
            this.z = false;
            m(Double.toString(d));
            return this;
        }
        T(Double.valueOf(d));
        int i5 = this.a - 1;
        this.v[i5] = iArr[i5] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o J(long j) {
        if (this.z) {
            this.z = false;
            m(Long.toString(j));
            return this;
        }
        T(Long.valueOf(j));
        int i5 = this.a - 1;
        this.v[i5] = iArr[i5] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o K(Number number) {
        BigDecimal bigDecimal;
        z = number instanceof Byte;
        if (!(number instanceof Byte)) {
            z = number instanceof Short;
            if (!(number instanceof Short)) {
                z = number instanceof Integer;
                if (!(number instanceof Integer)) {
                    z = number instanceof Long;
                    if (!(number instanceof ong)) {
                        z2 = number instanceof Float;
                        if (!(number instanceof Float)) {
                            z2 = number instanceof Double;
                            if (!(number instanceof Double)) {
                                if (number == null) {
                                    n();
                                    return this;
                                }
                                z3 = number instanceof BigDecimal;
                                if (number instanceof BigDecimal) {
                                } else {
                                }
                                if (this.z) {
                                    this.z = false;
                                    m(bigDecimal.toString());
                                    return this;
                                }
                            }
                            T(bigDecimal);
                            int i3 = this.a - 1;
                            this.v[i3] = iArr[i3] + 1;
                            return this;
                        }
                    }
                    H(number.doubleValue());
                    return this;
                }
            }
        }
        J(number.longValue());
        return this;
    }

    @Override // com.squareup.moshi.o
    public o L(String str) {
        if (this.z) {
            this.z = false;
            m(str);
            return this;
        }
        T(str);
        int i3 = this.a - 1;
        this.v[i3] = iArr[i3] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o M(boolean z) {
        if (this.z) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Boolean cannot be used as a map key in JSON at path ";
            String path = getPath();
            r0 = str + path;
            throw new IllegalStateException(r0);
        } else {
            T(Boolean.valueOf(z));
            int i2 = this.a - 1;
            this.v[i2] = iArr[i2] + 1;
            return this;
        }
    }

    @Override // com.squareup.moshi.o
    public o a() {
        if (this.z) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Array cannot be used as a map key in JSON at path ";
            String path = getPath();
            r1 = str + path;
            throw new IllegalStateException(r1);
        } else {
            int i6 = 1;
            if (this.a == this.A) {
                if (this.b[i - i6] == i6) {
                    this.A = ~i4;
                    return this;
                }
            }
            e();
            ArrayList arrayList = new ArrayList();
            T(arrayList);
            this.B[this.a] = arrayList;
            this.v[this.a] = 0;
            w(i6);
            return this;
        }
    }

    @Override // com.squareup.moshi.o
    public o c() {
        if (this.z) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Object cannot be used as a map key in JSON at path ";
            String path = getPath();
            r1 = str + path;
            throw new IllegalStateException(r1);
        } else {
            int i5 = 3;
            if (this.a == this.A) {
                if (this.b[i - 1] == i5) {
                    this.A = ~i4;
                    return this;
                }
            }
            e();
            com.squareup.moshi.p pVar = new p();
            T(pVar);
            this.B[this.a] = pVar;
            w(i5);
            return this;
        }
    }

    @Override // com.squareup.moshi.o
    public void close() throws IOException {
        int i2 = 1;
        if (this.a > i2) {
            throw new IOException("Incomplete document");
        } else {
            this.a = 0;
            return;
        }
    }

    @Override // com.squareup.moshi.o
    public o f() {
        int i6 = 1;
        if (q() != i6) {
            throw new IllegalStateException("Nesting problem.");
        } else {
            if (this.a == ~i7) {
                this.A = ~i7;
                return this;
            }
            this.a -= i6;
            this.B[i3] = 0;
            int i4 = i3 - i6;
            this.v[i4] = iArr[i4] + i6;
            return this;
        }
    }

    @Override // com.squareup.moshi.o
    public void flush() {
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    @Override // com.squareup.moshi.o
    public o i() {
        if (q() != 3) {
            throw new IllegalStateException("Nesting problem.");
        } else {
            if (this.C != null) {
                StringBuilder stringBuilder = new StringBuilder();
                String str3 = "Dangling name: ";
                r1 = str3 + this.C;
                throw new IllegalStateException(r1);
            } else {
                if (this.a == ~i7) {
                    this.A = ~i7;
                    return this;
                }
                this.z = false;
                this.a--;
                Object obj = null;
                this.B[i4] = obj;
                this.c[i4] = obj;
                int i5 = i4 - 1;
                this.v[i5] = iArr[i5] + 1;
                return this;
            }
        }
    }

    @Override // com.squareup.moshi.o
    public o m(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            if (q() != 3) {
                throw new IllegalStateException("Nesting problem.");
            } else {
                if (this.C == null) {
                    if (!this.z) {
                        this.C = str;
                        this.c[this.a - 1] = str;
                        return this;
                    }
                }
            }
        }
    }

    @Override // com.squareup.moshi.o
    public o n() {
        if (this.z) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "null cannot be used as a map key in JSON at path ";
            String path = getPath();
            r1 = str + path;
            throw new IllegalStateException(r1);
        } else {
            T(null);
            int i3 = this.a - 1;
            this.v[i3] = iArr[i3] + 1;
            return this;
        }
    }
}
