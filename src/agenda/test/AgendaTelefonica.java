package agenda.test;
import agenda.dao.ContactoDAO;
import agenda.entidades.Contacto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
*Agenda telefónica
* @author Brian Martínez
* @version 2.0
*/

public class AgendaTelefonica {
    
    public static void main(String[] args) throws IOException{
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
       
        
        ContactoDAO contactoDao=new ContactoDAO();
       
        boolean system= true;               
        while(system){
            try{
                System.out.println("    ------------------------------------------------------------------------------------------------");
                System.out.println("                                      Agenda Telef\u00f3nica                                        ");
                System.out.println("    ------------------------------------------------------------------------------------------------");
                System.out.println("");

                System.out.println("                    ----------------------------------------------------------");
                System.out.println("                                            MEN\u00da                         ");
                System.out.println("                    ----------------------------------------------------------");

                System.out.println("\n* 1-Ingresar un contacto \n* 2-Mostrar contactos \n* 3-Ver detalles de un contacto");
                System.out.println("* 4-Buscar un contacto\n* 5-Ver Residencia de contacto\n* 6-Editar contacto\n* 7-Salir");
                //ContactoDAO contactoDao=new ContactoDAO();
                
                
                int select;
                String cad= buff.readLine();
                select= Integer.parseInt(cad);
                
                

                switch(select){
                    case 1:  
                System.out.println("    ------------------------------------------------------------------------------------------------");
                System.out.println("                                      CREAR CONTACTO                                                ");
                System.out.println("    ------------------------------------------------------------------------------------------------");
                        System.out.println("  Ingrese un contacto:\n\n");
                        
                        System.out.print("Nombre:: ");
                        String nombre = buff.readLine();
                        
                        Contacto contacto=contactoDao.buscarContactos(nombre);
                        
                        if(contacto==null){
                            contacto=new Contacto(); //Si el contacto no existe, créalo
                            contacto.setNombre(nombre);
                            
                            System.out.print("Tel\u00e9fono:: ");
                            String tel=buff.readLine();
                            contacto.setTelefono(tel);
                            
                            System.out.print("Edad:: ");
                            String age=buff.readLine();
                            contacto.setEdad(age);
                            
                            System.out.print("Direcci\u00f3n:: ");
                            String dir=buff.readLine();
                            contacto.setDireccion(dir);
                            
                            System.out.print("Correo:: ");
                            String correo=buff.readLine();
                            contacto.setCorreo(correo);
                                                                         
                            contactoDao.crearContacto(contacto);
                        }else{
                            System.out.println("Este contacto ya está registrado");
                        }
                        
                break;
                    case 2:
                        System.out.println("     -----------------  ");
                        System.out.println("          CONTACTOS      ");
                        System.out.println("     -----------------  \n");

                        for (Contacto contactox : contactoDao.mostrarContactos()) {
                        System.out.println("Nombre:: "+contactox.getNombre());
                        }

                break;
                    case 3:
                        System.out.println("  ------------------------------------------------------  ");
                        System.out.println("                        DETALLES DE CONTACTO     ");
                        System.out.println("  ------------------------------------------------------  \n");
                        System.out.print("  Digite el nombre del contacto que desea ver::      ");
                        String name = buff.readLine();
                        Contacto contact= contactoDao.buscarContactos(name);
                        
                        if(contact!=null){
                            System.out.println("    ----Resultados de la búsqueda----\n");
                            System.out.println("Nombre  ::  "+contact.getNombre());
                            System.out.println("Tel\u00e9fono::  "+contact.getTelefono());
                            System.out.println("Edad    ::  "+contact.getEdad());
                            System.out.println("Correo  ::  "+contact.getCorreo());
                        }else{
                            System.out.println("    ----Resultados de la búsqueda----\n");
                            System.out.println("Lo siento, no se encontró ninún resultado");
                        }
                       
                break;
                
                    case 4:
                          
                        System.out.println("  ------------------------------------------------------  ");
                        System.out.println("                        Buscar Contacto     ");
                        System.out.println("  ------------------------------------------------------  \n");
                        System.out.print("  Digite el nombre del contacto que desea buscar::      ");
                        
                        String cadena = buff.readLine();
                        Contacto contact1= contactoDao.buscarContactos(cadena);
                        
                        if(contact1!=null){
                            System.out.println("                        --------Resultados de la búsqueda--------\n");
                            System.out.println("Contacto Encontrado::  "+contact1.getNombre());
                        }else{
                            System.out.println("                        --------Resultados de la búsqueda--------\n");
                            System.out.println("Oops!,parece que no se encontró ninún resultado");
                        }

                break;                
                    case 5:
                        System.out.println("  ------------------------------------------------------  ");
                        System.out.println("                      Residencia                          ");
                        System.out.println("  ------------------------------------------------------  \n");
                        
                        System.out.print("Digite el nombre del contacto para saber su residencia:: ");
                        
                        String nombre2=buff.readLine();
                        Contacto contact3= contactoDao.mostrarResidencia(nombre2);
                break;
                    case 6:
                        System.out.println("  ------------------------------------------------------  ");
                        System.out.println("                            EDITAR                        ");
                        System.out.println("  ------------------------------------------------------  \n");
                        
                        System.out.print("Escriba el nombre del contacto a editar:: ");
   
                        String nombre3=buff.readLine();
                        Contacto contact4= contactoDao.editarContacto(nombre3);
                        //Aquí tuve problemos debido a que 
                        
                        
                break;
                    case 7:
                        
                    system=false;

                break;
                }
            }catch (NumberFormatException error){
                System.out.println("ERROR, para elegir una opción debe introducir un valor numérico\n"+error.toString());
            }
        }
    }
}
