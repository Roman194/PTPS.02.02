import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> pancakeStacks = new ArrayList<>();
        while(true){ //ввод стопок алладий
                String pancakeStack =sc.nextLine();
                if(pancakeStack == "")
                    break;
                pancakeStacks.add(pancakeStack);
        }
        System.out.println(pancakeStacks);

        for(String currentStack: pancakeStacks){//рассмотрим каждую стопку по очереди
            String [] currentPancakesStack = currentStack.split(" ");

            int crossedOutPancakes = 0;
            while(crossedOutPancakes != currentPancakesStack.length){ //пока мы не убедились, что соблюдено конечное условие
                System.out.println(Arrays.toString(currentPancakesStack));
                int maxPancakeDia = 0;
                int maxPancakePlace = 0;
                for(int i = 0; i < currentPancakesStack.length - crossedOutPancakes; i++){ //поиск макс эллемента строки без учёта уже вычеркнутых эллементов
                    int currentPancake = Integer.parseInt(currentPancakesStack[i]);
                    if(maxPancakeDia <= currentPancake){
                        maxPancakeDia = currentPancake;
                        maxPancakePlace = i;
                    }
                }

                if(maxPancakePlace == currentPancakesStack.length - crossedOutPancakes - 1){//если макс - крайний справа
                    //вычеркнуть эллемент из дальнейшего рассмотрения до вывода условия
                    crossedOutPancakes ++;

                } else if (maxPancakePlace == 0) { // если - слева
                    //инверсировать всю стопку
                    for(int i = 0; i < (currentPancakesStack.length - crossedOutPancakes) / 2; i++){
                        String transit = currentPancakesStack[currentPancakesStack.length - i - crossedOutPancakes - 1];
                        currentPancakesStack[currentPancakesStack.length - i - crossedOutPancakes - 1] = currentPancakesStack[i];
                        currentPancakesStack[i] = transit;
                    }
                    int placeForInvertion = crossedOutPancakes + 1;
                    currentStack+=" " + placeForInvertion;

                    crossedOutPancakes++;
                } else {
                    //инверсировать стопку с начала до места макс эллемента
                    for(int i = 0; i <= maxPancakePlace / 2; i++){
                        String transit = currentPancakesStack[maxPancakePlace - i];
                        currentPancakesStack[maxPancakePlace - i] = currentPancakesStack[i];
                        currentPancakesStack[i] = transit;
                    }
                    int placeForInvertion = currentPancakesStack.length - maxPancakePlace;
                    currentStack+=" " + placeForInvertion;
                }

            }
            System.out.println(currentStack + " 0");
        }
    }
}