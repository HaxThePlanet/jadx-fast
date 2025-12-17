package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo;", "Landroid/os/Parcelable;", "entryId", "", "commentId", "reportType", "Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo$ReportType;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo$ReportType;)V", "getCommentId", "()Ljava/lang/String;", "getEntryId", "getReportType", "()Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo$ReportType;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ReportType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ChallengeReportInfo implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo> CREATOR;
    private final String commentId;
    private final String entryId;
    private final app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType reportType;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            ChallengeReportInfo challengeReportInfo = new ChallengeReportInfo(parcel.readString(), parcel.readString(), ChallengeReportInfo.ReportType.valueOf(parcel.readString()));
            return challengeReportInfo;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo[] newArray(int i) {
            return new ChallengeReportInfo[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo$ReportType;", "", "(Ljava/lang/String;I)V", "COMMENT", "ENTRY", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum ReportType {

        COMMENT,
        ENTRY;
        private static final app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType[] $values() {
            app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType[] arr = new ChallengeReportInfo.ReportType[2];
            return arr;
        }
    }
    static {
        ChallengeReportInfo.Creator creator = new ChallengeReportInfo.Creator();
        ChallengeReportInfo.CREATOR = creator;
    }

    public ChallengeReportInfo(String string, String string2, app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType challengeReportInfo$ReportType3) {
        n.f(string, "entryId");
        n.f(string2, "commentId");
        n.f(reportType3, "reportType");
        super();
        this.entryId = string;
        this.commentId = string2;
        this.reportType = reportType3;
    }

    public ChallengeReportInfo(String string, String string2, app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType challengeReportInfo$ReportType3, int i4, g g5) {
        String obj2;
        obj2 = i4 &= 2 != 0 ? "" : obj2;
        super(string, obj2, reportType3);
    }

    public static app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo copy$default(app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo challengeReportInfo, String string2, String string3, app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType challengeReportInfo$ReportType4, int i5, Object object6) {
        String obj1;
        String obj2;
        app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType obj3;
        if (i5 & 1 != 0) {
            obj1 = challengeReportInfo.entryId;
        }
        if (i5 & 2 != 0) {
            obj2 = challengeReportInfo.commentId;
        }
        if (i5 &= 4 != 0) {
            obj3 = challengeReportInfo.reportType;
        }
        return challengeReportInfo.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.entryId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.commentId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType component3() {
        return this.reportType;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo copy(String string, String string2, app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType challengeReportInfo$ReportType3) {
        n.f(string, "entryId");
        n.f(string2, "commentId");
        n.f(reportType3, "reportType");
        ChallengeReportInfo challengeReportInfo = new ChallengeReportInfo(string, string2, reportType3);
        return challengeReportInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ChallengeReportInfo) {
            return i2;
        }
        if (!n.b(this.entryId, object.entryId)) {
            return i2;
        }
        if (!n.b(this.commentId, object.commentId)) {
            return i2;
        }
        if (this.reportType != object.reportType) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getCommentId() {
        return this.commentId;
    }

    @Override // android.os.Parcelable
    public final String getEntryId() {
        return this.entryId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType getReportType() {
        return this.reportType;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ChallengeReportInfo(entryId=");
        stringBuilder.append(this.entryId);
        stringBuilder.append(", commentId=");
        stringBuilder.append(this.commentId);
        stringBuilder.append(", reportType=");
        stringBuilder.append(this.reportType);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.entryId);
        parcel.writeString(this.commentId);
        parcel.writeString(this.reportType.name());
    }
}
