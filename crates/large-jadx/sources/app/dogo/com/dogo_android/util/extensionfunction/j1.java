package app.dogo.com.dogo_android.util.h0;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.os.e;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.n.k;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.android.persistencedb.room.entity.BreedEntity;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeEntryModel.Companion;
import app.dogo.com.dogo_android.model.ChallengeEntryModel.MiniEntryModel;
import app.dogo.com.dogo_android.model.ChallengeEntryVoter;
import app.dogo.com.dogo_android.model.ChallengeNotificationModel;
import app.dogo.com.dogo_android.model.ChallengeNotificationModel.EntryImageObject;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable;
import app.dogo.com.dogo_android.model.survey.SurveyAnswerModel;
import app.dogo.com.dogo_android.model.survey.SurveyQuestionModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickStep;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickVideoStep;
import app.dogo.com.dogo_android.repository.domain.BitingProgramProgress;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.repository.domain.ModuleCompletionSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramOverview;
import app.dogo.com.dogo_android.repository.domain.PublicDogProfile;
import app.dogo.com.dogo_android.repository.domain.SpecialOfferCoupon;
import app.dogo.com.dogo_android.repository.domain.SpecialOfferRemoteConfig;
import app.dogo.com.dogo_android.repository.domain.SurveyAnswer;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickStep;
import app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep;
import app.dogo.com.dogo_android.s.b.b1;
import app.dogo.com.dogo_android.s.b.b1.a;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.n2.a;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails.Companion;
import app.dogo.com.dogo_android.util.exceptions.CustomExceptions.DataNotFound;
import app.dogo.com.dogo_android.w.a3;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q2;
import app.dogo.externalmodel.model.TrainingReminderModel.Weekdays;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission;
import app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ProgramExamStatus;
import com.android.billingclient.api.SkuDetails;
import com.google.android.gms.tasks.m;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.gson.Gson;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import com.revenuecat.purchases.ListenerConversionsKt;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.PurchaserInfo;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import d.h.l.u.f;
import i.b.c0;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.k0.f;
import kotlin.u;
import kotlin.w;
import kotlin.y.h0;
import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.e.b.a;
import nl.dionsegijn.konfetti.e.b.c;

