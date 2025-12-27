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

/* compiled from: CropImageOptions.java */
/* loaded from: classes2.dex */
public class f implements Parcelable {

    public static final Parcelable.Creator<f> CREATOR = new f$a<>();
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
    public CropImageView.c a;
    public int a0;
    public float b;
    public int b0;
    public float c;
    public CropImageView.j c0;
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
    public CropImageView.d v;
    public CropImageView.k w;
    public boolean x;
    public boolean y;
    public boolean z;

    static class a implements Parcelable.Creator<f> {
        a() {
            super();
        }

        public f a(Parcel parcel) {
            return new f(parcel);
        }

        public f[] b(int i) {
            return new f[i];
        }
    }

    public f() {
        super();
        android.util.DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.a = CropImageView.c.RECTANGLE;
        int i5 = 1;
        float f = 3f;
        this.b = TypedValue.applyDimension(i5, f, displayMetrics);
        this.c = TypedValue.applyDimension(i5, 24f, displayMetrics);
        this.v = CropImageView.d.ON_TOUCH;
        this.w = CropImageView.k.FIT_CENTER;
        this.x = true;
        this.y = true;
        this.z = true;
        int i9 = 0;
        this.B = 4;
        this.C = 0.1f;
        this.E = i5;
        this.F = i5;
        this.G = TypedValue.applyDimension(i5, f, displayMetrics);
        int i6 = 170;
        int i12 = 255;
        this.H = Color.argb(i6, i12, i12, i12);
        this.I = TypedValue.applyDimension(i5, 2f, displayMetrics);
        this.J = TypedValue.applyDimension(i5, 5f, displayMetrics);
        this.K = TypedValue.applyDimension(i5, 14f, displayMetrics);
        int i17 = -1;
        this.L = i17;
        this.M = TypedValue.applyDimension(i5, 1f, displayMetrics);
        this.N = Color.argb(i6, i12, i12, i12);
        this.O = Color.argb(119, i9, i9, i9);
        float f2 = 42f;
        this.P = (int)(TypedValue.applyDimension(i5, f2, displayMetrics));
        this.Q = (int)(TypedValue.applyDimension(i5, f2, displayMetrics));
        int i2 = 40;
        this.R = i2;
        this.S = i2;
        int i3 = 99999;
        this.T = i3;
        this.U = i3;
        this.V = "";
        this.W = i9;
        this.X = Uri.EMPTY;
        this.Y = Bitmap.CompressFormat.JPEG;
        int i4 = 90;
        this.Z = i4;
        this.a0 = i9;
        this.b0 = i9;
        this.c0 = CropImageView.j.NONE;
        Rect rect = null;
        this.e0 = rect;
        this.f0 = i17;
        this.g0 = true;
        this.h0 = true;
        this.j0 = i4;
        this.m0 = rect;
        this.n0 = i9;
    }

    public void a() {
        if (this.B < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1");
        } else {
            float f6 = 0.0f;
            if (this.c < 0.0f) {
                throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
            } else {
                if (this.C < 0.0f) {
                    throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
                } else {
                    double d2 = (double)f;
                    double d = 0.5d;
                    if (d2 < 0.5d) {
                        String str15 = "Cannot set aspect ratio value to a number less than or equal to 0.";
                        if (this.E <= 0) {
                            throw new IllegalArgumentException(str15);
                        } else {
                            if (this.F <= 0) {
                                throw new IllegalArgumentException(str15);
                            } else {
                                if (this.G < 0.0f) {
                                    throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
                                } else {
                                    if (this.I < 0.0f) {
                                        throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
                                    } else {
                                        if (this.M < 0.0f) {
                                            throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
                                        } else {
                                            if (this.Q < 0) {
                                                throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
                                            } else {
                                                if (this.R < 0) {
                                                    throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
                                                } else {
                                                    if (this.S < 0) {
                                                        throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
                                                    } else {
                                                        if (this.T < this.R) {
                                                            throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
                                                        } else {
                                                            if (this.U < this.S) {
                                                                throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
                                                            } else {
                                                                if (this.a0 < 0) {
                                                                    throw new IllegalArgumentException("Cannot set request width value to a number < 0 ");
                                                                } else {
                                                                    if (this.b0 < 0) {
                                                                        throw new IllegalArgumentException("Cannot set request height value to a number < 0 ");
                                                                    } else {
                                                                        if (this.j0 < 0) {
                                                                            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
                                                                        } else {
                                                                            int i = 360;
                                                                            if (this.j0 <= 360) {
                                                                                return;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a.ordinal());
        parcel.writeFloat(this.b);
        parcel.writeFloat(this.c);
        parcel.writeInt(this.v.ordinal());
        parcel.writeInt(this.w.ordinal());
        parcel.writeByte(this.x != 0 ? 1 : 0);
        parcel.writeByte(this.y != 0 ? 1 : 0);
        parcel.writeByte(this.z != 0 ? 1 : 0);
        parcel.writeByte(this.A != 0 ? 1 : 0);
        parcel.writeInt(this.B);
        parcel.writeFloat(this.C);
        parcel.writeByte(this.D != 0 ? 1 : 0);
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
        TextUtils.writeToParcel(this.V, parcel, i);
        parcel.writeInt(this.W);
        parcel.writeParcelable(this.X, i);
        parcel.writeString(this.Y.name());
        parcel.writeInt(this.Z);
        parcel.writeInt(this.a0);
        parcel.writeInt(this.b0);
        parcel.writeInt(this.c0.ordinal());
        parcel.writeInt(this.d0);
        parcel.writeParcelable(this.e0, i);
        parcel.writeInt(this.f0);
        parcel.writeByte(this.g0 != 0 ? 1 : 0);
        parcel.writeByte(this.h0 != 0 ? 1 : 0);
        parcel.writeByte(this.i0 != 0 ? 1 : 0);
        parcel.writeInt(this.j0);
        parcel.writeByte(this.k0 != 0 ? 1 : 0);
        parcel.writeByte(this.l0 != 0 ? 1 : 0);
        TextUtils.writeToParcel(this.m0, parcel, i);
        parcel.writeInt(this.n0);
    }

    protected f(Parcel parcel) {
        int i;
        super();
        this.a = CropImageView.c.values()[parcel.readInt()];
        this.b = parcel.readFloat();
        this.c = parcel.readFloat();
        this.v = CropImageView.d.values()[parcel.readInt()];
        this.w = CropImageView.k.values()[parcel.readInt()];
        i = 1;
        i = 0;
        int r0 = i;
        this.x = i;
        r0 = i;
        this.y = i;
        r0 = i;
        this.z = i;
        this.B = parcel.readInt();
        this.C = parcel.readFloat();
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
        this.e0 = (Rect)parcel.readParcelable(Rect.class.getClassLoader());
        this.f0 = parcel.readInt();
        r0 = i;
        this.g0 = i;
        r0 = i;
        this.h0 = i;
        this.j0 = parcel.readInt();
        this.m0 = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.n0 = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
