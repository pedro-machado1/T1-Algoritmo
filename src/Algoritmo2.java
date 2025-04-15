import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Algoritmo2 {
    public static void main(String[] args) {
        String directoryPath = "C:/Users/pedro/Documents/T1-Algoritmo/casosfinal9 (2)";

        try{
            BufferedReader reader = new BufferedReader(new FileReader(directoryPath + "/caso89.txt"));
            int numLength = Integer.parseInt(reader.readLine());

            String[] stringDanca = reader.readLine().split(" ");
            int[] arrayDanca = new int [numLength];
            for (int i = 0; i < numLength; i++){
                arrayDanca[i] = Integer.parseInt(stringDanca[i]);
            }

            reader.close();
            System.out.println(numeroDePassos(arrayDanca));

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static long numeroDePassos(int[] arrayDanca) {

        ArrayList<Integer> listaFinal = new ArrayList<>();

        // Se quiser aumentar eficiencia quando elemento for visto num ciclo colocar na posicao em que ele esta o proprio indice.
        // primeiro passo;
        for (int i = 0; i < arrayDanca.length; i++) {
            int cout = 1;
            int index = arrayDanca[i];
            int aux = index;
            index = arrayDanca[index];
            //  index torna-se o elemento
            while (true) {
                if (index == arrayDanca[i]) {
                    listaFinal.add(cout);
                    break;
                } else {
                    arrayDanca[aux] = aux;
                    aux = index;
                    index = arrayDanca[index];
                    cout++;
                }
            }

        }
        if (listaFinal.size() == 1) {
            return listaFinal.get(0);
        }
        return mmc(listaFinal);
    }


    public  static long mdc(long a, long b){
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static long mmc(ArrayList<Integer> numberList){
        long mmcResultado = numberList.get(0);
        for(int i = 0; i < numberList.size(); i++){
            mmcResultado = mmcResultado * (numberList.get(i) / mdc(mmcResultado, numberList.get(i)));
        }
        return mmcResultado;
    }

}
