package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u00082\u0008\u0087\u0008\u0018\u00002\u00020\u0001B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0003\u0012\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017\u0012\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0002\u0010\u0019J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\rHÆ\u0003J\t\u00103\u001a\u00020\u0010HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000f\u00109\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017HÆ\u0003J\u000f\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010A\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010 J\t\u0010B\u001a\u00020\rHÆ\u0003JÚ\u0001\u0010C\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00172\u000e\u0008\u0002\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\r2\u0008\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\nHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001bR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001bR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010!\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001bR\u0017\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010#R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u001bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010!\u001a\u0004\u0008*\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010-R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u001bR\u0017\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010\u001b¨\u0006I", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickEntity;", "", "trickId", "", "name", "image", "categoryName", "categoryId", "examInstructions", "examTimeLimit", "", "sortOrder", "isExam", "", "hasProgress", "updatedAt", "", "videoId", "videoThumbnail", "description", "locale", "locale_trickId", "imageStepOrder", "", "videoStepOder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getCategoryId", "()Ljava/lang/String;", "getCategoryName", "getDescription", "getExamInstructions", "getExamTimeLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasProgress", "()Z", "getImage", "getImageStepOrder", "()Ljava/util/List;", "getLocale", "getLocale_trickId", "getName", "getSortOrder", "getTrickId", "getUpdatedAt", "()J", "getVideoId", "getVideoStepOder", "getVideoThumbnail", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lapp/dogo/android/persistencedb/room/entity/TrickEntity;", "equals", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickEntity {

    private final String categoryId;
    private final String categoryName;
    private final String description;
    private final String examInstructions;
    private final Integer examTimeLimit;
    private final boolean hasProgress;
    private final String image;
    private final List<String> imageStepOrder;
    private final boolean isExam;
    private final String locale;
    private final String locale_trickId;
    private final String name;
    private final Integer sortOrder;
    private final String trickId;
    private final long updatedAt;
    private final String videoId;
    private final List<String> videoStepOder;
    private final String videoThumbnail;
    public TrickEntity(String string, String string2, String string3, String string4, String string5, String string6, Integer integer7, Integer integer8, boolean z9, boolean z10, long l11, String string12, String string13, String string14, String string15, String string16, List<String> list17, List<String> list18) {
        final Object obj = this;
        final Object obj2 = string5;
        final Object obj3 = string16;
        final Object obj4 = list17;
        final Object obj5 = list18;
        final Object obj6 = obj30;
        n.f(string, "trickId");
        n.f(string2, "name");
        n.f(string3, "image");
        n.f(string4, "categoryName");
        n.f(obj2, "categoryId");
        n.f(obj3, "locale");
        n.f(obj4, "locale_trickId");
        n.f(obj5, "imageStepOrder");
        n.f(obj6, "videoStepOder");
        super();
        obj.trickId = string;
        obj.name = string2;
        obj.image = string3;
        obj.categoryName = string4;
        obj.categoryId = obj2;
        obj.examInstructions = string6;
        obj.examTimeLimit = integer7;
        obj.sortOrder = integer8;
        obj.isExam = z9;
        obj.hasProgress = z10;
        obj.updatedAt = l11;
        obj.videoId = string13;
        obj.videoThumbnail = string14;
        obj.description = string15;
        obj.locale = obj3;
        obj.locale_trickId = obj4;
        obj.imageStepOrder = obj5;
        obj.videoStepOder = obj6;
    }

    public TrickEntity(String string, String string2, String string3, String string4, String string5, String string6, Integer integer7, Integer integer8, boolean z9, boolean z10, long l11, String string12, String string13, String string14, String string15, String string16, List list17, List list18, int i19, g g20) {
        String string7;
        int i4;
        String str2;
        String str3;
        int i5;
        int i7;
        int i6;
        int i8;
        int i;
        int i2;
        int i3;
        String str;
        int i9 = g20;
        int i17 = 0;
        i5 = i9 & 32 != 0 ? i17 : string6;
        i7 = i9 & 64 != 0 ? i17 : integer7;
        i6 = i9 & 128 != 0 ? i17 : integer8;
        i8 = i9 & 512 != 0 ? i4 : z10;
        i = i9 & 2048 != 0 ? i17 : string13;
        i2 = i9 & 4096 != 0 ? i17 : string14;
        i3 = i9 & 8192 != 0 ? i17 : string15;
        if (i9 &= i16 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string16);
            stringBuilder.append('_');
            stringBuilder.append(string);
            str = string7;
        } else {
            str3 = string;
            str2 = string16;
            str = list17;
        }
        super(string, string2, string3, string4, string5, i5, i7, i6, z9, i8, l11, obj15, i, i2, i3, string16, str, list18, i19);
    }

    public static app.dogo.android.persistencedb.room.entity.TrickEntity copy$default(app.dogo.android.persistencedb.room.entity.TrickEntity trickEntity, String string2, String string3, String string4, String string5, String string6, String string7, Integer integer8, Integer integer9, boolean z10, boolean z11, long l12, String string13, String string14, String string15, String string16, String string17, List list18, List list19, int i20, Object object21) {
        List videoStepOder;
        String trickId;
        String name;
        String image;
        String categoryName;
        String categoryId;
        String examInstructions;
        Integer examTimeLimit;
        Integer sortOrder;
        boolean isExam;
        boolean hasProgress;
        long updatedAt;
        String videoId;
        String videoThumbnail;
        String description;
        String locale;
        String locale_trickId;
        List imageStepOrder;
        Object obj = trickEntity;
        int i = object21;
        trickId = i & 1 != 0 ? obj.trickId : string2;
        name = i & 2 != 0 ? obj.name : string3;
        image = i & 4 != 0 ? obj.image : string4;
        categoryName = i & 8 != 0 ? obj.categoryName : string5;
        categoryId = i & 16 != 0 ? obj.categoryId : string6;
        examInstructions = i & 32 != 0 ? obj.examInstructions : string7;
        examTimeLimit = i & 64 != 0 ? obj.examTimeLimit : integer8;
        sortOrder = i & 128 != 0 ? obj.sortOrder : integer9;
        isExam = i & 256 != 0 ? obj.isExam : z10;
        hasProgress = i & 512 != 0 ? obj.hasProgress : z11;
        updatedAt = i & 1024 != 0 ? obj.updatedAt : l12;
        videoId = i & 2048 != 0 ? obj.videoId : string14;
        videoThumbnail = i & 4096 != 0 ? obj.videoThumbnail : string15;
        description = i & 8192 != 0 ? obj.description : string16;
        locale = i & 16384 != 0 ? obj.locale : string17;
        locale_trickId = i & i18 != 0 ? obj.locale_trickId : list18;
        imageStepOrder = i & i21 != 0 ? obj.imageStepOrder : list19;
        videoStepOder = i &= i23 != 0 ? obj.videoStepOder : i20;
        return trickEntity.copy(trickId, name, image, categoryName, categoryId, examInstructions, examTimeLimit, sortOrder, isExam, hasProgress, updatedAt, string13, videoId, videoThumbnail, description, locale, locale_trickId, imageStepOrder);
    }

    public final String component1() {
        return this.trickId;
    }

    public final boolean component10() {
        return this.hasProgress;
    }

    public final long component11() {
        return this.updatedAt;
    }

    public final String component12() {
        return this.videoId;
    }

    public final String component13() {
        return this.videoThumbnail;
    }

    public final String component14() {
        return this.description;
    }

    public final String component15() {
        return this.locale;
    }

    public final String component16() {
        return this.locale_trickId;
    }

    public final List<String> component17() {
        return this.imageStepOrder;
    }

    public final List<String> component18() {
        return this.videoStepOder;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.categoryName;
    }

    public final String component5() {
        return this.categoryId;
    }

    public final String component6() {
        return this.examInstructions;
    }

    public final Integer component7() {
        return this.examTimeLimit;
    }

    public final Integer component8() {
        return this.sortOrder;
    }

    public final boolean component9() {
        return this.isExam;
    }

    public final app.dogo.android.persistencedb.room.entity.TrickEntity copy(String string, String string2, String string3, String string4, String string5, String string6, Integer integer7, Integer integer8, boolean z9, boolean z10, long l11, String string12, String string13, String string14, String string15, String string16, List<String> list17, List<String> list18) {
        Object obj = string;
        n.f(obj, "trickId");
        n.f(string2, "name");
        n.f(string3, "image");
        n.f(string4, "categoryName");
        n.f(string5, "categoryId");
        n.f(string16, "locale");
        n.f(list17, "locale_trickId");
        n.f(list18, "imageStepOrder");
        n.f(obj41, "videoStepOder");
        super(obj, string2, string3, string4, string5, string6, integer7, integer8, z9, z10, l11, obj12, string13, string14, string15, string16, list17, list18, obj41);
        return trickEntity2;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof TrickEntity) {
            return i2;
        }
        if (!n.b(this.trickId, object.trickId)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.image, object.image)) {
            return i2;
        }
        if (!n.b(this.categoryName, object.categoryName)) {
            return i2;
        }
        if (!n.b(this.categoryId, object.categoryId)) {
            return i2;
        }
        if (!n.b(this.examInstructions, object.examInstructions)) {
            return i2;
        }
        if (!n.b(this.examTimeLimit, object.examTimeLimit)) {
            return i2;
        }
        if (!n.b(this.sortOrder, object.sortOrder)) {
            return i2;
        }
        if (this.isExam != object.isExam) {
            return i2;
        }
        if (this.hasProgress != object.hasProgress) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.videoId, object.videoId)) {
            return i2;
        }
        if (!n.b(this.videoThumbnail, object.videoThumbnail)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (!n.b(this.locale_trickId, object.locale_trickId)) {
            return i2;
        }
        if (!n.b(this.imageStepOrder, object.imageStepOrder)) {
            return i2;
        }
        if (!n.b(this.videoStepOder, object.videoStepOder)) {
            return i2;
        }
        return i;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getExamInstructions() {
        return this.examInstructions;
    }

    public final Integer getExamTimeLimit() {
        return this.examTimeLimit;
    }

    public final boolean getHasProgress() {
        return this.hasProgress;
    }

    public final String getImage() {
        return this.image;
    }

    public final List<String> getImageStepOrder() {
        return this.imageStepOrder;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_trickId() {
        return this.locale_trickId;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getSortOrder() {
        return this.sortOrder;
    }

    public final String getTrickId() {
        return this.trickId;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final List<String> getVideoStepOder() {
        return this.videoStepOder;
    }

    public final String getVideoThumbnail() {
        return this.videoThumbnail;
    }

    public int hashCode() {
        int i4;
        int i5;
        int i;
        boolean isExam;
        int i3;
        int i7;
        int i6;
        int i2;
        String examInstructions = this.examInstructions;
        i6 = 0;
        if (examInstructions == null) {
            i4 = i6;
        } else {
            i4 = examInstructions.hashCode();
        }
        Integer examTimeLimit = this.examTimeLimit;
        if (examTimeLimit == null) {
            i5 = i6;
        } else {
            i5 = examTimeLimit.hashCode();
        }
        Integer sortOrder = this.sortOrder;
        if (sortOrder == null) {
            i = i6;
        } else {
            i = sortOrder.hashCode();
        }
        if (this.isExam) {
            isExam = i2;
        }
        boolean hasProgress = this.hasProgress;
        if (hasProgress) {
        } else {
            i2 = hasProgress;
        }
        String videoId = this.videoId;
        if (videoId == null) {
            i3 = i6;
        } else {
            i3 = videoId.hashCode();
        }
        String videoThumbnail = this.videoThumbnail;
        if (videoThumbnail == null) {
            i7 = i6;
        } else {
            i7 = videoThumbnail.hashCode();
        }
        String description = this.description;
        if (description == null) {
        } else {
            i6 = description.hashCode();
        }
        return i41 += i51;
    }

    public final boolean isExam() {
        return this.isExam;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickEntity(trickId=");
        stringBuilder.append(this.trickId);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", image=");
        stringBuilder.append(this.image);
        stringBuilder.append(", categoryName=");
        stringBuilder.append(this.categoryName);
        stringBuilder.append(", categoryId=");
        stringBuilder.append(this.categoryId);
        stringBuilder.append(", examInstructions=");
        stringBuilder.append(this.examInstructions);
        stringBuilder.append(", examTimeLimit=");
        stringBuilder.append(this.examTimeLimit);
        stringBuilder.append(", sortOrder=");
        stringBuilder.append(this.sortOrder);
        stringBuilder.append(", isExam=");
        stringBuilder.append(this.isExam);
        stringBuilder.append(", hasProgress=");
        stringBuilder.append(this.hasProgress);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", videoId=");
        stringBuilder.append(this.videoId);
        stringBuilder.append(", videoThumbnail=");
        stringBuilder.append(this.videoThumbnail);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", locale_trickId=");
        stringBuilder.append(this.locale_trickId);
        stringBuilder.append(", imageStepOrder=");
        stringBuilder.append(this.imageStepOrder);
        stringBuilder.append(", videoStepOder=");
        stringBuilder.append(this.videoStepOder);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
