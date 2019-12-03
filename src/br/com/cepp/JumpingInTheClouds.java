package br.com.cepp;

public class JumpingInTheClouds {
    public static void main(String[] args) {
        int[] clouds = {0, 0, 1, 0, 0, 1, 0};
//        int[] clouds = {0, 0, 0, 1, 0, 0};
        int jump = 0;
        for(int i = 0; i < clouds.length; ) {
            int nextIndex = Math.min(i+2, clouds.length-1);
            i += clouds[nextIndex] == 1 ? 1 : 2;
            jump++;
            if(clouds.length-1 == i) {
                break;
            }
        }

        System.out.println(jump);
    }
}
