package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.repository.domain.LessonCardItem;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardType;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Type;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.service.v2.b;
import i.b.a0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0008\u001a\u00020\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0008\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0008\u001a\u00020\u0007H\u0002J\u0010\u0010\u000c\u001a\u00020\n2\u0006\u0010\u0008\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u0008\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00122\u0006\u0010\u0008\u001a\u00020\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/LessonCardListGenerationInteractor;", "", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "(Lapp/dogo/com/dogo_android/service/Utilities;)V", "addLessonList", "Lio/reactivex/Single;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "lessonItem", "buildHeaderCard", "Lapp/dogo/com/dogo_android/repository/domain/LessonCardItem;", "buildQuestionCard", "buildTaskCard", "buildTrainingCard", "calculateTrainingTime", "", "trickCount", "generateLessonCardList", "", "isTrainingAvailable", "", "trainingSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "isTrainingFinished", "isTrainingInProgress", "isTrainingStarted", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e3 {

    private final v2 a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[ProgramLessonItem.ProgramLessonStatus.NOT_STARTED.ordinal()] = 1;
            iArr[ProgramLessonItem.ProgramLessonStatus.STARTED.ordinal()] = 2;
            iArr[ProgramLessonItem.ProgramLessonStatus.PASSED.ordinal()] = 3;
            iArr[ProgramLessonItem.ProgramLessonStatus.MASTERED.ordinal()] = 4;
            e3.a.a = iArr;
        }
    }
    public e3(v2 v2) {
        n.f(v2, "utilities");
        super();
        this.a = v2;
    }

    private final LessonCardItem b(ProgramLessonItem programLessonItem) {
        LessonCardItem.CardStatus iN_PROGRESS;
        int i;
        int i2 = e3.a.a[programLessonItem.getLessonStatus().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                    } else {
                        iN_PROGRESS = LessonCardItem.CardStatus.COMPLETED;
                    }
                    NoWhenBranchMatchedException obj12 = new NoWhenBranchMatchedException();
                    throw obj12;
                }
                iN_PROGRESS = LessonCardItem.CardStatus.COMPLETED;
            } else {
                iN_PROGRESS = LessonCardItem.CardStatus.IN_PROGRESS;
            }
        } else {
            iN_PROGRESS = LessonCardItem.CardStatus.NOT_STARTED;
        }
        super(iN_PROGRESS, programLessonItem.getProgramName(), 0, "", programLessonItem.getCurrentLessonPositionData().getLessonNumber(), programLessonItem.getCurrentLessonPositionData().getModuleNumber(), LessonCardItem.CardType.HEADER, 4, 0);
        return obj12;
    }

    private final LessonCardItem c(ProgramLessonItem programLessonItem) {
        LessonCardItem.CardStatus nOT_STARTED;
        nOT_STARTED = programLessonItem.getQuestion().getType() == ProgramQuestion.Type.NOT_ANSWERED ? LessonCardItem.CardStatus.NOT_STARTED : LessonCardItem.CardStatus.COMPLETED;
        super(nOT_STARTED, programLessonItem.getProgramName(), 0, programLessonItem.getQuestion().getQuestion(), programLessonItem.getCurrentLessonPositionData().getLessonNumber(), programLessonItem.getCurrentLessonPositionData().getModuleNumber(), LessonCardItem.CardType.QUESTION, 4, 0);
        return obj12;
    }

    private final LessonCardItem d(ProgramLessonItem programLessonItem) {
        Object iterator;
        int i2;
        LessonCardItem.CardStatus nOT_STARTED;
        List iterator2;
        boolean empty;
        int i;
        ProgramTasks.Type cOMPLETED;
        Object obj;
        Object obj15;
        iterator = programLessonItem.getTasks();
        i = 1;
        final int i3 = 0;
        if (iterator instanceof Collection != null && iterator.isEmpty()) {
            if (iterator.isEmpty()) {
                i2 = i;
            } else {
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    if ((ProgramTasks)iterator.next().getType() == ProgramTasks.Type.COMPLETED) {
                    } else {
                    }
                    empty = i3;
                    empty = i;
                }
            }
        } else {
        }
        if (i2 != 0) {
            nOT_STARTED = LessonCardItem.CardStatus.COMPLETED;
        } else {
            iterator2 = programLessonItem.getTasks();
            if (iterator2 instanceof Collection != null && iterator2.isEmpty()) {
                if (iterator2.isEmpty()) {
                    i = i3;
                } else {
                    iterator2 = iterator2.iterator();
                    while (iterator2.hasNext()) {
                        if ((ProgramTasks)iterator2.next().getType() == ProgramTasks.Type.COMPLETED) {
                        } else {
                        }
                        empty = i3;
                        if (!empty) {
                            break;
                        }
                        empty = i;
                    }
                }
            } else {
            }
            nOT_STARTED = i != 0 ? LessonCardItem.CardStatus.IN_PROGRESS : LessonCardItem.CardStatus.NOT_STARTED;
        }
        obj15 = p.a0(programLessonItem.getTasks(), i3);
        if ((ProgramTasks)obj15 == null) {
            obj = str;
        } else {
        }
        super(nOT_STARTED, programLessonItem.getProgramName(), 0, obj, programLessonItem.getCurrentLessonPositionData().getLessonNumber(), programLessonItem.getCurrentLessonPositionData().getModuleNumber(), LessonCardItem.CardType.TASK, 4, 0);
        return obj15;
    }

    private final LessonCardItem e(ProgramLessonItem programLessonItem) {
        String imageUrl;
        LessonCardItem.CardStatus iN_PROGRESS;
        int i;
        if (empty ^= 1 != 0) {
            imageUrl = (TrickItem)programLessonItem.getTrainingSession().getTrainingTricksList().get(0).getImageUrl();
        } else {
            imageUrl = "";
        }
        iN_PROGRESS = i(programLessonItem.getTrainingSession()) ? LessonCardItem.CardStatus.COMPLETED : z2 ? LessonCardItem.CardStatus.IN_PROGRESS : LessonCardItem.CardStatus.NOT_STARTED;
        ProgramLessonItem.LessonPositionData currentLessonPositionData2 = programLessonItem.getCurrentLessonPositionData();
        super(iN_PROGRESS, programLessonItem.getProgramName(), imageUrl, this.a.u(l *= threshold), programLessonItem.getCurrentLessonPositionData().getLessonNumber(), currentLessonPositionData2.getModuleNumber(), LessonCardItem.CardType.TRAINING);
        return obj12;
    }

    private final int f(int i) {
        int i2;
        int obj2;
        obj2 = i <= 2 ? 5 : i <= i2 ? 10 : 15;
        return obj2;
    }

    private final boolean h(TrainingSession trainingSession) {
        return obj1 ^= 1;
    }

    private final boolean i(TrainingSession trainingSession) {
        boolean empty;
        Object ratedByUser;
        int i;
        boolean newContent;
        Object obj5;
        obj5 = trainingSession.getTrainingTricksList();
        final int i2 = 1;
        if (obj5 instanceof Collection != null && obj5.isEmpty()) {
            if (obj5.isEmpty()) {
                i = i2;
            } else {
                obj5 = obj5.iterator();
                while (obj5.hasNext()) {
                    ratedByUser = obj5.next();
                    if ((TrickItem)ratedByUser.getNewContent()) {
                    } else {
                    }
                    empty = i2;
                    if (empty) {
                        break;
                    }
                    if (ratedByUser.isRatedByUser()) {
                    } else {
                    }
                    empty = i;
                }
            }
        } else {
        }
        return i;
    }

    private final boolean j(TrainingSession trainingSession) {
        TrainingSession obj2;
        if (k(trainingSession) && !i(trainingSession)) {
            obj2 = !i(trainingSession) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private final boolean k(TrainingSession trainingSession) {
        boolean empty;
        Object ratedByUser;
        int i;
        boolean newContent;
        Object obj5;
        obj5 = trainingSession.getTrainingTricksList();
        final int i2 = 0;
        if (obj5 instanceof Collection != null && obj5.isEmpty()) {
            if (obj5.isEmpty()) {
                i = i2;
            } else {
                obj5 = obj5.iterator();
                while (obj5.hasNext()) {
                    ratedByUser = obj5.next();
                    if ((TrickItem)ratedByUser.getNewContent() && ratedByUser.isRatedByUser()) {
                    } else {
                    }
                    empty = i2;
                    if (!empty) {
                        break;
                    }
                    if (ratedByUser.isRatedByUser()) {
                    } else {
                    }
                    empty = i;
                }
            }
        } else {
        }
        return i;
    }

    public final a0<ProgramLessonItem> a(ProgramLessonItem programLessonItem) {
        Object obj = programLessonItem;
        n.f(obj, "lessonItem");
        a0 just = a0.just(ProgramLessonItem.copy$default(obj, 0, 0, 0, 0, 0, 0, 0, 0, 0, g(programLessonItem), false, false, 3583, 0));
        n.e(just, "just(lessonItem.copy(cardList = generateLessonCardList(lessonItem)))");
        return just;
    }

    public final List<LessonCardItem> g(ProgramLessonItem programLessonItem) {
        n.f(programLessonItem, "lessonItem");
        final LessonCardItem lessonCardItem2 = c(programLessonItem);
        final LessonCardItem lessonCardItem3 = d(programLessonItem);
        final int i = 1;
        LessonCardItem[] arr = new LessonCardItem[i];
        arr[0] = b(programLessonItem);
        List list = p.m(arr);
        if (z ^= i != 0) {
            list.add(lessonCardItem2);
        }
        if (h(programLessonItem.getTrainingSession())) {
            list.add(e(programLessonItem));
        }
        if (obj8 ^= i != 0) {
            list.add(lessonCardItem3);
        }
        return list;
    }
}
