package app.dogo.com.dogo_android.model.trainingprogram;

import app.dogo.externalmodel.model.responses.ProgramProgress;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u0016J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramAndProgressModel;", "", "dogId", "", "programModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progressModel", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;Lapp/dogo/externalmodel/model/responses/ProgramProgress;)V", "getDogId", "()Ljava/lang/String;", "id", "getId", "getProgramModel", "()Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "getProgressModel", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "isEmpty", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ProgramAndProgressModel {

    private final String dogId;
    private final app.dogo.com.dogo_android.model.trainingprogram.ProgramModel programModel;
    private final ProgramProgress progressModel;
    public ProgramAndProgressModel(String string, app.dogo.com.dogo_android.model.trainingprogram.ProgramModel programModel2, ProgramProgress programProgress3) {
        n.f(string, "dogId");
        n.f(programModel2, "programModel");
        super();
        this.dogId = string;
        this.programModel = programModel2;
        this.progressModel = programProgress3;
    }

    public static app.dogo.com.dogo_android.model.trainingprogram.ProgramAndProgressModel copy$default(app.dogo.com.dogo_android.model.trainingprogram.ProgramAndProgressModel programAndProgressModel, String string2, app.dogo.com.dogo_android.model.trainingprogram.ProgramModel programModel3, ProgramProgress programProgress4, int i5, Object object6) {
        String obj1;
        app.dogo.com.dogo_android.model.trainingprogram.ProgramModel obj2;
        ProgramProgress obj3;
        if (i5 & 1 != 0) {
            obj1 = programAndProgressModel.dogId;
        }
        if (i5 & 2 != 0) {
            obj2 = programAndProgressModel.programModel;
        }
        if (i5 &= 4 != 0) {
            obj3 = programAndProgressModel.progressModel;
        }
        return programAndProgressModel.copy(obj1, obj2, obj3);
    }

    public final String component1() {
        return this.dogId;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.ProgramModel component2() {
        return this.programModel;
    }

    public final ProgramProgress component3() {
        return this.progressModel;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.ProgramAndProgressModel copy(String string, app.dogo.com.dogo_android.model.trainingprogram.ProgramModel programModel2, ProgramProgress programProgress3) {
        n.f(string, "dogId");
        n.f(programModel2, "programModel");
        ProgramAndProgressModel programAndProgressModel = new ProgramAndProgressModel(string, programModel2, programProgress3);
        return programAndProgressModel;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ProgramAndProgressModel) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.programModel, object.programModel)) {
            return i2;
        }
        if (!n.b(this.progressModel, object.progressModel)) {
            return i2;
        }
        return i;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final String getId() {
        return this.programModel.getId();
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.ProgramModel getProgramModel() {
        return this.programModel;
    }

    public final ProgramProgress getProgressModel() {
        return this.progressModel;
    }

    public int hashCode() {
        int i;
        ProgramProgress progressModel = this.progressModel;
        if (progressModel == null) {
            i = 0;
        } else {
            i = progressModel.hashCode();
        }
        return i5 += i;
    }

    public final boolean isEmpty() {
        return l.z(this.programModel.getId());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ProgramAndProgressModel(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", programModel=");
        stringBuilder.append(this.programModel);
        stringBuilder.append(", progressModel=");
        stringBuilder.append(this.progressModel);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
