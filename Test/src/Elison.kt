import dev.robocode.tankroyale.botapi.Bot
import dev.robocode.tankroyale.botapi.BotInfo
import dev.robocode.tankroyale.botapi.Color
import dev.robocode.tankroyale.botapi.events.*


class Test: Bot(BotInfo.fromFile("res/Elison.json")) {

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


  override fun onScannedBot(a: ScannedBotEvent) {
    var distance = distanceTo(a.x,a.y)
    if ((distance > 200.0) or (this.energy < 30.0)){
        bulletColor = Color.BLUE
        fire(1.0)
    } else {
        bulletColor = Color.RED
        fire(3.0)
    }
}

    override fun onHitByBullet(bulletHitBotEvent: BulletHitBotEvent?) {
        //turnRight(90.0)
        forward(50.0)
    }

    override fun onBotDeath(botDeathEvent: DeathEvent?) {
        super.onBotDeath(botDeathEvent)
        turnRight(50.0)
    }

    override fun onBulletHitWall(bulletHitWallEvent: BulletHitWallEvent?) {
        super.onBulletHitWall(bulletHitWallEvent)
        back(100.0)


    }

    override fun onHitWall(event: HitWallEvent?) {
        super.onHitWall(event)

        turnRight(180.0)
        //voltar quando bater na parede
    }
}

fun main (){
    Test().start()
}
