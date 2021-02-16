/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Dao;

import Controlador.Conexion;
import Controlador.ListaDoble.ListaDoble;
import Modelo.Rol;

/**
 *
 * @author Milton Riofrio, Sebastian Gomez
 */
public class RolDao extends AdaptadorDao {
    
    private Rol rol;
    /**
     * Se superpone el nuevo Dao con su clase a la conexion que anteriormente tenia la clase AdapatadorDao 
     */
    public RolDao() {
        super(new Conexion(), Rol.class);
    }
    /**
     * @return Rol
     */
    public Rol getRol() {
        if (rol == null) {
            rol = new Rol();
        }
        return rol;
    }
    /**
     * Metodo para guardar la informacion del atributo rol al .json
     * @return Boolean
     */
    public Boolean guardar() {
        try {
            this.getRol().setId_rol(Long.parseLong(String.valueOf(listar().tamano() + 1)));
            this.guardar(this.getRol());
            return true;
        } catch (Exception e) {
            System.out.println("Error en guardar rol " + e);
            return false;
        }
    }
    /**
     * @param rol
     */
    public void setRol(Rol rol) {
        this.rol = rol;
    }
    /**
     * 
     * @param dato
     * @param tipo_ordenacion
     * @param atributo
     * @return
     */
    public ListaDoble ordenar(ListaDoble dato, int tipo_ordenacion, String atributo) {
        dato.ordenar(tipo_ordenacion, atributo);
        return dato;
    }
    
    /**
     * Metodo para definir los roles que van a usarse en el programa
     * Tambien sirve para crear las cuentas de usuaio de los empleados Secretario y Administrador
     */
    public void crearRoles() {
        EmpleadoDao edao = new EmpleadoDao();
        if (listar().tamano() == 0) {
            Rol admin = new Rol();
            admin.setRol("Administrador");
            setRol(admin);
            guardar();
            setRol(null);
            Rol secret = new Rol();
            secret.setRol("Secretario");
            setRol(secret);
            guardar();
            setRol(null);
            Rol cliente = new Rol();
            cliente.setRol("Cliente");
            setRol(cliente);
            guardar();
            setRol(null);
            if (edao.listar().tamano() == 0) {
                ListaDoble listado = listar().ordenar(ListaDoble.ORDENAR_ASCENDENTE, "rol");
                Object objeto = listado.busquedaBinaria("Administrador", "rol");
                long id_rol = (objeto != null) ? ((Rol)objeto).getId_rol() : -1;
                System.out.println("Se encontro " + objeto);
                
                edao.getEmpleado().setNombre("Administrador");
                edao.getEmpleado().setCi_ruc("1150069324");
                edao.getEmpleado().setDireccion("Belen Bolonia");
                edao.getEmpleado().setTelefono("0985583523");
                edao.getEmpleado().setCiudad("Loja");
                edao.getEmpleado().setId_rol(id_rol);
                edao.getEmpleado().setAnios_trabajo(2);
                edao.getEmpleado().setLicencia("");
                edao.getEmpleado().setSueldo(1500.00);
                edao.guardar();

                CuentaDao cdao = new CuentaDao();
                cdao.getCuenta().setContrasenia("1234");
                cdao.getCuenta().setId_persona(edao.getEmpleado().getId_persona());
                cdao.getCuenta().setUsuario(edao.getEmpleado().getCi_ruc());
                cdao.guardar();
                edao.setEmpleado(null);
                cdao.setCuenta(null);
                ((Rol)objeto).setId_rol(null);
                
                objeto = listado.busquedaBinaria("Secretario", "rol");
                id_rol = (objeto != null) ? ((Rol)objeto).getId_rol() : -1;
                edao.getEmpleado().setNombre("Secretario");
                edao.getEmpleado().setCi_ruc("1150161097");
                edao.getEmpleado().setDireccion("Ciudad Victoria");
                edao.getEmpleado().setTelefono("0985426423");
                edao.getEmpleado().setCiudad("Loja");
                edao.getEmpleado().setId_rol(id_rol);
                edao.getEmpleado().setAnios_trabajo(1);
                edao.getEmpleado().setLicencia("");
                edao.getEmpleado().setSueldo(400.00);
                edao.guardar();
                
                cdao.getCuenta().setContrasenia("4321");
                cdao.getCuenta().setId_persona(edao.getEmpleado().getId_persona());
                cdao.getCuenta().setUsuario(edao.getEmpleado().getCi_ruc());
                cdao.guardar();
                edao.setEmpleado(null);
                cdao.setCuenta(null);
            }
        }
    }
}
