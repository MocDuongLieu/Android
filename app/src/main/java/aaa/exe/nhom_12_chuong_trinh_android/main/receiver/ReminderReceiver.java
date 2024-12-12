package aaa.exe.nhom_12_chuong_trinh_android.main.receiver;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import java.util.Date;

import aaa.exe.nhom_12_chuong_trinh_android.R;

public class ReminderReceiver extends BroadcastReceiver {
    final String CHANNEL_ID = "201";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Nhắc nhở uống nước", "Đã nhận thông báo nhắc nhở.");

        // Xử lý hành động khi nhắc nhở được kích hoạt
        if (intent.getAction().equals("MyAction")) {
            int remain = intent.getIntExtra("remain",1000);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(CHANNEL_ID,
                        "Channel 1",
                        NotificationManager.IMPORTANCE_HIGH);
                channel.setDescription("Miêu tả cho kênh 1");
                notificationManager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                    .setContentTitle("Nhắc nhở uống nước")
                    .setContentText("Đến giờ bạn uống nước rồi.\nHôm nay bạn đã có " + remain + " ml số lượng nước còn lại để uống.")
                    .setSmallIcon(R.drawable.ic_notifications)
                    .setColor(Color.BLUE)
                    .setCategory(NotificationCompat.CATEGORY_ALARM)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText("Đến giờ bạn uống nước rồi.\nHôm nay bạn đã có " + remain + " ml số lượng nước còn lại để uống."));

            notificationManager.notify(getNotificationId(), builder.build());
        }
    }

    private int getNotificationId() {
        return (int) new Date().getTime();
    }
}
