package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.io.b;
import kotlin.k0.h;
import kotlin.k0.l;
import kotlin.w;
import l.b0;
import l.d0;
import l.g;
import l.h;
import l.q;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010)\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008*\u0001f\u0018\u0000 m2\u00020\u00012\u00020\u0002:\u0004mnopB9\u0008\u0000\u0012\u0006\u0010=\u001a\u00020<\u0012\u0006\u0010\\\u001a\u00020I\u0012\u0006\u0010N\u001a\u00020D\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010V\u001a\u00020\u001b\u0012\u0006\u0010j\u001a\u00020i¢\u0006\u0004\u0008k\u0010lJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\r\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\r\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\u0008\u0012\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u0014\u0010\u000cJ\r\u0010\u0015\u001a\u00020\u0003¢\u0006\u0004\u0008\u0015\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0003H\u0000¢\u0006\u0004\u0008\u0016\u0010\u0005J\u001e\u0010\u0019\u001a\u0008\u0018\u00010\u0018R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\u0008\u0019\u0010\u001aJ'\u0010\u001e\u001a\u0008\u0018\u00010\u001dR\u00020\u00002\u0006\u0010\u0013\u001a\u00020\t2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001bH\u0007¢\u0006\u0004\u0008\u001e\u0010\u001fJ\r\u0010 \u001a\u00020\u001b¢\u0006\u0004\u0008 \u0010!J#\u0010&\u001a\u00020\u00032\n\u0010\"\u001a\u00060\u001dR\u00020\u00002\u0006\u0010#\u001a\u00020\u000eH\u0000¢\u0006\u0004\u0008$\u0010%J\u0015\u0010'\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\u0008'\u0010(J\u001b\u0010-\u001a\u00020\u000e2\n\u0010*\u001a\u00060)R\u00020\u0000H\u0000¢\u0006\u0004\u0008+\u0010,J\u000f\u0010.\u001a\u00020\u0003H\u0016¢\u0006\u0004\u0008.\u0010\u0005J\r\u0010/\u001a\u00020\u000e¢\u0006\u0004\u0008/\u0010\u0010J\u000f\u00100\u001a\u00020\u0003H\u0016¢\u0006\u0004\u00080\u0010\u0005J\r\u00101\u001a\u00020\u0003¢\u0006\u0004\u00081\u0010\u0005J\r\u00102\u001a\u00020\u0003¢\u0006\u0004\u00082\u0010\u0005J\r\u00103\u001a\u00020\u0003¢\u0006\u0004\u00083\u0010\u0005J\u0017\u00105\u001a\u000c\u0012\u0008\u0012\u00060\u0018R\u00020\u000004¢\u0006\u0004\u00085\u00106R\"\u00107\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u00087\u00108\u001a\u0004\u00089\u0010\u0010\"\u0004\u0008:\u0010;R\u001c\u0010=\u001a\u00020<8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008=\u0010>\u001a\u0004\u0008?\u0010@R\u0018\u0010A\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008A\u0010BR\u0016\u0010C\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008C\u00108R\u001c\u0010E\u001a\u00020D8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008E\u0010F\u001a\u0004\u0008G\u0010HR\u0016\u0010J\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008J\u0010KR\u0016\u0010L\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008L\u00108R\u0016\u0010M\u001a\u00020D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008M\u0010FR\u0016\u0010N\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008N\u0010FR\u0016\u0010O\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008O\u00108R\u0016\u0010P\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008P\u00108R\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008R\u0010SR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008 \u0010TR*\u0010V\u001a\u00020\u001b2\u0006\u0010U\u001a\u00020\u001b8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\u0008V\u0010T\u001a\u0004\u0008W\u0010!\"\u0004\u0008X\u0010YR\u0016\u0010Z\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008Z\u00108R\u0016\u0010[\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008[\u0010TR\u0019\u0010\\\u001a\u00020I8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\\\u0010K\u001a\u0004\u0008]\u0010^R,\u0010`\u001a\u0012\u0012\u0004\u0012\u00020\t\u0012\u0008\u0012\u00060)R\u00020\u00000_8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008`\u0010a\u001a\u0004\u0008b\u0010cR\u0016\u0010d\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008d\u0010KR\u0016\u0010e\u001a\u00020I8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008e\u0010KR\u0016\u0010g\u001a\u00020f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008g\u0010h¨\u0006q", d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "Lkotlin/w;", "readJournal", "()V", "Ll/g;", "newJournalWriter", "()Ll/g;", "", "line", "readJournalLine", "(Ljava/lang/String;)V", "processJournal", "", "journalRebuildRequired", "()Z", "checkNotClosed", "removeOldestEntry", "key", "validateKey", "initialize", "rebuildJournal$okhttp", "rebuildJournal", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "get", "(Ljava/lang/String;)Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "", "expectedSequenceNumber", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "edit", "(Ljava/lang/String;J)Lokhttp3/internal/cache/DiskLruCache$Editor;", "size", "()J", "editor", "success", "completeEdit$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;Z)V", "completeEdit", "remove", "(Ljava/lang/String;)Z", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "entry", "removeEntry$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Entry;)Z", "removeEntry", "flush", "isClosed", "close", "trimToSize", "delete", "evictAll", "", "snapshots", "()Ljava/util/Iterator;", "closed", "Z", "getClosed$okhttp", "setClosed$okhttp", "(Z)V", "Lokhttp3/internal/io/FileSystem;", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "journalWriter", "Ll/g;", "mostRecentTrimFailed", "", "valueCount", "I", "getValueCount$okhttp", "()I", "Ljava/io/File;", "journalFileTmp", "Ljava/io/File;", "hasJournalErrors", "redundantOpCount", "appVersion", "civilizedFileSystem", "initialized", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "J", "value", "maxSize", "getMaxSize", "setMaxSize", "(J)V", "mostRecentRebuildFailed", "nextSequenceNumber", "directory", "getDirectory", "()Ljava/io/File;", "Ljava/util/LinkedHashMap;", "lruEntries", "Ljava/util/LinkedHashMap;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "journalFile", "journalFileBackup", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "cleanupTask", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "Companion", "Editor", "Entry", "Snapshot", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class DiskLruCache implements Closeable, Flushable {

    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final String CLEAN;
    public static final okhttp3.internal.cache.DiskLruCache.Companion Companion;
    public static final String DIRTY;
    public static final String JOURNAL_FILE;
    public static final String JOURNAL_FILE_BACKUP;
    public static final String JOURNAL_FILE_TEMP;
    public static final h LEGAL_KEY_PATTERN;
    public static final String MAGIC;
    public static final String READ;
    public static final String REMOVE;
    public static final String VERSION_1;
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final okhttp3.internal.cache.DiskLruCache.cleanupTask.1 cleanupTask;
    private boolean closed;
    private final File directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private g journalWriter;
    private final LinkedHashMap<String, okhttp3.internal.cache.DiskLruCache.Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0008\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\u0008\u0008\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\u0008\t\u0010\u0007R\u0016\u0010\n\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\u0008\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0007R\u0016\u0010\r\u001a\u00020\u000c8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0007R\u0016\u0010\u0011\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0007R\u0016\u0010\u0012\u001a\u00020\u00058\u0006@\u0007X\u0087D¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0007¨\u0006\u0015", d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "", "ANY_SEQUENCE_NUMBER", "J", "", "CLEAN", "Ljava/lang/String;", "DIRTY", "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "Lkotlin/k0/h;", "LEGAL_KEY_PATTERN", "Lkotlin/k0/h;", "MAGIC", "READ", "REMOVE", "VERSION_1", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0018\n\u0002\u0008\u0007\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0015\u0008\u0000\u0012\n\u0010\u0015\u001a\u00060\u0013R\u00020\u0014¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0000¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0017\u0010\t\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\t\u0010\nJ\u0015\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u000c\u0010\rJ\r\u0010\u000e\u001a\u00020\u0002¢\u0006\u0004\u0008\u000e\u0010\u0004J\r\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\u0008\u000f\u0010\u0004R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0012R \u0010\u0015\u001a\u00060\u0013R\u00020\u00148\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u001a\u0010\u001b\u001a\u0004\u0008\u001c\u0010\u001d¨\u0006 ", d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "Lkotlin/w;", "detach$okhttp", "()V", "detach", "", "index", "Ll/d0;", "newSource", "(I)Ll/d0;", "Ll/b0;", "newSink", "(I)Ll/b0;", "commit", "abort", "", "done", "Z", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "written", "[Z", "getWritten$okhttp", "()[Z", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class Editor {

        private boolean done;
        private final okhttp3.internal.cache.DiskLruCache.Entry entry;
        final okhttp3.internal.cache.DiskLruCache this$0;
        private final boolean[] written;
        public Editor(okhttp3.internal.cache.DiskLruCache diskLruCache, okhttp3.internal.cache.DiskLruCache.Entry diskLruCache$Entry2) {
            int obj2;
            n.f(entry2, "entry");
            this.this$0 = diskLruCache;
            super();
            this.entry = entry2;
            if (entry2.getReadable$okhttp()) {
                obj2 = 0;
            } else {
                obj2 = new boolean[diskLruCache.getValueCount$okhttp()];
            }
            this.written = obj2;
        }

        public final void abort() {
            boolean this$0;
            int i;
            final okhttp3.internal.cache.DiskLruCache this$02 = this.this$0;
            int i3 = 1;
            synchronized (this$02) {
                if (n.b(this.entry.getCurrentEditor$okhttp(), this)) {
                    this.this$0.completeEdit$okhttp(this, false);
                }
                try {
                    this.done = i3;
                    w wVar = w.a;
                    IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                    throw illegalStateException;
                    throw th;
                }
            }
        }

        public final void commit() {
            boolean this$0;
            final okhttp3.internal.cache.DiskLruCache this$02 = this.this$0;
            int i2 = 1;
            synchronized (this$02) {
                if (n.b(this.entry.getCurrentEditor$okhttp(), this)) {
                    this.this$0.completeEdit$okhttp(this, i2);
                }
                try {
                    this.done = i2;
                    w wVar = w.a;
                    IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                    throw illegalStateException;
                    throw th;
                }
            }
        }

        public final void detach$okhttp() {
            boolean entry;
            int i;
            if (n.b(this.entry.getCurrentEditor$okhttp(), this)) {
                if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) != null) {
                    this.this$0.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        public final okhttp3.internal.cache.DiskLruCache.Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final b0 newSink(int i) {
            boolean readable$okhttp;
            final okhttp3.internal.cache.DiskLruCache this$0 = this.this$0;
            int i4 = 1;
            synchronized (this$0) {
                if (z ^= i4 != 0) {
                    return q.b();
                }
                try {
                    if (!this.entry.getReadable$okhttp()) {
                    }
                    readable$okhttp = this.written;
                    n.d(readable$okhttp);
                    readable$okhttp[i] = i4;
                    DiskLruCache.Editor.newSink$$inlined.synchronized.lambda.1 anon = new DiskLruCache.Editor.newSink$$inlined.synchronized.lambda.1(this, i);
                    FaultHidingSink faultHidingSink = new FaultHidingSink(this.this$0.getFileSystem$okhttp().sink((File)this.entry.getDirtyFiles$okhttp().get(i)), anon);
                    return faultHidingSink;
                    i = q.b();
                    return i;
                    IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                    throw illegalStateException;
                    throw i;
                } catch (java.io.FileNotFoundException fileNotFound) {
                } catch (Throwable th1) {
                }
            }
        }

        public final d0 newSource(int i) {
            boolean readable$okhttp;
            final okhttp3.internal.cache.DiskLruCache this$0 = this.this$0;
            synchronized (this$0) {
                if (this.entry.getReadable$okhttp() && z ^= 1 == 0 && this.entry.getZombie$okhttp()) {
                    if (z ^= 1 == 0) {
                        try {
                            if (this.entry.getZombie$okhttp()) {
                            }
                            return this.this$0.getFileSystem$okhttp().source((File)this.entry.getCleanFiles$okhttp().get(i));
                            return null;
                            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                            throw illegalStateException;
                            throw i;
                        } catch (java.io.FileNotFoundException fileNotFound) {
                        } catch (Throwable th1) {
                        }
                    }
                }
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0010\u0016\n\u0002\u0008\u0007\u0008\u0080\u0004\u0018\u00002\u00020\u0001B\u0011\u0008\u0000\u0012\u0006\u0010(\u001a\u00020\u0003¢\u0006\u0004\u0008J\u0010KJ\u001d\u0010\u0006\u001a\u00020\u00052\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u001d\u0010\u0010\u001a\u00020\r2\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0017\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0015\u0010\u001a\u001a\u0008\u0018\u00010\u0016R\u00020\u0017H\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!R\"\u0010$\u001a\u0008\u0012\u0004\u0012\u00020#0\"8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008$\u0010%\u001a\u0004\u0008&\u0010'R\u001c\u0010(\u001a\u00020\u00038\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008(\u0010)\u001a\u0004\u0008*\u0010+R(\u0010-\u001a\u0008\u0018\u00010,R\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008-\u0010.\u001a\u0004\u0008/\u00100\"\u0004\u00081\u00102R\"\u00103\u001a\u0008\u0012\u0004\u0012\u00020#0\"8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u00083\u0010%\u001a\u0004\u00084\u0010'R\"\u00105\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u00085\u0010\u001d\u001a\u0004\u00086\u0010\u001f\"\u0004\u00087\u0010!R\"\u00109\u001a\u0002088\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u00089\u0010:\u001a\u0004\u0008;\u0010<\"\u0004\u0008=\u0010>R\"\u0010?\u001a\u00020\u00088\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008?\u0010@\u001a\u0004\u0008A\u0010B\"\u0004\u0008C\u0010DR\u001c\u0010F\u001a\u00020E8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008F\u0010G\u001a\u0004\u0008H\u0010I¨\u0006L", d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", "", "", "strings", "", "invalidLengths", "(Ljava/util/List;)Ljava/lang/Void;", "", "index", "Ll/d0;", "newSource", "(I)Ll/d0;", "Lkotlin/w;", "setLengths$okhttp", "(Ljava/util/List;)V", "setLengths", "Ll/g;", "writer", "writeLengths$okhttp", "(Ll/g;)V", "writeLengths", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Lokhttp3/internal/cache/DiskLruCache;", "snapshot$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot", "", "readable", "Z", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "", "Ljava/io/File;", "dirtyFiles", "Ljava/util/List;", "getDirtyFiles$okhttp", "()Ljava/util/List;", "key", "Ljava/lang/String;", "getKey$okhttp", "()Ljava/lang/String;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "cleanFiles", "getCleanFiles$okhttp", "zombie", "getZombie$okhttp", "setZombie$okhttp", "", "sequenceNumber", "J", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "lockingSourceCount", "I", "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "", "lengths", "[J", "getLengths$okhttp", "()[J", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class Entry {

        private final List<File> cleanFiles;
        private okhttp3.internal.cache.DiskLruCache.Editor currentEditor;
        private final List<File> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final okhttp3.internal.cache.DiskLruCache this$0;
        private boolean zombie;
        public Entry(okhttp3.internal.cache.DiskLruCache diskLruCache, String string2) {
            int i;
            List dirtyFiles;
            File file;
            File directory;
            String string;
            n.f(string2, "key");
            this.this$0 = diskLruCache;
            super();
            this.key = string2;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            ArrayList arrayList = new ArrayList();
            this.cleanFiles = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.dirtyFiles = arrayList2;
            StringBuilder stringBuilder = new StringBuilder(string2);
            stringBuilder.append('.');
            i = 0;
            while (i < diskLruCache.getValueCount$okhttp()) {
                stringBuilder.append(i);
                File file2 = new File(diskLruCache.getDirectory(), stringBuilder.toString());
                this.cleanFiles.add(file2);
                stringBuilder.append(".tmp");
                file = new File(diskLruCache.getDirectory(), stringBuilder.toString());
                this.dirtyFiles.add(file);
                stringBuilder.setLength(stringBuilder.length());
                i++;
            }
        }

        private final Void invalidLengths(List<String> list) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected journal line: ");
            stringBuilder.append(list);
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }

        private final d0 newSource(int i) {
            d0 obj3 = this.this$0.getFileSystem$okhttp().source((File)this.cleanFiles.get(i));
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) != null) {
                return obj3;
            }
            this.lockingSourceCount = lockingSourceCount++;
            DiskLruCache.Entry.newSource.1 anon = new DiskLruCache.Entry.newSource.1(this, obj3, obj3);
            return anon;
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final okhttp3.internal.cache.DiskLruCache.Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(okhttp3.internal.cache.DiskLruCache.Editor diskLruCache$Editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> list) {
            int i;
            long[] lengths;
            long long;
            n.f(list, "strings");
            if (list.size() != this.this$0.getValueCount$okhttp()) {
            } else {
                i = 0;
                while (i < list.size()) {
                    this.lengths[i] = Long.parseLong((String)list.get(i));
                    i++;
                }
            }
            invalidLengths(list);
            KotlinNothingValueException obj6 = new KotlinNothingValueException();
            throw obj6;
        }

        public final void setLockingSourceCount$okhttp(int i) {
            this.lockingSourceCount = i;
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final void setSequenceNumber$okhttp(long l) {
            this.sequenceNumber = l;
        }

        public final void setZombie$okhttp(boolean z) {
            this.zombie = z;
        }

        public final okhttp3.internal.cache.DiskLruCache.Snapshot snapshot$okhttp() {
            okhttp3.internal.cache.DiskLruCache.Editor currentEditor;
            boolean assertionsEnabled;
            boolean next;
            int i;
            d0 source;
            okhttp3.internal.cache.DiskLruCache this$02 = this.this$0;
            if (Util.assertionsEnabled) {
                if (!Thread.holdsLock(this$02)) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                Thread currentThread = Thread.currentThread();
                n.e(currentThread, "Thread.currentThread()");
                stringBuilder.append(currentThread.getName());
                stringBuilder.append(" MUST hold lock on ");
                stringBuilder.append(this$02);
                AssertionError assertionError = new AssertionError(stringBuilder.toString());
                throw assertionError;
            }
            int i2 = 0;
            if (!this.readable) {
                return i2;
            }
            if (DiskLruCache.access$getCivilizedFileSystem$p(this.this$0) == null && this.currentEditor == null && this.zombie) {
                if (this.currentEditor == null) {
                    if (this.zombie) {
                    }
                }
                return i2;
            }
            ArrayList arrayList = new ArrayList();
            i = 0;
            while (i < this.this$0.getValueCount$okhttp()) {
                arrayList.add(newSource(i));
                i++;
            }
            super(this.this$0, this.key, this.sequenceNumber, obj6, arrayList, (long[])this.lengths.clone());
            return snapshot2;
        }

        public final void writeLengths$okhttp(g g) {
            int i;
            long l;
            g gVar;
            n.f(g, "writer");
            long[] lengths = this.lengths;
            i = 0;
            while (i < lengths.length) {
                g.c0(32).Y1(lengths[i]);
                i++;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0016\n\u0002\u0008\u0005\u0008\u0086\u0004\u0018\u00002\u00020\u0001B/\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\u0008\u001d\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0013\u0010\u0007\u001a\u0008\u0018\u00010\u0005R\u00020\u0006¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008\u000c\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0018R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u001c¨\u0006\u001f", d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", "", "key", "()Ljava/lang/String;", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "edit", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "index", "Ll/d0;", "getSource", "(I)Ll/d0;", "", "getLength", "(I)J", "Lkotlin/w;", "close", "()V", "sequenceNumber", "J", "", "sources", "Ljava/util/List;", "Ljava/lang/String;", "", "lengths", "[J", "<init>", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class Snapshot implements Closeable {

        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<d0> sources;
        final okhttp3.internal.cache.DiskLruCache this$0;
        public Snapshot(okhttp3.internal.cache.DiskLruCache diskLruCache, String string2, long l3, List list4, long[] l5Arr5) {
            n.f(string2, "key");
            n.f(l5Arr5, "sources");
            n.f(obj7, "lengths");
            this.this$0 = diskLruCache;
            super();
            this.key = string2;
            this.sequenceNumber = l3;
            this.sources = l5Arr5;
            this.lengths = obj7;
        }

        @Override // java.io.Closeable
        public void close() {
            Object next;
            Iterator iterator = this.sources.iterator();
            for (d0 next : iterator) {
                Util.closeQuietly(next);
            }
        }

        @Override // java.io.Closeable
        public final okhttp3.internal.cache.DiskLruCache.Editor edit() {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        @Override // java.io.Closeable
        public final long getLength(int i) {
            return this.lengths[i];
        }

        @Override // java.io.Closeable
        public final d0 getSource(int i) {
            return (d0)this.sources.get(i);
        }

        @Override // java.io.Closeable
        public final String key() {
            return this.key;
        }
    }
    static {
        DiskLruCache.Companion companion = new DiskLruCache.Companion(0);
        DiskLruCache.Companion = companion;
        DiskLruCache.JOURNAL_FILE = "journal";
        DiskLruCache.JOURNAL_FILE_TEMP = "journal.tmp";
        DiskLruCache.JOURNAL_FILE_BACKUP = "journal.bkp";
        DiskLruCache.MAGIC = "libcore.io.DiskLruCache";
        DiskLruCache.VERSION_1 = "1";
        int i = -1;
        h hVar = new h("[a-z0-9_-]{1,120}");
        DiskLruCache.LEGAL_KEY_PATTERN = hVar;
        DiskLruCache.CLEAN = "CLEAN";
        DiskLruCache.DIRTY = "DIRTY";
        DiskLruCache.REMOVE = "REMOVE";
        DiskLruCache.READ = "READ";
    }

    public DiskLruCache(FileSystem fileSystem, File file2, int i3, int i4, long l5, TaskRunner taskRunner6) {
        int obj5;
        int obj7;
        n.f(fileSystem, "fileSystem");
        n.f(file2, "directory");
        n.f(obj11, "taskRunner");
        super();
        this.fileSystem = fileSystem;
        this.directory = file2;
        this.appVersion = i3;
        this.valueCount = i4;
        this.maxSize = l5;
        obj7 = 0;
        final int i2 = 1;
        obj5 = new LinkedHashMap(obj7, 1061158912, i2);
        this.lruEntries = obj5;
        this.cleanupQueue = obj11.newQueue();
        StringBuilder obj11 = new StringBuilder();
        obj11.append(Util.okHttpName);
        obj11.append(" Cache");
        obj5 = new DiskLruCache.cleanupTask.1(this, obj11.toString());
        this.cleanupTask = obj5;
        obj5 = Long.compare(l5, i5) > 0 ? i2 : obj7;
        if (obj5 == null) {
        } else {
            obj7 = i4 > 0 ? i2 : obj7;
            if (obj7 == null) {
            } else {
                obj5 = new File(file2, DiskLruCache.JOURNAL_FILE);
                this.journalFile = obj5;
                obj5 = new File(file2, DiskLruCache.JOURNAL_FILE_TEMP);
                this.journalFileTmp = obj5;
                obj5 = new File(file2, DiskLruCache.JOURNAL_FILE_BACKUP);
                this.journalFileBackup = obj5;
            }
            obj5 = new IllegalArgumentException("valueCount <= 0".toString());
            throw obj5;
        }
        obj5 = new IllegalArgumentException("maxSize <= 0".toString());
        throw obj5;
    }

    public static final boolean access$getCivilizedFileSystem$p(okhttp3.internal.cache.DiskLruCache diskLruCache) {
        return diskLruCache.civilizedFileSystem;
    }

    public static final boolean access$getHasJournalErrors$p(okhttp3.internal.cache.DiskLruCache diskLruCache) {
        return diskLruCache.hasJournalErrors;
    }

    public static final boolean access$getInitialized$p(okhttp3.internal.cache.DiskLruCache diskLruCache) {
        return diskLruCache.initialized;
    }

    public static final g access$getJournalWriter$p(okhttp3.internal.cache.DiskLruCache diskLruCache) {
        return diskLruCache.journalWriter;
    }

    public static final boolean access$getMostRecentRebuildFailed$p(okhttp3.internal.cache.DiskLruCache diskLruCache) {
        return diskLruCache.mostRecentRebuildFailed;
    }

    public static final boolean access$getMostRecentTrimFailed$p(okhttp3.internal.cache.DiskLruCache diskLruCache) {
        return diskLruCache.mostRecentTrimFailed;
    }

    public static final int access$getRedundantOpCount$p(okhttp3.internal.cache.DiskLruCache diskLruCache) {
        return diskLruCache.redundantOpCount;
    }

    public static final boolean access$journalRebuildRequired(okhttp3.internal.cache.DiskLruCache diskLruCache) {
        return diskLruCache.journalRebuildRequired();
    }

    public static final void access$setCivilizedFileSystem$p(okhttp3.internal.cache.DiskLruCache diskLruCache, boolean z2) {
        diskLruCache.civilizedFileSystem = z2;
    }

    public static final void access$setHasJournalErrors$p(okhttp3.internal.cache.DiskLruCache diskLruCache, boolean z2) {
        diskLruCache.hasJournalErrors = z2;
    }

    public static final void access$setInitialized$p(okhttp3.internal.cache.DiskLruCache diskLruCache, boolean z2) {
        diskLruCache.initialized = z2;
    }

    public static final void access$setJournalWriter$p(okhttp3.internal.cache.DiskLruCache diskLruCache, g g2) {
        diskLruCache.journalWriter = g2;
    }

    public static final void access$setMostRecentRebuildFailed$p(okhttp3.internal.cache.DiskLruCache diskLruCache, boolean z2) {
        diskLruCache.mostRecentRebuildFailed = z2;
    }

    public static final void access$setMostRecentTrimFailed$p(okhttp3.internal.cache.DiskLruCache diskLruCache, boolean z2) {
        diskLruCache.mostRecentTrimFailed = z2;
    }

    public static final void access$setRedundantOpCount$p(okhttp3.internal.cache.DiskLruCache diskLruCache, int i2) {
        diskLruCache.redundantOpCount = i2;
    }

    private final void checkNotClosed() {
        synchronized (this) {
            try {
                IllegalStateException illegalStateException = new IllegalStateException("cache is closed".toString());
                throw illegalStateException;
            }
        }
    }

    public static okhttp3.internal.cache.DiskLruCache.Editor edit$default(okhttp3.internal.cache.DiskLruCache diskLruCache, String string2, long l3, int i4, Object object5) {
        long obj2;
        if (object5 &= 2 != 0) {
            obj2 = DiskLruCache.ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(string2, obj2);
    }

    private final boolean journalRebuildRequired() {
        int i;
        int size;
        int redundantOpCount = this.redundantOpCount;
        if (redundantOpCount >= 2000 && redundantOpCount >= this.lruEntries.size()) {
            i = redundantOpCount >= this.lruEntries.size() ? 1 : 0;
        } else {
        }
        return i;
    }

    private final g newJournalWriter() {
        DiskLruCache.newJournalWriter.faultHidingSink.1 anon = new DiskLruCache.newJournalWriter.faultHidingSink.1(this);
        FaultHidingSink faultHidingSink = new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), anon);
        return q.c(faultHidingSink);
    }

    private final void processJournal() {
        File journalFileTmp;
        int valueCount;
        int i;
        int fileSystem;
        Object obj;
        long[] lengths$okhttp;
        long l;
        this.fileSystem.delete(this.journalFileTmp);
        Iterator iterator = this.lruEntries.values().iterator();
        while (iterator.hasNext()) {
            journalFileTmp = iterator.next();
            n.e(journalFileTmp, "i.next()");
            i = 0;
            if ((DiskLruCache.Entry)journalFileTmp.getCurrentEditor$okhttp() == null) {
            } else {
            }
            journalFileTmp.setCurrentEditor$okhttp(0);
            while (i < this.valueCount) {
                this.fileSystem.delete((File)journalFileTmp.getCleanFiles$okhttp().get(i));
                this.fileSystem.delete((File)journalFileTmp.getDirtyFiles$okhttp().get(i));
                i++;
            }
            iterator.remove();
            this.fileSystem.delete((File)journalFileTmp.getCleanFiles$okhttp().get(i));
            this.fileSystem.delete((File)journalFileTmp.getDirtyFiles$okhttp().get(i));
            i++;
            while (i < this.valueCount) {
                this.size = size += l;
                i++;
            }
            this.size = size += l;
            i++;
        }
    }

    private final void readJournal() {
        String str;
        String length;
        int valueOf;
        int i;
        str = ", ";
        h hVar = q.d(this.fileSystem.source(this.journalFile));
        String str2 = hVar.m1();
        final String str3 = hVar.m1();
        final String str4 = hVar.m1();
        final String str5 = hVar.m1();
        i = 1;
        if (z3 ^= i != 0) {
        } else {
            if (z4 ^= i != 0) {
            } else {
                if (z ^= i != 0) {
                } else {
                    if (z2 ^= i != 0) {
                    } else {
                        if (str5.length() > 0) {
                        } else {
                            i = valueOf;
                        }
                        if (i != 0) {
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("unexpected journal header: [");
        stringBuilder.append(str2);
        stringBuilder.append(str);
        stringBuilder.append(str3);
        stringBuilder.append(str);
        stringBuilder.append(str4);
        stringBuilder.append(str);
        stringBuilder.append(str5);
        stringBuilder.append(']');
        IOException iOException = new IOException(stringBuilder.toString());
        throw iOException;
    }

    private final void readJournalLine(String string) {
        int rEAD;
        String dIRTY;
        String length;
        int i;
        String cLEAN;
        String rEMOVE;
        Object entry;
        int lruEntries;
        char[] cArr;
        int i5;
        int i4;
        int i2;
        int i3;
        final Object obj = this;
        final Object obj2 = string;
        final int i20 = l.d0(string, ' ', 0, false, 6, 0);
        final String str = "unexpected journal line: ";
        final int i21 = -1;
        if (i20 == i21) {
        } else {
            int i22 = i20 + 1;
            rEAD = l.d0(string, ' ', i22, false, 4, 0);
            dIRTY = "(this as java.lang.String).substring(startIndex)";
            length = "null cannot be cast to non-null type java.lang.String";
            i = 2;
            int i16 = 0;
            int i19 = 0;
            if (rEAD == i21) {
                Objects.requireNonNull(obj2, length);
                cLEAN = obj2.substring(i22);
                n.e(cLEAN, dIRTY);
                rEMOVE = DiskLruCache.REMOVE;
                if (i20 == rEMOVE.length() && l.M(obj2, rEMOVE, i19, i, i16)) {
                    if (l.M(obj2, rEMOVE, i19, i, i16)) {
                        obj.lruEntries.remove(cLEAN);
                    }
                }
            } else {
                Objects.requireNonNull(obj2, length);
                n.e(obj2.substring(i22, rEAD), "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            if ((DiskLruCache.Entry)obj.lruEntries.get(cLEAN) == null) {
                entry = new DiskLruCache.Entry(obj, cLEAN);
                obj.lruEntries.put(cLEAN, entry);
            }
            cLEAN = DiskLruCache.CLEAN;
            if (rEAD != i21 && i20 == cLEAN.length() && l.M(obj2, cLEAN, i19, i, i16)) {
                cLEAN = DiskLruCache.CLEAN;
                if (i20 == cLEAN.length()) {
                    if (l.M(obj2, cLEAN, i19, i, i16)) {
                        i = 1;
                        Objects.requireNonNull(obj2, length);
                        lruEntries = obj2.substring(rEAD += i);
                        n.e(lruEntries, dIRTY);
                        cArr = new char[i];
                        cArr[i19] = 32;
                        entry.setReadable$okhttp(i);
                        entry.setCurrentEditor$okhttp(i16);
                        entry.setLengths$okhttp(l.D0(lruEntries, cArr, false, 0, 6, 0));
                    } else {
                        dIRTY = DiskLruCache.DIRTY;
                        if (rEAD == i21 && i20 == dIRTY.length() && l.M(obj2, dIRTY, i19, i, i16)) {
                            dIRTY = DiskLruCache.DIRTY;
                            if (i20 == dIRTY.length()) {
                                if (l.M(obj2, dIRTY, i19, i, i16)) {
                                    rEAD = new DiskLruCache.Editor(obj, entry);
                                    entry.setCurrentEditor$okhttp(rEAD);
                                } else {
                                    if (rEAD != i21) {
                                    } else {
                                        rEAD = DiskLruCache.READ;
                                        if (i20 != rEAD.length()) {
                                        } else {
                                            if (!l.M(obj2, rEAD, i19, i, i16)) {
                                            } else {
                                            }
                                        }
                                    }
                                }
                            } else {
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(obj2);
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(obj2);
        IOException iOException2 = new IOException(stringBuilder2.toString());
        throw iOException2;
    }

    private final boolean removeOldestEntry() {
        Object next;
        boolean zombie$okhttp;
        Iterator iterator = this.lruEntries.values().iterator();
        for (DiskLruCache.Entry next : iterator) {
        }
        return 0;
    }

    private final void validateKey(String string) {
        if (!DiskLruCache.LEGAL_KEY_PATTERN.d(string)) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
        stringBuilder.append(string);
        stringBuilder.append('"');
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
        throw illegalArgumentException;
    }

    @Override // java.io.Closeable
    public void close() {
        boolean initialized;
        int i;
        Object currentEditor$okhttp;
        okhttp3.internal.cache.DiskLruCache.Editor currentEditor$okhttp2;
        int i3 = 1;
        synchronized (this) {
            try {
                if (this.closed) {
                } else {
                }
                Collection values = this.lruEntries.values();
                n.e(values, "lruEntries.values");
                Object[] array = values.toArray(new DiskLruCache.Entry[0]);
                if (array == null) {
                } else {
                }
                while (i < array.length) {
                    currentEditor$okhttp = (DiskLruCache.Entry[])array[i];
                    currentEditor$okhttp = currentEditor$okhttp.getCurrentEditor$okhttp();
                    if (currentEditor$okhttp.getCurrentEditor$okhttp() != null && currentEditor$okhttp != null) {
                    }
                    i++;
                    currentEditor$okhttp = currentEditor$okhttp.getCurrentEditor$okhttp();
                    if (currentEditor$okhttp != null) {
                    }
                    currentEditor$okhttp.detach$okhttp();
                }
                currentEditor$okhttp = array[i];
                currentEditor$okhttp = currentEditor$okhttp.getCurrentEditor$okhttp();
                if (currentEditor$okhttp.getCurrentEditor$okhttp() != null && currentEditor$okhttp != null) {
                }
                currentEditor$okhttp = currentEditor$okhttp.getCurrentEditor$okhttp();
                if (currentEditor$okhttp != null) {
                }
                currentEditor$okhttp.detach$okhttp();
                i++;
                trimToSize();
                g journalWriter = this.journalWriter;
                n.d(journalWriter);
                journalWriter.close();
                this.journalWriter = 0;
                this.closed = i3;
                NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                throw nullPointerException;
                this.closed = i3;
                throw th;
            }
        }
    }

    @Override // java.io.Closeable
    public final void completeEdit$okhttp(okhttp3.internal.cache.DiskLruCache.Editor diskLruCache$Editor, boolean z2) {
        TaskQueue cleanupQueue;
        int i;
        String nextSequenceNumber;
        boolean readable$okhttp;
        int readable$okhttp2;
        int fileSystem;
        int i3;
        boolean exists;
        int i2;
        Object obj;
        int i4;
        int obj9;
        String obj10;
        n.f(editor, "editor");
        okhttp3.internal.cache.DiskLruCache.Entry entry$okhttp = editor.getEntry$okhttp();
        synchronized (this) {
            try {
                if (z2 != null && !entry$okhttp.getReadable$okhttp()) {
                }
                if (!entry$okhttp.getReadable$okhttp()) {
                }
                fileSystem = i;
                while (fileSystem < this.valueCount) {
                    boolean[] written$okhttp = editor.getWritten$okhttp();
                    n.d(written$okhttp);
                    fileSystem++;
                }
                written$okhttp = editor.getWritten$okhttp();
                n.d(written$okhttp);
                if (written$okhttp[fileSystem] == null) {
                } else {
                }
                if (this.fileSystem.exists((File)entry$okhttp.getDirtyFiles$okhttp().get(fileSystem)) == null) {
                } else {
                }
                editor.abort();
                fileSystem++;
                editor.abort();
                obj10 = new StringBuilder();
                obj10.append("Newly created entry didn't create value for index ");
                obj10.append(fileSystem);
                obj9 = new IllegalStateException(obj10.toString());
                throw obj9;
                while (i < this.valueCount) {
                    readable$okhttp = entry$okhttp.getDirtyFiles$okhttp().get(i);
                    if (z2 != null && !entry$okhttp.getZombie$okhttp()) {
                    } else {
                    }
                    this.fileSystem.delete((File)readable$okhttp);
                    i++;
                    if (!entry$okhttp.getZombie$okhttp()) {
                    } else {
                    }
                    if (this.fileSystem.exists(readable$okhttp) != null) {
                    }
                    fileSystem = entry$okhttp.getCleanFiles$okhttp().get(i);
                    this.fileSystem.rename(readable$okhttp, (File)fileSystem);
                    readable$okhttp = this.fileSystem.size(fileSystem);
                    entry$okhttp.getLengths$okhttp()[i] = readable$okhttp;
                    this.size = i7 += readable$okhttp;
                }
                readable$okhttp = entry$okhttp.getDirtyFiles$okhttp().get(i);
                if (z2 != null && !entry$okhttp.getZombie$okhttp()) {
                } else {
                }
                if (!entry$okhttp.getZombie$okhttp()) {
                } else {
                }
                if (this.fileSystem.exists((File)readable$okhttp) != null) {
                }
                fileSystem = entry$okhttp.getCleanFiles$okhttp().get(i);
                this.fileSystem.rename(readable$okhttp, (File)fileSystem);
                readable$okhttp = this.fileSystem.size(fileSystem);
                entry$okhttp.getLengths$okhttp()[i] = readable$okhttp;
                this.size = i7 += readable$okhttp;
                this.fileSystem.delete(readable$okhttp);
                i++;
                entry$okhttp.setCurrentEditor$okhttp(0);
                if (entry$okhttp.getZombie$okhttp()) {
                }
                removeEntry$okhttp(entry$okhttp);
                int i5 = 1;
                this.redundantOpCount = obj9 += i5;
                obj9 = this.journalWriter;
                n.d(obj9);
                readable$okhttp2 = entry$okhttp.getReadable$okhttp();
                i3 = 10;
                i2 = 32;
                if (!readable$okhttp2) {
                } else {
                }
                if (z2 != null) {
                } else {
                }
                this.lruEntries.remove(entry$okhttp.getKey$okhttp());
                obj9.E0(DiskLruCache.REMOVE).c0(i2);
                obj9.E0(entry$okhttp.getKey$okhttp());
                obj9.c0(i3);
                entry$okhttp.setReadable$okhttp(i5);
                obj9.E0(DiskLruCache.CLEAN).c0(i2);
                obj9.E0(entry$okhttp.getKey$okhttp());
                entry$okhttp.writeLengths$okhttp(obj9);
                obj9.c0(i3);
                if (z2 != null) {
                }
                nextSequenceNumber = this.nextSequenceNumber;
                this.nextSequenceNumber = i6 += nextSequenceNumber;
                entry$okhttp.setSequenceNumber$okhttp(nextSequenceNumber);
                obj9.flush();
                if (Long.compare(obj9, cleanupQueue) <= 0) {
                } else {
                }
                if (journalRebuildRequired()) {
                }
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, i3, 2);
                obj10 = new IllegalStateException("Check failed.".toString());
                throw obj10;
                throw editor;
            }
        }
    }

    @Override // java.io.Closeable
    public final void delete() {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    @Override // java.io.Closeable
    public final okhttp3.internal.cache.DiskLruCache.Editor edit(String string) {
        return DiskLruCache.edit$default(this, string, 0, obj3, 2);
    }

    @Override // java.io.Closeable
    public final okhttp3.internal.cache.DiskLruCache.Editor edit(String string, long l2) {
        Object entry;
        long sequenceNumber$okhttp;
        long obj11;
        n.f(string, "key");
        initialize();
        checkNotClosed();
        validateKey(string);
        entry = this.lruEntries.get(string);
        final int i3 = 0;
        synchronized (this) {
            try {
                if ((DiskLruCache.Entry)entry != null) {
                }
                if (Long.compare(sequenceNumber$okhttp, l2) != 0) {
                }
                return i3;
                if (entry != null) {
                } else {
                }
                obj11 = entry.getCurrentEditor$okhttp();
                obj11 = i3;
                if (obj11 != null) {
                }
                return i3;
                if (entry != null && entry.getLockingSourceCount$okhttp() != 0) {
                }
                if (entry.getLockingSourceCount$okhttp() != 0) {
                }
                return i3;
                if (!this.mostRecentTrimFailed) {
                }
                if (this.mostRecentRebuildFailed) {
                } else {
                }
                obj11 = this.journalWriter;
                n.d(obj11);
                obj11.E0(DiskLruCache.DIRTY).c0(32).E0(string).c0(10);
                obj11.flush();
                if (this.hasJournalErrors) {
                }
                return i3;
                if (entry == null) {
                }
                entry = new DiskLruCache.Entry(this, string);
                this.lruEntries.put(string, entry);
                DiskLruCache.Editor obj10 = new DiskLruCache.Editor(this, entry);
                entry.setCurrentEditor$okhttp(obj10);
                return obj10;
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, obj6, 2);
                return i3;
                throw string;
            }
        }
    }

    @Override // java.io.Closeable
    public final void evictAll() {
        int i;
        Object obj;
        String str;
        initialize();
        Collection values = this.lruEntries.values();
        n.e(values, "lruEntries.values");
        int i2 = 0;
        Object[] array = values.toArray(new DiskLruCache.Entry[i2]);
        synchronized (this) {
            try {
                i = i2;
                while (i < array.length) {
                    obj = (DiskLruCache.Entry[])array[i];
                    n.e(obj, "entry");
                    removeEntry$okhttp(obj);
                    i++;
                }
                obj = array[i];
                n.e(obj, "entry");
                removeEntry$okhttp(obj);
                i++;
                this.mostRecentTrimFailed = i2;
                NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                throw nullPointerException;
                throw th;
            }
        }
    }

    @Override // java.io.Closeable
    public void flush() {
        synchronized (this) {
            try {
                checkNotClosed();
                trimToSize();
                g journalWriter = this.journalWriter;
                n.d(journalWriter);
                journalWriter.flush();
            }
        }
    }

    @Override // java.io.Closeable
    public final okhttp3.internal.cache.DiskLruCache.Snapshot get(String string) {
        int cleanupQueue;
        int cleanupTask;
        int i;
        int i3;
        int i2;
        n.f(string, "key");
        initialize();
        checkNotClosed();
        validateKey(string);
        Object obj = this.lruEntries.get(string);
        int i4 = 0;
        synchronized (this) {
            try {
                n.e((DiskLruCache.Entry)obj, "lruEntries[key] ?: return null");
                okhttp3.internal.cache.DiskLruCache.Snapshot snapshot$okhttp = obj.snapshot$okhttp();
                if (snapshot$okhttp != null) {
                }
                this.redundantOpCount = redundantOpCount++;
                g journalWriter = this.journalWriter;
                n.d(journalWriter);
                journalWriter.E0(DiskLruCache.READ).c0(32).E0(string).c0(10);
                if (journalRebuildRequired()) {
                }
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, obj4, 2);
                return snapshot$okhttp;
                return i4;
                return i4;
                throw string;
            }
        }
    }

    @Override // java.io.Closeable
    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    @Override // java.io.Closeable
    public final File getDirectory() {
        return this.directory;
    }

    @Override // java.io.Closeable
    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, okhttp3.internal.cache.DiskLruCache.Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    @Override // java.io.Closeable
    public final long getMaxSize() {
        return this.maxSize;
        synchronized (this) {
            return this.maxSize;
        }
    }

    @Override // java.io.Closeable
    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    @Override // java.io.Closeable
    public final void initialize() {
        boolean assertionsEnabled;
        boolean fileSystem;
        boolean exists;
        File journalFileBackup;
        File journalFile;
        StringBuilder string;
        String str;
        synchronized (this) {
            try {
                if (!Thread.holdsLock(this)) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                Thread currentThread = Thread.currentThread();
                n.e(currentThread, "Thread.currentThread()");
                stringBuilder.append(currentThread.getName());
                stringBuilder.append(" MUST hold lock on ");
                stringBuilder.append(this);
                AssertionError assertionError = new AssertionError(stringBuilder.toString());
                throw assertionError;
                if (this.initialized) {
                }
                if (this.fileSystem.exists(this.journalFileBackup) != null) {
                }
                if (this.fileSystem.exists(this.journalFile) != null) {
                } else {
                }
                this.fileSystem.delete(this.journalFileBackup);
                this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
                int i = 1;
                if (this.fileSystem.exists(this.journalFile) != null) {
                }
                readJournal();
                processJournal();
                this.initialized = i;
                journalFile = Platform.Companion;
                journalFile = journalFile.get();
                string = new StringBuilder();
                str = "DiskLruCache ";
                string.append(str);
                str = this.directory;
                string.append(str);
                str = " is corrupt: ";
                string.append(str);
                str = th.getMessage();
                string.append(str);
                str = ", removing";
                string.append(str);
                string = string.toString();
                str = 5;
                journalFile.log(string, str, th);
                Throwable th = null;
                delete();
                this.closed = th;
                this.closed = th;
                throw th2;
                rebuildJournal$okhttp();
                this.initialized = i;
                throw th;
            } catch (java.io.IOException ioException) {
            } catch (Throwable th1) {
            }
        }
    }

    @Override // java.io.Closeable
    public final boolean isClosed() {
        return this.closed;
        synchronized (this) {
            return this.closed;
        }
    }

    @Override // java.io.Closeable
    public final void rebuildJournal$okhttp() {
        boolean fileSystem;
        File journalFile;
        Object journalFileBackup;
        long key$okhttp;
        Object key$okhttp2;
        int i;
        g journalWriter = this.journalWriter;
        synchronized (this) {
            try {
                journalWriter.close();
                g gVar = q.c(this.fileSystem.sink(this.journalFileTmp));
                final int i4 = 10;
                gVar.E0(DiskLruCache.MAGIC).c0(i4);
                gVar.E0(DiskLruCache.VERSION_1).c0(i4);
                gVar.Y1((long)appVersion).c0(i4);
                gVar.Y1((long)valueCount).c0(i4);
                gVar.c0(i4);
                Iterator iterator = this.lruEntries.values().iterator();
                while (iterator.hasNext()) {
                    key$okhttp = iterator.next();
                    i = 32;
                    if ((DiskLruCache.Entry)key$okhttp.getCurrentEditor$okhttp() != null) {
                    } else {
                    }
                    gVar.E0(DiskLruCache.CLEAN).c0(i);
                    gVar.E0(key$okhttp.getKey$okhttp());
                    key$okhttp.writeLengths$okhttp(gVar);
                    gVar.c0(i4);
                    gVar.E0(DiskLruCache.DIRTY).c0(i);
                    gVar.E0(key$okhttp.getKey$okhttp());
                    gVar.c0(i4);
                }
                key$okhttp = iterator.next();
                i = 32;
                if ((DiskLruCache.Entry)key$okhttp.getCurrentEditor$okhttp() != null) {
                } else {
                }
                gVar.E0(DiskLruCache.DIRTY).c0(i);
                gVar.E0(key$okhttp.getKey$okhttp());
                gVar.c0(i4);
                gVar.E0(DiskLruCache.CLEAN).c0(i);
                gVar.E0(key$okhttp.getKey$okhttp());
                key$okhttp.writeLengths$okhttp(gVar);
                gVar.c0(i4);
                journalFileBackup = w.a;
                b.a(gVar, 0);
                if (this.fileSystem.exists(this.journalFile) != null) {
                }
                this.fileSystem.rename(this.journalFile, this.journalFileBackup);
                this.fileSystem.rename(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
                this.journalWriter = newJournalWriter();
                int i2 = 0;
                this.hasJournalErrors = i2;
                this.mostRecentRebuildFailed = i2;
                throw th;
                b.a(closeable, th);
                throw th2;
                throw closeable;
            } catch (Throwable th) {
            }
        }
    }

    @Override // java.io.Closeable
    public final boolean remove(String string) {
        String str;
        long maxSize;
        n.f(string, "key");
        initialize();
        checkNotClosed();
        validateKey(string);
        Object obj6 = this.lruEntries.get(string);
        int i = 0;
        synchronized (this) {
            try {
                n.e((DiskLruCache.Entry)obj6, "lruEntries[key] ?: return false");
                obj6 = removeEntry$okhttp(obj6);
                if (obj6 != null) {
                }
                if (Long.compare(size, maxSize) <= 0) {
                }
                this.mostRecentTrimFailed = i;
                return obj6;
                return i;
                throw string;
            }
        }
    }

    @Override // java.io.Closeable
    public final boolean removeEntry$okhttp(okhttp3.internal.cache.DiskLruCache.Entry diskLruCache$Entry) {
        int lockingSourceCount$okhttp;
        int lockingSourceCount$okhttp2;
        int i2;
        int key$okhttp2;
        String key$okhttp;
        int cleanupQueue;
        long[] cleanupTask;
        int i3;
        long lengths$okhttp;
        long l;
        int i;
        n.f(entry, "entry");
        final int i5 = 10;
        key$okhttp2 = 32;
        final int i6 = 1;
        lockingSourceCount$okhttp = this.journalWriter;
        if (this.civilizedFileSystem == null && entry.getLockingSourceCount$okhttp() > 0 && lockingSourceCount$okhttp != null) {
            if (entry.getLockingSourceCount$okhttp() > 0) {
                lockingSourceCount$okhttp = this.journalWriter;
                if (lockingSourceCount$okhttp != null) {
                    lockingSourceCount$okhttp.E0(DiskLruCache.DIRTY);
                    lockingSourceCount$okhttp.c0(key$okhttp2);
                    lockingSourceCount$okhttp.E0(entry.getKey$okhttp());
                    lockingSourceCount$okhttp.c0(i5);
                    lockingSourceCount$okhttp.flush();
                }
            }
            if (entry.getLockingSourceCount$okhttp() <= 0 && entry.getCurrentEditor$okhttp() != null) {
                if (entry.getCurrentEditor$okhttp() != null) {
                }
            }
            entry.setZombie$okhttp(i6);
            return i6;
        }
        okhttp3.internal.cache.DiskLruCache.Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        i2 = 0;
        while (i2 < this.valueCount) {
            this.fileSystem.delete((File)entry.getCleanFiles$okhttp().get(i2));
            this.size = size -= l;
            entry.getLengths$okhttp()[i2] = 0;
            i2++;
        }
        this.redundantOpCount = redundantOpCount += i6;
        g journalWriter = this.journalWriter;
        if (journalWriter != null) {
            journalWriter.E0(DiskLruCache.REMOVE);
            journalWriter.c0(key$okhttp2);
            journalWriter.E0(entry.getKey$okhttp());
            journalWriter.c0(i5);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, lengths$okhttp, 2);
        }
        return i6;
    }

    @Override // java.io.Closeable
    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    @Override // java.io.Closeable
    public final void setMaxSize(long l) {
        TaskQueue cleanupQueue;
        okhttp3.internal.cache.DiskLruCache.cleanupTask.1 cleanupTask;
        int i;
        int i2;
        int i3;
        this.maxSize = l;
        synchronized (this) {
            try {
                TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, obj3, 2);
                throw l;
            }
        }
    }

    @Override // java.io.Closeable
    public final long size() {
        initialize();
        return this.size;
        synchronized (this) {
            initialize();
            return this.size;
        }
    }

    public final Iterator<okhttp3.internal.cache.DiskLruCache.Snapshot> snapshots() {
        initialize();
        DiskLruCache.snapshots.1 anon = new DiskLruCache.snapshots.1(this);
        return anon;
        synchronized (this) {
            initialize();
            anon = new DiskLruCache.snapshots.1(this);
            return anon;
        }
    }

    @Override // java.io.Closeable
    public final void trimToSize() {
        while (Long.compare(size, maxSize) > 0) {
        }
        this.mostRecentTrimFailed = false;
    }
}
