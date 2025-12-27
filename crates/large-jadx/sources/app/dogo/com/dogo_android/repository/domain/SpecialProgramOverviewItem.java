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

/* compiled from: SpecialProgramOverviewItem.kt */
@Metadata(d1 = "\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008-\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0087\u0008\u0018\u00002\u00020\u00012\u00020\u0002:\u0005RSTUVB¯\u0001\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r\u0012\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0008\u0012\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0008\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0015\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015\u0012\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018\u0012\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a\u0012\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0015\u0012\u000e\u0008\u0002\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0008¢\u0006\u0002\u0010\u001dJ\t\u00106\u001a\u00020\u0004HÆ\u0003J\t\u00107\u001a\u00020\u0015HÆ\u0003J\t\u00108\u001a\u00020\u0018HÆ\u0003J\t\u00109\u001a\u00020\u001aHÆ\u0003J\t\u0010:\u001a\u00020\u0015HÆ\u0003J\u000f\u0010;\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0008HÆ\u0003J\t\u0010<\u001a\u00020\u0006HÆ\u0003J\u000f\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008HÆ\u0003J\u000f\u0010>\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008HÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J\u000f\u0010@\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0008HÆ\u0003J\u000f\u0010A\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0008HÆ\u0003J\t\u0010B\u001a\u00020\u0013HÆ\u0003J\t\u0010C\u001a\u00020\u0015HÆ\u0003J³\u0001\u0010D\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u000e\u0008\u0002\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\r2\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u00082\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00082\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00152\u000e\u0008\u0002\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0008HÆ\u0001J\t\u0010E\u001a\u00020\u0006HÖ\u0001J\u0013\u0010F\u001a\u00020\u00152\u0008\u0010G\u001a\u0004\u0018\u00010HHÖ\u0003J\u0006\u0010I\u001a\u00020\u0015J\u0006\u0010J\u001a\u00020\u0015J\t\u0010K\u001a\u00020\u0006HÖ\u0001J\t\u0010L\u001a\u00020\u0004HÖ\u0001J\u0019\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020\u0006HÖ\u0001R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u001fR\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008#\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010$R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010$R \u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0008X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010\u001f\"\u0004\u0008&\u0010'R\u001a\u0010\u001b\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010$\"\u0004\u0008)\u0010*R\u0014\u0010\u0019\u001a\u00020\u001aX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010,R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\u0008\n\u0000\u001a\u0004\u0008-\u0010.R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008/\u00100R\u0011\u0010\u000c\u001a\u00020\r¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u0017\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u00105¨\u0006W", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "Landroid/os/Parcelable;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramCompletion;", "programId", "", "unreadZendeskMessages", "", "exercise", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "cardsOrder", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$PottyOverviewCardEnum;", "programProgress", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "articlesWithProgress", "Lapp/dogo/com/dogo_android/repository/domain/ArticleWithStatus;", "reminders", "Lapp/dogo/com/dogo_android/repository/domain/PottyRemindersItem;", "programData", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramData;", "isUserPremium", "", "isProgramEnrolled", "certificate", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "programCompletion", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "pottyTrackerNewUiEnabled", "pottyCheckmarks", "(Ljava/lang/String;ILjava/util/List;Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;Ljava/util/List;Ljava/util/List;Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramData;ZZLapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;ZLjava/util/List;)V", "getArticlesWithProgress", "()Ljava/util/List;", "getCardsOrder", "getCertificate", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "getExercise", "()Z", "getPottyCheckmarks", "setPottyCheckmarks", "(Ljava/util/List;)V", "getPottyTrackerNewUiEnabled", "setPottyTrackerNewUiEnabled", "(Z)V", "getProgramCompletion", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "getProgramData", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramData;", "getProgramId", "()Ljava/lang/String;", "getProgramProgress", "()Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "getReminders", "getUnreadZendeskMessages", "()I", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hasLogs", "hasProgress", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CertificateData", "CertificateState", "PottyOverviewCardEnum", "ProgramData", "ProgramProgressData", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SpecialProgramOverviewItem implements Parcelable, h {

    public static final Parcelable.Creator<SpecialProgramOverviewItem> CREATOR = new SpecialProgramOverviewItem$Creator<>();
    private final List<ArticleWithStatus> articlesWithProgress;
    private final List<SpecialProgramOverviewItem.PottyOverviewCardEnum> cardsOrder;
    private final SpecialProgramOverviewItem.CertificateData certificate;
    private final List<TrickItemWithVariations> exercise;
    private final boolean isProgramEnrolled;
    private final boolean isUserPremium;
    private List<Boolean> pottyCheckmarks;
    private boolean pottyTrackerNewUiEnabled;
    private final SpecialProgramOverviewItem.ProgramProgressData programCompletion;
    private final SpecialProgramOverviewItem.ProgramData programData;
    private final String programId;
    private final PottyProgramProgress programProgress;
    private final List<PottyRemindersItem> reminders;
    private final int unreadZendeskMessages;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateState;", "", "(Ljava/lang/String;I)V", "LOCKED", "UNLOCKED", "LOCKED_HIDDEN", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum CertificateState {

        LOCKED,
        LOCKED_HIDDEN,
        UNLOCKED;
        private static final /* synthetic */ SpecialProgramOverviewItem.CertificateState[] $values() {
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState[] arr = new SpecialProgramOverviewItem.CertificateState[3];
            return new SpecialProgramOverviewItem.CertificateState[] { SpecialProgramOverviewItem_CertificateState.LOCKED, SpecialProgramOverviewItem_CertificateState.UNLOCKED, SpecialProgramOverviewItem_CertificateState.LOCKED_HIDDEN };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SpecialProgramOverviewItem> {
        @Override // android.os.Parcelable$Creator
        public final SpecialProgramOverviewItem createFromParcel(Parcel parcel) {
            int i = 0;
            int _int;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            boolean z3 = false;
            boolean z4 = false;
            boolean z = false;
            Object parcel2 = parcel;
            n.f(parcel2, "parcel");
            int _int2 = parcel.readInt();
            final ArrayList arrayList2 = new ArrayList(_int2);
            i2 = 0;
            while (i2 != _int2) {
                arrayList2.add(TrickItemWithVariations.CREATOR.createFromParcel(parcel2));
                i2 = i2 + 1;
            }
            int _int3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(_int3);
            i3 = 0;
            while (TrickItemWithVariations.CREATOR != _int3) {
                arrayList3.add(SpecialProgramOverviewItem_PottyOverviewCardEnum.valueOf(parcel.readString()));
                i3 = i3 + 1;
            }
            int _int4 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(_int4);
            i4 = 0;
            while (i4 != PottyProgramProgress.CREATOR) {
                arrayList4.add(ArticleWithStatus.CREATOR.createFromParcel(parcel2));
                i4 = i4 + 1;
            }
            int _int5 = parcel.readInt();
            ArrayList arrayList5 = new ArrayList(_int5);
            i5 = 0;
            while (ArticleWithStatus.CREATOR != PottyProgramProgress.CREATOR) {
                arrayList5.add(PottyRemindersItem.CREATOR.createFromParcel(parcel2));
                i5 = i5 + 1;
            }
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            int r12 = parcel.readInt() != 0 ? 1 : 0;
            int r15 = parcel.readInt() != 0 ? 1 : 0;
            ArrayList arrayList = new ArrayList(parcel.readInt());
            i6 = 0;
            while (PottyRemindersItem.CREATOR != _int) {
                int r18 = parcel.readInt() != 0 ? 1 : 0;
                arrayList.add(Boolean.valueOf((parcel.readInt() != 0 ? 1 : 0)));
                i6 = i6 + 1;
            }
            SpecialProgramOverviewItem specialProgramOverviewItem = new SpecialProgramOverviewItem(parcel.readString(), parcel.readInt(), arrayList2, arrayList3, (PottyProgramProgress)PottyProgramProgress.CREATOR.createFromParcel(parcel2), arrayList4, arrayList5, (SpecialProgramOverviewItem_ProgramData)SpecialProgramOverviewItem_ProgramData.CREATOR.createFromParcel(parcel2), i, z3, (SpecialProgramOverviewItem_CertificateData)SpecialProgramOverviewItem_CertificateData.CREATOR.createFromParcel(parcel2), (SpecialProgramOverviewItem_ProgramProgressData)SpecialProgramOverviewItem_ProgramProgressData.CREATOR.createFromParcel(parcel2), z4, arrayList);
            return specialProgramOverviewItem;
        }

        @Override // android.os.Parcelable$Creator
        public final SpecialProgramOverviewItem[] newArray(int i) {
            return new SpecialProgramOverviewItem[i];
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0086\u0001\u0018\u0000 \r2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000c¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$PottyOverviewCardEnum;", "", "cardType", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getCardType", "()Ljava/lang/String;", "ARTICLE", "PROGRESS", "CERTIFICATE", "EXERCISE", "LOGS", "REMINDER", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum PottyOverviewCardEnum {

        ARTICLE,
        CERTIFICATE,
        EXERCISE,
        LOGS,
        PROGRESS,
        REMINDER;

        private final String cardType;
        @Override // java.lang.Enum
        public final String getCardType() {
            return this.cardType;
        }

        private static final /* synthetic */ SpecialProgramOverviewItem.PottyOverviewCardEnum[] $values() {
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.PottyOverviewCardEnum[] arr = new SpecialProgramOverviewItem.PottyOverviewCardEnum[6];
            return new SpecialProgramOverviewItem.PottyOverviewCardEnum[] { SpecialProgramOverviewItem_PottyOverviewCardEnum.ARTICLE, SpecialProgramOverviewItem_PottyOverviewCardEnum.PROGRESS, SpecialProgramOverviewItem_PottyOverviewCardEnum.CERTIFICATE, SpecialProgramOverviewItem_PottyOverviewCardEnum.EXERCISE, SpecialProgramOverviewItem_PottyOverviewCardEnum.LOGS, SpecialProgramOverviewItem_PottyOverviewCardEnum.REMINDER };
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramData;", "Landroid/os/Parcelable;", "centerImage", "", "programTitle", "programDescription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCenterImage", "()Ljava/lang/String;", "getProgramDescription", "getProgramTitle", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramData implements Parcelable {

        public static final Parcelable.Creator<SpecialProgramOverviewItem.ProgramData> CREATOR = new SpecialProgramOverviewItem$ProgramData$Creator<>();
        private final String centerImage;
        private final String programDescription;
        private final String programTitle;
        public ProgramData(String str, String str2, String str3) {
            n.f(str, "centerImage");
            n.f(str2, "programTitle");
            n.f(str3, "programDescription");
            super();
            this.centerImage = str;
            this.programTitle = str2;
            this.programDescription = str3;
        }

        public final String getCenterImage() {
            return this.centerImage;
        }

        public final String getProgramDescription() {
            return this.programDescription;
        }

        public final String getProgramTitle() {
            return this.programTitle;
        }

        public /* synthetic */ ProgramData(String str, String str2, String str3, int i, g gVar) {
            String str4;
            str4 = "";
            str4 = i & 1 != 0 ? str4 : str4;
            str4 = i & 2 != 0 ? str4 : str4;
            str4 = i & 4 != 0 ? str4 : str4;
            this(str4, str4, str4);
        }


        public ProgramData() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SpecialProgramOverviewItem.ProgramData copy$default(SpecialProgramOverviewItem.ProgramData programData, String str, String str2, String str3, int i, Object object) {
            String centerImage2;
            String programTitle2;
            String programDescription2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            return programData.copy(centerImage2, programTitle2, programDescription2);
        }

        /* operator */ public final String component1() {
            return this.centerImage;
        }

        /* operator */ public final String component2() {
            return this.programTitle;
        }

        /* operator */ public final String component3() {
            return this.programDescription;
        }

        public final SpecialProgramOverviewItem.ProgramData copy(String centerImage, String programTitle, String programDescription) {
            n.f(centerImage, "centerImage");
            n.f(programTitle, "programTitle");
            n.f(programDescription, "programDescription");
            return new SpecialProgramOverviewItem_ProgramData(centerImage, programTitle, programDescription);
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
            final boolean z5 = false;
            if (!(other instanceof SpecialProgramOverviewItem_ProgramData)) {
                return false;
            }
            if (!n.b(this.centerImage, other.centerImage)) {
                return false;
            }
            if (!n.b(this.programTitle, other.programTitle)) {
                return false;
            }
            return !n.b(this.programDescription, other.programDescription) ? z5 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (this.centerImage.hashCode() * 31) + this.programTitle.hashCode() * 31 + this.programDescription.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ProgramData(centerImage=";
            String str3 = ", programTitle=";
            String str4 = ", programDescription=";
            str = str2 + this.centerImage + str3 + this.programTitle + str4 + this.programDescription + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.centerImage);
            parcel.writeString(this.programTitle);
            parcel.writeString(this.programDescription);
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00052\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000c¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "Landroid/os/Parcelable;", "articleCompletionPercentage", "", "articlesAreCompleted", "", "trickCompletionPercentage", "tricksAreCompleted", "(IZIZ)V", "getArticleCompletionPercentage", "()I", "getArticlesAreCompleted", "()Z", "getTrickCompletionPercentage", "getTricksAreCompleted", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class ProgramProgressData implements Parcelable {

        public static final Parcelable.Creator<SpecialProgramOverviewItem.ProgramProgressData> CREATOR = new SpecialProgramOverviewItem$ProgramProgressData$Creator<>();
        private final int articleCompletionPercentage;
        private final boolean articlesAreCompleted;
        private final int trickCompletionPercentage;
        private final boolean tricksAreCompleted;
        public ProgramProgressData(int i, boolean z, int i2, boolean z2) {
            super();
            this.articleCompletionPercentage = i;
            this.articlesAreCompleted = z;
            this.trickCompletionPercentage = i2;
            this.tricksAreCompleted = z2;
        }

        public final int getArticleCompletionPercentage() {
            return this.articleCompletionPercentage;
        }

        public final boolean getArticlesAreCompleted() {
            return this.articlesAreCompleted;
        }

        public final int getTrickCompletionPercentage() {
            return this.trickCompletionPercentage;
        }

        public final boolean getTricksAreCompleted() {
            return this.tricksAreCompleted;
        }

        public /* synthetic */ ProgramProgressData(int i, boolean z, int i2, boolean z2, int i3, g gVar) {
            boolean z3;
            i2 = 0;
            i2 = i3 & 1 != 0 ? i2 : i2;
            i2 = i3 & 2 != 0 ? i2 : i2;
            i2 = i3 & 4 != 0 ? i2 : i2;
            i2 = i3 & 8 != 0 ? i2 : i2;
            this(i2, z, i2, z3);
        }


        public ProgramProgressData() {
            this(0, false, 0, false, 15, null);
        }

        public static /* synthetic */ SpecialProgramOverviewItem.ProgramProgressData copy$default(SpecialProgramOverviewItem.ProgramProgressData programProgressData, int i, boolean z, int i2, boolean z2, int i3, Object object) {
            int articleCompletionPercentage2;
            boolean articlesAreCompleted2;
            int trickCompletionPercentage2;
            boolean tricksAreCompleted2;
            if (i3 & 1 != 0) {
            }
            if (i3 & 2 != 0) {
            }
            if (i3 & 4 != 0) {
            }
            if (i3 & 8 != 0) {
            }
            return programProgressData.copy(articleCompletionPercentage2, articlesAreCompleted2, trickCompletionPercentage2, tricksAreCompleted2);
        }

        /* operator */ public final int component1() {
            return this.articleCompletionPercentage;
        }

        /* operator */ public final boolean component2() {
            return this.articlesAreCompleted;
        }

        /* operator */ public final int component3() {
            return this.trickCompletionPercentage;
        }

        /* operator */ public final boolean component4() {
            return this.tricksAreCompleted;
        }

        public final SpecialProgramOverviewItem.ProgramProgressData copy(int articleCompletionPercentage, boolean articlesAreCompleted, int trickCompletionPercentage, boolean tricksAreCompleted) {
            return new SpecialProgramOverviewItem_ProgramProgressData(articleCompletionPercentage, articlesAreCompleted, trickCompletionPercentage, tricksAreCompleted);
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
            final boolean z3 = false;
            if (!(other instanceof SpecialProgramOverviewItem_ProgramProgressData)) {
                return false;
            }
            if (this.articleCompletionPercentage != other.articleCompletionPercentage) {
                return false;
            }
            if (this.articlesAreCompleted != other.articlesAreCompleted) {
                return false;
            }
            if (this.trickCompletionPercentage != other.trickCompletionPercentage) {
                return false;
            }
            return this.tricksAreCompleted != other.tricksAreCompleted ? z3 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            boolean articlesAreCompleted2;
            int i = 1;
            i = 1;
            if (this.articlesAreCompleted) {
            }
            if (!(this.tricksAreCompleted)) {
            }
            return (Integer.hashCode(this.articleCompletionPercentage) * 31) + articlesAreCompleted2 * 31 + Integer.hashCode(this.trickCompletionPercentage) * 31 + i;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ProgramProgressData(articleCompletionPercentage=";
            String str3 = ", articlesAreCompleted=";
            String str4 = ", trickCompletionPercentage=";
            String str5 = ", tricksAreCompleted=";
            str = str2 + this.articleCompletionPercentage + str3 + this.articlesAreCompleted + str4 + this.trickCompletionPercentage + str5 + this.tricksAreCompleted + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeInt(this.articleCompletionPercentage);
            parcel.writeInt(this.articlesAreCompleted);
            parcel.writeInt(this.trickCompletionPercentage);
            parcel.writeInt(this.tricksAreCompleted);
        }
    }

    @Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u001e\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u00012\u00020\u0002B}\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0010HÆ\u0003J\t\u0010&\u001a\u00020\u0012HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0008HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003J\t\u0010.\u001a\u00020\u0004HÆ\u0003J\u0081\u0001\u0010/\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00042\u0008\u0008\u0002\u0010\r\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\t\u00100\u001a\u000201HÖ\u0001J\u0013\u00102\u001a\u00020\u00082\u0008\u00103\u001a\u0004\u0018\u000104HÖ\u0003J\t\u00105\u001a\u000201HÖ\u0001J\t\u00106\u001a\u00020\u0004HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u000201HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0015R\u0011\u0010\u000c\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u001dR\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"¨\u0006<", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateData;", "Landroid/os/Parcelable;", "Lapp/dogo/com/dogo_android/specialprograms/SpecialProgramCompletion;", "dogId", "", "certificatePaperImage", "certificateLaurelsImage", "isCertificateUnlocked", "", "certificatePlaceholderUrl", "certificateImageUrl", "certificatePdfUrl", "certificateRequirements", "programTitle", "dogName", "programCompletion", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "state", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateState;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateState;)V", "getCertificateImageUrl", "()Ljava/lang/String;", "getCertificateLaurelsImage", "getCertificatePaperImage", "getCertificatePdfUrl", "getCertificatePlaceholderUrl", "getCertificateRequirements", "getDogId", "getDogName", "()Z", "getProgramCompletion", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$ProgramProgressData;", "getProgramTitle", "getState", "()Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem$CertificateState;", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class CertificateData implements Parcelable, h {

        public static final Parcelable.Creator<SpecialProgramOverviewItem.CertificateData> CREATOR = new SpecialProgramOverviewItem$CertificateData$Creator<>();
        private final String certificateImageUrl;
        private final String certificateLaurelsImage;
        private final String certificatePaperImage;
        private final String certificatePdfUrl;
        private final String certificatePlaceholderUrl;
        private final String certificateRequirements;
        private final String dogId;
        private final String dogName;
        private final boolean isCertificateUnlocked;
        private final SpecialProgramOverviewItem.ProgramProgressData programCompletion;
        private final String programTitle;
        private final SpecialProgramOverviewItem.CertificateState state;
        public CertificateData(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9, SpecialProgramOverviewItem.ProgramProgressData programProgressData, SpecialProgramOverviewItem.CertificateState certificateState) {
            n.f(str, "dogId");
            n.f(str2, "certificatePaperImage");
            n.f(str3, "certificateLaurelsImage");
            n.f(str4, "certificatePlaceholderUrl");
            n.f(str5, "certificateImageUrl");
            n.f(str6, "certificatePdfUrl");
            n.f(str7, "certificateRequirements");
            n.f(str8, "programTitle");
            n.f(str9, "dogName");
            n.f(programProgressData, "programCompletion");
            n.f(certificateState, "state");
            super();
            this.dogId = str;
            this.certificatePaperImage = str2;
            this.certificateLaurelsImage = str3;
            this.isCertificateUnlocked = z;
            this.certificatePlaceholderUrl = str4;
            this.certificateImageUrl = str5;
            this.certificatePdfUrl = str6;
            this.certificateRequirements = str7;
            this.programTitle = str8;
            this.dogName = str9;
            this.programCompletion = programProgressData;
            this.state = certificateState;
        }

        public final String getCertificateImageUrl() {
            return this.certificateImageUrl;
        }

        public final String getCertificateLaurelsImage() {
            return this.certificateLaurelsImage;
        }

        public final String getCertificatePaperImage() {
            return this.certificatePaperImage;
        }

        public final String getCertificatePdfUrl() {
            return this.certificatePdfUrl;
        }

        public final String getCertificatePlaceholderUrl() {
            return this.certificatePlaceholderUrl;
        }

        public final String getCertificateRequirements() {
            return this.certificateRequirements;
        }

        public final String getDogId() {
            return this.dogId;
        }

        public final String getDogName() {
            return this.dogName;
        }

        public SpecialProgramOverviewItem.ProgramProgressData getProgramCompletion() {
            return this.programCompletion;
        }

        public final String getProgramTitle() {
            return this.programTitle;
        }

        public final SpecialProgramOverviewItem.CertificateState getState() {
            return this.state;
        }

        public final boolean isCertificateUnlocked() {
            return this.isCertificateUnlocked;
        }

        public /* synthetic */ CertificateData(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9, SpecialProgramOverviewItem.ProgramProgressData programProgressData, SpecialProgramOverviewItem.CertificateState certificateState, int i, g gVar) {
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState certificateState122;
            int z42 = 0;
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programProgressData112;
            int i132 = i;
            str4 = "";
            String r1 = i132 & 1 != 0 ? str4 : str;
            String r3 = i132 & 2 != 0 ? str4 : str2;
            String r4 = i132 & 4 != 0 ? str4 : str3;
            int r5 = i132 & 8 != 0 ? 0 : z;
            String r6 = str4;
            String r7 = i132 & 32 != 0 ? str4 : str5;
            String r8 = i132 & 64 != 0 ? str4 : str6;
            String r9 = i132 & 128 != 0 ? str4 : str7;
            String r10 = i132 & 256 != 0 ? str4 : str8;
            if (i132 & 512 == 0) {
                str4 = str9;
            }
            if (i132 & 1024 != 0) {
                i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 15;
                int i6 = 0;
                super(i, i2, i3, i4, i5, i6);
            } else {
                programProgressData112 = programProgressData;
            }
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState r0 = i132 & 2048 != 0 ? SpecialProgramOverviewItem_CertificateState.LOCKED : certificateState;
            this(str4, str4, str4, z42, str4, str4, str4, str4, str4, str4, programProgressData112, (i132 & 2048 != 0 ? SpecialProgramOverviewItem_CertificateState.LOCKED : certificateState));
        }


        public CertificateData() {
            this(null, null, null, false, null, null, null, null, null, null, null, null, 4095, null);
        }

        public static /* synthetic */ SpecialProgramOverviewItem.CertificateData copy$default(SpecialProgramOverviewItem.CertificateData certificateData, String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8, String str9, SpecialProgramOverviewItem.ProgramProgressData programProgressData, SpecialProgramOverviewItem.CertificateState certificateState, int i, Object object) {
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState certificateState132;
            String str22;
            String str32;
            String str42;
            boolean z52;
            String str62;
            String str72;
            String str82;
            String str92;
            String str102;
            String str112;
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programProgressData122;
            Object certificateData2 = certificateData;
            int i142 = i;
            String r2 = i142 & 1 != 0 ? certificateData2.dogId : str;
            String r3 = i142 & 2 != 0 ? certificateData2.certificatePaperImage : str2;
            String r4 = i142 & 4 != 0 ? certificateData2.certificateLaurelsImage : str3;
            boolean r5 = i142 & 8 != 0 ? certificateData2.isCertificateUnlocked : z;
            String r6 = i142 & 16 != 0 ? certificateData2.certificatePlaceholderUrl : str4;
            String r7 = i142 & 32 != 0 ? certificateData2.certificateImageUrl : str5;
            String r8 = i142 & 64 != 0 ? certificateData2.certificatePdfUrl : str6;
            String r9 = i142 & 128 != 0 ? certificateData2.certificateRequirements : str7;
            String r10 = i142 & 256 != 0 ? certificateData2.programTitle : str8;
            String r11 = i142 & 512 != 0 ? certificateData2.dogName : str9;
            if (i142 & 1024 != 0) {
                programProgressData122 = certificateData.getProgramCompletion();
            } else {
                programProgressData122 = programProgressData;
            }
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState r1 = i142 & 2048 != 0 ? certificateData2.state : certificateState;
            return certificateData.copy(str22, str32, str42, z52, str62, str72, str82, str92, str102, str112, programProgressData122, (i142 & 2048 != 0 ? certificateData2.state : certificateState));
        }

        /* operator */ public final String component1() {
            return this.dogId;
        }

        /* operator */ public final String component10() {
            return this.dogName;
        }

        /* operator */ public final SpecialProgramOverviewItem.ProgramProgressData component11() {
            return getProgramCompletion();
        }

        /* operator */ public final SpecialProgramOverviewItem.CertificateState component12() {
            return this.state;
        }

        /* operator */ public final String component2() {
            return this.certificatePaperImage;
        }

        /* operator */ public final String component3() {
            return this.certificateLaurelsImage;
        }

        /* operator */ public final boolean component4() {
            return this.isCertificateUnlocked;
        }

        /* operator */ public final String component5() {
            return this.certificatePlaceholderUrl;
        }

        /* operator */ public final String component6() {
            return this.certificateImageUrl;
        }

        /* operator */ public final String component7() {
            return this.certificatePdfUrl;
        }

        /* operator */ public final String component8() {
            return this.certificateRequirements;
        }

        /* operator */ public final String component9() {
            return this.programTitle;
        }

        public final SpecialProgramOverviewItem.CertificateData copy(String dogId, String certificatePaperImage, String certificateLaurelsImage, boolean isCertificateUnlocked, String certificatePlaceholderUrl, String certificateImageUrl, String certificatePdfUrl, String certificateRequirements, String programTitle, String dogName, SpecialProgramOverviewItem.ProgramProgressData programCompletion, SpecialProgramOverviewItem.CertificateState state) {
            n.f(dogId, "dogId");
            final Object certificatePaperImage2 = certificatePaperImage;
            n.f(certificatePaperImage2, "certificatePaperImage");
            final Object certificateLaurelsImage2 = certificateLaurelsImage;
            n.f(certificateLaurelsImage2, "certificateLaurelsImage");
            final Object certificatePlaceholderUrl2 = certificatePlaceholderUrl;
            n.f(certificatePlaceholderUrl2, "certificatePlaceholderUrl");
            final Object certificateImageUrl2 = certificateImageUrl;
            n.f(certificateImageUrl2, "certificateImageUrl");
            final Object certificatePdfUrl2 = certificatePdfUrl;
            n.f(certificatePdfUrl2, "certificatePdfUrl");
            final Object certificateRequirements2 = certificateRequirements;
            n.f(certificateRequirements2, "certificateRequirements");
            final Object programTitle2 = programTitle;
            n.f(programTitle2, "programTitle");
            final Object dogName2 = dogName;
            n.f(dogName2, "dogName");
            final Object programCompletion2 = programCompletion;
            n.f(programCompletion2, "programCompletion");
            final Object state2 = state;
            n.f(state2, "state");
            SpecialProgramOverviewItem_CertificateData specialProgramOverviewItem_CertificateData = new SpecialProgramOverviewItem_CertificateData(dogId, certificatePaperImage2, certificateLaurelsImage2, isCertificateUnlocked, certificatePlaceholderUrl2, certificateImageUrl2, certificatePdfUrl2, certificateRequirements2, programTitle2, dogName2, programCompletion2, state2);
            return specialProgramOverviewItem_CertificateData;
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
            final boolean z13 = false;
            if (!(other instanceof SpecialProgramOverviewItem_CertificateData)) {
                return false;
            }
            if (!n.b(this.dogId, other.dogId)) {
                return false;
            }
            if (!n.b(this.certificatePaperImage, other.certificatePaperImage)) {
                return false;
            }
            if (!n.b(this.certificateLaurelsImage, other.certificateLaurelsImage)) {
                return false;
            }
            if (this.isCertificateUnlocked != other.isCertificateUnlocked) {
                return false;
            }
            if (!n.b(this.certificatePlaceholderUrl, other.certificatePlaceholderUrl)) {
                return false;
            }
            if (!n.b(this.certificateImageUrl, other.certificateImageUrl)) {
                return false;
            }
            if (!n.b(this.certificatePdfUrl, other.certificatePdfUrl)) {
                return false;
            }
            if (!n.b(this.certificateRequirements, other.certificateRequirements)) {
                return false;
            }
            if (!n.b(this.programTitle, other.programTitle)) {
                return false;
            }
            if (!n.b(this.dogName, other.dogName)) {
                return false;
            }
            if (!n.b(getProgramCompletion(), other.getProgramCompletion())) {
                return false;
            }
            return this.state != other.state ? z13 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            boolean isCertificateUnlocked2 = true;
            if (this.isCertificateUnlocked) {
                int i34 = 1;
            }
            return (this.dogId.hashCode() * 31) + this.certificatePaperImage.hashCode() * 31 + this.certificateLaurelsImage.hashCode() * 31 + isCertificateUnlocked2 * 31 + this.certificatePlaceholderUrl.hashCode() * 31 + this.certificateImageUrl.hashCode() * 31 + this.certificatePdfUrl.hashCode() * 31 + this.certificateRequirements.hashCode() * 31 + this.programTitle.hashCode() * 31 + this.dogName.hashCode() * 31 + getProgramCompletion().hashCode() * 31 + this.state.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "CertificateData(dogId=";
            String str3 = ", certificatePaperImage=";
            String str4 = ", certificateLaurelsImage=";
            String str5 = ", isCertificateUnlocked=";
            String str6 = ", certificatePlaceholderUrl=";
            String str7 = ", certificateImageUrl=";
            String str8 = ", certificatePdfUrl=";
            String str9 = ", certificateRequirements=";
            String str10 = ", programTitle=";
            String str11 = ", dogName=";
            String str12 = ", programCompletion=";
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programCompletion = getProgramCompletion();
            String str13 = ", state=";
            str = str2 + this.dogId + str3 + this.certificatePaperImage + str4 + this.certificateLaurelsImage + str5 + this.isCertificateUnlocked + str6 + this.certificatePlaceholderUrl + str7 + this.certificateImageUrl + str8 + this.certificatePdfUrl + str9 + this.certificateRequirements + str10 + this.programTitle + str11 + this.dogName + str12 + programCompletion + str13 + this.state + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
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
            this.programCompletion.writeToParcel(parcel, flags);
            parcel.writeString(this.state.name());
        }
    }
    public SpecialProgramOverviewItem(String str, int i, List<TrickItemWithVariations> list, List<? extends SpecialProgramOverviewItem.PottyOverviewCardEnum> list2, PottyProgramProgress pottyProgramProgress, List<ArticleWithStatus> list3, List<PottyRemindersItem> list4, SpecialProgramOverviewItem.ProgramData programData, boolean z, boolean z2, SpecialProgramOverviewItem.CertificateData certificateData, SpecialProgramOverviewItem.ProgramProgressData programProgressData, boolean z3, List<Boolean> list5) {
        n.f(str, "programId");
        n.f(list, "exercise");
        n.f(list2, "cardsOrder");
        n.f(pottyProgramProgress, "programProgress");
        n.f(list3, "articlesWithProgress");
        n.f(list4, "reminders");
        n.f(programData, "programData");
        n.f(certificateData, "certificate");
        n.f(programProgressData, "programCompletion");
        n.f(list5, "pottyCheckmarks");
        super();
        this.programId = str;
        this.unreadZendeskMessages = i;
        this.exercise = list;
        this.cardsOrder = list2;
        this.programProgress = pottyProgramProgress;
        this.articlesWithProgress = list3;
        this.reminders = list4;
        this.programData = programData;
        this.isUserPremium = z;
        this.isProgramEnrolled = z2;
        this.certificate = certificateData;
        this.programCompletion = programProgressData;
        this.pottyTrackerNewUiEnabled = z3;
        this.pottyCheckmarks = list5;
    }

    public final List<ArticleWithStatus> getArticlesWithProgress() {
        return this.articlesWithProgress;
    }

    public final List<SpecialProgramOverviewItem.PottyOverviewCardEnum> getCardsOrder() {
        return this.cardsOrder;
    }

    public final SpecialProgramOverviewItem.CertificateData getCertificate() {
        return this.certificate;
    }

    public final List<TrickItemWithVariations> getExercise() {
        return this.exercise;
    }

    public final List<Boolean> getPottyCheckmarks() {
        return this.pottyCheckmarks;
    }

    public final boolean getPottyTrackerNewUiEnabled() {
        return this.pottyTrackerNewUiEnabled;
    }

    public SpecialProgramOverviewItem.ProgramProgressData getProgramCompletion() {
        return this.programCompletion;
    }

    public final SpecialProgramOverviewItem.ProgramData getProgramData() {
        return this.programData;
    }

    public final String getProgramId() {
        return this.programId;
    }

    public final PottyProgramProgress getProgramProgress() {
        return this.programProgress;
    }

    public final List<PottyRemindersItem> getReminders() {
        return this.reminders;
    }

    public final int getUnreadZendeskMessages() {
        return this.unreadZendeskMessages;
    }

    public final boolean hasLogs() {
        return this.programProgress.hasLogs();
    }

    public final boolean hasProgress() {
        boolean z = true;
        if (!this.programProgress.hasProgress()) {
            if (!(this.reminders.isEmpty() ^ 1)) {
                int i3 = 0;
            }
        }
        return z;
    }

    public final boolean isProgramEnrolled() {
        return this.isProgramEnrolled;
    }

    public final boolean isUserPremium() {
        return this.isUserPremium;
    }

    public final void setPottyCheckmarks(List<Boolean> list) {
        n.f(list, "<set-?>");
        this.pottyCheckmarks = list;
    }

    public final void setPottyTrackerNewUiEnabled(boolean z) {
        this.pottyTrackerNewUiEnabled = z;
    }

    public /* synthetic */ SpecialProgramOverviewItem(String str, int i, List list, List list2, PottyProgramProgress pottyProgramProgress, List list3, List list4, SpecialProgramOverviewItem.ProgramData programData, boolean z, boolean z2, SpecialProgramOverviewItem.CertificateData certificateData, SpecialProgramOverviewItem.ProgramProgressData programProgressData, boolean z3, List list5, int i2, g gVar) {
        List list142;
        String str2;
        int i22;
        List list32;
        List list42;
        app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress52;
        List list62;
        List list72;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData programData82;
        int i3 = 0;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData certificateData112;
        int i5 = 7;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programProgressData122;
        int i6 = 0;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        int i12 = 0;
        String str9 = null;
        int i14 = 2047;
        int i16 = 0;
        String str14;
        String str15;
        String str16;
        g gVar3;
        int i152 = i2;
        String r1 = i152 & 1 != 0 ? "" : str;
        i22 = 0;
        int r2 = i152 & 2 != 0 ? i22 : i;
        if (i152 & 4 != 0) {
            list32 = p.g();
        } else {
            list32 = list;
        }
        if (i152 & 8 != 0) {
            list42 = i.a0(SpecialProgramOverviewItem_PottyOverviewCardEnum.values());
        } else {
            list42 = list2;
        }
        if (i152 & 16 != 0) {
            String str3 = null;
            long l = 0L;
            i3 = 0;
            list = null;
            list2 = null;
            z = false;
            z2 = false;
            str7 = null;
            str8 = null;
            i12 = 0;
            gVar = null;
            i14 = 2047;
            i16 = 0;
            super(str3, l, l2, i3, i30, list, list2, z, z2, str7, str8, i12, gVar, i14, i16);
        } else {
            pottyProgramProgress52 = pottyProgramProgress;
        }
        if (i152 & 32 != 0) {
            list62 = p.g();
        } else {
            list62 = list3;
        }
        if (i152 & 64 != 0) {
            list72 = p.g();
        } else {
            list72 = list4;
        }
        if (i152 & 128 != 0) {
            i = 0;
            i3 = 0;
            int i4 = 0;
            i5 = 7;
            i6 = 0;
            super(i, i3, i4, i5, i6);
        } else {
            programData82 = programData;
        }
        long l2 = i152 & 256 != 0 ? i22 : z;
        int r11 = i152 & 512 != 0 ? i22 : z2;
        if (i152 & 1024 != 0) {
            str4 = null;
            str5 = null;
            str6 = null;
            z3 = false;
            str8 = null;
            str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            programProgressData = null;
            app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState certificateState = null;
            int i17 = 4095;
            g gVar2 = null;
            super(str4, str5, str6, z3, str8, str9, str10, str11, str12, str13, programProgressData, certificateState, i17, gVar2);
        } else {
            certificateData112 = certificateData;
        }
        if (i152 & 2048 != 0) {
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 15;
            int i13 = 0;
            super(i7, i8, i9, i10, i11, i13);
        } else {
            programProgressData122 = programProgressData;
        }
        if (i152 & 4096 == 0) {
            i22 = z3;
        }
        if (i152 & 8192 != 0) {
            list142 = p.g();
        } else {
            list142 = list5;
        }
        this(str2, i22, list32, list42, pottyProgramProgress52, list62, list72, programData82, i22, i22, certificateData112, programProgressData122, i22, list142);
    }


    public SpecialProgramOverviewItem() {
        this(null, 0, null, null, null, null, null, null, false, false, null, null, false, null, 16383, null);
    }

    public static /* synthetic */ SpecialProgramOverviewItem copy$default(SpecialProgramOverviewItem specialProgramOverviewItem, String str, int i, List list, List list2, PottyProgramProgress pottyProgramProgress, List list3, List list4, SpecialProgramOverviewItem.ProgramData programData, boolean z, boolean z2, SpecialProgramOverviewItem.CertificateData certificateData, SpecialProgramOverviewItem.ProgramProgressData programProgressData, boolean z3, List list5, int i2, Object object) {
        List list152;
        String str22;
        int i32;
        List list42;
        List list52;
        app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress62;
        List list72;
        List list82;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData programData92;
        boolean z102;
        boolean z112;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData certificateData122;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programProgressData132;
        boolean z142;
        Object specialProgramOverviewItem2 = specialProgramOverviewItem;
        int i162 = i2;
        String r2 = i162 & 1 != 0 ? specialProgramOverviewItem2.programId : str;
        int r3 = i162 & 2 != 0 ? specialProgramOverviewItem2.unreadZendeskMessages : i;
        List r4 = i162 & 4 != 0 ? specialProgramOverviewItem2.exercise : list;
        List r5 = i162 & 8 != 0 ? specialProgramOverviewItem2.cardsOrder : list2;
        app.dogo.com.dogo_android.repository.domain.PottyProgramProgress r6 = i162 & 16 != 0 ? specialProgramOverviewItem2.programProgress : pottyProgramProgress;
        List r7 = i162 & 32 != 0 ? specialProgramOverviewItem2.articlesWithProgress : list3;
        List r8 = i162 & 64 != 0 ? specialProgramOverviewItem2.reminders : list4;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData r9 = i162 & 128 != 0 ? specialProgramOverviewItem2.programData : programData;
        boolean r10 = i162 & 256 != 0 ? specialProgramOverviewItem2.isUserPremium : z;
        boolean r11 = i162 & 512 != 0 ? specialProgramOverviewItem2.isProgramEnrolled : z2;
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData r12 = i162 & 1024 != 0 ? specialProgramOverviewItem2.certificate : certificateData;
        if (i162 & 2048 != 0) {
            programProgressData132 = specialProgramOverviewItem.getProgramCompletion();
        } else {
            programProgressData132 = programProgressData;
        }
        boolean r14 = i162 & 4096 != 0 ? specialProgramOverviewItem2.pottyTrackerNewUiEnabled : z3;
        List r1 = i162 & 8192 != 0 ? specialProgramOverviewItem2.pottyCheckmarks : list5;
        return specialProgramOverviewItem.copy(str22, i32, list42, list52, pottyProgramProgress62, list72, list82, programData92, z102, z112, certificateData122, programProgressData132, z142, (i162 & 8192 != 0 ? specialProgramOverviewItem2.pottyCheckmarks : list5));
    }

    /* operator */ public final String component1() {
        return this.programId;
    }

    /* operator */ public final boolean component10() {
        return this.isProgramEnrolled;
    }

    /* operator */ public final SpecialProgramOverviewItem.CertificateData component11() {
        return this.certificate;
    }

    /* operator */ public final SpecialProgramOverviewItem.ProgramProgressData component12() {
        return getProgramCompletion();
    }

    /* operator */ public final boolean component13() {
        return this.pottyTrackerNewUiEnabled;
    }

    /* operator */ public final List<Boolean> component14() {
        return this.pottyCheckmarks;
    }

    /* operator */ public final int component2() {
        return this.unreadZendeskMessages;
    }

    /* operator */ public final List<TrickItemWithVariations> component3() {
        return this.exercise;
    }

    /* operator */ public final List<SpecialProgramOverviewItem.PottyOverviewCardEnum> component4() {
        return this.cardsOrder;
    }

    /* operator */ public final PottyProgramProgress component5() {
        return this.programProgress;
    }

    /* operator */ public final List<ArticleWithStatus> component6() {
        return this.articlesWithProgress;
    }

    /* operator */ public final List<PottyRemindersItem> component7() {
        return this.reminders;
    }

    /* operator */ public final SpecialProgramOverviewItem.ProgramData component8() {
        return this.programData;
    }

    /* operator */ public final boolean component9() {
        return this.isUserPremium;
    }

    public final SpecialProgramOverviewItem copy(String programId, int unreadZendeskMessages, List<TrickItemWithVariations> exercise, List<? extends SpecialProgramOverviewItem.PottyOverviewCardEnum> cardsOrder, PottyProgramProgress programProgress, List<ArticleWithStatus> articlesWithProgress, List<PottyRemindersItem> reminders, SpecialProgramOverviewItem.ProgramData programData, boolean isUserPremium, boolean isProgramEnrolled, SpecialProgramOverviewItem.CertificateData certificate, SpecialProgramOverviewItem.ProgramProgressData programCompletion, boolean pottyTrackerNewUiEnabled, List<Boolean> pottyCheckmarks) {
        final Object programId2 = programId;
        n.f(programId2, "programId");
        final Object exercise2 = exercise;
        n.f(exercise2, "exercise");
        final Object cardsOrder2 = cardsOrder;
        n.f(cardsOrder2, "cardsOrder");
        final Object programProgress2 = programProgress;
        n.f(programProgress2, "programProgress");
        final Object articlesWithProgress2 = articlesWithProgress;
        n.f(articlesWithProgress2, "articlesWithProgress");
        final Object reminders2 = reminders;
        n.f(reminders2, "reminders");
        final Object programData2 = programData;
        n.f(programData2, "programData");
        final Object certificate2 = certificate;
        n.f(certificate2, "certificate");
        final Object programCompletion2 = programCompletion;
        n.f(programCompletion2, "programCompletion");
        final Object pottyCheckmarks2 = pottyCheckmarks;
        n.f(pottyCheckmarks2, "pottyCheckmarks");
        SpecialProgramOverviewItem specialProgramOverviewItem = new SpecialProgramOverviewItem(programId2, unreadZendeskMessages, exercise2, cardsOrder2, programProgress2, articlesWithProgress2, reminders2, programData2, isUserPremium, isProgramEnrolled, certificate2, programCompletion2, pottyTrackerNewUiEnabled, pottyCheckmarks2);
        return specialProgramOverviewItem;
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
        final boolean z12 = false;
        if (!(other instanceof SpecialProgramOverviewItem)) {
            return false;
        }
        if (!n.b(this.programId, other.programId)) {
            return false;
        }
        if (this.unreadZendeskMessages != other.unreadZendeskMessages) {
            return false;
        }
        if (!n.b(this.exercise, other.exercise)) {
            return false;
        }
        if (!n.b(this.cardsOrder, other.cardsOrder)) {
            return false;
        }
        if (!n.b(this.programProgress, other.programProgress)) {
            return false;
        }
        if (!n.b(this.articlesWithProgress, other.articlesWithProgress)) {
            return false;
        }
        if (!n.b(this.reminders, other.reminders)) {
            return false;
        }
        if (!n.b(this.programData, other.programData)) {
            return false;
        }
        if (this.isUserPremium != other.isUserPremium) {
            return false;
        }
        if (this.isProgramEnrolled != other.isProgramEnrolled) {
            return false;
        }
        if (!n.b(this.certificate, other.certificate)) {
            return false;
        }
        if (!n.b(getProgramCompletion(), other.getProgramCompletion())) {
            return false;
        }
        if (this.pottyTrackerNewUiEnabled != other.pottyTrackerNewUiEnabled) {
            return false;
        }
        return !n.b(this.pottyCheckmarks, other.pottyCheckmarks) ? z12 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean isUserPremium2;
        boolean isProgramEnrolled2;
        boolean pottyTrackerNewUiEnabled2 = true;
        int i = 1;
        if (this.isUserPremium) {
        }
        if (this.isProgramEnrolled) {
        }
        if (!(this.pottyTrackerNewUiEnabled)) {
        }
        return (this.programId.hashCode() * 31) + Integer.hashCode(this.unreadZendeskMessages) * 31 + this.exercise.hashCode() * 31 + this.cardsOrder.hashCode() * 31 + this.programProgress.hashCode() * 31 + this.articlesWithProgress.hashCode() * 31 + this.reminders.hashCode() * 31 + this.programData.hashCode() * 31 + isUserPremium2 * 31 + isProgramEnrolled2 * 31 + this.certificate.hashCode() * 31 + getProgramCompletion().hashCode() * 31 + pottyTrackerNewUiEnabled2 * 31 + this.pottyCheckmarks.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "SpecialProgramOverviewItem(programId=";
        String str3 = ", unreadZendeskMessages=";
        String str4 = ", exercise=";
        String str5 = ", cardsOrder=";
        String str6 = ", programProgress=";
        String str7 = ", articlesWithProgress=";
        String str8 = ", reminders=";
        String str9 = ", programData=";
        String str10 = ", isUserPremium=";
        String str11 = ", isProgramEnrolled=";
        String str12 = ", certificate=";
        String str13 = ", programCompletion=";
        app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData programCompletion = getProgramCompletion();
        String str14 = ", pottyTrackerNewUiEnabled=";
        String str15 = ", pottyCheckmarks=";
        str = str2 + this.programId + str3 + this.unreadZendeskMessages + str4 + this.exercise + str5 + this.cardsOrder + str6 + this.programProgress + str7 + this.articlesWithProgress + str8 + this.reminders + str9 + this.programData + str10 + this.isUserPremium + str11 + this.isProgramEnrolled + str12 + this.certificate + str13 + programCompletion + str14 + this.pottyTrackerNewUiEnabled + str15 + this.pottyCheckmarks + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.programId);
        parcel.writeInt(this.unreadZendeskMessages);
        parcel.writeInt(this.exercise.size());
        Iterator it = this.exercise.iterator();
        while (it.hasNext()) {
            (TrickItemWithVariations)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.cardsOrder.size());
        Iterator it2 = this.cardsOrder.iterator();
        while (it2.hasNext()) {
            parcel.writeString((SpecialProgramOverviewItem_PottyOverviewCardEnum)it2.next().name());
        }
        this.programProgress.writeToParcel(parcel, flags);
        parcel.writeInt(this.articlesWithProgress.size());
        Iterator it3 = this.articlesWithProgress.iterator();
        while (it3.hasNext()) {
            (ArticleWithStatus)it3.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.reminders.size());
        Iterator it4 = this.reminders.iterator();
        while (it4.hasNext()) {
            (PottyRemindersItem)it4.next().writeToParcel(parcel, flags);
        }
        this.programData.writeToParcel(parcel, flags);
        parcel.writeInt(this.isUserPremium);
        parcel.writeInt(this.isProgramEnrolled);
        this.certificate.writeToParcel(parcel, flags);
        this.programCompletion.writeToParcel(parcel, flags);
        parcel.writeInt(this.pottyTrackerNewUiEnabled);
        parcel.writeInt(this.pottyCheckmarks.size());
        Iterator it5 = this.pottyCheckmarks.iterator();
        while (it5.hasNext()) {
            parcel.writeInt((Boolean)it5.next().booleanValue());
        }
    }
}
