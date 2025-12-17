package e.a.a.a.b.b;

import app.dogo.android.persistencedb.room.entity.OnboardingAnswerEntity;
import app.dogo.android.persistencedb.room.entity.OnboardingQuestionEntity;
import e.a.a.a.b.c.g;
import e.a.a.a.b.d.d;
import i.b.a0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0012\u0008g\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u00020\u00032\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\t\"\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001c\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u000e0\r2\u0006\u0010\u0010\u001a\u00020\u0011H'J\u001e\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H'J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0018H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001f\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\u001c\u001a\u00020\u0011H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00140\r2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H'J%\u0010\u001f\u001a\u00020\u00032\u0012\u0010 \u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u000f0\t\"\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0005H\u0082@ø\u0001\u0000J%\u0010&\u001a\u00020\u00032\u0012\u0010\u0008\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\n0\t\"\u00020\nH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ%\u0010'\u001a\u00020\u00032\u0012\u0010(\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00140\t\"\u00020\u0014H§@ø\u0001\u0000¢\u0006\u0002\u0010)\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006*", d2 = {"Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;", "", "cleanInsertFullOnboardingQuestion", "", "fullQuestionEntity", "Lapp/dogo/android/persistencedb/room/relations/OnboardingQuestionFullEntity;", "(Lapp/dogo/android/persistencedb/room/relations/OnboardingQuestionFullEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOnboardingQuestionWithAnswer", "onboardingQuestionWithAnswer", "", "Lapp/dogo/android/persistencedb/room/junction/OnboardingQuestionWithAnswer;", "([Lapp/dogo/android/persistencedb/room/junction/OnboardingQuestionWithAnswer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllAnswerContents", "Lio/reactivex/Single;", "", "Lapp/dogo/android/persistencedb/room/entity/OnboardingAnswerEntity;", "locale", "", "getAllOnboardingQuestions", "getAllQuestionContents", "Lapp/dogo/android/persistencedb/room/entity/OnboardingQuestionEntity;", "getAnswerContent", "id", "getLatestAnswerTimestamp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestQuestionTimestamp", "getOnboardingQuestionWithAnswerJunctions", "locale_questionId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getQuestionContent", "insertAllAnswer", "answer", "([Lapp/dogo/android/persistencedb/room/entity/OnboardingAnswerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAnswer", "(Lapp/dogo/android/persistencedb/room/entity/OnboardingAnswerEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertOnboardingQuestionJunctions", "fullTrickEntity", "insertOnboardingQuestionWithAnswer", "insertQuestion", "question", "([Lapp/dogo/android/persistencedb/room/entity/OnboardingQuestionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "persistencedb_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface c0 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static final Object a(e.a.a.a.b.b.c0 c0, d d2, d d3) {
            return c0.a.c(c0, d2, d3);
        }

        public static Object b(e.a.a.a.b.b.c0 c0, d d2, d<? super w> d3) {
            boolean aVar;
            int label;
            int i2;
            OnboardingQuestionEntity length;
            int i;
            Object obj;
            Object obj8;
            Object obj9;
            Object obj10;
            aVar = d3;
            label = aVar.label;
            i2 = Integer.MIN_VALUE;
            if (d3 instanceof c0.a.a && label & i2 != 0) {
                aVar = d3;
                label = aVar.label;
                i2 = Integer.MIN_VALUE;
                if (label & i2 != 0) {
                    aVar.label = label -= i2;
                } else {
                    aVar = new c0.a.a(d3);
                }
            } else {
            }
            obj10 = aVar.result;
            Object obj2 = b.d();
            length = aVar.label;
            int i3 = 0;
            final int i4 = 3;
            final int i5 = 2;
            final int i6 = 1;
            if (length != 0) {
                if (length != i6) {
                    if (length != i5) {
                        if (length != i4) {
                        } else {
                            q.b(obj10);
                            return w.a;
                        }
                        obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj8;
                    }
                    obj8 = aVar.L$1;
                    obj9 = aVar.L$0;
                    q.b(obj10);
                } else {
                    obj9 = obj8;
                    obj8 = aVar.L$0;
                    q.b(obj10);
                    obj10 = obj9.a().toArray(new OnboardingAnswerEntity[i3]);
                    Objects.requireNonNull(obj10, "null cannot be cast to non-null type kotlin.Array<T>");
                    aVar.L$0 = obj8;
                    aVar.L$1 = obj9;
                    aVar.label = i5;
                    if (obj8.f((OnboardingAnswerEntity[])Arrays.copyOf((OnboardingAnswerEntity[])obj10, obj10.length), aVar) == obj2) {
                        return obj2;
                    }
                    obj9 = obj8;
                    obj8 = obj;
                }
            } else {
                q.b(obj10);
                obj10 = new OnboardingQuestionEntity[i6];
                obj10[i3] = d2.b();
                aVar.L$0 = c0;
                aVar.L$1 = d2;
                aVar.label = i6;
                if (c0.d(obj10, aVar) == obj2) {
                    return obj2;
                }
            }
            obj10 = 0;
            aVar.L$0 = obj10;
            aVar.L$1 = obj10;
            aVar.label = i4;
            if (c0.a.c(obj9, obj8, aVar) == obj2) {
                return obj2;
            }
        }

        private static Object c(e.a.a.a.b.b.c0 c0, d d2, d<? super w> d3) {
            boolean bVar;
            int label;
            int i2;
            int arrayList;
            int i;
            boolean next;
            int locale_answerId;
            String locale_questionId;
            g gVar;
            Object obj11;
            Object obj12;
            int obj13;
            bVar = d3;
            label = bVar.label;
            i2 = Integer.MIN_VALUE;
            if (d3 instanceof c0.a.b && label & i2 != 0) {
                bVar = d3;
                label = bVar.label;
                i2 = Integer.MIN_VALUE;
                if (label & i2 != 0) {
                    bVar.label = label -= i2;
                } else {
                    bVar = new c0.a.b(d3);
                }
            } else {
            }
            obj13 = bVar.result;
            Object obj = b.d();
            arrayList = bVar.label;
            String str = "null cannot be cast to non-null type kotlin.Array<T>";
            final int i3 = 0;
            final int i4 = 3;
            final int i5 = 2;
            final int i6 = 1;
            if (arrayList != null) {
                if (arrayList != i6) {
                    if (arrayList != i5) {
                        if (arrayList != i4) {
                        } else {
                            q.b(obj13);
                            return w.a;
                        }
                        obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj11;
                    }
                    obj11 = bVar.L$1;
                    obj12 = bVar.L$0;
                    q.b(obj13);
                } else {
                    obj11 = bVar.L$1;
                    obj12 = bVar.L$0;
                    q.b(obj13);
                    obj13 = p.E0((List)obj13, obj11).toArray(new g[i3]);
                    Objects.requireNonNull(obj13, str);
                    bVar.L$0 = obj12;
                    bVar.L$1 = obj11;
                    bVar.label = i5;
                    if (obj12.c((g[])Arrays.copyOf((g[])obj13, obj13.length), bVar) == obj) {
                        return obj;
                    }
                }
            } else {
                q.b(obj13);
                obj13 = d2.a();
                arrayList = new ArrayList(p.r(obj13, 10));
                obj13 = obj13.iterator();
                for (OnboardingAnswerEntity next2 : obj13) {
                    gVar = new g(d2.b().getLocale_questionId(), next2.getLocale_answerId());
                    arrayList.add(gVar);
                }
                bVar.L$0 = c0;
                bVar.L$1 = arrayList;
                bVar.label = i6;
                if (c0.g(d2.b().getLocale_questionId(), bVar) == obj) {
                    return obj;
                }
                obj12 = c0;
                obj11 = arrayList;
            }
            obj11 = obj11.toArray(new g[i3]);
            Objects.requireNonNull(obj11, str);
            obj13 = 0;
            bVar.L$0 = obj13;
            bVar.L$1 = obj13;
            bVar.label = i4;
            if (obj12.h((g[])Arrays.copyOf((g[])obj11, obj11.length), bVar) == obj) {
                return obj;
            }
        }
    }
    public abstract Object a(d<? super Long> d);

    public abstract Object b(d d, d<? super w> d2);

    public abstract Object c(g[] gArr, d<? super w> d2);

    public abstract Object d(OnboardingQuestionEntity[] onboardingQuestionEntityArr, d<? super w> d2);

    public abstract a0<List<d>> e(String string);

    public abstract Object f(OnboardingAnswerEntity[] onboardingAnswerEntityArr, d<? super w> d2);

    public abstract Object g(String string, d<? super List<g>> d2);

    public abstract Object h(g[] gArr, d<? super w> d2);
}
