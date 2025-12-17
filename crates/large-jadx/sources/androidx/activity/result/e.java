package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* loaded from: classes.dex */
public final class e implements Parcelable {

    public static final Parcelable.Creator<androidx.activity.result.e> CREATOR;
    private final IntentSender a;
    private final Intent b;
    private final int c;
    private final int v;

    class a implements Parcelable.Creator<androidx.activity.result.e> {
        @Override // android.os.Parcelable$Creator
        public androidx.activity.result.e a(Parcel parcel) {
            e eVar = new e(parcel);
            return eVar;
        }

        @Override // android.os.Parcelable$Creator
        public androidx.activity.result.e[] b(int i) {
            return new e[i];
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

    public static final class b {

        private IntentSender a;
        private Intent b;
        private int c;
        private int d;
        public b(IntentSender intentSender) {
            super();
            this.a = intentSender;
        }

        public androidx.activity.result.e a() {
            e eVar = new e(this.a, this.b, this.c, this.d);
            return eVar;
        }

        public androidx.activity.result.e.b b(Intent intent) {
            this.b = intent;
            return this;
        }

        public androidx.activity.result.e.b c(int i, int i2) {
            this.d = i;
            this.c = i2;
            return this;
        }
    }
    static {
        e.a aVar = new e.a();
        e.CREATOR = aVar;
    }

    e(IntentSender intentSender, Intent intent2, int i3, int i4) {
        super();
        this.a = intentSender;
        this.b = intent2;
        this.c = i3;
        this.v = i4;
    }

    e(Parcel parcel) {
        super();
        this.a = (IntentSender)parcel.readParcelable(IntentSender.class.getClassLoader());
        this.b = (Intent)parcel.readParcelable(Intent.class.getClassLoader());
        this.c = parcel.readInt();
        this.v = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public Intent a() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int b() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int c() {
        return this.v;
    }

    @Override // android.os.Parcelable
    public IntentSender d() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.a, i2);
        parcel.writeParcelable(this.b, i2);
        parcel.writeInt(this.c);
        parcel.writeInt(this.v);
    }
}
