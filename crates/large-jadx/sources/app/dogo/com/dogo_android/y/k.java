package app.dogo.com.dogo_android.y;

import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.externalmodel.model.BitingProgressModel;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0003\u000b\u000c\rB\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n\u0082\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram;", "", "content", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "(Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;)V", "getContent", "()Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "id", "", "getId", "()Ljava/lang/String;", "BitingProgram", "ClassicProgram", "PottyProgram", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$ClassicProgram;", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class k {

    private final ProgramModel a;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram;", "content", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progress", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "(Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;Lapp/dogo/externalmodel/model/BitingProgressModel;)V", "getProgress", "()Lapp/dogo/externalmodel/model/BitingProgressModel;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends app.dogo.com.dogo_android.y.k {

        private final BitingProgressModel b;
        public a(ProgramModel programModel, BitingProgressModel bitingProgressModel2) {
            n.f(programModel, "content");
            super(programModel, 0);
            this.b = bitingProgressModel2;
        }

        @Override // app.dogo.com.dogo_android.y.k
        public final BitingProgressModel c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$ClassicProgram;", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram;", "content", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "(Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;Lapp/dogo/externalmodel/model/responses/ProgramProgress;)V", "getProgress", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends app.dogo.com.dogo_android.y.k {

        private final ProgramProgress b;
        public b(ProgramModel programModel, ProgramProgress programProgress2) {
            n.f(programModel, "content");
            super(programModel, 0);
            this.b = programProgress2;
        }

        @Override // app.dogo.com.dogo_android.y.k
        public final ProgramProgress c() {
            return this.b;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram;", "content", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progress", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "(Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;)V", "getProgress", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends app.dogo.com.dogo_android.y.k {

        private final PottyProgramProgressModel.ProgramStatus b;
        public c(ProgramModel programModel, PottyProgramProgressModel.ProgramStatus pottyProgramProgressModel$ProgramStatus2) {
            n.f(programModel, "content");
            super(programModel, 0);
            this.b = programStatus2;
        }

        @Override // app.dogo.com.dogo_android.y.k
        public final PottyProgramProgressModel.ProgramStatus c() {
            return this.b;
        }
    }
    private k(ProgramModel programModel) {
        super();
        this.a = programModel;
    }

    public k(ProgramModel programModel, g g2) {
        super(programModel);
    }

    public final ProgramModel a() {
        return this.a;
    }

    public final String b() {
        return this.a.getId();
    }
}
