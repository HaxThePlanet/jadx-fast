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
import androidx.appcompat.app.d;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import app.dogo.com.dogo_android.dogcreation.f;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.k.h;
import app.dogo.com.dogo_android.k.i;
import app.dogo.com.dogo_android.k.j;
import app.dogo.com.dogo_android.k.o;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.ChallengeModel;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.model.Exam;
import app.dogo.com.dogo_android.model.LiteDogProfile;
import app.dogo.com.dogo_android.q.q.i;
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
import app.dogo.com.dogo_android.util.i0.a;
import app.dogo.com.dogo_android.util.i0.b;
import app.dogo.com.dogo_android.util.i0.c;
import app.dogo.com.dogo_android.util.m0.a;
import app.dogo.com.dogo_android.util.q;
import app.dogo.com.dogo_android.util.q.b;
import app.dogo.com.dogo_android.util.t;
import app.dogo.com.dogo_android.util.t.a;
import app.dogo.com.dogo_android.util.u;
import app.dogo.com.dogo_android.util.u.a;
import app.dogo.com.dogo_android.util.u.b;
import app.dogo.com.dogo_android.y.j;
import com.bumptech.glide.c;
import com.google.android.material.snackbar.Snackbar;
import d.q.a.a;
import f.c.a.e.y.e;
import f.c.a.f.a.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¤\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008&\u0018\u0000 Ô\u00012\u00020\u0001:\u0002Ô\u0001B\u000f\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0014J\u001c\u0010R\u001a\u00020O2\u0006\u0010S\u001a\u00020T2\n\u0008\u0002\u0010U\u001a\u0004\u0018\u00010\u0007H\u0007J\u0006\u0010V\u001a\u00020OJ\"\u0010W\u001a\u00020O2\u0006\u0010X\u001a\u00020;2\u0006\u0010Y\u001a\u00020;2\u0008\u0010Z\u001a\u0004\u0018\u00010\u0016H\u0002J\u000e\u0010[\u001a\u00020O2\u0006\u0010\\\u001a\u00020\u0016J\u000e\u0010]\u001a\u00020O2\u0006\u0010\\\u001a\u00020\u0016J\u001c\u0010^\u001a\u0004\u0018\u00010\u000e2\u0006\u0010S\u001a\u00020\u00122\u0008\u0010U\u001a\u0004\u0018\u00010\u0007H\u0016J\u000e\u0010_\u001a\u00020O2\u0006\u0010S\u001a\u00020TJ\u0006\u0010`\u001a\u00020OJ\u0006\u0010a\u001a\u00020OJ\u0008\u0010b\u001a\u00020OH\u0016J\u0010\u0010c\u001a\u00020O2\u0008\u0010d\u001a\u0004\u0018\u00010eJ\u0008\u0010f\u001a\u00020;H\u0014J\u0008\u0010g\u001a\u00020;H\u0016J\u0008\u0010h\u001a\u00020;H\u0016J\n\u0010i\u001a\u0004\u0018\u00010jH&J\n\u0010k\u001a\u0004\u0018\u00010\u001bH&J\u0008\u0010l\u001a\u00020OH\u0016J\u0006\u0010m\u001a\u00020OJ\u0006\u0010n\u001a\u00020 J\u001a\u0010o\u001a\u00020O2\u0008\u0008\u0002\u0010X\u001a\u00020;2\u0006\u0010p\u001a\u00020\u001bH\u0007J\"\u0010q\u001a\u00020O2\u0006\u0010X\u001a\u00020;2\u0006\u0010Y\u001a\u00020;2\u0008\u0010Z\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010r\u001a\u00020O2\u0006\u0010s\u001a\u00020,H\u0016J\u0008\u0010t\u001a\u00020OH\u0016J\u0012\u0010u\u001a\u00020O2\u0008\u0010v\u001a\u0004\u0018\u00010\u0007H\u0014J\u0008\u0010w\u001a\u00020OH\u0016J\u0010\u0010x\u001a\u00020 2\u0006\u0010y\u001a\u00020zH\u0016J\u0008\u0010{\u001a\u00020OH\u0014J/\u0010|\u001a\u00020O2\u0006\u0010X\u001a\u00020;2\u000e\u0010}\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0~2\u0007\u0010\u007f\u001a\u00030\u0080\u0001H\u0016¢\u0006\u0003\u0010\u0081\u0001J\t\u0010\u0082\u0001\u001a\u00020OH\u0014J\u0012\u0010\u0083\u0001\u001a\u00020O2\u0007\u0010\u0084\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0085\u0001\u001a\u00020OH\u0016J\t\u0010\u0086\u0001\u001a\u00020OH\u0016J\u0011\u0010\u0087\u0001\u001a\u00020O2\u0008\u0010\u0088\u0001\u001a\u00030\u0089\u0001J\u0012\u0010\u008a\u0001\u001a\u00020O2\u0007\u0010\u008b\u0001\u001a\u00020 H\u0016J\u0010\u0010\u008c\u0001\u001a\u00020O2\u0007\u0010\u008d\u0001\u001a\u00020 J\u0014\u0010\u008e\u0001\u001a\u00020O2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u0090\u0001\u001a\u00020OH\u0002J\u001d\u0010\u0091\u0001\u001a\u00020O2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001bJ#\u0010\u0094\u0001\u001a\u00020O2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u0096\u00012\u000e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0098\u0001J#\u0010\u0094\u0001\u001a\u00020O2\n\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u009a\u00012\u000e\u0010\u0097\u0001\u001a\t\u0012\u0004\u0012\u00020\u001b0\u0098\u0001J\u001f\u0010\u009b\u0001\u001a\u00020O2\n\u0010\u009c\u0001\u001a\u0005\u0018\u00010\u009d\u00012\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001J)\u0010 \u0001\u001a\u00020O2\t\u0010¡\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010¢\u0001\u001a\u0004\u0018\u00010\u001b2\n\u0010£\u0001\u001a\u0005\u0018\u00010\u009d\u0001J\u0011\u0010¤\u0001\u001a\u00020O2\u0008\u0010¥\u0001\u001a\u00030\u009f\u0001J\u001d\u0010¤\u0001\u001a\u00020O2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010§\u0001\u001a\u0004\u0018\u00010\u001bJ&\u0010¨\u0001\u001a\u00020O2\u0007\u0010©\u0001\u001a\u00020\u001b2\u0007\u0010ª\u0001\u001a\u00020 2\t\u0008\u0002\u0010«\u0001\u001a\u00020\u001bH\u0002J\u0019\u0010¨\u0001\u001a\u00020O2\u0007\u0010©\u0001\u001a\u00020\u001b2\u0007\u0010«\u0001\u001a\u00020\u001bJ5\u0010¬\u0001\u001a\u00020O2\n\u0010­\u0001\u001a\u0005\u0018\u00010®\u00012\n\u0010¯\u0001\u001a\u0005\u0018\u00010\u009a\u00012\t\u0010°\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u001bJ\u001d\u0010±\u0001\u001a\u00020O2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001bJ\t\u0010²\u0001\u001a\u00020OH\u0016J(\u0010³\u0001\u001a\u00020O2\t\u0010¦\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u001b2\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001bJ4\u0010´\u0001\u001a\u00020O2\u0007\u0010µ\u0001\u001a\u00020\u001b2\u000b\u0008\u0002\u0010¶\u0001\u001a\u0004\u0018\u00010\u001b2\u0007\u0010·\u0001\u001a\u00020;2\u000c\u0008\u0002\u0010¸\u0001\u001a\u0005\u0018\u00010¹\u0001J\u0011\u0010º\u0001\u001a\u00020O2\u0008\u0008\u0001\u0010d\u001a\u00020;J\u0011\u0010º\u0001\u001a\u00020O2\u0008\u0010d\u001a\u0004\u0018\u00010\u001bJ\u0013\u0010»\u0001\u001a\u00020O2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010¼\u0001J\u001c\u0010½\u0001\u001a\u00020O2\u000b\u0008\u0002\u0010¾\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010X\u001a\u00020;J.\u0010½\u0001\u001a\u00020O2\t\u0010¾\u0001\u001a\u0004\u0018\u00010\u001b2\u0006\u0010X\u001a\u00020;2\u0007\u0010ª\u0001\u001a\u00020 2\t\u0010¿\u0001\u001a\u0004\u0018\u00010\u001bJ!\u0010À\u0001\u001a\u00020O2\u0007\u0010¾\u0001\u001a\u00020\u001b2\u0007\u0010¿\u0001\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020;J\t\u0010Á\u0001\u001a\u00020OH\u0002J\"\u0010Á\u0001\u001a\u00020O2\u0007\u0010Â\u0001\u001a\u00020 2\u0007\u0010Ã\u0001\u001a\u00020;2\u0007\u0010Ä\u0001\u001a\u00020;J\u0007\u0010Å\u0001\u001a\u00020OJ8\u0010Æ\u0001\u001a\u00020O2\u0006\u0010p\u001a\u00020\u001b2\u0008\u0010X\u001a\u0004\u0018\u00010;2\t\u0010Ç\u0001\u001a\u0004\u0018\u00010\u001b2\n\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001H\u0002¢\u0006\u0003\u0010Ê\u0001J*\u0010Æ\u0001\u001a\u00020O2\u0006\u0010p\u001a\u00020\u001b2\u000b\u0008\u0002\u0010Ç\u0001\u001a\u0004\u0018\u00010\u001b2\u000c\u0008\u0002\u0010È\u0001\u001a\u0005\u0018\u00010É\u0001J\u0012\u0010Ë\u0001\u001a\u00020O2\u0007\u0010Ì\u0001\u001a\u00020\u0012H\u0016J\u001a\u0010Ë\u0001\u001a\u00020O2\u0007\u0010Ì\u0001\u001a\u00020\u00122\u0008\u0010U\u001a\u0004\u0018\u00010\u0007J0\u0010Í\u0001\u001a\u00020O2\u0007\u0010Ì\u0001\u001a\u00020\u00122\u0008\u0010U\u001a\u0004\u0018\u00010\u00072\t\u0008\u0002\u0010Î\u0001\u001a\u00020;2\t\u0008\u0002\u0010Ï\u0001\u001a\u00020;J3\u0010Í\u0001\u001a\u00020O2\u0008\u0010Ì\u0001\u001a\u00030Ð\u00012\u0008\u0010U\u001a\u0004\u0018\u00010\u00072\t\u0008\u0002\u0010Î\u0001\u001a\u00020;2\t\u0008\u0002\u0010Ï\u0001\u001a\u00020;H\u0007J\u001b\u0010Ñ\u0001\u001a\u00020O2\u0008\u0010Ò\u0001\u001a\u00030Ó\u00012\u0006\u0010S\u001a\u00020TH\u0002R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00078FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0014R\u001e\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010!R\u000e\u0010\"\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008#\u0010!\"\u0004\u0008$\u0010%R\u001a\u0010&\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010!\"\u0004\u0008'\u0010%R\u0014\u0010(\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008(\u0010!R\u001c\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010*0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\u0008-\u0010.R\u001a\u0010/\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u0010!\"\u0004\u00081\u0010%R\u001a\u00102\u001a\u00020 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00083\u0010!\"\u0004\u00084\u0010%R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00088\u0010!\"\u0004\u00089\u0010%R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008@\u0010!\"\u0004\u0008A\u0010%R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010D\u001a\u0004\u0018\u00010E8F¢\u0006\u0006\u001a\u0004\u0008F\u0010GR\u001e\u0010H\u001a\u000e\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010J\u0018\u00010IX¦\u0004¢\u0006\u0006\u001a\u0004\u0008K\u0010LR\u0010\u0010M\u001a\u0004\u0018\u00010JX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Õ\u0001", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/Navigator;", "Landroidx/appcompat/app/AppCompatActivity;", "mockChannel", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel;", "(Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel;)V", "()V", "arguments", "Landroid/os/Bundle;", "getArguments", "()Landroid/os/Bundle;", "setArguments", "(Landroid/os/Bundle;)V", "communicationChannel", "currentFragment", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseNavFragment;", "getCurrentFragment", "()Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseNavFragment;", "currentFragmentTag", "Lapp/dogo/com/dogo_android/enums/FragmentTags;", "getCurrentFragmentTag", "()Lapp/dogo/com/dogo_android/enums/FragmentTags;", "dataToPass", "Landroid/content/Intent;", "defaultFragmentTag", "getDefaultFragmentTag", "entryCreationSavedData", "", "", "", "imageCropper", "Lapp/dogo/com/dogo_android/util/ImageCropper;", "isBackStackEmptyOr1Item", "", "()Z", "isDoCreationLaunched", "isFragmentsResumed", "setFragmentsResumed", "(Z)V", "isLoading", "setLoading", "isResultActivityLaunched", "lastCallTimeTracker", "", "lastFragment", "Landroidx/fragment/app/Fragment;", "getLastFragment", "()Landroidx/fragment/app/Fragment;", "loadingDialogShowed", "getLoadingDialogShowed", "setLoadingDialogShowed", "loginLaunched", "getLoginLaunched", "setLoginLaunched", "mBroadcastReceiver", "Landroid/content/BroadcastReceiver;", "newDataToPass", "getNewDataToPass", "setNewDataToPass", "requestCodeToPass", "", "resultCodeToPass", "snackbar", "Lcom/google/android/material/snackbar/Snackbar;", "startEntryCreationFlag", "getStartEntryCreationFlag", "setStartEntryCreationFlag", "toast", "Landroid/widget/Toast;", "viewModel", "Landroidx/lifecycle/ViewModel;", "getViewModel", "()Landroidx/lifecycle/ViewModel;", "viewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "getViewModelClass", "()Ljava/lang/Class;", "vm", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "callDialog", "tag", "Lapp/dogo/com/dogo_android/enums/DialogTags;", "bundle", "callLoadingDialog", "callTopFragmentOnActivityResults", "requestCode", "resultCode", "data", "changeToChallengeFromNotification", "intent", "changeToShareDialog", "createAndLoadViewFragment", "dismissDialog", "dismissLoadingDialog", "dismissSnackbar", "emergencyExit", "emitFragmentMessage", "message", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$MessageHolder;", "getDefaultStatusBarColor", "getNavBarVisibility", "getNavSize", "getTag", "Lapp/dogo/com/dogo_android/enums/NavigatorTags;", "getTrackingTag", "hideNavigation", "hideSoftKeyboard", "isConnectedToInternet", "launchLogInActivity", "viewSource", "onActivityResult", "onAttachFragment", "fragment", "onBackPressed", "onCreate", "savedInstanceState", "onEmptyBackStack", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPause", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResumeFragments", "onSaveInstanceState", "outState", "onStart", "onStop", "registerToChannel", "endpoint", "Lapp/dogo/com/dogo_android/util/NavFragmentCommunicationChannel$ChannelListener;", "setHomeUpVisible", "hasParent", "setLoadingState", "state", "setTitle", "title", "setupBroadcaster", "showChallengeFromNotification", "challengeId", "linkType", "showChallengeProfileDialog", "dogProfileModel", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "badges", "", "dogProfile", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "showChallengeShareDialog", "bitmap", "Landroid/net/Uri;", "model", "Lapp/dogo/com/dogo_android/model/ChallengeEntryModel;", "showChallengeWithCreationStarted", "id", "newDogId", "welcomeParticipationUri", "showCommentDialog", "entryModel", "entryId", "commentId", "showDogSelectDialog", "requestKey", "skipWelcomeSuggestion", "sourceScreenName", "showEntryCreationDialog", "challengeModel", "Lapp/dogo/com/dogo_android/model/ChallengeModel;", "selectedDog", "comment", "showFanList", "showNavigation", "showSharedImageDialog", "showSnackbar", "snackBarText", "snackBarActionText", "duration", "listener", "Landroid/view/View$OnClickListener;", "showToast", "showVideoPlaybackFullscreenFragment", "Lapp/dogo/com/dogo_android/model/Exam;", "startDogCreation", "dogId", "dogName", "startDogUpdateFlow", "startImageCropper", "shapeOval", "minimumX", "minimumY", "startOvalImageCropperWithNoSizeRestrictions", "startSubscriptionActivity", "lessonId", "subscriptionOffer", "Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/SubscriptionOffer;)V", "switchFragment", "fragmentTag", "switchFullscreenFragment", "enterAnimation", "exitAnimation", "Lapp/dogo/com/dogo_android/enums/FullScreenTag;", "tryShowDialog", "dialog", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyBaseDialogFragment;", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class a0 extends d {

    public static final app.dogo.com.dogo_android.util.e0.a0.a Companion;
    private Intent A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private Map<String, Object> G;
    private app.dogo.com.dogo_android.util.e0.r H;
    private final q I;
    private u J;
    private BroadcastReceiver K;
    private boolean a;
    private boolean b;
    private Bundle c;
    private Toast v;
    private Snackbar w;
    private final Map<String, Long> x;
    private int y;
    private int z;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0010\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/util/base_classes/Navigator$Companion;", "", "()V", "BACK_RETURN_TAG", "", "CALLED_FROM_ONBOARDING", "DEEPLINK_CAMPAING_KEY", "DEEPLINK_COMMENT_ID_KEY", "DEEPLINK_EXTRAS_KEY", "DEEPLINK_LINKTYPE_KEY", "DEEPLINK_PARTNER_KEY", "DEFAULT_STATUS_BAR_COLOR", "", "DOG_SELECT_REQUEST_KEY", "EXAM_RECORDING_ACTIVITY_REQUEST", "GOOGLE_SIGN_IN_REQUEST_CODE", "LANGUAGE_USER_CONFIRMATION_PROMPT", "LOGIN_REQUEST_CODE", "PROFILE_CREATION_FROM_SELECT_REQUEST", "PROFILE_CREATION_REQUEST", "PROFILE_CREATION_REQUEST_WITH_PARTICIPATION", "PROFILE_PHOTO_UPLOAD_REQUEST", "SAVE_STATE_BUNDLE_BASE_ARGUMENTS", "SAVE_STATE_BUNDLE_CROPPER_SETTINGS_KEY", "SAVE_STATE_SERIAZIBLE_LAST_FRAGMENT", "SHOW_RECOMMENDED_PROGRAM_LIST", "WELCOME_LOGIN_REQUEST_CODE", "ZENDESK_INFO_CONFIGURATION", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/util/base_classes/Navigator$setupBroadcaster$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends BroadcastReceiver {

        final app.dogo.com.dogo_android.util.e0.a0 a;
        b(app.dogo.com.dogo_android.util.e0.a0 a0) {
            this.a = a0;
            super();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent2) {
            Object mESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE;
            String str;
            String obj3;
            Object obj4;
            n.f(context, "context");
            n.f(intent2, "intent");
            if (intent2.getAction() != null && n.b(intent2.getAction(), "upload_completed")) {
                if (n.b(intent2.getAction(), "upload_completed")) {
                    obj3 = new Bundle();
                    obj3.putString("id", intent2.getStringExtra("extra_request_id"));
                    obj3.putParcelable("data", intent2.getParcelableExtra("extra_download_url"));
                    a0.i(this.a).b(h.MESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE, obj3);
                }
            }
        }
    }
    static {
        a0.a aVar = new a0.a(0);
        a0.Companion = aVar;
    }

    public a0() {
        super();
        d0();
        Bundle bundle = new Bundle();
        this.c = bundle;
        HashMap hashMap = new HashMap();
        this.x = hashMap;
        q qVar = new q();
        this.I = qVar;
        u uVar = new u();
        this.J = uVar;
    }

    private final void A0() {
        q qVar;
        try {
            this.I.v(this);
            a.d(th);
            Throwable th = 2131886123;
            t0(th);
        }
    }

    private final void D0(String string, Integer integer2, String string3, SubscriptionOffer subscriptionOffer4) {
        int obj3;
        SubscriptionScreenKey subscriptionScreenKey = new SubscriptionScreenKey(string, subscriptionOffer4, string3);
        Intent obj2 = subscriptionScreenKey.buildIntent(this);
        if (integer2 != 0) {
            startActivityForResult(obj2, integer2.intValue());
        } else {
            startActivity(obj2);
        }
        obj3 = SubscriptionActivity.class.getSimpleName();
        n.e(obj3, "SubscriptionActivity::class.java.simpleName");
        this.x.put(obj3, Long.valueOf(System.currentTimeMillis()));
    }

    public static void F0(app.dogo.com.dogo_android.util.e0.a0 a0, String string2, String string3, SubscriptionOffer subscriptionOffer4, int i5, Object object6) {
        int obj3;
        int obj4;
        if (object6 != null) {
        } else {
            final int i = 0;
            if (i5 & 2 != 0) {
                obj3 = i;
            }
            if (i5 &= 4 != 0) {
                obj4 = i;
            }
            a0.E0(string2, obj3, obj4);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startSubscriptionActivity");
        throw obj1;
    }

    private final boolean K() {
        int i;
        boolean z;
        if (!this.I.k()) {
            if (this.b) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public static void K0(app.dogo.com.dogo_android.util.e0.a0 a0, j j2, Bundle bundle3, int i4, int i5, int i6, Object object7) {
        int obj4;
        int obj5;
        if (object7 != null) {
        } else {
            final int i = 0;
            if (i6 & 4 != 0) {
                obj4 = i;
            }
            if (i6 &= 8 != 0) {
                obj5 = i;
            }
            a0.J0(j2, bundle3, obj4, obj5);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchFullscreenFragment");
        throw obj1;
    }

    public static void L(app.dogo.com.dogo_android.util.e0.a0 a0, u.b u$b2) {
        a0.W(a0, b2);
    }

    private final void L0(app.dogo.com.dogo_android.util.e0.u u, c c2) {
        int obj2;
        String obj3;
        try {
            u.show(getSupportFragmentManager(), c2.getTag());
            u = 0;
            u = new Object[u];
            c2 = "Can not perform this action after onSaveInstanceState";
            a.c(c2, u);
        }
    }

    public static void M(app.dogo.com.dogo_android.util.e0.a0 a0, String string2) {
        a0.U(a0, string2);
    }

    public static void N(app.dogo.com.dogo_android.util.e0.a0 a0, Boolean boolean2) {
        a0.V(a0, boolean2);
    }

    public static void O(app.dogo.com.dogo_android.util.e0.a0 a0) {
        a0.X(a0);
    }

    public static void P(app.dogo.com.dogo_android.util.e0.a0 a0, Integer integer2) {
        a0.T(a0, integer2);
    }

    public static void S(app.dogo.com.dogo_android.util.e0.a0 a0, int i2, String string3, int i4, Object object5) {
        int obj1;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj1 = 10000;
            }
            a0.Q(obj1, string3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchLogInActivity");
        throw obj0;
    }

    private static final void T(app.dogo.com.dogo_android.util.e0.a0 a0, Integer integer2) {
        int obj2;
        n.f(a0, "this$0");
        if (integer2 == 0) {
        } else {
            a0.t0(integer2.intValue());
        }
    }

    private static final void U(app.dogo.com.dogo_android.util.e0.a0 a0, String string2) {
        n.f(a0, "this$0");
        if (string2 == null) {
        } else {
            a0.u0(string2);
        }
    }

    private static final void V(app.dogo.com.dogo_android.util.e0.a0 a0, Boolean boolean2) {
        boolean obj2;
        n.f(a0, "this$0");
        if (boolean2) {
            if (boolean2.booleanValue()) {
                a0.m();
            } else {
                a0.s();
            }
        }
    }

    private static final void W(app.dogo.com.dogo_android.util.e0.a0 a0, u.b u$b2) {
        Object str;
        Object obj1;
        Bundle obj2;
        n.f(a0, "this$0");
        if (b2 != null) {
            a0.J.b(b2.a(), b2.b());
        }
    }

    private static final void X(app.dogo.com.dogo_android.util.e0.a0 a0) {
        Object tag;
        int statusBarColor;
        Window intValue3;
        int i;
        Window intValue;
        int window;
        int intValue2;
        int obj6;
        n.f(a0, "this$0");
        List list = a0.getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        tag = p.l0(list);
        if ((Fragment)tag == null) {
            i = statusBarColor;
        } else {
            i = k1.b((Fragment)tag);
        }
        if (i == 0) {
        } else {
            statusBarColor = i.getStatusBarColor();
        }
        final int i4 = 67108864;
        if (statusBarColor == 0) {
            a0.getWindow().clearFlags(i4);
        } else {
            if (statusBarColor.intValue() != 2131100375) {
            } else {
                a0.getWindow().addFlags(i4);
            }
        }
        if (statusBarColor != 0 && statusBarColor.intValue() != 0) {
            if (statusBarColor.intValue() != 0) {
                a0.getWindow().setStatusBarColor(a0.getColor(statusBarColor.intValue()));
            } else {
                a0.getWindow().setStatusBarColor(a0.getColor(a0.A()));
            }
        } else {
        }
        if (!tag instanceof t) {
            obj6 = "Fragment not defined";
            if (i == 0) {
            } else {
                tag = i.getTag();
                if (tag == null) {
                } else {
                    obj6 = tag;
                }
            }
            a.f(n.o("Fragment attached ", obj6), new Object[0]);
        }
    }

    private final void d0() {
        a0.b bVar = new a0.b(this);
        this.K = bVar;
    }

    public static final u i(app.dogo.com.dogo_android.util.e0.a0 a0) {
        return a0.J;
    }

    public static void l(app.dogo.com.dogo_android.util.e0.a0 a0, c c2, Bundle bundle3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = 0;
            }
            a0.k(c2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callDialog");
        throw obj0;
    }

    private final void m0(String string, boolean z2, String string3) {
        i iVar = new i(string, z2, string3);
        g1.X(this, iVar);
    }

    private final void n(int i, int i2, Intent intent3) {
        int previous;
        int i3;
        List list = getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
        }
        previous = 0;
        if ((Fragment)previous == 0) {
        } else {
            (Fragment)previous.onActivityResult(i, i2, intent3);
        }
    }

    public static void s0(app.dogo.com.dogo_android.util.e0.a0 a0, String string2, String string3, int i4, View.OnClickListener view$OnClickListener5, int i6, Object object7) {
        int obj3;
        int obj5;
        if (object7 != null) {
        } else {
            final int i = 0;
            if (i6 & 2 != 0) {
                obj3 = i;
            }
            if (i6 &= 8 != 0) {
                obj5 = i;
            }
            a0.r0(string2, obj3, i4, obj5);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSnackbar");
        throw obj1;
    }

    public static void y0(app.dogo.com.dogo_android.util.e0.a0 a0, String string2, int i3, int i4, Object object5) {
        int obj1;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj1 = 0;
            }
            a0.w0(obj1, i3);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startDogCreation");
        throw obj0;
    }

    @Override // androidx.appcompat.app.d
    protected int A() {
        return 2131100379;
    }

    @Override // androidx.appcompat.app.d
    public final Fragment B() {
        int previous;
        int i;
        List list = getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
        }
        previous = 0;
        return (Fragment)previous;
    }

    @Override // androidx.appcompat.app.d
    public final void B0(boolean z, int i2, int i3) {
        boolean z2;
        q.b obj2;
        int obj3;
        if (!this.I.k()) {
            this.I.p(i2, i3);
            obj2 = z != null ? q.b.OVAL : q.b.RECTANGLE;
            this.I.o(obj2);
            a.f("Image cropper started", new Object[0]);
            A0();
        }
    }

    @Override // androidx.appcompat.app.d
    public int C() {
        return 8;
    }

    @Override // androidx.appcompat.app.d
    public final void C0() {
        boolean arr;
        String str;
        q.b oVAL;
        if (!this.I.k()) {
            int i = 0;
            this.I.p(i, i);
            this.I.o(q.b.OVAL);
            a.f("Image cropper started", new Object[i]);
            A0();
        }
    }

    @Override // androidx.appcompat.app.d
    public int D() {
        return 0;
    }

    public abstract Class<? extends app.dogo.com.dogo_android.util.e0.r> E();

    @Override // androidx.appcompat.app.d
    public final void E0(String string, String string2, SubscriptionOffer subscriptionOffer3) {
        n.f(string, "viewSource");
        D0(string, 0, string2, subscriptionOffer3);
    }

    @Override // androidx.appcompat.app.d
    public void F() {
    }

    @Override // androidx.appcompat.app.d
    public final void G() {
        Object systemService = getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        (InputMethodManager)systemService.hideSoftInputFromWindow(findViewById(16908290).getRootView().getWindowToken(), 0);
    }

    @Override // androidx.appcompat.app.d
    public void G0(i i) {
        n.f(i, "fragmentTag");
        H0(i, 0);
    }

    @Override // androidx.appcompat.app.d
    public final boolean H() {
        int i;
        if (getSupportFragmentManager().p0() <= 1) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // androidx.appcompat.app.d
    public final void H0(i i, Bundle bundle2) {
        boolean z;
        n.f(i, "fragmentTag");
        c.c(this).b();
        if (!K() && bundle2 != null) {
            c.c(this).b();
            if (bundle2 != null) {
                this.c = bundle2;
            }
            q(i, bundle2);
        }
    }

    @Override // androidx.appcompat.app.d
    public final boolean I() {
        NetworkCapabilities networkCapabilities;
        int i;
        android.net.Network activeNetwork;
        Object systemService = getSystemService("connectivity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        networkCapabilities = systemService.getNetworkCapabilities((ConnectivityManager)systemService.getActiveNetwork());
        if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
            i = networkCapabilities.hasCapability(16) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // androidx.appcompat.app.d
    public final void I0(i i, Bundle bundle2, int i3, int i4) {
        n.f(i, "fragmentTag");
        c.c(this).b();
        if (bundle2 != null) {
            this.c = bundle2;
        }
        app.dogo.com.dogo_android.util.e0.w wVar = b.a(i);
        if (bundle2 != null) {
            wVar.setArguments(bundle2);
        }
        w obj4 = getSupportFragmentManager().n();
        n.e(obj4, "supportFragmentManager.beginTransaction()");
        if (i3 == 0) {
            if (i4 != 0) {
                obj4.q(i3, i4);
            }
        } else {
        }
        obj4.p(2131362551, wVar, i.getTag());
        obj4.f(0);
        obj4.h();
    }

    @Override // androidx.appcompat.app.d
    public final boolean J() {
        return this.D;
    }

    @Override // androidx.appcompat.app.d
    public final void J0(j j, Bundle bundle2, int i3, int i4) {
        n.f(j, "fragmentTag");
        c.c(this).b();
        if (bundle2 != null) {
            this.c = bundle2;
        }
        app.dogo.com.dogo_android.util.e0.x xVar = c.a(j);
        if (bundle2 != null) {
            xVar.setArguments(bundle2);
        }
        w obj4 = getSupportFragmentManager().n();
        n.e(obj4, "supportFragmentManager.beginTransaction()");
        if (i3 == 0) {
            if (i4 != 0) {
                obj4.q(i3, i4);
            }
        } else {
        }
        obj4.p(2131362551, xVar, j.getTag());
        obj4.f(0);
        obj4.h();
    }

    @Override // androidx.appcompat.app.d
    public final void Q(int i, String string2) {
        boolean intent;
        String str;
        int obj3;
        n.f(string2, "viewSource");
        if (!this.a) {
            intent = new Intent(this, LoginActivity.class);
            intent.putExtra("view_source", string2);
            startActivityForResult(intent, i);
            this.a = true;
        }
    }

    @Override // androidx.appcompat.app.d
    public final void R(String string) {
        n.f(string, "viewSource");
        a0.S(this, 0, string, 1, 0);
    }

    @Override // androidx.appcompat.app.d
    public void Y() {
        finish();
    }

    @Override // androidx.appcompat.app.d
    public final void Z(u.a u$a) {
        n.f(a, "endpoint");
        a.e(this.J);
    }

    @Override // androidx.appcompat.app.d
    public void a0(boolean z) {
    }

    @Override // androidx.appcompat.app.d
    protected void attachBaseContext(Context context) {
        n.f(context, "newBase");
        t.a companion = t.Companion;
        final Context obj4 = companion.b(context, n2.b(App.Companion.l().W()));
        super.attachBaseContext(obj4);
        android.content.res.Resources resources = getResources();
        n.e(resources, "resources");
        companion.c(resources, obj4);
        a.b(this);
    }

    @Override // androidx.appcompat.app.d
    public final void b0(boolean z) {
        this.D = z;
    }

    @Override // androidx.appcompat.app.d
    public void c0(String string) {
    }

    @Override // androidx.appcompat.app.d
    public final void e0(String string, String string2) {
        Bundle bundle = new Bundle();
        bundle.putString("challengeId", string);
        bundle.putString("linkType", string2);
        H0(i.CHALLENGE_HOME_FRAGMENT, bundle);
    }

    public final void f0(DogProfileModel dogProfileModel, List<String> list2) {
        Object liteDogProfile;
        DogProfileModel obj2;
        n.f(list2, "badges");
        if (dogProfileModel != null) {
            liteDogProfile = new LiteDogProfile(dogProfileModel);
            g0(liteDogProfile, list2);
        } else {
            t0(2131886123);
        }
    }

    public final void g0(LiteDogProfile liteDogProfile, List<String> list2) {
        app.dogo.com.dogo_android.util.e0.a0 a0Var;
        j cHALLENGE_PROFILE_DETAILS_DIALOG_FRAGMENT;
        Bundle bundle;
        int i3;
        int i2;
        int i;
        int i4;
        int obj9;
        Object obj10;
        final String str = "badges";
        n.f(list2, str);
        if (liteDogProfile != null) {
            bundle = new Bundle();
            bundle.putParcelable("liteDogProfile", liteDogProfile);
            obj9 = new ArrayList(list2);
            bundle.putStringArrayList(str, obj9);
            bundle.putInt("style", 2131951968);
            a0.K0(this, j.CHALLENGE_PROFILE_DETAILS_DIALOG_FRAGMENT, bundle, 0, 0, 12, 0);
        } else {
            t0(2131886123);
        }
    }

    @Override // androidx.appcompat.app.d
    public final void h0(Uri uri, ChallengeEntryModel challengeEntryModel2) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("bitmap", uri);
        bundle.putParcelable("model", challengeEntryModel2);
        k(c.CHALLENGE_SHARE_DIALOG, bundle);
    }

    @Override // androidx.appcompat.app.d
    public final void i0(String string, String string2, Uri uri3) {
        Map obj4;
        Object obj5;
        final int i2 = 1;
        final String str2 = "challengeId";
        this.F = i2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.G = linkedHashMap;
        n.d(linkedHashMap);
        linkedHashMap.put(str2, string);
        obj4 = this.G;
        n.d(obj4);
        obj4.put("dogId", string2);
        if (getSupportFragmentManager().N0() && uri3 != null) {
            this.F = i2;
            linkedHashMap = new LinkedHashMap();
            this.G = linkedHashMap;
            n.d(linkedHashMap);
            linkedHashMap.put(str2, string);
            obj4 = this.G;
            n.d(obj4);
            obj4.put("dogId", string2);
            if (uri3 != null) {
                obj4 = this.G;
                n.d(obj4);
                obj4.put("welcomeParticipationUri", uri3);
            }
        }
        this.F = false;
        Bundle bundle = new Bundle();
        bundle.putString(str2, string);
        bundle.putString("uploadDogId", string2);
        if (uri3 != null) {
            bundle.putParcelable("uploadPhoto", uri3);
        }
        H0(i.CHALLENGE_HOME_FRAGMENT, bundle);
        obj4 = findViewById(2131362866);
        if ((BottomNavigationView)obj4 != null) {
            (BottomNavigationView)obj4.getMenu().getItem(2).setChecked(i2);
        }
    }

    @Override // androidx.appcompat.app.d
    public final void j(c c) {
        n.f(c, "tag");
        int i = 0;
        a0.l(this, c, i, 2, i);
    }

    @Override // androidx.appcompat.app.d
    public final void j0(ChallengeEntryModel challengeEntryModel) {
        final String str = "entryModel";
        n.f(challengeEntryModel, str);
        Bundle bundle = new Bundle();
        bundle.putInt("style", 2131951968);
        bundle.putString("entryId", challengeEntryModel.getDocumentId());
        bundle.putParcelable(str, challengeEntryModel);
        a0.K0(this, j.CHALLENGE_COMMENTS_DIALOG, bundle, 0, 0, 12, 0);
    }

    @Override // androidx.appcompat.app.d
    public final void k(c c, Bundle bundle2) {
        c lOADING_DIALOG_FRAGMENT;
        Fragment fragment;
        boolean z;
        String tag;
        boolean key;
        Bundle obj5;
        n.f(c, "tag");
        lOADING_DIALOG_FRAGMENT = 1;
        b0(lOADING_DIALOG_FRAGMENT);
        if (c == c.LOADING_DIALOG_FRAGMENT && getSupportFragmentManager().N0()) {
            lOADING_DIALOG_FRAGMENT = 1;
            b0(lOADING_DIALOG_FRAGMENT);
            if (getSupportFragmentManager().N0()) {
            }
            this.E = lOADING_DIALOG_FRAGMENT;
        }
        fragment = getSupportFragmentManager().k0(c.getTag());
        if ((u)fragment == null) {
            fragment = a.a(c);
            if (fragment == null) {
            } else {
                fragment.setArguments(bundle2);
                tag = "style";
                if (bundle2 != null && bundle2.containsKey(tag)) {
                    fragment.setArguments(bundle2);
                    tag = "style";
                    if (bundle2.containsKey(tag)) {
                        fragment.setStyle(0, bundle2.getInt(tag));
                    }
                }
                L0(fragment, c);
            }
            RuntimeException obj4 = new RuntimeException("Dialog whit this tag was not found");
            throw obj4;
        }
        (u)fragment.T1(this);
    }

    @Override // androidx.appcompat.app.d
    public final void k0(String string, String string2) {
        Bundle bundle = new Bundle();
        bundle.putString("entryId", string);
        bundle.putString("commentId", string2);
        bundle.putInt("style", 2131951968);
        a0.K0(this, j.CHALLENGE_COMMENTS_DIALOG, bundle, 0, 0, 12, 0);
    }

    @Override // androidx.appcompat.app.d
    public final void l0(String string, String string2) {
        n.f(string, "requestKey");
        n.f(string2, "sourceScreenName");
        m0(string, true, string2);
    }

    @Override // androidx.appcompat.app.d
    public final void m() {
        final int i = 0;
        a0.l(this, c.LOADING_DIALOG_FRAGMENT, i, 2, i);
    }

    @Override // androidx.appcompat.app.d
    public final void n0(ChallengeModel challengeModel, LiteDogProfile liteDogProfile2, String string3, String string4) {
        Bundle bundle = new Bundle();
        bundle.putInt("style", 2131951968);
        bundle.putParcelable("challengeModel", challengeModel);
        bundle.putParcelable("selectedDog", liteDogProfile2);
        bundle.putString("comment", string3);
        bundle.putString("entryId", string4);
        k(c.CHALLENGE_ENTRY_CREATION, bundle);
    }

    @Override // androidx.appcompat.app.d
    public final void o(Intent intent) {
        String queryParameter;
        String str;
        Object obj3;
        n.f(intent, "intent");
        obj3 = intent.getParcelableExtra("android.intent.extra.STREAM");
        if ((Uri)obj3 != null) {
            e0((Uri)obj3.getQueryParameter("extra"), obj3.getQueryParameter("linkType"));
        }
    }

    @Override // androidx.appcompat.app.d
    public final void o0(String string, String string2) {
        Bundle bundle = new Bundle();
        bundle.putInt("style", 2131951968);
        bundle.putString("challenge_id", string2);
        bundle.putString("id", string);
        a0.K0(this, j.CHALLENGE_FAN_LIST_DIALOG_FRAGMENT, bundle, 0, 0, 12, 0);
    }

    @Override // androidx.appcompat.app.d
    protected void onActivityResult(int i, int i2, Intent intent3) {
        int stringExtra;
        int i3;
        q qVar;
        int intent;
        int i4;
        String parcelableExtra2;
        android.os.Parcelable parcelableExtra;
        int obj7;
        super.onActivityResult(i, i2, intent3);
        final int i5 = -1;
        i4 = 0;
        if (i != 11100 && i != 11101 && i != 11103) {
            if (i != 11101) {
                if (i != 11103) {
                } else {
                    this.b = i4;
                    stringExtra = "newDogId";
                    parcelableExtra2 = "welcomeParticipationUri";
                    n.d(intent3);
                    if (i2 == i5 && intent3.getParcelableExtra(parcelableExtra2) != null) {
                        n.d(intent3);
                        if (intent3.getParcelableExtra(parcelableExtra2) != null) {
                            i0(o.WELCOME_CHALLENGE.getId(), intent3.getStringExtra(stringExtra), (Uri)intent3.getParcelableExtra(parcelableExtra2));
                        } else {
                            n.d(intent3);
                            if (i2 == i5 && intent3.hasExtra(parcelableExtra2)) {
                                n.d(intent3);
                                if (intent3.hasExtra(parcelableExtra2)) {
                                    i0(o.WELCOME_CHALLENGE.getId(), intent3.getStringExtra(stringExtra), 0);
                                }
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        if (i != 10000 && i != 10002) {
            if (i != 10002) {
            } else {
                this.a = i4;
            }
        } else {
        }
        app.dogo.com.dogo_android.util.e0.r rVar = this.H;
        n.d(rVar);
        rVar.m(i, i2, intent3, this);
        this.I.m(i, i2, intent3, this);
        this.I.l(i, i2, intent3);
        int i6 = 1;
        if (this.C) {
            n(i, i2, intent3);
        } else {
            this.y = i;
            this.z = i2;
            if (intent3 == null) {
            } else {
                intent = new Intent(intent3);
            }
            this.A = intent;
            this.B = i6;
        }
        if (i == 10100 && i2 == i5) {
            if (i2 == i5) {
                i4 = i6;
            }
            obj7 = new k(i4);
            g1.X(this, obj7);
        }
    }

    @Override // androidx.appcompat.app.d
    public void onAttachFragment(Fragment fragment) {
        n.f(fragment, "fragment");
        super.onAttachFragment(fragment);
        if (fragment instanceof v) {
            (v)fragment.f0(this);
        }
    }

    @Override // androidx.appcompat.app.d
    public void onBackPressed() {
        int i;
        Fragment fragment = B();
        if (fragment instanceof w) {
            i = (w)fragment.V1();
        } else {
            i = 0;
        }
        if (i == 0) {
            if (!H()) {
                G();
                super.onBackPressed();
            } else {
                Y();
            }
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        q qVar;
        String str;
        Bundle obj3;
        super.onCreate(bundle);
        if (bundle != null) {
            this.c = bundle.getBundle("arguments");
            this.I.q(bundle.getBundle("image_cropper_settings"));
        }
        Class cls = E();
        n.d(cls);
        obj3 = h0.b(this).a(cls);
        this.H = (r)obj3;
        n.d(obj3);
        n nVar = new n(this);
        obj3.c.observe(this, nVar);
        obj3 = this.H;
        n.d(obj3);
        k kVar = new k(this);
        obj3.b.observe(this, kVar);
        obj3 = this.H;
        n.d(obj3);
        l lVar = new l(this);
        obj3.v.observe(this, lVar);
        obj3 = this.H;
        n.d(obj3);
        j jVar = new j(this);
        obj3.k().observe(this, jVar);
        m mVar = new m(this);
        getSupportFragmentManager().i(mVar);
    }

    @Override // androidx.appcompat.app.d
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        n.f(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return 1;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.d
    protected void onPause() {
        super.onPause();
        this.C = false;
    }

    @Override // androidx.appcompat.app.d
    public void onRequestPermissionsResult(int i, String[] string2Arr2, int[] i3Arr3) {
        int obj2;
        n.f(string2Arr2, "permissions");
        n.f(i3Arr3, "grantResults");
        super.onRequestPermissionsResult(i, string2Arr2, i3Arr3);
        this.I.n(i, string2Arr2, i3Arr3, this);
    }

    @Override // androidx.appcompat.app.d
    protected void onResumeFragments() {
        boolean z2;
        boolean lOADING_DIALOG_FRAGMENT;
        boolean z;
        int i;
        Intent intent;
        String str;
        super.onResumeFragments();
        if (this.B) {
            n(this.y, this.z, this.A);
            this.B = false;
        }
        if (this.D && !this.E) {
            if (!this.E) {
                intent = 0;
                a0.l(this, c.LOADING_DIALOG_FRAGMENT, intent, 2, intent);
            }
        }
        if (this.F) {
            Map map = this.G;
            n.d(map);
            Map map2 = this.G;
            n.d(map2);
            Map map3 = this.G;
            n.d(map3);
            i0((String)map.get("challengeId"), (String)map2.get("dogId"), (Uri)map3.get("welcomeParticipationUri"));
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
        final a aVar = a.b(this);
        n.e(aVar, "getInstance(this)");
        BroadcastReceiver broadcastReceiver = this.K;
        n.d(broadcastReceiver);
        aVar.c(broadcastReceiver, PhotoUploadNotificationService.Companion.a());
    }

    @Override // androidx.appcompat.app.d
    public void onStop() {
        super.onStop();
        final BroadcastReceiver broadcastReceiver = this.K;
        n.d(broadcastReceiver);
        a.b(this).e(broadcastReceiver);
    }

    @Override // androidx.appcompat.app.d
    public final void p(Intent intent) {
        String queryParameter;
        String queryParameter2;
        String str;
        Object obj4;
        n.f(intent, "intent");
        obj4 = intent.getParcelableExtra("android.intent.extra.STREAM");
        if ((Uri)obj4 != null) {
            q0((Uri)obj4.getQueryParameter("entryId"), obj4.getQueryParameter("challengeId"), obj4.getQueryParameter("linkType"));
        }
    }

    @Override // androidx.appcompat.app.d
    public void p0() {
    }

    @Override // androidx.appcompat.app.d
    public app.dogo.com.dogo_android.util.e0.w q(i i, Bundle bundle2) {
        boolean z;
        int i2;
        String obj6;
        n.f(i, "tag");
        app.dogo.com.dogo_android.util.e0.w wVar = b.b(i, z());
        if (bundle2 != null) {
            wVar.setArguments(bundle2);
        }
        obj6 = i.getTag();
        final int i3 = 1;
        obj6 = getSupportFragmentManager();
        n.e(obj6, "supportFragmentManager");
        z = obj6.p0();
        i2 = 0;
        if (!wVar.L1() && z > 0) {
            obj6 = getSupportFragmentManager();
            n.e(obj6, "supportFragmentManager");
            z = obj6.p0();
            i2 = 0;
            if (z > 0) {
            }
            obj6 = "parent";
        }
        w wVar2 = getSupportFragmentManager().n();
        wVar2.p(2131362533, wVar, i.getTag());
        wVar2.f(obj6);
        wVar2.s(i3);
        wVar2.h();
        return wVar;
    }

    @Override // androidx.appcompat.app.d
    public final void q0(String string, String string2, String string3) {
        Bundle bundle = new Bundle();
        bundle.putString("entryId", string);
        bundle.putString("challengeId", string2);
        bundle.putString("linkType", string3);
        a0.K0(this, j.CHALLENGE_COMMENTS_DIALOG, bundle, 0, 0, 12, 0);
    }

    @Override // androidx.appcompat.app.d
    public final void r(c c) {
        n.f(c, "tag");
        final int i = 0;
        if (c == c.LOADING_DIALOG_FRAGMENT) {
            b0(i);
        }
        Fragment obj3 = getSupportFragmentManager().k0(c.getTag());
        if ((d)obj3 != null) {
            (d)obj3.dismiss();
            this.E = i;
        }
    }

    @Override // androidx.appcompat.app.d
    public final void r0(String string, String string2, int i3, View.OnClickListener view$OnClickListener4) {
        n.f(string, "snackBarText");
        t();
        final Snackbar obj2 = Snackbar.e0(findViewById(2131363244), string, i3);
        obj2.h0(string2, onClickListener4);
        this.w = obj2;
        n.d(obj2);
        obj2.T();
    }

    @Override // androidx.appcompat.app.d
    public final void s() {
        r(c.LOADING_DIALOG_FRAGMENT);
    }

    @Override // androidx.appcompat.app.d
    public final void t() {
        final Snackbar snackbar = this.w;
        if (snackbar != null) {
            n.d(snackbar);
            snackbar.u();
        }
    }

    @Override // androidx.appcompat.app.d
    public final void t0(int i) {
        Toast toast = this.v;
        if (toast != null) {
            n.d(toast);
            toast.cancel();
        }
        final Toast obj2 = Toast.makeText(this, i, 1);
        this.v = obj2;
        n.d(obj2);
        obj2.show();
    }

    @Override // androidx.appcompat.app.d
    public void u() {
    }

    @Override // androidx.appcompat.app.d
    public final void u0(String string) {
        Toast toast = this.v;
        if (toast != null) {
            n.d(toast);
            toast.cancel();
        }
        final Toast obj2 = Toast.makeText(this, string, 1);
        this.v = obj2;
        n.d(obj2);
        obj2.show();
    }

    @Override // androidx.appcompat.app.d
    public final void v(u.b u$b) {
        this.J.c(b);
    }

    @Override // androidx.appcompat.app.d
    public final void v0(Exam exam) {
        Object str;
        Object string;
        j vIDEO_EXAM_PLAYBACK;
        Bundle bundle;
        int i;
        int i3;
        int i4;
        int i2;
        Object obj9;
        if (I()) {
            bundle = new Bundle();
            bundle.putSerializable("model", exam);
            a0.K0(this, j.VIDEO_EXAM_PLAYBACK, bundle, 0, 0, 12, 0);
        } else {
            string = getString(2131886953);
            n.e(string, "getString(R.string.no_internet_connection)");
            a0.s0(this, string, 0, -1, 0, 10, 0);
        }
    }

    @Override // androidx.appcompat.app.d
    public final Bundle w() {
        Bundle bundle;
        if (this.c == null) {
            bundle = new Bundle();
            this.c = bundle;
        }
        return this.c;
    }

    @Override // androidx.appcompat.app.d
    public final void w0(String string, int i2) {
        x0(string, i2, true, 0);
    }

    @Override // androidx.appcompat.app.d
    public final app.dogo.com.dogo_android.util.e0.w x() {
        Object list;
        int i;
        boolean empty;
        int i2;
        int i3;
        boolean z;
        list = getSupportFragmentManager().v0();
        n.e(list, "supportFragmentManager.fragments");
        i2 = 0;
        if (size-- >= 0) {
        }
        list = list.get(i2);
        if (!list.isEmpty() && list instanceof w) {
            list = list.get(i2);
            if (list instanceof w) {
                return (w)(Fragment)(Fragment)list;
            }
        }
        return null;
    }

    @Override // androidx.appcompat.app.d
    public final void x0(String string, int i2, boolean z3, String string4) {
        boolean fVar;
        f fVar2;
        String str;
        String str2;
        boolean z;
        int i4;
        int i3;
        int i;
        int obj9;
        if (!this.b) {
            super(string, string4, z3, 0, 8, 0);
            startActivityForResult(fVar.buildIntent(this), i2);
            this.b = true;
        }
    }

    @Override // androidx.appcompat.app.d
    public final i y() {
        int i2;
        int i;
        app.dogo.com.dogo_android.util.e0.w wVar = x();
        if (wVar == null) {
            i2 = i;
        } else {
            i2 = wVar.D1();
        }
        if (i2 instanceof i) {
            i = i2;
        }
        return i;
    }

    @Override // androidx.appcompat.app.d
    public abstract i z();

    @Override // androidx.appcompat.app.d
    public final void z0(String string, String string2, int i3) {
        n.f(string, "dogId");
        n.f(string2, "dogName");
        x0(string, i3, true, string2);
    }
}
