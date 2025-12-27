package app.dogo.com.dogo_android.util.e0;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import app.dogo.com.dogo_android.dogcreation.f;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.o;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.model.LiteDogProfile;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.service.PhotoUploadNotificationService;
import app.dogo.com.dogo_android.service.PhotoUploadNotificationService.a;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.subscription.SubscriptionScreenKey;
import app.dogo.com.dogo_android.t.h0.k;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.util.i0.b;
import app.dogo.com.dogo_android.util.q;
import app.dogo.com.dogo_android.util.q.b;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import app.dogo.com.dogo_android.util.u;
import app.dogo.com.dogo_android.util.u.a;
import app.dogo.com.dogo_android.util.u.b;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.y.p;

/* compiled from: Navigator.kt */
@Metadata(d1 = "\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008&\u0018\u0000 Ô\u00012\u00020\u0001:\u0002Ô\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0014J\u001c\u0010R\u001a\u00020O2\u0006\u0010S\u001a\u00020T2\n\u0008\u0002\u0010U\u001a\u0004\u0018\u00010\u0007H\u0007J\u0006\u0010V\u001a\u00020OJ\"\u0010W\u001a\u00020O2\u0006\u0010X\u001a\u00020;2\u0006\u0010Y\u001a\u00020;2\u0008\u0010Z\u001a\u0004\u0018\u00010\u0016H\u0002J\u000e\u0010[\u001a\u00020O2\u0006\u0010\\\u001a\u00020\u0016J\u000e\u0010]\u001a\u00020O2\u0006\u0010\\\u001a\u00020\u0016J\u001c\u0010^\u001a\u0004\u0018\u00010\u000e2\u0006\u0010S\u001a\u00020\u00122\u0008\u0010U\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010_\u001a\u00020O2\u0006\u0010S\u001a\u00020TJ\u0006\u0010`\u001a\u00020OJ\u0006\u0010a\u001a\u00020OJ\u0008\u0010b\u001a\u00020OH\u0016J\u0010\u0010c\u001a\u00020O2\u0008\u0010d\u001a\u0004\u0018\u00010eJ\u0008\u0010f\u001a\u00020;H\u0014J\u0008\u0010g\u001a\u00020;H\u0016J\u0008\u0010h\u001a\u00020;H\u0016J\n\u0010i\u001a\u0004\u0018\u00010jH&J\n\u0010k\u001a\u0004\u0018\u00010\u001bH&J\u0008\u0010l\u001a\u00020OH\u0016J\u0006\u0010m\u001a\u00020OJ\u0006\u0010n\u001a\u00020 J\u001a\u0010o\u001a\u00020O2\u0008\u0008\u0002\u0010X\u001a\u00020;2\u0006\u0010p\u001a\u00020\u001bH\u0007J\"\u0010q\u001a\u00020O2\u0006\u0010X\u001a\u00020;2\u0006\u0010Y\u001a\u00020;2\u0008\u0010Z\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010r\u001a\u00020O2\u0006\u0010s\u001a\u00020,H\u0016J\u0008\u0010t\u001a\u00020OH\u0016J\u0012\u0010u\u001a\u00020O2\u0008\u0010v\u001a\u0004\u0018\u00010\u0007H\u0014J\u0008\u0010w\u001a\u00020OH\u0016J\u0010\u0010x\u001a\u00020 2\u0006\u0010y\u001a\u00020zH\u0016J\u0008\u0010{\u001a\u00020OH\u0014J/\u0010|\u001a\u00020O2\u0006\u0010X\u001a\u00020;2\u000e\u0010}\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0~2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0016¢\u0006\u0003\u0010\u0081\u0001J\t\u0010\u0082\u0001\u001a\u00020OH\u0014J\u0012\u0010\u0083\u0001\u001a\u00020O2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0085\u0001\u001a\u00020OH\u0016J\t\u0010\u0086\u0001\u001a\u00020OH\u0016J\u0011\u0010\u0087\u0001\u001a\u00020O2\u0008\u0010\u0088\u0001\u001a\u00030\u0089\u0001J\u0012\u0010\u008a\u0001\u001a\u00020O2\u0007\u0010\u008b\u0001\u001a\u00020 H\u0016J\u0010\u0010\u008c\u0001\u001a\u00020O2\u0007\u0010\u008d\u0001\u001a\u00020 J\u0014\u0010\u008e\u0001\u001a\u00020O2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u0090\u0001\u001a\u00020OH\u0002J\u001d\u0010\u0091\u0001\u001a\u00020O2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001bJ#\u0010\u0094\u0001\u001a\u00020O2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u000e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0098\u0001J#\u0010\u0094\u0001\u001a\u00020O2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u000e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0098\u0001J\u001f\u0010\u009b\u0001\u001a\u00020O2\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00012\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001J)\u0010 \u0001\u001a\u00020O2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u001b2\n\u0010£\u0001\u001a\u0005\u0018\u00010\u009d\u0001J\u0011\u0010¤\u0001\u001a\u00020O2\u0008\u0010¥\u0001\u001a\u00030\u009f\u0001J\u001d\u0010¤\u0001\u001a\u00020O2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001bJ&\u0010¨\u0001\u001a\u00020O2\u0007\u0010©\u0001\u001a\u00020\u001b2\u0007\u0010ª\u0001\u001a\u00020 2\t\u0008\u0002\u0010«\u0001\u001a\u00020\u001bH\u0002J\u0019\u0010¨\u0001\u001a\u00020O2\u0007\u0010©\u0001\u001a\u00020\u001b2\u0007\u0010«\u0001\u001a\u00020\u001bJ5\u0010¬\u0001\u001a\u00020O2\n\u0010­\u0001\u001a\u0005\u0018\u00010®\u00012\n\u0010¯\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010°\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u001bJ\u001d\u0010±\u0001\u001a\u00020O2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001bJ\t\u0010²\u0001\u001a\u00020OH\u0016J(\u0010³\u0001\u001a\u00020O2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001bJ4\u0010´\u0001\u001a\u00020O2\u0007\u0010µ\u0001\u001a\u00020\u001b2\u000b\u0008\u0002\u0010¶\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010·\u0001\u001a\u00020;2\u000c\u0008\u0002\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001J\u0011\u0010º\u0001\u001a\u00020O2\u0008\u0008\u0001\u0010d\u001a\u00020;J\u0011\u0010º\u0001\u001a\u00020O2\u0008\u0010d\u001a\u0004\u0018\u00010\u001bJ\u0013\u0010»\u0001\u001a\u00020O2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010¼\u0001J\u001c\u0010½\u0001\u001a\u00020O2\u000b\u0008\u0002\u0010¾\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010X\u001a\u00020;J.\u0010½\u0001\u001a\u00020O2\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010X\u001a\u00020;2\u0007\u0010ª\u0001\u001a\u00020 2\t\u0010¿\u0001\u001a\u0004\u0018\u00010\u001bJ!\u0010À\u0001\u001a\u00020O2\u0007\u0010¾\u0001\u001a\u00020\u001b2\u0007\u0010¿\u0001\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020;J\t\u0010Á\u0001\u001a\u00020OH\u0002J\"\u0010Á\u0001\u001a\u00020O2\u0007\u0010Â\u0001\u001a\u00020 2\u0007\u0010Ã\u0001\u001a\u00020;2\u0007\u0010Ä\u0001\u001a\u00020;J\u0007\u0010Å\u0001\u001a\u00020OJ8\u0010Æ\u0001\u001a\u00020O2\u0006\u0010p\u001a\u00020\u001b2\u0008\u0010X\u001a\u0004\u0018\u00010;2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u001b2\n\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001H\u0002¢\u0006\u0003\u0010Ê\u0001J*\u0010Æ\u0001\u001a\u00020O2\u0006\u0010p\u001a\u00020\u001b2\u000b\u0008\u0002\u0010Ç\u0001\u001a\u0004\u0018\u00010\u001b2\u000c\u0008\u0002\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001J\u0012\u0010Ë\u0001\u001a\u00020O2\u0007\u0010Ì\u0001\u001a\u00020\u0012H\u0016J\u001a\u0010Ë\u0001\u001a\u00020O2\u0007\u0010Ì\u0001\u001a\u00020\u00122\u0008\u0010U\u001a\u0004\u0018\u00010\u0007J0\u0010Í\u0001\u001a\u00020O2\u0007\u0010Ì\u0001\u001a\u00020\u00122\u0008\u0010U\u001a\u0004\u0018\u00010\u00072\t\u0008\u0002\u0010Î\u0001\u001a\u00020;2\t\u0008\u0002\u0010Ï\u0001\u001a\u00020;J3\u0010Í\u0001\u001a\u00020O2\u0008\u0010Ì\u0001\u001a\u00030Ð\u00012\u0008\u0010U\u001a\u0004\u0018\u00010\u00072\t\u0008\u0002\u0010Î\u0001\u001a\u00020;2\t\u0008\u0002\u0010Ï\u0001\u001a\u00020;H\u0007J\u001b\u0010Ñ\u0001\u001a\u00020O2\u0008\u0010Ò\u0001\u001a\u00030Ó\u00012\u0006\u0010S\u001a\u00020TH\u0002R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0014R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010!R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010!\"\u0004\u0008$\u0010%R\u001a\u0010&\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010!\"\u0004\u0008'\u0010%R\u0014\u0010(\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008(\u0010!R\u001c\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010*0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\u0008-\u0010.R\u001a\u0010/\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u0010!\"\u0004\u00081\u0010%R\u001a\u00102\u001a\u00020 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00083\u0010!\"\u0004\u00084\u0010%R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00088\u0010!\"\u0004\u00089\u0010%R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008@\u0010!\"\u0004\u0008A\u0010%R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010D\u001a\u0004\u0018\u00010E8F¢\u0006\u0006\u001a\u0004\u0008F\u0010GR\u001e\u0010H\u001a\u000e\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010J\u0018\u00010IX¦\u0004¢\u0006\u0006\u001a\u0004\u0008K\u0010LR\u0010\u0010M\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Õ\u0001", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "Landroidx/appcompat/app/AppCompatActivity;", "mockChannel", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel;", "(Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel;)V", "()V", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "setArguments", "(Landroid/os/Bundle;)V", "communicationChannel", "currentFragment", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseNavFragment;", "getCurrentFragment", "()Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseNavFragment;", "currentFragmentTag", "Lapp/dogo/com/dogo_android/enums/FragmentTags;", "getCurrentFragmentTag", "()Lapp/dogo/com/dogo_android/enums/FragmentTags;", "dataToPass", "Landroid/content/Intent;", "defaultFragmentTag", "getDefaultFragmentTag", "entryCreationSavedData", "", "", "", "imageCropper", "Lapp/dogo/com/dogo_android/util/ImageCropper;", "isBackStackEmptyOr1Item", "", "()Z", "isDoCreationLaunched", "isFragmentsResumed", "setFragmentsResumed", "(Z)V", "isLoading", "setLoading", "isResultActivityLaunched", "lastCallTimeTracker", "", "lastFragment", "Landroidx/fragment/app/Fragment;", "getLastFragment", "()Landroidx/fragment/app/Fragment;", "loadingDialogShowed", "getLoadingDialogShowed", "setLoadingDialogShowed", "loginLaunched", "getLoginLaunched", "setLoginLaunched", "mBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "newDataToPass", "getNewDataToPass", "setNewDataToPass", "requestCodeToPass", "", "resultCodeToPass", "snackbar", "Lcom/google/android/material/snackbar/Snackbar;", "startEntryCreationFlag", "getStartEntryCreationFlag", "setStartEntryCreationFlag", "toast", "Landroid/widget/Toast;", "viewModel", "Landroidx/lifecycle/ViewModel;", "getViewModel", "()Landroidx/lifecycle/ViewModel;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "vm", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "callDialog", "tag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "bundle", "callLoadingDialog", "callTopFragmentOnActivityResults", "requestCode", "resultCode", "data", "changeToChallengeFromNotification", "intent", "changeToShareDialog", "createAndLoadViewFragment", "dismissDialog", "dismissLoadingDialog", "dismissSnackbar", "emergencyExit", "emitFragmentMessage", "message", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$MessageHolder;", "getDefaultStatusBarColor", "getNavBarVisibility", "getNavSize", "getTag", "Lapp/dogo/com/dogo_android/enums/NavigatorTags;", "getTrackingTag", "hideNavigation", "hideSoftKeyboard", "isConnectedToInternet", "launchLogInActivity", "viewSource", "onActivityResult", "onAttachFragment", "fragment", "onBackPressed", "onCreate", "savedInstanceState", "onEmptyBackStack", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResumeFragments", "onSaveInstanceState", "outState", "onStart", "onStop", "registerToChannel", "endpoint", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$ChannelListener;", "setHomeUpVisible", "hasParent", "setLoadingState", "state", "setTitle", "title", "setupBroadcaster", "showChallengeFromNotification", "challengeId", "linkType", "showChallengeProfileDialog", "dogProfileModel", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "badges", "", "dogProfile", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "showChallengeShareDialog", "bitmap", "Landroid/net/Uri;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "showChallengeWithCreationStarted", "id", "newDogId", "welcomeParticipationUri", "showCommentDialog", "entryModel", "entryId", "commentId", "showDogSelectDialog", "requestKey", "skipWelcomeSuggestion", "sourceScreenName", "showEntryCreationDialog", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "selectedDog", "comment", "showFanList", "showNavigation", "showSharedImageDialog", "showSnackbar", "snackBarText", "snackBarActionText", "duration", "listener", "Landroid/view/View$OnClickListener;", "showToast", "showVideoPlaybackFullscreenFragment", "Lapp/dogo/com/dogo_android/model/Exam;", "startDogCreation", "dogId", "dogName", "startDogUpdateFlow", "startImageCropper", "shapeOval", "minimumX", "minimumY", "startOvalImageCropperWithNoSizeRestrictions", "startSubscriptionActivity", "lessonId", "subscriptionOffer", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;)V", "switchFragment", "fragmentTag", "switchFullscreenFragment", "enterAnimation", "exitAnimation", "Lapp/dogo/com/dogo_android/enums/FullScreenTag;", "tryShowDialog", "dialog", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a0, reason: from kotlin metadata */
public abstract class Navigator extends androidx.appcompat.app.d {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final a0.a INSTANCE = new a0$a(0);
    private Intent A;
    /* renamed from: B, reason: from kotlin metadata */
    private boolean communicationChannel;
    private boolean C;
    private boolean D;
    /* renamed from: E, reason: from kotlin metadata */
    private boolean dataToPass;
    private boolean F;
    /* renamed from: G, reason: from kotlin metadata */
    private Map<String, Object> entryCreationSavedData;
    /* renamed from: H, reason: from kotlin metadata */
    private r imageCropper;
    private final q I = new q();
    /* renamed from: J, reason: from kotlin metadata */
    private u isDoCreationLaunched = new u();
    private BroadcastReceiver K;
    /* renamed from: a, reason: from kotlin metadata */
    private boolean isLoading;
    /* renamed from: b, reason: from kotlin metadata */
    private boolean isResultActivityLaunched;
    /* renamed from: c, reason: from kotlin metadata */
    private Bundle lastCallTimeTracker = new Bundle();
    private Toast v;
    private Snackbar w;
    private final Map<String, Long> x = new HashMap<>();
    /* renamed from: y, reason: from kotlin metadata */
    private int mBroadcastReceiver;
    private int z;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0010\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/Navigator$Companion;", "", "()V", "BACK_RETURN_TAG", "", "CALLED_FROM_ONBOARDING", "DEEPLINK_CAMPAING_KEY", "DEEPLINK_COMMENT_ID_KEY", "DEEPLINK_EXTRAS_KEY", "DEEPLINK_LINKTYPE_KEY", "DEEPLINK_PARTNER_KEY", "DEFAULT_STATUS_BAR_COLOR", "", "DOG_SELECT_REQUEST_KEY", "EXAM_RECORDING_ACTIVITY_REQUEST", "GOOGLE_SIGN_IN_REQUEST_CODE", "LANGUAGE_USER_CONFIRMATION_PROMPT", "LOGIN_REQUEST_CODE", "PROFILE_CREATION_FROM_SELECT_REQUEST", "PROFILE_CREATION_REQUEST", "PROFILE_CREATION_REQUEST_WITH_PARTICIPATION", "PROFILE_PHOTO_UPLOAD_REQUEST", "SAVE_STATE_BUNDLE_BASE_ARGUMENTS", "SAVE_STATE_BUNDLE_CROPPER_SETTINGS_KEY", "SAVE_STATE_SERIAZIBLE_LAST_FRAGMENT", "SHOW_RECOMMENDED_PROGRAM_LIST", "WELCOME_LOGIN_REQUEST_CODE", "ZENDESK_INFO_CONFIGURATION", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/util/base_classes/Navigator$setupBroadcaster$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends BroadcastReceiver {

        final /* synthetic */ a0 a;
        b() {
            this.a = a0Var;
            super();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            str = "context";
            n.f(context, str);
            n.f(intent, "intent");
            if (intent.getAction() != null) {
                str = "upload_completed";
                if (n.b(intent.getAction(), str)) {
                    Bundle bundle = new Bundle();
                    str2 = "id";
                    bundle.putString(str2, intent.getStringExtra("extra_request_id"));
                    bundle.putParcelable("data", intent.getParcelableExtra("extra_download_url"));
                    this.a.isDoCreationLaunched.b(FragmentMessageAction.MESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE, bundle);
                }
            }
        }
    }
    public a0() {
        super();
        d0();
        Bundle bundle = new Bundle();
        HashMap hashMap = new HashMap();
        q imageCropper = new ImageCropper();
        u uVar = new u();
    }

    /* renamed from: A0, reason: from kotlin metadata */
    private final void callLoadingDialog() {
        try {
            this.I.v(this);
        } catch (Exception e) {
            a.d(e);
            Throwable e2 = 2131886123;
            showToast(e2);
        }
    }

    /* renamed from: D0, reason: from kotlin metadata */
    private final void showEntryCreationDialog(String challengeModel, Integer selectedDog, String comment, SubscriptionOffer entryId) {
        Intent intent = new SubscriptionScreenKey(challengeModel, entryId, comment).buildIntent(this);
        if (selectedDog != null) {
            startActivityForResult(intent, selectedDog.intValue());
        } else {
            startActivity(intent);
        }
        String simpleName = SubscriptionActivity.class.getSimpleName();
        n.e(simpleName, "SubscriptionActivity::class.java.simpleName");
        this.x.put(simpleName, Long.valueOf(System.currentTimeMillis()));
    }

    public static /* synthetic */ void F0(a0 a0Var, String str, String str2, SubscriptionOffer subscriptionOffer, int i, Object object) {
        String str4;
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startSubscriptionActivity");
        } else {
            i = 0;
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            a0Var.showChallengeWithCreationStarted(str, str4, subscriptionOffer);
            return;
        }
    }

    private final boolean K() {
        boolean z = false;
        if (this.I.k() || this.isResultActivityLaunched) {
            int i2 = 1;
        }
        return z;
    }

    public static /* synthetic */ void K0(a0 a0Var, app.dogo.com.dogo_android.k.j jVar, Bundle bundle, int i, int i2, int i3, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchFullscreenFragment");
        } else {
            i = 0;
            if (i3 & 4 != 0) {
            }
            if (i3 & 8 != 0) {
            }
            a0Var.startDogCreation(jVar, bundle, i, i);
            return;
        }
    }

    /* renamed from: L0, reason: from kotlin metadata */
    private final void createAndLoadViewFragment(u tag, app.dogo.com.dogo_android.k.c bundle) {
        try {
            tag.show(getSupportFragmentManager(), bundle.getTag());
        } catch (java.lang.IllegalStateException unused) {
            tag = 0;
            tag = new Object[tag];
            bundle = "Can not perform this action after onSaveInstanceState";
            a.c(bundle, tag);
        }
    }

    public static /* synthetic */ void S(a0 a0Var, int i, String str, int i2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchLogInActivity");
        } else {
            if (i2 & 1 != 0) {
                i = 10000;
            }
            a0Var.startDogCreation(i, str);
            return;
        }
    }

    /* renamed from: T, reason: from kotlin metadata */
    private static final void showChallengeProfileDialog(a0 dogProfile, Integer badges) {
        n.f(dogProfile, "this$0");
        if (badges != null) {
            dogProfile.showToast(badges.intValue());
        }
    }

    /* renamed from: U, reason: from kotlin metadata */
    private static final void showChallengeShareDialog(a0 bitmap, String model) {
        n.f(bitmap, "this$0");
        if (model != null) {
            bitmap.showToast(model);
        }
    }

    /* renamed from: V, reason: from kotlin metadata */
    private static final void showCommentDialog(a0 entryId, Boolean commentId) {
        n.f(entryId, "this$0");
        if (commentId != null && commentId.booleanValue()) {
            entryId.m();
        }
    }

    /* renamed from: W, reason: from kotlin metadata */
    private static final void showDogSelectDialog(a0 requestKey, u.b sourceScreenName) {
        str = "this$0";
        n.f(requestKey, str);
        if (sourceScreenName != null) {
            requestKey.isDoCreationLaunched.b(sourceScreenName.a(), sourceScreenName.b());
        }
    }

    /* renamed from: X, reason: from kotlin metadata */
    private static final void changeToChallengeFromNotification(a0 intent) {
        int i = 0;
        Window window2;
        int value;
        String tag;
        n.f(intent, "this$0");
        List list = intent.getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        Object obj = p.l0(list);
        i = 0;
        if (obj == null) {
        } else {
            app.dogo.com.dogo_android.y.j jVar = app.dogo.com.dogo_android.util.extensionfunction.k1.b(obj);
        }
        if (i != 0) {
            Integer statusBarColor = i.getStatusBarColor();
        }
        final int i5 = 67108864;
        if ("supportFragmentManager.fragments" == 0) {
            intent.getWindow().clearFlags(i5);
        } else {
            if (i.intValue() == R.color.transparent) {
                intent.getWindow().addFlags(i5);
            }
        }
        if ("supportFragmentManager.fragments" == 0 || "supportFragmentManager.fragments".intValue() == 0) {
            intent.getWindow().setStatusBarColor(intent.getColor(intent.A()));
        } else {
            intent.getWindow().setStatusBarColor(intent.getColor(i.intValue()));
        }
        z = obj instanceof t;
        if (!(obj instanceof t) && i == 0) {
            a.f(n.o("Fragment attached ", tag), new Object[0]);
        }
    }

    private final void d0() {
        this.K = new Navigator_setupBroadcaster_1(this);
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ u changeToShareDialog(a0 intent) {
        return intent.isDoCreationLaunched;
    }

    public static /* synthetic */ void l(a0 a0Var, app.dogo.com.dogo_android.k.c cVar, Bundle bundle, int i, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callDialog");
        } else {
            if (i & 2 != 0) {
                i = 0;
            }
            a0Var.k(cVar, bundle);
            return;
        }
    }

    /* renamed from: m0, reason: from kotlin metadata */
    private final void callTopFragmentOnActivityResults(String requestCode, boolean resultCode, String data) {
        app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(this, new DogSelectScreen(requestCode, resultCode, data));
    }

    /* renamed from: n, reason: from kotlin metadata */
    private final void onActivityResult(int requestCode, int resultCode, Intent data) {
        Object prev = null;
        int i;
        List list = getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        ListIterator it = list.listIterator(list.size());
        while (it.hasPrevious()) {
            i = !(Fragment)prev instanceof t;
            if (!it.previous() instanceof t) {
                break;
            }
        }
        int i2 = 0;
        if (prev != null) {
            prev.onActivityResult(requestCode, resultCode, data);
        }
    }

    public static /* synthetic */ void s0(a0 a0Var, String str, String str2, int i, View.OnClickListener list, int i2, Object object) {
        String str4;
        View.OnClickListener onClickListener;
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSnackbar");
        } else {
            i = 0;
            if (i2 & 2 != 0) {
            }
            if (i2 & 8 != 0) {
            }
            a0Var.switchFullscreenFragment(str, str4, i, onClickListener);
            return;
        }
    }

    public static /* synthetic */ void y0(a0 a0Var, String str, int i, int i2, Object object) {
        if (object != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startDogCreation");
        } else {
            if (i2 & 1 != 0) {
                i = 0;
            }
            a0Var.w0(str, i);
            return;
        }
    }

    @Override // androidx.appcompat.app.d
    public final Fragment B() {
        int i = 0;
        int i2;
        List list = getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        ListIterator it = list.listIterator(list.size());
        while (it.hasPrevious()) {
            i2 = !(Fragment)prev instanceof t;
            if (!it.previous() instanceof t) {
                break;
            }
        }
        i = 0;
        return (Fragment)i;
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: B0, reason: from kotlin metadata */
    public final void onRequestPermissionsResult(boolean requestCode, int permissions, int grantResults) {
        q.b rECTANGLE2;
        if (!this.I.k()) {
            this.I.p(permissions, grantResults);
            requestCode = requestCode ? ImageCropper_CropperShape.OVAL : ImageCropper_CropperShape.RECTANGLE;
            this.I.startAnAppropriateImageSourceSelection((requestCode ? ImageCropper_CropperShape.OVAL : ImageCropper_CropperShape.RECTANGLE));
            str = "Image cropper started";
            a.f("Image cropper started", (requestCode ? ImageCropper_CropperShape.OVAL : ImageCropper_CropperShape.RECTANGLE));
            callLoadingDialog();
        }
    }

    @Override // androidx.appcompat.app.d
    public final void C0() {
        if (!this.I.k()) {
            int i = 0;
            this.I.p(i, i);
            this.I.startAnAppropriateImageSourceSelection(ImageCropper_CropperShape.OVAL);
            str = "Image cropper started";
            a.f(str, new Object[i]);
            callLoadingDialog();
        }
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: E0, reason: from kotlin metadata */
    public final void showChallengeWithCreationStarted(String id, String newDogId, SubscriptionOffer welcomeParticipationUri) {
        n.f(id, "viewSource");
        showEntryCreationDialog(id, null, newDogId, welcomeParticipationUri);
    }

    @Override // androidx.appcompat.app.d
    public final void G() {
        Object systemService = getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        systemService.hideSoftInputFromWindow(findViewById(16908290).getRootView().getWindowToken(), 0);
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: G0, reason: from kotlin metadata */
    public void dismissDialog(app.dogo.com.dogo_android.k.i tag) {
        n.f(tag, "fragmentTag");
        showFanList(tag, null);
    }

    @Override // androidx.appcompat.app.d
    public final boolean H() {
        boolean z = true;
        if (getSupportFragmentManager().p0() > 1) {
            int i3 = 0;
        }
        return z;
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: H0, reason: from kotlin metadata */
    public final void showFanList(app.dogo.com.dogo_android.k.i entryId, Bundle challengeId) {
        n.f(entryId, "fragmentTag");
        if (!K()) {
            c.c(this).b();
            if (challengeId != null) {
                this.lastCallTimeTracker = challengeId;
            }
            q(entryId, challengeId);
        }
    }

    @Override // androidx.appcompat.app.d
    public final boolean I() {
        boolean z = false;
        android.net.Network activeNetwork;
        Object systemService = getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkCapabilities networkCapabilities = systemService.getNetworkCapabilities(systemService.getActiveNetwork());
        if (networkCapabilities != null) {
            int r0 = networkCapabilities.hasCapability(16) ? 1 : 0;
        }
        return (networkCapabilities.hasCapability(16) ? 1 : 0);
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: I0, reason: from kotlin metadata */
    public final void showSnackbar(app.dogo.com.dogo_android.k.i snackBarText, Bundle snackBarActionText, int duration, int listener) {
        n.f(snackBarText, "fragmentTag");
        c.c(this).b();
        if (snackBarActionText != null) {
            this.lastCallTimeTracker = snackBarActionText;
        }
        app.dogo.com.dogo_android.util.e0.w wVar = b.a(snackBarText);
        if (snackBarActionText != null) {
            wVar.setArguments(snackBarActionText);
        }
        w wVar2 = getSupportFragmentManager().n();
        n.e(wVar2, "supportFragmentManager.beginTransaction()");
        if (duration != 0 || listener != null) {
            wVar2.q(duration, listener);
        }
        wVar2.p(2131362551, wVar, snackBarText.getTag());
        wVar2.f(null);
        wVar2.h();
    }

    @Override // androidx.appcompat.app.d
    public final boolean J() {
        return this.D;
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: J0, reason: from kotlin metadata */
    public final void startDogCreation(app.dogo.com.dogo_android.k.j dogId, Bundle requestCode, int skipWelcomeSuggestion, int dogName) {
        n.f(dogId, "fragmentTag");
        c.c(this).b();
        if (requestCode != null) {
            this.lastCallTimeTracker = requestCode;
        }
        app.dogo.com.dogo_android.util.e0.x xVar = c.a(dogId);
        if (requestCode != null) {
            xVar.setArguments(requestCode);
        }
        w wVar = getSupportFragmentManager().n();
        n.e(wVar, "supportFragmentManager.beginTransaction()");
        if (skipWelcomeSuggestion != 0 || dogName != 0) {
            wVar.q(skipWelcomeSuggestion, dogName);
        }
        wVar.p(2131362551, xVar, dogId.getTag());
        wVar.f(null);
        wVar.h();
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: Q, reason: from kotlin metadata */
    public final void startDogCreation(int dogId, String requestCode) {
        n.f(requestCode, "viewSource");
        if (!this.isLoading) {
            Intent intent = new Intent(this, LoginActivity.class);
            str = "view_source";
            intent.putExtra(str, requestCode);
            startActivityForResult(intent, dogId);
            boolean z = true;
            this.isLoading = z;
        }
    }

    @Override // androidx.appcompat.app.d
    public void Y() {
        finish();
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: Z, reason: from kotlin metadata */
    public final void onAttachFragment(u.a fragment) {
        n.f(fragment, "endpoint");
        fragment.e(this.isDoCreationLaunched);
    }

    @Override // androidx.appcompat.app.d
    protected void attachBaseContext(Context context) {
        n.f(context, "newBase");
        t.a iNSTANCE2 = MyContextWrapper.INSTANCE;
        final Context resources2 = iNSTANCE2.updateResources(context, LocaleService.getLanguageFromLocaleString(App.INSTANCE.l().W()));
        super.attachBaseContext(resources2);
        android.content.res.Resources resources = getResources();
        n.e(resources, "resources");
        iNSTANCE2.updateResourcesUpTo25Api(resources, resources2);
        a.b(this);
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: b0, reason: from kotlin metadata */
    public final void onOptionsItemSelected(boolean item) {
        this.D = item;
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: e0, reason: from kotlin metadata */
    public final void switchFragment(String fragmentTag, String bundle) {
        final Bundle bundle2 = new Bundle();
        bundle2.putString("challengeId", fragmentTag);
        bundle2.putString("linkType", bundle);
        showFanList(FragmentTags.CHALLENGE_HOME_FRAGMENT, bundle2);
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: f0, reason: from kotlin metadata */
    public final void tryShowDialog(DogProfileModel dialog, List<String> tag) {
        n.f(tag, "badges");
        if (dialog != null) {
            g0(new LiteDogProfile(dialog), tag);
        } else {
            int i = 2131886123;
            showToast(i);
        }
    }

    @Override // androidx.appcompat.app.d
    public final void g0(LiteDogProfile liteDogProfile, List<String> list) {
        final String str2 = "badges";
        n.f(list, str2);
        if (liteDogProfile != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("liteDogProfile", liteDogProfile);
            bundle.putStringArrayList(str2, new ArrayList(list));
            int i4 = 2131951968;
            str = "style";
            bundle.putInt(str, i4);
            int i = 0;
            int i2 = 0;
            int i3 = 12;
            Object obj = null;
            Navigator.K0(this, FullScreenTag.CHALLENGE_PROFILE_DETAILS_DIALOG_FRAGMENT, bundle, i, i2, i3, obj);
        } else {
            i4 = 2131886123;
            showToast(i4);
        }
    }

    @Override // androidx.appcompat.app.d
    public final void h0(Uri uri, ChallengeEntryModel challengeEntryModel) {
        final Bundle bundle = new Bundle();
        bundle.putParcelable("bitmap", uri);
        bundle.putParcelable("model", challengeEntryModel);
        k(DialogTags.CHALLENGE_SHARE_DIALOG, bundle);
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: i0, reason: from kotlin metadata */
    public final void showDogSelectDialog(String requestKey, String skipWelcomeSuggestion, Uri sourceScreenName) {
        final boolean z2 = true;
        final String str4 = "challengeId";
        if (getSupportFragmentManager().N0()) {
            this.F = z2;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.entryCreationSavedData = linkedHashMap;
            n.d(linkedHashMap);
            linkedHashMap.put(str4, requestKey);
            n.d(this.entryCreationSavedData);
            this.entryCreationSavedData.put("dogId", skipWelcomeSuggestion);
            if (sourceScreenName != null) {
                n.d(this.entryCreationSavedData);
                str2 = "welcomeParticipationUri";
                this.entryCreationSavedData.put(str2, sourceScreenName);
            }
            return;
        }
        this.F = false;
        Bundle bundle = new Bundle();
        bundle.putString(str4, requestKey);
        str = "uploadDogId";
        bundle.putString(str, skipWelcomeSuggestion);
        if (sourceScreenName != null) {
            str = "uploadPhoto";
            bundle.putParcelable(str, sourceScreenName);
        }
        showFanList(FragmentTags.CHALLENGE_HOME_FRAGMENT, bundle);
        View viewById = findViewById(2131362866);
        if (viewById != null) {
            int i = 2;
            viewById.getMenu().getItem(i).setChecked(z2);
        }
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: j0, reason: from kotlin metadata */
    public final void setHomeUpVisible(ChallengeEntryModel hasParent) {
        final String str = "entryModel";
        n.f(hasParent, str);
        final Bundle bundle = new Bundle();
        bundle.putInt("style", 2131951968);
        bundle.putString("entryId", hasParent.getDocumentId());
        bundle.putParcelable(str, hasParent);
        Navigator.K0(this, FullScreenTag.CHALLENGE_COMMENTS_DIALOG, bundle, 0, 0, 12, null);
    }

    @Override // androidx.appcompat.app.d
    public final void k(app.dogo.com.dogo_android.k.c cVar, Bundle bundle) {
        String tag;
        boolean key = false;
        int _int;
        n.f(cVar, "tag");
        if (cVar == DialogTags.LOADING_DIALOG_FRAGMENT) {
            boolean z2 = true;
            onOptionsItemSelected(z2);
            if (getSupportFragmentManager().N0()) {
                return;
            }
            this.dataToPass = z2;
        }
        Fragment fragment = getSupportFragmentManager().k0(cVar.getTag());
        if (fragment == null) {
            app.dogo.com.dogo_android.util.e0.u uVar = a.a(cVar);
            if (uVar == null) {
                throw new RuntimeException("Dialog whit this tag was not found");
            } else {
                if (bundle != null && bundle.containsKey(tag)) {
                    uVar.setStyle(0, bundle.getInt(tag));
                }
                createAndLoadViewFragment(uVar, cVar);
                return;
            }
        }
        fragment.onAttach(this);
    }

    @Override // androidx.appcompat.app.d
    public final void k0(String str, String str2) {
        final Bundle bundle = new Bundle();
        bundle.putString("entryId", str);
        bundle.putString("commentId", str2);
        bundle.putInt("style", 2131951968);
        Navigator.K0(this, FullScreenTag.CHALLENGE_COMMENTS_DIALOG, bundle, 0, 0, 12, null);
    }

    @Override // androidx.appcompat.app.d
    public final void l0(String str, String str2) {
        n.f(str, "requestKey");
        n.f(str2, "sourceScreenName");
        callTopFragmentOnActivityResults(str, true, str2);
    }

    @Override // androidx.appcompat.app.d
    public final void m() {
        final Bundle bundle = null;
        Navigator.l(this, DialogTags.LOADING_DIALOG_FRAGMENT, bundle, 2, bundle);
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: n0, reason: from kotlin metadata */
    public final void startSubscriptionActivity(ChallengeModel viewSource, LiteDogProfile requestCode, String lessonId, String subscriptionOffer) {
        final Bundle bundle = new Bundle();
        bundle.putInt("style", 2131951968);
        bundle.putParcelable("challengeModel", viewSource);
        bundle.putParcelable("selectedDog", requestCode);
        bundle.putString("comment", lessonId);
        bundle.putString("entryId", subscriptionOffer);
        k(DialogTags.CHALLENGE_ENTRY_CREATION, bundle);
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: o, reason: from kotlin metadata */
    public final void setLoadingState(Intent state) {
        n.f(state, "intent");
        queryParameter = "android.intent.extra.STREAM";
        android.os.Parcelable parcelableExtra = state.getParcelableExtra(queryParameter);
        if (parcelableExtra != null) {
            str = "linkType";
            switchFragment(parcelableExtra.getQueryParameter("extra"), parcelableExtra.getQueryParameter(str));
        }
    }

    @Override // androidx.appcompat.app.d
    public final void o0(String str, String str2) {
        final Bundle bundle = new Bundle();
        bundle.putInt("style", 2131951968);
        bundle.putString("challenge_id", str2);
        bundle.putString("id", str);
        Navigator.K0(this, FullScreenTag.CHALLENGE_FAN_LIST_DIALOG_FRAGMENT, bundle, 0, 0, 12, null);
    }

    @Override // androidx.appcompat.app.d
    protected void onActivityResult(int i, int i2, Intent intent) {
        int i4 = 10000;
        boolean z = false;
        android.os.Parcelable parcelableExtra;
        super.onActivityResult(i, i2, intent);
        int i3 = 11100;
        final int i5 = -1;
        z = false;
        if (i == 11100 || i == 11101 || i == 11103) {
            this.isResultActivityLaunched = z;
            String str2 = "newDogId";
            str = "welcomeParticipationUri";
            if (i2 == i5) {
                n.d(intent);
                if (intent.getParcelableExtra(str) != null) {
                    showDogSelectDialog(SpecialChallenges.WELCOME_CHALLENGE.getId(), intent.getStringExtra(str2), (Uri)intent.getParcelableExtra(str));
                } else {
                    if (i2 == i5) {
                        n.d(intent);
                        if (intent.hasExtra(str)) {
                            showDogSelectDialog(SpecialChallenges.WELCOME_CHALLENGE.getId(), intent.getStringExtra(str2), null);
                        }
                    }
                }
            }
        }
        i4 = 10000;
        if (i == 10000 || i == 10002) {
            this.isLoading = z;
        }
        n.d(this.imageCropper);
        this.imageCropper.onActivityResult(i, i2, intent, this);
        try {
            this.I.onActivityResultsForImageSelection(i, i2, intent, this);
        } catch (Exception e) {
            a.d(e);
        }
        this.I.onActivityResultsForImageCropper(i, i2, intent);
        z = true;
        if (this.C) {
            onActivityResult(i, i2, intent);
        } else {
            this.mBroadcastReceiver = i;
            this.z = i2;
            if (intent != null) {
                intent = new Intent(intent);
            }
            this.A = intent;
            this.communicationChannel = z;
        }
        if (i == 10100 && i2 == i5) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(this, new LanguageSelectScreen(z));
        }
    }

    @Override // androidx.appcompat.app.d
    public void onAttachFragment(Fragment fragment) {
        n.f(fragment, "fragment");
        super.onAttachFragment(fragment);
        if (fragment instanceof app.dogo.com.dogo_android.util.base_classes.v) {
            fragment.f0(this);
        }
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        int i = 0;
        Fragment fragment = B();
        if (fragment instanceof app.dogo.com.dogo_android.util.base_classes.w) {
            boolean z2 = fragment.V1();
        } else {
            i = 0;
        }
        if (i == 0 && !this.H()) {
            G();
            super.onBackPressed();
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.lastCallTimeTracker = bundle.getBundle("arguments");
            str = "image_cropper_settings";
            this.I.startImageSourceSelection(bundle.getBundle(str));
        }
        Class cls = E();
        n.d(cls);
        androidx.lifecycle.e0 e0Var = h0.b(this).a(cls);
        this.imageCropper = e0Var;
        n.d(e0Var);
        e0Var.c.observe(this, new app.dogo.com.dogo_android.util.base_classes.n(this));
        n.d(this.imageCropper);
        imageCropper2.loadingDialogTrigger.observe(this, new app.dogo.com.dogo_android.util.base_classes.k(this));
        n.d(this.imageCropper);
        imageCropper22.parent.observe(this, new app.dogo.com.dogo_android.util.base_classes.l(this));
        n.d(this.imageCropper);
        this.imageCropper.k().observe(this, new app.dogo.com.dogo_android.util.base_classes.j(this));
        getSupportFragmentManager().i(new app.dogo.com.dogo_android.util.base_classes.m(this));
    }

    @Override // androidx.appcompat.app.d
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        n.f(menuItem, "item");
        if (menuItem.getItemId() == 0x0102002c /* Unknown resource */) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.d
    protected void onPause() {
        super.onPause();
        this.C = false;
    }

    @Override // androidx.appcompat.app.d
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        n.f(strArr, "permissions");
        n.f(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        try {
            this.I.onRequestPermissionsResult(i, strArr, iArr, this);
        } catch (Exception e) {
            a.d(e);
            e = 2131886123;
            showToast(e);
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onResumeFragments() {
        int i;
        Intent intent;
        super.onResumeFragments();
        if (this.communicationChannel) {
            onActivityResult(this.mBroadcastReceiver, this.z, this.A);
            boolean communicationChannel2 = false;
            this.communicationChannel = communicationChannel2;
        }
        if (this.D && !this.dataToPass) {
            i = 2;
            Bundle bundle = null;
            Navigator.l(this, DialogTags.LOADING_DIALOG_FRAGMENT, bundle, i, bundle);
        }
        if (this.F) {
            n.d(this.entryCreationSavedData);
            n.d(this.entryCreationSavedData);
            n.d(this.entryCreationSavedData);
            str = "welcomeParticipationUri";
            showDogSelectDialog((String)this.entryCreationSavedData.get("challengeId"), (String)this.entryCreationSavedData.get("dogId"), (Uri)this.entryCreationSavedData.get(str));
        }
        this.C = true;
    }

    @Override // androidx.appcompat.app.d
    public void onSaveInstanceState(Bundle bundle) {
        n.f(bundle, "outState");
        bundle.putBundle("arguments", w());
        bundle.putBoolean("last_fragment", true);
        bundle.putBundle("image_cropper_settings", this.I.j());
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.d
    public void onStart() {
        super.onStart();
        final d.q.a.a aVar = a.b(this);
        n.e(aVar, "getInstance(this)");
        n.d(this.K);
        aVar.c(this.K, PhotoUploadNotificationService.INSTANCE.a());
    }

    @Override // androidx.appcompat.app.d
    public void onStop() {
        super.onStop();
        n.d(this.K);
        a.b(this).e(this.K);
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: p, reason: from kotlin metadata */
    public final void setTitle(Intent title) {
        n.f(title, "intent");
        queryParameter = "android.intent.extra.STREAM";
        android.os.Parcelable parcelableExtra = title.getParcelableExtra(queryParameter);
        if (parcelableExtra != null) {
            str = "linkType";
            showSharedImageDialog(parcelableExtra.getQueryParameter("entryId"), parcelableExtra.getQueryParameter("challengeId"), parcelableExtra.getQueryParameter(str));
        }
    }

    @Override // androidx.appcompat.app.d
    public w q(app.dogo.com.dogo_android.k.i iVar, Bundle bundle) {
        int i = 0;
        String tag;
        n.f(iVar, "tag");
        app.dogo.com.dogo_android.util.e0.w wVar = b.b(iVar, z());
        if (bundle != null) {
            wVar.setArguments(bundle);
        }
        tag = iVar.getTag();
        final int i3 = 1;
        if (!wVar.L1()) {
            androidx.fragment.app.n supportFragmentManager2 = getSupportFragmentManager();
            n.e(supportFragmentManager2, "supportFragmentManager");
            int i2 = supportFragmentManager2.p0();
            i = 0;
            if (i2 > 0) {
                i = i + i3;
                supportFragmentManager2.Z0();
                while (i + i3 >= i2) {
                    i = i + i3;
                    supportFragmentManager2.Z0();
                }
            }
            tag = "parent";
        }
        w wVar2 = getSupportFragmentManager().n();
        wVar2.p(2131362533, wVar, iVar.getTag());
        wVar2.f(tag);
        wVar2.s(true);
        wVar2.h();
        return wVar;
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: q0, reason: from kotlin metadata */
    public final void showSharedImageDialog(String entryId, String challengeId, String linkType) {
        final Bundle bundle = new Bundle();
        bundle.putString("entryId", entryId);
        bundle.putString("challengeId", challengeId);
        bundle.putString("linkType", linkType);
        Navigator.K0(this, FullScreenTag.CHALLENGE_COMMENTS_DIALOG, bundle, 0, 0, 12, null);
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: r, reason: from kotlin metadata */
    public final void showCommentDialog(app.dogo.com.dogo_android.k.c entryModel) {
        n.f(entryModel, "tag");
        final boolean z = false;
        if (entryModel == DialogTags.LOADING_DIALOG_FRAGMENT) {
            onOptionsItemSelected(z);
        }
        Fragment fragment = getSupportFragmentManager().k0(entryModel.getTag());
        if (fragment != null) {
            try {
                fragment.dismiss();
                this.dataToPass = z;
            } catch (Exception unused) {
                return;
            }
        }
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: r0, reason: from kotlin metadata */
    public final void switchFullscreenFragment(String fragmentTag, String bundle, int enterAnimation, View.OnClickListener exitAnimation) {
        n.f(fragmentTag, "snackBarText");
        t();
        final Snackbar snackbar = Snackbar.e0(findViewById(2131363244), fragmentTag, enterAnimation);
        snackbar.h0(bundle, exitAnimation);
        this.w = snackbar;
        n.d(snackbar);
        snackbar.T();
    }

    @Override // androidx.appcompat.app.d
    public final void s() {
        showCommentDialog(DialogTags.LOADING_DIALOG_FRAGMENT);
    }

    @Override // androidx.appcompat.app.d
    public final void t() {
        if (this.w != null) {
            n.d(this.w);
            this.w.u();
        }
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: t0, reason: from kotlin metadata */
    public final void showToast(int message) throws android.content.res.Resources.NotFoundException {
        if (this.v != null) {
            n.d(this.v);
            this.v.cancel();
        }
        final Toast text = Toast.makeText(this, message, 1);
        this.v = text;
        n.d(text);
        text.show();
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: u0, reason: from kotlin metadata */
    public final void showToast(String message) throws android.content.res.Resources.NotFoundException {
        if (this.v != null) {
            n.d(this.v);
            this.v.cancel();
        }
        final Toast text = Toast.makeText(this, message, 1);
        this.v = text;
        n.d(text);
        text.show();
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: v, reason: from kotlin metadata */
    public final void showVideoPlaybackFullscreenFragment(u.b model) {
        this.isDoCreationLaunched.c(model);
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: v0, reason: from kotlin metadata */
    public final void switchFragment(Exam fragmentTag) {
        if (I()) {
            Bundle bundle = new Bundle();
            str = "model";
            bundle.putSerializable(str, fragmentTag);
            int i = 0;
            int i2 = 0;
            int i3 = 12;
            Object obj = null;
            Navigator.K0(this, FullScreenTag.VIDEO_EXAM_PLAYBACK, bundle, i, i2, i3, obj);
        } else {
            String string = getString(2131886953);
            str2 = "getString(R.string.no_internet_connection)";
            n.e(string, str2);
            i2 = 10;
            Navigator.s0(this, string, null, -1, null, i2, null);
        }
    }

    @Override // androidx.appcompat.app.d
    public final Bundle w() {
        if (this.lastCallTimeTracker == null) {
            this.lastCallTimeTracker = new Bundle();
        }
        return this.lastCallTimeTracker;
    }

    @Override // androidx.appcompat.app.d
    public final void w0(String str, int i) {
        switchFullscreenFragment(str, i, true, null);
    }

    @Override // androidx.appcompat.app.d
    public final w x() {
        int i;
        List list = getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        i = list.size() - 1;
        i = 0;
        if (list.size() - 1 >= 0) {
            i = i - 1;
            z = list.get(i) instanceof app.dogo.com.dogo_android.util.base_classes.w;
            while (list.get("supportFragmentManager.fragments") instanceof app.dogo.com.dogo_android.util.base_classes.w) {
            }
        }
        if (!list.isEmpty()) {
            Object item = list.get(i);
            empty = item instanceof app.dogo.com.dogo_android.util.base_classes.w;
            if (item instanceof app.dogo.com.dogo_android.util.base_classes.w) {
                return item;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: x0, reason: from kotlin metadata */
    public final void switchFullscreenFragment(String fragmentTag, int bundle, boolean enterAnimation, String exitAnimation) {
        if (!this.isResultActivityLaunched) {
            boolean z = false;
            int i = 8;
            g gVar = null;
            DogCreationScreenKey dogCreationScreenKey = new DogCreationScreenKey(fragmentTag, exitAnimation, enterAnimation, z, i, gVar);
            startActivityForResult(dogCreationScreenKey.buildIntent(this), bundle);
            boolean z2 = true;
            this.isResultActivityLaunched = z2;
        }
    }

    @Override // androidx.appcompat.app.d
    public final app.dogo.com.dogo_android.k.i y() {
        int i;
        app.dogo.com.dogo_android.util.e0.w wVar = x();
        i = 0;
        if (wVar == null) {
        } else {
            app.dogo.com.dogo_android.k.q qVar = wVar.D1();
        }
        if (i instanceof FragmentTags) {
        }
        return i;
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: z0, reason: from kotlin metadata */
    public final void startDogUpdateFlow(String dogId, String dogName, int requestCode) {
        n.f(dogId, "dogId");
        n.f(dogName, "dogName");
        switchFullscreenFragment(dogId, requestCode, true, dogName);
    }


    /* renamed from: L, reason: from kotlin metadata */
    public static /* synthetic */ void callDialog(a0 tag, u.b bundle) {
        Navigator.showDogSelectDialog(tag, bundle);
    }

    /* renamed from: M, reason: from kotlin metadata */
    public static /* synthetic */ void launchLogInActivity(a0 requestCode, String viewSource) {
        Navigator.showChallengeShareDialog(requestCode, viewSource);
    }

    /* renamed from: N, reason: from kotlin metadata */
    public static /* synthetic */ void showChallengeFromNotification(a0 challengeId, Boolean linkType) {
        Navigator.showCommentDialog(challengeId, linkType);
    }

    /* renamed from: O, reason: from kotlin metadata */
    public static /* synthetic */ void attachBaseContext(a0 newBase) {
        Navigator.changeToChallengeFromNotification(newBase);
    }

    /* renamed from: P, reason: from kotlin metadata */
    public static /* synthetic */ void showChallengeProfileDialog(a0 dogProfileModel, Integer badges) {
        Navigator.showChallengeProfileDialog(dogProfileModel, badges);
    }

    @Override // androidx.appcompat.app.d
    protected int A() {
        return R.color.white;
    }

    @Override // androidx.appcompat.app.d
    public int C() {
        return 8;
    }

    @Override // androidx.appcompat.app.d
    public int D() {
        return 0;
    }

    @Override // androidx.appcompat.app.d
    public abstract Class<? extends r> E();

    @Override // androidx.appcompat.app.d
    public void F() {
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: R, reason: from kotlin metadata */
    public final void emitFragmentMessage(String message) {
        n.f(message, "viewSource");
        Navigator.S(this, 0, message, 1, null);
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: a0, reason: from kotlin metadata */
    public void onCreate(boolean savedInstanceState) {
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: c0, reason: from kotlin metadata */
    public void onSaveInstanceState(String outState) {
    }

    @Override // androidx.appcompat.app.d
    /* renamed from: j, reason: from kotlin metadata */
    public final void registerToChannel(app.dogo.com.dogo_android.k.c endpoint) {
        n.f(endpoint, "tag");
        Bundle bundle = null;
        Navigator.l(this, endpoint, bundle, 2, bundle);
    }

    @Override // androidx.appcompat.app.d
    public void p0() {
    }

    @Override // androidx.appcompat.app.d
    public void u() {
    }

    @Override // androidx.appcompat.app.d
    public abstract app.dogo.com.dogo_android.k.i z();
}
