package androidx.activity.compose;

import androidx.activity.FullyDrawnReporter;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref.BooleanRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\r\u001a\u00020\u00022\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001H\u0002J\u0006\u0010\u000e\u001a\u00020\u0002R \u0010\u0008\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u0001\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Landroidx/activity/compose/ReportDrawnComposition;", "Lkotlin/Function0;", "", "fullyDrawnReporter", "Landroidx/activity/FullyDrawnReporter;", "predicate", "", "(Landroidx/activity/FullyDrawnReporter;Lkotlin/jvm/functions/Function0;)V", "checkReporter", "Lkotlin/Function1;", "snapshotStateObserver", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", "invoke", "observeReporter", "removeReporter", "activity-compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ReportDrawnComposition implements Function0<Unit> {

    private final Function1<Function0<Boolean>, Unit> checkReporter;
    private final FullyDrawnReporter fullyDrawnReporter;
    private final Function0<Boolean> predicate;
    private final SnapshotStateObserver snapshotStateObserver;
    public ReportDrawnComposition(FullyDrawnReporter fullyDrawnReporter, Function0<Boolean> predicate) {
        boolean fullyDrawnReported;
        super();
        this.fullyDrawnReporter = fullyDrawnReporter;
        this.predicate = predicate;
        SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver((Function1)ReportDrawnComposition.snapshotStateObserver.1.INSTANCE);
        final int i = 0;
        snapshotStateObserver.start();
        this.snapshotStateObserver = snapshotStateObserver;
        ReportDrawnComposition.checkReporter.1 anon = new ReportDrawnComposition.checkReporter.1(this);
        this.checkReporter = (Function1)anon;
        this.fullyDrawnReporter.addOnReportDrawnListener((Function0)this);
        if (!this.fullyDrawnReporter.isFullyDrawnReported()) {
            this.fullyDrawnReporter.addReporter();
            observeReporter(this.predicate);
        }
    }

    public static final void access$observeReporter(androidx.activity.compose.ReportDrawnComposition $this, Function0 predicate) {
        $this.observeReporter(predicate);
    }

    private final void observeReporter(Function0<Boolean> predicate) {
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        ReportDrawnComposition.observeReporter.1 anon = new ReportDrawnComposition.observeReporter.1(booleanRef, predicate);
        this.snapshotStateObserver.observeReads(predicate, this.checkReporter, (Function0)anon);
        if (booleanRef.element) {
            removeReporter();
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function0
    public void invoke() {
        this.snapshotStateObserver.clear();
        this.snapshotStateObserver.stop();
    }

    @Override // kotlin.jvm.functions.Function0
    public final void removeReporter() {
        boolean fullyDrawnReported;
        this.snapshotStateObserver.clear(this.predicate);
        if (!this.fullyDrawnReporter.isFullyDrawnReported()) {
            this.fullyDrawnReporter.removeReporter();
        }
        invoke();
    }
}
