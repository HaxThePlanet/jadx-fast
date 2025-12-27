package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.OnboardingAnswerEntity;
import app.dogo.android.persistencedb.room.entity.OnboardingQuestionEntity;
import e.a.a.a.b.c.g;
import i.b.a0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;

/* compiled from: OnboardingSurveyEntityDao.kt */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0012\u0008g\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u00020\u00032\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\t\"\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u001e\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0018H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001f\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u001c\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00140\r2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H'J%\u0010\u001f\u001a\u00020\u00032\u0012\u0010 \u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u000f0\t\"\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0005H\u0082@ø\u0001\u0000J%\u0010&\u001a\u00020\u00032\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\t\"\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ%\u0010'\u001a\u00020\u00032\u0012\u0010(\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\t\"\u00020\u0014H§@ø\u0001\u0000¢\u0006\u0002\u0010)\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006*", d2 = {"Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;", "", "cleanInsertFullOnboardingQuestion", "", "fullQuestionEntity", "Lapp/dogo/android/persistencedb/room/relations/OnboardingQuestionFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/OnboardingQuestionFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOnboardingQuestionWithAnswer", "onboardingQuestionWithAnswer", "", "Lapp/dogo/android/persistencedb/room/junction/OnboardingQuestionWithAnswer;", "([Lapp/dogo/android/persistencedb/room/junction/OnboardingQuestionWithAnswer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAnswerContents", "Lio/reactivex/Single;", "", "Lapp/dogo/android/persistencedb/room/entity/OnboardingAnswerEntity;", "locale", "", "getAllOnboardingQuestions", "getAllQuestionContents", "Lapp/dogo/android/persistencedb/room/entity/OnboardingQuestionEntity;", "getAnswerContent", "id", "getLatestAnswerTimestamp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestQuestionTimestamp", "getOnboardingQuestionWithAnswerJunctions", "locale_questionId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuestionContent", "insertAllAnswer", "answer", "([Lapp/dogo/android/persistencedb/room/entity/OnboardingAnswerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAnswer", "(Lapp/dogo/android/persistencedb/room/entity/OnboardingAnswerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOnboardingQuestionJunctions", "fullTrickEntity", "insertOnboardingQuestionWithAnswer", "insertQuestion", "question", "([Lapp/dogo/android/persistencedb/room/entity/OnboardingQuestionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c0, reason: from kotlin metadata */
public interface OnboardingSurveyEntityDao {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static final /* synthetic */ Object a(c0 c0Var, e.a.a.a.b.d.d dVar, kotlin.b0.d dVar2) {
            return app.dogo.android.persistencedb.room.dao.c0.a.c(c0Var, dVar, dVar2);
        }

        public static Object b(c0 c0Var, e.a.a.a.b.d.d dVar, kotlin.b0.d<? super w> dVar2) {
            Object dVar32;
            int label2;
            int i = -2147483648;
            int length;
            int i2;
            Object dVar22;
            Object c0Var2;
            e.a.a.a.b.b.c0 c0Var3;
            z = dVar2 instanceof app.dogo.android.persistencedb.room.dao.c0.a.a;
            if (dVar2 instanceof app.dogo.android.persistencedb.room.dao.c0.a.a) {
                dVar32 = dVar2;
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar32.label -= i;
                } else {
                    e.a.a.a.b.b.c0.a.a aVar = new app.dogo.android.persistencedb.room.dao.c0.a.a(dVar2);
                }
            }
            Object obj2 = b.d();
            int i3 = 0;
            final int i4 = 3;
            final int i5 = 2;
            final int i6 = 1;
            if (dVar32.label != 0) {
                if (dVar32.label != i6) {
                    if (dVar32.label != i5) {
                        if (dVar32.label != i4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar32.result);
                            return w.a;
                        }
                    }
                    q.b(dVar32.result);
                } else {
                    q.b(dVar32.result);
                    Object[] array = dVar22.component1().toArray(new OnboardingAnswerEntity[i3]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    length = array.length;
                    dVar32.L$0 = c0Var2;
                    dVar32.L$1 = dVar22;
                    dVar32.label = i5;
                    if (c0Var2.f((OnboardingAnswerEntity[])Arrays.copyOf(array, length), dVar32) == obj2) {
                        return obj2;
                    }
                }
            } else {
                q.b(dVar32.result);
                OnboardingQuestionEntity[] arr2 = new OnboardingQuestionEntity[i6];
                dVar32.L$0 = c0Var;
                dVar32.L$1 = dVar;
                dVar32.label = i6;
                if (c0Var.d(new OnboardingQuestionEntity[] { dVar.b() }, dVar32) == obj2) {
                    return obj2;
                }
            }
            Object result2 = null;
            dVar32.L$0 = result2;
            dVar32.L$1 = result2;
            dVar32.label = i4;
            if (app.dogo.android.persistencedb.room.dao.c0.a.c(c0Var3, dVar, dVar32) == obj2) {
                return obj2;
            }
        }

        private static Object c(c0 c0Var, e.a.a.a.b.d.d dVar, kotlin.b0.d<? super w> dVar2) {
            Object dVar32;
            int label2;
            int i = -2147483648;
            int length;
            int i2;
            boolean hasNext;
            String locale_questionId;
            g onboardingQuestionWithAnswer;
            ArrayList arrayList;
            Object c0Var2;
            Iterable iterable;
            z = dVar2 instanceof app.dogo.android.persistencedb.room.dao.c0.a.b;
            if (dVar2 instanceof app.dogo.android.persistencedb.room.dao.c0.a.b) {
                dVar32 = dVar2;
                i = Integer.MIN_VALUE;
                i2 = label2 & i;
                if (label2 & i != 0) {
                    dVar32.label -= i;
                } else {
                    e.a.a.a.b.b.c0.a.b bVar = new app.dogo.android.persistencedb.room.dao.c0.a.b(dVar2);
                }
            }
            Object obj2 = b.d();
            String str = "null cannot be cast to non-null type kotlin.Array<T>";
            final int i4 = 0;
            final int i5 = 3;
            final int i6 = 2;
            final int i7 = 1;
            if (dVar32.label != 0) {
                if (dVar32.label != i7) {
                    if (dVar32.label != i6) {
                        if (dVar32.label != i5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar32.result);
                            return w.a;
                        }
                    }
                    q.b(dVar32.result);
                } else {
                    q.b(dVar32.result);
                    Object[] array2 = p.E0((List)iterable, arrayList).toArray(new g[i4]);
                    Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
                    length = array2.length;
                    dVar32.L$0 = c0Var2;
                    dVar32.L$1 = arrayList;
                    dVar32.label = i6;
                    if (c0Var2.getQuestionContent((g[])Arrays.copyOf(array2, length), dVar32) == obj2) {
                        return obj2;
                    }
                }
            } else {
                q.b(dVar32.result);
                List component1 = dVar.component1();
                arrayList = new ArrayList(p.r(component1, 10));
                Iterator it = component1.iterator();
                while (it.hasNext()) {
                    arrayList.add(new OnboardingQuestionWithAnswer(dVar.b().getLocale_questionId(), (OnboardingAnswerEntity)it.next().getLocale_answerId()));
                }
                dVar32.L$0 = c0Var;
                dVar32.L$1 = arrayList;
                dVar32.label = i7;
                if (c0Var.g(dVar.b().getLocale_questionId(), dVar32) == obj2) {
                    return obj2;
                }
                c0Var2 = c0Var;
            }
            Object[] array = arrayList.toArray(new g[i4]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            Object questionContent = null;
            dVar32.L$0 = questionContent;
            dVar32.L$1 = questionContent;
            dVar32.label = i5;
            if (c0Var2.h((g[])Arrays.copyOf(array, array.length), dVar32) == obj2) {
                return obj2;
            }
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ Object cleanInsertFullOnboardingQuestion(kotlin.b0.d<? super Long> fullQuestionEntity);

    /* renamed from: b, reason: from kotlin metadata */
    Object getAnswerContent(e.a.a.a.b.d.d id, kotlin.b0.d<? super w> locale);

    /* renamed from: c, reason: from kotlin metadata */
    Object getQuestionContent(g[] id, kotlin.b0.d<? super w> locale);

    Object d(OnboardingQuestionEntity[] onboardingQuestionEntityArr, kotlin.b0.d<? super w> dVar);

    /* renamed from: e, reason: from kotlin metadata */
    /* suspend */ a0<List<e.a.a.a.b.d.d>> deleteOnboardingQuestionWithAnswer(String onboardingQuestionWithAnswer);

    Object f(OnboardingAnswerEntity[] onboardingAnswerEntityArr, kotlin.b0.d<? super w> dVar);

    Object g(String str, kotlin.b0.d<? super List<g>> dVar);

    Object h(g[] gVarArr, kotlin.b0.d<? super w> dVar);
}
