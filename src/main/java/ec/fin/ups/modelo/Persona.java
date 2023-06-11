package ec.fin.ups.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="persona")
public class Persona {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private int id;
	private String nombre;
	private String correo;
	private String cedula;
	private String direccion;
	private String telefono;
	
	public Persona(int id,String nombre, String correo, String cedula, String direccion, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.cedula = cedula;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public Persona() {
		
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	

}
