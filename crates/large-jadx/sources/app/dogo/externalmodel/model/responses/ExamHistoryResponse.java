package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: ExamHistoryResponse.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0018", d2 = {"Lapp/dogo/externalmodel/model/responses/ExamHistoryResponse;", "Landroid/os/Parcelable;", "examHistory", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "(Ljava/util/List;)V", "getExamHistory", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ExamHistoryResponse implements Parcelable {

    public static final Parcelable.Creator<ExamHistoryResponse> CREATOR = new ExamHistoryResponse$Creator<>();
    private final List<ProgramProgress.ExamSubmission> examHistory;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExamHistoryResponse> {
        @Override // android.os.Parcelable$Creator
        public final ExamHistoryResponse createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(ProgramProgress_ExamSubmission.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new ExamHistoryResponse(arrayList);
        }

        @Override // android.os.Parcelable$Creator
        public final ExamHistoryResponse[] newArray(int i) {
            return new ExamHistoryResponse[i];
        }
    }
    public ExamHistoryResponse(List<ProgramProgress.ExamSubmission> list) {
        n.f(list, "examHistory");
        super();
        this.examHistory = list;
    }

    public final List<ProgramProgress.ExamSubmission> getExamHistory() {
        return this.examHistory;
    }

    public /* synthetic */ ExamHistoryResponse(List list, int i, g gVar) {
        List list2;
        if (i & 1 != 0) {
            list2 = p.g();
        }
        this(list2);
    }


    public ExamHistoryResponse() {
        final List list = null;
        this(list, 1, list);
    }

    public static /* synthetic */ ExamHistoryResponse copy$default(ExamHistoryResponse examHistoryResponse, List list, int i, Object object) {
        List examHistory2;
        if (i & 1 != 0) {
        }
        return examHistoryResponse.copy(examHistory2);
    }

    /* operator */ public final List<ProgramProgress.ExamSubmission> component1() {
        return this.examHistory;
    }

    public final ExamHistoryResponse copy(List<ProgramProgress.ExamSubmission> examHistory) {
        n.f(examHistory, "examHistory");
        return new ExamHistoryResponse(examHistory);
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
        if (!(other instanceof ExamHistoryResponse)) {
            return false;
        }
        return !n.b(this.examHistory, other.examHistory) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.examHistory.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ExamHistoryResponse(examHistory=";
        str = str2 + this.examHistory + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.examHistory.size());
        Iterator it = this.examHistory.iterator();
        while (it.hasNext()) {
            (ProgramProgress_ExamSubmission)it.next().writeToParcel(parcel, flags);
        }
    }
}
