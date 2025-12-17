package app.dogo.android.persistencedb.room.entity;

import app.dogo.externalmodel.model.TrickKnowledgeEvent;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008\u0087\u0008\u0018\u0000 $2\u00020\u0001:\u0003$%&B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u001c\u001a\u00020\nHÆ\u0003JN\u0010\u001d\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00062\u0008\u0008\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\nHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0015\u0010\u0008\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006'", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;", "", "trickId", "", "dogId", "updatedAt", "", "lastViewedAt", "lastRatedAt", "knowledge", "", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;I)V", "getDogId", "()Ljava/lang/String;", "getKnowledge", "()I", "getLastRatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLastViewedAt", "getTrickId", "getUpdatedAt", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;I)Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;", "equals", "", "other", "hashCode", "toString", "Companion", "TrickKnowledgeRateData", "TrickKnowledgeViewData", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickProgressEntity {

    public static final app.dogo.android.persistencedb.room.entity.TrickProgressEntity.Companion Companion;
    private final String dogId;
    private final int knowledge;
    private final Long lastRatedAt;
    private final Long lastViewedAt;
    private final String trickId;
    private final long updatedAt;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008¨\u0006\t", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$Companion;", "", "()V", "rateDataFormTrickKnowledgeEvent", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeRateData;", "dogId", "", "trickEvent", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeRateData rateDataFormTrickKnowledgeEvent(String string, TrickKnowledgeEvent trickKnowledgeEvent2) {
            n.f(string, "dogId");
            n.f(trickKnowledgeEvent2, "trickEvent");
            super(trickKnowledgeEvent2.getTrickId(), string, trickKnowledgeEvent2.getLastTrainedTimeMs(), obj5, trickKnowledgeEvent2.getLastTrainedTimeMs(), obj7, trickKnowledgeEvent2.getKnowledge());
            return obj11;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0010¨\u0006\u001e", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeRateData;", "", "trickId", "", "dogId", "updatedAt", "", "lastRatedAt", "knowledge", "", "(Ljava/lang/String;Ljava/lang/String;JJI)V", "getDogId", "()Ljava/lang/String;", "getKnowledge", "()I", "getLastRatedAt", "()J", "getTrickId", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickKnowledgeRateData {

        private final String dogId;
        private final int knowledge;
        private final long lastRatedAt;
        private final String trickId;
        private final long updatedAt;
        public TrickKnowledgeRateData(String string, String string2, long l3, long l4, int i5) {
            n.f(string, "trickId");
            n.f(string2, "dogId");
            super();
            this.trickId = string;
            this.dogId = string2;
            this.updatedAt = l3;
            this.lastRatedAt = i5;
            this.knowledge = obj8;
        }

        public static app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeRateData copy$default(app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeRateData trickProgressEntity$TrickKnowledgeRateData, String string2, String string3, long l4, long l5, int i6, int i7, Object object8) {
            String obj6;
            String obj7;
            long obj8;
            long obj10;
            int obj12;
            if (obj13 & 1 != 0) {
                obj6 = trickKnowledgeRateData.trickId;
            }
            if (obj13 & 2 != 0) {
                obj7 = trickKnowledgeRateData.dogId;
            }
            if (obj13 & 4 != 0) {
                obj8 = trickKnowledgeRateData.updatedAt;
            }
            if (obj13 & 8 != 0) {
                obj10 = trickKnowledgeRateData.lastRatedAt;
            }
            if (obj13 & 16 != 0) {
                obj12 = trickKnowledgeRateData.knowledge;
            }
            return trickKnowledgeRateData.copy(obj6, obj7, obj8, i7, obj10);
        }

        public final String component1() {
            return this.trickId;
        }

        public final String component2() {
            return this.dogId;
        }

        public final long component3() {
            return this.updatedAt;
        }

        public final long component4() {
            return this.lastRatedAt;
        }

        public final int component5() {
            return this.knowledge;
        }

        public final app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeRateData copy(String string, String string2, long l3, long l4, int i5) {
            n.f(string, "trickId");
            n.f(string2, "dogId");
            super(string, string2, l3, obj5, i5, obj7, obj16);
            return trickKnowledgeRateData;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object instanceof TrickProgressEntity.TrickKnowledgeRateData == null) {
                return i2;
            }
            if (!n.b(this.trickId, object.trickId)) {
                return i2;
            }
            if (!n.b(this.dogId, object.dogId)) {
                return i2;
            }
            if (Long.compare(updatedAt, updatedAt2) != 0) {
                return i2;
            }
            if (Long.compare(lastRatedAt, lastRatedAt2) != 0) {
                return i2;
            }
            if (this.knowledge != object.knowledge) {
                return i2;
            }
            return i;
        }

        public final String getDogId() {
            return this.dogId;
        }

        public final int getKnowledge() {
            return this.knowledge;
        }

        public final long getLastRatedAt() {
            return this.lastRatedAt;
        }

        public final String getTrickId() {
            return this.trickId;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public int hashCode() {
            return i8 += i13;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickKnowledgeRateData(trickId=");
            stringBuilder.append(this.trickId);
            stringBuilder.append(", dogId=");
            stringBuilder.append(this.dogId);
            stringBuilder.append(", updatedAt=");
            stringBuilder.append(this.updatedAt);
            stringBuilder.append(", lastRatedAt=");
            stringBuilder.append(this.lastRatedAt);
            stringBuilder.append(", knowledge=");
            stringBuilder.append(this.knowledge);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006\u001a", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity$TrickKnowledgeViewData;", "", "trickId", "", "dogId", "updatedAt", "", "lastViewedAt", "(Ljava/lang/String;Ljava/lang/String;JJ)V", "getDogId", "()Ljava/lang/String;", "getLastViewedAt", "()J", "getTrickId", "getUpdatedAt", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class TrickKnowledgeViewData {

        private final String dogId;
        private final long lastViewedAt;
        private final String trickId;
        private final long updatedAt;
        public TrickKnowledgeViewData(String string, String string2, long l3, long l4) {
            n.f(string, "trickId");
            n.f(string2, "dogId");
            super();
            this.trickId = string;
            this.dogId = string2;
            this.updatedAt = l3;
            this.lastViewedAt = obj6;
        }

        public static app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeViewData copy$default(app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeViewData trickProgressEntity$TrickKnowledgeViewData, String string2, String string3, long l4, long l5, int i6, Object object7) {
            String obj5;
            String obj6;
            long obj7;
            long obj9;
            if (obj11 & 1 != 0) {
                obj5 = trickKnowledgeViewData.trickId;
            }
            if (obj11 & 2 != 0) {
                obj6 = trickKnowledgeViewData.dogId;
            }
            String obj12 = obj6;
            if (obj11 & 4 != 0) {
                obj7 = trickKnowledgeViewData.updatedAt;
            }
            if (obj11 & 8 != 0) {
                obj9 = trickKnowledgeViewData.lastViewedAt;
            }
            return trickKnowledgeViewData.copy(obj5, obj12, obj7, object7);
        }

        public final String component1() {
            return this.trickId;
        }

        public final String component2() {
            return this.dogId;
        }

        public final long component3() {
            return this.updatedAt;
        }

        public final long component4() {
            return this.lastViewedAt;
        }

        public final app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeViewData copy(String string, String string2, long l3, long l4) {
            n.f(string, "trickId");
            n.f(string2, "dogId");
            super(string, string2, l3, obj5, obj13, obj7);
            return trickKnowledgeViewData;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object instanceof TrickProgressEntity.TrickKnowledgeViewData == null) {
                return i2;
            }
            if (!n.b(this.trickId, object.trickId)) {
                return i2;
            }
            if (!n.b(this.dogId, object.dogId)) {
                return i2;
            }
            if (Long.compare(updatedAt, updatedAt2) != 0) {
                return i2;
            }
            if (Long.compare(lastViewedAt, lastViewedAt2) != 0) {
                return i2;
            }
            return i;
        }

        public final String getDogId() {
            return this.dogId;
        }

        public final long getLastViewedAt() {
            return this.lastViewedAt;
        }

        public final String getTrickId() {
            return this.trickId;
        }

        public final long getUpdatedAt() {
            return this.updatedAt;
        }

        public int hashCode() {
            return i6 += i10;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("TrickKnowledgeViewData(trickId=");
            stringBuilder.append(this.trickId);
            stringBuilder.append(", dogId=");
            stringBuilder.append(this.dogId);
            stringBuilder.append(", updatedAt=");
            stringBuilder.append(this.updatedAt);
            stringBuilder.append(", lastViewedAt=");
            stringBuilder.append(this.lastViewedAt);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    static {
        TrickProgressEntity.Companion companion = new TrickProgressEntity.Companion(0);
        TrickProgressEntity.Companion = companion;
    }

    public TrickProgressEntity(String string, String string2, long l3, Long long4, Long long5, int i6) {
        n.f(string, "trickId");
        n.f(string2, "dogId");
        super();
        this.trickId = string;
        this.dogId = string2;
        this.updatedAt = l3;
        this.lastViewedAt = long5;
        this.lastRatedAt = i6;
        this.knowledge = obj8;
    }

    public TrickProgressEntity(String string, String string2, long l3, Long long4, Long long5, int i6, int i7, g g8) {
        int i2;
        int i;
        final int i5 = 0;
        i2 = g8 & 8 != 0 ? i5 : long5;
        i = g8 & 16 != 0 ? i5 : i6;
        super(string, string2, l3, obj6, i2, i, i7);
    }

    public static app.dogo.android.persistencedb.room.entity.TrickProgressEntity copy$default(app.dogo.android.persistencedb.room.entity.TrickProgressEntity trickProgressEntity, String string2, String string3, long l4, Long long5, Long long6, int i7, int i8, Object object9) {
        String obj6;
        String obj7;
        long obj8;
        Long obj10;
        Long obj11;
        int obj12;
        if (object9 & 1 != 0) {
            obj6 = trickProgressEntity.trickId;
        }
        if (object9 & 2 != 0) {
            obj7 = trickProgressEntity.dogId;
        }
        if (object9 & 4 != 0) {
            obj8 = trickProgressEntity.updatedAt;
        }
        if (object9 & 8 != 0) {
            obj10 = trickProgressEntity.lastViewedAt;
        }
        if (object9 & 16 != 0) {
            obj11 = trickProgressEntity.lastRatedAt;
        }
        if (object9 & 32 != 0) {
            obj12 = trickProgressEntity.knowledge;
        }
        return trickProgressEntity.copy(obj6, obj7, obj8, obj11, obj10, obj11);
    }

    public final String component1() {
        return this.trickId;
    }

    public final String component2() {
        return this.dogId;
    }

    public final long component3() {
        return this.updatedAt;
    }

    public final Long component4() {
        return this.lastViewedAt;
    }

    public final Long component5() {
        return this.lastRatedAt;
    }

    public final int component6() {
        return this.knowledge;
    }

    public final app.dogo.android.persistencedb.room.entity.TrickProgressEntity copy(String string, String string2, long l3, Long long4, Long long5, int i6) {
        n.f(string, "trickId");
        n.f(string2, "dogId");
        super(string, string2, l3, obj5, long5, i6, obj16);
        return trickProgressEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TrickProgressEntity) {
            return i2;
        }
        if (!n.b(this.trickId, object.trickId)) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.lastViewedAt, object.lastViewedAt)) {
            return i2;
        }
        if (!n.b(this.lastRatedAt, object.lastRatedAt)) {
            return i2;
        }
        if (this.knowledge != object.knowledge) {
            return i2;
        }
        return i;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final int getKnowledge() {
        return this.knowledge;
    }

    public final Long getLastRatedAt() {
        return this.lastRatedAt;
    }

    public final Long getLastViewedAt() {
        return this.lastViewedAt;
    }

    public final String getTrickId() {
        return this.trickId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int i2;
        int i;
        Long lastViewedAt = this.lastViewedAt;
        if (lastViewedAt == null) {
            i2 = i;
        } else {
            i2 = lastViewedAt.hashCode();
        }
        Long lastRatedAt = this.lastRatedAt;
        if (lastRatedAt == null) {
        } else {
            i = lastRatedAt.hashCode();
        }
        return i12 += i16;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickProgressEntity(trickId=");
        stringBuilder.append(this.trickId);
        stringBuilder.append(", dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", lastViewedAt=");
        stringBuilder.append(this.lastViewedAt);
        stringBuilder.append(", lastRatedAt=");
        stringBuilder.append(this.lastRatedAt);
        stringBuilder.append(", knowledge=");
        stringBuilder.append(this.knowledge);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
