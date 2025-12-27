package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;
import kotlin.y.p;

/* compiled from: PottyProgramProgressModel.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/PottyProgramProgressModel;", "Landroid/os/Parcelable;", "progress", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "(Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;)V", "getProgress", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ProgramStatus", "ReadStatus", "StreakDays", "Streaks", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PottyProgramProgressModel implements Parcelable {

    public static final Parcelable.Creator<PottyProgramProgressModel> CREATOR = new PottyProgramProgressModel$Creator<>();
    private final PottyProgramProgressModel.ProgramStatus progress;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PottyProgramProgressModel> {
        @Override // android.os.Parcelable$Creator
        public final PottyProgramProgressModel createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new PottyProgramProgressModel((PottyProgramProgressModel_ProgramStatus)PottyProgramProgressModel_ProgramStatus.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable$Creator
        public final PottyProgramProgressModel[] newArray(int i) {
            return new PottyProgramProgressModel[i];
        }
    }

    @Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u001e\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bs\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0008\u0002\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0015\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010,\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0084\u0001\u0010-\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0014\u0008\u0002\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t2\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010.J\t\u0010/\u001a\u000200HÖ\u0001J\u0013\u00101\u001a\u00020\u00112\u0008\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u000200HÖ\u0001J\t\u00105\u001a\u00020\u0006HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000200HÖ\u0001R\u001d\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\u0008\u0012\u0010\u0019R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\u0008\u0010\u0010\u0019R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#¨\u0006;", d2 = {"Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "Landroid/os/Parcelable;", "startedTimeMs", "", "stoppedTimeMs", "certificatePdfUrl", "", "certificateImageUrl", "articles", "", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ReadStatus;", "logs", "", "Lapp/dogo/externalmodel/model/DogLogModel;", "streaks", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$Streaks;", "isRecommended", "", "isCompleted", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lapp/dogo/externalmodel/model/PottyProgramProgressModel$Streaks;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getArticles", "()Ljava/util/Map;", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificatePdfUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLogs", "()Ljava/util/List;", "getStartedTimeMs", "()J", "getStoppedTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStreaks", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$Streaks;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lapp/dogo/externalmodel/model/PottyProgramProgressModel$Streaks;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramStatus implements Parcelable {

        public static final Parcelable.Creator<PottyProgramProgressModel.ProgramStatus> CREATOR = new PottyProgramProgressModel$ProgramStatus$Creator<>();
        private final Map<String, PottyProgramProgressModel.ReadStatus> articles;
        private final String certificateImageUrl;
        private final String certificatePdfUrl;
        private final Boolean isCompleted;
        private final Boolean isRecommended;
        private final List<DogLogModel> logs;
        private final long startedTimeMs;
        private final Long stoppedTimeMs;
        private final PottyProgramProgressModel.Streaks streaks;
        public ProgramStatus(long j, Long long, String str, String str2, Map<String, PottyProgramProgressModel.ReadStatus> map, List<DogLogModel> list, PottyProgramProgressModel.Streaks streaks, Boolean boolean, Boolean boolean2) {
            n.f(map, "articles");
            n.f(list, "logs");
            n.f(streaks, "streaks");
            super();
            this.startedTimeMs = j;
            this.stoppedTimeMs = long;
            this.certificatePdfUrl = str;
            this.certificateImageUrl = str2;
            this.articles = map;
            this.logs = list;
            this.streaks = streaks;
            this.isRecommended = boolean;
            this.isCompleted = boolean2;
        }

        public final Map<String, PottyProgramProgressModel.ReadStatus> getArticles() {
            return this.articles;
        }

        public final String getCertificateImageUrl() {
            return this.certificateImageUrl;
        }

        public final String getCertificatePdfUrl() {
            return this.certificatePdfUrl;
        }

        public final List<DogLogModel> getLogs() {
            return this.logs;
        }

        public final long getStartedTimeMs() {
            return this.startedTimeMs;
        }

        public final Long getStoppedTimeMs() {
            return this.stoppedTimeMs;
        }

        public final PottyProgramProgressModel.Streaks getStreaks() {
            return this.streaks;
        }

        public final Boolean isCompleted() {
            return this.isCompleted;
        }

        public final Boolean isRecommended() {
            return this.isRecommended;
        }

        public /* synthetic */ ProgramStatus(long j, Long long, String str, String str2, Map map, List list, PottyProgramProgressModel.Streaks streaks, Boolean boolean, Boolean boolean2, int i, g gVar) {
            int j2;
            String str32;
            Object list62;
            Object obj;
            Object obj2;
            j2 = i & 1;
            j2 = i & 1 != 0 ? j2 : j;
            final app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays streakDays = null;
            app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays r5 = i & 2 != 0 ? streakDays : long;
            map = i & 16 != 0 ? map : map;
            i = i & 32;
            list = i & 32 != 0 ? list : list;
            i2 = i & 64;
            PottyProgramProgressModel_Streaks r10 = i & 64 != 0 ? new PottyProgramProgressModel_Streaks(streakDays, streakDays, 3, streakDays) : streaks;
            this(j2, l, str32, str, str2, list62, obj, (i & 64 != 0 ? new PottyProgramProgressModel_Streaks(streakDays, streakDays, 3, streakDays) : streaks), boolean, boolean2);
        }


        public static /* synthetic */ PottyProgramProgressModel.ProgramStatus copy$default(PottyProgramProgressModel.ProgramStatus programStatus, long j, Long long, String str, String str2, Map map, List list, PottyProgramProgressModel.Streaks streaks, Boolean boolean, Boolean boolean2, int i, Object object) {
            Boolean i112;
            long j22;
            Long str42;
            String str52;
            String map62;
            Map list72;
            List streaks82;
            app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks boolean92;
            Boolean boolean102;
            Object programStatus2 = programStatus;
            int object122 = i;
            long r2 = object122 & 1 != 0 ? programStatus2.startedTimeMs : j;
            Long r4 = object122 & 2 != 0 ? programStatus2.stoppedTimeMs : long;
            String r5 = object122 & 4 != 0 ? programStatus2.certificatePdfUrl : str;
            String r6 = object122 & 8 != 0 ? programStatus2.certificateImageUrl : str2;
            Map r7 = object122 & 16 != 0 ? programStatus2.articles : map;
            List r8 = object122 & 32 != 0 ? programStatus2.logs : list;
            app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks r9 = object122 & 64 != 0 ? programStatus2.streaks : streaks;
            Boolean r10 = object122 & 128 != 0 ? programStatus2.isRecommended : boolean;
            Boolean r1 = object122 & 256 != 0 ? programStatus2.isCompleted : boolean2;
            return programStatus.copy(j22, r13, str42, str52, map62, list72, streaks82, boolean92, boolean102, (object122 & 256 != 0 ? programStatus2.isCompleted : boolean2));
        }

        /* operator */ public final long component1() {
            return this.startedTimeMs;
        }

        /* operator */ public final Long component2() {
            return this.stoppedTimeMs;
        }

        /* operator */ public final String component3() {
            return this.certificatePdfUrl;
        }

        /* operator */ public final String component4() {
            return this.certificateImageUrl;
        }

        /* operator */ public final Map<String, PottyProgramProgressModel.ReadStatus> component5() {
            return this.articles;
        }

        /* operator */ public final List<DogLogModel> component6() {
            return this.logs;
        }

        /* operator */ public final PottyProgramProgressModel.Streaks component7() {
            return this.streaks;
        }

        /* operator */ public final Boolean component8() {
            return this.isRecommended;
        }

        /* operator */ public final Boolean component9() {
            return this.isCompleted;
        }

        public final PottyProgramProgressModel.ProgramStatus copy(long startedTimeMs, Long stoppedTimeMs, String certificatePdfUrl, String certificateImageUrl, Map<String, PottyProgramProgressModel.ReadStatus> articles, List<DogLogModel> logs, PottyProgramProgressModel.Streaks streaks, Boolean isRecommended, Boolean isCompleted) {
            final Object logs2 = articles;
            n.f(logs2, "articles");
            final Object streaks2 = logs;
            n.f(streaks2, "logs");
            final Object isRecommended2 = streaks;
            n.f(isRecommended2, "streaks");
            PottyProgramProgressModel_ProgramStatus pottyProgramProgressModel_ProgramStatus = new PottyProgramProgressModel_ProgramStatus(startedTimeMs, l, stoppedTimeMs, certificatePdfUrl, certificateImageUrl, logs2, streaks2, isRecommended2, isRecommended, isCompleted);
            return pottyProgramProgressModel_ProgramStatus;
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
            final boolean z10 = false;
            if (!(other instanceof PottyProgramProgressModel_ProgramStatus)) {
                return false;
            }
            if (this.startedTimeMs != other.startedTimeMs) {
                return false;
            }
            if (!n.b(this.stoppedTimeMs, other.stoppedTimeMs)) {
                return false;
            }
            if (!n.b(this.certificatePdfUrl, other.certificatePdfUrl)) {
                return false;
            }
            if (!n.b(this.certificateImageUrl, other.certificateImageUrl)) {
                return false;
            }
            if (!n.b(this.articles, other.articles)) {
                return false;
            }
            if (!n.b(this.logs, other.logs)) {
                return false;
            }
            if (!n.b(this.streaks, other.streaks)) {
                return false;
            }
            if (!n.b(this.isRecommended, other.isRecommended)) {
                return false;
            }
            return !n.b(this.isCompleted, other.isCompleted) ? z10 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            i = 0;
            if (this.stoppedTimeMs == null) {
            } else {
                i = this.stoppedTimeMs.hashCode();
            }
            if (this.certificatePdfUrl == null) {
            } else {
                i = this.certificatePdfUrl.hashCode();
            }
            if (this.certificateImageUrl == null) {
            } else {
                i = this.certificateImageUrl.hashCode();
            }
            if (this.isRecommended == null) {
            } else {
                i = this.isRecommended.hashCode();
            }
            if (this.isCompleted != null) {
                i = this.isCompleted.hashCode();
            }
            return (Long.hashCode(this.startedTimeMs) * 31) + i * 31 + i * 31 + i * 31 + this.articles.hashCode() * 31 + this.logs.hashCode() * 31 + this.streaks.hashCode() * 31 + i * 31 + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ProgramStatus(startedTimeMs=";
            String str3 = ", stoppedTimeMs=";
            String str4 = ", certificatePdfUrl=";
            String str5 = ", certificateImageUrl=";
            String str6 = ", articles=";
            String str7 = ", logs=";
            String str8 = ", streaks=";
            String str9 = ", isRecommended=";
            String str10 = ", isCompleted=";
            str = str2 + this.startedTimeMs + str3 + this.stoppedTimeMs + str4 + this.certificatePdfUrl + str5 + this.certificateImageUrl + str6 + this.articles + str7 + this.logs + str8 + this.streaks + str9 + this.isRecommended + str10 + this.isCompleted + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeLong(this.startedTimeMs);
            final int i = 0;
            final int i2 = 1;
            if (this.stoppedTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeLong(this.stoppedTimeMs.longValue());
            }
            parcel.writeString(this.certificatePdfUrl);
            parcel.writeString(this.certificateImageUrl);
            parcel.writeInt(this.articles.size());
            Iterator it = this.articles.entrySet().iterator();
            while (it.hasNext()) {
                Object item2 = it.next();
                parcel.writeString((String)item2.getKey());
                (PottyProgramProgressModel_ReadStatus)item2.getValue().writeToParcel(parcel, flags);
            }
            parcel.writeInt(this.logs.size());
            Iterator it2 = this.logs.iterator();
            while (it2.hasNext()) {
                (DogLogModel)it2.next().writeToParcel(parcel, flags);
            }
            this.streaks.writeToParcel(parcel, flags);
            if (this.isRecommended == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeInt(this.isRecommended.booleanValue());
            }
            if (this.isCompleted == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                parcel.writeInt(this.isCompleted.booleanValue());
            }
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0008\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00032\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0005¨\u0006\u0015", d2 = {"Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ReadStatus;", "Landroid/os/Parcelable;", "isRead", "", "(Z)V", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ReadStatus implements Parcelable {

        public static final Parcelable.Creator<PottyProgramProgressModel.ReadStatus> CREATOR = new PottyProgramProgressModel$ReadStatus$Creator<>();
        private final boolean isRead;
        public ReadStatus(boolean z) {
            super();
            this.isRead = z;
        }

        public final boolean isRead() {
            return this.isRead;
        }

        public /* synthetic */ ReadStatus(boolean z, int i, g gVar) {
            boolean z2 = false;
            i = i & 1 != 0 ? 0 : i;
            this(z2);
        }


        public ReadStatus() {
            this(false, 1, null);
        }

        public static /* synthetic */ PottyProgramProgressModel.ReadStatus copy$default(PottyProgramProgressModel.ReadStatus readStatus, boolean z, int i, Object object) {
            boolean isRead2;
            if (i & 1 != 0) {
            }
            return readStatus.copy(isRead2);
        }

        /* operator */ public final boolean component1() {
            return this.isRead;
        }

        public final PottyProgramProgressModel.ReadStatus copy(boolean isRead) {
            return new PottyProgramProgressModel_ReadStatus(isRead);
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
            final boolean z3 = false;
            if (!(other instanceof PottyProgramProgressModel_ReadStatus)) {
                return false;
            }
            return this.isRead != other.isRead ? z3 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = 1;
            if (this.isRead) {
                i = 1;
            }
            return i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ReadStatus(isRead=";
            str = str2 + this.isRead + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeInt(this.isRead);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0016", d2 = {"Lapp/dogo/externalmodel/model/PottyProgramProgressModel$StreakDays;", "Landroid/os/Parcelable;", "days", "", "(I)V", "getDays", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class StreakDays implements Parcelable {

        public static final Parcelable.Creator<PottyProgramProgressModel.StreakDays> CREATOR = new PottyProgramProgressModel$StreakDays$Creator<>();
        private final int days;
        public StreakDays(int i) {
            super();
            this.days = i;
        }

        public final int getDays() {
            return this.days;
        }

        public /* synthetic */ StreakDays(int i, int i2, g gVar) {
            int i3 = 0;
            i3 = i2 & 1 != 0 ? 0 : i3;
            this(i3);
        }


        public StreakDays() {
            this(0, 1, null);
        }

        public static /* synthetic */ PottyProgramProgressModel.StreakDays copy$default(PottyProgramProgressModel.StreakDays streakDays, int i, int i2, Object object) {
            int days2;
            if (i2 & 1 != 0) {
            }
            return streakDays.copy(days2);
        }

        /* operator */ public final int component1() {
            return this.days;
        }

        public final PottyProgramProgressModel.StreakDays copy(int days) {
            return new PottyProgramProgressModel_StreakDays(days);
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
            final boolean z3 = false;
            if (!(other instanceof PottyProgramProgressModel_StreakDays)) {
                return false;
            }
            return this.days != other.days ? z3 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Integer.hashCode(this.days);
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "StreakDays(days=";
            str = str2 + this.days + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeInt(this.days);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u001a", d2 = {"Lapp/dogo/externalmodel/model/PottyProgramProgressModel$Streaks;", "Landroid/os/Parcelable;", "cleanDaysStreak", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$StreakDays;", "logStreak", "(Lapp/dogo/externalmodel/model/PottyProgramProgressModel$StreakDays;Lapp/dogo/externalmodel/model/PottyProgramProgressModel$StreakDays;)V", "getCleanDaysStreak", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$StreakDays;", "getLogStreak", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Streaks implements Parcelable {

        public static final Parcelable.Creator<PottyProgramProgressModel.Streaks> CREATOR = new PottyProgramProgressModel$Streaks$Creator<>();
        private final PottyProgramProgressModel.StreakDays cleanDaysStreak;
        private final PottyProgramProgressModel.StreakDays logStreak;
        public Streaks(PottyProgramProgressModel.StreakDays streakDays, PottyProgramProgressModel.StreakDays streakDays2) {
            super();
            this.cleanDaysStreak = streakDays;
            this.logStreak = streakDays2;
        }

        public final PottyProgramProgressModel.StreakDays getCleanDaysStreak() {
            return this.cleanDaysStreak;
        }

        public final PottyProgramProgressModel.StreakDays getLogStreak() {
            return this.logStreak;
        }

        public /* synthetic */ Streaks(PottyProgramProgressModel.StreakDays streakDays, PottyProgramProgressModel.StreakDays streakDays2, int i, g gVar) {
            app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays streakDays3;
            app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays streakDays4;
            i = 0;
            i = i & 1 != 0 ? i : i;
            i = i & 2 != 0 ? i : i;
            this(streakDays3, streakDays4);
        }


        public Streaks() {
            final app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays streakDays = null;
            this(streakDays, streakDays, 3, streakDays);
        }

        public static /* synthetic */ PottyProgramProgressModel.Streaks copy$default(PottyProgramProgressModel.Streaks streaks, PottyProgramProgressModel.StreakDays streakDays, PottyProgramProgressModel.StreakDays streakDays2, int i, Object object) {
            app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays cleanDaysStreak2;
            app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays logStreak2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            return streaks.copy(cleanDaysStreak2, logStreak2);
        }

        /* operator */ public final PottyProgramProgressModel.StreakDays component1() {
            return this.cleanDaysStreak;
        }

        /* operator */ public final PottyProgramProgressModel.StreakDays component2() {
            return this.logStreak;
        }

        public final PottyProgramProgressModel.Streaks copy(PottyProgramProgressModel.StreakDays cleanDaysStreak, PottyProgramProgressModel.StreakDays logStreak) {
            return new PottyProgramProgressModel_Streaks(cleanDaysStreak, logStreak);
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
            final boolean z4 = false;
            if (!(other instanceof PottyProgramProgressModel_Streaks)) {
                return false;
            }
            if (!n.b(this.cleanDaysStreak, other.cleanDaysStreak)) {
                return false;
            }
            return !n.b(this.logStreak, other.logStreak) ? z4 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i;
            i = 0;
            if (this.cleanDaysStreak == null) {
            } else {
                i = this.cleanDaysStreak.hashCode();
            }
            if (this.logStreak != null) {
                i = this.logStreak.hashCode();
            }
            return (i * 31) + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Streaks(cleanDaysStreak=";
            String str3 = ", logStreak=";
            str = str2 + this.cleanDaysStreak + str3 + this.logStreak + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            final int i = 0;
            final int i2 = 1;
            if (this.cleanDaysStreak == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                this.cleanDaysStreak.writeToParcel(parcel, flags);
            }
            if (this.logStreak == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i2);
                this.logStreak.writeToParcel(parcel, flags);
            }
        }
    }
    public PottyProgramProgressModel(PottyProgramProgressModel.ProgramStatus programStatus) {
        n.f(programStatus, "progress");
        super();
        this.progress = programStatus;
    }

    public final PottyProgramProgressModel.ProgramStatus getProgress() {
        return this.progress;
    }


    public static /* synthetic */ PottyProgramProgressModel copy$default(PottyProgramProgressModel pottyProgramProgressModel, PottyProgramProgressModel.ProgramStatus programStatus, int i, Object object) {
        app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus progress2;
        if (i & 1 != 0) {
        }
        return pottyProgramProgressModel.copy(progress2);
    }

    /* operator */ public final PottyProgramProgressModel.ProgramStatus component1() {
        return this.progress;
    }

    public final PottyProgramProgressModel copy(PottyProgramProgressModel.ProgramStatus progress) {
        n.f(progress, "progress");
        return new PottyProgramProgressModel(progress);
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
        final boolean z3 = false;
        if (!(other instanceof PottyProgramProgressModel)) {
            return false;
        }
        return !n.b(this.progress, other.progress) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.progress.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "PottyProgramProgressModel(progress=";
        str = str2 + this.progress + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.progress.writeToParcel(parcel, flags);
    }
}
