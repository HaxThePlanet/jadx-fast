package app.dogo.com.dogo_android.n.m.t;

import app.dogo.externalmodel.model.BitingProgressModel;
import app.dogo.externalmodel.model.TrickKnowledgeEvent;
import app.dogo.externalmodel.model.responses.BitingProgramCombinedResponse;
import app.dogo.externalmodel.model.responses.ClassicProgramCombinedResponse;
import app.dogo.externalmodel.model.responses.GetTrickKnowledgeResponse;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrickRatingResults.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00086\u0018\u00002\u00020\u0001:\u0003\u0006\u0007\u0008B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H&\u0082\u0001\u0003\t\n\u000b¨\u0006\u000c", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults;", "", "()V", "getTrickKnowledge", "", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "BitingProgram", "ClassicProgram", "Library", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults$Library;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults$BitingProgram;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults$ClassicProgram;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public abstract /* sealed */ class TrickRatingResults {

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults$BitingProgram;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults;", "results", "Lapp/dogo/externalmodel/model/responses/BitingProgramCombinedResponse;", "(Lapp/dogo/externalmodel/model/responses/BitingProgramCombinedResponse;)V", "getProgress", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "getTrickKnowledge", "", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends i {

        /* renamed from: a, reason: from kotlin metadata */
        private final BitingProgramCombinedResponse results;
        public a(BitingProgramCombinedResponse bitingProgramCombinedResponse) {
            n.f(bitingProgramCombinedResponse, "results");
            super(null);
            this.results = bitingProgramCombinedResponse;
        }

        @Override // app.dogo.com.dogo_android.n.m.t.i
        /* renamed from: a, reason: from kotlin metadata */
        public List<TrickKnowledgeEvent> getProgress() {
            return this.results.getTricks();
        }

        @Override // app.dogo.com.dogo_android.n.m.t.i
        public final BitingProgressModel b() {
            return this.results.getProgress();
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults$ClassicProgram;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults;", "results", "Lapp/dogo/externalmodel/model/responses/ClassicProgramCombinedResponse;", "(Lapp/dogo/externalmodel/model/responses/ClassicProgramCombinedResponse;)V", "getProgress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "getTrickKnowledge", "", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends i {

        /* renamed from: a, reason: from kotlin metadata */
        private final ClassicProgramCombinedResponse results;
        public b(ClassicProgramCombinedResponse cls) {
            n.f(cls, "results");
            super(null);
            this.results = cls;
        }

        @Override // app.dogo.com.dogo_android.n.m.t.i
        /* renamed from: a, reason: from kotlin metadata */
        public List<TrickKnowledgeEvent> getProgress() {
            return this.results.getTricks();
        }

        @Override // app.dogo.com.dogo_android.n.m.t.i
        public final ProgramProgress b() {
            return this.results.getProgress();
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults$Library;", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults;", "results", "Lapp/dogo/externalmodel/model/responses/GetTrickKnowledgeResponse;", "(Lapp/dogo/externalmodel/model/responses/GetTrickKnowledgeResponse;)V", "getTrickKnowledge", "", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends i {

        /* renamed from: a, reason: from kotlin metadata */
        private final GetTrickKnowledgeResponse results;
        public c(GetTrickKnowledgeResponse getTrickKnowledgeResponse) {
            n.f(getTrickKnowledgeResponse, "results");
            super(null);
            this.results = getTrickKnowledgeResponse;
        }

        @Override // app.dogo.com.dogo_android.n.m.t.i
        /* renamed from: a, reason: from kotlin metadata */
        public List<TrickKnowledgeEvent> getTrickKnowledge() {
            return this.results.getTricks();
        }
    }
    private i() {
        super();
    }

    public /* synthetic */ i(g gVar) {
        this();
    }

    /* renamed from: a, reason: from kotlin metadata */
    public abstract List<TrickKnowledgeEvent> getTrickKnowledge();
}
