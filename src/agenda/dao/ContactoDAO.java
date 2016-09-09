package agenda.dao;
import agenda.entidades.Contacto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ContactoDAO {
    
    protected ArrayList<Contacto> contactos=new ArrayList<>();
    BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
    
    public void crearContacto(Contacto contacto){
        contactos.add(contacto);
    }
    
    public ArrayList<Contacto> mostrarContactos(){
        return contactos;
    }
    
    public Contacto buscarContactos(String contacto){
        for(int i=0; i<contactos.size(); i++){
            if(contacto.equals(contactos.get(i).getNombre())){
                return contactos.get(i);
            }
        }
        return null;
    }
    
    public Contacto mostrarResidencia(String nombre) throws IOException{
                
        Contacto contacto= buscarContactos(nombre);
        if(contacto!=null){
            System.out.println("    ----Resultados de la búsqueda----\n");
            System.out.println("El contacto "+"'"+contacto.getNombre()+"'"+" vive en::  "+contacto.getDireccion());
        }else{
            System.out.println("    ----Resultados de la búsqueda----\n");
            System.out.println("Lo siento, no se encontró ninún resultado");
        }
        return contacto;
    }
    
    
    public Contacto editarContacto(String nombre) throws IOException{
        
        Contacto contact= buscarContactos(nombre);
        
        if(contact==null){ //¿No Existe?
            //return false;
        }else{
        System.out.println("------Modifique el contacto------");
        
        System.out.print("Nombre:: ");
        String nomb=buff.readLine();
        contact.setNombre(nomb);
        
        System.out.print("Tel.:: ");
        String tel=buff.readLine();
        contact.setTelefono(tel);
        
        System.out.print("Edad:: ");
        String edad=buff.readLine();
        contact.setEdad(edad);
        
        System.out.print("Dirección:: ");
        String dir=buff.readLine();
        contact.setDireccion(dir);
        
        System.out.println("Correo:: ");
        String correo=buff.readLine();
        contact.setCorreo(correo);
        }
        
        return contact;
    }
    
}


