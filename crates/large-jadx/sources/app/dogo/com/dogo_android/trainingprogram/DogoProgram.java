package app.dogo.com.dogo_android.y;

import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.externalmodel.model.BitingProgressModel;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogoProgram.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0003\u000b\u000c\rB\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n\u0082\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram;", "", "content", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "(Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;)V", "getContent", "()Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "id", "", "getId", "()Ljava/lang/String;", "BitingProgram", "ClassicProgram", "PottyProgram", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$ClassicProgram;", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k, reason: from kotlin metadata */
public abstract /* sealed */ class DogoProgram {

    /* renamed from: a, reason: from kotlin metadata */
    private final ProgramModel content;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram;", "content", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progress", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "(Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;Lapp/dogo/externalmodel/model/BitingProgressModel;)V", "getProgress", "()Lapp/dogo/externalmodel/model/BitingProgressModel;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends k {

        /* renamed from: b, reason: from kotlin metadata */
        private final BitingProgressModel progress;
        public a(ProgramModel programModel, BitingProgressModel bitingProgressModel) {
            n.f(programModel, "content");
            super(programModel, null);
            this.progress = bitingProgressModel;
        }

        @Override // app.dogo.com.dogo_android.y.k
        public final BitingProgressModel c() {
            return this.progress;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$ClassicProgram;", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram;", "content", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "(Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;Lapp/dogo/externalmodel/model/responses/ProgramProgress;)V", "getProgress", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends k {

        /* renamed from: b, reason: from kotlin metadata */
        private final ProgramProgress progress;
        public b(ProgramModel programModel, ProgramProgress programProgress) {
            n.f(programModel, "content");
            super(programModel, null);
            this.progress = programProgress;
        }

        @Override // app.dogo.com.dogo_android.y.k
        public final ProgramProgress c() {
            return this.progress;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram;", "content", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progress", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "(Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;)V", "getProgress", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends k {

        /* renamed from: b, reason: from kotlin metadata */
        private final PottyProgramProgressModel.ProgramStatus progress;
        public c(ProgramModel programModel, PottyProgramProgressModel.ProgramStatus programStatus) {
            n.f(programModel, "content");
            super(programModel, null);
            this.progress = programStatus;
        }

        @Override // app.dogo.com.dogo_android.y.k
        public final PottyProgramProgressModel.ProgramStatus c() {
            return this.progress;
        }
    }
    private k(ProgramModel programModel) {
        super();
        this.content = programModel;
    }

    public final ProgramModel a() {
        return this.content;
    }

    public final String b() {
        return this.content.getId();
    }

    public /* synthetic */ k(ProgramModel programModel, g gVar) {
        this(programModel);
    }
}
