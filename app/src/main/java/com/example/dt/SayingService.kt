package com.example.dt

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlin.random.Random

class SayingService : Service() {
    private lateinit var notificationManager: NotificationManager
    private val channelId = "MyNotificationServiceChannel"
    private val sayingList: List<String> = listOf("가는 말이 고와야 오는 말이 곱다.",
        "꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.",
        "가장 훌륭한 기술은 그 어떤 도구보다도 인간적인 소양이다.",
        "사람은 살면서 자신을 버리는 것보다 좋은 길을 선택하는 힘을 가져야 한다.",
        "일찍 일어나는 새가 튼다.",
        "노력 없이는 얻는 것도 없다.",
        "남을 비웃지 말라. 자신이 그들보다 나은 것이라고 생각하면 되지.",
        "목표 없이 살아간다는 것은 바다를 건너지 않고 섬에 갇혀있는 것과 같다.",
        "성공의 비결은 단순하다. 당신이 할 수 있다고 믿는 것이다.",
        "행동은 결과를 낳는다.",
        "피할 수 없으면 즐겨라.",
        "배우지 않으면 늘 그대로다.",
        "실패는 잊어버리고, 성공은 기억하라.",
        "어려운 시기에 처한 사람은 강해진다.",
        "과거로 돌아갈 수는 없으니, 미래를 위해 현재에 최선을 다하자.",
        "인내는 무엇보다 강력한 힘이다.",
        "인생은 10%는 무슨 일이 일어나는 것이고, 90%는 그에 대해 어떻게 대처하는가에 달려있다.",
        "오늘을 사는 사람은 내일을 장식한다.",
        "자신의 가치를 낮추지 말라. 세상은 당신의 가치를 평가할 때까지 기다릴 수 없다.",
        "불가능은 그저 시작점에 불과하다.",
        "사람이 그저 사는 것은 살아있는 동안 무엇인가를 이루지 않는 것과 같다.",
        "나 자신을 믿어라. 그러면 세상도 당신을 믿게 될 것이다.",
        "지금 당장 시작할 수 없다고 생각하는 것이 있다면, 당신은 결코 시작하지 못할 것이다.",
        "성공은 목표에 도달하는 것이 아니라, 목표를 향해 달리는 과정에서 찾아진다.",
        "언제나 노력하라. 당신이 결국 도달하는 것은 노력한 만큼이다.",
        "오늘 할 수 있는 최선의 일은 내일로 미뤄서는 안 된다.",
        "훌륭한 인생을 살기 위한 첫 번째 조건은 스스로 믿는 것이다.",
        "삶은 실패로 가득하다. 그럼에도 불구하고 일어나서라.",
        "무엇인가를 이루기 위해서는 먼저 시작해야 한다.",
        "성공은 준비된 사람의 편이다.",
        "희망은 사라지지 않는다. 우리가 사라지는 것이다.",
        "어제의 최선을 오늘보다 더 잘할 수 있는 방법을 찾으라.",
        "어떤 시련이 닥치더라도 포기하지 말고, 그것을 기회로 삼아라.",
        "실패는 성공의 어머니이다.",
        "성공한 사람을 볼 때, 당신은 그들의 고난과 열정을 알지 못한다.",
        "미래를 예측하는 가장 좋은 방법은 그것을 창조하는 것이다.",
        "기회는 자기 손으로 만들어야 한다.",
        "어려운 시기에야 비로소 용기와 힘을 발휘할 수 있다.",
        "목표를 향해 달려가는 동안 눈을 감아서는 안 된다.",
        "용기는 공포를 느끼고도 행동하는 것이다.",
        "자신에게 열심히 일하라. 그러면 당신을 누구도 막을 수 없다.",
        "모든 일은 처음이다. 시작하자.",
        "성공은 어제보다 더 나은 당신이 되는 것이다.",
        "그대의 삶이 그렇게 쉽지는 않을 것이다. 그러니 당당하게 맞서라.",
        "현재의 나 자신을 믿고, 미래의 나 자신을 위해 행동하라.",
        "작은 것을 지나치지 말라. 큰 것을 이루기 위한 준비일 수도 있다.",
        "어려움을 만나면 그것은 성장의 기회일 뿐이다.",
        "성공은 하루 아침에 찾아오지 않는다. 계속해서 노력하고 찾아가야 한다.",
        "자신을 돌아보는 시간은 자기 발전을 위한 가장 중요한 시간이다.",
        "오늘 당신이 넘어지지 않는다면, 내일은 더 강해진 당신이 될 것이다."
    )

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
        showNotification()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "My Notification Channel"
            val descriptionText = "This is my own notification channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            channel.setSound(null, null)
            notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showNotification() {
        val randomSaying = sayingList[Random.nextInt(sayingList.size)]
        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_launcher_foreground) // Replace with your own icon
            .setContentTitle("My notification")
            .setContentText(randomSaying)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            notificationManager.notify(1, builder.build())
        }
    }
}
