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
 
//    override fun onScannedRobot(event: ScannedRobotEvent?) { 
//        if (event != null) { 
//            fire(300 / event.distance) 
//        } else { 
//            fire(1.5) 
//        } 
//    }

    override fun onScannedBot(scannedBotEvent: ScannedBotEvent?) {
//override fun onScannedBot(a: ScannedBotEvent) {
//    var distance = distanceTo(a.x,a.y)
//    if ((distance > 250.0) or (this.energy < 30.0)){
//        bulletColor = Color.RED
//          fire(1.0)
//    } else {       
//        bulletColor = Color.BLUE
//        fire(2.0)
//    }
//}
        val distancia : Double = distanceTo(x, y)
        if (distancia < 3)  {
            bulletColor = Color.RED
            fire(3.0)
        }else {
            bulletColor = Color.BLUE
            fire(1.0)
        }
    }

    override fun onHitByBullet(bulletHitBotEvent: BulletHitBotEvent?) {
        turnRight(90.0)
        forward(150.0)
    }

    override fun onRobotDeath(event: RobotDeathEvent?) { 
        super.onRobotDeath(event) 
         turnGunRight(90.0)
          //Quando outro robô morrer
    } 

    override fun onBulletMissed(event: BulletMissedEvent?) {
         super.onBulletMissed(event) 
          turnGunLeft(90.0)
        //bala perdida
  
    }

    override fun onHitWall(event: HitWallEvent?) { 
         //super.onHitWall(event) 
         //mPositionTracker.onHitWall(event)
         turnBack(30.0)
         //voltar quando bater na parede
     }
}

fun main (){
    Test().start()
}

