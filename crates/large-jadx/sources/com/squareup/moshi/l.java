package com.squareup.moshi;

import java.io.IOException;
import java.util.Objects;
import l.b0;
import l.g;

/* loaded from: classes2.dex */
final class l extends com.squareup.moshi.o {

    private static final String[] E;
    private final g B;
    private String C;
    private String D;
    static {
        int i;
        String[] strArr;
        String format;
        String str;
        l.E = new String[128];
        int i3 = 0;
        i = i3;
        while (i <= 31) {
            Object[] arr = new Object[1];
            arr[i3] = Integer.valueOf(i);
            l.E[i] = String.format("\\u%04x", arr);
            i++;
        }
        String[] strArr3 = l.E;
        strArr3[34] = "\\\"";
        strArr3[92] = "\\\\";
        strArr3[9] = "\\t";
        strArr3[8] = "\\b";
        strArr3[10] = "\\n";
        strArr3[13] = "\\r";
        strArr3[12] = "\\f";
    }

    l(g g) {
        super();
        this.C = ":";
        Objects.requireNonNull(g, "sink == null");
        this.B = g;
        w(6);
    }

    private void T() {
        g i;
        int i2;
        i = q();
        if (i == 5) {
            this.B.c0(44);
            Y();
            x(4);
        } else {
            if (i != 3) {
            } else {
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("Nesting problem.");
        throw illegalStateException;
    }

    private void U() {
        g i2;
        String i3;
        int i;
        i2 = q();
        final int i6 = 2;
        if (i2 != 1) {
            if (i2 != i6) {
                if (i2 != 4) {
                    if (i2 == 9) {
                    } else {
                        if (i2 != 6) {
                            if (i2 != 7) {
                            } else {
                                if (!this.x) {
                                } else {
                                }
                                IllegalStateException illegalStateException = new IllegalStateException("JSON must have only one top-level value.");
                                throw illegalStateException;
                            }
                            IllegalStateException illegalStateException2 = new IllegalStateException("Nesting problem.");
                            throw illegalStateException2;
                        }
                    }
                    IllegalStateException illegalStateException3 = new IllegalStateException("Sink from valueSink() was not closed");
                    throw illegalStateException3;
                }
                i = 5;
                this.B.E0(this.C);
            } else {
                this.B.c0(44);
                Y();
                i = i6;
            }
        } else {
        }
        x(i);
    }

    private com.squareup.moshi.o V(int i, int i2, char c3) {
        final int i3 = q();
        if (i3 != i2) {
            if (i3 != i) {
            } else {
            }
            IllegalStateException obj4 = new IllegalStateException("Nesting problem.");
            throw obj4;
        }
        if (this.D != null) {
        } else {
            obj4 = this.a;
            int i4 = this.A;
            if (obj4 == ~i4) {
                this.A = ~i4;
                return this;
            }
            obj4--;
            this.a = obj4;
            this.c[obj4] = 0;
            int[] iArr = this.v;
            obj4--;
            iArr[obj4] = i7++;
            if (i3 == i2) {
                Y();
            }
            this.B.c0(c3);
            return this;
        }
        StringBuilder obj5 = new StringBuilder();
        obj5.append("Dangling name: ");
        obj5.append(this.D);
        obj4 = new IllegalStateException(obj5.toString());
        throw obj4;
    }

    private void Y() {
        int i;
        g gVar;
        String str;
        if (this.w == null) {
        }
        this.B.c0(10);
        i = 1;
        while (i < this.a) {
            this.B.E0(this.w);
            i++;
        }
    }

    private com.squareup.moshi.o e0(int i, int i2, char c3) {
        int i3;
        int[] iArr;
        int i4;
        i3 = this.a;
        final int i7 = this.A;
        iArr = this.b;
        if (i3 == i7 && iArr[i3 + -1] != i && iArr[i3--] == i2) {
            iArr = this.b;
            if (iArr[i3 + -1] != i) {
                if (iArr[i3--] == i2) {
                }
            }
            this.A = ~i7;
            return this;
        }
        U();
        e();
        w(i);
        this.v[obj6--] = 0;
        this.B.c0(c3);
        return this;
    }

    static void g0(g g, String string2) {
        int i;
        int i2;
        String charAt;
        int i3;
        final int i4 = 34;
        g.c0(i4);
        final int length = string2.length();
        i2 = i;
        while (i < length) {
            charAt = string2.charAt(i);
            if (charAt < 128) {
            } else {
            }
            if (charAt == 8232) {
            } else {
            }
            if (charAt == 8233) {
            }
            i++;
            charAt = "\\u2029";
            if (i2 < i) {
            }
            g.E0(charAt);
            i2 = i + 1;
            g.U0(string2, i2, i);
            charAt = "\\u2028";
            if (l.E[charAt] == null) {
            } else {
            }
        }
        if (i2 < length) {
            g.U0(string2, i2, length);
        }
        g.c0(i4);
    }

    private void j0() {
        String str;
        String str2;
        if (this.D != null) {
            T();
            l.g0(this.B, this.D);
            this.D = 0;
        }
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o H(double d) {
        boolean naN;
        if (!this.x) {
            if (Double.isNaN(d)) {
            } else {
                if (Double.isInfinite(d)) {
                } else {
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
        j0();
        U();
        this.B.E0(Double.toString(d));
        int[] obj4 = this.v;
        obj5--;
        obj4[obj5] = i++;
        return this;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o J(long l) {
        if (this.z) {
            this.z = false;
            m(Long.toString(l));
            return this;
        }
        j0();
        U();
        this.B.E0(Long.toString(l));
        int[] obj2 = this.v;
        obj3--;
        obj2[obj3] = i2++;
        return this;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o K(Number number) {
        boolean equals;
        if (number == null) {
            n();
            return this;
        }
        String string = number.toString();
        if (!this.x) {
            if (string.equals("-Infinity")) {
            } else {
                if (string.equals("Infinity")) {
                } else {
                    if (string.equals("NaN")) {
                    } else {
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Numeric values must be finite, but was ");
            stringBuilder.append(number);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        if (this.z) {
            this.z = false;
            m(string);
            return this;
        }
        j0();
        U();
        this.B.E0(string);
        int[] obj4 = this.v;
        i--;
        obj4[i2] = i3++;
        return this;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o L(String string) {
        if (string == null) {
            n();
            return this;
        }
        if (this.z) {
            this.z = false;
            m(string);
            return this;
        }
        j0();
        U();
        l.g0(this.B, string);
        final int[] obj3 = this.v;
        i2--;
        obj3[i3] = i4++;
        return this;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o M(boolean z) {
        String obj3;
        if (this.z) {
        } else {
            j0();
            U();
            obj3 = z ? "true" : "false";
            this.B.E0(obj3);
            obj3 = this.v;
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
        if (this.z) {
        } else {
            j0();
            e0(1, 2, '[');
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
        if (this.z) {
        } else {
            j0();
            e0(3, 5, '{');
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
        int i2;
        int i;
        int[] iArr;
        this.B.close();
        i2 = this.a;
        i = 1;
        if (i2 > i) {
        } else {
            if (i2 == i) {
                if (this.b[i2 -= i] != 7) {
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
        V(1, 2, ']');
        return this;
    }

    @Override // com.squareup.moshi.o
    public void flush() {
        if (this.a == 0) {
        } else {
            this.B.flush();
        }
        IllegalStateException illegalStateException = new IllegalStateException("JsonWriter is closed.");
        throw illegalStateException;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o i() {
        this.z = false;
        V(3, 5, '}');
        return this;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o m(String string) {
        String i2;
        int i;
        Objects.requireNonNull(string, "name == null");
        if (this.a == 0) {
        } else {
            i2 = q();
            if (i2 != 3 && i2 == 5) {
                if (i2 != 5) {
                } else {
                    if (this.D != null) {
                    } else {
                        if (this.z) {
                        } else {
                            this.D = string;
                            this.c[i4--] = string;
                            return this;
                        }
                    }
                }
            } else {
            }
            IllegalStateException obj3 = new IllegalStateException("Nesting problem.");
            throw obj3;
        }
        obj3 = new IllegalStateException("JsonWriter is closed.");
        throw obj3;
    }

    @Override // com.squareup.moshi.o
    public com.squareup.moshi.o n() {
        String str;
        if (this.z) {
        } else {
            if (this.D != null && this.y) {
                if (this.y) {
                    j0();
                }
                this.D = 0;
                return this;
            }
            U();
            this.B.E0("null");
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
