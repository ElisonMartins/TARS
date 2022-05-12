
import dev.robocode.tankroyale.botapi.Bot
import dev.robocode.tankroyale.botapi.BotInfo
import dev.robocode.tankroyale.botapi.Color
import dev.robocode.tankroyale.botapi.events.ScannedBotEvent

class Test: Bot(BotInfo.fromFile("res/test.json")) {

    override fun run() {
        tracksColor = Color.BLACK
        bulletColor = Color.BLACK
        scanColor = Color.BLACK

        while (isRunning){
            forward(100.0)
            turnGunRight(360.0)
            back(100.0)
            turnGunRight(100.0)
        }
    }

    override fun onScannedBot(scannedBotEvent: ScannedBotEvent?) {
        fire(3.0)
    }

}

fun main (){
    Test().start()
}