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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001b", d2 = {"Lapp/dogo/externalmodel/model/PottyProgramProgressModel;", "Landroid/os/Parcelable;", "progress", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "(Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;)V", "getProgress", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ProgramStatus", "ReadStatus", "StreakDays", "Streaks", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class PottyProgramProgressModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.PottyProgramProgressModel> CREATOR;
    private final app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus progress;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.PottyProgramProgressModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.PottyProgramProgressModel createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            PottyProgramProgressModel pottyProgramProgressModel = new PottyProgramProgressModel((PottyProgramProgressModel.ProgramStatus)PottyProgramProgressModel.ProgramStatus.CREATOR.createFromParcel(parcel));
            return pottyProgramProgressModel;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.PottyProgramProgressModel[] newArray(int i) {
            return new PottyProgramProgressModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u001e\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001Bs\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0014\u0008\u0002\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0015\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010,\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0084\u0001\u0010-\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0014\u0008\u0002\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t2\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010.J\t\u0010/\u001a\u000200HÖ\u0001J\u0013\u00101\u001a\u00020\u00112\u0008\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u000200HÖ\u0001J\t\u00105\u001a\u00020\u0006HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u000200HÖ\u0001R\u001d\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0017R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\u0008\u0012\u0010\u0019R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\u0008\u0010\u0010\u0019R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010!\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#¨\u0006;", d2 = {"Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "Landroid/os/Parcelable;", "startedTimeMs", "", "stoppedTimeMs", "certificatePdfUrl", "", "certificateImageUrl", "articles", "", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ReadStatus;", "logs", "", "Lapp/dogo/externalmodel/model/DogLogModel;", "streaks", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$Streaks;", "isRecommended", "", "isCompleted", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lapp/dogo/externalmodel/model/PottyProgramProgressModel$Streaks;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getArticles", "()Ljava/util/Map;", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificatePdfUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLogs", "()Ljava/util/List;", "getStartedTimeMs", "()J", "getStoppedTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStreaks", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$Streaks;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lapp/dogo/externalmodel/model/PottyProgramProgressModel$Streaks;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramStatus implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus> CREATOR;
        private final Map<String, app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus> articles;
        private final String certificateImageUrl;
        private final String certificatePdfUrl;
        private final Boolean isCompleted;
        private final Boolean isRecommended;
        private final List<app.dogo.externalmodel.model.DogLogModel> logs;
        private final long startedTimeMs;
        private final Long stoppedTimeMs;
        private final app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks streaks;
        static {
            PottyProgramProgressModel.ProgramStatus.Creator creator = new PottyProgramProgressModel.ProgramStatus.Creator();
            PottyProgramProgressModel.ProgramStatus.CREATOR = creator;
        }

        public ProgramStatus(long l, Long long2, String string3, String string4, Map<String, app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus> map5, List<app.dogo.externalmodel.model.DogLogModel> list6, app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks pottyProgramProgressModel$Streaks7, Boolean boolean8, Boolean boolean9) {
            n.f(list6, "articles");
            n.f(streaks7, "logs");
            n.f(boolean8, "streaks");
            super();
            this.startedTimeMs = l;
            this.stoppedTimeMs = string3;
            this.certificatePdfUrl = string4;
            this.certificateImageUrl = map5;
            this.articles = list6;
            this.logs = streaks7;
            this.streaks = boolean8;
            this.isRecommended = boolean9;
            this.isCompleted = obj11;
        }

        public ProgramStatus(long l, Long long2, String string3, String string4, Map map5, List list6, app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks pottyProgramProgressModel$Streaks7, Boolean boolean8, Boolean boolean9, int i10, g g11) {
            int i6;
            Map i2;
            int i;
            int streaks;
            int i5;
            int i4;
            int i3;
            Map map;
            List list;
            app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks streaks2;
            i4 = g11 & 1 != 0 ? i6 : l;
            final int i8 = 0;
            i3 = g11 & 2 != 0 ? i8 : string3;
            if (g11 & 16 != 0) {
                map = i2;
            } else {
                map = list6;
            }
            if (g11 & 32 != 0) {
                list = i;
            } else {
                list = streaks7;
            }
            if (g11 & 64 != 0) {
                streaks = new PottyProgramProgressModel.Streaks(i8, i8, 3, i8);
                streaks2 = streaks;
            } else {
                streaks2 = boolean8;
            }
            super(i4, obj4, i3, string4, map5, map, list, streaks2, boolean9, i10);
        }

        public static app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus copy$default(app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus pottyProgramProgressModel$ProgramStatus, long l2, Long long3, String string4, String string5, Map map6, List list7, app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks pottyProgramProgressModel$Streaks8, Boolean boolean9, Boolean boolean10, int i11, Object object12) {
            Boolean isCompleted;
            long startedTimeMs;
            Long stoppedTimeMs;
            String certificatePdfUrl;
            String certificateImageUrl;
            Map articles;
            List logs;
            app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks streaks;
            Boolean isRecommended;
            Object obj = programStatus;
            int i = object12;
            startedTimeMs = i & 1 != 0 ? obj.startedTimeMs : l2;
            stoppedTimeMs = i & 2 != 0 ? obj.stoppedTimeMs : string4;
            certificatePdfUrl = i & 4 != 0 ? obj.certificatePdfUrl : string5;
            certificateImageUrl = i & 8 != 0 ? obj.certificateImageUrl : map6;
            articles = i & 16 != 0 ? obj.articles : list7;
            logs = i & 32 != 0 ? obj.logs : streaks8;
            streaks = i & 64 != 0 ? obj.streaks : boolean9;
            isRecommended = i & 128 != 0 ? obj.isRecommended : boolean10;
            isCompleted = i &= 256 != 0 ? obj.isCompleted : i11;
            return programStatus.copy(startedTimeMs, long3, stoppedTimeMs, certificatePdfUrl, certificateImageUrl, articles, logs, streaks, isRecommended);
        }

        @Override // android.os.Parcelable
        public final long component1() {
            return this.startedTimeMs;
        }

        @Override // android.os.Parcelable
        public final Long component2() {
            return this.stoppedTimeMs;
        }

        @Override // android.os.Parcelable
        public final String component3() {
            return this.certificatePdfUrl;
        }

        @Override // android.os.Parcelable
        public final String component4() {
            return this.certificateImageUrl;
        }

        public final Map<String, app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus> component5() {
            return this.articles;
        }

        public final List<app.dogo.externalmodel.model.DogLogModel> component6() {
            return this.logs;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks component7() {
            return this.streaks;
        }

        @Override // android.os.Parcelable
        public final Boolean component8() {
            return this.isRecommended;
        }

        @Override // android.os.Parcelable
        public final Boolean component9() {
            return this.isCompleted;
        }

        public final app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus copy(long l, Long long2, String string3, String string4, Map<String, app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus> map5, List<app.dogo.externalmodel.model.DogLogModel> list6, app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks pottyProgramProgressModel$Streaks7, Boolean boolean8, Boolean boolean9) {
            final Object obj = list6;
            n.f(obj, "articles");
            final Object obj2 = streaks7;
            n.f(obj2, "logs");
            final Object obj3 = boolean8;
            n.f(obj3, "streaks");
            super(l, obj3, string3, string4, map5, obj, obj2, obj3, boolean9, obj22);
            return programStatus;
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
            if (!object instanceof PottyProgramProgressModel.ProgramStatus) {
                return i2;
            }
            if (Long.compare(startedTimeMs, startedTimeMs2) != 0) {
                return i2;
            }
            if (!n.b(this.stoppedTimeMs, object.stoppedTimeMs)) {
                return i2;
            }
            if (!n.b(this.certificatePdfUrl, object.certificatePdfUrl)) {
                return i2;
            }
            if (!n.b(this.certificateImageUrl, object.certificateImageUrl)) {
                return i2;
            }
            if (!n.b(this.articles, object.articles)) {
                return i2;
            }
            if (!n.b(this.logs, object.logs)) {
                return i2;
            }
            if (!n.b(this.streaks, object.streaks)) {
                return i2;
            }
            if (!n.b(this.isRecommended, object.isRecommended)) {
                return i2;
            }
            if (!n.b(this.isCompleted, object.isCompleted)) {
                return i2;
            }
            return i;
        }

        public final Map<String, app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus> getArticles() {
            return this.articles;
        }

        @Override // android.os.Parcelable
        public final String getCertificateImageUrl() {
            return this.certificateImageUrl;
        }

        @Override // android.os.Parcelable
        public final String getCertificatePdfUrl() {
            return this.certificatePdfUrl;
        }

        public final List<app.dogo.externalmodel.model.DogLogModel> getLogs() {
            return this.logs;
        }

        @Override // android.os.Parcelable
        public final long getStartedTimeMs() {
            return this.startedTimeMs;
        }

        @Override // android.os.Parcelable
        public final Long getStoppedTimeMs() {
            return this.stoppedTimeMs;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks getStreaks() {
            return this.streaks;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i3;
            int i4;
            int i5;
            int i;
            int i2;
            Long stoppedTimeMs = this.stoppedTimeMs;
            i2 = 0;
            if (stoppedTimeMs == null) {
                i3 = i2;
            } else {
                i3 = stoppedTimeMs.hashCode();
            }
            String certificatePdfUrl = this.certificatePdfUrl;
            if (certificatePdfUrl == null) {
                i4 = i2;
            } else {
                i4 = certificatePdfUrl.hashCode();
            }
            String certificateImageUrl = this.certificateImageUrl;
            if (certificateImageUrl == null) {
                i5 = i2;
            } else {
                i5 = certificateImageUrl.hashCode();
            }
            Boolean isRecommended = this.isRecommended;
            if (isRecommended == null) {
                i = i2;
            } else {
                i = isRecommended.hashCode();
            }
            Boolean isCompleted = this.isCompleted;
            if (isCompleted == null) {
            } else {
                i2 = isCompleted.hashCode();
            }
            return i21 += i2;
        }

        @Override // android.os.Parcelable
        public final Boolean isCompleted() {
            return this.isCompleted;
        }

        @Override // android.os.Parcelable
        public final Boolean isRecommended() {
            return this.isRecommended;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ProgramStatus(startedTimeMs=");
            stringBuilder.append(this.startedTimeMs);
            stringBuilder.append(", stoppedTimeMs=");
            stringBuilder.append(this.stoppedTimeMs);
            stringBuilder.append(", certificatePdfUrl=");
            stringBuilder.append(this.certificatePdfUrl);
            stringBuilder.append(", certificateImageUrl=");
            stringBuilder.append(this.certificateImageUrl);
            stringBuilder.append(", articles=");
            stringBuilder.append(this.articles);
            stringBuilder.append(", logs=");
            stringBuilder.append(this.logs);
            stringBuilder.append(", streaks=");
            stringBuilder.append(this.streaks);
            stringBuilder.append(", isRecommended=");
            stringBuilder.append(this.isRecommended);
            stringBuilder.append(", isCompleted=");
            stringBuilder.append(this.isCompleted);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            long longValue;
            int value;
            int size;
            Object key;
            boolean obj7;
            n.f(parcel, "out");
            parcel.writeLong(this.startedTimeMs);
            Long stoppedTimeMs = this.stoppedTimeMs;
            final int i = 0;
            final int i3 = 1;
            if (stoppedTimeMs == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeLong(stoppedTimeMs.longValue());
            }
            parcel.writeString(this.certificatePdfUrl);
            parcel.writeString(this.certificateImageUrl);
            Map articles = this.articles;
            parcel.writeInt(articles.size());
            Iterator iterator = articles.entrySet().iterator();
            for (Map.Entry next3 : iterator) {
                parcel.writeString((String)next3.getKey());
                (PottyProgramProgressModel.ReadStatus)next3.getValue().writeToParcel(parcel, i2);
            }
            List logs = this.logs;
            parcel.writeInt(logs.size());
            Iterator iterator2 = logs.iterator();
            for (DogLogModel size : iterator2) {
                size.writeToParcel(parcel, i2);
            }
            this.streaks.writeToParcel(parcel, i2);
            obj7 = this.isRecommended;
            if (obj7 == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeInt(obj7.booleanValue());
            }
            obj7 = this.isCompleted;
            if (obj7 == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                parcel.writeInt(obj7.booleanValue());
            }
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0008\u001a\u00020\tHÖ\u0001J\u0013\u0010\n\u001a\u00020\u00032\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\tHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0005¨\u0006\u0015", d2 = {"Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ReadStatus;", "Landroid/os/Parcelable;", "isRead", "", "(Z)V", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ReadStatus implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus> CREATOR;
        private final boolean isRead;
        static {
            PottyProgramProgressModel.ReadStatus.Creator creator = new PottyProgramProgressModel.ReadStatus.Creator();
            PottyProgramProgressModel.ReadStatus.CREATOR = creator;
        }

        public ReadStatus() {
            super(0, 1, 0);
        }

        public ReadStatus(boolean z) {
            super();
            this.isRead = z;
        }

        public ReadStatus(boolean z, int i2, g g3) {
            int obj1;
            obj1 = i2 &= 1 != 0 ? 0 : obj1;
            super(obj1);
        }

        public static app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus copy$default(app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus pottyProgramProgressModel$ReadStatus, boolean z2, int i3, Object object4) {
            boolean obj1;
            if (i3 &= 1 != 0) {
                obj1 = readStatus.isRead;
            }
            return readStatus.copy(obj1);
        }

        @Override // android.os.Parcelable
        public final boolean component1() {
            return this.isRead;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus copy(boolean z) {
            PottyProgramProgressModel.ReadStatus readStatus = new PottyProgramProgressModel.ReadStatus(z);
            return readStatus;
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
            if (!object instanceof PottyProgramProgressModel.ReadStatus) {
                return i2;
            }
            if (this.isRead != object.isRead) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            boolean isRead;
            if (this.isRead) {
                isRead = 1;
            }
            return isRead;
        }

        @Override // android.os.Parcelable
        public final boolean isRead() {
            return this.isRead;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ReadStatus(isRead=");
            stringBuilder.append(this.isRead);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeInt(this.isRead);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0016", d2 = {"Lapp/dogo/externalmodel/model/PottyProgramProgressModel$StreakDays;", "Landroid/os/Parcelable;", "days", "", "(I)V", "getDays", "()I", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class StreakDays implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays> CREATOR;
        private final int days;
        static {
            PottyProgramProgressModel.StreakDays.Creator creator = new PottyProgramProgressModel.StreakDays.Creator();
            PottyProgramProgressModel.StreakDays.CREATOR = creator;
        }

        public StreakDays() {
            super(0, 1, 0);
        }

        public StreakDays(int i) {
            super();
            this.days = i;
        }

        public StreakDays(int i, int i2, g g3) {
            int obj1;
            obj1 = i2 &= 1 != 0 ? 0 : obj1;
            super(obj1);
        }

        public static app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays copy$default(app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays pottyProgramProgressModel$StreakDays, int i2, int i3, Object object4) {
            int obj1;
            if (i3 &= 1 != 0) {
                obj1 = streakDays.days;
            }
            return streakDays.copy(obj1);
        }

        @Override // android.os.Parcelable
        public final int component1() {
            return this.days;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays copy(int i) {
            PottyProgramProgressModel.StreakDays streakDays = new PottyProgramProgressModel.StreakDays(i);
            return streakDays;
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
            if (!object instanceof PottyProgramProgressModel.StreakDays) {
                return i2;
            }
            if (this.days != object.days) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final int getDays() {
            return this.days;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return Integer.hashCode(this.days);
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("StreakDays(days=");
            stringBuilder.append(this.days);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeInt(this.days);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u000c\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u001a", d2 = {"Lapp/dogo/externalmodel/model/PottyProgramProgressModel$Streaks;", "Landroid/os/Parcelable;", "cleanDaysStreak", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$StreakDays;", "logStreak", "(Lapp/dogo/externalmodel/model/PottyProgramProgressModel$StreakDays;Lapp/dogo/externalmodel/model/PottyProgramProgressModel$StreakDays;)V", "getCleanDaysStreak", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$StreakDays;", "getLogStreak", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Streaks implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks> CREATOR;
        private final app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays cleanDaysStreak;
        private final app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays logStreak;
        static {
            PottyProgramProgressModel.Streaks.Creator creator = new PottyProgramProgressModel.Streaks.Creator();
            PottyProgramProgressModel.Streaks.CREATOR = creator;
        }

        public Streaks() {
            final int i = 0;
            super(i, i, 3, i);
        }

        public Streaks(app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays pottyProgramProgressModel$StreakDays, app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays pottyProgramProgressModel$StreakDays2) {
            super();
            this.cleanDaysStreak = streakDays;
            this.logStreak = streakDays2;
        }

        public Streaks(app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays pottyProgramProgressModel$StreakDays, app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays pottyProgramProgressModel$StreakDays2, int i3, g g4) {
            int obj2;
            int obj3;
            final int i = 0;
            obj2 = i3 & 1 != 0 ? i : obj2;
            obj3 = i3 &= 2 != 0 ? i : obj3;
            super(obj2, obj3);
        }

        public static app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks copy$default(app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks pottyProgramProgressModel$Streaks, app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays pottyProgramProgressModel$StreakDays2, app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays pottyProgramProgressModel$StreakDays3, int i4, Object object5) {
            app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays obj1;
            app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays obj2;
            if (i4 & 1 != 0) {
                obj1 = streaks.cleanDaysStreak;
            }
            if (i4 &= 2 != 0) {
                obj2 = streaks.logStreak;
            }
            return streaks.copy(obj1, obj2);
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays component1() {
            return this.cleanDaysStreak;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays component2() {
            return this.logStreak;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.PottyProgramProgressModel.Streaks copy(app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays pottyProgramProgressModel$StreakDays, app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays pottyProgramProgressModel$StreakDays2) {
            PottyProgramProgressModel.Streaks streaks = new PottyProgramProgressModel.Streaks(streakDays, streakDays2);
            return streaks;
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
            if (!object instanceof PottyProgramProgressModel.Streaks) {
                return i2;
            }
            if (!n.b(this.cleanDaysStreak, object.cleanDaysStreak)) {
                return i2;
            }
            if (!n.b(this.logStreak, object.logStreak)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays getCleanDaysStreak() {
            return this.cleanDaysStreak;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays getLogStreak() {
            return this.logStreak;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i;
            int i2;
            app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays cleanDaysStreak = this.cleanDaysStreak;
            if (cleanDaysStreak == null) {
                i = i2;
            } else {
                i = cleanDaysStreak.hashCode();
            }
            final app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays logStreak = this.logStreak;
            if (logStreak == null) {
            } else {
                i2 = logStreak.hashCode();
            }
            return i3 += i2;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Streaks(cleanDaysStreak=");
            stringBuilder.append(this.cleanDaysStreak);
            stringBuilder.append(", logStreak=");
            stringBuilder.append(this.logStreak);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays cleanDaysStreak = this.cleanDaysStreak;
            final int i = 0;
            final int i3 = 1;
            if (cleanDaysStreak == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                cleanDaysStreak.writeToParcel(parcel, i2);
            }
            app.dogo.externalmodel.model.PottyProgramProgressModel.StreakDays logStreak = this.logStreak;
            if (logStreak == null) {
                parcel.writeInt(i);
            } else {
                parcel.writeInt(i3);
                logStreak.writeToParcel(parcel, i2);
            }
        }
    }
    static {
        PottyProgramProgressModel.Creator creator = new PottyProgramProgressModel.Creator();
        PottyProgramProgressModel.CREATOR = creator;
    }

    public PottyProgramProgressModel(app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus pottyProgramProgressModel$ProgramStatus) {
        n.f(programStatus, "progress");
        super();
        this.progress = programStatus;
    }

    public static app.dogo.externalmodel.model.PottyProgramProgressModel copy$default(app.dogo.externalmodel.model.PottyProgramProgressModel pottyProgramProgressModel, app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus pottyProgramProgressModel$ProgramStatus2, int i3, Object object4) {
        app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus obj1;
        if (i3 &= 1 != 0) {
            obj1 = pottyProgramProgressModel.progress;
        }
        return pottyProgramProgressModel.copy(obj1);
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus component1() {
        return this.progress;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.PottyProgramProgressModel copy(app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus pottyProgramProgressModel$ProgramStatus) {
        n.f(programStatus, "progress");
        PottyProgramProgressModel pottyProgramProgressModel = new PottyProgramProgressModel(programStatus);
        return pottyProgramProgressModel;
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
        if (!object instanceof PottyProgramProgressModel) {
            return i2;
        }
        if (!n.b(this.progress, object.progress)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus getProgress() {
        return this.progress;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.progress.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PottyProgramProgressModel(progress=");
        stringBuilder.append(this.progress);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.progress.writeToParcel(parcel, i2);
    }
}
