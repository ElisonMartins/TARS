import dev.robocode.tankroyale.botapi.Bot
import dev.robocode.tankroyale.botapi.BotInfo
import dev.robocode.tankroyale.botapi.Color
import dev.robocode.tankroyale.botapi.events.*

class Test: Bot(BotInfo.fromFile("res/test.json")) {

    override fun run() {
        tracksColor = Color.BLACK
        bulletColor = Color.BLUE
        scanColor = Color.BLACK
        bodyColor = Color(0, 0, 0)

        while (isRunning){
            forward(200.0)
            turnGunRight(360.0)
            back(100.0)
            turnGunRight(100.0)
        }
    }

    override fun onScannedBot(scannedBotEvent: ScannedBotEvent?) {
        fire(1.0)
    }

    override fun onHitByBullet(bulletHitBotEvent: BulletHitBotEvent?) {
        turnRight(90.0)
        forward(150.0)
    }
}

fun main (){
    Test().start()
}
