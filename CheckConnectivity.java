package in.findlogics.testapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class CheckConnectivity extends BroadcastReceiver implements LogOutTimerUtil.LogOutListener{
    Context c;

@Override
public void onReceive(Context context, Intent arg1) {
    c = context;

    boolean isConnected = arg1.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
    if(isConnected){
        Toast.makeText(context, "Internet Connection Lost", Toast.LENGTH_LONG).show();
        LogOutTimerUtil.startLogoutTimer(context, this);
    }
    else{
        Toast.makeText(context, "Internet Connected", Toast.LENGTH_LONG).show();
        LogOutTimerUtil.stopLogoutTimer();
    }
   }

    @Override
    public void doLogout() {
        Toast.makeText(c, "Logged Out", Toast.LENGTH_SHORT).show();
    }
}