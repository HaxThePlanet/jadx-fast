package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class p implements Parcelable {

    public static final Parcelable.Creator<androidx.fragment.app.p> CREATOR;
    ArrayList<androidx.fragment.app.t> a;
    ArrayList<String> b;
    androidx.fragment.app.b[] c;
    int v;
    String w = null;
    ArrayList<String> x;
    ArrayList<Bundle> y;
    ArrayList<androidx.fragment.app.n.n> z;

    class a implements Parcelable.Creator<androidx.fragment.app.p> {
        @Override // android.os.Parcelable$Creator
        public androidx.fragment.app.p a(Parcel parcel) {
            p pVar = new p(parcel);
            return pVar;
        }

        @Override // android.os.Parcelable$Creator
        public androidx.fragment.app.p[] b(int i) {
            return new p[i];
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
        p.a aVar = new p.a();
        p.CREATOR = aVar;
    }

    public p() {
        super();
        int i = 0;
        ArrayList arrayList = new ArrayList();
        this.x = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.y = arrayList2;
    }

    public p(Parcel parcel) {
        super();
        int i = 0;
        ArrayList arrayList = new ArrayList();
        this.x = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.y = arrayList2;
        this.a = parcel.createTypedArrayList(t.CREATOR);
        this.b = parcel.createStringArrayList();
        this.c = (b[])parcel.createTypedArray(b.CREATOR);
        this.v = parcel.readInt();
        this.w = parcel.readString();
        this.x = parcel.createStringArrayList();
        this.y = parcel.createTypedArrayList(Bundle.CREATOR);
        this.z = parcel.createTypedArrayList(n.n.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedList(this.a);
        parcel.writeStringList(this.b);
        parcel.writeTypedArray(this.c, i2);
        parcel.writeInt(this.v);
        parcel.writeString(this.w);
        parcel.writeStringList(this.x);
        parcel.writeTypedList(this.y);
        parcel.writeTypedList(this.z);
    }
}
