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

/* compiled from: DogoApiClient.kt */
@Metadata(d1 = "\u0000ö\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0001\u0010\u0005\u001a\u00020\u0006H'J%\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\n\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u00020\u000fH'J\u0018\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u00020\u0012H'J\u0012\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u0018\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u001b\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001b0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u0018\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u00032\u0008\u0008\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u0018\u0010 \u001a\u0008\u0012\u0004\u0012\u00020!0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u0018\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020#0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J/\u0010$\u001a\u00020%2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0018\u0010)\u001a\u0008\u0012\u0004\u0012\u00020*0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J%\u0010+\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0018\u0010-\u001a\u0008\u0012\u0004\u0012\u00020.0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\u000e\u0010/\u001a\u0008\u0012\u0004\u0012\u0002000\u0003H'J\u0011\u00101\u001a\u000202H§@ø\u0001\u0000¢\u0006\u0002\u00103J\u000e\u00104\u001a\u0008\u0012\u0004\u0012\u0002050\u0003H'J\u000e\u00106\u001a\u0008\u0012\u0004\u0012\u0002070\u0003H'J\u0018\u00108\u001a\u0008\u0012\u0004\u0012\u0002050\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u000209H'J\u0012\u0010:\u001a\u00020\u00142\u0008\u0008\u0001\u0010\u000e\u001a\u00020;H'J\u0018\u0010<\u001a\u0008\u0012\u0004\u0012\u0002050\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u00020=H'J\u0018\u0010>\u001a\u0008\u0012\u0004\u0012\u0002050\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u000200H'J\"\u0010?\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010@\u001a\u00020\u0006H'J\u001c\u0010A\u001a\u00020\u00142\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010B\u001a\u00020\u0006H'J\u000e\u0010C\u001a\u0008\u0012\u0004\u0012\u0002050\u0003H'J\"\u0010D\u001a\u0008\u0012\u0004\u0012\u0002070\u00032\u0008\u0008\u0001\u0010E\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020FH'J%\u0010G\u001a\u00020H2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020IH§@ø\u0001\u0000¢\u0006\u0002\u0010JJ/\u0010K\u001a\u00020L2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020MH§@ø\u0001\u0000¢\u0006\u0002\u0010NJ\"\u0010O\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020PH'J9\u0010Q\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010R\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010SJ\u0018\u0010T\u001a\u0008\u0012\u0004\u0012\u0002000\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u00020UH'J/\u0010V\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020WH§@ø\u0001\u0000¢\u0006\u0002\u0010XJ/\u0010Y\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020ZH§@ø\u0001\u0000¢\u0006\u0002\u0010[J\u0018\u0010\\\u001a\u0008\u0012\u0004\u0012\u0002000\u00032\u0008\u0008\u0001\u0010\u000e\u001a\u00020]H'J%\u0010^\u001a\u00020\u00162\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020_H§@ø\u0001\u0000¢\u0006\u0002\u0010`J\u001b\u0010a\u001a\u0002022\u0008\u0008\u0001\u0010\u000e\u001a\u00020bH§@ø\u0001\u0000¢\u0006\u0002\u0010cJ%\u0010d\u001a\u00020\u001b2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020eH§@ø\u0001\u0000¢\u0006\u0002\u0010fJ/\u0010g\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020eH§@ø\u0001\u0000¢\u0006\u0002\u0010hJ%\u0010i\u001a\u00020\u00082\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020jH§@ø\u0001\u0000¢\u0006\u0002\u0010kJ,\u0010l\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010@\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020mH'J9\u0010n\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020oH§@ø\u0001\u0000¢\u0006\u0002\u0010pJ9\u0010q\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020rH§@ø\u0001\u0000¢\u0006\u0002\u0010sJ/\u0010t\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020uH§@ø\u0001\u0000¢\u0006\u0002\u0010vJ/\u0010w\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020xH§@ø\u0001\u0000¢\u0006\u0002\u0010yJ%\u0010z\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020{H§@ø\u0001\u0000¢\u0006\u0002\u0010|J\u0018\u0010}\u001a\u0008\u0012\u0004\u0012\u00020#0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u0006H'J\"\u0010}\u001a\u0008\u0012\u0004\u0012\u00020#0\u00032\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020~H'J/\u0010\u007f\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010(J:\u0010\u0080\u0001\u001a\u00020,2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010R\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010SJ\u001a\u0010\u0081\u0001\u001a\u0008\u0012\u0004\u0012\u0002050\u00032\t\u0008\u0001\u0010\u000e\u001a\u00030\u0082\u0001H'J&\u0010\u0083\u0001\u001a\u00020*2\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010\u000e\u001a\u00020eH§@ø\u0001\u0000¢\u0006\u0002\u0010fJ%\u0010\u0084\u0001\u001a\u0008\u0012\u0004\u0012\u0002000\u00032\t\u0008\u0001\u0010\u0085\u0001\u001a\u00020\u00062\t\u0008\u0001\u0010\u000e\u001a\u00030\u0086\u0001H'J<\u0010\u0087\u0001\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\t\u0008\u0001\u0010\u000e\u001a\u00030\u0088\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0089\u0001J<\u0010\u008a\u0001\u001a\u0002022\u0008\u0008\u0001\u0010\t\u001a\u00020\u00062\u0008\u0008\u0001\u0010'\u001a\u00020\u00062\u0008\u0008\u0001\u0010&\u001a\u00020\u00062\t\u0008\u0001\u0010\u000e\u001a\u00030\u008b\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u008c\u0001J\u001a\u0010\u008d\u0001\u001a\u0008\u0012\u0004\u0012\u0002000\u00032\t\u0008\u0001\u0010\u000e\u001a\u00030\u008e\u0001H'J%\u0010\u008f\u0001\u001a\u0008\u0012\u0004\u0012\u0002050\u00032\t\u0008\u0001\u0010\u0090\u0001\u001a\u00020\u00062\t\u0008\u0001\u0010\u000e\u001a\u00030\u0091\u0001H'\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0092\u0001", d2 = {"Lapp/dogo/android/network/DogoApiClient;", "", "acceptDogInvite", "Lio/reactivex/Single;", "Lapp/dogo/externalmodel/model/responses/AcceptDogInviteResponse;", "inviteId", "", "clearDogProperty", "Lapp/dogo/externalmodel/model/responses/DogUpdateResponse;", "dogId", "fieldName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createDog", "Lapp/dogo/externalmodel/model/responses/DogCreateResponse;", "request", "Lapp/dogo/externalmodel/model/requests/DogCreateRequest;", "createDogInvite", "Lapp/dogo/externalmodel/model/responses/CreateDogInviteResponse;", "Lapp/dogo/externalmodel/model/requests/CreateDogInviteRequest;", "deleteDog", "Lio/reactivex/Completable;", "fetchTricksKnowledgeSingle", "Lapp/dogo/externalmodel/model/responses/GetTrickKnowledgeResponse;", "getAllProgramProgress", "Lapp/dogo/externalmodel/model/responses/AllProgramProgressResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBitingProgramProgressSingle", "Lapp/dogo/externalmodel/model/responses/BitingProgramProgressResponse;", "getDogInvite", "Lapp/dogo/externalmodel/model/responses/GetDogInviteResponse;", "getDogLogSingle", "Lapp/dogo/externalmodel/model/responses/DogLogResponse;", "getDogParents", "Lapp/dogo/externalmodel/model/responses/GetDogParentsResponse;", "getDogWorkoutTrickListAndStreakSingle", "Lapp/dogo/externalmodel/model/responses/DogWorkoutResponse;", "getExamHistory", "Lapp/dogo/externalmodel/model/responses/ExamHistoryResponse;", "programId", "trickId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPottyProgramProgressSingle", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel;", "getProgramProgress", "Lapp/dogo/externalmodel/model/responses/ClassicProgramResponse;", "getPublicDog", "Lapp/dogo/externalmodel/model/responses/PublicDogResponse;", "getRemindersSingle", "Lapp/dogo/externalmodel/model/responses/ReminderResponse;", "getTrainingTimeMetrics", "Lapp/dogo/externalmodel/model/responses/DogTrainingDurationResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserApiModelSingle", "Lapp/dogo/externalmodel/model/responses/UserApiModel;", "getUserReadArticlesSingle", "Lapp/dogo/externalmodel/model/responses/UserReadArticlesResponse;", "loginUserSingle", "Lapp/dogo/externalmodel/model/requests/UserLoginRequest;", "logoutUserSingle", "Lapp/dogo/externalmodel/model/requests/UserLogoutRequest;", "mergeUsers", "Lapp/dogo/externalmodel/model/requests/UserMergeRequest;", "migrateRemindersSingle", "removeDogLog", "logId", "removeDogParent", "parentUserId", "restoreUserPurchases", "saveArticleReadSingle", "articleId", "Lapp/dogo/externalmodel/model/requests/SaveArticleReadRequest;", "saveBitingProgramKnowledge", "Lapp/dogo/externalmodel/model/responses/BitingProgramCombinedResponse;", "Lapp/dogo/externalmodel/model/requests/SaveSpecialProgramTrickKnowledgeRequest;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/SaveSpecialProgramTrickKnowledgeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveClassicProgramTrickKnowledge", "Lapp/dogo/externalmodel/model/responses/ClassicProgramCombinedResponse;", "Lapp/dogo/externalmodel/model/requests/SaveProgramTrickKnowledgeRequest;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/SaveProgramTrickKnowledgeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDogLogSingle", "Lapp/dogo/externalmodel/model/requests/AddDogLogRequest;", "saveExamUpload", "examId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePottyReminderSingle", "Lapp/dogo/externalmodel/model/requests/PottyReminderRequest;", "saveProgramQuestion", "Lapp/dogo/externalmodel/model/requests/SaveProgramQuestionRequest;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/SaveProgramQuestionRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveProgramTask", "Lapp/dogo/externalmodel/model/requests/SaveProgramTaskRequest;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/SaveProgramTaskRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTrainingReminderSingle", "Lapp/dogo/externalmodel/model/requests/TrainingReminderRequest;", "saveTrickKnowledge", "Lapp/dogo/externalmodel/model/requests/SaveTrickKnowledgeRequest;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/SaveTrickKnowledgeRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncWorkoutStreakToTrainingMetrics", "Lapp/dogo/externalmodel/model/requests/InitialTrainingStreakSyncRequest;", "(Lapp/dogo/externalmodel/model/requests/InitialTrainingStreakSyncRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBitingProgramState", "Lapp/dogo/externalmodel/model/requests/ProgramStatusRequest;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/ProgramStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateClassicProgramState", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/ProgramStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogData", "Lapp/dogo/externalmodel/model/requests/DogUpdateRequest;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogUpdateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogLogSingle", "Lapp/dogo/externalmodel/model/requests/UpdateDogLogRequest;", "updateDogProgramTrickDuration", "Lapp/dogo/externalmodel/model/requests/DogProgramTrickDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogProgramTrickDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogProgramVariationDuration", "Lapp/dogo/externalmodel/model/requests/DogProgramVariationDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogProgramVariationDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogTrickDuration", "Lapp/dogo/externalmodel/model/requests/DogTrickDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogTrickDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogTrickVariationDuration", "Lapp/dogo/externalmodel/model/requests/DogTrickVariationDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogTrickVariationDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogWorkoutDuration", "Lapp/dogo/externalmodel/model/requests/DogWorkoutDurationRequest;", "(Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogWorkoutDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDogWorkoutStreakSingle", "Lapp/dogo/externalmodel/model/responses/DogWorkoutCompletedRequest;", "updateExamBadge", "updateExamUserFeedback", "updatePolicies", "Lapp/dogo/externalmodel/model/requests/UserPolicyUpdateRequest;", "updatePottyProgramState", "updatePottyReminderSingle", "reminderId", "Lapp/dogo/externalmodel/model/requests/PottyReminderUpdateRequest;", "updateSpecialDogProgramTrickDuration", "Lapp/dogo/externalmodel/model/requests/DogSpecialProgramTrickDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogSpecialProgramTrickDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSpecialDogProgramVariationDuration", "Lapp/dogo/externalmodel/model/requests/DogSpecialProgramVariationDurationRequest;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/externalmodel/model/requests/DogSpecialProgramVariationDurationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTrainingReminderSingle", "Lapp/dogo/externalmodel/model/requests/TrainingReminderUpdateRequest;", "updateUserDeviceData", "deviceId", "Lapp/dogo/externalmodel/model/requests/UserDeviceUpdateRequest;", "network_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public interface DogoApiClient {
    @POST("/dogs/invites/{inviteId}")
    a0<AcceptDogInviteResponse> acceptDogInvite(@Path("inviteId") String inviteId);

    @DELETE("/dogs/{dogId}/{fieldName}")
    /* suspend */ Object clearDogProperty(@Path("dogId") String dogId, @Path("fieldName") String fieldName, d<? super DogUpdateResponse> dVar);

    @POST("/dogs")
    a0<DogCreateResponse> createDog(@Body DogCreateRequest request);

    @POST("/dogs/invites/")
    a0<CreateDogInviteResponse> createDogInvite(@Body CreateDogInviteRequest request);

    @DELETE("/dogs/{dogId}")
    b deleteDog(@Path("dogId") String dogId);

    @GET("/dogs/{dogId}/tricks")
    a0<GetTrickKnowledgeResponse> fetchTricksKnowledgeSingle(@Path("dogId") String dogId);

    @GET("/dogs/{dogId}/programs/")
    /* suspend */ Object getAllProgramProgress(@Path("dogId") String dogId, d<? super AllProgramProgressResponse> dVar);

    @GET("/dogs/{dogId}/programs/id_nipping_program")
    a0<BitingProgramProgressResponse> getBitingProgramProgressSingle(@Path("dogId") String dogId);

    @GET("/dogs/invites/{inviteId}")
    a0<GetDogInviteResponse> getDogInvite(@Path("inviteId") String inviteId);

    @GET("/dogs/{dogId}/logs")
    a0<DogLogResponse> getDogLogSingle(@Path("dogId") String dogId);

    @GET("/dogs/{dogId}/parents")
    a0<GetDogParentsResponse> getDogParents(@Path("dogId") String dogId);

    @GET("/dogs/{dogId}/workout")
    a0<DogWorkoutResponse> getDogWorkoutTrickListAndStreakSingle(@Path("dogId") String dogId);

    @GET("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/exams")
    /* suspend */ Object getExamHistory(@Path("dogId") String dogId, @Path("programId") String programId, @Path("trickId") String trickId, d<? super ExamHistoryResponse> dVar);

    @GET("/dogs/{dogId}/programs/id_potty_program")
    a0<PottyProgramProgressModel> getPottyProgramProgressSingle(@Path("dogId") String dogId);

    @GET("/dogs/{dogId}/programs/{programId}")
    /* suspend */ Object getProgramProgress(@Path("dogId") String dogId, @Path("programId") String programId, d<? super ClassicProgramResponse> dVar);

    @GET("/dogs/public/{dogId}")
    a0<PublicDogResponse> getPublicDog(@Path("dogId") String dogId);

    @GET("/users/me/reminders")
    a0<ReminderResponse> getRemindersSingle();

    @GET("/users/me/training_time_metrics")
    /* suspend */ Object getTrainingTimeMetrics(d<? super DogTrainingDurationResponse> dVar);

    @GET("/users/me")
    a0<UserApiModel> getUserApiModelSingle();

    @GET("/users/me/articles")
    a0<UserReadArticlesResponse> getUserReadArticlesSingle();

    @POST("/users/me/login")
    a0<UserApiModel> loginUserSingle(@Body UserLoginRequest request);

    @POST("/users/me/logout")
    b logoutUserSingle(@Body UserLogoutRequest request);

    @POST("/users/me/merge")
    a0<UserApiModel> mergeUsers(@Body UserMergeRequest request);

    @POST("/users/me/reminders/migrate")
    a0<UserApiModel> migrateRemindersSingle(@Body ReminderResponse request);

    @DELETE("/dogs/{dogId}/logs/{logId}")
    a0<DogLogResponse> removeDogLog(@Path("dogId") String dogId, @Path("logId") String logId);

    @DELETE("/dogs/{dogId}/parents/{parentUserId}")
    b removeDogParent(@Path("dogId") String dogId, @Path("parentUserId") String parentUserId);

    @POST("/users/me/restore_purchases")
    a0<UserApiModel> restoreUserPurchases();

    @POST("/users/me/articles/{articleId}")
    a0<UserReadArticlesResponse> saveArticleReadSingle(@Path("articleId") String articleId, @Body SaveArticleReadRequest request);

    @POST("/dogs/{dogId}/programs/id_nipping_program/tricks")
    /* suspend */ Object saveBitingProgramKnowledge(@Path("dogId") String dogId, @Body SaveSpecialProgramTrickKnowledgeRequest request, d<? super BitingProgramCombinedResponse> dVar);

    @POST("/dogs/{dogId}/programs/{programId}/tricks")
    /* suspend */ Object saveClassicProgramTrickKnowledge(@Path("dogId") String dogId, @Path("programId") String programId, @Body SaveProgramTrickKnowledgeRequest request, d<? super ClassicProgramCombinedResponse> dVar);

    @POST("/dogs/{dogId}/logs")
    a0<DogLogResponse> saveDogLogSingle(@Path("dogId") String dogId, @Body AddDogLogRequest request);

    @POST("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/exam/{examId}")
    /* suspend */ Object saveExamUpload(@Path("dogId") String dogId, @Path("programId") String programId, @Path("trickId") String trickId, @Path("examId") String examId, d<? super ClassicProgramResponse> dVar);

    @POST("/users/me/reminders/potty")
    a0<ReminderResponse> savePottyReminderSingle(@Body PottyReminderRequest request);

    @POST("/dogs/{dogId}/programs/{programId}/questions")
    /* suspend */ Object saveProgramQuestion(@Path("dogId") String dogId, @Path("programId") String programId, @Body SaveProgramQuestionRequest request, d<? super ClassicProgramResponse> dVar);

    @POST("/dogs/{dogId}/programs/{programId}/tasks")
    /* suspend */ Object saveProgramTask(@Path("dogId") String dogId, @Path("programId") String programId, @Body SaveProgramTaskRequest request, d<? super ClassicProgramResponse> dVar);

    @POST("/users/me/reminders/training")
    a0<ReminderResponse> saveTrainingReminderSingle(@Body TrainingReminderRequest request);

    @POST("/dogs/{dogId}/tricks")
    /* suspend */ Object saveTrickKnowledge(@Path("dogId") String dogId, @Body SaveTrickKnowledgeRequest request, d<? super GetTrickKnowledgeResponse> dVar);

    @POST("/users/me/training_time_event_history")
    /* suspend */ Object syncWorkoutStreakToTrainingMetrics(@Body InitialTrainingStreakSyncRequest request, d<? super DogTrainingDurationResponse> dVar);

    @POST("/dogs/{dogId}/programs/id_nipping_program")
    /* suspend */ Object updateBitingProgramState(@Path("dogId") String dogId, @Body ProgramStatusRequest request, d<? super BitingProgramProgressResponse> dVar);

    @POST("/dogs/{dogId}/programs/{programId}")
    /* suspend */ Object updateClassicProgramState(@Path("dogId") String dogId, @Path("programId") String programId, @Body ProgramStatusRequest request, d<? super ClassicProgramResponse> dVar);

    @PUT("/dogs/{dogId}")
    /* suspend */ Object updateDogData(@Path("dogId") String dogId, @Body DogUpdateRequest request, d<? super DogUpdateResponse> dVar);

    @PUT("/dogs/{dogId}/logs/{id}")
    a0<DogLogResponse> updateDogLogSingle(@Path("dogId") String dogId, @Path("id") String logId, @Body UpdateDogLogRequest request);

    @POST("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/duration")
    /* suspend */ Object updateDogProgramTrickDuration(@Path("dogId") String dogId, @Path("trickId") String trickId, @Path("programId") String programId, @Body DogProgramTrickDurationRequest request, d<? super DogTrainingDurationResponse> dVar);

    @POST("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/duration")
    /* suspend */ Object updateDogProgramVariationDuration(@Path("dogId") String dogId, @Path("trickId") String trickId, @Path("programId") String programId, @Body DogProgramVariationDurationRequest request, d<? super DogTrainingDurationResponse> dVar);

    @POST("/dogs/{dogId}/tricks/{trickId}/duration")
    /* suspend */ Object updateDogTrickDuration(@Path("dogId") String dogId, @Path("trickId") String trickId, @Body DogTrickDurationRequest request, d<? super DogTrainingDurationResponse> dVar);

    @POST("/dogs/{dogId}/tricks/{trickId}/duration")
    /* suspend */ Object updateDogTrickVariationDuration(@Path("dogId") String dogId, @Path("trickId") String trickId, @Body DogTrickVariationDurationRequest request, d<? super DogTrainingDurationResponse> dVar);

    @POST("/dogs/{dogId}/workout/duration")
    /* suspend */ Object updateDogWorkoutDuration(@Path("dogId") String dogId, @Body DogWorkoutDurationRequest request, d<? super DogTrainingDurationResponse> dVar);

    @POST("/dogs/{dogId}/workout")
    a0<DogWorkoutResponse> updateDogWorkoutStreakSingle(@Path("dogId") String dogId);

    @POST("/dogs/{dogId}/workout")
    a0<DogWorkoutResponse> updateDogWorkoutStreakSingle(@Path("dogId") String str, @Body DogWorkoutCompletedRequest dogWorkoutCompletedRequest);

    @PUT("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/badge")
    /* suspend */ Object updateExamBadge(@Path("dogId") String dogId, @Path("programId") String programId, @Path("trickId") String trickId, d<? super ClassicProgramResponse> dVar);

    @PUT("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/exam/{examId}/userFeedbackSubmitted")
    /* suspend */ Object updateExamUserFeedback(@Path("dogId") String dogId, @Path("programId") String programId, @Path("trickId") String trickId, @Path("examId") String examId, d<? super ClassicProgramResponse> dVar);

    @PUT("users/me/policies")
    a0<UserApiModel> updatePolicies(@Body UserPolicyUpdateRequest request);

    @POST("/dogs/{dogId}/programs/id_potty_program")
    /* suspend */ Object updatePottyProgramState(@Path("dogId") String dogId, @Body ProgramStatusRequest request, d<? super PottyProgramProgressModel> dVar);

    @PUT("/users/me/reminders/potty/{reminderId}")
    a0<ReminderResponse> updatePottyReminderSingle(@Path("reminderId") String reminderId, @Body PottyReminderUpdateRequest request);

    @POST("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/duration")
    /* suspend */ Object updateSpecialDogProgramTrickDuration(@Path("dogId") String dogId, @Path("trickId") String trickId, @Path("programId") String programId, @Body DogSpecialProgramTrickDurationRequest request, d<? super DogTrainingDurationResponse> dVar);

    @POST("/dogs/{dogId}/programs/{programId}/tricks/{trickId}/duration")
    /* suspend */ Object updateSpecialDogProgramVariationDuration(@Path("dogId") String dogId, @Path("trickId") String trickId, @Path("programId") String programId, @Body DogSpecialProgramVariationDurationRequest request, d<? super DogTrainingDurationResponse> dVar);

    @PUT("/users/me/reminders/training")
    a0<ReminderResponse> updateTrainingReminderSingle(@Body TrainingReminderUpdateRequest request);

    @PUT("/users/me/devices/{deviceId}")
    a0<UserApiModel> updateUserDeviceData(@Path("deviceId") String deviceId, @Body UserDeviceUpdateRequest request);
}
