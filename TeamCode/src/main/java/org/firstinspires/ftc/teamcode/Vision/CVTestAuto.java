package org.firstinspires.ftc.teamcode.Vision;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Config
@Autonomous(name = "CVTestAuto", group = "Out of this World")
public class CVTestAuto extends LinearOpMode {

    public static double rows = 0.71;
    public static double rect1Cols = 0.515;
    public static double rect2Cols = 0.5625;

    @Override
    public void runOpMode() throws InterruptedException {

        //RingDetector ringDetector = new RingDetector(this);

        //ringDetector.getDecision();

        RingDetectorV3 ringDetectorV3 = new RingDetectorV3(hardwareMap, telemetry,rows, rect1Cols, rect2Cols);
        ringDetectorV3.init();
        FtcDashboard.getInstance().startCameraStream(ringDetectorV3.webcam, 20);

        while (!isStarted() && !isStopRequested()) {
            telemetry.addData("State:", ringDetectorV3.getRingPosition());
            telemetry.addData("lowcolor", ringDetectorV3.getVal());
            telemetry.addData("upcolor", ringDetectorV3.getVal2());
            telemetry.update();
        }

        /*UGCobaltPipeline ugCobaltPipeline = new UGCobaltPipeline(hardwareMap);
        FtcDashboard.getInstance().startCameraStream(ugCobaltPipeline.webcam, 0);
        while (!isStarted() && !isStopRequested()) {
            Log.i("timeleftcollect", ugCobaltPipeline.pipeline.getPosition().toString());
            telemetry.addData("State:", ugCobaltPipeline.pipeline.getPosition());
            telemetry.addData("State:", ugCobaltPipeline.pipeline.getAnalysis());
            telemetry.update();
        }*/

        waitForStart();

        if (isStopRequested()) return;
    }
}