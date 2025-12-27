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

/* compiled from: ClassicProgramCombinedResponse.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/externalmodel/model/responses/ClassicProgramCombinedResponse;", "Landroid/os/Parcelable;", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "tricks", "", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "(Lapp/dogo/externalmodel/model/responses/ProgramProgress;Ljava/util/List;)V", "getProgress", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "getTricks", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ClassicProgramCombinedResponse implements Parcelable {

    public static final Parcelable.Creator<ClassicProgramCombinedResponse> CREATOR = new ClassicProgramCombinedResponse$Creator<>();
    private final ProgramProgress progress;
    private final List<TrickKnowledgeEvent> tricks;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ClassicProgramCombinedResponse> {
        @Override // android.os.Parcelable$Creator
        public final ClassicProgramCombinedResponse createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            final int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(TrickKnowledgeEvent.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new ClassicProgramCombinedResponse((ProgramProgress)ProgramProgress.CREATOR.createFromParcel(parcel), arrayList);
        }

        @Override // android.os.Parcelable$Creator
        public final ClassicProgramCombinedResponse[] newArray(int i) {
            return new ClassicProgramCombinedResponse[i];
        }
    }
    public ClassicProgramCombinedResponse(ProgramProgress programProgress, List<TrickKnowledgeEvent> list) {
        n.f(programProgress, "progress");
        n.f(list, "tricks");
        super();
        this.progress = programProgress;
        this.tricks = list;
    }

    public final ProgramProgress getProgress() {
        return this.progress;
    }

    public final List<TrickKnowledgeEvent> getTricks() {
        return this.tricks;
    }


    public static /* synthetic */ ClassicProgramCombinedResponse copy$default(ClassicProgramCombinedResponse cls, ProgramProgress programProgress, List list, int i, Object object) {
        app.dogo.externalmodel.model.responses.ProgramProgress progress2;
        List tricks2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return cls.copy(progress2, tricks2);
    }

    /* operator */ public final ProgramProgress component1() {
        return this.progress;
    }

    /* operator */ public final List<TrickKnowledgeEvent> component2() {
        return this.tricks;
    }

    public final ClassicProgramCombinedResponse copy(ProgramProgress progress, List<TrickKnowledgeEvent> tricks) {
        n.f(progress, "progress");
        n.f(tricks, "tricks");
        return new ClassicProgramCombinedResponse(progress, tricks);
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
        final boolean z4 = false;
        if (!(other instanceof ClassicProgramCombinedResponse)) {
            return false;
        }
        if (!n.b(this.progress, other.progress)) {
            return false;
        }
        return !n.b(this.tricks, other.tricks) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.progress.hashCode() * 31) + this.tricks.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ClassicProgramCombinedResponse(progress=";
        String str3 = ", tricks=";
        str = str2 + this.progress + str3 + this.tricks + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.progress.writeToParcel(parcel, flags);
        parcel.writeInt(this.tricks.size());
        Iterator it = this.tricks.iterator();
        while (it.hasNext()) {
            (TrickKnowledgeEvent)it.next().writeToParcel(parcel, flags);
        }
    }
}
