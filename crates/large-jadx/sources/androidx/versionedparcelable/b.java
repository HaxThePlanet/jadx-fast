package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.SparseIntArray;
import d.e.a;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
class b extends androidx.versionedparcelable.VersionedParcel {

    private final SparseIntArray d;
    private final Parcel e;
    private final int f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private int k;
    b(Parcel parcel) {
        a aVar = new a();
        a aVar2 = new a();
        a aVar3 = new a();
        super(parcel, parcel.dataPosition(), parcel.dataSize(), "", aVar, aVar2, aVar3);
    }

    private b(Parcel parcel, int i2, int i3, String string4, a<String, Method> a5, a<String, Method> a6, a<String, Class> a7) {
        super(a5, a6, a7);
        SparseIntArray obj5 = new SparseIntArray();
        this.d = obj5;
        obj5 = -1;
        this.i = obj5;
        this.j = 0;
        this.k = obj5;
        this.e = parcel;
        this.f = i2;
        this.g = i3;
        this.j = i2;
        this.h = string4;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] bArr) {
        Parcel parcel;
        int length;
        byte[] obj3;
        if (bArr != null) {
            this.e.writeInt(bArr.length);
            this.e.writeByteArray(bArr);
        } else {
            this.e.writeInt(-1);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void C(java.lang.CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int i) {
        this.e.writeInt(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable parcelable) {
        this.e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String string) {
        this.e.writeString(string);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i2;
        int dataPosition;
        int i;
        Parcel parcel;
        i2 = this.i;
        if (i2 >= 0) {
            int i3 = this.d.get(i2);
            dataPosition = this.e.dataPosition();
            this.e.setDataPosition(i3);
            this.e.writeInt(dataPosition - i3);
            this.e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected androidx.versionedparcelable.VersionedParcel b() {
        int i;
        final Parcel parcel = this.e;
        if (this.j == this.f) {
            i = this.g;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.h);
        stringBuilder.append("  ");
        super(parcel, parcel.dataPosition(), i, stringBuilder.toString(), this.a, this.b, this.c);
        return bVar2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        int i;
        i = this.e.readInt() != 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        int int = this.e.readInt();
        if (int < 0) {
            return null;
        }
        byte[] bArr = new byte[int];
        this.e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected java.lang.CharSequence k() {
        return (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int i) {
        int i2;
        final int i10 = 0;
        while (this.j < this.g) {
            int i5 = this.k;
            this.e.setDataPosition(this.j);
            this.k = this.e.readInt();
            this.j = i8 += int;
            i10 = 0;
        }
        if (this.k == i) {
        } else {
            i2 = i10;
        }
        return i2;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        return this.e.readInt();
    }

    public <T extends Parcelable> T q() {
        return this.e.readParcelable(b.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        return this.e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int i) {
        a();
        this.i = i;
        this.d.put(i, this.e.dataPosition());
        E(0);
        E(i);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean z) {
        this.e.writeInt(z);
    }
}