/* compiled from: Extensions.kt */
@Metadata(d1 = "\u0000Ì\u0004\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0004\n\u0002\u0010\u001c\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u0008\u0010\t\u001a\u00020\nH\u0002\u001a\u000e\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0001\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0010\u001aP\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u000c2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u001a*\u0010\u001f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0!0 \"\u0004\u0008\u0000\u0010\"*\u00020#2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0%\u001a\n\u0010&\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010'\u001a\u00020\u000f*\u00020(\u001a\u0012\u0010)\u001a\u00020\u0017*\u00020(2\u0006\u0010*\u001a\u00020\u0001\u001a,\u0010+\u001a\u0008\u0012\u0004\u0012\u0002H\"0 \"\u0004\u0008\u0000\u0010\"*\u00020,2\u0006\u0010-\u001a\u00020.2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0%\u001a$\u0010+\u001a\u0008\u0012\u0004\u0012\u0002H\"0 \"\u0004\u0008\u0000\u0010\"*\u00020,2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0%\u001a2\u0010+\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0!0 \"\u0004\u0008\u0000\u0010\"*\u00020#2\u0006\u0010-\u001a\u00020.2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0%\u001a*\u0010+\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\"0!0 \"\u0004\u0008\u0000\u0010\"*\u00020#2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\"0%\u001a\n\u0010/\u001a\u00020\u000f*\u00020(\u001a6\u00100\u001a\u00020\u000f*\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00012\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u000f08\u001a0\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H=0;\"\u0004\u0008\u0000\u0010<\"\u0004\u0008\u0001\u0010=*\u0010\u0012\u0004\u0012\u0002H<\u0012\u0006\u0012\u0004\u0018\u0001H=0;\u001a>\u0010>\u001a\u0008\u0012\u0004\u0012\u0002H?0!\"\u0004\u0008\u0000\u0010\"\"\u0004\u0008\u0001\u0010?*\u0008\u0012\u0004\u0012\u0002H\"0@2\u001a\u0010A\u001a\u0016\u0012\u0004\u0012\u0002H\"\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H?0@08\u001a\u001a\u0010B\u001a\u00020C*\u00020C2\u0006\u0010D\u001a\u00020\u00012\u0006\u0010E\u001a\u00020\u0001\u001a\n\u0010F\u001a\u00020\u0001*\u00020G\u001a\n\u0010F\u001a\u00020\u0001*\u00020H\u001a\n\u0010F\u001a\u00020\u0001*\u00020I\u001a\n\u0010J\u001a\u00020\u0001*\u00020K\u001a\n\u0010L\u001a\u00020\u0001*\u00020K\u001a\n\u0010M\u001a\u00020N*\u00020\u0006\u001a\n\u0010O\u001a\u00020P*\u00020Q\u001a\u0010\u0010R\u001a\u0008\u0012\u0004\u0012\u00020S0!*\u00020T\u001a$\u0010U\u001a\u00020V*\u00020W2\u0008\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020\u00012\u0006\u0010[\u001a\u00020\\\u001a\u000c\u0010]\u001a\u00020\u000c*\u0004\u0018\u00010^\u001a\u0011\u0010_\u001a\u0004\u0018\u00010\u0005*\u00020^¢\u0006\u0002\u0010`\u001a\n\u0010a\u001a\u00020\u000c*\u00020\u0012\u001a\n\u0010a\u001a\u00020\u000c*\u00020b\u001a\u001a\u0010c\u001a\u00020d*\u00020e2\u0006\u0010f\u001a\u00020\u00012\u0006\u0010[\u001a\u00020\\\u001a$\u0010c\u001a\u00020d*\u00020\u00132\u0008\u0010g\u001a\u0004\u0018\u00010h2\u0006\u0010f\u001a\u00020\u00012\u0006\u0010[\u001a\u00020\\\u001a\u0011\u0010i\u001a\u0004\u0018\u00010\u0005*\u00020j¢\u0006\u0002\u0010k\u001a\u0011\u0010l\u001a\u0004\u0018\u00010\u001a*\u00020j¢\u0006\u0002\u0010m\u001a\n\u0010n\u001a\u00020\u000c*\u00020o\u001a\u000c\u0010p\u001a\u00020\u000c*\u0004\u0018\u00010^\u001a\u001a\u0010q\u001a\u00020\u0001*\u00020\u00012\u0006\u0010r\u001a\u00020\u00012\u0006\u0010s\u001a\u00020t\u001a\n\u0010u\u001a\u00020\u0017*\u00020\u0001\u001a\n\u0010v\u001a\u00020\u0017*\u00020w\u001a\u0010\u0010x\u001a\u00020\u0017*\u0008\u0012\u0004\u0012\u00020S0!\u001a\n\u0010y\u001a\u00020\u0017*\u00020w\u001a\n\u0010z\u001a\u00020\u0017*\u00020{\u001a\n\u0010|\u001a\u00020\u0017*\u00020{\u001a\u0010\u0010}\u001a\u0008\u0012\u0004\u0012\u00020\u00170 *\u00020~\u001a\u001c\u0010\u007f\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010 *\u00030\u0081\u00012\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u0001\u001a\u0018\u0010\u0084\u0001\u001a\u00020\u000f*\u00030\u0085\u00012\n\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001\u001a\u000e\u0010\u0088\u0001\u001a\u0004\u0018\u00010H*\u00030\u0089\u0001\u001a'\u0010\u008a\u0001\u001a\u00030\u008b\u0001*\u00020b2\u0007\u0010\u008c\u0001\u001a\u0002092\u0007\u0010\u008d\u0001\u001a\u00020\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u0001\u001a\u000b\u0010\u008f\u0001\u001a\u00020\u000c*\u00020\u0006\u001a\u001f\u0010\u0090\u0001\u001a\u00030\u0091\u0001*\u00030\u0092\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u000c2\u0007\u0010\u0094\u0001\u001a\u00020\u000c\u001a\r\u0010\u0095\u0001\u001a\u00030\u0096\u0001*\u00030\u0097\u0001\u001a\u0012\u0010\u0098\u0001\u001a\t\u0012\u0005\u0012\u00030\u0099\u00010!*\u00020\u0001\u001a\r\u0010\u009a\u0001\u001a\u00030\u009b\u0001*\u00030\u0097\u0001\u001a\u001c\u0010\u009c\u0001\u001a\t\u0012\u0004\u0012\u00020\u00010\u009d\u0001*\u00030\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u0017\u001a[\u0010 \u0001\u001a\u00020\u000f\"\u0004\u0008\u0000\u0010\"*\t\u0012\u0004\u0012\u0002H\"0¡\u00012\u0008\u0010¢\u0001\u001a\u00030£\u00012'\u0010¤\u0001\u001a\"\u0012\u0018\u0012\u0016\u0018\u0001H\"¢\u0006\u000f\u0008¥\u0001\u0012\n\u0008¦\u0001\u0012\u0005\u0008\u0008(§\u0001\u0012\u0004\u0012\u00020\u0017082\u000e\u0010¨\u0001\u001a\t\u0012\u0004\u0012\u0002H\"0©\u0001\u001a\u000b\u0010ª\u0001\u001a\u00020\u0001*\u00020\u0001\u001a5\u0010«\u0001\u001a\u0008\u0012\u0004\u0012\u0002H\"0!\"\u0004\u0008\u0000\u0010\"*\u0008\u0012\u0004\u0012\u0002H\"0!2\u0007\u0010¬\u0001\u001a\u0002H\"2\u0007\u0010­\u0001\u001a\u0002H\"¢\u0006\u0003\u0010®\u0001\u001a\u000b\u0010¯\u0001\u001a\u00020\u0001*\u00020\u0001\u001a\u0013\u0010°\u0001\u001a\u0004\u0018\u00010\u000c*\u00020\u0001¢\u0006\u0003\u0010±\u0001\u001a(\u0010²\u0001\u001a\u00020\u000f*\u00030³\u00012\u0008\u0010´\u0001\u001a\u00030µ\u00012\u0007\u0010\u0093\u0001\u001a\u00020\u000c2\u0007\u0010¶\u0001\u001a\u00020\u000c\u001a\u0016\u0010·\u0001\u001a\u00030¸\u0001*\u00030¸\u00012\u0007\u0010¹\u0001\u001a\u00020\u000c\u001a\u0015\u0010º\u0001\u001a\u00020\u000f*\u00020\u00102\u0008\u0010»\u0001\u001a\u00030¼\u0001\u001a\u001f\u0010½\u0001\u001a\u00020\u000f*\u00030¾\u00012\u0008\u0010¿\u0001\u001a\u00030À\u00012\u0007\u00107\u001a\u00030Á\u0001\u001a%\u0010Â\u0001\u001a\t\u0012\u0004\u0012\u00020S0Ã\u0001*\u0008\u0012\u0004\u0012\u00020S0!2\u000b\u0008\u0002\u0010Ä\u0001\u001a\u0004\u0018\u00010S\u001a\u0011\u0010Å\u0001\u001a\u00020\u0017*\u00080Æ\u0001j\u0003`Ç\u0001\u001a\u000c\u0010È\u0001\u001a\u00020\u000f*\u00030É\u0001\u001a\u000c\u0010Ê\u0001\u001a\u00020\u000f*\u00030É\u0001\u001a\u0014\u0010Ë\u0001\u001a\u00030Ì\u0001*\n\u0012\u0005\u0012\u00030Í\u00010\u009d\u0001\u001a\r\u0010Î\u0001\u001a\u00030Ï\u0001*\u00030Ð\u0001\u001a\u001d\u0010Ñ\u0001\u001a\t\u0012\u0005\u0012\u00030Ò\u00010!*\u00020\u00132\t\u0010Ó\u0001\u001a\u0004\u0018\u00010h\u001a\u0015\u0010Ô\u0001\u001a\u00020\u0001*\u00020\u001a2\u0008\u0010Õ\u0001\u001a\u00030Ö\u0001\u001a\u0018\u0010×\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00010 *\t\u0012\u0004\u0012\u00020\u00010\u009d\u0001\u001a\u0013\u0010×\u0001\u001a\t\u0012\u0005\u0012\u00030Ø\u00010 *\u00030Ù\u0001\u001a9\u0010Ú\u0001\u001a\u00020S*\u00030Û\u00012\t\u0010Ü\u0001\u001a\u0004\u0018\u00010\u000c2\u000f\u0008\u0002\u0010Ý\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00010!2\t\u0008\u0002\u0010Þ\u0001\u001a\u00020\u0017¢\u0006\u0003\u0010ß\u0001\u001a\u0013\u0010à\u0001\u001a\u00030á\u0001*\t\u0012\u0004\u0012\u00020\u00170Ã\u0001\u001a\u0015\u0010â\u0001\u001a\u00020\u0001*\u00020\u00012\u0008\u0010ã\u0001\u001a\u00030ä\u0001\u001a\u0015\u0010â\u0001\u001a\u00020\u0001*\u00020\u00012\u0008\u0010Õ\u0001\u001a\u00030Ö\u0001\u001a\u000b\u0010å\u0001\u001a\u00020\u0017*\u00020{\u001a\u000b\u0010æ\u0001\u001a\u00020\u0017*\u00020{\u001a\u000b\u0010ç\u0001\u001a\u00020\u0017*\u00020{\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006è\u0001", d2 = {"ACTIVITY_NOT_ATTACHED", "", "NAVIGATION_AFTER_SAVE_INSTANCE", "NAVIGATION_PARENT", "priceAmount", "", "Lcom/android/billingclient/api/SkuDetails;", "getPriceAmount", "(Lcom/android/billingclient/api/SkuDetails;)D", "getLocaleWithJapanTempFix", "Ljava/util/Locale;", "getPercent", "", "sku", "bottomConfettiExplosion", "", "Lnl/dionsegijn/konfetti/KonfettiView;", "buildProgramDescriptionItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "status", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;", "specialImageForRecommended", "", "shouldOpenProgramOverview", "programStartTimeMs", "", "isSpecial", "programFit", "overview", "Lapp/dogo/com/dogo_android/repository/domain/ProgramOverview;", "cachedFirstContentFetch", "Lio/reactivex/Single;", "", "T", "Lcom/google/firebase/firestore/Query;", "objectClass", "Ljava/lang/Class;", "capitalizeSentences", "clearBackstack", "Landroidx/fragment/app/FragmentManager;", "containsTag", "tag", "createSingle", "Lcom/google/firebase/firestore/DocumentReference;", "source", "Lcom/google/firebase/firestore/Source;", "dismissAllDialogs", "fetchDogProfile", "Lapp/dogo/com/dogo_android/model/entry_list_item_models/EntryPhotoBaseObservable;", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "dogId", "callback", "Lkotlin/Function1;", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "filterNotNullValues", "", "K", "V", "flatMapNotNull", "R", "", "transform", "forPair", "Landroid/os/Bundle;", "key", "value", "getActiveTag", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "Lapp/dogo/com/dogo_android/model/ChallengeEntryVoter;", "getBirthdayDateString", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getBreedName", "getCurrencyFormatter", "Ljava/text/NumberFormat;", "getCustomDogoType", "Lapp/dogo/com/dogo_android/view/main_screen/FiamType;", "Lcom/google/firebase/inappmessaging/model/CardMessage;", "getLessonsNewTricks", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "getModuleCompletionSummary", "Lapp/dogo/com/dogo_android/repository/domain/ModuleCompletionSummary;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "moduleProgressModel", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "currentModuleId", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "getPercentDiscount", "Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;", "getPricePerDay", "(Lapp/dogo/com/dogo_android/subscription/DogoSkuDetails;)Ljava/lang/Double;", "getPrimaryOrderPriority", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "getProgramCompletionSummary", "Lapp/dogo/com/dogo_android/repository/domain/ProgramCompletionSummary;", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramAndProgressModel;", "currentLessonId", "programProgressModel", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "getTextAsDoubleOrNull", "Landroid/widget/EditText;", "(Landroid/widget/EditText;)Ljava/lang/Double;", "getTextAsLongOrNull", "(Landroid/widget/EditText;)Ljava/lang/Long;", "getTopPosition", "Lcom/yuyakaido/android/cardstackview/CardStackView;", "getTrialDays", "insertDogName", "dogName", "locale", "Lapp/dogo/com/dogo_android/service/LocaleService$SupportedLocales;", "isAnonymous", "isEmpty", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "isIntermediateTraining", "isNotEmpty", "isPremiumActive", "Lcom/revenuecat/purchases/PurchaserInfo;", "isPremiumNotActive", "isUserEligibleForFreeTrailByRegexCheck", "Lcom/revenuecat/purchases/Purchases;", "linkWithCredentialSingle", "Lcom/google/firebase/auth/AuthResult;", "Lcom/google/firebase/auth/FirebaseUser;", "lastCredential", "Lcom/google/firebase/auth/AuthCredential;", "logEvent", "Lcom/facebook/appevents/AppEventsLogger;", "fbEvent", "Lapp/dogo/com/dogo_android/tracking/FBEvent;", "parseEntryModel", "Lapp/dogo/com/dogo_android/model/ChallengeNotificationModel;", "parseExam", "Lapp/dogo/com/dogo_android/model/Exam;", "dogProfileModel", "userId", "userLocale", "parseFreeTrialPeriodToDays", "parseItem", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "Lapp/dogo/com/dogo_android/model/survey/SurveyQuestionModel;", "position", "total", "parseProgramExamStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "parseSpecialOffers", "Lapp/dogo/com/dogo_android/repository/domain/SpecialOfferCoupon;", "parseStatus", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ProgramExamStatus;", "refreshIdToken", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/auth/FirebaseAuth;", "forceUpdate", "removableObserve", "Landroidx/lifecycle/LiveData;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "removeObserverPredicate", "Lkotlin/ParameterName;", "name", "results", "observer", "Landroidx/lifecycle/Observer;", "removeSpecialSymbolsForCoupon", "replace", "newValue", "oldValue", "(Ljava/util/List;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;", "returnEmptyIfAnonymousNameFound", "safeParseToInt", "(Ljava/lang/String;)Ljava/lang/Integer;", "scrollToPositionMiddleInsideNestedView", "Landroidx/recyclerview/widget/RecyclerView;", "nestedScrollView", "Landroidx/core/widget/NestedScrollView;", "scrollDuration", "setMaxLines", "Lcom/google/android/material/snackbar/Snackbar;", "numberOfLines", "setUpOnbaordingConfetti", "width", "", "setupTouchListener", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "setupTrickListForIntermediateTraining", "", "selectedTrick", "shouldLogAsWarning", "Ljava/lang/Exception;", "Lkotlin/Exception;", "smoothNextItem", "Landroidx/viewpager2/widget/ViewPager2;", "smoothReverseItem", "toCompletable", "Lio/reactivex/Completable;", "Ljava/lang/Void;", "toDogBreed", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "Lapp/dogo/android/persistencedb/room/entity/BreedEntity;", "toFlatLessonData", "Lapp/dogo/com/dogo_android/model/trainingprogram/LessonAndProgressModel;", "progressModel", "toIntervalString", "resources", "Landroid/content/res/Resources;", "toSingle", "Lcom/google/firebase/database/DataSnapshot;", "Lcom/google/firebase/database/DatabaseReference;", "toTrickItem", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "knowledge", "lockedTricks", "isUserSubscribed", "(Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;Ljava/lang/Integer;Ljava/util/List;Z)Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "toWeekdays", "Lapp/dogo/externalmodel/model/TrainingReminderModel$Weekdays;", "translateIfAnonymousNameFound", "context", "Landroid/content/Context;", "userCancelledSubscription", "userHaveLifetimeSubscription", "userWillRenewSubscription", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class j1 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;
        public static final /* synthetic */ int[] d;
        static {
            int[] iArr = new int[ProgramProgress_ProgramExamStatus.values().length];
            final int i = 1;
            iArr[ProgramProgress_ProgramExamStatus.LOCKED.ordinal()] = i;
            final int i2 = 2;
            iArr[ProgramProgress_ProgramExamStatus.READY.ordinal()] = i2;
            final int i3 = 3;
            iArr[ProgramProgress_ProgramExamStatus.UPLOADING.ordinal()] = i3;
            final int i4 = 4;
            iArr[ProgramProgress_ProgramExamStatus.PENDING.ordinal()] = i4;
            final int i5 = 5;
            iArr[ProgramProgress_ProgramExamStatus.PASSED.ordinal()] = i5;
            final int i6 = 6;
            iArr[ProgramProgress_ProgramExamStatus.APPROVED.ordinal()] = i6;
            final int i7 = 7;
            iArr[ProgramProgress_ProgramExamStatus.REJECTED.ordinal()] = i7;
            app.dogo.com.dogo_android.util.extensionfunction.j1.a.a = iArr;
            int[] iArr2 = new int[ProgramExam_Status.values().length];
            iArr2[ProgramExam_Status.LOCKED.ordinal()] = i;
            iArr2[ProgramExam_Status.UNAVAILABLE_HEADER.ordinal()] = i2;
            iArr2[ProgramExam_Status.PREMIUM_LOCKED.ordinal()] = i3;
            iArr2[ProgramExam_Status.READY.ordinal()] = i4;
            iArr2[ProgramExam_Status.PENDING.ordinal()] = i5;
            iArr2[ProgramExam_Status.REJECTED.ordinal()] = i6;
            iArr2[ProgramExam_Status.APPROVED.ordinal()] = i7;
            iArr2[ProgramExam_Status.AVAILABLE_HEADER.ordinal()] = 8;
            iArr2[ProgramExam_Status.PROGRESS_HEADER.ordinal()] = 9;
            iArr2[ProgramExam_Status.CERTIFICATE_HEADER.ordinal()] = 10;
            app.dogo.com.dogo_android.util.extensionfunction.j1.a.b = iArr2;
            int[] iArr3 = new int[ProgramDescriptionItem_State.values().length];
            iArr3[ProgramDescriptionItem_State.HEADER.ordinal()] = i;
            iArr3[ProgramDescriptionItem_State.RECOMMENDED_BIG.ordinal()] = i2;
            iArr3[ProgramDescriptionItem_State.IN_PROGRESS.ordinal()] = i3;
            iArr3[ProgramDescriptionItem_State.RECOMMENDED.ordinal()] = i4;
            iArr3[ProgramDescriptionItem_State.NOT_STARTED.ordinal()] = i5;
            iArr3[ProgramDescriptionItem_State.COMPLETED.ordinal()] = i6;
            iArr3[ProgramDescriptionItem_State.COMING_SOON.ordinal()] = i7;
            app.dogo.com.dogo_android.util.extensionfunction.j1.a.c = iArr3;
            int[] iArr4 = new int[LocaleService_SupportedLocales.values().length];
            iArr4[LocaleService_SupportedLocales.ENGLISH.ordinal()] = i;
            iArr4[LocaleService_SupportedLocales.GERMAN.ordinal()] = i2;
            iArr4[LocaleService_SupportedLocales.SPANISH.ordinal()] = i3;
            iArr4[LocaleService_SupportedLocales.FRENCH.ordinal()] = i4;
            iArr4[LocaleService_SupportedLocales.PORTUGUESE.ordinal()] = i5;
            iArr4[LocaleService_SupportedLocales.DUTCH.ordinal()] = i6;
            iArr4[LocaleService_SupportedLocales.SWEDISH.ordinal()] = i7;
            app.dogo.com.dogo_android.util.extensionfunction.j1.a.d = iArr4;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class f<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(t2.getCreatedAt(), t.getCreatedAt());
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/util/extensionfunction/ExtensionsKt$setupTouchListener$tapGestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapUp", "", "e", "Landroid/view/MotionEvent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class h extends GestureDetector.SimpleOnGestureListener {

        final /* synthetic */ app.dogo.com.dogo_android.util.l0.b a;
        h(app.dogo.com.dogo_android.util.l0.b bVar) {
            this.a = bVar;
            super();
        }

        @Override // android.view.GestureDetector$SimpleOnGestureListener
        public boolean onSingleTapUp(MotionEvent e) {
            n.f(e, "e");
            this.a.f();
            return true;
        }
    }

    @Metadata(d1 = "\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0005¨\u0006\u0006", d2 = {"app/dogo/com/dogo_android/util/extensionfunction/ExtensionsKt$removableObserve$1", "Landroidx/lifecycle/Observer;", "onChanged", "", "t", "(Ljava/lang/Object;)V", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class g implements y<T> {

        final /* synthetic */ y<T> a;
        final /* synthetic */ kotlin.d0.c.l<T, Boolean> b;
        final /* synthetic */ LiveData<T> c;
        g(y<T> yVar, kotlin.d0.c.l<? super T, Boolean> lVar, LiveData<T> liveData) {
            this.a = yVar;
            this.b = lVar;
            this.c = liveData;
            super();
        }

        public void onChanged(T t) {
            this.a.onChanged(t);
            if ((Boolean)this.b.invoke(t).booleanValue()) {
                this.c.removeObserver(this);
            }
        }
    }

    @Metadata(d1 = "\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t", d2 = {"app/dogo/com/dogo_android/util/extensionfunction/ExtensionsKt$toSingle$1$1", "Lcom/google/firebase/database/ValueEventListener;", "onCancelled", "", "databaseError", "Lcom/google/firebase/database/DatabaseError;", "onDataChange", "dataSnapshot", "Lcom/google/firebase/database/DataSnapshot;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class i implements ValueEventListener {

        final /* synthetic */ c0<DataSnapshot> a;
        final /* synthetic */ DatabaseReference b;
        i(c0<DataSnapshot> c0Var, DatabaseReference databaseReference) {
            this.a = c0Var;
            this.b = databaseReference;
            super();
        }

        public void onCancelled(DatabaseError databaseError) {
            n.f(databaseError, "databaseError");
            this.b.removeEventListener(this);
            final com.google.firebase.database.DatabaseException exception = databaseError.toException();
            n.e(exception, "databaseError.toException()");
            a.d(exception);
            this.a.a(exception);
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            n.f(dataSnapshot, "dataSnapshot");
            this.a.onSuccess(dataSnapshot);
            this.b.removeEventListener(this);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, w> {

        final /* synthetic */ kotlin.d0.c.l<DogProfileModel, w> $callback;
        final /* synthetic */ String $dogId;
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            Object th3 = this;
            n.f(th, "it");
            a.d(th);
            DogProfileModel dogProfileModel = new DogProfileModel(null, null, null, null, null, null, 0, th3.$dogId, null, false, null, 1919, null);
            th3.$callback.invoke(dogProfileModel);
        }

        b(kotlin.d0.c.l<? super DogProfileModel, w> lVar, String str) {
            this.$callback = lVar;
            this.$dogId = str;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/PublicDogProfile;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.l<PublicDogProfile, w> {

        final /* synthetic */ kotlin.d0.c.l<DogProfileModel, w> $callback;
        @Override // kotlin.d0.d.p
        public final void a(PublicDogProfile publicDogProfile) {
            this.$callback.invoke(publicDogProfile.toDogModel());
        }

        c(kotlin.d0.c.l<? super DogProfileModel, w> lVar) {
            this.$callback = lVar;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.l<PurchasesError, w> {

        final /* synthetic */ c0<Boolean> $emitter;
        @Override // kotlin.d0.d.p
        public final void invoke(PurchasesError th) {
            n.f(th, "error");
            a.c(String.valueOf(th), new Object[0]);
            this.$emitter.onSuccess(Boolean.FALSE);
        }

        d(c0<Boolean> c0Var) {
            this.$emitter = c0Var;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "purchaserInfo", "Lcom/revenuecat/purchases/PurchaserInfo;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends kotlin.d0.d.p implements kotlin.d0.c.l<PurchaserInfo, w> {

        final /* synthetic */ c0<Boolean> $emitter;
        @Override // kotlin.d0.d.p
        public final void invoke(PurchaserInfo purchaserInfo) {
            boolean hasNext;
            boolean z = false;
            int i = 2;
            Object obj = null;
            java.lang.CharSequence charSequence;
            String str;
            Iterator it;
            n.f(purchaserInfo, "purchaserInfo");
            Set allPurchasedSkus = purchaserInfo.getAllPurchasedSkus();
            hasNext = allPurchasedSkus instanceof Collection;
            z = false;
            int r1 = 1;
            this.$emitter.onSuccess(Boolean.valueOf(1));
        }

        e(c0<Boolean> c0Var) {
            this.$emitter = c0Var;
            super(1);
        }
    }
    /* renamed from: A, reason: from kotlin metadata */
    private static final Locale getLocaleWithJapanTempFix() {
        Locale jAPAN2;
        if (n.b(e.d().c(0).getLanguage(), "ja")) {
            jAPAN2 = Locale.JAPAN;
        }
        n.e(jAPAN2, "default");
        return jAPAN2;
    }

    /* renamed from: A0, reason: from kotlin metadata */
    public static final Snackbar createSingle(Snackbar source, int objectClass) {
        n.f(source, "<this>");
        View viewById = source.F().findViewById(2131363246);
        Objects.requireNonNull(viewById, "null cannot be cast to non-null type android.widget.TextView");
        viewById.setMaxLines(objectClass);
        return source;
    }

    /* renamed from: B, reason: from kotlin metadata */
    public static final ModuleCompletionSummary fetchDogProfile(ProgramModel.ModuleModel userLocalCacheService, ProgramProgress.ModuleProgress disposable, String dogId, j1 callback) {
        int i = 1;
        int i2 = 0;
        Iterator it;
        boolean hasNext;
        boolean z;
        String str;
        String str2;
        n.f(userLocalCacheService, "<this>");
        n.f(dogId, "currentModuleId");
        n.f(callback, "programRepository");
        ArrayList arrayList = new ArrayList();
        Iterator it2 = userLocalCacheService.getLessons().iterator();
        i = 1;
        while (it2.hasNext()) {
            Object item = it2.next();
            i2 = 0;
            i = 0;
            int r4 = i2 == 0 ? 0 : i;
        }
        ModuleCompletionSummary userLocalCacheService2 = new ModuleCompletionSummary(userLocalCacheService.getId(), userLocalCacheService.getLessons().size(), disposable2, userLocalCacheService.getIndex() + 1, n.b(userLocalCacheService.getId(), dogId));
        return userLocalCacheService2;
    }

    /* renamed from: B0, reason: from kotlin metadata */
    public static final void createSingle(KonfettiView source, float objectClass) {
        n.f(source, "<this>");
        nl.dionsegijn.konfetti.b bVar = source.a();
        int i = 1;
        int[] iArr = new int[i];
        int i5 = 0;
        iArr[i5] = a.d(source.getContext(), 2131100336);
        bVar.a(iArr);
        bVar.h(0.0d, 359d);
        bVar.k(5f, 12f);
        bVar.i(true);
        bVar.l(4000L);
        nl.dionsegijn.konfetti.e.b[] arr = new b[i];
        arr[i5] = b.c.b;
        bVar.b(arr);
        nl.dionsegijn.konfetti.e.c[] arr2 = new c[i];
        int i3 = 12;
        arr2[i5] = new c(i3, 500f);
        bVar.c(arr2);
        float f2 = -50f;
        bVar.j(f2, Float.valueOf(objectClass + 50f), f2, Float.valueOf(f2));
        bVar.o(100, Long.MAX_VALUE);
    }

    /* renamed from: C, reason: from kotlin metadata */
    public static final int getPercent(String sku) {
        int parsed = 0;
        String value = null;
        n.f(sku, "sku");
        parsed = 0;
        f fVar = Regex.b(new Regex("\\d*pc"), sku, parsed, 2, null);
        if (fVar != null) {
            value = fVar.getValue();
        }
        if (value != null) {
            boolean z = false;
            int i = 4;
            Object obj = null;
            str = "pc";
            str2 = "";
            String str3 = l.G(value, str, str2, z, i, obj);
            if (str3 != null) {
                parsed = Integer.parseInt(str3);
            }
        }
        return parsed;
    }

    /* renamed from: C0, reason: from kotlin metadata */
    public static final void getModuleCompletionSummary(RecyclerView.e0 moduleProgressModel, View currentModuleId, app.dogo.com.dogo_android.util.l0.b programRepository) {
        n.f(moduleProgressModel, "<this>");
        n.f(currentModuleId, "view");
        n.f(programRepository, "callback");
        currentModuleId.setOnTouchListener(new app.dogo.com.dogo_android.util.extensionfunction.p0(new d(currentModuleId.getContext(), new ExtensionsKt_setupTouchListener_tapGestureDetector_1(programRepository))));
    }

    /* renamed from: D, reason: from kotlin metadata */
    public static final double cachedFirstContentFetch(SkuDetails objectClass) {
        n.f(objectClass, "<this>");
        return (double)objectClass.l() / 1000000d;
    }

    /* renamed from: D0, reason: from kotlin metadata */
    private static final boolean getProgramCompletionSummary(d.h.l.d programProgressModel, View currentLessonId, MotionEvent programRepository) {
        n.f(programProgressModel, "$tapGestureDetector");
        n.f(currentLessonId, "touchView");
        programProgressModel.a(programRepository);
        currentLessonId.performClick();
        return true;
    }

    /* renamed from: E, reason: from kotlin metadata */
    public static final Double containsTag(DogoSkuDetails tag) {
        String originalJson;
        n.f(tag, "<this>");
        if (tag.getOriginalJson() == null) {
            originalJson = "";
        }
        SkuDetails skuDetails = new SkuDetails(originalJson);
        if (tag.getSubscriptionPeriod() != PackageType.LIFETIME) {
            if (tag.getSubscriptionPeriod() != PackageType.UNKNOWN) {
                PackageType subscriptionPeriod = tag.getSubscriptionPeriod();
                return Double.valueOf((double)skuDetails.l() / 1000000d / (double)tag.getPeriodInDays());
            }
        }
        return null;
    }

    /* renamed from: E0, reason: from kotlin metadata */
    public static final List<TrickItem> forPair(List<TrickItem> key, TrickItem value) {
        int i;
        boolean notRatedByUser;
        String str = null;
        List list;
        n.f(key, "<this>");
        if (app.dogo.com.dogo_android.util.extensionfunction.j1.translateIfAnonymousNameFound(key)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = key.iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
            list = p.N0(arrayList);
        } else {
            list = p.N0(key);
        }
        if (value != null) {
            i2 = -list.indexOf(value);
            Collections.rotate(list, i2);
        }
        return list;
    }

    /* renamed from: F, reason: from kotlin metadata */
    public static final int createSingle(ProgramDescriptionItem objectClass) throws NoWhenBranchMatchedException {
        int i2 = 1;
        n.f(objectClass, "<this>");
        i2 = 1;
        switch (app.dogo.com.dogo_android.util.extensionfunction.j1.a.c[objectClass.getProgramState().ordinal()]) {
            case 1: /* ordinal */
                i2 = 0;
                return i2;
            case 2: /* ordinal */
                return i2;
            case 3: /* ordinal */
                i2 = 2;
                return i2;
            case 4: /* ordinal */
                i2 = 3;
                return i2;
            case 5: /* ordinal */
                i2 = 4;
                return i2;
            case 6: /* ordinal */
                i2 = 5;
                return i2;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: F0, reason: from kotlin metadata */
    public static final boolean createSingle(Exception objectClass) {
        int i;
        boolean z = true;
        n.f(objectClass, "<this>");
        int r0 = objectClass instanceof DogExceptions_NameIsTooShort ? 1 : objectClass instanceof DogExceptions_NameIsTooLong;
        if (i == 0) {
            z = objectClass instanceof UnknownHostException;
        }
        return z;
    }

    /* renamed from: G, reason: from kotlin metadata */
    public static final int flatMapNotNull(ProgramExam transform) throws NoWhenBranchMatchedException {
        int i = 3;
        n.f(transform, "<this>");
        switch (app.dogo.com.dogo_android.util.extensionfunction.j1.a.b[transform.getStatus().ordinal()]) {
            case 1: /* ordinal */
                i = 0;
                break;
            case 2: /* ordinal */
                i = 1;
                break;
            case 3: /* ordinal */
                i = 2;
                break;
            case 4: /* ordinal */
                i = 3;
                break;
            case 5: /* ordinal */
                i = 4;
                break;
            case 6: /* ordinal */
                i = 5;
                break;
            case 7: /* ordinal */
                i = 6;
                break;
            case 8: /* ordinal */
                i = 7;
                break;
            case 9: /* ordinal */
                i = 8;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return i;
    }

    /* renamed from: G0, reason: from kotlin metadata */
    public static final void linkWithCredentialSingle(ViewPager2 lastCredential) {
        n.f(lastCredential, "<this>");
        final int i2 = 1;
        lastCredential.k(lastCredential.getCurrentItem() + i2, true);
    }

    public static final ProgramCompletionSummary H(ProgramModel programModel, ProgramProgress programProgress, String str, j1 j1Var) {
        Object item;
        List lessons;
        boolean hasNext;
        int i3;
        Object item2;
        ProgramProgress.ModuleProgress moduleProgress;
        boolean z;
        String str2;
        String str4;
        n.f(programModel, "<this>");
        n.f(str, "currentLessonId");
        n.f(j1Var, "programRepository");
        Iterator it = programModel.getModules().iterator();
        int i = 0;
        while (it.hasNext()) {
            lessons = (ProgramModel_ModuleModel)item.getLessons();
            hasNext = lessons instanceof Collection;
            i3 = 0;
            if (i3 != 0) {
                break;
            }
        }
        if (item == null) {
        } else {
            str = item.getId();
        }
        if (str == null) {
            Object obj = p.Z(programModel.getModules());
            str = obj == null ? "" : str;
        }
        List modules2 = programModel.getModules();
        ArrayList arrayList = new ArrayList(p.r(modules2, 10));
        Iterator it2 = modules2.iterator();
        while (it2.hasNext()) {
            Object item3 = it2.next();
            int r5 = i;
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.j1.fetchDogProfile(item3, i, str, j1Var));
        }
        return new ProgramCompletionSummary(arrayList, programModel.getCardBackgroundColor());
    }

    /* renamed from: H0, reason: from kotlin metadata */
    public static final void logEvent(ViewPager2 fbEvent) {
        n.f(fbEvent, "<this>");
        final int i2 = 1;
        fbEvent.k(fbEvent.getCurrentItem() - i2, true);
    }

    /* renamed from: I, reason: from kotlin metadata */
    public static final Double refreshIdToken(EditText forceUpdate) {
        n.f(forceUpdate, "<this>");
        return l.j(forceUpdate.getText().toString());
    }

    /* renamed from: I0, reason: from kotlin metadata */
    public static final i.b.b setMaxLines(com.google.android.gms.tasks.j<Void> numberOfLines) {
        n.f(numberOfLines, "<this>");
        final i.b.b bVar = b.g(new app.dogo.com.dogo_android.util.extensionfunction.x0(numberOfLines));
        n.e(bVar, "create { emitter ->\n        this.addOnCompleteListener { task ->\n            if (task.isSuccessful) {\n                emitter.onComplete()\n            } else {\n                emitter.onError(task.exception ?: Exception(\"void task failed\"))\n            }\n        }\n    }");
        return bVar;
    }

    /* renamed from: J, reason: from kotlin metadata */
    public static final Long setUpOnbaordingConfetti(EditText width) {
        n.f(width, "<this>");
        return l.o(width.getText().toString());
    }

    /* renamed from: J0, reason: from kotlin metadata */
    private static final void getProgramCompletionSummary(com.google.android.gms.tasks.j currentLessonId, i.b.c programRepository) {
        n.f(currentLessonId, "$this_toCompletable");
        n.f(programRepository, "emitter");
        currentLessonId.addOnCompleteListener(new app.dogo.com.dogo_android.util.extensionfunction.o0(programRepository));
    }

    /* renamed from: K, reason: from kotlin metadata */
    public static final int setupTrickListForIntermediateTraining(CardStackView selectedTrick) {
        androidx.recyclerview.widget.RecyclerView.p layoutManager = null;
        int i = 0;
        n.f(selectedTrick, "<this>");
        selectedTrick = selectedTrick.getLayoutManager() instanceof CardStackLayoutManager ? (CardStackLayoutManager)selectedTrick.getLayoutManager() : 0;
        if (layoutManager == null) {
            i = 0;
        } else {
            i = layoutManager.n2();
        }
        return i;
    }

    /* renamed from: K0, reason: from kotlin metadata */
    private static final void insertDogName(i.b.c dogName, com.google.android.gms.tasks.j locale) {
        boolean successful;
        Exception exception;
        n.f(dogName, "$emitter");
        if (locale.isSuccessful()) {
            dogName.onComplete();
        } else {
            if (locale.getException() == null) {
                exception = new Exception("void task failed");
            }
            dogName.onError(exception);
        }
    }

    /* renamed from: L, reason: from kotlin metadata */
    public static final String parseExam(String dogProfileModel, String userId, n2.a userLocale) {
        String str;
        String str2 = null;
        n.f(dogProfileModel, "<this>");
        n.f(userId, "dogName");
        n.f(userLocale, "locale");
        switch (app.dogo.com.dogo_android.util.extensionfunction.j1.a.d[userLocale.ordinal()]) {
            case 1: /* ordinal */
                str2 = "the dog|your dog";
                break;
            case 2: /* ordinal */
                str2 = "dein Hund|deinem Hund|deinen Hund|der Hund|des Hundes|den Hund";
                break;
            case 3: /* ordinal */
                str2 = "el perro|al perro|tu perro|del perro";
                break;
            case 4: /* ordinal */
                str2 = "ton chien|au chie|le chien|du chien";
                break;
            case 5: /* ordinal */
                str2 = "o seu cachorro|o cachorro";
                break;
            case 6: /* ordinal */
                str2 = "jouw hond|je hond";
                break;
            case 7: /* ordinal */
                str2 = "din hund";
                break;
            default:
                int i2 = 0;
        }
        if (str2 != null) {
            str = new Regex(str2, RegexOption.IGNORE_CASE).e(dogProfileModel, userId);
        }
        return str;
    }

    /* renamed from: L0, reason: from kotlin metadata */
    public static final DogBreed toFlatLessonData(BreedEntity progressModel) {
        n.f(progressModel, "<this>");
        String title = progressModel.getTitle();
        Objects.requireNonNull(title, "null cannot be cast to non-null type kotlin.CharSequence");
        DogBreed dogBreed = new DogBreed(progressModel.getBreedId(), l.a1(title).toString(), false, 4, null);
        return dogBreed;
    }

    /* renamed from: M, reason: from kotlin metadata */
    public static final boolean toIntervalString(String resources) {
        boolean equals;
        boolean z = false;
        boolean equals2;
        n.f(resources, "<this>");
        int i2 = 1;
        switch (resources.hashCode()) {
            case -557629118:
                App.INSTANCE.r().logEvent(E_General.e.withParameters(u.a(eP_Value, resources)));
                int i3 = 0;
                break;
            case -106619775:
                App.INSTANCE.r().logEvent(E_General.e.withParameters(u.a(eP_Value, resources)));
                i3 = 0;
                break;
            case -91843507:
                i3 = 0;
                break;
            case 682158:
                App.INSTANCE.r().logEvent(E_General.e.withParameters(u.a(eP_Value, resources)));
                i3 = 0;
                break;
            case 661656845:
                App.INSTANCE.r().logEvent(E_General.e.withParameters(u.a(eP_Value, resources)));
                i3 = 0;
                break;
            case 813295717:
                App.INSTANCE.r().logEvent(E_General.e.withParameters(u.a(eP_Value, resources)));
                i3 = 0;
                break;
            case 813295967:
                App.INSTANCE.r().logEvent(E_General.e.withParameters(u.a(eP_Value, resources)));
                i3 = 0;
                break;
            case 813311333:
                App.INSTANCE.r().logEvent(E_General.e.withParameters(u.a(eP_Value, resources)));
                i3 = 0;
                break;
            case 935200739:
                App.INSTANCE.r().logEvent(E_General.e.withParameters(u.a(eP_Value, resources)));
                i3 = 0;
                break;
            case 1965898496:
                App.INSTANCE.r().logEvent(E_General.e.withParameters(u.a(eP_Value, resources)));
                i3 = 0;
                break;
            case 2096625051:
                App.INSTANCE.r().logEvent(E_General.e.withParameters(u.a(eP_Value, resources)));
                i3 = 0;
                break;
            default:
                i3 = 0;
        }
        return z;
    }

    /* renamed from: M0, reason: from kotlin metadata */
    public static final String parseItem(long position, Resources total) throws android.content.res.Resources.NotFoundException {
        String quantityString;
        n.f(total, "resources");
        long millis = TimeUnit.HOURS.toMillis(1L);
        int i2 = 0;
        int i3 = 1;
        if (position < millis) {
            int i4 = (int)TimeUnit.MILLISECONDS.toMinutes(position);
            Object[] arr = new Object[i3];
            str = "{\n        val minutes = TimeUnit.MILLISECONDS.toMinutes(this).toInt()\n        resources.getQuantityString(\n            R.plurals.time_placeholder_min,\n            minutes,\n            minutes\n        )\n    }";
            n.e(total.getQuantityString(2131755025, i4, new Object[] { Integer.valueOf(i4) }), str);
        } else {
            int i5 = (int)TimeUnit.MILLISECONDS.toHours(position);
            arr = new Object[i3];
            str = "{\n        val hours = TimeUnit.MILLISECONDS.toHours(this).toInt()\n        resources.getQuantityString(\n            R.plurals.time_placeholder_hour,\n            hours,\n            hours\n        )\n    }";
            n.e(total.getQuantityString(2131755024, i5, new Object[] { Integer.valueOf(i5) }), str);
        }
        return quantityString;
    }

    /* renamed from: N, reason: from kotlin metadata */
    public static final boolean translateIfAnonymousNameFound(List<TrickItem> context) {
        boolean hasNext;
        int size;
        boolean z = true;
        int i;
        boolean hasNext2;
        boolean newContent;
        n.f(context, "<this>");
        i = 1;
        i = 0;
        if (context.size() > i) {
            hasNext = context instanceof Collection;
            int r3 = i;
            if (i != 0) {
                context = i;
                if (i == 0) {
                }
            }
        }
        return z;
    }

    /* renamed from: N0, reason: from kotlin metadata */
    public static final i.b.a0<String> translateIfAnonymousNameFound(com.google.android.gms.tasks.j<String> resources) {
        n.f(resources, "<this>");
        final i.b.a0 a0Var = a0.create(new app.dogo.com.dogo_android.util.extensionfunction.q0(resources));
        n.e(a0Var, "create { emitter ->\n        this.addOnCompleteListener { task ->\n            if (task.isSuccessful) {\n                emitter.onSuccess(task.result ?: \"\")\n            } else {\n                emitter.onError(task.exception ?: Exception(\"String task failed\"))\n            }\n        }\n    }");
        return a0Var;
    }

    public static final boolean O(PurchaserInfo purchaserInfo) {
        boolean z = false;
        n.f(purchaserInfo, "<this>");
        EntitlementInfo entitlementInfo = purchaserInfo.getEntitlements().get("premium");
        int i2 = 0;
        final int i = 1;
        if (entitlementInfo != null) {
            if (entitlementInfo.isActive()) {
            }
        }
        return z;
    }

    public static final i.b.a0<DataSnapshot> O0(DatabaseReference databaseReference) {
        n.f(databaseReference, "<this>");
        final i.b.a0 a0Var = a0.create(new app.dogo.com.dogo_android.util.extensionfunction.u0(databaseReference));
        n.e(a0Var, "create { emitter ->\n        addValueEventListener(object : ValueEventListener {\n            override fun onDataChange(dataSnapshot: DataSnapshot) {\n                emitter.onSuccess(dataSnapshot)\n                removeEventListener(this)\n            }\n\n            override fun onCancelled(databaseError: DatabaseError) {\n                removeEventListener(this)\n                val exception = databaseError.toException()\n                Timber.e(exception)\n                @Suppress(\"UnstableApiUsage\")\n                emitter.tryOnError(exception)\n            }\n        })\n    }");
        return a0Var;
    }

    public static final boolean P(PurchaserInfo purchaserInfo) {
        n.f(purchaserInfo, "<this>");
        return !app.dogo.com.dogo_android.util.extensionfunction.j1.O(purchaserInfo);
    }

    /* renamed from: P0, reason: from kotlin metadata */
    private static final void replace(DatabaseReference newValue, c0 oldValue) {
        n.f(newValue, "$this_toSingle");
        n.f(oldValue, "emitter");
        newValue.addValueEventListener(new ExtensionsKt_toSingle_1_1(oldValue, newValue));
    }

    public static final i.b.a0<Boolean> Q(Purchases purchases) {
        n.f(purchases, "<this>");
        final i.b.a0 a0Var = a0.create(new app.dogo.com.dogo_android.util.extensionfunction.z0(purchases));
        n.e(a0Var, "create { emitter ->\n        getPurchaserInfoWith({ error ->\n            Timber.e(\"$error\")\n            emitter.onSuccess(false)\n        }) { purchaserInfo ->\n            val isFreeTrailAvailable = purchaserInfo.allPurchasedSkus.none { it.contains(\"freetrial\") }\n            emitter.onSuccess(isFreeTrailAvailable)\n        }\n    }");
        return a0Var;
    }

    /* renamed from: Q0, reason: from kotlin metadata */
    private static final void setupTouchListener(com.google.android.gms.tasks.j view, c0 callback) {
        n.f(view, "$this_toSingle");
        n.f(callback, "emitter");
        view.addOnCompleteListener(new app.dogo.com.dogo_android.util.extensionfunction.r0(callback));
    }

    private static final void R(Purchases purchases, c0 c0Var) {
        n.f(purchases, "$this_isUserEligibleForFreeTrailByRegexCheck");
        n.f(c0Var, "emitter");
        ListenerConversionsKt.getPurchaserInfoWith(purchases, new app.dogo.com.dogo_android.util.extensionfunction.j1.d(c0Var), new app.dogo.com.dogo_android.util.extensionfunction.j1.e(c0Var));
    }

    private static final void R0(c0 c0Var, com.google.android.gms.tasks.j jVar) {
        boolean successful;
        Object result;
        Exception exception;
        n.f(c0Var, "$emitter");
        if (jVar.isSuccessful()) {
            if ((String)jVar.getResult() == null) {
                String str3 = "";
            }
            c0Var.onSuccess(result);
        } else {
            if (jVar.getException() == null) {
                exception = new Exception("String task failed");
            }
            c0Var.onError(exception);
        }
    }

    public static final TrickItem S0(TrickModel trickModel, Integer integer, List<String> list, boolean z) {
        int value = 30;
        String examInstructions;
        int value3 = 2147483647;
        long parsed = 0;
        long parsed2;
        int value2 = 0;
        int startTime = -1;
        TrickItem.VideoStep trickItem_VideoStep;
        String text;
        int i3;
        Object list32 = list;
        n.f(trickModel, "<this>");
        n.f(list32, "lockedTricks");
        String videoId = trickModel.getVideoId();
        parsed = 0L;
        if (videoId == null) {
            int i6 = parsed;
        } else {
            parsed2 = Long.parseLong(videoId);
        }
        value2 = 0;
        int i7 = 10;
        if (parsed2 != parsed) {
            List videoSteps = trickModel.getVideoSteps();
            Iterator it = videoSteps.iterator();
            while (it.hasNext()) {
                Object item4 = it.next();
                value2 = value2 + 1;
                if (value2 < 0) {
                    p.q();
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                }
            }
        } else {
            list = p.g();
        }
        if (trickModel.getExamInstructions() == null && trickModel.getDescription() == null) {
            examInstructions = "";
        }
        value2 = integer == null ? value2 : value2;
        List trickSteps = trickModel.getTrickSteps();
        final ArrayList arrayList3 = new ArrayList(p.r(trickSteps, i7));
        Iterator it2 = trickSteps.iterator();
        while (it2.hasNext()) {
            Object item2 = it2.next();
            arrayList3.add(new TrickItem_TrickStep(item2.getDescription(), item2.getImage()));
        }
        String videoId2 = trickModel.getVideoId();
        if (videoId2 != null) {
            parsed = Long.parseLong(videoId2);
        }
        Integer sortOrder = trickModel.getSortOrder();
        if (sortOrder == null) {
            value3 = Integer.MAX_VALUE;
        } else {
            value3 = sortOrder.intValue();
        }
        List tags = trickModel.getTags();
        ArrayList arrayList = new ArrayList(p.r(tags, i7));
        Iterator it3 = tags.iterator();
        while (it3.hasNext()) {
            Object item = it3.next();
            z = false;
            int i4 = 1;
            kotlin.d0.d.g gVar = null;
            LibraryTag libraryTag = new LibraryTag(z, item.getName(), item.getId(), i4, gVar);
            arrayList.add(libraryTag);
        }
        if (list32.contains(trickModel.getId()) && !z) {
            value2 = 1;
        }
        Integer examTimeLimit = trickModel.getExamTimeLimit();
        if (examTimeLimit == null) {
            value = 30;
        } else {
            value = examTimeLimit.intValue();
        }
        TrickItem trickItem = new TrickItem(trickModel.getId(), trickModel.getName(), examInstructions, trickModel.getImage(), false, value2, arrayList3, list, parsed, z2, trickModel.getHasProgress(), value3, arrayList, new TrickItem_TrickCategory(trickModel.getCategory().getId(), trickModel.getCategory().getName()), value2, false, null, null, null, 0, value, 507904, 0);
        return trickItem;
    }

    public static /* synthetic */ TrickItem T0(TrickModel trickModel, Integer integer, List list, boolean z, int i, Object object) {
        if (i & 2 != 0) {
            list = p.g();
        }
        if (i & 4 != 0) {
            i = 1;
        }
        return app.dogo.com.dogo_android.util.extensionfunction.j1.S0(trickModel, integer, list, z);
    }

    public static final TrainingReminderModel.Weekdays U0(List<Boolean> list) {
        n.f(list, "<this>");
        TrainingReminderModel_Weekdays trainingReminderModel_Weekdays = new TrainingReminderModel_Weekdays((Boolean)list.get(0).booleanValue(), (Boolean)list.get(1).booleanValue(), (Boolean)list.get(2).booleanValue(), (Boolean)list.get(3).booleanValue(), (Boolean)list.get(4).booleanValue(), (Boolean)list.get(5).booleanValue(), (Boolean)list.get(6).booleanValue());
        return trainingReminderModel_Weekdays;
    }

    public static final String V0(String str, Context context) {
        n.f(str, "<this>");
        n.f(context, "context");
        final Resources resources = context.getResources();
        n.e(resources, "context.resources");
        return app.dogo.com.dogo_android.util.extensionfunction.j1.W0(str, resources);
    }

    public static final String W0(String str, Resources resources) throws android.content.res.Resources.NotFoundException {
        String string;
        n.f(str, "<this>");
        n.f(resources, "resources");
        if (app.dogo.com.dogo_android.util.extensionfunction.j1.toIntervalString(str)) {
            str2 = "{\n        resources.getString(R.string.general_anonymous)\n    }";
            n.e(resources.getString(2131886675), str2);
        }
        return string;
    }

    public static final boolean X0(PurchaserInfo purchaserInfo) {
        boolean z3 = false;
        n.f(purchaserInfo, "<this>");
        purchaserInfo = !app.dogo.com.dogo_android.util.extensionfunction.j1.Z0(purchaserInfo) && !app.dogo.com.dogo_android.util.extensionfunction.j1.Y0(purchaserInfo) ? 1 : 0;
        return (!app.dogo.com.dogo_android.util.extensionfunction.j1.Z0(purchaserInfo) && !app.dogo.com.dogo_android.util.extensionfunction.j1.Y0(purchaserInfo) ? 1 : 0);
    }

    public static final boolean Y0(PurchaserInfo purchaserInfo) {
        int i = 0;
        boolean z = false;
        n.f(purchaserInfo, "<this>");
        EntitlementInfo entitlementInfo = purchaserInfo.getEntitlements().get("premium");
        if (entitlementInfo == null) {
            i = 0;
        } else {
            Date expirationDate = entitlementInfo.getExpirationDate();
        }
        purchaserInfo = i == 0 ? 1 : 0;
        return (i == 0 ? 1 : 0);
    }

    public static final boolean Z0(PurchaserInfo purchaserInfo) {
        boolean z = false;
        n.f(purchaserInfo, "<this>");
        EntitlementInfo entitlementInfo = purchaserInfo.getEntitlements().get("premium");
        int i2 = 0;
        final int i = 1;
        if (entitlementInfo != null) {
            if (entitlementInfo.getWillRenew()) {
            }
        }
        return z;
    }

    public static final void a(KonfettiView konfettiView) throws android.content.res.Resources.NotFoundException {
        n.f(konfettiView, "<this>");
        nl.dionsegijn.konfetti.b bVar = konfettiView.a();
        int i = 2;
        int[] iArr = new int[i];
        int i8 = 2131099848;
        final android.content.res.Resources.Theme theme = null;
        final int i10 = 0;
        iArr[i10] = konfettiView.getResources().getColor(i8, theme);
        final int i11 = 2131099849;
        int color2 = konfettiView.getResources().getColor(i11, theme);
        final int i12 = 1;
        iArr[i12] = color2;
        bVar.a(iArr);
        final long l = 4645023210981556224L;
        bVar.h(0.0d, l);
        bVar.k(20f, 30f);
        bVar.i(true);
        bVar.l(6000L);
        nl.dionsegijn.konfetti.e.b[] arr3 = new b[i];
        final b.a aVar = b.a.c;
        arr3[i10] = aVar;
        final b.c cVar3 = b.c.b;
        arr3[i12] = cVar3;
        bVar.b(arr3);
        nl.dionsegijn.konfetti.e.c[] arr4 = new c[i12];
        int i15 = 18;
        arr4[i10] = new c(i15, 500f);
        bVar.c(arr4);
        bVar.j((float)konfettiView.getWidth(), Float.valueOf((float)konfettiView.getWidth()), (float)konfettiView.getHeight(), Float.valueOf((float)konfettiView.getHeight()));
        int i4 = 100;
        bVar.d(i4);
        nl.dionsegijn.konfetti.b bVar2 = konfettiView.a();
        int[] iArr2 = new int[i];
        iArr2[i10] = konfettiView.getResources().getColor(i8, theme);
        int color4 = konfettiView.getResources().getColor(i11, theme);
        iArr2[i12] = color4;
        bVar2.a(iArr2);
        bVar2.h(0.0d, l);
        float f5 = 20f;
        bVar2.k(f5, 30f);
        bVar2.i(true);
        bVar2.l(6000L);
        nl.dionsegijn.konfetti.e.b[] arr = new b[i];
        arr[i10] = aVar;
        arr[i12] = cVar3;
        bVar2.b(arr);
        nl.dionsegijn.konfetti.e.c[] arr2 = new c[i12];
        arr2[i10] = new c(i15, 500f);
        bVar2.c(arr2);
        float f2 = 0.0f;
        bVar2.j(f2, Float.valueOf(f2), (float)konfettiView.getHeight(), Float.valueOf((float)konfettiView.getHeight()));
        bVar2.d(i4);
    }

    public static final ProgramDescriptionItem b(ProgramModel programModel, ProgramDescriptionItem.State state, boolean z, boolean z2, long j, boolean z3, int i, ProgramOverview programOverview) {
        String centeredImage;
        Object state22 = state;
        n.f(programModel, "<this>");
        n.f(state22, "status");
        if (state22 != ProgramDescriptionItem_State.RECOMMENDED_BIG || !z) {
            centeredImage = programModel.getImage();
        } else {
            centeredImage = programModel.getCenteredImage();
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = programModel.getModules().iterator();
        while (it.hasNext()) {
            p.y(arrayList3, (ProgramModel_ModuleModel)it.next().getLessons());
        }
        ArrayList arrayList = new ArrayList();
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            p.y(arrayList, (ProgramModel_LessonModel)it3.next().getTricks().values());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = programModel.getModules().iterator();
        while (it2.hasNext()) {
            p.y(arrayList2, (ProgramModel_ModuleModel)it2.next().getExams());
        }
        ProgramDescriptionItem programDescriptionItem = new ProgramDescriptionItem(str, name, centeredImage, cardBackgroundColor, programModel.getModules().size(), arrayList.size(), state, arrayList2.size(), numberOfEnrolledUsers, i, programModel.getDogSkillsHighlights(), z2, j, z, z3, programOverview);
        return programDescriptionItem;
    }

    public static /* synthetic */ ProgramDescriptionItem c(ProgramModel programModel, ProgramDescriptionItem.State state, boolean z, boolean z2, long j, boolean z3, int i, ProgramOverview programOverview, int i2, Object object) {
        int z32 = 1;
        int z42;
        long programOverview82 = 0;
        int j52 = 0;
        int i92 = 0;
        int r0 = i2 & 2 != 0 ? 1 : z;
        z42 = 0;
        int r1 = i2 & 4 != 0 ? z42 : z2;
        int r3 = i2 & 8 != 0 ? 0 : j;
        int r5 = i2 & 16 != 0 ? z42 : z3;
        if (i2 & 32 == 0) {
            programOverview82 = i;
        }
        int r6 = i2 & 64 != 0 ? 0 : programOverview;
        return app.dogo.com.dogo_android.util.extensionfunction.j1.b(programModel, state, z32, z42, j52, i, z42, programOverview82, (i2 & 64 != 0 ? 0 : programOverview));
    }

    public static final String d(String str) {
        int str2;
        char charAt;
        char c = 33;
        n.f(str, "<this>");
        StringBuilder stringBuilder = new StringBuilder(str);
        str2 = 0;
        str2 = 1;
        while (str2 < stringBuilder.length()) {
            c = '.';
            str2 = str2 + 1;
        }
        String str5 = stringBuilder.toString();
        n.e(str5, "sb.toString()");
        return str5;
    }

    public static final void e(androidx.fragment.app.n nVar) {
        int i = 0;
        n.f(nVar, "<this>");
        int i2 = nVar.p0();
        if (i2 > 0) {
            i = 0;
            i = i + 1;
            nVar.Z0();
            while (i + 1 >= i2) {
                i = i + 1;
                nVar.Z0();
            }
        }
        app.dogo.com.dogo_android.util.extensionfunction.j1.o(nVar);
    }

    public static final boolean f(androidx.fragment.app.n nVar, String str) {
        boolean z = false;
        n.f(nVar, "<this>");
        n.f(str, "tag");
        kotlin.h0.f fVar = g.l(0, nVar.p0());
        final ArrayList arrayList = new ArrayList(p.r(fVar, 10));
        Iterator it = fVar.iterator();
        while (it.hasNext()) {
            n.k kVar = nVar.o0((IntIterator)it.d());
            str = "getBackStackEntryAt(it)";
            n.e(kVar, str);
            arrayList.add(kVar.getName());
        }
        if (!(arrayList.isEmpty())) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                if (n.b((String)it2.next(), str)) {
                    int i4 = 1;
                }
            }
        }
        return z;
    }

    /* renamed from: g, reason: from kotlin metadata */
    public static final <T> i.b.a0<T> scrollToPositionMiddleInsideNestedView(DocumentReference nestedScrollView, Source position, Class<T> scrollDuration) {
        n.f(nestedScrollView, "<this>");
        n.f(position, "source");
        n.f(scrollDuration, "objectClass");
        final i.b.a0 a0Var = a0.create(new app.dogo.com.dogo_android.util.extensionfunction.s0(nestedScrollView, position, scrollDuration));
        n.e(a0Var, "create { emitter ->\n        this.get(source).addOnCompleteListener { task ->\n            if (task.isSuccessful) {\n                val result = task.result?.toObject(objectClass)\n                if (result != null) {\n                    emitter.onSuccess(result)\n                } else {\n                    @Suppress(\"UnstableApiUsage\")\n                    emitter.tryOnError(CustomExceptions.DataNotFound(\"No document found\"))\n                }\n            } else {\n                val exception = task.exception ?: Exception(\"failed to fetch query : $this\")\n                Timber.e(exception)\n                @Suppress(\"UnstableApiUsage\")\n                emitter.tryOnError(exception)\n            }\n        }\n    }");
        return a0Var;
    }

    public static final <T> i.b.a0<T> h(DocumentReference documentReference, Class<T> cls) {
        n.f(documentReference, "<this>");
        n.f(cls, "objectClass");
        return app.dogo.com.dogo_android.util.extensionfunction.j1.scrollToPositionMiddleInsideNestedView(documentReference, Source.DEFAULT, cls);
    }

    public static final i.b.a0<AuthResult> h0(FirebaseUser firebaseUser, AuthCredential authCredential) {
        n.f(firebaseUser, "<this>");
        n.f(authCredential, "lastCredential");
        final i.b.a0 a0Var = a0.create(new app.dogo.com.dogo_android.util.extensionfunction.a1(firebaseUser, authCredential));
        n.e(a0Var, "create { emitter ->\n        linkWithCredential(lastCredential).addOnCompleteListener { task: Task<AuthResult> ->\n            if (task.isSuccessful && task.result != null) {\n                emitter.onSuccess(task.result)\n            } else {\n                Timber.e(task.exception, \"auth, error while linking\")\n                emitter.tryOnError(task.exception ?: Throwable(\"auth, error while linking\"))\n            }\n        }\n    }");
        return a0Var;
    }

    public static final <T> i.b.a0<List<T>> i(com.google.firebase.firestore.Query query, Source source, Class<T> cls) {
        n.f(query, "<this>");
        n.f(source, "source");
        n.f(cls, "objectClass");
        final i.b.a0 a0Var = a0.create(new app.dogo.com.dogo_android.util.extensionfunction.n0(query, source, cls));
        n.e(a0Var, "create { emitter ->\n        this.get(source)\n            .addOnCompleteListener { task ->\n                if (task.isSuccessful) {\n                    val result = task.result?.toObjects(objectClass)!!\n                    emitter.onSuccess(result)\n                } else {\n                    val exception = task.exception ?: Exception(\"failed to fetch query : $this\")\n                    Timber.e(exception)\n                    @Suppress(\"UnstableApiUsage\")\n                    emitter.tryOnError(exception)\n                }\n            }\n    }");
        return a0Var;
    }

    private static final void i0(FirebaseUser firebaseUser, AuthCredential authCredential, c0 c0Var) {
        n.f(firebaseUser, "$this_linkWithCredentialSingle");
        n.f(authCredential, "$lastCredential");
        n.f(c0Var, "emitter");
        firebaseUser.linkWithCredential(authCredential).addOnCompleteListener(new app.dogo.com.dogo_android.util.extensionfunction.y0(c0Var));
    }

    public static final <T> i.b.a0<List<T>> j(com.google.firebase.firestore.Query query, Class<T> cls) {
        n.f(query, "<this>");
        n.f(cls, "objectClass");
        return app.dogo.com.dogo_android.util.extensionfunction.j1.i(query, Source.DEFAULT, cls);
    }

    private static final void j0(c0 c0Var, com.google.android.gms.tasks.j jVar) {
        Exception exception2;
        n.f(c0Var, "$emitter");
        n.f(jVar, "task");
        if (!jVar.isSuccessful() || jVar.getResult() == null) {
            str = "auth, error while linking";
            a.e(jVar.getException(), str, new Object[0]);
            if (jVar.getException() == null) {
                Throwable throwable = new Throwable(str);
            }
            c0Var.a(exception2);
        } else {
            c0Var.onSuccess(jVar.getResult());
        }
    }

    private static final void k(com.google.firebase.firestore.Query query, Source source, Class cls, c0 c0Var) {
        n.f(query, "$this_createSingle");
        n.f(source, "$source");
        n.f(cls, "$objectClass");
        n.f(c0Var, "emitter");
        query.get(source).addOnCompleteListener(new app.dogo.com.dogo_android.util.extensionfunction.w0(cls, c0Var, query));
    }

    public static final void k0(com.facebook.e0.g gVar, a3 a3Var) {
        n.f(gVar, "<this>");
        if (a3Var == null) {
            return;
        }
        if (a3Var.h() == null || a3Var.g() == null) {
            if (a3Var.h() != null) {
                gVar.d(a3Var.f(), a3Var.h().doubleValue());
            } else {
                if (a3Var.g() != null) {
                    gVar.f(a3Var.f(), a3Var.g());
                } else {
                    gVar.c(a3Var.f());
                }
            }
        } else {
            gVar.e(a3Var.f(), a3Var.h().doubleValue(), a3Var.g());
        }
    }

    private static final void l(Class cls, c0 c0Var, com.google.firebase.firestore.Query query, com.google.android.gms.tasks.j jVar) {
        Exception exception;
        List objects = null;
        String str;
        String str2;
        n.f(cls, "$objectClass");
        n.f(c0Var, "$emitter");
        n.f(query, "$this_createSingle");
        if (jVar.isSuccessful()) {
            Object result = jVar.getResult();
            if (result == null) {
                int i = 0;
            } else {
                objects = result.toObjects(cls);
            }
            n.d(objects);
            str = "task.result?.toObjects(objectClass)!!";
            n.e(objects, str);
            c0Var.onSuccess(objects);
        } else {
            if (jVar.getException() == null) {
                str2 = "failed to fetch query : ";
                exception = new Exception(n.o(str2, query));
            }
            a.d(exception);
            c0Var.a(exception);
        }
    }

    public static final ChallengeEntryModel l0(ChallengeNotificationModel challengeNotificationModel) {
        ArrayList arrayList = null;
        HashMap hashMap;
        Object obj;
        long l;
        n.f(challengeNotificationModel, "<this>");
        Map entryImages = challengeNotificationModel.getEntryImages();
        String str2 = "votes";
        String str4 = "imageUrl_320";
        String str6 = "imageUrl_640";
        String str12 = "imageUrl_1280";
        String str13 = "imageUrl";
        int i2 = 0;
        if (entryImages != null) {
            Collection values = entryImages.values();
            if (values != null) {
                List list = p.D0(values, new app.dogo.com.dogo_android.util.extensionfunction.j1.f());
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        Object item = it.next();
                        hashMap = new HashMap();
                        hashMap.put(str4, item.getImageUrl_320());
                        hashMap.put(str6, item.getImageUrl_640());
                        hashMap.put(str12, item.getImageUrl_1280());
                        hashMap.put(str13, item.getImageUrl());
                        hashMap.put(str2, Long.valueOf(item.getVotes()));
                        hashMap.put("imageId", item.getImageId());
                        hashMap.put("createdAt", item.getCreatedAt());
                        hashMap.put("featured", Boolean.valueOf(item.getFeatured()));
                        new ArrayList(p.r(list, 10)).add(new ChallengeEntryModel_MiniEntryModel(hashMap));
                    }
                }
            }
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("entryId", challengeNotificationModel.getEntryId());
        hashMap2.put("dogName", challengeNotificationModel.getEntryDogName());
        hashMap2.put(str13, challengeNotificationModel.getEntryImageUrl());
        hashMap2.put(str12, challengeNotificationModel.getEntryImageUrl());
        hashMap2.put(str6, challengeNotificationModel.getEntryImageUrl());
        hashMap2.put(str4, challengeNotificationModel.getEntryImageUrl_320());
        hashMap2.put("published", Boolean.valueOf(challengeNotificationModel.getEntryPublished()));
        hashMap2.put("dogId", challengeNotificationModel.getEntryDogId());
        hashMap2.put("challengeId", challengeNotificationModel.getChallengeId());
        hashMap2.put("author", challengeNotificationModel.getEntryOwnerUserId());
        hashMap2.put("comment", challengeNotificationModel.getEntryComment());
        hashMap2.put(str2, Integer.valueOf(challengeNotificationModel.getEntryVotes()));
        hashMap2.put("dogAvatarUrl", challengeNotificationModel.getEntryDogAvatarUrl());
        hashMap2.put("images", arrayList);
        return ChallengeEntryModel.Companion.parseChallengeEntry(hashMap2);
    }

    private static final void m(DocumentReference documentReference, Source source, Class cls, c0 c0Var) {
        n.f(documentReference, "$this_createSingle");
        n.f(source, "$source");
        n.f(cls, "$objectClass");
        n.f(c0Var, "emitter");
        documentReference.get(source).addOnCompleteListener(new app.dogo.com.dogo_android.util.extensionfunction.t0(cls, c0Var, documentReference));
    }

    public static final Exam m0(ProgramExam programExam, DogProfileModel dogProfileModel, String str, String str2) {
        n.f(programExam, "<this>");
        n.f(dogProfileModel, "dogProfileModel");
        n.f(str, "userId");
        n.f(str2, "userLocale");
        Exam exam = new Exam(programExam.getTrickId(), dogProfileModel.getId(), dogProfileModel.getName(), dogProfileModel.getAvatar(), dogProfileModel.getGender(), str, str2, programExam.getDescription(), programExam.getExamTimeLimit(), programExam.getVideoUrl());
        return exam;
    }

    private static final void n(Class cls, c0 c0Var, DocumentReference documentReference, com.google.android.gms.tasks.j jVar) {
        Exception exception;
        Object object = null;
        String str;
        String str2;
        n.f(cls, "$objectClass");
        n.f(c0Var, "$emitter");
        n.f(documentReference, "$this_createSingle");
        if (jVar.isSuccessful()) {
            Object result = jVar.getResult();
            if (result == null) {
                int i = 0;
            } else {
                object = result.toObject(cls);
            }
            if (object != null) {
                c0Var.onSuccess(object);
            } else {
                str = "No document found";
                c0Var.a(new CustomExceptions_DataNotFound(str));
            }
        } else {
            if (jVar.getException() == null) {
                str2 = "failed to fetch query : ";
                exception = new Exception(n.o(str2, documentReference));
            }
            a.d(exception);
            c0Var.a(exception);
        }
    }

    public static final int n0(SkuDetails skuDetails) {
        n.f(skuDetails, "<this>");
        String str3 = skuDetails.b();
        n.e(str3, "freeTrialPeriod");
        return DogoSkuDetails.Companion.parsePeriodInDays(str3);
    }

    public static final void o(androidx.fragment.app.n nVar) {
        str = "<this>";
        n.f(nVar, str);
        Iterator it = nVar.v0().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            z = item instanceof d;
            Object childFragmentManager = item.getChildFragmentManager();
            str2 = "fragment.childFragmentManager";
            n.e(childFragmentManager, str2);
            app.dogo.com.dogo_android.util.extensionfunction.j1.o(childFragmentManager);
        }
    }

    public static final SurveyQuestion o0(SurveyQuestionModel surveyQuestionModel, int i, int i2) {
        Object obj;
        Object obj2;
        String text;
        n.f(surveyQuestionModel, "<this>");
        List answers = surveyQuestionModel.getAnswers();
        final ArrayList arrayList = new ArrayList(p.r(answers, 10));
        Iterator it = answers.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            arrayList.add(new SurveyAnswer(item.getId(), item.getText()));
        }
        obj = p.a0(surveyQuestionModel.getAnswers(), 0);
        text = "";
        String r4 = text;
        obj2 = p.a0(surveyQuestionModel.getAnswers(), 1);
        String r5 = text;
        Object obj3 = p.a0(surveyQuestionModel.getAnswers(), 2);
        if (obj3 == null) {
            i = 0;
        } else {
            String text2 = obj3.getText();
        }
        SurveyQuestion surveyQuestionModel2 = new SurveyQuestion(surveyQuestionModel.getId(), arrayList, text, text, i, surveyQuestionModel.getText(), i2, i);
        return surveyQuestionModel2;
    }

    public static final void p(EntryPhotoBaseObservable entryPhotoBaseObservable, app.dogo.com.dogo_android.service.u2 u2Var, i.b.j0.a aVar, String str, kotlin.d0.c.l<? super DogProfileModel, w> lVar) {
        n.f(entryPhotoBaseObservable, "<this>");
        n.f(u2Var, "userLocalCacheService");
        n.f(aVar, "disposable");
        n.f(str, "dogId");
        n.f(lVar, "callback");
        i.b.a0 observable2 = u2Var.y(str).subscribeOn(a.b()).observeOn(a.a());
        n.e(observable2, "userLocalCacheService.getPublicDogProfile(dogId)\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())");
        aVar.b(a.g(observable2, new app.dogo.com.dogo_android.util.extensionfunction.j1.b(lVar, str), new app.dogo.com.dogo_android.util.extensionfunction.j1.c(lVar)));
    }

    public static final ProgramExam.Status p0(ProgramProgress.ExamSubmission examSubmission) throws NoWhenBranchMatchedException {
        ProgramExam.Status aPPROVED2;
        n.f(examSubmission, "<this>");
        switch (app.dogo.com.dogo_android.util.extensionfunction.j1.a.a[app.dogo.com.dogo_android.util.extensionfunction.j1.r0(examSubmission).ordinal()]) {
            case 1: /* ordinal */
                aPPROVED2 = ProgramExam_Status.LOCKED;
                break;
            case 2: /* ordinal */
                aPPROVED2 = ProgramExam_Status.READY;
                break;
            case 3: /* ordinal */
                aPPROVED2 = ProgramExam_Status.PENDING;
                break;
            case 4: /* ordinal */
                aPPROVED2 = ProgramExam_Status.APPROVED;
                break;
            case 5: /* ordinal */
                aPPROVED2 = ProgramExam_Status.REJECTED;
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return aPPROVED2;
    }

    public static final <K, V> Map<K, V> q(Map<K, ? extends V> map) {
        int i = 1;
        n.f(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object value = it.next();
            int r2 = value.getValue() != null ? 1 : 0;
        }
        return linkedHashMap;
    }

    public static final List<SpecialOfferCoupon> q0(String str) {
        int i = 0;
        n.f(str, "<this>");
        Object json = new Gson().fromJson(str, SpecialOfferRemoteConfig.class);
        if (json == null) {
            i = 0;
        } else {
            List offers = json.getOffers();
        }
        if (i == 0) {
            List list = p.g();
        }
        return i;
    }

    public static final <T, R> List<R> r(Iterable<? extends T> iterable, kotlin.d0.c.l<? super T, ? extends Iterable<? extends R>> lVar) {
        n.f(iterable, "<this>");
        n.f(lVar, "transform");
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            p.y(arrayList, (Iterable)lVar.invoke(it.next()));
        }
        return p.U(arrayList);
    }

    public static final ProgramProgress.ProgramExamStatus r0(ProgramProgress.ExamSubmission examSubmission) {
        int i = 0;
        n.f(examSubmission, "<this>");
        ProgramProgress.ProgramExamStatus[] values = ProgramProgress_ProgramExamStatus.values();
        i = 0;
        for (ProgramProgress.ProgramExamStatus programExamStatus : values) {
            if (n.b(examSubmission.getStatus(), programExamStatus.getExamStatus())) {
                return programExamStatus;
            }
        }
        return ProgramProgress_ProgramExamStatus.LOCKED;
    }

    public static final String s(ChallengeComment challengeComment) {
        String item = null;
        boolean contains;
        Set set;
        item = "<this>";
        n.f(challengeComment, item);
        Iterator it = challengeComment.getBadges().iterator();
        while (it.hasNext()) {
            if (ChallengeRepository.Companion.a().contains((String)item)) {
                break;
            }
        }
        int i = 0;
        if ((String)item == null) {
            item = "";
        }
        return item;
    }

    public static final com.google.android.gms.tasks.j<String> s0(FirebaseAuth firebaseAuth, boolean z) {
        com.google.android.gms.tasks.j continueWith;
        n.f(firebaseAuth, "<this>");
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser != null) {
            continueWith = currentUser.getIdToken(z).continueWith(app.dogo.com.dogo_android.util.extensionfunction.v0.a);
        } else {
            a.f("Current User is Null", new Object[0]);
            continueWith = m.e("");
        }
        n.e(continueWith, "currentUser.let {\n        if (it != null) {\n            it.getIdToken(forceUpdate).continueWith { task ->\n                val fireAuthTokenJWT = task.takeIf { task.isSuccessful }?.result?.token\n                if (fireAuthTokenJWT != null) {\n                    if (BuildConfig.DEBUG) {\n                        Timber.d(\"Firebase Auth IdToken: $fireAuthTokenJWT\")\n                    }\n                    fireAuthTokenJWT\n                } else {\n                    Timber.i(\"Firebase Auth IdToken is null. Caused By ${task.exception?.message}\")\n                    \"\"\n                }\n            }\n        } else {\n            Timber.i(\"Current User is Null\")\n            Tasks.forResult(\"\")\n        }\n    }");
        return continueWith;
    }

    public static final String t(ChallengeEntryModel challengeEntryModel) {
        String item = null;
        boolean contains;
        Set set;
        item = "<this>";
        n.f(challengeEntryModel, item);
        Iterator it = challengeEntryModel.getBadges().iterator();
        while (it.hasNext()) {
            if (ChallengeRepository.Companion.a().contains((String)item)) {
                break;
            }
        }
        int i = 0;
        if ((String)item == null) {
            item = "";
        }
        return item;
    }

    private static final String t0(com.google.android.gms.tasks.j jVar) {
        int jVar2;
        String message = null;
        jVar2 = 0;
        int r0 = jVar.isSuccessful() ? jVar : jVar2;
        r0 = jVar2;
        if (jVar2 == 0) {
            Exception exception = jVar.getException();
            if (exception != null) {
                message = exception.getMessage();
            }
            a.f(n.o("Firebase Auth IdToken is null. Caused By ", message), new Object[0]);
            String str2 = "";
        }
        return jVar2;
    }

    public static final String u(ChallengeEntryVoter challengeEntryVoter) {
        String item = null;
        boolean contains;
        Set set;
        item = "<this>";
        n.f(challengeEntryVoter, item);
        Iterator it = challengeEntryVoter.getBadges().iterator();
        while (it.hasNext()) {
            if (ChallengeRepository.Companion.a().contains((String)item)) {
                break;
            }
        }
        int i = 0;
        if ((String)item == null) {
            item = "";
        }
        return item;
    }

    public static final <T> void u0(LiveData<T> liveData, q qVar, kotlin.d0.c.l<? super T, Boolean> lVar, y<T> yVar) {
        n.f(liveData, "<this>");
        n.f(qVar, "lifecycleOwner");
        n.f(lVar, "removeObserverPredicate");
        n.f(yVar, "observer");
        liveData.observe(qVar, new ExtensionsKt_removableObserve_1(yVar, lVar, liveData));
    }

    public static final String v(DogProfile dogProfile) {
        String format;
        n.f(dogProfile, "<this>");
        if (dogProfile.getBirthday() != null) {
            str = "{\n        val format = SimpleDateFormat(\"MMMM d, yyyy\", Locale.getDefault())\n        format.format(Date(birthday))\n    }";
            n.e(new SimpleDateFormat("MMMM d, yyyy", Locale.getDefault()).format(new Date(dogProfile.getBirthday().longValue(), r3)), str);
        } else {
            format = "";
        }
        return format;
    }

    public static final String v0(String str) {
        n.f(str, "<this>");
        String str7 = new Regex("[\\[\\]\\.\\#\\$]").e(str, "");
        Objects.requireNonNull(str7, "null cannot be cast to non-null type java.lang.String");
        String str8 = str7.toUpperCase();
        n.e(str8, "(this as java.lang.String).toUpperCase()");
        return str8;
    }

    public static final String w(DogProfile dogProfile) {
        String customBreed;
        String customBreed2;
        n.f(dogProfile, "<this>");
        if (dogProfile.getBreedId() != null || dogProfile.getCustomBreed() == null) {
            customBreed2 = dogProfile.getBreedTitle();
        } else {
            customBreed2 = dogProfile.getCustomBreed();
        }
        return customBreed2;
    }

    public static final String w0(String str) {
        String str2;
        n.f(str, "<this>");
        if (app.dogo.com.dogo_android.util.extensionfunction.j1.toIntervalString(str)) {
            str2 = "";
        }
        return str2;
    }

    public static final NumberFormat x(SkuDetails skuDetails) {
        n.f(skuDetails, "<this>");
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(app.dogo.com.dogo_android.util.extensionfunction.j1.getLocaleWithJapanTempFix());
        currencyInstance.setCurrency(Currency.getInstance(skuDetails.m()));
        n.e(currencyInstance, "currencyInstance");
        return currencyInstance;
    }

    public static final Integer x0(String str) {
        n.f(str, "<this>");
        try {
        } catch (Exception e) {
            a.b(e);
            e = null;
            return e;
        }
        return Integer.valueOf(Integer.parseInt(str));
    }

    public static final app.dogo.com.dogo_android.view.main_screen.h y(CardMessage cardMessage) {
        Object value = null;
        String str2;
        app.dogo.com.dogo_android.view.main_screen.h str3;
        str = "<this>";
        n.f(cardMessage, str);
        try {
            Map data = cardMessage.getData();
            if (data == null) {
                int i = 0;
            } else {
                str = "type";
                value = data.get(str);
            }
            if (value == null) {
                str2 = "";
            }
            Locale uS2 = Locale.US;
            n.e(uS2, "US");
            String str7 = str2.toUpperCase(uS2);
            n.e(str7, "(this as java.lang.String).toUpperCase(locale)");
            str3 = FiamType.valueOf(str7);
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (java.lang.IllegalArgumentException unused) {
            cardMessage = FiamType.NOT_FOUND;
        }
        return str3;
    }

    public static final void y0(RecyclerView recyclerView, NestedScrollView nestedScrollView, int i, int i2) {
        n.f(recyclerView, "<this>");
        n.f(nestedScrollView, "nestedScrollView");
        i = 0;
        recyclerView.getRootView().measure(i, i);
        app.dogo.com.dogo_android.util.extensionfunction.m0 m0Var = new app.dogo.com.dogo_android.util.extensionfunction.m0(recyclerView, i, recyclerView.getRootView().getHeight(), nestedScrollView, i2);
        recyclerView.post(m0Var);
    }

    public static final List<TrickItem> z(ProgramLessonItem programLessonItem) {
        n.f(programLessonItem, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = programLessonItem.getTrainingSession().getTrainingTricksList().iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return arrayList;
    }

    private static final void z0(RecyclerView recyclerView, int i, int i2, NestedScrollView nestedScrollView, int i3) {
        n.f(recyclerView, "$this_scrollToPositionMiddleInsideNestedView");
        n.f(nestedScrollView, "$nestedScrollView");
        if (recyclerView.getChildCount() > i) {
            float f2 = recyclerView.getY() + recyclerView.getChildAt(i).getY();
            float f5 = (float)i2;
            if (f2 > f5) {
                i4 = i2 / 2;
                int cmp = 0;
                i = (int)(f2 - (float)i4);
                nestedScrollView.H(cmp, i, i3);
            }
        }
    }

    public static /* synthetic */ void S(RecyclerView recyclerView, int i, int i2, NestedScrollView nestedScrollView, int i3) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.z0(recyclerView, i, i2, nestedScrollView, i3);
    }

    public static /* synthetic */ void T(com.google.firebase.firestore.Query query, Source source, Class cls, c0 c0Var) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.k(query, source, cls, c0Var);
    }

    public static /* synthetic */ void U(i.b.c cVar, com.google.android.gms.tasks.j jVar) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.insertDogName(cVar, jVar);
    }

    /* renamed from: V, reason: from kotlin metadata */
    public static /* synthetic */ boolean removableObserve(d.h.l.d lifecycleOwner, View removeObserverPredicate, MotionEvent observer) {
        return app.dogo.com.dogo_android.util.extensionfunction.j1.getProgramCompletionSummary(lifecycleOwner, removeObserverPredicate, observer);
    }

    public static /* synthetic */ void W(com.google.android.gms.tasks.j jVar, c0 c0Var) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.setupTouchListener(jVar, c0Var);
    }

    public static /* synthetic */ void X(c0 c0Var, com.google.android.gms.tasks.j jVar) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.R0(c0Var, jVar);
    }

    public static /* synthetic */ void Y(DocumentReference documentReference, Source source, Class cls, c0 c0Var) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.m(documentReference, source, cls, c0Var);
    }

    public static /* synthetic */ void Z(Class cls, c0 c0Var, DocumentReference documentReference, com.google.android.gms.tasks.j jVar) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.n(cls, c0Var, documentReference, jVar);
    }

    public static /* synthetic */ void a0(DatabaseReference databaseReference, c0 c0Var) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.replace(databaseReference, c0Var);
    }

    public static /* synthetic */ String b0(com.google.android.gms.tasks.j jVar) {
        return app.dogo.com.dogo_android.util.extensionfunction.j1.t0(jVar);
    }

    public static /* synthetic */ void c0(Class cls, c0 c0Var, com.google.firebase.firestore.Query query, com.google.android.gms.tasks.j jVar) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.l(cls, c0Var, query, jVar);
    }

    public static /* synthetic */ void d0(com.google.android.gms.tasks.j jVar, i.b.c cVar) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.getProgramCompletionSummary(jVar, cVar);
    }

    public static /* synthetic */ void e0(c0 c0Var, com.google.android.gms.tasks.j jVar) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.j0(c0Var, jVar);
    }

    public static /* synthetic */ void f0(Purchases purchases, c0 c0Var) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.R(purchases, c0Var);
    }

    /* renamed from: g0, reason: from kotlin metadata */
    public static /* synthetic */ void toTrickItem(FirebaseUser knowledge, AuthCredential lockedTricks, c0 isUserSubscribed) {
        app.dogo.com.dogo_android.util.extensionfunction.j1.i0(knowledge, lockedTricks, isUserSubscribed);
    }
}
