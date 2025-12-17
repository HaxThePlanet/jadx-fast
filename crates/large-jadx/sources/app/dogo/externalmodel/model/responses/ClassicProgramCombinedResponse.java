package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import app.dogo.externalmodel.model.TrickKnowledgeEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/externalmodel/model/responses/ClassicProgramCombinedResponse;", "Landroid/os/Parcelable;", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "tricks", "", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "(Lapp/dogo/externalmodel/model/responses/ProgramProgress;Ljava/util/List;)V", "getProgress", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "getTricks", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ClassicProgramCombinedResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.ClassicProgramCombinedResponse> CREATOR;
    private final app.dogo.externalmodel.model.responses.ProgramProgress progress;
    private final List<TrickKnowledgeEvent> tricks;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.ClassicProgramCombinedResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.ClassicProgramCombinedResponse createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            final int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(TrickKnowledgeEvent.CREATOR.createFromParcel(parcel));
                i++;
            }
            ClassicProgramCombinedResponse obj6 = new ClassicProgramCombinedResponse((ProgramProgress)ProgramProgress.CREATOR.createFromParcel(parcel), arrayList);
            return obj6;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.ClassicProgramCombinedResponse[] newArray(int i) {
            return new ClassicProgramCombinedResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        ClassicProgramCombinedResponse.Creator creator = new ClassicProgramCombinedResponse.Creator();
        ClassicProgramCombinedResponse.CREATOR = creator;
    }

    public ClassicProgramCombinedResponse(app.dogo.externalmodel.model.responses.ProgramProgress programProgress, List<TrickKnowledgeEvent> list2) {
        n.f(programProgress, "progress");
        n.f(list2, "tricks");
        super();
        this.progress = programProgress;
        this.tricks = list2;
    }

    public static app.dogo.externalmodel.model.responses.ClassicProgramCombinedResponse copy$default(app.dogo.externalmodel.model.responses.ClassicProgramCombinedResponse classicProgramCombinedResponse, app.dogo.externalmodel.model.responses.ProgramProgress programProgress2, List list3, int i4, Object object5) {
        app.dogo.externalmodel.model.responses.ProgramProgress obj1;
        List obj2;
        if (i4 & 1 != 0) {
            obj1 = classicProgramCombinedResponse.progress;
        }
        if (i4 &= 2 != 0) {
            obj2 = classicProgramCombinedResponse.tricks;
        }
        return classicProgramCombinedResponse.copy(obj1, obj2);
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.ProgramProgress component1() {
        return this.progress;
    }

    public final List<TrickKnowledgeEvent> component2() {
        return this.tricks;
    }

    public final app.dogo.externalmodel.model.responses.ClassicProgramCombinedResponse copy(app.dogo.externalmodel.model.responses.ProgramProgress programProgress, List<TrickKnowledgeEvent> list2) {
        n.f(programProgress, "progress");
        n.f(list2, "tricks");
        ClassicProgramCombinedResponse classicProgramCombinedResponse = new ClassicProgramCombinedResponse(programProgress, list2);
        return classicProgramCombinedResponse;
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
        if (object instanceof ClassicProgramCombinedResponse == null) {
            return i2;
        }
        if (!n.b(this.progress, object.progress)) {
            return i2;
        }
        if (!n.b(this.tricks, object.tricks)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.responses.ProgramProgress getProgress() {
        return this.progress;
    }

    public final List<TrickKnowledgeEvent> getTricks() {
        return this.tricks;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ClassicProgramCombinedResponse(progress=");
        stringBuilder.append(this.progress);
        stringBuilder.append(", tricks=");
        stringBuilder.append(this.tricks);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        this.progress.writeToParcel(parcel, i2);
        List tricks = this.tricks;
        parcel.writeInt(tricks.size());
        Iterator iterator = tricks.iterator();
        for (TrickKnowledgeEvent size : iterator) {
            size.writeToParcel(parcel, i2);
        }
    }
}
