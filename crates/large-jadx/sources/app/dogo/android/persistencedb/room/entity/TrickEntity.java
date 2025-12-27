package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrickEntity.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u00082\u0008\u0087\u0008\u0018\u00002\u00020\u0001B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0003\u0012\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017\u0012\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0002\u0010\u0019J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\rHÆ\u0003J\t\u00103\u001a\u00020\u0010HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\u000f\u00109\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017HÆ\u0003J\u000f\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010A\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010 J\t\u0010B\u001a\u00020\rHÆ\u0003JÚ\u0001\u0010C\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\r2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00172\u000e\u0008\u0002\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020\r2\u0008\u0010F\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010G\u001a\u00020\nHÖ\u0001J\t\u0010H\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001bR\u0013\u0010\u0008\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001bR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010!\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001bR\u0017\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010&R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010#R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u001bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010!\u001a\u0004\u0008*\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010-R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u001bR\u0017\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010&R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010\u001b¨\u0006I", d2 = {"Lapp/dogo/android/persistencedb/room/entity/TrickEntity;", "", "trickId", "", "name", "image", "categoryName", "categoryId", "examInstructions", "examTimeLimit", "", "sortOrder", "isExam", "", "hasProgress", "updatedAt", "", "videoId", "videoThumbnail", "description", "locale", "locale_trickId", "imageStepOrder", "", "videoStepOder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getCategoryId", "()Ljava/lang/String;", "getCategoryName", "getDescription", "getExamInstructions", "getExamTimeLimit", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHasProgress", "()Z", "getImage", "getImageStepOrder", "()Ljava/util/List;", "getLocale", "getLocale_trickId", "getName", "getSortOrder", "getTrickId", "getUpdatedAt", "()J", "getVideoId", "getVideoStepOder", "getVideoThumbnail", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ZZJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lapp/dogo/android/persistencedb/room/entity/TrickEntity;", "equals", "other", "hashCode", "toString", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickEntity {

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
    public TrickEntity(String str, String str2, String str3, String str4, String str5, String str6, Integer integer, Integer integer2, boolean z, boolean z2, long j, String str7, String str8, String str9, String str10, String str11, List<String> list, List<String> list2) {
        final Object str82 = this;
        final Object str52 = str5;
        final Object str162 = str10;
        final Object list172 = str11;
        final Object list182 = list;
        final Object obj = list2;
        n.f(str, "trickId");
        n.f(str2, "name");
        n.f(str3, "image");
        n.f(str4, "categoryName");
        n.f(str52, "categoryId");
        n.f(str162, "locale");
        n.f(list172, "locale_trickId");
        n.f(list182, "imageStepOrder");
        n.f(obj, "videoStepOder");
        super();
        str82.trickId = str;
        str82.name = str2;
        str82.image = str3;
        str82.categoryName = str4;
        str82.categoryId = str52;
        str82.examInstructions = str6;
        str82.examTimeLimit = integer;
        str82.sortOrder = integer2;
        str82.isExam = z;
        str82.hasProgress = z2;
        str82.updatedAt = j;
        str82.videoId = str7;
        str82.videoThumbnail = str8;
        str82.description = str9;
        str82.locale = str162;
        str82.locale_trickId = list172;
        str82.imageStepOrder = list182;
        str82.videoStepOder = obj;
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

    public final boolean isExam() {
        return this.isExam;
    }

    public /* synthetic */ TrickEntity(String str, String str2, String str3, String str4, String str5, String str6, Integer integer, Integer integer2, boolean z, boolean z2, long j, String str7, String str8, String str9, String str10, String str11, List list, List list2, int i, g gVar) {
        String str62;
        Integer integer72;
        Integer integer82;
        boolean z102;
        String str132;
        String str142;
        String str152;
        Object list172;
        int gVar202 = i;
        int i2 = 0;
        int r9 = gVar202 & 32 != 0 ? i2 : str6;
        int r10 = gVar202 & 64 != 0 ? i2 : integer;
        int r11 = gVar202 & 128 != 0 ? i2 : integer2;
        i = gVar202 & 512;
        i = gVar202 & 512 != 0 ? i : z2;
        int r16 = gVar202 & 2048 != 0 ? i2 : str7;
        int r17 = gVar202 & 4096 != 0 ? i2 : str8;
        int r18 = gVar202 & 8192 != 0 ? i2 : str9;
        if (gVar202 & 32768 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str162 = str10;
            str8 = str;
            str7 = str162 + 95 + str8;
        } else {
            str8 = str;
            str162 = str10;
            list172 = str11;
        }
        this(str, str2, str3, str4, str5, str62, integer72, integer82, z, z102, j, str10, str132, str142, str152, str10, list172, list, list2);
    }

    public static /* synthetic */ TrickEntity copy$default(TrickEntity trickEntity, String str, String str2, String str3, String str4, String str5, String str6, Integer integer, Integer integer2, boolean z, boolean z2, long j, String str7, String str8, String str9, String str10, String str11, List list, List list2, int i, Object object) {
        List i202;
        String str22;
        String str32;
        String str42;
        String str52;
        String str62;
        String str72;
        Integer integer82;
        Integer integer92;
        boolean z102;
        boolean z112;
        long j122;
        String str142;
        String str152;
        String str162;
        String str172;
        String list182;
        List list192;
        Object trickEntity2 = trickEntity;
        int object212 = i;
        String r2 = object212 & 1 != 0 ? trickEntity2.trickId : str;
        String r3 = object212 & 2 != 0 ? trickEntity2.name : str2;
        String r4 = object212 & 4 != 0 ? trickEntity2.image : str3;
        String r5 = object212 & 8 != 0 ? trickEntity2.categoryName : str4;
        String r6 = object212 & 16 != 0 ? trickEntity2.categoryId : str5;
        String r7 = object212 & 32 != 0 ? trickEntity2.examInstructions : str6;
        Integer r8 = object212 & 64 != 0 ? trickEntity2.examTimeLimit : integer;
        Integer r9 = object212 & 128 != 0 ? trickEntity2.sortOrder : integer2;
        boolean r10 = object212 & 256 != 0 ? trickEntity2.isExam : z;
        boolean r11 = object212 & 512 != 0 ? trickEntity2.hasProgress : z2;
        long r12 = object212 & 1024 != 0 ? trickEntity2.updatedAt : j;
        String r14 = object212 & 2048 != 0 ? trickEntity2.videoId : str7;
        String r15 = object212 & 4096 != 0 ? trickEntity2.videoThumbnail : str8;
        r15 = object212 & 8192 != 0 ? trickEntity2.description : str9;
        r15 = object212 & 16384 != 0 ? trickEntity2.locale : str10;
        r15 = object212 & 32768 != 0 ? trickEntity2.locale_trickId : str11;
        r15 = object212 & 65536 != 0 ? trickEntity2.imageStepOrder : list;
        List r1 = object212 & 131072 != 0 ? trickEntity2.videoStepOder : list2;
        return trickEntity.copy(str22, str32, str42, str52, str62, str72, integer82, integer92, z102, z112, j122, r29, str142, (object212 & 4096 != 0 ? trickEntity2.videoThumbnail : str8), (object212 & 8192 != 0 ? trickEntity2.description : str9), (object212 & 16384 != 0 ? trickEntity2.locale : str10), (object212 & 32768 != 0 ? trickEntity2.locale_trickId : str11), list192, (object212 & 131072 != 0 ? trickEntity2.videoStepOder : list2));
    }

    /* operator */ public final String component1() {
        return this.trickId;
    }

    /* operator */ public final boolean component10() {
        return this.hasProgress;
    }

    /* operator */ public final long component11() {
        return this.updatedAt;
    }

    /* operator */ public final String component12() {
        return this.videoId;
    }

    /* operator */ public final String component13() {
        return this.videoThumbnail;
    }

    /* operator */ public final String component14() {
        return this.description;
    }

    /* operator */ public final String component15() {
        return this.locale;
    }

    /* operator */ public final String component16() {
        return this.locale_trickId;
    }

    /* operator */ public final List<String> component17() {
        return this.imageStepOrder;
    }

    /* operator */ public final List<String> component18() {
        return this.videoStepOder;
    }

    /* operator */ public final String component2() {
        return this.name;
    }

    /* operator */ public final String component3() {
        return this.image;
    }

    /* operator */ public final String component4() {
        return this.categoryName;
    }

    /* operator */ public final String component5() {
        return this.categoryId;
    }

    /* operator */ public final String component6() {
        return this.examInstructions;
    }

    /* operator */ public final Integer component7() {
        return this.examTimeLimit;
    }

    /* operator */ public final Integer component8() {
        return this.sortOrder;
    }

    /* operator */ public final boolean component9() {
        return this.isExam;
    }

    public final TrickEntity copy(String trickId, String name, String image, String categoryName, String categoryId, String examInstructions, Integer examTimeLimit, Integer sortOrder, boolean isExam, boolean hasProgress, long updatedAt, String videoId, String videoThumbnail, String description, String locale, String locale_trickId, List<String> imageStepOrder, List<String> videoStepOder) {
        Object trickId2 = trickId;
        n.f(trickId2, "trickId");
        n.f(name, "name");
        n.f(image, "image");
        n.f(categoryName, "categoryName");
        n.f(categoryId, "categoryId");
        n.f(locale, "locale");
        n.f(locale_trickId, "locale_trickId");
        n.f(imageStepOrder, "imageStepOrder");
        n.f(videoStepOder, "videoStepOder");
        TrickEntity trickEntity = new TrickEntity(trickId2, name, image, categoryName, categoryId, examInstructions, examTimeLimit, sortOrder, isExam, hasProgress, updatedAt, str11, videoId, videoThumbnail, description, locale, locale_trickId, imageStepOrder, videoStepOder);
        return trickEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z17 = false;
        if (!(other instanceof TrickEntity)) {
            return false;
        }
        if (!n.b(this.trickId, other.trickId)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.image, other.image)) {
            return false;
        }
        if (!n.b(this.categoryName, other.categoryName)) {
            return false;
        }
        if (!n.b(this.categoryId, other.categoryId)) {
            return false;
        }
        if (!n.b(this.examInstructions, other.examInstructions)) {
            return false;
        }
        if (!n.b(this.examTimeLimit, other.examTimeLimit)) {
            return false;
        }
        if (!n.b(this.sortOrder, other.sortOrder)) {
            return false;
        }
        if (this.isExam != other.isExam) {
            return false;
        }
        if (this.hasProgress != other.hasProgress) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        if (!n.b(this.videoId, other.videoId)) {
            return false;
        }
        if (!n.b(this.videoThumbnail, other.videoThumbnail)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (!n.b(this.locale_trickId, other.locale_trickId)) {
            return false;
        }
        if (!n.b(this.imageStepOrder, other.imageStepOrder)) {
            return false;
        }
        return !n.b(this.videoStepOder, other.videoStepOder) ? z17 : z;
    }

    public int hashCode() {
        int i;
        boolean isExam2;
        int i2 = 1;
        i = 0;
        if (this.examInstructions == null) {
        } else {
            i = this.examInstructions.hashCode();
        }
        if (this.examTimeLimit == null) {
        } else {
            i = this.examTimeLimit.hashCode();
        }
        if (this.sortOrder == null) {
        } else {
            i = this.sortOrder.hashCode();
        }
        i2 = 1;
        if (this.isExam) {
        }
        if (!(this.hasProgress)) {
        }
        if (this.videoId == null) {
        } else {
            i = this.videoId.hashCode();
        }
        if (this.videoThumbnail == null) {
        } else {
            i = this.videoThumbnail.hashCode();
        }
        if (this.description != null) {
            i = this.description.hashCode();
        }
        return (this.trickId.hashCode() * 31) + this.name.hashCode() * 31 + this.image.hashCode() * 31 + this.categoryName.hashCode() * 31 + this.categoryId.hashCode() * 31 + i * 31 + i * 31 + i * 31 + isExam2 * 31 + i2 * 31 + Long.hashCode(this.updatedAt) * 31 + i * 31 + i * 31 + i * 31 + this.locale.hashCode() * 31 + this.locale_trickId.hashCode() * 31 + this.imageStepOrder.hashCode() * 31 + this.videoStepOder.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickEntity(trickId=";
        String str3 = ", name=";
        String str4 = ", image=";
        String str5 = ", categoryName=";
        String str6 = ", categoryId=";
        String str7 = ", examInstructions=";
        String str8 = ", examTimeLimit=";
        String str9 = ", sortOrder=";
        String str10 = ", isExam=";
        String str11 = ", hasProgress=";
        String str12 = ", updatedAt=";
        String str13 = ", videoId=";
        String str14 = ", videoThumbnail=";
        String str15 = ", description=";
        String str16 = ", locale=";
        String str17 = ", locale_trickId=";
        String str18 = ", imageStepOrder=";
        String str19 = ", videoStepOder=";
        str = str2 + this.trickId + str3 + this.name + str4 + this.image + str5 + this.categoryName + str6 + this.categoryId + str7 + this.examInstructions + str8 + this.examTimeLimit + str9 + this.sortOrder + str10 + this.isExam + str11 + this.hasProgress + str12 + this.updatedAt + str13 + this.videoId + str14 + this.videoThumbnail + str15 + this.description + str16 + this.locale + str17 + this.locale_trickId + str18 + this.imageStepOrder + str19 + this.videoStepOder + 41;
        return str;
    }
}
