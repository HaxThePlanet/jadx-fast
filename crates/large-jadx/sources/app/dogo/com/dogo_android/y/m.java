package app.dogo.com.dogo_android.y;

import app.dogo.externalmodel.model.BitingProgressModel;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0003\u0007\u0008\tB\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\u000c¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "BitingProgramProgressWrapper", "ClassicProgramProgress", "PottyProgramProgressWrapper", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$ClassicProgramProgress;", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$PottyProgramProgressWrapper;", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$BitingProgramProgressWrapper;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class m {

    private final String a;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$BitingProgramProgressWrapper;", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "progress", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "(Lapp/dogo/externalmodel/model/BitingProgressModel;)V", "getProgress", "()Lapp/dogo/externalmodel/model/BitingProgressModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends app.dogo.com.dogo_android.y.m {

        private final BitingProgressModel b;
        public a(BitingProgressModel bitingProgressModel) {
            n.f(bitingProgressModel, "progress");
            super("id_nipping_program", 0);
            this.b = bitingProgressModel;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public final BitingProgressModel b() {
            return this.b;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof m.a) {
                return i2;
            }
            if (!n.b(this.b, object.b)) {
                return i2;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public int hashCode() {
            return this.b.hashCode();
        }

        @Override // app.dogo.com.dogo_android.y.m
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("BitingProgramProgressWrapper(progress=");
            stringBuilder.append(this.b);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$ClassicProgramProgress;", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "(Lapp/dogo/externalmodel/model/responses/ProgramProgress;)V", "getProgress", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends app.dogo.com.dogo_android.y.m {

        private final ProgramProgress b;
        public b(ProgramProgress programProgress) {
            n.f(programProgress, "progress");
            super(programProgress.getId(), 0);
            this.b = programProgress;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public final ProgramProgress b() {
            return this.b;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof m.b) {
                return i2;
            }
            if (!n.b(this.b, object.b)) {
                return i2;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public int hashCode() {
            return this.b.hashCode();
        }

        @Override // app.dogo.com.dogo_android.y.m
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ClassicProgramProgress(progress=");
            stringBuilder.append(this.b);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$PottyProgramProgressWrapper;", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "progress", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "(Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;)V", "getProgress", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends app.dogo.com.dogo_android.y.m {

        private final PottyProgramProgressModel.ProgramStatus b;
        public c(PottyProgramProgressModel.ProgramStatus pottyProgramProgressModel$ProgramStatus) {
            n.f(programStatus, "progress");
            super("id_potty_program", 0);
            this.b = programStatus;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public final PottyProgramProgressModel.ProgramStatus b() {
            return this.b;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof m.c) {
                return i2;
            }
            if (!n.b(this.b, object.b)) {
                return i2;
            }
            return i;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public int hashCode() {
            return this.b.hashCode();
        }

        @Override // app.dogo.com.dogo_android.y.m
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PottyProgramProgressWrapper(progress=");
            stringBuilder.append(this.b);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }
    }
    private m(String string) {
        super();
        this.a = string;
    }

    public m(String string, g g2) {
        super(string);
    }

    public final String a() {
        return this.a;
    }
}
