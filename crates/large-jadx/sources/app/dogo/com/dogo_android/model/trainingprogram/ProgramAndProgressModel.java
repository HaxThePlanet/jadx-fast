package app.dogo.com.dogo_android.model.trainingprogram;

import app.dogo.externalmodel.model.responses.ProgramProgress;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* compiled from: ProgramAndProgressModel.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u0016J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramAndProgressModel;", "", "dogId", "", "programModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progressModel", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;Lapp/dogo/externalmodel/model/responses/ProgramProgress;)V", "getDogId", "()Ljava/lang/String;", "id", "getId", "getProgramModel", "()Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "getProgressModel", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "isEmpty", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProgramAndProgressModel {

    private final String dogId;
    private final ProgramModel programModel;
    private final ProgramProgress progressModel;
    public ProgramAndProgressModel(String str, ProgramModel programModel, ProgramProgress programProgress) {
        n.f(str, "dogId");
        n.f(programModel, "programModel");
        super();
        this.dogId = str;
        this.programModel = programModel;
        this.progressModel = programProgress;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final String getId() {
        return this.programModel.getId();
    }

    public final ProgramModel getProgramModel() {
        return this.programModel;
    }

    public final ProgramProgress getProgressModel() {
        return this.progressModel;
    }

    public final boolean isEmpty() {
        return l.z(this.programModel.getId());
    }

    public static /* synthetic */ ProgramAndProgressModel copy$default(ProgramAndProgressModel programAndProgressModel, String str, ProgramModel programModel, ProgramProgress programProgress, int i, Object object) {
        String dogId2;
        app.dogo.com.dogo_android.model.trainingprogram.ProgramModel programModel2;
        ProgramProgress progressModel2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return programAndProgressModel.copy(dogId2, programModel2, progressModel2);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final ProgramModel component2() {
        return this.programModel;
    }

    /* operator */ public final ProgramProgress component3() {
        return this.progressModel;
    }

    public final ProgramAndProgressModel copy(String dogId, ProgramModel programModel, ProgramProgress progressModel) {
        n.f(dogId, "dogId");
        n.f(programModel, "programModel");
        return new ProgramAndProgressModel(dogId, programModel, progressModel);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z5 = false;
        if (!(other instanceof ProgramAndProgressModel)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.programModel, other.programModel)) {
            return false;
        }
        return !n.b(this.progressModel, other.progressModel) ? z5 : z;
    }

    public int hashCode() {
        int i = 0;
        if (this.progressModel == null) {
            i = 0;
        } else {
            i = this.progressModel.hashCode();
        }
        return (this.dogId.hashCode() * 31) + this.programModel.hashCode() * 31 + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ProgramAndProgressModel(dogId=";
        String str3 = ", programModel=";
        String str4 = ", progressModel=";
        str = str2 + this.dogId + str3 + this.programModel + str4 + this.progressModel + 41;
        return str;
    }
}
