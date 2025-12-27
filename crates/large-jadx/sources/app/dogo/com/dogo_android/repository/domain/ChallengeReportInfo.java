package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ChallengeReportInfo.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo;", "Landroid/os/Parcelable;", "entryId", "", "commentId", "reportType", "Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo$ReportType;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo$ReportType;)V", "getCommentId", "()Ljava/lang/String;", "getEntryId", "getReportType", "()Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo$ReportType;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ReportType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ChallengeReportInfo implements Parcelable {

    public static final Parcelable.Creator<ChallengeReportInfo> CREATOR = new ChallengeReportInfo$Creator<>();
    private final String commentId;
    private final String entryId;
    private final ChallengeReportInfo.ReportType reportType;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ChallengeReportInfo> {
        @Override // android.os.Parcelable$Creator
        public final ChallengeReportInfo createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new ChallengeReportInfo(parcel.readString(), parcel.readString(), ChallengeReportInfo_ReportType.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable$Creator
        public final ChallengeReportInfo[] newArray(int i) {
            return new ChallengeReportInfo[i];
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo$ReportType;", "", "(Ljava/lang/String;I)V", "COMMENT", "ENTRY", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ReportType {

        COMMENT,
        ENTRY;
        private static final /* synthetic */ ChallengeReportInfo.ReportType[] $values() {
            app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType[] arr = new ChallengeReportInfo.ReportType[2];
            return new ChallengeReportInfo.ReportType[] { ChallengeReportInfo_ReportType.COMMENT, ChallengeReportInfo_ReportType.ENTRY };
        }
    }
    public ChallengeReportInfo(String str, String str2, ChallengeReportInfo.ReportType reportType) {
        n.f(str, "entryId");
        n.f(str2, "commentId");
        n.f(reportType, "reportType");
        super();
        this.entryId = str;
        this.commentId = str2;
        this.reportType = reportType;
    }

    public final String getCommentId() {
        return this.commentId;
    }

    public final String getEntryId() {
        return this.entryId;
    }

    public final ChallengeReportInfo.ReportType getReportType() {
        return this.reportType;
    }

    public /* synthetic */ ChallengeReportInfo(String str, String str2, ChallengeReportInfo.ReportType reportType, int i, g gVar) {
        String str3;
        str3 = i & 2 != 0 ? "" : str3;
        this(str, str3, reportType);
    }


    public static /* synthetic */ ChallengeReportInfo copy$default(ChallengeReportInfo challengeReportInfo, String str, String str2, ChallengeReportInfo.ReportType reportType, int i, Object object) {
        String entryId2;
        String commentId2;
        app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo.ReportType reportType2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return challengeReportInfo.copy(entryId2, commentId2, reportType2);
    }

    /* operator */ public final String component1() {
        return this.entryId;
    }

    /* operator */ public final String component2() {
        return this.commentId;
    }

    /* operator */ public final ChallengeReportInfo.ReportType component3() {
        return this.reportType;
    }

    public final ChallengeReportInfo copy(String entryId, String commentId, ChallengeReportInfo.ReportType reportType) {
        n.f(entryId, "entryId");
        n.f(commentId, "commentId");
        n.f(reportType, "reportType");
        return new ChallengeReportInfo(entryId, commentId, reportType);
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
        final boolean z5 = false;
        if (!(other instanceof ChallengeReportInfo)) {
            return false;
        }
        if (!n.b(this.entryId, other.entryId)) {
            return false;
        }
        if (!n.b(this.commentId, other.commentId)) {
            return false;
        }
        return this.reportType != other.reportType ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.entryId.hashCode() * 31) + this.commentId.hashCode() * 31 + this.reportType.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ChallengeReportInfo(entryId=";
        String str3 = ", commentId=";
        String str4 = ", reportType=";
        str = str2 + this.entryId + str3 + this.commentId + str4 + this.reportType + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.entryId);
        parcel.writeString(this.commentId);
        parcel.writeString(this.reportType.name());
    }
}
