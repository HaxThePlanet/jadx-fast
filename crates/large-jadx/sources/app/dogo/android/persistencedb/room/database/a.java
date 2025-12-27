package app.dogo.android.persistencedb.room.database;

import androidx.room.e1.b;
import d.s.a.g;

/* compiled from: UserDatabase_AutoMigration_2_3_Impl.java */
/* loaded from: classes.dex */
class a extends b {
    public a() {
        super(2, 3);
    }

    @Override // androidx.room.e1.b
    public void a(g gVar) {
        gVar.C("CREATE TABLE IF NOT EXISTS `TrainingStreakEntity` (`userId` TEXT NOT NULL, `currentStreak` INTEGER NOT NULL, `longestStreak` INTEGER NOT NULL, `trainingTimesSec` TEXT NOT NULL, `totalTrainingTimeSec` INTEGER NOT NULL, `remoteUpdateTimeMs` INTEGER NOT NULL, PRIMARY KEY(`userId`))");
        gVar.C("CREATE TABLE IF NOT EXISTS `UserStateEntity` (`userId` TEXT NOT NULL, `isWorkoutStreakSyncedToTrainingMetrics` INTEGER NOT NULL, `lastSeenGoalNotReachedState` TEXT, PRIMARY KEY(`userId`))");
    }
}
