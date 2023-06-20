package ec.fin.ups.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.Times;
import org.mockito.junit.jupiter.MockitoExtension;

import ec.fin.ups.interfaceServices.IPersonaService;
import ec.fin.ups.modelo.Persona;
import ec.fin.ups.repositories.IPersona;


@ExtendWith(MockitoExtension.class)
public class PersonaTest {
	
	@Mock
	private IPersona personaserviciorepositorio;
	
	@InjectMocks
	private PersonaService personaServicio;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void TestSave() {
		Persona persona=new Persona( 1,"Carlos","carlos.34@yahoo.es","123","0106785423","Batan","9873652416");
		
		when(personaserviciorepositorio.save(persona)).thenReturn(persona);
		
		int persona1=personaServicio.save(persona);
		
		assertEquals(1,persona1 );
		verify(personaserviciorepositorio,times(1)).save(persona);
		
	}
@Test
	public void testFindCedula() {
		Persona persona=new Persona( 1,"Carlos","carlos.34@yahoo.es","123","0106785423","Batan","9873652416");
		
		when(personaserviciorepositorio.findByCedula("0106785423")).thenReturn(persona);
		
		Persona persona1=personaServicio.findByCedula("0106785423");
		
		assertEquals(persona, persona1);
	}
	
	@Test
	public void listarpersonas() {
		
		java.util.List<Persona> listapesona= Arrays.asList(new Persona( 1,"Carlos","carlos.34@yahoo.es","123","0106785423","Batan","9873652416"),
														new Persona( 2,"Cristina","cristina.98@yahoo.es","321","0108985423","San Pedro","9873689416")
				);
		
		when(personaserviciorepositorio.findAll()).thenReturn(listapesona);
		
		List<Persona> listarpersona1= personaServicio.listar();
		
		assertEquals(listapesona, listarpersona1);
	}
	
	
		
	}


