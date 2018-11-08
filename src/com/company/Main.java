package com.company;
import java.util.*;

public class Main {

    public static String[] cortar(String texto)
    {
        String[] cortado = texto.split(" ");
        return cortado;
    }

    public static HashMap cortei(String x)
    {
        HashMap<String,Integer> hash = new HashMap<String, Integer>();
        String[] partes = cortar(x);
        //hash.put(partes[0],1);
        for (int i = 0; i < partes.length; i++)
        {
            hash.put(partes[i],1);
            if(hash.containsKey(partes[i]))
            {
                Integer num = hash.get(partes[i])+1;
                hash.put(partes[i],num);
            }
        }

        return hash;
    }
    public static String[] sim(String x)
    {
        HashMap<String,Integer> hash = new HashMap<String, Integer>();
        String[] partes = x.split(" ");
        String[] aux = new String[partes.length];
        hash.put(partes[0],1);
        aux[0] = partes[0];
        for (int i = 1; i < partes.length; i++)
        {
            hash.put(partes[i],1);
            if(hash.containsKey(partes[i-1]))
            {
                Integer num = hash.get(partes[i])+1;
                hash.put(partes[i],num);
                aux[i] = partes[i];
            }
        }
        return aux;
    }

    public static void main(String[] args)
    {
        // ta chegando perto, falta ainda printar direito, todos são dois e ta errado
        HashMap<String,Integer> hash = new HashMap<String, Integer>();
        hash = cortei("Hoje eu acordei feliz e contente Minha vida está super animada e eu tenho grande amigos Amigos Que engraçado essa palavra Amigos O que são amigos Alguem pra dividir momentos felizes ajudar nos momentos dificeis Amigos de verdade seriam a mesma coisa que uma familia Se amigos não são familia então amigos não fazem o que deveriam fazer Amigos Uma palavra mentirosa");
        String [] aux = sim("Hoje eu acordei feliz e contente. Minha vida está super animada e eu tenho grande amigos. Amigos... Que engraçado essa palavra. Amigos. O que são amigos? Alguem pra dividir momentos felizes, ajudar nos momentos dificeis. Amigos de verdade seriam a mesma coisa que uma familia. Se amigos não são familia, então amigos não fazem o que deveriam fazer. Amigos... Uma palavra mentirosa.");
        //String [] nomes = hash.get();
        for (Map.Entry hashEntry : hash.entrySet())
        {
            System.out.println("Chave: '" + hashEntry.getKey() + "' número de repetições: " + hashEntry.getValue());
        }
        /*for(int i = 0; i < hash.size(); i++)
        {
            System.out.println("Com a chave: '" + aux[i] + "' temos o valor: " + hash.get(aux[i]));
            //System.out.println(" - " + aux[x]);
        }
        System.out.println();*/

    }
}
