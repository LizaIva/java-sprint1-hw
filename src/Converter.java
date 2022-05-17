public class Converter {
    private static final double INDEX_KM=0.00075;
    private static final double INDEX_KCAL=0.05;

    public static double convertStepsToKm (int stepsSum) {
        return stepsSum * INDEX_KM;
    }
    public static double convertStepsToKilocalories (int stepsSum) {
        return stepsSum * INDEX_KCAL;
    }




}