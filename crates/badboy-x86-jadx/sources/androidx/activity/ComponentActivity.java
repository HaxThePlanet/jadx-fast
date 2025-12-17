package androidx.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnDrawListener;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.contextaware.ContextAware;
import androidx.activity.contextaware.ContextAwareHelper;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ComponentActivity;
import androidx.core.app.MultiWindowModeChangedInfo;
import androidx.core.app.OnMultiWindowModeChangedProvider;
import androidx.core.app.OnNewIntentProvider;
import androidx.core.app.OnPictureInPictureModeChangedProvider;
import androidx.core.app.OnUserLeaveHintProvider;
import androidx.core.app.PictureInPictureModeChangedInfo;
import androidx.core.content.OnConfigurationChangedProvider;
import androidx.core.content.OnTrimMemoryProvider;
import androidx.core.util.Consumer;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.Lifecycle.State;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.ReportFragment.Companion;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory;
import androidx.lifecycle.ViewModelProvider.Factory;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryController.Companion;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.tracing.Trace;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0016\u0018\u0000 ¼\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\u00082\u00020\t2\u00020\n2\u00020\u000b2\u00020\u000c2\u00020\r2\u00020\u000e2\u00020\u000f2\u00020\u00102\u00020\u0011:\n»\u0001¼\u0001½\u0001¾\u0001¿\u0001B\u0011\u0008\u0017\u0012\u0008\u0008\u0001\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014B\u0005¢\u0006\u0002\u0010\u0015J\u001c\u0010[\u001a\u00020\\2\u0008\u0010]\u001a\u0004\u0018\u00010^2\u0008\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020\\2\u0006\u0010b\u001a\u00020cH\u0016J\u0018\u0010a\u001a\u00020\\2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u0003H\u0016J \u0010a\u001a\u00020\\2\u0006\u0010b\u001a\u00020c2\u0006\u0010d\u001a\u00020\u00032\u0006\u0010e\u001a\u00020fH\u0017J\u0010\u0010g\u001a\u00020\\2\u0006\u0010h\u001a\u00020=H\u0003J\u0014\u0010i\u001a\u00020\\2\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020E0DJ\u000e\u0010k\u001a\u00020\\2\u0006\u0010j\u001a\u00020lJ\u0014\u0010m\u001a\u00020\\2\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020G0DJ\u0014\u0010n\u001a\u00020\\2\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020I0DJ\u0014\u0010o\u001a\u00020\\2\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020K0DJ\u0014\u0010p\u001a\u00020\\2\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020\u00130DJ\u000e\u0010q\u001a\u00020\\2\u0006\u0010j\u001a\u00020NJ\u0008\u0010r\u001a\u00020PH\u0002J\u0008\u0010s\u001a\u00020\\H\u0002J\u0008\u0010t\u001a\u00020\\H\u0017J\u0008\u0010u\u001a\u00020\\H\u0016J\"\u0010v\u001a\u00020\\2\u0006\u0010w\u001a\u00020\u00132\u0006\u0010x\u001a\u00020\u00132\u0008\u0010y\u001a\u0004\u0018\u00010IH\u0015J\u0008\u0010z\u001a\u00020\\H\u0017J\u0010\u0010{\u001a\u00020\\2\u0006\u0010|\u001a\u00020EH\u0017J\u0012\u0010}\u001a\u00020\\2\u0008\u0010~\u001a\u0004\u0018\u00010\u007fH\u0014J\u001c\u0010\u0080\u0001\u001a\u00020)2\u0007\u0010\u0081\u0001\u001a\u00020\u00132\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\u001c\u0010\u0084\u0001\u001a\u00020)2\u0007\u0010\u0081\u0001\u001a\u00020\u00132\u0008\u0010\u0085\u0001\u001a\u00030\u0086\u0001H\u0016J\u0012\u0010\u0087\u0001\u001a\u00020\\2\u0007\u0010\u0088\u0001\u001a\u00020)H\u0017J\u001a\u0010\u0087\u0001\u001a\u00020\\2\u0007\u0010\u0088\u0001\u001a\u00020)2\u0006\u0010|\u001a\u00020EH\u0017J\u0012\u0010\u0089\u0001\u001a\u00020\\2\u0007\u0010\u008a\u0001\u001a\u00020IH\u0015J\u001c\u0010\u008b\u0001\u001a\u00020\\2\u0007\u0010\u0081\u0001\u001a\u00020\u00132\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\u0012\u0010\u008c\u0001\u001a\u00020\\2\u0007\u0010\u008d\u0001\u001a\u00020)H\u0017J\u001a\u0010\u008c\u0001\u001a\u00020\\2\u0007\u0010\u008d\u0001\u001a\u00020)2\u0006\u0010|\u001a\u00020EH\u0017J&\u0010\u008e\u0001\u001a\u00020)2\u0007\u0010\u0081\u0001\u001a\u00020\u00132\u0008\u0010]\u001a\u0004\u0018\u00010^2\u0008\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J2\u0010\u008f\u0001\u001a\u00020\\2\u0006\u0010w\u001a\u00020\u00132\u000f\u0010\u0090\u0001\u001a\n\u0012\u0005\u0012\u00030\u0092\u00010\u0091\u00012\u0008\u0010\u0093\u0001\u001a\u00030\u0094\u0001H\u0017¢\u0006\u0003\u0010\u0095\u0001J\u000b\u0010\u0096\u0001\u001a\u0004\u0018\u000101H\u0017J\t\u0010\u0097\u0001\u001a\u0004\u0018\u000101J\u0012\u0010\u0098\u0001\u001a\u00020\\2\u0007\u0010\u0099\u0001\u001a\u00020\u007fH\u0015J\u0012\u0010\u009a\u0001\u001a\u00020\\2\u0007\u0010\u009b\u0001\u001a\u00020\u0013H\u0017J\t\u0010\u009c\u0001\u001a\u00020\\H\u0015J\u000c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001H\u0016JF\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H¡\u00010 \u0001\"\u0005\u0008\u0000\u0010¡\u0001\"\u0005\u0008\u0001\u0010¢\u00012\u0016\u0010£\u0001\u001a\u0011\u0012\u0005\u0012\u0003H¡\u0001\u0012\u0005\u0012\u0003H¢\u00010¤\u00012\u000f\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u0003H¢\u00010¦\u0001JO\u0010\u009f\u0001\u001a\n\u0012\u0005\u0012\u0003H¡\u00010 \u0001\"\u0005\u0008\u0000\u0010¡\u0001\"\u0005\u0008\u0001\u0010¢\u00012\u0016\u0010£\u0001\u001a\u0011\u0012\u0005\u0012\u0003H¡\u0001\u0012\u0005\u0012\u0003H¢\u00010¤\u00012\u0007\u0010§\u0001\u001a\u00020\u00192\u000f\u0010¥\u0001\u001a\n\u0012\u0005\u0012\u0003H¢\u00010¦\u0001J\u0011\u0010¨\u0001\u001a\u00020\\2\u0006\u0010b\u001a\u00020cH\u0016J\u0015\u0010©\u0001\u001a\u00020\\2\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020E0DJ\u000f\u0010ª\u0001\u001a\u00020\\2\u0006\u0010j\u001a\u00020lJ\u0015\u0010«\u0001\u001a\u00020\\2\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020G0DJ\u0015\u0010¬\u0001\u001a\u00020\\2\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020I0DJ\u0015\u0010­\u0001\u001a\u00020\\2\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020K0DJ\u0015\u0010®\u0001\u001a\u00020\\2\u000c\u0010j\u001a\u0008\u0012\u0004\u0012\u00020\u00130DJ\u000f\u0010¯\u0001\u001a\u00020\\2\u0006\u0010j\u001a\u00020NJ\t\u0010°\u0001\u001a\u00020\\H\u0016J\u0013\u0010±\u0001\u001a\u00020\\2\u0008\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u001d\u0010±\u0001\u001a\u00020\\2\u0008\u0010]\u001a\u0004\u0018\u00010^2\u0008\u0010_\u001a\u0004\u0018\u00010`H\u0016J\u0014\u0010±\u0001\u001a\u00020\\2\t\u0008\u0001\u0010²\u0001\u001a\u00020\u0013H\u0016J\u001a\u0010³\u0001\u001a\u00020\\2\u0007\u0010\u008a\u0001\u001a\u00020I2\u0006\u0010w\u001a\u00020\u0013H\u0017J%\u0010³\u0001\u001a\u00020\\2\u0007\u0010\u008a\u0001\u001a\u00020I2\u0006\u0010w\u001a\u00020\u00132\t\u0010´\u0001\u001a\u0004\u0018\u00010\u007fH\u0017JA\u0010µ\u0001\u001a\u00020\\2\u0008\u0010\u008a\u0001\u001a\u00030¶\u00012\u0006\u0010w\u001a\u00020\u00132\t\u0010·\u0001\u001a\u0004\u0018\u00010I2\u0007\u0010¸\u0001\u001a\u00020\u00132\u0007\u0010¹\u0001\u001a\u00020\u00132\u0007\u0010º\u0001\u001a\u00020\u0013H\u0017JL\u0010µ\u0001\u001a\u00020\\2\u0008\u0010\u008a\u0001\u001a\u00030¶\u00012\u0006\u0010w\u001a\u00020\u00132\t\u0010·\u0001\u001a\u0004\u0018\u00010I2\u0007\u0010¸\u0001\u001a\u00020\u00132\u0007\u0010¹\u0001\u001a\u00020\u00132\u0007\u0010º\u0001\u001a\u00020\u00132\t\u0010´\u0001\u001a\u0004\u0018\u00010\u007fH\u0017R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0012\u0010\u0012\u001a\u00020\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u001f8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010!R\u001b\u0010\"\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008&\u0010'\u001a\u0004\u0008$\u0010%R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8VX\u0096\u0084\u0002¢\u0006\u000c\n\u0004\u0008/\u0010'\u001a\u0004\u0008-\u0010.R\u0016\u00100\u001a\u0004\u0018\u0001018WX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00082\u00103R\u0014\u00104\u001a\u0002058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00086\u00107R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010<\u001a\u00020=8FX\u0086\u0084\u0002¢\u0006\u0012\n\u0004\u0008A\u0010'\u0012\u0004\u0008>\u0010\u0015\u001a\u0004\u0008?\u0010@R\u001a\u0010B\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020E0D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010F\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020G0D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010H\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020I0D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020K0D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010L\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00130D0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010M\u001a\u0008\u0012\u0004\u0012\u00020N0CX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010Q\u001a\u00020R8F¢\u0006\u0006\u001a\u0004\u0008S\u0010TR\u0014\u0010U\u001a\u00020VX\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008W\u0010\u0015R\u0014\u0010X\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008Y\u0010Z¨\u0006À\u0001", d2 = {"Landroidx/activity/ComponentActivity;", "Landroidx/core/app/ComponentActivity;", "Landroidx/activity/contextaware/ContextAware;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "Landroidx/lifecycle/HasDefaultViewModelProviderFactory;", "Landroidx/savedstate/SavedStateRegistryOwner;", "Landroidx/activity/OnBackPressedDispatcherOwner;", "Landroidx/activity/result/ActivityResultRegistryOwner;", "Landroidx/activity/result/ActivityResultCaller;", "Landroidx/core/content/OnConfigurationChangedProvider;", "Landroidx/core/content/OnTrimMemoryProvider;", "Landroidx/core/app/OnNewIntentProvider;", "Landroidx/core/app/OnMultiWindowModeChangedProvider;", "Landroidx/core/app/OnPictureInPictureModeChangedProvider;", "Landroidx/core/app/OnUserLeaveHintProvider;", "Landroidx/core/view/MenuHost;", "Landroidx/activity/FullyDrawnReporterOwner;", "contentLayoutId", "", "(I)V", "()V", "_viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "activityResultRegistry", "Landroidx/activity/result/ActivityResultRegistry;", "getActivityResultRegistry", "()Landroidx/activity/result/ActivityResultRegistry;", "contextAwareHelper", "Landroidx/activity/contextaware/ContextAwareHelper;", "defaultViewModelCreationExtras", "Landroidx/lifecycle/viewmodel/CreationExtras;", "getDefaultViewModelCreationExtras", "()Landroidx/lifecycle/viewmodel/CreationExtras;", "defaultViewModelProviderFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getDefaultViewModelProviderFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "defaultViewModelProviderFactory$delegate", "Lkotlin/Lazy;", "dispatchingOnMultiWindowModeChanged", "", "dispatchingOnPictureInPictureModeChanged", "fullyDrawnReporter", "Landroidx/activity/FullyDrawnReporter;", "getFullyDrawnReporter", "()Landroidx/activity/FullyDrawnReporter;", "fullyDrawnReporter$delegate", "lastCustomNonConfigurationInstance", "", "getLastCustomNonConfigurationInstance", "()Ljava/lang/Object;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "menuHostHelper", "Landroidx/core/view/MenuHostHelper;", "nextLocalRequestCode", "Ljava/util/concurrent/atomic/AtomicInteger;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "getOnBackPressedDispatcher$annotations", "getOnBackPressedDispatcher", "()Landroidx/activity/OnBackPressedDispatcher;", "onBackPressedDispatcher$delegate", "onConfigurationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/core/util/Consumer;", "Landroid/content/res/Configuration;", "onMultiWindowModeChangedListeners", "Landroidx/core/app/MultiWindowModeChangedInfo;", "onNewIntentListeners", "Landroid/content/Intent;", "onPictureInPictureModeChangedListeners", "Landroidx/core/app/PictureInPictureModeChangedInfo;", "onTrimMemoryListeners", "onUserLeaveHintListeners", "Ljava/lang/Runnable;", "reportFullyDrawnExecutor", "Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutor;", "savedStateRegistry", "Landroidx/savedstate/SavedStateRegistry;", "getSavedStateRegistry", "()Landroidx/savedstate/SavedStateRegistry;", "savedStateRegistryController", "Landroidx/savedstate/SavedStateRegistryController;", "getSavedStateRegistryController$annotations", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "addContentView", "", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "addMenuProvider", "provider", "Landroidx/core/view/MenuProvider;", "owner", "state", "Landroidx/lifecycle/Lifecycle$State;", "addObserverForBackInvoker", "dispatcher", "addOnConfigurationChangedListener", "listener", "addOnContextAvailableListener", "Landroidx/activity/contextaware/OnContextAvailableListener;", "addOnMultiWindowModeChangedListener", "addOnNewIntentListener", "addOnPictureInPictureModeChangedListener", "addOnTrimMemoryListener", "addOnUserLeaveHintListener", "createFullyDrawnExecutor", "ensureViewModelStore", "initializeViewTreeOwners", "invalidateMenu", "onActivityResult", "requestCode", "resultCode", "data", "onBackPressed", "onConfigurationChanged", "newConfig", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreatePanelMenu", "featureId", "menu", "Landroid/view/Menu;", "onMenuItemSelected", "item", "Landroid/view/MenuItem;", "onMultiWindowModeChanged", "isInMultiWindowMode", "onNewIntent", "intent", "onPanelClosed", "onPictureInPictureModeChanged", "isInPictureInPictureMode", "onPreparePanel", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onRetainCustomNonConfigurationInstance", "onRetainNonConfigurationInstance", "onSaveInstanceState", "outState", "onTrimMemory", "level", "onUserLeaveHint", "peekAvailableContext", "Landroid/content/Context;", "registerForActivityResult", "Landroidx/activity/result/ActivityResultLauncher;", "I", "O", "contract", "Landroidx/activity/result/contract/ActivityResultContract;", "callback", "Landroidx/activity/result/ActivityResultCallback;", "registry", "removeMenuProvider", "removeOnConfigurationChangedListener", "removeOnContextAvailableListener", "removeOnMultiWindowModeChangedListener", "removeOnNewIntentListener", "removeOnPictureInPictureModeChangedListener", "removeOnTrimMemoryListener", "removeOnUserLeaveHintListener", "reportFullyDrawn", "setContentView", "layoutResID", "startActivityForResult", "options", "startIntentSenderForResult", "Landroid/content/IntentSender;", "fillInIntent", "flagsMask", "flagsValues", "extraFlags", "Api33Impl", "Companion", "NonConfigurationInstances", "ReportFullyDrawnExecutor", "ReportFullyDrawnExecutorImpl", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class ComponentActivity extends ComponentActivity implements ContextAware, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner, androidx.activity.OnBackPressedDispatcherOwner, ActivityResultRegistryOwner, ActivityResultCaller, OnConfigurationChangedProvider, OnTrimMemoryProvider, OnNewIntentProvider, OnMultiWindowModeChangedProvider, OnPictureInPictureModeChangedProvider, OnUserLeaveHintProvider, MenuHost, androidx.activity.FullyDrawnReporterOwner {

    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final androidx.activity.ComponentActivity.Companion Companion;
    private ViewModelStore _viewModelStore;
    private final ActivityResultRegistry activityResultRegistry;
    private int contentLayoutId;
    private final ContextAwareHelper contextAwareHelper;
    private final Lazy defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    private final Lazy fullyDrawnReporter$delegate;
    private final MenuHostHelper menuHostHelper;
    private final AtomicInteger nextLocalRequestCode;
    private final Lazy onBackPressedDispatcher$delegate;
    private final CopyOnWriteArrayList<Consumer<Configuration>> onConfigurationChangedListeners;
    private final CopyOnWriteArrayList<Consumer<MultiWindowModeChangedInfo>> onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Intent>> onNewIntentListeners;
    private final CopyOnWriteArrayList<Consumer<PictureInPictureModeChangedInfo>> onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<Consumer<Integer>> onTrimMemoryListeners;
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    private final androidx.activity.ComponentActivity.ReportFullyDrawnExecutor reportFullyDrawnExecutor;
    private final SavedStateRegistryController savedStateRegistryController;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Landroidx/activity/ComponentActivity$Api33Impl;", "", "()V", "getOnBackInvokedDispatcher", "Landroid/window/OnBackInvokedDispatcher;", "activity", "Landroid/app/Activity;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Api33Impl {

        public static final androidx.activity.ComponentActivity.Api33Impl INSTANCE;
        static {
            ComponentActivity.Api33Impl api33Impl = new ComponentActivity.Api33Impl();
            ComponentActivity.Api33Impl.INSTANCE = api33Impl;
        }

        public final OnBackInvokedDispatcher getOnBackInvokedDispatcher(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            OnBackInvokedDispatcher onBackInvokedDispatcher = activity.getOnBackInvokedDispatcher();
            Intrinsics.checkNotNullExpressionValue(onBackInvokedDispatcher, "activity.getOnBackInvokedDispatcher()");
            return onBackInvokedDispatcher;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Landroidx/activity/ComponentActivity$Companion;", "", "()V", "ACTIVITY_RESULT_TAG", "", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0004\u0010\u0005\"\u0004\u0008\u0006\u0010\u0007R\u001c\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\r¨\u0006\u000e", d2 = {"Landroidx/activity/ComponentActivity$NonConfigurationInstances;", "", "()V", "custom", "getCustom", "()Ljava/lang/Object;", "setCustom", "(Ljava/lang/Object;)V", "viewModelStore", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "setViewModelStore", "(Landroidx/lifecycle/ViewModelStore;)V", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class NonConfigurationInstances {

        private Object custom;
        private ViewModelStore viewModelStore;
        public final Object getCustom() {
            return this.custom;
        }

        public final ViewModelStore getViewModelStore() {
            return this.viewModelStore;
        }

        public final void setCustom(Object <set-?>) {
            this.custom = <set-?>;
        }

        public final void setViewModelStore(ViewModelStore <set-?>) {
            this.viewModelStore = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008b\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0007À\u0006\u0001", d2 = {"Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutor;", "Ljava/util/concurrent/Executor;", "activityDestroyed", "", "viewCreated", "view", "Landroid/view/View;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private interface ReportFullyDrawnExecutor extends Executor {
        @Override // java.util.concurrent.Executor
        public abstract void activityDestroyed();

        @Override // java.util.concurrent.Executor
        public abstract void viewCreated(View view);
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0003H\u0016J\u0008\u0010\u0018\u001a\u00020\u0015H\u0016J\u0008\u0010\u0019\u001a\u00020\u0015H\u0016J\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013¨\u0006\u001d", d2 = {"Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutorImpl;", "Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutor;", "Landroid/view/ViewTreeObserver$OnDrawListener;", "Ljava/lang/Runnable;", "(Landroidx/activity/ComponentActivity;)V", "currentRunnable", "getCurrentRunnable", "()Ljava/lang/Runnable;", "setCurrentRunnable", "(Ljava/lang/Runnable;)V", "endWatchTimeMillis", "", "getEndWatchTimeMillis", "()J", "onDrawScheduled", "", "getOnDrawScheduled", "()Z", "setOnDrawScheduled", "(Z)V", "activityDestroyed", "", "execute", "runnable", "onDraw", "run", "viewCreated", "view", "Landroid/view/View;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class ReportFullyDrawnExecutorImpl implements androidx.activity.ComponentActivity.ReportFullyDrawnExecutor, ViewTreeObserver.OnDrawListener, Runnable {

        private Runnable currentRunnable;
        private final long endWatchTimeMillis;
        private boolean onDrawScheduled;
        final androidx.activity.ComponentActivity this$0;
        public static void $r8$lambda$0sNsUdVD3QenIrnQ9NJ_gPQ5x8k(androidx.activity.ComponentActivity.ReportFullyDrawnExecutorImpl componentActivity$ReportFullyDrawnExecutorImpl) {
            ComponentActivity.ReportFullyDrawnExecutorImpl.execute$lambda$0(reportFullyDrawnExecutorImpl);
        }

        public ReportFullyDrawnExecutorImpl(androidx.activity.ComponentActivity this$0) {
            this.this$0 = this$0;
            super();
            this.endWatchTimeMillis = uptimeMillis += l;
        }

        private static final void execute$lambda$0(androidx.activity.ComponentActivity.ReportFullyDrawnExecutorImpl this$0) {
            Runnable currentRunnable;
            if (this$0.currentRunnable != null) {
                Runnable currentRunnable2 = this$0.currentRunnable;
                Intrinsics.checkNotNull(currentRunnable2);
                currentRunnable2.run();
                this$0.currentRunnable = 0;
            }
        }

        @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
        public void activityDestroyed() {
            this.this$0.getWindow().getDecorView().removeCallbacks((Runnable)this);
            this.this$0.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener((ViewTreeObserver.OnDrawListener)this);
        }

        @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
        public void execute(Runnable runnable) {
            boolean equal;
            Looper mainLooper;
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.currentRunnable = runnable;
            View decorView = this.this$0.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            if (this.onDrawScheduled) {
                if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                    decorView.invalidate();
                } else {
                    decorView.postInvalidate();
                }
            } else {
                equal = new ComponentActivity.ReportFullyDrawnExecutorImpl$$ExternalSyntheticLambda0(this);
                decorView.postOnAnimation(equal);
            }
        }

        @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
        public final Runnable getCurrentRunnable() {
            return this.currentRunnable;
        }

        @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
        public final long getEndWatchTimeMillis() {
            return this.endWatchTimeMillis;
        }

        @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
        public final boolean getOnDrawScheduled() {
            return this.onDrawScheduled;
        }

        @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
        public void onDraw() {
            int decorView;
            int fullyDrawnReported;
            long endWatchTimeMillis;
            final Runnable currentRunnable = this.currentRunnable;
            decorView = 0;
            if (currentRunnable != null) {
                currentRunnable.run();
                this.currentRunnable = 0;
                if (this.this$0.getFullyDrawnReporter().isFullyDrawnReported()) {
                    this.onDrawScheduled = decorView;
                    this.this$0.getWindow().getDecorView().post((Runnable)this);
                }
            } else {
                if (Long.compare(uptimeMillis, endWatchTimeMillis) > 0) {
                    this.onDrawScheduled = decorView;
                    this.this$0.getWindow().getDecorView().post((Runnable)this);
                }
            }
        }

        @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
        public void run() {
            this.this$0.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener((ViewTreeObserver.OnDrawListener)this);
        }

        @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
        public final void setCurrentRunnable(Runnable <set-?>) {
            this.currentRunnable = <set-?>;
        }

        @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
        public final void setOnDrawScheduled(boolean <set-?>) {
            this.onDrawScheduled = <set-?>;
        }

        @Override // androidx.activity.ComponentActivity$ReportFullyDrawnExecutor
        public void viewCreated(View view) {
            boolean viewTreeObserver;
            Object obj;
            Intrinsics.checkNotNullParameter(view, "view");
            if (!this.onDrawScheduled) {
                this.onDrawScheduled = true;
                view.getViewTreeObserver().addOnDrawListener((ViewTreeObserver.OnDrawListener)this);
            }
        }
    }
    public static void $r8$lambda$4IRRzyoWeWaykEOcgWGjbNoGAkw(androidx.activity.OnBackPressedDispatcher onBackPressedDispatcher, androidx.activity.ComponentActivity componentActivity2, LifecycleOwner lifecycleOwner3, Lifecycle.Event lifecycle$Event4) {
        ComponentActivity.addObserverForBackInvoker$lambda$7(onBackPressedDispatcher, componentActivity2, lifecycleOwner3, event4);
    }

    public static void $r8$lambda$KUbBm7ckfqTc9QC-gukC86fguu4(androidx.activity.ComponentActivity componentActivity, Context context2) {
        ComponentActivity._init_$lambda$5(componentActivity, context2);
    }

    public static void $r8$lambda$cI7dwLT0wnPzJ9a3oRpjgUF1USM(androidx.activity.ComponentActivity componentActivity) {
        ComponentActivity.menuHostHelper$lambda$0(componentActivity);
    }

    public static void $r8$lambda$h6vvr6zUWA2U1fE-0KsKpOgpr28(androidx.activity.ComponentActivity componentActivity, LifecycleOwner lifecycleOwner2, Lifecycle.Event lifecycle$Event3) {
        ComponentActivity._init_$lambda$2(componentActivity, lifecycleOwner2, event3);
    }

    public static void $r8$lambda$ibk6u1HK7J3AWKL_Wn934v2UVI8(androidx.activity.ComponentActivity componentActivity, LifecycleOwner lifecycleOwner2, Lifecycle.Event lifecycle$Event3) {
        ComponentActivity._init_$lambda$3(componentActivity, lifecycleOwner2, event3);
    }

    public static Bundle $r8$lambda$xTL2e_8-xZHyLBqzsfEVlyFwLP0(androidx.activity.ComponentActivity componentActivity) {
        return ComponentActivity._init_$lambda$4(componentActivity);
    }

    static {
        ComponentActivity.Companion companion = new ComponentActivity.Companion(0);
        ComponentActivity.Companion = companion;
    }

    public ComponentActivity() {
        super();
        ContextAwareHelper contextAwareHelper = new ContextAwareHelper();
        this.contextAwareHelper = contextAwareHelper;
        ComponentActivity$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new ComponentActivity$$ExternalSyntheticLambda0(this);
        MenuHostHelper menuHostHelper = new MenuHostHelper(externalSyntheticLambda0);
        this.menuHostHelper = menuHostHelper;
        this.savedStateRegistryController = SavedStateRegistryController.Companion.create((SavedStateRegistryOwner)this);
        this.reportFullyDrawnExecutor = createFullyDrawnExecutor();
        ComponentActivity.fullyDrawnReporter.2 anon = new ComponentActivity.fullyDrawnReporter.2(this);
        this.fullyDrawnReporter$delegate = LazyKt.lazy((Function0)anon);
        AtomicInteger atomicInteger = new AtomicInteger();
        this.nextLocalRequestCode = atomicInteger;
        ComponentActivity.activityResultRegistry.1 anon2 = new ComponentActivity.activityResultRegistry.1(this);
        this.activityResultRegistry = (ActivityResultRegistry)anon2;
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.onConfigurationChangedListeners = copyOnWriteArrayList;
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.onTrimMemoryListeners = copyOnWriteArrayList2;
        CopyOnWriteArrayList copyOnWriteArrayList3 = new CopyOnWriteArrayList();
        this.onNewIntentListeners = copyOnWriteArrayList3;
        CopyOnWriteArrayList copyOnWriteArrayList4 = new CopyOnWriteArrayList();
        this.onMultiWindowModeChangedListeners = copyOnWriteArrayList4;
        CopyOnWriteArrayList copyOnWriteArrayList5 = new CopyOnWriteArrayList();
        this.onPictureInPictureModeChangedListeners = copyOnWriteArrayList5;
        CopyOnWriteArrayList copyOnWriteArrayList6 = new CopyOnWriteArrayList();
        this.onUserLeaveHintListeners = copyOnWriteArrayList6;
        if (getLifecycle() == null) {
        } else {
            ComponentActivity$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new ComponentActivity$$ExternalSyntheticLambda1(this);
            getLifecycle().addObserver((LifecycleObserver)externalSyntheticLambda1);
            ComponentActivity$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new ComponentActivity$$ExternalSyntheticLambda2(this);
            getLifecycle().addObserver((LifecycleObserver)externalSyntheticLambda2);
            ComponentActivity.4 anon5 = new ComponentActivity.4(this);
            getLifecycle().addObserver((LifecycleObserver)anon5);
            this.savedStateRegistryController.performAttach();
            SavedStateHandleSupport.enableSavedStateHandles((SavedStateRegistryOwner)this);
            ComponentActivity$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new ComponentActivity$$ExternalSyntheticLambda3(this);
            getSavedStateRegistry().registerSavedStateProvider("android:support:activity-result", externalSyntheticLambda3);
            ComponentActivity$$ExternalSyntheticLambda4 externalSyntheticLambda4 = new ComponentActivity$$ExternalSyntheticLambda4(this);
            addOnContextAvailableListener(externalSyntheticLambda4);
            ComponentActivity.defaultViewModelProviderFactory.2 anon3 = new ComponentActivity.defaultViewModelProviderFactory.2(this);
            this.defaultViewModelProviderFactory$delegate = LazyKt.lazy((Function0)anon3);
            ComponentActivity.onBackPressedDispatcher.2 anon4 = new ComponentActivity.onBackPressedDispatcher.2(this);
            this.onBackPressedDispatcher$delegate = LazyKt.lazy((Function0)anon4);
        }
        int i = 0;
        IllegalStateException illegalStateException = new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.".toString());
        throw illegalStateException;
    }

    public ComponentActivity(int contentLayoutId) {
        super();
        this.contentLayoutId = contentLayoutId;
    }

    private static final void _init_$lambda$2(androidx.activity.ComponentActivity this$0, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        Object obj2;
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        obj2 = this$0.getWindow();
        obj2 = obj2.peekDecorView();
        if (event == Lifecycle.Event.ON_STOP && obj2 != null && obj2 != null) {
            obj2 = this$0.getWindow();
            if (obj2 != null) {
                obj2 = obj2.peekDecorView();
                if (obj2 != null) {
                    obj2.cancelPendingInputEvents();
                }
            }
        }
    }

    private static final void _init_$lambda$3(androidx.activity.ComponentActivity this$0, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        boolean obj2;
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        this$0.contextAwareHelper.clearAvailableContext();
        if (event == Lifecycle.Event.ON_DESTROY && !this$0.isChangingConfigurations()) {
            this$0.contextAwareHelper.clearAvailableContext();
            if (!this$0.isChangingConfigurations()) {
                this$0.getViewModelStore().clear();
            }
            this$0.reportFullyDrawnExecutor.activityDestroyed();
        }
    }

    private static final Bundle _init_$lambda$4(androidx.activity.ComponentActivity this$0) {
        Bundle bundle = new Bundle();
        this$0.activityResultRegistry.onSaveInstanceState(bundle);
        return bundle;
    }

    private static final void _init_$lambda$5(androidx.activity.ComponentActivity this$0, Context it) {
        Object activityResultRegistry;
        Intrinsics.checkNotNullParameter(it, "it");
        Bundle consumeRestoredStateForKey = this$0.getSavedStateRegistry().consumeRestoredStateForKey("android:support:activity-result");
        if (consumeRestoredStateForKey != null) {
            this$0.activityResultRegistry.onRestoreInstanceState(consumeRestoredStateForKey);
        }
    }

    public static final void access$addObserverForBackInvoker(androidx.activity.ComponentActivity $this, androidx.activity.OnBackPressedDispatcher dispatcher) {
        $this.addObserverForBackInvoker(dispatcher);
    }

    public static final void access$ensureViewModelStore(androidx.activity.ComponentActivity $this) {
        $this.ensureViewModelStore();
    }

    public static final androidx.activity.ComponentActivity.ReportFullyDrawnExecutor access$getReportFullyDrawnExecutor$p(androidx.activity.ComponentActivity $this) {
        return $this.reportFullyDrawnExecutor;
    }

    public static final void access$onBackPressed$s1027565324(androidx.activity.ComponentActivity $this) {
        super.onBackPressed();
    }

    private final void addObserverForBackInvoker(androidx.activity.OnBackPressedDispatcher dispatcher) {
        ComponentActivity$$ExternalSyntheticLambda5 externalSyntheticLambda5 = new ComponentActivity$$ExternalSyntheticLambda5(dispatcher, this);
        getLifecycle().addObserver((LifecycleObserver)externalSyntheticLambda5);
    }

    private static final void addObserverForBackInvoker$lambda$7(androidx.activity.OnBackPressedDispatcher $dispatcher, androidx.activity.ComponentActivity this$0, LifecycleOwner lifecycleOwner3, Lifecycle.Event event) {
        Object str;
        Object obj3;
        Intrinsics.checkNotNullParameter(lifecycleOwner3, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            $dispatcher.setOnBackInvokedDispatcher(ComponentActivity.Api33Impl.INSTANCE.getOnBackInvokedDispatcher((Activity)this$0));
        }
    }

    private final androidx.activity.ComponentActivity.ReportFullyDrawnExecutor createFullyDrawnExecutor() {
        ComponentActivity.ReportFullyDrawnExecutorImpl reportFullyDrawnExecutorImpl = new ComponentActivity.ReportFullyDrawnExecutorImpl(this);
        return (ComponentActivity.ReportFullyDrawnExecutor)reportFullyDrawnExecutorImpl;
    }

    private final void ensureViewModelStore() {
        Object lastNonConfigurationInstance;
        ViewModelStore _viewModelStore;
        lastNonConfigurationInstance = getLastNonConfigurationInstance();
        if (this._viewModelStore == null && (ComponentActivity.NonConfigurationInstances)lastNonConfigurationInstance != null) {
            lastNonConfigurationInstance = getLastNonConfigurationInstance();
            if ((ComponentActivity.NonConfigurationInstances)(ComponentActivity.NonConfigurationInstances)lastNonConfigurationInstance != null) {
                this._viewModelStore = (ComponentActivity.NonConfigurationInstances)(ComponentActivity.NonConfigurationInstances)lastNonConfigurationInstance.getViewModelStore();
            }
            if (this._viewModelStore == null) {
                _viewModelStore = new ViewModelStore();
                this._viewModelStore = _viewModelStore;
            }
        }
    }

    public static void getOnBackPressedDispatcher$annotations() {
    }

    private static void getSavedStateRegistryController$annotations() {
    }

    private static final void menuHostHelper$lambda$0(androidx.activity.ComponentActivity this$0) {
        this$0.invalidateMenu();
    }

    @Override // androidx.core.app.ComponentActivity
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        initializeViewTreeOwners();
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        this.reportFullyDrawnExecutor.viewCreated(decorView);
        super.addContentView(view, params);
    }

    @Override // androidx.core.app.ComponentActivity
    public void addMenuProvider(MenuProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.menuHostHelper.addMenuProvider(provider);
    }

    @Override // androidx.core.app.ComponentActivity
    public void addMenuProvider(MenuProvider provider, LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.menuHostHelper.addMenuProvider(provider, owner);
    }

    @Override // androidx.core.app.ComponentActivity
    public void addMenuProvider(MenuProvider provider, LifecycleOwner owner, Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(state, "state");
        this.menuHostHelper.addMenuProvider(provider, owner, state);
    }

    public final void addOnConfigurationChangedListener(Consumer<Configuration> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onConfigurationChangedListeners.add(listener);
    }

    @Override // androidx.core.app.ComponentActivity
    public final void addOnContextAvailableListener(OnContextAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.contextAwareHelper.addOnContextAvailableListener(listener);
    }

    public final void addOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onMultiWindowModeChangedListeners.add(listener);
    }

    public final void addOnNewIntentListener(Consumer<Intent> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onNewIntentListeners.add(listener);
    }

    public final void addOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onPictureInPictureModeChangedListeners.add(listener);
    }

    public final void addOnTrimMemoryListener(Consumer<Integer> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onTrimMemoryListeners.add(listener);
    }

    @Override // androidx.core.app.ComponentActivity
    public final void addOnUserLeaveHintListener(Runnable listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onUserLeaveHintListeners.add(listener);
    }

    @Override // androidx.core.app.ComponentActivity
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @Override // androidx.core.app.ComponentActivity
    public CreationExtras getDefaultViewModelCreationExtras() {
        Object aPPLICATION_KEY;
        Object dEFAULT_ARGS_KEY;
        int extras;
        android.app.Application application;
        String str;
        extras = 0;
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(extras, 1, extras);
        if (getApplication() != null) {
            application = getApplication();
            Intrinsics.checkNotNullExpressionValue(application, "application");
            mutableCreationExtras.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, application);
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        dEFAULT_ARGS_KEY = getIntent();
        if (dEFAULT_ARGS_KEY != null) {
            extras = dEFAULT_ARGS_KEY.getExtras();
        }
        if (extras != 0) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, extras);
        }
        return (CreationExtras)mutableCreationExtras;
    }

    @Override // androidx.core.app.ComponentActivity
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return (ViewModelProvider.Factory)this.defaultViewModelProviderFactory$delegate.getValue();
    }

    @Override // androidx.core.app.ComponentActivity
    public androidx.activity.FullyDrawnReporter getFullyDrawnReporter() {
        return (FullyDrawnReporter)this.fullyDrawnReporter$delegate.getValue();
    }

    @Deprecated(message = "Use a {@link androidx.lifecycle.ViewModel} to store non config state.")
    public Object getLastCustomNonConfigurationInstance() {
        Object custom;
        final Object lastNonConfigurationInstance = getLastNonConfigurationInstance();
        if ((ComponentActivity.NonConfigurationInstances)lastNonConfigurationInstance != null) {
            custom = (ComponentActivity.NonConfigurationInstances)lastNonConfigurationInstance.getCustom();
        } else {
            custom = 0;
        }
        return custom;
    }

    @Override // androidx.core.app.ComponentActivity
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override // androidx.core.app.ComponentActivity
    public final androidx.activity.OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return (OnBackPressedDispatcher)this.onBackPressedDispatcher$delegate.getValue();
    }

    @Override // androidx.core.app.ComponentActivity
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.savedStateRegistryController.getSavedStateRegistry();
    }

    @Override // androidx.core.app.ComponentActivity
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
        } else {
            ensureViewModelStore();
            ViewModelStore _viewModelStore = this._viewModelStore;
            Intrinsics.checkNotNull(_viewModelStore);
            return _viewModelStore;
        }
        int i = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.".toString());
        throw illegalStateException;
    }

    @Override // androidx.core.app.ComponentActivity
    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        String str = "window.decorView";
        Intrinsics.checkNotNullExpressionValue(decorView, str);
        ViewTreeLifecycleOwner.set(decorView, (LifecycleOwner)this);
        View decorView2 = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView2, str);
        ViewTreeViewModelStoreOwner.set(decorView2, (ViewModelStoreOwner)this);
        View decorView3 = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView3, str);
        ViewTreeSavedStateRegistryOwner.set(decorView3, (SavedStateRegistryOwner)this);
        View decorView4 = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView4, str);
        ViewTreeOnBackPressedDispatcherOwner.set(decorView4, (OnBackPressedDispatcherOwner)this);
        View decorView5 = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView5, str);
        ViewTreeFullyDrawnReporterOwner.set(decorView5, (FullyDrawnReporterOwner)this);
    }

    @Override // androidx.core.app.ComponentActivity
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      with the appropriate {@link ActivityResultContract} and handling the result in the\n      {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!this.activityResultRegistry.dispatchResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Deprecated(message = "This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    public void onBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    @Override // androidx.core.app.ComponentActivity
    public void onConfigurationChanged(Configuration newConfig) {
        Object next;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Iterator iterator = this.onConfigurationChangedListeners.iterator();
        for (Consumer next : iterator) {
            next.accept(newConfig);
        }
    }

    @Override // androidx.core.app.ComponentActivity
    protected void onCreate(Bundle savedInstanceState) {
        int contentLayoutId;
        this.savedStateRegistryController.performRestore(savedInstanceState);
        this.contextAwareHelper.dispatchOnContextAvailable((Context)this);
        super.onCreate(savedInstanceState);
        ReportFragment.Companion.injectIfNeededIn((Activity)this);
        if (this.contentLayoutId != 0) {
            setContentView(this.contentLayoutId);
        }
    }

    @Override // androidx.core.app.ComponentActivity
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        Object menuHostHelper;
        android.view.MenuInflater menuInflater;
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (featureId == 0) {
            super.onCreatePanelMenu(featureId, menu);
            this.menuHostHelper.onCreateMenu(menu, getMenuInflater());
        }
        return 1;
    }

    @Override // androidx.core.app.ComponentActivity
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        boolean onMenuItemSelected;
        Intrinsics.checkNotNullParameter(item, "item");
        if (super.onMenuItemSelected(featureId, item)) {
            return 1;
        }
        if (featureId == 0) {
            onMenuItemSelected = this.menuHostHelper.onMenuItemSelected(item);
        } else {
            onMenuItemSelected = 0;
        }
        return onMenuItemSelected;
    }

    @Deprecated(message = "Deprecated in android.app.Activity")
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        Object next;
        MultiWindowModeChangedInfo multiWindowModeChangedInfo;
        if (this.dispatchingOnMultiWindowModeChanged) {
        }
        Iterator iterator = this.onMultiWindowModeChangedListeners.iterator();
        for (Consumer next : iterator) {
            multiWindowModeChangedInfo = new MultiWindowModeChangedInfo(isInMultiWindowMode);
            next.accept(multiWindowModeChangedInfo);
        }
    }

    @Override // androidx.core.app.ComponentActivity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        Object next;
        MultiWindowModeChangedInfo multiWindowModeChangedInfo;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
        this.dispatchingOnMultiWindowModeChanged = false;
        Iterator iterator = this.onMultiWindowModeChangedListeners.iterator();
        for (Consumer next : iterator) {
            multiWindowModeChangedInfo = new MultiWindowModeChangedInfo(isInMultiWindowMode, newConfig);
            next.accept(multiWindowModeChangedInfo);
        }
    }

    @Override // androidx.core.app.ComponentActivity
    protected void onNewIntent(Intent intent) {
        Object next;
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Iterator iterator = this.onNewIntentListeners.iterator();
        for (Consumer next : iterator) {
            next.accept(intent);
        }
    }

    @Override // androidx.core.app.ComponentActivity
    public void onPanelClosed(int featureId, Menu menu) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        this.menuHostHelper.onMenuClosed(menu);
        super.onPanelClosed(featureId, menu);
    }

    @Deprecated(message = "Deprecated in android.app.Activity")
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        Object next;
        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo;
        if (this.dispatchingOnPictureInPictureModeChanged) {
        }
        Iterator iterator = this.onPictureInPictureModeChangedListeners.iterator();
        for (Consumer next : iterator) {
            pictureInPictureModeChangedInfo = new PictureInPictureModeChangedInfo(isInPictureInPictureMode);
            next.accept(pictureInPictureModeChangedInfo);
        }
    }

    @Override // androidx.core.app.ComponentActivity
    public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
        Object next;
        PictureInPictureModeChangedInfo pictureInPictureModeChangedInfo;
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
        this.dispatchingOnPictureInPictureModeChanged = false;
        Iterator iterator = this.onPictureInPictureModeChangedListeners.iterator();
        for (Consumer next : iterator) {
            pictureInPictureModeChangedInfo = new PictureInPictureModeChangedInfo(isInPictureInPictureMode, newConfig);
            next.accept(pictureInPictureModeChangedInfo);
        }
    }

    @Override // androidx.core.app.ComponentActivity
    public boolean onPreparePanel(int featureId, View view, Menu menu) {
        Object menuHostHelper;
        Intrinsics.checkNotNullParameter(menu, "menu");
        if (featureId == 0) {
            super.onPreparePanel(featureId, view, menu);
            this.menuHostHelper.onPrepareMenu(menu);
        }
        return 1;
    }

    @Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)} passing\n      in a {@link RequestMultiplePermissions} object for the {@link ActivityResultContract} and\n      handling the result in the {@link ActivityResultCallback#onActivityResult(Object) callback}.")
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        Intent intent = new Intent();
        if (!this.activityResultRegistry.dispatchResult(requestCode, -1, intent.putExtra("androidx.activity.result.contract.extra.PERMISSIONS", permissions).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", grantResults))) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Deprecated(message = "Use a {@link androidx.lifecycle.ViewModel} to store non config state.")
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // androidx.core.app.ComponentActivity
    public final Object onRetainNonConfigurationInstance() {
        ViewModelStore viewModelStore;
        Object lastNonConfigurationInstance;
        final Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        lastNonConfigurationInstance = getLastNonConfigurationInstance();
        if (this._viewModelStore == null && (ComponentActivity.NonConfigurationInstances)lastNonConfigurationInstance != null) {
            lastNonConfigurationInstance = getLastNonConfigurationInstance();
            if ((ComponentActivity.NonConfigurationInstances)(ComponentActivity.NonConfigurationInstances)lastNonConfigurationInstance != null) {
                viewModelStore = (ComponentActivity.NonConfigurationInstances)(ComponentActivity.NonConfigurationInstances)lastNonConfigurationInstance.getViewModelStore();
            }
        }
        if (viewModelStore == null && onRetainCustomNonConfigurationInstance == null) {
            if (onRetainCustomNonConfigurationInstance == null) {
                return null;
            }
        }
        ComponentActivity.NonConfigurationInstances nonConfigurationInstances = new ComponentActivity.NonConfigurationInstances();
        nonConfigurationInstances.setCustom(onRetainCustomNonConfigurationInstance);
        nonConfigurationInstances.setViewModelStore(viewModelStore);
        return nonConfigurationInstances;
    }

    @Override // androidx.core.app.ComponentActivity
    protected void onSaveInstanceState(Bundle outState) {
        boolean lifecycle;
        Lifecycle.State cREATED;
        Intrinsics.checkNotNullParameter(outState, "outState");
        if (lifecycle2 instanceof LifecycleRegistry) {
            lifecycle = getLifecycle();
            Intrinsics.checkNotNull(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            (LifecycleRegistry)lifecycle.setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(outState);
        this.savedStateRegistryController.performSave(outState);
    }

    @Override // androidx.core.app.ComponentActivity
    public void onTrimMemory(int level) {
        Object next;
        Integer valueOf;
        super.onTrimMemory(level);
        Iterator iterator = this.onTrimMemoryListeners.iterator();
        for (Consumer next : iterator) {
            next.accept(Integer.valueOf(level));
        }
    }

    @Override // androidx.core.app.ComponentActivity
    protected void onUserLeaveHint() {
        Object next;
        super.onUserLeaveHint();
        Iterator iterator = this.onUserLeaveHintListeners.iterator();
        for (Runnable next : iterator) {
            next.run();
        }
    }

    @Override // androidx.core.app.ComponentActivity
    public Context peekAvailableContext() {
        return this.contextAwareHelper.peekAvailableContext();
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> contract, ActivityResultCallback<O> callback) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return registerForActivityResult(contract, this.activityResultRegistry, callback);
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> contract, ActivityResultRegistry registry, ActivityResultCallback<O> callback) {
        Intrinsics.checkNotNullParameter(contract, "contract");
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(callback, "callback");
        StringBuilder stringBuilder = new StringBuilder();
        return registry.register(stringBuilder.append("activity_rq#").append(this.nextLocalRequestCode.getAndIncrement()).toString(), (LifecycleOwner)this, contract, callback);
    }

    @Override // androidx.core.app.ComponentActivity
    public void removeMenuProvider(MenuProvider provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.menuHostHelper.removeMenuProvider(provider);
    }

    public final void removeOnConfigurationChangedListener(Consumer<Configuration> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onConfigurationChangedListeners.remove(listener);
    }

    @Override // androidx.core.app.ComponentActivity
    public final void removeOnContextAvailableListener(OnContextAvailableListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.contextAwareHelper.removeOnContextAvailableListener(listener);
    }

    public final void removeOnMultiWindowModeChangedListener(Consumer<MultiWindowModeChangedInfo> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onMultiWindowModeChangedListeners.remove(listener);
    }

    public final void removeOnNewIntentListener(Consumer<Intent> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onNewIntentListeners.remove(listener);
    }

    public final void removeOnPictureInPictureModeChangedListener(Consumer<PictureInPictureModeChangedInfo> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onPictureInPictureModeChangedListeners.remove(listener);
    }

    public final void removeOnTrimMemoryListener(Consumer<Integer> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onTrimMemoryListeners.remove(listener);
    }

    @Override // androidx.core.app.ComponentActivity
    public final void removeOnUserLeaveHintListener(Runnable listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onUserLeaveHintListeners.remove(listener);
    }

    @Override // androidx.core.app.ComponentActivity
    public void reportFullyDrawn() {
        boolean enabled;
        if (Trace.isEnabled()) {
            try {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
                super.reportFullyDrawn();
                getFullyDrawnReporter().fullyDrawnReported();
                Trace.endSection();
                Trace.endSection();
                throw th;
            }
        }
    }

    @Override // androidx.core.app.ComponentActivity
    public void setContentView(int layoutResID) {
        initializeViewTreeOwners();
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        this.reportFullyDrawnExecutor.viewCreated(decorView);
        super.setContentView(layoutResID);
    }

    @Override // androidx.core.app.ComponentActivity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        this.reportFullyDrawnExecutor.viewCreated(decorView);
        super.setContentView(view);
    }

    @Override // androidx.core.app.ComponentActivity
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        initializeViewTreeOwners();
        View decorView = getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        this.reportFullyDrawnExecutor.viewCreated(decorView);
        super.setContentView(view, params);
    }

    @Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartActivityForResult} object for the {@link ActivityResultContract}.")
    public void startActivityForResult(Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.startActivityForResult(intent, requestCode);
    }

    @Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartActivityForResult} object for the {@link ActivityResultContract}.")
    public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.startActivityForResult(intent, requestCode, options);
    }

    @Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartIntentSenderForResult} object for the\n      {@link ActivityResultContract}.")
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    @Deprecated(message = "This method has been deprecated in favor of using the Activity Result API\n      which brings increased type safety via an {@link ActivityResultContract} and the prebuilt\n      contracts for common intents available in\n      {@link androidx.activity.result.contract.ActivityResultContracts}, provides hooks for\n      testing, and allow receiving results in separate, testable classes independent from your\n      activity. Use\n      {@link #registerForActivityResult(ActivityResultContract, ActivityResultCallback)}\n      passing in a {@link StartIntentSenderForResult} object for the\n      {@link ActivityResultContract}.")
    public void startIntentSenderForResult(IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
    }
}
