package server;


public class Operations {
    private int num1,num2;

    public String suma (String num1,String num2){
        int num = Integer.parseInt(num1);
        int nume = Integer.parseInt(num2);
        int suma = num +nume;
        return "La suma de "+num1+" + " + num2 + " es: " +(suma);
    }
    public String resta (String num1, String num2){
        int num = Integer.parseInt(num1);
        int nume = Integer.parseInt(num2);
        int resta = num -nume;
        return "La resta de "+num1+" - "+num2+" es: " +(resta);
    }
    public String multiplicacion (String num1, String num2){
        int num = Integer.parseInt(num1);
        int nume = Integer.parseInt(num2);
        int multi = num *nume;
        return "La multiplicacion de "+num1+" * "+num2+" es: " +(multi);
    }
    public String division (String num1, String num2){
        int num = Integer.parseInt(num1);
        int nume = Integer.parseInt(num2);
        int division = num / nume;
        return "La division de "+num1+" / "+num2+" es: " +(division);
    }
    public String exponente (String num1, String num2){
        double num = Double.parseDouble(num1);
        double nume = Double.parseDouble(num2);
        double exponente = Math.pow(num,nume);
        return "El exponente de "+num1+" elevado a la "+num2+" es: " +(exponente);
    }
    public String raiz (String num1){
        double num = Double.parseDouble(num1);
        double raiz = Math.sqrt(num);
        return "La raiz de " +num + " es: " +(raiz);
    }
}
