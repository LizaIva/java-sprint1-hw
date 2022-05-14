public class StepTracker {
    int goalSteps = 10000;
    MonthData[] monthToData;


    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    static class MonthData {
        int[] daySteps;

        public MonthData() {
            daySteps = new int[30];
        }
    }

    public void inputSteps(int numberMonth, int numberDay, int countSteps) {
        MonthData monthData = monthToData[numberMonth];
        monthData.daySteps[numberDay] = countSteps;
    }


    public void statisticsSteps(int numberMonth) {
        MonthData monthData = monthToData[numberMonth];
        int[] monthDaySteps = monthData.daySteps;

        int stepsSum = 0;
        int maxSteps = 0;
        for (int i = 0; i < monthDaySteps.length; i++) {
            int steps = monthDaySteps[i];
            if (i == monthDaySteps.length - 1) {
                System.out.print(i + " день: " + steps + " шагов. ");
            } else {
                System.out.print(i + " день: " + steps + " шагов, ");
            }

            stepsSum = stepsSum + steps;

            if (steps > maxSteps) {
                maxSteps = steps;
            }


        }
        System.out.println();
        System.out.println("Общее количество шагов за месяц: " + stepsSum);
        int stepsMid = stepsSum / 30;
        System.out.println("Среднее количество шагов за месяц: " + stepsMid);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        double distanceSteps = Converter.convertStepsToKm(stepsSum);
        System.out.println("Пройденная дистанция (в км): " + distanceSteps);
        double stepsKilocalories = Converter.convertStepsToKilocalories(stepsSum);
        System.out.println("Количество сожжённых килокалорий: " + stepsKilocalories);


        int bestSeries = 0;
        int bestSeriesTemp = 0;
        for (int i = 0; i < monthDaySteps.length; i++) {
            int steps = monthDaySteps[i];
            if (steps >= goalSteps) {
                bestSeriesTemp++;
            } else {
                if (bestSeriesTemp>bestSeries){
                    bestSeries = bestSeriesTemp;
                }
                bestSeriesTemp = 0;
            }
            if (i == monthDaySteps.length-1){
                if (bestSeriesTemp>bestSeries){
                    bestSeries = bestSeriesTemp;
                }
                bestSeriesTemp = 0;
            }


        }
        System.out.println("Лучшая серия: " + bestSeries);

    }

    public void changeGoalSteps (int newGoal){
        goalSteps = newGoal;
    }



}