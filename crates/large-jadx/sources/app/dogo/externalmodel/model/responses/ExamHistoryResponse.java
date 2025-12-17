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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bHÖ\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0018", d2 = {"Lapp/dogo/externalmodel/model/responses/ExamHistoryResponse;", "Landroid/os/Parcelable;", "examHistory", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "(Ljava/util/List;)V", "getExamHistory", "()Ljava/util/List;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ExamHistoryResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.ExamHistoryResponse> CREATOR;
    private final List<app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission> examHistory;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.ExamHistoryResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.ExamHistoryResponse createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(ProgramProgress.ExamSubmission.CREATOR.createFromParcel(parcel));
                i++;
            }
            ExamHistoryResponse obj5 = new ExamHistoryResponse(arrayList);
            return obj5;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.ExamHistoryResponse[] newArray(int i) {
            return new ExamHistoryResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ExamHistoryResponse.Creator creator = new ExamHistoryResponse.Creator();
        ExamHistoryResponse.CREATOR = creator;
    }

    public ExamHistoryResponse() {
        final int i = 0;
        super(i, 1, i);
    }

    public ExamHistoryResponse(List<app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission> list) {
        n.f(list, "examHistory");
        super();
        this.examHistory = list;
    }

    public ExamHistoryResponse(List list, int i2, g g3) {
        List obj1;
        if (i2 &= 1 != 0) {
            obj1 = p.g();
        }
        super(obj1);
    }

    public static app.dogo.externalmodel.model.responses.ExamHistoryResponse copy$default(app.dogo.externalmodel.model.responses.ExamHistoryResponse examHistoryResponse, List list2, int i3, Object object4) {
        List obj1;
        if (i3 &= 1 != 0) {
            obj1 = examHistoryResponse.examHistory;
        }
        return examHistoryResponse.copy(obj1);
    }

    public final List<app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission> component1() {
        return this.examHistory;
    }

    public final app.dogo.externalmodel.model.responses.ExamHistoryResponse copy(List<app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission> list) {
        n.f(list, "examHistory");
        ExamHistoryResponse examHistoryResponse = new ExamHistoryResponse(list);
        return examHistoryResponse;
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
        if (object instanceof ExamHistoryResponse == null) {
            return i2;
        }
        if (!n.b(this.examHistory, object.examHistory)) {
            return i2;
        }
        return i;
    }

    public final List<app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission> getExamHistory() {
        return this.examHistory;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.examHistory.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExamHistoryResponse(examHistory=");
        stringBuilder.append(this.examHistory);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List examHistory = this.examHistory;
        parcel.writeInt(examHistory.size());
        Iterator iterator = examHistory.iterator();
        for (ProgramProgress.ExamSubmission size : iterator) {
            size.writeToParcel(parcel, i2);
        }
    }
}
