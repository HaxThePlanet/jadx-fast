package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0016B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0010J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0017", d2 = {"Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity;", "", "dogId", "", "recommendedProgramIds", "", "Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity$ProgramCompatibility;", "(Ljava/lang/String;Ljava/util/List;)V", "getDogId", "()Ljava/lang/String;", "getRecommendedProgramIds", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "isEmpty", "toString", "ProgramCompatibility", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RecommendedListOrderEntity {

    private final String dogId;
    private final List<app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility> recommendedProgramIds;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0008J$\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0015", d2 = {"Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity$ProgramCompatibility;", "", "programId", "", "compatibility", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCompatibility", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProgramId", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity$ProgramCompatibility;", "equals", "", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramCompatibility {

        private final Integer compatibility;
        private final String programId;
        public ProgramCompatibility(String string, Integer integer2) {
            n.f(string, "programId");
            super();
            this.programId = string;
            this.compatibility = integer2;
        }

        public ProgramCompatibility(String string, Integer integer2, int i3, g g4) {
            int obj2;
            obj2 = i3 &= 2 != 0 ? 0 : obj2;
            super(string, obj2);
        }

        public static app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility copy$default(app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility recommendedListOrderEntity$ProgramCompatibility, String string2, Integer integer3, int i4, Object object5) {
            String obj1;
            Integer obj2;
            if (i4 & 1 != 0) {
                obj1 = programCompatibility.programId;
            }
            if (i4 &= 2 != 0) {
                obj2 = programCompatibility.compatibility;
            }
            return programCompatibility.copy(obj1, obj2);
        }

        public final String component1() {
            return this.programId;
        }

        public final Integer component2() {
            return this.compatibility;
        }

        public final app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility copy(String string, Integer integer2) {
            n.f(string, "programId");
            RecommendedListOrderEntity.ProgramCompatibility programCompatibility = new RecommendedListOrderEntity.ProgramCompatibility(string, integer2);
            return programCompatibility;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof RecommendedListOrderEntity.ProgramCompatibility) {
                return i2;
            }
            if (!n.b(this.programId, object.programId)) {
                return i2;
            }
            if (!n.b(this.compatibility, object.compatibility)) {
                return i2;
            }
            return i;
        }

        public final Integer getCompatibility() {
            return this.compatibility;
        }

        public final String getProgramId() {
            return this.programId;
        }

        public int hashCode() {
            int i;
            Integer compatibility = this.compatibility;
            if (compatibility == null) {
                i = 0;
            } else {
                i = compatibility.hashCode();
            }
            return i3 += i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ProgramCompatibility(programId=");
            stringBuilder.append(this.programId);
            stringBuilder.append(", compatibility=");
            stringBuilder.append(this.compatibility);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    public RecommendedListOrderEntity(String string, List<app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility> list2) {
        n.f(string, "dogId");
        n.f(list2, "recommendedProgramIds");
        super();
        this.dogId = string;
        this.recommendedProgramIds = list2;
    }

    public static app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity copy$default(app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity recommendedListOrderEntity, String string2, List list3, int i4, Object object5) {
        String obj1;
        List obj2;
        if (i4 & 1 != 0) {
            obj1 = recommendedListOrderEntity.dogId;
        }
        if (i4 &= 2 != 0) {
            obj2 = recommendedListOrderEntity.recommendedProgramIds;
        }
        return recommendedListOrderEntity.copy(obj1, obj2);
    }

    public final String component1() {
        return this.dogId;
    }

    public final List<app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility> component2() {
        return this.recommendedProgramIds;
    }

    public final app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity copy(String string, List<app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility> list2) {
        n.f(string, "dogId");
        n.f(list2, "recommendedProgramIds");
        RecommendedListOrderEntity recommendedListOrderEntity = new RecommendedListOrderEntity(string, list2);
        return recommendedListOrderEntity;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof RecommendedListOrderEntity) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.recommendedProgramIds, object.recommendedProgramIds)) {
            return i2;
        }
        return i;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final List<app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility> getRecommendedProgramIds() {
        return this.recommendedProgramIds;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public final boolean isEmpty() {
        return this.recommendedProgramIds.isEmpty();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RecommendedListOrderEntity(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", recommendedProgramIds=");
        stringBuilder.append(this.recommendedProgramIds);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
