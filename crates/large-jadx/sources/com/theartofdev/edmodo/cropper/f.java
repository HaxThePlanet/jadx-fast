package com.theartofdev.edmodo.cropper;

import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.TypedValue;

/* loaded from: classes2.dex */
public class f implements Parcelable {

    public static final Parcelable.Creator<com.theartofdev.edmodo.cropper.f> CREATOR;
    public boolean A = false;
    public int B;
    public float C;
    public boolean D = false;
    public int E;
    public int F;
    public float G;
    public int H;
    public float I;
    public float J;
    public float K;
    public int L;
    public float M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public int U;
    public java.lang.CharSequence V;
    public int W;
    public Uri X;
    public Bitmap.CompressFormat Y;
    public int Z;
    public com.theartofdev.edmodo.cropper.CropImageView.c a;
    public int a0;
    public float b;
    public int b0;
    public float c;
    public com.theartofdev.edmodo.cropper.CropImageView.j c0;
    public boolean d0 = false;
    public Rect e0;
    public int f0;
    public boolean g0;
    public boolean h0;
    public boolean i0 = false;
    public int j0;
    public boolean k0 = false;
    public boolean l0 = false;
    public java.lang.CharSequence m0;
    public int n0;
    public com.theartofdev.edmodo.cropper.CropImageView.d v;
    public com.theartofdev.edmodo.cropper.CropImageView.k w;
    public boolean x;
    public boolean y;
    public boolean z;

    static class a implements Parcelable.Creator<com.theartofdev.edmodo.cropper.f> {
        @Override // android.os.Parcelable$Creator
        public com.theartofdev.edmodo.cropper.f a(Parcel parcel) {
            f fVar = new f(parcel);
            return fVar;
        }

