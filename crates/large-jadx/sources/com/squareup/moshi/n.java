package com.squareup.moshi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes2.dex */
final class n extends com.squareup.moshi.o {

    Object[] B;
    private String C;
    n() {
        super();
        this.B = new Object[32];
        w(6);
    }

    private com.squareup.moshi.n T(Object object) {
        boolean i3;
        int i2;
        int i;
        int i4;
        Object obj6;
        i3 = q();
        i2 = this.a;
        int i5 = 1;
        if (i2 == i5) {
            if (i3 != 6) {
            } else {
                this.b[i2 + -1] = 7;
                this.B[i2 -= i5] = object;
                return this;
            }
            obj6 = new IllegalStateException("JSON must have only one top-level value.");
            throw obj6;
        }
        i = this.C;
        if (i3 == 3 && i != null) {
            i = this.C;
            if (i != null) {
                if (object == null) {
                    if (this.y) {
                        i3 = (Map)this.B[i2 -= i5].put(i, object);
                        if (i3 != null) {
                        } else {
                        }
                    }
                    this.C = 0;
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Map key '");
                stringBuilder.append(this.C);
                stringBuilder.append("' has multiple values at path ");
                stringBuilder.append(getPath());
                stringBuilder.append(": ");
                stringBuilder.append(i3);
                stringBuilder.append(" and ");
                stringBuilder.append(object);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
        }
        if (i3 == i5) {
            (List)this.B[i2 -= i5].add(object);
        }
        if (i3 == 9) {
            obj6 = new IllegalStateException("Sink from valueSink() was not closed");
            throw obj6;
        }
        obj6 = new IllegalStateException("Nesting problem.");
        throw obj6;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o H(double d) {
        boolean naN;
        if (!this.x) {
            if (Double.isNaN(d)) {
            } else {
                if (Double.compare(d, l) == 0) {
                } else {
                    if (Double.compare(d, l2) == 0) {
                    } else {
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Numeric values must be finite, but was ");
            stringBuilder.append(d);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        if (this.z) {
            this.z = false;
            m(Double.toString(d));
            return this;
        }
        T(Double.valueOf(d));
        int[] obj4 = this.v;
        obj5--;
        obj4[obj5] = i2++;
        return this;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o J(long l) {
        if (this.z) {
            this.z = false;
            m(Long.toString(l));
            return this;
        }
        T(Long.valueOf(l));
        int[] obj2 = this.v;
        obj3--;
        obj2[obj3] = i2++;
        return this;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o K(Number number) {
        boolean z;
        boolean bigDecimal;
        boolean z2;
        Object obj3;
        if (!number instanceof Byte && !number instanceof Short && !number instanceof Integer) {
            if (!number instanceof Short) {
                if (!number instanceof Integer) {
                    if (number instanceof Long) {
                    } else {
                        if (!number instanceof Float) {
                            if (number instanceof Double) {
                            } else {
                                if (number == null) {
                                    n();
                                    return this;
                                }
                                if (number instanceof BigDecimal) {
                                } else {
                                    bigDecimal = new BigDecimal((BigDecimal)number.toString());
                                    obj3 = bigDecimal;
                                }
                                if (this.z) {
                                    this.z = false;
                                    m(obj3.toString());
                                    return this;
                                }
                            }
                            T(obj3);
                            obj3 = this.v;
                            i2--;
                            obj3[i3] = i4++;
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
    public com.squareup.moshi.o L(String string) {
        if (this.z) {
            this.z = false;
            m(string);
            return this;
        }
        T(string);
        final int[] obj3 = this.v;
        i2--;
        obj3[i3] = i4++;
        return this;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o M(boolean z) {
        if (this.z) {
        } else {
            T(Boolean.valueOf(z));
            int[] obj3 = this.v;
            i--;
            obj3[i2] = i3++;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Boolean cannot be used as a map key in JSON at path ");
        stringBuilder.append(getPath());
        obj3 = new IllegalStateException(stringBuilder.toString());
        throw obj3;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o a() {
        int i;
        int[] iArr;
        if (this.z) {
        } else {
            i = this.a;
            int i4 = this.A;
            int i6 = 1;
            if (i == i4 && this.b[i -= i6] == i6) {
                if (this.b[i -= i6] == i6) {
                    this.A = ~i4;
                    return this;
                }
            }
            e();
            ArrayList arrayList = new ArrayList();
            T(arrayList);
            int i7 = this.a;
            this.B[i7] = arrayList;
            this.v[i7] = 0;
            w(i6);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Array cannot be used as a map key in JSON at path ");
        stringBuilder.append(getPath());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o c() {
        int i;
        int[] iArr;
        if (this.z) {
        } else {
            i = this.a;
            int i4 = this.A;
            int i5 = 3;
            if (i == i4 && this.b[i--] == i5) {
                if (this.b[i--] == i5) {
                    this.A = ~i4;
                    return this;
                }
            }
            e();
            p pVar = new p();
            T(pVar);
            this.B[this.a] = pVar;
            w(i5);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Object cannot be used as a map key in JSON at path ");
        stringBuilder.append(getPath());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // com.squareup.moshi.o
    public void close() {
        int i;
        int i2;
        int[] iArr;
        i = this.a;
        i2 = 1;
        if (i > i2) {
        } else {
            if (i == i2) {
                if (this.b[i -= i2] != 7) {
                } else {
                }
            }
            this.a = 0;
        }
        IOException iOException = new IOException("Incomplete document");
        throw iOException;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o f() {
        int i6 = 1;
        if (q() != i6) {
        } else {
            int i2 = this.a;
            int i7 = this.A;
            if (i2 == ~i7) {
                this.A = ~i7;
                return this;
            }
            i2 -= i6;
            this.a = i3;
            this.B[i3] = 0;
            int[] iArr = this.v;
            i3 -= i6;
            iArr[i4] = i10 += i6;
            return this;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Nesting problem.");
        throw illegalStateException;
    }

    @Override // com.squareup.moshi.o
    public void flush() {
        if (this.a == 0) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("JsonWriter is closed.");
        throw illegalStateException;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o i() {
        if (q() != 3) {
        } else {
            if (this.C != null) {
            } else {
                int i2 = this.a;
                int i7 = this.A;
                if (i2 == ~i7) {
                    this.A = ~i7;
                    return this;
                }
                this.z = false;
                i2--;
                this.a = i4;
                int i10 = 0;
                this.B[i4] = i10;
                this.c[i4] = i10;
                int[] iArr = this.v;
                i4--;
                iArr[i5] = i11++;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Dangling name: ");
            stringBuilder.append(this.C);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        IllegalStateException illegalStateException2 = new IllegalStateException("Nesting problem.");
        throw illegalStateException2;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o m(String string) {
        int i;
        Objects.requireNonNull(string, "name == null");
        if (this.a == 0) {
        } else {
            if (q() != 3) {
            } else {
                if (this.C != null) {
                } else {
                    if (this.z) {
                    } else {
                        this.C = string;
                        this.c[i4--] = string;
                        return this;
                    }
                }
            }
            IllegalStateException obj3 = new IllegalStateException("Nesting problem.");
            throw obj3;
        }
        obj3 = new IllegalStateException("JsonWriter is closed.");
        throw obj3;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o n() {
        if (this.z) {
        } else {
            T(0);
            int[] iArr = this.v;
            i2--;
            iArr[i3] = i4++;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("null cannot be used as a map key in JSON at path ");
        stringBuilder.append(getPath());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }
}
