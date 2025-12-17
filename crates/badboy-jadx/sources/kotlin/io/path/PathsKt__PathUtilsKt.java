package kotlin.io.path;

import java.io.Closeable;
import java.io.IOException;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000Ì\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010 \n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0011\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0001H\u0087\u0008\u001a*\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00012\u0012\u0010\u0019\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00010\u001a\"\u00020\u0001H\u0087\u0008¢\u0006\u0002\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u00022\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030 0\u001a\"\u0006\u0012\u0002\u0008\u00030 H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\u001c\u001a\u00020\u00022\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030 0\u001a\"\u0006\u0012\u0002\u0008\u00030 H\u0087\u0008¢\u0006\u0002\u0010\"\u001aK\u0010#\u001a\u00020\u00022\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030 0\u001a\"\u0006\u0012\u0002\u0008\u00030 H\u0007¢\u0006\u0002\u0010%\u001aB\u0010#\u001a\u00020\u00022\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\u0008\u0002\u0010$\u001a\u0004\u0018\u00010\u00012\u001a\u0010\u001f\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030 0\u001a\"\u0006\u0012\u0002\u0008\u00030 H\u0087\u0008¢\u0006\u0002\u0010&\u001a\u001c\u0010'\u001a\u00020(2\u0006\u0010\u0017\u001a\u00020\u00022\n\u0010)\u001a\u0006\u0012\u0002\u0008\u00030*H\u0001\u001a4\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00020,2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\u00081H\u0007\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\r\u00102\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\r\u00103\u001a\u00020\u0001*\u00020\u0002H\u0087\u0008\u001a.\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002070\u001a\"\u000207H\u0087\u0008¢\u0006\u0002\u00108\u001a\u001f\u00104\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0008\u0008\u0002\u00109\u001a\u00020:H\u0087\u0008\u001a.\u0010;\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030 0\u001a\"\u0006\u0012\u0002\u0008\u00030 H\u0087\u0008¢\u0006\u0002\u0010<\u001a.\u0010=\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030 0\u001a\"\u0006\u0012\u0002\u0008\u00030 H\u0087\u0008¢\u0006\u0002\u0010<\u001a.\u0010>\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030 0\u001a\"\u0006\u0012\u0002\u0008\u00030 H\u0087\u0008¢\u0006\u0002\u0010<\u001a\u0015\u0010?\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u0002H\u0087\u0008\u001a-\u0010@\u001a\u00020\u0002*\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030 0\u001a\"\u0006\u0012\u0002\u0008\u00030 H\u0007¢\u0006\u0002\u0010<\u001a6\u0010A\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u001a\u0010\u001f\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030 0\u001a\"\u0006\u0012\u0002\u0008\u00030 H\u0087\u0008¢\u0006\u0002\u0010B\u001a\r\u0010C\u001a\u000200*\u00020\u0002H\u0087\u0008\u001a\r\u0010D\u001a\u00020:*\u00020\u0002H\u0087\u0008\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0087\n\u001a\u0015\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001H\u0087\n\u001a&\u0010G\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010I\u001a2\u0010J\u001a\u0002HK\"\n\u0008\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010M\u001a4\u0010N\u001a\u0004\u0018\u0001HK\"\n\u0008\u0000\u0010K\u0018\u0001*\u00020L*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010M\u001a\r\u0010O\u001a\u00020P*\u00020\u0002H\u0087\u0008\u001a\r\u0010Q\u001a\u00020R*\u00020\u0002H\u0087\u0008\u001a.\u0010S\u001a\u000200*\u00020\u00022\u0008\u0008\u0002\u0010T\u001a\u00020\u00012\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002000.H\u0087\u0008ø\u0001\u0000\u001a0\u0010V\u001a\u0004\u0018\u00010W*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010Y\u001a&\u0010Z\u001a\u00020[*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010\\\u001a(\u0010]\u001a\u0004\u0018\u00010^*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010_\u001a,\u0010`\u001a\u0008\u0012\u0004\u0012\u00020b0a*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010c\u001a&\u0010d\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010I\u001a\r\u0010e\u001a\u00020:*\u00020\u0002H\u0087\u0008\u001a\r\u0010f\u001a\u00020:*\u00020\u0002H\u0087\u0008\u001a\r\u0010g\u001a\u00020:*\u00020\u0002H\u0087\u0008\u001a&\u0010h\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010I\u001a\u0015\u0010i\u001a\u00020:*\u00020\u00022\u0006\u0010F\u001a\u00020\u0002H\u0087\u0008\u001a\r\u0010j\u001a\u00020:*\u00020\u0002H\u0087\u0008\u001a\r\u0010k\u001a\u00020:*\u00020\u0002H\u0087\u0008\u001a\u001c\u0010l\u001a\u0008\u0012\u0004\u0012\u00020\u00020m*\u00020\u00022\u0008\u0008\u0002\u0010T\u001a\u00020\u0001H\u0007\u001a.\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002070\u001a\"\u000207H\u0087\u0008¢\u0006\u0002\u00108\u001a\u001f\u0010n\u001a\u00020\u0002*\u00020\u00022\u0006\u00105\u001a\u00020\u00022\u0008\u0008\u0002\u00109\u001a\u00020:H\u0087\u0008\u001a&\u0010o\u001a\u00020:*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010I\u001a2\u0010p\u001a\u0002Hq\"\n\u0008\u0000\u0010q\u0018\u0001*\u00020r*\u00020\u00022\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010s\u001a<\u0010p\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010W0t*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00012\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010u\u001a\r\u0010v\u001a\u00020\u0002*\u00020\u0002H\u0087\u0008\u001a\u0014\u0010w\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0016\u0010x\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a\u0014\u0010y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0007\u001a8\u0010z\u001a\u00020\u0002*\u00020\u00022\u0006\u0010X\u001a\u00020\u00012\u0008\u0010{\u001a\u0004\u0018\u00010W2\u0012\u00106\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020H0\u001a\"\u00020HH\u0087\u0008¢\u0006\u0002\u0010|\u001a\u0015\u0010}\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020[H\u0087\u0008\u001a\u0015\u0010~\u001a\u00020\u0002*\u00020\u00022\u0006\u0010{\u001a\u00020^H\u0087\u0008\u001a\u001b\u0010\u007f\u001a\u00020\u0002*\u00020\u00022\u000c\u0010{\u001a\u0008\u0012\u0004\u0012\u00020b0aH\u0087\u0008\u001a\u000f\u0010\u0080\u0001\u001a\u00020\u0002*\u00030\u0081\u0001H\u0087\u0008\u001aF\u0010\u0082\u0001\u001a\u0003H\u0083\u0001\"\u0005\u0008\u0000\u0010\u0083\u0001*\u00020\u00022\u0008\u0008\u0002\u0010T\u001a\u00020\u00012\u001b\u0010\u0084\u0001\u001a\u0016\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00020\u0085\u0001\u0012\u0005\u0012\u0003H\u0083\u00010.H\u0087\u0008ø\u0001\u0000¢\u0006\u0003\u0010\u0086\u0001\u001a3\u0010\u0087\u0001\u001a\u000200*\u00020\u00022\r\u0010\u0088\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00020,2\n\u0008\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\u0008\u0002\u0010\u008b\u0001\u001a\u00020:H\u0007\u001aJ\u0010\u0087\u0001\u001a\u000200*\u00020\u00022\n\u0008\u0002\u0010\u0089\u0001\u001a\u00030\u008a\u00012\t\u0008\u0002\u0010\u008b\u0001\u001a\u00020:2\u0017\u0010-\u001a\u0013\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u0002000.¢\u0006\u0002\u00081H\u0007\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0003 \u0001\u001a0\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0085\u0001*\u00020\u00022\u0014\u00106\u001a\u000b\u0012\u0007\u0008\u0001\u0012\u00030\u008d\u00010\u001a\"\u00030\u008d\u0001H\u0007¢\u0006\u0003\u0010\u008e\u0001\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\u0004\u001a\u0004\u0008\t\u0010\u0006\"\u001e\u0010\n\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u000b\u0010\u0004\u001a\u0004\u0008\u000c\u0010\u0006\"\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u0004\u001a\u0004\u0008\u000f\u0010\u0006\"\u001e\u0010\u0010\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0011\u0010\u0004\u001a\u0004\u0008\u0012\u0010\u0006\"\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0014\u0010\u0004\u001a\u0004\u0008\u0015\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u008f\u0001", d2 = {"extension", "", "Ljava/nio/file/Path;", "getExtension$annotations", "(Ljava/nio/file/Path;)V", "getExtension", "(Ljava/nio/file/Path;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath$annotations", "getInvariantSeparatorsPath", "invariantSeparatorsPathString", "getInvariantSeparatorsPathString$annotations", "getInvariantSeparatorsPathString", "name", "getName$annotations", "getName", "nameWithoutExtension", "getNameWithoutExtension$annotations", "getNameWithoutExtension", "pathString", "getPathString$annotations", "getPathString", "Path", "path", "base", "subpaths", "", "(Ljava/lang/String;[Ljava/lang/String;)Ljava/nio/file/Path;", "createTempDirectory", "directory", "prefix", "attributes", "Ljava/nio/file/attribute/FileAttribute;", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createTempFile", "suffix", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "(Ljava/lang/String;Ljava/lang/String;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "fileAttributeViewNotAvailable", "", "attributeViewClass", "Ljava/lang/Class;", "fileVisitor", "Ljava/nio/file/FileVisitor;", "builderAction", "Lkotlin/Function1;", "Lkotlin/io/path/FileVisitorBuilder;", "", "Lkotlin/ExtensionFunctionType;", "absolute", "absolutePathString", "copyTo", "target", "options", "Ljava/nio/file/CopyOption;", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/CopyOption;)Ljava/nio/file/Path;", "overwrite", "", "createDirectories", "(Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "createDirectory", "createFile", "createLinkPointingTo", "createParentDirectories", "createSymbolicLinkPointingTo", "(Ljava/nio/file/Path;Ljava/nio/file/Path;[Ljava/nio/file/attribute/FileAttribute;)Ljava/nio/file/Path;", "deleteExisting", "deleteIfExists", "div", "other", "exists", "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "fileAttributesView", "V", "Ljava/nio/file/attribute/FileAttributeView;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileAttributeView;", "fileAttributesViewOrNull", "fileSize", "", "fileStore", "Ljava/nio/file/FileStore;", "forEachDirectoryEntry", "glob", "action", "getAttribute", "", "attribute", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "getLastModifiedTime", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/FileTime;", "getOwner", "Ljava/nio/file/attribute/UserPrincipal;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/UserPrincipal;", "getPosixFilePermissions", "", "Ljava/nio/file/attribute/PosixFilePermission;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/util/Set;", "isDirectory", "isExecutable", "isHidden", "isReadable", "isRegularFile", "isSameFileAs", "isSymbolicLink", "isWritable", "listDirectoryEntries", "", "moveTo", "notExists", "readAttributes", "A", "Ljava/nio/file/attribute/BasicFileAttributes;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/nio/file/attribute/BasicFileAttributes;", "", "(Ljava/nio/file/Path;Ljava/lang/String;[Ljava/nio/file/LinkOption;)Ljava/util/Map;", "readSymbolicLink", "relativeTo", "relativeToOrNull", "relativeToOrSelf", "setAttribute", "value", "(Ljava/nio/file/Path;Ljava/lang/String;Ljava/lang/Object;[Ljava/nio/file/LinkOption;)Ljava/nio/file/Path;", "setLastModifiedTime", "setOwner", "setPosixFilePermissions", "toPath", "Ljava/net/URI;", "useDirectoryEntries", "T", "block", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "visitFileTree", "visitor", "maxDepth", "", "followLinks", "walk", "Lkotlin/io/path/PathWalkOption;", "(Ljava/nio/file/Path;[Lkotlin/io/path/PathWalkOption;)Lkotlin/sequences/Sequence;", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathUtilsKt extends kotlin.io.path.PathsKt__PathRecursiveFunctionsKt {
    private static final Path Path(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        Path path2 = Paths.get(path, new String[0]);
        Intrinsics.checkNotNullExpressionValue(path2, "get(...)");
        return path2;
    }

    private static final Path Path(String base, String... subpaths) {
        Intrinsics.checkNotNullParameter(base, "base");
        Intrinsics.checkNotNullParameter(subpaths, "subpaths");
        Path path = Paths.get(base, (String[])Arrays.copyOf(subpaths, subpaths.length));
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    private static final Path absolute(Path $this$absolute) {
        Intrinsics.checkNotNullParameter($this$absolute, "<this>");
        Path absolutePath = $this$absolute.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "toAbsolutePath(...)");
        return absolutePath;
    }

    private static final String absolutePathString(Path $this$absolutePathString) {
        Intrinsics.checkNotNullParameter($this$absolutePathString, "<this>");
        return $this$absolutePathString.toAbsolutePath().toString();
    }

    private static final Path copyTo(Path $this$copyTo, Path target, boolean overwrite) throws IOException {
        CopyOption[] arr;
        StandardCopyOption rEPLACE_EXISTING;
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        int i = 0;
        if (overwrite) {
            new CopyOption[1][i] = StandardCopyOption.REPLACE_EXISTING;
        } else {
            arr = new CopyOption[i];
        }
        Path copy = Files.copy($this$copyTo, target, (CopyOption[])Arrays.copyOf(arr, arr.length));
        Intrinsics.checkNotNullExpressionValue(copy, "copy(...)");
        return copy;
    }

    private static final Path copyTo(Path $this$copyTo, Path target, CopyOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(options, "options");
        Path copy = Files.copy($this$copyTo, target, (CopyOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(copy, "copy(...)");
        return copy;
    }

    static Path copyTo$default(Path $this$copyTo_u24default, Path target, boolean overwrite, int i4, Object object5) throws IOException {
        StandardCopyOption rEPLACE_EXISTING;
        int obj3;
        CopyOption[] obj5;
        if (i4 &= 2 != 0) {
            obj3 = 0;
        }
        Intrinsics.checkNotNullParameter($this$copyTo_u24default, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        int obj4 = 0;
        if (obj3 != null) {
            new CopyOption[1][obj4] = StandardCopyOption.REPLACE_EXISTING;
        } else {
            obj5 = new CopyOption[obj4];
        }
        obj4 = Files.copy($this$copyTo_u24default, target, (CopyOption[])Arrays.copyOf(obj5, obj5.length));
        Intrinsics.checkNotNullExpressionValue(obj4, "copy(...)");
        return obj4;
    }

    private static final Path createDirectories(Path $this$createDirectories, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter($this$createDirectories, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path directories = Files.createDirectories($this$createDirectories, (FileAttribute[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(directories, "createDirectories(...)");
        return directories;
    }

    private static final Path createDirectory(Path $this$createDirectory, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter($this$createDirectory, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path directory = Files.createDirectory($this$createDirectory, (FileAttribute[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(directory, "createDirectory(...)");
        return directory;
    }

    private static final Path createFile(Path $this$createFile, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter($this$createFile, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path file = Files.createFile($this$createFile, (FileAttribute[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(file, "createFile(...)");
        return file;
    }

    private static final Path createLinkPointingTo(Path $this$createLinkPointingTo, Path target) throws IOException {
        Intrinsics.checkNotNullParameter($this$createLinkPointingTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Path link = Files.createLink($this$createLinkPointingTo, target);
        Intrinsics.checkNotNullExpressionValue(link, "createLink(...)");
        return link;
    }

    public static final Path createParentDirectories(Path $this$createParentDirectories, FileAttribute<?>... attributes) throws IOException {
        int directory;
        Throwable directories;
        LinkOption[] arr;
        Intrinsics.checkNotNullParameter($this$createParentDirectories, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        final int i = 0;
        final Path parent = $this$createParentDirectories.getParent();
        directory = 0;
        if (parent != null && Files.isDirectory(parent, (LinkOption[])Arrays.copyOf(new LinkOption[directory], directory)) == null) {
            directory = 0;
            if (Files.isDirectory(parent, (LinkOption[])Arrays.copyOf(new LinkOption[directory], directory)) == null) {
                Object[] copyOf2 = Arrays.copyOf(attributes, attributes.length);
                Intrinsics.checkNotNullExpressionValue(Files.createDirectories(parent, (FileAttribute[])Arrays.copyOf((FileAttribute[])copyOf2, copyOf2.length)), "createDirectories(...)");
            }
        }
        return $this$createParentDirectories;
    }

    private static final Path createSymbolicLinkPointingTo(Path $this$createSymbolicLinkPointingTo, Path target, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter($this$createSymbolicLinkPointingTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path symbolicLink = Files.createSymbolicLink($this$createSymbolicLinkPointingTo, target, (FileAttribute[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(symbolicLink, "createSymbolicLink(...)");
        return symbolicLink;
    }

    private static final Path createTempDirectory(String prefix, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path tempDirectory = Files.createTempDirectory(prefix, (FileAttribute[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(tempDirectory, "createTempDirectory(...)");
        return tempDirectory;
    }

    public static final Path createTempDirectory(Path directory, String prefix, FileAttribute<?>... attributes) throws IOException {
        Path tempDirectory;
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        String str2 = "createTempDirectory(...)";
        if (directory != null) {
            Intrinsics.checkNotNullExpressionValue(Files.createTempDirectory(directory, prefix, (FileAttribute[])Arrays.copyOf(attributes, attributes.length)), str2);
        } else {
            Intrinsics.checkNotNullExpressionValue(Files.createTempDirectory(prefix, (FileAttribute[])Arrays.copyOf(attributes, attributes.length)), str2);
        }
        return tempDirectory;
    }

    static Path createTempDirectory$default(String prefix, FileAttribute[] attributes, int i3, Object object4) throws IOException {
        int obj0;
        if (i3 &= 1 != 0) {
            obj0 = 0;
        }
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path obj2 = Files.createTempDirectory(obj0, (FileAttribute[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(obj2, "createTempDirectory(...)");
        return obj2;
    }

    public static Path createTempDirectory$default(Path path, String string2, FileAttribute[] fileAttribute3Arr3, int i4, Object object5) throws IOException {
        int obj1;
        if (i4 &= 2 != 0) {
            obj1 = 0;
        }
        return PathsKt.createTempDirectory(path, obj1, fileAttribute3Arr3);
    }

    private static final Path createTempFile(String prefix, String suffix, FileAttribute<?>... attributes) throws IOException {
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path tempFile = Files.createTempFile(prefix, suffix, (FileAttribute[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(tempFile, "createTempFile(...)");
        return tempFile;
    }

    public static final Path createTempFile(Path directory, String prefix, String suffix, FileAttribute<?>... attributes) throws IOException {
        Path tempFile;
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        String str2 = "createTempFile(...)";
        if (directory != null) {
            Intrinsics.checkNotNullExpressionValue(Files.createTempFile(directory, prefix, suffix, (FileAttribute[])Arrays.copyOf(attributes, attributes.length)), str2);
        } else {
            Intrinsics.checkNotNullExpressionValue(Files.createTempFile(prefix, suffix, (FileAttribute[])Arrays.copyOf(attributes, attributes.length)), str2);
        }
        return tempFile;
    }

    static Path createTempFile$default(String prefix, String suffix, FileAttribute[] attributes, int i4, Object object5) throws IOException {
        int obj0;
        int obj1;
        if (i4 & 1 != 0) {
            obj0 = 0;
        }
        if (i4 &= 2 != 0) {
            obj1 = 0;
        }
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Path obj3 = Files.createTempFile(obj0, obj1, (FileAttribute[])Arrays.copyOf(attributes, attributes.length));
        Intrinsics.checkNotNullExpressionValue(obj3, "createTempFile(...)");
        return obj3;
    }

    public static Path createTempFile$default(Path path, String string2, String string3, FileAttribute[] fileAttribute4Arr4, int i5, Object object6) throws IOException {
        int obj2;
        int obj3;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj2 = i;
        }
        if (i5 &= 4 != 0) {
            obj3 = i;
        }
        return PathsKt.createTempFile(path, obj2, obj3, fileAttribute4Arr4);
    }

    private static final void deleteExisting(Path $this$deleteExisting) throws IOException {
        Intrinsics.checkNotNullParameter($this$deleteExisting, "<this>");
        Files.delete($this$deleteExisting);
    }

    private static final boolean deleteIfExists(Path $this$deleteIfExists) throws IOException {
        Intrinsics.checkNotNullParameter($this$deleteIfExists, "<this>");
        return Files.deleteIfExists($this$deleteIfExists);
    }

    private static final Path div(Path $this$div, String other) {
        Intrinsics.checkNotNullParameter($this$div, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Path resolve = $this$div.resolve(other);
        Intrinsics.checkNotNullExpressionValue(resolve, "resolve(...)");
        return resolve;
    }

    private static final Path div(Path $this$div, Path other) {
        Intrinsics.checkNotNullParameter($this$div, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Path resolve = $this$div.resolve(other);
        Intrinsics.checkNotNullExpressionValue(resolve, "resolve(...)");
        return resolve;
    }

    private static final boolean exists(Path $this$exists, LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$exists, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.exists($this$exists, (LinkOption[])Arrays.copyOf(options, options.length));
    }

    public static final Void fileAttributeViewNotAvailable(Path path, Class<?> attributeViewClass) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(attributeViewClass, "attributeViewClass");
        StringBuilder stringBuilder = new StringBuilder();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException(stringBuilder.append("The desired attribute view type ").append(attributeViewClass).append(" is not available for the file ").append(path).append('.').toString());
        throw unsupportedOperationException;
    }

    private static final <V extends java.nio.file.attribute.FileAttributeView> V fileAttributesView(Path $this$fileAttributesView, LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$fileAttributesView, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        int i = 4;
        String str3 = "V";
        Intrinsics.reifiedOperationMarker(i, str3);
        Class<java.nio.file.attribute.FileAttributeView> obj3 = FileAttributeView.class;
        Class<java.nio.file.attribute.FileAttributeView> obj4 = obj3;
        java.nio.file.attribute.FileAttributeView fileAttributeView = Files.getFileAttributeView($this$fileAttributesView, obj3, (LinkOption[])Arrays.copyOf(options, options.length));
        if (fileAttributeView == null) {
        } else {
            java.nio.file.attribute.FileAttributeView view = fileAttributeView;
            return fileAttributeView;
        }
        Intrinsics.reifiedOperationMarker(i, str3);
        Class<java.nio.file.attribute.FileAttributeView> obj = FileAttributeView.class;
        Class<java.nio.file.attribute.FileAttributeView> obj2 = obj;
        PathsKt.fileAttributeViewNotAvailable($this$fileAttributesView, obj);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private static final <V extends java.nio.file.attribute.FileAttributeView> V fileAttributesViewOrNull(Path $this$fileAttributesViewOrNull, LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$fileAttributesViewOrNull, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        Class<java.nio.file.attribute.FileAttributeView> obj = FileAttributeView.class;
        Class<java.nio.file.attribute.FileAttributeView> obj2 = obj;
        return Files.getFileAttributeView($this$fileAttributesViewOrNull, obj, (LinkOption[])Arrays.copyOf(options, options.length));
    }

    private static final long fileSize(Path $this$fileSize) throws IOException {
        Intrinsics.checkNotNullParameter($this$fileSize, "<this>");
        return Files.size($this$fileSize);
    }

    private static final FileStore fileStore(Path $this$fileStore) throws IOException {
        Intrinsics.checkNotNullParameter($this$fileStore, "<this>");
        FileStore fileStore = Files.getFileStore($this$fileStore);
        Intrinsics.checkNotNullExpressionValue(fileStore, "getFileStore(...)");
        return fileStore;
    }

    public static final FileVisitor<Path> fileVisitor(Function1<? super kotlin.io.path.FileVisitorBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        FileVisitorBuilderImpl fileVisitorBuilderImpl = new FileVisitorBuilderImpl();
        builderAction.invoke(fileVisitorBuilderImpl);
        return fileVisitorBuilderImpl.build();
    }

    private static final void forEachDirectoryEntry(Path $this$forEachDirectoryEntry, String glob, Function1<? super Path, Unit> action) throws IOException {
        boolean apiVersionIsAtLeast;
        Object next;
        Intrinsics.checkNotNullParameter($this$forEachDirectoryEntry, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        Intrinsics.checkNotNullParameter(action, "action");
        java.nio.file.DirectoryStream directoryStream = Files.newDirectoryStream($this$forEachDirectoryEntry, glob);
        final int i2 = 1;
        java.nio.file.DirectoryStream stream = directoryStream;
        final int i3 = 0;
        Intrinsics.checkNotNull((DirectoryStream)stream);
        final int i4 = 0;
        final Iterator iterator = (Iterable)stream.iterator();
        for (Object next : iterator) {
            action.invoke(next);
        }
        Unit it = Unit.INSTANCE;
        if (PlatformImplementationsKt.apiVersionIsAtLeast(i2, i2, 0)) {
            CloseableKt.closeFinally((Closeable)directoryStream, 0);
        } else {
            if (directoryStream != null) {
                directoryStream.close();
            }
        }
    }

    static void forEachDirectoryEntry$default(Path $this$forEachDirectoryEntry_u24default, String glob, Function1 action, int i4, Object object5) throws IOException {
        Object next;
        String obj8;
        boolean obj11;
        obj11 = 1;
        if (i4 &= obj11 != 0) {
            obj8 = "*";
        }
        Intrinsics.checkNotNullParameter($this$forEachDirectoryEntry_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj8, "glob");
        Intrinsics.checkNotNullParameter(action, "action");
        java.nio.file.DirectoryStream obj10 = Files.newDirectoryStream($this$forEachDirectoryEntry_u24default, obj8);
        java.nio.file.DirectoryStream stream = obj10;
        final int i2 = 0;
        Intrinsics.checkNotNull((DirectoryStream)stream);
        final int i3 = 0;
        final Iterator iterator = (Iterable)stream.iterator();
        for (Object next : iterator) {
            action.invoke(next);
        }
        Unit it = Unit.INSTANCE;
        if (PlatformImplementationsKt.apiVersionIsAtLeast(obj11, obj11, 0)) {
            CloseableKt.closeFinally((Closeable)obj10, 0);
        } else {
            if (obj10 != null) {
                obj10.close();
            }
        }
    }

    private static final Object getAttribute(Path $this$getAttribute, String attribute, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getAttribute, "<this>");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.getAttribute($this$getAttribute, attribute, (LinkOption[])Arrays.copyOf(options, options.length));
    }

    public static final String getExtension(Path $this$extension) {
        Object substringAfterLast;
        String str;
        int i;
        Intrinsics.checkNotNullParameter($this$extension, "<this>");
        substringAfterLast = $this$extension.getFileName();
        substringAfterLast = substringAfterLast.toString();
        if (substringAfterLast != null && substringAfterLast != null) {
            substringAfterLast = substringAfterLast.toString();
            if (substringAfterLast != null) {
                substringAfterLast = StringsKt.substringAfterLast(substringAfterLast, '.', "");
                if (substringAfterLast == null) {
                } else {
                    str = substringAfterLast;
                }
            }
        }
        return str;
    }

    public static void getExtension$annotations(Path path) {
    }

    private static final String getInvariantSeparatorsPath(Path $this$invariantSeparatorsPath) {
        Intrinsics.checkNotNullParameter($this$invariantSeparatorsPath, "<this>");
        return PathsKt.getInvariantSeparatorsPathString($this$invariantSeparatorsPath);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(...))
    public static void getInvariantSeparatorsPath$annotations(Path path) {
    }

    public static final String getInvariantSeparatorsPathString(Path $this$invariantSeparatorsPathString) {
        String replace$default;
        String string;
        String str;
        int i3;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$invariantSeparatorsPathString, "<this>");
        final String separator = $this$invariantSeparatorsPathString.getFileSystem().getSeparator();
        if (!Intrinsics.areEqual(separator, "/")) {
            Intrinsics.checkNotNull(separator);
            replace$default = StringsKt.replace$default($this$invariantSeparatorsPathString.toString(), separator, "/", false, 4, 0);
        } else {
            replace$default = $this$invariantSeparatorsPathString.toString();
        }
        return replace$default;
    }

    public static void getInvariantSeparatorsPathString$annotations(Path path) {
    }

    private static final FileTime getLastModifiedTime(Path $this$getLastModifiedTime, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getLastModifiedTime, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        FileTime lastModifiedTime = Files.getLastModifiedTime($this$getLastModifiedTime, (LinkOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "getLastModifiedTime(...)");
        return lastModifiedTime;
    }

    public static final String getName(Path $this$name) {
        String string;
        Intrinsics.checkNotNullParameter($this$name, "<this>");
        Path fileName = $this$name.getFileName();
        if (fileName != null) {
            string = fileName.toString();
        } else {
            string = 0;
        }
        if (string == null) {
            string = "";
        }
        return string;
    }

    public static void getName$annotations(Path path) {
    }

    public static final String getNameWithoutExtension(Path $this$nameWithoutExtension) {
        Object substringBeforeLast$default;
        String str;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter($this$nameWithoutExtension, "<this>");
        substringBeforeLast$default = $this$nameWithoutExtension.getFileName();
        substringBeforeLast$default = substringBeforeLast$default.toString();
        if (substringBeforeLast$default != null && substringBeforeLast$default != null) {
            substringBeforeLast$default = substringBeforeLast$default.toString();
            if (substringBeforeLast$default != null) {
                i = 0;
                if (StringsKt.substringBeforeLast$default(substringBeforeLast$default, ".", i, 2, i) == null) {
                    substringBeforeLast$default = "";
                }
            } else {
            }
        } else {
        }
        return substringBeforeLast$default;
    }

    public static void getNameWithoutExtension$annotations(Path path) {
    }

    private static final UserPrincipal getOwner(Path $this$getOwner, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getOwner, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.getOwner($this$getOwner, (LinkOption[])Arrays.copyOf(options, options.length));
    }

    private static final String getPathString(Path $this$pathString) {
        Intrinsics.checkNotNullParameter($this$pathString, "<this>");
        return $this$pathString.toString();
    }

    public static void getPathString$annotations(Path path) {
    }

    private static final Set<PosixFilePermission> getPosixFilePermissions(Path $this$getPosixFilePermissions, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$getPosixFilePermissions, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Set posixFilePermissions = Files.getPosixFilePermissions($this$getPosixFilePermissions, (LinkOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, "getPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    private static final boolean isDirectory(Path $this$isDirectory, LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$isDirectory, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.isDirectory($this$isDirectory, (LinkOption[])Arrays.copyOf(options, options.length));
    }

    private static final boolean isExecutable(Path $this$isExecutable) {
        Intrinsics.checkNotNullParameter($this$isExecutable, "<this>");
        return Files.isExecutable($this$isExecutable);
    }

    private static final boolean isHidden(Path $this$isHidden) throws IOException {
        Intrinsics.checkNotNullParameter($this$isHidden, "<this>");
        return Files.isHidden($this$isHidden);
    }

    private static final boolean isReadable(Path $this$isReadable) {
        Intrinsics.checkNotNullParameter($this$isReadable, "<this>");
        return Files.isReadable($this$isReadable);
    }

    private static final boolean isRegularFile(Path $this$isRegularFile, LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$isRegularFile, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.isRegularFile($this$isRegularFile, (LinkOption[])Arrays.copyOf(options, options.length));
    }

    private static final boolean isSameFileAs(Path $this$isSameFileAs, Path other) throws IOException {
        Intrinsics.checkNotNullParameter($this$isSameFileAs, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Files.isSameFile($this$isSameFileAs, other);
    }

    private static final boolean isSymbolicLink(Path $this$isSymbolicLink) {
        Intrinsics.checkNotNullParameter($this$isSymbolicLink, "<this>");
        return Files.isSymbolicLink($this$isSymbolicLink);
    }

    private static final boolean isWritable(Path $this$isWritable) {
        Intrinsics.checkNotNullParameter($this$isWritable, "<this>");
        return Files.isWritable($this$isWritable);
    }

    public static final List<Path> listDirectoryEntries(Path $this$listDirectoryEntries, String glob) throws IOException {
        Intrinsics.checkNotNullParameter($this$listDirectoryEntries, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        java.nio.file.DirectoryStream directoryStream = Files.newDirectoryStream($this$listDirectoryEntries, glob);
        java.nio.file.DirectoryStream stream = directoryStream;
        final int i = 0;
        Intrinsics.checkNotNull((DirectoryStream)stream);
        CloseableKt.closeFinally((Closeable)directoryStream, 0);
        return CollectionsKt.toList((Iterable)stream);
    }

    public static List listDirectoryEntries$default(Path path, String string2, int i3, Object object4) throws IOException {
        String obj1;
        if (i3 &= 1 != 0) {
            obj1 = "*";
        }
        return PathsKt.listDirectoryEntries(path, obj1);
    }

    private static final Path moveTo(Path $this$moveTo, Path target, boolean overwrite) throws IOException {
        CopyOption[] arr;
        StandardCopyOption rEPLACE_EXISTING;
        Intrinsics.checkNotNullParameter($this$moveTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        int i = 0;
        if (overwrite) {
            new CopyOption[1][i] = StandardCopyOption.REPLACE_EXISTING;
        } else {
            arr = new CopyOption[i];
        }
        Path move = Files.move($this$moveTo, target, (CopyOption[])Arrays.copyOf(arr, arr.length));
        Intrinsics.checkNotNullExpressionValue(move, "move(...)");
        return move;
    }

    private static final Path moveTo(Path $this$moveTo, Path target, CopyOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$moveTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(options, "options");
        Path move = Files.move($this$moveTo, target, (CopyOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(move, "move(...)");
        return move;
    }

    static Path moveTo$default(Path $this$moveTo_u24default, Path target, boolean overwrite, int i4, Object object5) throws IOException {
        StandardCopyOption rEPLACE_EXISTING;
        int obj3;
        CopyOption[] obj5;
        if (i4 &= 2 != 0) {
            obj3 = 0;
        }
        Intrinsics.checkNotNullParameter($this$moveTo_u24default, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        int obj4 = 0;
        if (obj3 != null) {
            new CopyOption[1][obj4] = StandardCopyOption.REPLACE_EXISTING;
        } else {
            obj5 = new CopyOption[obj4];
        }
        obj4 = Files.move($this$moveTo_u24default, target, (CopyOption[])Arrays.copyOf(obj5, obj5.length));
        Intrinsics.checkNotNullExpressionValue(obj4, "move(...)");
        return obj4;
    }

    private static final boolean notExists(Path $this$notExists, LinkOption... options) {
        Intrinsics.checkNotNullParameter($this$notExists, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        return Files.notExists($this$notExists, (LinkOption[])Arrays.copyOf(options, options.length));
    }

    private static final <A extends java.nio.file.attribute.BasicFileAttributes> A readAttributes(Path $this$readAttributes, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$readAttributes, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.reifiedOperationMarker(4, "A");
        Class<java.nio.file.attribute.BasicFileAttributes> obj = BasicFileAttributes.class;
        Class<java.nio.file.attribute.BasicFileAttributes> obj2 = obj;
        java.nio.file.attribute.BasicFileAttributes attributes = Files.readAttributes($this$readAttributes, obj, (LinkOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(attributes, "readAttributes(...)");
        java.nio.file.attribute.BasicFileAttributes basicFileAttributes = attributes;
        return attributes;
    }

    private static final Map<String, Object> readAttributes(Path $this$readAttributes, String attributes, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$readAttributes, "<this>");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(options, "options");
        Map attributes2 = Files.readAttributes($this$readAttributes, attributes, (LinkOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(attributes2, "readAttributes(...)");
        return attributes2;
    }

    private static final Path readSymbolicLink(Path $this$readSymbolicLink) throws IOException {
        Intrinsics.checkNotNullParameter($this$readSymbolicLink, "<this>");
        Path symbolicLink = Files.readSymbolicLink($this$readSymbolicLink);
        Intrinsics.checkNotNullExpressionValue(symbolicLink, "readSymbolicLink(...)");
        return symbolicLink;
    }

    public static final Path relativeTo(Path $this$relativeTo, Path base) {
        Intrinsics.checkNotNullParameter($this$relativeTo, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        return PathRelativizer.INSTANCE.tryRelativeTo($this$relativeTo, base);
    }

    public static final Path relativeToOrNull(Path $this$relativeToOrNull, Path base) {
        Path tryRelativeTo;
        int i;
        Intrinsics.checkNotNullParameter($this$relativeToOrNull, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        tryRelativeTo = PathRelativizer.INSTANCE.tryRelativeTo($this$relativeToOrNull, base);
        return tryRelativeTo;
    }

    public static final Path relativeToOrSelf(Path $this$relativeToOrSelf, Path base) {
        Object relativeToOrNull;
        Intrinsics.checkNotNullParameter($this$relativeToOrSelf, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        if (PathsKt.relativeToOrNull($this$relativeToOrSelf, base) == null) {
            relativeToOrNull = $this$relativeToOrSelf;
        }
        return relativeToOrNull;
    }

    private static final Path setAttribute(Path $this$setAttribute, String attribute, Object value, LinkOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$setAttribute, "<this>");
        Intrinsics.checkNotNullParameter(attribute, "attribute");
        Intrinsics.checkNotNullParameter(options, "options");
        Path attribute2 = Files.setAttribute($this$setAttribute, attribute, value, (LinkOption[])Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(attribute2, "setAttribute(...)");
        return attribute2;
    }

    private static final Path setLastModifiedTime(Path $this$setLastModifiedTime, FileTime value) throws IOException {
        Intrinsics.checkNotNullParameter($this$setLastModifiedTime, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Path lastModifiedTime = Files.setLastModifiedTime($this$setLastModifiedTime, value);
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "setLastModifiedTime(...)");
        return lastModifiedTime;
    }

    private static final Path setOwner(Path $this$setOwner, UserPrincipal value) throws IOException {
        Intrinsics.checkNotNullParameter($this$setOwner, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Path owner = Files.setOwner($this$setOwner, value);
        Intrinsics.checkNotNullExpressionValue(owner, "setOwner(...)");
        return owner;
    }

    private static final Path setPosixFilePermissions(Path $this$setPosixFilePermissions, Set<? extends PosixFilePermission> value) throws IOException {
        Intrinsics.checkNotNullParameter($this$setPosixFilePermissions, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Path posixFilePermissions = Files.setPosixFilePermissions($this$setPosixFilePermissions, value);
        Intrinsics.checkNotNullExpressionValue(posixFilePermissions, "setPosixFilePermissions(...)");
        return posixFilePermissions;
    }

    private static final Path toPath(URI $this$toPath) {
        Intrinsics.checkNotNullParameter($this$toPath, "<this>");
        Path path = Paths.get($this$toPath);
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    private static final <T> T useDirectoryEntries(Path $this$useDirectoryEntries, String glob, Function1<? super Sequence<? extends Path>, ? extends T> block) throws IOException {
        int apiVersionIsAtLeast;
        Intrinsics.checkNotNullParameter($this$useDirectoryEntries, "<this>");
        Intrinsics.checkNotNullParameter(glob, "glob");
        Intrinsics.checkNotNullParameter(block, "block");
        java.nio.file.DirectoryStream directoryStream = Files.newDirectoryStream($this$useDirectoryEntries, glob);
        final int i2 = 1;
        final java.nio.file.DirectoryStream stream = directoryStream;
        final int i3 = 0;
        Intrinsics.checkNotNull((DirectoryStream)stream);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(i2, i2, 0)) {
            CloseableKt.closeFinally((Closeable)directoryStream, 0);
        } else {
            if (directoryStream != null) {
                directoryStream.close();
            }
        }
        return block.invoke(CollectionsKt.asSequence((Iterable)stream));
    }

    static Object useDirectoryEntries$default(Path $this$useDirectoryEntries_u24default, String glob, Function1 block, int i4, Object object5) throws IOException {
        String obj5;
        int obj8;
        obj8 = 1;
        if (i4 &= obj8 != 0) {
            obj5 = "*";
        }
        Intrinsics.checkNotNullParameter($this$useDirectoryEntries_u24default, "<this>");
        Intrinsics.checkNotNullParameter(obj5, "glob");
        Intrinsics.checkNotNullParameter(block, "block");
        java.nio.file.DirectoryStream obj7 = Files.newDirectoryStream($this$useDirectoryEntries_u24default, obj5);
        final java.nio.file.DirectoryStream stream = obj7;
        final int i2 = 0;
        Intrinsics.checkNotNull((DirectoryStream)stream);
        if (PlatformImplementationsKt.apiVersionIsAtLeast(obj8, obj8, 0)) {
            CloseableKt.closeFinally((Closeable)obj7, 0);
        } else {
            if (obj7 != null) {
                obj7.close();
            }
        }
        return block.invoke(CollectionsKt.asSequence((Iterable)stream));
    }

    public static final void visitFileTree(Path $this$visitFileTree, int maxDepth, boolean followLinks, Function1<? super kotlin.io.path.FileVisitorBuilder, Unit> builderAction) {
        Intrinsics.checkNotNullParameter($this$visitFileTree, "<this>");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        PathsKt.visitFileTree($this$visitFileTree, PathsKt.fileVisitor(builderAction), maxDepth, followLinks);
    }

    public static final void visitFileTree(Path $this$visitFileTree, FileVisitor<Path> visitor, int maxDepth, boolean followLinks) {
        Set emptySet;
        Intrinsics.checkNotNullParameter($this$visitFileTree, "<this>");
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        if (followLinks) {
            emptySet = SetsKt.setOf(FileVisitOption.FOLLOW_LINKS);
        } else {
            emptySet = SetsKt.emptySet();
        }
        Files.walkFileTree($this$visitFileTree, emptySet, maxDepth, visitor);
    }

    public static void visitFileTree$default(Path path, int i2, boolean z3, Function1 function14, int i5, Object object6) {
        int obj1;
        int obj2;
        if (i5 & 1 != 0) {
            obj1 = Integer.MAX_VALUE;
        }
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        PathsKt.visitFileTree(path, obj1, obj2, function14);
    }

    public static void visitFileTree$default(Path path, FileVisitor fileVisitor2, int i3, boolean z4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = Integer.MAX_VALUE;
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        PathsKt.visitFileTree(path, fileVisitor2, obj2, obj3);
    }

    public static final Sequence<Path> walk(Path $this$walk, kotlin.io.path.PathWalkOption... options) {
        Intrinsics.checkNotNullParameter($this$walk, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        PathTreeWalk pathTreeWalk = new PathTreeWalk($this$walk, options);
        return (Sequence)pathTreeWalk;
    }
}
