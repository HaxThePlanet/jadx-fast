package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u00083\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0087\u0008\u0018\u0000 Q2\u00020\u0001:\u0001QB×\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u000e\u0008\u0002\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018\u0012\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u0018\u0012\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0002\u0010\u001bJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0010HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000f\u0010<\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\u000f\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\u000f\u0010>\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\t\u0010?\u001a\u00020\u0018HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0018HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003Jí\u0001\u0010J\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00142\u000e\u0008\u0002\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00142\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00142\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0003HÆ\u0001J\u0013\u0010K\u001a\u00020L2\u0008\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\u0018HÖ\u0001J\u0006\u0010O\u001a\u00020LJ\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u001fR\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001fR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\u001fR\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010(R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u001fR\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u00103R\u0017\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010(¨\u0006R", d2 = {"Lapp/dogo/android/persistencedb/room/entity/ProgramEntity;", "", "type", "", "programId", "name", "image", "centeredImage", "description", "cardBackgroundColor", "certificateLaurelsImage", "certificatePaperImage", "certificatePlaceholderUrl", "certificateRequirements", "locale", "updatedAt", "", "locale_programId", "programOverviewImage", "dogSkillsHighlights", "", "dogSkillsOverview", "userSkillsOverview", "averageCompletionTimeWeeks", "", "numberOfEnrolledUsers", "certificatePreviewImage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;IILjava/lang/String;)V", "getAverageCompletionTimeWeeks", "()I", "getCardBackgroundColor", "()Ljava/lang/String;", "getCenteredImage", "getCertificateLaurelsImage", "getCertificatePaperImage", "getCertificatePlaceholderUrl", "getCertificatePreviewImage", "getCertificateRequirements", "getDescription", "getDogSkillsHighlights", "()Ljava/util/List;", "getDogSkillsOverview", "getImage", "getLocale", "getLocale_programId", "getName", "getNumberOfEnrolledUsers", "getProgramId", "getProgramOverviewImage", "getType", "getUpdatedAt", "()J", "getUserSkillsOverview", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "isClassicProgram", "toString", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramEntity {

    public static final String CLASSIC_PROGRAM_TYPE = "classic";
    public static final app.dogo.android.persistencedb.room.entity.ProgramEntity.Companion Companion;
    private final int averageCompletionTimeWeeks;
    private final String cardBackgroundColor;
    private final String centeredImage;
    private final String certificateLaurelsImage;
    private final String certificatePaperImage;
    private final String certificatePlaceholderUrl;
    private final String certificatePreviewImage;
    private final String certificateRequirements;
    private final String description;
    private final List<String> dogSkillsHighlights;
    private final List<String> dogSkillsOverview;
    private final String image;
    private final String locale;
    private final String locale_programId;
    private final String name;
    private final int numberOfEnrolledUsers;
    private final String programId;
    private final String programOverviewImage;
    private final String type;
    private final long updatedAt;
    private final List<String> userSkillsOverview;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/android/persistencedb/room/entity/ProgramEntity$Companion;", "", "()V", "CLASSIC_PROGRAM_TYPE", "", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }
    static {
        ProgramEntity.Companion companion = new ProgramEntity.Companion(0);
        ProgramEntity.Companion = companion;
    }

    public ProgramEntity(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, long l13, String string14, String string15, List<String> list16, List<String> list17, List<String> list18, int i19, int i20, String string21) {
        Object obj = this;
        Object obj4 = string;
        Object obj5 = string2;
        final Object obj6 = string3;
        final Object obj7 = string4;
        final Object obj8 = string5;
        final Object obj9 = string6;
        final Object obj10 = string7;
        final Object obj11 = string8;
        final Object obj12 = string9;
        final Object obj13 = string10;
        final Object obj14 = string11;
        final Object obj15 = string12;
        final Object obj16 = string15;
        final Object obj17 = list16;
        Object obj2 = list18;
        n.f(obj4, "type");
        n.f(obj5, "programId");
        n.f(obj6, "name");
        n.f(obj7, "image");
        n.f(obj8, "centeredImage");
        n.f(obj9, "description");
        n.f(obj10, "cardBackgroundColor");
        n.f(obj11, "certificateLaurelsImage");
        n.f(obj12, "certificatePaperImage");
        n.f(obj13, "certificatePlaceholderUrl");
        n.f(obj14, "certificateRequirements");
        n.f(obj15, "locale");
        n.f(obj16, "locale_programId");
        n.f(obj17, "programOverviewImage");
        n.f(list17, "dogSkillsHighlights");
        n.f(list18, "dogSkillsOverview");
        n.f(i19, "userSkillsOverview");
        n.f(obj38, "certificatePreviewImage");
        super();
        Object obj3 = this;
        obj3.type = obj4;
        obj3.programId = obj5;
        obj3.name = obj6;
        obj3.image = obj7;
        obj3.centeredImage = obj8;
        obj3.description = obj9;
        obj3.cardBackgroundColor = obj10;
        obj3.certificateLaurelsImage = obj11;
        obj3.certificatePaperImage = obj12;
        obj3.certificatePlaceholderUrl = obj13;
        obj3.certificateRequirements = obj14;
        obj3.locale = obj15;
        obj3.updatedAt = l13;
        obj3.locale_programId = obj16;
        obj3.programOverviewImage = obj17;
        obj3.dogSkillsHighlights = list17;
        obj3.dogSkillsOverview = list18;
        obj3.userSkillsOverview = i19;
        obj3.averageCompletionTimeWeeks = i20;
        obj3.numberOfEnrolledUsers = string21;
        obj3.certificatePreviewImage = obj38;
    }

    public ProgramEntity(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, long l13, String string14, String string15, List list16, List list17, List list18, int i19, int i20, String string21, int i22, g g23) {
        int string13;
        int i3;
        List i;
        List i6;
        int i2;
        String str3;
        String str8;
        String str;
        String str9;
        String str4;
        String str2;
        String str7;
        String str6;
        List list3;
        List list2;
        List list;
        int i4;
        int i5;
        String str5;
        int i7 = g23;
        final String str10 = "";
        str8 = i7 & 128 != 0 ? str10 : string8;
        str = i7 & 256 != 0 ? str10 : string9;
        str9 = i7 & 512 != 0 ? str10 : string10;
        str4 = i7 & 1024 != 0 ? str10 : string11;
        if (i7 & 8192 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string12);
            stringBuilder.append('_');
            stringBuilder.append(string2);
            str7 = string13;
        } else {
            str3 = string2;
            str2 = string12;
            str7 = string15;
        }
        str6 = i7 & 16384 != 0 ? str10 : list16;
        if (i14 &= i7 != 0) {
            list3 = i3;
        } else {
            list3 = list17;
        }
        if (i15 &= i7 != 0) {
            list2 = i;
        } else {
            list2 = list18;
        }
        if (i16 &= i7 != 0) {
            list = i6;
        } else {
            list = i19;
        }
        int i25 = 0;
        i4 = i17 &= i7 != 0 ? i25 : i20;
        i5 = i21 &= i7 != 0 ? i25 : string21;
        str5 = i7 &= i24 != 0 ? str10 : i22;
        super(string, string2, string3, string4, string5, string6, string7, str8, str, str9, str4, string12, l13, obj17, str7, str6, list3, list2, list, i4, i5, str5);
    }

    public static app.dogo.android.persistencedb.room.entity.ProgramEntity copy$default(app.dogo.android.persistencedb.room.entity.ProgramEntity programEntity, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, String string13, long l14, String string15, String string16, List list17, List list18, List list19, int i20, int i21, String string22, int i23, Object object24) {
        String certificatePreviewImage;
        String type;
        String programId;
        String name;
        String image;
        String centeredImage;
        String description;
        String cardBackgroundColor;
        String certificateLaurelsImage;
        String certificatePaperImage;
        String certificatePlaceholderUrl;
        String certificateRequirements;
        String locale;
        long updatedAt;
        String locale_programId;
        String programOverviewImage;
        List dogSkillsHighlights;
        List dogSkillsOverview;
        List userSkillsOverview;
        int averageCompletionTimeWeeks;
        int numberOfEnrolledUsers;
        Object obj = programEntity;
        int i = object24;
        type = i & 1 != 0 ? obj.type : string2;
        programId = i & 2 != 0 ? obj.programId : string3;
        name = i & 4 != 0 ? obj.name : string4;
        image = i & 8 != 0 ? obj.image : string5;
        centeredImage = i & 16 != 0 ? obj.centeredImage : string6;
        description = i & 32 != 0 ? obj.description : string7;
        cardBackgroundColor = i & 64 != 0 ? obj.cardBackgroundColor : string8;
        certificateLaurelsImage = i & 128 != 0 ? obj.certificateLaurelsImage : string9;
        certificatePaperImage = i & 256 != 0 ? obj.certificatePaperImage : string10;
        certificatePlaceholderUrl = i & 512 != 0 ? obj.certificatePlaceholderUrl : string11;
        certificateRequirements = i & 1024 != 0 ? obj.certificateRequirements : string12;
        locale = i & 2048 != 0 ? obj.locale : string13;
        updatedAt = i & 4096 != 0 ? obj.updatedAt : l14;
        locale_programId = i & 8192 != 0 ? obj.locale_programId : string16;
        programOverviewImage = i & 16384 != 0 ? obj.programOverviewImage : list17;
        dogSkillsHighlights = i & i18 != 0 ? obj.dogSkillsHighlights : list18;
        dogSkillsOverview = i & i22 != 0 ? obj.dogSkillsOverview : list19;
        userSkillsOverview = i & i25 != 0 ? obj.userSkillsOverview : i20;
        averageCompletionTimeWeeks = i & i27 != 0 ? obj.averageCompletionTimeWeeks : i21;
        numberOfEnrolledUsers = i & i29 != 0 ? obj.numberOfEnrolledUsers : string22;
        certificatePreviewImage = i &= i31 != 0 ? obj.certificatePreviewImage : i23;
        return programEntity.copy(type, programId, name, image, centeredImage, description, cardBackgroundColor, certificateLaurelsImage, certificatePaperImage, certificatePlaceholderUrl, certificateRequirements, locale, updatedAt, string15, locale_programId, programOverviewImage, dogSkillsHighlights, dogSkillsOverview, userSkillsOverview, averageCompletionTimeWeeks, numberOfEnrolledUsers);
    }

    public final String component1() {
        return this.type;
    }

    public final String component10() {
        return this.certificatePlaceholderUrl;
    }

    public final String component11() {
        return this.certificateRequirements;
    }

    public final String component12() {
        return this.locale;
    }

    public final long component13() {
        return this.updatedAt;
    }

    public final String component14() {
        return this.locale_programId;
    }

    public final String component15() {
        return this.programOverviewImage;
    }

    public final List<String> component16() {
        return this.dogSkillsHighlights;
    }

    public final List<String> component17() {
        return this.dogSkillsOverview;
    }

    public final List<String> component18() {
        return this.userSkillsOverview;
    }

    public final int component19() {
        return this.averageCompletionTimeWeeks;
    }

    public final String component2() {
        return this.programId;
    }

    public final int component20() {
        return this.numberOfEnrolledUsers;
    }

    public final String component21() {
        return this.certificatePreviewImage;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.image;
    }

    public final String component5() {
        return this.centeredImage;
    }

    public final String component6() {
        return this.description;
    }

    public final String component7() {
        return this.cardBackgroundColor;
    }

    public final String component8() {
        return this.certificateLaurelsImage;
    }

    public final String component9() {
        return this.certificatePaperImage;
    }

    public final app.dogo.android.persistencedb.room.entity.ProgramEntity copy(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12, long l13, String string14, String string15, List<String> list16, List<String> list17, List<String> list18, int i19, int i20, String string21) {
        Object obj = string;
        n.f(obj, "type");
        n.f(string2, "programId");
        n.f(string3, "name");
        n.f(string4, "image");
        n.f(string5, "centeredImage");
        n.f(string6, "description");
        n.f(string7, "cardBackgroundColor");
        n.f(string8, "certificateLaurelsImage");
        n.f(string9, "certificatePaperImage");
        n.f(string10, "certificatePlaceholderUrl");
        n.f(string11, "certificateRequirements");
        n.f(string12, "locale");
        n.f(string15, "locale_programId");
        n.f(list16, "programOverviewImage");
        n.f(list17, "dogSkillsHighlights");
        n.f(list18, "dogSkillsOverview");
        n.f(i19, "userSkillsOverview");
        n.f(obj47, "certificatePreviewImage");
        super(obj, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, l13, obj14, string15, list16, list17, list18, i19, i20, string21, obj47);
        return programEntity2;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ProgramEntity) {
            return i2;
        }
        if (!n.b(this.type, object.type)) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.image, object.image)) {
            return i2;
        }
        if (!n.b(this.centeredImage, object.centeredImage)) {
            return i2;
        }
        if (!n.b(this.description, object.description)) {
            return i2;
        }
        if (!n.b(this.cardBackgroundColor, object.cardBackgroundColor)) {
            return i2;
        }
        if (!n.b(this.certificateLaurelsImage, object.certificateLaurelsImage)) {
            return i2;
        }
        if (!n.b(this.certificatePaperImage, object.certificatePaperImage)) {
            return i2;
        }
        if (!n.b(this.certificatePlaceholderUrl, object.certificatePlaceholderUrl)) {
            return i2;
        }
        if (!n.b(this.certificateRequirements, object.certificateRequirements)) {
            return i2;
        }
        if (!n.b(this.locale, object.locale)) {
            return i2;
        }
        if (Long.compare(updatedAt, updatedAt2) != 0) {
            return i2;
        }
        if (!n.b(this.locale_programId, object.locale_programId)) {
            return i2;
        }
        if (!n.b(this.programOverviewImage, object.programOverviewImage)) {
            return i2;
        }
        if (!n.b(this.dogSkillsHighlights, object.dogSkillsHighlights)) {
            return i2;
        }
        if (!n.b(this.dogSkillsOverview, object.dogSkillsOverview)) {
            return i2;
        }
        if (!n.b(this.userSkillsOverview, object.userSkillsOverview)) {
            return i2;
        }
        if (this.averageCompletionTimeWeeks != object.averageCompletionTimeWeeks) {
            return i2;
        }
        if (this.numberOfEnrolledUsers != object.numberOfEnrolledUsers) {
            return i2;
        }
        if (!n.b(this.certificatePreviewImage, object.certificatePreviewImage)) {
            return i2;
        }
        return i;
    }

    public final int getAverageCompletionTimeWeeks() {
        return this.averageCompletionTimeWeeks;
    }

    public final String getCardBackgroundColor() {
        return this.cardBackgroundColor;
    }

    public final String getCenteredImage() {
        return this.centeredImage;
    }

    public final String getCertificateLaurelsImage() {
        return this.certificateLaurelsImage;
    }

    public final String getCertificatePaperImage() {
        return this.certificatePaperImage;
    }

    public final String getCertificatePlaceholderUrl() {
        return this.certificatePlaceholderUrl;
    }

    public final String getCertificatePreviewImage() {
        return this.certificatePreviewImage;
    }

    public final String getCertificateRequirements() {
        return this.certificateRequirements;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<String> getDogSkillsHighlights() {
        return this.dogSkillsHighlights;
    }

    public final List<String> getDogSkillsOverview() {
        return this.dogSkillsOverview;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getLocale_programId() {
        return this.locale_programId;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNumberOfEnrolledUsers() {
        return this.numberOfEnrolledUsers;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final String getProgramOverviewImage() {
        return this.programOverviewImage;
    }

    public final String getType() {
        return this.type;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public final List<String> getUserSkillsOverview() {
        return this.userSkillsOverview;
    }

    public int hashCode() {
        return i40 += i61;
    }

    public final boolean isClassicProgram() {
        return n.b(this.type, "classic");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramEntity(type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", programId=");
        stringBuilder.append(this.programId);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", image=");
        stringBuilder.append(this.image);
        stringBuilder.append(", centeredImage=");
        stringBuilder.append(this.centeredImage);
        stringBuilder.append(", description=");
        stringBuilder.append(this.description);
        stringBuilder.append(", cardBackgroundColor=");
        stringBuilder.append(this.cardBackgroundColor);
        stringBuilder.append(", certificateLaurelsImage=");
        stringBuilder.append(this.certificateLaurelsImage);
        stringBuilder.append(", certificatePaperImage=");
        stringBuilder.append(this.certificatePaperImage);
        stringBuilder.append(", certificatePlaceholderUrl=");
        stringBuilder.append(this.certificatePlaceholderUrl);
        stringBuilder.append(", certificateRequirements=");
        stringBuilder.append(this.certificateRequirements);
        stringBuilder.append(", locale=");
        stringBuilder.append(this.locale);
        stringBuilder.append(", updatedAt=");
        stringBuilder.append(this.updatedAt);
        stringBuilder.append(", locale_programId=");
        stringBuilder.append(this.locale_programId);
        stringBuilder.append(", programOverviewImage=");
        stringBuilder.append(this.programOverviewImage);
        stringBuilder.append(", dogSkillsHighlights=");
        stringBuilder.append(this.dogSkillsHighlights);
        stringBuilder.append(", dogSkillsOverview=");
        stringBuilder.append(this.dogSkillsOverview);
        stringBuilder.append(", userSkillsOverview=");
        stringBuilder.append(this.userSkillsOverview);
        stringBuilder.append(", averageCompletionTimeWeeks=");
        stringBuilder.append(this.averageCompletionTimeWeeks);
        stringBuilder.append(", numberOfEnrolledUsers=");
        stringBuilder.append(this.numberOfEnrolledUsers);
        stringBuilder.append(", certificatePreviewImage=");
        stringBuilder.append(this.certificatePreviewImage);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
