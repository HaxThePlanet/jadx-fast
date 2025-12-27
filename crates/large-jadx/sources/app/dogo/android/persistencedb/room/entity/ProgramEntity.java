package app.dogo.android.persistencedb.room.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: ProgramEntity.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u00083\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0087\u0008\u0018\u0000 Q2\u00020\u0001:\u0001QB×\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u000e\u0008\u0002\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018\u0012\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u0018\u0012\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0002\u0010\u001bJ\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0010HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000f\u0010<\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\u000f\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\u000f\u0010>\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014HÆ\u0003J\t\u0010?\u001a\u00020\u0018HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0018HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003Jí\u0001\u0010J\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u00032\u0008\u0008\u0002\u0010\t\u001a\u00020\u00032\u0008\u0008\u0002\u0010\n\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00032\u0008\u0008\u0002\u0010\r\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00142\u000e\u0008\u0002\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00142\u000e\u0008\u0002\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00142\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0003HÆ\u0001J\u0013\u0010K\u001a\u00020L2\u0008\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\u0018HÖ\u0001J\u0006\u0010O\u001a\u00020LJ\t\u0010P\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u001fR\u0011\u0010\u000c\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010\u001fR\u0011\u0010\u0008\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\u001fR\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010(R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010\u001fR\u0011\u0010\u0019\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u0010\u001fR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u00103R\u0017\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010(¨\u0006R", d2 = {"Lapp/dogo/android/persistencedb/room/entity/ProgramEntity;", "", "type", "", "programId", "name", "image", "centeredImage", "description", "cardBackgroundColor", "certificateLaurelsImage", "certificatePaperImage", "certificatePlaceholderUrl", "certificateRequirements", "locale", "updatedAt", "", "locale_programId", "programOverviewImage", "dogSkillsHighlights", "", "dogSkillsOverview", "userSkillsOverview", "averageCompletionTimeWeeks", "", "numberOfEnrolledUsers", "certificatePreviewImage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;IILjava/lang/String;)V", "getAverageCompletionTimeWeeks", "()I", "getCardBackgroundColor", "()Ljava/lang/String;", "getCenteredImage", "getCertificateLaurelsImage", "getCertificatePaperImage", "getCertificatePlaceholderUrl", "getCertificatePreviewImage", "getCertificateRequirements", "getDescription", "getDogSkillsHighlights", "()Ljava/util/List;", "getDogSkillsOverview", "getImage", "getLocale", "getLocale_programId", "getName", "getNumberOfEnrolledUsers", "getProgramId", "getProgramOverviewImage", "getType", "getUpdatedAt", "()J", "getUserSkillsOverview", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "isClassicProgram", "toString", "Companion", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramEntity {

    public static final String CLASSIC_PROGRAM_TYPE = "classic";
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final ProgramEntity.Companion INSTANCE = new ProgramEntity$Companion(0);
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
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
    public ProgramEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, long j, String str13, String str14, List<String> list, List<String> list2, List<String> list3, int i, int i2, String str15) {
        Object str132 = str;
        Object str22 = str2;
        final Object str32 = str3;
        final Object str42 = str4;
        final Object str52 = str5;
        final Object str62 = str6;
        final Object str72 = str7;
        final Object str82 = str8;
        final Object str92 = str9;
        final Object str102 = str10;
        final Object str112 = str11;
        final Object str122 = str12;
        final Object str152 = str13;
        final Object list162 = str14;
        n.f(str132, "type");
        n.f(str22, "programId");
        n.f(str32, "name");
        n.f(str42, "image");
        n.f(str52, "centeredImage");
        n.f(str62, "description");
        n.f(str72, "cardBackgroundColor");
        n.f(str82, "certificateLaurelsImage");
        n.f(str92, "certificatePaperImage");
        n.f(str102, "certificatePlaceholderUrl");
        n.f(str112, "certificateRequirements");
        n.f(str122, "locale");
        n.f(str152, "locale_programId");
        n.f(list162, "programOverviewImage");
        n.f(list, "dogSkillsHighlights");
        n.f(list2, "dogSkillsOverview");
        n.f(list3, "userSkillsOverview");
        n.f(str15, "certificatePreviewImage");
        super();
        Object str37 = this;
        str37.type = str132;
        str37.programId = str22;
        str37.name = str32;
        str37.image = str42;
        str37.centeredImage = str52;
        str37.description = str62;
        str37.cardBackgroundColor = str72;
        str37.certificateLaurelsImage = str82;
        str37.certificatePaperImage = str92;
        str37.certificatePlaceholderUrl = str102;
        str37.certificateRequirements = str112;
        str37.locale = str122;
        str37.updatedAt = j;
        str37.locale_programId = str152;
        str37.programOverviewImage = list162;
        str37.dogSkillsHighlights = list;
        str37.dogSkillsOverview = list2;
        str37.userSkillsOverview = list3;
        str37.averageCompletionTimeWeeks = i;
        str37.numberOfEnrolledUsers = i2;
        str37.certificatePreviewImage = str15;
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

    public final boolean isClassicProgram() {
        return n.b(this.type, "classic");
    }

    public /* synthetic */ ProgramEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, long j, String str13, String str14, List list, List list2, List list3, int i, int i2, String str15, int i3, g gVar) {
        String str82;
        String str152;
        Object obj;
        List list172;
        List list182;
        int i192;
        int i202;
        String str212;
        int gVar232 = i3;
        str82 = "";
        String r11 = gVar232 & 128 != 0 ? str82 : str8;
        String r12 = gVar232 & 256 != 0 ? str82 : str9;
        String r13 = gVar232 & 512 != 0 ? str82 : str10;
        String r14 = gVar232 & 1024 != 0 ? str82 : str11;
        i = gVar232 & 8192;
        if (gVar232 & 8192 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            str122 = str12;
            char c = '_';
            str22 = str2;
            str152 = str122 + c + str22;
        } else {
            str22 = str2;
            str122 = str12;
            str152 = str13;
        }
        String r19 = gVar232 & 16384 != 0 ? str82 : str14;
        i2 = 32768 & gVar232;
        list172 = 32768 & gVar232 != 0 ? list172 : list;
        list182 = 65536 & gVar232 != 0 ? list182 : list2;
        list = 131072 & gVar232 != 0 ? list : list3;
        i202 = 0;
        int r23 = 262144 & gVar232 != 0 ? i202 : i;
        int r24 = 524288 & gVar232 != 0 ? i202 : i2;
        String r25 = gVar232 & 1048576 != 0 ? str82 : str15;
        this(str, str2, str3, str4, str5, str6, str7, str82, str82, str82, str82, str12, j, str17, str152, obj, list172, list182, i192, i202, str212, (gVar232 & 1048576 != 0 ? str82 : str15));
    }


    public static /* synthetic */ ProgramEntity copy$default(ProgramEntity programEntity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, long j, String str13, String str14, List list, List list2, List list3, int i, int i2, String str15, int i3, Object object) {
        String i232;
        String str23;
        String str32;
        String str42;
        String str52;
        String str62;
        String str72;
        String str82;
        String str92;
        String str102;
        String str112;
        String str122;
        String str132;
        long j142;
        String str162;
        String list172;
        List list182;
        List list192;
        List i202;
        int i212;
        int str222;
        Object programEntity2 = programEntity;
        int object242 = i3;
        String r2 = object242 & 1 != 0 ? programEntity2.type : str;
        String r3 = object242 & 2 != 0 ? programEntity2.programId : str2;
        String r4 = object242 & 4 != 0 ? programEntity2.name : str3;
        String r5 = object242 & 8 != 0 ? programEntity2.image : str4;
        String r6 = object242 & 16 != 0 ? programEntity2.centeredImage : str5;
        String r7 = object242 & 32 != 0 ? programEntity2.description : str6;
        String r8 = object242 & 64 != 0 ? programEntity2.cardBackgroundColor : str7;
        String r9 = object242 & 128 != 0 ? programEntity2.certificateLaurelsImage : str8;
        String r10 = object242 & 256 != 0 ? programEntity2.certificatePaperImage : str9;
        String r11 = object242 & 512 != 0 ? programEntity2.certificatePlaceholderUrl : str10;
        String r12 = object242 & 1024 != 0 ? programEntity2.certificateRequirements : str11;
        String r13 = object242 & 2048 != 0 ? programEntity2.locale : str12;
        long r14 = object242 & 4096 != 0 ? programEntity2.updatedAt : j;
        r14 = object242 & 8192 != 0 ? programEntity2.locale_programId : str13;
        String r15 = object242 & 16384 != 0 ? programEntity2.programOverviewImage : str14;
        r15 = object242 & 32768 != 0 ? programEntity2.dogSkillsHighlights : list;
        r15 = object242 & 65536 != 0 ? programEntity2.dogSkillsOverview : list2;
        r15 = object242 & 131072 != 0 ? programEntity2.userSkillsOverview : list3;
        r15 = object242 & 262144 != 0 ? programEntity2.averageCompletionTimeWeeks : i;
        r15 = object242 & 524288 != 0 ? programEntity2.numberOfEnrolledUsers : i2;
        String r1 = object242 & 1048576 != 0 ? programEntity2.certificatePreviewImage : str15;
        return programEntity.copy(str23, str32, str42, str52, str62, str72, str82, str92, str102, str112, str122, str132, (object242 & 4096 != 0 ? programEntity2.updatedAt : j), r31, str162, (object242 & 16384 != 0 ? programEntity2.programOverviewImage : str14), (object242 & 32768 != 0 ? programEntity2.dogSkillsHighlights : list), (object242 & 65536 != 0 ? programEntity2.dogSkillsOverview : list2), (object242 & 131072 != 0 ? programEntity2.userSkillsOverview : list3), (object242 & 262144 != 0 ? programEntity2.averageCompletionTimeWeeks : i), str222, (object242 & 1048576 != 0 ? programEntity2.certificatePreviewImage : str15));
    }

    /* operator */ public final String component1() {
        return this.type;
    }

    /* operator */ public final String component10() {
        return this.certificatePlaceholderUrl;
    }

    /* operator */ public final String component11() {
        return this.certificateRequirements;
    }

    /* operator */ public final String component12() {
        return this.locale;
    }

    /* operator */ public final long component13() {
        return this.updatedAt;
    }

    /* operator */ public final String component14() {
        return this.locale_programId;
    }

    /* operator */ public final String component15() {
        return this.programOverviewImage;
    }

    /* operator */ public final List<String> component16() {
        return this.dogSkillsHighlights;
    }

    /* operator */ public final List<String> component17() {
        return this.dogSkillsOverview;
    }

    /* operator */ public final List<String> component18() {
        return this.userSkillsOverview;
    }

    /* operator */ public final int component19() {
        return this.averageCompletionTimeWeeks;
    }

    /* operator */ public final String component2() {
        return this.programId;
    }

    /* operator */ public final int component20() {
        return this.numberOfEnrolledUsers;
    }

    /* operator */ public final String component21() {
        return this.certificatePreviewImage;
    }

    /* operator */ public final String component3() {
        return this.name;
    }

    /* operator */ public final String component4() {
        return this.image;
    }

    /* operator */ public final String component5() {
        return this.centeredImage;
    }

    /* operator */ public final String component6() {
        return this.description;
    }

    /* operator */ public final String component7() {
        return this.cardBackgroundColor;
    }

    /* operator */ public final String component8() {
        return this.certificateLaurelsImage;
    }

    /* operator */ public final String component9() {
        return this.certificatePaperImage;
    }

    public final ProgramEntity copy(String type, String programId, String name, String image, String centeredImage, String description, String cardBackgroundColor, String certificateLaurelsImage, String certificatePaperImage, String certificatePlaceholderUrl, String certificateRequirements, String locale, long updatedAt, String locale_programId, String programOverviewImage, List<String> dogSkillsHighlights, List<String> dogSkillsOverview, List<String> userSkillsOverview, int averageCompletionTimeWeeks, int numberOfEnrolledUsers, String certificatePreviewImage) {
        Object type2 = type;
        n.f(type2, "type");
        n.f(programId, "programId");
        n.f(name, "name");
        n.f(image, "image");
        n.f(centeredImage, "centeredImage");
        n.f(description, "description");
        n.f(cardBackgroundColor, "cardBackgroundColor");
        n.f(certificateLaurelsImage, "certificateLaurelsImage");
        n.f(certificatePaperImage, "certificatePaperImage");
        n.f(certificatePlaceholderUrl, "certificatePlaceholderUrl");
        n.f(certificateRequirements, "certificateRequirements");
        n.f(locale, "locale");
        n.f(locale_programId, "locale_programId");
        n.f(programOverviewImage, "programOverviewImage");
        n.f(dogSkillsHighlights, "dogSkillsHighlights");
        n.f(dogSkillsOverview, "dogSkillsOverview");
        n.f(userSkillsOverview, "userSkillsOverview");
        n.f(certificatePreviewImage, "certificatePreviewImage");
        ProgramEntity programEntity = new ProgramEntity(type2, programId, name, image, centeredImage, description, cardBackgroundColor, certificateLaurelsImage, certificatePaperImage, certificatePlaceholderUrl, certificateRequirements, locale, updatedAt, str20, locale_programId, programOverviewImage, dogSkillsHighlights, dogSkillsOverview, userSkillsOverview, averageCompletionTimeWeeks, numberOfEnrolledUsers, certificatePreviewImage);
        return programEntity;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z20 = false;
        if (!(other instanceof ProgramEntity)) {
            return false;
        }
        if (!n.b(this.type, other.type)) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.image, other.image)) {
            return false;
        }
        if (!n.b(this.centeredImage, other.centeredImage)) {
            return false;
        }
        if (!n.b(this.description, other.description)) {
            return false;
        }
        if (!n.b(this.cardBackgroundColor, other.cardBackgroundColor)) {
            return false;
        }
        if (!n.b(this.certificateLaurelsImage, other.certificateLaurelsImage)) {
            return false;
        }
        if (!n.b(this.certificatePaperImage, other.certificatePaperImage)) {
            return false;
        }
        if (!n.b(this.certificatePlaceholderUrl, other.certificatePlaceholderUrl)) {
            return false;
        }
        if (!n.b(this.certificateRequirements, other.certificateRequirements)) {
            return false;
        }
        if (!n.b(this.locale, other.locale)) {
            return false;
        }
        if (this.updatedAt != other.updatedAt) {
            return false;
        }
        if (!n.b(this.locale_programId, other.locale_programId)) {
            return false;
        }
        if (!n.b(this.programOverviewImage, other.programOverviewImage)) {
            return false;
        }
        if (!n.b(this.dogSkillsHighlights, other.dogSkillsHighlights)) {
            return false;
        }
        if (!n.b(this.dogSkillsOverview, other.dogSkillsOverview)) {
            return false;
        }
        if (!n.b(this.userSkillsOverview, other.userSkillsOverview)) {
            return false;
        }
        if (this.averageCompletionTimeWeeks != other.averageCompletionTimeWeeks) {
            return false;
        }
        if (this.numberOfEnrolledUsers != other.numberOfEnrolledUsers) {
            return false;
        }
        return !n.b(this.certificatePreviewImage, other.certificatePreviewImage) ? z20 : z;
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.programId.hashCode() * 31 + this.name.hashCode() * 31 + this.image.hashCode() * 31 + this.centeredImage.hashCode() * 31 + this.description.hashCode() * 31 + this.cardBackgroundColor.hashCode() * 31 + this.certificateLaurelsImage.hashCode() * 31 + this.certificatePaperImage.hashCode() * 31 + this.certificatePlaceholderUrl.hashCode() * 31 + this.certificateRequirements.hashCode() * 31 + this.locale.hashCode() * 31 + Long.hashCode(this.updatedAt) * 31 + this.locale_programId.hashCode() * 31 + this.programOverviewImage.hashCode() * 31 + this.dogSkillsHighlights.hashCode() * 31 + this.dogSkillsOverview.hashCode() * 31 + this.userSkillsOverview.hashCode() * 31 + Integer.hashCode(this.averageCompletionTimeWeeks) * 31 + Integer.hashCode(this.numberOfEnrolledUsers) * 31 + this.certificatePreviewImage.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramEntity(type=";
        String str3 = ", programId=";
        String str4 = ", name=";
        String str5 = ", image=";
        String str6 = ", centeredImage=";
        String str7 = ", description=";
        String str8 = ", cardBackgroundColor=";
        String str9 = ", certificateLaurelsImage=";
        String str10 = ", certificatePaperImage=";
        String str11 = ", certificatePlaceholderUrl=";
        String str12 = ", certificateRequirements=";
        String str13 = ", locale=";
        String str14 = ", updatedAt=";
        String str15 = ", locale_programId=";
        String str16 = ", programOverviewImage=";
        String str17 = ", dogSkillsHighlights=";
        String str18 = ", dogSkillsOverview=";
        String str19 = ", userSkillsOverview=";
        String str20 = ", averageCompletionTimeWeeks=";
        String str21 = ", numberOfEnrolledUsers=";
        String str22 = ", certificatePreviewImage=";
        str = str2 + this.type + str3 + this.programId + str4 + this.name + str5 + this.image + str6 + this.centeredImage + str7 + this.description + str8 + this.cardBackgroundColor + str9 + this.certificateLaurelsImage + str10 + this.certificatePaperImage + str11 + this.certificatePlaceholderUrl + str12 + this.certificateRequirements + str13 + this.locale + str14 + this.updatedAt + str15 + this.locale_programId + str16 + this.programOverviewImage + str17 + this.dogSkillsHighlights + str18 + this.dogSkillsOverview + str19 + this.userSkillsOverview + str20 + this.averageCompletionTimeWeeks + str21 + this.numberOfEnrolledUsers + str22 + this.certificatePreviewImage + 41;
        return str;
    }
}
