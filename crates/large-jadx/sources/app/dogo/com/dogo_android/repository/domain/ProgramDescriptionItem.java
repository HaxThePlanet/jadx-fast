package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.u.m.o;
import app.dogo.com.dogo_android.u.n.m;
import app.dogo.com.dogo_android.y.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: ProgramDescriptionItem.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008)\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001LB£\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0008\u0012\u000e\u0008\u0002\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0012\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0008HÆ\u0003J\u000f\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\t\u00101\u001a\u00020\u0012HÆ\u0003J\t\u00102\u001a\u00020\u0014HÆ\u0003J\t\u00103\u001a\u00020\u0012HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0008HÆ\u0003J\t\u00109\u001a\u00020\u0008HÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\t\u0010;\u001a\u00020\u0008HÆ\u0003J\t\u0010<\u001a\u00020\u0008HÆ\u0003J§\u0001\u0010=\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00082\u0008\u0008\u0002\u0010\r\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00082\u000e\u0008\u0002\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00122\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001J\t\u0010>\u001a\u00020\u0008HÖ\u0001J\u0013\u0010?\u001a\u00020\u00122\u0008\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u0003J\t\u0010E\u001a\u00020\u0008HÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001J\u0019\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0008HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010!R\u0011\u0010\u000c\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010!R\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010!R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010!¨\u0006M", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "Landroid/os/Parcelable;", "id", "", "name", "iconUrl", "cardBackgroundColor", "modulesCount", "", "numberOfSkills", "programState", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;", "numberOfExams", "numberOfEnrolledUsers", "surveyCompatibility", "dogSkillsHighlights", "", "shouldOpenProgramOverview", "", "programStartTimeMs", "", "isSpecial", "overviewItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;IIILjava/util/List;ZJZLapp/dogo/com/dogo_android/repository/domain/ProgramOverview;)V", "getCardBackgroundColor", "()Ljava/lang/String;", "getDogSkillsHighlights", "()Ljava/util/List;", "getIconUrl", "getId", "()Z", "getModulesCount", "()I", "getName", "getNumberOfEnrolledUsers", "getNumberOfExams", "getNumberOfSkills", "getOverviewItem", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "getProgramStartTimeMs", "()J", "getProgramState", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;", "getShouldOpenProgramOverview", "getSurveyCompatibility", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "getSpecialProgramOverviewScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "State", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramDescriptionItem implements Parcelable {

    public static final Parcelable.Creator<ProgramDescriptionItem> CREATOR = new ProgramDescriptionItem$Creator<>();
    private final String cardBackgroundColor;
    private final List<String> dogSkillsHighlights;
    private final String iconUrl;
    private final String id;
    private final boolean isSpecial;
    private final int modulesCount;
    private final String name;
    private final int numberOfEnrolledUsers;
    private final int numberOfExams;
    private final int numberOfSkills;
    private final ProgramOverview overviewItem;
    private final long programStartTimeMs;
    private final ProgramDescriptionItem.State programState;
    private final boolean shouldOpenProgramOverview;
    private final int surveyCompatibility;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ProgramDescriptionItem> {
        @Override // android.os.Parcelable$Creator
        public final ProgramDescriptionItem createFromParcel(Parcel parcel) {
            int i = 0;
            boolean z;
            app.dogo.com.dogo_android.repository.domain.ProgramOverview programOverview;
            Object parcel2 = parcel;
            n.f(parcel2, "parcel");
            int i2 = 1;
            int i3 = 0;
            int r16 = parcel.readInt() != 0 ? i2 : i3;
            int r17 = parcel.readInt() != 0 ? i2 : i3;
            if (parcel.readInt() == 0) {
                i = 0;
            } else {
                Object fromParcel = ProgramOverview.CREATOR.createFromParcel(parcel2);
            }
            ProgramDescriptionItem programDescriptionItem = new ProgramDescriptionItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), ProgramDescriptionItem_State.valueOf(parcel.readString()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createStringArrayList(), z, _long, z, programOverview, (ProgramOverview)i);
            return programDescriptionItem;
        }

        @Override // android.os.Parcelable$Creator
        public final ProgramDescriptionItem[] newArray(int i) {
            return new ProgramDescriptionItem[i];
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\t\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;", "", "(Ljava/lang/String;I)V", "NOT_STARTED", "IN_PROGRESS", "COMPLETED", "HEADER", "COMING_SOON", "RECOMMENDED", "RECOMMENDED_BIG", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum State {

        COMING_SOON,
        COMPLETED,
        HEADER,
        IN_PROGRESS,
        NOT_STARTED,
        RECOMMENDED,
        RECOMMENDED_BIG;
        private static final /* synthetic */ ProgramDescriptionItem.State[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State[] arr = new ProgramDescriptionItem.State[7];
            return new ProgramDescriptionItem.State[] { ProgramDescriptionItem_State.NOT_STARTED, ProgramDescriptionItem_State.IN_PROGRESS, ProgramDescriptionItem_State.COMPLETED, ProgramDescriptionItem_State.HEADER, ProgramDescriptionItem_State.COMING_SOON, ProgramDescriptionItem_State.RECOMMENDED, ProgramDescriptionItem_State.RECOMMENDED_BIG };
        }
    }
    public ProgramDescriptionItem(String str, String str2, String str3, String str4, int i, int i2, ProgramDescriptionItem.State state, int i3, int i4, int i5, List<String> list, boolean z, long j, boolean z2, ProgramOverview programOverview) {
        final Object str6 = this;
        final Object list112 = list;
        n.f(str, "id");
        n.f(str2, "name");
        n.f(str3, "iconUrl");
        n.f(str4, "cardBackgroundColor");
        n.f(state, "programState");
        n.f(list112, "dogSkillsHighlights");
        super();
        str6.id = str;
        str6.name = str2;
        str6.iconUrl = str3;
        str6.cardBackgroundColor = str4;
        str6.modulesCount = i;
        str6.numberOfSkills = i2;
        str6.programState = state;
        str6.numberOfExams = i3;
        str6.numberOfEnrolledUsers = i4;
        str6.surveyCompatibility = i5;
        str6.dogSkillsHighlights = list112;
        str6.shouldOpenProgramOverview = z;
        str6.programStartTimeMs = j;
        str6.isSpecial = z2;
        str6.overviewItem = programOverview;
    }

    public final String getCardBackgroundColor() {
        return this.cardBackgroundColor;
    }

    public final List<String> getDogSkillsHighlights() {
        return this.dogSkillsHighlights;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final int getModulesCount() {
        return this.modulesCount;
    }

    public final String getName() {
        return this.name;
    }

    public final int getNumberOfEnrolledUsers() {
        return this.numberOfEnrolledUsers;
    }

    public final int getNumberOfExams() {
        return this.numberOfExams;
    }

    public final int getNumberOfSkills() {
        return this.numberOfSkills;
    }

    public final ProgramOverview getOverviewItem() {
        return this.overviewItem;
    }

    public final long getProgramStartTimeMs() {
        return this.programStartTimeMs;
    }

    public final ProgramDescriptionItem.State getProgramState() {
        return this.programState;
    }

    public final boolean getShouldOpenProgramOverview() {
        return this.shouldOpenProgramOverview;
    }

    public final j getSpecialProgramOverviewScreen(String source) {
        m pottyProgramOverviewScreen = null;
        n.f(source, "source");
        if (n.b(this.id, "id_potty_program")) {
            pottyProgramOverviewScreen = new PottyProgramOverviewScreen(source);
        } else {
            BitingProgramOverviewScreen r0 = n.b(this.id, "id_nipping_program") ? new BitingProgramOverviewScreen(source) : 0;
        }
        return (n.b(this.id, "id_nipping_program") ? new BitingProgramOverviewScreen(source) : 0);
    }

    public final int getSurveyCompatibility() {
        return this.surveyCompatibility;
    }

    public final boolean isSpecial() {
        return this.isSpecial;
    }

    public /* synthetic */ ProgramDescriptionItem(String str, String str2, String str3, String str4, int i, int i2, ProgramDescriptionItem.State state, int i3, int i4, int i5, List list, boolean z, long j, boolean z2, ProgramOverview programOverview, int i6, g gVar) {
        int i162 = 0;
        String str5;
        int i52 = 0;
        int i62 = 0;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State state72;
        int i82 = 0;
        int i92 = 0;
        int i102 = 0;
        List list112;
        int z122 = 0;
        int j132 = 0;
        int gVar172 = i6;
        str5 = "";
        String r1 = gVar172 & 1 != 0 ? str5 : str;
        String r3 = gVar172 & 2 != 0 ? str5 : str2;
        String r4 = gVar172 & 4 != 0 ? str5 : str3;
        if (gVar172 & 8 == 0) {
            str5 = str4;
        }
        int r5 = gVar172 & 16 != 0 ? 0 : i;
        int r7 = gVar172 & 32 != 0 ? 0 : i2;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State r8 = gVar172 & 64 != 0 ? ProgramDescriptionItem_State.NOT_STARTED : state;
        int r9 = gVar172 & 128 != 0 ? 0 : i3;
        int r10 = gVar172 & 256 != 0 ? 0 : i4;
        int r11 = gVar172 & 512 != 0 ? 0 : i5;
        if (gVar172 & 1024 != 0) {
            list112 = p.g();
        } else {
            list112 = list;
        }
        int r13 = gVar172 & 2048 != 0 ? 0 : z;
        int r14 = gVar172 & 4096 != 0 ? 0 : j;
        int r6 = gVar172 & 8192 != 0 ? 0 : z2;
        int r0 = gVar172 & 16384 != 0 ? 0 : programOverview;
        this(str5, str5, str5, str5, i52, i62, state72, i82, i92, i102, list112, z122, j132, z2, i, (gVar172 & 16384 != 0 ? 0 : programOverview));
    }


    public ProgramDescriptionItem() {
        this(null, null, null, null, 0, 0, null, 0, 0, 0, null, false, 0L, z, null, 0, 32767, 0);
    }

    public static /* synthetic */ ProgramDescriptionItem copy$default(ProgramDescriptionItem programDescriptionItem, String str, String str2, String str3, String str4, int i, int i2, ProgramDescriptionItem.State state, int i3, int i4, int i5, List list, boolean z, long j, boolean z2, ProgramOverview programOverview, int i6, Object object) {
        app.dogo.com.dogo_android.repository.domain.ProgramOverview i172;
        String str22;
        String str32;
        String str42;
        String str52;
        int i62;
        int i72;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State state82;
        int i92;
        int i102;
        int i112;
        List list122;
        boolean z132;
        long j142;
        boolean programOverview162;
        Object programDescriptionItem2 = programDescriptionItem;
        int object182 = i6;
        String r2 = object182 & 1 != 0 ? programDescriptionItem2.id : str;
        String r3 = object182 & 2 != 0 ? programDescriptionItem2.name : str2;
        String r4 = object182 & 4 != 0 ? programDescriptionItem2.iconUrl : str3;
        String r5 = object182 & 8 != 0 ? programDescriptionItem2.cardBackgroundColor : str4;
        int r6 = object182 & 16 != 0 ? programDescriptionItem2.modulesCount : i;
        int r7 = object182 & 32 != 0 ? programDescriptionItem2.numberOfSkills : i2;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State r8 = object182 & 64 != 0 ? programDescriptionItem2.programState : state;
        int r9 = object182 & 128 != 0 ? programDescriptionItem2.numberOfExams : i3;
        int r10 = object182 & 256 != 0 ? programDescriptionItem2.numberOfEnrolledUsers : i4;
        int r11 = object182 & 512 != 0 ? programDescriptionItem2.surveyCompatibility : i5;
        List r12 = object182 & 1024 != 0 ? programDescriptionItem2.dogSkillsHighlights : list;
        boolean r13 = object182 & 2048 != 0 ? programDescriptionItem2.shouldOpenProgramOverview : z;
        long r14 = object182 & 4096 != 0 ? programDescriptionItem2.programStartTimeMs : j;
        r14 = object182 & 8192 != 0 ? programDescriptionItem2.isSpecial : z2;
        app.dogo.com.dogo_android.repository.domain.ProgramOverview r1 = object182 & 16384 != 0 ? programDescriptionItem2.overviewItem : programOverview;
        return programDescriptionItem.copy(str22, str32, str42, str52, i62, i72, state82, i92, i102, i112, list122, z132, (object182 & 4096 != 0 ? programDescriptionItem2.programStartTimeMs : j), r30, programOverview162, (object182 & 16384 != 0 ? programDescriptionItem2.overviewItem : programOverview));
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final int component10() {
        return this.surveyCompatibility;
    }

    /* operator */ public final List<String> component11() {
        return this.dogSkillsHighlights;
    }

    /* operator */ public final boolean component12() {
        return this.shouldOpenProgramOverview;
    }

    /* operator */ public final long component13() {
        return this.programStartTimeMs;
    }

    /* operator */ public final boolean component14() {
        return this.isSpecial;
    }

    /* operator */ public final ProgramOverview component15() {
        return this.overviewItem;
    }

    /* operator */ public final String component2() {
        return this.name;
    }

    /* operator */ public final String component3() {
        return this.iconUrl;
    }

    /* operator */ public final String component4() {
        return this.cardBackgroundColor;
    }

    /* operator */ public final int component5() {
        return this.modulesCount;
    }

    /* operator */ public final int component6() {
        return this.numberOfSkills;
    }

    /* operator */ public final ProgramDescriptionItem.State component7() {
        return this.programState;
    }

    /* operator */ public final int component8() {
        return this.numberOfExams;
    }

    /* operator */ public final int component9() {
        return this.numberOfEnrolledUsers;
    }

    public final ProgramDescriptionItem copy(String id, String name, String iconUrl, String cardBackgroundColor, int modulesCount, int numberOfSkills, ProgramDescriptionItem.State programState, int numberOfExams, int numberOfEnrolledUsers, int surveyCompatibility, List<String> dogSkillsHighlights, boolean shouldOpenProgramOverview, long programStartTimeMs, boolean isSpecial, ProgramOverview overviewItem) {
        Object id2 = id;
        n.f(id2, "id");
        n.f(name, "name");
        n.f(iconUrl, "iconUrl");
        n.f(cardBackgroundColor, "cardBackgroundColor");
        n.f(programState, "programState");
        n.f(dogSkillsHighlights, "dogSkillsHighlights");
        ProgramDescriptionItem programDescriptionItem = new ProgramDescriptionItem(id2, name, iconUrl, cardBackgroundColor, modulesCount, numberOfSkills, programState, numberOfExams, numberOfEnrolledUsers, surveyCompatibility, dogSkillsHighlights, shouldOpenProgramOverview, programStartTimeMs, z, isSpecial, overviewItem);
        return programDescriptionItem;
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
        final boolean z8 = false;
        if (!(other instanceof ProgramDescriptionItem)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.iconUrl, other.iconUrl)) {
            return false;
        }
        if (!n.b(this.cardBackgroundColor, other.cardBackgroundColor)) {
            return false;
        }
        if (this.modulesCount != other.modulesCount) {
            return false;
        }
        if (this.numberOfSkills != other.numberOfSkills) {
            return false;
        }
        if (this.programState != other.programState) {
            return false;
        }
        if (this.numberOfExams != other.numberOfExams) {
            return false;
        }
        if (this.numberOfEnrolledUsers != other.numberOfEnrolledUsers) {
            return false;
        }
        if (this.surveyCompatibility != other.surveyCompatibility) {
            return false;
        }
        if (!n.b(this.dogSkillsHighlights, other.dogSkillsHighlights)) {
            return false;
        }
        if (this.shouldOpenProgramOverview != other.shouldOpenProgramOverview) {
            return false;
        }
        if (this.programStartTimeMs != other.programStartTimeMs) {
            return false;
        }
        if (this.isSpecial != other.isSpecial) {
            return false;
        }
        return !n.b(this.overviewItem, other.overviewItem) ? z8 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean shouldOpenProgramOverview2;
        int i = 0;
        int i2 = 1;
        i2 = 1;
        if (this.shouldOpenProgramOverview != null) {
        }
        if (!(this.isSpecial)) {
        }
        if (this.overviewItem == null) {
            i = 0;
        } else {
            i = this.overviewItem.hashCode();
        }
        return (this.id.hashCode() * 31) + this.name.hashCode() * 31 + this.iconUrl.hashCode() * 31 + this.cardBackgroundColor.hashCode() * 31 + Integer.hashCode(this.modulesCount) * 31 + Integer.hashCode(this.numberOfSkills) * 31 + this.programState.hashCode() * 31 + Integer.hashCode(this.numberOfExams) * 31 + Integer.hashCode(this.numberOfEnrolledUsers) * 31 + Integer.hashCode(this.surveyCompatibility) * 31 + this.dogSkillsHighlights.hashCode() * 31 + shouldOpenProgramOverview2 * 31 + Long.hashCode(this.programStartTimeMs) * 31 + i2 * 31 + i;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramDescriptionItem(id=";
        String str3 = ", name=";
        String str4 = ", iconUrl=";
        String str5 = ", cardBackgroundColor=";
        String str6 = ", modulesCount=";
        String str7 = ", numberOfSkills=";
        String str8 = ", programState=";
        String str9 = ", numberOfExams=";
        String str10 = ", numberOfEnrolledUsers=";
        String str11 = ", surveyCompatibility=";
        String str12 = ", dogSkillsHighlights=";
        String str13 = ", shouldOpenProgramOverview=";
        String str14 = ", programStartTimeMs=";
        String str15 = ", isSpecial=";
        String str16 = ", overviewItem=";
        str = str2 + this.id + str3 + this.name + str4 + this.iconUrl + str5 + this.cardBackgroundColor + str6 + this.modulesCount + str7 + this.numberOfSkills + str8 + this.programState + str9 + this.numberOfExams + str10 + this.numberOfEnrolledUsers + str11 + this.surveyCompatibility + str12 + this.dogSkillsHighlights + str13 + this.shouldOpenProgramOverview + str14 + this.programStartTimeMs + str15 + this.isSpecial + str16 + this.overviewItem + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.cardBackgroundColor);
        parcel.writeInt(this.modulesCount);
        parcel.writeInt(this.numberOfSkills);
        parcel.writeString(this.programState.name());
        parcel.writeInt(this.numberOfExams);
        parcel.writeInt(this.numberOfEnrolledUsers);
        parcel.writeInt(this.surveyCompatibility);
        parcel.writeStringList(this.dogSkillsHighlights);
        parcel.writeInt(this.shouldOpenProgramOverview);
        parcel.writeLong(this.programStartTimeMs);
        parcel.writeInt(this.isSpecial);
        if (this.overviewItem == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.overviewItem.writeToParcel(parcel, flags);
        }
    }
}