        @Override // android.os.Parcelable$Creator
        public com.theartofdev.edmodo.cropper.f[] b(int i) {
            return new f[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        f.a aVar = new f.a();
        f.CREATOR = aVar;
    }

    public f() {
        super();
        android.util.DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.a = CropImageView.c.RECTANGLE;
        int i5 = 1;
        int i6 = 1077936128;
        this.b = TypedValue.applyDimension(i5, i6, displayMetrics);
        this.c = TypedValue.applyDimension(i5, 1103101952, displayMetrics);
        this.v = CropImageView.d.ON_TOUCH;
        this.w = CropImageView.k.FIT_CENTER;
        this.x = i5;
        this.y = i5;
        this.z = i5;
        int i12 = 0;
        this.B = 4;
        this.C = 1036831949;
        this.E = i5;
        this.F = i5;
        this.G = TypedValue.applyDimension(i5, i6, displayMetrics);
        int i7 = 170;
        int i15 = 255;
        this.H = Color.argb(i7, i15, i15, i15);
        this.I = TypedValue.applyDimension(i5, 1073741824, displayMetrics);
        this.J = TypedValue.applyDimension(i5, 1084227584, displayMetrics);
        this.K = TypedValue.applyDimension(i5, 1096810496, displayMetrics);
        int i20 = -1;
        this.L = i20;
        this.M = TypedValue.applyDimension(i5, 1065353216, displayMetrics);
        this.N = Color.argb(i7, i15, i15, i15);
        this.O = Color.argb(119, i12, i12, i12);
        int i9 = 1109917696;
        this.P = (int)dimension5;
        this.Q = (int)dimension;
        int i2 = 40;
        this.R = i2;
        this.S = i2;
        int i3 = 99999;
        this.T = i3;
        this.U = i3;
        this.V = "";
        this.W = i12;
        this.X = Uri.EMPTY;
        this.Y = Bitmap.CompressFormat.JPEG;
        int i4 = 90;
        this.Z = i4;
        this.a0 = i12;
        this.b0 = i12;
        this.c0 = CropImageView.j.NONE;
        int i10 = 0;
        this.e0 = i10;
        this.f0 = i20;
        this.g0 = i5;
        this.h0 = i5;
        this.j0 = i4;
        this.m0 = i10;
        this.n0 = i12;
    }

    protected f(Parcel parcel) {
        int i;
        int i4;
        int i5;
        int i2;
        int i3;
        super();
        this.a = CropImageView.c.values()[parcel.readInt()];
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.v = CropImageView.d.values()[parcel.readInt()];
        this.w = CropImageView.k.values()[parcel.readInt()];
        int i16 = 1;
        final int i18 = 0;
        i = parcel.readByte() != 0 ? i16 : i18;
        this.x = i;
        i4 = parcel.readByte() != 0 ? i16 : i18;
        this.y = i4;
        i5 = parcel.readByte() != 0 ? i16 : i18;
        this.z = i5;
        int i15 = parcel.readByte() != 0 ? i16 : i15;
        int i6 = i18;
        this.B = parcel.readInt();
        this.C = parcel.readFloat();
        int i7 = parcel.readByte() != 0 ? i16 : i7;
        int i8 = i18;
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readFloat();
        this.H = parcel.readInt();
        this.I = parcel.readFloat();
        this.J = parcel.readFloat();
        this.K = parcel.readFloat();
        this.L = parcel.readInt();
        this.M = parcel.readFloat();
        this.N = parcel.readInt();
        this.O = parcel.readInt();
        this.P = parcel.readInt();
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.S = parcel.readInt();
        this.T = parcel.readInt();
        this.U = parcel.readInt();
        this.V = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.W = parcel.readInt();
        this.X = (Uri)parcel.readParcelable(Uri.class.getClassLoader());
        this.Y = Bitmap.CompressFormat.valueOf(parcel.readString());
        this.Z = parcel.readInt();
        this.a0 = parcel.readInt();
        this.b0 = parcel.readInt();
        this.c0 = CropImageView.j.values()[parcel.readInt()];
        int i9 = parcel.readByte() != 0 ? i16 : i9;
        int i10 = i18;
        this.e0 = (Rect)parcel.readParcelable(Rect.class.getClassLoader());
        this.f0 = parcel.readInt();
        i2 = parcel.readByte() != 0 ? i16 : i18;
        this.g0 = i2;
        i3 = parcel.readByte() != 0 ? i16 : i18;
        this.h0 = i3;
        int i11 = parcel.readByte() != 0 ? i16 : i11;
        int i12 = i18;
        this.j0 = parcel.readInt();
        int i14 = parcel.readByte() != 0 ? i16 : i14;
        int i13 = i18;
        if (parcel.readByte() != 0) {
        }
        int i17 = i18;
        this.m0 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.n0 = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void a() {
        float cmp;
        int i;
        int cmp2;
        long l;
        if (this.B < 0) {
        } else {
            int i11 = 0;
            if (Float.compare(f, i11) < 0) {
            } else {
                cmp = this.C;
                if (Float.compare(cmp, i11) < 0) {
                } else {
                    if (Double.compare(cmp2, l) >= 0) {
                    } else {
                        String str15 = "Cannot set aspect ratio value to a number less than or equal to 0.";
                        if (this.E <= 0) {
                        } else {
                            if (this.F <= 0) {
                            } else {
                                if (Float.compare(f2, i11) < 0) {
                                } else {
                                    if (Float.compare(f3, i11) < 0) {
                                    } else {
                                        if (Float.compare(f4, i11) < 0) {
                                        } else {
                                            if (this.Q < 0) {
                                            } else {
                                                int i6 = this.R;
                                                if (i6 < 0) {
                                                } else {
                                                    i = this.S;
                                                    if (i < 0) {
                                                    } else {
                                                        if (this.T < i6) {
                                                        } else {
                                                            if (this.U < i) {
                                                            } else {
                                                                if (this.a0 < 0) {
                                                                } else {
                                                                    if (this.b0 < 0) {
                                                                    } else {
                                                                        int i10 = this.j0;
                                                                        if (i10 < 0) {
                                                                        } else {
                                                                            if (i10 > 360) {
                                                                            } else {
                                                                            }
                                                                        }
                                                                        IllegalArgumentException illegalArgumentException9 = new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
                                                                        throw illegalArgumentException9;
                                                                    }
                                                                    IllegalArgumentException illegalArgumentException8 = new IllegalArgumentException("Cannot set request height value to a number < 0 ");
                                                                    throw illegalArgumentException8;
                                                                }
                                                                IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException("Cannot set request width value to a number < 0 ");
                                                                throw illegalArgumentException10;
                                                            }
                                                            IllegalArgumentException illegalArgumentException7 = new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
                                                            throw illegalArgumentException7;
                                                        }
                                                        IllegalArgumentException illegalArgumentException6 = new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
                                                        throw illegalArgumentException6;
                                                    }
                                                    IllegalArgumentException illegalArgumentException11 = new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
                                                    throw illegalArgumentException11;
                                                }
                                                IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
                                                throw illegalArgumentException5;
                                            }
                                            IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
                                            throw illegalArgumentException4;
                                        }
                                        IllegalArgumentException illegalArgumentException12 = new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
                                        throw illegalArgumentException12;
                                    }
                                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
                                    throw illegalArgumentException3;
                                }
                                IllegalArgumentException illegalArgumentException13 = new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
                                throw illegalArgumentException13;
                            }
                            IllegalArgumentException illegalArgumentException14 = new IllegalArgumentException(str15);
                            throw illegalArgumentException14;
                        }
                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(str15);
                        throw illegalArgumentException2;
                    }
                }
                IllegalArgumentException illegalArgumentException15 = new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
                throw illegalArgumentException15;
            }
            IllegalArgumentException illegalArgumentException16 = new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
            throw illegalArgumentException16;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot set max zoom to a number < 1");
        throw illegalArgumentException;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a.ordinal());
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.v.ordinal());
        parcel.writeInt(this.w.ordinal());
        parcel.writeByte((byte)z);
        parcel.writeByte((byte)z2);
        parcel.writeByte((byte)z3);
        parcel.writeByte((byte)z4);
        parcel.writeInt(this.B);
        parcel.writeFloat(this.C);
        parcel.writeByte((byte)z5);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeFloat(this.G);
        parcel.writeInt(this.H);
        parcel.writeFloat(this.I);
        parcel.writeFloat(this.J);
        parcel.writeFloat(this.K);
        parcel.writeInt(this.L);
        parcel.writeFloat(this.M);
        parcel.writeInt(this.N);
        parcel.writeInt(this.O);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        parcel.writeInt(this.S);
        parcel.writeInt(this.T);
        parcel.writeInt(this.U);
        TextUtils.writeToParcel(this.V, parcel, i2);
        parcel.writeInt(this.W);
        parcel.writeParcelable(this.X, i2);
        parcel.writeString(this.Y.name());
        parcel.writeInt(this.Z);
        parcel.writeInt(this.a0);
        parcel.writeInt(this.b0);
        parcel.writeInt(this.c0.ordinal());
        parcel.writeInt(this.d0);
        parcel.writeParcelable(this.e0, i2);
        parcel.writeInt(this.f0);
        parcel.writeByte((byte)z7);
        parcel.writeByte((byte)z8);
        parcel.writeByte((byte)z9);
        parcel.writeInt(this.j0);
        parcel.writeByte((byte)z10);
        parcel.writeByte((byte)z11);
        TextUtils.writeToParcel(this.m0, parcel, i2);
        parcel.writeInt(this.n0);
    }
}
