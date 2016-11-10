package com.example.dominio;

import java.util.Date;
import java.sql.Timestamp;

import javax.persistence.*;

@Entity
public class Timeline {
	@Id
	@SequenceGenerator(name = "TIMELINE_ID_GENERATOR", sequenceName = "TIMELINE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TIMELINE_ID_GENERATOR")
	private Integer ID_timeline;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name="USUARIOID", referencedColumnName="ID_usuario")
    private Usuario usuario;
    
    @ManyToOne
    @PrimaryKeyJoinColumn(name="CANCIONID", referencedColumnName="ID_cancion")
    private Cancion cancion; 
    
    @Column(name = "fecha_reproduccion")
    private Timestamp date;
}
