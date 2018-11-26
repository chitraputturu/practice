package in.findlogics.testapplication;

import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import static android.app.AppOpsManager.MODE_ALLOWED;
import static android.app.AppOpsManager.OPSTR_GET_USAGE_STATS;

public class MainActivity extends AppCompatActivity {
    long RESUME_TIME = 0L, PAUSE_TIME = 0L;
    SharedPreferences sharedPreferences = null;
    SharedPreferences.Editor editor = null;
    String TAG = "MainActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        RESUME_TIME = System.currentTimeMillis();
        editor.remove("resume_time");
        editor.putLong("resume_time", RESUME_TIME);
        editor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();

        PAUSE_TIME = System.currentTimeMillis();
        editor.remove("foreground_time");
        editor.putInt("foreground_time", sharedPreferences.getInt("foreground_time", 0) + getActiveTime(PAUSE_TIME, sharedPreferences.getLong("resume_time", 0L)));
        editor.commit();
    }

    public int getActiveTime(Long time1, Long time2) {
        return (int) (((time1 - time2) / (1000 * 60)) % 60);
    }

}
