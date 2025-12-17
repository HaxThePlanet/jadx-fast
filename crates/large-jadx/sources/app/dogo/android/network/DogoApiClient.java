package app.dogo.android.network;

import app.dogo.externalmodel.model.PottyProgramProgressModel;
import app.dogo.externalmodel.model.requests.AddDogLogRequest;
import app.dogo.externalmodel.model.requests.CreateDogInviteRequest;
import app.dogo.externalmodel.model.requests.DogCreateRequest;
import app.dogo.externalmodel.model.requests.DogProgramTrickDurationRequest;
import app.dogo.externalmodel.model.requests.DogProgramVariationDurationRequest;
import app.dogo.externalmodel.model.requests.DogSpecialProgramTrickDurationRequest;
import app.dogo.externalmodel.model.requests.DogSpecialProgramVariationDurationRequest;
import app.dogo.externalmodel.model.requests.DogTrickDurationRequest;
import app.dogo.externalmodel.model.requests.DogTrickVariationDurationRequest;
import app.dogo.externalmodel.model.requests.DogUpdateRequest;
import app.dogo.externalmodel.model.requests.DogWorkoutDurationRequest;
import app.dogo.externalmodel.model.requests.InitialTrainingStreakSyncRequest;
import app.dogo.externalmodel.model.requests.PottyReminderRequest;
import app.dogo.externalmodel.model.requests.PottyReminderUpdateRequest;
import app.dogo.externalmodel.model.requests.ProgramStatusRequest;
import app.dogo.externalmodel.model.requests.SaveArticleReadRequest;
import app.dogo.externalmodel.model.requests.SaveProgramQuestionRequest;
import app.dogo.externalmodel.model.requests.SaveProgramTaskRequest;
import app.dogo.externalmodel.model.requests.SaveProgramTrickKnowledgeRequest;
import app.dogo.externalmodel.model.requests.SaveSpecialProgramTrickKnowledgeRequest;
import app.dogo.externalmodel.model.requests.SaveTrickKnowledgeRequest;
import app.dogo.externalmodel.model.requests.TrainingReminderRequest;
import app.dogo.externalmodel.model.requests.TrainingReminderUpdateRequest;
import app.dogo.externalmodel.model.requests.UpdateDogLogRequest;
import app.dogo.externalmodel.model.requests.UserDeviceUpdateRequest;
import app.dogo.externalmodel.model.requests.UserLoginRequest;
import app.dogo.externalmodel.model.requests.UserLogoutRequest;
import app.dogo.externalmodel.model.requests.UserMergeRequest;
import app.dogo.externalmodel.model.requests.UserPolicyUpdateRequest;
import app.dogo.externalmodel.model.responses.AcceptDogInviteResponse;
import app.dogo.externalmodel.model.responses.AllProgramProgressResponse;
import app.dogo.externalmodel.model.responses.BitingProgramCombinedResponse;
import app.dogo.externalmodel.model.responses.BitingProgramProgressResponse;
import app.dogo.externalmodel.model.responses.ClassicProgramCombinedResponse;
import app.dogo.externalmodel.model.responses.ClassicProgramResponse;
import app.dogo.externalmodel.model.responses.CreateDogInviteResponse;
import app.dogo.externalmodel.model.responses.DogCreateResponse;
import app.dogo.externalmodel.model.responses.DogLogResponse;
import app.dogo.externalmodel.model.responses.DogTrainingDurationResponse;
import app.dogo.externalmodel.model.responses.DogUpdateResponse;
import app.dogo.externalmodel.model.responses.DogWorkoutCompletedRequest;
import app.dogo.externalmodel.model.responses.DogWorkoutResponse;
import app.dogo.externalmodel.model.responses.ExamHistoryResponse;
import app.dogo.externalmodel.model.responses.GetDogInviteResponse;
import app.dogo.externalmodel.model.responses.GetDogParentsResponse;
import app.dogo.externalmodel.model.responses.GetTrickKnowledgeResponse;
import app.dogo.externalmodel.model.responses.PublicDogResponse;
import app.dogo.externalmodel.model.responses.ReminderResponse;
import app.dogo.externalmodel.model.responses.UserApiModel;
import app.dogo.externalmodel.model.responses.UserReadArticlesResponse;
import i.b.a0;
import i.b.b;
import kotlin.Metadata;
import kotlin.b0.d;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ö\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0001\u0010\u0005\u001a\u00020\u0006H'J%\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\n\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u00020\u000fH'J\u0018\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u00020\u0012H'J\u0012\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u0018\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u001b\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u0018\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u00032\u0008\u0008\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u0018\u0010 \u001a\u0008\u0012\u0004\u0012\u00020!0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u0018\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020#0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J/\u0010$\u001a\u00020%2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u0008\u0012\u0004\u0012\u00020*0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J%\u0010+\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0018\u0010-\u001a\u0008\u0012\u0004\u0012\u00020.0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u000e\u0010/\u001a\u0008\u0012\u0004\u0012\u0002000\u0003H'J\u0011\u00101\u001a\u000202H§@ø\u0001\u0000¢\u0006\u0002\u00103J\u000e\u00104\u001a\u0008\u0012\u0004\u0012\u0002050\u0003H'J\u000e\u00106\u001a\u0008\u0012\u0004\u0012\u0002070\u0003H'J\u0018\u00108\u001a\u0008\u0012\u0004\u0012\u0002050\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u000209H'J\u0012\u0010:\u001a\u00020\u00142\u0008\u0008\u0001\u0010\u000e\u001a\u00020;H'J\u0018\u0010<\u001a\u0008\u0012\u0004\u0012\u0002050\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u00020=H'J\u0018\u0010>\u001a\u0008\u0012\u0004\u0012\u0002050\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u000200H'J\"\u0010?\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010@\u001a\u00020\u0006H'J\u001c\u0010A\u001a\u00020\u00142\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010B\u001a\u00020\u0006H'J\u000e\u0010C\u001a\u0008\u0012\u0004\u0012\u0002050\u0003H'J\"\u0010D\u001a\u0008\u0012\u0004\u0012\u0002070\u00032\u0008\u0008\u0001\u0010E\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020FH'J%\u0010G\u001a\u00020H2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020IH§@ø\u0001\u0000¢\u0006\u0002\u0010JJ/\u0010K\u001a\u00020L2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020MH§@ø\u0001\u0000¢\u0006\u0002\u0010NJ\"\u0010O\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020PH'J9\u0010Q\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010R\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010SJ\u0018\u0010T\u001a\u0008\u0012\u0004\u0012\u0002000\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u00020UH'J/\u0010V\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020WH§@ø\u0001\u0000¢\u0006\u0002\u0010XJ/\u0010Y\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020ZH§@ø\u0001\u0000¢\u0006\u0002\u0010[J\u0018\u0010\\\u001a\u0008\u0012\u0004\u0012\u0002000\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u00020]H'J%\u0010^\u001a\u00020\u00162\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020_H§@ø\u0001\u0000¢\u0006\u0002\u0010`J\u001b\u0010a\u001a\u0002022\u0008\u0008\u0001\u0010\u000e\u001a\u00020bH§@ø\u0001\u0000¢\u0006\u0002\u0010cJ%\u0010d\u001a\u00020\u001b2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020eH§@ø\u0001\u0000¢\u0006\u0002\u0010fJ/\u0010g\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020eH§@ø\u0001\u0000¢\u0006\u0002\u0010hJ%\u0010i\u001a\u00020\u00082\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020jH§@ø\u0001\u0000¢\u0006\u0002\u0010kJ,\u0010l\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010@\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020mH'J9\u0010n\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020oH§@ø\u0001\u0000¢\u0006\u0002\u0010pJ9\u0010q\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020rH§@ø\u0001\u0000¢\u0006\u0002\u0010sJ/\u0010t\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020uH§@ø\u0001\u0000¢\u0006\u0002\u0010vJ/\u0010w\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020xH§@ø\u0001\u0000¢\u0006\u0002\u0010yJ%\u0010z\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020{H§@ø\u0001\u0000¢\u0006\u0002\u0010|J\u0018\u0010}\u001a\u0008\u0012\u0004\u0012\u00020#0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\"\u0010}\u001a\u0008\u0012\u0004\u0012\u00020#0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020~H'J/\u0010\u007f\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010(J:\u0010\u0080\u0001\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010R\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010SJ\u001a\u0010\u0081\u0001\u001a\u0008\u0012\u0004\u0012\u0002050\u00032\t\u0008\u0001\u0010\u000e\u001a\u00030\u0082\u0001H'J&\u0010\u0083\u0001\u001a\u00020*2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020eH§@ø\u0001\u0000¢\u0006\u0002\u0010fJ%\u0010\u0084\u0001\u001a\u0008\u0012\u0004\u0012\u0002000\u00032\t\u0008\u0001\u0010\u0085\u0001\u001a\u00020\u00062\t\u0008\u0001\u0010\u000e\u001a\u00030\u0086\u0001H'J<\u0010\u0087\u0001\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\t\u0008\u0001\u0010\u000e\u001a\u00030\u0088\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0089\u0001J<\u0010\u008a\u0001\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\t\u0008\u0001\u0010\u000e\u001a\u00030\u008b\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u008c\u0001J\u001a\u0010\u008d\u0001\u001a\u0008\u0012\u0004\u0012\u0002000\u00032\t\u0008\u0001\u0010\u000e\u001a\u00030\u008e\u0001H'J%\u0010\u008f\u0001\u001a\u0008\u0012\u0004\u0012\u0002050\u00032\t\u0008\u0001\u0010\u0090\u0001\u001a\u00020\u00062\t\u0008\u0001\u0010\u000e\u001a\u00030\u0091\u0001H'\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0092\u0001", d2 = {"Lapp/dogo/android/network/DogoApiClient;", "", "acceptDogInvite", "Lio/reactivex/Single;", "Lapp/dogo/externalmodel/model/responses/AcceptDogInviteResponse;", "inviteId", "", "clearDogProperty", "Lapp/dogo/externalmodel/model/responses/DogUpdateResponse;", "dogId", "fieldName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDog", "Lapp/dogo/externalmodel/model/responses/DogCreateResponse;", "request", "Lapp/dogo/externalmodel/model/requests/DogCreateRequest;", "createDogInvite", "Lapp/dogo/externalmodel/model/responses/CreateDogInviteResponse;", "Lapp/dogo/externalmodel/model/requests/CreateDogInviteRequest;", "deleteDog", "Lio/reactivex/Completable;", "fetchTricksKnowledgeSingle", "Lapp/dogo/externalmodel/model/responses/GetTrickKnowledgeResponse;", "getAllProgramProgress", "Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBitingProgramProgressSingle", "Lapp/dogo/externalmodel/model/responses/BitingProgramProgressResponse;", "getDogInvite", "Lapp/dogo/externalmodel/model/responses/GetDogInviteResponse;", "getDogLogSingle", "Lapp/dogo/externalmodel/model/responses/DogLogResponse;", "getDogParents", "Lapp/dogo/externalmodel/model/responses/GetDogParentsResponse;", "getDogWorkoutTrickListAndStreakSingle", "Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse;", "getExamHistory", "Lapp/dogo/externalmodel/model/responses/ExamHistoryResponse;", "programId", "trickId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPottyProgramProgressSingle", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel;", "getProgramProgress", "Lapp/dogo/externalmodel/model/responses/ClassicProgramResponse;", "getPublicDog", "Lapp/dogo/externalmodel/model/responses/PublicDogResponse;", "getRemindersSingle", "Lapp/dogo/externalmodel/model/responses/ReminderResponse;", "getTrainingTimeMetrics", "Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserApiModelSingle", "Lapp/dogo/externalmodel/model/responses/UserApiModel;", "getUserReadArticlesSingle", "Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse;", "loginUserSingle", "Lapp/dogo/externalmodel/model/requests/UserLoginRequest;", "logoutUserSingle", "Lapp/dogo/externalmodel/model/requests/UserLogoutRequest;", "mergeUsers", "Lapp/dogo/externalmodel/model/requests/UserMergeRequest;", "migrateRemindersSingle", "removeDogLog", "logId", "removeDogParent", "parentUserId", "restoreUserPurchases", "saveArticleReadSingle", "articleId", "Lapp/dogo/externalmodel/model/requests/SaveArticleReadRequest;", "saveBitingProgramKnowledge", "Lapp/dogo/externalmodel/model/responses/BitingProgramCombinedResponse;", "Lapp/dogo/externalmodel/model/requests/SaveSpecialProgramTrickKnowledgeRequest;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/SaveSpecialProgramTrickKnowledgeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveClassicProgramTrickKnowledge", "Lapp/dogo/externalmodel/model/responses/ClassicProgramCombinedResponse;", "Lapp/dogo/externalmodel/model/requests/SaveProgramTrickKnowledgeRequest;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/SaveProgramTrickKnowledgeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDogLogSingle", "Lapp/dogo/externalmodel/model/requests/AddDogLogRequest;", "saveExamUpload", "examId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePottyReminderSingle", "Lapp/dogo/externalmodel/model/requests/PottyReminderRequest;", "saveProgramQuestion", "Lapp/dogo/externalmodel/model/requests/SaveProgramQuestionRequest;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/SaveProgramQuestionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveProgramTask", "Lapp/dogo/externalmodel/model/requests/SaveProgramTaskRequest;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/SaveProgramTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTrainingReminderSingle", "Lapp/dogo/externalmodel/model/requests/TrainingReminderRequest;", "saveTrickKnowledge", "Lapp/dogo/externalmodel/model/requests/SaveTrickKnowledgeRequest;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/SaveTrickKnowledgeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncWorkoutStreakToTrainingMetrics", "Lapp/dogo/externalmodel/model/requests/InitialTrainingStreakSyncRequest;", "(Lapp/dogo/externalmodel/model/requests/InitialTrainingStreakSyncRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBitingProgramState", "Lapp/dogo/externalmodel/model/requests/ProgramStatusRequest;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/ProgramStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateClassicProgramState", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/ProgramStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogData", "Lapp/dogo/externalmodel/model/requests/DogUpdateRequest;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogUpdateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogLogSingle", "Lapp/dogo/externalmodel/model/requests/UpdateDogLogRequest;", "updateDogProgramTrickDuration", "Lapp/dogo/externalmodel/model/requests/DogProgramTrickDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogProgramTrickDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogProgramVariationDuration", "Lapp/dogo/externalmodel/model/requests/DogProgramVariationDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogProgramVariationDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogTrickDuration", "Lapp/dogo/externalmodel/model/requests/DogTrickDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogTrickDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogTrickVariationDuration", "Lapp/dogo/externalmodel/model/requests/DogTrickVariationDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogTrickVariationDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogWorkoutDuration", "Lapp/dogo/externalmodel/model/requests/DogWorkoutDurationRequest;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogWorkoutDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogWorkoutStreakSingle", "Lapp/dogo/externalmodel/model/responses/DogWorkoutCompletedRequest;", "updateExamBadge", "updateExamUserFeedback", "updatePolicies", "Lapp/dogo/externalmodel/model/requests/UserPolicyUpdateRequest;", "updatePottyProgramState", "updatePottyReminderSingle", "reminderId", "Lapp/dogo/externalmodel/model/requests/PottyReminderUpdateRequest;", "updateSpecialDogProgramTrickDuration", "Lapp/dogo/externalmodel/model/requests/DogSpecialProgramTrickDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogSpecialProgramTrickDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSpecialDogProgramVariationDuration", "Lapp/dogo/externalmodel/model/requests/DogSpecialProgramVariationDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogSpecialProgramVariationDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTrainingReminderSingle", "Lapp/dogo/externalmodel/model/requests/TrainingReminderUpdateRequest;", "updateUserDeviceData", "deviceId", "Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest;", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface DogoApiClient {
    @POST("/dogs/invites/{inviteId}")
    public abstract a0<AcceptDogInviteResponse> acceptDogInvite(String string);

    @DELETE("/dogs/{dogId}/{fieldName}")
    public abstract Object clearDogProperty(String string, String string2, d<? super DogUpdateResponse> d3);

    @POST("/dogs")
    public abstract a0<DogCreateResponse> createDog(DogCreateRequest dogCreateRequest);

    @POST("/dogs/invites/")
    public abstract a0<CreateDogInviteResponse> createDogInvite(CreateDogInviteRequest createDogInviteRequest);

    @DELETE("/dogs/{dogId}")
    public abstract b deleteDog(String string);

    @GET("/dogs/{dogId}/tricks")
    public abstract a0<GetTrickKnowledgeResponse> fetchTricksKnowledgeSingle(String string);

    @GET("/dogs/{dogId}/programs/")
    public abstract Object getAllProgramProgress(String string, d<? super AllProgramProgressResponse> d2);

    @GET("/dogs/{dogId}/programs/id_nipping_program")
    public abstract a0<BitingProgramProgressResponse> getBitingProgramProgressSingle(String string);

    @GET("/dogs/invites/{inviteId}")
    public abstract a0<GetDogInviteResponse> getDogInvite(String string);

    @GET("/dogs/{dogId}/logs")
    public abstract a0<DogLogResponse> getDogLogSingle(String string);

    @GET("/dogs/{dogId}/parents")
    public abstract a0<GetDogParentsResponse> getDogParents(String string);

    @GET("/dogs/{dogId}/workout")
    public abstract a0<DogWorkoutResponse> getDogWorkoutTrickListAndStreakSingle(String string);

    @GET("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/exams")
    public abstract Object getExamHistory(String string, String string2, String string3, d<? super ExamHistoryResponse> d4);

    @GET("/dogs/{dogId}/programs/id_potty_program")
    public abstract a0<PottyProgramProgressModel> getPottyProgramProgressSingle(String string);

    @GET("/dogs/{dogId}/programs/{programId}")
    public abstract Object getProgramProgress(String string, String string2, d<? super ClassicProgramResponse> d3);

    @GET("/dogs/public/{dogId}")
    public abstract a0<PublicDogResponse> getPublicDog(String string);

    @GET("/users/me/reminders")
    public abstract a0<ReminderResponse> getRemindersSingle();

    @GET("/users/me/training_time_metrics")
    public abstract Object getTrainingTimeMetrics(d<? super DogTrainingDurationResponse> d);

    @GET("/users/me")
    public abstract a0<UserApiModel> getUserApiModelSingle();

    @GET("/users/me/articles")
    public abstract a0<UserReadArticlesResponse> getUserReadArticlesSingle();

    @POST("/users/me/login")
    public abstract a0<UserApiModel> loginUserSingle(UserLoginRequest userLoginRequest);

    @POST("/users/me/logout")
    public abstract b logoutUserSingle(UserLogoutRequest userLogoutRequest);

    @POST("/users/me/merge")
    public abstract a0<UserApiModel> mergeUsers(UserMergeRequest userMergeRequest);

    @POST("/users/me/reminders/migrate")
    public abstract a0<UserApiModel> migrateRemindersSingle(ReminderResponse reminderResponse);

    @DELETE("/dogs/{dogId}/logs/{logId}")
    public abstract a0<DogLogResponse> removeDogLog(String string, String string2);

    @DELETE("/dogs/{dogId}/parents/{parentUserId}")
    public abstract b removeDogParent(String string, String string2);

    @POST("/users/me/restore_purchases")
    public abstract a0<UserApiModel> restoreUserPurchases();

    @POST("/users/me/articles/{articleId}")
    public abstract a0<UserReadArticlesResponse> saveArticleReadSingle(String string, SaveArticleReadRequest saveArticleReadRequest2);

    @POST("/dogs/{dogId}/programs/id_nipping_program/tricks")
    public abstract Object saveBitingProgramKnowledge(String string, SaveSpecialProgramTrickKnowledgeRequest saveSpecialProgramTrickKnowledgeRequest2, d<? super BitingProgramCombinedResponse> d3);

    @POST("/dogs/{dogId}/programs/{programId}/tricks")
    public abstract Object saveClassicProgramTrickKnowledge(String string, String string2, SaveProgramTrickKnowledgeRequest saveProgramTrickKnowledgeRequest3, d<? super ClassicProgramCombinedResponse> d4);

    @POST("/dogs/{dogId}/logs")
    public abstract a0<DogLogResponse> saveDogLogSingle(String string, AddDogLogRequest addDogLogRequest2);

    @POST("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/exam/{examId}")
    public abstract Object saveExamUpload(String string, String string2, String string3, String string4, d<? super ClassicProgramResponse> d5);

    @POST("/users/me/reminders/potty")
    public abstract a0<ReminderResponse> savePottyReminderSingle(PottyReminderRequest pottyReminderRequest);

    @POST("/dogs/{dogId}/programs/{programId}/questions")
    public abstract Object saveProgramQuestion(String string, String string2, SaveProgramQuestionRequest saveProgramQuestionRequest3, d<? super ClassicProgramResponse> d4);

    @POST("/dogs/{dogId}/programs/{programId}/tasks")
    public abstract Object saveProgramTask(String string, String string2, SaveProgramTaskRequest saveProgramTaskRequest3, d<? super ClassicProgramResponse> d4);

    @POST("/users/me/reminders/training")
    public abstract a0<ReminderResponse> saveTrainingReminderSingle(TrainingReminderRequest trainingReminderRequest);

    @POST("/dogs/{dogId}/tricks")
    public abstract Object saveTrickKnowledge(String string, SaveTrickKnowledgeRequest saveTrickKnowledgeRequest2, d<? super GetTrickKnowledgeResponse> d3);

    @POST("/users/me/training_time_event_history")
    public abstract Object syncWorkoutStreakToTrainingMetrics(InitialTrainingStreakSyncRequest initialTrainingStreakSyncRequest, d<? super DogTrainingDurationResponse> d2);

    @POST("/dogs/{dogId}/programs/id_nipping_program")
    public abstract Object updateBitingProgramState(String string, ProgramStatusRequest programStatusRequest2, d<? super BitingProgramProgressResponse> d3);

    @POST("/dogs/{dogId}/programs/{programId}")
    public abstract Object updateClassicProgramState(String string, String string2, ProgramStatusRequest programStatusRequest3, d<? super ClassicProgramResponse> d4);

    @PUT("/dogs/{dogId}")
    public abstract Object updateDogData(String string, DogUpdateRequest dogUpdateRequest2, d<? super DogUpdateResponse> d3);

    @PUT("/dogs/{dogId}/logs/{id}")
    public abstract a0<DogLogResponse> updateDogLogSingle(String string, String string2, UpdateDogLogRequest updateDogLogRequest3);

    @POST("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/duration")
    public abstract Object updateDogProgramTrickDuration(String string, String string2, String string3, DogProgramTrickDurationRequest dogProgramTrickDurationRequest4, d<? super DogTrainingDurationResponse> d5);

    @POST("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/duration")
    public abstract Object updateDogProgramVariationDuration(String string, String string2, String string3, DogProgramVariationDurationRequest dogProgramVariationDurationRequest4, d<? super DogTrainingDurationResponse> d5);

    @POST("/dogs/{dogId}/tricks/{trickId}/duration")
    public abstract Object updateDogTrickDuration(String string, String string2, DogTrickDurationRequest dogTrickDurationRequest3, d<? super DogTrainingDurationResponse> d4);

    @POST("/dogs/{dogId}/tricks/{trickId}/duration")
    public abstract Object updateDogTrickVariationDuration(String string, String string2, DogTrickVariationDurationRequest dogTrickVariationDurationRequest3, d<? super DogTrainingDurationResponse> d4);

    @POST("/dogs/{dogId}/workout/duration")
    public abstract Object updateDogWorkoutDuration(String string, DogWorkoutDurationRequest dogWorkoutDurationRequest2, d<? super DogTrainingDurationResponse> d3);

    @POST("/dogs/{dogId}/workout")
    public abstract a0<DogWorkoutResponse> updateDogWorkoutStreakSingle(String string);

    @POST("/dogs/{dogId}/workout")
    public abstract a0<DogWorkoutResponse> updateDogWorkoutStreakSingle(String string, DogWorkoutCompletedRequest dogWorkoutCompletedRequest2);

    @PUT("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/badge")
    public abstract Object updateExamBadge(String string, String string2, String string3, d<? super ClassicProgramResponse> d4);

    @PUT("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/exam/{examId}/userFeedbackSubmitted")
    public abstract Object updateExamUserFeedback(String string, String string2, String string3, String string4, d<? super ClassicProgramResponse> d5);

    @PUT("users/me/policies")
    public abstract a0<UserApiModel> updatePolicies(UserPolicyUpdateRequest userPolicyUpdateRequest);

    @POST("/dogs/{dogId}/programs/id_potty_program")
    public abstract Object updatePottyProgramState(String string, ProgramStatusRequest programStatusRequest2, d<? super PottyProgramProgressModel> d3);

    @PUT("/users/me/reminders/potty/{reminderId}")
    public abstract a0<ReminderResponse> updatePottyReminderSingle(String string, PottyReminderUpdateRequest pottyReminderUpdateRequest2);

    @POST("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/duration")
    public abstract Object updateSpecialDogProgramTrickDuration(String string, String string2, String string3, DogSpecialProgramTrickDurationRequest dogSpecialProgramTrickDurationRequest4, d<? super DogTrainingDurationResponse> d5);

    @POST("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/duration")
    public abstract Object updateSpecialDogProgramVariationDuration(String string, String string2, String string3, DogSpecialProgramVariationDurationRequest dogSpecialProgramVariationDurationRequest4, d<? super DogTrainingDurationResponse> d5);

    @PUT("/users/me/reminders/training")
    public abstract a0<ReminderResponse> updateTrainingReminderSingle(TrainingReminderUpdateRequest trainingReminderUpdateRequest);

    @PUT("/users/me/devices/{deviceId}")
    public abstract a0<UserApiModel> updateUserDeviceData(String string, UserDeviceUpdateRequest userDeviceUpdateRequest2);
}
