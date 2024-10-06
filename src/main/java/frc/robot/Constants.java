package frc.robot;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.SoftwareLimitSwitchConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.MotionMagicExpoVoltage;
import com.ctre.phoenix6.signals.GravityTypeValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.geometry.Rotation2d;

public class Constants {


    public static final class ArmConstants {
        public static final int armLeaderID = 14;
        public static final int armFollowerID = 21;
        public static final String armTalonCANBus = "CAN0";
        public static final double armGearRatio = 25.64; // Sensor to Mechanism Ratio

        public static final double ArmIntakeAngle = 10;

        public static final double armMinClamp = 0;
        public static final double armMaxClamp = 114.873047;

        public static final Rotation2d armMinAngle = Rotation2d.fromDegrees(armMinClamp);
        public static final Rotation2d armMaxAngle = Rotation2d.fromDegrees(armMaxClamp);

        public static final TalonFXConfiguration kArmConfiguration = new TalonFXConfiguration()
      .withCurrentLimits(new CurrentLimitsConfigs()
        .withStatorCurrentLimit(60)
        .withSupplyCurrentLimit(60)
        .withStatorCurrentLimitEnable(true)
        .withSupplyCurrentLimitEnable(true))
      .withMotorOutput(new MotorOutputConfigs()
        .withNeutralMode(NeutralModeValue.Brake)
        .withInverted(InvertedValue.CounterClockwise_Positive))
      .withMotionMagic(new MotionMagicConfigs()
        .withMotionMagicCruiseVelocity(0)
        .withMotionMagicAcceleration(0)
        .withMotionMagicJerk(0))
      .withSlot0(new Slot0Configs()
        .withKV(0)
        .withKA(0)
        .withKP(3000) //1000
        .withKI(0)
        .withKD(1)
        .withGravityType(GravityTypeValue.Arm_Cosine)
        .withKG(6)
        .withKS(0))
      .withFeedback(new FeedbackConfigs()
      .withSensorToMechanismRatio(armGearRatio))
      .withSoftwareLimitSwitch(new SoftwareLimitSwitchConfigs()
        .withForwardSoftLimitEnable(true)
        .withReverseSoftLimitEnable(true)
        .withForwardSoftLimitThreshold(armMaxAngle.getRotations())
        .withReverseSoftLimitThreshold(armMinAngle.getRotations()));

        public static final MotionMagicExpoVoltage armPositionControl = new MotionMagicExpoVoltage(0, false, 0, 0, true, false, false);
        public static final Follower followerControl = new Follower(armLeaderID, true);
        public static final Rotation2d angleErrorTolerance = Rotation2d.fromDegrees(2.5); // Degrees
    }
}
