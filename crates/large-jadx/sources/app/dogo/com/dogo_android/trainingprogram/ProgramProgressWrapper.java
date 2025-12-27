package app.dogo.com.dogo_android.y;

import app.dogo.externalmodel.model.BitingProgressModel;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ProgramProgressWrapper.kt */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0003\u0007\u0008\tB\u000f\u0008\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0003\n\u000b\u000c¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "BitingProgramProgressWrapper", "ClassicProgramProgress", "PottyProgramProgressWrapper", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$ClassicProgramProgress;", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$PottyProgramProgressWrapper;", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$BitingProgramProgressWrapper;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public abstract /* sealed */ class ProgramProgressWrapper {

    private final String a;

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$BitingProgramProgressWrapper;", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "progress", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "(Lapp/dogo/externalmodel/model/BitingProgressModel;)V", "getProgress", "()Lapp/dogo/externalmodel/model/BitingProgressModel;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends m {

        /* renamed from: b, reason: from kotlin metadata */
        private final BitingProgressModel progress;
        public a(BitingProgressModel bitingProgressModel) {
            n.f(bitingProgressModel, "progress");
            super("id_nipping_program", null);
            this.progress = bitingProgressModel;
        }

        @Override // app.dogo.com.dogo_android.y.m
        /* renamed from: b, reason: from kotlin metadata */
        /* operator */ public final BitingProgressModel component1() {
            return this.progress;
        }

        @Override // app.dogo.com.dogo_android.y.m
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z3 = false;
            if (!(other instanceof ProgramProgressWrapper_BitingProgramProgressWrapper)) {
                return false;
            }
            return !n.b(this.progress, other.progress) ? z3 : z;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public int hashCode() {
            return this.progress.hashCode();
        }

        @Override // app.dogo.com.dogo_android.y.m
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "BitingProgramProgressWrapper(progress=";
            str = str2 + this.progress + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$ClassicProgramProgress;", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "(Lapp/dogo/externalmodel/model/responses/ProgramProgress;)V", "getProgress", "()Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends m {

        /* renamed from: b, reason: from kotlin metadata */
        private final ProgramProgress progress;
        public b(ProgramProgress programProgress) {
            n.f(programProgress, "progress");
            super(programProgress.getId(), null);
            this.progress = programProgress;
        }

        @Override // app.dogo.com.dogo_android.y.m
        /* renamed from: b, reason: from kotlin metadata */
        /* operator */ public final ProgramProgress component1() {
            return this.progress;
        }

        @Override // app.dogo.com.dogo_android.y.m
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z3 = false;
            if (!(other instanceof ProgramProgressWrapper_ClassicProgramProgress)) {
                return false;
            }
            return !n.b(this.progress, other.progress) ? z3 : z;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public int hashCode() {
            return this.progress.hashCode();
        }

        @Override // app.dogo.com.dogo_android.y.m
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "ClassicProgramProgress(progress=";
            str = str2 + this.progress + 41;
            return str;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper$PottyProgramProgressWrapper;", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "progress", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "(Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;)V", "getProgress", "()Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends m {

        /* renamed from: b, reason: from kotlin metadata */
        private final PottyProgramProgressModel.ProgramStatus progress;
        public c(PottyProgramProgressModel.ProgramStatus programStatus) {
            n.f(programStatus, "progress");
            super("id_potty_program", null);
            this.progress = programStatus;
        }

        @Override // app.dogo.com.dogo_android.y.m
        /* renamed from: b, reason: from kotlin metadata */
        /* operator */ public final PottyProgramProgressModel.ProgramStatus component1() {
            return this.progress;
        }

        @Override // app.dogo.com.dogo_android.y.m
        /* operator */ public boolean equals(Object other) {
            final boolean z = true;
            if (this == other) {
                return true;
            }
            final boolean z3 = false;
            if (!(other instanceof ProgramProgressWrapper_PottyProgramProgressWrapper)) {
                return false;
            }
            return !n.b(this.progress, other.progress) ? z3 : z;
        }

        @Override // app.dogo.com.dogo_android.y.m
        public int hashCode() {
            return this.progress.hashCode();
        }

        @Override // app.dogo.com.dogo_android.y.m
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "PottyProgramProgressWrapper(progress=";
            str = str2 + this.progress + 41;
            return str;
        }
    }
    private m(String str) {
        super();
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public /* synthetic */ m(String str, g gVar) {
        this(str);
    }
}
