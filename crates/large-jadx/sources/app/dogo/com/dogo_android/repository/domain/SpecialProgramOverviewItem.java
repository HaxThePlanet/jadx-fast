package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.u.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008-\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0087\u0008\u0018\u00002\u00020\u00012\u00020\u0002:\u0005RSTUVB¯\u0001\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0008\u0012\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0008\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018\u0012\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0015\u0012\u000e\u0008\u0002\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0008¢\u0006\u0002\u0010\u001dJ\t\u00106\u001a\u00020\u0004HÆ\u0003J\t\u00107\u001a\u00020\u0015HÆ\u0003J\t\u00108\u001a\u00020\u0018HÆ\u0003J\t\u00109\u001a\u00020\u001aHÆ\u0003J\t\u0010:\u001a\u00020\u0015HÆ\u0003J\u000f\u0010;\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0008HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\u000f\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008HÆ\u0003J\u000f\u0010>\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008HÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J\u000f\u0010@\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0008HÆ\u0003J\u000f\u0010A\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0008HÆ\u0003J\t\u0010B\u001a\u00020\u0013HÆ\u0003J\t\u0010C\u001a\u00020\u0015HÆ\u0003J³\u0001\u0010D\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u00082\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00082\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00152\u000e\u0008\u0002\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0008HÆ\u0001J\t\u0010E\u001a\u00020\u0006HÖ\u0001J\u0013\u0010F\u001a\u00020\u00152\u0008\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\u0006\u0010I\u001a\u00020\u0015J\u0006\u0010J\u001a\u00020\u0015J\t\u0010K\u001a\u00020\u0006HÖ\u0001J\t\u0010L\u001a\u00020\u0004HÖ\u0001J\u0019\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001fR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010$R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010$R \u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010\u001f\"\u0004\u0008&\u0010'R\u001a\u0010\u001b\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010$\"\u0004\u0008)\u0010*R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00105¨\u0006W", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "Landroid/os/Parcelable;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramCompletion;", "programId", "", "unreadZendeskMessages", "", "exercise", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "cardsOrder", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$PottyOverviewCardEnum;", "programProgress", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "articlesWithProgress", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "reminders", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "programData", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramData;", "isUserPremium", "", "isProgramEnrolled", "certificate", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "programCompletion", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "pottyTrackerNewUiEnabled", "pottyCheckmarks", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;Ljava/util/List;Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramData;ZZLapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;ZLjava/util/List;)V", "getArticlesWithProgress", "()Ljava/util/List;", "getCardsOrder", "getCertificate", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "getExercise", "()Z", "getPottyCheckmarks", "setPottyCheckmarks", "(Ljava/util/List;)V", "getPottyTrackerNewUiEnabled", "setPottyTrackerNewUiEnabled", "(Z)V", "getProgramCompletion", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "getProgramData", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramData;", "getProgramId", "()Ljava/lang/String;", "getProgramProgress", "()Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "getReminders", "getUnreadZendeskMessages", "()I", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hasLogs", "hasProgress", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CertificateData", "CertificateState", "PottyOverviewCardEnum", "ProgramData", "ProgramProgressData", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class SpecialProgramOverviewItem implements Parcelable, h {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem> CREATOR;
    private final List<app.dogo.com.dogo_android.repository.domain.ArticleWithStatus> articlesWithProgress;
    private final List<app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum> cardsOrder;
    private final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData certificate;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations> exercise;
    private final boolean isProgramEnrolled;
    private final boolean isUserPremium;
    private List<Boolean> pottyCheckmarks;
    private boolean pottyTrackerNewUiEnabled;
    private final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programCompletion;
    private final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData programData;
    private final String programId;
    private final app.dogo.com.dogo_android.repository.domain.PottyProgramProgress programProgress;
    private final List<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> reminders;
    private final int unreadZendeskMessages;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateState;", "", "(Ljava/lang/String;I)V", "LOCKED", "UNLOCKED", "LOCKED_HIDDEN", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum CertificateState {

        LOCKED,
        UNLOCKED,
        LOCKED_HIDDEN;
        private static final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState[] $values() {
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState[] arr = new SpecialProgramOverviewItem.CertificateState[3];
            return arr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem createFromParcel(Parcel parcel) {
            int i8;
            int int;
            int i4;
            Object fromParcel2;
            int i7;
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum valueOf;
            int i2;
            Object fromParcel3;
            int i6;
            Object fromParcel;
            int i5;
            int i;
            int i9;
            int i10;
            int i3;
            Object obj = parcel;
            n.f(obj, "parcel");
            int int2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(int2);
            i4 = 0;
            while (i4 != int2) {
                arrayList2.add(TrickItemWithVariations.CREATOR.createFromParcel(obj));
                i4++;
            }
            int int3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(int3);
            i7 = 0;
            while (i7 != int3) {
                arrayList3.add(SpecialProgramOverviewItem.PottyOverviewCardEnum.valueOf(parcel.readString()));
                i7++;
            }
            int int4 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(int4);
            i2 = 0;
            while (i2 != int4) {
                arrayList4.add(ArticleWithStatus.CREATOR.createFromParcel(obj));
                i2++;
            }
            int int5 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(int5);
            i6 = 0;
            while (i6 != int5) {
                arrayList5.add(PottyRemindersItem.CREATOR.createFromParcel(obj));
                i6++;
            }
            i8 = parcel.readInt() != 0 ? 1 : 0;
            i = parcel.readInt() != 0 ? 1 : 0;
            i9 = parcel.readInt() != 0 ? 1 : 0;
            ArrayList arrayList = new ArrayList(parcel.readInt());
            i5 = 0;
            while (i5 != int) {
                if (parcel.readInt() != 0) {
                } else {
                }
                i10 = 0;
                arrayList.add(Boolean.valueOf(i10));
                i5++;
                int = i3;
                i10 = 1;
            }
            super(parcel.readString(), parcel.readInt(), arrayList2, arrayList3, (PottyProgramProgress)PottyProgramProgress.CREATOR.createFromParcel(obj), arrayList4, arrayList5, (SpecialProgramOverviewItem.ProgramData)SpecialProgramOverviewItem.ProgramData.CREATOR.createFromParcel(obj), i8, i, (SpecialProgramOverviewItem.CertificateData)SpecialProgramOverviewItem.CertificateData.CREATOR.createFromParcel(obj), (SpecialProgramOverviewItem.ProgramProgressData)SpecialProgramOverviewItem.ProgramProgressData.CREATOR.createFromParcel(obj), i9, arrayList);
            return specialProgramOverviewItem2;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem[] newArray(int i) {
            return new SpecialProgramOverviewItem[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0086\u0001\u0018\u0000 \r2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000c¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$PottyOverviewCardEnum;", "", "cardType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCardType", "()Ljava/lang/String;", "ARTICLE", "PROGRESS", "CERTIFICATE", "EXERCISE", "LOGS", "REMINDER", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum PottyOverviewCardEnum {

        ARTICLE("article"),
        PROGRESS("article"),
        CERTIFICATE("article"),
        EXERCISE("article"),
        LOGS("article"),
        REMINDER("article");

        private final String cardType;
        private static final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum[] $values() {
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum[] arr = new SpecialProgramOverviewItem.PottyOverviewCardEnum[6];
            return arr;
        }

        @Override // java.lang.Enum
        public final String getCardType() {
            return this.cardType;
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramData;", "Landroid/os/Parcelable;", "centerImage", "", "programTitle", "programDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCenterImage", "()Ljava/lang/String;", "getProgramDescription", "getProgramTitle", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramData implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData> CREATOR;
        private final String centerImage;
        private final String programDescription;
        private final String programTitle;
        static {
            SpecialProgramOverviewItem.ProgramData.Creator creator = new SpecialProgramOverviewItem.ProgramData.Creator();
            SpecialProgramOverviewItem.ProgramData.CREATOR = creator;
        }

        public ProgramData() {
            super(0, 0, 0, 7, 0);
        }

        public ProgramData(String string, String string2, String string3) {
            n.f(string, "centerImage");
            n.f(string2, "programTitle");
            n.f(string3, "programDescription");
            super();
            this.centerImage = string;
            this.programTitle = string2;
            this.programDescription = string3;
        }

        public ProgramData(String string, String string2, String string3, int i4, g g5) {
            String obj2;
            String obj3;
            String obj4;
            final String str = "";
            obj2 = i4 & 1 != 0 ? str : obj2;
            obj3 = i4 & 2 != 0 ? str : obj3;
            obj4 = i4 &= 4 != 0 ? str : obj4;
            super(obj2, obj3, obj4);
        }

        public static app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData copy$default(app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData specialProgramOverviewItem$ProgramData, String string2, String string3, String string4, int i5, Object object6) {
            String obj1;
            String obj2;
            String obj3;
            if (i5 & 1 != 0) {
                obj1 = programData.centerImage;
            }
            if (i5 & 2 != 0) {
                obj2 = programData.programTitle;
            }
            if (i5 &= 4 != 0) {
                obj3 = programData.programDescription;
            }
            return programData.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.centerImage;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.programTitle;
        }

        @Override // android.os.Parcelable
        public final String component3() {
            return this.programDescription;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData copy(String string, String string2, String string3) {
            n.f(string, "centerImage");
            n.f(string2, "programTitle");
            n.f(string3, "programDescription");
            SpecialProgramOverviewItem.ProgramData programData = new SpecialProgramOverviewItem.ProgramData(string, string2, string3);
            return programData;
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
            if (object instanceof SpecialProgramOverviewItem.ProgramData == null) {
                return i2;
            }
            if (!n.b(this.centerImage, object.centerImage)) {
                return i2;
            }
            if (!n.b(this.programTitle, object.programTitle)) {
                return i2;
            }
            if (!n.b(this.programDescription, object.programDescription)) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getCenterImage() {
            return this.centerImage;
        }

        @Override // android.os.Parcelable
        public final String getProgramDescription() {
            return this.programDescription;
        }

        @Override // android.os.Parcelable
        public final String getProgramTitle() {
            return this.programTitle;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            return i4 += i7;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ProgramData(centerImage=");
            stringBuilder.append(this.centerImage);
            stringBuilder.append(", programTitle=");
            stringBuilder.append(this.programTitle);
            stringBuilder.append(", programDescription=");
            stringBuilder.append(this.programDescription);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.centerImage);
            parcel.writeString(this.programTitle);
            parcel.writeString(this.programDescription);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "Landroid/os/Parcelable;", "articleCompletionPercentage", "", "articlesAreCompleted", "", "trickCompletionPercentage", "tricksAreCompleted", "(IZIZ)V", "getArticleCompletionPercentage", "()I", "getArticlesAreCompleted", "()Z", "getTrickCompletionPercentage", "getTricksAreCompleted", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramProgressData implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData> CREATOR;
        private final int articleCompletionPercentage;
        private final boolean articlesAreCompleted;
        private final int trickCompletionPercentage;
        private final boolean tricksAreCompleted;
        static {
            SpecialProgramOverviewItem.ProgramProgressData.Creator creator = new SpecialProgramOverviewItem.ProgramProgressData.Creator();
            SpecialProgramOverviewItem.ProgramProgressData.CREATOR = creator;
        }

        public ProgramProgressData() {
            super(0, 0, 0, 0, 15, 0);
        }

        public ProgramProgressData(int i, boolean z2, int i3, boolean z4) {
            super();
            this.articleCompletionPercentage = i;
            this.articlesAreCompleted = z2;
            this.trickCompletionPercentage = i3;
            this.tricksAreCompleted = z4;
        }

        public ProgramProgressData(int i, boolean z2, int i3, boolean z4, int i5, g g6) {
            int obj2;
            int obj3;
            int obj4;
            int obj5;
            final int i2 = 0;
            obj2 = i5 & 1 != 0 ? i2 : obj2;
            obj3 = i5 & 2 != 0 ? i2 : obj3;
            obj4 = i5 & 4 != 0 ? i2 : obj4;
            obj5 = i5 &= 8 != 0 ? i2 : obj5;
            super(obj2, obj3, obj4, obj5);
        }

        public static app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData copy$default(app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData, int i2, boolean z3, int i4, boolean z5, int i6, Object object7) {
            int obj1;
            boolean obj2;
            int obj3;
            boolean obj4;
            if (i6 & 1 != 0) {
                obj1 = programProgressData.articleCompletionPercentage;
            }
            if (i6 & 2 != 0) {
                obj2 = programProgressData.articlesAreCompleted;
            }
            if (i6 & 4 != 0) {
                obj3 = programProgressData.trickCompletionPercentage;
            }
            if (i6 &= 8 != 0) {
                obj4 = programProgressData.tricksAreCompleted;
            }
            return programProgressData.copy(obj1, obj2, obj3, obj4);
        }

        @Override // android.os.Parcelable
        public final int component1() {
            return this.articleCompletionPercentage;
        }

        @Override // android.os.Parcelable
        public final boolean component2() {
            return this.articlesAreCompleted;
        }

        @Override // android.os.Parcelable
        public final int component3() {
            return this.trickCompletionPercentage;
        }

        @Override // android.os.Parcelable
        public final boolean component4() {
            return this.tricksAreCompleted;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData copy(int i, boolean z2, int i3, boolean z4) {
            SpecialProgramOverviewItem.ProgramProgressData programProgressData = new SpecialProgramOverviewItem.ProgramProgressData(i, z2, i3, z4);
            return programProgressData;
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
            if (object instanceof SpecialProgramOverviewItem.ProgramProgressData == null) {
                return i2;
            }
            if (this.articleCompletionPercentage != object.articleCompletionPercentage) {
                return i2;
            }
            if (this.articlesAreCompleted != object.articlesAreCompleted) {
                return i2;
            }
            if (this.trickCompletionPercentage != object.trickCompletionPercentage) {
                return i2;
            }
            if (this.tricksAreCompleted != object.tricksAreCompleted) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final int getArticleCompletionPercentage() {
            return this.articleCompletionPercentage;
        }

        @Override // android.os.Parcelable
        public final boolean getArticlesAreCompleted() {
            return this.articlesAreCompleted;
        }

        @Override // android.os.Parcelable
        public final int getTrickCompletionPercentage() {
            return this.trickCompletionPercentage;
        }

        @Override // android.os.Parcelable
        public final boolean getTricksAreCompleted() {
            return this.tricksAreCompleted;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            boolean articlesAreCompleted;
            int i;
            if (this.articlesAreCompleted) {
                articlesAreCompleted = i;
            }
            boolean tricksAreCompleted = this.tricksAreCompleted;
            if (tricksAreCompleted) {
            } else {
                i = tricksAreCompleted;
            }
            return i7 += i;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ProgramProgressData(articleCompletionPercentage=");
            stringBuilder.append(this.articleCompletionPercentage);
            stringBuilder.append(", articlesAreCompleted=");
            stringBuilder.append(this.articlesAreCompleted);
            stringBuilder.append(", trickCompletionPercentage=");
            stringBuilder.append(this.trickCompletionPercentage);
            stringBuilder.append(", tricksAreCompleted=");
            stringBuilder.append(this.tricksAreCompleted);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeInt(this.articleCompletionPercentage);
            parcel.writeInt(this.articlesAreCompleted);
            parcel.writeInt(this.trickCompletionPercentage);
            parcel.writeInt(this.tricksAreCompleted);
        }
    }

    @Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001e\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u00012\u00020\u0002B}\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0010HÆ\u0003J\t\u0010&\u001a\u00020\u0012HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0008HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u0081\u0001\u0010/\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00042\u0008\u0008\u0002\u0010\r\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\t\u00100\u001a\u000201HÖ\u0001J\u0013\u00102\u001a\u00020\u00082\u0008\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000201HÖ\u0001J\t\u00106\u001a\u00020\u0004HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u000201HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0015R\u0011\u0010\u000c\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u001dR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"¨\u0006<", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "Landroid/os/Parcelable;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramCompletion;", "dogId", "", "certificatePaperImage", "certificateLaurelsImage", "isCertificateUnlocked", "", "certificatePlaceholderUrl", "certificateImageUrl", "certificatePdfUrl", "certificateRequirements", "programTitle", "dogName", "programCompletion", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "state", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateState;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateState;)V", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificateLaurelsImage", "getCertificatePaperImage", "getCertificatePdfUrl", "getCertificatePlaceholderUrl", "getCertificateRequirements", "getDogId", "getDogName", "()Z", "getProgramCompletion", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "getProgramTitle", "getState", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateState;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CertificateData implements Parcelable, h {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData> CREATOR;
        private final String certificateImageUrl;
        private final String certificateLaurelsImage;
        private final String certificatePaperImage;
        private final String certificatePdfUrl;
        private final String certificatePlaceholderUrl;
        private final String certificateRequirements;
        private final String dogId;
        private final String dogName;
        private final boolean isCertificateUnlocked;
        private final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programCompletion;
        private final String programTitle;
        private final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState state;
        static {
            SpecialProgramOverviewItem.CertificateData.Creator creator = new SpecialProgramOverviewItem.CertificateData.Creator();
            SpecialProgramOverviewItem.CertificateData.CREATOR = creator;
        }

        public CertificateData() {
            super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, 0);
        }

        public CertificateData(String string, String string2, String string3, boolean z4, String string5, String string6, String string7, String string8, String string9, String string10, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData11, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState specialProgramOverviewItem$CertificateState12) {
            n.f(string, "dogId");
            n.f(string2, "certificatePaperImage");
            n.f(string3, "certificateLaurelsImage");
            n.f(string5, "certificatePlaceholderUrl");
            n.f(string6, "certificateImageUrl");
            n.f(string7, "certificatePdfUrl");
            n.f(string8, "certificateRequirements");
            n.f(string9, "programTitle");
            n.f(string10, "dogName");
            n.f(programProgressData11, "programCompletion");
            n.f(certificateState12, "state");
            super();
            this.dogId = string;
            this.certificatePaperImage = string2;
            this.certificateLaurelsImage = string3;
            this.isCertificateUnlocked = z4;
            this.certificatePlaceholderUrl = string5;
            this.certificateImageUrl = string6;
            this.certificatePdfUrl = string7;
            this.certificateRequirements = string8;
            this.programTitle = string9;
            this.dogName = string10;
            this.programCompletion = programProgressData11;
            this.state = certificateState12;
        }

        public CertificateData(String string, String string2, String string3, boolean z4, String string5, String string6, String string7, String string8, String string9, String string10, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData11, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState specialProgramOverviewItem$CertificateState12, int i13, g g14) {
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState lOCKED;
            Object obj;
            String str2;
            String str3;
            String str;
            int i2;
            String str8;
            String str6;
            String str5;
            String str4;
            String str7;
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programProgressData;
            int i7;
            int i5;
            int i;
            int i6;
            int i4;
            int i3;
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData obj19;
            int obj20;
            int obj21;
            int obj22;
            int obj23;
            int obj24;
            int obj25;
            int i8 = i13;
            str2 = "";
            obj = i8 & 1 != 0 ? str2 : string;
            str3 = i8 & 2 != 0 ? str2 : string2;
            str = i8 & 4 != 0 ? str2 : string3;
            i2 = i8 & 8 != 0 ? 0 : z4;
            str8 = i8 & 16 != 0 ? str2 : string5;
            str6 = i8 & 32 != 0 ? str2 : string6;
            str5 = i8 & 64 != 0 ? str2 : string7;
            str4 = i8 & 128 != 0 ? str2 : string8;
            str7 = i8 & 256 != 0 ? str2 : string9;
            if (i8 & 512 != 0) {
            } else {
                str2 = string10;
            }
            if (i8 & 1024 != 0) {
                super(0, 0, 0, 0, 15, 0);
            } else {
                programProgressData = programProgressData11;
            }
            lOCKED = i8 &= 2048 != 0 ? SpecialProgramOverviewItem.CertificateState.LOCKED : certificateState12;
            super(obj, str3, str, i2, str8, str6, str5, str4, str7, str2, programProgressData, lOCKED);
        }

        public static app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData copy$default(app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData, String string2, String string3, String string4, boolean z5, String string6, String string7, String string8, String string9, String string10, String string11, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData12, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState specialProgramOverviewItem$CertificateState13, int i14, Object object15) {
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState state;
            String dogId;
            String certificatePaperImage;
            String certificateLaurelsImage;
            boolean isCertificateUnlocked;
            String certificatePlaceholderUrl;
            String certificateImageUrl;
            String certificatePdfUrl;
            String certificateRequirements;
            String programTitle;
            String dogName;
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programCompletion;
            Object obj = certificateData;
            int i = i14;
            dogId = i & 1 != 0 ? obj.dogId : string2;
            certificatePaperImage = i & 2 != 0 ? obj.certificatePaperImage : string3;
            certificateLaurelsImage = i & 4 != 0 ? obj.certificateLaurelsImage : string4;
            isCertificateUnlocked = i & 8 != 0 ? obj.isCertificateUnlocked : z5;
            certificatePlaceholderUrl = i & 16 != 0 ? obj.certificatePlaceholderUrl : string6;
            certificateImageUrl = i & 32 != 0 ? obj.certificateImageUrl : string7;
            certificatePdfUrl = i & 64 != 0 ? obj.certificatePdfUrl : string8;
            certificateRequirements = i & 128 != 0 ? obj.certificateRequirements : string9;
            programTitle = i & 256 != 0 ? obj.programTitle : string10;
            dogName = i & 512 != 0 ? obj.dogName : string11;
            if (i & 1024 != 0) {
                programCompletion = certificateData.getProgramCompletion();
            } else {
                programCompletion = programProgressData12;
            }
            state = i &= 2048 != 0 ? obj.state : certificateState13;
            return certificateData.copy(dogId, certificatePaperImage, certificateLaurelsImage, isCertificateUnlocked, certificatePlaceholderUrl, certificateImageUrl, certificatePdfUrl, certificateRequirements, programTitle, dogName, programCompletion, state);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.dogId;
        }

        @Override // android.os.Parcelable
        public final String component10() {
            return this.dogName;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData component11() {
            return getProgramCompletion();
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState component12() {
            return this.state;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.certificatePaperImage;
        }

        @Override // android.os.Parcelable
        public final String component3() {
            return this.certificateLaurelsImage;
        }

        @Override // android.os.Parcelable
        public final boolean component4() {
            return this.isCertificateUnlocked;
        }

        @Override // android.os.Parcelable
        public final String component5() {
            return this.certificatePlaceholderUrl;
        }

        @Override // android.os.Parcelable
        public final String component6() {
            return this.certificateImageUrl;
        }

        @Override // android.os.Parcelable
        public final String component7() {
            return this.certificatePdfUrl;
        }

        @Override // android.os.Parcelable
        public final String component8() {
            return this.certificateRequirements;
        }

        @Override // android.os.Parcelable
        public final String component9() {
            return this.programTitle;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData copy(String string, String string2, String string3, boolean z4, String string5, String string6, String string7, String string8, String string9, String string10, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData11, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState specialProgramOverviewItem$CertificateState12) {
            n.f(string, "dogId");
            final Object obj = string2;
            n.f(obj, "certificatePaperImage");
            final Object obj2 = string3;
            n.f(obj2, "certificateLaurelsImage");
            final Object obj3 = string5;
            n.f(obj3, "certificatePlaceholderUrl");
            final Object obj4 = string6;
            n.f(obj4, "certificateImageUrl");
            final Object obj5 = string7;
            n.f(obj5, "certificatePdfUrl");
            final Object obj6 = string8;
            n.f(obj6, "certificateRequirements");
            final Object obj7 = string9;
            n.f(obj7, "programTitle");
            final Object obj8 = string10;
            n.f(obj8, "dogName");
            final Object obj9 = programProgressData11;
            n.f(obj9, "programCompletion");
            final Object obj10 = certificateState12;
            n.f(obj10, "state");
            super(string, obj, obj2, z4, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
            return certificateData;
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
            if (object instanceof SpecialProgramOverviewItem.CertificateData == null) {
                return i2;
            }
            if (!n.b(this.dogId, object.dogId)) {
                return i2;
            }
            if (!n.b(this.certificatePaperImage, object.certificatePaperImage)) {
                return i2;
            }
            if (!n.b(this.certificateLaurelsImage, object.certificateLaurelsImage)) {
                return i2;
            }
            if (this.isCertificateUnlocked != object.isCertificateUnlocked) {
                return i2;
            }
            if (!n.b(this.certificatePlaceholderUrl, object.certificatePlaceholderUrl)) {
                return i2;
            }
            if (!n.b(this.certificateImageUrl, object.certificateImageUrl)) {
                return i2;
            }
            if (!n.b(this.certificatePdfUrl, object.certificatePdfUrl)) {
                return i2;
            }
            if (!n.b(this.certificateRequirements, object.certificateRequirements)) {
                return i2;
            }
            if (!n.b(this.programTitle, object.programTitle)) {
                return i2;
            }
            if (!n.b(this.dogName, object.dogName)) {
                return i2;
            }
            if (!n.b(getProgramCompletion(), (SpecialProgramOverviewItem.CertificateData)object.getProgramCompletion())) {
                return i2;
            }
            if (this.state != object.state) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getCertificateImageUrl() {
            return this.certificateImageUrl;
        }

        @Override // android.os.Parcelable
        public final String getCertificateLaurelsImage() {
            return this.certificateLaurelsImage;
        }

        @Override // android.os.Parcelable
        public final String getCertificatePaperImage() {
            return this.certificatePaperImage;
        }

        @Override // android.os.Parcelable
        public final String getCertificatePdfUrl() {
            return this.certificatePdfUrl;
        }

        @Override // android.os.Parcelable
        public final String getCertificatePlaceholderUrl() {
            return this.certificatePlaceholderUrl;
        }

        @Override // android.os.Parcelable
        public final String getCertificateRequirements() {
            return this.certificateRequirements;
        }

        @Override // android.os.Parcelable
        public final String getDogId() {
            return this.dogId;
        }

        @Override // android.os.Parcelable
        public final String getDogName() {
            return this.dogName;
        }

        @Override // android.os.Parcelable
        public app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData getProgramCompletion() {
            return this.programCompletion;
        }

        @Override // android.os.Parcelable
        public final String getProgramTitle() {
            return this.programTitle;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState getState() {
            return this.state;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            boolean isCertificateUnlocked;
            if (this.isCertificateUnlocked) {
                isCertificateUnlocked = 1;
            }
            return i22 += i33;
        }

        @Override // android.os.Parcelable
        public final boolean isCertificateUnlocked() {
            return this.isCertificateUnlocked;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CertificateData(dogId=");
            stringBuilder.append(this.dogId);
            stringBuilder.append(", certificatePaperImage=");
            stringBuilder.append(this.certificatePaperImage);
            stringBuilder.append(", certificateLaurelsImage=");
            stringBuilder.append(this.certificateLaurelsImage);
            stringBuilder.append(", isCertificateUnlocked=");
            stringBuilder.append(this.isCertificateUnlocked);
            stringBuilder.append(", certificatePlaceholderUrl=");
            stringBuilder.append(this.certificatePlaceholderUrl);
            stringBuilder.append(", certificateImageUrl=");
            stringBuilder.append(this.certificateImageUrl);
            stringBuilder.append(", certificatePdfUrl=");
            stringBuilder.append(this.certificatePdfUrl);
            stringBuilder.append(", certificateRequirements=");
            stringBuilder.append(this.certificateRequirements);
            stringBuilder.append(", programTitle=");
            stringBuilder.append(this.programTitle);
            stringBuilder.append(", dogName=");
            stringBuilder.append(this.dogName);
            stringBuilder.append(", programCompletion=");
            stringBuilder.append(getProgramCompletion());
            stringBuilder.append(", state=");
            stringBuilder.append(this.state);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.dogId);
            parcel.writeString(this.certificatePaperImage);
            parcel.writeString(this.certificateLaurelsImage);
            parcel.writeInt(this.isCertificateUnlocked);
            parcel.writeString(this.certificatePlaceholderUrl);
            parcel.writeString(this.certificateImageUrl);
            parcel.writeString(this.certificatePdfUrl);
            parcel.writeString(this.certificateRequirements);
            parcel.writeString(this.programTitle);
            parcel.writeString(this.dogName);
            this.programCompletion.writeToParcel(parcel, i2);
            parcel.writeString(this.state.name());
        }
    }
    static {
        SpecialProgramOverviewItem.Creator creator = new SpecialProgramOverviewItem.Creator();
        SpecialProgramOverviewItem.CREATOR = creator;
    }

    public SpecialProgramOverviewItem() {
        super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16383, 0);
    }

    public SpecialProgramOverviewItem(String string, int i2, List<app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations> list3, List<? extends app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum> list4, app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress5, List<app.dogo.com.dogo_android.repository.domain.ArticleWithStatus> list6, List<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> list7, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData specialProgramOverviewItem$ProgramData8, boolean z9, boolean z10, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData11, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData12, boolean z13, List<Boolean> list14) {
        n.f(string, "programId");
        n.f(list3, "exercise");
        n.f(list4, "cardsOrder");
        n.f(pottyProgramProgress5, "programProgress");
        n.f(list6, "articlesWithProgress");
        n.f(list7, "reminders");
        n.f(programData8, "programData");
        n.f(certificateData11, "certificate");
        n.f(programProgressData12, "programCompletion");
        n.f(list14, "pottyCheckmarks");
        super();
        this.programId = string;
        this.unreadZendeskMessages = i2;
        this.exercise = list3;
        this.cardsOrder = list4;
        this.programProgress = pottyProgramProgress5;
        this.articlesWithProgress = list6;
        this.reminders = list7;
        this.programData = programData8;
        this.isUserPremium = z9;
        this.isProgramEnrolled = z10;
        this.certificate = certificateData11;
        this.programCompletion = programProgressData12;
        this.pottyTrackerNewUiEnabled = z13;
        this.pottyCheckmarks = list14;
    }

    public SpecialProgramOverviewItem(String string, int i2, List list3, List list4, app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress5, List list6, List list7, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData specialProgramOverviewItem$ProgramData8, boolean z9, boolean z10, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData11, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData12, boolean z13, List list14, int i15, g g16) {
        List list2;
        Object str;
        int i19;
        int i;
        List list8;
        List list9;
        app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress;
        app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress2;
        List list5;
        int i21;
        List list;
        int i22;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData programData;
        int i12;
        int i9;
        int i6;
        int i5;
        int i4;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData certificateData;
        int i25;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programProgressData;
        int i16;
        int i26;
        int i7;
        int i23;
        int i11;
        int i3;
        int i20;
        int i18;
        int i10;
        int i14;
        int i17;
        int i24;
        int i8;
        int i13;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData obj29;
        int obj30;
        int obj31;
        int obj32;
        int obj33;
        int obj34;
        int obj35;
        int i27 = i15;
        str = i27 & 1 != 0 ? "" : string;
        i = 0;
        i19 = i27 & 2 != 0 ? i : i2;
        if (i27 & 4 != 0) {
            list8 = p.g();
        } else {
            list8 = list3;
        }
        if (i27 & 8 != 0) {
            list9 = i.a0(SpecialProgramOverviewItem.PottyOverviewCardEnum.values());
        } else {
            list9 = list4;
        }
        if (i27 & 16 != 0) {
            super(0, 0, obj10, 0, obj12, 0, 0, 0, 0, 0, 0, 0, 0, 2047, 0);
        } else {
            pottyProgramProgress = pottyProgramProgress5;
        }
        if (i27 & 32 != 0) {
            list5 = p.g();
        } else {
            list5 = list6;
        }
        if (i27 & 64 != 0) {
            list = p.g();
        } else {
            list = list7;
        }
        if (i27 & 128 != 0) {
            super(0, 0, 0, 7, 0);
        } else {
            programData = programData8;
        }
        i9 = i27 & 256 != 0 ? i : z9;
        i5 = i27 & 512 != 0 ? i : z10;
        if (i27 & 1024 != 0) {
            super(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4095, 0);
        } else {
            certificateData = certificateData11;
        }
        if (i27 & 2048 != 0) {
            super(0, 0, 0, 0, 15, 0);
        } else {
            programProgressData = programProgressData12;
        }
        if (i27 & 4096 != 0) {
        } else {
            i = z13;
        }
        if (i27 &= 8192 != 0) {
            list2 = p.g();
        } else {
            list2 = list14;
        }
        super(str, i19, list8, list9, pottyProgramProgress, list5, list, programData, i9, i5, certificateData, programProgressData, i, list2);
    }

    public static app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem copy$default(app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem specialProgramOverviewItem, String string2, int i3, List list4, List list5, app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress6, List list7, List list8, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData specialProgramOverviewItem$ProgramData9, boolean z10, boolean z11, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData12, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData13, boolean z14, List list15, int i16, Object object17) {
        List pottyCheckmarks;
        String programId;
        int unreadZendeskMessages;
        List exercise;
        List cardsOrder;
        app.dogo.com.dogo_android.repository.domain.PottyProgramProgress programProgress;
        List articlesWithProgress;
        List reminders;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData programData;
        boolean isUserPremium;
        boolean isProgramEnrolled;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData certificate;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programCompletion;
        boolean pottyTrackerNewUiEnabled;
        Object obj = specialProgramOverviewItem;
        int i = i16;
        programId = i & 1 != 0 ? obj.programId : string2;
        unreadZendeskMessages = i & 2 != 0 ? obj.unreadZendeskMessages : i3;
        exercise = i & 4 != 0 ? obj.exercise : list4;
        cardsOrder = i & 8 != 0 ? obj.cardsOrder : list5;
        programProgress = i & 16 != 0 ? obj.programProgress : pottyProgramProgress6;
        articlesWithProgress = i & 32 != 0 ? obj.articlesWithProgress : list7;
        reminders = i & 64 != 0 ? obj.reminders : list8;
        programData = i & 128 != 0 ? obj.programData : programData9;
        isUserPremium = i & 256 != 0 ? obj.isUserPremium : z10;
        isProgramEnrolled = i & 512 != 0 ? obj.isProgramEnrolled : z11;
        certificate = i & 1024 != 0 ? obj.certificate : certificateData12;
        if (i & 2048 != 0) {
            programCompletion = specialProgramOverviewItem.getProgramCompletion();
        } else {
            programCompletion = programProgressData13;
        }
        pottyTrackerNewUiEnabled = i & 4096 != 0 ? obj.pottyTrackerNewUiEnabled : z14;
        pottyCheckmarks = i &= 8192 != 0 ? obj.pottyCheckmarks : list15;
        return specialProgramOverviewItem.copy(programId, unreadZendeskMessages, exercise, cardsOrder, programProgress, articlesWithProgress, reminders, programData, isUserPremium, isProgramEnrolled, certificate, programCompletion, pottyTrackerNewUiEnabled, pottyCheckmarks);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final boolean component10() {
        return this.isProgramEnrolled;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData component11() {
        return this.certificate;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData component12() {
        return getProgramCompletion();
    }

    @Override // android.os.Parcelable
    public final boolean component13() {
        return this.pottyTrackerNewUiEnabled;
    }

    public final List<Boolean> component14() {
        return this.pottyCheckmarks;
    }

    @Override // android.os.Parcelable
    public final int component2() {
        return this.unreadZendeskMessages;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations> component3() {
        return this.exercise;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum> component4() {
        return this.cardsOrder;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.PottyProgramProgress component5() {
        return this.programProgress;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ArticleWithStatus> component6() {
        return this.articlesWithProgress;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> component7() {
        return this.reminders;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData component8() {
        return this.programData;
    }

    @Override // android.os.Parcelable
    public final boolean component9() {
        return this.isUserPremium;
    }

    public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem copy(String string, int i2, List<app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations> list3, List<? extends app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum> list4, app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress5, List<app.dogo.com.dogo_android.repository.domain.ArticleWithStatus> list6, List<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> list7, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData specialProgramOverviewItem$ProgramData8, boolean z9, boolean z10, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData specialProgramOverviewItem$CertificateData11, app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData12, boolean z13, List<Boolean> list14) {
        final Object obj = string;
        n.f(obj, "programId");
        final Object obj2 = list3;
        n.f(obj2, "exercise");
        final Object obj3 = list4;
        n.f(obj3, "cardsOrder");
        final Object obj4 = pottyProgramProgress5;
        n.f(obj4, "programProgress");
        final Object obj5 = list6;
        n.f(obj5, "articlesWithProgress");
        final Object obj6 = list7;
        n.f(obj6, "reminders");
        final Object obj7 = programData8;
        n.f(obj7, "programData");
        final Object obj8 = certificateData11;
        n.f(obj8, "certificate");
        final Object obj9 = programProgressData12;
        n.f(obj9, "programCompletion");
        final Object obj10 = list14;
        n.f(obj10, "pottyCheckmarks");
        super(obj, i2, obj2, obj3, obj4, obj5, obj6, obj7, z9, z10, obj8, obj9, z13, obj10);
        return specialProgramOverviewItem;
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
        if (!object instanceof SpecialProgramOverviewItem) {
            return i2;
        }
        if (!n.b(this.programId, object.programId)) {
            return i2;
        }
        if (this.unreadZendeskMessages != object.unreadZendeskMessages) {
            return i2;
        }
        if (!n.b(this.exercise, object.exercise)) {
            return i2;
        }
        if (!n.b(this.cardsOrder, object.cardsOrder)) {
            return i2;
        }
        if (!n.b(this.programProgress, object.programProgress)) {
            return i2;
        }
        if (!n.b(this.articlesWithProgress, object.articlesWithProgress)) {
            return i2;
        }
        if (!n.b(this.reminders, object.reminders)) {
            return i2;
        }
        if (!n.b(this.programData, object.programData)) {
            return i2;
        }
        if (this.isUserPremium != object.isUserPremium) {
            return i2;
        }
        if (this.isProgramEnrolled != object.isProgramEnrolled) {
            return i2;
        }
        if (!n.b(this.certificate, object.certificate)) {
            return i2;
        }
        if (!n.b(getProgramCompletion(), (SpecialProgramOverviewItem)object.getProgramCompletion())) {
            return i2;
        }
        if (this.pottyTrackerNewUiEnabled != object.pottyTrackerNewUiEnabled) {
            return i2;
        }
        if (!n.b(this.pottyCheckmarks, object.pottyCheckmarks)) {
            return i2;
        }
        return i;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.ArticleWithStatus> getArticlesWithProgress() {
        return this.articlesWithProgress;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum> getCardsOrder() {
        return this.cardsOrder;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData getCertificate() {
        return this.certificate;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations> getExercise() {
        return this.exercise;
    }

    public final List<Boolean> getPottyCheckmarks() {
        return this.pottyCheckmarks;
    }

    @Override // android.os.Parcelable
    public final boolean getPottyTrackerNewUiEnabled() {
        return this.pottyTrackerNewUiEnabled;
    }

    @Override // android.os.Parcelable
    public app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData getProgramCompletion() {
        return this.programCompletion;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData getProgramData() {
        return this.programData;
    }

    @Override // android.os.Parcelable
    public final String getProgramId() {
        return this.programId;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.PottyProgramProgress getProgramProgress() {
        return this.programProgress;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.PottyRemindersItem> getReminders() {
        return this.reminders;
    }

    @Override // android.os.Parcelable
    public final int getUnreadZendeskMessages() {
        return this.unreadZendeskMessages;
    }

    @Override // android.os.Parcelable
    public final boolean hasLogs() {
        return this.programProgress.hasLogs();
    }

    @Override // android.os.Parcelable
    public final boolean hasProgress() {
        boolean progress;
        int i;
        if (!this.programProgress.hasProgress()) {
            if (empty ^= i != 0) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean isUserPremium;
        boolean isProgramEnrolled;
        boolean i;
        i = 1;
        if (this.isUserPremium) {
            isUserPremium = i;
        }
        if (this.isProgramEnrolled) {
            isProgramEnrolled = i;
        }
        boolean pottyTrackerNewUiEnabled = this.pottyTrackerNewUiEnabled;
        if (pottyTrackerNewUiEnabled) {
        } else {
            i = pottyTrackerNewUiEnabled;
        }
        return i27 += i38;
    }

    @Override // android.os.Parcelable
    public final boolean isProgramEnrolled() {
        return this.isProgramEnrolled;
    }

    @Override // android.os.Parcelable
    public final boolean isUserPremium() {
        return this.isUserPremium;
    }

    public final void setPottyCheckmarks(List<Boolean> list) {
        n.f(list, "<set-?>");
        this.pottyCheckmarks = list;
    }

    @Override // android.os.Parcelable
    public final void setPottyTrackerNewUiEnabled(boolean z) {
        this.pottyTrackerNewUiEnabled = z;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SpecialProgramOverviewItem(programId=");
        stringBuilder.append(this.programId);
        stringBuilder.append(", unreadZendeskMessages=");
        stringBuilder.append(this.unreadZendeskMessages);
        stringBuilder.append(", exercise=");
        stringBuilder.append(this.exercise);
        stringBuilder.append(", cardsOrder=");
        stringBuilder.append(this.cardsOrder);
        stringBuilder.append(", programProgress=");
        stringBuilder.append(this.programProgress);
        stringBuilder.append(", articlesWithProgress=");
        stringBuilder.append(this.articlesWithProgress);
        stringBuilder.append(", reminders=");
        stringBuilder.append(this.reminders);
        stringBuilder.append(", programData=");
        stringBuilder.append(this.programData);
        stringBuilder.append(", isUserPremium=");
        stringBuilder.append(this.isUserPremium);
        stringBuilder.append(", isProgramEnrolled=");
        stringBuilder.append(this.isProgramEnrolled);
        stringBuilder.append(", certificate=");
        stringBuilder.append(this.certificate);
        stringBuilder.append(", programCompletion=");
        stringBuilder.append(getProgramCompletion());
        stringBuilder.append(", pottyTrackerNewUiEnabled=");
        stringBuilder.append(this.pottyTrackerNewUiEnabled);
        stringBuilder.append(", pottyCheckmarks=");
        stringBuilder.append(this.pottyCheckmarks);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int booleanValue;
        int size3;
        int size;
        int size2;
        int size4;
        n.f(parcel, "out");
        parcel.writeString(this.programId);
        parcel.writeInt(this.unreadZendeskMessages);
        List exercise = this.exercise;
        parcel.writeInt(exercise.size());
        Iterator iterator = exercise.iterator();
        for (TrickItemWithVariations size3 : iterator) {
            size3.writeToParcel(parcel, i2);
        }
        List cardsOrder = this.cardsOrder;
        parcel.writeInt(cardsOrder.size());
        Iterator iterator2 = cardsOrder.iterator();
        for (SpecialProgramOverviewItem.PottyOverviewCardEnum next7 : iterator2) {
            parcel.writeString(next7.name());
        }
        this.programProgress.writeToParcel(parcel, i2);
        List articlesWithProgress = this.articlesWithProgress;
        parcel.writeInt(articlesWithProgress.size());
        Iterator iterator3 = articlesWithProgress.iterator();
        for (ArticleWithStatus size2 : iterator3) {
            size2.writeToParcel(parcel, i2);
        }
        List reminders = this.reminders;
        parcel.writeInt(reminders.size());
        Iterator iterator4 = reminders.iterator();
        for (PottyRemindersItem size4 : iterator4) {
            size4.writeToParcel(parcel, i2);
        }
        this.programData.writeToParcel(parcel, i2);
        parcel.writeInt(this.isUserPremium);
        parcel.writeInt(this.isProgramEnrolled);
        this.certificate.writeToParcel(parcel, i2);
        this.programCompletion.writeToParcel(parcel, i2);
        parcel.writeInt(this.pottyTrackerNewUiEnabled);
        List obj4 = this.pottyCheckmarks;
        parcel.writeInt(obj4.size());
        obj4 = obj4.iterator();
        for (Boolean next2 : obj4) {
            parcel.writeInt(next2.booleanValue());
        }
    }
}
