package app.dogo.com.dogo_android.model.trainingprogram;

import app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: LessonAndProgressModel.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0008HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/model/trainingprogram/LessonAndProgressModel;", "", "lessonModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "progressModel", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "(Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;)V", "id", "", "getId", "()Ljava/lang/String;", "getLessonModel", "()Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "getProgressModel", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LessonAndProgressModel {

    private final ProgramModel.LessonModel lessonModel;
    private final ProgramProgress.LessonProgress progressModel;
    public LessonAndProgressModel(ProgramModel.LessonModel lessonModel, ProgramProgress.LessonProgress lessonProgress) {
        n.f(lessonModel, "lessonModel");
        super();
        this.lessonModel = lessonModel;
        this.progressModel = lessonProgress;
    }

    public final String getId() {
        return this.lessonModel.getId();
    }

    public final ProgramModel.LessonModel getLessonModel() {
        return this.lessonModel;
    }

    public final ProgramProgress.LessonProgress getProgressModel() {
        return this.progressModel;
    }

    public static /* synthetic */ LessonAndProgressModel copy$default(LessonAndProgressModel lessonAndProgressModel, ProgramModel.LessonModel lessonModel, ProgramProgress.LessonProgress lessonProgress, int i, Object object) {
        app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel lessonModel22;
        ProgramProgress.LessonProgress progressModel2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return lessonAndProgressModel.copy(lessonModel22, progressModel2);
    }

    /* operator */ public final ProgramModel.LessonModel component1() {
        return this.lessonModel;
    }

    /* operator */ public final ProgramProgress.LessonProgress component2() {
        return this.progressModel;
    }

    public final LessonAndProgressModel copy(ProgramModel.LessonModel lessonModel, ProgramProgress.LessonProgress progressModel) {
        n.f(lessonModel, "lessonModel");
        return new LessonAndProgressModel(lessonModel, progressModel);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof LessonAndProgressModel)) {
            return false;
        }
        if (!n.b(this.lessonModel, other.lessonModel)) {
            return false;
        }
        return !n.b(this.progressModel, other.progressModel) ? z4 : z;
    }

    public int hashCode() {
        int i = 0;
        if (this.progressModel == null) {
            i = 0;
        } else {
            i = this.progressModel.hashCode();
        }
        return (this.lessonModel.hashCode() * 31) + i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LessonAndProgressModel(lessonModel=";
        String str3 = ", progressModel=";
        str = str2 + this.lessonModel + str3 + this.progressModel + 41;
        return str;
    }
}
