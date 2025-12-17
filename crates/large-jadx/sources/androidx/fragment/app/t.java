package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
final class t implements Parcelable {

    public static final Parcelable.Creator<androidx.fragment.app.t> CREATOR;
    final boolean A;
    final Bundle B;
    final boolean C;
    final int D;
    Bundle E;
    final String a;
    final String b;
    final boolean c;
    final int v;
    final int w;
    final String x;
    final boolean y;
    final boolean z;

    class a implements Parcelable.Creator<androidx.fragment.app.t> {
        @Override // android.os.Parcelable$Creator
        public androidx.fragment.app.t a(Parcel parcel) {
            t tVar = new t(parcel);
            return tVar;
        }

        @Override // android.os.Parcelable$Creator
        public androidx.fragment.app.t[] b(int i) {
            return new t[i];
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
        t.a aVar = new t.a();
        t.CREATOR = aVar;
    }

    t(Parcel parcel) {
        int i4;
        int i5;
        int i;
        int i3;
        int i2;
        super();
        this.a = parcel.readString();
        this.b = parcel.readString();
        i2 = 1;
        final int i6 = 0;
        i4 = parcel.readInt() != 0 ? i2 : i6;
        this.c = i4;
        this.v = parcel.readInt();
        this.w = parcel.readInt();
        this.x = parcel.readString();
        i5 = parcel.readInt() != 0 ? i2 : i6;
        this.y = i5;
        i = parcel.readInt() != 0 ? i2 : i6;
        this.z = i;
        i3 = parcel.readInt() != 0 ? i2 : i6;
        this.A = i3;
        this.B = parcel.readBundle();
        if (parcel.readInt() != 0) {
        } else {
            i2 = i6;
        }
        this.C = i2;
        this.E = parcel.readBundle();
        this.D = parcel.readInt();
    }

    t(androidx.fragment.app.Fragment fragment) {
        super();
        this.a = fragment.getClass().getName();
        this.b = fragment.mWho;
        this.c = fragment.mFromLayout;
        this.v = fragment.mFragmentId;
        this.w = fragment.mContainerId;
        this.x = fragment.mTag;
        this.y = fragment.mRetainInstance;
        this.z = fragment.mRemoving;
        this.A = fragment.mDetached;
        this.B = fragment.mArguments;
        this.C = fragment.mHidden;
        this.D = fragment.mMaxState.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public String toString() {
        boolean str5;
        int hexString;
        String empty;
        boolean str4;
        boolean str;
        boolean str2;
        boolean str3;
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentState{");
        stringBuilder.append(this.a);
        stringBuilder.append(" (");
        stringBuilder.append(this.b);
        stringBuilder.append(")}:");
        if (this.c) {
            stringBuilder.append(" fromLayout");
        }
        if (this.w != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.w));
        }
        empty = this.x;
        if (empty != null && !empty.isEmpty()) {
            if (!empty.isEmpty()) {
                stringBuilder.append(" tag=");
                stringBuilder.append(this.x);
            }
        }
        if (this.y) {
            stringBuilder.append(" retainInstance");
        }
        if (this.z) {
            stringBuilder.append(" removing");
        }
        if (this.A) {
            stringBuilder.append(" detached");
        }
        if (this.C) {
            stringBuilder.append(" hidden");
        }
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.v);
        parcel.writeInt(this.w);
        parcel.writeString(this.x);
        parcel.writeInt(this.y);
        parcel.writeInt(this.z);
        parcel.writeInt(this.A);
        parcel.writeBundle(this.B);
        parcel.writeInt(this.C);
        parcel.writeBundle(this.E);
        parcel.writeInt(this.D);
    }
}
