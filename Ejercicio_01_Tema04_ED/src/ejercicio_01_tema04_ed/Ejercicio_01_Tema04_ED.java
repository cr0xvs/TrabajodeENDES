/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_01_tema04_ed;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author francis
 */
public class Ejercicio_01_Tema04_ED 
{
    private static byte[] bufer = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream flujoEntrada = null;
    private static BufferedInputStream entradaBufer = null;

    public static void iniciarArchivo() throws FileNotFoundException
    {
        flujoEntrada = new FileInputStream(nombreArchivo);
        entradaBufer = new BufferedInputStream(flujoEntrada);
    }
    
    public static int mostrarArchivoTexto() throws IOException
    {
        int total = 0;
        int nLeer = 0;
        while((nLeer = flujoEntrada.read(bufer)) != -1) 
        {
            System.out.println(new String(bufer));
            total += nLeer;
        }
        
        return total;
    }
    
    /**
     * @param argumentos the command line arguments
     */
    public static void main(String[] argumentos) 
    {        
        try 
        {
            iniciarArchivo();
            
            int total = mostrarArchivoTexto();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( entradaBufer != null && flujoEntrada != null )
                {
                    flujoEntrada.close();
                    entradaBufer.close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }
    
}
