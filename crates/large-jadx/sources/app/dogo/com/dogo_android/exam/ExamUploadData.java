package app.dogo.com.dogo_android.exam;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ExamUploadData.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0008HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000b¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/exam/ExamUploadData;", "Landroid/os/Parcelable;", "dogId", "", "trickId", "programId", "trickDescription", "examTimeLimitSec", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getDogId", "()Ljava/lang/String;", "getExamTimeLimitSec", "()J", "getProgramId", "getTrickDescription", "getTrickId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final /* data */ class ExamUploadData implements Parcelable {

    public static final Parcelable.Creator<g> CREATOR = new g$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String dogId;
    private final String b;
    /* renamed from: c, reason: from kotlin metadata */
    private final String programId;
    /* renamed from: v, reason: from kotlin metadata */
    private final String trickDescription;
    private final long w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<g> {
        public final g a(Parcel parcel) {
            n.f(parcel, "parcel");
            ExamUploadData examUploadData = new ExamUploadData(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), obj);
            return examUploadData;
        }

        public final g[] b(int i) {
            return new g[i];
        }
    }
    public g(String str, String str2, String str3, String str4, long j) {
        n.f(str, "dogId");
        n.f(str2, "trickId");
        n.f(str3, "programId");
        n.f(str4, "trickDescription");
        super();
        this.dogId = str;
        this.b = str2;
        this.programId = str3;
        this.trickDescription = str4;
        this.w = j;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final String component1() {
        return this.dogId;
    }

    public final long b() {
        return this.w;
    }

    public final String c() {
        return this.programId;
    }

    public final String d() {
        return this.trickDescription;
    }

    public final String e() {
        return this.b;
    }


    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z7 = false;
        if (!(other instanceof ExamUploadData)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.b, other.b)) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        if (!n.b(this.trickDescription, other.trickDescription)) {
            return false;
        }
        return this.w != other.w ? z7 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.dogId.hashCode() * 31) + this.b.hashCode() * 31 + this.programId.hashCode() * 31 + this.trickDescription.hashCode() * 31 + Long.hashCode(this.w);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ExamUploadData(dogId=";
        String str3 = ", trickId=";
        String str5 = ", programId=";
        String str6 = ", trickDescription=";
        String str7 = ", examTimeLimitSec=";
        str = str2 + this.dogId + str3 + this.b + str5 + this.programId + str6 + this.trickDescription + str7 + this.w + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        parcel.writeString(this.b);
        parcel.writeString(this.programId);
        parcel.writeString(this.trickDescription);
        parcel.writeLong(this.w);
    }
}
