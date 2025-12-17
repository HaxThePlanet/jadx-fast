package app.dogo.com.dogo_android.model.trainingprogram;

import app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0008HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/LessonAndProgressModel;", "", "lessonModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "progressModel", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "(Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;)V", "id", "", "getId", "()Ljava/lang/String;", "getLessonModel", "()Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "getProgressModel", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LessonAndProgressModel {

    private final app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel lessonModel;
    private final ProgramProgress.LessonProgress progressModel;
    public LessonAndProgressModel(app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel programModel$LessonModel, ProgramProgress.LessonProgress programProgress$LessonProgress2) {
        n.f(lessonModel, "lessonModel");
        super();
        this.lessonModel = lessonModel;
        this.progressModel = lessonProgress2;
    }

    public static app.dogo.com.dogo_android.model.trainingprogram.LessonAndProgressModel copy$default(app.dogo.com.dogo_android.model.trainingprogram.LessonAndProgressModel lessonAndProgressModel, app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel programModel$LessonModel2, ProgramProgress.LessonProgress programProgress$LessonProgress3, int i4, Object object5) {
        app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel obj1;
        ProgramProgress.LessonProgress obj2;
        if (i4 & 1 != 0) {
            obj1 = lessonAndProgressModel.lessonModel;
        }
        if (i4 &= 2 != 0) {
            obj2 = lessonAndProgressModel.progressModel;
        }
        return lessonAndProgressModel.copy(obj1, obj2);
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel component1() {
        return this.lessonModel;
    }

    public final ProgramProgress.LessonProgress component2() {
        return this.progressModel;
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.LessonAndProgressModel copy(app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel programModel$LessonModel, ProgramProgress.LessonProgress programProgress$LessonProgress2) {
        n.f(lessonModel, "lessonModel");
        LessonAndProgressModel lessonAndProgressModel = new LessonAndProgressModel(lessonModel, lessonProgress2);
        return lessonAndProgressModel;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof LessonAndProgressModel) {
            return i2;
        }
        if (!n.b(this.lessonModel, object.lessonModel)) {
            return i2;
        }
        if (!n.b(this.progressModel, object.progressModel)) {
            return i2;
        }
        return i;
    }

    public final String getId() {
        return this.lessonModel.getId();
    }

    public final app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel getLessonModel() {
        return this.lessonModel;
    }

    public final ProgramProgress.LessonProgress getProgressModel() {
        return this.progressModel;
    }

    public int hashCode() {
        int i;
        ProgramProgress.LessonProgress progressModel = this.progressModel;
        if (progressModel == null) {
            i = 0;
        } else {
            i = progressModel.hashCode();
        }
        return i3 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LessonAndProgressModel(lessonModel=");
        stringBuilder.append(this.lessonModel);
        stringBuilder.append(", progressModel=");
        stringBuilder.append(this.progressModel);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
