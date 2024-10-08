package 面试代码题.小米;


// 暴力解法：<时间超时>
public class minNumberOfHours {
    public static boolean judge(int initialEnergy,int initialExperience,int[] energy,int[] experience){
        int N = energy.length;
        int curEnergy = initialEnergy;
        int curExperience = initialExperience;
        for (int i = 0; i < N; i++) {
            if (curEnergy > energy[i] && curExperience > experience[i]) {
                curEnergy -= energy[i];
                curExperience += experience[i];
            } else {
                return false;
            }
        }
        return true;
    }
    public static boolean improve(int initialEnergy,int initialExperience,int[] energy,int[] experience,int curTime){
        if (curTime == 0){
            return judge(initialEnergy,initialExperience,energy,experience);
        }
        boolean r1= improve(initialEnergy + 1, initialExperience, energy, experience, curTime - 1);
        if (r1 == true) return true;
        boolean r2 = improve(initialEnergy,initialExperience + 1,energy,experience,curTime - 1);
        if (r2 == true) return true;
        return false;
    }
    public static int minNumberOfHours(int initialEnergy,int initialExperience,int[] energy,int[] experience){
        int i = 0;
        while (true){
            boolean res = improve(initialEnergy, initialExperience, energy, experience, i);
            if (res == true){
                return i;
            }else {
                i++;
            }
        }
    }
    public static void main(String[] args) {
        int[] energy = {1,1,1,1};
        int[] experience = {1,1,1,50};

        System.out.println(minNumberOfHours(1,1,energy,experience));
    }
}





























