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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008)\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001LB£\u0001\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0008\u0012\u000e\u0008\u0002\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014\u0012\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0012\u0012\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0008HÆ\u0003J\u000f\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010HÆ\u0003J\t\u00101\u001a\u00020\u0012HÆ\u0003J\t\u00102\u001a\u00020\u0014HÆ\u0003J\t\u00103\u001a\u00020\u0012HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0008HÆ\u0003J\t\u00109\u001a\u00020\u0008HÆ\u0003J\t\u0010:\u001a\u00020\u000bHÆ\u0003J\t\u0010;\u001a\u00020\u0008HÆ\u0003J\t\u0010<\u001a\u00020\u0008HÆ\u0003J§\u0001\u0010=\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00082\u0008\u0008\u0002\u0010\r\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00082\u000e\u0008\u0002\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00122\n\u0008\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001J\t\u0010>\u001a\u00020\u0008HÖ\u0001J\u0013\u0010?\u001a\u00020\u00122\u0008\u0010@\u001a\u0004\u0018\u00010AHÖ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020\u0003J\t\u0010E\u001a\u00020\u0008HÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001J\u0019\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0008HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u001aR\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u001fR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010!R\u0011\u0010\u000c\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010!R\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008%\u0010!R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010+R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u001fR\u0011\u0010\u000e\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010!¨\u0006M", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "Landroid/os/Parcelable;", "id", "", "name", "iconUrl", "cardBackgroundColor", "modulesCount", "", "numberOfSkills", "programState", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;", "numberOfExams", "numberOfEnrolledUsers", "surveyCompatibility", "dogSkillsHighlights", "", "shouldOpenProgramOverview", "", "programStartTimeMs", "", "isSpecial", "overviewItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;IIILjava/util/List;ZJZLapp/dogo/com/dogo_android/repository/domain/ProgramOverview;)V", "getCardBackgroundColor", "()Ljava/lang/String;", "getDogSkillsHighlights", "()Ljava/util/List;", "getIconUrl", "getId", "()Z", "getModulesCount", "()I", "getName", "getNumberOfEnrolledUsers", "getNumberOfExams", "getNumberOfSkills", "getOverviewItem", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "getProgramStartTimeMs", "()J", "getProgramState", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;", "getShouldOpenProgramOverview", "getSurveyCompatibility", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "getSpecialProgramOverviewScreen", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "source", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "State", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramDescriptionItem implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> CREATOR;
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
    private final app.dogo.com.dogo_android.repository.domain.ProgramOverview overviewItem;
    private final long programStartTimeMs;
    private final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State programState;
    private final boolean shouldOpenProgramOverview;
    private final int surveyCompatibility;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem createFromParcel(Parcel parcel) {
            int fromParcel;
            int cREATOR;
            int i;
            int i2;
            Object obj = parcel;
            n.f(obj, "parcel");
            int i3 = 1;
            int i5 = 0;
            i = parcel.readInt() != 0 ? i3 : i5;
            i2 = parcel.readInt() != 0 ? i3 : i5;
            if (parcel.readInt() == 0) {
                fromParcel = 0;
            } else {
                fromParcel = ProgramOverview.CREATOR.createFromParcel(obj);
            }
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), ProgramDescriptionItem.State.valueOf(parcel.readString()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createStringArrayList(), i, parcel.readLong(), i, i2, (ProgramOverview)fromParcel);
            return programDescriptionItem;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem[] newArray(int i) {
            return new ProgramDescriptionItem[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\t\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;", "", "(Ljava/lang/String;I)V", "NOT_STARTED", "IN_PROGRESS", "COMPLETED", "HEADER", "COMING_SOON", "RECOMMENDED", "RECOMMENDED_BIG", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum State {

        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED,
        HEADER,
        COMING_SOON,
        RECOMMENDED,
        RECOMMENDED_BIG;
        private static final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State[] $values() {
            app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State[] arr = new ProgramDescriptionItem.State[7];
            return arr;
        }
    }
    static {
        ProgramDescriptionItem.Creator creator = new ProgramDescriptionItem.Creator();
        ProgramDescriptionItem.CREATOR = creator;
    }

    public ProgramDescriptionItem() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj14, 0, 0, 32767, 0);
    }

    public ProgramDescriptionItem(String string, String string2, String string3, String string4, int i5, int i6, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State programDescriptionItem$State7, int i8, int i9, int i10, List<String> list11, boolean z12, long l13, boolean z14, app.dogo.com.dogo_android.repository.domain.ProgramOverview programOverview15) {
        final Object obj = this;
        final Object obj2 = list11;
        n.f(string, "id");
        n.f(string2, "name");
        n.f(string3, "iconUrl");
        n.f(string4, "cardBackgroundColor");
        n.f(state7, "programState");
        n.f(obj2, "dogSkillsHighlights");
        super();
        obj.id = string;
        obj.name = string2;
        obj.iconUrl = string3;
        obj.cardBackgroundColor = string4;
        obj.modulesCount = i5;
        obj.numberOfSkills = i6;
        obj.programState = state7;
        obj.numberOfExams = i8;
        obj.numberOfEnrolledUsers = i9;
        obj.surveyCompatibility = i10;
        obj.dogSkillsHighlights = obj2;
        obj.shouldOpenProgramOverview = z12;
        obj.programStartTimeMs = l13;
        obj.isSpecial = programOverview15;
        obj.overviewItem = obj24;
    }

    public ProgramDescriptionItem(String string, String string2, String string3, String string4, int i5, int i6, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State programDescriptionItem$State7, int i8, int i9, int i10, List list11, boolean z12, long l13, boolean z14, app.dogo.com.dogo_android.repository.domain.ProgramOverview programOverview15, int i16, g g17) {
        int i4;
        String str3;
        String str;
        String str4;
        String str2;
        int i2;
        int i12;
        int i14;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State nOT_STARTED;
        int i;
        int i3;
        int i11;
        List list;
        int i7;
        int i13;
        int i15 = g17;
        str = "";
        str3 = i15 & 1 != 0 ? str : string;
        str4 = i15 & 2 != 0 ? str : string2;
        str2 = i15 & 4 != 0 ? str : string3;
        if (i15 & 8 != 0) {
        } else {
            str = string4;
        }
        i2 = i15 & 16 != 0 ? 0 : i5;
        i14 = i15 & 32 != 0 ? 0 : i6;
        nOT_STARTED = i15 & 64 != 0 ? ProgramDescriptionItem.State.NOT_STARTED : state7;
        i = i15 & 128 != 0 ? 0 : i8;
        i3 = i15 & 256 != 0 ? 0 : i9;
        i11 = i15 & 512 != 0 ? 0 : i10;
        if (i15 & 1024 != 0) {
            list = p.g();
        } else {
            list = list11;
        }
        i7 = i15 & 2048 != 0 ? 0 : z12;
        i13 = i15 & 4096 != 0 ? 0 : l13;
        i12 = i15 & 8192 != 0 ? 0 : programOverview15;
        i4 = i15 &= 16384 != 0 ? 0 : i16;
        super(str3, str4, str2, str, i2, i14, nOT_STARTED, i, i3, i11, list, i7, i13, programOverview15, i12, i4);
    }

    public static app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem copy$default(app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem, String string2, String string3, String string4, String string5, int i6, int i7, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State programDescriptionItem$State8, int i9, int i10, int i11, List list12, boolean z13, long l14, boolean z15, app.dogo.com.dogo_android.repository.domain.ProgramOverview programOverview16, int i17, Object object18) {
        app.dogo.com.dogo_android.repository.domain.ProgramOverview overviewItem;
        String str;
        String name;
        String iconUrl;
        String cardBackgroundColor;
        int modulesCount;
        int numberOfSkills;
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State programState;
        int numberOfExams;
        int numberOfEnrolledUsers;
        int surveyCompatibility;
        List dogSkillsHighlights;
        boolean shouldOpenProgramOverview;
        long programStartTimeMs;
        boolean isSpecial;
        Object obj = programDescriptionItem;
        int i = object18;
        str = i & 1 != 0 ? obj.id : string2;
        name = i & 2 != 0 ? obj.name : string3;
        iconUrl = i & 4 != 0 ? obj.iconUrl : string4;
        cardBackgroundColor = i & 8 != 0 ? obj.cardBackgroundColor : string5;
        modulesCount = i & 16 != 0 ? obj.modulesCount : i6;
        numberOfSkills = i & 32 != 0 ? obj.numberOfSkills : i7;
        programState = i & 64 != 0 ? obj.programState : state8;
        numberOfExams = i & 128 != 0 ? obj.numberOfExams : i9;
        numberOfEnrolledUsers = i & 256 != 0 ? obj.numberOfEnrolledUsers : i10;
        surveyCompatibility = i & 512 != 0 ? obj.surveyCompatibility : i11;
        dogSkillsHighlights = i & 1024 != 0 ? obj.dogSkillsHighlights : list12;
        shouldOpenProgramOverview = i & 2048 != 0 ? obj.shouldOpenProgramOverview : z13;
        programStartTimeMs = i & 4096 != 0 ? obj.programStartTimeMs : l14;
        isSpecial = i & 8192 != 0 ? obj.isSpecial : programOverview16;
        overviewItem = i &= 16384 != 0 ? obj.overviewItem : i17;
        return programDescriptionItem.copy(str, name, iconUrl, cardBackgroundColor, modulesCount, numberOfSkills, programState, numberOfExams, numberOfEnrolledUsers, surveyCompatibility, dogSkillsHighlights, shouldOpenProgramOverview, programStartTimeMs, z15, isSpecial);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final int component10() {
        return this.surveyCompatibility;
    }

    public final List<String> component11() {
        return this.dogSkillsHighlights;
    }

    @Override // android.os.Parcelable
    public final boolean component12() {
        return this.shouldOpenProgramOverview;
    }

    @Override // android.os.Parcelable
    public final long component13() {
        return this.programStartTimeMs;
    }

    @Override // android.os.Parcelable
    public final boolean component14() {
        return this.isSpecial;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramOverview component15() {
        return this.overviewItem;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.iconUrl;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.cardBackgroundColor;
    }

    @Override // android.os.Parcelable
    public final int component5() {
        return this.modulesCount;
    }

    @Override // android.os.Parcelable
    public final int component6() {
        return this.numberOfSkills;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State component7() {
        return this.programState;
    }

    @Override // android.os.Parcelable
    public final int component8() {
        return this.numberOfExams;
    }

    @Override // android.os.Parcelable
    public final int component9() {
        return this.numberOfEnrolledUsers;
    }

    public final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem copy(String string, String string2, String string3, String string4, int i5, int i6, app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State programDescriptionItem$State7, int i8, int i9, int i10, List<String> list11, boolean z12, long l13, boolean z14, app.dogo.com.dogo_android.repository.domain.ProgramOverview programOverview15) {
        Object obj = string;
        n.f(obj, "id");
        n.f(string2, "name");
        n.f(string3, "iconUrl");
        n.f(string4, "cardBackgroundColor");
        n.f(state7, "programState");
        n.f(list11, "dogSkillsHighlights");
        super(obj, string2, string3, string4, i5, i6, state7, i8, i9, i10, list11, z12, l13, obj14, programOverview15, obj35);
        return programDescriptionItem2;
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
        if (!object instanceof ProgramDescriptionItem) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.iconUrl, object.iconUrl)) {
            return i2;
        }
        if (!n.b(this.cardBackgroundColor, object.cardBackgroundColor)) {
            return i2;
        }
        if (this.modulesCount != object.modulesCount) {
            return i2;
        }
        if (this.numberOfSkills != object.numberOfSkills) {
            return i2;
        }
        if (this.programState != object.programState) {
            return i2;
        }
        if (this.numberOfExams != object.numberOfExams) {
            return i2;
        }
        if (this.numberOfEnrolledUsers != object.numberOfEnrolledUsers) {
            return i2;
        }
        if (this.surveyCompatibility != object.surveyCompatibility) {
            return i2;
        }
        if (!n.b(this.dogSkillsHighlights, object.dogSkillsHighlights)) {
            return i2;
        }
        if (this.shouldOpenProgramOverview != object.shouldOpenProgramOverview) {
            return i2;
        }
        if (Long.compare(programStartTimeMs, programStartTimeMs2) != 0) {
            return i2;
        }
        if (this.isSpecial != object.isSpecial) {
            return i2;
        }
        if (!n.b(this.overviewItem, object.overviewItem)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getCardBackgroundColor() {
        return this.cardBackgroundColor;
    }

    public final List<String> getDogSkillsHighlights() {
        return this.dogSkillsHighlights;
    }

    @Override // android.os.Parcelable
    public final String getIconUrl() {
        return this.iconUrl;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final int getModulesCount() {
        return this.modulesCount;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final int getNumberOfEnrolledUsers() {
        return this.numberOfEnrolledUsers;
    }

    @Override // android.os.Parcelable
    public final int getNumberOfExams() {
        return this.numberOfExams;
    }

    @Override // android.os.Parcelable
    public final int getNumberOfSkills() {
        return this.numberOfSkills;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramOverview getOverviewItem() {
        return this.overviewItem;
    }

    @Override // android.os.Parcelable
    public final long getProgramStartTimeMs() {
        return this.programStartTimeMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State getProgramState() {
        return this.programState;
    }

    @Override // android.os.Parcelable
    public final boolean getShouldOpenProgramOverview() {
        return this.shouldOpenProgramOverview;
    }

    @Override // android.os.Parcelable
    public final j getSpecialProgramOverviewScreen(String string) {
        m mVar;
        boolean str;
        n.f(string, "source");
        String str3 = this.id;
        if (n.b(str3, "id_potty_program")) {
            mVar = new m(string);
        } else {
            if (n.b(str3, "id_nipping_program")) {
                mVar = new o(string);
            } else {
                mVar = 0;
            }
        }
        return mVar;
    }

    @Override // android.os.Parcelable
    public final int getSurveyCompatibility() {
        return this.surveyCompatibility;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean shouldOpenProgramOverview;
        int i2;
        int i;
        if (this.shouldOpenProgramOverview != null) {
            shouldOpenProgramOverview = i;
        }
        boolean isSpecial = this.isSpecial;
        if (isSpecial) {
        } else {
            i = isSpecial;
        }
        app.dogo.com.dogo_android.repository.domain.ProgramOverview overviewItem = this.overviewItem;
        if (overviewItem == null) {
            i2 = 0;
        } else {
            i2 = overviewItem.hashCode();
        }
        return i30 += i2;
    }

    @Override // android.os.Parcelable
    public final boolean isSpecial() {
        return this.isSpecial;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramDescriptionItem(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", iconUrl=");
        stringBuilder.append(this.iconUrl);
        stringBuilder.append(", cardBackgroundColor=");
        stringBuilder.append(this.cardBackgroundColor);
        stringBuilder.append(", modulesCount=");
        stringBuilder.append(this.modulesCount);
        stringBuilder.append(", numberOfSkills=");
        stringBuilder.append(this.numberOfSkills);
        stringBuilder.append(", programState=");
        stringBuilder.append(this.programState);
        stringBuilder.append(", numberOfExams=");
        stringBuilder.append(this.numberOfExams);
        stringBuilder.append(", numberOfEnrolledUsers=");
        stringBuilder.append(this.numberOfEnrolledUsers);
        stringBuilder.append(", surveyCompatibility=");
        stringBuilder.append(this.surveyCompatibility);
        stringBuilder.append(", dogSkillsHighlights=");
        stringBuilder.append(this.dogSkillsHighlights);
        stringBuilder.append(", shouldOpenProgramOverview=");
        stringBuilder.append(this.shouldOpenProgramOverview);
        stringBuilder.append(", programStartTimeMs=");
        stringBuilder.append(this.programStartTimeMs);
        stringBuilder.append(", isSpecial=");
        stringBuilder.append(this.isSpecial);
        stringBuilder.append(", overviewItem=");
        stringBuilder.append(this.overviewItem);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
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
        app.dogo.com.dogo_android.repository.domain.ProgramOverview overviewItem = this.overviewItem;
        if (overviewItem == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            overviewItem.writeToParcel(parcel, i2);
        }
    }
}
