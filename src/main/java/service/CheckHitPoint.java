package service;

public final class CheckHitPoint {

    private static boolean isHitToFirstQuarter(double x, double y, double r) {
        return (0 <= x) && (x * x <= r * 0.5 * r * 0.5 - y * y) && (0 <= y);
    }

    private static boolean isHitToSecondQuarter(double x, double y, double r) {
        return (-r <= x) && (x <= 0) && (0 <= y) && (y <= r * 0.5 );
    }

    private static boolean isHitToThirdQuarter(double x, double y, double r) {
        return false;
    }

    private static boolean isHitToFourthQuarter(double x, double y, double r) {
        return (x >= 0) && (y <= 0) && (0.5 * x - r * 0.5 <= y);
    }

    public static boolean checkHit(double x, double y, double r) {
        boolean mem = isHitToFirstQuarter(x, y, r) || isHitToSecondQuarter(x, y, r) || isHitToThirdQuarter(x, y, r) || isHitToFourthQuarter(x, y, r);
        return isHitToFirstQuarter(x, y, r) || isHitToSecondQuarter(x, y, r) || isHitToThirdQuarter(x, y, r) || isHitToFourthQuarter(x, y, r);
    }
}
