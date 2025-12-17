package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008+\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001JB\u0087\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0012\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u0012\u000c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0017J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\t\u00100\u001a\u00020\u0014HÆ\u0003J\t\u00101\u001a\u00020\u0014HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010!J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0015\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u000f\u00107\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cHÆ\u0003J\t\u00108\u001a\u00020\u000fHÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u000fHÆ\u0003Jª\u0001\u0010;\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0014\u0008\u0002\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t2\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00142\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010<J\t\u0010=\u001a\u00020\u0014HÖ\u0001J\u0013\u0010>\u001a\u00020\u000f2\u0008\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\u001a\u0010A\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140\t2\u0006\u0010B\u001a\u00020\u0006J\t\u0010C\u001a\u00020\u0014HÖ\u0001J\t\u0010D\u001a\u00020\u0006HÖ\u0001J\u0019\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u001d\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001fR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\"\u001a\u0004\u0008\u0016\u0010!R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010)\u001a\u0004\u0008'\u0010(R\u0011\u0010\u0015\u001a\u00020\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u0019R\u0017\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0011\u0010\u0012\u001a\u00020\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u001d¨\u0006K", d2 = {"Lapp/dogo/externalmodel/model/BitingProgressModel;", "Landroid/os/Parcelable;", "startedTimeMs", "", "stoppedTimeMs", "certificatePdfUrl", "", "certificateImageUrl", "articles", "", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ReadStatus;", "tricks", "", "Lapp/dogo/externalmodel/model/BitingProgressModel$TrickVariationEvent;", "programIsCompleted", "", "programIsMastered", "articlesAreCompleted", "tricksAreCompleted", "articleCompletionPercentage", "", "trickCompletionPercentage", "isRecommended", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;ZZZZIILjava/lang/Boolean;)V", "getArticleCompletionPercentage", "()I", "getArticles", "()Ljava/util/Map;", "getArticlesAreCompleted", "()Z", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificatePdfUrl", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getProgramIsCompleted", "getProgramIsMastered", "getStartedTimeMs", "()J", "getStoppedTimeMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getTrickCompletionPercentage", "getTricks", "()Ljava/util/List;", "getTricksAreCompleted", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;ZZZZIILjava/lang/Boolean;)Lapp/dogo/externalmodel/model/BitingProgressModel;", "describeContents", "equals", "other", "", "getTrickVariationKnowledgeMap", "trickId", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "TrickVariationEvent", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class BitingProgressModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.BitingProgressModel> CREATOR;
    private final int articleCompletionPercentage;
    private final Map<String, app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus> articles;
    private final boolean articlesAreCompleted;
    private final String certificateImageUrl;
    private final String certificatePdfUrl;
    private final Boolean isRecommended;
    private final boolean programIsCompleted;
    private final boolean programIsMastered;
    private final long startedTimeMs;
    private final Long stoppedTimeMs;
    private final int trickCompletionPercentage;
    private final List<app.dogo.externalmodel.model.BitingProgressModel.TrickVariationEvent> tricks;
    private final boolean tricksAreCompleted;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.BitingProgressModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.BitingProgressModel createFromParcel(Parcel parcel) {
            int valueOf2;
            int valueOf;
            int i6;
            int i3;
            int i4;
            int i2;
            String string;
            int i7;
            Object fromParcel;
            int i8;
            int i;
            int i5;
            Object obj = parcel;
            n.f(obj, "parcel");
            int i9 = 0;
            if (parcel.readInt() == 0) {
                i3 = i9;
            } else {
                i3 = valueOf;
            }
            int int2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(int2);
            i4 = 0;
            i2 = i4;
            while (i2 != int2) {
                linkedHashMap.put(parcel.readString(), PottyProgramProgressModel.ReadStatus.CREATOR.createFromParcel(obj));
                i2++;
            }
            int int3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(int3);
            i7 = i4;
            while (i7 != int3) {
                arrayList.add(BitingProgressModel.TrickVariationEvent.CREATOR.createFromParcel(obj));
                i7++;
            }
            int i11 = 1;
            i6 = parcel.readInt() != 0 ? i11 : i4;
            i8 = parcel.readInt() != 0 ? i11 : i4;
            i = parcel.readInt() != 0 ? i11 : i4;
            i5 = parcel.readInt() != 0 ? i11 : i4;
            if (parcel.readInt() == 0) {
                valueOf2 = i9;
            } else {
                if (parcel.readInt() != 0) {
                    i4 = i11;
                }
                valueOf2 = Boolean.valueOf(i4);
            }
            super(parcel.readLong(), obj4, i3, parcel.readString(), parcel.readString(), linkedHashMap, arrayList, i6, i8, i, i5, parcel.readInt(), parcel.readInt(), valueOf2);
            return bitingProgressModel2;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.BitingProgressModel[] newArray(int i) {
            return new BitingProgressModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/externalmodel/model/BitingProgressModel$TrickVariationEvent;", "Landroid/os/Parcelable;", "trickId", "", "variationId", "knowledge", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getKnowledge", "()I", "getTrickId", "()Ljava/lang/String;", "getVariationId", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickVariationEvent implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.BitingProgressModel.TrickVariationEvent> CREATOR;
        private final int knowledge;
        private final String trickId;
        private final String variationId;
        static {
            BitingProgressModel.TrickVariationEvent.Creator creator = new BitingProgressModel.TrickVariationEvent.Creator();
            BitingProgressModel.TrickVariationEvent.CREATOR = creator;
        }

        public TrickVariationEvent(String string, String string2, int i3) {
            n.f(string, "trickId");
            super();
            this.trickId = string;
            this.variationId = string2;
            this.knowledge = i3;
        }

        public static app.dogo.externalmodel.model.BitingProgressModel.TrickVariationEvent copy$default(app.dogo.externalmodel.model.BitingProgressModel.TrickVariationEvent bitingProgressModel$TrickVariationEvent, String string2, String string3, int i4, int i5, Object object6) {
            String obj1;
            String obj2;
            int obj3;
            if (i5 & 1 != 0) {
                obj1 = trickVariationEvent.trickId;
            }
            if (i5 & 2 != 0) {
                obj2 = trickVariationEvent.variationId;
            }
            if (i5 &= 4 != 0) {
                obj3 = trickVariationEvent.knowledge;
            }
            return trickVariationEvent.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.trickId;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.variationId;
        }

        @Override // android.os.Parcelable
        public final int component3() {
            return this.knowledge;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.BitingProgressModel.TrickVariationEvent copy(String string, String string2, int i3) {
            n.f(string, "trickId");
            BitingProgressModel.TrickVariationEvent trickVariationEvent = new BitingProgressModel.TrickVariationEvent(string, string2, i3);
            return trickVariationEvent;
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
            if (!object instanceof BitingProgressModel.TrickVariationEvent) {
                return i2;
            }
            if (!n.b(this.trickId, object.trickId)) {
                return i2;
            }
            if (!n.b(this.variationId, object.variationId)) {
                return i2;
            }
            if (this.knowledge != object.knowledge) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final int getKnowledge() {
            return this.knowledge;
        }

        @Override // android.os.Parcelable
        public final String getTrickId() {
            return this.trickId;
        }

        @Override // android.os.Parcelable
        public final String getVariationId() {
            return this.variationId;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            int i;
            String variationId = this.variationId;
            if (variationId == null) {
                i = 0;
            } else {
                i = variationId.hashCode();
            }
            return i5 += i7;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickVariationEvent(trickId=");
            stringBuilder.append(this.trickId);
            stringBuilder.append(", variationId=");
            stringBuilder.append(this.variationId);
            stringBuilder.append(", knowledge=");
            stringBuilder.append(this.knowledge);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.trickId);
            parcel.writeString(this.variationId);
            parcel.writeInt(this.knowledge);
        }
    }
    static {
        BitingProgressModel.Creator creator = new BitingProgressModel.Creator();
        BitingProgressModel.CREATOR = creator;
    }

    public BitingProgressModel(long l, Long long2, String string3, String string4, Map<String, app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus> map5, List<app.dogo.externalmodel.model.BitingProgressModel.TrickVariationEvent> list6, boolean z7, boolean z8, boolean z9, boolean z10, int i11, int i12, Boolean boolean13) {
        n.f(list6, "articles");
        n.f(z7, "tricks");
        super();
        this.startedTimeMs = l;
        this.stoppedTimeMs = string3;
        this.certificatePdfUrl = string4;
        this.certificateImageUrl = map5;
        this.articles = list6;
        this.tricks = z7;
        this.programIsCompleted = z8;
        this.programIsMastered = z9;
        this.articlesAreCompleted = z10;
        this.tricksAreCompleted = i11;
        this.articleCompletionPercentage = i12;
        this.trickCompletionPercentage = boolean13;
        this.isRecommended = obj15;
    }

    public static app.dogo.externalmodel.model.BitingProgressModel copy$default(app.dogo.externalmodel.model.BitingProgressModel bitingProgressModel, long l2, Long long3, String string4, String string5, Map map6, List list7, boolean z8, boolean z9, boolean z10, boolean z11, int i12, int i13, Boolean boolean14, int i15, Object object16) {
        Boolean isRecommended;
        long startedTimeMs;
        Long stoppedTimeMs;
        String certificatePdfUrl;
        String certificateImageUrl;
        Map articles;
        List tricks;
        boolean programIsCompleted;
        boolean programIsMastered;
        boolean articlesAreCompleted;
        boolean tricksAreCompleted;
        int articleCompletionPercentage;
        int trickCompletionPercentage;
        Object obj = bitingProgressModel;
        int i = object16;
        startedTimeMs = i & 1 != 0 ? obj.startedTimeMs : l2;
        stoppedTimeMs = i & 2 != 0 ? obj.stoppedTimeMs : string4;
        certificatePdfUrl = i & 4 != 0 ? obj.certificatePdfUrl : string5;
        certificateImageUrl = i & 8 != 0 ? obj.certificateImageUrl : map6;
        articles = i & 16 != 0 ? obj.articles : list7;
        tricks = i & 32 != 0 ? obj.tricks : z8;
        programIsCompleted = i & 64 != 0 ? obj.programIsCompleted : z9;
        programIsMastered = i & 128 != 0 ? obj.programIsMastered : z10;
        articlesAreCompleted = i & 256 != 0 ? obj.articlesAreCompleted : z11;
        tricksAreCompleted = i & 512 != 0 ? obj.tricksAreCompleted : i12;
        articleCompletionPercentage = i & 1024 != 0 ? obj.articleCompletionPercentage : i13;
        trickCompletionPercentage = i & 2048 != 0 ? obj.trickCompletionPercentage : boolean14;
        isRecommended = i &= 4096 != 0 ? obj.isRecommended : i15;
        return bitingProgressModel.copy(startedTimeMs, long3, stoppedTimeMs, certificatePdfUrl, certificateImageUrl, articles, tricks, programIsCompleted, programIsMastered, articlesAreCompleted, tricksAreCompleted, articleCompletionPercentage, trickCompletionPercentage);
    }

    @Override // android.os.Parcelable
    public final long component1() {
        return this.startedTimeMs;
    }

    @Override // android.os.Parcelable
    public final boolean component10() {
        return this.tricksAreCompleted;
    }

    @Override // android.os.Parcelable
    public final int component11() {
        return this.articleCompletionPercentage;
    }

    @Override // android.os.Parcelable
    public final int component12() {
        return this.trickCompletionPercentage;
    }

    @Override // android.os.Parcelable
    public final Boolean component13() {
        return this.isRecommended;
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

    public final List<app.dogo.externalmodel.model.BitingProgressModel.TrickVariationEvent> component6() {
        return this.tricks;
    }

    @Override // android.os.Parcelable
    public final boolean component7() {
        return this.programIsCompleted;
    }

    @Override // android.os.Parcelable
    public final boolean component8() {
        return this.programIsMastered;
    }

    @Override // android.os.Parcelable
    public final boolean component9() {
        return this.articlesAreCompleted;
    }

    public final app.dogo.externalmodel.model.BitingProgressModel copy(long l, Long long2, String string3, String string4, Map<String, app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus> map5, List<app.dogo.externalmodel.model.BitingProgressModel.TrickVariationEvent> list6, boolean z7, boolean z8, boolean z9, boolean z10, int i11, int i12, Boolean boolean13) {
        final Object obj = list6;
        n.f(obj, "articles");
        final Object obj2 = z7;
        n.f(obj2, "tricks");
        super(l, obj3, string3, string4, map5, obj, obj2, z8, z9, z10, i11, i12, boolean13, obj30);
        return bitingProgressModel;
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
        if (!object instanceof BitingProgressModel) {
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
        if (!n.b(this.tricks, object.tricks)) {
            return i2;
        }
        if (this.programIsCompleted != object.programIsCompleted) {
            return i2;
        }
        if (this.programIsMastered != object.programIsMastered) {
            return i2;
        }
        if (this.articlesAreCompleted != object.articlesAreCompleted) {
            return i2;
        }
        if (this.tricksAreCompleted != object.tricksAreCompleted) {
            return i2;
        }
        if (this.articleCompletionPercentage != object.articleCompletionPercentage) {
            return i2;
        }
        if (this.trickCompletionPercentage != object.trickCompletionPercentage) {
            return i2;
        }
        if (!n.b(this.isRecommended, object.isRecommended)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getArticleCompletionPercentage() {
        return this.articleCompletionPercentage;
    }

    public final Map<String, app.dogo.externalmodel.model.PottyProgramProgressModel.ReadStatus> getArticles() {
        return this.articles;
    }

    @Override // android.os.Parcelable
    public final boolean getArticlesAreCompleted() {
        return this.articlesAreCompleted;
    }

    @Override // android.os.Parcelable
    public final String getCertificateImageUrl() {
        return this.certificateImageUrl;
    }

    @Override // android.os.Parcelable
    public final String getCertificatePdfUrl() {
        return this.certificatePdfUrl;
    }

    @Override // android.os.Parcelable
    public final boolean getProgramIsCompleted() {
        return this.programIsCompleted;
    }

    @Override // android.os.Parcelable
    public final boolean getProgramIsMastered() {
        return this.programIsMastered;
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
    public final int getTrickCompletionPercentage() {
        return this.trickCompletionPercentage;
    }

    public final Map<String, Integer> getTrickVariationKnowledgeMap(String string) {
        Integer valueOf;
        o oVar;
        boolean variationId;
        String variationId2;
        n.f(string, "trickId");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.tricks.iterator();
        while (iterator.hasNext()) {
            valueOf = iterator.next();
            if (n.b((BitingProgressModel.TrickVariationEvent)valueOf.getTrickId(), string) && valueOf.getVariationId() != null) {
            } else {
            }
            oVar = 0;
            if (oVar != null) {
            }
            arrayList.add(oVar);
            if (valueOf.getVariationId() != null) {
            } else {
            }
            oVar = new o(valueOf.getVariationId(), Integer.valueOf(valueOf.getKnowledge()));
        }
        return j0.s(arrayList);
    }

    public final List<app.dogo.externalmodel.model.BitingProgressModel.TrickVariationEvent> getTricks() {
        return this.tricks;
    }

    @Override // android.os.Parcelable
    public final boolean getTricksAreCompleted() {
        return this.tricksAreCompleted;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        int i3;
        int i2;
        boolean programIsCompleted;
        boolean programIsMastered;
        boolean articlesAreCompleted;
        int i4;
        boolean i5;
        Long stoppedTimeMs = this.stoppedTimeMs;
        i4 = 0;
        if (stoppedTimeMs == null) {
            i = i4;
        } else {
            i = stoppedTimeMs.hashCode();
        }
        String certificatePdfUrl = this.certificatePdfUrl;
        if (certificatePdfUrl == null) {
            i3 = i4;
        } else {
            i3 = certificatePdfUrl.hashCode();
        }
        String certificateImageUrl = this.certificateImageUrl;
        if (certificateImageUrl == null) {
            i2 = i4;
        } else {
            i2 = certificateImageUrl.hashCode();
        }
        i5 = 1;
        if (this.programIsCompleted) {
            programIsCompleted = i5;
        }
        if (this.programIsMastered) {
            programIsMastered = i5;
        }
        if (this.articlesAreCompleted) {
            articlesAreCompleted = i5;
        }
        boolean tricksAreCompleted = this.tricksAreCompleted;
        if (tricksAreCompleted) {
        } else {
            i5 = tricksAreCompleted;
        }
        Boolean isRecommended = this.isRecommended;
        if (isRecommended == null) {
        } else {
            i4 = isRecommended.hashCode();
        }
        return i29 += i4;
    }

    @Override // android.os.Parcelable
    public final Boolean isRecommended() {
        return this.isRecommended;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BitingProgressModel(startedTimeMs=");
        stringBuilder.append(this.startedTimeMs);
        stringBuilder.append(", stoppedTimeMs=");
        stringBuilder.append(this.stoppedTimeMs);
        stringBuilder.append(", certificatePdfUrl=");
        stringBuilder.append(this.certificatePdfUrl);
        stringBuilder.append(", certificateImageUrl=");
        stringBuilder.append(this.certificateImageUrl);
        stringBuilder.append(", articles=");
        stringBuilder.append(this.articles);
        stringBuilder.append(", tricks=");
        stringBuilder.append(this.tricks);
        stringBuilder.append(", programIsCompleted=");
        stringBuilder.append(this.programIsCompleted);
        stringBuilder.append(", programIsMastered=");
        stringBuilder.append(this.programIsMastered);
        stringBuilder.append(", articlesAreCompleted=");
        stringBuilder.append(this.articlesAreCompleted);
        stringBuilder.append(", tricksAreCompleted=");
        stringBuilder.append(this.tricksAreCompleted);
        stringBuilder.append(", articleCompletionPercentage=");
        stringBuilder.append(this.articleCompletionPercentage);
        stringBuilder.append(", trickCompletionPercentage=");
        stringBuilder.append(this.trickCompletionPercentage);
        stringBuilder.append(", isRecommended=");
        stringBuilder.append(this.isRecommended);
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
        List tricks = this.tricks;
        parcel.writeInt(tricks.size());
        Iterator iterator2 = tricks.iterator();
        for (BitingProgressModel.TrickVariationEvent size : iterator2) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.programIsCompleted);
        parcel.writeInt(this.programIsMastered);
        parcel.writeInt(this.articlesAreCompleted);
        parcel.writeInt(this.tricksAreCompleted);
        parcel.writeInt(this.articleCompletionPercentage);
        parcel.writeInt(this.trickCompletionPercentage);
        obj7 = this.isRecommended;
        if (obj7 == null) {
            parcel.writeInt(i);
        } else {
            parcel.writeInt(i3);
            parcel.writeInt(obj7.booleanValue());
        }
    }
}
