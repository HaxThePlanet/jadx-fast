package androidx.compose.runtime;

import androidx.collection.MutableIntIntMap;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.changelist.ComposerChangeListWriter;
import androidx.compose.runtime.changelist.FixupList;
import androidx.compose.runtime.collection.IntMap;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.PersistentCompositionLocalMapKt;
import androidx.compose.runtime.snapshots.ListUtilsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000ñ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u000c\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u001b\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u00082\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008**\u0001A\u0008\u0000\u0018\u00002\u00020\u0001:\u0004Ø\u0002Ù\u0002BG\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000c\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\n\u0010\u008d\u0001\u001a\u00030\u008e\u0001H\u0002J\n\u0010\u008f\u0001\u001a\u00030\u008e\u0001H\u0002JM\u0010\u0090\u0001\u001a\u00030\u008e\u0001\"\u0005\u0008\u0000\u0010\u0091\u0001\"\u0005\u0008\u0001\u0010\u0092\u00012\u0008\u0010\u0093\u0001\u001a\u0003H\u0091\u00012#\u0010\u0094\u0001\u001a\u001e\u0012\u0005\u0012\u0003H\u0092\u0001\u0012\u0005\u0012\u0003H\u0091\u0001\u0012\u0005\u0012\u00030\u008e\u00010\u0095\u0001¢\u0006\u0003\u0008\u0096\u0001H\u0016¢\u0006\u0003\u0010\u0097\u0001J\t\u0010\u0098\u0001\u001a\u00020\u0005H\u0016J2\u0010\u0099\u0001\u001a\u0003H\u0092\u0001\"\u0005\u0008\u0000\u0010\u0092\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u00182\u000f\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0092\u00010\u009b\u0001H\u0087\u0008¢\u0006\u0003\u0010\u009c\u0001J\u0014\u0010\u009d\u0001\u001a\u00020\u00182\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0017J\u0012\u0010\u009d\u0001\u001a\u00020\u00182\u0007\u0010\u0093\u0001\u001a\u00020\u0018H\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\u0008\u0010\u0093\u0001\u001a\u00030\u009e\u0001H\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\u0008\u0010\u0093\u0001\u001a\u00030\u009f\u0001H\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\u0008\u0010\u0093\u0001\u001a\u00030 \u0001H\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\u0008\u0010\u0093\u0001\u001a\u00030¡\u0001H\u0017J\u0012\u0010\u009d\u0001\u001a\u00020\u00182\u0007\u0010\u0093\u0001\u001a\u00020\u001cH\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\u0008\u0010\u0093\u0001\u001a\u00030¢\u0001H\u0017J\u0013\u0010\u009d\u0001\u001a\u00020\u00182\u0008\u0010\u0093\u0001\u001a\u00030£\u0001H\u0017J\u0014\u0010¤\u0001\u001a\u00020\u00182\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0017J\u0010\u0010¥\u0001\u001a\u00030\u008e\u0001H\u0000¢\u0006\u0003\u0008¦\u0001J\n\u0010§\u0001\u001a\u00030\u008e\u0001H\u0002J\n\u0010¨\u0001\u001a\u00030\u008e\u0001H\u0002J\n\u0010©\u0001\u001a\u00030\u008e\u0001H\u0016J@\u0010ª\u0001\u001a\u00030\u008e\u00012\u0014\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020~0¬\u00012\u0015\u0010­\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u008e\u00010\u009b\u0001¢\u0006\u0003\u0008®\u0001H\u0000¢\u0006\u0006\u0008¯\u0001\u0010°\u0001J,\u0010±\u0001\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001c2\u0007\u0010³\u0001\u001a\u00020\u001c2\u0007\u0010´\u0001\u001a\u00020\u001cH\u0002J(\u0010µ\u0001\u001a\u0003H\u0092\u0001\"\u0005\u0008\u0000\u0010\u0092\u00012\u000f\u0010¶\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0092\u00010·\u0001H\u0017¢\u0006\u0003\u0010¸\u0001J\n\u0010¹\u0001\u001a\u00030\u008e\u0001H\u0002J\"\u0010º\u0001\u001a\u00030\u008e\u0001\"\u0005\u0008\u0000\u0010\u0092\u00012\u000f\u0010»\u0001\u001a\n\u0012\u0005\u0012\u0003H\u0092\u00010\u009b\u0001H\u0016J\t\u0010¼\u0001\u001a\u00020hH\u0002J\u0012\u0010¼\u0001\u001a\u00020h2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J\u0010\u0010½\u0001\u001a\u00030\u008e\u0001H\u0000¢\u0006\u0003\u0008¾\u0001J\u0013\u0010¿\u0001\u001a\u00030\u008e\u00012\u0007\u0010\u009d\u0001\u001a\u00020\u0018H\u0017J\n\u0010À\u0001\u001a\u00030\u008e\u0001H\u0016J\n\u0010Á\u0001\u001a\u00030\u008e\u0001H\u0016J\u0010\u0010Â\u0001\u001a\u00030\u008e\u0001H\u0000¢\u0006\u0003\u0008Ã\u0001J?\u0010Ä\u0001\u001a\u00030\u008e\u00012\u0014\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020~0¬\u00012\u0017\u0010­\u0001\u001a\u0012\u0012\u0005\u0012\u00030\u008e\u0001\u0018\u00010\u009b\u0001¢\u0006\u0003\u0008®\u0001H\u0002¢\u0006\u0003\u0010°\u0001J\u001c\u0010Å\u0001\u001a\u00030\u008e\u00012\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010Æ\u0001\u001a\u00020\u001cH\u0002J\n\u0010Ç\u0001\u001a\u00030\u008e\u0001H\u0016J\u0013\u0010È\u0001\u001a\u00030\u008e\u00012\u0007\u0010É\u0001\u001a\u00020\u0018H\u0002J\n\u0010Ê\u0001\u001a\u00030\u008e\u0001H\u0017J\n\u0010Ë\u0001\u001a\u00030\u008e\u0001H\u0002J\n\u0010Ì\u0001\u001a\u00030\u008e\u0001H\u0017J\n\u0010Í\u0001\u001a\u00030\u008e\u0001H\u0016J\n\u0010Î\u0001\u001a\u00030\u008e\u0001H\u0017J\n\u0010Ï\u0001\u001a\u00030\u008e\u0001H\u0017J\n\u0010Ð\u0001\u001a\u00030\u008e\u0001H\u0017J\n\u0010Ñ\u0001\u001a\u00030\u008e\u0001H\u0017J\u000c\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001H\u0017J\n\u0010Ô\u0001\u001a\u00030\u008e\u0001H\u0016J\u0008\u0010Õ\u0001\u001a\u00030\u008e\u0001J\n\u0010Ö\u0001\u001a\u00030\u008e\u0001H\u0002J\u0013\u0010×\u0001\u001a\u00030\u008e\u00012\u0007\u0010Ø\u0001\u001a\u00020\u001cH\u0016J\n\u0010Ù\u0001\u001a\u00030\u008e\u0001H\u0002J\u001e\u0010Ú\u0001\u001a\u00030\u008e\u00012\u0007\u0010É\u0001\u001a\u00020\u00182\t\u0010Û\u0001\u001a\u0004\u0018\u00010kH\u0002J\u001b\u0010Ü\u0001\u001a\u00030\u008e\u00012\u0007\u0010Ý\u0001\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u0018H\u0002J\n\u0010Þ\u0001\u001a\u00030\u008e\u0001H\u0002J\n\u0010ß\u0001\u001a\u00030\u008e\u0001H\u0002J\u000e\u0010E\u001a\u00020\u0018H\u0000¢\u0006\u0003\u0008à\u0001J#\u0010á\u0001\u001a\u00030\u008e\u00012\u000c\u0010\u0093\u0001\u001a\u0007\u0012\u0002\u0008\u00030â\u00012\t\u0010ã\u0001\u001a\u0004\u0018\u00010~H\u0017J+\u0010ä\u0001\u001a\u00030\u008e\u00012\u001f\u0010å\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030è\u0001\u0012\u0007\u0012\u0005\u0018\u00010è\u00010ç\u00010æ\u0001H\u0002J+\u0010é\u0001\u001a\u00030\u008e\u00012\u001f\u0010å\u0001\u001a\u001a\u0012\u0015\u0012\u0013\u0012\u0005\u0012\u00030è\u0001\u0012\u0007\u0012\u0005\u0018\u00010è\u00010ç\u00010æ\u0001H\u0017J\u0012\u0010ê\u0001\u001a\u00020\u001c2\u0007\u0010ë\u0001\u001a\u00020\u001cH\u0002J9\u0010ì\u0001\u001a\u00030\u008e\u00012\u0010\u0010­\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010~0â\u00012\u0007\u0010í\u0001\u001a\u00020h2\t\u0010ã\u0001\u001a\u0004\u0018\u00010~2\u0007\u0010î\u0001\u001a\u00020\u0018H\u0002J\u001f\u0010ï\u0001\u001a\u00020~2\t\u0010ð\u0001\u001a\u0004\u0018\u00010~2\t\u0010ñ\u0001\u001a\u0004\u0018\u00010~H\u0017J\u000b\u0010ò\u0001\u001a\u0004\u0018\u00010~H\u0001J\u000b\u0010ó\u0001\u001a\u0004\u0018\u00010~H\u0001J-\u0010ô\u0001\u001a\u00020\u001c2\u0007\u0010õ\u0001\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010³\u0001\u001a\u00020\u001c2\u0007\u0010ö\u0001\u001a\u00020\u001cH\u0002J\u000f\u0010÷\u0001\u001a\u00020\u001cH\u0001¢\u0006\u0003\u0008ø\u0001J!\u0010ù\u0001\u001a\u00030\u008e\u00012\u000f\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u009b\u0001H\u0000¢\u0006\u0003\u0008ú\u0001J\u0012\u0010û\u0001\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J%\u0010ü\u0001\u001a\u00020\u00182\u0014\u0010«\u0001\u001a\u000f\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020~0¬\u0001H\u0000¢\u0006\u0003\u0008ý\u0001Jo\u0010þ\u0001\u001a\u0003Hÿ\u0001\"\u0005\u0008\u0000\u0010ÿ\u00012\u000b\u0008\u0002\u0010\u0080\u0002\u001a\u0004\u0018\u00010\u000f2\u000b\u0008\u0002\u0010\u0081\u0002\u001a\u0004\u0018\u00010\u000f2\u000b\u0008\u0002\u0010ë\u0001\u001a\u0004\u0018\u00010\u001c2\u001e\u0008\u0002\u0010Z\u001a\u0018\u0012\u0013\u0012\u0011\u0012\u0004\u0012\u000205\u0012\u0006\u0012\u0004\u0018\u00010~0ç\u00010æ\u00012\u000f\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u0003Hÿ\u00010\u009b\u0001H\u0002¢\u0006\u0003\u0010\u0082\u0002J\n\u0010\u0083\u0002\u001a\u00030\u008e\u0001H\u0002J\n\u0010\u0084\u0002\u001a\u00030\u008e\u0001H\u0002J\u0013\u0010\u0085\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u0086\u0002\u001a\u00020MH\u0002J\u0013\u0010\u0087\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u0088\u0002\u001a\u00020hH\u0002J\u001b\u0010\u0089\u0002\u001a\u00030\u008e\u00012\u000f\u0010\u008a\u0002\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u009b\u0001H\u0016J%\u0010\u008b\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u008c\u0002\u001a\u00020\u001c2\u0007\u0010\u008d\u0002\u001a\u00020\u001c2\u0007\u0010\u008e\u0002\u001a\u00020\u001cH\u0002J\u0013\u0010\u008f\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u0090\u0002\u001a\u00020zH\u0016J\u000b\u0010\u0091\u0002\u001a\u0004\u0018\u00010MH\u0002J\u000b\u0010\u0092\u0002\u001a\u0004\u0018\u00010~H\u0016J\n\u0010\u0093\u0002\u001a\u00030\u008e\u0001H\u0002J\u0013\u0010\u0094\u0002\u001a\u00030\u008e\u00012\u0007\u0010\u0095\u0002\u001a\u00020\u001cH\u0002J\n\u0010\u0096\u0002\u001a\u00030\u008e\u0001H\u0017J\n\u0010\u0097\u0002\u001a\u00030\u008e\u0001H\u0002J\n\u0010\u0098\u0002\u001a\u00030\u008e\u0001H\u0002J\n\u0010\u0099\u0002\u001a\u00030\u008e\u0001H\u0017J\u0014\u0010\u009a\u0002\u001a\u00030\u008e\u00012\u0008\u0010\u009a\u0002\u001a\u00030\u009b\u0002H\u0017J\n\u0010\u009c\u0002\u001a\u00030\u008e\u0001H\u0017J\u001d\u0010\u009d\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\u0008\u0010\u009a\u0002\u001a\u00030\u009b\u0002H\u0017J\u000f\u0010\u009e\u0002\u001a\u00020\u001cH\u0000¢\u0006\u0003\u0008\u009f\u0002J?\u0010 \u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010¡\u0002\u001a\u0004\u0018\u00010~2\u0008\u0010¢\u0002\u001a\u00030£\u00022\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\u0002ø\u0001\u0000¢\u0006\u0006\u0008¥\u0002\u0010¦\u0002J\n\u0010§\u0002\u001a\u00030\u008e\u0001H\u0017J\u0013\u0010¨\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0002J\u001e\u0010¨\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~H\u0002J\u001e\u0010ª\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~H\u0017J\n\u0010«\u0002\u001a\u00030\u008e\u0001H\u0016J\u0018\u0010¬\u0002\u001a\u00030\u008e\u00012\u000c\u0010\u0093\u0001\u001a\u0007\u0012\u0002\u0008\u00030­\u0002H\u0017J'\u0010®\u0002\u001a\u00030\u008e\u00012\u0015\u0010¯\u0002\u001a\u0010\u0012\u000b\u0008\u0001\u0012\u0007\u0012\u0002\u0008\u00030­\u00020°\u0002H\u0017¢\u0006\u0003\u0010±\u0002J\u001e\u0010²\u0002\u001a\u00030\u008e\u00012\u0007\u0010É\u0001\u001a\u00020\u00182\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\u0002J\u0013\u0010³\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0017J\u0013\u0010´\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0017J\u0012\u0010µ\u0002\u001a\u00020\u00012\u0007\u0010¶\u0001\u001a\u00020\u001cH\u0017J\u001e\u0010¶\u0002\u001a\u00030\u008e\u00012\u0007\u0010¶\u0001\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~H\u0016J\n\u0010·\u0002\u001a\u00030\u008e\u0001H\u0016J\u0008\u0010¸\u0002\u001a\u00030\u008e\u0001J\n\u0010¹\u0002\u001a\u00030\u008e\u0001H\u0002J#\u0010º\u0002\u001a\u00020\u00182\u0007\u0010\u0090\u0002\u001a\u0002052\t\u0010»\u0002\u001a\u0004\u0018\u00010~H\u0000¢\u0006\u0003\u0008¼\u0002J\u0015\u0010½\u0002\u001a\u00030\u008e\u00012\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0001J2\u0010¾\u0002\u001a\u00030\u008e\u00012\u0007\u0010¿\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~2\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\u0082\u0008J\u001c\u0010À\u0002\u001a\u00030\u008e\u00012\u0007\u0010Á\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001cH\u0082\u0008J2\u0010Â\u0002\u001a\u00030\u008e\u00012\u0007\u0010¿\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001c2\t\u0010©\u0002\u001a\u0004\u0018\u00010~2\t\u0010¤\u0002\u001a\u0004\u0018\u00010~H\u0082\u0008J\u001c\u0010Ã\u0002\u001a\u00030\u008e\u00012\u0007\u0010¿\u0002\u001a\u00020\u001c2\u0006\u0010r\u001a\u00020\u001cH\u0082\u0008J\u001c\u0010Ä\u0002\u001a\u00030\u008e\u00012\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010Å\u0002\u001a\u00020\u001cH\u0002J\u001c\u0010Æ\u0002\u001a\u00030\u008e\u00012\u0007\u0010²\u0001\u001a\u00020\u001c2\u0007\u0010Ç\u0002\u001a\u00020\u001cH\u0002J\u001b\u0010È\u0002\u001a\u00020h2\u0007\u0010É\u0002\u001a\u00020h2\u0007\u0010Ê\u0002\u001a\u00020hH\u0002J\u0015\u0010Ë\u0002\u001a\u00030\u008e\u00012\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0016J\u0015\u0010Ì\u0002\u001a\u00030\u008e\u00012\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0002J\u0015\u0010Í\u0002\u001a\u00030\u008e\u00012\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010~H\u0001J\u0012\u0010Î\u0002\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J\n\u0010Ï\u0002\u001a\u00030\u008e\u0001H\u0016J\n\u0010Ð\u0002\u001a\u00030\u008e\u0001H\u0002J\n\u0010Ñ\u0002\u001a\u00030\u008e\u0001H\u0002J\u0010\u0010Ò\u0002\u001a\u00030\u008e\u0001H\u0000¢\u0006\u0003\u0008Ó\u0002J1\u0010Ô\u0002\u001a\u0003Hÿ\u0001\"\u0005\u0008\u0000\u0010ÿ\u00012\u0006\u0010s\u001a\u00020t2\u000f\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u0003Hÿ\u00010\u009b\u0001H\u0082\u0008¢\u0006\u0003\u0010Õ\u0002J\u0016\u0010Ö\u0002\u001a\u00020\u001c*\u00020t2\u0007\u0010²\u0001\u001a\u00020\u001cH\u0002J\u0018\u0010×\u0002\u001a\u0004\u0018\u00010~*\u00020t2\u0007\u0010ë\u0001\u001a\u00020\u001cH\u0002R\u0014\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148WX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0014\u0010$\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008&\u0010'R\u000e\u0010(\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c8\u0016@RX\u0097\u000e¢\u0006\u000e\n\u0000\u0012\u0004\u0008+\u0010,\u001a\u0004\u0008-\u0010\u001eR\u0014\u0010.\u001a\u00020/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00080\u00101R\u0014\u00102\u001a\u00020\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00083\u0010\u001eR\u0016\u00104\u001a\u0004\u0018\u0001058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00086\u00107R\u001a\u00108\u001a\u00020\u00188VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u00089\u0010,\u001a\u0004\u0008:\u0010\u001aR\u001c\u0010;\u001a\u0004\u0018\u00010\u000cX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008<\u0010=\"\u0004\u0008>\u0010?R\u0010\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010H\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\u0008I\u0010\u001aR\u0014\u0010J\u001a\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008K\u0010\u001aR\u000e\u0010L\u001a\u00020MX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020OX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008Q\u0010R\"\u0004\u0008S\u0010TR&\u0010U\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00188\u0016@RX\u0097\u000e¢\u0006\u000e\n\u0000\u0012\u0004\u0008V\u0010,\u001a\u0004\u0008W\u0010\u001aR\u0014\u0010X\u001a\u0008\u0012\u0004\u0012\u0002050YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010Z\u001a\u0008\u0012\u0004\u0012\u00020\\0[X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010]\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008^\u0010\u001aR\u001e\u0010_\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018@BX\u0080\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008`\u0010\u001aR\u000e\u0010\r\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u00020hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010l\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010k0YX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u0004\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010n\u001a\n\u0012\u0004\u0012\u00020h\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010p\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010q\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010r\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010s\u001a\u00020tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008u\u0010v\"\u0004\u0008w\u0010xR\u0016\u0010y\u001a\u0004\u0018\u00010z8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008{\u0010|R\u0017\u0010}\u001a\u0004\u0018\u00010~8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\u0008\u007f\u0010\u0080\u0001R\u000f\u0010\u0081\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0082\u0001\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0083\u0001\u001a\u00020\u00188VX\u0097\u0004¢\u0006\u000e\u0012\u0005\u0008\u0084\u0001\u0010,\u001a\u0005\u0008\u0085\u0001\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0086\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0087\u0001\u001a\u00030\u0088\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0089\u0001\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u008a\u0001\u001a\u0004\u0018\u00010~*\u00020t8BX\u0082\u0004¢\u0006\u0008\u001a\u0006\u0008\u008b\u0001\u0010\u008c\u0001\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006Ú\u0002", d2 = {"Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/Composer;", "applier", "Landroidx/compose/runtime/Applier;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "abandonSet", "", "Landroidx/compose/runtime/RememberObserver;", "changes", "Landroidx/compose/runtime/changelist/ChangeList;", "lateChanges", "composition", "Landroidx/compose/runtime/ControlledComposition;", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/SlotTable;Ljava/util/Set;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/ControlledComposition;)V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "areChildrenComposing", "", "getAreChildrenComposing$runtime_release", "()Z", "changeCount", "", "getChangeCount$runtime_release", "()I", "changeListWriter", "Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", "childrenComposing", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compositionToken", "<set-?>", "compoundKeyHash", "getCompoundKeyHash$annotations", "()V", "getCompoundKeyHash", "currentCompositionLocalMap", "Landroidx/compose/runtime/CompositionLocalMap;", "getCurrentCompositionLocalMap", "()Landroidx/compose/runtime/CompositionLocalMap;", "currentMarker", "getCurrentMarker", "currentRecomposeScope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "getCurrentRecomposeScope$runtime_release", "()Landroidx/compose/runtime/RecomposeScopeImpl;", "defaultsInvalid", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "deferredChanges", "getDeferredChanges$runtime_release", "()Landroidx/compose/runtime/changelist/ChangeList;", "setDeferredChanges$runtime_release", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "derivedStateObserver", "androidx/compose/runtime/ComposerImpl$derivedStateObserver$1", "Landroidx/compose/runtime/ComposerImpl$derivedStateObserver$1;", "entersStack", "Landroidx/compose/runtime/IntStack;", "forceRecomposeScopes", "forciblyRecompose", "groupNodeCount", "hasInvalidations", "getHasInvalidations", "hasPendingChanges", "getHasPendingChanges$runtime_release", "insertAnchor", "Landroidx/compose/runtime/Anchor;", "insertFixups", "Landroidx/compose/runtime/changelist/FixupList;", "insertTable", "getInsertTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "setInsertTable$runtime_release", "(Landroidx/compose/runtime/SlotTable;)V", "inserting", "getInserting$annotations", "getInserting", "invalidateStack", "Landroidx/compose/runtime/Stack;", "invalidations", "", "Landroidx/compose/runtime/Invalidation;", "isComposing", "isComposing$runtime_release", "isDisposed", "isDisposed$runtime_release", "nodeCountOverrides", "", "nodeCountVirtualOverrides", "Landroidx/collection/MutableIntIntMap;", "nodeExpected", "nodeIndex", "parentProvider", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "parentStateStack", "pending", "Landroidx/compose/runtime/Pending;", "pendingStack", "providerCache", "providerUpdates", "Landroidx/compose/runtime/collection/IntMap;", "providersInvalid", "providersInvalidStack", "rGroupIndex", "reader", "Landroidx/compose/runtime/SlotReader;", "getReader$runtime_release", "()Landroidx/compose/runtime/SlotReader;", "setReader$runtime_release", "(Landroidx/compose/runtime/SlotReader;)V", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "reusing", "reusingGroup", "skipping", "getSkipping$annotations", "getSkipping", "sourceMarkersEnabled", "writer", "Landroidx/compose/runtime/SlotWriter;", "writerHasAProvider", "node", "getNode", "(Landroidx/compose/runtime/SlotReader;)Ljava/lang/Object;", "abortRoot", "", "addRecomposeScope", "apply", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "cache", "invalid", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "changed", "", "", "", "", "", "", "changedInstance", "changesApplied", "changesApplied$runtime_release", "cleanUpCompose", "clearUpdatedNodeCounts", "collectParameterInformation", "composeContent", "invalidationsRequested", "Landroidx/compose/runtime/collection/ScopeMap;", "content", "Landroidx/compose/runtime/Composable;", "composeContent$runtime_release", "(Landroidx/compose/runtime/collection/ScopeMap;Lkotlin/jvm/functions/Function2;)V", "compoundKeyOf", "group", "recomposeGroup", "recomposeKey", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createFreshInsertTable", "createNode", "factory", "currentCompositionLocalScope", "deactivate", "deactivate$runtime_release", "deactivateToEndGroup", "disableReusing", "disableSourceInformation", "dispose", "dispose$runtime_release", "doCompose", "doRecordDownsFor", "nearestCommonRoot", "enableReusing", "end", "isNode", "endDefaults", "endGroup", "endMovableGroup", "endNode", "endProvider", "endProviders", "endReplaceGroup", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "endReuseFromRoot", "endRoot", "endToMarker", "marker", "ensureWriter", "enterGroup", "newPending", "exitGroup", "expectedNodeCount", "finalizeCompose", "forceFreshInsertTable", "forceRecomposeScopes$runtime_release", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentGuarded", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "insertMovableContentReferences", "insertedGroupVirtualIndex", "index", "invokeMovableContentLambda", "locals", "force", "joinKey", "left", "right", "nextSlot", "nextSlotForCache", "nodeIndexOf", "groupLocation", "recomposeIndex", "parentKey", "parentKey$runtime_release", "prepareCompose", "prepareCompose$runtime_release", "rGroupIndexOf", "recompose", "recompose$runtime_release", "recomposeMovableContent", "R", "from", "to", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/ControlledComposition;Ljava/lang/Integer;Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "recomposeToGroupEnd", "recordDelete", "recordInsert", "anchor", "recordProviderUpdate", "providers", "recordSideEffect", "effect", "recordUpsAndDowns", "oldGroup", "newGroup", "commonRoot", "recordUsed", "scope", "rememberObserverAnchor", "rememberedValue", "reportAllMovableContent", "reportFreeMovableContent", "groupBeingRemoved", "skipCurrentGroup", "skipGroup", "skipReaderToGroupEnd", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "stacksSize", "stacksSize$runtime_release", "start", "objectKey", "kind", "Landroidx/compose/runtime/GroupKind;", "data", "start-BaiHCIY", "(ILjava/lang/Object;ILjava/lang/Object;)V", "startDefaults", "startGroup", "dataKey", "startMovableGroup", "startNode", "startProvider", "Landroidx/compose/runtime/ProvidedValue;", "startProviders", "values", "", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReaderGroup", "startReplaceGroup", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "startReuseFromRoot", "startRoot", "tryImminentInvalidation", "instance", "tryImminentInvalidation$runtime_release", "updateCachedValue", "updateCompoundKeyWhenWeEnterGroup", "groupKey", "updateCompoundKeyWhenWeEnterGroupKeyHash", "keyHash", "updateCompoundKeyWhenWeExitGroup", "updateCompoundKeyWhenWeExitGroupKeyHash", "updateNodeCount", "count", "updateNodeCountOverrides", "newCount", "updateProviderMapGroup", "parentScope", "currentProviders", "updateRememberedValue", "updateSlot", "updateValue", "updatedNodeCount", "useNode", "validateNodeExpected", "validateNodeNotExpected", "verifyConsistent", "verifyConsistent$runtime_release", "withReader", "(Landroidx/compose/runtime/SlotReader;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "groupCompoundKeyPart", "nodeAt", "CompositionContextHolder", "CompositionContextImpl", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComposerImpl implements androidx.compose.runtime.Composer {

    public static final int $stable = 8;
    private final Set<androidx.compose.runtime.RememberObserver> abandonSet;
    private final androidx.compose.runtime.Applier<?> applier;
    private final ComposerChangeListWriter changeListWriter;
    private ChangeList changes;
    private int childrenComposing;
    private final androidx.compose.runtime.ControlledComposition composition;
    private int compositionToken;
    private int compoundKeyHash;
    private ChangeList deferredChanges;
    private final androidx.compose.runtime.ComposerImpl.derivedStateObserver.1 derivedStateObserver;
    private final androidx.compose.runtime.IntStack entersStack;
    private boolean forceRecomposeScopes;
    private boolean forciblyRecompose;
    private int groupNodeCount;
    private androidx.compose.runtime.Anchor insertAnchor;
    private FixupList insertFixups;
    private androidx.compose.runtime.SlotTable insertTable;
    private boolean inserting;
    private final androidx.compose.runtime.Stack<androidx.compose.runtime.RecomposeScopeImpl> invalidateStack;
    private final List<androidx.compose.runtime.Invalidation> invalidations;
    private boolean isComposing;
    private boolean isDisposed;
    private ChangeList lateChanges;
    private int[] nodeCountOverrides;
    private MutableIntIntMap nodeCountVirtualOverrides;
    private boolean nodeExpected;
    private int nodeIndex;
    private final androidx.compose.runtime.CompositionContext parentContext;
    private androidx.compose.runtime.PersistentCompositionLocalMap parentProvider;
    private final androidx.compose.runtime.IntStack parentStateStack;
    private androidx.compose.runtime.Pending pending;
    private final androidx.compose.runtime.Stack<androidx.compose.runtime.Pending> pendingStack;
    private androidx.compose.runtime.PersistentCompositionLocalMap providerCache;
    private IntMap<androidx.compose.runtime.PersistentCompositionLocalMap> providerUpdates;
    private boolean providersInvalid;
    private final androidx.compose.runtime.IntStack providersInvalidStack;
    private int rGroupIndex;
    private androidx.compose.runtime.SlotReader reader;
    private boolean reusing;
    private int reusingGroup = -1;
    private final androidx.compose.runtime.SlotTable slotTable;
    private boolean sourceMarkersEnabled = true;
    private androidx.compose.runtime.SlotWriter writer;
    private boolean writerHasAProvider;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0008\u001a\u00020\tH\u0016J\u0008\u0010\n\u001a\u00020\tH\u0016J\u0008\u0010\u000b\u001a\u00020\tH\u0016R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u000c", d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextHolder;", "Landroidx/compose/runtime/ReusableRememberObserver;", "ref", "Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/ComposerImpl;", "(Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;)V", "getRef", "()Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class CompositionContextHolder implements androidx.compose.runtime.ReusableRememberObserver {

        private final androidx.compose.runtime.ComposerImpl.CompositionContextImpl ref;
        public CompositionContextHolder(androidx.compose.runtime.ComposerImpl.CompositionContextImpl ref) {
            super();
            this.ref = ref;
        }

        @Override // androidx.compose.runtime.ReusableRememberObserver
        public final androidx.compose.runtime.ComposerImpl.CompositionContextImpl getRef() {
            return this.ref;
        }

        @Override // androidx.compose.runtime.ReusableRememberObserver
        public void onAbandoned() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.ReusableRememberObserver
        public void onForgotten() {
            this.ref.dispose();
        }

        @Override // androidx.compose.runtime.ReusableRememberObserver
        public void onRemembered() {
        }
    }

    @Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008\u0082\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ*\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0011\u00102\u001a\r\u0012\u0004\u0012\u00020/03¢\u0006\u0002\u00084H\u0010¢\u0006\u0004\u00085\u00106J\u0015\u00107\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0010¢\u0006\u0002\u0008:J\u0006\u0010;\u001a\u00020/J\r\u0010<\u001a\u00020/H\u0010¢\u0006\u0002\u0008=J\r\u0010\u0017\u001a\u00020\u0015H\u0010¢\u0006\u0002\u0008>J\u0015\u0010?\u001a\u00020/2\u0006\u00108\u001a\u000209H\u0010¢\u0006\u0002\u0008@J\u0015\u0010A\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\u0008BJ\u0015\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020EH\u0010¢\u0006\u0002\u0008FJ\u001d\u0010G\u001a\u00020/2\u0006\u00108\u001a\u0002092\u0006\u0010H\u001a\u00020IH\u0010¢\u0006\u0002\u0008JJ\u0017\u0010K\u001a\u0004\u0018\u00010I2\u0006\u00108\u001a\u000209H\u0010¢\u0006\u0002\u0008LJ\u001b\u0010M\u001a\u00020/2\u000c\u0010N\u001a\u0008\u0012\u0004\u0012\u00020$0\u0010H\u0010¢\u0006\u0002\u0008OJ\u0015\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u00020RH\u0010¢\u0006\u0002\u0008SJ\u0015\u0010T\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\u0008UJ\u0015\u0010V\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\u0008WJ\r\u0010X\u001a\u00020/H\u0010¢\u0006\u0002\u0008YJ\u0015\u0010Z\u001a\u00020/2\u0006\u0010Q\u001a\u00020RH\u0010¢\u0006\u0002\u0008[J\u0015\u0010\\\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0010¢\u0006\u0002\u0008]J\u000e\u0010^\u001a\u00020/2\u0006\u0010D\u001a\u00020\u0015R\u0014\u0010\n\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0004\u001a\u00020\u0005X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0014\u0010\u0006\u001a\u00020\u0005X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000cR\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001b\u0010\u001c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R(\u0010#\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020$0\u0010\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010\u0013\"\u0004\u0008&\u0010'R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u001a\u0010*\u001a\u00020 8PX\u0090\u0004¢\u0006\u000c\u0012\u0004\u0008+\u0010,\u001a\u0004\u0008-\u0010\"¨\u0006_", d2 = {"Landroidx/compose/runtime/ComposerImpl$CompositionContextImpl;", "Landroidx/compose/runtime/CompositionContext;", "compoundHashKey", "", "collectingParameterInformation", "", "collectingSourceInformation", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "(Landroidx/compose/runtime/ComposerImpl;IZZLandroidx/compose/runtime/CompositionObserverHolder;)V", "collectingCallByInformation", "getCollectingCallByInformation$runtime_release", "()Z", "getCollectingParameterInformation$runtime_release", "getCollectingSourceInformation$runtime_release", "composers", "", "Landroidx/compose/runtime/ComposerImpl;", "getComposers", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "compositionLocalScope", "getCompositionLocalScope", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "setCompositionLocalScope", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "compositionLocalScope$delegate", "Landroidx/compose/runtime/MutableState;", "getCompoundHashKey$runtime_release", "()I", "effectCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "inspectionTables", "Landroidx/compose/runtime/tooling/CompositionData;", "getInspectionTables", "setInspectionTables", "(Ljava/util/Set;)V", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "recomposeCoroutineContext", "getRecomposeCoroutineContext$runtime_release$annotations", "()V", "getRecomposeCoroutineContext$runtime_release", "composeInitial", "", "composition", "Landroidx/compose/runtime/ControlledComposition;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "deletedMovableContent", "reference", "Landroidx/compose/runtime/MovableContentStateReference;", "deletedMovableContent$runtime_release", "dispose", "doneComposing", "doneComposing$runtime_release", "getCompositionLocalScope$runtime_release", "insertMovableContent", "insertMovableContent$runtime_release", "invalidate", "invalidate$runtime_release", "invalidateScope", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "invalidateScope$runtime_release", "movableContentStateReleased", "data", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateReleased$runtime_release", "movableContentStateResolve", "movableContentStateResolve$runtime_release", "recordInspectionTable", "table", "recordInspectionTable$runtime_release", "registerComposer", "composer", "Landroidx/compose/runtime/Composer;", "registerComposer$runtime_release", "registerComposition", "registerComposition$runtime_release", "reportRemovedComposition", "reportRemovedComposition$runtime_release", "startComposing", "startComposing$runtime_release", "unregisterComposer", "unregisterComposer$runtime_release", "unregisterComposition", "unregisterComposition$runtime_release", "updateCompositionLocalScope", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class CompositionContextImpl extends androidx.compose.runtime.CompositionContext {

        private final boolean collectingParameterInformation;
        private final boolean collectingSourceInformation;
        private final Set<androidx.compose.runtime.ComposerImpl> composers;
        private final androidx.compose.runtime.MutableState compositionLocalScope$delegate;
        private final int compoundHashKey;
        private Set<Set<CompositionData>> inspectionTables;
        private final androidx.compose.runtime.CompositionObserverHolder observerHolder;
        final androidx.compose.runtime.ComposerImpl this$0;
        public CompositionContextImpl(androidx.compose.runtime.ComposerImpl this$0, int compoundHashKey, boolean collectingParameterInformation, boolean collectingSourceInformation, androidx.compose.runtime.CompositionObserverHolder observerHolder) {
            this.this$0 = this$0;
            super();
            this.compoundHashKey = compoundHashKey;
            this.collectingParameterInformation = collectingParameterInformation;
            this.collectingSourceInformation = collectingSourceInformation;
            this.observerHolder = observerHolder;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            this.composers = (Set)linkedHashSet;
            this.compositionLocalScope$delegate = SnapshotStateKt.mutableStateOf(PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf(), SnapshotStateKt.referentialEqualityPolicy());
        }

        private final androidx.compose.runtime.PersistentCompositionLocalMap getCompositionLocalScope() {
            final int i = 0;
            final int i2 = 0;
            return (PersistentCompositionLocalMap)(State)this.compositionLocalScope$delegate.getValue();
        }

        public static void getRecomposeCoroutineContext$runtime_release$annotations() {
        }

        private final void setCompositionLocalScope(androidx.compose.runtime.PersistentCompositionLocalMap <set-?>) {
            final int i = 0;
            final int i2 = 0;
            this.compositionLocalScope$delegate.setValue(<set-?>);
        }

        public void composeInitial$runtime_release(androidx.compose.runtime.ControlledComposition composition, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
            ComposerImpl.access$getParentContext$p(this.this$0).composeInitial$runtime_release(composition, content);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void deletedMovableContent$runtime_release(androidx.compose.runtime.MovableContentStateReference reference) {
            ComposerImpl.access$getParentContext$p(this.this$0).deletedMovableContent$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void dispose() {
            boolean composers;
            int i;
            Iterator iterator;
            boolean next;
            Iterator iterator2;
            boolean next2;
            androidx.compose.runtime.SlotTable slotTable;
            Set inspectionTables = this.inspectionTables;
            if (!(Collection)this.composers.isEmpty() && inspectionTables != null) {
                inspectionTables = this.inspectionTables;
                if (inspectionTables != null) {
                    i = 0;
                    iterator = this.composers.iterator();
                    for (ComposerImpl next : iterator) {
                        iterator2 = inspectionTables.iterator();
                        for (Set next2 : iterator2) {
                            next2.remove(ComposerImpl.access$getSlotTable$p(next));
                        }
                        (Set)iterator2.next().remove(ComposerImpl.access$getSlotTable$p(next));
                    }
                }
                this.composers.clear();
            }
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void doneComposing$runtime_release() {
            final androidx.compose.runtime.ComposerImpl this$0 = this.this$0;
            ComposerImpl.access$setChildrenComposing$p(this$0, i--);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingCallByInformation$runtime_release() {
            return ComposerImpl.access$getParentContext$p(this.this$0).getCollectingCallByInformation$runtime_release();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingParameterInformation$runtime_release() {
            return this.collectingParameterInformation;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public boolean getCollectingSourceInformation$runtime_release() {
            return this.collectingSourceInformation;
        }

        public final Set<androidx.compose.runtime.ComposerImpl> getComposers() {
            return this.composers;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public androidx.compose.runtime.PersistentCompositionLocalMap getCompositionLocalScope$runtime_release() {
            return getCompositionLocalScope();
        }

        @Override // androidx.compose.runtime.CompositionContext
        public int getCompoundHashKey$runtime_release() {
            return this.compoundHashKey;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext getEffectCoroutineContext() {
            return ComposerImpl.access$getParentContext$p(this.this$0).getEffectCoroutineContext();
        }

        public final Set<Set<CompositionData>> getInspectionTables() {
            return this.inspectionTables;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public androidx.compose.runtime.CompositionObserverHolder getObserverHolder$runtime_release() {
            return this.observerHolder;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public CoroutineContext getRecomposeCoroutineContext$runtime_release() {
            return CompositionKt.getRecomposeCoroutineContext(this.this$0.getComposition());
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void insertMovableContent$runtime_release(androidx.compose.runtime.MovableContentStateReference reference) {
            ComposerImpl.access$getParentContext$p(this.this$0).insertMovableContent$runtime_release(reference);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidate$runtime_release(androidx.compose.runtime.ControlledComposition composition) {
            ComposerImpl.access$getParentContext$p(this.this$0).invalidate$runtime_release(this.this$0.getComposition());
            ComposerImpl.access$getParentContext$p(this.this$0).invalidate$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void invalidateScope$runtime_release(androidx.compose.runtime.RecomposeScopeImpl scope) {
            ComposerImpl.access$getParentContext$p(this.this$0).invalidateScope$runtime_release(scope);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void movableContentStateReleased$runtime_release(androidx.compose.runtime.MovableContentStateReference reference, androidx.compose.runtime.MovableContentState data) {
            ComposerImpl.access$getParentContext$p(this.this$0).movableContentStateReleased$runtime_release(reference, data);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public androidx.compose.runtime.MovableContentState movableContentStateResolve$runtime_release(androidx.compose.runtime.MovableContentStateReference reference) {
            return ComposerImpl.access$getParentContext$p(this.this$0).movableContentStateResolve$runtime_release(reference);
        }

        public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
            Object inspectionTables;
            HashSet set;
            int i;
            HashSet set2;
            if (this.inspectionTables == null) {
                inspectionTables = new HashSet();
                i = 0;
                this.inspectionTables = (Set)inspectionTables;
            }
            inspectionTables.add(table);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposer$runtime_release(androidx.compose.runtime.Composer composer) {
            Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
            super.registerComposer$runtime_release((Composer)(ComposerImpl)composer);
            this.composers.add(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void registerComposition$runtime_release(androidx.compose.runtime.ControlledComposition composition) {
            ComposerImpl.access$getParentContext$p(this.this$0).registerComposition$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void reportRemovedComposition$runtime_release(androidx.compose.runtime.ControlledComposition composition) {
            ComposerImpl.access$getParentContext$p(this.this$0).reportRemovedComposition$runtime_release(composition);
        }

        public final void setInspectionTables(Set<Set<CompositionData>> <set-?>) {
            this.inspectionTables = <set-?>;
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void startComposing$runtime_release() {
            final androidx.compose.runtime.ComposerImpl this$0 = this.this$0;
            ComposerImpl.access$setChildrenComposing$p(this$0, i++);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposer$runtime_release(androidx.compose.runtime.Composer composer) {
            int i2;
            Iterator iterator;
            boolean next;
            Object obj;
            int i;
            androidx.compose.runtime.SlotTable slotTable;
            Set inspectionTables = this.inspectionTables;
            if (inspectionTables != null) {
                i2 = 0;
                iterator = (Iterable)inspectionTables.iterator();
                for (Object next : iterator) {
                    i = 0;
                    Intrinsics.checkNotNull(composer, "null cannot be cast to non-null type androidx.compose.runtime.ComposerImpl");
                    (Set)next.remove(ComposerImpl.access$getSlotTable$p((ComposerImpl)composer));
                }
            }
            TypeIntrinsics.asMutableCollection((Collection)this.composers).remove(composer);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public void unregisterComposition$runtime_release(androidx.compose.runtime.ControlledComposition composition) {
            ComposerImpl.access$getParentContext$p(this.this$0).unregisterComposition$runtime_release(composition);
        }

        @Override // androidx.compose.runtime.CompositionContext
        public final void updateCompositionLocalScope(androidx.compose.runtime.PersistentCompositionLocalMap scope) {
            setCompositionLocalScope(scope);
        }
    }
    static {
        final int i = 8;
    }

    public ComposerImpl(androidx.compose.runtime.Applier<?> applier, androidx.compose.runtime.CompositionContext parentContext, androidx.compose.runtime.SlotTable slotTable, Set<androidx.compose.runtime.RememberObserver> abandonSet, ChangeList changes, ChangeList lateChanges, androidx.compose.runtime.ControlledComposition composition) {
        boolean collectingSourceInformation$runtime_release;
        super();
        this.applier = applier;
        this.parentContext = parentContext;
        this.slotTable = slotTable;
        this.abandonSet = abandonSet;
        this.changes = changes;
        this.lateChanges = lateChanges;
        this.composition = composition;
        Stack stack = new Stack();
        this.pendingStack = stack;
        IntStack intStack = new IntStack();
        this.parentStateStack = intStack;
        ArrayList arrayList = new ArrayList();
        this.invalidations = (List)arrayList;
        IntStack intStack2 = new IntStack();
        this.entersStack = intStack2;
        this.parentProvider = (PersistentCompositionLocalMap)PersistentCompositionLocalMapKt.persistentCompositionLocalHashMapOf();
        IntStack intStack3 = new IntStack();
        this.providersInvalidStack = intStack3;
        int i = -1;
        int i4 = 0;
        int i5 = 1;
        if (!this.parentContext.getCollectingSourceInformation$runtime_release() && this.parentContext.getCollectingCallByInformation$runtime_release()) {
            int i2 = !this.parentContext.getCollectingCallByInformation$runtime_release() ? i4 : i2;
        }
        int i3 = i5;
        ComposerImpl.derivedStateObserver.1 anon = new ComposerImpl.derivedStateObserver.1(this);
        this.derivedStateObserver = anon;
        Stack stack2 = new Stack();
        this.invalidateStack = stack2;
        androidx.compose.runtime.SlotReader reader = this.slotTable.openReader();
        int i7 = 0;
        reader.close();
        this.reader = reader;
        SlotTable slotTable3 = new SlotTable();
        androidx.compose.runtime.SlotTable slotTable4 = slotTable3;
        int i8 = 0;
        if (this.parentContext.getCollectingSourceInformation$runtime_release()) {
            slotTable4.collectSourceInformation();
        }
        if (this.parentContext.getCollectingCallByInformation$runtime_release()) {
            slotTable4.collectCalledByInformation();
        }
        this.insertTable = slotTable3;
        androidx.compose.runtime.SlotWriter writer = this.insertTable.openWriter();
        int i9 = 0;
        writer.close(i5);
        this.writer = writer;
        ComposerChangeListWriter composerChangeListWriter = new ComposerChangeListWriter(this, this.changes);
        this.changeListWriter = composerChangeListWriter;
        int i6 = 0;
        androidx.compose.runtime.SlotReader reader3 = this.insertTable.openReader();
        int i10 = 0;
        final int i11 = 0;
        reader3.close();
        this.insertAnchor = reader3.anchor(i4);
        FixupList fixupList = new FixupList();
        this.insertFixups = fixupList;
    }

    private final void abortRoot() {
        boolean closed;
        cleanUpCompose();
        this.pendingStack.clear();
        this.parentStateStack.clear();
        this.entersStack.clear();
        this.providersInvalidStack.clear();
        this.providerUpdates = 0;
        this.insertFixups.clear();
        int i2 = 0;
        this.compoundKeyHash = i2;
        this.childrenComposing = i2;
        this.nodeExpected = i2;
        this.inserting = i2;
        this.reusing = i2;
        this.isComposing = i2;
        this.forciblyRecompose = i2;
        this.reusingGroup = -1;
        if (!this.reader.getClosed()) {
            this.reader.close();
        }
        if (!this.writer.getClosed()) {
            forceFreshInsertTable();
        }
    }

    public static final ComposerChangeListWriter access$getChangeListWriter$p(androidx.compose.runtime.ComposerImpl $this) {
        return $this.changeListWriter;
    }

    public static final int access$getChildrenComposing$p(androidx.compose.runtime.ComposerImpl $this) {
        return $this.childrenComposing;
    }

    public static final int[] access$getNodeCountOverrides$p(androidx.compose.runtime.ComposerImpl $this) {
        return $this.nodeCountOverrides;
    }

    public static final androidx.compose.runtime.CompositionContext access$getParentContext$p(androidx.compose.runtime.ComposerImpl $this) {
        return $this.parentContext;
    }

    public static final IntMap access$getProviderUpdates$p(androidx.compose.runtime.ComposerImpl $this) {
        return $this.providerUpdates;
    }

    public static final androidx.compose.runtime.SlotTable access$getSlotTable$p(androidx.compose.runtime.ComposerImpl $this) {
        return $this.slotTable;
    }

    public static final void access$invokeMovableContentLambda(androidx.compose.runtime.ComposerImpl $this, androidx.compose.runtime.MovableContent content, androidx.compose.runtime.PersistentCompositionLocalMap locals, Object parameter, boolean force) {
        $this.invokeMovableContentLambda(content, locals, parameter, force);
    }

    public static final void access$setChildrenComposing$p(androidx.compose.runtime.ComposerImpl $this, int <set-?>) {
        $this.childrenComposing = <set-?>;
    }

    public static final void access$setNodeCountOverrides$p(androidx.compose.runtime.ComposerImpl $this, int[] <set-?>) {
        $this.nodeCountOverrides = <set-?>;
    }

    public static final void access$setProviderUpdates$p(androidx.compose.runtime.ComposerImpl $this, IntMap <set-?>) {
        $this.providerUpdates = <set-?>;
    }

    private final void addRecomposeScope() {
        Object recomposeScopeImpl;
        int compositionToken;
        String forcedRecompose;
        Object composition2;
        Object recomposeScopeImpl2;
        boolean composition;
        int i2;
        int i;
        forcedRecompose = "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl";
        if (getInserting()) {
            composition2 = getComposition();
            Intrinsics.checkNotNull(composition2, forcedRecompose);
            recomposeScopeImpl = new RecomposeScopeImpl((RecomposeScopeOwner)(CompositionImpl)composition2);
            this.invalidateStack.push(recomposeScopeImpl);
            updateValue(recomposeScopeImpl);
            recomposeScopeImpl.start(this.compositionToken);
        } else {
            composition2 = this.reader.next();
            if (Intrinsics.areEqual(composition2, Composer.Companion.getEmpty())) {
                composition = getComposition();
                Intrinsics.checkNotNull(composition, forcedRecompose);
                recomposeScopeImpl2 = new RecomposeScopeImpl((RecomposeScopeOwner)(CompositionImpl)composition);
                updateValue(recomposeScopeImpl2);
            } else {
                Intrinsics.checkNotNull(composition2, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeImpl");
                recomposeScopeImpl2 = composition2;
            }
            if (ComposerKt.access$removeLocation(this.invalidations, this.reader.getParent()) == null) {
                forcedRecompose = recomposeScopeImpl2.getForcedRecompose();
                i2 = 0;
                if (forcedRecompose) {
                    recomposeScopeImpl2.setForcedRecompose(false);
                }
                if (forcedRecompose) {
                    i = 1;
                }
            } else {
            }
            recomposeScopeImpl2.setRequiresRecompose(i);
            this.invalidateStack.push(recomposeScopeImpl2);
            recomposeScopeImpl2.start(this.compositionToken);
        }
    }

    private final void cleanUpCompose() {
        this.pending = 0;
        int i2 = 0;
        this.nodeIndex = i2;
        this.groupNodeCount = i2;
        this.compoundKeyHash = i2;
        this.nodeExpected = i2;
        this.changeListWriter.resetTransientState();
        this.invalidateStack.clear();
        clearUpdatedNodeCounts();
    }

    private final void clearUpdatedNodeCounts() {
        final int i = 0;
        this.nodeCountOverrides = i;
        this.nodeCountVirtualOverrides = i;
    }

    private final int compoundKeyOf(int group, int rGroupIndex, int recomposeGroup, int recomposeKey) {
        Object obj;
        int i2;
        int groupCompoundKeyPart;
        int parent;
        int compoundKeyOf;
        int i4;
        int $this$rol$iv;
        int i;
        int i3;
        int rotateLeft;
        if (group == recomposeGroup) {
            $this$rol$iv = recomposeKey;
        } else {
            obj = this;
            i2 = 0;
            groupCompoundKeyPart = (ComposerImpl)obj.groupCompoundKeyPart(obj.reader, group);
            if (groupCompoundKeyPart == 126665345) {
                $this$rol$iv = groupCompoundKeyPart;
            } else {
                parent = obj.reader.parent(group);
                if (parent == recomposeGroup) {
                    compoundKeyOf = recomposeKey;
                } else {
                    compoundKeyOf = obj.compoundKeyOf(parent, obj.rGroupIndexOf(parent), recomposeGroup, recomposeKey);
                }
                i4 = obj.reader.hasObjectKey(group) ? 0 : rGroupIndex;
                int i7 = 0;
                i3 = 0;
                $this$rol$iv = rotateLeft ^ i4;
            }
        }
        return $this$rol$iv;
    }

    private final void createFreshInsertTable() {
        ComposerKt.runtimeCheck(this.writer.getClosed());
        forceFreshInsertTable();
    }

    private final androidx.compose.runtime.PersistentCompositionLocalMap currentCompositionLocalScope() {
        androidx.compose.runtime.PersistentCompositionLocalMap providerCache = this.providerCache;
        if (providerCache != null) {
            final int i = 0;
            return providerCache;
        }
        return currentCompositionLocalScope(this.reader.getParent());
    }

    private final androidx.compose.runtime.PersistentCompositionLocalMap currentCompositionLocalScope(int group) {
        int current2;
        int current;
        Object providerUpdates;
        androidx.compose.runtime.SlotWriter writer;
        int groupKey;
        int groupKey2;
        Object compositionLocalMap;
        String str = "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap";
        int i = 202;
        if (getInserting() && this.writerHasAProvider != null) {
            if (this.writerHasAProvider != null) {
                current2 = this.writer.getParent();
                while (current2 > 0) {
                    current2 = this.writer.parent(current2);
                }
            }
        }
        if (this.reader.getSize() > 0) {
            current = group;
            while (current > 0) {
                current = this.reader.parent(current);
            }
        }
        this.providerCache = this.parentProvider;
        return this.parentProvider;
    }

    private final void doCompose(ScopeMap<androidx.compose.runtime.RecomposeScopeImpl, Object> invalidationsRequested, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        int i$iv$iv;
        Object nextSlot;
        int $this$maskEmptyOrDeleted$iv$iv$iv;
        String $i$f$runtimeCheck;
        String str;
        int $i$f$trace2;
        int j$iv$iv;
        androidx.collection.MutableScatterMap $i$f$isFull;
        int i3;
        int invalidation;
        Object i4;
        boolean beforeCheckcastToFunctionOfArity;
        long slot$iv$iv;
        int $this$maskEmptyOrDeleted$iv$iv$iv2;
        androidx.collection.MutableScatterMap map;
        int cmp;
        int sectionName$iv;
        long l;
        int i6;
        int i8;
        Object scope;
        int i;
        String $i$f$trace;
        int i2;
        Object obj;
        int i9;
        int i5;
        int i7;
        final Object obj2 = this;
        final Object obj3 = content;
        int i20 = 0;
        if (isComposing ^= $this$maskEmptyOrDeleted$iv$iv$iv == 0) {
            int i22 = 0;
            ComposerKt.composeImmediateRuntimeError("Reentrant composition is not supported");
        }
        $i$f$runtimeCheck = "Compose:recompose";
        obj2.compositionToken = SnapshotKt.currentSnapshot().getId();
        obj2.providerUpdates = 0;
        $i$f$isFull = invalidationsRequested.getMap();
        final int i33 = 0;
        final long[] metadata = map2.metadata;
        length -= i12;
        if (0 <= i34) {
        } else {
            sectionName$iv = $i$f$runtimeCheck;
            $i$f$trace = $i$f$trace2;
            $this$maskEmptyOrDeleted$iv$iv$iv2 = j$iv$iv;
            map = $i$f$isFull;
            i7 = invalidation;
        }
        CollectionsKt.sortWith(obj2.invalidations, ComposerKt.access$getInvalidationLocationAscending$p());
        obj2.nodeIndex = 0;
        int i19 = 0;
        obj2.isComposing = true;
        obj2.startRoot();
        Object obj6 = nextSlot;
        if (obj6 != obj3 && obj3 != null) {
            try {
                if (obj3 != null) {
                }
                obj2.updateValue((Object)obj3);
                int i25 = 0;
                MutableVector mutableVector2 = derivedStateObservers;
                mutableVector2.add((DerivedStateObserver)obj2.derivedStateObserver);
                int i13 = 0;
                i4 = 200;
                if (obj3 != null) {
                } else {
                }
                obj2.startGroup(i4, ComposerKt.getInvocation());
                ActualJvm_jvmKt.invokeComposable((Composer)obj2, obj3);
                obj2.endGroup();
                if (!obj2.forciblyRecompose) {
                } else {
                }
                if (obj2.providersInvalid && obj6 != null && !Intrinsics.areEqual(obj6, Composer.Companion.getEmpty())) {
                } else {
                }
                if (obj6 != null) {
                } else {
                }
                if (!Intrinsics.areEqual(obj6, Composer.Companion.getEmpty())) {
                } else {
                }
                obj2.startGroup(i4, ComposerKt.getInvocation());
                ActualJvm_jvmKt.invokeComposable((Composer)obj2, (Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj6, 2));
                obj2.endGroup();
                obj2.skipCurrentGroup();
                int i28 = 0;
                final int i36 = 1;
                mutableVector2.removeAt(size--);
                obj2.endRoot();
                int i14 = 1;
                obj2.isComposing = false;
                obj2.invalidations.clear();
                obj2.createFreshInsertTable();
                Unit complete = Unit.INSTANCE;
                Trace.INSTANCE.endSection(Trace.INSTANCE.beginSection($i$f$runtimeCheck));
                int i29 = 0;
                int i32 = obj8.getSize();
                int i35 = 1;
                i32--;
                obj8.removeAt(i32);
                throw th;
                int invalidations3 = 0;
                obj1.isComposing = invalidations3;
                invalidations3 = obj1.invalidations;
                invalidations3.clear();
                obj1.abortRoot();
                obj1.createFreshInsertTable();
                throw th;
                sectionName$iv = invalidations3;
                $i$f$trace = obj5;
                Trace.INSTANCE.endSection(obj6);
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    private final void doRecordDownsFor(int group, int nearestCommonRoot) {
        boolean changeListWriter;
        Object nodeAt;
        doRecordDownsFor(this.reader.parent(group), nearestCommonRoot);
        if (group > 0 && group != nearestCommonRoot && this.reader.isNode(group)) {
            if (group != nearestCommonRoot) {
                doRecordDownsFor(this.reader.parent(group), nearestCommonRoot);
                if (this.reader.isNode(group)) {
                    this.changeListWriter.moveDown(nodeAt(this.reader, group));
                }
            }
        }
    }

    private final void end(boolean isNode) {
        int currentInfo;
        int rotateRight2;
        int parent;
        int groupKey;
        int equal;
        Object updatedNodeCountOf;
        Object updatedNodeCountOf2;
        int remainingSlots;
        Object current;
        boolean insertedGroupVirtualIndex;
        Object changeListWriter2;
        int changeListWriter;
        int currentIndex;
        int size;
        int previousIndex;
        int size2;
        int nodeOffset;
        int rotateRight3;
        int nodePositionOf;
        int rotateRight;
        List list;
        int rGroupIndex2;
        int rGroupIndex;
        int startIndex;
        Set set;
        List current2;
        final Object obj = this;
        peek2 -= rotateRight2;
        equal = 207;
        if (obj.getInserting()) {
            groupKey = obj.writer.getParent();
            updatedNodeCountOf2 = obj.writer.groupKey(groupKey);
            current = obj.writer.groupObjectKey(groupKey);
            changeListWriter2 = obj.writer.groupAux(groupKey);
            changeListWriter = this;
            currentIndex = 0;
            if (current == null) {
                if (changeListWriter2 != null && updatedNodeCountOf2 == equal && !Intrinsics.areEqual(changeListWriter2, Composer.Companion.getEmpty())) {
                    if (updatedNodeCountOf2 == equal) {
                        if (!Intrinsics.areEqual(changeListWriter2, Composer.Companion.getEmpty())) {
                            size = changeListWriter;
                            previousIndex = 0;
                            int i32 = 0;
                            rotateRight3 = 0;
                            size.compoundKeyHash = Integer.rotateRight(i19 ^= rotateRight9, 3);
                        } else {
                            updatedNodeCountOf = changeListWriter;
                            size = 0;
                            int i25 = 0;
                            nodeOffset = 0;
                            updatedNodeCountOf.compoundKeyHash = Integer.rotateRight(i10 ^= rotateRight6, 3);
                        }
                    } else {
                    }
                } else {
                }
            } else {
                if (current instanceof Enum) {
                    previousIndex = changeListWriter;
                    size2 = 0;
                    int i35 = 0;
                    nodePositionOf = 0;
                    previousIndex.compoundKeyHash = Integer.rotateRight(rotateRight ^ i29, 3);
                } else {
                    size = changeListWriter;
                    previousIndex = 0;
                    int i33 = 0;
                    rotateRight3 = 0;
                    size.compoundKeyHash = Integer.rotateRight(i21 ^= rotateRight10, 3);
                }
            }
        } else {
            rotateRight2 = obj.reader.getParent();
            groupKey = obj.reader.groupKey(rotateRight2);
            updatedNodeCountOf2 = obj.reader.groupObjectKey(rotateRight2);
            current = obj.reader.groupAux(rotateRight2);
            changeListWriter2 = this;
            changeListWriter = 0;
            if (updatedNodeCountOf2 == null) {
                if (current != null && groupKey == equal && !Intrinsics.areEqual(current, Composer.Companion.getEmpty())) {
                    if (groupKey == equal) {
                        if (!Intrinsics.areEqual(current, Composer.Companion.getEmpty())) {
                            currentIndex = changeListWriter2;
                            size = 0;
                            int i22 = 0;
                            nodeOffset = 0;
                            currentIndex.compoundKeyHash = Integer.rotateRight(i8 ^= rotateRight5, 3);
                        } else {
                            updatedNodeCountOf = changeListWriter2;
                            currentIndex = 0;
                            int i11 = 0;
                            size2 = 0;
                            updatedNodeCountOf.compoundKeyHash = Integer.rotateRight(i5 ^= rotateRight4, 3);
                        }
                    } else {
                    }
                } else {
                }
            } else {
                if (updatedNodeCountOf2 instanceof Enum) {
                    size = changeListWriter2;
                    previousIndex = 0;
                    int i30 = 0;
                    rotateRight3 = 0;
                    size.compoundKeyHash = Integer.rotateRight(i14 ^= rotateRight7, 3);
                } else {
                    size = changeListWriter2;
                    previousIndex = 0;
                    int i31 = 0;
                    rotateRight3 = 0;
                    size.compoundKeyHash = Integer.rotateRight(i16 ^= rotateRight8, 3);
                }
            }
        }
        parent = obj.groupNodeCount;
        androidx.compose.runtime.Pending pending = obj.pending;
        if (pending != null && pending.getKeyInfos().size() > 0) {
            if (pending.getKeyInfos().size() > 0) {
                current = pending.getUsed();
                changeListWriter2 = ListUtilsKt.fastToSet(current);
                changeListWriter = new LinkedHashSet();
                currentIndex = 0;
                previousIndex = 0;
                nodeOffset = 0;
                while (previousIndex < pending.getKeyInfos().size()) {
                    rotateRight3 = updatedNodeCountOf2.get(previousIndex);
                    if (changeListWriter2.contains((KeyInfo)rotateRight3) == 0) {
                    } else {
                    }
                    rGroupIndex2 = currentInfo;
                    list = updatedNodeCountOf2;
                    set = changeListWriter2;
                    if ((Set)changeListWriter.contains(rotateRight3)) {
                    } else {
                    }
                    if (currentIndex < current.size()) {
                    } else {
                    }
                    current2 = current;
                    updatedNodeCountOf2 = list;
                    currentInfo = rGroupIndex2;
                    changeListWriter2 = set;
                    Object obj2 = current.get(currentIndex);
                    if ((KeyInfo)obj2 != rotateRight3) {
                    } else {
                    }
                    current2 = current;
                    previousIndex++;
                    currentIndex++;
                    nodeOffset += updatedNodeCountOf;
                    updatedNodeCountOf2 = list;
                    currentInfo = rGroupIndex2;
                    changeListWriter2 = set;
                    current = current2;
                    updatedNodeCountOf = pending.nodePositionOf(obj2);
                    changeListWriter.add(obj2);
                    if (updatedNodeCountOf != nodeOffset) {
                    } else {
                    }
                    current2 = current;
                    updatedNodeCountOf2 = pending.updatedNodeCountOf(obj2);
                    current2 = current;
                    obj.changeListWriter.moveNode(startIndex2 += updatedNodeCountOf, nodeOffset + startIndex, updatedNodeCountOf2);
                    pending.registerMoveNode(updatedNodeCountOf, nodeOffset, updatedNodeCountOf2);
                    previousIndex++;
                    updatedNodeCountOf2 = list;
                    currentInfo = rGroupIndex2;
                    changeListWriter2 = set;
                    obj.changeListWriter.removeNode(nodePositionOf + startIndex3, rotateRight3.getNodes());
                    pending.updateNodeCount(rotateRight3.getLocation(), 0);
                    obj.changeListWriter.moveReaderRelativeTo(rotateRight3.getLocation());
                    obj.reader.reposition(rotateRight3.getLocation());
                    obj.recordDelete();
                    obj.reader.skipGroup();
                    ComposerKt.access$removeRange(obj.invalidations, rotateRight3.getLocation(), groupSize += startIndex);
                    previousIndex++;
                    updatedNodeCountOf2 = list;
                    currentInfo = rGroupIndex2;
                    changeListWriter2 = set;
                }
                rGroupIndex = currentInfo;
                current2 = current;
                set = changeListWriter2;
                obj.changeListWriter.endNodeMovement();
                if (updatedNodeCountOf2.size() > 0) {
                    obj.changeListWriter.moveReaderRelativeTo(obj.reader.getGroupEnd());
                    obj.reader.skipToGroupEnd();
                }
            } else {
                rGroupIndex = currentInfo;
            }
        } else {
        }
        while (!obj.reader.isGroupEnd()) {
            obj.recordDelete();
            obj.changeListWriter.removeNode(obj.nodeIndex, obj.reader.skipGroup());
            ComposerKt.access$removeRange(obj.invalidations, obj.reader.getCurrentGroup(), obj.reader.getCurrentGroup());
        }
        boolean inserting2 = obj.getInserting();
        if (inserting2) {
            if (isNode) {
                obj.insertFixups.endNodeInsert();
                parent = 1;
            }
            obj.reader.endEmpty();
            obj.writer.endGroup();
            insertedGroupVirtualIndex = obj.insertedGroupVirtualIndex(obj.writer.getParent());
            obj.writer.endInsert();
            obj.writer.close(true);
            obj.recordInsert(obj.insertAnchor);
            changeListWriter2 = 0;
            obj.inserting = changeListWriter2;
            if (!obj.reader.getInEmpty() && !obj.slotTable.isEmpty()) {
                insertedGroupVirtualIndex = obj.insertedGroupVirtualIndex(remainingSlots);
                obj.writer.endInsert();
                obj.writer.close(true);
                obj.recordInsert(obj.insertAnchor);
                changeListWriter2 = 0;
                obj.inserting = changeListWriter2;
                if (!obj.slotTable.isEmpty()) {
                    obj.updateNodeCount(insertedGroupVirtualIndex, changeListWriter2);
                    obj.updateNodeCountOverrides(insertedGroupVirtualIndex, parent);
                }
            }
        } else {
            if (isNode) {
                obj.changeListWriter.moveUp();
            }
            remainingSlots = obj.reader.getRemainingSlots();
            if (remainingSlots > 0) {
                obj.changeListWriter.trimValues(remainingSlots);
            }
            obj.changeListWriter.endCurrentGroup();
            insertedGroupVirtualIndex = obj.reader.getParent();
            if (parent != obj.updatedNodeCount(insertedGroupVirtualIndex)) {
                obj.updateNodeCountOverrides(insertedGroupVirtualIndex, parent);
            }
            if (isNode) {
                parent = 1;
            }
            obj.reader.endGroup();
            obj.changeListWriter.endNodeMovement();
        }
        obj.exitGroup(parent, inserting2);
    }

    private final void endGroup() {
        end(false);
    }

    private final void endRoot() {
        endGroup();
        this.parentContext.doneComposing$runtime_release();
        endGroup();
        this.changeListWriter.endRoot();
        finalizeCompose();
        this.reader.close();
        this.forciblyRecompose = false;
        this.providersInvalid = ComposerKt.access$asBool(this.providersInvalidStack.pop());
    }

    private final void ensureWriter() {
        boolean closed;
        if (this.writer.getClosed()) {
            this.writer = this.insertTable.openWriter();
            this.writer.skipToGroupEnd();
            this.writerHasAProvider = false;
            this.providerCache = 0;
        }
    }

    private final void enterGroup(boolean isNode, androidx.compose.runtime.Pending newPending) {
        this.pendingStack.push(this.pending);
        this.pending = newPending;
        this.parentStateStack.push(this.groupNodeCount);
        this.parentStateStack.push(this.rGroupIndex);
        this.parentStateStack.push(this.nodeIndex);
        int i = 0;
        if (isNode) {
            this.nodeIndex = i;
        }
        this.groupNodeCount = i;
        this.rGroupIndex = i;
    }

    private final void exitGroup(int expectedNodeCount, boolean inserting) {
        int i;
        Object obj = this.pendingStack.pop();
        if ((Pending)obj != null && !inserting) {
            if (!inserting) {
                obj.setGroupIndex(groupIndex++);
            }
        }
        this.pending = obj;
        this.nodeIndex = i2 += expectedNodeCount;
        this.rGroupIndex = this.parentStateStack.pop();
        this.groupNodeCount = i5 += expectedNodeCount;
    }

    private final void finalizeCompose() {
        String str;
        this.changeListWriter.finalizeComposition();
        final int i = 0;
        if (!this.pendingStack.isEmpty()) {
            int i2 = 0;
            ComposerKt.composeImmediateRuntimeError("Start/end imbalance");
        }
        cleanUpCompose();
    }

    private final void forceFreshInsertTable() {
        SlotTable slotTable = new SlotTable();
        androidx.compose.runtime.SlotTable slotTable2 = slotTable;
        int i = 0;
        if (this.sourceMarkersEnabled) {
            slotTable2.collectSourceInformation();
        }
        if (this.parentContext.getCollectingCallByInformation$runtime_release()) {
            slotTable2.collectCalledByInformation();
        }
        this.insertTable = slotTable;
        androidx.compose.runtime.SlotWriter writer = this.insertTable.openWriter();
        int i2 = 0;
        writer.close(true);
        this.writer = writer;
    }

    public static void getCompoundKeyHash$annotations() {
    }

    @ComposeCompilerApi
    public static void getDefaultsInvalid$annotations() {
    }

    @ComposeCompilerApi
    public static void getInserting$annotations() {
    }

    private final Object getNode(androidx.compose.runtime.SlotReader $this$node) {
        return $this$node.node($this$node.getParent());
    }

    @ComposeCompilerApi
    public static void getSkipping$annotations() {
    }

    private final int groupCompoundKeyPart(androidx.compose.runtime.SlotReader $this$groupCompoundKeyPart, int group) {
        int groupObjectKey;
        int i2;
        int aux;
        int groupAux;
        int i3;
        int i;
        if ($this$groupCompoundKeyPart.hasObjectKey(group)) {
            groupObjectKey = $this$groupCompoundKeyPart.groupObjectKey(group);
            if (groupObjectKey != null) {
                i2 = 0;
                if (groupObjectKey instanceof Enum) {
                    aux = (Enum)groupObjectKey.ordinal();
                } else {
                    if (groupObjectKey instanceof MovableContent) {
                        aux = 126665345;
                    } else {
                        aux = groupObjectKey.hashCode();
                    }
                }
            } else {
                aux = 0;
            }
        } else {
            groupObjectKey = $this$groupCompoundKeyPart.groupKey(group);
            i2 = 0;
            groupAux = $this$groupCompoundKeyPart.groupAux(group);
            if (groupObjectKey == 207 && groupAux != null) {
                groupAux = $this$groupCompoundKeyPart.groupAux(group);
                if (groupAux != null) {
                    i3 = 0;
                    if (Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
                        i = groupObjectKey;
                    } else {
                        i = groupAux.hashCode();
                    }
                    aux = i;
                } else {
                    aux = groupObjectKey;
                }
            } else {
            }
        }
        return aux;
    }

    private final void insertMovableContentGuarded(List<Pair<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentStateReference>> references) {
        int changeListWriter;
        Unit offsetChanges;
        boolean fromAnchor;
        int size;
        androidx.compose.runtime.SlotTable movableContentStateResolve$runtime_release;
        boolean changeListWriter2;
        ChangeList to;
        int i9;
        ChangeList toSlotTable;
        androidx.compose.runtime.SlotReader nodesToInsert;
        int[] reader4;
        boolean anchorIndex;
        IntMap this_$iv;
        androidx.compose.runtime.Anchor anchor$runtime_release;
        Object newLocation;
        Object fromTable;
        androidx.compose.runtime.SlotReader newChangeList$iv;
        ChangeList list2;
        Object from;
        androidx.compose.runtime.ComposerImpl anchor2;
        int i11;
        Object anchor;
        boolean z2;
        int i10;
        IntRef intRef;
        Object obj2;
        int i8;
        int i3;
        int i4;
        int size2;
        androidx.compose.runtime.SlotTable slotTable;
        int i13;
        androidx.compose.runtime.SlotReader reader6;
        int i2;
        androidx.compose.runtime.SlotReader effectiveNodeIndex;
        androidx.compose.runtime.ComposerImpl location;
        int offsetChanges3;
        int anchor3;
        ChangeList list;
        int from2;
        ChangeList fromAnchor2;
        androidx.compose.runtime.SlotReader reader2;
        int[] iArr;
        IntMap map;
        androidx.compose.runtime.SlotTable offsetChanges2;
        androidx.compose.runtime.MovableContentState movableContentState;
        int i7;
        int i;
        ChangeList list3;
        int i5;
        boolean z;
        int i12;
        boolean z3;
        androidx.compose.runtime.SlotReader reader5;
        androidx.compose.runtime.SlotReader reader;
        androidx.compose.runtime.SlotReader reader3;
        int i6;
        androidx.compose.runtime.ComposerImpl composerImpl;
        Object obj;
        final Object obj3 = this;
        final ComposerChangeListWriter changeListWriter13 = obj3.changeListWriter;
        i11 = 0;
        changeListWriter13.setChangeList(obj3.lateChanges);
        i10 = 0;
        obj3.changeListWriter.resetSlots();
        final Object obj7 = references;
        final int i20 = 0;
        size = obj7.size();
        i9 = changeListWriter;
        int index$iv = 0;
        while (i9 < size) {
            Object obj6 = obj2;
            i8 = 0;
            Object component1 = (Pair)obj6.component1();
            Object component2 = obj6.component2();
            anchor$runtime_release = (MovableContentStateReference)component1.getAnchor$runtime_release();
            int anchorIndex3 = component1.getSlotTable$runtime_release().anchorIndex(anchor$runtime_release);
            IntRef intRef3 = new IntRef(index$iv, 1, 0);
            IntRef intRef2 = intRef3;
            obj3.changeListWriter.determineMovableContentNodeIndex(intRef2, anchor$runtime_release);
            if ((MovableContentStateReference)component2 == null) {
            } else {
            }
            Object to3 = component1;
            offsetChanges3 = anchorIndex3;
            effectiveNodeIndex = list2;
            location = i11;
            anchor3 = i10;
            intRef = intRef2;
            Object newChangeList$iv2 = component2;
            androidx.compose.runtime.Anchor $i$f$withChangeList = anchor$runtime_release;
            androidx.compose.runtime.MovableContentState movableContentState2 = movableContentStateResolve$runtime_release;
            if (movableContentState2 != null) {
            } else {
            }
            movableContentStateResolve$runtime_release = newChangeList$iv2.getSlotTable$runtime_release();
            androidx.compose.runtime.SlotTable slotTable4 = movableContentStateResolve$runtime_release;
            movableContentStateResolve$runtime_release = movableContentState2.getSlotTable$runtime_release();
            if (movableContentState2 != null && movableContentStateResolve$runtime_release != null) {
            } else {
            }
            movableContentStateResolve$runtime_release = newChangeList$iv2.getAnchor$runtime_release();
            List list4 = ComposerKt.access$collectNodesFrom(slotTable4, movableContentStateResolve$runtime_release);
            obj3.changeListWriter.copyNodesToNewAnchorLocation(list4, intRef);
            if (!(Collection)list4.isEmpty() && Intrinsics.areEqual(to3.getSlotTable$runtime_release(), obj3.slotTable)) {
            }
            Object obj4 = to3;
            obj3.changeListWriter.copySlotTableToAnchorLocation(movableContentState2, obj3.parentContext, newChangeList$iv2, obj4);
            i13 = 0;
            reader6 = reader10;
            i2 = 0;
            androidx.compose.runtime.SlotReader reader11 = reader6;
            list = 0;
            androidx.compose.runtime.ComposerImpl composerImpl2 = this;
            from2 = 0;
            int i14 = 0;
            ComposerImpl.access$setNodeCountOverrides$p(composerImpl2, i14);
            ComposerImpl.access$setProviderUpdates$p(composerImpl2, i14);
            composerImpl2.setReader$runtime_release(reader11);
            size2 = 0;
            movableContentState = movableContentState2;
            int resolvedState = i24;
            reader11.reposition(resolvedState);
            obj3.changeListWriter.moveReaderToAbsolute(resolvedState);
            ChangeList changeList = new ChangeList();
            ComposerChangeListWriter list9 = changeListWriter7;
            i = 0;
            i5 = resolvedState;
            newLocation = list8;
            offsetChanges2 = slotTable4;
            fromTable = list9;
            fromTable.setChangeList(newLocation);
            i7 = 0;
            ComposerChangeListWriter list10 = changeListWriter8;
            i12 = 0;
            reader5 = newChangeList$iv2;
            from = list10;
            from.setImplicitRootStart(false);
            reader3 = reader11;
            i6 = i16;
            ComposerImpl.insertMovableContentGuarded.1.1.2.1.1.1.1 anon = new ComposerImpl.insertMovableContentGuarded.1.1.2.1.1.1.1(obj3, obj4);
            fromAnchor2 = obj4;
            z = anchor6;
            reader = list4;
            composerImpl = $i$f$withChangeList;
            anchor = composerImpl2;
            obj3.recomposeMovableContent(reader5.getComposition$runtime_release(), obj4.getComposition$runtime_release(), Integer.valueOf(reader11.getCurrentGroup()), reader5.getInvalidations$runtime_release(), (Function0)anon);
            from.setImplicitRootStart(list10.getImplicitRootStart());
            fromTable.setChangeList(list9.getChangeList());
            obj3.changeListWriter.includeOperationsIn(newLocation, intRef);
            Unit iNSTANCE = Unit.INSTANCE;
            anchor.setReader$runtime_release(composerImpl2.getReader$runtime_release());
            ComposerImpl.access$setNodeCountOverrides$p(anchor, ComposerImpl.access$getNodeCountOverrides$p(composerImpl2));
            ComposerImpl.access$setProviderUpdates$p(anchor, ComposerImpl.access$getProviderUpdates$p(composerImpl2));
            offsetChanges = Unit.INSTANCE;
            reader6.close();
            obj3.changeListWriter.skipToEndOfCurrentGroup();
            i9 = i4 + 1;
            size = i3;
            list2 = effectiveNodeIndex;
            i11 = location;
            i10 = anchor3;
            index$iv = 0;
            obj3.changeListWriter.copyNodesToNewAnchorLocation(list4, intRef);
            if (Intrinsics.areEqual(to3.getSlotTable$runtime_release(), obj3.slotTable)) {
            }
            anchorIndex = obj3.slotTable.anchorIndex($i$f$withChangeList);
            obj3.updateNodeCount(anchorIndex, updatedNodeCount += size2);
            movableContentStateResolve$runtime_release = movableContentState2.getSlotTable$runtime_release();
            if (movableContentStateResolve$runtime_release != null) {
            } else {
            }
            if (movableContentStateResolve$runtime_release.anchor(index$iv) == null) {
            }
            if (movableContentState2.getSlotTable$runtime_release() == null) {
            }
            androidx.compose.runtime.SlotTable slotTable2 = slotTable$runtime_release;
            if (Intrinsics.areEqual(slotTable2, obj3.insertTable)) {
            }
            slotTable = 0;
            i13 = reader7;
            reader6 = 0;
            androidx.compose.runtime.SlotReader reader8 = i13;
            i2 = 0;
            reader8.reposition(anchorIndex3);
            obj3.changeListWriter.moveReaderToAbsolute(anchorIndex3);
            ChangeList changeList3 = new ChangeList();
            ComposerImpl.insertMovableContentGuarded.1.1.1.1 effectiveNodeIndex3 = new ComposerImpl.insertMovableContentGuarded.1.1.1.1(obj3, changeList3, reader8, component1);
            list = slotTable2;
            fromAnchor2 = component1;
            from2 = reader8;
            offsetChanges3 = i22;
            location = i11;
            anchor3 = i10;
            effectiveNodeIndex = list2;
            ComposerImpl.recomposeMovableContent$default(obj3, 0, 0, 0, 0, (Function0)effectiveNodeIndex3, 15, 0);
            obj3.changeListWriter.includeOperationsIn(changeList3, intRef2);
            offsetChanges = Unit.INSTANCE;
            i13.close();
            reader5 = from;
            composerImpl = anchor;
            obj3.createFreshInsertTable();
        }
        int index$iv3 = i9;
        ChangeList list6 = list2;
        int i21 = i11;
        int i23 = i10;
        obj3.changeListWriter.endMovableContentPlacement();
        obj3.changeListWriter.moveReaderToAbsolute(0);
        changeListWriter13.setChangeList(changeListWriter13.getChangeList());
    }

    private final int insertedGroupVirtualIndex(int index) {
        return index - -2;
    }

    private final void invokeMovableContentLambda(androidx.compose.runtime.MovableContent<Object> content, androidx.compose.runtime.PersistentCompositionLocalMap locals, Object parameter, boolean force) {
        boolean inserting;
        boolean inserting2;
        int i;
        boolean movableContentStateReference;
        Object obj;
        Object composableLambdaInstance;
        Object insertTable;
        Object anchor;
        int emptyList;
        androidx.compose.runtime.PersistentCompositionLocalMap currentCompositionLocalScope;
        int i2 = 126665345;
        startMovableGroup(i2, content);
        updateSlot(parameter);
        final int i6 = 0;
        this.compoundKeyHash = i2;
        int i4 = 1;
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, i4, i6);
        }
        if (getInserting()) {
        } else {
        }
        int i3 = i;
        if (i3 != 0) {
            recordProviderUpdate(locals);
        }
        start-BaiHCIY(202, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.getGroup-ULZAiWs(), locals);
        this.providerCache = i6;
        if (getInserting() && !force) {
            if (!force) {
                this.writerHasAProvider = i4;
                movableContentStateReference = new MovableContentStateReference(content, parameter, getComposition(), this.insertTable, this.writer.anchor(this.writer.parent(this.writer.getParent())), CollectionsKt.emptyList(), currentCompositionLocalScope());
                this.parentContext.insertMovableContent$runtime_release(movableContentStateReference);
            } else {
                this.providersInvalid = i3;
                anchor = new ComposerImpl.invokeMovableContentLambda.1(content, parameter);
                ActualJvm_jvmKt.invokeComposable((Composer)this, (Function2)ComposableLambdaKt.composableLambdaInstance(316014703, i4, anchor));
                this.providersInvalid = this.providersInvalid;
            }
        } else {
        }
        endGroup();
        this.providerCache = i6;
        this.compoundKeyHash = getCompoundKeyHash();
        endMovableGroup();
    }

    private final Object nodeAt(androidx.compose.runtime.SlotReader $this$nodeAt, int index) {
        return $this$nodeAt.node(index);
    }

    private final int nodeIndexOf(int groupLocation, int group, int recomposeGroup, int recomposeIndex) {
        int anchorGroup;
        androidx.compose.runtime.SlotReader reader;
        int index;
        int current;
        int nodeCount;
        int updatedNodeCount;
        anchorGroup = this.reader.parent(group);
        while (anchorGroup != recomposeGroup) {
            if (!this.reader.isNode(anchorGroup)) {
            }
            anchorGroup = this.reader.parent(anchorGroup);
        }
        index = this.reader.isNode(anchorGroup) ? 0 : recomposeIndex;
        if (anchorGroup == group) {
            return index;
        }
        current = anchorGroup;
        while (index < i += index) {
            if (current != groupLocation) {
            }
            current++;
            while (current < groupLocation) {
                groupSize += current;
                if (this.reader.isNode(current)) {
                } else {
                }
                updatedNodeCount = updatedNodeCount(current);
                index += updatedNodeCount;
                current = nodeCount;
                updatedNodeCount = 1;
            }
            groupSize += current;
            if (this.reader.isNode(current)) {
            } else {
            }
            updatedNodeCount = updatedNodeCount(current);
            index += updatedNodeCount;
            current = nodeCount;
            updatedNodeCount = 1;
        }
        return index;
    }

    private final int rGroupIndexOf(int group) {
        int result;
        int child;
        int groupSize;
        result = 0;
        child = parent + 1;
        while (child < group) {
            if (!this.reader.hasObjectKey(child)) {
            }
            child += groupSize;
            result++;
        }
        return result;
    }

    private final <R> R recomposeMovableContent(androidx.compose.runtime.ControlledComposition from, androidx.compose.runtime.ControlledComposition to, Integer index, List<? extends Pair<androidx.compose.runtime.RecomposeScopeImpl, ? extends Object>> invalidations, Function0<? extends R> block) {
        Object delegateInvalidations;
        int intValue;
        Function0 function0;
        Function0 function02;
        int index$iv;
        Object obj;
        Object component2;
        int i;
        Object component1;
        int i2;
        this.isComposing = true;
        this.nodeIndex = 0;
        delegateInvalidations = invalidations;
        int i5 = 0;
        index$iv = 0;
        while (index$iv < delegateInvalidations.size()) {
            Object obj2 = obj;
            i = 0;
            component1 = (Pair)obj2.component1();
            component2 = obj2.component2();
            if (component2 != null) {
            } else {
            }
            tryImminentInvalidation$runtime_release((RecomposeScopeImpl)component1, 0);
            index$iv++;
            tryImminentInvalidation$runtime_release(component1, component2);
        }
        try {
            if (from != null) {
            } else {
            }
            if (index != null) {
            } else {
            }
            intValue = index.intValue();
            intValue = -1;
            if (from.delegateInvalidations(to, intValue, block) == null) {
            }
            function02 = block;
            delegateInvalidations = function02.invoke();
            this.isComposing = this.isComposing;
            this.nodeIndex = this.nodeIndex;
            return delegateInvalidations;
            function0 = block;
            this.isComposing = obj1;
            this.nodeIndex = obj2;
            throw th;
        } catch (Throwable th) {
        }
    }

    static Object recomposeMovableContent$default(androidx.compose.runtime.ComposerImpl composerImpl, androidx.compose.runtime.ControlledComposition controlledComposition2, androidx.compose.runtime.ControlledComposition controlledComposition3, Integer integer4, List list5, Function0 function06, int i7, Object object8) {
        int obj2;
        int obj3;
        int obj4;
        List obj5;
        final int i = 0;
        if (i7 & 1 != 0) {
            obj2 = i;
        }
        if (i7 & 2 != 0) {
            obj3 = i;
        }
        if (i7 & 4 != 0) {
            obj4 = i;
        }
        if (i7 &= 8 != 0) {
            obj5 = CollectionsKt.emptyList();
        }
        return composerImpl.recomposeMovableContent(obj2, obj3, obj4, obj5, function06);
    }

    private final void recomposeToGroupEnd() {
        int recomposed;
        int oldGroup;
        androidx.compose.runtime.Invalidation firstInRange;
        int updatedNodeCount;
        int invalidations;
        int invalidateStack;
        int currentGroup;
        int parent;
        androidx.compose.runtime.SlotReader reader;
        androidx.compose.runtime.RecomposeScopeImpl scope;
        final Object obj = this;
        obj.isComposing = true;
        recomposed = 0;
        int parent2 = obj.reader.getParent();
        groupSize += parent2;
        final int nodeIndex = obj.nodeIndex;
        final int compoundKeyHash = obj.getCompoundKeyHash();
        oldGroup = parent2;
        firstInRange = ComposerKt.access$firstInRange(obj.invalidations, obj.reader.getCurrentGroup(), i2);
        while (firstInRange != null) {
            updatedNodeCount = firstInRange.getLocation();
            ComposerKt.access$removeLocation(obj.invalidations, updatedNodeCount);
            if (firstInRange.isInvalid()) {
            } else {
            }
            obj.invalidateStack.push(firstInRange.getScope());
            firstInRange.getScope().rereadTrackedInstances();
            obj.invalidateStack.pop();
            firstInRange = ComposerKt.access$firstInRange(obj.invalidations, obj.reader.getCurrentGroup(), i2);
            recomposed = 1;
            obj.reader.reposition(updatedNodeCount);
            invalidateStack = obj.reader.getCurrentGroup();
            obj.recordUpsAndDowns(oldGroup, invalidateStack, parent2);
            oldGroup = invalidateStack;
            obj.nodeIndex = obj.nodeIndexOf(updatedNodeCount, invalidateStack, parent2, nodeIndex);
            obj.rGroupIndex = obj.rGroupIndexOf(invalidateStack);
            parent = obj.reader.parent(invalidateStack);
            obj.compoundKeyHash = obj.compoundKeyOf(parent, obj.rGroupIndexOf(parent), parent2, compoundKeyHash);
            obj.providerCache = 0;
            firstInRange.getScope().compose((Composer)obj);
            obj.providerCache = 0;
            obj.reader.restoreParent(parent2);
        }
        if (recomposed != 0) {
            obj.recordUpsAndDowns(oldGroup, parent2, parent2);
            obj.reader.skipToGroupEnd();
            updatedNodeCount = obj.updatedNodeCount(parent2);
            obj.nodeIndex = nodeIndex + updatedNodeCount;
            obj.groupNodeCount = groupNodeCount + updatedNodeCount;
            obj.rGroupIndex = obj.rGroupIndex;
        } else {
            obj.skipReaderToGroupEnd();
        }
        obj.compoundKeyHash = compoundKeyHash;
        obj.isComposing = obj.isComposing;
    }

    private final void recordDelete() {
        reportFreeMovableContent(this.reader.getCurrentGroup());
        this.changeListWriter.removeCurrentGroup();
    }

    private final void recordInsert(androidx.compose.runtime.Anchor anchor) {
        Object changeListWriter;
        androidx.compose.runtime.SlotTable insertTable;
        FixupList insertFixups;
        if (this.insertFixups.isEmpty()) {
            this.changeListWriter.insertSlots(anchor, this.insertTable);
        } else {
            this.changeListWriter.insertSlots(anchor, this.insertTable, this.insertFixups);
            changeListWriter = new FixupList();
            this.insertFixups = changeListWriter;
        }
    }

    private final void recordProviderUpdate(androidx.compose.runtime.PersistentCompositionLocalMap providers) {
        IntMap $this$recordProviderUpdate_u24lambda_u2414;
        int i4;
        IntMap intMap;
        int i3;
        int i;
        int i2;
        if (this.providerUpdates == null) {
            i4 = 0;
            intMap = new IntMap(0, 1, 0);
            obj.providerUpdates = intMap;
            $this$recordProviderUpdate_u24lambda_u2414 = intMap;
        }
        $this$recordProviderUpdate_u24lambda_u2414.set(this.reader.getCurrentGroup(), providers);
    }

    private final void recordUpsAndDowns(int oldGroup, int newGroup, int commonRoot) {
        int current;
        boolean changeListWriter;
        final androidx.compose.runtime.SlotReader reader = this.reader;
        final int i = ComposerKt.access$nearestCommonRootOf(reader, oldGroup, newGroup, commonRoot);
        current = oldGroup;
        while (current > 0) {
            if (current != i) {
            }
            if (reader.isNode(current)) {
            }
            current = reader.parent(current);
            this.changeListWriter.moveUp();
        }
        doRecordDownsFor(newGroup, i);
    }

    private final androidx.compose.runtime.Anchor rememberObserverAnchor() {
        int group;
        int parent3;
        int parent;
        int parent2;
        androidx.compose.runtime.SlotWriter writer;
        parent = 0;
        if (getInserting()) {
            if (ComposerKt.isAfterFirstChild(this.writer)) {
                parent3 = this.writer.parent(currentGroup--);
                while (parent3 != this.writer.getParent()) {
                    if (parent3 >= 0) {
                    }
                    parent3 = this.writer.parent(parent3);
                }
                parent = this.writer.anchor(group);
            } else {
            }
        } else {
            if (ComposerKt.isAfterFirstChild(this.reader)) {
                parent2 = this.reader.parent(currentGroup2--);
                while (parent2 != this.reader.getParent()) {
                    if (parent2 >= 0) {
                    }
                    parent2 = this.reader.parent(parent2);
                }
                parent = this.reader.anchor(group);
            } else {
            }
        }
        return parent;
    }

    private final void reportAllMovableContent() {
        boolean changeList;
        androidx.compose.runtime.SlotTable slotTable;
        int i;
        androidx.compose.runtime.SlotReader reader2;
        int i4;
        Object reader;
        int i2;
        ComposerChangeListWriter changeListWriter;
        int i3;
        ChangeList changeList2;
        Throwable th;
        ComposerChangeListWriter changeListWriter2;
        if (this.slotTable.containsMark()) {
            changeList = new ChangeList();
            this.deferredChanges = changeList;
            i = 0;
            reader2 = this.slotTable.openReader();
            i4 = 0;
            i2 = 0;
            this.reader = reader2;
            changeListWriter = this.changeListWriter;
            i3 = 0;
            changeListWriter.setChangeList(changeList);
            th = 0;
            reportFreeMovableContent(0);
            this.changeListWriter.releaseMovableContent();
            changeListWriter.setChangeList(changeListWriter.getChangeList());
            reader = Unit.INSTANCE;
            reader2.close();
        }
    }

    private final void reportFreeMovableContent(int groupBeingRemoved) {
        int i = 0;
        ComposerImpl.reportFreeMovableContent$reportGroup(this, groupBeingRemoved, i, i);
        this.changeListWriter.endNodeMovement();
    }

    private static final int reportFreeMovableContent$reportGroup(androidx.compose.runtime.ComposerImpl this$0, int group, boolean needsNodeDelete, int nodeIndex) {
        int groupSize;
        int equal;
        Object groupGet;
        int size;
        int contextHolder;
        boolean composition;
        int end;
        Object groupObjectKey;
        int current;
        List list;
        int runningNodeCount;
        Iterator iterator;
        boolean changeListWriter;
        int i2;
        int reportFreeMovableContent$reportGroup;
        Object composition2;
        androidx.compose.runtime.SlotTable slotTable;
        Object parentContext;
        Object $i$f$fastForEach;
        int i4;
        androidx.compose.runtime.PersistentCompositionLocalMap currentCompositionLocalScope;
        int i;
        int i7;
        int i6;
        int i3;
        int i5;
        int i8;
        int i9;
        List list2;
        final Object obj = this$0;
        final int i10 = group;
        final int i11 = nodeIndex;
        final androidx.compose.runtime.SlotReader reader = obj.reader;
        int i12 = 0;
        composition = 1;
        if (reader.hasMark(i10)) {
            groupSize = reader.groupKey(i10);
            groupObjectKey = reader.groupObjectKey(i10);
            if (groupSize == 126665345 && groupObjectKey instanceof MovableContent) {
                if (groupObjectKey instanceof MovableContent) {
                    groupSize2 += i10;
                    list = ComposerKt.access$filterToRange(obj.invalidations, i10, i14);
                    int i15 = 0;
                    ArrayList arrayList = new ArrayList(list.size());
                    List list4 = list;
                    int i16 = 0;
                    size = list4.size();
                    i = i14;
                    end = i4;
                    while (end < size) {
                        i6 = 0;
                        i5 = i7;
                        i8 = 0;
                        (Collection)arrayList.add(TuplesKt.to((Invalidation)i5.getScope(), i5.getInstances()));
                        end = i9 + 1;
                        size = i3;
                        list = list2;
                    }
                    i9 = end;
                    list2 = list;
                    runningNodeCount = new MovableContentStateReference((MovableContent)groupObjectKey, reader.groupGet(i10, i12), obj.getComposition(), obj.slotTable, reader.anchor(i10), (List)arrayList, this$0.currentCompositionLocalScope(group));
                    obj.parentContext.deletedMovableContent$runtime_release(runningNodeCount);
                    obj.changeListWriter.recordSlotEditing();
                    obj.changeListWriter.releaseMovableGroupAtCurrent(obj.getComposition(), obj.parentContext, runningNodeCount);
                    if (needsNodeDelete) {
                        obj.changeListWriter.endNodeMovementAndDeleteNode(i11, i10);
                        contextHolder = 0;
                    } else {
                        contextHolder = reader.nodeCount(i10);
                    }
                } else {
                    if (groupSize == 206 && Intrinsics.areEqual(groupObjectKey, ComposerKt.getReference())) {
                        if (Intrinsics.areEqual(groupObjectKey, ComposerKt.getReference())) {
                            if (groupGet instanceof ComposerImpl.CompositionContextHolder) {
                            } else {
                                groupGet = 0;
                            }
                            if (groupGet != null) {
                                runningNodeCount = 0;
                                iterator = (Iterable)groupGet.getRef().getComposers().iterator();
                                for (Object changeListWriter : iterator) {
                                    composition2 = changeListWriter;
                                    slotTable = 0;
                                    (ComposerImpl)composition2.reportAllMovableContent();
                                    obj.parentContext.reportRemovedComposition$runtime_release(composition2.getComposition());
                                }
                            }
                            contextHolder = reader.nodeCount(i10);
                        } else {
                            if (reader.isNode(i10)) {
                                contextHolder = composition;
                            } else {
                                contextHolder = reader.nodeCount(i10);
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
            if (reader.containsMark(i10)) {
                current = i10 + 1;
                runningNodeCount = 0;
                while (current < i10 + groupSize) {
                    iterator = reader.isNode(current);
                    if (iterator != null) {
                    }
                    if (iterator == null) {
                    } else {
                    }
                    i2 = composition;
                    if (iterator != null) {
                    } else {
                    }
                    composition2 = i11 + runningNodeCount;
                    runningNodeCount += reportFreeMovableContent$reportGroup;
                    if (iterator != null) {
                    }
                    current += changeListWriter;
                    obj.changeListWriter.endNodeMovement();
                    obj.changeListWriter.moveUp();
                    composition2 = i12;
                    if (needsNodeDelete) {
                    } else {
                    }
                    i2 = i12;
                    obj.changeListWriter.endNodeMovement();
                    obj.changeListWriter.moveDown(reader.node(current));
                }
                contextHolder = reader.isNode(i10) ? composition : runningNodeCount;
            } else {
                if (reader.isNode(i10)) {
                    contextHolder = composition;
                } else {
                    contextHolder = reader.nodeCount(i10);
                }
            }
        }
        return contextHolder;
    }

    private final void skipGroup() {
        this.groupNodeCount = groupNodeCount += skipGroup;
    }

    private final void skipReaderToGroupEnd() {
        this.groupNodeCount = this.reader.getParentNodes();
        this.reader.skipToGroupEnd();
    }

    private final void start-BaiHCIY(int key, Object objectKey, int kind, Object data) {
        androidx.compose.runtime.SlotWriter writer;
        int rGroupIndex$iv;
        androidx.compose.runtime.SlotWriter writer2;
        Object keyInfo2;
        int pending;
        int obj;
        int i2;
        int reusing;
        int i;
        androidx.compose.runtime.Pending arrayList;
        Object empty2;
        int insertedGroupVirtualIndex;
        int ordinal;
        int keyInfo;
        Object empty;
        int equal;
        int keyInfo3;
        Object $this$rol$iv$iv$iv;
        int nodeIndex;
        int $this$rol$iv$iv$iv3;
        int $this$rol$iv$iv$iv2;
        int currentGroup;
        int rotateLeft3;
        int rotateLeft;
        int rotateLeft2;
        int newPending;
        androidx.compose.runtime.KeyInfo keyInfo4;
        final Object obj2 = this;
        pending = key;
        final Object obj4 = objectKey;
        final int i8 = kind;
        final Object obj5 = data;
        obj2.validateNodeNotExpected();
        int rGroupIndex = obj2.rGroupIndex;
        obj = this;
        int i6 = 0;
        if (obj4 == null) {
            if (obj5 != null && pending == 207 && !Intrinsics.areEqual(obj5, Composer.Companion.getEmpty())) {
                if (pending == 207) {
                    if (!Intrinsics.areEqual(obj5, Composer.Companion.getEmpty())) {
                        keyInfo3 = obj;
                        $this$rol$iv$iv$iv = 0;
                        int i16 = 0;
                        rotateLeft3 = 0;
                        keyInfo3.compoundKeyHash = rotateLeft ^ rGroupIndex;
                    } else {
                        ordinal = obj;
                        keyInfo3 = 0;
                        int i11 = 0;
                        $this$rol$iv$iv$iv2 = 0;
                        ordinal.compoundKeyHash = rotateLeft3 ^ rGroupIndex;
                    }
                } else {
                }
            } else {
            }
        } else {
            if (obj4 instanceof Enum) {
                $this$rol$iv$iv$iv = obj;
                $this$rol$iv$iv$iv3 = 0;
                int i18 = 0;
                rotateLeft = 0;
                $this$rol$iv$iv$iv.compoundKeyHash = rotateLeft2 ^ keyInfo3;
            } else {
                $this$rol$iv$iv$iv = obj;
                $this$rol$iv$iv$iv3 = 0;
                int i17 = 0;
                rotateLeft = 0;
                $this$rol$iv$iv$iv.compoundKeyHash = rotateLeft2 ^ keyInfo3;
            }
        }
        rGroupIndex$iv = 1;
        if (obj4 == null) {
            obj2.rGroupIndex = rGroupIndex2 += rGroupIndex$iv;
        }
        int i4 = 0;
        nodeIndex = 0;
        i2 = i8 != GroupKind.Companion.getGroup-ULZAiWs() ? rGroupIndex$iv : nodeIndex;
        int i9 = i2;
        currentGroup = 0;
        insertedGroupVirtualIndex = -1;
        if (obj2.getInserting()) {
            obj2.reader.beginEmpty();
            if (i9 != 0) {
                obj2.writer.startNode(pending, Composer.Companion.getEmpty());
            } else {
                if (obj5 != null) {
                    if (obj4 == null) {
                        empty2 = Composer.Companion.getEmpty();
                    } else {
                        empty2 = obj4;
                    }
                    obj2.writer.startData(pending, empty2, obj5);
                } else {
                    if (obj4 == null) {
                        empty2 = Composer.Companion.getEmpty();
                    } else {
                        empty2 = obj4;
                    }
                    obj2.writer.startGroup(pending, empty2);
                }
            }
            keyInfo2 = obj2.pending;
            if (keyInfo2 != null) {
                rotateLeft3 = keyInfo2;
                rotateLeft = 0;
                keyInfo2 = new KeyInfo(pending, Integer.valueOf(insertedGroupVirtualIndex), obj2.insertedGroupVirtualIndex(obj2.writer.getCurrentGroup()), -1, 0);
                rotateLeft3.registerInsert(keyInfo2, nodeIndex3 -= insertedGroupVirtualIndex);
                rotateLeft3.recordUsed(keyInfo2);
            }
            obj2.enterGroup(i9, currentGroup);
        }
        int i5 = 0;
        reusing = i8 != GroupKind.Companion.getNode-ULZAiWs() ? rGroupIndex$iv : nodeIndex;
        if (reusing == 0 && obj2.reusing) {
            i = obj2.reusing ? rGroupIndex$iv : nodeIndex;
        } else {
        }
        int i15 = i;
        if (obj2.pending == null) {
            if (i15 == 0 && obj2.reader.getGroupKey() == pending && Intrinsics.areEqual(obj4, obj2.reader.getGroupObjectKey())) {
                if (obj2.reader.getGroupKey() == pending) {
                    if (Intrinsics.areEqual(obj4, obj2.reader.getGroupObjectKey())) {
                        obj2.startReaderGroup(i9, obj5);
                    } else {
                        keyInfo = new Pending(obj2.reader.extractKeys(), obj2.nodeIndex);
                        obj2.pending = keyInfo;
                    }
                } else {
                }
            } else {
            }
        }
        androidx.compose.runtime.Pending pending2 = obj2.pending;
        newPending = 0;
        if (pending2 != null) {
            arrayList = pending2.getNext(pending, obj4);
            if (i15 == 0 && arrayList != null) {
                if (arrayList != null) {
                    pending2.recordUsed(arrayList);
                    rGroupIndex$iv = arrayList.getLocation();
                    obj2.nodeIndex = nodePositionOf += startIndex2;
                    insertedGroupVirtualIndex = pending2.slotPositionOf(arrayList);
                    keyInfo = insertedGroupVirtualIndex - groupIndex;
                    pending2.registerMoveSlot(insertedGroupVirtualIndex, pending2.getGroupIndex());
                    obj2.changeListWriter.moveReaderRelativeTo(rGroupIndex$iv);
                    obj2.reader.reposition(rGroupIndex$iv);
                    if (keyInfo > 0) {
                        obj2.changeListWriter.moveCurrentGroup(keyInfo);
                    }
                    obj2.startReaderGroup(i9, obj5);
                } else {
                    obj2.reader.beginEmpty();
                    obj2.inserting = rGroupIndex$iv;
                    obj2.providerCache = currentGroup;
                    obj2.ensureWriter();
                    obj2.writer.beginInsert();
                    currentGroup = obj2.writer.getCurrentGroup();
                    if (i9 != 0) {
                        obj2.writer.startNode(pending, Composer.Companion.getEmpty());
                    } else {
                        if (obj5 != null) {
                            if (obj4 == null) {
                                empty = Composer.Companion.getEmpty();
                            } else {
                                empty = obj4;
                            }
                            obj2.writer.startData(pending, empty, obj5);
                        } else {
                            if (obj4 == null) {
                                empty = Composer.Companion.getEmpty();
                            } else {
                                empty = obj4;
                            }
                            obj2.writer.startGroup(pending, empty);
                        }
                    }
                    obj2.insertAnchor = obj2.writer.anchor(currentGroup);
                    keyInfo4 = keyInfo7;
                    rGroupIndex$iv = new KeyInfo(pending, Integer.valueOf(insertedGroupVirtualIndex), obj2.insertedGroupVirtualIndex(currentGroup), -1, 0);
                    pending2.registerInsert(rGroupIndex$iv, nodeIndex2 -= startIndex);
                    pending2.recordUsed(rGroupIndex$iv);
                    arrayList = new ArrayList();
                    if (i9 != 0) {
                    } else {
                        nodeIndex = obj2.nodeIndex;
                    }
                    pending = new Pending((List)arrayList, nodeIndex);
                    newPending = pending;
                }
            } else {
            }
        }
        obj2.enterGroup(i9, newPending);
    }

    private final void startGroup(int key) {
        final int i = 0;
        start-BaiHCIY(key, i, GroupKind.Companion.getGroup-ULZAiWs(), i);
    }

    private final void startGroup(int key, Object dataKey) {
        start-BaiHCIY(key, dataKey, GroupKind.Companion.getGroup-ULZAiWs(), 0);
    }

    private final void startReaderGroup(boolean isNode, Object data) {
        androidx.compose.runtime.SlotReader reader;
        Object changeListWriter;
        if (isNode) {
            this.reader.startNode();
        } else {
            if (data != null && this.reader.getGroupAux() != data) {
                if (this.reader.getGroupAux() != data) {
                    this.changeListWriter.updateAuxData(data);
                }
            }
            this.reader.startGroup();
        }
    }

    private final void startRoot() {
        boolean forceRecomposeScopes;
        boolean sourceMarkersEnabled;
        androidx.compose.runtime.ProvidableCompositionLocal localInspectionTables;
        androidx.compose.runtime.CompositionContext parentContext;
        this.rGroupIndex = 0;
        this.reader = this.slotTable.openReader();
        startGroup(100);
        this.parentContext.startComposing$runtime_release();
        this.parentProvider = this.parentContext.getCompositionLocalScope$runtime_release();
        this.providersInvalidStack.push(ComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = changed(this.parentProvider);
        this.providerCache = 0;
        if (!this.forceRecomposeScopes) {
            this.forceRecomposeScopes = this.parentContext.getCollectingParameterInformation$runtime_release();
        }
        if (!this.sourceMarkersEnabled) {
            this.sourceMarkersEnabled = this.parentContext.getCollectingSourceInformation$runtime_release();
        }
        Object read = CompositionLocalMapKt.read(this.parentProvider, (CompositionLocal)InspectionTablesKt.getLocalInspectionTables());
        if ((Set)read != null) {
            localInspectionTables = 0;
            (Set)read.add(this.slotTable);
            this.parentContext.recordInspectionTable$runtime_release(read);
        }
        startGroup(this.parentContext.getCompoundHashKey$runtime_release());
    }

    private final void updateCompoundKeyWhenWeEnterGroup(int groupKey, int rGroupIndex, Object dataKey, Object data) {
        int ordinal;
        int equal;
        int i;
        Object $this$rol$iv$iv;
        int $this$rol$iv$iv3;
        int $this$rol$iv$iv2;
        int rotateLeft2;
        int rotateLeft3;
        int rotateLeft;
        final int i2 = 0;
        if (dataKey == null) {
            if (data != null && groupKey == 207 && !Intrinsics.areEqual(data, Composer.Companion.getEmpty())) {
                if (groupKey == 207) {
                    if (!Intrinsics.areEqual(data, Composer.Companion.getEmpty())) {
                        i = this;
                        $this$rol$iv$iv = 0;
                        int i8 = 0;
                        rotateLeft2 = 0;
                        i.compoundKeyHash = rotateLeft3 ^ rGroupIndex;
                    } else {
                        ordinal = this;
                        i = 0;
                        int i5 = 0;
                        $this$rol$iv$iv2 = 0;
                        ordinal.compoundKeyHash = rotateLeft2 ^ rGroupIndex;
                    }
                } else {
                }
            } else {
            }
        } else {
            if (dataKey instanceof Enum) {
                $this$rol$iv$iv = this;
                $this$rol$iv$iv3 = 0;
                int i9 = 0;
                rotateLeft3 = 0;
                $this$rol$iv$iv.compoundKeyHash = rotateLeft ^ i;
            } else {
                $this$rol$iv$iv = this;
                $this$rol$iv$iv3 = 0;
                int i10 = 0;
                rotateLeft3 = 0;
                $this$rol$iv$iv.compoundKeyHash = rotateLeft ^ i;
            }
        }
    }

    private final void updateCompoundKeyWhenWeEnterGroupKeyHash(int keyHash, int rGroupIndex) {
        final int i = 0;
        int i4 = 0;
        int i5 = 0;
        this.compoundKeyHash = rotateLeft2 ^ rGroupIndex;
    }

    private final void updateCompoundKeyWhenWeExitGroup(int groupKey, int rGroupIndex, Object dataKey, Object data) {
        int ordinal;
        int equal;
        int i2;
        Object obj;
        int i3;
        int i;
        int rotateRight2;
        int rotateRight3;
        int rotateRight;
        final int i4 = 0;
        if (dataKey == null) {
            if (data != null && groupKey == 207 && !Intrinsics.areEqual(data, Composer.Companion.getEmpty())) {
                if (groupKey == 207) {
                    if (!Intrinsics.areEqual(data, Composer.Companion.getEmpty())) {
                        i2 = this;
                        obj = 0;
                        int i18 = 0;
                        rotateRight2 = 0;
                        i2.compoundKeyHash = Integer.rotateRight(i8 ^= rotateRight5, 3);
                    } else {
                        ordinal = this;
                        i2 = 0;
                        int i15 = 0;
                        i = 0;
                        ordinal.compoundKeyHash = Integer.rotateRight(i6 ^= rotateRight4, 3);
                    }
                } else {
                }
            } else {
            }
        } else {
            if (dataKey instanceof Enum) {
                obj = this;
                i3 = 0;
                int i19 = 0;
                rotateRight3 = 0;
                obj.compoundKeyHash = Integer.rotateRight(i11 ^= rotateRight6, 3);
            } else {
                obj = this;
                i3 = 0;
                int i20 = 0;
                rotateRight3 = 0;
                obj.compoundKeyHash = Integer.rotateRight(i13 ^= rotateRight7, 3);
            }
        }
    }

    private final void updateCompoundKeyWhenWeExitGroupKeyHash(int groupKey, int rGroupIndex) {
        final int i = 0;
        int i7 = 0;
        int i8 = 0;
        this.compoundKeyHash = Integer.rotateRight(i3 ^= rotateRight, 3);
    }

    private final void updateNodeCount(int group, int count) {
        MutableIntIntMap $this$updateNodeCount_u24lambda_u2420;
        int i3;
        MutableIntIntMap mutableIntIntMap;
        int iArr;
        int i5;
        int i2;
        int i;
        int i4;
        int i6;
        if (updatedNodeCount(group) != count) {
            if (group < 0) {
                if (this.nodeCountVirtualOverrides == null) {
                    i3 = 0;
                    mutableIntIntMap = new MutableIntIntMap(0, 1, 0);
                    obj.nodeCountVirtualOverrides = mutableIntIntMap;
                    $this$updateNodeCount_u24lambda_u2420 = mutableIntIntMap;
                }
                $this$updateNodeCount_u24lambda_u2420.set(group, count);
            } else {
                if (this.nodeCountOverrides == null) {
                    Object obj2 = this;
                    i3 = 0;
                    iArr = new int[obj2.reader.getSize()];
                    ArraysKt.fill$default(iArr, -1, 0, 0, 6, 0);
                    obj2.nodeCountOverrides = iArr;
                    $this$updateNodeCount_u24lambda_u2420 = iArr;
                }
                $this$updateNodeCount_u24lambda_u2420[group] = count;
            }
        }
    }

    private final void updateNodeCountOverrides(int group, int newCount) {
        int i;
        int current;
        int minPending;
        int reader;
        int i2;
        int pendingIndex;
        Object peek;
        boolean nodeCount;
        final int updatedNodeCount = updatedNodeCount(group);
        if (updatedNodeCount != newCount) {
            current = group;
            size--;
            reader = -1;
            while (current != reader) {
                updatedNodeCount2 += i;
                updateNodeCount(current, i2);
                pendingIndex = minPending;
                while (reader < pendingIndex) {
                    peek = this.pendingStack.peek(pendingIndex);
                    if ((Pending)peek != null) {
                        break loop_4;
                    } else {
                    }
                    pendingIndex--;
                    if ((Pending)peek.updateNodeCount(current, i2)) {
                        break loop_4;
                    } else {
                    }
                }
                if (current < 0) {
                } else {
                }
                if (!this.reader.isNode(current)) {
                }
                current = this.reader.parent(current);
                reader = -1;
                current = this.reader.getParent();
                peek = this.pendingStack.peek(pendingIndex);
                if ((Pending)peek != null) {
                } else {
                }
                pendingIndex--;
                if ((Pending)peek.updateNodeCount(current, i2)) {
                } else {
                }
                minPending = pendingIndex + -1;
            }
        }
    }

    private final androidx.compose.runtime.PersistentCompositionLocalMap updateProviderMapGroup(androidx.compose.runtime.PersistentCompositionLocalMap parentScope, androidx.compose.runtime.PersistentCompositionLocalMap currentProviders) {
        int i = 0;
        androidx.compose.runtime.PersistentCompositionLocalMap.Builder builder = parentScope.builder();
        final int i3 = 0;
        (Map)builder.putAll((Map)currentProviders);
        androidx.compose.runtime.PersistentCompositionLocalMap $this$mutate$iv = builder.build();
        startGroup(204, ComposerKt.getProviderMaps());
        updateSlot($this$mutate$iv);
        updateSlot(currentProviders);
        endGroup();
        return $this$mutate$iv;
    }

    private final void updateSlot(Object value) {
        nextSlot();
        updateValue(value);
    }

    private final int updatedNodeCount(int group) {
        int i;
        int i3;
        int i2;
        boolean contains;
        if (group < 0) {
            MutableIntIntMap nodeCountVirtualOverrides = this.nodeCountVirtualOverrides;
            i3 = 0;
            if (nodeCountVirtualOverrides != null) {
                i2 = 0;
                if (nodeCountVirtualOverrides.contains(group)) {
                    i3 = nodeCountVirtualOverrides.get(group);
                }
            } else {
            }
            return i3;
        }
        int[] nodeCountOverrides = this.nodeCountOverrides;
        i = nodeCountOverrides[group];
        if (nodeCountOverrides != null && i >= 0) {
            i = nodeCountOverrides[group];
            if (i >= 0) {
                return i;
            }
        }
        return this.reader.nodeCount(group);
    }

    private final void validateNodeExpected() {
        String str;
        final int i = 0;
        if (!this.nodeExpected) {
            int i2 = 0;
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected was not expected");
        }
        this.nodeExpected = false;
    }

    private final void validateNodeNotExpected() {
        String str;
        final int i2 = 0;
        if (nodeExpected ^= 1 == 0) {
            int i3 = 0;
            ComposerKt.composeImmediateRuntimeError("A call to createNode(), emitNode() or useNode() expected");
        }
    }

    private final <R> R withReader(androidx.compose.runtime.SlotReader reader, Function0<? extends R> block) {
        final int i = 0;
        int i2 = 0;
        ComposerImpl.access$setNodeCountOverrides$p(this, i2);
        ComposerImpl.access$setProviderUpdates$p(this, i2);
        setReader$runtime_release(reader);
        setReader$runtime_release(getReader$runtime_release());
        ComposerImpl.access$setNodeCountOverrides$p(this, ComposerImpl.access$getNodeCountOverrides$p(this));
        ComposerImpl.access$setProviderUpdates$p(this, ComposerImpl.access$getProviderUpdates$p(this));
        return block.invoke();
    }

    public <V, T> void apply(V value, Function2<? super T, ? super V, Unit> block) {
        Object changeListWriter;
        if (getInserting()) {
            this.insertFixups.updateNode(value, block);
        } else {
            this.changeListWriter.updateNode(value, block);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public androidx.compose.runtime.CompositionContext buildContext() {
        boolean inserting;
        Object holder;
        int observerHolder$runtime_release;
        int i;
        androidx.compose.runtime.ComposerImpl.CompositionContextHolder compositionContextHolder;
        int compositionContextImpl;
        androidx.compose.runtime.ControlledComposition composition;
        Object obj;
        int compoundKeyHash;
        boolean forceRecomposeScopes;
        boolean sourceMarkersEnabled;
        int i2;
        startGroup(206, ComposerKt.getReference());
        observerHolder$runtime_release = 0;
        if (getInserting()) {
            SlotWriter.markGroup$default(this.writer, 0, 1, observerHolder$runtime_release);
        }
        if (holder instanceof ComposerImpl.CompositionContextHolder) {
        } else {
            holder = observerHolder$runtime_release;
        }
        if (holder == null) {
            if (composition instanceof CompositionImpl) {
            } else {
                composition = observerHolder$runtime_release;
            }
            if (composition != null) {
                observerHolder$runtime_release = composition.getObserverHolder$runtime_release();
            }
            compositionContextImpl = new ComposerImpl.CompositionContextImpl(this, getCompoundKeyHash(), this.forceRecomposeScopes, this.sourceMarkersEnabled, observerHolder$runtime_release);
            compositionContextHolder = new ComposerImpl.CompositionContextHolder(compositionContextImpl);
            updateValue(compositionContextHolder);
        } else {
            obj = this;
        }
        holder.getRef().updateCompositionLocalScope(currentCompositionLocalScope());
        endGroup();
        return (CompositionContext)holder.getRef();
    }

    @ComposeCompilerApi
    public final <T> T cache(boolean invalid, Function0<? extends T> block) {
        Object result;
        Object invoke;
        final int i = 0;
        if (nextSlotForCache() != Composer.Companion.getEmpty()) {
            if (invalid) {
                invoke = block.invoke();
                updateCachedValue(invoke);
                result = invoke;
            }
        } else {
        }
        return result;
    }

    @ComposeCompilerApi
    public boolean changed(byte value) {
        boolean byteValue;
        final Object nextSlot = nextSlot();
        if (nextSlot instanceof Byte && value == (Number)nextSlot.byteValue()) {
            if (value == (Number)nextSlot.byteValue()) {
                return 0;
            }
        }
        updateValue(Byte.valueOf(value));
        return 1;
    }

    @ComposeCompilerApi
    public boolean changed(char value) {
        boolean charValue;
        final Object nextSlot = nextSlot();
        if (nextSlot instanceof Character && value == (Character)nextSlot.charValue()) {
            if (value == (Character)nextSlot.charValue()) {
                return 0;
            }
        }
        updateValue(Character.valueOf(value));
        return 1;
    }

    @ComposeCompilerApi
    public boolean changed(double value) {
        int i2;
        double doubleValue;
        int i;
        final Object nextSlot = nextSlot();
        final int i3 = 1;
        if (nextSlot instanceof Double) {
            i = 0;
            i2 = Double.compare(value, doubleValue) == 0 ? i3 : i;
            if (i2 != 0) {
                return i;
            }
        }
        updateValue(Double.valueOf(value));
        return i3;
    }

    @ComposeCompilerApi
    public boolean changed(float value) {
        boolean floatValue;
        int i;
        int i2;
        final Object nextSlot = nextSlot();
        final int i3 = 1;
        if (nextSlot instanceof Float) {
            i2 = 0;
            i = Float.compare(value, floatValue) == 0 ? i3 : i2;
            if (i != 0) {
                return i2;
            }
        }
        updateValue(Float.valueOf(value));
        return i3;
    }

    @ComposeCompilerApi
    public boolean changed(int value) {
        boolean intValue;
        final Object nextSlot = nextSlot();
        if (nextSlot instanceof Integer && value == (Number)nextSlot.intValue()) {
            if (value == (Number)nextSlot.intValue()) {
                return 0;
            }
        }
        updateValue(Integer.valueOf(value));
        return 1;
    }

    @ComposeCompilerApi
    public boolean changed(long value) {
        boolean longValue;
        int cmp;
        final Object nextSlot = nextSlot();
        if (nextSlot instanceof Long && Long.compare(value, longValue) == 0) {
            if (Long.compare(value, longValue) == 0) {
                return 0;
            }
        }
        updateValue(Long.valueOf(value));
        return 1;
    }

    @ComposeCompilerApi
    public boolean changed(Object value) {
        int i;
        i = !Intrinsics.areEqual(nextSlot(), value) ? 1 : 0;
        return i;
    }

    @ComposeCompilerApi
    public boolean changed(short value) {
        boolean shortValue;
        final Object nextSlot = nextSlot();
        if (nextSlot instanceof Short && value == (Number)nextSlot.shortValue()) {
            if (value == (Number)nextSlot.shortValue()) {
                return 0;
            }
        }
        updateValue(Short.valueOf(value));
        return 1;
    }

    @ComposeCompilerApi
    public boolean changed(boolean value) {
        boolean booleanValue;
        final Object nextSlot = nextSlot();
        if (nextSlot instanceof Boolean && value == (Boolean)nextSlot.booleanValue()) {
            if (value == (Boolean)nextSlot.booleanValue()) {
                return 0;
            }
        }
        updateValue(Boolean.valueOf(value));
        return 1;
    }

    @ComposeCompilerApi
    public boolean changedInstance(Object value) {
        int i;
        i = nextSlot() != value ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.Composer
    public final void changesApplied$runtime_release() {
        this.providerUpdates = 0;
    }

    @Override // androidx.compose.runtime.Composer
    public void collectParameterInformation() {
        int i = 1;
        this.forceRecomposeScopes = i;
        this.sourceMarkersEnabled = i;
        this.slotTable.collectSourceInformation();
        this.insertTable.collectSourceInformation();
        this.writer.updateToTableMaps();
    }

    public final void composeContent$runtime_release(ScopeMap<androidx.compose.runtime.RecomposeScopeImpl, Object> invalidationsRequested, Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        String str;
        final int i = 0;
        if (!this.changes.isEmpty()) {
            int i2 = 0;
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        doCompose(invalidationsRequested, content);
    }

    public <T> T consume(androidx.compose.runtime.CompositionLocal<T> key) {
        return CompositionLocalMapKt.read(currentCompositionLocalScope(), key);
    }

    public <T> void createNode(Function0<? extends T> factory) {
        String str;
        validateNodeExpected();
        int i = 0;
        if (!getInserting()) {
            int i3 = 0;
            ComposerKt.composeImmediateRuntimeError("createNode() can only be called when inserting");
        }
        this.groupNodeCount = groupNodeCount++;
        this.insertFixups.createAndInsertNode(factory, this.parentStateStack.peek(), this.writer.anchor(this.writer.getParent()));
    }

    @Override // androidx.compose.runtime.Composer
    public final void deactivate$runtime_release() {
        this.invalidateStack.clear();
        this.invalidations.clear();
        this.changes.clear();
        this.providerUpdates = 0;
    }

    @ComposeCompilerApi
    public void deactivateToEndGroup(boolean changed) {
        int i;
        boolean currentGroup;
        int currentEnd;
        String reader;
        i = this.groupNodeCount == 0 ? 1 : 0;
        currentEnd = 0;
        if (i == 0) {
            int i2 = 0;
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling dactivateToEndGroup");
        }
        if (!getInserting() && !changed) {
            if (!changed) {
                skipReaderToGroupEnd();
            }
            this.changeListWriter.deactivateCurrentGroup();
            ComposerKt.access$removeRange(this.invalidations, this.reader.getCurrentGroup(), this.reader.getCurrentEnd());
            this.reader.skipToGroupEnd();
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void disableReusing() {
        this.reusing = false;
    }

    @Override // androidx.compose.runtime.Composer
    public void disableSourceInformation() {
        this.sourceMarkersEnabled = false;
    }

    @Override // androidx.compose.runtime.Composer
    public final void dispose$runtime_release() {
        final int i = 0;
        int i2 = 0;
        this.parentContext.unregisterComposer$runtime_release((Composer)this);
        deactivate$runtime_release();
        getApplier().clear();
        this.isDisposed = true;
        Unit iNSTANCE2 = Unit.INSTANCE;
        Trace.INSTANCE.endSection(Trace.INSTANCE.beginSection("Compose:Composer.dispose"));
    }

    @Override // androidx.compose.runtime.Composer
    public void enableReusing() {
        int i;
        i = this.reusingGroup >= 0 ? 1 : 0;
        this.reusing = i;
    }

    @ComposeCompilerApi
    public void endDefaults() {
        boolean used;
        endGroup();
        final androidx.compose.runtime.RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getUsed()) {
            if (currentRecomposeScope$runtime_release.getUsed()) {
                currentRecomposeScope$runtime_release.setDefaultsInScope(true);
            }
        }
    }

    @ComposeCompilerApi
    public void endMovableGroup() {
        endGroup();
    }

    @Override // androidx.compose.runtime.Composer
    public void endNode() {
        end(true);
    }

    @Override // androidx.compose.runtime.Composer
    public void endProvider() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.access$asBool(this.providersInvalidStack.pop());
        this.providerCache = 0;
    }

    @Override // androidx.compose.runtime.Composer
    public void endProviders() {
        endGroup();
        endGroup();
        this.providersInvalid = ComposerKt.access$asBool(this.providersInvalidStack.pop());
        this.providerCache = 0;
    }

    @ComposeCompilerApi
    public void endReplaceGroup() {
        endGroup();
    }

    @ComposeCompilerApi
    public void endReplaceableGroup() {
        endGroup();
    }

    @ComposeCompilerApi
    public androidx.compose.runtime.ScopeUpdateScope endRestartGroup() {
        Object obj;
        Object i;
        androidx.compose.runtime.Anchor anchor;
        kotlin.jvm.functions.Function1 forceRecomposeScopes;
        int i2;
        ComposerChangeListWriter changeListWriter;
        androidx.compose.runtime.ControlledComposition composition;
        if (this.invalidateStack.isNotEmpty()) {
            obj = this.invalidateStack.pop();
        } else {
            obj = i;
        }
        int i3 = 0;
        if (obj == null) {
        } else {
            obj.setRequiresRecompose(i3);
        }
        forceRecomposeScopes = obj.end(this.compositionToken);
        if (obj != null && forceRecomposeScopes != null) {
            forceRecomposeScopes = obj.end(this.compositionToken);
            if (forceRecomposeScopes != null) {
                i2 = 0;
                this.changeListWriter.endCompositionScope(forceRecomposeScopes, (Composition)getComposition());
            }
        }
        if (obj != null && !obj.getSkipped$runtime_release()) {
            if (!obj.getSkipped$runtime_release()) {
                if (!obj.getUsed()) {
                    if (this.forceRecomposeScopes) {
                        if (obj.getAnchor() == null) {
                            if (getInserting()) {
                                anchor = this.writer.anchor(this.writer.getParent());
                            } else {
                                anchor = this.reader.anchor(this.reader.getParent());
                            }
                            obj.setAnchor(anchor);
                        }
                        obj.setDefaultsInvalid(i3);
                        i = obj;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        end(i3);
        return (ScopeUpdateScope)i;
    }

    @Override // androidx.compose.runtime.Composer
    public void endReusableGroup() {
        boolean reusing;
        int reusingGroup;
        final int i = 0;
        if (this.reusing && this.reader.getParent() == this.reusingGroup) {
            if (this.reader.getParent() == this.reusingGroup) {
                this.reusingGroup = -1;
                this.reusing = i;
            }
        }
        end(i);
    }

    @Override // androidx.compose.runtime.Composer
    public final void endReuseFromRoot() {
        boolean reusingGroup;
        int i2;
        int i;
        String str;
        final int i3 = 0;
        if (!this.isComposing && this.reusingGroup == 100) {
            i2 = this.reusingGroup == 100 ? 1 : i3;
        } else {
        }
        int i4 = 0;
        if (i2 == 0) {
            int i5 = 0;
            PreconditionsKt.throwIllegalArgumentException("Cannot disable reuse from root if it was caused by other groups");
        }
        this.reusingGroup = -1;
        this.reusing = i3;
    }

    @Override // androidx.compose.runtime.Composer
    public void endToMarker(int marker) {
        int writer;
        boolean inserting2;
        androidx.compose.runtime.SlotWriter inserting;
        int parent;
        boolean node;
        if (marker < 0) {
            inserting = this.writer;
            parent = inserting.getParent();
            while (parent > -marker) {
                end(inserting.isNode(parent));
                parent = inserting.getParent();
            }
        } else {
            if (getInserting()) {
                inserting2 = this.writer;
                while (getInserting()) {
                    end(inserting2.isNode(inserting2.getParent()));
                }
            }
            writer = this.reader;
            inserting = writer.getParent();
            while (inserting > marker) {
                end(writer.isNode(inserting));
                inserting = writer.getParent();
            }
        }
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean forceRecomposeScopes$runtime_release() {
        int i;
        if (!this.forceRecomposeScopes) {
            i = 1;
            this.forceRecomposeScopes = i;
            this.forciblyRecompose = i;
        } else {
            i = 0;
        }
        return i;
    }

    public androidx.compose.runtime.Applier<?> getApplier() {
        return this.applier;
    }

    @Override // androidx.compose.runtime.Composer
    public CoroutineContext getApplyCoroutineContext() {
        return this.parentContext.getEffectCoroutineContext();
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean getAreChildrenComposing$runtime_release() {
        int i;
        i = this.childrenComposing > 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.Composer
    public final int getChangeCount$runtime_release() {
        return this.changes.getSize();
    }

    @Override // androidx.compose.runtime.Composer
    public androidx.compose.runtime.ControlledComposition getComposition() {
        return this.composition;
    }

    @Override // androidx.compose.runtime.Composer
    public CompositionData getCompositionData() {
        return (CompositionData)this.slotTable;
    }

    @Override // androidx.compose.runtime.Composer
    public int getCompoundKeyHash() {
        return this.compoundKeyHash;
    }

    @Override // androidx.compose.runtime.Composer
    public androidx.compose.runtime.CompositionLocalMap getCurrentCompositionLocalMap() {
        return (CompositionLocalMap)currentCompositionLocalScope();
    }

    @Override // androidx.compose.runtime.Composer
    public int getCurrentMarker() {
        int parent;
        if (getInserting()) {
            parent = -parent2;
        } else {
            parent = this.reader.getParent();
        }
        return parent;
    }

    @Override // androidx.compose.runtime.Composer
    public final androidx.compose.runtime.RecomposeScopeImpl getCurrentRecomposeScope$runtime_release() {
        int childrenComposing;
        int peek;
        final androidx.compose.runtime.Stack invalidateStack = this.invalidateStack;
        final int i = 0;
        if (this.childrenComposing == 0 && invalidateStack.isNotEmpty()) {
            if (invalidateStack.isNotEmpty()) {
                peek = invalidateStack.peek();
            } else {
                peek = 0;
            }
        } else {
        }
        return peek;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getDefaultsInvalid() {
        boolean providersInvalid;
        androidx.compose.runtime.RecomposeScopeImpl currentRecomposeScope$runtime_release;
        int i;
        int i2;
        i = 1;
        if (getSkipping() && !this.providersInvalid) {
            if (!this.providersInvalid) {
                currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
                i2 = 0;
                if (currentRecomposeScope$runtime_release != null && currentRecomposeScope$runtime_release.getDefaultsInvalid() == i) {
                    providersInvalid = currentRecomposeScope$runtime_release.getDefaultsInvalid() == i ? i : i2;
                } else {
                }
                if (providersInvalid != 0) {
                } else {
                    i = i2;
                }
            }
        }
        return i;
    }

    @Override // androidx.compose.runtime.Composer
    public final ChangeList getDeferredChanges$runtime_release() {
        return this.deferredChanges;
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean getHasInvalidations() {
        return empty ^= 1;
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean getHasPendingChanges$runtime_release() {
        return this.changes.isNotEmpty();
    }

    @Override // androidx.compose.runtime.Composer
    public final androidx.compose.runtime.SlotTable getInsertTable$runtime_release() {
        return this.insertTable;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getInserting() {
        return this.inserting;
    }

    @Override // androidx.compose.runtime.Composer
    public final androidx.compose.runtime.SlotReader getReader$runtime_release() {
        return this.reader;
    }

    @Override // androidx.compose.runtime.Composer
    public androidx.compose.runtime.RecomposeScope getRecomposeScope() {
        return (RecomposeScope)getCurrentRecomposeScope$runtime_release();
    }

    @Override // androidx.compose.runtime.Composer
    public Object getRecomposeScopeIdentity() {
        androidx.compose.runtime.Anchor anchor;
        androidx.compose.runtime.RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            anchor = currentRecomposeScope$runtime_release.getAnchor();
        } else {
            anchor = 0;
        }
        return anchor;
    }

    @Override // androidx.compose.runtime.Composer
    public boolean getSkipping() {
        boolean forciblyRecompose;
        androidx.compose.runtime.RecomposeScopeImpl currentRecomposeScope$runtime_release;
        int i2;
        int i;
        if (!getInserting() && !this.reusing && !this.providersInvalid) {
            if (!this.reusing) {
                if (!this.providersInvalid) {
                    currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
                    i = 1;
                    if (currentRecomposeScope$runtime_release != null && !currentRecomposeScope$runtime_release.getRequiresRecompose()) {
                        forciblyRecompose = !currentRecomposeScope$runtime_release.getRequiresRecompose() ? i : i2;
                    } else {
                    }
                    if (forciblyRecompose != 0 && !this.forciblyRecompose) {
                        if (!this.forciblyRecompose) {
                            i2 = i;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i2;
    }

    public void insertMovableContent(androidx.compose.runtime.MovableContent<?> value, Object parameter) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.MovableContent<kotlin.Any?>");
        invokeMovableContentLambda(value, currentCompositionLocalScope(), parameter, false);
    }

    public void insertMovableContentReferences(List<Pair<androidx.compose.runtime.MovableContentStateReference, androidx.compose.runtime.MovableContentStateReference>> references) {
        int i = 0;
        insertMovableContentGuarded(references);
        int completed = 1;
        cleanUpCompose();
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean isComposing$runtime_release() {
        return this.isComposing;
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean isDisposed$runtime_release() {
        return this.isDisposed;
    }

    @ComposeCompilerApi
    public Object joinKey(Object left, Object right) {
        Object joinedKey;
        if (ComposerKt.access$getKey(this.reader.getGroupObjectKey(), left, right) == null) {
            joinedKey = new JoinedKey(left, right);
        }
        return joinedKey;
    }

    @Override // androidx.compose.runtime.Composer
    public final Object nextSlot() {
        Object it;
        int i;
        boolean reusing;
        if (getInserting()) {
            validateNodeNotExpected();
            it = Composer.Companion.getEmpty();
        } else {
            i = 0;
            if (this.reusing && !it instanceof ReusableRememberObserver) {
                if (!it instanceof ReusableRememberObserver) {
                    it = reusing;
                }
            }
        }
        return it;
    }

    @Override // androidx.compose.runtime.Composer
    public final Object nextSlotForCache() {
        Object it;
        int i;
        boolean reusing;
        Object wrapped;
        if (getInserting()) {
            validateNodeNotExpected();
            it = Composer.Companion.getEmpty();
        } else {
            Object next = this.reader.next();
            i = 0;
            if (this.reusing && !next instanceof ReusableRememberObserver) {
                if (!next instanceof ReusableRememberObserver) {
                    wrapped = Composer.Companion.getEmpty();
                } else {
                    if (next instanceof RememberObserverHolder) {
                        wrapped = (RememberObserverHolder)next.getWrapped();
                    } else {
                        wrapped = next;
                    }
                }
            } else {
            }
            it = wrapped;
        }
        return it;
    }

    @Override // androidx.compose.runtime.Composer
    public final int parentKey$runtime_release() {
        int groupKey;
        int parent;
        if (getInserting()) {
            groupKey = this.writer.groupKey(this.writer.getParent());
        } else {
            groupKey = this.reader.groupKey(this.reader.getParent());
        }
        return groupKey;
    }

    public final void prepareCompose$runtime_release(Function0<Unit> block) {
        String str;
        final int i3 = 1;
        final int i4 = 0;
        if (isComposing ^= i3 == 0) {
            int i5 = 0;
            ComposerKt.composeImmediateRuntimeError("Preparing a composition while composing is not supported");
        }
        this.isComposing = i3;
        block.invoke();
        this.isComposing = false;
    }

    public final boolean recompose$runtime_release(ScopeMap<androidx.compose.runtime.RecomposeScopeImpl, Object> invalidationsRequested) {
        int forciblyRecompose;
        String str;
        final int i3 = 0;
        if (!this.changes.isEmpty()) {
            int i4 = 0;
            ComposerKt.composeImmediateRuntimeError("Expected applyChanges() to have been called");
        }
        if (invalidationsRequested.getSize() <= 0 && (Collection)this.invalidations.isEmpty() && this.forciblyRecompose) {
            if ((Collection)this.invalidations.isEmpty()) {
                if (this.forciblyRecompose) {
                }
                return 0;
            }
        }
        doCompose(invalidationsRequested, 0);
        return this.changes.isNotEmpty();
    }

    public void recordSideEffect(Function0<Unit> effect) {
        this.changeListWriter.sideEffect(effect);
    }

    @Override // androidx.compose.runtime.Composer
    public void recordUsed(androidx.compose.runtime.RecomposeScope scope) {
        Object obj;
        int i;
        if (scope instanceof RecomposeScopeImpl) {
            obj = scope;
        } else {
            obj = 0;
        }
        if (obj == null) {
        } else {
            obj.setUsed(true);
        }
    }

    @Override // androidx.compose.runtime.Composer
    public Object rememberedValue() {
        return nextSlotForCache();
    }

    @Override // androidx.compose.runtime.Composer
    public final void setDeferredChanges$runtime_release(ChangeList <set-?>) {
        this.deferredChanges = <set-?>;
    }

    @Override // androidx.compose.runtime.Composer
    public final void setInsertTable$runtime_release(androidx.compose.runtime.SlotTable <set-?>) {
        this.insertTable = <set-?>;
    }

    @Override // androidx.compose.runtime.Composer
    public final void setReader$runtime_release(androidx.compose.runtime.SlotReader <set-?>) {
        this.reader = <set-?>;
    }

    @ComposeCompilerApi
    public void skipCurrentGroup() {
        boolean reader;
        int groupKey;
        Object groupObjectKey;
        Object groupAux;
        int rGroupIndex;
        Object obj2;
        int i;
        int ordinal;
        int equal;
        int equal2;
        int ordinal2;
        Object obj;
        Object obj3;
        int i2;
        int $this$rol$iv$iv$iv;
        int i3;
        int $this$rol$iv$iv$iv2;
        int rotateRight;
        int $this$rol$iv$iv$iv3;
        int rotateRight3;
        int rotateRight2;
        int rotateLeft;
        final Object obj4 = this;
        if (obj4.invalidations.isEmpty()) {
            obj4.skipGroup();
        } else {
            reader = obj4.reader;
            groupKey = reader.getGroupKey();
            groupObjectKey = reader.getGroupObjectKey();
            groupAux = reader.getGroupAux();
            rGroupIndex = obj4.rGroupIndex;
            Object obj5 = this;
            int i4 = 0;
            equal = 207;
            if (groupObjectKey == null) {
                if (groupAux != null && groupKey == equal && !Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
                    if (groupKey == equal) {
                        if (!Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
                            obj3 = obj5;
                            $this$rol$iv$iv$iv = 0;
                            int i25 = 0;
                            rotateRight3 = 0;
                            obj3.compoundKeyHash = rotateRight2 ^ rGroupIndex;
                        } else {
                            ordinal2 = obj5;
                            obj3 = 0;
                            int i22 = 0;
                            $this$rol$iv$iv$iv3 = 0;
                            ordinal2.compoundKeyHash = rotateRight3 ^ rGroupIndex;
                        }
                    } else {
                    }
                } else {
                }
            } else {
                if (groupObjectKey instanceof Enum) {
                    $this$rol$iv$iv$iv = obj5;
                    $this$rol$iv$iv$iv2 = 0;
                    int i28 = 0;
                    rotateRight2 = 0;
                    $this$rol$iv$iv$iv.compoundKeyHash = rotateLeft ^ obj3;
                } else {
                    $this$rol$iv$iv$iv = obj5;
                    $this$rol$iv$iv$iv2 = 0;
                    int i29 = 0;
                    rotateRight2 = 0;
                    $this$rol$iv$iv$iv.compoundKeyHash = rotateLeft ^ obj3;
                }
            }
            obj4.startReaderGroup(reader.isNode(), 0);
            obj4.recomposeToGroupEnd();
            reader.endGroup();
            obj2 = this;
            i = 0;
            if (groupObjectKey == null) {
                if (groupAux != null && groupKey == equal && !Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
                    if (groupKey == equal) {
                        if (!Intrinsics.areEqual(groupAux, Composer.Companion.getEmpty())) {
                            equal2 = obj2;
                            obj = 0;
                            int i20 = 0;
                            rotateRight = 0;
                            equal2.compoundKeyHash = Integer.rotateRight(i9 ^= rotateRight5, 3);
                        } else {
                            ordinal = obj2;
                            equal2 = 0;
                            int i16 = 0;
                            i3 = 0;
                            ordinal.compoundKeyHash = Integer.rotateRight(i7 ^= rotateRight4, 3);
                        }
                    } else {
                    }
                } else {
                }
            } else {
                if (groupObjectKey instanceof Enum) {
                    obj = obj2;
                    i2 = 0;
                    int i23 = 0;
                    rotateRight3 = 0;
                    obj.compoundKeyHash = Integer.rotateRight(i12 ^= rotateRight6, 3);
                } else {
                    obj = obj2;
                    i2 = 0;
                    int i24 = 0;
                    rotateRight3 = 0;
                    obj.compoundKeyHash = Integer.rotateRight(i14 ^= rotateRight7, 3);
                }
            }
        }
    }

    @ComposeCompilerApi
    public void skipToGroupEnd() {
        int i;
        String str;
        i = this.groupNodeCount == 0 ? 1 : 0;
        final int i2 = 0;
        if (i == 0) {
            int i3 = 0;
            ComposerKt.composeImmediateRuntimeError("No nodes can be emitted before calling skipAndEndGroup");
        }
        androidx.compose.runtime.RecomposeScopeImpl currentRecomposeScope$runtime_release = getCurrentRecomposeScope$runtime_release();
        if (currentRecomposeScope$runtime_release != null) {
            currentRecomposeScope$runtime_release.scopeSkipped();
        }
        if (this.invalidations.isEmpty()) {
            skipReaderToGroupEnd();
        } else {
            recomposeToGroupEnd();
        }
    }

    @ComposeCompilerApi
    public void sourceInformation(String sourceInformation) {
        boolean sourceMarkersEnabled;
        if (getInserting() && this.sourceMarkersEnabled) {
            if (this.sourceMarkersEnabled) {
                this.writer.recordGroupSourceInformation(sourceInformation);
            }
        }
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerEnd() {
        boolean sourceMarkersEnabled;
        if (getInserting() && this.sourceMarkersEnabled) {
            if (this.sourceMarkersEnabled) {
                this.writer.recordGrouplessCallSourceInformationEnd();
            }
        }
    }

    @ComposeCompilerApi
    public void sourceInformationMarkerStart(int key, String sourceInformation) {
        boolean sourceMarkersEnabled;
        if (getInserting() && this.sourceMarkersEnabled) {
            if (this.sourceMarkersEnabled) {
                this.writer.recordGrouplessCallSourceInformationStart(key, sourceInformation);
            }
        }
    }

    @Override // androidx.compose.runtime.Composer
    public final int stacksSize$runtime_release() {
        return i3 += size5;
    }

    @ComposeCompilerApi
    public void startDefaults() {
        final int i2 = 0;
        start-BaiHCIY(-127, i2, GroupKind.Companion.getGroup-ULZAiWs(), i2);
    }

    @ComposeCompilerApi
    public void startMovableGroup(int key, Object dataKey) {
        start-BaiHCIY(key, dataKey, GroupKind.Companion.getGroup-ULZAiWs(), 0);
    }

    @Override // androidx.compose.runtime.Composer
    public void startNode() {
        final int i3 = 0;
        start-BaiHCIY(125, i3, GroupKind.Companion.getNode-ULZAiWs(), i3);
        this.nodeExpected = true;
    }

    public void startProvider(androidx.compose.runtime.ProvidedValue<?> value) {
        int i;
        int inserting;
        int providers;
        androidx.compose.runtime.PersistentCompositionLocalMap oldScope;
        boolean canOverride;
        boolean canOverride2;
        Object value2;
        final androidx.compose.runtime.PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        Object rememberedValue = rememberedValue();
        int i3 = 0;
        if (Intrinsics.areEqual(rememberedValue, Composer.Companion.getEmpty())) {
            i = 0;
        } else {
            Intrinsics.checkNotNull(rememberedValue, "null cannot be cast to non-null type androidx.compose.runtime.ValueHolder<kotlin.Any?>");
            i = rememberedValue;
        }
        androidx.compose.runtime.CompositionLocal compositionLocal = value.getCompositionLocal();
        Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.ProvidedValue<kotlin.Any?>");
        androidx.compose.runtime.ValueHolder updatedStateOf$runtime_release = compositionLocal.updatedStateOf$runtime_release(value, i);
        inserting = 1;
        equal2 ^= inserting;
        if (i4 != 0) {
            updateRememberedValue(updatedStateOf$runtime_release);
        }
        int i5 = 0;
        int i6 = 0;
        if (getInserting()) {
            if (!value.getCanOverride()) {
                if (!CompositionLocalMapKt.contains(currentCompositionLocalScope, compositionLocal)) {
                    oldScope = currentCompositionLocalScope.putValue(compositionLocal, updatedStateOf$runtime_release);
                } else {
                    oldScope = currentCompositionLocalScope;
                }
            } else {
            }
            providers = 0;
            this.writerHasAProvider = inserting;
        } else {
            Object groupAux = this.reader.groupAux(this.reader.getCurrentGroup());
            Intrinsics.checkNotNull(groupAux, "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap");
            if (getSkipping()) {
                if (i4 != 0) {
                    if (!value.getCanOverride()) {
                        if (!CompositionLocalMapKt.contains(currentCompositionLocalScope, compositionLocal)) {
                            value2 = currentCompositionLocalScope.putValue(compositionLocal, updatedStateOf$runtime_release);
                        } else {
                            value2 = groupAux;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (!this.reusing) {
                if ((PersistentCompositionLocalMap)groupAux != value2) {
                } else {
                    inserting = 0;
                }
            }
            providers = inserting;
            oldScope = value2;
        }
        if (providers != 0 && !getInserting()) {
            if (!getInserting()) {
                recordProviderUpdate(oldScope);
            }
        }
        this.providersInvalidStack.push(ComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = providers;
        this.providerCache = oldScope;
        start-BaiHCIY(202, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.getGroup-ULZAiWs(), oldScope);
    }

    public void startProviders(androidx.compose.runtime.ProvidedValue<?>[] values) {
        Object providers;
        int invalid;
        Object compositionMap$default;
        int i;
        int i2;
        Object obj;
        androidx.compose.runtime.PersistentCompositionLocalMap compositionMap;
        boolean skipping;
        final androidx.compose.runtime.PersistentCompositionLocalMap currentCompositionLocalScope = currentCompositionLocalScope();
        startGroup(201, ComposerKt.getProvider());
        int i4 = 0;
        int i5 = 0;
        i = 1;
        if (getInserting()) {
            i2 = 0;
            providers = updateProviderMapGroup(currentCompositionLocalScope, CompositionLocalMapKt.updateCompositionMap$default(values, currentCompositionLocalScope, i2, 4, i2));
            invalid = 0;
            this.writerHasAProvider = i;
        } else {
            i2 = 0;
            compositionMap$default = this.reader.groupGet(i2);
            String str = "null cannot be cast to non-null type androidx.compose.runtime.PersistentCompositionLocalMap";
            Intrinsics.checkNotNull(compositionMap$default, str);
            Object groupGet = this.reader.groupGet(i);
            Intrinsics.checkNotNull(groupGet, str);
            obj = groupGet;
            compositionMap = CompositionLocalMapKt.updateCompositionMap(values, currentCompositionLocalScope, (PersistentCompositionLocalMap)obj);
            if (getSkipping() && !this.reusing) {
                if (!this.reusing) {
                    if (!Intrinsics.areEqual(obj, compositionMap)) {
                        if (!this.reusing) {
                            if (!Intrinsics.areEqual(updateProviderMapGroup(currentCompositionLocalScope, compositionMap), (PersistentCompositionLocalMap)compositionMap$default)) {
                            } else {
                                i = i2;
                            }
                        }
                        invalid = i;
                    } else {
                        skipGroup();
                        providers = compositionMap$default;
                        invalid = 0;
                    }
                } else {
                }
            } else {
            }
        }
        if (invalid != 0 && !getInserting()) {
            if (!getInserting()) {
                recordProviderUpdate(providers);
            }
        }
        this.providersInvalidStack.push(ComposerKt.access$asInt(this.providersInvalid));
        this.providersInvalid = invalid;
        this.providerCache = providers;
        start-BaiHCIY(202, ComposerKt.getCompositionLocalMap(), GroupKind.Companion.getGroup-ULZAiWs(), providers);
    }

    @ComposeCompilerApi
    public void startReplaceGroup(int key) {
        int hasObjectKey;
        boolean nodeIndex;
        Object currentGroup2;
        int skipGroup;
        int $this$rol$iv$iv$iv;
        int currentGroup;
        final int i = 0;
        if (this.pending != null) {
            start-BaiHCIY(key, i, GroupKind.Companion.getGroup-ULZAiWs(), i);
        }
        validateNodeNotExpected();
        int i3 = 0;
        int i5 = 0;
        hasObjectKey = 0;
        currentGroup2 = obj;
        skipGroup = 0;
        int i8 = 0;
        int i9 = 0;
        currentGroup2.compoundKeyHash = rotateLeft2 ^ rGroupIndex;
        int i4 = 1;
        this.rGroupIndex = rGroupIndex$iv += i4;
        androidx.compose.runtime.SlotReader reader = this.reader;
        int i6 = 0;
        if (getInserting()) {
            reader.beginEmpty();
            this.writer.startGroup(key, Composer.Companion.getEmpty());
            enterGroup(i6, i);
        }
        if (reader.getGroupKey() == key && !reader.getHasObjectKey()) {
            if (!reader.getHasObjectKey()) {
                reader.startGroup();
                enterGroup(i6, i);
            }
        }
        if (!reader.isGroupEnd()) {
            recordDelete();
            this.changeListWriter.removeNode(this.nodeIndex, reader.skipGroup());
            ComposerKt.access$removeRange(this.invalidations, reader.getCurrentGroup(), reader.getCurrentGroup());
        }
        reader.beginEmpty();
        this.inserting = i4;
        this.providerCache = i;
        ensureWriter();
        androidx.compose.runtime.SlotWriter writer2 = this.writer;
        writer2.beginInsert();
        writer2.startGroup(key, Composer.Companion.getEmpty());
        this.insertAnchor = writer2.anchor(writer2.getCurrentGroup());
        enterGroup(i6, i);
    }

    @ComposeCompilerApi
    public void startReplaceableGroup(int key) {
        final int i = 0;
        start-BaiHCIY(key, i, GroupKind.Companion.getGroup-ULZAiWs(), i);
    }

    @ComposeCompilerApi
    public androidx.compose.runtime.Composer startRestartGroup(int key) {
        startReplaceGroup(key);
        addRecomposeScope();
        return (Composer)this;
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableGroup(int key, Object dataKey) {
        boolean reusingGroup;
        if (!getInserting() && this.reader.getGroupKey() == key && !Intrinsics.areEqual(this.reader.getGroupAux(), dataKey) && this.reusingGroup < 0) {
            if (this.reader.getGroupKey() == key) {
                if (!Intrinsics.areEqual(this.reader.getGroupAux(), dataKey)) {
                    if (this.reusingGroup < 0) {
                        this.reusingGroup = this.reader.getCurrentGroup();
                        this.reusing = true;
                    }
                }
            }
        }
        start-BaiHCIY(key, 0, GroupKind.Companion.getGroup-ULZAiWs(), dataKey);
    }

    @Override // androidx.compose.runtime.Composer
    public void startReusableNode() {
        final int i3 = 0;
        start-BaiHCIY(125, i3, GroupKind.Companion.getReusableNode-ULZAiWs(), i3);
        this.nodeExpected = true;
    }

    @Override // androidx.compose.runtime.Composer
    public final void startReuseFromRoot() {
        this.reusingGroup = 100;
        this.reusing = true;
    }

    @Override // androidx.compose.runtime.Composer
    public final boolean tryImminentInvalidation$runtime_release(androidx.compose.runtime.RecomposeScopeImpl scope, Object instance) {
        boolean currentGroup;
        final androidx.compose.runtime.Anchor anchor = scope.getAnchor();
        int i = 0;
        if (anchor == null) {
            return i;
        }
        final int indexFor = anchor.toIndexFor(this.reader.getTable$runtime_release());
        if (this.isComposing && indexFor >= this.reader.getCurrentGroup()) {
            if (indexFor >= this.reader.getCurrentGroup()) {
                ComposerKt.access$insertIfMissing(this.invalidations, indexFor, scope, instance);
                return 1;
            }
        }
        return i;
    }

    @Override // androidx.compose.runtime.Composer
    public final void updateCachedValue(Object value) {
        boolean changeListWriter;
        Object rememberObserverHolder;
        Object obj;
        androidx.compose.runtime.Anchor rememberObserverAnchor;
        if (value instanceof RememberObserver) {
            if (getInserting()) {
                this.changeListWriter.remember((RememberObserver)value);
            }
            this.abandonSet.add(value);
            rememberObserverHolder = new RememberObserverHolder((RememberObserver)value, rememberObserverAnchor());
        } else {
            rememberObserverHolder = value;
        }
        updateValue(rememberObserverHolder);
    }

    @Override // androidx.compose.runtime.Composer
    public void updateRememberedValue(Object value) {
        updateCachedValue(value);
    }

    @Override // androidx.compose.runtime.Composer
    public final void updateValue(Object value) {
        int changeListWriter;
        Object changeListWriter2;
        androidx.compose.runtime.Anchor anchor;
        int parent;
        if (getInserting()) {
            this.writer.update(value);
        } else {
            if (this.reader.getHadNext()) {
                groupSlotIndex--;
                if (this.changeListWriter.getPastParent()) {
                    this.changeListWriter.updateAnchoredValue(value, this.reader.anchor(this.reader.getParent()), changeListWriter);
                } else {
                    this.changeListWriter.updateValue(value, changeListWriter);
                }
            } else {
                this.changeListWriter.appendValue(this.reader.anchor(this.reader.getParent()), value);
            }
        }
    }

    @Override // androidx.compose.runtime.Composer
    public void useNode() {
        boolean changeListWriter;
        String str;
        validateNodeExpected();
        int i2 = 0;
        if (inserting ^= 1 == 0) {
            int i3 = 0;
            ComposerKt.composeImmediateRuntimeError("useNode() called while inserting");
        }
        Object node = getNode(this.reader);
        this.changeListWriter.moveDown(node);
        if (this.reusing && node instanceof ComposeNodeLifecycleCallback != null) {
            if (node instanceof ComposeNodeLifecycleCallback != null) {
                this.changeListWriter.useNode(node);
            }
        }
    }

    @Override // androidx.compose.runtime.Composer
    public final void verifyConsistent$runtime_release() {
        this.insertTable.verifyWellFormed();
    }
}
